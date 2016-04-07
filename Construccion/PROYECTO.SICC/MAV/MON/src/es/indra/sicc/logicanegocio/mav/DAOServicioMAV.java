package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;


public class DAOServicioMAV {
    public DAOServicioMAV() {}

    public DTOSalida obtenerTiposDespacho() throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtenerTiposDespacho(void):Entrada");
        try {
        
            UtilidadesLog.debug("Entro en DAO.obtenerTiposDespacho");

            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append("Select tipoDespa.OID_TIPO_DESP, tipoDespa.DES_TIPO_DESP ");
            query.append("from MAV_TIPO_DESPA tipoDespa ");
            query.append("ORDER BY tipodespa.des_tipo_desp ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtenerTiposDespacho(void):Salida");
            return dtos;
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

    public DTOSalida obtenerEstadosMAV(DTOBelcorp dto) throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtenerEstadosMAV(DTOBelcorp dto):Entrada");
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            //               query.append("Select * ");
            //               query.append("from MAV_ESTAD_MAV mem ");
            //               query.append("where mem.PAIS_OID_PAIS = '" + dto.getOidPais() + "'");*/
            // by SSantana, 14/06/04				
            query.append(" SELECT   mem.oid_esta_mav, i18n.val_i18n ");
            query.append(" FROM mav_estad_mav mem, v_gen_i18n_sicc i18n ");
            query.append(" WHERE mem.pais_oid_pais = " + dto.getOidPais() + " ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + dto.getOidIdioma() + " ");
            query.append(" AND i18n.attr_enti = 'MAV_ESTAD_MAV' ");
            query.append(" AND i18n.val_oid = mem.oid_esta_mav ");
            query.append(" ORDER BY i18n.val_i18n ASC ");

            // Fin Cambio 
            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            //UtilidadesLog.debug("Resultado: " + rs.toString() );
            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtenerEstadosMAV(DTOBelcorp dto):Salida");
            return dtos;
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

    public DTOSalida obtenerTiposCondicionPago() throws Exception {
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append("Select * ");
            query.append("from MAV_TIPO_CONDI_PAGO");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);

            return dtos;
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

    public DTOSalida obtenerCriteriosAsignacion() throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtenerCriteriosAsignacion(void):Entrada");
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append("Select crite.OID_CRIT_ASIG, crite.DES_CRIT_ASIG ");
            query.append(" from MAV_CRITE_ASIGN crite");
            query.append(" order by crite.DES_CRIT_ASIG");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtenerCriteriosAsignacion(void):Salida");
            return dtos;
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

    public DTOSalida obtenerSubtiposCliente(DTOBelcorp dto)
        throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtenerSubtiposCliente(DTOBelcorp dto):Entrada");
        try {
            DTOSalida dtos = new DTOSalida();
            DTOTipoSubtipo dtots = new DTOTipoSubtipo();

            MONConfiguracionClientes mcch = this.getMONConfiguracionClientesHome().create();
            dtots = mcch.obtenerTipoSubtipo(dto);

            dtos.setResultado(dtots.getSubtipos());

            UtilidadesLog.info("DAOServicioMAV.obtenerSubtiposCliente(DTOBelcorp dto):Salida");
            return dtos;
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public DTOSalida obtenerEnvioConSolicitud() throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtenerEnvioConSolicitud():Entrada");
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append("Select envioSolic.OID_ENVI_SOLI, envioSolic.DES_ENVI_SOLI ");
            query.append("  from mav_envio_solic envioSolic ");
            query.append("ORDER BY enviosolic.des_envi_soli ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtenerEnvioConSolicitud():Salida");
            return dtos;
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

    public DTOSalida obtenerFormaCobro(DTOOID dtoOid) throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtenerFormaCobro():Entrada");

        /*  
         *  Modificado por ssantana, 22/11/2005. Inc. BELC300021444.
         *   - Ahora Se recibe el Oid de la Actividad en DTOOID
         *     y se filtra por la actividad.
         */
        
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append(" SELECT mav_tipo_condi_pago.oid_tipo_cond_pago, ");
            query.append(" mav_tipo_condi_pago.des_tipo_cond_pago ");
            query.append(" FROM mav_activ, mav_tipo_condi_pago ");
            query.append(" WHERE mav_activ.oid_acti = " + dtoOid.getOid());
            query.append(" AND mav_activ.tcpa_oid_tipo_cond_pago = ");
            query.append("        mav_tipo_condi_pago.oid_tipo_cond_pago ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);
            UtilidadesLog.debug("query: " + query.toString());
            UtilidadesLog.debug("rs: " + rs);
            UtilidadesLog.info("DAOServicioMAV.obtenerFormaCobro():Salida");
            return dtos;
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

    public DTOSalida obtieneMensajesTipoDespacho(DTOOID dto)
        throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtieneMensajesTipoDespacho(DTOOID dto):Entrada");
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            ConstantesMAV cm = new ConstantesMAV();

            // Se agrega query para obtener tipo de despacho a partir de 
            // MAV_ACTIV_TIPO_DESPA - by ssantana
            RecordSet rsDespacho = new RecordSet();
            StringBuffer queryDespacho = new StringBuffer(" SELECT mav_activ_tipo_despa.tdch_oid_tipo_desp ");
            queryDespacho.append(" FROM mav_activ_tipo_despa ");
            queryDespacho.append(" WHERE mav_activ_tipo_despa.oid_acti_tipo_desp = " + dto.getOid().toString() );

            try {
              rsDespacho = belcorpService.dbService.executeStaticQuery(queryDespacho.toString() );
            } catch(Exception ex) {
                UtilidadesLog.debug("Error en obtenerTiposDespachoActividad");
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

              // Se asume que siempre habrá un valor para tipo de Despacho.
            Long tipoDespacho =  new Long( ((BigDecimal)rsDespacho.getValueAt(0,0)).longValue());
            UtilidadesLog.debug("Tipo de Despacho: " + tipoDespacho.toString() );

            rs = null;

            if(tipoDespacho.longValue() == cm.DESPACHO_PEDIDO) {
                query.append("SELECT msg_mensa.oid_mens, msg_mensa.cod_mens ");
                query.append("FROM msg_mensa ");

                // Cambio x inc. 6213
                query.append("WHERE (msg_mensa.cod_mens = 'MAV10') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV11') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV12') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV13') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV14') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV15') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV16') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV17') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV18') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV19') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV19') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV05') ");

                /*               query.append("WHERE (msg_mensa.cod_mens = 'MAV01.01') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.02') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.03') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.04') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.05') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.06') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.07') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.08') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.09') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV01.10')");*/
            }

            if((tipoDespacho.longValue() == cm.DESPACHO_PEDIDO_SERVICIO) || (tipoDespacho.longValue() == cm.DESPACHO_FIN_PERIODO)) {
                query.append("SELECT msg_mensa.oid_mens, msg_mensa.cod_mens ");
                query.append("FROM msg_mensa ");

                // Cambio x inc. 6213                 
                query.append("WHERE (msg_mensa.cod_mens = 'MAV21') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV22') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV23') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV24') ");
                query.append("OR (msg_mensa.cod_mens = 'MAV25')");

                /*               query.append("WHERE (msg_mensa.cod_mens = 'MAV02.01') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV02.02') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV02.03') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV02.04') ");
                                 query.append("OR (msg_mensa.cod_mens = 'MAV02.05')");*/
            }

            if(tipoDespacho.longValue() == cm.DESPACHO_INI_PERIODO) {
                query.append("SELECT msg_mensa.oid_mens, msg_mensa.cod_mens ");
                query.append("FROM msg_mensa ");

                // Cambio x inc. 6213                 
                query.append("WHERE (msg_mensa.cod_mens = 'MAV31') ");
                query.append(" OR (msg_mensa.cod_mens = 'MAV32')");
            }

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtieneMensajesTipoDespacho(DTOOID dto):Salida");
            return dtos;
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

    public DTOSalida obtieneSubcriteriosPorCriterio(DTOOID dto)
        throws Exception {
        UtilidadesLog.info("DAOServicioMAV.obtieneSubcriteriosPorCriterio(DTOOID dto):Entrada");
        try {
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append("Select * ");
            query.append("from MAV_SUBCR_ASIGN ");
            query.append("where CRAS_OID_CRIT_ASIG = " + dto.getOid());
            
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010
            query.append("  AND IND_ACTI = 1 ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtieneSubcriteriosPorCriterio(DTOOID dto):Salida");
            return dtos;
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

    private MONConfiguracionClientesHome getMONConfiguracionClientesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONConfiguracionClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConfiguracionClientes"),
            MONConfiguracionClientesHome.class);
    }

    public DTOSalida obtieneEstadosEnvio(DTOBelcorp dto) throws MareException {
    
        UtilidadesLog.info("DAOServicioMAV.obtieneEstadosEnvio(DTOBelcorp dto):Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer sql = new StringBuffer(" SELECT estado.OID_ESTA_ENVI, estado.DES_ESTA_ENVI ");
        sql.append(" FROM MAV_ESTAD_ENVIO estado ORDER BY estado.DES_ESTA_ENVI ASC");

        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();

        try {
            r = bs.dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtieneEstadosEnvio");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(r);
        UtilidadesLog.debug("DTOSalida: " + dtoSalida);
        UtilidadesLog.info("DAOServicioMAV.obtieneEstadosEnvio(DTOBelcorp dto):Salida");
        return dtoSalida;
    }

    public DTOSalida obtieneTiposEstadoProceso(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("DAOServicioMAV.obtieneTiposEstadoProceso(DTOBelcorp dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        
        StringBuffer sql = new StringBuffer(" SELECT m.OID_TIPO_ESTA_PROC, m.DES_TIPO_ESTA_PROC ");
        sql.append(" FROM MAV_TIPO_ESTAD_PROCE m ORDER BY m.DES_TIPO_ESTA_PROC ASC");

        RecordSet r = null;

        BelcorpService bs = BelcorpService.getInstance();

        try {
            r = bs.dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtieneTiposEstadoProceso");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(r);
        UtilidadesLog.debug("dtoSalida: " + dtoSalida);
        UtilidadesLog.info("DAOServicioMAV.obtieneTiposEstadoProceso(DTOBelcorp dto):Salida");
        return dtoSalida;
    }

    /**
         * @Autor : Hugo A. Mansi
         * @Creado: 30/09/2004
         * @qModificado: --
         * @Recibe: DTOOID con oid de actividad
         * @Retorna: DTOSalida con recordset
         * @DMCO: Tomado de la Incidencia 8054
         *
         */
    public DTOSalida obtenerTiposDespachoActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("DAOServicioMAV.obtenerTiposDespachoActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = BelcorpService.getInstance();

        // Modificado por ssantana, inc. 11073, 9/12/2004
        // se agrega Envio Con Solicitud y Descripción respectiva.
        query.append(" SELECT m.oid_acti_tipo_desp, mdespa.des_tipo_desp, ");
        query.append(" m.ENVS_OID_ENVI_SOLI, menvio.DES_ENVI_SOLI ");
        query.append(" FROM mav_activ_tipo_despa m, mav_tipo_despa mdespa, mav_envio_solic menvio ");
        query.append(" WHERE m.tdch_oid_tipo_desp = mdespa.oid_tipo_desp ");
        query.append(" and m.ENVS_OID_ENVI_SOLI = menvio.OID_ENVI_SOLI(+) ");
        query.append(" AND m.acti_oid_acti = " + dto.getOid().toString() );
        query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rs);
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtenerTiposDespachoActividad");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOServicioMAV.obtenerTiposDespachoActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

    /**
     * @Autor : Hugo A. Mansi
     * @Creado: 30/09/2004
     * @Modificado: --
     * @Recibe: DTOOID con oid de actividad
     * @Retorna: DTOSalida con recordset
     * @DMCO: Tomado de la Incidencia 8054
     *
     */
    public DTOSalida obtenerEstadosMAVActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("DAOServicioMAV.obtenerEstadosMAVActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = BelcorpService.getInstance();

        //Numero de atributo a usar en la consulta para la internacionalización
        Integer numAtri = new Integer(1);

        query.append(" 	SELECT a.oid_esta_acti, vgen.val_i18n	 ");
        query.append(" 	FROM mav_activ_estad a,	 ");
        query.append(" 	v_gen_i18n_sicc vgen,	 ");
        query.append(" 	mav_estad_mav c	 ");
        query.append(" 	WHERE  vgen.attr_enti = 'MAV_ESTAD_MAV'	 ");
        query.append(" 	AND vgen.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" 	AND vgen.attr_num_atri = " + numAtri);
        query.append(" 	AND vgen.val_oid = c.oid_esta_mav	 ");
        query.append(" 	and a.EMAV_OID_ESTA_MAV = c.OID_ESTA_MAV	 ");
        query.append(" 	and a.ACTI_OID_ACTI =  " + dto.getOid());
        query.append(" 	order by 2	 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rs);
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtenerEstadosMAVActividad");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOServicioMAV.obtenerEstadosMAVActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

    /**
    * @Autor : Hugo A. Mansi
    * @Creado: 30/09/2004
    * @qModificado: Ssantana, 17/12/2004, inc. 11463
    * @Recibe: DTOOID con oid de actividad
    * @Retorna: DTOSalida con recordset
    * @DMCO: Tomado de la Incidencia 8054
    *
    */
    public DTOSalida obtenerTiposOfertaActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("DAOServicioMAV.obtenerTiposOfertaActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = BelcorpService.getInstance();

        //Numero de atributo a usar en la consulta para la internacionalización
        //Integer numAtri = new Integer(1);

        /*query.append(" 	select a.OID_TIPO_OFER_ACTI, vgen.VAL_I18N 	 ");
        query.append(" 	from MAV_ACTIV_TIPO_OFERT a, 	 ");
        query.append(" 	v_gen_i18n_sicc vgen,	 ");
        query.append(" 	pre_tipo_ofert b	 ");
        query.append(" 	where vgen.ATTR_ENTI = 'PRE_TIPO_OFERT'	 ");
        query.append(" 	and   vgen.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" 	and   vgen.ATTR_NUM_ATRI = " + numAtri);
        query.append(" 	and   vgen.VAL_OID = b.OID_TIPO_OFER	 ");
        query.append(" 	and   a.TOFE_OID_TIPO_OFER = b.OID_TIPO_OFER	 ");
        query.append(" 	and   a.ACTI_OID_ACTI = " + dto.getOid());
        query.append(" 	order by 2	 ");*/

        // Modific. x ssantana, 17/12/2004
        // por incidencia 11463
        query.append(" SELECT p.OID_TIPO_OFER, v1.VAL_I18N ");
        query.append(" FROM pre_tipo_ofert p, mav_activ_tipo_ofert activ, v_gen_i18n_sicc v1 ");
        query.append(" WHERE activ.tofe_oid_tipo_ofer = p.oid_tipo_ofer ");
        query.append(" and p.OID_TIPO_OFER = v1.VAL_OID ");
        query.append(" and v1.ATTR_NUM_ATRI = 1 ");
        query.append(" and v1.IDIO_OID_IDIO = " + dto.getOidIdioma().toString() );
        query.append(" and v1.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
        query.append(" and activ.ACTI_OID_ACTI = " + dto.getOid().toString());
        query.append(" order by 2 ");
        // Fin Modific. x ssantana

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rs);
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtenerTiposOfertaActividad");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOServicioMAV.obtenerTiposOfertaActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

    /**
    * @Autor : Hugo A. Mansi
    * @Creado: 30/09/2004
    * @qModificado: Ssantana, inc. 11463
    * @Recibe: DTOOID con oid de actividad
    * @Retorna: DTOSalida con recordset
    * @DMCO: Tomado de la Incidencia 8054
    *
    */
    public DTOSalida obtenerCiclosVidaActividad(DTOOID dto)
        throws MareException 
    {
        UtilidadesLog.info("DAOServicioMAV.obtenerCiclosVidaActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = BelcorpService.getInstance();

        //Numero de atributo a usar en la consulta para la internacionalización
        Integer numAtri = new Integer(1);

   /*     query.append(" 	select a.OID_ACTI_CICL_VIDA, vgen.VAL_I18N 	 ");
        query.append(" 	from MAV_ACTIV_CICLO_VIDA a, 	 ");
        query.append(" 	v_gen_i18n_sicc vgen,	 ");
        query.append(" 	PRE_CICLO_VIDA b	 ");
        query.append(" 	where vgen.ATTR_ENTI = 'PRE_CICLO_VIDA'	 ");
        query.append(" 	and vgen.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" 	and vgen.ATTR_NUM_ATRI = " + numAtri);
        query.append(" 	and vgen.VAL_OID = b.OID_CICL_VIDA ");
        query.append(" 	and a.CIVI_OID_CICL_VIDA = b.OID_CICL_VIDA	 ");
        query.append(" 	and a.ACTI_OID_ACTI = " + dto.getOid());
        query.append(" 	order by 2	 ");*/

        // Modific. x ssantana
        // por incidencia 11463

        query.append(" select ciclo.OID_CICL_VIDA, v1.VAL_I18N from pre_ciclo_vida ciclo, ");
        query.append(" mav_activ_ciclo_vida aciclo, v_gen_i18n_sicc v1 ");
        query.append(" where aciclo.CIVI_OID_CICL_VIDA = ciclo.OID_CICL_VIDA ");
        query.append(" and aciclo.ACTI_OID_ACTI = " + dto.getOid() );
        query.append(" and ciclo.OID_CICL_VIDA = v1.VAL_OID ");
        query.append(" and v1.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
        query.append(" and v1.ATTR_NUM_ATRI = 1 ");
        query.append(" and v1.IDIO_OID_IDIO = " + dto.getOidIdioma() );
        query.append(" order by 2 ");
       // Fin Modific. x ssantana

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rs);
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtenerTiposOfertaActividad");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOServicioMAV.obtenerCiclosVidaActividad(DTOOID dto):Salida");
        return dtoSalida;
    }
    
    
  /**
   * @author: ssantana, 23/11/2005, inc. 21444
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOOID dtoOid
   */
    public DTOSalida obtieneFormasPagoActividad(DTOOID dtoOid) throws MareException {
      UtilidadesLog.info("DAOServicioMAV.obtieneFormaPagoActividad(DTOOID dtoOid): Entrada");
      DTOSalida dtoSalida = new DTOSalida();
      
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer("");
        sqlQuery.append(" SELECT bel_forma_pago.oid_form_pago, v_gen_i18n_sicc.val_i18n ");
        sqlQuery.append(" FROM mav_activ, bel_forma_pago, v_gen_i18n_sicc ");
        sqlQuery.append(" WHERE mav_activ.oid_acti = " + dtoOid.getOid() );
        sqlQuery.append(" AND mav_activ.fopa_oid_form_pago = bel_forma_pago.oid_form_pago ");
        sqlQuery.append(" AND bel_forma_pago.oid_form_pago = v_gen_i18n_sicc.val_oid ");
        sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dtoOid.getOidIdioma());
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'BEL_FORMA_PAGO' ");
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        
        UtilidadesLog.debug("sqlQuery: " + sqlQuery.toString());
        
        r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
        UtilidadesLog.debug("r: " + r);
        
        dtoSalida.setResultado(r);
        
      } catch (Exception ex) {
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         int nCodigo = UtilidadesError.armarCodigoError(sCodigoError);         
         UtilidadesLog.debug(ex);
         throw new MareException(ex, 
                                 nCodigo);
      }
      
      UtilidadesLog.info("DAOServicioMAV.obtieneFormaPagoActividad(DTOOID dtoOid): Salida");     
      return dtoSalida;
      
    }
    

  /**
   * @author: ssantana, 27/12/2005, inc. 
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet 
   * @param Long oidPeriodoPivot
   */
    public RecordSet obtenerPeriodosRangoAnual(Long oidPeriodoPivot, Long oidMarca,
                                               Long oidCanal, Long oidPais) 
            throws MareException {
            
      UtilidadesLog.info("DAOServicioMAV.obtenerPeriodosRangoAnual(Long " +
                         "oidPeriodoPivot, Long oidMarca, Long oidCanal, " +
                         "Long oidPais):Entrada");
      
      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = new RecordSet();
      
      StringBuffer sqlQuery = new StringBuffer("");
      
      sqlQuery.append(" SELECT cra_perio.oid_peri, cra_perio.val_nomb_peri ");
      sqlQuery.append(" FROM cra_perio ");
      sqlQuery.append(" WHERE cra_perio.fec_inic >= ");
      sqlQuery.append("                     (SELECT cra_perio.fec_inic - 365 ");
      sqlQuery.append(" FROM cra_perio ");
      sqlQuery.append(" WHERE cra_perio.oid_peri = " + oidPeriodoPivot + ") ");
      sqlQuery.append(" AND cra_perio.fec_inic <= ");
      sqlQuery.append("                     (SELECT cra_perio.fec_fina + 365 ");
      sqlQuery.append(" FROM cra_perio ");
      sqlQuery.append(" WHERE cra_perio.oid_peri = " + oidPeriodoPivot + ") ");
      sqlQuery.append(" AND cra_perio.marc_oid_marc = " + oidMarca);
      sqlQuery.append(" AND cra_perio.cana_oid_cana = " + oidCanal);
      sqlQuery.append(" AND cra_perio.pais_oid_pais = " + oidPais);
      sqlQuery.append(" ORDER BY cra_perio.val_nomb_peri ");
      
      
      try {
          UtilidadesLog.debug("sqlQuery.toString(): "+ sqlQuery.toString());
          r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          int nCodigo = UtilidadesError.armarCodigoError(sCodigoError);         
          throw new MareException(ex, 
                                  nCodigo);
      }
      
      UtilidadesLog.debug("r: " + r);
      //UtilidadesLog.info("r: " + r);
      UtilidadesLog.info("DAOServicioMAV.obtenerPeriodosRangoAnual(Long " +
                         "oidPeriodoPivot, Long oidMarca, Long oidCanal, " +
                         "Long oidPais):Salida");
      return r;
    }
    
  /**
   * 19-06-2007   agregado por Sapaza, incidencia SiCC-20070288. Obtiene los tipo de despacho MAV
   *              Inicio de Periodo y Fin de Periodo
   * @throws java.lang.Exception
   * @return 
   */
    public DTOSalida obtenerTiposDespachoIniFinPeriodo() throws MareException {
        UtilidadesLog.info("DAOServicioMAV.obtenerTiposDespachoIniFinPeriodo(void):Entrada");
        try {
        
            UtilidadesLog.debug("Entro en DAO.obtenerTiposDespachoIniFinPeriodo");

            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            BelcorpService belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append("Select tipoDespa.OID_TIPO_DESP, tipoDespa.DES_TIPO_DESP ");
            query.append("from MAV_TIPO_DESPA tipoDespa ");
            query.append("WHERE oid_tipo_desp in (" + ConstantesMAV.DESPACHO_INI_PERIODO + "," + ConstantesMAV.DESPACHO_FIN_PERIODO + ") ");
            query.append("ORDER BY tipodespa.des_tipo_desp ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            dtos.setResultado(rs);
            UtilidadesLog.info("DAOServicioMAV.obtenerTiposDespachoIniFinPeriodo(void):Salida");
            return dtos;
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