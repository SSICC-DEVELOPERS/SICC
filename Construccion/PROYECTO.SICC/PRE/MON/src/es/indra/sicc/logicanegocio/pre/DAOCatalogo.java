package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCatalData;
import es.indra.belcorp.mso.SegPaisViewData;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOCatalogo 
{
    public DAOCatalogo()
    {
    }
    
    public Vector query(PreCatalData preCatalFrom, PreCatalData preCatalTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOCatalogo.query(PreCatalOrdenData preCatalOrdenFrom, PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Entrada");
        
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
        
      
        query.append(" SELECT OID_CATA, COD_CATA, DES_CATA, PAIS_OID_PAIS ");
        query.append(" FROM  PRE_CATAL ");
        query.append(" WHERE 1 = 1");
        
        
        // Para la busqueda
        if(preCatalFrom.getCodCata()!= null){
            query.append(" and COD_CATA = " + preCatalFrom.getCodCata());
        }
        
        if(preCatalFrom.getDesCata()!= null){
            query.append(" and DES_CATA like '" + preCatalFrom.getDesCata() + "' ");
        }
       
        if(preCatalFrom.getId()== null){
            query.append(" AND PAIS_OID_PAIS = " + preCatalFrom.getPaisOidPais().getId());     
        } 
        
        // Para el detalle
        if(preCatalFrom.getId()!= null){
            query.append(" and OID_CATA = " + preCatalFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreCatalData preCatalData = null;
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
                  preCatalData = new PreCatalData();
                  
                  preCatalData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CATA")).toString()));   
                  preCatalData.setCodCata(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_CATA")).toString()));   
                  preCatalData.setDesCata((String)rs.getValueAt(i,"DES_CATA"));
                  
                  segPaisViewData = new SegPaisViewData();
                  segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));   
                  preCatalData.setPaisOidPais(segPaisViewData);
                 
                  result.add(preCatalData);
                
            } else {
               break;
            }
        }
                
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOCatalogo.query(PreCatalOrdenData preCatalOrdenFrom, PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Salida");
        return result;
        
    }
    
    public Vector query(PreCatalData preCatalFrom, PreCatalData preCatalTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOCatalogo.query(PreCatalData preCatalFrom, PreCatalData preCatalTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_CATA, COD_CATA, DES_CATA, PAIS_OID_PAIS ");
      query.append(" FROM PRE_CATAL ");
      query.append(" ORDER BY DES_CATA ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      PreCatalData preCatalData = null;
      SegPaisViewData segPaisViewData = null;
      
      for(int i=0; i < cant; i++){
          preCatalData = new PreCatalData();
          
          preCatalData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CATA")).toString()));
          preCatalData.setCodCata(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_CATA")).toString()));
          preCatalData.setDesCata((String)rs.getValueAt(i,"DES_CATA"));
          
          segPaisViewData = new SegPaisViewData();
          segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));   
          preCatalData.setPaisOidPais(segPaisViewData);
          
          resultado.add(preCatalData);
      }
      
      UtilidadesLog.info("DAOCatalogo.query(PreCatalData preCatalFrom, PreCatalData preCatalTo, HashMap userProperties): Salida");
      
      return resultado;
    }
}
