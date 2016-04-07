package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dts.MareDTS;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


import es.indra.sicc.entidades.zon.EstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.EstructuraGeopoliticaLocalHome;
import es.indra.sicc.entidades.zon.SubestructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.SubestructuraGeopoliticaLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;

import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.logicanegocio.zon.DAOZON;
import es.indra.sicc.logicanegocio.zon.ErroresDeNegocio;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;

import es.indra.sicc.dtos.zon.DTOEGPaises;
import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;
import es.indra.sicc.dtos.zon.DTOUsuario;
import es.indra.sicc.dtos.zon.DTOZONConsultarPaises;
import es.indra.sicc.dtos.zon.DTOSubEstructura;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.sql.*;

public class MONEstructuraGeoPoliticaBean implements SessionBean {
    private SessionContext ctx;
	private static final int MAXIMO_PAIS_CONSULTA_EG = 5;

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public DTOEstructuraGeopoliticaPais obtenerEstructuraGeoPolitica(DTOPais pais) throws MareException {
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.obtenerEstructuraGeoPolitica(DTOPais pais): Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;
        DTOEstructuraGeopoliticaPais estGeo= new DTOEstructuraGeopoliticaPais();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            Vector param = new Vector();

            param.addElement(pais.getPais());
            param.addElement(pais.getOidIdioma());
            
            buf.append("select COD_DIVI_POLI, COD_ORDE, OID_ESTR_GEOP, val_i18n ");            
            buf.append("from ZON_ESTRU_GEOPO a, ZON_NIVEL_GEOGR b, V_GEN_I18N_SICC  ");     
            buf.append("where a.PAIS_OID_PAIS = ? ");      
            buf.append("and a.DIPO_OID_DIVI_POLI = b.OID_DIVI_POLI ");
            buf.append("and a.IND_BORR = 0 ");            
            buf.append("and a.DIPO_OID_DIVI_POLI = VAL_OID ");
            buf.append("and ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");           
            buf.append("and ATTR_NUM_ATRI = 1 ");
            buf.append("and idio_oid_idio = ? ");
            buf.append("order by COD_ORDE ");
        
            respuesta = bs.dbService.executePreparedQuery(buf.toString(), param);

            estGeo.setCodDivPol(respuesta.getColumn(0));
            estGeo.setNivelEG(respuesta.getColumn(1));
            estGeo.setPais(pais.getPais());
            estGeo.setOidEG(respuesta.getColumn(2));
            estGeo.setDescripcionDivPol(respuesta.getColumn(3));
            
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.obtenerEstructuraGeoPolitica(DTOPais pais): Salida");
        return estGeo;
        
    }

    public RecordSet cargaPaisesSinEG(String usuario) // ya no se usa mas en el actual modelo de componentes
        throws RemoteException, MareException {
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.cargaPaisesSinEG(String usuario): Entrada");
        
        RecordSet rs = null;
        DTOSalida salida = new DTOSalida();
        StringBuffer query = new StringBuffer();

        int pais = 1;
        BelcorpService bs;

        bs = getBelcorpService();

        query.append(" select  cod_pais, val_i18n  ");
        query.append(" from V_GEN_I18N_SICC A,  ");
        query.append(" SEG_PAIS B ");
        query.append(" where a.attr_enti = 'SEG_PAIS'  ");
        query.append(" and a.attr_num_atri = 1  ");
        query.append(" and a.idio_oid_idio = 1  ");
        query.append(" and a.val_oid = b.oid_pais ");
        query.append(" and b.OID_PAIS not in (select c.PAIS_OID_PAIS ");
        query.append(" 			   	   	  		  from ZON_estru_geopo C ) ");
        query.append(" order by cod_pais ");

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());

