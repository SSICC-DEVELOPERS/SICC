package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.zon.DTOUBIGEO;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.dtos.zon.DTOUG;
import es.indra.sicc.dtos.zon.DTOLISTUniNSE;
import es.indra.sicc.entidades.zon.EstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.EstructuraGeopoliticaLocalHome;
import es.indra.sicc.entidades.zon.SubestructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.SubestructuraGeopoliticaLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;
import es.indra.sicc.logicanegocio.zon.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.zon.DAOZON;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.util.UtilidadesEJB;


import java.lang.reflect.Array;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Timestamp;
import es.indra.sicc.dtos.zon.DTOSubEstructura;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONUnidadesGeograficasBean implements SessionBean {
    private SessionContext ctx = null;

    public void ejbCreate() {}
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void ejbRemove() { }

    public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }

    public DTOSalida modificaEstadoUniGeo(DTOUG dto) throws  MareException {
    
      UtilidadesLog.info("MONUnidadesGeograficasBean.modificaEstadoUniGeo(DTOUG dto): Entrada");
      /*Este método retorna las unidades geográficas que corresponden
       al país y a la unidad geográfica pasadas por parámetro. 

        1)Se llama al método ObtenerUnidadesGeograficas pasándole
        como parámetro de entrada dto.
        
        2)Si la llamada a este metodo retorna una MAREException con
        el codigo "ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE" 

          2.a)Si dto.oidUG==NULL entonces 
              se genera una MAREException con el codigo
              de error: 280040001 (El país no tiene Unidades Geograficas.) 
          2.b)sino 
              se genera sube la MAREException recibida del metodo ObtenerUnidadesGeograficas 
              Fin Si 

        Sino El método retorna el DTOSalida retornado por el método invocado. 
        Fin del Si*/

      DTOSalida dtoSalida = new DTOSalida();   

      try {
        dtoSalida = this.obtenerUnidadesGeograficas(dto);        
      }
      catch (MareException ma) {
        UtilidadesLog.debug("************* Entre al catch porque se lanzo una MareException");
        UtilidadesLog.debug(ma);

        if(ma.getCode()== UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)) { // Codigo 5
          if(dto.getOidUG()== null) {
            UtilidadesLog.info("MONUnidadesGeograficasBean.modificaEstadoUniGeo(DTOUG dto): Salida");
            throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "",ErroresDeNegocio.PAIS_SIN_UNIDADES_GEOGRAFICAS));
          }
          else {
            UtilidadesLog.info("MONUnidadesGeograficasBean.modificaEstadoUniGeo(DTOUG dto): Salida");
            throw ma;
          }         
        }
      }      
      
      UtilidadesLog.info("MONUnidadesGeograficasBean.modificaEstadoUniGeo(DTOUG dto): Salida");
      return dtoSalida;
    }

    public DTOSalida obtenerUGTerritorios(DTOUG dto) throws  MareException {
    
      UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUGTerritorios(DTOUG dto): Entrada");
      DTOSalida dtoSalida = new DTOSalida();
      
      try {
          
        DAOZON dao = new DAOZON();
        Long estruGeo = null;
        Long ultimo = null;
                
        if(dto.getOidUG()!=null) {
          ValoresEstructuraGeopoliticaLocalHome veglh = this.getValoresEstructuraGeopoliticaLocalHome();
          UtilidadesLog.debug("*********** Llamando al findByPrimaryKey con OidUG " + dto.getOidUG());
          ValoresEstructuraGeopoliticaLocal vegl = veglh.findByPrimaryKey(dto.getOidUG());
          estruGeo = vegl.getEgeo_oid_estr_geop();

          ultimo = dao.obtenerUltimoNivel(dto.getOidPais());          
        }
        else {
          ultimo = new Long(-1);
        }                

        if((dto.getOidUG()!=null) && (ultimo.longValue() == estruGeo.longValue())) {
          dtoSalida = dao.obtenerTerritoriosUG(dto.getOidPais(), dto.getOidUG());  
        }
        else {
          dtoSalida = this.obtenerUnidadesGeograficas(dto);
        }        
      }
      catch (NoResultException re) {
        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (MareException ma) {
        UtilidadesLog.debug("************* Entre al catch porque se lanzo una MareException");
        UtilidadesLog.debug(ma);

        if(ma.getCode()== UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)) { // Codigo 5
          if(dto.getOidUG()== null) {
            throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "",ErroresDeNegocio.PAIS_SIN_UNIDADES_GEOGRAFICAS));
          }
          else {
            throw ma;
          }         
        }
      }
      
      UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUGTerritorios(DTOUG dto): Salida");
      return dtoSalida;
    } 

    
