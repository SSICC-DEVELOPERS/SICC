package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegDeptoEmpreData;
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

public class DAODepartamentoEmpresa 
{
    public DAODepartamentoEmpresa()
    {
    }
    
    public Hashtable guardar(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAODepartamentoEmpresa.guardar(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_DPTE_SEQ.NEXTVAL FROM DUAL");        
        
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
        
        update.append(" INSERT INTO SEG_DEPTO_EMPRE ( ");
        update.append("OID_DEPA, "); 
        update.append("COD_DPTO, "); 
        update.append("DES_CORT_DPTO "); 
        
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segDeptoEmpre.getCodDpto() + "', ");
        update.append(" '" + segDeptoEmpre.getDesCortDpto() + "' ");
        
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
            updateInter.append(" 'SEG_DEPTO_EMPRE', ");
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
    
        UtilidadesLog.info("DAODepartamentoEmpresa.guardar(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector segDeptoEmpreFrom) throws MareException
    {
        UtilidadesLog.info("DAODepartamentoEmpresa.remove(Vector segDeptoEmpreFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segDeptoEmpreFrom.size();
        SegDeptoEmpreData segDeptoEmpreData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segDeptoEmpreData = (SegDeptoEmpreData)segDeptoEmpreFrom.get(j);
             
            oids = oids + "," + segDeptoEmpreData.getId();
        }
        
        update.append("delete SEG_DEPTO_EMPRE ");
        update.append("where OID_DEPA in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_DEPTO_EMPRE' ");
        
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
        
        UtilidadesLog.info("DAODepartamentoEmpresa.remove(Vector segDeptoEmpreFrom): Salida");     
    }
    
    public Vector query(SegDeptoEmpreData segDeptoEmpreFrom, SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAODepartamentoEmpresa.query(SegDeptoEmpreData segDeptoEmpreFrom, SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
        query.append(" select OID_DEPA, COD_DPTO, DES_CORT_DPTO ");
        query.append(" from SEG_DEPTO_EMPRE ");
        query.append(" WHERE 1 = 1 ");         
        
        
        // Para la busqueda
        if(segDeptoEmpreFrom.getCodDpto()!= null){
            query.append(" and COD_DPTO like '" + segDeptoEmpreFrom.getCodDpto() + "' ");
        }
        
        if(segDeptoEmpreFrom.getDesCortDpto()!= null){
            query.append(" and DES_CORT_DPTO like '" + segDeptoEmpreFrom.getDesCortDpto() + "' ");
        }
        
        // Para el detalle
        if(segDeptoEmpreFrom.getId()!= null){
            query.append(" and OID_DEPA = " + segDeptoEmpreFrom.getId());
        }


        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegDeptoEmpreData segDeptoEmpreData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                segDeptoEmpreData = new SegDeptoEmpreData();
          
                segDeptoEmpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_DEPA")).toString()));                  
                segDeptoEmpreData.setCodDpto((String)rs.getValueAt(i,"COD_DPTO"));
                segDeptoEmpreData.setDesCortDpto((String)rs.getValueAt(i,"DES_CORT_DPTO"));
             
                result.add(segDeptoEmpreData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAODepartamentoEmpresa.query(SegDeptoEmpreData segDeptoEmpreFrom, SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAODepartamentoEmpresa.update(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        // Borrar los registros internalizacion
        StringBuffer deleteInter = new StringBuffer();
        
        deleteInter.append("delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + segDeptoEmpre.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_DEPTO_EMPRE' ");
        
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
            updateInter.append(" 'SEG_DEPTO_EMPRE', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segDeptoEmpre.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("DAODepartamentoEmpresa.update(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels): Salida");
    }
}