/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class MONMantenimientoEstrategiaBean implements SessionBean {

    private SessionContext ctx;

    public void ejbCreate() {  }
    public void ejbActivate() {  }
    public void ejbPassivate() {  }
    public void ejbRemove() {   }
    
    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida buscarEstrategias(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoEstrategiaBean.buscarEstrategias(DTOBelcorp dto): Entrada");
        
        BelcorpService belcorpService = null;
        DTOSalida dtos = new DTOSalida();
        RecordSet rs = new RecordSet();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer();

            query.append(" select e.OID_ESTR, i.VAL_I18N from pre_estra e, v_gen_i18n_sicc i");
            query.append(" where i.ATTR_ENTI = 'PRE_ESTRA'");
            query.append(" and i.VAL_OID = e.OID_ESTR");
            query.append(" and i.IDIO_OID_IDIO = '" + dto.getOidIdioma().toString() + "'");
            query.append(" and e.PAIS_OID_PAIS = '" + dto.getOidPais().toString() + "' ");
            query.append(" order by VAL_I18N");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            dtos.setResultado(rs);
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMantenimientoEstrategiaBean.buscarEstrategias(DTOBelcorp dto): Salida");
        return dtos;
    }

}