/*este metodo  recibe el DTOUG, se recibe el oidPais, que identifica al país, el oidUniGeo, que 
 * identifica a la unidad geografica y el flag filtroActiva que indica con True o False si se deben 
 * retornar solo las activas o todas las definidas. 
*/
    public DTOSalida obtenerUnidadesGeograficas(DTOUG dtoUG) throws MareException {
    
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUnidadesGeograficas(DTOUG dtoUG): Entrada");
        
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        //DTOUG dtoUG = new DTOUG();
        StringBuffer query = new StringBuffer();
        String orden = " ";
        ValoresEstructuraGeopoliticaLocal registroUGLocal;
        DTOAuditableSICC dtoAuditable = new DTOAuditableSICC();
        dtoAuditable.setIpCliente(dtoUG.getIpCliente());
        dtoAuditable.setPrograma(dtoUG.getPrograma());

        try {
            ValoresEstructuraGeopoliticaLocalHome localHome = this.getValoresEstructuraGeopoliticaLocalHome();
            
            bs = BelcorpService.getInstance();

            ValoresEstructuraGeopoliticaLocal registroUG;

            query.append(" select ");
            query.append(" OID_VALO_ESTR_GEOP, COD_UNID_GEOG, DES_GEOG, IND_ACTI, COD_NSE1, COD_NSE2, COD_NSE3, COD_POST , orde_1||orde_2||orde_3||orde_4||orde_5||orde_6||orde_7||orde_8||orde_9 UBIGEO ");
            query.append(" from ZON_VALOR_ESTRU_GEOPO a ");
            
            if ( (dtoUG.getOidUG() == null) && (dtoUG.getFiltroActiva().booleanValue()==true) ) {
                //si es de orden1 ... es decir... el oidUBIGEO = null
                bs = getBelcorpService();
                query.append(" where a.orde_2 is NULL ");
                query.append(" and a.IND_ACTI = 1 " );
                //+ ( dtoUG.getFiltroActiva().booleanValue()==true  ?new Long(1):new Long(0)) 
                query.append(" and a.PAIS_OID_PAIS = " + dtoUG.getOidPais() );
                query.append(" and a.IND_BORR = 0 ");
            } 
            else if((dtoUG.getOidUG() == null) &&  (dtoUG.getFiltroActiva().booleanValue()==false) )
            {
                bs = getBelcorpService();
                query.append(" where a.orde_2 is NULL ");
                query.append(" and a.PAIS_OID_PAIS = " + dtoUG.getOidPais() );
                query.append(" and a.IND_BORR = 0 ");
            }
            else {
                try {
                    registroUG = localHome.findByPrimaryKey(dtoUG.getOidUG());
                } catch (NoResultException re) {
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
              if( dtoUG.getFiltroActiva().booleanValue() ){
                  query.append(armarWhere(registroUG));
                  query.append(" and a.PAIS_OID_PAIS = " + dtoUG.getOidPais() );
                  query.append(" and a.IND_BORR = 0 ");
                  query.append(" and a.IND_ACTI = " + ( dtoUG.getFiltroActiva().booleanValue()==true  ?new Long(1):new Long(0))  );
              }
              else {
                  query.append(armarWhere(registroUG));
                  query.append(" and a.PAIS_OID_PAIS = " + dtoUG.getOidPais() );
                  query.append(" and a.IND_BORR = 0 ");
                  //query.append(" and a.IND_ACTI = " + ( dtoUG.getFiltroActiva().booleanValue()==true  ?new Long(1):new Long(0))  );
              }
            }
             //fin del else de ubigeo==null
             
            // Ordenamiento
            query.append(" order by DES_GEOG");
            
        } //fin del try

        catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        try {
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.debug(me);
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (resultado.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        dtos.setResultado(resultado);     
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUnidadesGeograficas(DTOUG dtoUG): Salida");
        return dtos;
    }
     //fin del metodo
/*metodo que arma el where*/
    private String armarWhere(ValoresEstructuraGeopoliticaLocal UGLocal) {
    
        UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhere(ValoresEstructuraGeopoliticaLocal UGLocal): Entrada");
        
        StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[] {
                "orde_1", "orde_2", "orde_3", "orde_4", "orde_5", "orde_6",
                "orde_7", "orde_8", "orde_9"
            };
        Object[] valoresWhere = new Object[] {
                UGLocal.getOrde_1(), UGLocal.getOrde_2(), UGLocal.getOrde_3(),
                UGLocal.getOrde_4(), UGLocal.getOrde_5(), UGLocal.getOrde_6(),
                UGLocal.getOrde_7(), UGLocal.getOrde_8(), UGLocal.getOrde_9()
            };
        boolean[] operadores = new boolean[] {
                false, false, false, false, false, false, false, false, false
            };

        /*
         * Armamos where de los campos not null
         */
        query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere,
                operadores));

        
        int posNula = 0;

        for (int i = 0; i < valoresWhere.length; i++) {
            if (valoresWhere[i] != null) {
                posNula++;
                UtilidadesLog.debug("valoresWhere[i]: " + valoresWhere[i]);
            } else {
                break; //i = valoresWhere.length; 
            }
        }

        if (posNula <= 8) {
            query.append(" and " + camposWhere[posNula] + " is not null ");
        }

        if (posNula == 9) {
            query.append(" and " + camposWhere[posNula - 1] + " is null ");
        } else if(posNula < 8) {
            query.append(" and " + camposWhere[posNula + 1] + " is null ");
        }

        UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhere(ValoresEstructuraGeopoliticaLocal UGLocal): Salida");
        return query.toString(); //deberia retornar el string                   
    }

    
//Este metodo permite dado un Territorio obtener el codigo UBIGEO.Este codigo es unico
//para cada Territorio
    public DTOUBIGEO obtenerUBIGEOdeTerritorio(Long codTerritorio)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUBIGEOdeTerritorio(Long codTerritorio): Entrada");
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUBIGEOdeTerritorio(Long codTerritorio : " + codTerritorio);
        
        TerritorioLocal regTerriLocal;
        ValoresEstructuraGeopoliticaLocal registroUGLocal;

        BelcorpService bs;

        try {
            TerritorioLocalHome localHomeTerri = this.getTerritorioLocalHome();
            bs = BelcorpService.getInstance();
            regTerriLocal = localHomeTerri.findByPrimaryKey(codTerritorio);
            Vector v = new Vector();
            
            ValoresEstructuraGeopoliticaLocalHome localHome = this.getValoresEstructuraGeopoliticaLocalHome();

            bs = BelcorpService.getInstance();
            
            UtilidadesLog.info("regTerriLocal.getOidValoresEstruGeo() : " + regTerriLocal.getOidValoresEstruGeo());
            ValoresEstructuraGeopoliticaLocal registroUG = localHome.findByPrimaryKey(regTerriLocal.getOidValoresEstruGeo());
            String ubigeoStr = new String();
            String[] ubigeoArr = new String[] {
                    registroUG.getOrde_1(), registroUG.getOrde_2(),
                    registroUG.getOrde_3(), registroUG.getOrde_4(),
                    registroUG.getOrde_5(), registroUG.getOrde_6(),
                    registroUG.getOrde_7(), registroUG.getOrde_8(),
                    registroUG.getOrde_9()
                };
            int nivel = 0;
                
            for (int i = 0; i < ubigeoArr.length; i++) {
                if (ubigeoArr[i] != null) {
                    ubigeoStr = ubigeoStr + ubigeoArr[i];
                    nivel = i + 1;
                }
                //break;
            }
            UtilidadesLog.info("ubigeoStr   " + ubigeoStr);
            //inserta en el vector el primer ubigeo
            DTOUBIGEO dtoUG = new DTOUBIGEO();
            String descripcion = registroUG.getDes_geog();
            //dtoUG.setDescCompleta(registroUG.getDes_geog());
            Long indicadorActiva=registroUG.getInd_acti();
                
            dtoUG.setIndicadorActiva(indicadorActiva.longValue()==new Long(1).longValue()?Boolean.TRUE:Boolean.FALSE);
            dtoUG.setOidTerritorio(regTerriLocal.getOid());
            UtilidadesLog.info("regTerriLocal.getOid() :  " + regTerriLocal.getOid());
            dtoUG.setUBIGEO(ubigeoStr);
            v.addElement(dtoUG);
            Long pais = registroUG.getPais_oid_pais();
            //inserta en el vector el segundo ubigeo

             //deberia devolver la descripcion separada por comas   
            for (int i =ubigeoStr.length()-6; i >= 6; i--) {
                     
                ubigeoStr= ubigeoStr.substring(0, i);
                //buscar el oid de valoresEstructuraGeopolitica a traves de DAOZON
                DAOZON daoZon = new DAOZON();
                Long oidUG = daoZon.obtenerUniGeoPorUBIGEO(ubigeoStr, pais );
                UtilidadesLog.info("oidUG :  " + oidUG);
                
                if (oidUG != null) {
                    try{
                        registroUG = localHome.findByPrimaryKey(oidUG);
                        descripcion = registroUG.getDes_geog() + ',' + descripcion;
                    }
                    catch (NoResultException re) {
                        UtilidadesLog.error(re);
                        ctx.setRollbackOnly();
                        throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                        
                }//fin if oidUG != null
                i=i-5;
            }//fin del for
            dtoUG.setDescCompleta(descripcion);
            UtilidadesLog.info("vuelve del metodo obtenerUBIGEOdeTerritorio  " + dtoUG);
            UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerUBIGEOdeTerritorio(Long codTerritorio): Salida");
            return dtoUG;                  
            
        } catch (NoResultException re) {           
           throw new MareException(re,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.UBIGEO_NO_EXISTE_PARA_TERRITORIO));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

    }

    //este metodo valida que exista el ubigeo recibido en la base... 
    //debiso a que el findByUbigeo no funciona debo hacer el metodo obtenerUniGeoPorUBIGEO(UBIGEO, pais)
    public Boolean validarUBIGEO(Long oidPais, String ubigeo)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.validarUBIGEO(Long oidPais, String ubigeo): Entrada");
        
        ValoresEstructuraGeopoliticaLocal registroUGLocal;
        Boolean b = Boolean.TRUE;

        // Verifica longitud y formato
        int resto = (ubigeo.length() % 6);

        if((ubigeo.length() >= 6) && (ubigeo.length() <= 54) && (resto == 0) && (ubigeo != null)) {
            
            DAOZON daoZon = new DAOZON();
            Long oidUG = daoZon.obtenerUniGeoPorUBIGEO(ubigeo, oidPais);
                    
            if (oidUG != null) {
               try{
                   ValoresEstructuraGeopoliticaLocalHome localHome = this.getValoresEstructuraGeopoliticaLocalHome();
                    
                    ValoresEstructuraGeopoliticaLocal registroUG;
                    registroUG = localHome.findByPrimaryKey(oidUG);
                    if( (registroUG.getInd_acti().longValue()==1) && (registroUG.getInd_borr().longValue()==0) ){
                        b = b.TRUE;
                    }
                    else{
                        b = b.FALSE;
                    }    
               }
               catch (Exception e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
                
            } else{
                b = b.FALSE;
            }
            
        } else{
            b = b.FALSE;
        }
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.validarUBIGEO(Long oidPais, String ubigeo): Salida");
        return b;
    }
     //fin metodo

    public void desasignarUnidadesGeograficas(DTOPais pais)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.desasignarUnidadesGeograficas(DTOPais pais): Entrada");
        /*
        * Método que desasigna al país de entrada todas las Unidades Geográficas que tenía asignadas.

        Realiza una actualizacion utilizando DBService sobre la entidad de
        ValoresEstructuraGeopolitica, filtrando a través de oidPaís. Esta actualizacion consistira
        es asignar al atributo ACTIVO el valor FALSE y BORRADO el valor TRUE. Además, se debe
        guardar la fecha del sistema en que se realiza la modificación.
        * */

        //DTOPais pais = DTOPais();
        BelcorpService bs;
        bs = BelcorpService.getInstance();
        Timestamp time = new Timestamp(System.currentTimeMillis());        
        StringBuffer query = new StringBuffer();
        String fechaStr = time.toString();
        
        
        String fecha = fechaStr.substring(0, fechaStr.indexOf(".") );
        fecha = " to_date( ' " + fecha + "', 'YYYY-MM-DD HH24:MI:SS' ) ";

        DTOAuditableSICC dtoAuditable = new DTOAuditableSICC();
        dtoAuditable.setIpCliente(pais.getIpCliente());
        dtoAuditable.setPrograma(pais.getPrograma());

        query.append(" update ZON_VALOR_ESTRU_GEOPO ");
        query.append(" set IND_ACTI= " + 0 + ", IND_BORR = " + 1 + ", FEC_ACTU = " + fecha );
        query.append(" where  PAIS_OID_PAIS= " + pais.getPais());
        query.append(" and  IND_BORR = 0 ");
        int n;
        try{
            n = bs.dbService.executeUpdate(query.toString());               
        }
        catch (Exception re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        if(n==0){
                UtilidadesLog.info("MONUnidadesGeograficasBean.desasignarUnidadesGeograficas(DTOPais pais): Salida");
                throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_NO_TIENE_UNIDAD_GEOGRAFICA_A_DESASIGNAR));
            }        
            
            UtilidadesLog.info("MONUnidadesGeograficasBean.desasignarUnidadesGeograficas(DTOPais pais): Salida");
    }

    //metodo que devuelve true si el pais tien Unidad Geografica
    public Boolean paisTieneUG(Long pais) throws MareException {
        UtilidadesLog.info("MONUnidadesGeograficasBean.paisTieneUG(Long pais): Entrada");
        
        Boolean b = Boolean.FALSE;

        //hacer referencia al metodo consultarNumUG de DAOZON,()es una clase no un mon que devuelve cantidad de registros
        Long cantReg = null;
        DAOZON cantRegistros = new DAOZON();
        cantReg = cantRegistros.consultarNumUG(pais);

        try {
            if (cantReg.longValue() > 0) {
                b = b.TRUE;
            } else {
                b = b.FALSE;
            }
        } catch (Exception e) {
            UtilidadesLog.debug(e);
        }

        UtilidadesLog.info("MONUnidadesGeograficasBean.paisTieneUG(Long pais): Salida");
        return b;
    }

    /*Este metodo dado un Pais y un UBIGEO de entrada retorna una lista de 
     * territorios asignados al UBIGEO de entrada.*/
    public DTOSalida obtenerTerritoriosdeUBIGEO(Long pais, String ubigeo) throws MareException {
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerTerritoriosdeUBIGEO(Long pais, String ubigeo): Entrada");
        
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        String[] ubigeoArray = new String[9];
        int resto = (ubigeo.length() % 6);
        
        if ((ubigeo.length() >= 6) && (ubigeo.length() <= 54) &&
                (resto == 0)) {
                int a = 0;
                for (int i = 0; i < ubigeo.length(); i++) {
                        ubigeoArray[a] = ubigeo.substring(i, i + 6);
                        i = i + 5;
                        a = a + 1;
                }                
                query.append(" select OID_TERR ");
                query.append(" from ZON_TERRI b ");
                query.append(" where  VEPO_OID_VALO_ESTR_GEOP in ( ");
                query.append(" select OID_VALO_ESTR_GEOP ");
                query.append(" from ZON_VALOR_ESTRU_GEOPO a ");
                query.append( armarWhere2(ubigeoArray) + ")" );
                query.append(" and PAIS_OID_PAIS =  " + pais );
          
            try {
               bs = UtilidadesEJB.getBelcorpService();
               DTOSalida dtos = new DTOSalida();
               RecordSet resultado = new RecordSet();
               resultado =  bs.dbService.executeStaticQuery(query.toString());
               dtos.setResultado(resultado);
               UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerTerritoriosdeUBIGEO(Long pais, String ubigeo): Salida");
               return dtos;
            } catch(Exception e) {
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
            }
        }//fin del if que valida el tamano del ubigeo
        else {
          UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerTerritoriosdeUBIGEO(Long pais, String ubigeo): Salida");
       		throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_ESTRUCTURA_GEOPOLITICA));
         }
         
    }

