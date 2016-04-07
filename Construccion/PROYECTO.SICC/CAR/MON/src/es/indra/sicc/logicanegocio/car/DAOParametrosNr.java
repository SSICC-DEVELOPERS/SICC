package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
import es.indra.belcorp.mso.CarParamNrData;

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

public class DAOParametrosNr {
    public DAOParametrosNr() {
    }
    
    public Vector query(CarParamNrData carParamNrFrom, CarParamNrData carParamNrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {   UtilidadesLog.info("DAOParametrosNr.query(CarParamNrData carParamNrFrom, CarParamNrData carParamNrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");   
       
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
       
           query.append(" SELECT b.oid_nive_ries, c.val_i18n, a.oid_para_nr, a.val_maxi, a.val_mini, b.COD_NIVE_RIES ");
           query.append(" FROM car_param_nr a, car_nivel_riesg b, gen_i18n_sicc_comun c ");
           query.append(" WHERE c.attr_enti = 'CAR_NIVEL_RIESG'");
           query.append(" AND c.attr_num_atri = 1 ");
           query.append(" AND c.idio_oid_idio = 1");
           query.append(" AND c.val_oid = b.oid_nive_ries");
           query.append(" AND a.niri_oid_nive_ries = b.oid_nive_ries");
           
            if(carParamNrFrom.getId()!= null){
               query.append(" AND OID_PARA_NR = " + carParamNrFrom.getId());
           }
            if(carParamNrFrom.getValMini()!= null){
               query.append(" AND VAL_MINI = " + carParamNrFrom.getValMini());
           }
           if(carParamNrFrom.getValMaxi()!= null)
           {
               query.append(" AND VAL_MAXI = " + carParamNrFrom.getValMaxi() );
           }
         
           if(carParamNrFrom.getNiriOidNiveRies()!= null){
               query.append(" AND OID_NIVE_RIES = " + carParamNrFrom.getNiriOidNiveRies().getId());
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
           CarParamNrData carParamNr = null;
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
               
                     carParamNr = new CarParamNrData();
                     carNivelRiesgo= new CarNivelRiesgData();
                     BigDecimal valMaxi = null;
                     
                     carNivelRiesgo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_NIVE_RIES")).toString())); 
                     carNivelRiesgo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     carNivelRiesgo.setCodNiveRies((String)rs.getValueAt(i,"COD_NIVE_RIES"));
                     carParamNr.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA_NR")).toString()));
                     valMaxi = (BigDecimal)rs.getValueAt(i,"VAL_MAXI");
                       if(valMaxi != null){
                           
                           carParamNr.setValMaxi(Double.valueOf(valMaxi.toString()));
                       }
                                       
                     carParamNr.setValMini(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_MINI")).toString()));
                     carParamNr.setNiriOidNiveRies(carNivelRiesgo);
                                      
                     result.add(carParamNr);
                     
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
               
       }
       
       UtilidadesLog.info("DAOParametrosNr.query(CarParamNrData carParamNrFrom, CarParamNrData carParamNrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");   
           return result;
       }
       public Hashtable guardarParamNr(CarParamNrData carParamNr, Vector localizationLabels, HashMap userProperties) throws MareException
       {   UtilidadesLog.info("DAOParametrosNr.guardarParamNr(CarParamNrData carParamNr, Vector localizationLabels, HashMap userProperties):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT CAR_PANR_SEQ.NEXTVAL FROM DUAL");         
           
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
         update.append(" INSERT INTO CAR_PARAM_NR ( ");
         update.append(" OID_PARA_NR, ");
         update.append(" NIRI_OID_NIVE_RIES, ");
         update.append(" VAL_MINI, ");
         update.append(" VAL_MAXI ");
         update.append(" ) VALUES ( ");
         update.append(id + ", ");
         update.append(carParamNr.getNiriOidNiveRies().getId() + ", ");
         update.append(carParamNr.getValMini() + "," );
          
         if(carParamNr.getValMaxi()!= null)
           {
             update.append(carParamNr.getValMaxi());
           }
            else 
               {update.append(" NULL" );}      
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
           
            
           Hashtable primaryKey = new Hashtable();
           primaryKey.put("id", id);     
       
           UtilidadesLog.info("DAOParametrosNr.guardarParamNr(CarParamNrData carParamNr, Vector localizationLabels, HashMap userProperties):SAlida");
           return primaryKey;
       }
           
            public void remove(Vector entities) throws MareException
       {   UtilidadesLog.info("DAOParametrosNr.remove(Vector entities):Entrada");
       
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           //StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           CarParamNrData carParam = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               carParam = (CarParamNrData)entities.get(j);
                
               oids = oids + "," + carParam.getId();
           }
           
           update.append("delete CAR_PARAM_NR ");
           update.append("where OID_PARA_NR in ( " + oids.substring(1) + ") ");
           
                  
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
              
               
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
           
       
           UtilidadesLog.info("DAOParametrosNr.remove(Vector entities):Salida");
       }
       public void update(CarParamNrData carParamNr, Vector localizationLabels) throws MareException
       {   UtilidadesLog.info("DAOParametrosNr.update(CarParamNrData carParamNr, Vector localizationLabels):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
                   
           update.append(" UPDATE  CAR_PARAM_NR SET ");
           update.append(" VAL_MINI = " + carParamNr.getValMini()+ ",");
           
           if(carParamNr.getValMaxi()!= null){
               update.append(" VAL_MAXI = " + carParamNr.getValMaxi());
           }
           else
              { update.append(" VAL_MAXI = NULL");}
           
           update.append(" WHERE OID_PARA_NR =" + carParamNr.getId());
           
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
           UtilidadesLog.info("DAOParametrosNr.update(CarParamNrData carParamNr, Vector localizationLabels):Salida");
       }
       
 }
       

    
