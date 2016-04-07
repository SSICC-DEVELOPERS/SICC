package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCicloVidaData;
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

public class DAOCicloVida 
{
    public DAOCicloVida()
    {
    }
    
    public Vector query(PreCicloVidaData preCicloVidaFrom, PreCicloVidaData preCicloVidaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOCicloVida.query(PreCicloVidaData preCicloVidaFrom, PreCicloVidaData preCicloVidaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" select OID_CICL_VIDA, COD_CICL_VIDA, i18n.VAL_I18N ");
        query.append(" from PRE_CICLO_VIDA, V_GEN_I18N_SICC i18n ");
        query.append(" where OID_CICL_VIDA = i18n.VAL_OID ");
        query.append(" and i18n.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      
        
        // Para la busqueda
        if(preCicloVidaFrom.getCodCiclVida()!= null){
            query.append(" and COD_CICL_VIDA like '" + preCicloVidaFrom.getCodCiclVida() + "' ");
        }
        
        if(preCicloVidaFrom.getDescripcion()!= null){
            query.append(" and i18n.VAL_I18N like '" + preCicloVidaFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(preCicloVidaFrom.getId()!= null){
            query.append(" and OID_CICL_VIDA = " + preCicloVidaFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreCicloVidaData preCicloVidaData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                preCicloVidaData = new PreCicloVidaData();
                
                preCicloVidaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CICL_VIDA")).toString()));
                preCicloVidaData.setCodCiclVida((String)rs.getValueAt(i,"COD_CICL_VIDA"));  
                preCicloVidaData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));                
                
                result.add(preCicloVidaData);
                
            } else {
               break;
            }
        }
                
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOCicloVida.query(PreCicloVidaData preCicloVidaFrom, PreCicloVidaData preCicloVidaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
}
