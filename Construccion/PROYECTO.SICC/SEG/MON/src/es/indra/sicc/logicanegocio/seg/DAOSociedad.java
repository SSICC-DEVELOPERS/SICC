package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.BelFormaPagoTaponData;
import es.indra.belcorp.mso.SegMonedData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.belcorp.mso.SegSocieData;
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
import es.indra.mare.common.mgu.manager.Property;

public class DAOSociedad 
{
    public DAOSociedad()
    {
    }
    
    public Hashtable guardar(SegSocieData segSocie) throws MareException
    {
        UtilidadesLog.info("DAOSociedad.guardar(FacParamFactuData facParamFactu): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_SOCI_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_SOCIE ( ");
        update.append("OID_SOCI, "); 
        update.append("PAIS_OID_PAIS, "); 
        update.append("COD_SOCI, "); 
        update.append("VAL_IDEN_FISC, "); 
        update.append("VAL_DENO, "); 
        
        update.append("VAL_DIRE, "); 
        update.append("VAL_TLFN, "); 
        update.append("VAL_FAX "); 
       
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(segSocie.getPaisOidPais().getId() + ", ");
        update.append(" '" + segSocie.getCodSoci() + "', ");
        update.append(" '" + segSocie.getValIdenFisc() + "', ");
        update.append(" '" + segSocie.getValDeno() + "' ");
        
        if (segSocie.getValDire() != null) {
            update.append(", '" + segSocie.getValDire() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (segSocie.getValTlfn() != null) {
            update.append(", '" + segSocie.getValTlfn() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (segSocie.getValFax() != null) {
            update.append(", '" + segSocie.getValFax() + "' ");
        } else {
            update.append(", NULL ");
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
    
        UtilidadesLog.info("DAOSociedad.guardar(FacParamFactuData facParamFactuu): Salida");
        return primaryKey;
    }
    
    public void remove(Vector SegSocieFrom) throws MareException
    {
        UtilidadesLog.info("DAOSociedad.remove(Vector SegSocieFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = SegSocieFrom.size();
        SegSocieData segSocieData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segSocieData = (SegSocieData)SegSocieFrom.get(j);
             
            oids = oids + "," + segSocieData.getId();
        }
        
        update.append("delete SEG_SOCIE ");
        update.append("where OID_SOCI in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOSociedad.remove(Vector SegSocieFrom): Salida");
    }
    
    public Vector query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOSociedad.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
       
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

        query.append(" select OID_SOCI,  COD_SOCI,  VAL_IDEN_FISC, ");
        query.append(" PAIS_OID_PAIS,  VAL_DENO, VAL_DIRE, VAL_TLFN,  VAL_FAX ");
        query.append(" from SEG_SOCIE ");
                
        if(segSocieFrom.getId()!= null){
            query.append(" where 1= 1 ");       
        } else {
            query.append(" where PAIS_OID_PAIS = " + segSocieFrom.getPaisOidPais().getId());     
        }        
        
        // Para la busqueda       
        if(segSocieFrom.getCodSoci()!= null){
            query.append(" and COD_SOCI LIKE '" + segSocieFrom.getCodSoci() + "' ");
        }
        
        if(segSocieFrom.getValDeno()!= null){
            query.append(" and VAL_DENO LIKE '" + segSocieFrom.getValDeno() + "' ");
        }
        
        // Para el detalle
        if(segSocieFrom.getId()!= null){
            query.append(" and OID_SOCI = " + segSocieFrom.getId());
        }
        
        
        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        SegSocieData segSocieData = null;
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
                segSocieData = new SegSocieData();
                
                segSocieData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_SOCI")).toString()));
                segSocieData.setCodSoci((String)rs.getValueAt(i,"COD_SOCI"));
                segSocieData.setValIdenFisc((String)rs.getValueAt(i,"VAL_IDEN_FISC"));
                segSocieData.setValDeno((String)rs.getValueAt(i,"VAL_DENO"));
                                                
                segPaisViewData = new SegPaisViewData();
                segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));           
                segSocieData.setPaisOidPais(segPaisViewData);                 
                
                     
                if((String)rs.getValueAt(i,"VAL_DIRE") != null){
                    segSocieData.setValDire((String)rs.getValueAt(i,"VAL_DIRE"));
                }
                
                if((String)rs.getValueAt(i,"VAL_TLFN") != null){
                    segSocieData.setValTlfn((String)rs.getValueAt(i,"VAL_TLFN"));
                }
                
                if((String)rs.getValueAt(i,"VAL_FAX") != null){
                    segSocieData.setValFax((String)rs.getValueAt(i,"VAL_FAX"));
                }
                
                result.add(segSocieData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOSociedad.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
        
    }
    
    
    public void update(SegSocieData segSocie) throws MareException
    {
        UtilidadesLog.info("DAOSociedad.update(SegSocieData segSocie): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_SOCIE SET ");
        update.append("VAL_IDEN_FISC = '" + segSocie.getValIdenFisc() + "', ");
        update.append("VAL_DENO = '" + segSocie.getValDeno() + "' ");
        
        if (segSocie.getValDire() != null) {
            update.append(", VAL_DIRE = '" + segSocie.getValDire() + "' ");
        } else {
            update.append(", VAL_DIRE = NULL ");
        }
        
        if (segSocie.getValTlfn() != null) {
            update.append(", VAL_TLFN = '" + segSocie.getValTlfn() + "' ");
        } else {
            update.append(", VAL_TLFN = NULL ");
        }
        
        if (segSocie.getValFax() != null) {
            update.append(", VAL_FAX = '" + segSocie.getValFax() + "' ");
        } else {
            update.append(", VAL_FAX = NULL ");
        }
                
        update.append(" WHERE OID_SOCI = " + segSocie.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }        
               
        UtilidadesLog.info("DAOSociedad.update(SegSocieData segSocie): Salida");
    }
}
