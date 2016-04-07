package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeMagniData;
import es.indra.belcorp.mso.MaeUnidaMedidData;
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

public class DAOUnidMedida {
    public DAOUnidMedida() {
    }
    public Vector query(MaeUnidaMedidData maeUnidaMedidFrom, MaeUnidaMedidData maeUnidaMedidTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {
           UtilidadesLog.info("DAOUnidMedida.query(MaeUnidaMedidData maeUnidaMedidFrom, MaeUnidaMedidData maeUnidaMedidTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
           
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
           query.append("SELECT MUM.OID_UNID_MEDI, MUM.PAIS_OID_PAIS, MUM.COD_UNID_MEDI, ");
           query.append("MUM.MAGN_OID_MAGN, MUM.DES_ABRE, MUM.IND_UM_STND, i18n.VAL_I18N, ");
           query.append("MM.COD_MAGN, i18n1.VAL_I18N as DESC_MAGNI ");
           query.append("FROM MAE_UNIDA_MEDID MUM, v_gen_i18n_sicc i18n, MAE_MAGNI MM, v_gen_i18n_sicc i18n1 ");
           query.append("WHERE MUM.PAIS_OID_PAIS = " + pais.longValue());
           query.append(" AND MUM.OID_UNID_MEDI = i18n.val_oid ");
           query.append("AND i18n.ATTR_ENTI = 'MAE_UNIDA_MEDID' ");
           query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
           query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
           query.append(" AND MUM.MAGN_OID_MAGN = MM.OID_MAGN ");
           query.append("AND MUM.MAGN_OID_MAGN = i18n1.val_oid ");
           query.append("AND i18n1.ATTR_ENTI = 'MAE_MAGNI' ");
           query.append("AND i18n1.ATTR_NUM_ATRI = 1 ");
           query.append("AND i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());

           if (maeUnidaMedidFrom.getId()!=null)
               query.append(" AND MUM.OID_UNID_MEDI = " + maeUnidaMedidFrom.getId().longValue());
           
           if (maeUnidaMedidFrom.getCodUnidMedi()!=null)
               query.append(" AND MUM.COD_UNID_MEDI = '" + maeUnidaMedidFrom.getCodUnidMedi().trim() + "'");
           
           if (maeUnidaMedidFrom.getDescripcion()!=null)        
               query.append(" AND  upper(i18n.val_i18n) LIKE '%" + maeUnidaMedidFrom.getDescripcion().trim().toUpperCase() + "%'");    

           if (maeUnidaMedidFrom.getDesAbre()!=null)        
               query.append(" AND MUM.DES_ABRE = '" + maeUnidaMedidFrom.getDesAbre() + "'");
               
           if (maeUnidaMedidFrom.getMagnOidMagn()!=null)        
               query.append(" AND MUM.MAGN_OID_MAGN = " + maeUnidaMedidFrom.getMagnOidMagn().getId());

           if (maeUnidaMedidFrom.getIndUmStnd()!=null)        
               query.append(" AND MUM.IND_UM_STND = " + maeUnidaMedidFrom.getIndUmStnd());

           try {
               rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }      
             
           int cant = rs.getRowCount();
           MaeUnidaMedidData  maeUnidaMedidData = null;
           MaeMagniData maeMagniData = null;
           SegPaisViewData segPaisViewData = null;
           
           int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
           int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
           
           UtilidadesLog.debug("rsSaltar: " + rsSaltar);
           UtilidadesLog.debug("rsMostrar: " + rsMostrar);
           
           for(int i=0; i < cant; i++){
           
               if(i < rsSaltar ) {
                   continue;
               }
               if(i < rsMostrar){ 
               
                   maeUnidaMedidData = new MaeUnidaMedidData();
                   maeMagniData = new MaeMagniData();
                   segPaisViewData = new SegPaisViewData();
                   
                   segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                   
                   maeUnidaMedidData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_UNID_MEDI")).toString()));
                   maeUnidaMedidData.setPaisOidPais(segPaisViewData);
                   maeUnidaMedidData.setCodUnidMedi(rs.getValueAt(i,"COD_UNID_MEDI").toString());
                   
                   maeMagniData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MAGN_OID_MAGN")).toString()));
                   maeMagniData.setCodMagn(rs.getValueAt(i,"COD_MAGN").toString());
                   maeMagniData.setDescripcion(rs.getValueAt(i,"DESC_MAGNI").toString());
                   maeUnidaMedidData.setMagnOidMagn(maeMagniData);
                   
                   
                   if (rs.getValueAt(i,"DES_ABRE")!=null)
                       maeUnidaMedidData.setDesAbre(rs.getValueAt(i,"DES_ABRE").toString());
                   
                   maeUnidaMedidData.setIndUmStnd(String.valueOf(rs.getValueAt(i,"IND_UM_STND").toString()));
                   
                   if (rs.getValueAt(i,"VAL_I18N")!=null)
                       maeUnidaMedidData.setDescripcion(rs.getValueAt(i,"VAL_I18N").toString());

                   resultado.add(maeUnidaMedidData);
               }
           }
           UtilidadesLog.info("DAOUnidMedida.query(MaeUnidaMedidData maeUnidaMedidFrom, MaeUnidaMedidData maeUnidaMedidTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return resultado;
       }
       
        public Hashtable guardar(MaeUnidaMedidData maeUnidaMedid, Vector localizationLabels, HashMap userProperties) throws MareException
        {
           UtilidadesLog.info("DAOUnidMedida.guardar(MaeUnidaMedidData maeUnidaMedid, Vector localizationLabels, HashMap userProperties): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();        
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           Long pais   = (Long)userProperties.get("loidPais");
           query.append(" SELECT MAE_UNMD_SEQ.NEXTVAL FROM DUAL");         
           
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
           update.append("INSERT INTO MAE_UNIDA_MEDID ( ");
           update.append("OID_UNID_MEDI "); 
           update.append(", PAIS_OID_PAIS");
           update.append(", COD_UNID_MEDI");    
           update.append(", MAGN_OID_MAGN");  
           
           if (maeUnidaMedid.getDesAbre()!=null)
               update.append(", DES_ABRE");    
               
           update.append(", IND_UM_STND");    
           update.append(" ) VALUES ( ");      
           update.append(id);
           update.append(", " + pais);
           update.append(", '" + maeUnidaMedid.getCodUnidMedi() + "'");
           update.append(", " + maeUnidaMedid.getMagnOidMagn().getId().longValue());
           
           if (maeUnidaMedid.getDesAbre()!=null)
               update.append(", '" + maeUnidaMedid.getDesAbre() + "'");
           
           update.append(", " + maeUnidaMedid.getIndUmStnd());
           
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
           
           UtilidadesLog.debug("1");
           
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
               UtilidadesLog.debug("2");
               if(rsPKInter != null && !rsPKInter.esVacio()) {
                   idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
               }      
               UtilidadesLog.debug("3");
               genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
               UtilidadesLog.debug("4");
               
               UtilidadesLog.debug("4: " + idInter);
               
               UtilidadesLog.debug("4a:");
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
               updateInter.append(" 'MAE_UNIDA_MEDID', ");
               updateInter.append(" 1, ");
               UtilidadesLog.debug("5");
               updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
               UtilidadesLog.debug("6");
               updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
               UtilidadesLog.debug("7");
               updateInter.append(id.longValue() + " )");  
               UtilidadesLog.debug("8");
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
           UtilidadesLog.info("DAOTipoVincu.guardar(MaeUnidaMedidData maeUnidaMedid, Vector localizationLabels, HashMap userProperties): Salida");
           return primaryKey;
       }
       
       public void remove(Vector entities) throws MareException
       {
           UtilidadesLog.info("DAOTipoVincu.remove(Vector entities): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           MaeUnidaMedidData maeUnidaMedidData  = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               maeUnidaMedidData = (MaeUnidaMedidData)entities.get(j);
                
               oids = oids + "," + maeUnidaMedidData.getId();
           }
           update.append("delete from MAE_UNIDA_MEDID ");
           update.append("where OID_UNID_MEDI in ( " + oids.substring(1) + ") ");

           updateInter.append("delete from GEN_I18N_SICC_PAIS ");
           updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'MAE_UNIDA_MEDID' ");
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
           UtilidadesLog.info("DAOTipoVincu.remove(Vector entities): Salida");
       }
       
       public void update(MaeUnidaMedidData maeUnidaMedid, Vector localizationLabels) throws MareException
       {
           UtilidadesLog.info("DAOTipoVincu.update(MaeUnidaMedidData maeUnidaMedid, Vector localizationLabels): Entrada");
           try{
               RecordSet rs = null;
               BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
               int cant = localizationLabels.size();
               GenDetaSiccData genDetaSiccData = null;
               StringBuffer updateInter = null;
               
               updateInter = new StringBuffer();
               updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
               updateInter.append(" where VAL_OID in ( " + maeUnidaMedid.getId().longValue() + ") ");
               updateInter.append(" and ATTR_NUM_ATRI = 1 ");
               updateInter.append(" and ATTR_ENTI = 'MAE_UNIDA_MEDID' ");
               
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
                   updateInter.append(" 'MAE_UNIDA_MEDID', ");
                   updateInter.append(" 1, ");
                   updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                   updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                   updateInter.append(maeUnidaMedid.getId().longValue() + " )");                
                   try {
                       int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                   } catch (Exception ex) {
                       ex.printStackTrace();
                       throw new MareException(ex, UtilidadesError.armarCodigoError(
                                               CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                   }
               }
               
               StringBuffer update = new StringBuffer();     
               
               update.append("UPDATE MAE_UNIDA_MEDID SET ");         
               
               if (maeUnidaMedid.getDesAbre()!=null)
                   update.append("DES_ABRE = '" + maeUnidaMedid.getDesAbre() + "', ");    
               
               update.append("MAGN_OID_MAGN = " + maeUnidaMedid.getMagnOidMagn().getId().longValue());
               
               update.append(", IND_UM_STND = " + maeUnidaMedid.getIndUmStnd());    
               update.append(" WHERE OID_UNID_MEDI = " + maeUnidaMedid.getId().longValue());
               
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
           UtilidadesLog.info("DAOTipoVincu.update(MaeUnidaMedidData maeUnidaMedid, Vector localizationLabels): Salida");
       }
      
}
