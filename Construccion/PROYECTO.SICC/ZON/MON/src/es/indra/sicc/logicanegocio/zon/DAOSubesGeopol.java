package es.indra.sicc.logicanegocio.zon;

import es.indra.belcorp.mso.ZonSubesGeopoData;
import es.indra.belcorp.mso.ZonEstruGeopoData;
import es.indra.belcorp.mso.ZonNivelGeogrData;
import es.indra.belcorp.mso.SegPaisViewData;
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
import java.sql.Date;
import es.indra.mare.common.exception.MareException;

public class DAOSubesGeopol 
{
    public DAOSubesGeopol()
    {
    }
    
    public Vector query(ZonSubesGeopoData zonSubesGeopoFrom, ZonSubesGeopoData zonSubesGeopoTo, HashMap userProperties, 
                        Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOSubesGeopol.query(ZonSubesGeopoData zonSubesGeopoFrom, ZonSubesGeopoData zonSubesGeopoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        
        UtilidadesLog.debug("1a");    
    
        try {
          bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        UtilidadesLog.debug("1b");    
        
        Property idioma = (Property)userProperties.get("Idioma");
        Long pais   = (Long)userProperties.get("loidPais");
        
        UtilidadesLog.debug("1c");    
        
        
        //UtilidadesLog.debug("zonSubesGeopoFrom.getId(): " + zonSubesGeopoFrom.getId());    
        //UtilidadesLog.debug("zonSubesGeopoFrom.getEgeoOidEstrGeop(): " + zonSubesGeopoFrom.getEgeoOidEstrGeop().getCodOrde());    
        //UtilidadesLog.debug("zonSubesGeopoFrom.getEgeoOidEstrGeop(): " + zonSubesGeopoFrom.getEgeoOidEstrGeop().getId());    
        //UtilidadesLog.debug("zonSubesGeopoFrom.getCodSube(): " + zonSubesGeopoFrom.getCodSube());    
        
        
        query.append("SELECT ZSG.OID_SUBE_GEOP, ZEG.COD_ORDE, ZSG.COD_SUBE, i18n.VAL_I18N, ZNG.OID_DIVI_POLI, ");
        query.append("ZNG.COD_DIVI_POLI, i18n1.VAL_I18N DESC_NIVEL, ZEG.FEC_ACTU, ZEG.OID_ESTR_GEOP, zeg.IND_BORR, ZEG.PAIS_OID_PAIS ");
        query.append("FROM ZON_SUBES_GEOPO ZSG, ZON_ESTRU_GEOPO ZEG, ZON_NIVEL_GEOGR ZNG, ");
        query.append("v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
        query.append("WHERE ZSG.EGEO_OID_ESTR_GEOP = ZEG.OID_ESTR_GEOP ");
        query.append("AND ZEG.PAIS_OID_PAIS = " + pais.longValue());
        query.append(" AND ZSG.OID_SUBE_GEOP = i18n.val_oid ");
        query.append("AND i18n.ATTR_ENTI = 'ZON_SUBES_GEOPO' ");
        query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" AND ZEG.DIPO_OID_DIVI_POLI = ZNG.OID_DIVI_POLI ");
        query.append("AND ZNG.OID_DIVI_POLI = i18n1.val_oid ");
        query.append("AND i18n1.ATTR_ENTI = 'ZON_NIVEL_GEOGR' ");
        query.append("AND i18n1.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        UtilidadesLog.debug("1d");    
        
        if (zonSubesGeopoFrom.getId()!=null)
            query.append(" AND ZSG.OID_SUBE_GEOP = " + zonSubesGeopoFrom.getId().longValue());
        
        if (zonSubesGeopoFrom.getEgeoOidEstrGeop()!=null)
            if (zonSubesGeopoFrom.getEgeoOidEstrGeop().getId()!=null)
                query.append(" AND ZEG.OID_ESTR_GEOP = " + zonSubesGeopoFrom.getEgeoOidEstrGeop().getId().longValue());
                
        if ( zonSubesGeopoFrom.getCodSube()!=null)    
            query.append(" AND ZSG.COD_SUBE = " + zonSubesGeopoFrom.getCodSube().longValue());
            
        if (zonSubesGeopoFrom.getDescripcion()!=null)        
            query.append(" AND  upper(i18n.val_i18n) LIKE '%" + zonSubesGeopoFrom.getDescripcion().trim().toUpperCase() + "%'");    
            
        UtilidadesLog.debug("1e");                
            
        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
            
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        ZonSubesGeopoData zonSubesGeopoData = null;
        ZonEstruGeopoData zonEstruGeopoData = null;
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
                zonSubesGeopoData = new ZonSubesGeopoData();
                
                if (rs.getValueAt(i,"OID_SUBE_GEOP")!=null)
                    zonSubesGeopoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_SUBE_GEOP")).toString()));
                
                UtilidadesLog.debug("1");    
                
                zonEstruGeopoData = new ZonEstruGeopoData();
                zonNivelGeogrData = new ZonNivelGeogrData();
                if (rs.getValueAt(i,"COD_ORDE")!=null) {
                    zonEstruGeopoData.setCodOrde(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_ORDE")).toString()));
                }
                UtilidadesLog.debug("2");
                //division politica
                if (rs.getValueAt(i,"OID_DIVI_POLI")!=null) {
                    zonNivelGeogrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_DIVI_POLI")).toString()));
                }
                UtilidadesLog.debug("3");
                if (rs.getValueAt(i,"COD_DIVI_POLI")!=null) {
                    zonNivelGeogrData.setCodDiviPoli(rs.getValueAt(i,"COD_DIVI_POLI").toString());
                }
                UtilidadesLog.debug("");
                if (rs.getValueAt(i,"DESC_NIVEL")!=null) {
                    zonNivelGeogrData.setDescripcion(rs.getValueAt(i,"DESC_NIVEL").toString());
                }
                UtilidadesLog.debug("");
                zonEstruGeopoData.setDipoOidDiviPoli(zonNivelGeogrData);
                if (rs.getValueAt(i,"FEC_ACTU")!=null) {
                    zonEstruGeopoData.setFecActu((Date)rs.getValueAt(i, "FEC_ACTU"));
                }
                UtilidadesLog.debug("4");
                if (rs.getValueAt(i,"OID_ESTR_GEOP")!=null) {
                    zonEstruGeopoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTR_GEOP")).toString()));
                }
                UtilidadesLog.debug("");
                if (rs.getValueAt(i,"IND_BORR")!=null){
                    zonEstruGeopoData.setIndBorr(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_BORR")).toString()));    
                }
                UtilidadesLog.debug("");
                if (rs.getValueAt(i,"PAIS_OID_PAIS")!=null){
                    SegPaisViewData segPaisViewData = new SegPaisViewData();
                    segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                    zonEstruGeopoData.setPaisOidPais(segPaisViewData);
                }
                UtilidadesLog.debug("5");
                if (rs.getValueAt(i,"COD_SUBE")!=null){
                    zonSubesGeopoData.setCodSube(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_SUBE")).toString()));
                }
                UtilidadesLog.debug("");
                if (rs.getValueAt(i,"VAL_I18N")!=null){
                    zonSubesGeopoData.setDescripcion(rs.getValueAt(i,"VAL_I18N").toString());
                }
                UtilidadesLog.debug("6");
                zonSubesGeopoData.setEgeoOidEstrGeop(zonEstruGeopoData);
                
                if (rs.getValueAt(i,"OID_SUBE_GEOP")!=null){
                     zonSubesGeopoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_SUBE_GEOP")).toString()));
                }
                UtilidadesLog.debug("7");
                result.add(zonSubesGeopoData);
            }
        }
        UtilidadesLog.debug("result: " + result);
        UtilidadesLog.info("DAOSubesGeopol.query(ZonSubesGeopoData zonSubesGeopoFrom, ZonSubesGeopoData zonSubesGeopoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
}