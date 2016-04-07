package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarParamEvaluNrData;
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

public class DAOParametrosEvaluacionNr {
    public DAOParametrosEvaluacionNr() {
    }
    
    public Vector query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {   UtilidadesLog.info("DAOCarParamEvaluNR.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
       
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
           
           query.append(" SELECT OID_PARA_EVAL_NR, COD_PARA, DES_PARA, VAL_PESO");
           query.append(" FROM CAR_PARAM_EVALU_NR ");
           query.append(" WHERE 1 = 1");
           
            if(carParamEvaluNrFrom.getId()!= null){
               query.append(" AND OID_PARA_EVAL_NR = " + carParamEvaluNrFrom.getId());
           }
           
           if(carParamEvaluNrFrom.getCodPara() != null){
               query.append(" AND COD_PARA like '" + carParamEvaluNrFrom.getCodPara() + "'");
           }
           if(carParamEvaluNrFrom.getValPeso()!=null)
           {
               query.append(" AND VAL_PESO = " + carParamEvaluNrFrom.getValPeso());
           }
           if(carParamEvaluNrFrom.getDesPara()!= null){
           
               query.append(" AND DES_PARA like '" + carParamEvaluNrFrom.getDesPara() + "'");
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
           
           CarParamEvaluNrData carParamEvalu = null;
           
           
           
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
                     carParamEvalu = new CarParamEvaluNrData();
                    
                     
                    
                    
                     carParamEvalu.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA_EVAL_NR")).toString())); 
                     carParamEvalu.setCodPara((String)rs.getValueAt(i,"COD_PARA"));
                     carParamEvalu.setDesPara((String)rs.getValueAt(i,"DES_PARA"));
                     carParamEvalu.setValPeso(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PESO")).toString()));
                           
                     result.add(carParamEvalu);
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
           }
         
           UtilidadesLog.info("DAOCarParamEvaluNR.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
         return result;
           
             
           
       }
       
        public Hashtable guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels, HashMap userProperties) throws MareException
       {   
       UtilidadesLog.info("DAOCarParamEvaluNR.guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels, HashMap userProperties): Entrada");
           
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT CAR_PENR_SEQ.NEXTVAL FROM DUAL");         
           
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
           
                   
         update.append(" INSERT INTO CAR_PARAM_EVALU_NR ( ");
         update.append(" OID_PARA_EVAL_NR, ");
         update.append(" COD_PARA, ");
         update.append(" DES_PARA,");
         update.append(" VAL_PESO ");
         update.append(" ) VALUES ( ");
         update.append(id + ", ");
         update.append("'" + carParamEvaluNr.getCodPara() + "', ");
         update.append("'" + carParamEvaluNr.getDesPara() + "', ");
         update.append(carParamEvaluNr.getValPeso());
         
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
         UtilidadesLog.info("DAOCarParamEvaluNR.guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels, HashMap userProperties):Salida");
         
         return primaryKey;
       }
       
         
       
       
       public void remove(Vector entities) throws MareException
       { 
           UtilidadesLog.info("DAOCarParamEvaluNR.remove(Vector entities): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           //StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           CarParamEvaluNrData carParamEvalu = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               carParamEvalu = (CarParamEvaluNrData)entities.get(j);
                
               oids = oids + "," + carParamEvalu.getId();
           }
           
           update.append("delete CAR_PARAM_EVALU_NR ");
           update.append("where OID_PARA_EVAL_NR in ( " + oids.substring(1) + ") ");
           
                  
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
           UtilidadesLog.info("DAOCarCondiEvalNR.remove(Vector entities): Salida");
    }

       public void update(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels) throws MareException
       {   UtilidadesLog.info("DAOCarParamEvaluNR.update(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels): Entrada");
       
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
                   
           update.append(" UPDATE  CAR_PARAM_EVALU_NR SET ");
           update.append(" DES_PARA = '" + carParamEvaluNr.getDesPara()+ "',");
           update.append(" VAL_PESO = " + carParamEvaluNr.getValPeso());
           update.append(" WHERE OID_PARA_EVAL_NR =" + carParamEvaluNr.getId());
           
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
         UtilidadesLog.info("DAOCarParamEvaluNR.update(CarParamEvaluNrData carParamEvaluNr, Vector localizationLabels): Salida");
         
       }
       
       }
       

    
