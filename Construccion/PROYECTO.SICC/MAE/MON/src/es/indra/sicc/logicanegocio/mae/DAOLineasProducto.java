package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeLineaProduData;
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

public class DAOLineasProducto {
    public DAOLineasProducto() {
    }
    public Hashtable gardarLineasProducto(MaeLineaProduData maeLineaProdu, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOLineasProducto.gardarLineasProducto(MaeLineaProduData maeLineaProdu, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT MAE_LIPR_SEQ.NEXTVAL FROM DUAL ");
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
       update.append(" INSERT INTO MAE_LINEA_PRODU (");
       update.append("  OID_LINE_PROD, ");
       update.append("  PAIS_OID_PAIS, ");
       update.append("  COD_LINE_PROD ");
       update.append(" ) VALUES ( ");
       update.append(id);
       update.append(" , " + maeLineaProdu.getPaisOidPais().getId());
       update.append(" , '" + maeLineaProdu.getCodLineProd()+ "' ");
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
                   
               updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
               updateInter.append("OID_I18N, "); 
               updateInter.append("ATTR_ENTI, "); 
               updateInter.append("ATTR_NUM_ATRI, "); 
               updateInter.append("IDIO_OID_IDIO, "); 
               updateInter.append("VAL_I18N, ");                 
               updateInter.append("VAL_OID "); 
               updateInter.append(" ) VALUES ( ");
               updateInter.append(idInter + ", ");
               updateInter.append(" 'MAE_LINEA_PRODU', ");
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
         UtilidadesLog.info("DAOLineasProducto.gardarLineasProducto(MaeLineaProduData maeLineaProdu, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(MaeLineaProduData maeLineaProduFrom, MaeLineaProduData maeLineaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAOLineasProducto.query(MaeLineaProduData maeLineaProduFrom, MaeLineaProduData maeLineaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append(" SELECT MAE_LINEA_PRODU.OID_LINE_PROD , MAE_LINEA_PRODU.COD_LINE_PROD, V_GEN_I18N_SICC.VAL_I18N DESCRIPCION, ");
       query.append("        SEG_PAIS.OID_PAIS ");
       query.append("        FROM MAE_LINEA_PRODU, V_GEN_I18N_SICC, SEG_PAIS ");
       query.append("        WHERE MAE_LINEA_PRODU.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
       if(maeLineaProduFrom.getCodLineProd() != null)
       {
           query.append("          AND MAE_LINEA_PRODU.COD_LINE_PROD LIKE '" + maeLineaProduFrom.getCodLineProd() + "' ");
       }
       query.append("         AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_LINEA_PRODU' ");
       query.append("         AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
       query.append("         AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("         AND V_GEN_I18N_SICC.VAL_OID = MAE_LINEA_PRODU.OID_LINE_PROD ");
       if( maeLineaProduFrom.getDescripcion() != null)
       {
           query.append("  AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeLineaProduFrom.getDescripcion() +  "' ");
       }
       if(maeLineaProduFrom.getId() != null)
       {
          query.append(" AND MAE_LINEA_PRODU.OID_LINE_PROD = " + maeLineaProduFrom.getId());
       }
       query.append(" ORDER BY MAE_LINEA_PRODU.COD_LINE_PROD ");
       try {
              rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       int cant = rs.getRowCount();
       Vector result = new Vector();
       MaeLineaProduData maeLineaProdu = null;
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
                       maeLineaProdu = new MaeLineaProduData();
                       maeLineaProdu.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_LINE_PROD")).toString()));
                       maeLineaProdu.setCodLineProd((String)rs.getValueAt(i,"COD_LINE_PROD"));
                       maeLineaProdu.setDescripcion((String)rs.getValueAt(i,"DESCRIPCION"));
                       segPaisViewFrom =  new SegPaisViewData(); 
                       segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                       maeLineaProdu.setPaisOidPais(segPaisViewFrom);
                       result.add(maeLineaProdu);
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
           UtilidadesLog.info("DAOLineasProducto.query(MaeLineaProduData maeLineaProduFrom, MaeLineaProduData maeLineaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
     }
     public void update(MaeLineaProduData maeLineaProdu, Vector localizationLabels)throws MareException
     {
         UtilidadesLog.info("DAOLineasProducto.update(MaeLineaProduData maeLineaProdu, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
       
         deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
         deleteInter.append(" where VAL_OID = " + maeLineaProdu.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'MAE_LINEA_PRODU' ");
        
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
             updateInter.append(" 'MAE_LINEA_PRODU', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(maeLineaProdu.getId() + " )");   
              
             try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
             
         }
        UtilidadesLog.info("DAOLineasProducto.update(MaeLineaProduData maeLineaProdu, Vector localizationLabels): Salida"); 
     }
     public void remove(Vector maeLineaProducto)throws MareException
     {
       UtilidadesLog.info("DAOLineasProducto.remove(Vector maeLineaProducto): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
           
        int cant = maeLineaProducto.size();
        MaeLineaProduData maeLineaProdu = null;
        String oidLineaProdu = "";
        for (int j = 0; j < cant; j++) {
               maeLineaProdu = (MaeLineaProduData)maeLineaProducto.get(j);
                
               oidLineaProdu = oidLineaProdu + "," + maeLineaProdu.getId();
        }
        update.append("delete MAE_LINEA_PRODU ");
        update.append("where OID_LINE_PROD in ( " + oidLineaProdu.substring(1) + ") ");
         
        updateInter.append("delete GEN_I18N_SICC_PAIS ");
        updateInter.append(" where VAL_OID in ( " + oidLineaProdu.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_LINEA_PRODU' ");
         
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
        UtilidadesLog.info("DAOLineasProducto.remove(Vector maeLineaProducto): Salida"); 
     }
}