/*Este metodo se encarga de dada una entrada de UBIGEOS con el indicador activo de cada uno de ellos, 
 * realizar el proceso correspondiente para marcar los UBIGEOS recibidos activos o 
 * inactivos segun corresponda.*/
    public void actualizarEstadoUG(DTOUBIGEOS ug) throws MareException {
        UtilidadesLog.info("MONUnidadesGeograficasBean.actualizarEstadoUG(DTOUBIGEOS ug): Entrada");
        
        //reibo en el dto: un string de ubigeos, descripcion, filtroActiva
        DTOUBIGEOS dtoeUGS = new DTOUBIGEOS();
        DTOUBIGEO dtoUG;
        String ubigeoStr;
        Vector dtoVector = new Vector();
        dtoVector =ug.getDtoUbigeoVec();
        BelcorpService bs;
        String[] ubigeoArray = new String[9];
        StringBuffer query; //= new StringBuffer();

        DTOAuditableSICC dtoAuditable = new DTOAuditableSICC();
        dtoAuditable.setIpCliente(ug.getIpCliente());
        dtoAuditable.setPrograma(ug.getPrograma());
        
        for(int j=0; j<dtoVector.size(); j++){
          query = new StringBuffer();
          dtoUG = (DTOUBIGEO) dtoVector.elementAt(j);
          ubigeoStr = dtoUG.getUBIGEO();
          int resto = (ubigeoStr.length() % 6);
          
          if ((ubigeoStr.length() >= 6) && (ubigeoStr.length() <= 54) &&
                (resto == 0)) {
            int a = 0;

            for (int i = 0; i < ubigeoStr.length(); i++) {
                ubigeoArray[a] = ubigeoStr.substring(i, i + 6);
                i = i + 5;
                a = a + 1;
            }
            
       
            if ( ubigeoStr.length()==6 || verificaPadre(ubigeoStr).longValue() > 0 ){
                query.append(" update ZON_VALOR_ESTRU_GEOPO");
                query.append(" set IND_ACTI = " + (dtoUG.getIndicadorActiva().booleanValue()==true?1:0 ) );
                if(!dtoUG.getIndicadorActiva().booleanValue()) 
                   query.append(armarWhere2(ubigeoArray));
                else
                   query.append(armarWhereStr(ubigeoStr));
            }            
        
          
            try {
               bs = UtilidadesEJB.getBelcorpService();
               bs.dbService.executeUpdate(query.toString());
            } catch(Exception e) {
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
            }
        }          
     }
     
     UtilidadesLog.info("MONUnidadesGeograficasBean.actualizarEstadoUG(DTOUBIGEOS ug): Salida");
    }
  //fin metodo


