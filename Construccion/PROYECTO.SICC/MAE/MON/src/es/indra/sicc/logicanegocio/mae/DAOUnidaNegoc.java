package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;

import es.indra.belcorp.mso.MaeUnidaNegocData;
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

public class DAOUnidaNegoc {
    public DAOUnidaNegoc() {
    }
    public Vector query(MaeUnidaNegocData maeUnidaNegocFrom, MaeUnidaNegocData maeUnidaNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {
            UtilidadesLog.info("DAOUnidaNegoc.query(MaeUnidaNegocData maeUnidaNegocFrom, MaeUnidaNegocData maeUnidaNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            
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
            
            query.append("SELECT MUN.OID_UNID_NEGO, MUN.PAIS_OID_PAIS, MUN.COD_UNID_NEGO, i18n.VAL_I18N ");
            query.append("FROM MAE_UNIDA_NEGOC MUN, v_gen_i18n_sicc i18n ");
            query.append("WHERE MUN.OID_UNID_NEGO = i18n.val_oid ");
            query.append("AND i18n.ATTR_ENTI = 'MAE_UNIDA_NEGOC' ");
            query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
            query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
            
            if (maeUnidaNegocFrom.getId()!=null)
                query.append(" AND MUN.OID_UNID_NEGO = " + maeUnidaNegocFrom.getId().longValue());
                
            if (maeUnidaNegocFrom.getCodUnidNego()!=null)
                query.append(" AND MUN.COD_UNID_NEGO LIKE '" + maeUnidaNegocFrom.getCodUnidNego() + "'");
                
            if (maeUnidaNegocFrom.getDescripcion()!=null)
                query.append(" AND  i18n.VAL_I18N LIKE '" + maeUnidaNegocFrom.getDescripcion()+ "'");    
                
            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }      
            
            int cant = rs.getRowCount();
            MaeUnidaNegocData maeUnidaNegocData   = null;
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
                    maeUnidaNegocData  = new MaeUnidaNegocData();
                    segPaisViewData = new SegPaisViewData();
                    
                    maeUnidaNegocData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_UNID_NEGO")).toString()));
                    maeUnidaNegocData.setCodUnidNego((String)rs.getValueAt(i,"COD_UNID_NEGO"));
                    maeUnidaNegocData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                    
                    segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                    maeUnidaNegocData.setPaisOidPais(segPaisViewData);
                    
                    resultado.add(maeUnidaNegocData);

                }
            }
            UtilidadesLog.info("DAOUnidaNegoc.query(MaeUnidaNegocData maeUnidaNegocFrom, MaeUnidaNegocData maeUnidaNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return resultado;
        }
     
            public void remove(Vector entities) throws MareException
        {
            UtilidadesLog.info("DAOUnidaNegoc.remove(Vector entities): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant = entities.size();
            MaeUnidaNegocData maeUnidaNegocData = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                maeUnidaNegocData = (MaeUnidaNegocData)entities.get(j);
                 
                oids = oids + "," + maeUnidaNegocData.getId();
            }
            update.append("delete from MAE_UNIDA_NEGOC ");
            update.append("where OID_UNID_NEGO in ( " + oids.substring(1) + ") ");

            updateInter.append("delete from GEN_I18N_SICC_PAIS ");
            updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_UNIDA_NEGOC' ");
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
            UtilidadesLog.info("DAOUnidaNegoc.remove(Vector entities): Salida");
        }

        public void update(MaeUnidaNegocData maeUnidaNegoc, Vector localizationLabels) throws MareException
        {
            UtilidadesLog.info("DAOUnidaNegoc.update(MaeUnidaNegocData maeUnidaNegoc, Vector localizationLabels): Entrada");
            try{
                RecordSet rs = null;
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                
                int cant = localizationLabels.size();
                GenDetaSiccData genDetaSiccData = null;
                StringBuffer updateInter = null;
                
                updateInter = new StringBuffer();
                updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
                updateInter.append(" where VAL_OID in ( " + maeUnidaNegoc.getId().longValue() + ") ");
                updateInter.append(" and ATTR_NUM_ATRI = 1 ");
                updateInter.append(" and ATTR_ENTI = 'MAE_UNIDA_NEGOC' ");
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
                    updateInter.append(" 'MAE_UNIDA_NEGOC', ");
                    updateInter.append(" 1, ");
                    updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                    updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                    updateInter.append(maeUnidaNegoc.getId().longValue() + " )");                
                    try {
                        int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
                
            } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            UtilidadesLog.info("DAOUnidaNegoc.update(MaeUnidaNegocData maeUnidaNegoc, Vector localizationLabels): Salida");
        }

         public Hashtable guardar(MaeUnidaNegocData maeUnidaNegoc, Vector localizationLabels, HashMap userProperties) throws MareException
         {
            UtilidadesLog.info("DAOUnidaNegoc.guardar(MaeUnidaNegocData maeUnidaNegoc, Vector localizationLabels, HashMap userProperties): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();        
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            Long pais   = (Long)userProperties.get("loidPais");
            query.append(" SELECT MAE_UNEG_SEQ.NEXTVAL FROM DUAL");         
            
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
            update.append("INSERT INTO MAE_UNIDA_NEGOC ( ");
            update.append("OID_UNID_NEGO "); 
            update.append(", PAIS_OID_PAIS");
            update.append(", COD_UNID_NEGO");    
            update.append(" ) VALUES ( ");      
            update.append(id);
            update.append(", " + pais);
            update.append(", '" + maeUnidaNegoc.getCodUnidNego() + "'");
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
                updateInter = new StringBuffer();    
                genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
                updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
                updateInter.append("OID_I18N, ");
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");                
                updateInter.append(" 'MAE_UNIDA_NEGOC', ");
                updateInter.append(" 1, ");
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(id.longValue() + " )");               
            
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
            UtilidadesLog.info("DAOUnidaNegoc.guardar(MaeUnidaNegocData maeUnidaNegoc, Vector localizationLabels, HashMap userProperties): Salida");
            return primaryKey;
        }
}
