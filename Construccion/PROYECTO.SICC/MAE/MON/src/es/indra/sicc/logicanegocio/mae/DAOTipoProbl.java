package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeTipoProblData;
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

public class DAOTipoProbl {
    public DAOTipoProbl() {
    }
    public Vector query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {
           UtilidadesLog.info("DAOTipoProbl.query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
           
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
           query.append("SELECT MTP.OID_TIPO_PROB, MTP.PAIS_OID_PAIS, MTP.COD_TIPO_PROB, i18n.VAL_I18N ");
           query.append("FROM MAE_TIPO_PROBL MTP, v_gen_i18n_sicc i18n ");
           query.append("WHERE MTP.PAIS_OID_PAIS = " + pais.longValue());
           query.append(" AND MTP.OID_TIPO_PROB = i18n.val_oid ");
           query.append("AND i18n.ATTR_ENTI = 'MAE_TIPO_PROBL' ");
           query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
           query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
           
           if (maeTipoProblFrom.getCodTipoProb()!=null)
               query.append(" AND MTP.COD_TIPO_PROB = '" + maeTipoProblFrom.getCodTipoProb().trim() + "'");
           
           if (maeTipoProblFrom.getDescripcion()!=null)        
               query.append(" AND  upper(i18n.val_i18n) LIKE '%" + maeTipoProblFrom.getDescripcion().trim().toUpperCase() + "%'");    

           if (maeTipoProblFrom.getId()!=null)        
               query.append(" AND MTP.OID_TIPO_PROB = " + maeTipoProblFrom.getId().longValue());

           try {
               rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }      
             
           int cant = rs.getRowCount();
           MaeTipoProblData  maeTipoProblData  = null;
           int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
           int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
           
           UtilidadesLog.debug("rsSaltar: " + rsSaltar);
           UtilidadesLog.debug("rsMostrar: " + rsMostrar);
           
           for(int i=0; i < cant; i++){
           
               if(i < rsSaltar ) {
                   continue;
               }
               if(i < rsMostrar){ 
               
                   SegPaisViewData segPaisViewData = new SegPaisViewData();
                   maeTipoProblData = new MaeTipoProblData();
                   
                   segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                   
                   maeTipoProblData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PROB")).toString()));
                   maeTipoProblData.setCodTipoProb((String)rs.getValueAt(i,"COD_TIPO_PROB"));
                   maeTipoProblData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                   maeTipoProblData.setPaisOidPais(segPaisViewData);
                   
                   resultado.add(maeTipoProblData);
               }
           }
           UtilidadesLog.info("DAOTipoProbl.query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return resultado;
       }
       
       public void remove(Vector entities) throws MareException
       {
           UtilidadesLog.info("DAOTipoProbl.remove(Vector entities): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           MaeTipoProblData maeTipoProblData = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               maeTipoProblData = (MaeTipoProblData)entities.get(j);
                
               oids = oids + "," + maeTipoProblData.getId();
           }
           update.append("delete from MAE_TIPO_PROBL ");
           update.append("where OID_TIPO_PROB in ( " + oids.substring(1) + ") ");

           updateInter.append("delete from GEN_I18N_SICC_PAIS ");
           updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_PROBL' ");
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
           UtilidadesLog.info("DAOTipoProbl.remove(Vector entities): Salida");
       }
       
       public void update(MaeTipoProblData maeTipoProbl, Vector localizationLabels) throws MareException
       {
           UtilidadesLog.info("DAOTipoProbl.update(MaeTipoProblData maeTipoProbl, Vector localizationLabels): Entrada");
           try{
               RecordSet rs = null;
               BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
               int cant = localizationLabels.size();
               GenDetaSiccData genDetaSiccData = null;
               StringBuffer updateInter = null;
               
               updateInter = new StringBuffer();
               updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
               updateInter.append(" where VAL_OID in ( " + maeTipoProbl.getId().longValue() + ") ");
               updateInter.append(" and ATTR_NUM_ATRI = 1 ");
               updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_PROBL' ");
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
                   updateInter.append(" 'MAE_TIPO_PROBL', ");
                   updateInter.append(" 1, ");
                   updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                   updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                   updateInter.append(maeTipoProbl.getId().longValue() + " )");                
                   try {
                       int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                   } catch (Exception ex) {
                       ex.printStackTrace();
                       throw new MareException(ex, UtilidadesError.armarCodigoError(
                                               CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                   }
               }
               StringBuffer update = new StringBuffer();     
               
               update.append("UPDATE MAE_TIPO_PROBL SET ");                
               update.append("PAIS_OID_PAIS = " + maeTipoProbl.getPaisOidPais().getId());
               update.append(", COD_TIPO_PROB = '" + maeTipoProbl.getCodTipoProb().trim() + "'");
               update.append(" WHERE OID_TIPO_PROB = " + maeTipoProbl.getId().longValue());
               
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
           UtilidadesLog.info("DAOTipoProbl.update(MaeTipoProblData maeTipoProbl, Vector localizationLabels): Salida");
       }
    
       public Hashtable guardar(MaeTipoProblData maeTipoProbl, Vector localizationLabels, HashMap userProperties) throws MareException
       {
           UtilidadesLog.info("DAOTipoProbl.guardar(MaeTipoProblData maeTipoProbl, Vector localizationLabels, HashMap userProperties): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();        
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT MAE_TIPB_SEQ.NEXTVAL FROM DUAL");         
           
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
           update.append("INSERT INTO MAE_TIPO_PROBL ( ");
           update.append("OID_TIPO_PROB "); 
           update.append(", PAIS_OID_PAIS");    
           update.append(", COD_TIPO_PROB");    
           update.append(" ) VALUES ( ");      
           update.append(id);
           update.append(", " + maeTipoProbl.getPaisOidPais().getId().longValue());
           update.append(", '" + maeTipoProbl.getCodTipoProb() + "'");
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
               updateInter.append(" 'MAE_TIPO_PROBL', ");
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
           UtilidadesLog.info("DAOTipoProbl.guardar(MaeTipoProblData maeTipoProbl, Vector localizationLabels, HashMap userProperties): Salida");
           return primaryKey;
       }
       
       public Vector query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties) throws MareException
       {
           UtilidadesLog.info("DAOTipoProbl.query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties): Entrada");
           RecordSet rs = new RecordSet();
           StringBuffer query = new StringBuffer();
           BelcorpService bs;
           
           UtilidadesLog.debug("maeTipoProblFrom: " + maeTipoProblFrom.getDescripcion());
           UtilidadesLog.debug("1");

           try {
             bs = BelcorpService.getInstance();
           } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           }
           
           Property idioma = (Property)userProperties.get("Idioma");
           Long pais   = (Long)userProperties.get("loidPais");
           UtilidadesLog.debug("2");
           query.append("SELECT MTP.OID_TIPO_PROB, MTP.PAIS_OID_PAIS, ");
           query.append("MTP.COD_TIPO_PROB, i18n.VAL_I18N ");
           query.append("FROM MAE_TIPO_PROBL MTP, v_gen_i18n_sicc i18n ");
           query.append("WHERE MTP.PAIS_OID_PAIS = " + pais.longValue());
           query.append(" AND MTP.OID_TIPO_PROB = i18n.val_oid ");
           query.append("AND i18n.ATTR_ENTI = 'MAE_TIPO_PROBL' ");
           query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
           query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
           
           UtilidadesLog.debug("3");

           if (maeTipoProblFrom.getId()!=null)
               query.append(" AND MTP.OID_TIPO_PROB = " + maeTipoProblFrom.getId().longValue());
           UtilidadesLog.debug("4");
           if (maeTipoProblFrom.getCodTipoProb()!=null)
               query.append(" AND MTP.COD_TIPO_PROB = '" + maeTipoProblFrom.getCodTipoProb().trim() + "'");

           UtilidadesLog.debug("8");

           try {
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }        
           UtilidadesLog.debug("9");    
           int cant = rs.getRowCount();
           Vector result = new Vector();
           
           MaeTipoProblData maeTipoProblData = null;
           for(int i=0; i < cant; i++){
               maeTipoProblData = new MaeTipoProblData();
               
               if (rs.getValueAt(i,"OID_TIPO_PROB")!=null)
                   maeTipoProblData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PROB")).toString()));
               
               if (rs.getValueAt(i,"COD_TIPO_PROB")!=null)
                   maeTipoProblData.setCodTipoProb(rs.getValueAt(i,"COD_TIPO_PROB").toString());
               
               if (rs.getValueAt(i,"VAL_I18N")!=null)
                   maeTipoProblData.setDescripcion(rs.getValueAt(i,"VAL_I18N").toString());
               
               if (rs.getValueAt(i,"PAIS_OID_PAIS")!=null){
                   SegPaisViewData segPaisViewData = new SegPaisViewData();
                   segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                   maeTipoProblData.setPaisOidPais(segPaisViewData);
               }
               result.add(maeTipoProblData);
           }
           UtilidadesLog.debug("result: " + result);
           UtilidadesLog.info("DAOTipoProbl.query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties): Salida");
           return result;
       }

}