/*metodo privado que obtiene el oid el ubigeo padre segun el ubigeo recibido*/
  private Long verificaPadre(String ubigeoStr) throws MareException{
    UtilidadesLog.info("MONUnidadesGeograficasBean.verificaPadre(String ubigeoStr): Entrada");
    
    int a =0;
    String[] ubigeoArray = new String[9];
    StringBuffer query = new StringBuffer();
    int resto = (ubigeoStr.length() % 6);
    Long nReturnValue;
    BelcorpService bs;

    bs = UtilidadesEJB.getBelcorpService();
    
    for (int i = 0; i < ubigeoStr.length(); i++) {
        ubigeoArray[a] = ubigeoStr.substring(i, i + 6);
        i = i + 5;
        a = a + 1;
    }
    ubigeoArray[a-1] = null;
    
    query.append( " select count(*) " );
    query.append(" from ZON_VALOR_ESTRU_GEOPO   a ");
    query.append( armarWhere2(ubigeoArray) );
    query.append( " and IND_ACTI = 1 " );
    
    RecordSet r;
    try {
         r = bs.dbService.executeStaticQuery(query.toString());
      } catch(Exception ex) 
      {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }

    BigDecimal d = (BigDecimal)r.getValueAt(0, 0);
    nReturnValue = new Long(d.longValue());
    UtilidadesLog.debug("el valor a retornar es " + nReturnValue.toString());
    
    UtilidadesLog.info("MONUnidadesGeograficasBean.verificaPadre(String ubigeoStr): Salida");
    return nReturnValue;
   
  }


