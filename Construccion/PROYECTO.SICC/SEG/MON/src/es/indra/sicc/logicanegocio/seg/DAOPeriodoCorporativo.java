package es.indra.sicc.logicanegocio.seg;

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
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.SegPerioCorpoData;
import es.indra.belcorp.mso.GenDetaSiccData;
import java.util.Hashtable;

public class DAOPeriodoCorporativo 
{
    public DAOPeriodoCorporativo()
    {
    }
    
    public Hashtable guardar(SegPerioCorpoData segPerioCorpo, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOPeriodoCorporativo.guardar(SegPerioCorpoData segPerioCorpo, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_PERI_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_PERIO_CORPO ( ");
        update.append("OID_PERI, "); 
        update.append("COD_PERI, "); 
        update.append("TIPE_OID_TIPO_PERI, "); 
        update.append("VAL_ANIO "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segPerioCorpo.getCodPeri() + "', ");
        update.append(segPerioCorpo.getTipeOidTipoPeri().getId() + ", ");
        update.append(segPerioCorpo.getValAnio());
        
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
            updateInter.append(" 'SEG_PERIO_CORPO', ");
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
    
        UtilidadesLog.info("DAOPeriodoCorporativo.guardar(SegPerioCorpoData segPerioCorpo, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector segPerioCorpoFrom) throws MareException
    {
        UtilidadesLog.info("DAOPeriodoCorporativo.remove(Vector segPerioCorpoFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segPerioCorpoFrom.size();
        SegPerioCorpoData segPerioCorpoData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segPerioCorpoData = (SegPerioCorpoData)segPerioCorpoFrom.get(j);
             
            oids = oids + "," + segPerioCorpoData.getId();
        }
        
        update.append("delete SEG_PERIO_CORPO ");
        update.append("where OID_PERI in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_PERIO_CORPO' ");
        
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
        
        UtilidadesLog.info("DAOPeriodoCorporativo.remove(Vector segPerioCorpoFrom): Salida");
    }
    
    public Vector query(SegPerioCorpoData segPerioCorpoFrom, SegPerioCorpoData segPerioCorpoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOPeriodoCorporativo.query(SegPerioCorpoData segPerioCorpoFrom, SegPerioCorpoData segPerioCorpoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_PERI, COD_PERI, TIPE_OID_TIPO_PERI, ");
        query.append(" VAL_ANIO, i18n.val_i18n DESC_PERI, i18n1.val_i18n DESC_TIPOPERI ");
        query.append(" FROM SEG_PERIO_CORPO, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
        query.append(" WHERE OID_PERI = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'SEG_PERIO_CORPO' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" and i18n1.ATTR_ENTI = 'SEG_TIPO_PERIO' ");
        query.append(" and i18n1.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" and i18n1.val_oid = TIPE_OID_TIPO_PERI ");
        
        // Para la busqueda
        if(segPerioCorpoFrom.getCodPeri()!= null){
            query.append(" and COD_PERI like '" + segPerioCorpoFrom.getCodPeri() + "' ");
        }
        
        if(segPerioCorpoFrom.getTipeOidTipoPeri()!= null){
            query.append(" and TIPE_OID_TIPO_PERI = " + segPerioCorpoFrom.getTipeOidTipoPeri().getId());
        }
        
        if(segPerioCorpoFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + segPerioCorpoFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(segPerioCorpoFrom.getId()!= null){
            query.append(" and OID_PERI = " + segPerioCorpoFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegPerioCorpoData segPerioCorpoData = null;
        SegTipoPerioData segTipoPerioData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                segPerioCorpoData = new SegPerioCorpoData();
                
                segPerioCorpoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PERI")).toString()));
                segPerioCorpoData.setCodPeri((String)rs.getValueAt(i,"COD_PERI"));  
                segPerioCorpoData.setValAnio(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_ANIO")).toString()));
                segPerioCorpoData.setDescripcion((String)rs.getValueAt(i,"DESC_PERI"));    
                
                segTipoPerioData = new SegTipoPerioData();
                segTipoPerioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIPE_OID_TIPO_PERI")).toString()));
                segTipoPerioData.setDescripcion((String)rs.getValueAt(i,"DESC_TIPOPERI"));  
                segPerioCorpoData.setTipeOidTipoPeri(segTipoPerioData);                
                
                result.add(segPerioCorpoData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOPeriodoCorporativo.query(SegPerioCorpoData segPerioCorpoFrom, SegPerioCorpoData segPerioCorpoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(SegPerioCorpoData segPerioCorpo, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOPeriodoCorporativo.update(SegPerioCorpoData segPerioCorpo, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_PERIO_CORPO SET ");
        update.append(" VAL_ANIO = " + segPerioCorpo.getValAnio());
        update.append(" WHERE OID_PERI = " + segPerioCorpo.getId());   
        
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
        deleteInter.append(" where VAL_OID = " + segPerioCorpo.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_PERIO_CORPO' ");
        
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
            updateInter.append(" 'SEG_PERIO_CORPO', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segPerioCorpo.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
               
        UtilidadesLog.info("DAOPeriodoCorporativo.update(SegPerioCorpoData segPerioCorpo, Vector localizationLabels): Salida");
    }

}