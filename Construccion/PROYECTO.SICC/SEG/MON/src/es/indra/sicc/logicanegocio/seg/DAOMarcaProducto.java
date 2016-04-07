package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaProduData;
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

public class DAOMarcaProducto 
{
    public DAOMarcaProducto()
    {
    }
    
    public Hashtable guardar(SegMarcaProduData segMarcaProdu, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOMarcaProducto.guardar(SegMarcaProduData segMarcaProdu, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_MAPR_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_MARCA_PRODU ( ");
        update.append("OID_MARC_PROD, "); 
        update.append("COD_MARC_PROD, "); 
        update.append("DES_MARC_PROD "); 
        
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segMarcaProdu.getCodMarcProd() + "', ");
        update.append(" '" + segMarcaProdu.getDesMarcProd() + "' ");
        
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
    
        UtilidadesLog.info("DAOMarcaProducto.guardar(SegMarcaProduData segMarcaProdu, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public Vector query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOMarcaProducto.query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" select OID_MARC_PROD, COD_MARC_PROD, DES_MARC_PROD ");
        query.append(" from SEG_MARCA_PRODU ");
        query.append(" WHERE 1 = 1 ");          
          
        // Para la busqueda
        if(segMarcaProduFrom.getCodMarcProd()!= null){
            query.append(" and COD_MARC_PROD like '" + segMarcaProduFrom.getCodMarcProd() + "' ");
        }
        
        if(segMarcaProduFrom.getDesMarcProd()!= null){
            query.append(" and DES_MARC_PROD like '" + segMarcaProduFrom.getDesMarcProd() + "' ");
        }
        
        // Para el detalle
        if(segMarcaProduFrom.getId()!= null){
            query.append(" and OID_MARC_PROD = " + segMarcaProduFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegMarcaProduData segMarcaProduData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                  segMarcaProduData = new SegMarcaProduData();
          
                  segMarcaProduData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC_PROD")).toString()));                  
                  segMarcaProduData.setCodMarcProd((String)rs.getValueAt(i,"COD_MARC_PROD"));
                  segMarcaProduData.setDesMarcProd((String)rs.getValueAt(i,"DES_MARC_PROD"));
                 
                  result.add(segMarcaProduData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void remove(Vector segMarcaProduFrom) throws MareException
    {
        UtilidadesLog.info("DAOMarcaProducto.remove(Vector segMarcaProduFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = segMarcaProduFrom.size();
        SegMarcaProduData segMarcaProduData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segMarcaProduData = (SegMarcaProduData)segMarcaProduFrom.get(j);
             
            oids = oids + "," + segMarcaProduData.getId();
        }
        
        update.append("delete SEG_MARCA_PRODU ");
        update.append("where OID_MARC_PROD in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOMarcaProducto.remove(Vector segMarcaProduFrom): Salida");        
    }
    
    public void update(SegMarcaProduData segMarcaProdu) throws MareException
    {
        UtilidadesLog.info("DAOMarcaProducto.update(SegMarcaProduData segMarcaProdu): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_MARCA_PRODU SET ");
        update.append("DES_MARC_PROD = '" + segMarcaProdu.getDesMarcProd() + "' ");
        
        update.append(" WHERE OID_MARC_PROD = " + segMarcaProdu.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOMarcaProducto.update(SegMarcaProduData segMarcaProdu): Salida");
    }
    
    public Vector query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOMarcaProducto.query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      Vector resultado = new Vector();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      query.append(" select OID_MARC_PROD, DES_MARC_PROD ");
      query.append(" from SEG_MARCA_PRODU ");
      query.append(" ORDER BY DES_MARC_PROD ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      SegMarcaProduData segMarcaProduData = null;
      
      for(int i=0; i < cant; i++){
          segMarcaProduData = new SegMarcaProduData();
          
          segMarcaProduData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC_PROD")).toString()));
          segMarcaProduData.setDesMarcProd((String)rs.getValueAt(i,"DES_MARC_PROD"));
          
          resultado.add(segMarcaProduData);
      }
      
      UtilidadesLog.info("DAOMarcaProducto.query(SegMarcaProduData segMarcaProduFrom, SegMarcaProduData segMarcaProduTo, HashMap userProperties): Salida");
      
      return resultado;
    }
}