package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeTipoProblData;
import es.indra.belcorp.mso.MaeTipoProblTipoSolucData;
import es.indra.belcorp.mso.MaeTipoSolucData;
import es.indra.belcorp.mso.SegPaisViewData;
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

public class DAOTipoProblTipoSoluc {
    public DAOTipoProblTipoSoluc() {
    }
    public Vector query(MaeTipoProblTipoSolucData maeTipoProblTipoSolucFrom, 
                           MaeTipoProblTipoSolucData maeTipoProblTipoSolucTo, 
                           HashMap userProperties, Integer pageCount, 
                           Integer pageSize) throws MareException
       {
           UtilidadesLog.info("DAOTipoProblTipoSoluc.query(MaeTipoProblTipoSolucData maeTipoProblTipoSolucFrom, MaeTipoProblTipoSolucData maeTipoProblTipoSolucTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
           UtilidadesLog.debug("maeTipoProblTipoSolucFrom: " + maeTipoProblTipoSolucFrom.getId());
           
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
           
           Vector resultado = new Vector();

           try {
             bs = BelcorpService.getInstance();
           } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           }
           
           Property idioma = (Property)userProperties.get("Idioma");
           Long pais   = (Long)userProperties.get("loidPais");
           query.append("SELECT MTPTS.OID_TIPO_PROB_TIPO_SOLU, MTPTS.TIPB_OID_TIPO_PROB, ");
           query.append("MTPTS.TSOC_OID_TIPO_SOLU, MTP.COD_TIPO_PROB, MTS.COD_TIPO_SOLU, ");
           query.append("i18n.VAL_I18N as descr_tipo_probl, i18n1.VAL_I18N as descr_tipo_soluc, ");
           query.append("MTP.PAIS_OID_PAIS as PTP, MTS.PAIS_OID_PAIS as PTS ");
           query.append("FROM MAE_TIPO_PROBL_TIPO_SOLUC MTPTS, MAE_TIPO_PROBL MTP, MAE_TIPO_SOLUC MTS, ");
           query.append("v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
           query.append("WHERE MTPTS.TIPB_OID_TIPO_PROB = MTP.OID_TIPO_PROB ");
           query.append("AND MTPTS.TSOC_OID_TIPO_SOLU = MTS.OID_TIPO_SOLU ");
           query.append("AND i18n.val_oid = MTP.OID_TIPO_PROB ");
           query.append("AND i18n.ATTR_ENTI = 'MAE_TIPO_PROBL' ");
           query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
           query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
           query.append(" AND i18n1.val_oid = MTS.OID_TIPO_SOLU ");
           query.append("AND i18n1.ATTR_ENTI = 'MAE_TIPO_SOLUC' "); 
           query.append("AND i18n1.ATTR_NUM_ATRI = 1 ");
           query.append(" AND i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());
           
           if (maeTipoProblTipoSolucFrom.getId()!=null)
               query.append(" AND MTPTS.OID_TIPO_PROB_TIPO_SOLU = " + maeTipoProblTipoSolucFrom.getId().longValue());

           if (maeTipoProblTipoSolucFrom.getTipbOidTipoProb()!=null)
               if (maeTipoProblTipoSolucFrom.getTipbOidTipoProb().getId()!=null)   
                   query.append(" AND MTP.OID_TIPO_PROB = " + maeTipoProblTipoSolucFrom.getTipbOidTipoProb().getId().longValue());
           if (maeTipoProblTipoSolucFrom.getTsocOidTipoSolu()!=null)
               if (maeTipoProblTipoSolucFrom.getTsocOidTipoSolu().getId()!=null)   
                   query.append(" AND MTS.OID_TIPO_SOLU = " + maeTipoProblTipoSolucFrom.getTsocOidTipoSolu().getId().longValue());

           try {
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }        
               
           int cant = rs.getRowCount();
           Vector result = new Vector();
           
           MaeTipoProblTipoSolucData maeTipoProblTipoSolucData = null;
           MaeTipoProblData maeTipoProblData = null;
           MaeTipoSolucData maeTipoSolucData = null;
           
           int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
           int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
           
           UtilidadesLog.debug("rsSaltar: " + rsSaltar);
           UtilidadesLog.debug("rsMostrar: " + rsMostrar);

           for(int i=0; i < cant; i++){
           
               if(i < rsSaltar ) {
                   continue;
               }
               if(i < rsMostrar){        
           
                   maeTipoProblTipoSolucData = new MaeTipoProblTipoSolucData();
                   
                   maeTipoProblData = new MaeTipoProblData();
                   maeTipoSolucData = new MaeTipoSolucData();
                   
                   if (rs.getValueAt(i,"TSOC_OID_TIPO_SOLU")!=null)
                       maeTipoSolucData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TSOC_OID_TIPO_SOLU")).toString()));
                   if (rs.getValueAt(i,"COD_TIPO_SOLU")!=null)
                       maeTipoSolucData.setCodTipoSolu(rs.getValueAt(i,"COD_TIPO_SOLU").toString());
                   if (rs.getValueAt(i,"DESCR_TIPO_SOLUC")!=null)    
                       maeTipoSolucData.setDescripcion(rs.getValueAt(i,"DESCR_TIPO_SOLUC").toString());
                   if (rs.getValueAt(i,"PTS")!=null){        
                       SegPaisViewData segPaisViewData = new SegPaisViewData();
                       segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PTS")).toString()));
                       maeTipoSolucData.setPaisOidPais(segPaisViewData);
                   }
               
                   if (rs.getValueAt(i,"TIPB_OID_TIPO_PROB")!=null)
                       maeTipoProblData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIPB_OID_TIPO_PROB")).toString()));
                   if (rs.getValueAt(i,"COD_TIPO_PROB")!=null)
                       maeTipoProblData.setCodTipoProb(rs.getValueAt(i,"COD_TIPO_PROB").toString());
                   if (rs.getValueAt(i,"DESCR_TIPO_PROBL")!=null)    
                       maeTipoProblData.setDescripcion(rs.getValueAt(i,"DESCR_TIPO_PROBL").toString());
                   if (rs.getValueAt(i,"PTP")!=null){        
                       SegPaisViewData segPaisViewData = new SegPaisViewData();
                       segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PTP")).toString()));
                       maeTipoProblData.setPaisOidPais(segPaisViewData);
                   }
                   
                   if (rs.getValueAt(i,"OID_TIPO_PROB_TIPO_SOLU")!=null)
                       maeTipoProblTipoSolucData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PROB_TIPO_SOLU")).toString()));
               
                   maeTipoProblTipoSolucData.setTipbOidTipoProb(maeTipoProblData);
                   maeTipoProblTipoSolucData.setTsocOidTipoSolu(maeTipoSolucData);
                   
                   UtilidadesLog.debug("maeTipoProblTipoSolucData: " + maeTipoProblTipoSolucData);
                   UtilidadesLog.debug("maeTipoProblData: " + maeTipoProblData);
                   UtilidadesLog.debug("maeTipoSolucData: " + maeTipoSolucData);
                   
                   result.add(maeTipoProblTipoSolucData);
               }
           
           }
           UtilidadesLog.info("DAOTipoProblTipoSoluc.query(MaeTipoProblTipoSolucData maeTipoProblTipoSolucFrom, MaeTipoProblTipoSolucData maeTipoProblTipoSolucTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
       }
    
       public Hashtable guardar(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, Vector localizationLabels, HashMap userProperties) throws MareException
       {
           UtilidadesLog.info("DAOTipoProblTipoSoluc.guardar(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, Vector localizationLabels, HashMap userProperties): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();        
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT MAE_TPRS_SEQ.NEXTVAL FROM DUAL");         
           
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
           update.append("INSERT INTO MAE_TIPO_PROBL_TIPO_SOLUC ( ");
           update.append("OID_TIPO_PROB_TIPO_SOLU, ");
           update.append("TIPB_OID_TIPO_PROB, ");
           update.append("TSOC_OID_TIPO_SOLU");
           update.append(" ) VALUES ( ");      
           update.append(id);
           update.append(", " + maeTipoProblTipoSoluc.getTipbOidTipoProb().getId().longValue());
           update.append(", " + maeTipoProblTipoSoluc.getTsocOidTipoSolu().getId().longValue());
           update.append(") ");
           
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
           StringBuffer updateInter = null;
           
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
               updateInter.append(" 'MAE_TIPO_PROBL_TIPO_SOLUC', ");
               updateInter.append(" 1, ");            
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
           UtilidadesLog.info("DAOTipoProblTipoSoluc.guardar(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, Vector localizationLabels, HashMap userProperties): Salida");
           return primaryKey;
       }

       public void remove(Vector entities) throws MareException
       {
           UtilidadesLog.info("DAOTipoProblTipoSoluc.remove(Vector entities): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           MaeTipoProblTipoSolucData maeTipoProblTipoSolucData = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               maeTipoProblTipoSolucData = (MaeTipoProblTipoSolucData)entities.get(j);
                
               oids = oids + "," + maeTipoProblTipoSolucData.getId();
           }
           update.append("delete from MAE_TIPO_PROBL_TIPO_SOLUC ");
           update.append("where OID_TIPO_PROB_TIPO_SOLU in ( " + oids.substring(1) + ") ");

           updateInter.append("delete from GEN_I18N_SICC_PAIS ");
           updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_PROBL_TIPO_SOLUC' ");
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
           UtilidadesLog.info("DAOTipoProblTipoSoluc.remove(Vector entities): Salida");
       }

       public void update(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, Vector localizationLabels) throws MareException
       {
           UtilidadesLog.info("DAOTipoPrefer.update(MaeTipoPrefeData maeTipoPrefe, Vector localizationLabels): Entrada");
           try{
               RecordSet rs = null;
               BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
               int cant = localizationLabels.size();
               GenDetaSiccData genDetaSiccData = null;
               StringBuffer updateInter = null;
               
               updateInter = new StringBuffer();
               updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
               updateInter.append(" where VAL_OID in ( " + maeTipoProblTipoSoluc.getId().longValue() + ") ");
               updateInter.append(" and ATTR_NUM_ATRI = 1 ");
               updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_PROBL_TIPO_SOLUC' ");
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
               
               for(int i= 0; i< cant; i++){                      
                   genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
                   UtilidadesLog.info("genDetaSiccData: " + genDetaSiccData.getDeta());
                   updateInter = new StringBuffer();
                   updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
                   updateInter.append("OID_I18N, ");
                   updateInter.append("ATTR_ENTI, "); 
                   updateInter.append("ATTR_NUM_ATRI, "); 
                   updateInter.append("IDIO_OID_IDIO, "); 
                   updateInter.append("VAL_I18N, ");                 
                   updateInter.append("VAL_OID "); 
                   updateInter.append(" ) VALUES ( ");
                   updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");                
                   updateInter.append(" 'MAE_TIPO_PROBL_TIPO_SOLUC', ");
                   updateInter.append(" 1, ");
                   updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                   updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                   updateInter.append(maeTipoProblTipoSoluc.getId().longValue() + " )");                
                   try {
                       int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                   } catch (Exception ex) {
                       ex.printStackTrace();
                       throw new MareException(ex, UtilidadesError.armarCodigoError(
                                               CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                   }
               }
               StringBuffer update = new StringBuffer();     
               
               update.append("UPDATE MAE_TIPO_PROBL_TIPO_SOLUC SET ");                
               update.append("PTIPB_OID_TIPO_PROB = " + maeTipoProblTipoSoluc.getTipbOidTipoProb().getId().longValue());
               update.append(", TSOC_OID_TIPO_SOLU = " + maeTipoProblTipoSoluc.getTsocOidTipoSolu().getId().longValue());
               update.append(" WHERE OID_TIPO_PREF = " + maeTipoProblTipoSoluc.getId().longValue());
               
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
           } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
           UtilidadesLog.info("DAOTipoPrefer.update(MaeTipoPrefeData maeTipoPrefe, Vector localizationLabels): Salida");
       }

}
