package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarCodigAprobData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOCodigosAprobacion {
    public DAOCodigosAprobacion() {
    }
    
    public Vector query(CarCodigAprobData carCodigAprobFrom, CarCodigAprobData carCodigAprobTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {UtilidadesLog.info("DAODAOCarCodigoAprobacion.query(CarCodigAprobData carCodigAprobFrom, CarCodigAprobData carCodigAprobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        
          if(pageCount == null)
            {
                pageCount = new Integer(1);
            }
            if(pageSize == null)
            {
                pageSize = new Integer(0x7fffffff);
            }
            
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
        
            try {
              bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            try{
            query.append(" SELECT a.OID_CODI_APRO, a.COD_APRO, v.VAL_I18N ");
            query.append(" FROM CAR_CODIG_APROB a, V_GEN_I18N_SICC v ");
            query.append(" WHERE v.attr_enti = 'CAR_CODIG_APROB'");
            query.append(" AND v.attr_num_atri = 1");
            query.append(" AND v.idio_oid_idio = 1");
            query.append(" AND v.val_oid = a.oid_codi_apro");
            
            if(carCodigAprobFrom.getCodApro()!= null){
                query.append(" AND a.COD_APRO like '" + carCodigAprobFrom.getCodApro() + "' ");
            }
            
            if(carCodigAprobFrom.getId()!= null){
                query.append(" AND a.OID_CODI_APRO = " + carCodigAprobFrom.getId());
            }
            
            if(carCodigAprobFrom.getDescripcion()!= null){
                query.append(" and v.VAL_I18N like '" + carCodigAprobFrom.getDescripcion() + "' ");
            }
            }catch(Exception ex)
            {
              ex.printStackTrace();
            }
          try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            
            int cant = rs.getRowCount();
            Vector result = new Vector();
            
            CarCodigAprobData carCodigAprobData = null;
            
            
            int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
            int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
            
            UtilidadesLog.debug("rsSaltar: " + rsSaltar);
            UtilidadesLog.debug("rsMostrar: " + rsMostrar);
            
            for(int i=0; i < cant; i++){
            
                if(i < rsSaltar ) {
                    continue;
                }
                
                if(i < rsMostrar){
                try{
                      carCodigAprobData = new CarCodigAprobData();
                       
                      carCodigAprobData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CODI_APRO")).toString())); 
                      carCodigAprobData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      carCodigAprobData.setCodApro((String)rs.getValueAt(i,"COD_APRO"));
                      
                      
                      result.add(carCodigAprobData);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
                UtilidadesLog.info("DAOCarCodigoAprobacion.query(CarCodigAprobData carCodigAprobFrom, CarCodigAprobData carCodigAprobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida ");
            
        }
        return result;
    }
        public void update(CarCodigAprobData carCodigAprob, Vector localizationLabels) throws MareException
        {UtilidadesLog.info("DAOCarCodigoAprobacion.update(CarCodigAprobData carCodigAprob, Vector localizationLabels):Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            // Borrar los registros internalizacion
            StringBuffer deleteInter = new StringBuffer();
            
            deleteInter.append("delete GEN_I18N_SICC_COMUN ");
            deleteInter.append(" where VAL_OID = " + carCodigAprob.getId());
            deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
            deleteInter.append(" and ATTR_ENTI = 'CAR_CODIG_APROB' ");
            
            try {
                int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
            } catch (Exception ex) {
                ex.printStackTrace();            
               
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
            }
            
            
            int cant = localizationLabels.size();
            GenDetaSiccData genDetaSiccData = null;
            RecordSet rsPKInter = null;
            StringBuffer queryInter = null;
            Long idInter = null;      
            StringBuffer updateInter = null;
            
            for(int i= 0; i< cant; i++){                      
               
                genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
            
                queryInter = new StringBuffer();             
                queryInter.append(" SELECT GEN_I18C_SEQ.NEXTVAL FROM DUAL");         
                
                try {
                    rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                        
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                if(rsPKInter != null && !rsPKInter.esVacio()) {
                    idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
                }      
                
                updateInter = new StringBuffer();    
                 
                updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
                updateInter.append("OID_I18N, "); 
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(idInter + ", ");
                updateInter.append(" 'CAR_CODIG_APROB', ");
                updateInter.append(" 1, ");            
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(carCodigAprob.getId() + " )");   
                try {
                        int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                        
                } catch (Exception ex) {
                    ex.printStackTrace();
                    
                    if(ex.toString().indexOf("ORA-00001")!= -1) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } else {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
               
            }
             UtilidadesLog.info("DAOCarCodigoAprobacion.update(CarCodigAprobData carCodigAprob, Vector localizationLabels):Salida ");
        }
           
           public void remove(Vector entities) throws MareException
           {UtilidadesLog.info("DAOCarCodigoAprobacion.remove(Vector entities): Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant = entities.size();
            CarCodigAprobData carCodigAprobData = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                carCodigAprobData = (CarCodigAprobData)entities.get(j);
                 
                oids = oids + "," + carCodigAprobData.getId();
            }
            
            update.append("delete CAR_CODIG_APROB ");
            update.append("where OID_CODI_APRO in ( " + oids.substring(1) + ") ");
            
            updateInter.append("delete GEN_I18N_SICC_COMUN ");
            updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'CAR_CODIG_APROB' ");
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                int cantRegActualizados1 = bs.dbService.executeUpdate(updateInter.toString());
                
            } catch (Exception ex) {
                ex.printStackTrace();
                
                if(ex.toString().indexOf("ORA-02292")!= -1) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                } else {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }            
            }
            
            UtilidadesLog.info("DAOCarCodigoAprobacion.remove(Vector entities): Salida ");
        }
        
          public Hashtable guardarCarCoAp(CarCodigAprobData carCodigAprob, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCarCodigoAprobacion.guardarCarCoAp(CarCodigAprobData carCodigAprob, Vector localizationLabels, HashMap userProperties):Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();        
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT CAR_COAP_SEQ.NEXTVAL FROM DUAL");         
            
            try {
                rsPK = bs.dbService.executeStaticQuery(query.toString());
                    
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            if(rsPK != null && !rsPK.esVacio()) {
                id = Long.valueOf(((BigDecimal)rsPK.getValueAt(0,0)).toString());
            }        
            
            update.append(" INSERT INTO car_codig_aprob ( ");
            update.append("OID_CODI_APRO, "); 
            update.append("COD_APRO "); 
            update.append(") VALUES (");
            update.append(id + ", ");
            update.append("'" + carCodigAprob.getCodApro() + "'");
            
            update.append(") ");
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                
                if(ex.toString().indexOf("ORA-00001")!= -1) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } else {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            
            // Internacionalización
            int cant = localizationLabels.size();
            GenDetaSiccData genDetaSiccData = null;
            RecordSet rsPKInter = null;
            StringBuffer queryInter = null;
            Long idInter = null;        
            StringBuffer updateInter = null;
            
            for(int i= 0; i< cant; i++){
                          
                queryInter = new StringBuffer();             
                queryInter.append(" SELECT GEN_I18C_SEQ.NEXTVAL FROM DUAL");         
                
                try {
                    rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                        
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                if(rsPKInter != null && !rsPKInter.esVacio()) {
                    idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
                }      
                
                genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
                updateInter = new StringBuffer();    
                    
                updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
                updateInter.append("OID_I18N, "); 
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(idInter + ", ");
                updateInter.append(" 'CAR_CODIG_APROB', ");
                updateInter.append(" 1, ");            
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(id + " )");    
                    
                try {
                    int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    
                    if(ex.toString().indexOf("ORA-00001")!= -1) {
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    } else {
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
            }
            
            Hashtable primaryKey = new Hashtable();
            primaryKey.put("id", id);     
        
            UtilidadesLog.info("DAOCarCodigoAprobacion.guardarCarCoAp(CarCodigAprobData carCodigAprob, Vector localizationLabels, HashMap userProperties):Salida ");
            return primaryKey;
        }
            
 }      
       
           
      


    
    
    

