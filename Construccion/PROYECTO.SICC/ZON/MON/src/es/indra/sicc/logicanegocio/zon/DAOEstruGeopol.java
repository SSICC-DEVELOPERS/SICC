package es.indra.sicc.logicanegocio.zon;

import es.indra.belcorp.mso.ZonEstruGeopoData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.mare.common.mgu.manager.Property;
import java.math.BigDecimal;
import es.indra.belcorp.mso.ZonNivelGeogrData;
import java.sql.Date;
import es.indra.belcorp.mso.SegPaisViewData;
import java.text.SimpleDateFormat;
import es.indra.belcorp.mso.ZonSubesGeopoData;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.belcorp.mso.GenDetaSiccData;
import java.util.Hashtable;

public class DAOEstruGeopol 
{
    public DAOEstruGeopol()
    {
    }
    
    public Vector query(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOEstruGeopol.query(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo, HashMap userProperties): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
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
        query.append("SELECT ZEG.OID_ESTR_GEOP, ZEG.COD_ORDE, ZEG.FEC_ACTU, ZEG.IND_BORR, ");
        query.append("ZEG.PAIS_OID_PAIS, ZEG.DIPO_OID_DIVI_POLI, ZNG.COD_DIVI_POLI, i18n.VAL_I18N ");
        query.append("FROM ZON_ESTRU_GEOPO ZEG, ZON_NIVEL_GEOGR ZNG, v_gen_i18n_sicc i18n ");
        query.append("WHERE ZEG.DIPO_OID_DIVI_POLI = ZNG.OID_DIVI_POLI ");
        query.append("AND ZEG.PAIS_OID_PAIS = " + pais.longValue());
        query.append(" AND ZNG.OID_DIVI_POLI = i18n.val_oid ");
        query.append("AND i18n.ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
        query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        UtilidadesLog.debug("3");

        if (zonEstruGeopoFrom.getId()!=null)
            query.append(" AND ZEG.OID_ESTR_GEOP = " + zonEstruGeopoFrom.getId().longValue());
        UtilidadesLog.debug("4");
        if (zonEstruGeopoFrom.getCodOrde()!=null)
            query.append(" AND ZEG.COD_ORDE = " + zonEstruGeopoFrom.getCodOrde().longValue());
        UtilidadesLog.debug("5");    
        if (zonEstruGeopoFrom.getIndBorr()!=null)
            query.append(" AND ZEG.IND_BORR = " + zonEstruGeopoFrom.getIndBorr().longValue());
        UtilidadesLog.debug("6");
        if (zonEstruGeopoFrom.getDipoOidDiviPoli()!=null)
            if (zonEstruGeopoFrom.getDipoOidDiviPoli().getId()!=null)
                query.append(" AND ZEG.DIPO_OID_DIVI_POLI = " + zonEstruGeopoFrom.getDipoOidDiviPoli().getId().longValue());
        UtilidadesLog.debug("7");
        if (zonEstruGeopoFrom.getFecActu()!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(zonEstruGeopoFrom.getFecActu());        
            query.append(" AND ZEG.FEC_ACTU = " + fecha);
        }
        
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
        
        ZonEstruGeopoData zonEstruGeopoData = null;
        ZonNivelGeogrData zonNivelGeogrData = null;
        
        UtilidadesLog.debug("10");
        
        for(int i=0; i < cant; i++){
            zonEstruGeopoData = new ZonEstruGeopoData();
            zonNivelGeogrData = new ZonNivelGeogrData();
            
            if (rs.getValueAt(i,"COD_ORDE")!=null) {
                zonEstruGeopoData.setCodOrde(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_ORDE")).toString()));
            }
            UtilidadesLog.debug("11");
            if (rs.getValueAt(i,"DIPO_OID_DIVI_POLI")!=null) {
                zonNivelGeogrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"DIPO_OID_DIVI_POLI")).toString()));
            }
            UtilidadesLog.debug("12");
            if (rs.getValueAt(i,"COD_DIVI_POLI")!=null) {
                zonNivelGeogrData.setCodDiviPoli(rs.getValueAt(i,"COD_DIVI_POLI").toString());
            }
            UtilidadesLog.debug("13");
            if (rs.getValueAt(i,"VAL_I18N")!=null) {
                zonNivelGeogrData.setDescripcion(rs.getValueAt(i,"VAL_I18N").toString());
            }
            UtilidadesLog.debug("14");
            zonEstruGeopoData.setDipoOidDiviPoli(zonNivelGeogrData);
            
