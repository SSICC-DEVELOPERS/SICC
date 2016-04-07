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
 * @autor: Dante Castiglione
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005  
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOSolicitudConcursoPuntaje;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;

public class DAOSolicitudConcursoPuntaje {
    public ArrayList cargarPuntajes(long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudConcursoPuntaje.cargarPuntajes(long "
            +"oidSolicitud):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            query.append(" SELECT IND_ANUL, ");
            query.append(" FEC_DOCU, ");
            query.append(" NUM_PUNT, ");
            query.append(" OID_SOLI_CONC_PUNT, ");
            query.append(" COPA_OID_PARA_GRAL, ");
            query.append(" CLIE_OID_CLIE, ");
            query.append(" PERD_OID_PERI, ");
            query.append(" SOCA_OID_SOLI_CABE, ");
            query.append(" VAL_PUNT_BONI, ");
            query.append(" VAL_PUNT_FALT_NANU ");
            query.append(" FROM INC_SOLIC_CONCU_PUNTA ");
            query.append(" WHERE SOCA_OID_SOLI_CABE = ").append(oidSolicitud);
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("Resultado " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        ArrayList output = new ArrayList();

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            DTOSolicitudConcursoPuntaje dto = 
                new DTOSolicitudConcursoPuntaje();
            BigDecimal indAnul = (BigDecimal) respuesta
                .getValueAt(i, "IND_ANUL");

            if (indAnul == null) {
                dto.setAnulada(new Boolean(false));
            } else {
                if (indAnul.intValue() == 1) {
                    dto.setAnulada(new Boolean(true));
                } else {
                    dto.setAnulada(new Boolean(false));
                }
            }

            dto.setFechaDocumento((Date) respuesta.getValueAt(i, "FEC_DOCU"));
            dto.setNumeroPuntos(new Integer(((BigDecimal) respuesta
                .getValueAt(i, "NUM_PUNT")).intValue()));
            dto.setOid(new Long(((BigDecimal) respuesta
                .getValueAt(i, "OID_SOLI_CONC_PUNT")).longValue()));
            dto.setOidConcurso(new Long(((BigDecimal) respuesta
                .getValueAt(i, "COPA_OID_PARA_GRAL")).longValue()));
            dto.setOidConsultora(new Long(((BigDecimal) respuesta
                .getValueAt(i, "CLIE_OID_CLIE")).longValue()));
            dto.setOidPeriodo(new Long(((BigDecimal) respuesta
                .getValueAt(i, "PERD_OID_PERI")).longValue()));
            dto.setOidSolicitud(new Long(((BigDecimal) respuesta
                .getValueAt(i, "SOCA_OID_SOLI_CABE")).longValue()));
            dto.setPuntajeBonificacion(new Integer(((BigDecimal) respuesta
                .getValueAt(i, "VAL_PUNT_BONI")).intValue()));
            dto.setPuntajeFaltantesNoAnunciados(new Integer(((BigDecimal)
                respuesta.getValueAt(i, "VAL_PUNT_FALT_NANU")).intValue()));
            output.add(dto);
        }
        UtilidadesLog.info("DAOSolicitudConcursoPuntaje.cargarPuntajes(long "
            +"oidSolicitud):Salida");
        return output;
    }
}
