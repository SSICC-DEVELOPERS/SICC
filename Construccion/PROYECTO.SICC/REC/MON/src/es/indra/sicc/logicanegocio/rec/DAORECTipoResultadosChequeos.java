package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.RecResulChequData;
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

public class DAORECTipoResultadosChequeos {
    public DAORECTipoResultadosChequeos() {
    }
    public Hashtable guardarDAORECTipoResultadoChequeo(RecResulChequData recResulChequ, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAORECTipoResultadoChequeos.guardarDAORECTipoResultadoChequeo(RecResulChequData recResulChequ, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT REC_RECQ_SEQ.NEXTVAL FROM DUAL ");
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
       update.append(" INSERT INTO REC_RESUL_CHEQU  ( ");
       update.append("             OID_RESU_CHEQ ");
       update.append("             , COD_RESU_CHEQ ");
       update.append("             , IND_RESU ");
       update.append("             , PAIS_OID_PAIS ");
       update.append("  ) VALUES (  ");
       update.append(id);
       update.append(" , '" + recResulChequ.getCodResuCheq() + "'");
       update.append(" , " + recResulChequ.getIndResu());
       update.append(", " + recResulChequ.getPaisOidPais().getId());
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
               updateInter.append(" 'REC_RESUL_CHEQU', ");
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
       UtilidadesLog.info("DAORECTipoResultadoChequeos.guardarDAORECTipoResultadoChequeo(RecResulChequData recResulChequ, Vector localizationLabels, HashMap userProperties): Salida");
       return primaryKey;
     }
     public Vector query(RecResulChequData recResulChequFrom, RecResulChequData recResulChequTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAORECTipoResultadoChequeos.query(RecResulChequData recResulChequFrom, RecResulChequData recResulChequTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append(" SELECT REC_RESUL_CHEQU.OID_RESU_CHEQ, REC_RESUL_CHEQU.COD_RESU_CHEQ, ");
       query.append("        V_GEN_I18N_SICC.VAL_I18N, REC_RESUL_CHEQU.IND_RESU, SEG_PAIS.OID_PAIS ");
       query.append("        FROM REC_RESUL_CHEQU, V_GEN_I18N_SICC, SEG_PAIS ");
       query.append("             WHERE REC_RESUL_CHEQU.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
       if(recResulChequFrom.getPaisOidPais() != null)
       {
         query.append("                 AND SEG_PAIS.OID_PAIS =  " + recResulChequFrom.getPaisOidPais().getId());
       }
       if(recResulChequFrom.getIndResu() != null)
       {
         query.append("                 AND REC_RESUL_CHEQU.IND_RESU =  " + recResulChequFrom.getIndResu());
        }
        if(recResulChequFrom.getCodResuCheq() != null)
        {
          query.append("                AND REC_RESUL_CHEQU.COD_RESU_CHEQ LIKE '" + recResulChequFrom.getCodResuCheq() +"'");
        }
        query.append("                  AND V_GEN_I18N_SICC.ATTR_ENTI = 'REC_RESUL_CHEQU' ");
        query.append("                  AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("                  AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("                  AND V_GEN_I18N_SICC.VAL_OID = REC_RESUL_CHEQU.OID_RESU_CHEQ");
        if(recResulChequFrom.getDescripcion() != null)
        {
          query.append("                AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + recResulChequFrom.getDescripcion() + "'");
        }
        if(recResulChequFrom.getId() != null)
        {
          query.append("                AND REC_RESUL_CHEQU.OID_RESU_CHEQ = " + recResulChequFrom.getId());
        }
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        RecResulChequData recResulChequ = null;
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
                     recResulChequ = new RecResulChequData();
                     recResulChequ.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_RESU_CHEQ")).toString()));
                     recResulChequ.setCodResuCheq((String)rs.getValueAt(i,"COD_RESU_CHEQ"));
                     recResulChequ.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     recResulChequ.setIndResu(new Long(((BigDecimal)rs.getValueAt(i,"IND_RESU")).toString()));
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     recResulChequ.setPaisOidPais(segPaisViewFrom);
                     result.add(recResulChequ);
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
        UtilidadesLog.info("DAORECTipoResultadoChequeos.query(RecResulChequData recResulChequFrom, RecResulChequData recResulChequTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
     }
     public void update(RecResulChequData recResulChequ, Vector localizationLabels)throws MareException
     {
        UtilidadesLog.info("DAORECTipoResultadoChequeos.update(RecResulChequData recResulChequ, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
       
        deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
        deleteInter.append(" where VAL_OID = " + recResulChequ.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'REC_RESUL_CHEQU' ");
        
        try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
               
        } catch (Exception ex) {
               ex.printStackTrace();                      
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
        }
         update.append("UPDATE REC_RESUL_CHEQU SET ");
         update.append("       IND_RESU = " + recResulChequ.getIndResu());
         update.append(" where OID_RESU_CHEQ = " + recResulChequ.getId());
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
            updateInter.append(" 'REC_RESUL_CHEQU', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(recResulChequ.getId() + " )");   
              
            try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
             
        }
        UtilidadesLog.info("DAORECTipoResultadoChequeos.update(RecResulChequData recResulChequ, Vector localizationLabels): Salida");
     }
     public void remove(Vector recResulChequeo)throws MareException
     {
       UtilidadesLog.info("DAORECTipoResultadoChequeos.remove(Vector recResulChequeo): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       
       int cant = recResulChequeo.size();
       RecResulChequData recResulChequ = null;
       String oidResultChequeo = "";
       for (int j = 0; j < cant; j++) {
           recResulChequ = (RecResulChequData)recResulChequeo.get(j);
            
           oidResultChequeo = oidResultChequeo + "," + recResulChequ.getId();
       }
       update.append("delete REC_RESUL_CHEQU  ");
       update.append("where OID_RESU_CHEQ in ( " + oidResultChequeo.substring(1) + ") ");
       
       updateInter.append("delete GEN_I18N_SICC_PAIS ");
       updateInter.append(" where VAL_OID in ( " + oidResultChequeo.substring(1) + ") ");
       updateInter.append(" and ATTR_NUM_ATRI = 1 ");
       updateInter.append(" and ATTR_ENTI = 'REC_RESUL_CHEQU' ");
       
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
       UtilidadesLog.info("DAOCalMotivosContactos.remove(Vector calMotivoContacto): Salida ");
     
     }
}
