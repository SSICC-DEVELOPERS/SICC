package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaePreguEncueData;
import es.indra.belcorp.mso.MaeRespuEncueData;
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

public class DAORespuestaEncuesta {
    public DAORespuestaEncuesta() {
    }
    public Vector query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties)throws MareException
      {
              UtilidadesLog.info("DAORespuestaEncuesta.query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties): Entrada");
              RecordSet rs = new RecordSet();
              StringBuffer query = new StringBuffer();
              Vector parametros = new Vector();
              BelcorpService bs;
              try{
                        bs = BelcorpService.getInstance();
            
              } catch(MareMiiServiceNotFoundException ex){
              
                        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
              }
              query.append("  SELECT V_GEN_I18N_SICC.VAL_I18N, V_GEN_I18N_SICC.VAL_OID ");
              query.append("         FROM V_GEN_I18N_SICC, MAE_PREGU_ENCUE ");
              query.append("              WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_PREGU_ENCUE' ");
              query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
              query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
              query.append("              AND V_GEN_I18N_SICC.VAL_OID = MAE_PREGU_ENCUE.OID_PREG ");
              query.append("              ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
              
              try{
                    
                        rs = bs.dbService.executeStaticQuery(query.toString());
                     
               } catch (Exception ex) {
                     
                        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
               if(!rs.esVacio())
                {
                  for(int i= 0; i < rs.getRowCount(); i++){
                      MaePreguEncueData maePreguEncue = new MaePreguEncueData();
                      maePreguEncue.setId( new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                      maePreguEncue.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      parametros.add(maePreguEncue);
                  }
                }
             UtilidadesLog.info("DAORespuestaEncuesta.query(MaePreguEncueData maePreguEncueFrom, MaePreguEncueData maePreguEncueTo, HashMap userProperties): Salida");
             return parametros;
      }
      public Hashtable guaradaRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, Vector localizationLabels, HashMap userProperties)throws MareException
      {
            UtilidadesLog.info("DAORespuestaEncuesta.guardarRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, Vector localizationLabels, HashMap userProperties): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();     
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            query.append(" SELECT MAE_REEN_SEQ.NEXTVAL FROM DUAL ");
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
            update.append(" INSERT INTO MAE_RESPU_ENCUE (");
            update.append("            OID_RESP, ");
            update.append("            PREN_OID_PREG, ");
            update.append("            COD_RESP,  ");
            update.append("            VAL_PESO ");
            update.append(" ) VALUES ( ");
            update.append(id);
            update.append(" , " + maeRespuEncue.getPrenOidPreg().getId());
            update.append(" , '" + maeRespuEncue.getCodResp()+"'");
            update.append(" , " + maeRespuEncue.getValPeso());
            update.append("   ) ");
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
                updateInter.append(" 'MAE_RESPU_ENCUE', ");
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
          UtilidadesLog.info("DAORespuestaEncuesta.guardarRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, Vector localizationLabels, HashMap userProperties): Salida");
          return primaryKey;
      }
      public Vector query(MaeRespuEncueData maeRespuEncueFrom, MaeRespuEncueData maeRespuEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAORespuestaEncuesta.query(MaeRespuEncueData maeRespuEncueFrom, MaeRespuEncueData maeRespuEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
         query.append("    SELECT MAE_RESPU_ENCUE.OID_RESP, V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N, ");
         query.append("           MAE_RESPU_ENCUE.COD_RESP, MAE_RESPU_ENCUE.VAL_PESO ");
         query.append("           FROM MAE_RESPU_ENCUE, V_GEN_I18N_SICC, MAE_PREGU_ENCUE ");
         query.append("           WHERE MAE_RESPU_ENCUE.PREN_OID_PREG = MAE_PREGU_ENCUE.OID_PREG ");
         if(maeRespuEncueFrom.getPrenOidPreg() != null)
         {
            query.append("              AND  MAE_PREGU_ENCUE.OID_PREG = " + maeRespuEncueFrom.getPrenOidPreg().getId());
         }
         if(maeRespuEncueFrom.getCodResp() != null)
         {
            query.append("              AND MAE_RESPU_ENCUE.COD_RESP LIKE '" + maeRespuEncueFrom.getCodResp() +"' ");
         }
         if(maeRespuEncueFrom.getValPeso() != null)
         {
            query.append("  AND MAE_RESPU_ENCUE.VAL_PESO = " + maeRespuEncueFrom.getValPeso() );
         }
         query.append("                 AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_PREGU_ENCUE' ");
         query.append("                 AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append("                 AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
         query.append("                 AND V_GEN_I18N_SICC.VAL_OID = MAE_PREGU_ENCUE.OID_PREG ");
         if(maeRespuEncueFrom.getDescripcion() != null)
         {
            query.append("              AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeRespuEncueFrom.getDescripcion() + "' ");
         }
         if(maeRespuEncueFrom.getId() != null)
         {
            query.append("              AND MAE_RESPU_ENCUE.OID_RESP =  " + maeRespuEncueFrom.getId());
         }
         query.append("                 ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
         
         try {
               rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          int cant = rs.getRowCount();
          Vector result = new Vector();
          MaeRespuEncueData maeRespuEncue = null;
          MaePreguEncueData maePreguEncue = null;
          
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
                        maeRespuEncue = new MaeRespuEncueData();
                        maeRespuEncue.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_RESP")).toString()));
                        maeRespuEncue.setCodResp((String)rs.getValueAt(i,"COD_RESP"));
                        maeRespuEncue.setValPeso(new Long(((BigDecimal)rs.getValueAt(i,"VAL_PESO")).toString()));
                        maePreguEncue = new MaePreguEncueData();
                        maePreguEncue.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                        maePreguEncue.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                        maeRespuEncue.setPrenOidPreg(maePreguEncue);
                        result.add(maeRespuEncue);
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
            UtilidadesLog.info("DAORespuestaEncuesta.query(MaeRespuEncueData maeRespuEncueFrom, MaeRespuEncueData maeRespuEncueTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");  
            return result;
      }
      public void update(MaeRespuEncueData maeRespuEncue, Vector localizationLabels)throws MareException
      {
          UtilidadesLog.info("DAORespuestaEncuesta.update(MaeRespuEncueData maeRespuEncue, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
          deleteInter.append(" where VAL_OID = " + maeRespuEncue.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'MAE_RESPU_ENCUE' ");
         
          try {
                int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
          } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
          }
            update.append(" UPDATE MAE_RESPU_ENCUE SET");
            update.append("        PREN_OID_PREG = " + maeRespuEncue.getPrenOidPreg().getId());
            update.append("        , COD_RESP = '" + maeRespuEncue.getCodResp() +"' ");
            update.append("        , VAL_PESO = " + maeRespuEncue.getValPeso());
            update.append("        where OID_RESP = " + maeRespuEncue.getId());
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
             updateInter.append(" 'MAE_RESPU_ENCUE', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(maeRespuEncue.getId() + " )");   
               
             try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
              
         }
        UtilidadesLog.info("DAORespuestaEncuesta.update(MaeRespuEncueData maeRespuEncue, Vector localizationLabels): Salida");    
      }
      public void remove(Vector maeRepuestaEncuesta)throws MareException
      {
            UtilidadesLog.info("DAORespuestaEncuesta.remove(Vector maeRespuestaEncuesta): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant = maeRepuestaEncuesta.size();
            MaeRespuEncueData maeRespuEncue = null;
            String oidRes = "";
            for (int j = 0; j < cant; j++) {
                 maeRespuEncue = (MaeRespuEncueData)maeRepuestaEncuesta.get(j);
                 
                 oidRes = oidRes + "," + maeRespuEncue.getId();
            }
            update.append("delete MAE_RESPU_ENCUE  ");
            update.append("where OID_RESP in ( " + oidRes.substring(1) + ") ");
            
            updateInter.append("delete GEN_I18N_SICC_PAIS ");
            updateInter.append(" where VAL_OID in ( " + oidRes.substring(1) + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_RESPU_ENCUE' ");
            
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
         UtilidadesLog.info("DAORespuestaEncuesta.remove(Vector maeRespuestaEncuesta): Salida");   
      }
}
