package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.PedSubtiPosicData;
import es.indra.belcorp.mso.PedTipoPosicData;
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

public class DAOSubtipoPosicion {
    public DAOSubtipoPosicion() {
    }
    public Hashtable guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels, HashMap userProperties)throws MareException
      {
          UtilidadesLog.info("DAOSubtipoPosicion.guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels, HashMap userProperties): Entrada ");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();     
          StringBuffer updateInter = null;
          StringBuffer update = new StringBuffer();
          RecordSet rsPK = null;
          StringBuffer query = new StringBuffer();      
          Long id = null;
          query.append(" SELECT PED_STPO_SEQ.NEXTVAL FROM DUAL ");
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
          update.append(" INSERT INTO PED_SUBTI_POSIC ( ");
          update.append("  OID_SUBT_POSI, ");
          update.append("  COD_SUBT_POSI, ");
          update.append(" TPOS_OID_TIPO_POSI ");
          update.append(" ) VALUES ( ");
          update.append(id);
          update.append(", '" + pedSubtiPosic.getCodSubtPosi() + "'");
          update.append(", " + pedSubtiPosic.getTposOidTipoPosi().getId());
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
                updateInter.append(" 'PED_SUBTI_POSIC', ");
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
          UtilidadesLog.info("DAOSubtipoPosicion.guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels, HashMap userProperties): Salida ");
          return primaryKey;    
         
         
      }
      public Vector query(PedSubtiPosicData pedSubtiPosicFrom, PedSubtiPosicData pedSubtiPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOSubtipoPosicion.query(PedSubtiPosicData pedSubtiPosicFrom, PedSubtiPosicData pedSubtiPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
           query.append(" SELECT PED_SUBTI_POSIC.OID_SUBT_POSI, PED_SUBTI_POSIC.COD_SUBT_POSI, ");
           query.append(" TIPOPOS.VAL_I18N DESTIPO, TIPOPOS.VAL_OID OIDTIPO,  ");
           query.append(" SUBTIPO.VAL_I18N DESSUBTIPO ");
           query.append("  FROM PED_SUBTI_POSIC, V_GEN_I18N_SICC SUBTIPO, ");
           query.append("       PED_TIPO_POSIC, V_GEN_I18N_SICC TIPOPOS ");
           query.append("       WHERE PED_SUBTI_POSIC.TPOS_OID_TIPO_POSI = PED_TIPO_POSIC.OID_TIPO_POSI  ");
           if(pedSubtiPosicFrom.getTposOidTipoPosi() != null)
           {
             query.append(" AND PED_TIPO_POSIC.OID_TIPO_POSI = "+ pedSubtiPosicFrom.getTposOidTipoPosi().getId());
           }
           if(pedSubtiPosicFrom.getCodSubtPosi() != null)
           {
             query.append(" AND PED_SUBTI_POSIC.COD_SUBT_POSI LIKE '" + pedSubtiPosicFrom.getCodSubtPosi()+"'");
           }
           query.append(" AND SUBTIPO.ATTR_ENTI = 'PED_SUBTI_POSIC' ");
           query.append(" AND SUBTIPO.ATTR_NUM_ATRI = 1 ");
           query.append(" AND SUBTIPO.IDIO_OID_IDIO = 1 ");
           query.append(" AND SUBTIPO.VAL_OID =  PED_SUBTI_POSIC.OID_SUBT_POSI ");
           if(pedSubtiPosicFrom.getDescripcion() != null)
           {
             query.append(" AND SUBTIPO.VAL_I18N LIKE '" + pedSubtiPosicFrom.getDescripcion()+"' ");
           }
           query.append("    AND TIPOPOS.ATTR_ENTI = 'PED_TIPO_POSIC' ");
           query.append("    AND TIPOPOS.ATTR_NUM_ATRI = 1 ");
           query.append("    AND TIPOPOS.IDIO_OID_IDIO = 1 ");
           query.append("    AND TIPOPOS.VAL_OID =  PED_TIPO_POSIC.OID_TIPO_POSI ");
           if(pedSubtiPosicFrom.getId() != null)
           {
             query.append(" AND PED_SUBTI_POSIC.OID_SUBT_POSI = " + pedSubtiPosicFrom.getId());
           }
            try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             PedSubtiPosicData pedSubtiPosic = null;
             PedTipoPosicData pedTipoPosicFrom = null;
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
                   pedSubtiPosic = new PedSubtiPosicData();    
                   pedSubtiPosic.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUBT_POSI")).toString()));
                   pedSubtiPosic.setCodSubtPosi((String)rs.getValueAt(i,"COD_SUBT_POSI"));
                   pedSubtiPosic.setDescripcion((String)rs.getValueAt(i,"DESSUBTIPO"));
                   pedTipoPosicFrom = new PedTipoPosicData ();
                   pedTipoPosicFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDTIPO")).toString()));
                   pedTipoPosicFrom.setDescripcion((String)rs.getValueAt(i,"DESTIPO"));
                   pedSubtiPosic.setTposOidTipoPosi(pedTipoPosicFrom);
                   result.add(pedSubtiPosic);
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
             UtilidadesLog.info("DAOSubtipoPosicion.query(PedSubtiPosicData pedSubtiPosicFrom, PedSubtiPosicData pedSubtiPosicTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
             return result;
      }
      public void update(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels)throws MareException
      {
        UtilidadesLog.info("DAOSubtipoPosicion.update(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels): Entrada");
        RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
         
         deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
         deleteInter.append(" where VAL_OID = " + pedSubtiPosic.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'PED_SUBTI_POSIC' ");
         
         try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
         } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
         }
         
         
         update.append("UPDATE  PED_SUBTI_POSIC SET");
         update.append("  COD_SUBT_POSI = '" + pedSubtiPosic.getCodSubtPosi()+ "'");
         update.append("  , TPOS_OID_TIPO_POSI = " + pedSubtiPosic.getTposOidTipoPosi().getId());
         update.append(" WHERE OID_SUBT_POSI = " + pedSubtiPosic.getId());
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
             updateInter.append(" 'PED_SUBTI_POSIC', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(pedSubtiPosic.getId() + " )");   
               
             try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
              
         }
         UtilidadesLog.info("DAOSubtipoPosicion.update(PedSubtiPosicData pedSubtiPosic, Vector localizationLabels): Salida");   
      }
      public void remove(Vector pedSubtiPosic)throws MareException
      {
            UtilidadesLog.info("DAOSubtipoPosicion,remove(Vector pesSubtiPosic): Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant =  pedSubtiPosic.size();
            PedSubtiPosicData  pedFormuData = null;
            String oidSubtipoPosic = "";
             for (int j = 0; j < cant; j++) {
                pedFormuData = (PedSubtiPosicData)pedSubtiPosic.get(j);
                 
                oidSubtipoPosic = oidSubtipoPosic + "," + pedFormuData.getId();
            }
             update.append("delete PED_SUBTI_POSIC  ");
             update.append("where OID_SUBT_POSI in ( " + oidSubtipoPosic.substring(1) + ") ");
             
             updateInter.append("delete GEN_I18N_SICC_COMUN ");
             updateInter.append(" where VAL_OID in ( " + oidSubtipoPosic.substring(1) + ") ");
             updateInter.append(" and ATTR_NUM_ATRI = 1 ");
             updateInter.append(" and ATTR_ENTI = 'PED_SUBTI_POSIC' ");
            
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
           UtilidadesLog.info("DAOSubtipoPosicion,remove(Vector pesSubtiPosic): Salida ");  
      }
}
