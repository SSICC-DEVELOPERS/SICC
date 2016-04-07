package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MsgMetacData;
import es.indra.belcorp.mso.MsgTipoMetacData;
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

public class DAOMetacaracteres {
    public DAOMetacaracteres() {
    }
    
    public Vector query(MsgTipoMetacData msgTipoMetacFrom, MsgTipoMetacData msgTipoMetacTo, HashMap userProperties) throws MareException
       { UtilidadesLog.info("DAOMsgMetac.query(MsgTipoMetacData msgTipoMetacFrom, MsgTipoMetacData msgTipoMetacTo, HashMap userProperties):Entrada ");
         
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
       
       query.append(" SELECT OID_TIPO, COD_TIPO  ");
       query.append(" FROM MSG_TIPO_METAC  ");
       
       try {
             rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
       int cant = rs.getRowCount();
         
        MsgTipoMetacData msgTipoMetacData = null;
         
         for(int i=0; i < cant; i++){
             msgTipoMetacData = new MsgTipoMetacData();
             
             msgTipoMetacData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO")).toString()));
             msgTipoMetacData.setCodTipo((String)rs.getValueAt(i,"COD_TIPO"));
             
             resultado.add(msgTipoMetacData);
         }
         
         UtilidadesLog.info("DAOMsgMetac.query(MsgTipoMetacData msgTipoMetacFrom, MsgTipoMetacData msgTipoMetacTo, HashMap userProperties):Salida ");
         
       return resultado;
       }
         
         
       
        public Vector query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       { UtilidadesLog.info("DAOMsgMetac.query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
       
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
       
           query.append(" SELECT m.OID_META, m.COD_META, s.VAL_I18N, t.OID_TIPO, t.COD_TIPO, m.VAL_ESTA, m.VAL_LITE_IDEN ");
           query.append(" FROM MSG_METAC m, GEN_I18N_SICC_COMUN s, MSG_TIPO_METAC t ");
           query.append(" where t.oid_TIPO = m.TIME_OID_TIPO ");
           query.append(" and s.attr_enti = 'MSG_METAC'");
           query.append(" AND s.attr_num_atri = 1");
           query.append(" AND s.idio_oid_idio = 1");
           query.append(" AND s.val_oid = m.OID_META");
           
           
            if(msgMetacFrom.getCodMeta()!= null){
               query.append(" AND m.COD_META = " + msgMetacFrom.getCodMeta());
           }
            if(msgMetacFrom.getId()!= null){
               query.append(" AND m.OID_META = " + msgMetacFrom.getId());
           }
           if(msgMetacFrom.getDescripcion()!= null){
               query.append(" and s.VAL_I18N like '" + msgMetacFrom.getDescripcion() + "' ");
           }
           if(msgMetacFrom.getValEsta()!= null){
               query.append(" and m.VAL_ESTA like '" + msgMetacFrom.getValEsta() + "' ");
           }
           if(msgMetacFrom.getValLiteIden()!= null){
               query.append(" and m.VAL_LITE_IDEN like '" + msgMetacFrom.getValLiteIden() + "' ");
           }
           if(msgMetacFrom.getTimeOidTipo() !=null){
               query.append(" AND OID_TIPO = " + msgMetacFrom.getTimeOidTipo().getId());
           }
           
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
           
           MsgMetacData msgMetacData = null;
           MsgTipoMetacData msgTipoMetacData = null;
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
                     msgMetacData = new MsgMetacData();
                      segPaisViewFrom = new SegPaisViewData();
                     msgTipoMetacData = new MsgTipoMetacData();
                    
                    
                    
                     msgMetacData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_META")).toString())); 
                     msgMetacData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     msgMetacData.setCodMeta(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_META")).toString()));
                     msgTipoMetacData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO")).toString()));
                     msgTipoMetacData.setCodTipo((String)rs.getValueAt(i,"COD_TIPO"));
                     msgMetacData.setTimeOidTipo(msgTipoMetacData);
                     msgMetacData.setValEsta((String)rs.getValueAt(i,"VAL_ESTA"));
                     msgMetacData.setValLiteIden((String)rs.getValueAt(i,"VAL_LITE_IDEN"));
                     
                     result.add(msgMetacData);
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
           }
         
         UtilidadesLog.info("DAOMsgMetac.query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida ");
         return result;
         
       
         }

       
        public void update(MsgMetacData msgMetac, Vector localizationLabels) throws MareException
       { UtilidadesLog.info("DAOMsgMetac.update(MsgMetacData msgMetac, Vector localizationLabels):Entrada ");
       RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           // Borrar los registros internalizacion
           StringBuffer deleteInter = new StringBuffer();
           
           deleteInter.append("delete GEN_I18N_SICC_COMUN ");
           deleteInter.append(" where VAL_OID = " + msgMetac.getId());
           deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
           deleteInter.append(" and ATTR_ENTI = 'MSG_METAC' ");
           
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
           StringBuffer queryInter = null;
           Long idInter = null;      
           StringBuffer updateInter = null;
           
           for(int i= 0; i< cant; i++){                      
              
               genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
           
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
               updateInter.append(" 'MSG_METAC', ");
               updateInter.append(" 1, ");            
               updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
               updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
               updateInter.append(msgMetac.getId() + " )");   
           
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
           }
           StringBuffer update = new StringBuffer();
           
           update.append("UPDATE MSG_METAC SET ");
           update.append(" COD_META = " + msgMetac.getCodMeta());
           update.append(" , VAL_LITE_IDEN = '" + msgMetac.getValLiteIden() + "'");
           update.append(" , VAL_ESTA = '" + msgMetac.getValEsta() + "' ");
           update.append(" , TIME_OID_TIPO = " + msgMetac.getTimeOidTipo().getId());
           update.append(" WHERE OID_META = " + msgMetac.getId());   
           
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
           UtilidadesLog.info("DAOMsgMetac.update(MsgMetacData msgMetac, Vector localizationLabels):Salida ");
       }

       public void remove(Vector entities) throws MareException
       {
       UtilidadesLog.info("DAOMsgMetac.remove(Vector entities): Entrada ");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           MsgMetacData msgMetacData = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               msgMetacData = (MsgMetacData)entities.get(j);
                
               oids = oids + "," + msgMetacData.getId();
           }
           
           update.append("delete MSG_METAC ");
           update.append("where OID_META in ( " + oids.substring(1) + ") ");
           
           updateInter.append("delete GEN_I18N_SICC_COMUN ");
           updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'MSG_METAC' ");
           
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
           
           UtilidadesLog.info("DAOMsgMetac.remove(Vector entities): Salida ");
       }
       
      
       public Hashtable guardarMetac(MsgMetacData msgMetac, Vector localizationLabels, HashMap userProperties) throws MareException
       {
       UtilidadesLog.info("DAOMsgMetac.guardar(MsgMetacData msgMetac, Vector localizationLabels, HashMap userProperties): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();        
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT MSG_METC_SEQ.NEXTVAL FROM DUAL");         
           
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
           
           update.append(" INSERT INTO MSG_METAC ( ");
           update.append("OID_META, "); 
           update.append("COD_META, "); 
           update.append("VAL_LITE_IDEN, "); 
           update.append("VAL_ESTA, ");
           update.append("TIME_OID_TIPO ");
           
           
           
           update.append(" ) VALUES ( ");
           update.append(id + ", ");
           update.append(msgMetac.getCodMeta() + ", ");
           update.append(" '" + msgMetac.getValLiteIden() + "' ,");
           update.append(" '" + msgMetac.getValEsta() + "', ");
           update.append(msgMetac.getTimeOidTipo().getId() );
           
           
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
                   
               updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
               updateInter.append("OID_I18N, "); 
               updateInter.append("ATTR_ENTI, "); 
               updateInter.append("ATTR_NUM_ATRI, "); 
               updateInter.append("IDIO_OID_IDIO, "); 
               updateInter.append("VAL_I18N, ");                 
               updateInter.append("VAL_OID "); 
               updateInter.append(" ) VALUES ( ");
               updateInter.append(idInter + ", ");
               updateInter.append(" 'MSG_METAC', ");
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
       
           UtilidadesLog.info("DAOMsgMetac.guardar(MsgMetacData msgMetac, Vector localizationLabels, HashMap userProperties): Salida ");
           return primaryKey;
       }
       
          
 }



