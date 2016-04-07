package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaData;
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

public class DAOMarca 
{
    public DAOMarca()
    {
    }
    
    public Hashtable guardar(SegMarcaData segMarca, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOMarca.guardar(SegMarcaData segMarca, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_MARC_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_MARCA ( ");
        update.append("OID_MARC, "); 
        update.append("COD_MARC, "); 
        update.append("DES_MARC "); 
        
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segMarca.getCodMarc() + "', ");
        update.append(" '" + segMarca.getDesMarc() + "' ");
        
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
    
        UtilidadesLog.info("DAOMarca.guardar(SegMarcaData segMarca, HashMap userProperties): Salida");
        return primaryKey;
    }
    
     public void remove(Vector segMarcaFrom) throws MareException
    {
        UtilidadesLog.info("DAOMarca.remove(Vector segMarcaFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = segMarcaFrom.size();
        SegMarcaData segMarcaData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segMarcaData = (SegMarcaData)segMarcaFrom.get(j);
             
            oids = oids + "," + segMarcaData.getId();
        }
        
        update.append("delete SEG_MARCA ");
        update.append("where OID_MARC in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOMarca.remove(Vector segMarcaFrom): Salida");        
    }
    
    public Vector query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.info("DAOMarca.query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Entrada");
        
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
        
                
        if(!applyStructuralSecurity){
      
          query.append(" select OID_MARC, COD_MARC, DES_MARC ");
          query.append(" from SEG_MARCA ");
          query.append(" WHERE 1 = 1 ");          
          
        } else {
      
          Property userID = (Property)userProperties.get("userID");
      
          query.append(" select OID_MARC, COD_MARC, DES_MARC ");
          query.append(" from VCA_SEG_MARCA ");
          query.append(" where COD_USUA = '" + userID.getValue() + "' ");
        }
        
        // Para la busqueda
        if(segMarcaFrom.getCodMarc()!= null){
            query.append(" and COD_MARC like '" + segMarcaFrom.getCodMarc() + "' ");
        }
        
        if(segMarcaFrom.getDesMarc()!= null){
            query.append(" and DES_MARC like '" + segMarcaFrom.getDesMarc() + "' ");
        }
        
        // Para el detalle
        if(segMarcaFrom.getId()!= null){
            query.append(" and OID_MARC = " + segMarcaFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegMarcaData segMarcaData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                  segMarcaData = new SegMarcaData();
          
                  segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));                  
                  segMarcaData.setCodMarc((String)rs.getValueAt(i,"COD_MARC"));
                  segMarcaData.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));
                 
                  result.add(segMarcaData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOMarca.query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Salida");
        return result;
        
    }
    
    public void update(SegMarcaData segMarca) throws MareException
    {
        UtilidadesLog.info("DAOMarca.update(SegMarcaData segMarca): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_MARCA SET ");
        update.append("DES_MARC = '" + segMarca.getDesMarc() + "' ");
        
        update.append(" WHERE OID_MARC = " + segMarca.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOMarca.update(SegMarcaData segMarca): Salida");
    }
}