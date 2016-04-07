package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.manager.RoleImpl;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class DAOMenu {
    private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService"; //Nombre del servicio de MGU.
    private String usu = null;

    public DAOMenu(String usuario) {
        usu = usuario;
    }

    public RecordSet obtenerFavoritosUsuario(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("DAOMenu.obtenerFavoritosUsuario(DTOBelcorp dto):Entrada");
        StringBuffer query = new StringBuffer();

        query.append("SELECT  FUNC_OID_func ");
        query.append("FROM MEN_FAVOR ");
        query.append("WHERE VAL_USUA = '" + usu + "'");

        RecordSet rs = new RecordSet();

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch(MareException me) {
            throw me;
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        rs.addColumn("RutaCompleta");
        int lineas = rs.getRowCount();

        Set oids = new HashSet();

        if (lineas != 0) {
          for(int i = 0; i < lineas; i++) {
            oids.add(rs.getValueAt(i, 0));
      /*            Long oid = new Long(((BigDecimal)rs.getValueAt(i, 0)).longValue());
            rs.setValueAt(this.obtenerRutaCompletaFuncion(oid, dto.getOidIdioma()), i, 1);*/
          }

          Map ruta = this.obtenerRutaCompletaFuncion(oids, dto.getOidIdioma());
          for(int i = 0; i < lineas; i++) {
            rs.setValueAt(ruta.get(rs.getValueAt(i, 0).toString()), i, 1);
          }		
          rs.sortByColumn(1, true);
		    }
        UtilidadesLog.info("DAOMenu.obtenerFavoritosUsuario(DTOBelcorp dto):Salida");
	     	return rs;
    }

    public RecordSet obtenerMenuUsuario(Long idioma) throws MareException {
        UtilidadesLog.info("DAOMenu.obtenerMenuUsuario(Long idioma):Entrada");
        RecordSet rs = this.obtenerMenuCompleto(idioma);

        //Llamamos a getRoles del MGUService y obtenemos un HashMap roles. 
        HashSet roles = null;

        UtilidadesLog.debug("usuario " + usu);

        try {
            MareCredentials credenciales = new MareCredentials(new UserIDSICC(usu), null);
            MGUService mgu = (MGUService)MareMii.getService(new MareTopic(NOMBRE_SERVICIO_MGUSERVICE, credenciales));

            roles = mgu.getRoles();
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        RecordSet resultado = new RecordSet();
        resultado.addColumn("OID_FUNC");
        resultado.addColumn("nom_func");
        resultado.addColumn("VAL_NOMB_PROG");
        resultado.addColumn("hoja");
        resultado.addColumn("padre");
        resultado.addColumn("nivel");

        int lineas = rs.getRowCount();

        for(int i = 0; i < lineas; i++) {
            String oid = rs.getValueAt(i, 0).toString();

            if(roles.contains(new RoleImpl(oid)))
                resultado.addRow(rs.getRow(i));
        }
        UtilidadesLog.info("DAOMenu.obtenerMenuUsuario(Long idioma):Salida");
        return resultado;
    }

    public Map obtenerRutaCompletaFuncion(Set oids, Long idioma)
        throws MareException {
        UtilidadesLog.info("DAOMenu.obtenerRutaCompletaFuncion(Set oids, Long idioma):Entrada");
        RecordSet rs = new RecordSet();

        try {
            StringBuffer query = new StringBuffer();
/*            query.append("   SELECT VAL_I18N ");
            query.append("   FROM ( ");
            query.append("   SELECT OID_func, SYS_CONNECT_BY_PATH (OID_func, '#') AS PATH");
            query.append("     FROM MEN_FUNCI f ");
            query.append("       CONNECT BY PRIOR FUNC_OID_FUNC = OID_FUNC ");
            query.append("       START WITH OID_FUNC = " + oid);
            query.append("   ) f, V_GEN_I18N_SICC g ");
            query.append("   WHERE g.VAL_OID = f.OID_FUNC AND ");
            query.append("         g.ATTR_NUM_ATRI = 1 AND ");
            query.append(" 	g.IDIO_OID_IDIO = " + idioma + " AND ");
            query.append("   g.ATTR_ENTI = 'MEN_FUNCI' ");
            query.append("   order by path desc ");*/

            query.append("   SELECT OID_FUNC, RUTA ");
            query.append("   FROM ( ");
            query.append("   	 SELECT SYS_CONNECT_BY_PATH(VAL_I18N, '~') RUTA, OID_FUNC ");
            query.append("   	 FROM (  ");
            query.append("   	 	  SELECT VAL_I18N, OID_FUNC, FUNC_OID_FUNC, IND_NIVE ");
            query.append("   		  FROM MEN_FUNCI f, V_GEN_I18N_SICC g ");
            query.append("   		  WHERE g.VAL_OID = f.OID_FUNC AND ");
            query.append("   				g.ATTR_NUM_ATRI = 1 AND ");
            query.append("   			    g.IDIO_OID_IDIO = " + idioma + " AND ");
            query.append("   				g.ATTR_ENTI = 'MEN_FUNCI' ");
            query.append("   		  )	 ");
            query.append("   	 WHERE IND_NIVE = 1 ");
            query.append("   	 CONNECT BY PRIOR OID_FUNC = FUNC_OID_FUNC ");
            query.append("   	 START WITH OID_FUNC = 1 ");
            query.append("   	 ) ");
            query.append("   WHERE OID_FUNC IN "); //Dentro del IN ponemos la lista de elementos del parametro oids
            query.append(" (");

			Iterator it = oids.iterator();
			if (it.hasNext()) {
				query.append(it.next());							
			}
			int cant = 1;
      while (it.hasNext()) {
        while (cant < 999 && it.hasNext()) {
          query.append(", " + it.next());				
          cant++;
        }
        if (it.hasNext()) {
          query.append(") OR OID_FUNC IN (");			          
          cant = 1;
          query.append(it.next());							
        }
        
      }

			query.append(") ");			

     query.append("   ORDER BY RUTA ");

      UtilidadesLog.debug(query.toString());

            rs = (RecordSet)BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //StringBuffer salida = new StringBuffer();
		Map salida = new HashMap();
        int lineas = rs.getRowCount();
	    String rutaCompleta = "";
        if(lineas > 0) {
            for(int i = 0; i < lineas; i++) {
				rutaCompleta = rs.getValueAt(i, 1).toString().replace('~',  ConstantesMEN.SEPARADOR_MENU.charAt(0));
				rutaCompleta = rutaCompleta.substring(1, rutaCompleta.length());
                salida.put(rs.getValueAt(i, 0).toString(), rutaCompleta);
            }
        }
        UtilidadesLog.info("DAOMenu.obtenerRutaCompletaFuncion(Set oids, Long idioma):Salida");
        return salida;
    }

    public Long[] obtenerPadresFunciones(Long[] funciones) throws MareException {
        UtilidadesLog.info("DAOMenu.obtenerPadresFunciones(Long[] funciones):Entrada");
        RecordSet rs = new RecordSet();

        try {
            if(funciones.length > 0) {
                StringBuffer query = new StringBuffer();
                query.append(" SELECT distinct oid_func ");
                query.append(" FROM MEN_FUNCI ");
                query.append(" CONNECT BY NOCYCLE PRIOR func_oid_func = oid_func ");
                query.append(" START WITH oid_func IN ");
                query.append(" (");
                query.append(funciones[0]);
                
                
                /*Incidencia BELC300022789 se modifica la logica a fin de armar
                 * clausulas in con 1000 opciones para evitar error sql
                 * GACEVEDO*/
                int cant = 1;
                int largo = funciones.length;
                int i = 1;
                while (i < largo) {
                  while (cant < 999 && i < largo) {
                    query.append( ", "+funciones[i]);
                    cant+=1;  
                    i+=1;
                  }
                  if (i < largo) {
                    query.append(") OR OID_FUNC IN (");			          
                    cant = 1;
                    query.append(funciones[i]);
                    i+=1;
                  }
                }
              query.append(") ");			

                rs = (RecordSet)BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            }
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        Long[] salida = new Long[rs.getRowCount()];

        for(int i = 0; i < rs.getRowCount(); i++)
            salida[i] = new Long(((BigDecimal)rs.getValueAt(i, 0)).longValue());
            
        UtilidadesLog.info("DAOMenu.obtenerPadresFunciones(Long[] funciones):Salida");
        return salida;
    }

    public RecordSet obtenerMenuCompleto(Long idioma) throws MareException {
        UtilidadesLog.info("DAOMenu.obtenerMenuCompleto(Long idioma):Entrada");
        RecordSet rs = new RecordSet();

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT OID_FUNC, nom_func, VAL_NOMB_PROG, IND_NIVE as hoja, FUNC_OID_FUNC AS padre, LEVEL - 1 AS nivel ");
            query.append(" FROM ( ");
            query.append(" SELECT OID_FUNC, VAL_I18N as nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC ");
            query.append(" FROM men_funci, V_GEN_I18N_SICC ");
            query.append(" WHERE ATTR_ENTI = 'MEN_FUNCI' AND ");
            query.append(" ATTR_NUM_ATRI = 1 AND ");
            query.append(" IDIO_OID_IDIO = " + idioma + " AND ");
            query.append(" VAL_OID = OID_FUNC ");
            query.append(" ) ");
            query.append(" CONNECT BY PRIOR OID_FUNC = FUNC_OID_FUNC ");
            query.append(" START WITH OID_FUNC = " + ConstantesMEN.NODO_RAIZ);

            rs = (RecordSet)BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    UtilidadesLog.info("DAOMenu.obtenerMenuCompleto(Long idioma):Salida");
		return rs;
	}



  public Set obtenerFuncionesFinales() throws MareException {
//Obtiene los oids de todas las funciones finales del sistema

        UtilidadesLog.info("DAOMenu.obtenerFuncionesFinales():Entrada");
        RecordSet rs = new RecordSet();

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT OID_FUNC ");
            query.append(" FROM MEN_FUNCI ");
            query.append(" WHERE IND_NIVE = 1 ");			

            rs = (RecordSet)BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } 

		HashSet salida = new HashSet();
		for (int i=0 ;i < rs.getRowCount() ;i++ )  {
			salida.add(new Long(rs.getValueAt(i,0).toString()));
		}
    UtilidadesLog.info("DAOMenu.obtenerFuncionesFinales():Salida");
		return salida;		
  }


    public static void main(String[] args) throws Exception {
        DAOMenu h = new DAOMenu("usuario1");
        Set a = new TreeSet();
        for (int i = 0; i < 2900; i++) {        
          a.add(new Long(i));
        }
        Map d = h.obtenerRutaCompletaFuncion(a, new Long(21));
    }
}