package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeEstadCivilData;
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

public class DAOEstadoCivil {
    public DAOEstadoCivil() {
    }
    public Hashtable guardarEstadoCivil(MaeEstadCivilData maeEstadCivil, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOEstadoCivil.guardarEstadoCivil(MaeEstadCivilData maeEstadCivil, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer updateInter = null;
        StringBuffer update = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT MAE_ESCV_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO MAE_ESTAD_CIVIL ( ");
        update.append("    OID_ESTA_CIVI, ");
        update.append("    COD_ESTA_CIVI ");
        update.append(" ) VALUES (   ");
        update.append(id);
        update.append(",'" + maeEstadCivil.getCodEstaCivi()+ "'");
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
              updateInter.append(" 'MAE_ESTAD_CIVIL', ");
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
          UtilidadesLog.info("DAOEstadoCivil.guardarEstadoCivil(MaeEstadCivilData maeEstadCivil, Vector localizationLabels, HashMap userProperties): Salida");
          return primaryKey;
      }
      public Vector query(MaeEstadCivilData maeEstadCivilFrom, MaeEstadCivilData maeEstadCivilTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOEstadoCivil.query(MaeEstadCivilData maeEstadCivilFrom, MaeEstadCivilData maeEstadCivilTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
         query.append(" SELECT MAE_ESTAD_CIVIL.OID_ESTA_CIVI, MAE_ESTAD_CIVIL.COD_ESTA_CIVI, V_GEN_I18N_SICC.VAL_I18N ");
         query.append("         FROM MAE_ESTAD_CIVIL, V_GEN_I18N_SICC  ");
         query.append("          WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_ESTAD_CIVIL' ");
         query.append("                 AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append("                 AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
         query.append("                 AND V_GEN_I18N_SICC.VAL_OID = MAE_ESTAD_CIVIL.OID_ESTA_CIVI ");
         if(maeEstadCivilFrom.getDescripcion() != null)
         {
           query.append(" AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeEstadCivilFrom.getDescripcion()+ "' ");
         }
         if(maeEstadCivilFrom.getCodEstaCivi() != null)
         {
            query.append(" AND MAE_ESTAD_CIVIL.COD_ESTA_CIVI LIKE '" + maeEstadCivilFrom.getCodEstaCivi() + "' ");
         }
         if(maeEstadCivilFrom.getId() != null)
         {
           query.append(" AND MAE_ESTAD_CIVIL.OID_ESTA_CIVI = " + maeEstadCivilFrom.getId());
         }
          try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeEstadCivilData maeEstadCivil = null;
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
                       maeEstadCivil = new MaeEstadCivilData();
                       maeEstadCivil.setId( new Long(((BigDecimal)rs.getValueAt(i, "OID_ESTA_CIVI")).toString()));
                       maeEstadCivil.setCodEstaCivi((String)rs.getValueAt(i,"COD_ESTA_CIVI"));
                       maeEstadCivil.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                       result.add(maeEstadCivil);
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
            UtilidadesLog.info("DAOEstadoCivil.query(MaeEstadCivilData maeEstadCivilFrom, MaeEstadCivilData maeEstadCivilTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result; 
      }
      public void update(MaeEstadCivilData maeEstadCivil, Vector localizationLabels)throws MareException
      {
        UtilidadesLog.info("DAOEstadoCivil.update(MaeEstadCivilData maeEstadCivil, Vector localizationLabels):Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
        
        deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + maeEstadCivil.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'MAE_ESTAD_CIVIL' ");
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
              updateInter.append(" 'MAE_ESTAD_CIVIL', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeEstadCivil.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
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
              
          }
        UtilidadesLog.info("DAOEstadoCivil.update(MaeEstadCivilData maeEstadCivil, Vector localizationLabels):Salida");  
      }
      public void remove(Vector maeEstadoCivil)throws MareException
      {
        UtilidadesLog.info("DAOEstadoCivil.remove(Vector maeEstadoCivil): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
            
         int cant = maeEstadoCivil.size();
         MaeEstadCivilData maeEstadCivil = null;
         String oidEstCivil = "";
         for (int j = 0; j < cant; j++) {
                maeEstadCivil = (MaeEstadCivilData)maeEstadoCivil.get(j);
                 
                oidEstCivil = oidEstCivil + "," + maeEstadCivil.getId();
         }
         update.append("delete MAE_ESTAD_CIVIL ");
         update.append("where OID_ESTA_CIVI in ( " + oidEstCivil.substring(1) + ") ");
          
         updateInter.append("delete GEN_I18N_SICC_COMUN ");
         updateInter.append(" where VAL_OID in ( " + oidEstCivil.substring(1) + ") ");
         updateInter.append(" and ATTR_NUM_ATRI = 1 ");
         updateInter.append(" and ATTR_ENTI = 'MAE_ESTAD_CIVIL' ");
          
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
        
        UtilidadesLog.info("DAOEstadoCivil.remove(Vector maeEstadoCivil): Salida");
      }
}
