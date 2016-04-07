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
 * @autor: Damasia Maneiro
 * 
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

import es.indra.sicc.dtos.inc.DTOAnticipo;
import es.indra.sicc.dtos.inc.DTOClienteAnticipo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;


public class DAOGanadora {
    public DAOGanadora() {
    }

    /**
    * Fecha de Creacion: 04/05/2005
    * Autor: Damasia Maneiro
    * Descripcion: Obtiene los OIDs de la entidad Ganadoras a reversar.
    *
    */
    public DTOOIDs obtenerGanadoras(Long oidPeriodo, Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOGanadora.obtenerGanadoras(Long oidPeriodo, Long"
            +"oidCliente):Entrada");

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOOIDs dtoOIDs = new DTOOIDs();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_GANA");
            query.append(" FROM INC_GANAD");
            query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
            query.append(" AND PERD_OID_PERI = " + oidPeriodo);

            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Long[] oids = new Long[rs.getRowCount()];

        if (rs.esVacio()) {
            dtoOIDs.setOids(oids);
        } else {
            for (int fila = 0; rs.existeFila(fila); fila++) {
                oids[fila] = new Long(((BigDecimal) rs.getValueAt(fila,
                            "OID_GANA")).longValue());
            }
            dtoOIDs.setOids(oids);
        }

        UtilidadesLog.info("DAOGanadora.obtenerGanadoras(Long oidPeriodo,"
            +"Long oidCliente):Salida");

        return dtoOIDs;
    }

    /**
    * Fecha de Creacion: 30/05/2005
    * Autor: Damasia Maneiro
    * Descripcion: Recupera los premios para un cliente y concurso que se 
    * corresponden con Anticipos.
    *
    */
    public DTOAnticipo[] obtenerPremiosAnticipo(Long oidCliente,
        Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOGanadora.obtenerPremiosAnticipo(Long oidCliente"
            +", Long oidConcurso):Entrada");

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOAnticipo dtoAnticipo; //Cleal 06/09/2005

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(
                " SELECT OID_GANA, NUM_PREM, NUM_UNID, FPAG_OID_FORM_PAGO");
            query.append(" FROM INC_GANAD GAN, INC_TIPO_PREMI TPR, ");
            query.append(" INC_PARAM_NIVEL_PREMI PNP, ");
            query.append(" INC_PARAM_GENER_PREMI PGP, INC_PREMI_MONET PRM");
            query.append(
                " WHERE GAN.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM");
            query.append(
                " AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM");
            query.append(" AND PGP.COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append(" AND GAN.CLIE_OID_CLIE = " + oidCliente);
            query.append(" AND PNP.TPRE_OID_TIPO_PREM = " +
                ConstantesINC.TIPO_PREMIO_MONETARIO);
            query.append(" AND PRM.IND_DESC_PAGO_ANTI = 1");
            query.append(" AND PRM.IND_PAGO_PART = 1");
            query.append(" AND PRM.TCUM_OID_TIPO_CUMP = " +
                ConstantesINC.TIPO_CUMPLIMIENTO_TOTAL);

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOAnticipo[] dtosAnticipo = new DTOAnticipo[rs.getRowCount()];

        for (int fila = 0; rs.existeFila(fila); fila++) {
            dtoAnticipo = new DTOAnticipo(); //Cleal 06/09/2005
            dtoAnticipo.setOidGanadora(new Long(
                    ((BigDecimal) rs.getValueAt(fila, "OID_GANA"))
                        .longValue()));
            dtoAnticipo.setNumPremio(new Long(
                    ((BigDecimal) rs.getValueAt(fila, "NUM_PREM"))
                        .longValue()));
            dtoAnticipo.setUnidades((BigDecimal) 
                rs.getValueAt(fila, "NUM_UNID"));

            //Inc 19248
            dtoAnticipo.setOidNivelPremiacion(new Long(
                    ((BigDecimal) rs.getValueAt(fila, "OID_PARA_NIVE_PREM"))
                        .longValue()));
            dtoAnticipo.setOidParametrosGeneralesPremiacion(new Long(
                    ((BigDecimal) rs.getValueAt(fila, "OID_PARA_GENE_PREM"))
                        .longValue()));

            //Inc 17813
            //dtoAnticipo.setOidFormaPago(new Long(((BigDecimal) 
            //rs.getValueAt(fila, "FPAG_OID_FORM_PAGO")).longValue()));
            dtosAnticipo[fila] = dtoAnticipo;
        }

        UtilidadesLog.info("DAOGanadora.obtenerPremiosAnticipo(Long oidCliente"
            +", Long oidConcurso):Salida");

        return dtosAnticipo;
    }

    /**
    * Fecha de Creacion: 30/05/2005
    * Autor: Damasia Maneiro
    * Descripcion: Este metodo recupera los cliente y concursos en los que se
    * han entregado anticipos.
    *
    */
    public DTOClienteAnticipo[] obtenerClientesConAnticipos()
        throws MareException {
        UtilidadesLog.info("DAOGanadora.obtenerClientesConAnticipos()"
            +":Entrada");

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOClienteAnticipo dtoClienteAnticipo;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT CLIE_OID_CLIE, OID_PARA_GRAL");
            query.append(" FROM INC_CONCU_PARAM_GENER CPG, INC_GANAD GAN, ");
            query.append(" INC_TIPO_PREMI TPR, INC_PARAM_NIVEL_PREMI PNP, ");
            query.append(" INC_PREMI_MONET PRM");
            query.append(" WHERE CPG.IND_ACTI = 1");
            query.append(
                " AND GAN.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM");
            query.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = ");
            query.append(" CPG.OID_PARA_GRAL");
            query.append(" AND PNP.TPRE_OID_TIPO_PREM = TPR.OID_TIPO_PREM");
            query.append(" AND PNP.TPRE_OID_TIPO_PREM = " +
                ConstantesINC.TIPO_PREMIO_MONETARIO);
            query.append(" AND PRM.IND_DESC_PAGO_ANTI = 1");
            query.append(" AND PRM.IND_PAGO_PART = 1");
            query.append(" AND PRM.TCUM_OID_TIPO_CUMP = " +
                ConstantesINC.TIPO_CUMPLIMIENTO_TOTAL);
            query.append(" ORDER BY CPG.OID_PARA_GRAL");

            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOClienteAnticipo[] clientesAnticipo = new DTOClienteAnticipo[rs
            .getRowCount()];

        for (int fila = 0; rs.existeFila(fila); fila++) {
            dtoClienteAnticipo = new DTOClienteAnticipo();
            dtoClienteAnticipo.setOidConcurso(new Long(
                    ((BigDecimal) rs.getValueAt(fila, "OID_PARA_GRAL"))
                        .longValue()));
            dtoClienteAnticipo.setOidCliente(new Long(
                    ((BigDecimal) rs.getValueAt(fila, "CLIE_OID_CLIE"))
                        .longValue()));

            clientesAnticipo[fila] = dtoClienteAnticipo;
        }

        UtilidadesLog.info("DAOGanadora.obtenerClientesConAnticipos():Salida");

        return clientesAnticipo;
    }
}
