package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class DAOParametrizacionMAV {
    public DAOParametrizacionMAV() {}

    Long obtenerEstrategiaParametrizacionMAVPais(Long pais)
        throws Exception {
        UtilidadesLog.info("DAOParametrizacionMAV.obtenerEstrategiaParametrizacionMAVPais(Long pais):Entrada");
        try {
            RecordSet rs = new RecordSet();

            BelcorpService belcorpService = BelcorpService.getInstance();
            Long resu = null;

            StringBuffer query = new StringBuffer();

            query.append("Select COES_OID_ESTR ");
            query.append("from MAV_PARAM ");
            query.append("where PAIS_OID_PAIS = '" + pais + "'");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            if(rs.getRowCount() == 1)
                resu = new Long(((BigDecimal)rs.getValueAt(0, "COES_OID_ESTR")).longValue());

            UtilidadesLog.info("DAOParametrizacionMAV.obtenerEstrategiaParametrizacionMAVPais(Long pais):Salida");
            return resu;
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception exception) {
            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
    public Map obtenerParametrizacionMAVPais(Long pais) throws Exception {
        HashMap resu = new HashMap();
        
        UtilidadesLog.info("DAOParametrizacionMAV.obtenerParametrizacionMAVPais(Long pais):Entrada");
        try {
            RecordSet rs = new RecordSet();

            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append("Select COES_OID_ESTR, OCAT_OID_CATA, CNDP_OID_COND_PROM ");
            query.append("from MAV_PARAM ");
            query.append("where PAIS_OID_PAIS = '" + pais + "'");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            if(rs.getRowCount() == 1) {
                resu.put("oidEstrategia", new Long(((BigDecimal)rs.getValueAt(0, "COES_OID_ESTR")).longValue()));
                
                if(rs.getValueAt(0, "OCAT_OID_CATA")!=null) 
                    resu.put("oidCatalogo", new Long(((BigDecimal)rs.getValueAt(0, "OCAT_OID_CATA")).longValue()));

                if(rs.getValueAt(0, "CNDP_OID_COND_PROM")!=null) 
                    resu.put("oidCondicionPromocion", new Long(((BigDecimal)rs.getValueAt(0, "CNDP_OID_COND_PROM")).longValue()));
            }    

            UtilidadesLog.info("DAOParametrizacionMAV.obtenerParametrizacionMAVPais(Long pais):Salida");
            return resu;
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception exception) {
            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
}