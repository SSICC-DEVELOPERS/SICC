package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.PedTipoDespaData;
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

public class DAOTipoDespacho {
    public DAOTipoDespacho() {
    }
    public Hashtable guardarTipoDespacho(PedTipoDespaData pedTipoDespa, Vector localizationLabels, HashMap userProperties)throws MareException 
     {
       UtilidadesLog.info("DAOTipoDespacho.guardarTipoDespacho(PedTipoDespaData pedTipoDespa, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT PED_TIDS_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO PED_TIPO_DESPA( ");
        update.append(" OID_TIPO_DESP, ");
        update.append(" PAIS_OID_PAIS, ");
        update.append(" COD_TIPO_DESP, ");
        update.append(" IND_CRON  ");
        update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" ," + pedTipoDespa.getPaisOidPais().getId());
        update.append(" , '" + pedTipoDespa.getCodTipoDesp() + "' ");
        if(pedTipoDespa.getIndCron().booleanValue()){
             update.append(" , 1 ");
        }else{
             update.append(" , 0 ");
        }
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
               updateInter.append(" 'PED_TIPO_DESPA', ");
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
         UtilidadesLog.info("DAOTipoDespacho.guardarTipoDespacho(PedTipoDespaData pedTipoDespa, Vector localizationLabels, HashMap userProperties): Entrada");
         return primaryKey; 
     }
     public Vector query(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAOTipoDespacho.query(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
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
       query.append(" SELECT PED_TIPO_DESPA.OID_TIPO_DESP, PED_TIPO_DESPA.COD_TIPO_DESP, ");
       query.append("        TIPODESPACHO.VAL_I18N DESCRIPCION, PED_TIPO_DESPA.IND_CRON, ");
       query.append("        PED_TIPO_DESPA.PAIS_OID_PAIS ");
       query.append("        FROM PED_TIPO_DESPA, V_GEN_I18N_SICC TIPODESPACHO, SEG_PAIS ");
       query.append("        WHERE PED_TIPO_DESPA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
       if(pedTipoDespaFrom.getCodTipoDesp() != null){
             query.append("  AND PED_TIPO_DESPA.COD_TIPO_DESP LIKE '" + pedTipoDespaFrom.getCodTipoDesp() + "'");
       }
       if(pedTipoDespaFrom.getIndCron() != null){
           if(pedTipoDespaFrom.getIndCron().booleanValue())
           {
             query.append("      AND PED_TIPO_DESPA.IND_CRON = 1 ");
           }else
           {
             query.append("      AND PED_TIPO_DESPA.IND_CRON = 0 ");
           }
       }
       query.append("        AND TIPODESPACHO.ATTR_ENTI = 'PED_TIPO_DESPA' ");
       query.append("        AND TIPODESPACHO.ATTR_NUM_ATRI = 1 ");
       query.append("        AND TIPODESPACHO.IDIO_OID_IDIO = 1 ");
       query.append("        AND TIPODESPACHO.VAL_OID = PED_TIPO_DESPA.OID_TIPO_DESP ");
       if(pedTipoDespaFrom.getDescripcion() != null)
       {
         query.append("      AND TIPODESPACHO.VAL_I18N LIKE '" + pedTipoDespaFrom.getDescripcion() + "'");
       }
       if(pedTipoDespaFrom.getId() != null){
       
          query.append("     AND  PED_TIPO_DESPA.OID_TIPO_DESP = " +  pedTipoDespaFrom.getId());
       }
       query.append(" order by TIPODESPACHO.VAL_I18N desc ");
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
            PedTipoDespaData pedTipoDespa = null;
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
                        pedTipoDespa = new PedTipoDespaData();
                        pedTipoDespa.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_DESP")).toString()));
                        pedTipoDespa.setCodTipoDesp((String)rs.getValueAt(i,"COD_TIPO_DESP"));
                        pedTipoDespa.setDescripcion((String)rs.getValueAt(i,"DESCRIPCION"));
                        segPaisViewFrom = new SegPaisViewData();
                        segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                        pedTipoDespa.setPaisOidPais(segPaisViewFrom);
                        if(((BigDecimal)rs.getValueAt(i, "IND_CRON")).equals(new BigDecimal("1")))
                        {
                          pedTipoDespa.setIndCron(Boolean.TRUE);
                        }else
                        {
                          pedTipoDespa.setIndCron(Boolean.FALSE);
                        }
                        result.add(pedTipoDespa);
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
           UtilidadesLog.info("DAOTipoDespacho.query(PedTipoDespaData pedTipoDespaFrom, PedTipoDespaData pedTipoDespaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida "); 
           return result; 
     }
     public void update(PedTipoDespaData pedTipoDespa, Vector localizationLabels)throws MareException
     {
        UtilidadesLog.info("DAOTipoDespacho.update(PedTipoDespaData pedTipoDespa, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
       
        deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + pedTipoDespa.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'PED_TIPO_DESPA' ");
        
         try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
               
         } catch (Exception ex) {
               ex.printStackTrace();                      
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
         }
         update.append(" UPDATE PED_TIPO_DESPA SET ");
         update.append("  PAIS_OID_PAIS =" + pedTipoDespa.getPaisOidPais().getId());
         update.append("  ,COD_TIPO_DESP = '" + pedTipoDespa.getCodTipoDesp() + "' " );
         if(pedTipoDespa.getIndCron().booleanValue()){  
               update.append("  , IND_CRON = 1 ");
         }else
         {
               update.append("  , IND_CRON = 0 ");
         }
         update.append(" where PED_TIPO_DESPA.OID_TIPO_DESP = " + pedTipoDespa.getId());
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
            updateInter.append(" 'PED_TIPO_DESPA', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(pedTipoDespa.getId() + " )");   
              
            try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
             
        }
      UtilidadesLog.info("DAOTipoDespacho.update(PedTipoDespaData pedTipoDespa, Vector localizationLabels): Salida");  
     }
     public void remove(Vector pedTipoDespa)throws MareException
     {
       UtilidadesLog.info("DAOTipoDespacho.remove(Vector pedTipoDespa): Entrada ");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
           
        int cant = pedTipoDespa.size();
        PedTipoDespaData pedTipoDespaFrom = null;
        String oidTipoDespacho = "";
        for (int j = 0; j < cant; j++) {
               pedTipoDespaFrom = (PedTipoDespaData)pedTipoDespa.get(j);
                
               oidTipoDespacho = oidTipoDespacho + "," + pedTipoDespaFrom.getId();
        }
         update.append("delete PED_TIPO_DESPA ");
         update.append("where OID_TIPO_DESP in ( " + oidTipoDespacho.substring(1) + ") ");
         
         updateInter.append("delete GEN_I18N_SICC_COMUN ");
         updateInter.append(" where VAL_OID in ( " + oidTipoDespacho.substring(1) + ") ");
         updateInter.append(" and ATTR_NUM_ATRI = 1 ");
         updateInter.append(" and ATTR_ENTI = 'PED_TIPO_DESPA' ");
         
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
        UtilidadesLog.info("DAOTipoDespacho.remove(Vector pedTipoDespa): Salida ");
     }
}
