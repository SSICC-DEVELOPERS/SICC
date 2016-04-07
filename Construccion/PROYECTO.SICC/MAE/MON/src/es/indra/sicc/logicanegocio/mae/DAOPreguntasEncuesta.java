package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeEncueNseViewData;
import es.indra.belcorp.mso.MaePreguEncueData;
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

public class DAOPreguntasEncuesta {
    public DAOPreguntasEncuesta() {
    }
    public Vector query(MaeEncueNseViewData maeEncueNseViewFrom, MaeEncueNseViewData maeEncueNseViewTo, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOPreguntasEncuesta.quer(MaeEncueNseViewData maeEncueNseViewFrom, MaeEncueNseViewData maeEncueNseViewTo, HashMap userProperties): Entrada");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;
       try{
                 bs = BelcorpService.getInstance();
           
       } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
       query.append("  SELECT  V_GEN_I18N_SICC.VAL_I18N, V_GEN_I18N_SICC.VAL_OID ");
       query.append("          FROM MAE_ENCUE_NSE, V_GEN_I18N_SICC ");
       query.append("          WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_ENCUE_NSE'  ");
       query.append("                AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
       query.append("                AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("                AND V_GEN_I18N_SICC.VAL_OID = MAE_ENCUE_NSE.OID_ENCU ");
       try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
        } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
        if(!rs.esVacio())
         {
           for(int i= 0; i < rs.getRowCount(); i++){
                 MaeEncueNseViewData maeEncueNse = new MaeEncueNseViewData();
                 maeEncueNse.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                 maeEncueNse.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                 parametros.add(maeEncueNse);
           }
         }  
       UtilidadesLog.info("DAOPreguntasEncuesta.query(MaeEncueNseViewData maeEncueNseViewFrom, MaeEncueNseViewData maeEncueNseViewTo, HashMap userProperties): Salida");  
       return parametros;
     } 
     public Hashtable guardarPreguntasEncuesta(MaePreguEncueData maePreguEncue, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOPreguntasEncuesta.guardarPreguntaEncuesta(MaePreguEncueData maePreguEncue, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT MAE_PREN_SEQ.NEXTVAL FROM DUAL ");
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
       update.append(" INSERT INTO MAE_PREGU_ENCUE ( ");
       update.append("          OID_PREG, ");
       update.append("          COD_PREG,   ");
       update.append("          VAL_PESO_PREG,  ");
       update.append("          ENSE_OID_ENCU ");
       update.append(" ) VALUES ( ");
       update.append(id);
       update.append(" ,'" + maePreguEncue.getCodPreg()+"' ");
       update.append(" , "+ maePreguEncue.getValPesoPreg());
       update.append(" , " + maePreguEncue.getEnseOidEncu().getId());
       update.append("  ) ");
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
                   
               updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
               updateInter.append("OID_I18N, "); 
               updateInter.append("ATTR_ENTI, "); 
               updateInter.append("ATTR_NUM_ATRI, "); 
               updateInter.append("IDIO_OID_IDIO, "); 
               updateInter.append("VAL_I18N, ");                 
               updateInter.append("VAL_OID "); 
               updateInter.append(" ) VALUES ( ");
               updateInter.append(idInter + ", ");
               updateInter.append(" 'MAE_PREGU_ENCUE', ");
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
         UtilidadesLog.info("DAOPreguntasEncuesta.guardarPreguntaEncuesta(MaePreguEncueData maePreguEncue, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(MaePreguEncueData maePreguEncueFrom,MaePreguEncueData maePreguEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
         UtilidadesLog.info("DAOPreguntaEncuesta.query(MaePreguEncueData maePreguEncueFrom,MaePreguEncueData maePreguEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");   
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
         query.append(" SELECT  MAE_PREGU_ENCUE.OID_PREG, MAE_PREGU_ENCUE.COD_PREG, ");
         query.append("         MAE_PREGU_ENCUE.VAL_PESO_PREG, V_GEN_I18N_SICC.VAL_I18N DESENCUE, V_GEN_I18N_SICC.VAL_OID OIDENCUE, ");
         query.append("         I18N.VAL_I18N DESPREGU ");
         query.append("         FROM MAE_PREGU_ENCUE, V_GEN_I18N_SICC, V_GEN_I18N_SICC I18N, MAE_ENCUE_NSE  ");
         query.append("                WHERE MAE_PREGU_ENCUE.ENSE_OID_ENCU = MAE_ENCUE_NSE.OID_ENCU ");
         if(maePreguEncueFrom.getEnseOidEncu() != null)
         {
            query.append("                  AND MAE_ENCUE_NSE.OID_ENCU = " + maePreguEncueFrom.getEnseOidEncu().getId());
         }
         if(maePreguEncueFrom.getCodPreg() != null)
         {
             query.append("                AND MAE_PREGU_ENCUE.COD_PREG LIKE '" + maePreguEncueFrom.getCodPreg()+ "' ");
         }
         if(maePreguEncueFrom.getValPesoPreg() != null)
         {
           query.append("                  AND MAE_PREGU_ENCUE.VAL_PESO_PREG = " + maePreguEncueFrom.getValPesoPreg());
         }
         query.append("                    AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_ENCUE_NSE' ");
         query.append("                    AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append("                    AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
         query.append("                    AND V_GEN_I18N_SICC.VAL_OID = MAE_ENCUE_NSE.OID_ENCU ");
         
         query.append("                    AND I18N.ATTR_ENTI = 'MAE_PREGU_ENCUE' ");
         query.append("                    AND I18N.ATTR_NUM_ATRI = 1 ");
         query.append("                    AND I18N.IDIO_OID_IDIO = 1 ");
         query.append("                    AND I18N.VAL_OID = MAE_PREGU_ENCUE.OID_PREG ");
         if(maePreguEncueFrom.getDescripcion()!= null)
         {
           query.append("                  AND I18N.VAL_I18N LIKE '" + maePreguEncueFrom.getDescripcion() + "'");
         }
         if(maePreguEncueFrom.getId() != null)
         {
           query.append("                   AND MAE_PREGU_ENCUE.OID_PREG =" + maePreguEncueFrom.getId());
         }
         try {
              rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         int cant = rs.getRowCount();
         Vector result = new Vector();
         MaePreguEncueData maePreguEncue = null;
         MaeEncueNseViewData maeEncueNseViewFrom = null;
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
                       maePreguEncue = new MaePreguEncueData();
                       maePreguEncue.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PREG")).toString()));
                       maePreguEncue.setCodPreg((String)rs.getValueAt(i,"COD_PREG"));
                       maePreguEncue.setDescripcion((String)rs.getValueAt(i,"DESPREGU"));
                       maeEncueNseViewFrom =  new   MaeEncueNseViewData();
                       maeEncueNseViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDENCUE")).toString()));
                       maeEncueNseViewFrom.setDescripcion((String)rs.getValueAt(i,"DESENCUE"));
                       maePreguEncue.setEnseOidEncu(maeEncueNseViewFrom);
                       maePreguEncue.setValPesoPreg(new Long(((BigDecimal)rs.getValueAt(i,"VAL_PESO_PREG")).toString()));
                       result.add(maePreguEncue);
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
           UtilidadesLog.info("DAOPreguntaEncuesta.query(MaePreguEncueData maePreguEncueFrom,MaePreguEncueData maePreguEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");   
           return result;
     }
      public void update(MaePreguEncueData maePreguEncue, Vector localizationLabels)throws MareException
      {
         UtilidadesLog.info("DAOPreguntaEncuesta.update(MaePreguEncueData maePreguEncue, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
       
         deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
         deleteInter.append(" where VAL_OID = " + maePreguEncue.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'MAE_PREGU_ENCUE' ");
        
         try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
               
         } catch (Exception ex) {
               ex.printStackTrace();                      
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
         }
         update.append(" UPDATE MAE_PREGU_ENCUE SET");
         update.append("       VAL_PESO_PREG = " + maePreguEncue.getValPesoPreg());
         update.append("       ,ENSE_OID_ENCU = " + maePreguEncue.getEnseOidEncu().getId());
         update.append("   where OID_PREG = " + maePreguEncue.getId());
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
            updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
            updateInter.append("OID_I18N, "); 
            updateInter.append("ATTR_ENTI, "); 
            updateInter.append("ATTR_NUM_ATRI, "); 
            updateInter.append("IDIO_OID_IDIO, "); 
            updateInter.append("VAL_I18N, ");                 
            updateInter.append("VAL_OID "); 
            updateInter.append(" ) VALUES ( ");
            updateInter.append(idInter + ", ");
            updateInter.append(" 'MAE_PREGU_ENCUE', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(maePreguEncue.getId() + " )");   
              
            try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
             
        }
         UtilidadesLog.info("DAOPreguntaEncuesta.update(MaePreguEncueData maePreguEncue, Vector localizationLabels): Salida");
      }
      public void remove(Vector maePreguEncuesta)throws MareException
      {
           UtilidadesLog.info("DAOPreguntaEncuesta.remove(Vector maePreguEncuesta): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = maePreguEncuesta.size();
           MaePreguEncueData maePreguEncue = null;
           String oidPreguntaEncuesta = "";
           for (int j = 0; j < cant; j++) {
                maePreguEncue = (MaePreguEncueData)maePreguEncuesta.get(j);
                
                oidPreguntaEncuesta = oidPreguntaEncuesta + "," + maePreguEncue.getId();
           }
           update.append("delete MAE_PREGU_ENCUE  ");
           update.append("where OID_PREG in ( " + oidPreguntaEncuesta.substring(1) + ") ");
           
           updateInter.append("delete GEN_I18N_SICC_PAIS ");
           updateInter.append(" where VAL_OID in ( " + oidPreguntaEncuesta.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'MAE_PREGU_ENCUE' ");
           
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
          UtilidadesLog.info("DAOPreguntaEncuesta.remove(Vector maePreguEncuesta): Salida"); 
      }
}
