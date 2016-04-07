package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarEstatPedidData;
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

public class DAOEstatusPedido {
    public DAOEstatusPedido() {
    }
    
    public Vector query(CarEstatPedidData carEstatPedidFrom, CarEstatPedidData carEstatPedidTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
         {
         UtilidadesLog.info("DAOCarEstatPedido.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
         
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
            
            query.append(" SELECT b.oid_esta_pedi, b.cod_esta, v.val_i18n");
            query.append(" FROM car_estat_pedid b, v_gen_i18n_sicc v ");
            query.append(" WHERE v.attr_enti = 'CAR_ESTAT_PEDID' ");
            query.append(" AND v.attr_num_atri = 1");
            query.append(" AND v.idio_oid_idio = 1 ");
            query.append(" AND v.val_oid = b.oid_esta_pedi");
            
             if(carEstatPedidFrom.getId()!= null){
                query.append(" AND b.oid_esta_pedi = " + carEstatPedidFrom.getId());
            }
            
            if(carEstatPedidFrom.getCodEsta() != null){
                query.append(" and b.cod_esta like '" + carEstatPedidFrom.getCodEsta() + "'");
            }
            if(carEstatPedidFrom.getDescripcion()!= null){
            
                query.append(" AND v.val_i18n like '" + carEstatPedidFrom.getDescripcion() + "'");
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
            
            CarEstatPedidData carEstatPedidData = null;
            
            
            
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
                      carEstatPedidData = new CarEstatPedidData();
                     
                     
                     
                     
                      carEstatPedidData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTA_PEDI")).toString())); 
                      carEstatPedidData.setCodEsta((String)rs.getValueAt(i,"COD_ESTA"));
                      carEstatPedidData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                            
                      result.add(carEstatPedidData);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
          
          UtilidadesLog.info("DAOCarEstatPedido.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida");
          return result;
            
              
        }
    public Hashtable guardarEstPed(CarEstatPedidData carEstatPedid, Vector localizationLabels, HashMap userProperties) throws MareException
        {
            UtilidadesLog.info("DAOguardarEstPed(CarEstatPedidData carEstatPedid, Vector localizationLabels, HashMap userProperties): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT CAR_ESPE_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO CAR_ESTAT_PEDID ( ");
          update.append(" OID_ESTA_PEDI, ");
          update.append(" COD_ESTA ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(" '" + carEstatPedid.getCodEsta() + "' ");
          
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
                updateInter.append(" 'CAR_ESTAT_PEDID', ");
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
        
            UtilidadesLog.info("DAOguardarEstPed(CarEstatPedidData carEstatPedid, Vector localizationLabels, HashMap userProperties): Salida");
            return primaryKey;
        }
        
    public void update(CarEstatPedidData carEstatPedid, Vector localizationLabels) throws MareException
        {UtilidadesLog.info("DAOCarEstatPedido.update(CarEstatPedidData carEstatPedid, Vector localizationLabels):Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            // Borrar los registros internalizacion
            StringBuffer deleteInter = new StringBuffer();
            
            deleteInter.append("delete GEN_I18N_SICC_COMUN ");
            deleteInter.append(" where VAL_OID = " + carEstatPedid.getId());
            deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
            deleteInter.append(" and ATTR_ENTI = 'CAR_ESTAT_PEDID' ");
            
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
                updateInter.append(" 'CAR_ESTAT_PEDID', ");
                updateInter.append(" 1, ");            
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(carEstatPedid.getId() + " )");   
            
                try {
                    int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            StringBuffer update = new StringBuffer();
            
            update.append("UPDATE CAR_ESTAT_PEDID SET ");
            update.append(" COD_ESTA = '" + carEstatPedid.getCodEsta()+ "'");
            update.append(" WHERE OID_ESTA_PEDI = " + carEstatPedid.getId());   
            
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
            UtilidadesLog.info("DAOCarEstatPedido.update(CarEstatPedidData carEstatPedid, Vector localizationLabels):Salida ");
        }

    public void remove(Vector entities) throws MareException
        {
        UtilidadesLog.info("DAOCarEstatPedido.remove(Vector entities): Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant = entities.size();
            CarEstatPedidData carEstatPedid = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                carEstatPedid = (CarEstatPedidData)entities.get(j);
                 
                oids = oids + "," + carEstatPedid.getId();
            }
            
            update.append("delete CAR_ESTAT_PEDID ");
            update.append("where OID_ESTA_PEDI in ( " + oids.substring(1) + ") ");
            
            updateInter.append("delete GEN_I18N_SICC_COMUN ");
            updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'CAR_ESTAT_PEDID' ");
            
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
            
            UtilidadesLog.info("DAOCarEstatPedido.remove(Vector entities): Salida ");
        }
        
     }
    
    
    

