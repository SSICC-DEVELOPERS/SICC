package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.PedTasaImpueData;
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

public class DAOTasaImpuesto {
    public DAOTasaImpuesto() {
    }
    public  Hashtable  guardarTasaImpuesto(PedTasaImpueData pedTasaImpue, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOTasaImpuesto.guardarTasaImpuesto(PedTasaImpueData pedTasaImpue, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT PED_TAIM_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO PED_TASA_IMPUE( ");
        update.append("    OID_TASA_IMPU, ");
        update.append("    VAL_INDI_IMPU, ");
        update.append("    PAIS_OID_PAIS,  ");
        update.append("     VAL_TASA_IMPU ");
         update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" , '" + pedTasaImpue.getValIndiImpu() + "'");
        update.append(" ," + pedTasaImpue.getPaisOidPais().getId());
        update.append(" ," + pedTasaImpue.getValTasaImpu());
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
                    
                updateInter.append(" INSERT INTO GEN_I18N_SICC ( ");
                updateInter.append("OID_I18N, "); 
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(idInter + ", ");
                updateInter.append(" 'PED_TASA_IMPUE', ");
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
          UtilidadesLog.info("DAOTasaImpuesto.guardarTasaImpuesto(PedTasaImpueData pedTasaImpue, Vector localizationLabels, HashMap userProperties): Entrada");
          return primaryKey;    
      }
      public Vector query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
      {
        UtilidadesLog.info("DAOTasaImpuesto.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada ");
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
        query.append(" SELECT PED_TASA_IMPUE.OID_TASA_IMPU, PED_TASA_IMPUE.VAL_INDI_IMPU, ");
        query.append(" TASAIMPUESTO.VAL_I18N DESCRIPCION, PED_TASA_IMPUE.VAL_TASA_IMPU, ");
        query.append(" PED_TASA_IMPUE.PAIS_OID_PAIS ");
        query.append("  FROM PED_TASA_IMPUE, V_GEN_I18N_SICC TASAIMPUESTO, SEG_PAIS ");
        query.append("  WHERE PED_TASA_IMPUE.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS");
        if(pedTasaImpueFrom.getPaisOidPais() != null)
        {
          query.append(" AND SEG_PAIS.OID_PAIS = " + pedTasaImpueFrom.getPaisOidPais().getId());
        }
        if(pedTasaImpueFrom.getValIndiImpu() != null)
        {
          query.append(" AND PED_TASA_IMPUE.VAL_INDI_IMPU LIKE '" + pedTasaImpueFrom.getValIndiImpu() + "' ");
        }
        if(pedTasaImpueFrom.getValTasaImpu() != null)
        {
          query.append(" AND PED_TASA_IMPUE.VAL_TASA_IMPU = " + pedTasaImpueFrom.getValTasaImpu());
        }
        query.append(" AND TASAIMPUESTO.ATTR_ENTI = 'PED_TASA_IMPUE' ");
        query.append(" AND TASAIMPUESTO.ATTR_NUM_ATRI = 1 ");
        query.append(" AND TASAIMPUESTO.IDIO_OID_IDIO = 1 ");
        query.append(" AND TASAIMPUESTO.VAL_OID = PED_TASA_IMPUE.OID_TASA_IMPU ");
        if(pedTasaImpueFrom.getDescripcion() != null)
        {
          query.append(" AND TASAIMPUESTO.VAL_I18N LIKE '" + pedTasaImpueFrom.getDescripcion() + "' ");
        }
        if(pedTasaImpueFrom.getId() != null)
        {
          query.append("AND PED_TASA_IMPUE.OID_TASA_IMPU =" + pedTasaImpueFrom.getId());
        }
        query.append(" order by tasaimpuesto.VAL_I18N desc");
         try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             PedTasaImpueData pedTasaImpue = null;
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
                   pedTasaImpue = new PedTasaImpueData();
                   pedTasaImpue.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TASA_IMPU")).toString()));
                   segPaisViewFrom = new SegPaisViewData();
                   segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                   pedTasaImpue.setPaisOidPais(segPaisViewFrom);
                   pedTasaImpue.setValIndiImpu((String)rs.getValueAt(i,"VAL_INDI_IMPU"));
                   pedTasaImpue.setDescripcion((String)rs.getValueAt(i,"DESCRIPCION"));
                   pedTasaImpue.setValTasaImpu( Double.valueOf(rs.getValueAt(i,"VAL_TASA_IMPU").toString()));
                   result.add(pedTasaImpue);
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
            UtilidadesLog.info("DAOTasaImpuesto.query(PedTasaImpueData pedTasaImpueFrom, PedTasaImpueData pedTasaImpueTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida ");
            return result; 
      }
      public void update(PedTasaImpueData pedTasaImpue, Vector localizationLabels)throws MareException
      {
         UtilidadesLog.info("DAOTasaImpuestos.update(PedTasaImpueData pedTasaImpue, Vector localizationLabels): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
        
         deleteInter.append(" delete GEN_I18N_SICC ");
         deleteInter.append(" where VAL_OID = " + pedTasaImpue.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'PED_TASA_IMPUE' ");
         
          try {
                int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
          } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
          }
          update.append(" UPDATE PED_TASA_IMPUE SET ");
          update.append(" VAL_INDI_IMPU = '" + pedTasaImpue.getValIndiImpu() +"' ");
          update.append(" , PAIS_OID_PAIS = " + pedTasaImpue.getPaisOidPais().getId());
          update.append(" , VAL_TASA_IMPU = " + pedTasaImpue.getValTasaImpu());
          update.append(" where OID_TASA_IMPU = " + pedTasaImpue.getId());
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
             updateInter.append(" INSERT INTO GEN_I18N_SICC ( ");
             updateInter.append("OID_I18N, "); 
             updateInter.append("ATTR_ENTI, "); 
             updateInter.append("ATTR_NUM_ATRI, "); 
             updateInter.append("IDIO_OID_IDIO, "); 
             updateInter.append("VAL_I18N, ");                 
             updateInter.append("VAL_OID "); 
             updateInter.append(" ) VALUES ( ");
             updateInter.append(idInter + ", ");
             updateInter.append(" 'PED_TASA_IMPUE', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(pedTasaImpue.getId() + " )");   
               
             try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
              
         }
        UtilidadesLog.info("DAOTasaImpuestos.update(PedTasaImpueData pedTasaImpue, Vector localizationLabels): Salida"); 
      }
      public void remove(Vector pedTasaFrom)throws MareException
      {
         UtilidadesLog.info("DAOTasaImpuestos.remove(Vector pedTasaFrom): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = new StringBuffer();
            
         int cant = pedTasaFrom.size();
         PedTasaImpueData pedTasaImpue = null;
         String oidTasaImpuesto = "";
         for (int j = 0; j < cant; j++) {
                pedTasaImpue = (PedTasaImpueData)pedTasaFrom.get(j);
                 
                oidTasaImpuesto = oidTasaImpuesto + "," + pedTasaImpue.getId();
         }
         update.append("delete PED_TASA_IMPUE ");
         update.append("where OID_TASA_IMPU in ( " + oidTasaImpuesto.substring(1) + ") ");
          
         updateInter.append("delete GEN_I18N_SICC ");
         updateInter.append(" where VAL_OID in ( " + oidTasaImpuesto.substring(1) + ") ");
         updateInter.append(" and ATTR_NUM_ATRI = 1 ");
         updateInter.append(" and ATTR_ENTI = 'PED_TASA_IMPUE' ");
            
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
       UtilidadesLog.info("DAOTasaImpuestos.remove(Vector pedTasaFrom): Salida");   
      }
}
