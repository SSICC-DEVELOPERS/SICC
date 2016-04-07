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
import es.indra.belcorp.mso.PreTipoEstraData;
import es.indra.belcorp.mso.PreArgumVentaData;
import es.indra.mare.common.mgu.manager.Property;

public class DAOArgumentoVenta 
{
    public DAOArgumentoVenta()
    {
    }
    
    public Vector query(PreTipoEstraData preTipoEstraFrom, PreTipoEstraData preTipoEstraTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOArgumentoVenta.query(PreTipoEstraData preTipoEstraFrom, PreTipoEstraData preTipoEstraTo, HashMap userProperties): Entrada");
      
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

      query.append(" select OID_TIPO_ESTR, COD_TIPO_ESTR, DES_TIPO_ESTR, ");
      query.append(" IND_ESTR_COND, IND_ESTR_GRUP, IND_ESTR_PAQU, IND_ESTR_VS ");
      query.append(" from PRE_TIPO_ESTRA ");
      query.append(" order by DES_TIPO_ESTR ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      PreTipoEstraData preTipoEstraData = null;
      
      for(int i=0; i < cant; i++){
          preTipoEstraData = new PreTipoEstraData();
          
          preTipoEstraData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_ESTR")).toString()));
          preTipoEstraData.setCodTipoEstr((String)rs.getValueAt(i,"COD_TIPO_ESTR"));
          preTipoEstraData.setDesTipoEstr((String)rs.getValueAt(i,"DES_TIPO_ESTR"));
          preTipoEstraData.setIndEstrCond(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_ESTR_COND")).toString()));
          preTipoEstraData.setIndEstrGrup(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_ESTR_GRUP")).toString()));
          preTipoEstraData.setIndEstrPaqu(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_ESTR_PAQU")).toString()));
          preTipoEstraData.setIndEstrVs(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_ESTR_VS")).toString()));
          
          resultado.add(preTipoEstraData);
      }
      
      UtilidadesLog.info("DAOArgumentoVenta.query(PreTipoEstraData preTipoEstraFrom, PreTipoEstraData preTipoEstraTo, HashMap userProperties): Salida");
      
      return resultado;      
    }

    public Vector query(PreArgumVentaData preArgumVentaFrom, PreArgumVentaData preArgumVentaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOArgumentoVenta.query(PreArgumVentaData preArgumVentaFrom, PreArgumVentaData preArgumVentaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_ARGU_VENT, COD_ARGU_VENT, i18n.VAL_I18N, ");
        query.append(" TIES_OID_TIPO_ESTR, DES_TIPO_ESTR, VAL_FACT_REPE  ");
        query.append(" FROM  PRE_ARGUM_VENTA, PRE_TIPO_ESTRA, v_gen_i18n_sicc i18n  ");
        query.append(" WHERE TIES_OID_TIPO_ESTR = OID_TIPO_ESTR ");
        query.append(" AND OID_ARGU_VENT = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'PRE_ARGUM_VENTA' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      
        
        // Para la busqueda
        if(preArgumVentaFrom.getCodArguVent()!= null){
            query.append(" and COD_ARGU_VENT like '" + preArgumVentaFrom.getCodArguVent() + "' ");
        }
        
        if(preArgumVentaFrom.getDescripcion()!= null){
            query.append(" and i18n.VAL_I18N like '" + preArgumVentaFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(preArgumVentaFrom.getId()!= null){
            query.append(" and OID_ARGU_VENT = " + preArgumVentaFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreArgumVentaData preArgumVentaData = null;
        PreTipoEstraData preTipoEstraData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                preArgumVentaData = new PreArgumVentaData();
                
                preArgumVentaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ARGU_VENT")).toString()));
                preArgumVentaData.setCodArguVent(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_ARGU_VENT")).toString()));
                preArgumVentaData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                preArgumVentaData.setValFactRepe(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_FACT_REPE")).toString()));
                
                preTipoEstraData = new PreTipoEstraData();          
                preTipoEstraData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIES_OID_TIPO_ESTR")).toString()));
                preTipoEstraData.setDesTipoEstr((String)rs.getValueAt(i,"DES_TIPO_ESTR"));
                preArgumVentaData.setTiesOidTipoEstr(preTipoEstraData);
                
                result.add(preArgumVentaData);
                
            } else {
               break;
            }
        }
        
                
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOArgumentoVenta.query(PreArgumVentaData preArgumVentaFrom, PreArgumVentaData preArgumVentaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
}