//este metodo me devuelve where que pregunta por los parametros no nulos y los nulos!
    private String armarWhereStr(String ubigeo) {
        UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhereStr(String ubigeo): Entrada");
        
        String[] ubigeoArray = new String[9];
        int resto = (ubigeo.length() % 6);

        if((ubigeo.length() >= 6) && (ubigeo.length() <= 54) && (resto == 0) && (ubigeo != null)) {
            int a = 0;

            for(int i = 0; i < ubigeo.length(); i++) {
                ubigeoArray[a] = ubigeo.substring(i, i + 6);
                i = i + 5;
                a = a + 1;
            }

            if(a < 9) {
                for(int i = a; i < 9; i++)
                    ubigeoArray[i] = null;
            }
            StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[] {
									"orde_1", 
									"orde_2",
									"orde_3",
									"orde_4",
									"orde_5",
									"orde_6",
									"orde_7",
									"orde_8",
									"orde_9"};
            
            Object[] valoresWhere = new Object[] {
							ubigeoArray[0],
							ubigeoArray[1],
							ubigeoArray[2],
							ubigeoArray[3],
							ubigeoArray[4],
							ubigeoArray[5],
							ubigeoArray[6],
							ubigeoArray[7], 
							ubigeoArray[8]};
            boolean[] operadores = new boolean[] {false, false, false, false, false, false, false, false, false};
            if(ubigeo.length()>0){
                /*
                 * Armamos where de los campos not null
                 */
                query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadores));

                /*
                 * buscamos el primer orden !=nulo
                 */
                for(int i = 0; i < valoresWhere.length; i++) {
                    if(valoresWhere[i] == null) {
                        query.append(" and " + camposWhere[i] + " is null ");
                        UtilidadesLog.debug("camposWhere[i]   " + i + "  " + camposWhere[i] + " valoresWhere " + valoresWhere.toString());
                    }
                }

            }
            UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhereStr(String ubigeo): Salida");
            return query.toString();
        }//fin del if donde valida tamaño del ubigeo
        else {
                UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhereStr(String ubigeo): Salida");
                return null;
             }
        
    }


    //metodo que arma el where de los ubigeos recibidos
    private String armarWhere2(String[] ubigeoArray) {
    
        UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhere2(String[] ubigeoArray): Entrada");
        
        StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[] {
                "orde_1", "orde_2", "orde_3", "orde_4", "orde_5", "orde_6",
                "orde_7", "orde_8", "orde_9"
            };
        Object[] valoresWhere = new Object[ubigeoArray.length];
        
        for (int i = 0; i < ubigeoArray.length; i++) {
            valoresWhere[i] = ubigeoArray[i];
        }

        boolean[] operadores = new boolean[] {
                false, false, false, false, false, false, false, false, false
            };

        /*
         * Armamos where de los campos not null
         */
        query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere,
                operadores));

        UtilidadesLog.info("MONUnidadesGeograficasBean.armarWhere2(String[] ubigeoArray): Salida");
        return query.toString();
    }

    public void insertarUG(String ubigeo, String nse1, String nse2,
        String desc, String subestructura, Integer nivel, String cp,
        Long oidPais, String ip, String oidPrograma) throws MareException {
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.insertarUG(String ubigeo, String nse1, String nse2, String desc, String subestructura, Integer nivel, String cp, Long oidPais, String ip, String oidPrograma): Entrada");
        
        try {
            EstructuraGeopoliticaLocal estructL;
            Collection registroEGLocal;
            SubestructuraGeopoliticaLocal subestrG;
            Collection registroSGLocal;
            ValoresEstructuraGeopoliticaLocalHome localHomeVal = null;
            DTOAuditableSICC dtoAuditable = new DTOAuditableSICC();
            dtoAuditable.setIpCliente(ip);
            dtoAuditable.setPrograma(oidPrograma);
            
            EstructuraGeopoliticaLocalHome localHome = this.getEstructuraGeopoliticaLocalHome();
            SubestructuraGeopoliticaLocalHome localHomeSubE = this.getSubestructuraGeopoliticaLocalHome();

            UtilidadesLog.debug("************ Llamando a findByPaisNivelEGBorrado");
            registroEGLocal = localHome.findByPaisNivelEGBorrado(oidPais,nivel, Boolean.FALSE);

            Iterator it = registroEGLocal.iterator();
            Long estrGeop = null;
            Long oidSube_geop = null;

            while (it.hasNext()) {
                estructL = (EstructuraGeopoliticaLocal) it.next();
                estrGeop = estructL.getOid();
            }

            Integer subEstr = Integer.valueOf(subestructura);

            UtilidadesLog.debug("************ Llamando a findByEGCod con 'subEstr'= " + 
                subEstr + ", y 'estrGeop'= " + estrGeop);
            registroSGLocal = localHomeSubE.findByEGCod(subEstr, estrGeop);

            Iterator ite = registroSGLocal.iterator();

            
             if(registroSGLocal.size() > 0) {   
                while (ite.hasNext() ) {
                    subestrG = (SubestructuraGeopoliticaLocal) ite.next();
                    oidSube_geop = subestrG.getOid();
                }
             }
             else {
                UtilidadesLog.debug("************ Entro al else se lanza una MareException - NO_EXISTE_ESTRUCTURA_GEOPOLITICA");
                throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_ESTRUCTURA_GEOPOLITICA));
             }
            
            //Long oidSube_geop = registroSGLocal.getOidSubEstructuraGeopoli();
            localHomeVal = this.getValoresEstructuraGeopoliticaLocalHome();

            UtilidadesLog.debug("************ Haciendo el create con:");
            UtilidadesLog.debug("************ ubigeo :" + ubigeo);
            UtilidadesLog.debug("************ nse1 :" + nse1);
            UtilidadesLog.debug("************ nse2 :" + nse2);
            UtilidadesLog.debug("************ desc :" + desc);
            UtilidadesLog.debug("************ oidSube_geop :" + oidSube_geop);
            UtilidadesLog.debug("************ cp :" + cp);
            UtilidadesLog.debug("************ oidPais :" + oidPais);
            UtilidadesLog.debug("************ estrGeop :" + estrGeop);
            
            localHomeVal.create(ubigeo, nse1, nse2, desc, oidSube_geop, cp,
                oidPais, estrGeop);
        }
         catch (NoResultException re) {
            UtilidadesLog.debug("************ Entro al catch - FinderException");
            UtilidadesLog.debug(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException e) {
            UtilidadesLog.debug("************ Entro al catch - CreateException");
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        /*1.- Utilizando el oidPais y el Nivel obtiene la instancia de la entidad EstructuraGeopolitica que corresponde.
         * Se utiliza la función find de findByPaisNivelEGBorrado de la entidad EstructuraGeopolitica,
         * colocando como borrado=FALSE.
        2.- Utilizando el oid de la estructuraGeopolitica obtenida y el codigo de subestructura recibido se obtiene el oid de la subestructura. Se utiliza la función findByEGCod de la entidad SubestructuraGeopolitica.
        3.- Se llama al metodo create de la entidad con los datos recibidos y el oid de la subestructura y estructurageopolitca obtenida:
        create(UBIGEO : String, NSE1 : String, NSE2 : String, NSE3 : String, Desc : String, oidSubestructura : Long, cp : String, oidPais : Long, OidEG : Long)
        */
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.insertarUG(String ubigeo, String nse1, String nse2, String desc, String subestructura, Integer nivel, String cp, Long oidPais, String ip, String oidPrograma): Salida");
    }



/*
 * Esta función recibe un oidPais y un UBIGEO.
 * Deconponiendo el UBIGEO en los codigos de orden_X, para lo cual va tomando grupos de 6 
 * caracteres del UBIGEO hasta haber completado el UBIGEO reicibido. 
   Con esta información y completando los codigos de orden_x faltantes se llama al metodo 
   "findByUbigeo" de la entidad ValoresEstructuraGeopolitca. 
   Al obtener el objeto, setea la propiedad BORRADO=TRUE. 
   Se coloca la FechaAct con la fecha del momento en que se realiza el borrado logico.
 * 
 * */
    public void eliminarUG(Long oidPais, String ubigeo, String ip,
        String oidPrograma) throws MareException {
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.eliminarUG(Long oidPais, String ubigeo, String ip, String oidPrograma): Entrada");
        
        DAOZON daoZon = new DAOZON();
        DTOAuditableSICC dtoAuditable = new DTOAuditableSICC();
        dtoAuditable.setIpCliente(ip);
        dtoAuditable.setPrograma(oidPrograma);

        Long registroUG = daoZon.obtenerUniGeoPorUBIGEO(ubigeo, oidPais);

        if (registroUG != null) {
            try {
                ValoresEstructuraGeopoliticaLocalHome localHome = this.getValoresEstructuraGeopoliticaLocalHome();
                
                ValoresEstructuraGeopoliticaLocal regEstrGeop = localHome.findByPrimaryKey(registroUG);
                regEstrGeop.setInd_borr(new Long(1));
                localHome.merge(regEstrGeop);
                UtilidadesLog.info("MONUnidadesGeograficasBean.eliminarUG(Long oidPais, String ubigeo, String ip, String oidPrograma): Salida");
            } catch (NoResultException e) {
                //Siempre deberia encontrarlo, ya que lo estoy buscan en el obtenerUniGeoPorUBIGEO
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } else {
            UtilidadesLog.info("MONUnidadesGeograficasBean.eliminarUG(Long oidPais, String ubigeo, String ip, String oidPrograma): Salida");
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }

/*incidencia 671*/
    public void calcularNSE(Long codPais, Long codTerritorio) throws MareException {
    
        UtilidadesLog.info("MONUnidadesGeograficasBean.calcularNSE(Long codPais, Long codTerritorio): Entrada");
        
        TerritorioLocal regTerriLocal;
        ValoresEstructuraGeopoliticaLocalHome localHome;
        ValoresEstructuraGeopoliticaLocal local;
        BelcorpService bs;
        
        try {
            TerritorioLocalHome localHomeTerri = this.getTerritorioLocalHome();
            bs = BelcorpService.getInstance();
            regTerriLocal = localHomeTerri.findByPrimaryKey(codTerritorio);
            String[] nseArr = new String[3];
            Long oidUGS;
            Long oidUGI;
            boolean b;
            
            DAOZON dao = new DAOZON();
            DTOLISTUniNSE dtoLis = new DTOLISTUniNSE(); 
            dtoLis = dao.obtenerTerritoriosEnUG(regTerriLocal.getOidValoresEstruGeo());
            CAuxCalculoModas calModa = new CAuxCalculoModas();
            calModa.calcularModaNSE(dtoLis, nseArr);
            localHome = this.getValoresEstructuraGeopoliticaLocalHome();
            local = localHome.findByPrimaryKey(regTerriLocal.getOidValoresEstruGeo());
            local.setCod_nse1(nseArr[0]);
            local.setCod_nse2(nseArr[1]);
            local.setCod_nse3(nseArr[2]);
            localHome.merge(local);
            oidUGS = dao.obtenerUnidadGeoSuperior(regTerriLocal.getOidValoresEstruGeo());
            if(oidUGS != null){

                dtoLis = dao.obtenerUGinferioresaUG(oidUGS);
                calModa.calcularModaNSE(dtoLis, nseArr);
                localHome = this.getValoresEstructuraGeopoliticaLocalHome();
                local = localHome.findByPrimaryKey(oidUGS);
                local.setCod_nse1(nseArr[0]);
                local.setCod_nse2(nseArr[1]);
                local.setCod_nse3(nseArr[2]);
                localHome.merge(local);
                b = true;
            }
            else 
            {   
                b = false;
            }
            
            while(b){
                oidUGS = dao.obtenerUnidadGeoSuperior(oidUGS);
                if(oidUGS != null){
                    dtoLis = dao.obtenerUGinferioresaUG(oidUGS);
                    calModa.calcularModaNSE(dtoLis, nseArr);
                    localHome = this.getValoresEstructuraGeopoliticaLocalHome();
                    local = localHome.findByPrimaryKey(oidUGS);
                    local.setCod_nse1(nseArr[0]);
                    local.setCod_nse2(nseArr[1]);
                    local.setCod_nse3(nseArr[2]);
                    localHome.merge(local);
                    b = true;
                }
                else 
                {   
                    b = false;
                }   
            }//fin del while            
            
        } catch (NoResultException re) {
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
            
                  
        UtilidadesLog.info("MONUnidadesGeograficasBean.calcularNSE(Long codPais, Long codTerritorio): Salida");
    }

    //    
    public Boolean validarNivelUBIGEO(Integer nivel, String ubigeo)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesGeograficasBean.validarNivelUBIGEO(Integer nivel, String ubigeo): Entrada");
        
        Boolean valor = Boolean.FALSE;

        try {
            String ubigeoStr = ubigeo;
            String[] ubigeoArray = new String[9];
            int largoStr = ubigeoStr.length();
            int resto = (ubigeoStr.length() % 6);

            if ((ubigeoStr.length() >= 6) && (ubigeoStr.length() <= 54) &&
                    (resto == 0) && (ubigeoStr != null)) {
                int a = 0;

                for (int i = 0; i < ubigeoStr.length(); i++) {
                    ubigeoArray[a] = ubigeoStr.substring(i, i + 6);
                    i = i + 5;
                    a = a + 1;
                }

                //comparo si el nivel a es menor= al nivel recibido por parametro
                if (a <= nivel.intValue()) {
                    valor = Boolean.TRUE;
                } else {
                    valor = Boolean.FALSE;
                }
            }
        } //fin try
        catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONUnidadesGeograficasBean.validarNivelUBIGEO(Integer nivel, String ubigeo): Salida");
        return valor;
    }
     //fin del metodo

    //metodo para realizar una sentencia sql a traves de dbService
    private BelcorpService getBelcorpService() throws MareException {
        UtilidadesLog.info("MONUnidadesGeograficasBean.getBelcorpService(): Entrada");
        
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
        UtilidadesLog.info("MONUnidadesGeograficasBean.getBelcorpService(): Salida");
        return bs;
    }

    public String obtenerDescripcionUBIGEO(Long valEstructuraGeopolitica) throws MareException {
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerDescripcionUBIGEO(Long valEstructuraGeopolitica): Entrada");
        
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();

            ValoresEstructuraGeopoliticaLocalHome localHome = this.getValoresEstructuraGeopoliticaLocalHome();
            ValoresEstructuraGeopoliticaLocal registroUG = localHome.findByPrimaryKey(valEstructuraGeopolitica);
            
            String ubigeoStr = new String();
            String[] ubigeoArr = new String[] {
                    registroUG.getOrde_1(), registroUG.getOrde_2(),
                    registroUG.getOrde_3(), registroUG.getOrde_4(),
                    registroUG.getOrde_5(), registroUG.getOrde_6(),
                    registroUG.getOrde_7(), registroUG.getOrde_8(),
                    registroUG.getOrde_9()
                };
            int nivel = 0;
                
            for (int i = 0; i < ubigeoArr.length; i++) {
                if (ubigeoArr[i] != null) {
                    ubigeoStr = ubigeoStr + ubigeoArr[i];
                    nivel = i + 1;
                }
                //break;
            }
           UtilidadesLog.debug("ubigeoStr   " + ubigeoStr);
            //inserta en el vector el primer ubigeo
           
            String descripcion = registroUG.getDes_geog();
            Long pais = registroUG.getPais_oid_pais();
            
             //deberia devolver la descripcion separada por comas   
            for (int i =ubigeoStr.length()-6; i >= 6; i--) {
                     
                ubigeoStr= ubigeoStr.substring(0, i);
                //buscar el oid de valoresEstructuraGeopolitica a traves de DAOZON
                DAOZON daoZon = new DAOZON();
                Long oidUG = daoZon.obtenerUniGeoPorUBIGEO(ubigeoStr, pais );
                    
                if (oidUG != null) {
                    try{
                        registroUG = localHome.findByPrimaryKey(oidUG);
                        descripcion = registroUG.getDes_geog() + ',' + descripcion;
                    }
                    catch (NoResultException re) {
                        throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                        
                }//fin if oidUG != null
                i=i-5;
            }//fin del for
            
            UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerDescripcionUBIGEO(Long valEstructuraGeopolitica): Salida");
            return descripcion;
                  
        } catch (NoResultException re) {           
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
    }

    public DTOSubEstructura obtenerSubestructuraUG(Long oidPais, Long oidTerritorio, Long idIdioma) throws MareException {
    
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerSubestructuraUG(Long oidPais, Long oidTerritorio, Long idIdioma): Entrada");
        
        RecordSet rs = null;
        DTOSubEstructura dtoSubEstructura = new DTOSubEstructura();
        
        StringBuffer query = new StringBuffer();

        String codigoError;
        TerritorioLocalHome territorioLH = this.getTerritorioLocalHome();
        ValoresEstructuraGeopoliticaLocalHome valoresEstrucGeopLH = this.getValoresEstructuraGeopoliticaLocalHome();
        SubestructuraGeopoliticaLocalHome subEstructLH = this.getSubestructuraGeopoliticaLocalHome();

        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
            
            TerritorioLocal territorioLocal = territorioLH.findByPrimaryKey(oidTerritorio);
            ValoresEstructuraGeopoliticaLocal valoresEstructuraGeopoliticaLocal = null;
            SubestructuraGeopoliticaLocal subestructuraGeopoliticaLocal = null;

            valoresEstructuraGeopoliticaLocal = valoresEstrucGeopLH.findByPrimaryKey(territorioLocal.getOidValoresEstruGeo());
            subestructuraGeopoliticaLocal = subEstructLH.findByPrimaryKey(valoresEstructuraGeopoliticaLocal.getSubEstruGeopo());

            // Para internacionalizar el atributo descripción de la tabla
            query.append(   "SELECT VAL_I18N FROM v_gen_i18n_sicc WHERE " + 
                            " ATTR_ENTI = 'ZON_SUBES_GEOPO' AND ATTR_NUM_ATRI = 1 " + 
                            " AND IDIO_OID_IDIO = " + idIdioma +
                            " AND VAL_OID = " + subestructuraGeopoliticaLocal.getOid() );

            rs = bs.dbService.executeStaticQuery(query.toString());

            String descripcion = (String) rs.getValueAt(0,"VAL_I18N");

            dtoSubEstructura.setCod(subestructuraGeopoliticaLocal.getCodigo());
            dtoSubEstructura.setOid(subestructuraGeopoliticaLocal.getOid());
            dtoSubEstructura.setDesc(descripcion);
            
        } catch (NoResultException re) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            UtilidadesLog.debug(e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerSubestructuraUG(Long oidPais, Long oidTerritorio, Long idIdioma): Salida");
        return dtoSubEstructura;
    }

    public Long obtenerOidUBIGEO(Long oidPais, String ubigeo) throws MareException {
    
        UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerOidUBIGEO(Long oidPais, String ubigeo): Entrada");
        
        Long oid = null;
        if (validaRangoUbigeo(ubigeo)){
            DAOZON dao = new DAOZON();
            oid = dao.obtenerUniGeoPorUBIGEO(ubigeo, oidPais);
            if (oid == null) {
                UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerOidUBIGEO(Long oidPais, String ubigeo): Salida");
                return null;  
            }
            try{
                ValoresEstructuraGeopoliticaLocalHome valoresEstrucGeopLH = this.getValoresEstructuraGeopoliticaLocalHome();
                ValoresEstructuraGeopoliticaLocal vegp = valoresEstrucGeopLH.findByPrimaryKey(oid);
                if (vegp.getInd_borr().longValue()==0L &&
                    vegp.getInd_acti().longValue()==1L){
                    UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerOidUBIGEO(Long oidPais, String ubigeo): Salida");
                    return vegp.getOid();
                }else{
                    UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerOidUBIGEO(Long oidPais, String ubigeo): Salida");
                    return null;
                }                
            }catch(NoResultException e){
                UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerOidUBIGEO(Long oidPais, String ubigeo): Salida");
                return null;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else {
            UtilidadesLog.info("MONUnidadesGeograficasBean.obtenerOidUBIGEO(Long oidPais, String ubigeo): Salida");
            return null;
        }
    }

    private boolean validaRangoUbigeo(String ubigeo){
        UtilidadesLog.info("MONUnidadesGeograficasBean.validaRangoUbigeo(String ubigeo): Entrada");
        
        int largo = ubigeo.length();
        if (largo<6 || largo>56){
            UtilidadesLog.info("MONUnidadesGeograficasBean.validaRangoUbigeo(String ubigeo): Salida");
            return false;
        }
        if ((largo%6)!=0){
            UtilidadesLog.info("MONUnidadesGeograficasBean.validaRangoUbigeo(String ubigeo): Salida");
            return false;
        }
        UtilidadesLog.info("MONUnidadesGeograficasBean.validaRangoUbigeo(String ubigeo): Salida");
        return true;
    }

    private ValoresEstructuraGeopoliticaLocalHome getValoresEstructuraGeopoliticaLocalHome() {
        return new ValoresEstructuraGeopoliticaLocalHome();
    }
    
    private TerritorioLocalHome getTerritorioLocalHome() {
        return new TerritorioLocalHome();
    }

    private SubestructuraGeopoliticaLocalHome getSubestructuraGeopoliticaLocalHome() {
        return new SubestructuraGeopoliticaLocalHome();
    }

    private EstructuraGeopoliticaLocalHome getEstructuraGeopoliticaLocalHome() {
        return new EstructuraGeopoliticaLocalHome();
    }

    
}


 //fin clase
