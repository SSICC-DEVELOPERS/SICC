package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCondiPromoData;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import es.indra.mare.common.exception.MareException;

public class DAOCondicionPromocion 
{
    public DAOCondicionPromocion()
    {
    }
    
    public Vector query(PreCondiPromoData preCondiPromoFrom, PreCondiPromoData preCondiPromoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOCondicionPromocion.query(PreCondiPromoData preCondiPromoFrom, PreCondiPromoData preCondiPromoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" select OID_COND_PROM, COD_COND_PROM, i18n.VAL_I18N ");
        query.append(" from PRE_CONDI_PROMO, V_GEN_I18N_SICC i18n ");
        query.append(" where OID_COND_PROM = i18n.VAL_OID ");
        query.append(" and i18n.ATTR_ENTI = 'PRE_CONDI_PROMO' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      
        
        // Para la busqueda
        if(preCondiPromoFrom.getCodCondProm()!= null){
            query.append(" and COD_COND_PROM like '" + preCondiPromoFrom.getCodCondProm() + "' ");
        }
        
        if(preCondiPromoFrom.getDescripcion()!= null){
            query.append(" and i18n.VAL_I18N like '" + preCondiPromoFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(preCondiPromoFrom.getId()!= null){
            query.append(" and OID_COND_PROM = " + preCondiPromoFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreCondiPromoData preCondiPromoData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                preCondiPromoData = new PreCondiPromoData();
                
                preCondiPromoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_COND_PROM")).toString()));
                preCondiPromoData.setCodCondProm((String)rs.getValueAt(i,"COD_COND_PROM"));  
                preCondiPromoData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));                
                
                result.add(preCondiPromoData);
                
            } else {
               break;
            }
        }
                
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOCondicionPromocion.query(PreCondiPromoData preCondiPromoFrom, PreCondiPromoData preCondiPromoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
}