            salida.setResultado(rs);
            UtilidadesLog.debug("MON!DTOSalida: \n" + salida);
            } catch (Exception re) {
                String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.cargaPaisesSinEG(String usuario): Salida");
        return rs;
    }

    boolean estanTodos(Vector nivelEG) {
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.estanTodos(Vector nivelEG)): Entrada");
        boolean sw = true;
        Vector ordena = new Vector();

        for (int i = 0; i < nivelEG.size(); i++) {
            ordena.add(new Integer(-1));
        }

        for (int i = 0; i < nivelEG.size(); i++) {
            if (((Integer) nivelEG.get(i)).intValue() <= nivelEG.size()) {
                ordena.set(((Integer) nivelEG.get(i)).intValue() - 1,
                    nivelEG.get(i));
            }
        }

        for (int i = 0; i < ordena.size(); i++) {
            if (i != (((Integer) ordena.get(i)).intValue() - 1)) {
                sw = false;
            }
        }
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.estanTodos(Vector nivelEG): Salida");
        return sw;
    }

    public void definirEG(DTOEstructuraGeopoliticaPais eg)
        throws MareException {
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.definirEG(DTOEstructuraGeopoliticaPais eg): Entrada");
        
        String codigoError;
        Vector nivelEG = eg.getNivelEG();
        Vector codDivPol = eg.getCodDivPol();

        if (estanTodos(nivelEG) == true) {
            EstructuraGeopoliticaLocalHome estructLH = this.getEstructuraGeopoliticaLocalHome();

            try {
                for (int i = 0; i < eg.getNivelEG().size(); i++) {
                    estructLH.create((Integer) nivelEG.get(i),
									 new Long(eg.getPais().longValue()),
									 new Long(((Integer) codDivPol.get(i)).longValue()),
									 new Timestamp(System.currentTimeMillis()));
                }
                
                UtilidadesLog.info("MONEstructuraGeoPoliticaBean.definirEG(DTOEstructuraGeopoliticaPais eg): Salida");
                
            } catch (Exception re) {
                codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }
    }

    public RecordSet cargaPaisesConEG(DTOUsuario usuario) throws MareException {
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.cargaPaisesConEG(DTOUsuario usuario): Entrada");
        
        RecordSet rs = null;
        String codigoError;
        String user = ctx.getCallerPrincipal().getName();
        DTOSalida salida =  new DTOSalida();
        BelcorpService bs;
        bs = getBelcorpService();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" IPais.VAL_OID,  ");
        query.append(" IPais.VAL_I18N ");
        query.append(" FROM VCA_SEG_PAIS P, V_GEN_I18N_SICC IPais ");
        query.append(" WHERE IPais.ATTR_ENTI = 'SEG_PAIS' ");
        query.append(" AND IPais.IDIO_OID_IDIO = " + usuario.getOidIdioma() + " ");
        query.append(" AND IPais.VAL_OID = P.OID_PAIS  ");
        query.append(" AND IPais.ATTR_NUM_ATRI = 1 ");
        query.append(" AND P.COD_USUA = '"+user+"' ");
        query.append(" AND EXISTS (SELECT * ");
        query.append("                      FROM ZON_ESTRU_GEOPO EG ");
        query.append("                      WHERE EG.PAIS_OID_PAIS = P.OID_PAIS ");
        query.append("                      AND EG.IND_BORR = 0) ");
        query.append(" ORDER BY IPais.VAL_I18N ");

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());

            salida.setResultado(rs);
            UtilidadesLog.debug("MON!DTOSalida: \n" + salida);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
      
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.cargaPaisesConEG(DTOUsuario usuario)): Salida");
        
        return rs;
    }

    public DTOSalida consultaEGPaises(DTOZONConsultarPaises paises)
        throws RemoteException, MareException {
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaEGPaises(DTOZONConsultarPaises paises): Entrada");
        
        RecordSet rs = null;
        String codigoError;
        DTOSalida salida = new DTOSalida();
        StringBuffer query = new StringBuffer();

        int pais = 1;
        BelcorpService bs;

        bs = getBelcorpService();

        Vector vecPaises = paises.getPaises();
        String idioma = paises.getIdioma().toString();

        query.append(" SELECT ");
        query.append(" ng.oid_divi_poli, ");
        query.append(" INivel.val_i18n desc_dp, "); 
        query.append(" EST.oid_pais oid_pais, ");
        query.append(" EST.desc_pais desc_pais, ");
        query.append(" EST.nivel nivel ");
        query.append(" FROM ");
        query.append(" (SELECT "); 
        query.append(" b.oid_pais OID_PAIS, ");
        query.append(" IPais.val_i18n desc_pais, "); 
        query.append(" c.cod_orde nivel, ");
        query.append(" c.DIPO_OID_DIVI_POLI DIPO_OID_DIVI_POLI "); 
        query.append(" FROM seg_pais b, zon_estru_geopo c, ");
        query.append(" V_GEN_I18N_SICC IPais ");
        query.append(" WHERE c.pais_oid_pais = b.oid_pais "); 
        query.append(" AND c.ind_borr = 0 ");
        query.append(" AND IPais.ATTR_ENTI = 'SEG_PAIS' "); 
        query.append(" AND IPais.IDIO_OID_IDIO = " + idioma + " ");
        query.append(" AND IPais.VAL_OID = b.oid_pais ");
        query.append(" AND IPais.ATTR_NUM_ATRI = 1 ");

        query.append(" 		AND ( 1!=1 ");
            for (int i = 0; i < vecPaises.size(); i++) {
                String cadena = new String( ( ( (DTOPais) vecPaises.get(i)).getPais()).toString() );
                query.append("   OR	c.PAIS_OID_PAIS = " + cadena);
            }
        query.append(") ");

        query.append(" ) EST, ");
        query.append(" zon_nivel_geogr ng, ");
        query.append(" V_GEN_I18N_SICC INivel ");   
        query.append(" WHERE ");
        query.append(" ng.OID_DIVI_POLI  = EST.DIPO_OID_DIVI_POLI (+) ");
        query.append(" AND INivel.ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
        query.append(" AND INivel.IDIO_OID_IDIO = " + idioma + " ");
        query.append(" AND INivel.VAL_OID = ng.oid_divi_poli "); 
        query.append(" AND INivel.ATTR_NUM_ATRI = 1 ");
        query.append(" ORDER BY 1,4 ");
        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("Rs: "+rs);
      			salida.setResultado( modificarResultado( rs ) );
            UtilidadesLog.debug("Rs res: "+salida.getResultado());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        if ( salida.getResultado().esVacio()){
            UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaEGPaises(DTOZONConsultarPaises paises): Salida");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaEGPaises(DTOZONConsultarPaises paises): Salida");
        return salida;
    }

    public DTOEstructuraGeopoliticaPais consultaEGMod(DTOZONConsultarPaises paises) throws MareException {
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaEGMod(DTOZONConsultarPaises paises): Entrada");
        
    		DTOEstructuraGeopoliticaPais salida = new DTOEstructuraGeopoliticaPais();
        Vector vecPaises = paises.getPaises();
        String idioma = paises.getIdioma().toString();
        Long paisSel = new Long( ((DTOPais) vecPaises.get(0)).getPais().toString() );

        Boolean tieneUG;
        try{
            tieneUG = ZONEjbLocators.getMONUnidadesGeograficasHome().create().paisTieneUG(paisSel);        

        }catch(RemoteException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if (tieneUG.booleanValue())
      			throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", 
                ErroresDeNegocio.PAIS_TIENE_UG_ASIGNADAS)); 

                
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" IGeo.VAL_I18N des_geop, ");
        query.append(" IGeo.VAL_OID,  ");
        query.append(" a.cod_orde ");
        query.append(" FROM ZON_NIVEL_GEOGR G, V_GEN_I18N_SICC IGeo, zon_estru_geopo a ");
        query.append(" WHERE IGeo.ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
        query.append(" AND IGeo.IDIO_OID_IDIO = " + idioma + " ");
        query.append(" AND IGeo.VAL_OID = G.OID_DIVI_POLI  ");
        query.append(" AND IGeo.ATTR_NUM_ATRI = 1 ");
        query.append(" AND a.dipo_oid_divi_poli(+) = G.oid_divi_poli ");
        query.append(" AND a.pais_oid_pais(+) = " + paisSel);
        query.append(" AND a.ind_borr(+) = 0 ");
        query.append(" ORDER BY IGeo.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
            salida.setDescripcionDivPol(rs.getColumn(0));;			
      			salida.setCodDivPol(rs.getColumn(1));
      			salida.setNivelEG(rs.getColumn(2));
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaEGMod(DTOZONConsultarPaises paises): Salida");
        return salida;
    }

    public void modificaEG(DTOEstructuraGeopoliticaPais eg)
        throws RemoteException, MareException {
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.modificaEG(DTOEstructuraGeopoliticaPais eg): Entrada");
        
        Vector nivelEG = eg.getNivelEG();

        if (estanTodos(nivelEG) == true) {
            DTOPais pais = new DTOPais();
            pais.setPais(eg.getPais());
            eliminaEG(pais);
            definirEG(eg);
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.modificaEG(DTOEstructuraGeopoliticaPais eg): Salida");
    }

    public void eliminaEG(DTOPais pais) throws RemoteException, MareException {
    
    UtilidadesLog.info("MONEstructuraGeoPoliticaBean.eliminaEG(DTOPais pais): Entrada");
    
    String codigoError;
    Boolean res=null;
    try{
        res = ZONEjbLocators.getMONUnidadesGeograficasHome().create().paisTieneUG(pais.getPais());
        
    }
    catch ( CreateException e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
    if(res.booleanValue() ){
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.ELIMINACION_ESTRGEOPOL_UNIDAD_GEOGRAFICA_EXISTENTE));
        }
        else {
            DAOZON dao = new DAOZON();		
            dao.borradoLogicoEG(pais.getPais());            
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.eliminaEG(DTOPais pais): Salida");
    }


    public boolean paisTieneEG(Long pais)
        throws RemoteException, MareException {
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.paisTieneEG(Long pais): Entrada");
        
        RecordSet rs = null;
        DTOSalida salida = new DTOSalida();
        String codigoError;
        StringBuffer query = new StringBuffer();

        BelcorpService bs;

        bs = getBelcorpService();

        query.append(" select 1 ");
        query.append(" from   ");
        query.append(" ZON_estru_geopo ");
        query.append(" where PAIS_OID_PAIS = " + pais + " and ind_borr = 0");

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
            salida.setResultado(rs);
            UtilidadesLog.debug("DTOSalida: \n" + salida);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.paisTieneEG(Long pais): Salida");
        return !rs.esVacio();
    }

    public boolean paisTieneNivelDefinido(Integer oidPais, Integer nivel, String pais) throws RemoteException, MareException {
        return false;
    }


	private  RecordSet modificarResultado(RecordSet qryResult) throws Exception{
    UtilidadesLog.info("MONEstructuraGeoPoliticaBean.modificarResultado(RecordSet qryResult): Entrada");
    
		RecordSet resultado = new RecordSet();
		RecordSet rTmp = new RecordSet();

		String divPol = "";
		String divPolTmp = "";
		String paisTmp = "";
		String pais = "";
		Vector vDivPol = new Vector();
		Vector vOidDivPol = new Vector();
		Vector vPais = new Vector();
    Long oidDivPol;
		boolean bExiste = false;

		HashMap hmPais;

		for (int i=0; i < qryResult.getRowCount() ; i++){
			divPol = (String) qryResult.getValueAt(i,1);
			if ( !vDivPol.contains( divPol )){
				vDivPol.add(divPol);
        vOidDivPol.add(new Long(((BigDecimal) qryResult.getValueAt(i,0)).toString()));
			}
		}

		for (int i=0; i < qryResult.getRowCount() ; i++){
			pais = (String) qryResult.getValueAt(i,3);
			if ( !vPais.contains( pais ) && (vPais.size() < MAXIMO_PAIS_CONSULTA_EG) && pais!=null){
				vPais.add(pais);
			}
		}

		resultado.addColumn("oid_division_politica");
		resultado.addColumn("division_politica");

		for(int i=0; (i<vPais.size()); i++)	resultado.addColumn( (String) vPais.get(i) );

		rTmp.addColumn("division_politica");
		rTmp.addColumn("pais");
		rTmp.addColumn("nivel");

		for (int i=0; i < vDivPol.size() ; i++){ //x Division Politica
			divPol = (String) vDivPol.get(i);
			for (int j=0; (j < vPais.size()); j++){ //x Pais
				pais = (String) vPais.get(j);
				bExiste = false;
			
				for (int z=0; z<qryResult.getRowCount(); z++){ //recorro los resultados

					divPolTmp = (String) qryResult.getValueAt(z,1) ;
					paisTmp = (String) qryResult.getValueAt(z,3) ;

					if ( //si encuentro la combinacion en los resultados					
						divPol.equals( divPolTmp ) &&
						pais.equals( paisTmp ) &&
						(bExiste == false)
						){ 
						rTmp.addRow( new Object[]{ (String) vDivPol.get(i), vPais.get(j), ((BigDecimal) qryResult.getValueAt(z,4)).toString() } );
						bExiste = true;
						break;
					}

				}

				if (bExiste == false) rTmp.addRow( new Object[]{ (String) vDivPol.get(i), vPais.get(j), "-" } );

			}
		}

		Vector valoresTmp;
		for (int i=0; i < vDivPol.size() ; i++){
			valoresTmp = new Vector();
      valoresTmp.add((Long) vOidDivPol.get(i));
			valoresTmp.add( (String) vDivPol.get(i));
			for (int j=0; (j<vPais.size()); j++){
				valoresTmp.add( rTmp.getValueAt( ( (i * vPais.size()) + j),2) );
			}		
			resultado.addRow( valoresTmp.toArray() );
		}

    UtilidadesLog.info("MONEstructuraGeoPoliticaBean.modificarResultado(RecordSet qryResult): Salida");
		return resultado;
	  }


	
    public RecordSet consultaDefinirEG(DTOZONConsultarPaises dtoe) throws RemoteException, MareException  {
    
    UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaDefinirEG(DTOZONConsultarPaises dtoe): Entrada");
    
		String codigoError;
		RecordSet rs = new RecordSet();
		try {
		  Long pais = new Long( (String) ((Vector) dtoe.getPaises()).get(0) );
		  if (paisTieneEG(pais) == false) {
			rs = cargaDivisionesPoliticas(dtoe.getIdioma());
		  } else {			
		    Exception ex = new Exception();
			codigoError = ErroresDeNegocio.EXISTE_ESTRUCTURA_GEOPOLITICA;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));		  
		  }
        } catch (Exception e) {
            codigoError = ErroresDeNegocio.EXISTE_ESTRUCTURA_GEOPOLITICA;
		 	  throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", codigoError));
        }
        
    UtilidadesLog.info("MONEstructuraGeoPoliticaBean.consultaDefinirEG(DTOZONConsultarPaises dtoe): Salida");
		return rs;
	}

    public RecordSet cargaDivisionesPoliticas(Long idioma)
        throws RemoteException, MareException {
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.cargaDivisionesPoliticas(Long idioma): Entrada");
        
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" G.oid_divi_poli,  ");
        query.append(" IGeo.VAL_I18N ");
        query.append(" FROM ZON_NIVEL_GEOGR G, V_GEN_I18N_SICC IGeo ");
        query.append(" WHERE IGeo.ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
        query.append(" AND IGeo.IDIO_OID_IDIO = " + idioma + " ");
        query.append(" AND IGeo.VAL_OID = G.OID_DIVI_POLI  ");
        query.append(" AND IGeo.ATTR_NUM_ATRI = 1 ");
        query.append(" ORDER BY IGeo.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.cargaDivisionesPoliticas(Long idioma): Salida");
        return rs;

    }


    private BelcorpService getBelcorpService() throws MareException {
    
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.getBelcorpService(): Entrada");
        
        String codigoError;
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONEstructuraGeoPoliticaBean.getBelcorpService(): Salida");
        return bs;
    }

    private EstructuraGeopoliticaLocalHome getEstructuraGeopoliticaLocalHome() {
        return new EstructuraGeopoliticaLocalHome();
    }



}
