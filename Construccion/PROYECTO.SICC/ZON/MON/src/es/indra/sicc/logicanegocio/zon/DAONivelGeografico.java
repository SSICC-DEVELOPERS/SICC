package es.indra.sicc.logicanegocio.zon;

import es.indra.belcorp.mso.ZonNivelGeogrData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mgu.manager.Property;
import java.math.BigDecimal;
import java.util.Hashtable;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.belcorp.mso.GenDetaSiccData;

public class DAONivelGeografico 
{
    public DAONivelGeografico()
    {
    }
    
    public Vector query(ZonNivelGeogrData zonNivelGeogrFrom, ZonNivelGeogrData zonNivelGeogrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAONivelGeografico.query(ZonNivelGeogrData zonNivelGeogrFrom, ZonNivelGeogrData zonNivelGeogrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        
        query.append("SELECT ZNG.OID_DIVI_POLI, ZNG.COD_DIVI_POLI, i18n.VAL_I18N "); 
        query.append("FROM ZON_NIVEL_GEOGR ZNG, v_gen_i18n_sicc i18n ");
        query.append("WHERE OID_DIVI_POLI = i18n.val_oid ");
        query.append("AND i18n.ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
        query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        if (zonNivelGeogrFrom.getCodDiviPoli()!=null)
            query.append(" AND ZNG.COD_DIVI_POLI = '" + zonNivelGeogrFrom.getCodDiviPoli() +"'");
            
        if (zonNivelGeogrFrom.getDescripcion()!=null)
            query.append(" AND  upper(i18n.val_i18n) LIKE '%" + zonNivelGeogrFrom.getDescripcion().trim().toUpperCase() + "%'");
            
        if (zonNivelGeogrFrom.getId()!=null)            
            query.append(" AND ZNG.OID_DIVI_POLI = " + zonNivelGeogrFrom.getId().longValue());
        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        ZonNivelGeogrData zonNivelGeogrData = null;
                int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            if(i < rsMostrar){
                zonNivelGeogrData = new ZonNivelGeogrData();
                if (rs.getValueAt(i,"OID_DIVI_POLI")!=null)
                    zonNivelGeogrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_DIVI_POLI")).toString()));
                if (rs.getValueAt(i,"COD_DIVI_POLI")!=null)    
                    zonNivelGeogrData.setCodDiviPoli((String)rs.getValueAt(i,"COD_DIVI_POLI"));
                if (rs.getValueAt(i,"VAL_I18N")!=null)        
                    zonNivelGeogrData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                result.add(zonNivelGeogrData);
            } else {
               break;
            }
        }
        UtilidadesLog.debug("result: " + result);
        UtilidadesLog.info("DAONivelGeografico.query(ZonNivelGeogrData zonNivelGeogrFrom, ZonNivelGeogrData zonNivelGeogrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return result;
    }
    
    public Hashtable guardar(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAONivelGeografico.guardar(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT ZON_DIPO_SEQ.NEXTVAL FROM DUAL");         
        
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
        update.append("INSERT INTO ZON_NIVEL_GEOGR ( ");
        update.append("OID_DIVI_POLI "); 
         update.append(", COD_DIVI_POLI");
        update.append(" ) VALUES ( ");    
        update.append(id);
        update.append(", '" + zonNivelGeogr.getCodDiviPoli());
        update.append("') ");            
         
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
            updateInter.append(" 'ZON_NIVEL_GEOGR', ");
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
        
        UtilidadesLog.info("DAONivelGeografico.guardar(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector zonEstadZonaOids) throws MareException
    {
        UtilidadesLog.info("DAONivelGeografico.remove(Vector zonEstadZonaOids): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = zonEstadZonaOids.size();
        ZonNivelGeogrData zonNivelGeogrData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            zonNivelGeogrData = (ZonNivelGeogrData)zonEstadZonaOids.get(j);
             
            oids = oids + "," + zonNivelGeogrData.getId();
        }
        
        update.append("delete from ZON_NIVEL_GEOGR ");
        update.append("where OID_DIVI_POLI in ( " + oids.substring(1) + ") ");

        updateInter.append("delete from GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
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
        UtilidadesLog.info("DAONivelGeografico.remove(Vector zonEstadZonaOids): Salida");
    }
    
    public void update(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAONivelGeografico.update(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels): Entrada");
        try{
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            int cant = localizationLabels.size();
            GenDetaSiccData genDetaSiccData = null;
            StringBuffer updateInter = null;
            
            updateInter = new StringBuffer();
            updateInter.append("DELETE GEN_I18N_SICC_COMUN ");
            updateInter.append(" where VAL_OID in ( " + zonNivelGeogr.getId().longValue() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
            
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
                updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
                updateInter.append("OID_I18N, ");
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");                
                updateInter.append(" 'ZON_NIVEL_GEOGR', ");
                updateInter.append(" 1, ");
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(zonNivelGeogr.getId().longValue() + " )");
            
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
        UtilidadesLog.info("DAONivelGeografico.update(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels): Salida");
    }
    
}