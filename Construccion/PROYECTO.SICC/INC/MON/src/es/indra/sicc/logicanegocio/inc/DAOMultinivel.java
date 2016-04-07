/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.getRecomendadosMultinivel
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
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTODatosMensajeMultinivel;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;

public class DAOMultinivel {
    public DAOMultinivel() {
    }

    /**
    * Fecha de Creacion: 01/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    public boolean recuperarRegistrosMovCCC(Concurso concurso, Long oidCliente)
            throws MareException {
        UtilidadesLog.info("DAOMultinivel.recuperarRegistrosMovCCC(Concurso "
            +"concurso, Long oidCliente):Entrada");
        
        UtilidadesLog.debug("Cliente: " + oidCliente);
        UtilidadesLog.debug("Concurso: " + concurso.getOidConcurso());
        UtilidadesLog.debug("ConsursoDiasDeGracia: " + concurso
            .getDiasGracia());

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
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            query.append(" SELECT *");
            query.append(" FROM CCC_MOVIM_CUENT_CORRI mcc, CRA_PERIO p1, ");
            query.append(" CRA_PERIO p2, CRA_PERIO p3");
            query.append(" WHERE mcc.FEC_VENC + " + 
                concurso.getDiasGracia() + " < SYSDATE");
            query.append(" AND p1.OID_PERI = mcc.PERD_OID_PERI");
            query.append(" AND p2.OID_PERI = " + concurso.getPeriodoDesde()
                .getOidPeriodo());
            query.append(" AND p3.OID_PERI = " + concurso.getPeriodoHasta()
                .getOidPeriodo());
            query.append(" AND p2.FEC_INIC <= p1.FEC_INIC");
            query.append(" AND p3.FEC_FINA >= p1.FEC_FINA");
            query.append(" AND mcc.CLIE_OID_CLIE = " + oidCliente);
            query.append(" AND ((mcc.FEC_VENC + " + concurso.getDiasGracia() + 
                " >= mcc.FEC_ULTI_MOVI AND mcc.IMP_PEND <> 0)");
            query.append(" OR (mcc.FEC_VENC + " + concurso.getDiasGracia() + 
                " < mcc.FEC_ULTI_MOVI AND (mcc.IMP_PEND IS NULL OR "); 
            query.append(" mcc.IMP_PEND = 0)))");

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("Salio DAOMultinivel.recuperarRegistrosMovCCC"
                +"y retorna: TRUE");
            UtilidadesLog.info("DAOMultinivel.recuperarRegistrosMovCCC(Concur"
                +"so concurso, Long oidCliente):Salida");
            return true;
        } else {
            UtilidadesLog.debug("Salio DAOMultinivel.recuperarRegistrosMovCCC"
                +"y retorna: FALSE");
            UtilidadesLog.info("DAOMultinivel.recuperarRegistrosMovCCC(Concur"
                +"so concurso, Long oidCliente):Salida");
            return false;
        }
    }

    /**
    * Fecha de Creacion: 01/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    public ArrayList getMadres(Concurso concurso, Periodo periodoGanador)
            throws MareException {
        UtilidadesLog.info("DAOMultinivel.getMadres(Concurso concurso, Periodo"
            +"periodoGanador):Entrada");
        UtilidadesLog.debug("Concurso: " + concurso.getOidConcurso());
        UtilidadesLog.debug("Periodo ganador: " + 
            periodoGanador.getOidPeriodo());

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOOIDs dtoOIDs = new DTOOIDs();
        Madre madre = null;
        Hijas hija = null;
        ArrayList madres = new ArrayList();
        ArrayList hijas = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            query.append(" SELECT RECTE.CLIE_OID_CLIE,  ");
            query.append(" RECTE.COPA_OID_PARA_GRAL ");
            query.append(" FROM INC_CLIEN_RECDO_MULTI RECDO,  ");
            query.append(" INC_CLIEN_RECTE_MULTI RECTE,  ");
            query.append(" INC_CONCU_PARAM_GENER CPG");
            query.append(" WHERE RECDO.CLR2_CLIE_OID_CLIE =  ");
            query.append(" RECTE.OID_CLIE_RECO_MULT");
            query.append(" AND RECTE.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL");
            query.append(" AND RECTE.COPA_OID_PARA_GRAL = " + 
                concurso.getOidConcurso());
            query.append(" AND CPG.PERD_OID_PERI_DESD = " + 
                periodoGanador.getOidPeriodo());

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("Nro de Madres: " + madres.size());
            UtilidadesLog.info("DAOMultinivel.getMadres(Concurso concurso,"
                +"Periodo periodoGanador):Salida");

            return madres; //Cleal 5/8/2005
        } else {
            for (int recte = 0; rs.existeFila(recte); recte++) {
                madre = new Madre();
                //oid del recomendado
                Long oidCliente = Long.valueOf(((BigDecimal) 
                    rs.getValueAt(recte, "CLIE_OID_CLIE")).toString()); 
                Long oidConcurso = Long.valueOf(((BigDecimal) 
                    rs.getValueAt(recte, "COPA_OID_PARA_GRAL")).toString());

                // Instanciamos un objeto Madre con los recomendantes de la 
                //consulta 
                madre.setOidCliente(oidCliente);
                madre.setOidConcurso(oidConcurso);

                try {
                    //obtengo los recomendados (Hijas) pertenecientes a un 
                    //recomendante (Madre) 
                    query = new StringBuffer(); //Cleal 5/8/2005
                    query.append(" SELECT DISTINCT CLIE_OID_CLIE");
                    query.append(" FROM INC_CLIEN_RECDO_MULTI RECDO");
                    query.append(" WHERE CLR2_CLIE_OID_CLIE = " + oidCliente);

                    rs = bs.dbService.executeStaticQuery(query.toString());
                    UtilidadesLog.debug(" rs: " + rs);
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError
                        .armarCodigoError(codigoError));
                }

                if (rs.esVacio()) {
                    UtilidadesLog.debug(" No hay hijas");
                    madre.setHijas(new ArrayList());
                } else {
                    //armo el ArrayList con los recomendados
                    for (int recdo = 0; rs.existeFila(recdo); recdo++) {
                        hija = new Hijas(); //Cleal 5/8/2005
                        hija.setCantidadHija(new Long(rs.getRowCount()));

                        //obtenemos los pedidos recomendados
                        hija.setPedidos(obtenerPedidosMultinivel(
                            periodoGanador, true));
                        hijas.add(hija);
                    }

                    madre.setHijas(hijas);
                }

                //obtenemos los pedidos recomendantes
                madre.setPedidos(obtenerPedidosMultinivel(
                    periodoGanador, false));
                madres.add(madre);
            }

            UtilidadesLog.debug("Nro de Madres: " + madres.size());
            UtilidadesLog.info("DAOMultinivel.getMadres(Concurso concurso, "
                +"Periodo periodoGanador):Salida");

            return madres;
        }
    }

    /**
    * Fecha de Creacion: 01/06/2005
    * Autor: Damasia Maneiro
    * Comentario: 
    * Accedo al a tabla clienteRecomentanteMultinivel filtrando por concurso y 
    * periodoGanador. 
    * Devolvemos un DTOOID con los oidClienteRecomendante 
    * @cambio incidencia  20802
    * @motivo retornamos los oidClienteRecomendante en ves del oidCliente
    * @autor gdmarzi
    */
    public DTOOIDs getRecomendantesMultinivel(Periodo periodo) 
        throws MareException {
        UtilidadesLog.info("DAOMultinivel.getRecomendantesMultinivel(Periodo"
            +"periodo):Entrada");
        UtilidadesLog.debug("Periodo ganador que le llaman: " + periodo
            .getOidPeriodo());

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
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        // 1.-Accedo al a tabla clienteRecomentanteMultinivel filtrando por 
        //concurso y periodoGanador.
        try {
            query.append(" SELECT A.OID_CLIE_RECO_MULT ");
            query.append(" FROM INC_CLIEN_RECTE_MULTI A, ");
            query.append(" INC_CLIEN_RECDO_MULTI B ");
            query.append(" WHERE A.OID_CLIE_RECO_MULT =  ");
            query.append(" B.CLR2_CLIE_OID_CLIE ");
            query.append(" AND B.PERD_OID_PERI = " + periodo.getOidPeriodo());

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        Long[] oidsCliente = new Long[rs.getRowCount()];

        if (rs.esVacio()) {
            dtoOIDs.setOids(oidsCliente);
        } else {
            oidsCliente = new Long[rs.getRowCount()];

            for (int recte = 0; rs.existeFila(recte); recte++) {
                //oid del recomendado
                oidsCliente[recte] = Long.valueOf(((BigDecimal) 
                    rs.getValueAt(recte, "OID_CLIE_RECO_MULT")).toString()); 
            }

            dtoOIDs.setOids(oidsCliente);
        }

        UtilidadesLog.debug("Oids recomendantes Multinivel: " + 
            dtoOIDs.getOids());
        UtilidadesLog.info("DAOMultinivel.getRecomendantesMultinivel(Periodo"
            +"periodo):Salida");

        return dtoOIDs;
    }


    /**
    * Fecha de Creacion: 03/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    public ArrayList getSolicitudesMultinivel(Periodo periodo, DTOOIDs dtoOIDs) 
        throws MareException {
        
        UtilidadesLog.info("DAOMultinivel.getSolicitudesMultinivel(Periodo"
            +"periodo, DTOOIDs dtoOIDs):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        Long[] oidsCliente = dtoOIDs.getOids();
        DTOSolicitudValidacion dtoSolicitudValidacion = null;
        ArrayList solicitudes = new ArrayList();

        for (int index = 0; oidsCliente.length > index; index++) {
            query.append(" SELECT OID_SOLI_CABE, ZZON_OID_ZONA, ");
            query.append(" CLIE_OID_CLIE, PAIS_OID_PAIS");
            query.append(" FROM PED_SOLIC_CABEC");
            query.append(" WHERE CLIE_OID_CLIE = " + oidsCliente[index]);
            query.append(" AND PERD_OID_PERI = " + periodo.getOidPeriodo());
            query.append(" AND IND_TS_NO_CONSO = 1 ");

            try {
                rs = (RecordSet) belcorpService.getInstance().dbService
                    .executeStaticQuery(query.toString());
                UtilidadesLog.debug(" rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }

            for (int fila = 0; rs.existeFila(fila); fila++) {
                dtoSolicitudValidacion = new DTOSolicitudValidacion();

                dtoSolicitudValidacion.setOidSolicitud(new Long(((BigDecimal) 
                    rs.getValueAt(fila, "OID_SOLI_CABE")).longValue()));
                dtoSolicitudValidacion.setZona(new Long(((BigDecimal) 
                    rs.getValueAt(fila, "ZZON_OID_ZONA")).longValue()));
                dtoSolicitudValidacion.setOidCliente(new Long(((BigDecimal)
                    rs.getValueAt(fila, "CLIE_OID_CLIE")).longValue()));
                dtoSolicitudValidacion.setOidPais(new Long(((BigDecimal) 
                    rs.getValueAt(fila, "PAIS_OID_PAIS")).longValue()));
                dtoSolicitudValidacion.setOidMarca(periodo.getOidMarca());
                dtoSolicitudValidacion.setOidCanal(periodo.getOidCanal());
                dtoSolicitudValidacion.setOidPeriodo(periodo.getOidPeriodo());
 
                solicitudes.add(dtoSolicitudValidacion);
            }
        }

        UtilidadesLog.info("DAOMultinivel.getSolicitudesMultinivel(Periodo "
            +"periodo, DTOOIDs dtoOIDs):Salida");

        return solicitudes;
    }


    /**
    * Fecha de Creacion: 01/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    public DTOOIDs getRecomendadosMultinivel(Long oidRecomendante, 
        Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOMultinivel.getRecomendadosMultinivel(Long "
            +"oidRecomendante, Long oidPeriodo):Entrada");
        UtilidadesLog.debug("oidRecomendante: " + oidRecomendante);

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
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            //jrivas 4/7/2005
            //Inc 16978
            //gdmarzi 30(08/2005
            //incidencia 
            query.append(" SELECT CLIE_OID_CLIE ");
            query.append(" FROM INC_CLIEN_RECDO_MULTI  ");
            query.append(" WHERE CLR2_CLIE_OID_CLIE =  " + oidRecomendante);
            query.append(" AND PERD_OID_PERI = " + oidPeriodo);

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        Long[] oids = new Long[rs.getRowCount()];

        if (rs.esVacio()) {
            dtoOIDs.setOids(oids);
        } else {
            for (int fila = 0; rs.existeFila(fila); fila++) {
                oids[fila] = new Long(((BigDecimal) 
                    rs.getValueAt(fila, "CLIE_OID_CLIE")).longValue());
            }
            dtoOIDs.setOids(oids);
        }
        UtilidadesLog.info("DAOMultinivel.getRecomendadosMultinivel(Long "
            +"oidRecomendante, Long oidPeriodo):Salida");
        return dtoOIDs;
    }


    /**
    * Fecha de Creacion: 01/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    private ArrayList obtenerPedidosMultinivel(Periodo periodoGanador, 
        boolean esRecdo) throws MareException {
        UtilidadesLog.info("DAOMultinivel.obtenerPedidosMultinivel(Periodo "
            +"periodoGanador, boolean esRecdo):Entrada");
        UtilidadesLog.debug("periodoGanador: " + periodoGanador.getOidPeriodo());
        UtilidadesLog.debug("esRecdo: " + esRecdo);

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        PedidoMultinivel pedidoMultinivel = null;
        ArrayList pedidosMultinivel = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            if (esRecdo) {
                query.append(" SELECT NUM_CANT, NUM_PUNT_EXIG");
                query.append(" FROM INC_PEDID_RECDA_MULTI, CRA_PERIO P1, ");
                query.append(" CRA_PERIO P2");
            } else {
                query.append(" SELECT VAL_CANT, VAL_PUNT_EXIG");
                query.append(" FROM INC_PEDID_RECTE_MULTI, CRA_PERIO P1, ");
                query.append(" CRA_PERIO P2");
            }

            query.append(" WHERE PERD_OID_PERI = P1.OID_PERI");
            query.append(" AND P2.OID_PERI = " + periodoGanador
                .getOidPeriodo());
            query.append(" AND P2.FEC_INIC <= P1.FEC_INIC");
            query.append(" AND P2.FEC_FINA >= P1.FEC_FINA");

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOMultinivel.obtenerPedidosMultinivel(Periodo"
                +"periodoGanador, boolean esRecdo):Salida");
            return null;
        } else {
            for (int fila = 0; rs.existeFila(fila); fila++) {
                pedidoMultinivel = new PedidoMultinivel();

                if (esRecdo) {
                    if (rs.getValueAt(fila, "NUM_CANT") != null) {
                        pedidoMultinivel.setCantidad(new Long(((BigDecimal) 
                            rs.getValueAt(fila, "NUM_CANT")).longValue()));
                    }

                    if (rs.getValueAt(fila, "NUM_PUNT_EXIG") != null) {
                        pedidoMultinivel.setNumPuntosExigidos(
                            new Long(((BigDecimal) rs.getValueAt(fila,
                                "NUM_PUNT_EXIG")).longValue()));
                    }
                } else {
                    if (rs.getValueAt(fila, "VAL_CANT") != null) {
                        pedidoMultinivel.setCantidad(new Long(((BigDecimal) 
                            rs.getValueAt(fila, "VAL_CANT")).longValue()));
                    }

                    if (rs.getValueAt(fila, "VAL_PUNT_EXIG") != null) {
                        pedidoMultinivel.setNumPuntosExigidos(
                            new Long(((BigDecimal) rs.getValueAt(fila, 
                                "VAL_PUNT_EXIG")).longValue()));
                    }
                }

                pedidosMultinivel.add(pedidoMultinivel);
            }

            UtilidadesLog.info("DAOMultinivel.obtenerPedidosMultinivel(Periodo"
                +"periodoGanador, boolean esRecdo):Salida");

            return pedidosMultinivel;
        }
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 21/06/2005
     * @Recibe: Long oidCliente, Concurso concurso
     * @Retorna: DTODatosMensajeMultinivel
     * @Descripción: recupera los datos del cliente, nombres, apellidos, etc.
     * para generar el mensaje.
     * @Referencia: BELC300018971
     */
    public DTODatosMensajeMultinivel recuperarDatosMensaje(Long oidCliente, 
        Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOMultinivel.recuperarDatosMensaje(Long "
            +"oidCliente, Concurso concurso):Entrada");
        UtilidadesLog.debug("entra al metodo DAOMultinivel.recuperarDatos"
            +"Mensaje con oidCliente:" + oidCliente + " concurso:" + concurso);

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        DTODatosMensajeMultinivel dtoS = new DTODatosMensajeMultinivel();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT cl.OID_CLIE, cl.val_nom1, cl.val_nom2, ");
        query.append(" cl.val_ape1, cl.val_ape2, cl.cod_clie, ");
        query.append(" SUM (ccp.num_punt) puntos ");
        query.append(" FROM inc_cuent_corri_punto ccp, mae_clien cl ");
        query.append(" WHERE cl.oid_clie = ccp.clie_oid_clie ");
        query.append(" AND ccp.copa_oid_para_gral = " + 
            concurso.getOidConcurso() + " ");
        query.append(" AND ccp.clie_oid_clie = " + oidCliente + " ");
        query.append(" GROUP BY cl.OID_CLIE, cl.val_nom1, cl.val_nom2, ");
        query.append(" cl.val_ape1, cl.val_ape2, cl.cod_clie ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug(" rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if ((rs != null) && (!rs.esVacio())) {
            dtoS.setOidCliente((rs.getValueAt(0, "OID_CLIE") != null) ?
                new Long(((BigDecimal) rs.getValueAt(0, "OID_CLIE"))
                    .longValue()) : null);
            dtoS.setNombre1((String) rs.getValueAt(0, "VAL_NOM1"));
            dtoS.setNombre2((String) rs.getValueAt(0, "VAL_NOM2"));
            dtoS.setApellido1((String) rs.getValueAt(0, "VAL_APE1"));
            dtoS.setApellido2((String) rs.getValueAt(0, "VAL_APE2"));
            dtoS.setCodCliente((String) rs.getValueAt(0, "COD_CLIE"));
            dtoS.setSaldoPuntos(new Long((rs.getValueAt(0, "PUNTOS") != null) 
                ? ((BigDecimal) rs.getValueAt(0, "PUNTOS")).longValue() : 0));
        }

        UtilidadesLog.debug("sale del metodo DAOMultinivel.recuperarDatosMensa"
            +"je con DTODatosMensajeMultinivel:" + dtoS);
        UtilidadesLog.info("DAOMultinivel.recuperarDatosMensaje(Long oidClient"
            +"e, Concurso concurso):Salida");
        return dtoS;
    }
}