            if (rs.getValueAt(i,"FEC_ACTU")!=null) {
                zonEstruGeopoData.setFecActu((Date)rs.getValueAt(i, "FEC_ACTU"));
            }
            UtilidadesLog.debug("15");
            if (rs.getValueAt(i,"OID_ESTR_GEOP")!=null) {
                zonEstruGeopoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTR_GEOP")).toString()));
            }
            UtilidadesLog.debug("16");
            if (rs.getValueAt(i,"IND_BORR")!=null){
                zonEstruGeopoData.setIndBorr(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_BORR")).toString()));    
            }
            UtilidadesLog.debug("17");
            if (rs.getValueAt(i,"PAIS_OID_PAIS")!=null){
                SegPaisViewData segPaisViewData = new SegPaisViewData();
                segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                zonEstruGeopoData.setPaisOidPais(segPaisViewData);
            }
            UtilidadesLog.debug("18");
            result.add(zonEstruGeopoData);
        }
        UtilidadesLog.debug("result: " + result);
        UtilidadesLog.info("DAOEstruGeopol.query(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo, HashMap userProperties): Salida");
        return result;
    }
 
    public Hashtable guardar(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOEstruGeopol.guardar(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT ZON_SGEO_SEQ.NEXTVAL FROM DUAL");         
        
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
        update.append("INSERT INTO ZON_SUBES_GEOPO ( ");
        update.append("OID_SUBE_GEOP "); 
        
        if (zonSubesGeopo.getCodSube()!=null)
            update.append(", COD_SUBE");    
        if (zonSubesGeopo.getEgeoOidEstrGeop()!=null)
            if (zonSubesGeopo.getEgeoOidEstrGeop().getId()!=null)
                update.append(", EGEO_OID_ESTR_GEOP");    
            
        update.append(" ) VALUES ( ");    
        update.append(id);
        if (zonSubesGeopo.getCodSube()!=null)
            update.append(", '" + zonSubesGeopo.getCodSube().longValue() + "'");    
        if (zonSubesGeopo.getEgeoOidEstrGeop()!=null)
            if (zonSubesGeopo.getEgeoOidEstrGeop().getId()!=null)
                update.append(", " + zonSubesGeopo.getEgeoOidEstrGeop().getId().longValue());    
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
            updateInter.append(" 'ZON_SUBES_GEOPO', ");
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
        
        UtilidadesLog.info("DAOEstruGeopol.guardar(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }

    public void update(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOEstruGeopol.update(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels): Entrada");
        try{
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            int cant = localizationLabels.size();
            GenDetaSiccData genDetaSiccData = null;
            StringBuffer updateInter = null;
            
            updateInter = new StringBuffer();
            updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
            updateInter.append(" where VAL_OID in ( " + zonSubesGeopo.getId().longValue() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'ZON_SUBES_GEOPO' ");
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
                updateInter.append(" 'ZON_SUBES_GEOPO', ");
                updateInter.append(" 1, ");
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(zonSubesGeopo.getId().longValue() + " )");                
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
        
        UtilidadesLog.info("DAOEstruGeopol.update(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels): Salida");
    }

    public void remove(Vector entities) throws MareException
    {
        UtilidadesLog.info("DAOEstruGeopol.remove(Vector entities): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = entities.size();
        ZonSubesGeopoData zonSubesGeopoData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            zonSubesGeopoData = (ZonSubesGeopoData)entities.get(j);
             
            oids = oids + "," + zonSubesGeopoData.getId();
        }
        
        update.append("delete from ZON_SUBES_GEOPO ");
        update.append("where OID_SUBE_GEOP in ( " + oids.substring(1) + ") ");

        updateInter.append("delete from GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'ZON_SUBES_GEOPO' ");
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
        
        UtilidadesLog.info("DAOEstruGeopol.remove(Vector entities): Salida");
    }

}