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
import es.indra.mare.common.mgu.manager.Property;
import es.indra.belcorp.mso.PreTipoOfertData;
import es.indra.belcorp.mso.SegCanalViewData;

public class DAOTipoOferta 
{
    public DAOTipoOferta()
    {
    }
    
    public Vector query(PreTipoOfertData preTipoOfertFrom, PreTipoOfertData preTipoOfertTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOTipoOferta.query(PreTipoOfertData preTipoOfertFrom, PreTipoOfertData preTipoOfertTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_TIPO_OFER, COD_TIPO_OFER, CANA_OID_CANA, i18n1.VAL_I18N DESC_CANAL, ");
        query.append(" i18n.val_i18n DESC_TIPOOFERTA, IND_COMI, IND_ESTA, IND_APOR_MONT_ESCA,  ");
        query.append(" IND_GRAT, IND_MONT_MINI, IND_PUNT, VAL_FORM_VENT ");
        query.append(" FROM PRE_TIPO_OFERT, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
        query.append(" WHERE OID_TIPO_OFER = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" AND CANA_OID_CANA = i18n1.val_oid ");
        query.append(" and i18n1.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" and i18n1.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());
      
        
        // Para la busqueda
        if(preTipoOfertFrom.getCanaOidCana()!= null){
            query.append(" and CANA_OID_CANA = " + preTipoOfertFrom.getCanaOidCana().getId());
        } 
        
        if(preTipoOfertFrom.getCodTipoOfer()!= null){
            query.append(" and COD_TIPO_OFER like '" + preTipoOfertFrom.getCodTipoOfer() + "' ");
        } 
        
        // Para el detalle
        if(preTipoOfertFrom.getId()!= null){
            query.append(" and OID_TIPO_OFER = " + preTipoOfertFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreTipoOfertData preTipoOfertData = null;
        SegCanalViewData segCanalViewData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                preTipoOfertData = new PreTipoOfertData();
                
                preTipoOfertData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_OFER")).toString()));
                preTipoOfertData.setCodTipoOfer((String)rs.getValueAt(i,"COD_TIPO_OFER"));  
                preTipoOfertData.setDescripcion((String)rs.getValueAt(i,"DESC_TIPOOFERTA"));  
                
                preTipoOfertData.setIndComi((((BigDecimal)rs.getValueAt(i,"IND_COMI")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                preTipoOfertData.setIndEsta((((BigDecimal)rs.getValueAt(i,"IND_ESTA")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                preTipoOfertData.setIndAporMontEsca((((BigDecimal)rs.getValueAt(i,"IND_APOR_MONT_ESCA")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                preTipoOfertData.setIndGrat((((BigDecimal)rs.getValueAt(i,"IND_GRAT")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                preTipoOfertData.setIndMontMini((((BigDecimal)rs.getValueAt(i,"IND_MONT_MINI")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                preTipoOfertData.setIndPunt((((BigDecimal)rs.getValueAt(i,"IND_PUNT")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                                
                segCanalViewData = new SegCanalViewData();                
                segCanalViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).toString()));
                segCanalViewData.setDescripcion((String)rs.getValueAt(i,"DESC_CANAL"));   
                preTipoOfertData.setCanaOidCana(segCanalViewData);
                
                result.add(preTipoOfertData);
                
            } else {
               break;
            }
        }
                        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoOferta.query(PreTipoOfertData preTipoOfertFrom, PreTipoOfertData preTipoOfertTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
}