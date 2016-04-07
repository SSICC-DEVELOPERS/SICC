package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeMagniData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Vector;

public class DAOMagni {
    public DAOMagni() {
    }
    public Vector query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, HashMap userProperties) throws MareException
       {
           UtilidadesLog.info("DAOTipoProbl.query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties): Entrada");
           RecordSet rs = new RecordSet();
           StringBuffer query = new StringBuffer();
           BelcorpService bs;
           
           UtilidadesLog.debug("maeTipoProblFrom: " + maeMagniFrom.getDescripcion());
           UtilidadesLog.debug("1");

           try {
             bs = BelcorpService.getInstance();
           } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           }
           
           Property idioma = (Property)userProperties.get("Idioma");
           Long pais   = (Long)userProperties.get("loidPais");
           UtilidadesLog.debug("2");
           query.append("SELECT MM.OID_MAGN, MM.COD_MAGN, i18n.VAL_I18N ");
           query.append("FROM MAE_MAGNI MM, v_gen_i18n_sicc i18n ");
           query.append("WHERE MM.OID_MAGN = i18n.val_oid ");
           query.append("AND i18n.ATTR_ENTI = 'MAE_MAGNI' ");
           query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
           query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
           
           UtilidadesLog.debug("3");

           if (maeMagniFrom.getId()!=null)
               query.append(" AND MM.OID_MAGN = " + maeMagniFrom.getId().longValue());
           UtilidadesLog.debug("4");
           if (maeMagniFrom.getCodMagn()!=null)
               query.append(" AND MM.COD_MAGN = '" + maeMagniFrom.getCodMagn().trim() + "'");

           UtilidadesLog.debug("8");

           try {
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }        
           UtilidadesLog.debug("9");    
           int cant = rs.getRowCount();
           Vector result = new Vector();
           
           MaeMagniData maeMagniData = null;
           for(int i=0; i < cant; i++){
               maeMagniData = new MaeMagniData();
               
               if (rs.getValueAt(i,"OID_MAGN")!=null)
                   maeMagniData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MAGN")).toString()));
               
               if (rs.getValueAt(i,"COD_MAGN")!=null)
                   maeMagniData.setCodMagn(rs.getValueAt(i,"COD_MAGN").toString());
               
               if (rs.getValueAt(i,"VAL_I18N")!=null)
                   maeMagniData.setDescripcion(rs.getValueAt(i,"VAL_I18N").toString());
               
               result.add(maeMagniData);
           }
           UtilidadesLog.debug("result: " + result);
           UtilidadesLog.info("DAOTipoProbl.query(MaeTipoProblData maeTipoProblFrom, MaeTipoProblData maeTipoProblTo, HashMap userProperties): Salida");
           return result;
       }
      
}
