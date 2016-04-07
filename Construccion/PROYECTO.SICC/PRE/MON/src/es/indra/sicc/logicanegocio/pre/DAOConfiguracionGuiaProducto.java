package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreConfiGpData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.SegPaisViewData;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;


public class DAOConfiguracionGuiaProducto {
    public DAOConfiguracionGuiaProducto() {
    }
    
    public Hashtable guardar(PreConfiGpData preConfiGp, HashMap userProperties) throws MareException
        {
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.guardar((PreConfiGpData preConfiGp, HashMap userProperties): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT PRE_CGPP_SEQ.NEXTVAL FROM DUAL");         
            
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
            
            update.append(" INSERT INTO PRE_CONFI_GP ( ");
            update.append("OID_CONF_GP, "); 
            update.append("MARC_OID_MARC, "); 
            update.append("CANA_OID_CANA, "); 
            update.append("PAIS_OID_PAIS, "); 
            update.append("VAL_INCR "); 
            
            update.append(" ) VALUES ( ");
            update.append(id + ", ");
            update.append(preConfiGp.getMarcOidMarc().getId() + ", ");
            update.append(preConfiGp.getCanaOidCana().getId() + ", ");
            update.append(preConfiGp.getPaisOidPais().getId() + ", ");
            update.append(preConfiGp.getValIncr());
            
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
        
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.guardar(PreConfiGpData preConfiGp, HashMap userProperties): Salida");
            return primaryKey;
        }

        public void remove(Vector preConfiGpFrom) throws MareException
        {
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.remove(Vector preConfiGpFrom): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            int cant = preConfiGpFrom.size();
            PreConfiGpData preConfiGpData = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                preConfiGpData = (PreConfiGpData)preConfiGpFrom.get(j);
                 
                oids = oids + "," + preConfiGpData.getId();
            }
            
            update.append("delete PRE_CONFI_GP ");
            update.append("where OID_CONF_GP in ( " + oids.substring(1) + ") ");
            
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
            
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.remove(Vector preConfiGpFrom)): Salida");        
        }

        public Vector query(PreConfiGpData preConfiGpFrom, PreConfiGpData preConfiGpTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.query(PreConfiGpData preConfiGpFrom, PreConfiGpData preConfiGpTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Entrada");
            
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
            
            Property idioma = (Property)userProperties.get("Idioma");
          
            query.append(" SELECT OID_CONF_GP, MARC_OID_MARC, DES_MARC, ");
            query.append(" CANA_OID_CANA, i18n.VAL_I18N, PAIS_OID_PAIS, VAL_INCR ");
            query.append(" FROM  PRE_CONFI_GP, SEG_MARCA, v_gen_i18n_sicc i18n ");
            query.append(" WHERE MARC_OID_MARC = OID_MARC ");
            query.append(" AND CANA_OID_CANA = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            
            // Para la busqueda
            if(preConfiGpFrom.getCanaOidCana()!= null){
                query.append(" and CANA_OID_CANA = " + preConfiGpFrom.getCanaOidCana().getId());
            }
            
            if(preConfiGpFrom.getMarcOidMarc()!= null){
                query.append(" and MARC_OID_MARC = " + preConfiGpFrom.getMarcOidMarc().getId());
            }
            
            if(preConfiGpFrom.getId()== null){
                query.append(" AND PAIS_OID_PAIS = " + preConfiGpFrom.getPaisOidPais().getId());     
            }   
            
            // Para el detalle
            if(preConfiGpFrom.getId()!= null){
                query.append(" and OID_CONF_GP = " + preConfiGpFrom.getId());
            }

            try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            
            int cant = rs.getRowCount();
            Vector result = new Vector();
            
            PreConfiGpData preConfiGpData = null;
            SegMarcaData segMarcaData = null;
            SegCanalViewData segCanalViewData = null;
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
                      preConfiGpData = new PreConfiGpData();
              
                      preConfiGpData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CONF_GP")).toString()));                  
                      preConfiGpData.setValIncr(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_INCR")).toString()));     
                      
                      segMarcaData = new SegMarcaData();
                      segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).toString()));    
                      segMarcaData.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));                  
                      preConfiGpData.setMarcOidMarc(segMarcaData);
                      
                      segCanalViewData = new SegCanalViewData();
                      segCanalViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).toString()));
                      segCanalViewData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));   
                      preConfiGpData.setCanaOidCana(segCanalViewData);
                      
                      segPaisViewData = new SegPaisViewData();
                      segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));   
                      preConfiGpData.setPaisOidPais(segPaisViewData);
                     
                      result.add(preConfiGpData);
                    
                } else {
                   break;
                }
            }
            
            
            UtilidadesLog.debug("result: " + result);
           
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.query(PreConfiGpData preConfiGpFrom, PreConfiGpData preConfiGpTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Salida");
            return result;
        }

        public void update(PreConfiGpData preConfiGp) throws MareException
        {
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.update(PreConfiGpData preConfiGp): Entrada");
           
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            update.append("UPDATE PRE_CONFI_GP SET ");
            update.append("VAL_INCR = " + preConfiGp.getValIncr());
            
            update.append(" WHERE OID_CONF_GP = " + preConfiGp.getId());   
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
                   
            UtilidadesLog.info("DAOConfiguracionGuiaProducto.update(PreConfiGpData preConfiGp): Salida");
        }
}
