package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedImpueGenerData;
import es.indra.belcorp.mso.PedTasaImpueData;
import es.indra.belcorp.mso.SegAccesData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.belcorp.mso.SegSubacData;
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

public class DAOImpuestosGenerales {
    public DAOImpuestosGenerales() {
    }
    public Vector query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DOAImpuestoGenerales.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties): Entrada");
       RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                 bs = BelcorpService.getInstance();
           
             } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             } 
           query.append(" SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
           query.append(" FROM V_GEN_I18N_SICC, PED_TASA_IMPUE ");
           query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'PED_TASA_IMPUE' ");
           query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
           query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
           query.append(" AND V_GEN_I18N_SICC.VAL_OID = PED_TASA_IMPUE.OID_TASA_IMPU ");
           query.append(" ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
            try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
             } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
         if(!rs.esVacio())
         {
           for(int i= 0; i < rs.getRowCount(); i++){
             PedTasaImpueData salida = new PedTasaImpueData();
             salida.setId(new Long(((BigDecimal) rs.getValueAt(i,"VAL_OID")).toString()));
             salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
             parametros.add(salida);
           }
         } 
         UtilidadesLog.info("DOAImpuestoGenerales.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties): Entrada");
         return parametros;  
     }
     public Hashtable guardarImpuestosGenerales(PedImpueGenerData pedImpueGener, Vector localizationLabels,HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOImpuestosGenerales(PedImpueGenerData pedImpueGener, Vector localizationLabels,HashMap userProperties): Entrada");   
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT PED_IMGE_SEQ.NEXTVAL FROM DUAL ");
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
         try{
         update.append(" INSERT INTO PED_IMPUE_GENER (");
         update.append(" OID_IMPU_GENE, ");
         update.append(" TAIM_OID_TASA_IMPU, ");
         update.append(" IND_TASA_UNIC, ");
         update.append(" PAIS_OID_PAIS, ");
         update.append(" SBAC_OID_SBAC, ");
         update.append(" TAIM_OID_TASA_IMPU_FLET");
         update.append(" ) VALUES ( ");
         update.append(id );
         update.append(", " + pedImpueGener.getTaimOidTasaImpu().getId());
        
         if(pedImpueGener.getIndTasaUnic().booleanValue())
         {
           update.append(", 1 ");
         }else
         {
           update.append(", 0 ");
         }
         update.append(", "+ pedImpueGener.getPaisOidPais().getId());
         update.append(", " + pedImpueGener.getSbacOidSbac().getId());
         if(pedImpueGener.getTaimOidTasaImpuFlet() != null){
            update.append(", "+ pedImpueGener.getTaimOidTasaImpuFlet().getId());
         }else
         {
           update.append(", NULL");
         }
         
         update.append( " ) ");
         }catch(Exception ex)
         {
           ex.printStackTrace();
         }
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
         Hashtable primaryKey = new Hashtable();
         primaryKey.put("id", id); 
         UtilidadesLog.info("DAOImpuestosGenerales(PedImpueGenerData pedImpueGener, Vector localizationLabels,HashMap userProperties): Salida");   
         return primaryKey;   
     }
     public Vector query(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
     {
      UtilidadesLog.info("DAOImpuestoGenerales.query(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada "); 
      
      
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
           query.append(" SELECT PED_IMPUE_GENER.OID_IMPU_GENE, SUBACCESO.VAL_I18N DESSUBAC, SUBACCESO.VAL_OID OIDSUB,");
           query.append(" SEG_PAIS.OID_PAIS, TASAIMPUESTO.VAL_I18N DESIMPUESTO, TASAIMPUESTO.VAL_OID OIDIMPUESTO, ");
           query.append(" DESFLETE.VAL_I18N DESFLETE, DESFLETE.VAL_OID OIDFLETE, ");
           query.append(" PED_IMPUE_GENER.IND_TASA_UNIC, CANAL.VAL_I18N DESCANAL, CANAL.VAL_OID OIDCANAL, ");
           query.append(" ACCESO.VAL_I18N DESACCES, ACCESO.VAL_OID OIDACCES ");
           
           query.append(" FROM PED_IMPUE_GENER, V_GEN_I18N_SICC SUBACCESO, SEG_SUBAC, ");
           query.append(" SEG_PAIS, V_GEN_I18N_SICC TASAIMPUESTO, PED_TASA_IMPUE IMPUE, ");
           query.append(" PED_TASA_IMPUE FLE, V_GEN_I18N_SICC DESFLETE, ");
           query.append(" V_GEN_I18N_SICC CANAL, V_GEN_I18N_SICC ACCESO, SEG_CANAL, ");
           query.append(" SEG_ACCES ");
           
           query.append(" WHERE PED_IMPUE_GENER.SBAC_OID_SBAC = SEG_SUBAC.OID_SBAC ");
           query.append(" AND SEG_SUBAC.OID_SBAC IN( SELECT OID_SBAC from VCA_SEG_SUBAC where COD_USUA='PEPRUEBAS') ");
           query.append(" AND SEG_SUBAC.ACCE_OID_ACCE = SEG_ACCES.OID_ACCE ");
           query.append(" AND SEG_ACCES.CANA_OID_CANA = SEG_CANAL.OID_CANA ");
           query.append(" AND PED_IMPUE_GENER.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
           if(pedImpueGenerFrom.getPaisOidPais() != null)
           {
             query.append(" AND SEG_PAIS.OID_PAIS = " + pedImpueGenerFrom.getPaisOidPais().getId());
           }
           query.append(" AND PED_IMPUE_GENER.TAIM_OID_TASA_IMPU =   IMPUE.OID_TASA_IMPU ");
           if(pedImpueGenerFrom.getTaimOidTasaImpu() != null)
           {
             query.append(" AND IMPUE.OID_TASA_IMPU = " + pedImpueGenerFrom.getTaimOidTasaImpu().getId());
           }
           query.append(" AND PED_IMPUE_GENER.TAIM_OID_TASA_IMPU_FLET = FLE.OID_TASA_IMPU(+) ");
           if(pedImpueGenerFrom.getTaimOidTasaImpuFlet() != null)
           {
             query.append(" AND FLE.OID_TASA_IMPU = " + pedImpueGenerFrom.getTaimOidTasaImpuFlet().getId());
           }
           
           UtilidadesLog.debug("pedImpueGenerFrom.getIndTasaUnic(): " + pedImpueGenerFrom.getIndTasaUnic());
           
          if(pedImpueGenerFrom.getIndTasaUnic() != null){
          // UtilidadesLog.debug("entro");
             if(!pedImpueGenerFrom.getIndTasaUnic().booleanValue()){
                 query.append("  AND ped_impue_gener.IND_TASA_UNIC = 0 " );
             }else
             {
                query.append("  AND ped_impue_gener.IND_TASA_UNIC = 1 ");
             }        
          }  
           
           query.append(" AND SUBACCESO.ATTR_ENTI = 'SEG_SUBAC' ");
           query.append(" AND SUBACCESO.ATTR_NUM_ATRI = 1 ");
           query.append(" AND SUBACCESO.IDIO_OID_IDIO = 1 ");
           query.append(" AND SUBACCESO.VAL_OID = SEG_SUBAC.OID_SBAC ");
           
           query.append(" AND TASAIMPUESTO.ATTR_ENTI = 'PED_TASA_IMPUE' ");
           query.append(" AND TASAIMPUESTO.ATTR_NUM_ATRI = 1 ");
           query.append(" AND TASAIMPUESTO.IDIO_OID_IDIO = 1 ");
           query.append(" AND TASAIMPUESTO.VAL_OID =   IMPUE.OID_TASA_IMPU ");
           
           query.append(" AND DESFLETE.ATTR_ENTI (+)= 'PED_TASA_IMPUE' ");
           query.append(" AND DESFLETE.ATTR_NUM_ATRI (+)= 1 ");
           query.append(" AND DESFLETE.IDIO_OID_IDIO (+)= 1 ");
           query.append(" AND DESFLETE.VAL_OID (+)= FLE.OID_TASA_IMPU ");
           
           query.append(" AND CANAL.ATTR_ENTI = 'SEG_CANAL' ");
           query.append(" AND CANAL.ATTR_NUM_ATRI = 1 ");
           query.append(" AND CANAL.IDIO_OID_IDIO = 1 ");
           query.append(" AND CANAL.VAL_OID =      SEG_CANAL.OID_CANA ");
           
           query.append(" AND ACCESO.ATTR_ENTI = 'SEG_ACCES' ");
           query.append(" AND ACCESO.ATTR_NUM_ATRI = 1 ");
           query.append(" AND ACCESO.IDIO_OID_IDIO = 1 ");
           query.append(" AND ACCESO.VAL_OID = SEG_ACCES.OID_ACCE ");
           
           if(pedImpueGenerFrom.getId() != null)
           {
             query.append(" AND PED_IMPUE_GENER.OID_IMPU_GENE =  " +pedImpueGenerFrom.getId());
           }
           }catch(Exception ex)
           {
             ex.printStackTrace();
           }
          try {         
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
           
             ex.printStackTrace();
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
            int cant = rs.getRowCount();
            Vector result = new Vector();
            PedImpueGenerData pedImpueGener = null;
            PedTasaImpueData pedTasaImpued = null;
            PedTasaImpueData pedTasaFlete = null;
            SegPaisViewData segPaisViewFrom = null; 
            SegAccesData segAccesFrom = null;
            SegCanalViewData segCanalViewData = null;
            SegSubacData segSubAcFrom = null; 
            boolean indicador = false;
            String num = null;
            BigDecimal oidFlete = null;
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
                 pedImpueGener = new PedImpueGenerData();
                 pedImpueGener.setId(new Long(((BigDecimal) rs.getValueAt(i,"OID_IMPU_GENE")).toString()));
                 segCanalViewData = new SegCanalViewData();
                 segCanalViewData.setId(new Long(((BigDecimal) rs.getValueAt(i,"OIDCANAL")).toString()));
                 segCanalViewData.setDescripcion((String)rs.getValueAt(i,"DESCANAL"));
                 segAccesFrom = new SegAccesData() ;
                 segAccesFrom.setCanaOidCana(segCanalViewData);
                 segAccesFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDACCES")).toString()));
                 segAccesFrom.setDescripcion((String)rs.getValueAt(i,"DESACCES"));
                 segSubAcFrom = new SegSubacData();
                 segSubAcFrom.setAcceOidAcce(segAccesFrom);
                 segSubAcFrom.setId(new Long(((BigDecimal) rs.getValueAt(i,"OIDSUB")).toString()));
                 segSubAcFrom.setDescripcion((String)rs.getValueAt(i,"DESSUBAC"));
                 pedImpueGener.setSbacOidSbac(segSubAcFrom);
                 segPaisViewFrom = new SegPaisViewData();
                 segPaisViewFrom.setId(new Long(((BigDecimal) rs.getValueAt(i,"OID_PAIS")).toString()));
                 pedImpueGener.setPaisOidPais(segPaisViewFrom);
                 //num = ((BigDecimal)rs.getValueAt(i, "IND_TASA_UNIC")).toString();
                 if(((BigDecimal)rs.getValueAt(i, "IND_TASA_UNIC")).equals(new BigDecimal("1"))){
                  UtilidadesLog.debug(" entra");
                   pedImpueGener.setIndTasaUnic(Boolean.TRUE);
                 }else
                 {
                   pedImpueGener.setIndTasaUnic(Boolean.FALSE);
                 }
                 
                 pedTasaImpued = new PedTasaImpueData();
                 pedTasaImpued.setId(new Long(((BigDecimal) rs.getValueAt(i,"OIDIMPUESTO")).toString()));
                 pedTasaImpued.setDescripcion((String)rs.getValueAt(i,"DESIMPUESTO"));
                 pedImpueGener.setTaimOidTasaImpu(pedTasaImpued);
                 oidFlete = (BigDecimal)rs.getValueAt(i,"OIDFLETE");
                 if(oidFlete != null)
                 {
                     pedTasaFlete = new PedTasaImpueData();
                     pedTasaFlete.setId(Long.valueOf(oidFlete.toString()));
                     pedTasaFlete.setDescripcion((String)rs.getValueAt(i,"DESFLETE"));
                     pedImpueGener.setTaimOidTasaImpuFlet(pedTasaFlete);
                 }
                 result.add(pedImpueGener);
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
        
            UtilidadesLog.info("DAOImpuestoGenerales.query(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida "); 
            return result; 
      
            
     }
     public void update(PedImpueGenerData pedImpueGener, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAOImpuestosGenerales.update(PedImpueGenerData pedImpueGener, Vector localizationLabels): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = null;    
       
       update.append(" UPDATE PED_IMPUE_GENER SET");
       update.append(" TAIM_OID_TASA_IMPU = " + pedImpueGener.getTaimOidTasaImpu().getId());
       if(pedImpueGener.getIndTasaUnic().booleanValue())
         {
           update.append(" ,IND_TASA_UNIC = 1 ");
         }else
         {
           update.append(" ,IND_TASA_UNIC = 0 ");
         }
       update.append(" ,PAIS_OID_PAIS = " + pedImpueGener.getPaisOidPais().getId());
       update.append(" ,SBAC_OID_SBAC = " + pedImpueGener.getSbacOidSbac().getId());
       if(pedImpueGener.getTaimOidTasaImpuFlet() != null)
       {
         update.append(" , TAIM_OID_TASA_IMPU_FLET = " + pedImpueGener.getTaimOidTasaImpuFlet().getId());
       }else
       {
         update.append(" , TAIM_OID_TASA_IMPU_FLET = NULL");
       }
       update.append(" where OID_IMPU_GENE = " + pedImpueGener.getId());
       try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
               
            } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
        UtilidadesLog.info("DAOImpuestosGenerales.update(PedImpueGenerData pedImpueGener, Vector localizationLabels): Salida ");   
          
     }
     public void remove(Vector pedImpueGenerFrom)throws MareException
     {
           UtilidadesLog.info("DAOImpuestosGenerales.remove(Vector pedImpueGenerFrom): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = pedImpueGenerFrom.size();
           PedImpueGenerData pedImpueGener = null;
           String oidImpuestosGenerales = "";
           for (int j = 0; j < cant; j++) {
               pedImpueGener = (PedImpueGenerData)pedImpueGenerFrom.get(j);
                
               oidImpuestosGenerales = oidImpuestosGenerales + "," + pedImpueGener.getId();
           }
           update.append("delete PED_IMPUE_GENER  ");
           update.append("where OID_IMPU_GENE in ( " + oidImpuestosGenerales.substring(1) + ") ");
          try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString()); 
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
         UtilidadesLog.info("DAOImpuestosGenerales.remove(Vector pedImpueGenerFrom): Salida");  
     }
}
