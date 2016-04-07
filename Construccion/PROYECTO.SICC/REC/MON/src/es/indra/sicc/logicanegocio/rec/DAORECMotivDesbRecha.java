package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.RecMotivRechaDesblData;
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

public class DAORECMotivDesbRecha {
    public DAORECMotivDesbRecha() {
    }
    public Hashtable guardarMotivDesbRecha(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels, HashMap userProperties )throws MareException
      {
        UtilidadesLog.info("DAORECMotivDesbRecha.guardarMotivDesbRecha(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels, HashMap userProperties ): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT REC_MRDB_SEQ.NEXTVAL FROM DUAL ");
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
        update.append("INSERT INTO REC_MOTIV_RECHA_DESBL  ( ");
        update.append("            OID_MOTI_RECH_DESB  ");
        update.append("            , COD_RECH_DESB ");
        update.append("            , PAIS_OID_PAIS ");
        update.append("  )  VALUES ( ");
        update.append(id);
        update.append(" , '" + recMotivRechaDesbl.getCodRechDesb() + "'");
        update.append(" , " + recMotivRechaDesbl.getPaisOidPais().getId());
        update.append("     ) ");
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
                updateInter.append(" 'REC_MOTIV_RECHA_DESBL', ");
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
          UtilidadesLog.info("DAORECMotivDesbRecha.guardarMotivDesbRecha(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels, HashMap userProperties ): Salida");
          return primaryKey;
      }
      public Vector query(RecMotivRechaDesblData recMotivRechaDesblFrom, RecMotivRechaDesblData recMotivRechaDesblTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
      {
        UtilidadesLog.info("DAORECMotivDesbRecha.query(RecMotivRechaDesblData recMotivRechaDesblFrom, RecMotivRechaDesblData recMotivRechaDesblTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
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
        query.append(" SELECT  REC_MOTIV_RECHA_DESBL.OID_MOTI_RECH_DESB, V_GEN_I18N_SICC.VAL_I18N, ");
        query.append("         REC_MOTIV_RECHA_DESBL.COD_RECH_DESB, SEG_PAIS.OID_PAIS ");
        query.append("         FROM REC_MOTIV_RECHA_DESBL, V_GEN_I18N_SICC, SEG_PAIS ");
        query.append("         WHERE REC_MOTIV_RECHA_DESBL.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(recMotivRechaDesblFrom.getPaisOidPais() != null)
        {
          query.append("                AND SEG_PAIS.OID_PAIS = " + recMotivRechaDesblFrom.getPaisOidPais().getId());
        }
        if(recMotivRechaDesblFrom.getCodRechDesb() != null)
        {
          query.append("              AND REC_MOTIV_RECHA_DESBL.COD_RECH_DESB LIKE '" + recMotivRechaDesblFrom.getCodRechDesb() + "'");
        }
        query.append("               AND V_GEN_I18N_SICC.ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL' ");
        query.append("               AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("               AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("               AND V_GEN_I18N_SICC.VAL_OID = REC_MOTIV_RECHA_DESBL.OID_MOTI_RECH_DESB  ");
        if(recMotivRechaDesblFrom.getDescripcion() != null)
        {
          query.append("             AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + recMotivRechaDesblFrom.getDescripcion() + "'");
        }
        if(recMotivRechaDesblFrom.getId() != null)
        {
          query.append("             AND REC_MOTIV_RECHA_DESBL.OID_MOTI_RECH_DESB = " + recMotivRechaDesblFrom.getId());
        }
        query.append("               ORDER BY REC_MOTIV_RECHA_DESBL.OID_MOTI_RECH_DESB ");
      
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        RecMotivRechaDesblData recMotivRechaDesbl = null;
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
                     recMotivRechaDesbl = new RecMotivRechaDesblData();
                     recMotivRechaDesbl.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_MOTI_RECH_DESB")).toString()));
                     recMotivRechaDesbl.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     recMotivRechaDesbl.setCodRechDesb((String)rs.getValueAt(i,"COD_RECH_DESB"));
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     recMotivRechaDesbl.setPaisOidPais(segPaisViewFrom);
                     result.add(recMotivRechaDesbl);
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
            UtilidadesLog.info("DAORECMotivDesbRecha.query(RecMotivRechaDesblData recMotivRechaDesblFrom, RecMotivRechaDesblData recMotivRechaDesblTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida"); 
            return result;
     
      }
      public void update(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels)throws MareException
      {
          UtilidadesLog.info("DAORECMotivDesbRecha.update(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
          deleteInter.append(" where VAL_OID = " + recMotivRechaDesbl.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL' ");
         
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
              updateInter.append(" 'REC_MOTIV_RECHA_DESBL', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(recMotivRechaDesbl.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
              } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
          }
          UtilidadesLog.info("DAORECMotivDesbRecha.update(RecMotivRechaDesblData recMotivRechaDesbl, Vector localizationLabels): Salida");
      }
      public void remove(Vector recMotivDesbl)throws MareException
      {
        UtilidadesLog.info("DAORECMotivDesbRecha.remove(Vector recMotivDesbl): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
            
         int cant = recMotivDesbl.size();
        RecMotivRechaDesblData recMotivRechaDesbl = null;
         String oidMotivDesbl = "";
         for (int j = 0; j < cant; j++) {
                recMotivRechaDesbl = (RecMotivRechaDesblData)recMotivDesbl.get(j);
                 
                oidMotivDesbl = oidMotivDesbl + "," + recMotivRechaDesbl.getId();
         }
         update.append("delete REC_MOTIV_RECHA_DESBL ");
         update.append("where OID_MOTI_RECH_DESB in ( " + oidMotivDesbl.substring(1) + ") ");
          
         updateInter.append("delete GEN_I18N_SICC_PAIS ");
         updateInter.append(" where VAL_OID in ( " + oidMotivDesbl.substring(1) + ") ");
         updateInter.append(" and ATTR_NUM_ATRI = 1 ");
         updateInter.append(" and ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL' ");
          
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
        UtilidadesLog.info("DAORECMotivDesbRecha.remove(Vector recMotivDesbl): Salida");
      }
}
