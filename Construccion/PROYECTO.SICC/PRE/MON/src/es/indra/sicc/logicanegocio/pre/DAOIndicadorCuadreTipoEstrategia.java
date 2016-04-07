package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreTipoEstraData;
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
import es.indra.belcorp.mso.PreIndicCuadrTipoEstraData;
import es.indra.belcorp.mso.PreIndicCuadrData;
import es.indra.mare.common.mgu.manager.Property;

public class DAOIndicadorCuadreTipoEstrategia 
{
    public DAOIndicadorCuadreTipoEstrategia()
    {
    }
    
    public Vector query(PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraFrom, PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOIndicadorCuadreTipoEstrategia.query(PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraFrom, PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_IND_CUAD_TIPO_ESTR, INDC_OID_INDI_CUAD, i18n.val_i18n, ");
        query.append(" TIES_OID_TIPO_ESTR, DES_TIPO_ESTR, IND_OFER_MONO_GRUP ");
        query.append(" FROM PRE_INDIC_CUADR_TIPO_ESTRA cu, PRE_TIPO_ESTRA ti, v_gen_i18n_sicc i18n ");
        query.append(" WHERE TIES_OID_TIPO_ESTR = OID_TIPO_ESTR ");
        query.append(" AND INDC_OID_INDI_CUAD = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'PRE_INDIC_CUADR' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      
        
        // Para la busqueda
        if(preIndicCuadrTipoEstraFrom.getTiesOidTipoEstr()!= null){
            query.append(" and TIES_OID_TIPO_ESTR = " + preIndicCuadrTipoEstraFrom.getTiesOidTipoEstr().getId());
        }        
        
        // Para el detalle
        if(preIndicCuadrTipoEstraFrom.getId()!= null){
            query.append(" and OID_IND_CUAD_TIPO_ESTR = " + preIndicCuadrTipoEstraFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraData = null;
        PreIndicCuadrData preIndicCuadrData = null;
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
                preIndicCuadrTipoEstraData = new PreIndicCuadrTipoEstraData();
                
                preIndicCuadrTipoEstraData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_IND_CUAD_TIPO_ESTR")).toString()));
                preIndicCuadrTipoEstraData.setIndOferMonoGrup((((BigDecimal)rs.getValueAt(i,"IND_OFER_MONO_GRUP")).equals(new BigDecimal("1"))?Boolean.TRUE:Boolean.FALSE));
                
                preIndicCuadrData = new PreIndicCuadrData();                
                preIndicCuadrData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"INDC_OID_INDI_CUAD")).toString()));
                preIndicCuadrData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                preIndicCuadrTipoEstraData.setIndcOidIndiCuad(preIndicCuadrData);
                
                preTipoEstraData = new PreTipoEstraData();                
                preTipoEstraData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIES_OID_TIPO_ESTR")).toString()));
                preTipoEstraData.setDesTipoEstr((String)rs.getValueAt(i,"DES_TIPO_ESTR"));
                preIndicCuadrTipoEstraData.setTiesOidTipoEstr(preTipoEstraData);
                
                result.add(preIndicCuadrTipoEstraData);
                
            } else {
               break;
            }
        }
                        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOIndicadorCuadreTipoEstrategia.query(PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraFrom, PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
}