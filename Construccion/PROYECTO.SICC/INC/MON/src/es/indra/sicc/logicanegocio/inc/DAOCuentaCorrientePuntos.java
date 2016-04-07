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
 *
 * @author: Dante Castiglione
 *  
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;


public class DAOCuentaCorrientePuntos {
    public DAOCuentaCorrientePuntos() {
    }

    /**
     * Obtiene los OIDs de la entidad CuentaCorrientePuntos a reversar
     *
     * @author Dante Castiglione
     */
    public DTOOIDs obtenerCuentasARevertir(
        DTOSolicitudValidacion solicitudValidacion) throws MareException {
        UtilidadesLog.info("DAOCuentaCorrientePuntos.obtenerCuentasARevertir("
            +"DTOSolicitudValidacion solicitudValidacion):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT DISTINCT ");
            query.append(" A.OID_CUEN_CORR_PUNT ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO A, ");
            query.append(" PED_SOLIC_CABEC B ");
            query.append(" WHERE A.CLIE_OID_CLIE    = " +
                solicitudValidacion.getOidCliente());
            query.append(" AND A.TMOV_OID_TIPO_MOVI = " +
                ConstantesINC.TIPO_MOVIMIENTO_CARGO);
            query.append(" AND A.PERD_OID_PERI      = " +
                solicitudValidacion.getOidPeriodo());
            query.append(" AND A.CLIE_OID_CLIE = B.CLIE_OID_CLIE ");
            query.append(" AND A.FEC_MOVI      = B.FEC_CRON      ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOOIDs dtoOids = new DTOOIDs();

        if (respuesta.esVacio()) {
            dtoOids.setOids(null);
        } else {
            Long[] ids = new Long[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                            "OID_CUEN_CORR_PUNT")).longValue());
            }

            dtoOids.setOids(ids);
        }

        UtilidadesLog.info("DAOCuentaCorrientePuntos.obtenerCuentasARevertir("
            +"DTOSolicitudValidacion solicitudValidacion):Salida");

        return dtoOids;
    }
}
