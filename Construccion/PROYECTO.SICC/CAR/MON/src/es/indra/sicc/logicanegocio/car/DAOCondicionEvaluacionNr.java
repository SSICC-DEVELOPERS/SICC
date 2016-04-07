package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarCondiEvaluNrData;
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

public class DAOCondicionEvaluacionNr {
    public DAOCondicionEvaluacionNr() {
    }
    
    public Vector query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties) throws MareException
        {
        UtilidadesLog.info("DAOCondicionEvaluacionNr.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties ): Entrada");
          
          RecordSet rs = new RecordSet();
          StringBuffer query = new StringBuffer();
          BelcorpService bs;
          Vector resultado = new Vector();
            
        try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT c.oid_para_eval_nr, c.des_para  ");
        query.append(" FROM car_param_evalu_nr c  ");
        
        
        
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        
         CarParamEvaluNrData carParamEvaluNr = null;
          
          for(int i=0; i < cant; i++){
             
              carParamEvaluNr = new CarParamEvaluNrData();
              
              carParamEvaluNr.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_PARA_EVAL_NR")).toString()));
              carParamEvaluNr.setDesPara((String)rs.getValueAt(i,"DES_PARA"));
             
              
              resultado.add(carParamEvaluNr);
          }
          
          UtilidadesLog.info("DAOCondicionEvaluacionNr.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties): Salida");
          
        return resultado;
        }

         public Vector query(CarCondiEvaluNrData carCondiEvaluNrFrom, CarCondiEvaluNrData carCondiEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {UtilidadesLog.info("DAOCondicionEvaluacionNr.query(CarCondiEvaluNrData carCondiEvaluNrFrom, CarCondiEvaluNrData carCondiEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
        
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
        
            query.append(" SELECT c.oid_para_eval_nr, c.des_para, a.oid_cond_eval_nr, a.val_mini, ");
            query.append(" a.val_maxi, a.val_esca_mini ");
            query.append(" FROM car_condi_evalu_nr a, car_param_evalu_nr c ");
            query.append(" WHERE a.penr_oid_para_eval_nr = c.oid_para_eval_nr ");
            
            
            
             if(carCondiEvaluNrFrom.getId()!= null){
                query.append(" AND a.OID_COND_EVAL_NR = " + carCondiEvaluNrFrom.getId());
            }
             if(carCondiEvaluNrFrom.getPenrOidParaEvalNr()!= null){
                query.append(" AND c.OID_PARA_EVAL_NR = " + carCondiEvaluNrFrom.getPenrOidParaEvalNr().getId());
            }
          
            if(carCondiEvaluNrFrom.getValEscaMini()!= null){
                query.append(" AND a.VAL_ESCA_MINI = " + carCondiEvaluNrFrom.getValEscaMini());
            }
            
            if(carCondiEvaluNrFrom.getValMaxi()!= null){
                query.append(" and a.VAL_MAXI = " + carCondiEvaluNrFrom.getValMaxi());
            }
                    
            if(carCondiEvaluNrFrom.getValMini()!= null){
                query.append(" and a.VAL_MINI = " + carCondiEvaluNrFrom.getValMini());
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
            
            CarCondiEvaluNrData carCondiEvaluData = null;
            CarParamEvaluNrData carParamEvaluNrData = null;
            
            
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
                      carCondiEvaluData = new CarCondiEvaluNrData();
                      carParamEvaluNrData = new CarParamEvaluNrData();
                      BigDecimal valMaxi = null;
                     
                     
                      carCondiEvaluData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_COND_EVAL_NR")).toString())); 
                      carCondiEvaluData.setValEscaMini(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_ESCA_MINI")).toString()));
                      valMaxi = (BigDecimal)rs.getValueAt(i,"VAL_MAXI");
                        if(valMaxi != null){
                            
                            carCondiEvaluData.setValMaxi(Double.valueOf(valMaxi.toString()));
                        }
                      carCondiEvaluData.setValMini(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_MINI")).toString()));  
                      carParamEvaluNrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA_EVAL_NR")).toString()));
                      carParamEvaluNrData.setDesPara((String)rs.getValueAt(i,"DES_PARA"));
                      carCondiEvaluData.setPenrOidParaEvalNr(carParamEvaluNrData);
                                        
                      result.add(carCondiEvaluData);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
          
          UtilidadesLog.info("DAOCondicionEvaluacionNr.query(CarCondiEvaluNrData carCondiEvaluNrFrom, CarCondiEvaluNrData carCondiEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida");
          return result;
            
        }
           
       public Hashtable guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels, HashMap userProperties) throws MareException
        {UtilidadesLog.info("DAOCondicionEvaluacionNr.guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels, HashMap userProperties ): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT CAR_CENR_SEQ.NEXTVAL FROM DUAL");         
            
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
            
                    
          update.append(" INSERT INTO CAR_CONDI_EVALU_NR ( ");
          update.append(" OID_COND_EVAL_NR, ");
          update.append(" PENR_OID_PARA_EVAL_NR, ");
          update.append(" VAL_MINI,");
          update.append(" VAL_MAXI, ");
          update.append(" VAL_ESCA_MINI ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(carCondiEvaluNr.getPenrOidParaEvalNr().getId() + ", ");
          update.append(carCondiEvaluNr.getValMini() + ", ");
            if(carCondiEvaluNr.getValMaxi()!= null)
            {
              update.append(carCondiEvaluNr.getValMaxi() + ", ");
            }
             else 
                {update.append(" NULL," );}
          update.append(carCondiEvaluNr.getValEscaMini());
          
          
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
          UtilidadesLog.info("DAOCondicionEvaluacionNr.guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels, HashMap userProperties ): Salida");
          
          return primaryKey;
        }
        
        public void remove(Vector entities) throws MareException
        {UtilidadesLog.info("DAOCondicionEvaluacionNr.remove(Vector entities): Entrada");
        RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CarCondiEvaluNrData carCondiEvaluNr = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                carCondiEvaluNr = (CarCondiEvaluNrData)entities.get(j);
                 
                oids = oids + "," + carCondiEvaluNr.getId();
            }
            
            update.append("delete CAR_CONDI_EVALU_NR ");
            update.append("where OID_COND_EVAL_NR in ( " + oids.substring(1) + ") ");
            
                   
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
            
                
        UtilidadesLog.info("DAOCondicionEvaluacionNr.remove(Vector entities): Salida");
        }     
        public void update(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels) throws MareException
        {UtilidadesLog.info("DAOCondicionEvaluacionNr.update(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels): Entrada");
        
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  CAR_CONDI_EVALU_NR SET ");
            update.append(" VAL_MINI = " + carCondiEvaluNr.getValMini()+ ",");
            
            if(carCondiEvaluNr.getValMaxi()!= null){
                update.append(" VAL_MAXI = " + carCondiEvaluNr.getValMaxi()+",");
            }
            else
               { update.append(" VAL_MAXI = NULL,");}
            update.append(" VAL_ESCA_MINI = " + carCondiEvaluNr.getValEscaMini());
            update.append(" WHERE OID_COND_EVAL_NR =" + carCondiEvaluNr.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          UtilidadesLog.info("DAOCondicionEvaluacionNr.update(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels): Salida");
          
        }
        
        
        
    }
    

