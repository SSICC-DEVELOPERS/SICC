package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.MaeNegocData;
import es.indra.belcorp.mso.PedImpueNegocData;
import es.indra.belcorp.mso.PedTasaImpueData;
import es.indra.belcorp.mso.SegAccesData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.belcorp.mso.SegSubacData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
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

public class DAOImpuestosNegocio {
    public DAOImpuestosNegocio() {
    }
    public Vector query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOImpuestosNegocio.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;  
        try
        {
            bs = BelcorpService.getInstance();
               
        }catch(Exception ex)
        {
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT NEGOCIO.VAL_OID, NEGOCIO.VAL_I18N ");
        query.append(" FROM V_GEN_I18N_SICC NEGOCIO, MAE_NEGOC ");
        query.append(" WHERE NEGOCIO.ATTR_ENTI = 'MAE_NEGOC' ");
        query.append(" AND NEGOCIO.ATTR_NUM_ATRI = 1 ");
        query.append(" AND NEGOCIO.IDIO_OID_IDIO = 1 ");
        query.append(" AND NEGOCIO.VAL_OID = MAE_NEGOC.OID_NEGO ");
        query.append(" ORDER BY NEGOCIO.VAL_I18N ");
        
         try
         {
            rs = bs.dbService.executeStaticQuery(query.toString());
         
         }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         try{
            for(int i= 0; i < rs.getRowCount(); i++){
              MaeNegocData salida= new MaeNegocData();
              salida.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
              salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
              parametros.add(salida);
            }
            }catch(Exception ex)
            {
              ex.printStackTrace();
            }
        UtilidadesLog.info("DAOImpuestosNegocio.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties): Salida");    
        return parametros;
      }
      public Hashtable guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, Vector localizationLabels, HashMap userProperties )throws MareException
      {
         UtilidadesLog.info("DAOImpuestosNegocio.guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, Vector localizationLabels, HashMap userProperties ): Entrada ");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT PED_IMNE_SEQ.NEXTVAL FROM DUAL ");
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
          update.append(" INSERT INTO PED_IMPUE_NEGOC ( ");
          update.append(" OID_IMPU_NEGO, ");
          update.append(" NEGO_OID_NEGO, ");
          update.append(" TAIM_OID_TASA_IMPU, ");
          update.append("   PAIS_OID_PAIS,");
          update.append(" SBAC_OID_SBAC");
          update.append(" ) VALUES ( ");
          update.append(id );
          update.append(", " + pedImpueNegoc.getNegoOidNego().getId());
          update.append(", " + pedImpueNegoc.getTaimOidTasaImpu().getId());
          update.append(", "+ pedImpueNegoc.getPaisOidPais().getId());
          update.append(", " + pedImpueNegoc.getSbacOidSbac().getId());
          update.append( " ) ");
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
          UtilidadesLog.info("DAOImpuestosNegocio.guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, Vector localizationLabels, HashMap userProperties ): Salida ");
          return primaryKey;   
      }
      public Vector query(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException{
         UtilidadesLog.info("DAOImpuestosNegocio.query(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada ");
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
            query.append(" SELECT PED_IMPUE_NEGOC.OID_IMPU_NEGO, SUBACCESO.VAL_I18N DESSUBACCESO, SUBACCESO.VAL_OID OIDSUBACCESO, ");
            query.append(" NEGOCIO.VAL_I18N DESNEGOCIO, NEGOCIO.VAL_OID OIDNEGOCIO, TASAIMPUESTO.VAL_I18N DESTASA, TASAIMPUESTO.VAL_OID OIDTASA, ");
            query.append(" CANAL.VAL_I18N DESCANAL, CANAL.VAL_OID OIDCANAL, ACCES.VAL_I18N DESACCESO, ACCES.VAL_OID OIDACCESO, SEG_PAIS.OID_PAIS  ");
            
            query.append(" FROM V_GEN_I18N_SICC SUBACCESO, SEG_SUBAC, ");
            query.append(" PED_IMPUE_NEGOC, MAE_NEGOC, SEG_PAIS, ");
            query.append(" PED_TASA_IMPUE, V_GEN_I18N_SICC NEGOCIO, ");
            query.append(" V_GEN_I18N_SICC TASAIMPUESTO, SEG_CANAL, ");
            query.append(" SEG_ACCES, V_GEN_I18N_SICC CANAL, V_GEN_I18N_SICC ACCES ");
            
            query.append(" WHERE PED_IMPUE_NEGOC.NEGO_OID_NEGO = MAE_NEGOC.OID_NEGO ");
            if(pedImpueNegocFrom.getNegoOidNego() != null)
            {
                query.append("   AND MAE_NEGOC.OID_NEGO = " + pedImpueNegocFrom.getNegoOidNego().getId());
            }
            query.append("       AND PED_IMPUE_NEGOC.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
            if(pedImpueNegocFrom.getPaisOidPais() != null)
            {
                query.append("     AND SEG_PAIS.OID_PAIS = " + pedImpueNegocFrom.getPaisOidPais().getId());
            }
            query.append("       AND PED_IMPUE_NEGOC.SBAC_OID_SBAC = SEG_SUBAC.OID_SBAC ");
            if(pedImpueNegocFrom.getSbacOidSbac() != null){
                query.append("AND SEG_SUBAC.OID_SBAC = " + pedImpueNegocFrom.getSbacOidSbac().getId());
            }else
            {
              Property userID = (Property)userProperties.get("userID");
              query.append("  AND SEG_SUBAC.OID_SBAC IN (SELECT OID_SBAC from VCA_SEG_SUBAC where COD_USUA='"+ userID.getValue()+"')" );               
            }
            query.append("       AND SEG_SUBAC.ACCE_OID_ACCE = SEG_ACCES.OID_ACCE ");
            query.append("       AND SEG_ACCES.CANA_OID_CANA = SEG_CANAL.OID_CANA ");
            query.append("       AND PED_IMPUE_NEGOC.TAIM_OID_TASA_IMPU = PED_TASA_IMPUE.OID_TASA_IMPU  ");
            if(pedImpueNegocFrom.getTaimOidTasaImpu() != null){
              query.append("    AND PED_TASA_IMPUE.OID_TASA_IMPU = " + pedImpueNegocFrom.getTaimOidTasaImpu().getId());
            }
            
            query.append("       AND SUBACCESO.ATTR_ENTI = 'SEG_SUBAC' ");
            query.append("      AND SUBACCESO.ATTR_NUM_ATRI = 1  ");
            query.append("      AND SUBACCESO.IDIO_OID_IDIO = 1  ");
            
            
            query.append("      AND SUBACCESO.VAL_OID = SEG_SUBAC.OID_SBAC ");
            
            query.append("      AND NEGOCIO.ATTR_ENTI = 'MAE_NEGOC' ");
            query.append("      AND NEGOCIO.ATTR_NUM_ATRI = 1  ");
            query.append("      AND NEGOCIO.IDIO_OID_IDIO = 1 ");
            query.append("      AND NEGOCIO.VAL_OID = MAE_NEGOC.OID_NEGO ");
            
            query.append("      AND TASAIMPUESTO.ATTR_ENTI = 'PED_TASA_IMPUE' ");
            query.append("      AND TASAIMPUESTO.ATTR_NUM_ATRI = 1 ");
            query.append("      AND TASAIMPUESTO.IDIO_OID_IDIO = 1 ");
            query.append("      AND TASAIMPUESTO.VAL_OID = PED_TASA_IMPUE.OID_TASA_IMPU ");
            
            query.append("      AND CANAL.ATTR_ENTI = 'SEG_CANAL'  ");
            query.append("      AND CANAL.ATTR_NUM_ATRI = 1 ");
            query.append("      AND CANAL.IDIO_OID_IDIO = 1 ");
            query.append("      AND CANAL.VAL_OID = SEG_CANAL.OID_CANA ");
            
            query.append("      AND ACCES.ATTR_ENTI = 'SEG_ACCES' ");
            query.append("      AND ACCES.ATTR_NUM_ATRI = 1 ");
            query.append("      AND ACCES.IDIO_OID_IDIO = 1 ");
            query.append("      AND ACCES.VAL_OID = SEG_ACCES.OID_ACCE ");
            
            if(pedImpueNegocFrom.getId() != null){
              query.append(" AND PED_IMPUE_NEGOC.OID_IMPU_NEGO = " + pedImpueNegocFrom.getId());
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
             PedImpueNegocData pedImpueNegoc = null;
             SegPaisViewData segPaisViewFrom = null; 
             SegAccesData segAccesFrom = null;
             SegCanalViewData segCanalViewData = null;
             SegSubacData segSubAcFrom = null;
             MaeNegocData maeNegocFrom = null;
             PedTasaImpueData pedTasaImpueFrom = null;
             
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
                     pedImpueNegoc = new PedImpueNegocData();     
                     pedImpueNegoc.setId(new Long (((BigDecimal)rs.getValueAt(i,"OID_IMPU_NEGO")).toString()));
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId(new Long (((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     pedImpueNegoc.setPaisOidPais(segPaisViewFrom);
                     
                     segCanalViewData = new SegCanalViewData();
                     segCanalViewData.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDCANAL")).toString()));
                     segCanalViewData.setDescripcion((String)rs.getValueAt(i,"DESCANAL"));
                     
                     segAccesFrom = new SegAccesData();
                     segAccesFrom.setCanaOidCana(segCanalViewData);
                     segAccesFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDACCESO")).toString()));
                     segAccesFrom.setDescripcion((String)rs.getValueAt(i, "DESACCESO"));
                     
                     segSubAcFrom = new SegSubacData();
                     segSubAcFrom.setAcceOidAcce(segAccesFrom);
                     segSubAcFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDSUBACCESO")).toString()));
                     segSubAcFrom.setDescripcion((String)rs.getValueAt(i,"DESSUBACCESO"));
                     pedImpueNegoc.setSbacOidSbac(segSubAcFrom);
                     
                     maeNegocFrom = new MaeNegocData();
                     maeNegocFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDNEGOCIO")).toString()));
                     maeNegocFrom.setDescripcion((String)rs.getValueAt(i,"DESNEGOCIO"));
                     pedImpueNegoc.setNegoOidNego(maeNegocFrom);
                     
                     pedTasaImpueFrom = new PedTasaImpueData();
                     pedTasaImpueFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDTASA")).toString()));
                     pedTasaImpueFrom.setDescripcion((String)rs.getValueAt(i,"DESTASA"));
                     
                     pedImpueNegoc.setTaimOidTasaImpu(pedTasaImpueFrom);  
                    
                     result.add(pedImpueNegoc);
                  
                             
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
             UtilidadesLog.info("DAOImpuestosNegocio.query(PedImpueNegocData pedImpueNegocFrom, PedImpueNegocData pedImpueNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida "); 
             return result;
      
      }
      public void update(PedImpueNegocData pedImpueNegoc, Vector localizationLabels)throws MareException
      {
        UtilidadesLog.info("DAOImpuestosNegocio.update(PedImpueNegocData pedImpueNegoc, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         update.append("UPDATE PED_IMPUE_NEGOC SET ");
         update.append(" TAIM_OID_TASA_IMPU = " + pedImpueNegoc.getTaimOidTasaImpu().getId());        
         update.append(" where OID_IMPU_NEGO = " + pedImpueNegoc.getId());
          try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                
          }catch (Exception ex) {
               ex.printStackTrace();
              if(ex.toString().indexOf("ORA-00001")!= -1) {
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
              } else {
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
          }
        UtilidadesLog.info("DAOImpuestosNegocio.update(PedImpueNegocData pedImpueNegoc, Vector localizationLabels): Salida");     
      }
      public void remove(Vector pedImpueNegoc)throws MareException
      {
        UtilidadesLog.info("DAOImpuestosNegocio.remove(Vector pedImpueNegoc): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         int cant = pedImpueNegoc.size();
         PedImpueNegocData  pedFormuData = null;
         String oidImpuestosNegocio = "";
         for (int j = 0; j < cant; j++) {
               pedFormuData = (PedImpueNegocData)pedImpueNegoc.get(j);
                 
               oidImpuestosNegocio = oidImpuestosNegocio + "," + pedFormuData.getId();
          }
          update.append("delete PED_IMPUE_NEGOC  ");
          update.append("where OID_IMPU_NEGO in ( " + oidImpuestosNegocio.substring(1) + ") ");
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
         UtilidadesLog.info("DAOImpuestosNegocio.remove(Vector pedImpueNegoc): Salida");   
      }
}
