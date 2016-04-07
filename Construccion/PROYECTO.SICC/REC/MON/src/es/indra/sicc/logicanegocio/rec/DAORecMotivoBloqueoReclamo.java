package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.RecMotivBloquData;
import es.indra.belcorp.mso.SegPaisViewData;
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

public class DAORecMotivoBloqueoReclamo {
    public DAORecMotivoBloqueoReclamo() {
    }
    public Hashtable guardarMotivoBloqueo(RecMotivBloquData recMotivBloqu, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAORecMotivoBloqueoReclamo.guardarMotivoBloqueo(RecMotivBloquData recMotivBloqu, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT REC_MOBL_SEQ.NEXTVAL FROM DUAL ");
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
       update.append("INSERT INTO REC_MOTIV_BLOQU ( ");
       update.append("            OID_MOTI_BLOQ ");
       update.append("            , VAL_MOTI_BLOQ ");
       update.append("            , PAIS_OID_PAIS ");
       update.append("  ) VALUES ( ");
       update.append(id);
       update.append("  , '" + recMotivBloqu.getValMotiBloq() + "'");
       update.append(" , " + recMotivBloqu.getPaisOidPais().getId());
       update.append("            ) ");
       
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
             updateInter.append(" 'REC_MOTIV_BLOQU', ");
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
       UtilidadesLog.info("DAORecMotivoBloqueoReclamo.guardarMotivoBloqueo(RecMotivBloquData recMotivBloqu, Vector localizationLabels, HashMap userProperties): Salida");
       return primaryKey;
     }
     public Vector query( RecMotivBloquData recMotivBloquFrom, RecMotivBloquData recMotivBloquTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAORecMotivoBloqueReclamo.query(RecMotivBloquData recMotivBloquFrom, RecMotivBloquData recMotivBloquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append("  SELECT REC_MOTIV_BLOQU.OID_MOTI_BLOQ, REC_MOTIV_BLOQU.VAL_MOTI_BLOQ,  ");
       query.append("         V_GEN_I18N_SICC.VAL_I18N, SEG_PAIS.OID_PAIS ");
       query.append("         FROM REC_MOTIV_BLOQU, V_GEN_I18N_SICC, SEG_PAIS ");
       query.append("         WHERE REC_MOTIV_BLOQU.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS  ");
       if(recMotivBloquFrom.getValMotiBloq() != null)
       {
         query.append("             AND REC_MOTIV_BLOQU.VAL_MOTI_BLOQ LIKE '" + recMotivBloquFrom.getValMotiBloq() + "' ");
       }
       query.append("               AND V_GEN_I18N_SICC.ATTR_ENTI = 'REC_MOTIV_BLOQU' ");
       query.append("               AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
       query.append("               AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("               AND V_GEN_I18N_SICC.VAL_OID = REC_MOTIV_BLOQU.OID_MOTI_BLOQ ");
       if(recMotivBloquFrom.getDescripcion() != null)
       {
         query.append("             AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + recMotivBloquFrom.getDescripcion() + "'");
       }
       if(recMotivBloquFrom.getId() != null)
       {
         query.append("             AND REC_MOTIV_BLOQU.OID_MOTI_BLOQ = " + recMotivBloquFrom.getId());
       }
       
       try {
              rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       int cant = rs.getRowCount();
       Vector result = new Vector();
       RecMotivBloquData recMotivBloqu = null;
       SegPaisViewData segPaisViewFrom = null; 
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
                     recMotivBloqu = new RecMotivBloquData();
                     recMotivBloqu.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_MOTI_BLOQ")).toString()));
                     recMotivBloqu.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     recMotivBloqu.setValMotiBloq((String)rs.getValueAt(i,"VAL_MOTI_BLOQ"));
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     recMotivBloqu.setPaisOidPais(segPaisViewFrom);
                     result.add(recMotivBloqu);
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
          UtilidadesLog.info("DAORecMotivoBloqueoReclamo.query(RecMotivBloquData recMotivBloquFrom, RecMotivBloquData recMotivBloquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
          return result;
     }
     public void update(RecMotivBloquData recMotivBloqu, Vector localizationLabels)throws MareException
     {
         UtilidadesLog.info("DAORecMotivoBloqueoReclamo.update(RecMotivBloquData recMotivBloqu, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
       
         deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
         deleteInter.append(" where VAL_OID = " + recMotivBloqu.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'REC_MOTIV_BLOQU' ");
        
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
             updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
             updateInter.append("OID_I18N, "); 
             updateInter.append("ATTR_ENTI, "); 
             updateInter.append("ATTR_NUM_ATRI, "); 
             updateInter.append("IDIO_OID_IDIO, "); 
             updateInter.append("VAL_I18N, ");                 
             updateInter.append("VAL_OID "); 
             updateInter.append(" ) VALUES ( ");
             updateInter.append(idInter + ", ");
             updateInter.append(" 'REC_MOTIV_BLOQU', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(recMotivBloqu.getId() + " )");   
              
             try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
             
         }
         UtilidadesLog.info("DAORecMotivoBloqueoReclamo.update(RecMotivBloquData recMotivBloqu, Vector localizationLabels): Salida"); 
     }
     public void remove(Vector recMotivoBloqueo)throws MareException
     {
       UtilidadesLog.info("DAORecMotivoBloqueoReclamo.removo(Vector recMotivoBloqueo): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
           
       int cant = recMotivoBloqueo.size();
       RecMotivBloquData recMotivBloqu = null;
       String oidMotivoBloqueo = "";
       for (int j = 0; j < cant; j++) {
               recMotivBloqu = (RecMotivBloquData)recMotivoBloqueo.get(j);
                
               oidMotivoBloqueo = oidMotivoBloqueo + "," + recMotivBloqu.getId();
       }
       update.append("delete REC_MOTIV_BLOQU ");
       update.append("where OID_MOTI_BLOQ in ( " + oidMotivoBloqueo.substring(1) + ") ");
         
       updateInter.append(" delete GEN_I18N_SICC_PAIS ");
       updateInter.append(" where VAL_OID in ( " + oidMotivoBloqueo.substring(1) + ") ");
       updateInter.append(" and ATTR_NUM_ATRI = 1 ");
       updateInter.append(" and ATTR_ENTI = 'REC_MOTIV_BLOQU' ");
         
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
      UtilidadesLog.info("DAORecMotivoBloqueoReclamo.removo(Vector recMotivoBloqueo): Salida");  
     }
}
