package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaCorpoMarcaProduData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.SegMarcaProduData;
import es.indra.belcorp.mso.SegPaisViewData;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOMarcaCorpoMarcaProducto 
{
    public DAOMarcaCorpoMarcaProducto()
    {
    }
        
    public Hashtable guardar(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOMarcaCorpoMarcaProducto.guardar(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_MMPR_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_MARCA_CORPO_MARCA_PRODU ( ");
        update.append("OID_MARC_CORP_MARC_PROD, "); 
        update.append("MARC_OID_MARC, "); 
        update.append("MAPR_OID_MARC_PROD, "); 
        update.append("PAIS_OID_PAIS "); 
        
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(segMarcaCorpoMarcaProdu.getMarcOidMarc().getId() + ", ");
        update.append(segMarcaCorpoMarcaProdu.getMaprOidMarcProd().getId() + ", ");
        update.append(segMarcaCorpoMarcaProdu.getPaisOidPais().getId());
        
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
    
        UtilidadesLog.info("DAOMarcaCorpoMarcaProducto.guardar(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector segMarcaCorpoMarcaProduFrom) throws MareException
    {
        UtilidadesLog.info("DAOMarcaCorpoMarcaProducto.remove(Vector segMarcaCorpoMarcaProduFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = segMarcaCorpoMarcaProduFrom.size();
        SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segMarcaCorpoMarcaProduData = (SegMarcaCorpoMarcaProduData)segMarcaCorpoMarcaProduFrom.get(j);
             
            oids = oids + "," + segMarcaCorpoMarcaProduData.getId();
        }
        
        update.append("delete SEG_MARCA_CORPO_MARCA_PRODU ");
        update.append("where OID_MARC_CORP_MARC_PROD in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOMarcaCorpoMarcaProducto.remove(Vector segMarcaCorpoMarcaProduFrom): Salida");        
    }
    
    public Vector query(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOMarcaCorpoMarcaProducto.query(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
             
        query.append(" select OID_MARC_CORP_MARC_PROD, MARC_OID_MARC, DES_MARC, ");
        query.append(" MAPR_OID_MARC_PROD, DES_MARC_PROD, PAIS_OID_PAIS ");
        query.append(" from SEG_MARCA_CORPO_MARCA_PRODU, SEG_MARCA, SEG_MARCA_PRODU ");          
        query.append(" where MARC_OID_MARC = OID_MARC ");  
        query.append(" and MAPR_OID_MARC_PROD = OID_MARC_PROD ");  
        
        // Para la busqueda
        if(segMarcaCorpoMarcaProduFrom.getMarcOidMarc()!= null){
            query.append(" and MARC_OID_MARC = " + segMarcaCorpoMarcaProduFrom.getMarcOidMarc().getId());
        }
        
        if(segMarcaCorpoMarcaProduFrom.getMaprOidMarcProd()!= null){
            query.append(" and MAPR_OID_MARC_PROD = " + segMarcaCorpoMarcaProduFrom.getMaprOidMarcProd().getId());
        }
        
        if(segMarcaCorpoMarcaProduFrom.getPaisOidPais()!= null){
            query.append(" and PAIS_OID_PAIS = " + segMarcaCorpoMarcaProduFrom.getPaisOidPais().getId());
        }
        
        // Para el detalle
        if(segMarcaCorpoMarcaProduFrom.getId()!= null){
            query.append(" and OID_MARC_CORP_MARC_PROD = " + segMarcaCorpoMarcaProduFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduData = null;
        SegMarcaProduData segMarcaProduData = null;
        SegMarcaData segMarcaData = null;
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
                  segMarcaCorpoMarcaProduData = new SegMarcaCorpoMarcaProduData();
          
                  segMarcaCorpoMarcaProduData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC_CORP_MARC_PROD")).toString()));       
                  
                  segMarcaProduData = new SegMarcaProduData();
                  segMarcaProduData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MAPR_OID_MARC_PROD")).toString()));    
                  segMarcaProduData.setDesMarcProd((String)rs.getValueAt(i,"DES_MARC_PROD"));                  
                  segMarcaCorpoMarcaProduData.setMaprOidMarcProd(segMarcaProduData);
                  
                  segMarcaData = new SegMarcaData();
                  segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).toString()));    
                  segMarcaData.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));                  
                  segMarcaCorpoMarcaProduData.setMarcOidMarc(segMarcaData);
                  
                  segPaisViewData = new SegPaisViewData();
                  segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));   
                  segMarcaCorpoMarcaProduData.setPaisOidPais(segPaisViewData);
                 
                  result.add(segMarcaCorpoMarcaProduData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOMarcaCorpoMarcaProducto.query(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu) throws MareException
    {
        UtilidadesLog.info("No hay CU Modificacion");        
    }
}