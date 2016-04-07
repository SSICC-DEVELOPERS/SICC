package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
import es.indra.belcorp.mso.CarParamCalcuLcData;

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

public class DAOParametrosCalculoLc {
    public DAOParametrosCalculoLc() 
    {
    }
    
    public Vector query(CarParamCalcuLcData carParamCalcuLcFrom, CarParamCalcuLcData carParamCalcuLcTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCarParamCalcuLc.query(CarParamCalcuLcData carParamCalcuLcFrom, CarParamCalcuLcData carParamCalcuLcTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
            query.append(" SELECT c.oid_nive_ries, b.val_i18n, a.oid_para_calc_lc, a.niri_oid_nive_ries,   ");
            query.append(" a.val_tope, a.val_fact_calc, a.ind_vari_line_cred  ");
            query.append(" FROM car_param_calcu_lc a, car_nivel_riesg c, gen_i18n_sicc_comun b ");
            query.append(" WHERE b.attr_enti = 'CAR_NIVEL_RIESG'");
            query.append(" AND b.attr_num_atri = 1");
            query.append(" AND b.idio_oid_idio = 1");
            query.append(" AND b.val_oid = c.oid_nive_ries");
            query.append(" AND c.OID_NIVE_RIES = a.NIRI_OID_NIVE_RIES");
        
            
            
             if(carParamCalcuLcFrom.getId()!= null){
                query.append(" AND OID_PARA_CALC_LC = " + carParamCalcuLcFrom.getId());
            }
             if(carParamCalcuLcFrom.getIndVariLineCred()!= null){
                query.append(" AND IND_VARI_LINE_CRED like '" + carParamCalcuLcFrom.getIndVariLineCred() + "'");
            }
          
            if(carParamCalcuLcFrom.getNiriOidNiveRies()!= null){
                query.append(" AND NIRI_OID_NIVE_RIES =" + carParamCalcuLcFrom.getNiriOidNiveRies().getId());
            }
            if(carParamCalcuLcFrom.getValFactCalc()!= null)
            {
                query.append(" AND VAL_FACT_CALC = " + carParamCalcuLcFrom.getValFactCalc());
            }
            
            if(carParamCalcuLcFrom.getValTope()!= null)
            {
                query.append(" AND VAL_TOPE = " + carParamCalcuLcFrom.getValTope());
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
            
            CarParamCalcuLcData carParamCalcuLc = null;
            CarNivelRiesgData  carNivelRiesgo = null;
            
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
                      carParamCalcuLc= new CarParamCalcuLcData();
                      carNivelRiesgo = new CarNivelRiesgData();
                      
                      
                      carParamCalcuLc.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA_CALC_LC")).toString())); 
                      carParamCalcuLc.setIndVariLineCred((String)rs.getValueAt(i,"IND_VARI_LINE_CRED"));
                      carParamCalcuLc.setValFactCalc(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_FACT_CALC")).toString()));  
                      carParamCalcuLc.setValTope(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_TOPE")).toString()));
                      carNivelRiesgo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_NIVE_RIES")).toString())); 
                      carNivelRiesgo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                                  
                      carParamCalcuLc.setNiriOidNiveRies(carNivelRiesgo);                 
                      result.add(carParamCalcuLc);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            
                 
        }
        UtilidadesLog.info("DAOCarParamCalcuLc.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
        }
        public Vector query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties) throws MareException
        {
        
            UtilidadesLog.info("DAOCarParamCalcuLc.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties): Entrada");
          
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
          query.append(" SELECT c.oid_nive_ries,  b.val_i18n  ");     
          query.append(" FROM car_nivel_riesg c, gen_i18n_sicc_comun b ");                
          query.append(" WHERE b.attr_enti = 'CAR_NIVEL_RIESG'");              
          query.append(" AND b.attr_num_atri = 1");
          query.append(" AND b.idio_oid_idio = 1");
          query.append(" AND b.val_oid = c.oid_nive_ries");
        
        
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
         CarNivelRiesgData carNivelRiesgo = null;
          
          for(int i=0; i < cant; i++){
              carNivelRiesgo = new CarNivelRiesgData();
              
              carNivelRiesgo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_NIVE_RIES")).toString()));
              carNivelRiesgo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
              
              resultado.add(carNivelRiesgo);
          }
          
          UtilidadesLog.info("DAOCarParamCalcuLc.query(CarNivelRiesgData carNivelRiesgFrom, CarNivelRiesgData carNivelRiesgTo, HashMap userProperties): Salida");
          
        return resultado;
        }

               
     public void remove(Vector entities) throws MareException
        {UtilidadesLog.info("DAOCarEstatPedido.remove(Vector entities): Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CarParamCalcuLcData carParamLc = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                carParamLc = (CarParamCalcuLcData)entities.get(j);
                 
                oids = oids + "," + carParamLc.getId();
            }
            
            update.append("delete CAR_PARAM_CALCU_LC ");
            update.append("where OID_PARA_CALC_LC in ( " + oids.substring(1) + ") ");
            
           
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
            
            UtilidadesLog.info("DAOCarEstatPedido.remove(Vector entities): Salida ");
        }
        
        public Hashtable guardarParam(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels, HashMap userProperties) throws MareException
        {
            UtilidadesLog.info("DAODAOCarParamCalcuLC.guardarParam(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels, HashMap userProperties): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT CAR_PCLC_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO CAR_PARAM_CALCU_LC ( ");
          update.append(" OID_PARA_CALC_LC, ");
          update.append(" NIRI_OID_NIVE_RIES, ");
          update.append(" VAL_TOPE, ");
          update.append(" VAL_FACT_CALC, ");
          update.append(" IND_VARI_LINE_CRED ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(" '" + carParamCalcuLc.getNiriOidNiveRies().getId() + "', ");
          update.append(carParamCalcuLc.getValTope() + ",");
          update.append(carParamCalcuLc.getValFactCalc() + ",");
          update.append(" '" + carParamCalcuLc.getIndVariLineCred() + "'");
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
          UtilidadesLog.info("DAOCarParamCalcuLC.guardarParam(CarCondiEvaluNrData carCondiEvaluNr, Vector localizationLabels, HashMap userProperties ): Salida");
          
          return primaryKey;
        }
        
        
       public void update(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels) throws MareException
        {
            UtilidadesLog.info("DAOCarParamCalcuLC.update(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels): Entrada");
        
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  CAR_PARAM_CALCU_LC SET ");
            update.append(" VAL_FACT_CALC = " + carParamCalcuLc.getValFactCalc() + ",");
            update.append(" IND_VARI_LINE_CRED = '" + carParamCalcuLc.getIndVariLineCred()+ "',");
            update.append(" VAL_TOPE = " + carParamCalcuLc.getValTope());
            update.append(" WHERE OID_PARA_CALC_LC = " + carParamCalcuLc.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          UtilidadesLog.info("DAOCarParamCalcuLC.update(CarParamCalcuLcData carParamCalcuLc, Vector localizationLabels): Salida");
          
            
        } 
        
    
    
}
