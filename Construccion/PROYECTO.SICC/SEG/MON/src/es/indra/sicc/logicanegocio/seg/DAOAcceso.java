package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegAccesData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegTipoPerioData;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;

public class DAOAcceso 
{
    public DAOAcceso()
    {
    }
    
    public Hashtable guardar(SegAccesData segAcces, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOAcceso.guardar(SegAccesData segAcces, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_ACCE_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_ACCES ( ");
        update.append("OID_ACCE, "); 
        update.append("COD_ACCE, "); 
        update.append("CANA_OID_CANA, "); 
        update.append("IND_ACCE "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segAcces.getCodAcce() + "', ");
        update.append(segAcces.getCanaOidCana().getId() + ", ");
        update.append(" '" + segAcces.getIndAcce() + "' ");
        
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
            updateInter.append(" 'SEG_ACCES', ");
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
    
        UtilidadesLog.info("DAOAcceso.guardar(SegAccesData segAcces, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }

    public void remove(Vector segAccesFrom) throws MareException
    {
        UtilidadesLog.info("DAOAcceso.remove(Vector segAccesFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segAccesFrom.size();
        SegAccesData segAccesData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segAccesData = (SegAccesData)segAccesFrom.get(j);
             
            oids = oids + "," + segAccesData.getId();
        }
        
        update.append("delete SEG_ACCES ");
        update.append("where OID_ACCE in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_ACCES' ");
        
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
        
        UtilidadesLog.info("DAOAcceso.remove(Vector segAccesFrom): Salida");
    }
    
    public Vector query(SegAccesData segAccesFrom, SegAccesData SegAccesTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.info("DAOAcceso.query(SegAccesData segAccesFrom, SegAccesData SegAccesTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
        if(applyStructuralSecurity.booleanValue()){
            
            Property userID = (Property)userProperties.get("userID");
    
            query.append(" SELECT OID_ACCE, COD_ACCE, IND_ACCE, ");
            query.append(" i18n.VAL_I18N DESC_ACCES,  CANA_OID_CANA, i18n1.VAL_I18N DESC_CANAL ");
            query.append(" FROM VCA_SEG_ACCES, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
            query.append(" WHERE OID_ACCE = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_ACCES' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND CANA_OID_CANA = i18n1.val_oid ");
            query.append(" AND i18n1.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n1.attr_num_atri = 1 ");
            query.append(" AND i18n1.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND COD_USUA = '" + userID.getValue() + "' ");
        
        } else {
        
            query.append(" SELECT OID_ACCE, COD_ACCE, IND_ACCE, ");
            query.append(" i18n.VAL_I18N DESC_ACCES,  CANA_OID_CANA, i18n1.VAL_I18N DESC_CANAL ");
            query.append(" FROM SEG_ACCES, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
            query.append(" WHERE OID_ACCE = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_ACCES' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND CANA_OID_CANA = i18n1.val_oid ");
            query.append(" AND i18n1.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n1.attr_num_atri = 1 ");
            query.append(" AND i18n1.idio_oid_idio = " + (String)idioma.getValue());
            
        }        
        
        // Para la busqueda
        if(segAccesFrom.getCodAcce()!= null){
            query.append(" and COD_ACCE like '" + segAccesFrom.getCodAcce() + "' ");
        }
        
        if(segAccesFrom.getDescripcion()!= null){
            query.append(" and i18n.VAL_I18N like '" + segAccesFrom.getDescripcion() + "' ");
        }
        
        if(segAccesFrom.getCanaOidCana()!= null){
            query.append(" and CANA_OID_CANA = " + segAccesFrom.getCanaOidCana().getId());
        }
        
        if(segAccesFrom.getIndAcce()!= null){
            query.append(" and IND_ACCE = '" + segAccesFrom.getIndAcce() + "' ");
        }
        
        // Para el detalle
        if(segAccesFrom.getId()!= null){
            query.append(" and OID_ACCE = " + segAccesFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegAccesData segAccesData = null;
        SegCanalViewData segCanalViewData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                segAccesData = new SegAccesData();
                
                segAccesData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ACCE")).toString()));
                segAccesData.setCodAcce((String)rs.getValueAt(i,"COD_ACCE"));  
                segAccesData.setDescripcion((String)rs.getValueAt(i,"DESC_ACCES"));   
                segAccesData.setIndAcce((String)rs.getValueAt(i,"IND_ACCE")); 
                
                segCanalViewData = new SegCanalViewData();
                segCanalViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).toString()));
                segCanalViewData.setDescripcion((String)rs.getValueAt(i,"DESC_CANAL"));   
                segAccesData.setCanaOidCana(segCanalViewData);
                
                result.add(segAccesData);
                
            } else {
               break;
            }
        }        
        
        UtilidadesLog.debug("result: " + result);
              
        UtilidadesLog.info("DAOAcceso.query(SegAccesData segAccesFrom, SegAccesData SegAccesTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }

    public void update(SegAccesData segAcces, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOAcceso.update(SegAccesData segAcces, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_ACCES SET ");
        update.append(" IND_ACCE = '" + segAcces.getIndAcce() + "' ");
        
        update.append(" WHERE OID_ACCE = " + segAcces.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // Borrar los registros internalizacion
        StringBuffer deleteInter = new StringBuffer();
        
        deleteInter.append("delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + segAcces.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_ACCES' ");
        
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
            updateInter.append(" 'SEG_ACCES', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segAcces.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("DAOAcceso.update(SegAccesData segAcces, Vector localizationLabels): Salida");
    }
}