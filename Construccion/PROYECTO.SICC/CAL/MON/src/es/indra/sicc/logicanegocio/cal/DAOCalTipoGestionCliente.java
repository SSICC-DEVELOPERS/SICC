package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalTipoGestiClienData;
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

public class DAOCalTipoGestionCliente {
    public DAOCalTipoGestionCliente() {
    }
    public Hashtable guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOCalTipoGestionCliente.guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT CAL_TGCL_SEQ.NEXTVAL FROM DUAL ");
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
       update.append("INSERT INTO CAL_TIPO_GESTI_CLIEN ( ");
       update.append("            OID_TIPO_GEST_CLIE  ");
       update.append("            , COD_GEST ");
       update.append("  ) VALUES ( "); 
       update.append(id);
       update.append(" , '" + calTipoGestiClien.getCodGest() + "'");
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
               updateInter.append(" 'CAL_TIPO_GESTI_CLIEN', ");
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
         UtilidadesLog.info("DAOCalTipoGestionCliente.guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(CalTipoGestiClienData calTipoGestiClienFrom, CalTipoGestiClienData calTipoGestiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAOCalTipoGestionCliente.query(CalTipoGestiClienData calTipoGestiClienFrom, CalTipoGestiClienData calTipoGestiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append("  SELECT CAL_TIPO_GESTI_CLIEN.OID_TIPO_GEST_CLIE, CAL_TIPO_GESTI_CLIEN.COD_GEST, ");
       query.append("         V_GEN_I18N_SICC.VAL_I18N  ");
       query.append("         FROM CAL_TIPO_GESTI_CLIEN, V_GEN_I18N_SICC  ");
       query.append("              WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'CAL_TIPO_GESTI_CLIEN' ");
       query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
       query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("              AND V_GEN_I18N_SICC.VAL_OID = CAL_TIPO_GESTI_CLIEN.OID_TIPO_GEST_CLIE ");
       if(calTipoGestiClienFrom.getDescripcion() != null)
       {
         query.append("            AND V_GEN_I18N_SICC.VAL_I18N LIKE  '" + calTipoGestiClienFrom.getDescripcion() + "'");
       }
       if(calTipoGestiClienFrom.getCodGest() != null)
       {
         query.append("            AND CAL_TIPO_GESTI_CLIEN.COD_GEST LIKE '" + calTipoGestiClienFrom.getCodGest() + "'");
       }
       if(calTipoGestiClienFrom.getId() != null)
       {
         query.append("            AND CAL_TIPO_GESTI_CLIEN.OID_TIPO_GEST_CLIE = " + calTipoGestiClienFrom.getId());
       }
       try {
              rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       int cant = rs.getRowCount();
       Vector result = new Vector();
       CalTipoGestiClienData calTipoGestiClien = null;
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
                     calTipoGestiClien = new CalTipoGestiClienData();
                     calTipoGestiClien.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_GEST_CLIE")).toString()));
                     calTipoGestiClien.setCodGest((String)rs.getValueAt(i,"COD_GEST"));
                     calTipoGestiClien.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     result.add(calTipoGestiClien);
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
           UtilidadesLog.info("DAOCalTipoGestionCliente.query(CalTipoGestiClienData calTipoGestiClienFrom, CalTipoGestiClienData calTipoGestiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
       }
       public void update(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels)throws MareException
       {
         UtilidadesLog.info("DAOCaklTipoGestionCliente.update(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
       
         deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
         deleteInter.append(" where VAL_OID = " + calTipoGestiClien.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'CAL_TIPO_GESTI_CLIEN' ");
        
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
             updateInter.append(" 'CAL_TIPO_GESTI_CLIEN', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(calTipoGestiClien.getId() + " )");   
              
             try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
             
         }
          UtilidadesLog.info("DAOCalTipoGestionCliente.update(CalTipoGestiClienData calTipoGestiClien, Vector localizationLabels): Salida");
       }
       public void remove(Vector calTipoGestiCliente)throws MareException
       {
          UtilidadesLog.info("DAOCalTipoGestionCliente.remove(Vector calTipoGestiCliente): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = new StringBuffer();
           
          int cant = calTipoGestiCliente.size();
          CalTipoGestiClienData calTipoGestiClien = null;
          String oidTipoGestiCliente = "";
          for (int j = 0; j < cant; j++) {
               calTipoGestiClien = (CalTipoGestiClienData)calTipoGestiCliente.get(j);
                
               oidTipoGestiCliente = oidTipoGestiCliente + "," + calTipoGestiClien.getId();
          }
          update.append("delete CAL_TIPO_GESTI_CLIEN ");
          update.append("where OID_TIPO_GEST_CLIE in ( " + oidTipoGestiCliente.substring(1) + ") ");
         
          updateInter.append("delete GEN_I18N_SICC_COMUN ");
          updateInter.append(" where VAL_OID in ( " + oidTipoGestiCliente.substring(1) + ") ");
          updateInter.append(" and ATTR_NUM_ATRI = 1 ");
          updateInter.append(" and ATTR_ENTI = 'CAL_TIPO_GESTI_CLIEN' ");
         
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
        UtilidadesLog.info("DAOCalTipoGestionCliente.remove(Vector calTipoGestiCliente): Salida");
       }
}
