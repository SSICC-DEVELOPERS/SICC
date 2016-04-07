package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
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

public class DAONivelRiesgo {
    public DAONivelRiesgo() {
    }
    
    public Vector query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {UtilidadesLog.info("DAOCarNivelRiesgo.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
       
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
       
           query.append(" SELECT c.OID_NIVE_RIES, c.COD_NIVE_RIES, b.VAL_I18N ");
           query.append(" FROM CAR_NIVEL_RIESG c, GEN_I18N_SICC_COMUN b ");
           query.append(" WHERE   b.attr_enti = 'CAR_NIVEL_RIESG'");
           query.append(" AND b.attr_num_atri = 1 ");
           query.append(" AND b.idio_oid_idio = 1");
           query.append(" AND b.val_oid = c.OID_NIVE_RIES");
           
            if(carNivelRiesgFrom.getId()!= null){
               query.append(" AND c.OID_NIVE_RIES = " + carNivelRiesgFrom.getId());
           }
            if(carNivelRiesgFrom.getCodNiveRies()!= null){
               query.append(" AND c.COD_NIVE_RIES like '" + carNivelRiesgFrom.getCodNiveRies() + "'");
           }
         
           if(carNivelRiesgFrom.getDescripcion()!= null){
               query.append(" AND b.VAL_I18N like '" + carNivelRiesgFrom.getDescripcion() + "'");
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
           
           CarNivelRiesgData carNivelRiesgo = null;
           
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
                     carNivelRiesgo= new CarNivelRiesgData();
                     
                     carNivelRiesgo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_NIVE_RIES")).toString())); 
                     carNivelRiesgo.setCodNiveRies((String)rs.getValueAt(i,"COD_NIVE_RIES"));
                     carNivelRiesgo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                                      
                     result.add(carNivelRiesgo);
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
           
                
       }
       UtilidadesLog.info("DAOCarNivelRiesgo.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
          return result;
       }
      
      
      public Hashtable guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, Vector localizationLabels, HashMap userProperties) throws MareException
       {UtilidadesLog.info("DAOCarNivelRiesgo.guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, Vector localizationLabels, HashMap userProperties): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT CAR_NIRE_SEQ.NEXTVAL FROM DUAL");         
           
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
         update.append(" INSERT INTO CAR_NIVEL_RIESG ( ");
         update.append(" OID_NIVE_RIES, ");
         update.append(" COD_NIVE_RIES ");
         update.append(" ) VALUES ( ");
         update.append(id + ", ");
         update.append(" '" + carNivelRiesg.getCodNiveRies() + "' ");
               
         update.append(" ) ");
         
         
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
               updateInter.append(" 'CAR_NIVEL_RIESG', ");
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
       
           UtilidadesLog.info("DAOCarNivelRiesgo.guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, Vector localizationLabels, HashMap userProperties): Salida");
           return primaryKey;
       }
       
       public void remove(Vector entities) throws MareException
       {
       
       UtilidadesLog.info("DAOCarNivelRiesgo.remove(Vector entities): Entrada ");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           CarNivelRiesgData carNivelRiesgo = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               carNivelRiesgo = (CarNivelRiesgData)entities.get(j);
                
               oids = oids + "," + carNivelRiesgo.getId();
           }
           
           update.append("delete CAR_NIVEL_RIESG ");
           update.append("where OID_NIVE_RIES in ( " + oids.substring(1) + ") ");
           
           updateInter.append("delete GEN_I18N_SICC_COMUN ");
           updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'CAR_NIVEL_RIESG' ");
           
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
           
           UtilidadesLog.info("DAOCarNivelRiesgo.remove(Vector entities): Salida ");
       }
       
       public void update(CarNivelRiesgData carNivelRiesg, Vector localizationLabels) throws MareException
       {
       UtilidadesLog.info("DAOCarNivelRiesgo.update(CarNivelRiesgData carNivelRiesg, Vector localizationLabels):Entrada ");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           // Borrar los registros internalizacion
           StringBuffer deleteInter = new StringBuffer();
           
           deleteInter.append("delete GEN_I18N_SICC_COMUN ");
           deleteInter.append(" where VAL_OID = " + carNivelRiesg.getId());
           deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
           deleteInter.append(" and ATTR_ENTI = 'CAR_NIVEL_RIESG' ");
           
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
               updateInter.append(" 'CAR_NIVEL_RIESG', ");
               updateInter.append(" 1, ");            
               updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
               updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
               updateInter.append(carNivelRiesg.getId() + " )");   
           
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
           }
           StringBuffer update = new StringBuffer();
           
           update.append("UPDATE CAR_NIVEL_RIESG SET ");
           update.append(" COD_NIVE_RIES = '" + carNivelRiesg.getCodNiveRies()+ "'");
           update.append(" WHERE OID_NIVE_RIES = " + carNivelRiesg.getId());   
           
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
           UtilidadesLog.info("DAOCarNivelRiesgo.update(CarNivelRiesgData carNivelRiesg, Vector localizationLabels):Salida ");
       }
    }
       
    

