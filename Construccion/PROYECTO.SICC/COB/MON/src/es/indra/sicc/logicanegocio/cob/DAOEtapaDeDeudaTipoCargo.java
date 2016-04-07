package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CccTipoCargoAbonoData;
import es.indra.belcorp.mso.CobEtapaDeudaData;
import es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData;
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

public class DAOEtapaDeDeudaTipoCargo {
    public DAOEtapaDeDeudaTipoCargo() 
    {
    }
    
    public Vector query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties) throws MareException
       {   UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties):Entrada");
       
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
       
       query.append(" SELECT a.OID_TIPO_CARG_ABON, b.VAL_I18N ");
       query.append(" FROM CCC_TIPO_CARGO_ABONO a, GEN_I18N_SICC_PAIS b  ");
       query.append(" where b.ATTR_ENTI = 'CCC_TIPO_CARGO_ABONO'");
       query.append(" AND b.ATTR_NUM_ATRI = 1");
       query.append(" and b.IDIO_OID_IDIO = 1");
       query.append(" and b.VAL_OID = a.OID_TIPO_CARG_ABON ");
       
       
       
       try {
             rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
       int cant = rs.getRowCount();
         
       
        CccTipoCargoAbonoData cccTipoCargo = null;
         
         for(int i=0; i < cant; i++){
            
             cccTipoCargo  = new CccTipoCargoAbonoData();
             
             cccTipoCargo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_TIPO_CARG_ABON")).toString()));
             cccTipoCargo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
            
             
             resultado.add(cccTipoCargo);
         }
       
       
       
       
           UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties):Salida");
       
           return resultado;
       }
       
       public Vector query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties) throws MareException
       {   UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties):Entrada");
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
       
       query.append(" SELECT a.OID_ETAP_DEUD, a.VAL_DESC ");
       query.append(" FROM COB_ETAPA_DEUDA a  ");
       
       
       
       try {
             rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
       int cant = rs.getRowCount();
         
       
        CobEtapaDeudaData cobEtapaDe = null;
         
         for(int i=0; i < cant; i++){
            
             cobEtapaDe  = new CobEtapaDeudaData();
             
             cobEtapaDe.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_ETAP_DEUD")).toString()));
             cobEtapaDe.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
            
             
             resultado.add(cobEtapaDe);
         }
       
           UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties):Salida");
           return resultado;
       }
        public Vector query(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {   UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.query((CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
       
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
       
           query.append(" SELECT a.oid_etap_deud, a.val_desc, b.oid_tipo_carg_abon, c.val_i18n, d.OID_ETAP_DEUD_TIPO_CARG, d.VAL_DESC VAL_DESC1 ");
           query.append(" FROM cob_etapa_deuda a, ccc_tipo_cargo_abono b, gen_i18n_sicc_pais c, COB_ETAPA_DEUDA_TIPO_CARGO d ");
           query.append(" WHERE c.attr_enti = 'CCC_TIPO_CARGO_ABONO'");
           query.append(" AND c.attr_num_atri = 1 ");
           query.append(" AND c.idio_oid_idio = 1 ");
           query.append(" AND c.val_oid = b.OID_TIPO_CARG_ABON");
           query.append(" AND d.ETDE_OID_ETAP_DEUD = a.OID_ETAP_DEUD");
           query.append(" AND d.TCAB_OID_TIPO_CARG_ABON = b.OID_TIPO_CARG_ABON");
           
            if(cobEtapaDeudaTipoCargoFrom.getId()!= null){
               query.append(" AND d.OID_ETAP_DEUD_TIPO_CARG = " + cobEtapaDeudaTipoCargoFrom.getId());
           }
            if(cobEtapaDeudaTipoCargoFrom.getEtdeOidEtapDeud()!= null){
               query.append(" AND a.OID_ETAP_DEUD = " + cobEtapaDeudaTipoCargoFrom.getEtdeOidEtapDeud().getId());
           }
         
           if(cobEtapaDeudaTipoCargoFrom.getTcabOidTipoCargAbon()!= null){
               query.append(" AND  b.OID_TIPO_CARG_ABON = " + cobEtapaDeudaTipoCargoFrom.getTcabOidTipoCargAbon().getId());
           }
           
           if(cobEtapaDeudaTipoCargoFrom.getValDesc()!= null)
           {
               query.append(" AND d.VAL_DESC = " + cobEtapaDeudaTipoCargoFrom.getValDesc());
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
           
           CobEtapaDeudaTipoCargoData cobEtapaDeT = null;
           CobEtapaDeudaData cobEtapa = null;
           CccTipoCargoAbonoData cccTipoC = null;
           
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
                     cobEtapaDeT = new CobEtapaDeudaTipoCargoData();
                     cccTipoC    = new CccTipoCargoAbonoData();
                     cobEtapa = new CobEtapaDeudaData();
                     BigDecimal cccTipoC1, etapaDeuda1 = null;
                     
                     cobEtapaDeT.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ETAP_DEUD_TIPO_CARG")).toString())); 
                     cobEtapaDeT.setValDesc((String)rs.getValueAt(i,"VAL_DESC1"));
                     cccTipoC1 = (BigDecimal)rs.getValueAt(i,"OID_TIPO_CARG_ABON");
                     if(cccTipoC1 != null)
                     {
                          cccTipoC.setId(Long.valueOf(cccTipoC1.toString()));
                          cccTipoC.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                          cobEtapaDeT.setTcabOidTipoCargAbon(cccTipoC);
                     }
                     etapaDeuda1 = (BigDecimal)rs.getValueAt(i,"OID_ETAP_DEUD");
                     if(etapaDeuda1 !=null)
                     {
                         cobEtapa.setId(Long.valueOf(etapaDeuda1.toString()));
                         cobEtapa.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                         cobEtapaDeT.setEtdeOidEtapDeud(cobEtapa);
                     }
                     
                                 
                                      
                     result.add(cobEtapaDeT);
                     
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
           
                
       }
       UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.query((CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
           return result;
       }
       public void remove(Vector entities) throws MareException
       {   UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.remove(Vector entities):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           
           
           int cant = entities.size();
           CobEtapaDeudaTipoCargoData cobEtaDeuT = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               cobEtaDeuT = (CobEtapaDeudaTipoCargoData)entities.get(j);
                
               oids = oids + "," + cobEtaDeuT.getId();
           }
           
           update.append("delete COB_ETAPA_DEUDA_TIPO_CARGO ");
           update.append("where OID_ETAP_DEUD_TIPO_CARG in ( " + oids.substring(1) + ") ");
           
                  
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
       
       UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.remove(Vector entities):Entrada");
       }
       public void update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels) throws MareException
       {   UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels):Entrada");
           
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
                   
           update.append(" UPDATE  COB_ETAPA_DEUDA_TIPO_CARGO SET ");
           update.append(" TCAB_OID_TIPO_CARG_ABON = " + cobEtapaDeudaTipoCargo.getTcabOidTipoCargAbon().getId() + ",");
           update.append(" ETDE_OID_ETAP_DEUD = "+ cobEtapaDeudaTipoCargo.getEtdeOidEtapDeud().getId());
           
          
           if(cobEtapaDeudaTipoCargo.getValDesc()!= null)
           {
               update.append(", VAL_DESC = '" + cobEtapaDeudaTipoCargo.getValDesc() + "'");
           }
              else {
               update.append(" , VAL_DESC = NULL" );} 
           
           
           
          
               update.append(" WHERE OID_ETAP_DEUD_TIPO_CARG = " + cobEtapaDeudaTipoCargo.getId());
           
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
       
       
       
           UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels):Salida");
       }
       
        public Hashtable guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels, HashMap userProperties) throws MareException
       {   UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels, HashMap userProperties):Entrada");
       
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT COB_EDTC_SEQ.NEXTVAL FROM DUAL");         
           
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
         update.append(" INSERT INTO COB_ETAPA_DEUDA_TIPO_CARGO ( ");
         update.append(" OID_ETAP_DEUD_TIPO_CARG, ");
         update.append(" TCAB_OID_TIPO_CARG_ABON, ");
         update.append(" ETDE_OID_ETAP_DEUD,");
         update.append(" VAL_DESC ");
         update.append(" ) VALUES ( ");
         update.append(id + ", ");
         update.append(cobEtapaDeudaTipoCargo.getTcabOidTipoCargAbon().getId() + ", ");
         update.append(cobEtapaDeudaTipoCargo.getEtdeOidEtapDeud().getId());
         
         
           if(cobEtapaDeudaTipoCargo.getValDesc()!= null)
           {
             update.append(", '" + cobEtapaDeudaTipoCargo.getValDesc() + "'");
           }
           else 
           {
             update.append(", NULL");
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
           
           Hashtable primaryKey = new Hashtable();
           primaryKey.put("id", id);
       
       
           UtilidadesLog.info("DAOCobEtapaDeudaTipoCargo.guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels, HashMap userProperties):Salida");
           return primaryKey;
       }
    }

