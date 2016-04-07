package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import java.math.BigDecimal;
import es.indra.belcorp.mso.PreIndicCuadrData;
import es.indra.mare.common.mgu.manager.Property;

public class DAOIndicadorCuadre 
{
    public DAOIndicadorCuadre()
    {
    }
    
    public Vector query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOIndicadorCuadre.query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_IND_CUAD, COD_INDI_CUAD, ");
        query.append(" i18n.val_i18n, VAL_FACT_CUAD ");
        query.append(" FROM PRE_INDIC_CUADR, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_IND_CUAD = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'PRE_INDIC_CUADR' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      
        
        // Para la busqueda
        if(preIndicCuadrFrom.getCodIndiCuad()!= null){
            query.append(" and COD_INDI_CUAD like '" + preIndicCuadrFrom.getCodIndiCuad() + "' ");
        }
        
        if(preIndicCuadrFrom.getDescripcion()!= null){
            query.append(" and i18n.VAL_I18N like '" + preIndicCuadrFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(preIndicCuadrFrom.getId()!= null){
            query.append(" and OID_IND_CUAD = " + preIndicCuadrFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreIndicCuadrData preIndicCuadrData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                preIndicCuadrData = new PreIndicCuadrData();
                
                preIndicCuadrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_IND_CUAD")).toString()));
                preIndicCuadrData.setCodIndiCuad(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_INDI_CUAD")).toString()));
                preIndicCuadrData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                preIndicCuadrData.setValFactCuad((String)rs.getValueAt(i,"VAL_FACT_CUAD"));
                
                result.add(preIndicCuadrData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOIndicadorCuadre.query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public Vector query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOIndicadorCuadre.query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties): Entrada");
      
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

      Property idioma = (Property)userProperties.get("Idioma");

      query.append(" SELECT OID_IND_CUAD, COD_INDI_CUAD, ");
      query.append(" i18n.val_i18n, VAL_FACT_CUAD ");
      query.append(" FROM PRE_INDIC_CUADR, v_gen_i18n_sicc i18n ");
      query.append(" WHERE OID_IND_CUAD = i18n.val_oid ");
      query.append(" and i18n.ATTR_ENTI = 'PRE_INDIC_CUADR' ");
      query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
      query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      query.append(" order by i18n.val_i18n ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      PreIndicCuadrData preIndicCuadrData = null;
      
      for(int i=0; i < cant; i++){
          preIndicCuadrData = new PreIndicCuadrData();
                
          preIndicCuadrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_IND_CUAD")).toString()));
          preIndicCuadrData.setCodIndiCuad(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_INDI_CUAD")).toString()));
          preIndicCuadrData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
          preIndicCuadrData.setValFactCuad((String)rs.getValueAt(i,"VAL_FACT_CUAD"));
          
          resultado.add(preIndicCuadrData);
      }
      
      UtilidadesLog.info("DAOIndicadorCuadre.query(PreIndicCuadrData preIndicCuadrFrom, PreIndicCuadrData preIndicCuadrTo, HashMap userProperties): Salida");
      
      return resultado;     
    }

}