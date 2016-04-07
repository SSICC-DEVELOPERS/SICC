package es.indra.sicc.logicanegocio.pre;

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
import es.indra.belcorp.mso.PreCatalOrdenData;
import es.indra.belcorp.mso.PreCatalData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.SegPaisViewData;

public class DAOCatalogoOrden 
{
    public DAOCatalogoOrden()
    {
    }
   
    public Hashtable guardar(PreCatalOrdenData preCatalOrden, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOCatalogoOrden.guardar(PreCatalOrdenData preCatalOrden, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT PRE_CATO_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO PRE_CATAL_ORDEN ( ");
        update.append("OID_CATA_ORDE, "); 
        update.append("MARC_OID_MARC, "); 
        update.append("CANA_OID_CANA, "); 
        update.append("OCAT_OID_CATA, "); 
        update.append("NUM_ORDE "); 
        
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(preCatalOrden.getMarcOidMarc().getId() + ", ");
        update.append(preCatalOrden.getCanaOidCana().getId() + ", ");
        update.append(preCatalOrden.getOcatOidCata().getId() + ", ");
        update.append(preCatalOrden.getNumOrde());
        
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
    
        UtilidadesLog.info("DAOCatalogoOrden.guardar(PreCatalOrdenData preCatalOrden, HashMap userProperties): Salida");
        return primaryKey;
    }

    public Vector query(PreCatalOrdenData preCatalOrdenFrom, PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOCatalogoOrden.query(PreCatalOrdenData preCatalOrdenFrom, PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Entrada");
        
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
      
        query.append(" SELECT OID_CATA_ORDE, OCAT_OID_CATA, DES_CATA, ");
        query.append(" CANA_OID_CANA, i18n.VAL_I18N, MARC_OID_MARC, DES_MARC, NUM_ORDE ");
        query.append(" FROM  PRE_CATAL_ORDEN, SEG_MARCA, PRE_CATAL, v_gen_i18n_sicc i18n ");
        query.append(" WHERE MARC_OID_MARC = OID_MARC ");
        query.append(" AND OCAT_OID_CATA = OID_CATA ");
        query.append(" AND CANA_OID_CANA = i18n.val_oid ");
        query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
        query.append(" AND i18n.attr_num_atri = 1 ");
        query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
        
        
        // Para la busqueda
        if(preCatalOrdenFrom.getCanaOidCana()!= null){
            query.append(" and CANA_OID_CANA = " + preCatalOrdenFrom.getCanaOidCana().getId());
        }
        
        if(preCatalOrdenFrom.getMarcOidMarc()!= null){
            query.append(" and MARC_OID_MARC = " + preCatalOrdenFrom.getMarcOidMarc().getId());
        }
        
        if(preCatalOrdenFrom.getOcatOidCata()!= null){
            query.append(" AND OCAT_OID_CATA = " + preCatalOrdenFrom.getOcatOidCata().getId());     
        }   
        
        // Para el detalle
        if(preCatalOrdenFrom.getId()!= null){
            query.append(" and OID_CATA_ORDE = " + preCatalOrdenFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreCatalOrdenData preCatalOrdenData = null;
        SegMarcaData segMarcaData = null;
        SegCanalViewData segCanalViewData = null;
        PreCatalData preCatalData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                  preCatalOrdenData = new PreCatalOrdenData();
          
                  preCatalOrdenData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CATA_ORDE")).toString()));                  
                  preCatalOrdenData.setNumOrde(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_ORDE")).toString()));     
                  
                  segMarcaData = new SegMarcaData();
                  segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).toString()));    
                  segMarcaData.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));                  
                  preCatalOrdenData.setMarcOidMarc(segMarcaData);
                  
                  segCanalViewData = new SegCanalViewData();
                  segCanalViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).toString()));
                  segCanalViewData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));   
                  preCatalOrdenData.setCanaOidCana(segCanalViewData);
                  
                  preCatalData = new PreCatalData();
                  preCatalData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OCAT_OID_CATA")).toString()));   
                  preCatalData.setDesCata((String)rs.getValueAt(i,"DES_CATA"));   
                  preCatalOrdenData.setOcatOidCata(preCatalData);
                 
                  result.add(preCatalOrdenData);
                
            } else {
               break;
            }
        }
                
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOCatalogoOrden.query(PreCatalOrdenData preCatalOrdenFrom, PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Salida");
        return result;
    }

    public void remove(Vector preCatalOrdenFrom) throws MareException
    {
        UtilidadesLog.info("DAOCatalogoOrden.remove(Vector preCatalOrdenFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = preCatalOrdenFrom.size();
        PreCatalOrdenData preCatalOrdenData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            preCatalOrdenData = (PreCatalOrdenData)preCatalOrdenFrom.get(j);
             
            oids = oids + "," + preCatalOrdenData.getId();
        }
        
        update.append("delete PRE_CATAL_ORDEN ");
        update.append("where OID_CATA_ORDE in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOCatalogoOrden.remove(Vector preCatalOrdenFrom): Salida");        
    }

    public void update(PreCatalOrdenData preCatalOrden) throws MareException
    {
        UtilidadesLog.info("DAOCatalogoOrden.update(PreCatalOrdenData preCatalOrden): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE PRE_CATAL_ORDEN SET ");
        update.append("NUM_ORDE = " + preCatalOrden.getNumOrde());
        
        update.append(" WHERE OID_CATA_ORDE = " + preCatalOrden.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOCatalogoOrden.update(PreCatalOrdenData preCatalOrden): Salida");
    }
}
