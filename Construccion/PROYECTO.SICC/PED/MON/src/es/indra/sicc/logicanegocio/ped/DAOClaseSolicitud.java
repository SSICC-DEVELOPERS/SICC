package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.PedClaseSolicData;
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

public class DAOClaseSolicitud {
    public DAOClaseSolicitud() {
    }
    public Hashtable guardarClaseSoliciud(PedClaseSolicData pedClaseSolic, java.util.Vector localizationLabels, HashMap userProperties) throws MareException
      {
          UtilidadesLog.info("DAOClaseSolicitud.guardarClaseSolicitud(PedClaseSolicData pedClaseSolic, java.util.Vector localizationLabels, HashMap userProperties): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();     
          StringBuffer updateInter = null;
          StringBuffer update = new StringBuffer();
          RecordSet rsPK = null;
          StringBuffer query = new StringBuffer();      
          Long id = null;
          query.append(" SELECT PED_CLSO_SEQ.NEXTVAL FROM DUAL ");
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
          update.append(" INSERT INTO PED_CLASE_SOLIC ( ");
          update.append(" OID_CLAS_SOLI, ");
          update.append(" COD_CLAS_SOLI, ");
          update.append(" IND_ORDE_COMP ");
          update.append(" ) VALUES ( ");
          update.append(id);
          update.append(", '"+ pedClaseSolic.getCodClasSoli() +"' ");
          update.append(" ," + pedClaseSolic.getIndOrdeComp());
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
            
            for(int i= 0; i< cant; i++){
                          
                queryInter = new StringBuffer();             
                queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");         
                
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
                updateInter.append(" 'PED_CLASE_SOLIC', ");
                updateInter.append(" 1, ");   
              //UtilidadesLog.debug(" oidPais: "+ genDetaSiccData.getIdioOidIdio().getId());
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
          UtilidadesLog.info("DAOClaseSolicitud.guardarClaseSolicitud(PedClaseSolicData pedClaseSolic, java.util.Vector localizationLabels, HashMap userProperties): Salida");
          return primaryKey;    
      }
      public Vector query(PedClaseSolicData pedClaseSolicFrom, PedClaseSolicData pedClaseSolicTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
      {
        UtilidadesLog.info("DAOClaseSolicitud.query(PedClaseSolicData pedClaseSolicFrom, PedClaseSolicData pedClaseSolicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada ");
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
            query.append(" SELECT PED_CLASE_SOLIC.OID_CLAS_SOLI, PED_CLASE_SOLIC.COD_CLAS_SOLI, ");
            query.append(" V_GEN_I18N_SICC.VAL_I18N, PED_CLASE_SOLIC.IND_ORDE_COMP ");
            query.append(" FROM PED_CLASE_SOLIC, V_GEN_I18N_SICC ");
            query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'PED_CLASE_SOLIC' ");
            query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
            query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
            query.append(" AND V_GEN_I18N_SICC.VAL_OID = PED_CLASE_SOLIC.OID_CLAS_SOLI");
            if(pedClaseSolicFrom.getCodClasSoli() != null)
            {
              query.append(" AND PED_CLASE_SOLIC.COD_CLAS_SOLI LIKE '"+ pedClaseSolicFrom.getCodClasSoli()+ "' ");
            }
            if(pedClaseSolicFrom.getDescripcion() != null)
            {
                query.append(" AND V_GEN_I18N_SICC.VAL_I18N LIKE '"+ pedClaseSolicFrom.getDescripcion()+"' ");
            }
            if(pedClaseSolicFrom.getIndOrdeComp() != null)
            {
              String num = pedClaseSolicFrom.getIndOrdeComp();
              if(num.equals("1")){
                  query.append("   AND PED_CLASE_SOLIC.IND_ORDE_COMP = 1 " );
              }else
              {
                  query.append("   AND PED_CLASE_SOLIC.IND_ORDE_COMP = 0 " );
              }
            }
            if(pedClaseSolicFrom.getId()  != null)
            {
               query.append(" AND PED_CLASE_SOLIC.OID_CLAS_SOLI = " + pedClaseSolicFrom.getId());
            }
             try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             PedClaseSolicData pedClaseSolicfrom = null;
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
                  pedClaseSolicfrom = new PedClaseSolicData();
                  pedClaseSolicfrom.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CLAS_SOLI")).toString()));
                  pedClaseSolicfrom.setCodClasSoli((String)rs.getValueAt(i,"COD_CLAS_SOLI"));
                  pedClaseSolicfrom.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                  pedClaseSolicfrom.setIndOrdeComp(((BigDecimal)rs.getValueAt(i,"IND_ORDE_COMP")).toString());
                  result.add(pedClaseSolicfrom);
                }catch(Exception ex)
                {
                   ex.printStackTrace();
                   UtilidadesLog.error("ERROR ", ex);
                }
                }else
                {
                  break;
                }
            }
             UtilidadesLog.debug("result: " + result);
             UtilidadesLog.info("DAOClaseSolicitud.query(PedClaseSolicData pedClaseSolicFrom, PedClaseSolicData pedClaseSolicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida ");
             return result; 
      }
      public void remove(Vector pedClasSolicFrom )throws MareException
      {
            UtilidadesLog.info("DAOClaseSolicitud.reomve(Vector pedClasSolicFrom): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant = pedClasSolicFrom.size();
            PedClaseSolicData  pedFormuData = null;
            String oidClaseSolicitud = "";
            for (int j = 0; j < cant; j++) {
                pedFormuData = (PedClaseSolicData)pedClasSolicFrom.get(j);
                 
                oidClaseSolicitud = oidClaseSolicitud + "," + pedFormuData.getId();
            }
            update.append("delete PED_CLASE_SOLIC  ");
            update.append("where OID_CLAS_SOLI in ( " + oidClaseSolicitud.substring(1) + ") ");
            
            updateInter.append("delete GEN_I18N_SICC_COMUN ");
            updateInter.append(" where VAL_OID in ( " + oidClaseSolicitud.substring(1) + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'PED_CLASE_SOLIC' ");
            
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
            UtilidadesLog.info("DAOClaseSolicitud.reomve(Vector pedClasSolicFrom): Salida");
            
      }
      public void update(PedClaseSolicData pedClaseSolic, Vector localizationLabels)throws MareException
      {
         UtilidadesLog.info("DAOClaseSolicitud(PedClaseSolicData pedClaseSolic, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
        
         deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
         deleteInter.append(" where VAL_OID = " + pedClaseSolic.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'PED_CLASE_SOLIC' ");
         
         try {
                int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
         } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
         }
         
         update.append("UPDATE PED_CLASE_SOLIC SET ");
         update.append(" COD_CLAS_SOLI ='" + pedClaseSolic.getCodClasSoli()+"' ");
         update.append(" , IND_ORDE_COMP = " + pedClaseSolic.getIndOrdeComp());
         update.append(" where OID_CLAS_SOLI = " + pedClaseSolic.getId());
         try {
              int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                
         } catch (Exception ex) {
              ex.printStackTrace();
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }
         int cant = localizationLabels.size();
         GenDetaSiccData genDetaSiccData = null;
         RecordSet rsPKInter = null;
         Long idInter = null;  
         for(int i = 0; i < cant; i++){
             queryInter = new StringBuffer();
             genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);                                         
             queryInter.append("SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");      
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
             updateInter.append(" 'PED_CLASE_SOLIC', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(pedClaseSolic.getId() + " )");   
               
             try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
              
         }
         UtilidadesLog.info("DAOClaseSolicitud(PedClaseSolicData pedClaseSolic, Vector localizationLabels): Salida");
      }
}
