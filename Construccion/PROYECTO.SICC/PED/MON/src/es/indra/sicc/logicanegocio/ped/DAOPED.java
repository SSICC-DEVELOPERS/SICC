package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.dtos.ped.DTOAtributoEspecial;
import es.indra.sicc.dtos.ped.DTOFlete;
import es.indra.sicc.dtos.ped.DTOMontoMinimo;
import es.indra.sicc.dtos.ped.DTOSecuenciaProcesos;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOP;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;
import es.indra.sicc.dtos.ped.DTOValoresPorDefecto;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOPEDBloqueosClientes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.dtos.ped.DTOCalcularTotales;

import java.sql.Date;
import java.text.DateFormat;

/*
 * rgiorgi - 25/8/2005: cambios por incidencia FAC-01.
 * */
public class DAOPED {
    private String user;

    public DAOPED() {
    }

    public DAOPED(String user) {
        this.user = user;
    }

    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();

            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }


    public DTOOID obtieneTipoDespachoCronogramaActivo(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTipoDespachoCronogramaActivo(DTOBelcorp dtoe): Entrada ");
      /*Documentation
        Obtiene el tipo de despacho que tenga el indicador de cronograma activo 

        SELECT OID_TIPO_DESP 
        FROM PED_TIPO_DESPA 
        WHERE 
        IND_CRON = 1 AND 
        PAIS_OID_PAIS = DTOE.pais 

        Crea un DTOOID con: 
        - oid = OID_TIPO_DESP del primer registro devuelto */
      StringBuffer query = new StringBuffer();
      RecordSet rs;       

      query.append(" SELECT OID_TIPO_DESP ");
      query.append(" FROM PED_TIPO_DESPA ");
      query.append(" WHERE IND_CRON = 1 AND ");
      query.append(" PAIS_OID_PAIS = " + dtoe.getOidPais().toString());

      try {        
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      if (rs.esVacio()) {
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      BigDecimal bdTipoDespacho = (BigDecimal)rs.getValueAt(0, "OID_TIPO_DESP");
      Long tipoDespacho = new Long(bdTipoDespacho.longValue());

      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(tipoDespacho);
      UtilidadesLog.info("DAOPED.obtieneTipoDespachoCronogramaActivo(DTOBelcorp dtoe): Salida ");
      return dtoOid;
    }

    public DTOSalida obtieneValoresPorDefecto(DTOValoresPorDefecto dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneValoresPorDefecto(DTOValoresPorDefecto dto): Entrada ");

        DTOSalida dtoSalida = new DTOSalida();

        StringBuffer query = new StringBuffer();
        RecordSet rs;       

        /* Modificado por ssantana, 17/07/2006, inc. 23562 
         * Se quita retorno de campo ped_valor_defec_tipo_solic.VAL_DEFE_OID */ 
        query.append(" SELECT v.oid_valo_defe_tipo_soli as OID, i1.VAL_I18N descTipoSolic, ");
        query.append(" a.des_atri, v.val_valo_defe, v.ind_obli, v.ind_modi ");

        query.append(" FROM ped_valor_defec_tipo_solic v, ped_atrib_espec a, ");
        query.append(" ped_tipo_solic_pais tp, ped_tipo_solic t, V_GEN_I18N_SICC i1 ");

        query.append(" WHERE ((a.oid_atri_espe = v.atre_oid_atri_espe) ");
        query.append(" AND (tp.oid_tipo_soli_pais = v.tspa_oid_tipo_soli_pais) ");
        query.append(" AND (t.oid_tipo_soli = tp.tsol_oid_tipo_soli) ");
        query.append(" AND (i1.VAL_OID = tp.tsol_oid_tipo_soli) ");
        query.append(" AND (i1.ATTR_ENTI = 'PED_TIPO_SOLIC') ");
        query.append(" AND (i1.ATTR_NUM_ATRI = 1) ");
        query.append(" AND (i1.IDIO_OID_IDIO = " + dto.getOidIdioma().toString() + ") ");

        if (dto.getOidTipoSolicitudPais() != null) {
            UtilidadesLog.debug("************ OidTipoSolicitud es distinto de null");
            query.append(" AND (tp.oid_tipo_soli_pais = " + dto.getOidTipoSolicitudPais().toString() + ") ");
        }

        query.append(" AND (tp.pais_oid_pais = " + dto.getOidPais().toString() + ")) ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            UtilidadesLog.debug("recordset: " + rs);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOPED.obtieneValoresPorDefecto(DTOValoresPorDefecto dto): Salida ");
        return dtoSalida;
    }

    public DTOSalida obtieneTiposSolicitudPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudPais(DTOBelcorp dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //@ssaavedr, 14/09/2005: se modifica consulta por inc.: BELC300020839, solo deben
            //rescatarse Tipo de Solicitud que tengan el Indicador Consolidado activo.
            //para lo cual se va a la tabla ped_tipo_solic
            
            //@ssaavedr, 28/09/2005, dado que este metodo es utilizado no solo desde fac para 
            //asignar formularios a tipos de solicitud, sino tambien desde ped para insertar
            //secuencias de procesos x ej., no se deben filtrar por consolidados, para todos esos
            //metodos (los que necesitan TODAS los tipos de solicitudes), se sigue utilizando 
            //este metodo -sin el filtro, se sca-, y para el de fac se crea uno nuevo:
            buf.append(" SELECT ");
            buf.append(" t.oid_tipo_soli_pais OID,  ");
            buf.append(" i1.VAL_I18N descTipoSolic  ");
            buf.append(" FROM  ");
            buf.append(" ped_tipo_solic_pais t, ");
            buf.append(" V_GEN_I18N_SICC i1, ");
            buf.append(" ped_tipo_solic ts");
            buf.append(" WHERE  ");
            buf.append(" i1.VAL_OID = t.tsol_oid_tipo_soli  ");
            buf.append(" AND t.tsol_oid_tipo_soli = ts.OID_TIPO_SOLI ");
            //@ssaavedr, 28/09/2005.. buf.append(" AND ts.IND_CONS = 1 ");            
            buf.append(" AND i1.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
            buf.append(" AND i1.ATTR_NUM_ATRI = 1 ");
            buf.append(" AND i1.IDIO_OID_IDIO = " + dto.getOidIdioma());
            buf.append(" AND t.pais_oid_pais = " + dto.getOidPais());
            buf.append(" ORDER BY descTipoSolic "); 

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudPais(DTOBelcorp dto): Salida ");
        return new DTOSalida(respuesta);
    }

    //@ssaavedr, 28/09/2005.. metodo creado para posibilitar traer solo tipos de sol.
    //consolidadas.......
    public DTOSalida obtieneTiposSolicitudPaisConsolidadas(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudPaisConsolidadas(DTOBelcorp dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT ");
            buf.append(" t.oid_tipo_soli_pais OID,  ");
            buf.append(" i1.VAL_I18N descTipoSolic  ");
            buf.append(" FROM  ");
            buf.append(" ped_tipo_solic_pais t, ");
            buf.append(" V_GEN_I18N_SICC i1, ");
            buf.append(" ped_tipo_solic ts");
            buf.append(" WHERE  ");
            buf.append(" i1.VAL_OID = t.tsol_oid_tipo_soli  ");
            buf.append(" AND t.tsol_oid_tipo_soli = ts.OID_TIPO_SOLI ");
            buf.append(" AND ts.IND_CONS = 1 ");            
            buf.append(" AND i1.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
            buf.append(" AND i1.ATTR_NUM_ATRI = 1 ");
            buf.append(" AND i1.IDIO_OID_IDIO = " + dto.getOidIdioma());
            buf.append(" AND t.pais_oid_pais = " + dto.getOidPais());
            buf.append(" ORDER BY descTipoSolic "); 

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudPaisConsolidadas(DTOBelcorp dto): Salida ");
        return new DTOSalida(respuesta);
    }

    public DTOSalida obtieneTiposSolicitudPais(DTOTipoSolicitudPais dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudPais(DTOTipoSolicitudPais dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT ");
            buf.append(" t.oid_tipo_soli_pais OID,  ");
            buf.append(" i1.VAL_I18N descTipoSolic,  ");
            buf.append(" t.num_soli_lote,  ");
            buf.append(" t.num_unid_alar,  ");
            buf.append(" t.ind_suje_flet,  ");
            buf.append(" t.ind_perm_unio,  ");
            buf.append(" i2.VAL_I18N descTipoCons,  ");
            buf.append(" tipoDocu.DES_TIPO_DOCU descTipoDocum,   ");
            buf.append(" t.ind_perm_reve,  ");
            buf.append(" t.ind_pedi_prue,  ");
            buf.append(" t.ind_comi,  ");
            buf.append(" t.ind_pedi_gt_zona,  ");
            buf.append(" t.ind_camb_vent_bel,  ");
            buf.append(" t.ind_vent_inte_sab_14,  ");
            buf.append(" i4.VAL_I18N descFormaPago,  ");
            buf.append(" i5.VAL_I18N descAlmac,   ");
            buf.append(" i6.VAL_I18N descMoviAsig,   ");
            buf.append(" t.ind_rese_stoc,  ");
            buf.append(" i7.VAL_I18N descMoviRese,  ");
            buf.append(" i8.VAL_I18N descMoviFact,  ");
            buf.append(" i9.VAL_I18N descActiv,  ");
            buf.append(" sociedad.VAL_DENO descsocie, ");
            buf.append(" i11.VAL_I18N descMoned  ");
            buf.append(" FROM  ");
            buf.append(" ped_tipo_solic_pais t, ");
            buf.append(" ped_tipo_solic_pais tp2, ");
            buf.append(" V_GEN_I18N_SICC i1, ");
            buf.append(" V_GEN_I18N_SICC i2, ");
            buf.append(" V_GEN_I18N_SICC i4, ");
            buf.append(" V_GEN_I18N_SICC i5, ");
            buf.append(" V_GEN_I18N_SICC i6, ");
            buf.append(" V_GEN_I18N_SICC i7, ");
            buf.append(" V_GEN_I18N_SICC i8, ");
            buf.append(" V_GEN_I18N_SICC i9, ");
            buf.append(" SEG_SOCIE sociedad, ");
			buf.append(" fac_tipo_docum tipoDocu, ");
            buf.append(" V_GEN_I18N_SICC i11 ");
            buf.append(" WHERE  ");
            buf.append(" i1.VAL_OID = t.tsol_oid_tipo_soli  ");
            buf.append(" AND i1.ATTR_ENTI(+) = 'PED_TIPO_SOLIC' ");
            buf.append(" AND i1.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i1.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND t.tsol_oid_tipo_cons = tp2.oid_tipo_soli_pais(+) ");
            buf.append(" AND i2.VAL_OID(+) = tp2.tsol_oid_tipo_soli ");
            buf.append(" AND i2.ATTR_ENTI(+) = 'PED_TIPO_SOLIC' ");
            buf.append(" AND i2.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i2.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
			buf.append(" and tipoDocu.OID_TIPO_DOCU(+) = t.TIDO_OID_TIPO_DOCU ");
/*          buf.append(" AND i3.VAL_OID(+) = t.tido_oid_tipo_docu  ");
            buf.append(" AND i3.ATTR_ENTI(+) = 'FAC_TIPO_DOCUM' ");
            buf.append(" AND i3.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i3.IDIO_OID_IDIO(+) =" + dto.getOidIdioma()); */
            buf.append(" AND i4.VAL_OID(+) = t.fopa_oid_form_pago  ");
            buf.append(" AND i4.ATTR_ENTI(+) = 'BEL_FORMA_PAGO' ");
            buf.append(" AND i4.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i4.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND i5.VAL_OID(+) = t.almc_oid_alma  ");
            buf.append(" AND i5.ATTR_ENTI(+) = 'BEL_ALMAC' ");
            buf.append(" AND i5.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i5.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND i6.VAL_OID(+) = t.tmal_oid_tipo_movi_asig  ");
            buf.append(" AND i6.ATTR_ENTI(+) = 'BEL_TIPO_MOVIM_ALMAC' ");
            buf.append(" AND i6.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i6.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND i7.VAL_OID(+) = t.tmal_oid_tipo_movi_rese  ");
            buf.append(" AND i7.ATTR_ENTI(+) = 'BEL_TIPO_MOVIM_ALMAC' ");
            buf.append(" AND i7.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i7.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND i8.VAL_OID(+) = t.tmal_oid_tipo_movi_fact  ");
            buf.append(" AND i8.ATTR_ENTI(+) = 'BEL_TIPO_MOVIM_ALMAC' ");
            buf.append(" AND i8.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i8.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND i9.VAL_OID(+) = t.cact_oid_acti  ");
            buf.append(" AND i9.ATTR_ENTI(+) = 'CRA_ACTIV' ");
            buf.append(" AND i9.ATTR_NUM_ATRI(+) = 1 ");
            buf.append(" AND i9.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            buf.append(" AND sociedad.OID_SOCI(+) = t.SOCI_OID_SOCI ");
            buf.append(" AND i11.VAL_OID(+) = t.mone_oid_mone  ");
            buf.append(" AND i11.ATTR_ENTI(+)= 'SEG_MONED' ");
            buf.append(" AND i11.ATTR_NUM_ATRI(+)= 1 ");
            buf.append(" AND i11.IDIO_OID_IDIO(+)= " + dto.getOidIdioma());
            buf.append(" AND t.pais_oid_pais = " + dto.getOidPais());

            if (dto.getTipoSolicitud() != null) {
                buf.append(" AND t.tsol_oid_tipo_soli = " + dto.getTipoSolicitud());
            }

            if (dto.getNumPorLote() != null) {
                buf.append(" AND t.num_soli_lote = " + dto.getNumPorLote());
            }

            if (dto.getAlarmaNumUnidades() != null) {
                buf.append(" AND t.num_unid_alar = " + dto.getAlarmaNumUnidades());
            }

            if (dto.getSujetoFlete() != null) {
                buf.append(" AND t.ind_suje_flet = " + this.booleanToLong(dto.getSujetoFlete()));
            }

            if (dto.getPermiteUnionSolicitudes() != null) {
                buf.append(" AND t.ind_perm_unio = " + this.booleanToLong(dto.getPermiteUnionSolicitudes()));
            }

            if (dto.getTipoConsolidado() != null) {
                buf.append(" AND t.tsol_oid_tipo_cons = " + dto.getTipoConsolidado());
            }

            if (dto.getTipoDocumentoLegal() != null) {
                buf.append(" AND t.tido_oid_tipo_docu = " + dto.getTipoDocumentoLegal());
            }

            if (dto.getReservaStock() != null) {
                buf.append(" AND t.ind_rese_stoc = " + this.booleanToLong(dto.getReservaStock()));
            }

            if (dto.getIndPedidoPrueba() != null) {
                buf.append(" AND t.ind_pedi_prue = " + this.booleanToLong(dto.getIndPedidoPrueba()));
            }

            if (dto.getIndComisionable() != null) {
                buf.append(" AND t.ind_comi = " + this.booleanToLong(dto.getIndComisionable()));
            }

            if (dto.getIndPedGtZona() != null) {
                buf.append(" AND t.ind_pedi_gt_zona = " + this.booleanToLong(dto.getIndPedGtZona()));
            }

            if (dto.getIndCambioVentaBEL() != null) {
                buf.append(" AND t.ind_camb_vent_bel = " + this.booleanToLong(dto.getIndCambioVentaBEL()));
            }

            if (dto.getIndVentaSAB14() != null) {
                buf.append(" AND t.ind_vent_inte_sab_14 = " + this.booleanToLong(dto.getIndVentaSAB14()));
            }

            if (dto.getFormaPago() != null) {
                buf.append(" AND t.fopa_oid_form_pago = " + dto.getFormaPago());
            }

            if (dto.getAlmacen() != null) {
                buf.append(" AND t.almc_oid_alma = " + dto.getAlmacen());
            }

            if (dto.getTipoMovAsigna() != null) {
                buf.append(" AND t.tmal_oid_tipo_movi_asig = " + dto.getTipoMovAsigna());
            }

            if (dto.getPermiteReversion() != null) {
                buf.append(" AND t.ind_perm_reve = " + this.booleanToLong(dto.getPermiteReversion()));
            }

            if (dto.getTipoMovReserva() != null) {
                buf.append(" AND t.tmal_oid_tipo_movi_rese = " + dto.getTipoMovReserva());
            }

            if (dto.getTipoMovFacturacion() != null) {
                buf.append(" AND t.tmal_oid_tipo_movi_fact = " + dto.getTipoMovFacturacion());
            }

            if (dto.getActividad() != null) {
                buf.append(" AND t.cact_oid_acti = " + dto.getActividad());
            }

            if (dto.getSociedad() != null) {
                buf.append(" AND t.soci_oid_soci = " + dto.getSociedad());
            }

            if (dto.getMoneda() != null) {
                buf.append(" AND t.mone_oid_mone = " + dto.getMoneda());
            }

            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), dto));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudPais(DTOTipoSolicitudPais dto): Salida ");
        return new DTOSalida(respuesta);
    }

    private Long booleanToLong(Boolean bool) {
        if (bool == null) {
            return null;
        } else {
            if (bool.booleanValue()) {
                return new Long(1);
            } else {
                return new Long(0);
            }
        }
    }

    /**
         * Autor: Hugo Mansi
         * Creado: 12/07/2004
         * Modificado: --
         * Paquete 18
         * Recibe un DTOBelcorp
         * Devuelve un RecordSet con el resultado pares de (oid, descripcion) de cada tipo de posición encapsulado en un DTOSalida.

         *
         *
        **/
    public DTOSalida obtieneTiposPosicion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposPosicion(DTOBelcorp dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT   t.oid_tipo_posi AS oid, vgen.val_i18n AS descripcion ");
            buf.append(" FROM ped_tipo_posic t, v_gen_i18n_sicc vgen ");
            buf.append(" WHERE vgen.idio_oid_idio =  " + dto.getOidIdioma());
            buf.append(" AND vgen.attr_enti = 'PED_TIPO_POSIC'	 ");
            buf.append(" AND vgen.val_oid = t.oid_tipo_posi	 ");
            buf.append(" AND vgen.attr_num_atri = 1 ");
            buf.append(" ORDER BY vgen.val_i18n	 ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPED.obtieneTiposPosicion(DTOBelcorp dto): Salida ");
        return new DTOSalida(respuesta);
    }

    /**
             * Autor: Hugo Mansi
             * Creado: 12/07/2004
             * Modificado: --
             * Paquete 18
             * Recibe un DTOBelcorp
             *Rcordset encapsulado con el resultado pares de (oid, descripcion) de cada subtipo de posición encapsulado en un DTOSalida.

             *
             *
            **/
    public DTOSalida obtieneSubtiposPosicion(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneSubtiposPosicion(DTOOID dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT   s.oid_subt_posi AS OID, vgen.val_i18n AS descripcionSubtipo ");
            buf.append(" FROM ped_subti_posic s, v_gen_i18n_sicc vgen ");
            buf.append(" WHERE vgen.idio_oid_idio =  " + dto.getOidIdioma());
            buf.append(" AND vgen.attr_enti = 'PED_SUBTI_POSIC' ");
            buf.append(" AND s.TPOS_OID_TIPO_POSI =  " + dto.getOid());
            buf.append(" AND vgen.val_oid = s.oid_subt_posi ");
            buf.append(" AND vgen.attr_num_atri = 1 ");
            buf.append(" ORDER BY vgen.val_i18n	 ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPED.obtieneSubtiposPosicion(DTOOID dto): Salida ");
        return new DTOSalida(respuesta);
    }

    /**
          * Autor: Hugo Mansi
          * Creado: 13/07/2004
          * Modificado: --
          * Paquete 18
          * Recibe un DTOTipoSolicitudProceso
          *Rcordset encapsulado en un DTOSalida.

          *
          *
         **/
    public DTOSalida obtieneTiposSolicitudProceso(DTOTipoSolicitudProceso dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudProceso(DTOTipoSolicitudProceso dto): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        String queryPaginada = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            UtilidadesLog.debug("DTO------> " + dto);
            query.append("SELECT t.oid_tipo_soli_proc AS OID,   ");
            query.append(" o.cod_oper AS operacion,  ");
            query.append(" vgen1.val_i18n AS descripcion,   ");
            query.append(" vgen2.val_i18n AS tiposolicitud,  ");
            query.append(" vgen3.val_i18n AS tipoposicion,  ");
            query.append(" vgen4.val_i18n AS subtipoposcion,  ");
            query.append(" t.ind_prod AS indproducto,  ");
            query.append(" mp.cod_sap AS producto  ");
            query.append(" FROM   ped_tipo_solic_proce t,  ");
            query.append(" bel_opera o,  ");
            query.append(" ped_tipo_solic_pais tp,  ");
            query.append(" mae_produ mp,  ");
            query.append(" v_gen_i18n_sicc vgen1,  ");
            query.append(" v_gen_i18n_sicc vgen2,  ");
            query.append(" v_gen_i18n_sicc vgen3, ");
            query.append(" v_gen_i18n_sicc vgen4  ");
            query.append(" WHERE  t.tspa_oid_tipo_soli_pais = tp.oid_tipo_soli_pais  ");
            query.append(" AND t.oper_oid_oper = o.oid_oper  ");
            query.append(" AND mp.oid_prod (+) = t.prod_oid_prod      ");
            query.append(" AND vgen1.val_oid = t.OID_TIPO_SOLI_PROC ");
            query.append(" AND vgen1.attr_enti = 'PED_TIPO_SOLIC_PROCE'  ");
            query.append(" AND vgen1.ATTR_NUM_ATRI = 1  ");
            query.append(" AND vgen1.IDIO_OID_IDIO = 1  ");
            query.append(" AND vgen2.val_oid = tp.tsol_oid_tipo_soli  ");
            query.append(" AND vgen2.attr_enti = 'PED_TIPO_SOLIC'  ");
            query.append(" AND vgen2.ATTR_NUM_ATRI = 1  ");
            query.append(" AND vgen2.IDIO_OID_IDIO = 1  ");
            query.append(" AND vgen3.val_oid(+) = t.tpos_oid_tipo_posi  ");
            query.append(" AND vgen3.attr_enti(+) = 'PED_TIPO_POSIC'  ");
            query.append(" AND vgen3.ATTR_NUM_ATRI(+) = 1  ");
            query.append(" AND vgen3.IDIO_OID_IDIO(+) = 1  ");
            query.append(" AND vgen4.VAL_OID(+) = t.STPO_OID_SUBT_POSI  ");
            query.append(" AND vgen4.ATTR_ENTI(+) = 'PED_SUBTI_POSIC'  ");
            query.append(" AND vgen4.ATTR_NUM_ATRI(+) = 1  ");
            query.append(" AND vgen4.IDIO_OID_IDIO(+) = 1  ");

            if (dto.getDescripcion() != null) {
                query.append("  AND vgen1.val_i18n LIKE '" + dto.getDescripcion() + "'");
            }

            if (dto.getTipoSolicitud() != null) {
                query.append(" AND t.tspa_oid_tipo_soli_pais = " + dto.getTipoSolicitud());
            }

            if (dto.getTipoPosicion() != null) {
                query.append(" AND t.tpos_oid_tipo_posi = " + dto.getTipoPosicion());
            }

            if (dto.getSubtipoPosicion() != null) {
                query.append(" AND t.stpo_oid_subt_posi = " + dto.getSubtipoPosicion());
            }

            int indProd;

            if (dto.getIndProducto() != null) {
                if (dto.getIndProducto().booleanValue()) {
                    indProd = 1;
                } else {
                    indProd = 0;
                }

                query.append(" AND t.ind_prod = " + indProd);
            }

            if (dto.getProducto() != null) {
                query.append(" AND mp.cod_sap LIKE '" + dto.getProducto() + "'");
            }

            /* if (dto.getDescripcion() != null) {
                 query.append(" AND t.descripcion LIKE " + dto.getDescripcion());
             }
            */
            if (dto.getOperacion() != null) {
                query.append(" AND t.oper_oid_oper = " + dto.getOperacion());
            }

            queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            respuesta = bs.dbService.executeStaticQuery(queryPaginada);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(respuesta);
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitudProceso(DTOTipoSolicitudProceso dto): Salida ");
        return dtoSalida;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       13/07/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     */
    public DTOSalida obtieneTiposSolicitud(DTOTipoSolicitud dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitud(DTOTipoSolicitud dto): Entrada ");
        BelcorpService belService = null;
        RecordSet rsRetorno = null;
        StringBuffer statement = new StringBuffer();
        String queryPaginada = null;

        try {
            belService = BelcorpService.getInstance();
            statement.append("SELECT ");
            statement.append("t.oid_tipo_soli AS OID, ");
            statement.append("t.cod_tipo_soli AS CODIGO, ");
            statement.append("i18n1.val_i18n AS DESCRIPCION, ");
            statement.append("i18n2.val_i18n AS CLASE, ");
            statement.append("m.des_marc AS MARCA, ");
            statement.append("i18n3.val_i18n AS CANAL, ");
            statement.append("i18n4.val_i18n AS ACCESO, ");
            statement.append("subacceso.descrip AS SUBACCESO, ");
            statement.append("i18n6.val_i18n AS TIPOCLIENTE, ");
            statement.append("t.ind_cons AS INDCONSOLIDADO, ");
            statement.append("t.ind_anul AS INDANULACION, ");
            statement.append("t.ind_devo AS INDDEVOLUCION, ");
            statement.append("t.ind_soli_nega AS NEGATIVA, ");
            statement.append("t.GRSO_OID_GRUP_SOLI AS OIDGRUPO ");

            statement.append("FROM ped_tipo_solic t, ");
            statement.append("ped_clase_solic c, ");
            statement.append("VCA_SEG_MARCA m, ");
            statement.append("seg_canal ca, ");
            statement.append("seg_acces a, ");

            // Esto evita problemas en subacceso nulo
            statement.append("(select aux.OIDTipoSolicitud, ");
            statement.append("aux.oidsubacceso, ");
            statement.append("i18nJoin.val_i18n as descrip ");
            statement.append("from ( SELECT PED.OID_TIPO_SOLI AS OIDTipoSolicitud, ");
            statement.append("PED.COD_TIPO_SOLI AS CODIGO, ");
            statement.append("PED.SBAC_OID_SBAC as OIDSUBACCESO ");
            statement.append("FROM PED_TIPO_SOLIC PED LEFT JOIN VCA_SEG_SUBAC SB  ");
            statement.append("ON ( PED.SBAC_OID_SBAC LIKE SB.OID_SBAC AND SB.COD_USUA = '" + user + "' ) ) aux ");
            statement.append("left join v_gen_i18n_sicc i18nJoin ");
            statement.append("on (aux.OIDSUBACCESO like i18nJoin.val_oid and i18nJoin.attr_enti='SEG_SUBAC' ");
            statement.append("and i18nJoin.idio_oid_idio=" + dto.getOidIdioma().toString() + " ");
            statement.append("AND i18nJoin.attr_num_atri=1)) subacceso, ");

            // ---
            statement.append("mae_tipo_clien tc, ");
            statement.append("v_gen_i18n_sicc i18n1, ");
            statement.append("v_gen_i18n_sicc i18n2, ");
            statement.append("v_gen_i18n_sicc i18n3, ");
            statement.append("v_gen_i18n_sicc i18n4, ");
            statement.append("v_gen_i18n_sicc i18n6 ");

            statement.append("WHERE c.oid_clas_soli = t.clso_oid_clas_soli ");
            statement.append("AND m.cod_usua = '" + user + "' ");
            statement.append("AND m.oid_marc = t.marc_oid_marc ");
            statement.append("AND ca.oid_cana = a.cana_oid_cana ");
            statement.append("AND a.oid_acce = t.acce_oid_acce ");
            statement.append("AND t.OID_TIPO_SOLI = subacceso.OIDTipoSolicitud ");
            statement.append("AND tc.oid_tipo_clie = t.ticl_oid_tipo_clie ");

            if ((dto.getCodigo() != null) && !dto.getCodigo().equals("")) {
                statement.append("AND t.cod_tipo_soli LIKE '" + dto.getCodigo() + "' ");
            }

            if ((dto.getDescripcion() != null) && !dto.getDescripcion().equals("")) {
                statement.append("AND i18n1.val_i18n LIKE '%" + dto.getDescripcion() + "%' ");
            }

            if (dto.getClaseSolicitud() != null) {
                statement.append("AND c.oid_clas_soli = " + dto.getClaseSolicitud().toString() + " ");
            }

            if (dto.getIndConsolidado() != null) {
                if (dto.getIndConsolidado().booleanValue()) {
                    statement.append("AND t.ind_cons = 1 ");
                } else {
                    statement.append("AND t.ind_cons = 0 ");
                }
            }

            if (dto.getCanal() != null) {
                statement.append("AND ca.oid_cana = " + dto.getCanal().toString() + " ");
            }

            if (dto.getAcceso() != null) {
                statement.append("AND a.oid_acce = " + dto.getAcceso().toString() + " ");
            }

            if (dto.getSubacceso() != null) {
                statement.append("AND subacceso.oidsubacceso = " + dto.getSubacceso().toString() + " ");
            }

            if (dto.getTipoCliente() != null) {
                statement.append("AND tc.oid_tipo_clie = " + dto.getTipoCliente().toString() + " ");
            }

            if (dto.getIndAnulacion() != null) {
                if (dto.getIndAnulacion().booleanValue()) {
                    statement.append("AND t.ind_anul = 1 ");
                } else {
                    statement.append("AND t.ind_anul = 0 ");
                }
            }

            if (dto.getIndDevoluciones() != null) {
                if (dto.getIndDevoluciones().booleanValue()) {
                    statement.append("AND t.ind_devo = 1 ");
                } else {
                    statement.append("AND t.ind_devo = 0 ");
                }
            }

            if (dto.getIndSolNegativa() != null) {
                if (dto.getIndSolNegativa().booleanValue()) {
                    statement.append("AND t.ind_soli_nega = 1 ");
                } else {
                    statement.append("AND t.ind_soli_nega = 0 ");
                }
            }

            if (dto.getMarca() != null) {
                statement.append("AND m.oid_marc = " + dto.getMarca().toString() + " ");
            }

            statement.append("AND I18N1.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
            statement.append("AND i18n1.idio_oid_idio = " + dto.getOidIdioma().toString() + " ");
            statement.append("AND i18n1.attr_num_atri = 1 ");
            statement.append("AND i18n1.val_oid = t.oid_tipo_soli ");

            statement.append("AND i18n2.attr_enti = 'PED_CLASE_SOLIC' ");
            statement.append("AND i18n2.idio_oid_idio = " + dto.getOidIdioma().toString() + " ");
            statement.append("AND i18n2.attr_num_atri = 1 ");
            statement.append("AND i18n2.val_oid = c.oid_clas_soli ");

            statement.append("AND i18n3.attr_enti = 'SEG_CANAL' ");
            statement.append("AND i18n3.idio_oid_idio = " + dto.getOidIdioma().toString() + " ");
            statement.append("AND i18n3.attr_num_atri = 1 ");
            statement.append("AND i18n3.val_oid = ca.oid_cana ");

            statement.append("AND i18n4.attr_enti = 'SEG_ACCES' ");
            statement.append("AND i18n4.idio_oid_idio = " + dto.getOidIdioma().toString() + " ");
            statement.append("AND i18n4.attr_num_atri = 1 ");
            statement.append("AND i18n4.val_oid = a.oid_acce ");

            statement.append("AND i18n6.attr_enti = 'MAE_TIPO_CLIEN' ");
            statement.append("AND i18n6.idio_oid_idio = " + dto.getOidIdioma().toString() + " ");
            statement.append("AND i18n6.attr_num_atri = 1 ");
            statement.append("AND i18n6.val_oid = tc.oid_tipo_clie ");

            queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(statement.toString(), dto);
            rsRetorno = belService.dbService.executeStaticQuery(queryPaginada);
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rsRetorno.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rsRetorno);
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitud(DTOTipoSolicitud dto): Salida ");
        return dtoSalida;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       23/07/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: Obtiene los tipos de solicitud filtrando por los campos del dto.
     */
    public DTOSalida obtieneTiposSolicitud(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposSolicitud(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            query.append("SELECT t.oid_tipo_soli AS OID, i18n.val_i18n AS descripcion ");
            query.append("  FROM ped_tipo_solic t, v_gen_i18n_sicc i18n ");
						// MODIFICACION -------------------------------
						// Autor: Maximiliano Dello Russo (grusso).
						// Motivo: INC BELC300010891.  Se deja de filtrar por ind_cons = '0'.
						//
		//			query.append(" WHERE t.ind_cons = '0' ");
		//      query.append("   AND i18n.attr_enti = 'PED_TIPO_SOLIC'");			
						query.append(" WHERE i18n.attr_enti = 'PED_TIPO_SOLIC' ");
						// FIN MODIFICACION ---------------------------
            query.append("   AND i18n.attr_num_atri = 1 ");
            query.append("   AND i18n.idio_oid_idio = " + dto.getOidIdioma() + " ");
            query.append("   AND i18n.val_oid = t.oid_tipo_soli ");
            query.append("ORDER BY descripcion ");

            bs = BelcorpService.getInstance();

            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAOPED.obtieneTiposSolicitud(DTOBelcorp dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       04/07/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: Obtiene las clases de solicitud.
     */
    public DTOSalida obtieneClasesSolicitud(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneClasesSolicitud(DTOBelcorp dto): Entrada ");
        // A través de DBService hace la siguiente consulta y devuelve el RecordSet 
        // encapsulado en un DTOSalida: 
        // SELECT 
        // c.oid_clas_soli as oid 
        // descripcion según el idioma del dto de c.oid_clas_soli en V_GEN_I18N_SICC as descripcion 
        // FROM 
        // own_peru.ped_clase_solic c 
        BelcorpService belService = null;
        RecordSet rsRetorno = null;
        StringBuffer statement = new StringBuffer();

        try {
            belService = BelcorpService.getInstance();

            statement.append("SELECT C.OID_CLAS_SOLI AS OID, I18N.VAL_I18N AS DESCRIPCION ");
            statement.append("FROM PED_CLASE_SOLIC C, V_GEN_I18N_SICC I18N ");
            statement.append("WHERE I18N.ATTR_ENTI = 'PED_CLASE_SOLIC' ");
            statement.append("AND I18N.IDIO_OID_IDIO = " + dto.getOidIdioma().toString() + " ");
            statement.append("AND I18N.ATTR_NUM_ATRI = 1 ");
            statement.append("AND I18N.VAL_OID = C.OID_CLAS_SOLI ");
            statement.append("ORDER BY DESCRIPCION ");

            rsRetorno = belService.dbService.executeStaticQuery(statement.toString());

            // Devuelve un RecordSet con el resultado pares de (oid, descripcion) 
            // de cada clase de solicitud encapsulado en un DTOSalida.
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rsRetorno);
            UtilidadesLog.info("DAOPED.obtieneClasesSolicitud(DTOBelcorp dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      PED
           * Fecha:       20/07/2004
           * @version     1.0
           * @autor       Andrés Pollitzer
           *
     * Obtiene los procesos de pedidos dado el grupo de procesos
     *
     * A través de DBService hace la siguiente consulta y devuelve el RecordSet encapsulado en un DTOSalida:
     * SELECT
     *  p.oid_proc as oid,
     *  p.cod_proc as descripcion
     * FROM
     *  own_peru.ped_proce p
     * WHERE
     *  ( (p.grpr_oid_grup_proc = dto.oid) )
     *
     * Devuelve un RecordSet con el resultado pares de (oid,descripcion) de cada proceso encapsulado en un DTOSalida.
     */
    public DTOSalida obtieneProcesos(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneProcesos(DTOOID dto): Entrada ");
        BelcorpService belService = null;
        RecordSet rsProcesos = null;
        StringBuffer statement = new StringBuffer();

        try {
            belService = BelcorpService.getInstance();

            statement.append("SELECT P.OID_PROC AS OID, P.COD_PROC AS DESCRIPCION ");
            statement.append("FROM PED_PROCE P ");
            statement.append("WHERE (P.GRPR_OID_GRUP_PROC = " + dto.getOid() + " or P.COD_PROC='0000') ");
            statement.append("ORDER BY DESCRIPCION");

            rsProcesos = belService.dbService.executeStaticQuery(statement.toString());

            //Devuelve un RecordSet con el resultado pares de (oid,descripcion) de cada proceso encapsulado en un DTOSalida
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rsProcesos);
            UtilidadesLog.info("DAOPED.obtieneProcesos(DTOOID dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      PED
           * Fecha:       20/07/2004
           * @version     1.0
           * @autor       Andrés Pollitzer
     *
     * Obtiene las secuencias de procesos dados unos criterios
           */
    public DTOSalida obtieneSecuenciaProcesos(DTOSecuenciaProcesos dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneSecuenciaProcesos(DTOSecuenciaProcesos dto): Entrada ");

        BelcorpService belService = null;
        RecordSet rsSecuenciaProcesos = null;
        StringBuffer statement = new StringBuffer();
        String queryPaginada = null;

        try {
            belService = BelcorpService.getInstance();

            //A través de DBService hace la siguiente consulta y devuelve el RecordSet encapsulado en un DTOSalida:
            statement.append("SELECT ");
            statement.append("S.OID_SECU_PROC AS OID, ");

            //descripción de t.oid_tipo_soli en V_GEN_I18N_SICC as tiposolicitud,
            statement.append("T.OID_TIPO_SOLI AS TIPOSOLICITUD, ");
            statement.append("I18N1.VAL_I18N AS DESCRIPCION1, ");

            //descripción de g.oid_grup_proc en V_GEN_I18N_SICC as grupoproceso,
            statement.append("G.OID_GRUP_PROC AS GRUPOPROCESO, ");
            statement.append("G.COD_GRUP_PROC AS DESCRIPCION2, ");
            statement.append("P.COD_PROC AS CODIGOPROCESO, ");
            statement.append("S.COD_SECU AS SECUENCIA, ");
            statement.append("S.IND_EJEC_ONLI AS INDICADOR ");
            statement.append("FROM ");
            statement.append("PED_SECUE_PROCE S, ");
            statement.append("PED_TIPO_SOLIC T, ");
            statement.append("PED_GRUPO_PROCE G, ");
            statement.append("PED_PROCE P, ");
            statement.append("PED_TIPO_SOLIC_PAIS TP, ");
            statement.append("V_GEN_I18N_SICC I18N1 ");
            statement.append("WHERE ");
            statement.append("( (TP.OID_TIPO_SOLI_PAIS = S.TSPA_OID_TIPO_SOLI_PAIS) ");
            statement.append("AND (P.OID_PROC = S.PROC_OID_PROC) ");
            statement.append("AND (T.OID_TIPO_SOLI = TP.TSOL_OID_TIPO_SOLI) ");
            statement.append("AND (G.OID_GRUP_PROC = S.GRPR_OID_GRUP_PROC) ");
            statement.append("AND (I18N1.ATTR_ENTI = 'PED_TIPO_SOLIC') ");
            statement.append("AND (I18N1.IDIO_OID_IDIO = " + dto.getOidIdioma().toString() + ") ");
            statement.append("AND (I18N1.ATTR_NUM_ATRI = 1) ");
            statement.append("AND (I18N1.VAL_OID = T.OID_TIPO_SOLI) ");
            statement.append("AND (G.OID_GRUP_PROC = P.GRPR_OID_GRUP_PROC OR P.COD_PROC='0000') ");
            
            /*esta ultima linea de la consulta se debe a la inc.: 15608*/
            /*El proceso NULO ('0000') esta parametrizado para GP1 pero puede asociarse con cualquier GP)*/
            
            //Nota: Las condiciones de filtrado se harán SÓLO sí el atributo respectivo del dto es distinto de null
            if ((dto.getOidGrupoProcesos() != null) && !dto.getOidGrupoProcesos().equals("")) {
                statement.append("AND (G.OID_GRUP_PROC = " + dto.getOidGrupoProcesos() + ") ");
            }

            if ((dto.getSecuencia() != null) && !dto.getSecuencia().equals("")) {
                statement.append("AND (S.COD_SECU ='" + dto.getSecuencia() + "') ");
            }

            if ((dto.getIndEjecucion() != null) && !dto.getIndEjecucion().equals("")) {
                if (dto.getIndEjecucion().booleanValue()) {
                    statement.append("AND (S.IND_EJEC_ONLI = 1) ");
                } else {
                    statement.append("AND (S.IND_EJEC_ONLI = 0) ");
                }
            }

            statement.append("AND (TP.PAIS_OID_PAIS = " + dto.getOidPais() + ") ");

            if ((dto.getOidTipoSolicitudPais() != null) && !dto.getOidTipoSolicitudPais().equals("")) {
                statement.append("AND (TP.OID_TIPO_SOLI_PAIS = " + dto.getOidTipoSolicitudPais() + ") ");
            }

            if ((dto.getOidProceso() != null) && !dto.getOidProceso().equals("")) {
                statement.append("AND (P.OID_PROC = " + dto.getOidProceso() + ") ");
            }

            statement.append(") ");

            //Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes
            //consideraciones para filtrar la búsqueda:
            //1.- oid del registro encontrado = dto.indicadorSituacion
            //2.- ROWNUM = dto.tamañoPagina
            queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(statement.toString(), dto);
            rsSecuenciaProcesos = belService.dbService.executeStaticQuery(queryPaginada);

            //Devuelve el RecordSet generado encapsulado en un DTOSalida.
            if (rsSecuenciaProcesos.esVacio()) {
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
            }

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rsSecuenciaProcesos);
            UtilidadesLog.info("DAOPED.obtieneSecuenciaProcesos(DTOSecuenciaProcesos dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new MareException(mmsnfe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      PED
           * Fecha:       20/07/2004
           * @version     1.0
           * @autor       Andrés Pollitzer
     *
     * Obtiene los grupos de procesos de PED.
     *
     * A través de DBService hace la siguiente consulta:
     * SELECT
     * g.oid_grup_proc as oid,
     * g.des_grup_proc as descripcion
     * FROM
     * own_peru.ped_grupo_proce g
     *
     * Devuelve un RecordSet con el resultado pares de (oid,descripcion) de cada grupo de procesos
     * encapsulado en un DTOSalida
           */
    public DTOSalida obtieneGruposProcesos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneGruposProcesos(DTOBelcorp dto): Entrada ");
        BelcorpService belService = null;
        RecordSet rsGruposProcesos = null;
        StringBuffer statement = new StringBuffer();

        try {
            belService = BelcorpService.getInstance();

            statement.append("SELECT G.OID_GRUP_PROC AS OID, G.COD_GRUP_PROC AS DESCRIPCION ");
            statement.append("FROM PED_GRUPO_PROCE G ORDER BY DESCRIPCION");

            rsGruposProcesos = belService.dbService.executeStaticQuery(statement.toString());

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rsGruposProcesos);
            UtilidadesLog.info("DAOPED.obtieneGruposProcesos(DTOBelcorp dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneAtributosEspeciales(DTOAtributoEspecial dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneAtributosEspeciales(DTOAtributoEspecial dto): Entrada ");
        BelcorpService belService = null;
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        try {
            belService = BelcorpService.getInstance();

            query.append(" SELECT a.oid_atri_espe as oid, a.des_atri as descripcion,'' AS VPD,'' AS IDVPD ");
            query.append(" FROM ped_atrib_espec a ");
            query.append(" WHERE ((a.val_form = '" + dto.getFormulario() + "') AND (a.modu_oid_modu = " + dto.getOidModulo().toString() + ")) ");

            rs = belService.dbService.executeStaticQuery(query.toString());

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAOPED.obtieneAtributosEspeciales(DTOAtributoEspecial dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       22/07/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * @incidencia  BELC300022892 - Emilio Iraola - Se agrega filtrado por pais.
     * Descripcion: Obtiene los tipos de consolidado filtrando por los campos del dto.
     */
    public DTOSalida obtieneTiposConsolidado(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposConsolidado(DTOBelcorp dto): Entrada ");
       
        try {
            BelcorpService bs = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append("SELECT tsp.oid_tipo_soli_pais AS OID, i18n.val_i18n AS descripcion ");
            query.append("  FROM ped_tipo_solic_pais tsp, ped_tipo_solic ts, v_gen_i18n_sicc i18n ");
            query.append("  WHERE tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
            query.append("   AND ts.ind_cons = 1 ");
            query.append("   AND tsp.pais_oid_pais = " + dto.getOidPais() + " ");
            query.append("   AND i18n.attr_enti = 'PED_TIPO_SOLIC' ");
            query.append("   AND i18n.attr_num_atri = 1 ");            
            query.append("   AND I18N.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append("   AND i18n.val_oid = ts.oid_tipo_soli ");
            query.append(" ORDER BY DESCRIPCION "); 
            

            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());

            // Devuelve un RecordSet con el resultado pares de (oid,descripcion) de cada 
            // tipo de solicitud encapsulado en un DTOSalida.
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAOPED.obtieneTiposConsolidado(DTOBelcorp dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       27/07/2004
     * @version     1.0
     * @autor       Marta Aurora Montiel
     * Descripcion: Obtiene los montos mínimos que cumplen el dto de entrada
     */
    public DTOSalida obtieneMontoMinimo(DTOMontoMinimo dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneMontoMinimo(DTOMontoMinimo dto): Entrada ");
        RecordSet resultado = null;
        
        try {
            BelcorpService bs = null;
            StringBuffer query = new StringBuffer();
            /*query.append(" SELECT m.OID_MONT_MINI oid, ");
            query.append(" g1.VAL_I18N desc_tipoSolicitud, ");
            query.append(" g2.VAL_I18N desc_tipoCliente, ");
            query.append(" g3.VAL_I18N desc_subTipoCliento, ");
            query.append(" g4.VAL_I18N desc_tipoClasificacion, ");
            query.append(" g5.VAL_I18N desc_clasificacion, ");
            query.append(" m.val_niv1, ");
            query.append(" m.val_niv2, ");
            query.append(" m.val_niv3, ");
            query.append(" m.val_reca, ");
            query.append(" m.val_mont_mini_nomi ");
            query.append(" FROM PED_MONTO_MINIM m, ");
            query.append(" PED_TIPO_SOLIC_PAIS tp, ");
            query.append(" V_GEN_I18N_SICC g1, ");
            query.append(" V_GEN_I18N_SICC g2, ");
            query.append(" V_GEN_I18N_SICC g3, ");
            query.append(" V_GEN_I18N_SICC g4, ");
            query.append(" V_GEN_I18N_SICC g5 ");
            query.append(" where m.TSPA_OID_TIPO_SOLI_PAIS = tp.OID_TIPO_SOLI_PAIS ");
            query.append(" and tp.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" and g1.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
            query.append(" and g1.ATTR_NUM_ATRI = 1 ");
            query.append(" and g1.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" and g1.VAL_OID = tp.TSOL_OID_TIPO_SOLI ");
            query.append(" and g2.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
            query.append(" and g2.ATTR_NUM_ATRI = 1 ");
            query.append(" and g2.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" and g2.VAL_OID = m.TICL_OID_TIPO_CLIE ");
            query.append(" and g3.ATTR_ENTI(+) = 'MAE_SUBTI_CLIEN' ");
            query.append(" and g3.ATTR_NUM_ATRI(+) = 1 ");
            query.append(" and g3.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            query.append(" and g3.VAL_OID(+) = m.SBTI_OID_SUBT_CLIE ");
            query.append(" and g4.ATTR_ENTI(+) = 'MAE_TIPO_CLASI_CLIEN' ");
            query.append(" and g4.ATTR_NUM_ATRI(+) = 1 ");
            query.append(" and g4.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            query.append(" and g4.VAL_OID(+) = m.TCCL_OID_TIPO_CLAS ");
            query.append(" and g5.ATTR_ENTI(+) = 'MAE_CLASI' ");
            query.append(" and g5.ATTR_NUM_ATRI(+) = 1 ");
            query.append(" and g5.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
            query.append(" and g5.VAL_OID(+) = m.CLAS_OID_CLAS ");*/
            
             query.append(" SELECT M.OID_MONT_MINI OID, ");
             query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma()+",TP.TSOL_OID_TIPO_SOLI,'PED_TIPO_SOLIC') DESC_TIPOSOLICITUD, ");
             query.append("       R.DES_REGI ,  ");
             query.append("       Z.DES_ZONA,   ");
             query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma()+",M.TICL_OID_TIPO_CLIE,'MAE_TIPO_CLIEN') DESC_TIPOCLIENTE, ");
             query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma()+",M.SBTI_OID_SUBT_CLIE,'MAE_SUBTI_CLIEN') DESC_SUBTIPOCLIENTO, ");
             query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma()+",M.TCCL_OID_TIPO_CLAS,'MAE_TIPO_CLASI_CLIEN') DESC_TIPOCLASIFICACION, ");
             query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma()+",M.CLAS_OID_CLAS,'MAE_CLASI') DESC_CLASIFICACION, ");
             query.append("       M.VAL_MONT_MINI_NOMI, ");
             query.append("       M.VAL_NIV1, ");
             query.append("       M.VAL_NIV2, ");
             query.append("       M.VAL_NIV3, ");
             query.append("       M.VAL_RECA ");
             query.append("  FROM PED_MONTO_MINIM M, ");
             query.append("       ZON_ZONA Z, ");
             query.append("       ZON_REGIO R, ");
             query.append("       PED_TIPO_SOLIC_PAIS TP ");
             query.append(" WHERE M.TSPA_OID_TIPO_SOLI_PAIS = TP.OID_TIPO_SOLI_PAIS ");
             query.append("   AND M.ZORG_OID_REGI = R.OID_REGI(+) ");
             query.append("   AND M.ZZON_OID_ZONA = Z.OID_ZONA(+) ");
          
            if(dto.getTipoSolicitudPais()!=null){
                query.append("and m.TSPA_OID_TIPO_SOLI_PAIS= " + dto.getTipoSolicitudPais());
            }
           

            bs = BelcorpService.getInstance();

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            resultado = bs.dbService.executeStaticQuery(queryStr);
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        
        if(resultado.esVacio()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
            
        DTOSalida dts = new DTOSalida();
        dts.setResultado(resultado);
        UtilidadesLog.info("DAOPED.obtieneMontoMinimo(DTOMontoMinimo dto): Salida ");
        return dts;
        
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       27/07/2004
    * @version     1.0
    * @autor       Marta Aurora Montiel
    * Descripcion: Obtiene los montos mínimos que cumplen el dto de entrada
    */
    public DTOSalida obtieneTipoCliente(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTipoCliente(DTOOID dto): Entrada ");
        try {
            BelcorpService bs = BelcorpService.getInstance();
            ;

            StringBuffer query = new StringBuffer();
            query.append(" SELECT VAL_OID oid, VAL_I18N descripcion ");
            query.append(" FROM GEN_I18N_SICC ");
            query.append(" WHERE ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
            query.append(" AND ATTR_NUM_ATRI = 1 ");
            query.append(" AND IDIO_OID_IDIO = 1 ");
            query.append(" AND VAL_OID IN (SELECT TICL_OID_TIPO_CLIE ");
            query.append(" FROM PED_TIPO_SOLIC ");
            query.append(" WHERE OID_TIPO_SOLI IN( SELECT TSOL_OID_TIPO_SOLI ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS ");
            query.append(" WHERE OID_TIPO_SOLI_PAIS =  " + dto.getOid());
            query.append(" )) ");
            UtilidadesLog.debug("query  " + query);

            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAOPED.obtieneTipoCliente(DTOOID dto): Salida ");
            return dtoSalida;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneTiposDespacho(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTiposDespacho(DTOBelcorp dto): Entrada ");
        //Obtiene los tipos de despacho del país 
        try {
            BelcorpService bs = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append(" SELECT  ");
            query.append(" td.oid_tipo_desp as oid,  ");
            query.append(" i.VAL_I18N as descripcion  ");
            query.append(" FROM  ");
            query.append(" ped_tipo_despa td, V_GEN_I18N_SICC i  ");
            query.append(" WHERE td.pais_oid_pais = " + dto.getOidPais());
            query.append(" AND i.ATTR_ENTI = 'PED_TIPO_DESPA' ");
            query.append(" AND i.ATTR_NUM_ATRI = 1 ");
            query.append(" AND i.IDIO_OID_IDIO =  " + dto.getOidIdioma());
            query.append(" AND i.VAL_OID = td.OID_TIPO_DESP ");

            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAOPED.obtieneTiposDespacho(DTOBelcorp dto): Salida ");
            return dtoSalida;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneFlete(DTOFlete dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneFlete(DTOFlete dto): Entrada ");
        RecordSet resultado = null;      
		
       try {
            BelcorpService bs = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

			query.append(" SELECT   a.oid_flete AS OID, c.des_marc AS descr, canal.VAL_I18N as canal, ");
			query.append("e.des_zona ");
			query.append("||'' ");
			query.append("||f.orde_1 ");
			query.append("||'' ");
			query.append("||f.orde_2 ");
			query.append("||'' ");
			query.append("||f.orde_3 ");
			query.append("||'' ");
			query.append("||f.orde_4 ");
			query.append("||'' ");
			query.append("||f.orde_5 ");
			query.append("||'' ");
			query.append("||f.orde_6 ");
			query.append("||'' ");
			query.append("||f.orde_7 ");
			query.append("||'' ");
			query.append("||f.orde_8 ");
			query.append("||''");
			query.append("||f.orde_9 AS zonaubigeo, ");
			query.append(" despacho.VAL_I18N as despacho, ");
			query.append(" a.val_mont_fijo AS montofijo, a.val_tasa AS tasa, ");
			query.append(" a.val_flet_mini AS fletemin, a.val_flet_maxi AS fletemax, ");
			query.append(" a.val_cont_entr AS contraentrega,  ");
			query.append(" tipoClien.VAL_I18N as tipoCliente, subtiClien.VAL_I18N as subTipoCliente,  ");
			query.append(" tipoClasi.VAL_I18N as tipoClasi, clasif.VAL_I18N as clasif ");
			query.append(" FROM ped_flete a, ");
			query.append(" vca_seg_marca c, ");
			query.append(" vca_seg_canal d, ");
			query.append(" zon_valor_estru_geopo f, ");
			query.append(" vca_zon_zona e, ");
			query.append(" v_gen_i18n_sicc tipoClien, ");
			query.append(" v_gen_i18n_sicc subtiClien, ");
			query.append(" v_gen_i18n_sicc tipoClasi, ");
			query.append(" v_gen_i18n_sicc clasif, ");
			query.append(" v_gen_i18n_sicc canal, ");
			query.append(" v_gen_i18n_sicc despacho ");			
		    query.append(" WHERE a.oid_flete > " + dto.getIndicadorSituacion());
			query.append(" AND a.CANA_OID_CANA = d.OID_CANA	");
			if (dto.getOidCanal() != null) {
                query.append(" AND d.OID_CANA =  " + dto.getOidCanal());
            }
			query.append(" AND d.COD_USUA = '" + user + "' ");
			
			if (dto.getOidTipoDespacho() != null) {
                query.append(" AND a.tids_oid_tipo_desp =  " + dto.getOidTipoDespacho());
            }
      //Modifado por Jrivas 13/1/2005
      //Le agregue el  (+) porque la query tiraba ORA_1722 Invalid Number 
			query.append(" AND a.MARC_OID_MARC = c.OID_MARC(+) ");
			if (dto.getOidMarca() != null) {
                query.append(" AND c.OID_MARC =  " + dto.getOidMarca());
            }
			query.append(" AND c.COD_USUA(+) = '" + user + "' " );
			query.append(" AND a.zzon_zona = e.OID_ZONA(+) ");
			if (dto.getZona() != null) {
                query.append(" AND e.OID_ZONA = " + dto.getZona());
            }			
			query.append(" AND e.cod_usua(+) = '" + user + "' " );
			query.append(" AND a.vepo_ubig = f.oid_valo_estr_geop(+) ");
			if (dto.getOidUbigeo() != null) {
                query.append(" AND f.OID_VALO_ESTR_GEOP = " + dto.getOidUbigeo());
            }			
			query.append(" AND a.sbti_oid_subt_clie= subticlien.val_oid(+) ");
			query.append(" AND a.ticl_oid_tipo_clie = tipoclien.val_oid ");
			query.append(" AND a.tccl_oid_tipo_clas = tipoclasi.val_oid(+) ");
			query.append(" AND a.clas_oid_clas = clasif.val_oid (+)");
			query.append(" AND subticlien.attr_enti(+) = 'MAE_SUBTI_CLIEN' ");
			query.append(" AND subticlien.attr_num_atri(+) = 1 ");
			query.append(" AND subticlien.idio_oid_idio(+) = " + dto.getOidIdioma());
			query.append(" AND tipoclien.attr_enti = 'MAE_TIPO_CLIEN' ");
			query.append(" AND tipoclien.attr_num_atri = 1 ");
			query.append(" AND tipoclien.idio_oid_idio = " + dto.getOidIdioma());
			query.append(" AND tipoclasi.attr_enti(+) = 'MAE_TIPO_CLASI_CLIEN' ");
			query.append(" AND tipoclasi.attr_num_atri(+) = 1 ");
			query.append(" AND tipoclasi.idio_oid_idio(+)= " + dto.getOidIdioma());
			query.append(" AND clasif.attr_enti(+) = 'MAE_CLASI' ");
			query.append(" AND clasif.attr_num_atri(+) = 1");
			query.append(" AND clasif.idio_oid_idio(+) = " + dto.getOidIdioma());
			query.append(" AND a.CANA_OID_CANA = canal.val_oid ");
			query.append(" AND canal.attr_enti = 'SEG_CANAL'");
			query.append(" AND canal.attr_num_atri = 1 ");
			query.append(" AND canal.idio_oid_idio = " + dto.getOidIdioma());
			query.append(" AND a.TIDS_OID_TIPO_DESP = despacho.VAL_OID");
			query.append(" AND despacho.ATTR_ENTI = 'PED_TIPO_DESPA'");
			query.append(" AND despacho.attr_num_atri = 1");
			query.append(" AND despacho.idio_oid_idio = " + dto.getOidIdioma());
			query.append(" ORDER BY a.oid_flete ");   		
            

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
            resultado = bs.dbService.executeStaticQuery(queryStr);

        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(resultado.esVacio()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
            
        DTOSalida dts = new DTOSalida();
        dts.setResultado(resultado);
        UtilidadesLog.info("DAOPED.obtieneFlete(DTOFlete dto): Salida ");
        return dts;
        
    }


    public static void main(String[] args) throws MareException {
        DAOPED h = new DAOPED("ww");
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidIdioma(new Long(1));
        dto.setOidPais(new Long(1));

        DTOFlete dto2 = new DTOFlete();
        dto2.setOidMarca(new Long(1));
        dto2.setOidCanal(new Long(1));
        dto2.setOidTipoDespacho(new Long(1));
        dto2.setZona(new Long(1));
        dto2.setOidUbigeo(new Long(1));

        dto2.setTamanioPagina(new Integer(20));
        dto2.setIndicadorSituacion(new Long(0));

        h.obtieneFlete(dto2);
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       02/08/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: Generada a partir de la incidencia 6841
     */
    public DTOSalida obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto): Entrada ");
        try {
            StringBuffer query = new StringBuffer();
            BelcorpService bs = BelcorpService.getInstance();

            // -> Hacer consulta JDBC sobre la tabla PED_TIPO_SOLIC_PROCE haciendo join con 
            // la tabla PED_TIPO_SOLIC_PAIS, esta a su vez con PED_TIPO_SOLIC, esta a su vez 
            // con SEG_ACCES obteniendo los campos PED_TIPO_SOLIC_PROCE.TSPA_OID_TIPO_SOLI_PAIS 
            // y descripción internacionalizada de tipo de solicitud (tabla PED_TIPO_SOLIC). 
            // Se filtrará por los siguientes campos: 
            // PED_TIPO_SOLIC.MARC_OID_MARC = dto.oidMarca 
            // SEG_ACCES.CANA_OID_CANA = dto.oidCanal 
            // PED_TIPO_SOLIC.TICL_OID_TIPO_CLIE = dto.oidTipoCliente 
            // PED_TIPO_SOLIC_PROCE.OPER_OID_OPER = dto.oidOperacion 
			query.append("SELECT TSPAIS.OID_TIPO_SOLI_PAIS OID, I18N.VAL_I18N DESCRIPCION ");
			query.append("  FROM PED_TIPO_SOLIC_PAIS TSPAIS, ");
			if( dto.getOidOperacion() != null )
				query.append("         ped_tipo_solic_proce tproceso,");
			query.append("       PED_TIPO_SOLIC TIPOSOLIC, ");
			query.append("       SEG_ACCES ACCESO, ");
			query.append("       V_GEN_I18N_SICC I18N ");
			query.append(" WHERE TSPAIS.TSOL_OID_TIPO_SOLI = TIPOSOLIC.OID_TIPO_SOLI ");
			if( dto.getOidOperacion() != null ){
				query.append("   AND tproceso.OPER_OID_OPER = " + dto.getOidOperacion() + " ");
				query.append("   AND tproceso.TSPA_OID_TIPO_SOLI_PAIS = tspais.OID_TIPO_SOLI_PAIS");
			}
			query.append("   AND TIPOSOLIC.ACCE_OID_ACCE = ACCESO.OID_ACCE ");
			query.append("   AND I18N.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
			query.append("   AND I18N.ATTR_NUM_ATRI = 1 ");
			query.append("   AND I18N.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
			query.append("   AND I18N.VAL_OID = TIPOSOLIC.OID_TIPO_SOLI ");
			if (dto.getOidMarca() != null) {
				query.append("   AND TIPOSOLIC.MARC_OID_MARC = " + dto.getOidMarca() + " ");
			}

			if (dto.getOidCanal() != null) {
				query.append("   AND ACCESO.CANA_OID_CANA = " + dto.getOidCanal() + " ");
			}

			if (dto.getOidTipoCliente() != null) {
				query.append("   AND TIPOSOLIC.TICL_OID_TIPO_CLIE = " + dto.getOidTipoCliente() + " ");
			}
            query.append(" ORDER BY DESCRIPCION ");

            RecordSet retorno = bs.dbService.executeStaticQuery(query.toString());

            // -> Devolver RecordSet obtenido en objeto DTOSalida 
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(retorno);
            UtilidadesLog.info("DAOPED.obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       02/08/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: Generada a partir de la incidencia 6841
     */
    public DTOSalida obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto): Entrada ");
        try {
            StringBuffer query = new StringBuffer();
            BelcorpService bs = BelcorpService.getInstance();

			//-> Hacer consulta JDBC sobre la tabla PED_TIPO_SOLIC_PROCE haciendo join 
			// con la tabla PED_TIPO_SOLIC_PAIS, esta a su vez con PED_TIPO_SOLIC, 
			// esta a su vez con SEG_ACCES obteniendo los campos PED_TIPO_SOLIC_PROCE.TPOS_OID_TIPO_POSI 
			// y descripción internacionalizada de tipo de posicion (tabla PED_TIPO_POSIC). 
			// Se filtrará por los siguientes campos: 
			// PED_TIPO_SOLIC_PROCE.TSPA_OID_TIPO_SOLI_PAIS = dto.oidTipoSolicitudPais 
			// PED_TIPO_SOLIC.MARC_OID_MARC = dto.oidMarca 
			// SEG_ACCES.CANA_OID_CANA = dto.oidCanal 
			// PED_TIPO_SOLIC.TICL_OID_TIPO_CLIE = dto.oidTipoCliente 
			// PED_TIPO_SOLIC_PROCE.OPER_OID_OPER = dto.oidOperacion 
			// -> Devolver RecordSet obtenido en objeto DTOSalida 

            query.append("SELECT TSPROCESO.TPOS_OID_TIPO_POSI OID, ");
            query.append("	     I18N.VAL_I18N DESCRIPCION");
            query.append("  FROM PED_TIPO_SOLIC_PROCE TSPROCESO, ");
            query.append("       PED_TIPO_SOLIC_PAIS TSPAIS, ");
            query.append("       PED_TIPO_SOLIC TIPOSOLIC, ");
            query.append("       SEG_ACCES ACCESO, ");
            query.append("       V_GEN_I18N_SICC I18N ");
            query.append(" WHERE TSPROCESO.TSPA_OID_TIPO_SOLI_PAIS = TSPAIS.OID_TIPO_SOLI_PAIS ");
            query.append("   AND TSPAIS.TSOL_OID_TIPO_SOLI = TIPOSOLIC.OID_TIPO_SOLI ");
            query.append("   AND TIPOSOLIC.ACCE_OID_ACCE = ACCESO.OID_ACCE ");
            query.append("   AND I18N.ATTR_ENTI = 'PED_TIPO_POSIC' ");
            query.append("   AND I18N.ATTR_NUM_ATRI = 1 ");
            query.append("   AND I18N.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append("   AND I18N.VAL_OID = TSPROCESO.TPOS_OID_TIPO_POSI ");

            if (dto.getOidTipoSolicitudPais() != null) {
                query.append(" AND TSPROCESO.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getOidTipoSolicitudPais() + " ");
            }

            if (dto.getOidMarca() != null) {
                query.append("   AND TIPOSOLIC.MARC_OID_MARC = " + dto.getOidMarca() + " ");
            }

            if (dto.getOidCanal() != null) {
                query.append("   AND ACCESO.CANA_OID_CANA = " + dto.getOidCanal() + " ");
            }

            if (dto.getOidTipoCliente() != null) {
                query.append("   AND TIPOSOLIC.TICL_OID_TIPO_CLIE = " + dto.getOidTipoCliente() + " ");
            }

            if (dto.getOidOperacion() != null) {
                query.append("   AND TSPROCESO.OPER_OID_OPER = " + dto.getOidOperacion() + " ");
            }

            query.append(" ORDER BY DESCRIPCION ");

            RecordSet retorno = bs.dbService.executeStaticQuery(query.toString());

            // -> Devolver RecordSet obtenido en objeto DTOSalida 
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(retorno);
            UtilidadesLog.info("DAOPED.obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto): Salida ");
            return dtoSalida;
        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOTipoSolicitudOP obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto) throws MareException {
        UtilidadesLog.info("DAOPED.obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            query.append("SELECT ");
            query.append(" B.oid_tipo_soli_pais tipoSolicitudPais, C.tpos_oid_tipo_posi tipoPosicion,  ");
            query.append(" C.stpo_oid_subt_posi subtipoPosicion ");
            query.append(" FROM ped_tipo_solic A, ped_tipo_solic_pais B, ped_tipo_solic_proce C ");
            query.append(" WHERE A.ticl_oid_tipo_clie = " + dto.getOidTipoCliente() + " AND  ");
            query.append("            A.marc_oid_marc = " + dto.getOidMarca() + " AND ");
            query.append("A.acce_oid_acce = " + dto.getOidAcceso() + " AND ");
            query.append(" B.tsol_oid_tipo_soli = A.oid_tipo_soli AND ");
            query.append(" B.pais_oid_pais = " + dto.getOidPais() + " AND ");
            query.append(" C.tspa_oid_tipo_soli_pais = B.oid_tipo_soli_pais ");
            if (dto.getOidOperacion()!=null){
                query.append(" AND c.OPER_OID_OPER = "+dto.getOidOperacion());
            }

            RecordSet retorno = bs.dbService.executeStaticQuery(query.toString());

            // -> Devolver RecordSet obtenido en objeto DTOSalida 
            if (!retorno.esVacio())
            {
              BigDecimal numero =new BigDecimal(1);
              if (retorno.getColumn(0).get(0)!=null){
                numero =(BigDecimal) retorno.getColumn(0).get(0);
                dto.setOidTipoSolicitud(new Long(numero.longValue()));
              }
              else {
                dto.setOidTipoSolicitud(null);
              }
              if (retorno.getColumn(1).get(0)!=null){
                numero =(BigDecimal) retorno.getColumn(1).get(0);
                dto.setOidTipoPosicion(new Long(numero.longValue()));  
              }
              else {
                dto.setOidTipoPosicion(null);
              }
              if (retorno.getColumn(2).get(0) !=null){
                numero =(BigDecimal) retorno.getColumn(2).get(0);
                dto.setOidSubtipoPosicion(new Long(numero.longValue()));  
              }
              else {
                dto.setOidSubtipoPosicion(null);
              }
            }
            else {
               
                throw new MareException (null, null , UtilidadesError.armarCodigoError( ConstantesPED.MODULO_PEDIDOS.toString(), "", ErroresNegocio.PED_027));
            }

            /* tipoSolicitudPais,tipoPosicion y subtipoPosicion*/
        } catch (MareMiiServiceNotFoundException me) {
            UtilidadesLog.error("MareMiiServiceNotFoundException: ",me);
            throw new MareException(me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPED.obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto): Salida ");
        return dto;
    }


  public RecordSet obtieneTipoSolicitudOperacion(Long pais) throws MareException {
    UtilidadesLog.info("DAOPED.obtieneTipoSolicitudOperacion(Long pais): Entrada ");
    BelcorpService bs;
    RecordSet respuesta;
    StringBuffer buf = new StringBuffer();
    String sqlWhere;
    try {
      bs = BelcorpService.getInstance();
    } 
    catch (MareException e) 
    {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try 
    {
      buf.append(" SELECT B.tsol_oid_tipo_soli tiposolicitud "); 
      buf.append(" FROM ped_tipo_solic_proce A, ped_tipo_solic_pais B "); 
      buf.append(" WHERE A.oper_oid_oper IN ( " +ConstantesBEL.INC020+" , "+ ConstantesBEL.INC030+ " , ");
      buf.append("  " + ConstantesBEL.INC040+" , "+ ConstantesBEL.INC050+ ") AND " ); 
      buf.append(" B.oid_tipo_soli_pais = A.tspa_oid_tipo_soli_pais AND " ); 
      buf.append(" B.pais_oid_pais = " +pais); 
      respuesta = bs.dbService.executeStaticQuery(buf.toString());
    } 
    catch (Exception e) 
    {
      throw new MareException(e,UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAOPED.obtieneTipoSolicitudOperacion(Long pais): Salida ");
    return respuesta;
    
  }

  public RecordSet obtieneTipoPosicionProceso() throws MareException {
    UtilidadesLog.info("DAOPED.obtieneTipoPosicionProceso(): Entrada ");
   BelcorpService bs;
    RecordSet respuesta;
    StringBuffer buf = new StringBuffer();
    String sqlWhere;
    try {
      bs = BelcorpService.getInstance();
    } 
    catch (MareException e) 
    {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try 
    {
      buf.append(" SELECT oid_proc proceso, tpos_oid_tipo_posi tipoposicion, stpo_oid_subt_posi subtipoposicion "); 
      buf.append(" FROM ped_proce  ") ;
      buf.append(" WHERE oid_proc IN ( "+ ConstantesProcesosPED.PROCESO_P205+", " + ConstantesProcesosPED.PROCESO_P210 );
      buf.append(" , "+ ConstantesProcesosPED.PROCESO_P215 +" , " + ConstantesProcesosPED.PROCESO_P235 + " ) " );

 
      respuesta = bs.dbService.executeStaticQuery(buf.toString());
    } 
    catch (Exception e) 
    {
      throw new MareException(e,UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAOPED.obtieneTipoPosicionProceso(): Salida ");
    return respuesta;
  }

  // Autor: ssantana, 18/11/2004
  // Motivo: Inc. 9737
  // Desc: Obtiene tuplas ["OidAcceso", "DescripcionAcceso"] para aquellos
  //       Accesos en SEG_ACCES con IND_ACCE = ConstantesPED.IND_ACCESO_BELCENTER ("B").
  public RecordSet obtieneAccesosBelcenter(DTOBelcorp dtoB) throws MareException  {
      UtilidadesLog.info("DAOPED.obtieneAccesosBelcenter(DTOBelcorp dtoB): Entrada ");
      RecordSet r = new RecordSet();

      StringBuffer sql = new StringBuffer(" SELECT s.OID_ACCE, v.VAL_I18N ");
      sql.append(" FROM SEG_ACCES s, v_gen_i18n_sicc v ");
      sql.append(" WHERE IND_ACCE = '" + ConstantesSEG.IND_ACCESO_BELCENTER + "' ");
      sql.append(" AND s.OID_ACCE = v.VAL_OID ");
      sql.append(" AND v.ATTR_ENTI = 'SEG_ACCES' ");
      sql.append(" and v.ATTR_NUM_ATRI = 1 ");
      sql.append(" and v.IDIO_OID_IDIO = " + dtoB.getOidIdioma().toString() );

      BelcorpService bs = null;
      try {
        bs = BelcorpService.getInstance();
        r = bs.dbService.executeStaticQuery(sql.toString());        
      } catch (MareMiiServiceNotFoundException mEx) {
          UtilidadesLog.error("MareMiiServiceNotFoundException");
          throw new MareException(mEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
      } catch (Exception ex) {
          UtilidadesLog.error("Exception");      
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
      }
      UtilidadesLog.info("DAOPED.obtieneAccesosBelcenter(DTOBelcorp dtoB): Salida ");
      return r;

  }

  // ****************************
  // Autor: ssantana
  // Incidencia: BELC300010413
  // ****************************
  public DTOSalida obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto) throws MareException {
      /* -> Hacer consulta JDBC sobre la tabla PED_TIPO_SOLIC_PROCE con las siguientes condiciones:
      -> Cruzar tabla PED_TIPO_SOLIC_PROCE con tabla PED_TIPO_SOLIC_PAIS
      -> Cruzar tabla PED_TIPO_SOLIC_PAIS con tabla PED_TIPO_SOLIC
      -> Cruzar tabla PED_TIPO_SOLIC con tabla SEG_ACCES
      -> PED_TIPO_SOLIC.MARC_OID_MARC = dto.oidMarca
      -> SEG_ACCES.CANA_OID_CANA = dto.oidCanal
      -> PED_TIPO_SOLIC.TICL_OID_TIPO_CLIE = dto.oidTipoCliente
      -> PED_TIPO_SOLIC_PROCE.OPER_OID_OPER = dto.oidOperacion
      -> Obtener los siguientes campos 
          - PED_TIPO_SOLIC_PROCE.TSPA_OID_TIPO_SOLI_PAIS
          - Descripcion internacionalizada de la tabla PED_TIPO_SOLIC_PROCE
      -> Devolver RecordSet obtenido encapsulado en un objeto DTOSalida  
      Nota: No se filtrará por un campo si el atributo del dto viene a NULL */
      UtilidadesLog.info("DAOPED.obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto): Entrada ");
      
      StringBuffer qSelect = new StringBuffer("");
      StringBuffer qWhere = new StringBuffer("");
      StringBuffer qFrom = new StringBuffer("");
      String sQueryCompleta = null;

      qSelect.append(" SELECT proceso.tspa_oid_tipo_soli_pais, v.val_i18n ");
      
      qFrom.append(" FROM ped_tipo_solic_proce proceso, ");
      qFrom.append(" ped_tipo_solic_pais pais, ");
      qFrom.append(" ped_tipo_solic solic, ");     
      qFrom.append(" seg_acces acceso, ");
      qFrom.append(" v_gen_i18n_sicc v ");

      qWhere.append(" WHERE proceso.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
      qWhere.append(" AND pais.tsol_oid_tipo_soli = solic.oid_tipo_soli ");
      qWhere.append(" AND solic.acce_oid_acce = acceso.oid_acce ");

      if (dto.getOidMarca() != null)
        qWhere.append(" AND solic.marc_oid_marc = " + dto.getOidMarca().toString() );

      if (dto.getOidCanal() != null)
        qWhere.append(" AND acceso.cana_oid_cana = " + dto.getOidCanal().toString() );

      if (dto.getOidTipoCliente() != null)
        qWhere.append(" AND solic.ticl_oid_tipo_clie = " + dto.getOidTipoCliente().toString() );

      if (dto.getOidOperacion() != null)
        qWhere.append(" AND proceso.oper_oid_oper = " + dto.getOidOperacion().toString() );

      qWhere.append(" AND v.attr_enti = 'PED_TIPO_SOLIC_PROCE' ");
      qWhere.append(" AND v.attr_num_atri = 1 ");
      qWhere.append(" AND v.val_oid = proceso.oid_tipo_soli_proc ");
      qWhere.append(" AND v.idio_oid_idio = " + dto.getOidIdioma().toString() );

      sQueryCompleta = qSelect.toString() + qFrom.toString() + qWhere.toString();

      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      DTOSalida dtoSalida = new DTOSalida();

      try {
        r = bs.dbService.executeStaticQuery( sQueryCompleta );
        UtilidadesLog.debug("RecordSet: " + r);
      } catch (Exception ex) {
        UtilidadesLog.error("Excepcion al consultar",ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOPED.obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto): Salida ");
      return dtoSalida;

/*select proceso.TSPA_OID_TIPO_SOLI_PAIS, v.VAL_I18N from PED_TIPO_SOLIC_PROCE proceso, PED_TIPO_SOLIC_PAIS pais, PED_TIPO_SOLIC solic, SEG_ACCES acceso, V_GEN_I18N_SICC v
where proceso.TSPA_OID_TIPO_SOLI_PAIS = pais.OID_TIPO_SOLI_PAIS
and pais.TSOL_OID_TIPO_SOLI = solic.OID_TIPO_SOLI
and solic.ACCE_OID_ACCE = acceso.OID_ACCE
and solic.MARC_OID_MARC = 1
and acceso.CANA_OID_CANA = 1
and solic.TICL_OID_TIPO_CLIE = 4
and proceso.OPER_OID_OPER = 1
and v.ATTR_ENTI(+) = 'PED_TIPO_SOLIC_PROCE'
and v.ATTR_NUM_ATRI(+) = 1
and v.VAL_OID(+) = proceso.OID_TIPO_SOLI_PROC
and v.IDIO_OID_IDIO(+) = 1*/
    //return null;
  }



  /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return  DTOSalida
   * @param DTOBelcorp dto
   */
  public DTOSalida obtieneClasesSolicitudOrdenCompra(DTOBelcorp dto) throws MareException  {
      /*
A través de DBService hace la siguiente consulta y devuelve el RecordSet encapsulado en un DTOSalida: 

SELECT 
c.oid_clas_soli as oid, 
descripcion según el idioma del dto de c.oid_clas_soli en V_GEN_I18N_SICC as descripcion 
FROM 
own_peru.ped_clase_solic c 
WHERE 
c.ind_orde_comp = ConstantesCMN.VAL_TRUE 

Devuelve un RecordSet con el resultado pares de (oid, descripcion) de cada clase de solicitud de orden de compra encapsulado en un DTOSalida.
 */

      UtilidadesLog.info("DAOPED.obtieneClasesSolicitudOrdenCompra(DTOBelcorp dto): Entrada ");
      StringBuffer query = new StringBuffer("");
      
      query.append(" SELECT c.oid_clas_soli as oid, v.VAL_I18N as descripcion");
      
      query.append(" FROM ped_clase_solic c, V_GEN_I18N_SICC v");
      query.append(" WHERE c.ind_orde_comp = ").append(es.indra.sicc.cmn.negocio.ConstantesCMN.VAL_TRUE);
      query.append(" AND v.IDIO_OID_IDIO = ").append(dto.getOidIdioma());     
      query.append(" AND v.val_oid = c.oid_clas_soli");
      query.append(" AND v.ATTR_ENTI = 'PED_CLASE_SOLIC'");
      query.append(" AND v.ATTR_NUM_ATRI = 1");

      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      DTOSalida dtoSalida = new DTOSalida();

      try {
        r = bs.dbService.executeStaticQuery( query.toString() );
        UtilidadesLog.debug("RecordSet: " + r);
      } catch (Exception ex) {
        UtilidadesLog.error("Excepcion al consultar",ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOPED.obtieneClasesSolicitudOrdenCompra(DTOBelcorp dto): Salida ");
      return dtoSalida;

  }
  
  //Incidencia 12368
  public DTOSalida consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto) throws MareException{
      UtilidadesLog.info("DAOPED.consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto): Entrada ");
      StringBuffer query = new StringBuffer("");
      
      query.append(" SELECT tp.oid_tipo_soli_pais oid, ");
      query.append("        i1.VAL_I18N as descripcion ");
      query.append("   FROM ped_tipo_solic_pais tp, ");
      query.append("        ped_tipo_solic t, ");
      query.append("        V_GEN_I18N_SICC i1 ");
      //query.append("  WHERE t.oid_tipo_soli = " + dto.getTipoSolicitud() + " "); 
      //query.append("    AND tp.pais_oid_pais = " + dto.getOidPais() + " "); 
      query.append("    WHERE tp.PAIS_OID_PAIS = " + dto.getOidPais() + " ");       
      query.append("    AND tp.IND_PERM_UNIO = 0  "); //dto.getPermiteUnionSolicitudes()
      query.append("    AND t.OID_TIPO_SOLI = tp.TSOL_OID_TIPO_SOLI ");
      query.append("    AND i1.VAL_OID = t.OID_TIPO_SOLI ");
      query.append("    AND i1.ATTR_ENTI = 'PED_TIPO_SOLIC'  ");
      query.append("    AND i1.ATTR_NUM_ATRI = 1  ");
      query.append("    AND i1.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");  

      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      DTOSalida dtoSalida = new DTOSalida();

      try {
        r = bs.dbService.executeStaticQuery( query.toString() );
        UtilidadesLog.debug("RecordSet: " + r);
      } catch (Exception ex){
        UtilidadesLog.error("Exception: ",ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOPED.consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto): Salida ");
      return dtoSalida;
  }
  
  public DTOSalida obtenerTipoSolicitudPorClase(DTOBelcorp dto) throws MareException{
      UtilidadesLog.info("DAOPED.obtenerTipoSolicitudPorClase(DTOBelcorp dto): Entrada ");
      StringBuffer query = new StringBuffer("");
      
      query.append(" select ped.CLSO_OID_CLAS_SOLI, ped.OID_TIPO_SOLI, gen_i18.VAL_I18N    ");
      query.append("   FROM ped_tipo_solic ped, gen_i18n_sicc gen_i18 ");
      query.append("    where  ped.OID_TIPO_SOLI = gen_i18.val_oid " );       
      query.append("    and    gen_i18.ATTR_ENTI = 'PED_TIPO_SOLIC'");
      query.append("    and    gen_i18.ATTR_NUM_ATRI = 1 ");
      query.append("    and    gen_i18.IDIO_OID_IDIO = " + dto.getOidIdioma());
      query.append("   order by 3 ");
      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      DTOSalida dtoSalida = new DTOSalida();

      try {
        r = bs.dbService.executeStaticQuery( query.toString() );
        UtilidadesLog.debug("RecordSet: " + r);
      } catch (Exception ex){
        UtilidadesLog.error("Exception ",ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOPED.obtenerTipoSolicitudPorClase(DTOBelcorp dto): Salida ");
      return dtoSalida;
  }


    /**
	 * rgiorgi - 25/08/2005: se modifica la query por incidencia FAC-01.
     * Recupera de BD información de cabecera y posición de solicitud, correspondiente 
     * a lineas faltantes no recuperadas en el proceso de facturación.
     * Esta información se retorna como una lista de objetos DTOCabeceraSolicitud, estructura que 
     * contiene los datos de la cabecera de solicitud, y una lista de objetos DTOPosicionSolicitud
     * @autor gdmarzi
     */
    public ArrayList obtenerLineasFaltantes(DTOFACProcesoCierre dtoProcesoCierre) throws MareException { 
        UtilidadesLog.info("DAOPED.obtenerLineasFaltantes  -- Entra"); 
        StringBuffer queryCabeceras = new StringBuffer(); 
        DTOTipoSolicitudProceso dtoTipoSolicitudProceso = new DTOTipoSolicitudProceso(); 
        RecordSet rsCabecerasSolicitud = new RecordSet(); 
        RecordSet rsPosiciones = new RecordSet(); 
        RecordSet rsFiltroPosicion = new RecordSet(); 

        /** 1.- Se obtienen las cabeceras de solicitud */ 
        queryCabeceras.append(" SELECT distinct "); 
        queryCabeceras.append("  SC.OID_SOLI_CABE as oid, "); 
        queryCabeceras.append("  SC.PAIS_OID_PAIS as pais, "); 
        queryCabeceras.append("  SC.VAL_NUME_SOLI as numeroSolicitud, "); 
        queryCabeceras.append("  SC.CLIE_OID_CLIE as oidCliente, "); 
        queryCabeceras.append("  SC.TICL_OID_TIPO_CLIE as tipoCliente, "); 
        queryCabeceras.append("  PE.MARC_OID_MARC as marca, "); 
        queryCabeceras.append("  PE.CANA_OID_CANA as canal, "); 
        queryCabeceras.append("  SUB.ACCE_OID_ACCE as acceso, "); 
        queryCabeceras.append("  SC.SBAC_OID_SBAC as subacceso, "); 
        queryCabeceras.append("  SC.PERD_OID_PERI as periodo, "); 
        queryCabeceras.append("  SC.MODU_OID_MODU modulo, "); 
        queryCabeceras.append("  SC.IND_PEDI_PRUE as indPedidoPrueba ");
        queryCabeceras.append(" FROM "); 
        queryCabeceras.append("  PED_SOLIC_CABEC SC, "); 
        queryCabeceras.append("  PED_TIPO_SOLIC_PAIS TSP, "); 
        queryCabeceras.append("  PED_TIPO_SOLIC TS, "); 
        queryCabeceras.append("  ZON_ZONA ZO, "); 
        queryCabeceras.append("  CRA_PERIO PE, "); 
        queryCabeceras.append("  ped_solic_posic po, "); 
        queryCabeceras.append("  SEG_SUBAC SUB ");   
        queryCabeceras.append(" WHERE "); 
        queryCabeceras.append("  SC.PAIS_OID_PAIS IS NOT NULL AND"); 
                queryCabeceras.append("  SUB.OID_SBAC = SC.SBAC_OID_SBAC AND "); 
                queryCabeceras.append("  po.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE and "); 
                queryCabeceras.append("  po.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND "); 
                queryCabeceras.append("  po.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_RECUPERACION +" AND "); 
        queryCabeceras.append("  po.IND_RECU_OBLI = " +  ConstantesCMN.VAL_TRUE + " AND "); 
        queryCabeceras.append("  TS.IND_ANUL = 0 "); 
        queryCabeceras.append("  AND TS.IND_DEVO = 0 "); 
        queryCabeceras.append("  AND SC.IND_OC = 1 ");  
        //Se agrega la siguente linea para que el proceso sea compatible con el cierre de zona y region
        //Autor: jpbosnjak
        if ( dtoProcesoCierre.getZona() != null ) { 
            queryCabeceras.append("  AND ZO.OID_ZONA = " + dtoProcesoCierre.getZona()); 
        }else if ( dtoProcesoCierre.getRegion() != null ) {         
            queryCabeceras.append("  AND ZO.ZORG_OID_REGI = " + dtoProcesoCierre.getRegion()); 
        } 
        queryCabeceras.append("  AND (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " + dtoProcesoCierre.getPeriodo() + " ) > PE.FEC_INIC "); 
        queryCabeceras.append("  AND SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS "); 
        queryCabeceras.append("  AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI "); 
        queryCabeceras.append("  AND SC.ZZON_OID_ZONA = ZO.OID_ZONA "); 
        queryCabeceras.append("  AND SC.PERD_OID_PERI = PE.OID_PERI "); 
        queryCabeceras.append(" ORDER BY "); 
        queryCabeceras.append("  SC.PAIS_OID_PAIS, PE.MARC_OID_MARC, PE.CANA_OID_CANA, "); 
        queryCabeceras.append("  SUB.ACCE_OID_ACCE, SC.SBAC_OID_SBAC, "); 
        queryCabeceras.append("  SC.TICL_OID_TIPO_CLIE, SC.CLIE_OID_CLIE "); 

        try { 
            rsCabecerasSolicitud = getBelcorpService().dbService.executeStaticQuery(queryCabeceras.toString()); 
        } catch(Exception e) { 
            e.printStackTrace(); 
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS)); 
        } 

        // Con cada registro obtenido de la sentencia anterior, construye un objeto DTOCabeceraSolicitud y lo añade a listaCabeceras. 
        ArrayList listaCabeceras = new ArrayList(); 
        for(int pos=0; pos < rsCabecerasSolicitud.getRowCount(); pos++) { 
            DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud(); 
            dtoCabeceraSolicitud.setOidCabeceraSolicitud(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "OID")).longValue())); 
            dtoCabeceraSolicitud.setOidPais(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "PAIS")).longValue())); 
            dtoCabeceraSolicitud.setNumeroDocumentoOrigen(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "NUMEROSOLICITUD")).longValue())); 
            dtoCabeceraSolicitud.setOidCliente(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "OIDCLIENTE")).longValue())); 
            dtoCabeceraSolicitud.setTipoCliente(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "TIPOCLIENTE")).longValue())); 
            dtoCabeceraSolicitud.setMarca(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "MARCA")).longValue())); 
            dtoCabeceraSolicitud.setCanal(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "CANAL")).longValue())); 
            
            BigDecimal indPedido = (BigDecimal)rsCabecerasSolicitud.getValueAt(pos,"INDPEDIDOPRUEBA");
            if (indPedido != null) { 
                if (new BigDecimal(1).equals(indPedido)) {
                    dtoCabeceraSolicitud.setIndPedidoPrueba(Boolean.TRUE); 
                } else {
                    dtoCabeceraSolicitud.setIndPedidoPrueba(Boolean.FALSE); 
                }
            } 

            if (rsCabecerasSolicitud.getValueAt(pos,"ACCESO") != null) { 
                dtoCabeceraSolicitud.setAcceso(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "ACCESO")).longValue())); 
            } 
            dtoCabeceraSolicitud.setSubacceso(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "SUBACCESO")).longValue())); 
            dtoCabeceraSolicitud.setPeriodo(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "PERIODO")).longValue())); 
            dtoCabeceraSolicitud.setModulo(new Long(((BigDecimal)rsCabecerasSolicitud.getValueAt(pos, "MODULO")).longValue())); 
            listaCabeceras.add(dtoCabeceraSolicitud); 
        } 

        /** 2.- Se obtienen los registros de posición */ 
        // Por cada cabecera de solicitud recuperada en el paso anterior, hay que obtener sus posiciones, 
        // creando objetos DTOPosicionSolicitud y asignándolos al atributo DTOCabeceraSolicitus.posiciones 
        Iterator iterCabeceras =  listaCabeceras.iterator(); 
        while( iterCabeceras.hasNext() ) { 
            DTOCabeceraSolicitud cabecera = (DTOCabeceraSolicitud)iterCabeceras.next(); 
            StringBuffer queryPosiciones = new StringBuffer(); 
            // Se ejecuta la consulta: 
            queryPosiciones.append(" SELECT "); 
            queryPosiciones.append("    OID_SOLI_POSI, ");   
            queryPosiciones.append("    COD_POSI, "); 
            queryPosiciones.append("    NUM_UNID_DEMA, "); 
            queryPosiciones.append("    NUM_UNID_POR_ATEN, "); 
            queryPosiciones.append("    TPOS_OID_TIPO_POSI, "); 
            queryPosiciones.append("    SP.PROD_OID_PROD, "); 
            queryPosiciones.append("    SP.FOPA_OID_FORM_PAGO, ");   
            queryPosiciones.append("    SP.VAL_CODI_VENT, "); 
            queryPosiciones.append("    ESPO_OID_ESTA_POSI, "); 
            queryPosiciones.append("    STPO_OID_SUBT_POSI, "); 
            queryPosiciones.append("    VAL_CODI_VENT_FICT, "); 
            queryPosiciones.append("    NUM_UNID_DEMA_REAL, "); 
            queryPosiciones.append("    VAL_PREC_CATA_UNIT_LOCA, "); 
            queryPosiciones.append("    VAL_PREC_CONT_UNIT_LOCA, "); 
            queryPosiciones.append("    VAL_PREC_CATA_UNIT_DOCU, "); 
            queryPosiciones.append("    VAL_PREC_CONTA_UNIT_DOCU, "); 
            queryPosiciones.append("    VAL_PORC_DESC, "); 
            queryPosiciones.append("    VAL_IMPO_DESC_UNIT_DOCU, "); 
            queryPosiciones.append("    SP.OFDE_OID_DETA_OFER, "); 
            queryPosiciones.append("    SOPO_OID_SOLI_POSI, "); 
            queryPosiciones.append("    NUM_UNID_COMPR, "); 
            queryPosiciones.append("    GEN.val_i18n as DP ");
            queryPosiciones.append(" FROM "); 
            queryPosiciones.append("    PED_SOLIC_POSIC SP, "); 
            queryPosiciones.append("    PRE_MATRI_FACTU_CABEC MFC, "); 
            queryPosiciones.append("    PRE_MATRI_FACTU MF, "); 
            queryPosiciones.append("    PRE_OFERT OFER, "); 
            queryPosiciones.append("    PRE_OFERT_DETAL OD, "); 
            queryPosiciones.append("    V_GEN_I18N_SICC GEN, ");
            queryPosiciones.append("    MAE_PRODU  PROD "); 
            queryPosiciones.append(" WHERE "); 
            queryPosiciones.append("    MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER ");   
            queryPosiciones.append("    AND SP.VAL_CODI_VENT = OD.VAL_CODI_VENT "); 
            queryPosiciones.append("    AND OD.OFER_OID_OFER = OFER.OID_OFER ");   
            queryPosiciones.append("    AND OFER.MFCA_OID_CABE = MFC.OID_CABE "); 
            queryPosiciones.append("    AND OFER.IND_RECU_OBLI = 1 ");   
            queryPosiciones.append("    AND SOCA_OID_SOLI_CABE = " + cabecera.getOidCabeceraSolicitud() ); 
            queryPosiciones.append("    AND MFC.PERD_OID_PERI = " + cabecera.getPeriodo() ); 
            
            //ssaavedr, ag. X inc.: DBLG400000966
            queryPosiciones.append(" AND PROD.OID_PROD = SP.PROD_OID_PROD "); 
            queryPosiciones.append(" AND (GEN.ATTR_ENTI = 'MAE_PRODU') ");
            queryPosiciones.append(" AND (GEN.ATTR_NUM_ATRI = 1) ");
            queryPosiciones.append(" AND (GEN.IDIO_OID_IDIO = " + dtoProcesoCierre.getOidIdioma().toString() + ") ");            
            queryPosiciones.append(" AND (GEN.VAL_OID = PROD.OID_PROD) ");
            
            /*if (cabecera.getAcceso() != null ) { 
                queryPosiciones.append("    AND OFER.ACCE_OID_ACCE = " + cabecera.getAcceso() ); 
            } 
            if (cabecera.getSubacceso() != null ) { 
                queryPosiciones.append("    AND OFER.SBAC_OID_SBAC = " + cabecera.getSubacceso() ); 
            }*/ 
            queryPosiciones.append("    ORDER BY SP.VAL_CODI_VENT "); 

            try { 
                rsPosiciones = getBelcorpService().dbService.executeStaticQuery(queryPosiciones.toString()); 
            } catch(Exception e) { 
                e.printStackTrace(); 
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS)); 
            } 

            // Con los registros obtenidos, se crean objetos DTOPosicionSolicitud y se asignan a cabecera.posiciones. 
            ArrayList listaPosiciones = new ArrayList(); 
            cabecera.setPosiciones(listaPosiciones); 
            for(int ubic=0; ubic < rsPosiciones.getRowCount(); ubic++) { 
                DTOPosicionSolicitud dtoPosicionSolicitud = new DTOPosicionSolicitud(); 
                dtoPosicionSolicitud.setOidPosicionSolicitud(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "OID_SOLI_POSI")).longValue())); 
                dtoPosicionSolicitud.setNumeroPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "COD_POSI")).longValue())); 
                dtoPosicionSolicitud.setUnidadesDemandadas(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "NUM_UNID_DEMA")).longValue())); 
                dtoPosicionSolicitud.setUnidadesPorAtender(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "NUM_UNID_POR_ATEN")).longValue())); 
                if (rsPosiciones.getValueAt(ubic, "TPOS_OID_TIPO_POSI") != null) { 
                    dtoPosicionSolicitud.setTipoPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "TPOS_OID_TIPO_POSI")).longValue())); 
                } 
                dtoPosicionSolicitud.setProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "PROD_OID_PROD")).longValue())); 
                if (rsPosiciones.getValueAt(ubic, "FOPA_OID_FORM_PAGO") != null) { 
                    dtoPosicionSolicitud.setFormaPago(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "FOPA_OID_FORM_PAGO")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_CODI_VENT") != null) { 
                    dtoPosicionSolicitud.setCodigoVenta((String)rsPosiciones.getValueAt(ubic, "VAL_CODI_VENT")); 
                } 
                if (rsPosiciones.getValueAt(ubic, "ESPO_OID_ESTA_POSI") != null) { 
                    dtoPosicionSolicitud.setEstadoPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "ESPO_OID_ESTA_POSI")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "STPO_OID_SUBT_POSI") != null) { 
                    dtoPosicionSolicitud.setSubtipoPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "STPO_OID_SUBT_POSI")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_CODI_VENT_FICT") != null) { 
                    dtoPosicionSolicitud.setCodigoVentaFicticio(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_CODI_VENT_FICT")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "NUM_UNID_DEMA_REAL") != null) { 
                    dtoPosicionSolicitud.setUnidadesDemandaReal(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "NUM_UNID_DEMA_REAL")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_PREC_CATA_UNIT_LOCA") != null) { 
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_PREC_CATA_UNIT_LOCA")); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_PREC_CONT_UNIT_LOCA") != null) { 
                    dtoPosicionSolicitud.setPrecioContableUnitarioLocal((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_PREC_CONT_UNIT_LOCA")); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_PREC_CATA_UNIT_DOCU") != null) { 
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioDocumento((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_PREC_CATA_UNIT_DOCU")); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_PREC_CONTA_UNIT_DOCU") != null) { 
                    dtoPosicionSolicitud.setPrecioContableUnitarioDocumento((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_PREC_CONTA_UNIT_DOCU")); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_PORC_DESC") != null) { 
                    dtoPosicionSolicitud.setPorcentajeDescuento(new Double(((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_PORC_DESC")).doubleValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "VAL_IMPO_DESC_UNIT_DOCU") != null) { 
                    dtoPosicionSolicitud.setImporteDescuentoUnitarioDocumento((BigDecimal)rsPosiciones.getValueAt(ubic, "VAL_IMPO_DESC_UNIT_DOCU")); 
                } 
                if (rsPosiciones.getValueAt(ubic, "OFDE_OID_DETA_OFER") != null) { 
                    dtoPosicionSolicitud.setOidDetalleOferta(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "OFDE_OID_DETA_OFER")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "SOPO_OID_SOLI_POSI") != null) { 
                    dtoPosicionSolicitud.setPosicionRecuperacion(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "SOPO_OID_SOLI_POSI")).longValue())); 
                } 
                if (rsPosiciones.getValueAt(ubic, "NUM_UNID_COMPR") != null) { 
                    dtoPosicionSolicitud.setUnidadesComprometidas(new Long(((BigDecimal)rsPosiciones.getValueAt(ubic, "NUM_UNID_COMPR")).longValue())); 
                } 
                
                //ssaavedr, ag. X inc.: DBLG400000966
                if (rsPosiciones.getValueAt(ubic, "DP") != null) { 
                    dtoPosicionSolicitud.setDescripcionProducto((String)rsPosiciones.getValueAt(ubic, "DP")); 
                } 
                
                listaPosiciones.add(dtoPosicionSolicitud); 
            } // Fin posiciones 
        } // Fin cabeceras 

        /** 
         * 3.- De las posiciones asignadas a cada cabecera, hay que filtrar aquellas que no cumplen la condición de que 
         * su indicador de recuperación automática está activo en la matriz de recuperación. Para ello, con cada posición 
         * de la cabecera se realiza la siguiente consulta, y si no se encuentra registro, se elimina la posición de 
         * cabecera.posiciones: 
         */ 
        Iterator iterCabObtenidas = listaCabeceras.iterator(); 
        while (iterCabObtenidas.hasNext()) { 
            DTOCabeceraSolicitud cabeceraObtenida = (DTOCabeceraSolicitud)iterCabObtenidas.next(); 
            Iterator iterPosObtenidas = cabeceraObtenida.getPosiciones().iterator(); 
            ArrayList posicionesFiltradas = new ArrayList();    // mantego solo las posciones segun el filtro del query 
            while (iterPosObtenidas.hasNext()) { 
                DTOPosicionSolicitud dtoPosicionObtenida = (DTOPosicionSolicitud)iterPosObtenidas.next(); 
                StringBuffer queryFiltro = new StringBuffer(); 
                queryFiltro.append(" SELECT "); 
                queryFiltro.append("   DO2.VAL_CODI_VENT  "); 
                queryFiltro.append(" FROM "); 
                queryFiltro.append("   PRE_MATRI_RECUP MR, "); 
                queryFiltro.append("   PRE_MATRI_FACTU MF1, "); 
                queryFiltro.append("   PRE_MATRI_FACTU_CABEC CMF1, "); 
                queryFiltro.append("   PRE_OFERT_DETAL DO1, "); 
                queryFiltro.append("   PRE_MATRI_FACTU MF2, "); 
                queryFiltro.append("   PRE_MATRI_FACTU_CABEC CMF2, "); 
                queryFiltro.append("   PRE_OFERT_DETAL DO2 "); 
                queryFiltro.append(" WHERE "); 
                queryFiltro.append("   MR.MAFA_OID_COD_RECU = MF1.OID_MATR_FACT ");   //--RECUPERACION 
                queryFiltro.append("   AND MF1.MFCA_OID_CABE = CMF1.OID_CABE "); 
                queryFiltro.append("   AND CMF1.PERD_OID_PERI = " + cabeceraObtenida.getPeriodo()); 
                queryFiltro.append("   AND DO1.VAL_CODI_VENT = '" + dtoPosicionObtenida.getCodigoVenta() + "' "); 
                queryFiltro.append("   AND MF1.OFDE_OID_DETA_OFER = DO1.OID_DETA_OFER "); 
                queryFiltro.append("   AND MR.IND_RECU_AUTO = 1 "); 
                queryFiltro.append("   AND DO1.VAL_CODI_VENT = '" + dtoPosicionObtenida.getCodigoVenta() + "' "); 
                queryFiltro.append("   AND MR.MAFA_OID_COD_PPAL = MF2.OID_MATR_FACT ");   //--ACTUAL 
                queryFiltro.append("   AND MR.MAFA_OID_COD_PPAL = MF2.OID_MATR_FACT "); 
                queryFiltro.append("   AND MF2.MFCA_OID_CABE = CMF2.OID_CABE "); 
                queryFiltro.append("   AND CMF2.PERD_OID_PERI = " + dtoProcesoCierre.getPeriodo()); 
                queryFiltro.append("   AND MF2.OFDE_OID_DETA_OFER = DO2.OID_DETA_OFER  "); 

                try { 
                    rsFiltroPosicion = getBelcorpService().dbService.executeStaticQuery(queryFiltro.toString()); 
                } catch(Exception e) { 
                    e.printStackTrace(); 
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS)); 
                } 
                // - si la sentencia anterior no retorna un registro, se elimina la posición actual 
                // de la cabecera, es decir, del ArrayList cabecera.posiciones. 
                /*if ( ! rsFiltroPosicion.esVacio()) { 
                    posicionesFiltradas.add(dtoPosicionObtenida); 
                } SCS modificado por inc.: BELC300022758*/
                
                if ( ! rsFiltroPosicion.esVacio()) {
                
                    if (rsFiltroPosicion.getValueAt(0, "VAL_CODI_VENT") != null) { 
                        dtoPosicionObtenida.setCodigoVentaActual((String)rsFiltroPosicion.getValueAt(0, "VAL_CODI_VENT"));                    }                 
                        posicionesFiltradas.add(dtoPosicionObtenida); 
                }

            } // Fin posición 
            //pisamos las posiciones de la cabecera con las que cumplen con el filtro 
            cabeceraObtenida.setPosiciones(posicionesFiltradas); 

        } // Fin listaCabeceras 
        UtilidadesLog.debug("listaCabeceras filtradas: " + listaCabeceras); 
        UtilidadesLog.info("DAOPED.obtenerLineasFaltantes  -- Sale"); 

        //Se retorna la lista de objetos DTOCabeceraSolicitud.     
        return listaCabeceras; 
    } 


    /**
     * Obtiene de BD un registro de TipoSolicitudPorPais(PED_TIPO_SOLIC_PROCE), con los 
     * criterios de búsqueda especificados en la cabecera de solicitud que recibe.
     * @autor gdmarzi
     */
    public DTOTipoSolicitudProceso obtenerTipoSolicitud(DTOCabeceraSolicitud cabecera) throws MareException {
        UtilidadesLog.info("DAOPED.obtenerTipoSolicitud(DTOCabeceraSolicitud cabecera): Entrada ");
        UtilidadesLog.debug("DTOCabeceraSolicitud: " + cabecera);
        BelcorpService bs = getBelcorpService();
        StringBuffer query = new StringBuffer();
        DTOTipoSolicitudProceso dtoTipoSolicitudProceso = new DTOTipoSolicitudProceso();
        RecordSet rsTipoSolicitud = new RecordSet();

        query.append(" SELECT ");
        query.append("  TSP.OID_TIPO_SOLI_PROC as oid,  ");
        query.append("  TSP.TSPA_OID_TIPO_SOLI_PAIS as tipoSolicitudPais, ");
        query.append("  TSP.TPOS_OID_TIPO_POSI as tipoPosicion, ");
        query.append("  TSP.STPO_OID_SUBT_POSI as subtipoPosicion ");
        query.append(" FROM ");
        query.append("  PED_TIPO_SOLIC_PROCE TSP, ");
        query.append("  PED_TIPO_SOLIC_PAIS TSPA, ");
        query.append("  PED_TIPO_SOLIC TS, ");
        query.append("  SEG_ACCES AC, ");
        query.append("  SEG_SUBAC SA, ");
        query.append("  SEG_MARCA MA ");
        query.append(" WHERE ");
        query.append("  TSP.TSPA_OID_TIPO_SOLI_PAIS = TSPA.OID_TIPO_SOLI_PAIS  ");
        query.append("  AND TSPA.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        query.append("  AND TS.SBAC_OID_SBAC = SA.OID_SBAC  ");
        query.append("  AND TS.ACCE_OID_ACCE = AC.OID_ACCE ");
        query.append("  AND TS.MARC_OID_MARC = MA.OID_MARC ");
        query.append("  AND TSPA.PAIS_OID_PAIS = " + cabecera.getOidPais());
        //query.append("  AND TSP.OPER_OID_OPER = " + ConstantesProcesosPED.PROCESO_P215);
        query.append("  AND TSP.OPER_OID_OPER = " + ConstantesBEL.PED215);
        
        if (cabecera.getMarca() != null) {
            query.append("  AND TS.MARC_OID_MARC = " + cabecera.getMarca());
        }
        if (cabecera.getSubacceso() != null) {
            query.append("  AND TS.SBAC_OID_SBAC = " + cabecera.getSubacceso());
        }
        if (cabecera.getTipoCliente() != null) {
            query.append("  AND TS.TICL_OID_TIPO_CLIE = " + cabecera.getTipoCliente());
        }

        //ejecutamos la consulta
        try {
            rsTipoSolicitud = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //Con el registro obtenido se construye un objeto DTOTipoSolicitudProceso y se retorna.
        if (rsTipoSolicitud.esVacio()) {
            dtoTipoSolicitudProceso = null;
        } else {
            dtoTipoSolicitudProceso.setOid(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0, "OID")).longValue()));
            dtoTipoSolicitudProceso.setTipoSolicitud(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0, "TIPOSOLICITUDPAIS")).longValue()));
            if (rsTipoSolicitud.getValueAt(0, "TIPOPOSICION") != null) {
                dtoTipoSolicitudProceso.setTipoPosicion(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0, "TIPOPOSICION")).longValue()));
            }
            if (rsTipoSolicitud.getValueAt(0, "SUBTIPOPOSICION") != null) {
                dtoTipoSolicitudProceso.setSubtipoPosicion(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0, "SUBTIPOPOSICION")).longValue()));
            }
        }
        UtilidadesLog.debug("dtoTipoSolicitudProceso: " + dtoTipoSolicitudProceso ); 
        UtilidadesLog.info("DAOPED.obtenerTipoSolicitud(DTOCabeceraSolicitud cabecera): Salida ");
        return dtoTipoSolicitudProceso;
    }
    
     public DTOSalida obtenerTipoSolicitudPaisREP(DTOBelcorp dto) throws MareException{
      UtilidadesLog.info("DAOPED.obtenerTipoSolicitudPaisREP(DTOBelcorp dto): Entrada ");
      StringBuffer query = new StringBuffer("");
      UtilidadesLog.info("** DAOPPed.obtenerTipoSolicitudPaisREP**");
      query.append(" SELECT   solipais.oid_tipo_soli_pais, descripcion.val_i18n ");
      query.append(" FROM ped_tipo_solic_pais solipais, ");
      query.append(" gen_i18n_sicc descripcion, ");
      query.append(" ped_tipo_solic tiposolic ");
      query.append(" WHERE solipais.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND solipais.tsol_oid_tipo_soli = tiposolic.oid_tipo_soli ");
      query.append(" AND tiposolic.oid_tipo_soli = descripcion.val_oid ");
      query.append(" AND descripcion.attr_enti = 'PED_TIPO_SOLIC' ");
      query.append(" AND descripcion.idio_oid_idio = " + dto.getOidIdioma());
      query.append(" ORDER BY 2 ");
      
      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      DTOSalida dtoSalida = new DTOSalida();

      try {
        r = bs.dbService.executeStaticQuery( query.toString() );
      } catch (Exception ex){
        UtilidadesLog.error("Exception ",ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOPED.obtenerTipoSolicitudPaisREP(DTOBelcorp dto): Salida ");
      return dtoSalida;
  }
  
    /**
     * Metodo que obtiene los Oids y NumSolic de las solicitud de servicio mayor e igual a la fecha dada
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param fecha
     * @param oidPais
     */
    public HashMap obtenerSolicitudesServicioEnGP4(Long oidPais, java.sql.Date fecha) throws MareException {
        UtilidadesLog.info("DAOPED.obtenerSolicitudesServicioEnGP4(Long oidPais, Date fecha) : Entrada");
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Vector parametros = new java.util.Vector();
        StringBuffer query = new StringBuffer();
        ArrayList Oids = new ArrayList();
        ArrayList NumeSoli = new ArrayList();
        HashMap resultado = new HashMap();
        
        query.append(" SELECT oid_soli_cabe, val_nume_soli ");
        query.append(" FROM ped_solic_cabec ");
        query.append(" WHERE ");
        query.append(" pais_oid_pais = ? ");
        parametros.add( oidPais );
        query.append(" AND tspa_oid_tipo_soli_pais in ( select tspa_oid_tipo_soli_pais from PED_TIPO_SOLIC_REVER_SOLIC ) ");
        query.append(" AND trunc(fec_prog_fact) >= trunc(to_date( '"+df.format(fecha)+"','dd/MM/yyyy')) ");
        query.append(" AND grpr_oid_grup_proc = "+ ConstantesPED.GP4);
        
        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executePreparedQuery(query.toString(), parametros);
            if (rs!=null && !rs.esVacio())  {
                for(int i=0; i<rs.getRowCount(); i++)   {
                    Oids.add( new Long(((BigDecimal)rs.getValueAt( i, 0)).longValue()) );
                    NumeSoli.add( new Long(((BigDecimal)rs.getValueAt( i, 1)).longValue()) );
                }
            }
        }catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        resultado.put("ListaOids", Oids);
        resultado.put("ListaNumeSoli", NumeSoli);
        UtilidadesLog.debug("Tamanio de lista de Oids: " + Oids.size() );
        UtilidadesLog.debug("Tamanio de lista de Numero Solicitud: " + NumeSoli.size() );
        UtilidadesLog.info("DAOPED.obtenerSolicitudesServicioEnGP4(Long oidPais, Date fecha) : Salida");
        return resultado;
    }
    
    /**
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * Modificado por Sapaza - Fecha 21/05/2010 - PER-SiCC-2010-0085 - Se agrego fec_repo_falt=null
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param oids
     */
    public void actualizarSolicitudesServicioGP3(ArrayList oids) throws MareException {
        UtilidadesLog.info("DAOPED.actualizarSolicitudesServicioGP3(ArrayList oids) : Entrada");
        java.util.Vector parametros = new java.util.Vector();
        StringBuffer upd = new StringBuffer();
        if (oids!=null && oids.size()>0)    {
            upd.append(" UPDATE ped_solic_cabec ");
            upd.append(" SET grpr_oid_grup_proc = " + ConstantesPED.GP3);
            upd.append(" , fec_repo_falt=null, proc_oid_proc = (select proc_oid_proc from ped_secue_proce where grpr_oid_grup_proc="+ ConstantesPED.GP3);
            upd.append("   and tspa_oid_tipo_soli_pais = ped_solic_cabec.tspa_oid_tipo_soli_pais) ");
            upd.append(" WHERE ");
            upd.append( generarFiltroOidSolicitudes( "OID_SOLI_CABE", oids) );
            
            try{
                BelcorpService.getInstance().dbService.executePreparedUpdate(upd.toString(), parametros);
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        else    {
            UtilidadesLog.info("No se actualiza las solicitudes servicio porque no existen OIDS de solicitudes");
        }
        UtilidadesLog.info("DAOPED.actualizarSolicitudesServicioGP3(ArrayList oids) : Salida");
    }
    
    /**
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @param oids
     */
    public void actualizarPosicionesSolicitudesServicio(ArrayList oids) throws MareException {
        UtilidadesLog.info("DAOPED.actualizarPosicionesSolicitudesServicio(ArrayList oids) : Entrada");
        if (oids!=null && oids.size()>0)    {
            java.util.Vector parametros = new java.util.Vector();
            StringBuffer upd = new StringBuffer();
            
            upd.append(" UPDATE ped_solic_posic ");
            upd.append(" SET num_unid_compr = num_unid_por_aten ");
            upd.append(" WHERE ");
            upd.append( generarFiltroOidSolicitudes( "SOCA_OID_SOLI_CABE", oids) );
            
            try{
                BelcorpService.getInstance().dbService.executePreparedUpdate(upd.toString(), parametros);
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
            //sapaza -- PER-SiCC-2010-0085 -- 21/05/2010            
            StringBuffer del = new StringBuffer();
            
            del.append(" DELETE FROM INC_BOLSA_FALTA ");
            del.append(" WHERE SOPO_OID_SOLI_POSI IN (SELECT OID_SOLI_POSI FROM PED_SOLIC_POSIC WHERE ");
            del.append( generarFiltroOidSolicitudes( "SOCA_OID_SOLI_CABE", oids) );
            del.append(" ) ");
            
            try{
                BelcorpService.getInstance().dbService.executePreparedUpdate(del.toString(), parametros);
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
        }
        else    {
            UtilidadesLog.info("No se actualiza en PED_SOLIC_POSIC porque no existen OIDS de solicitudes");
        }
        UtilidadesLog.info("DAOPED.actualizarPosicionesSolicitudesServicio(ArrayList oids) : Salida");
    }
    
    /**
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param numSolicitudes
     */
    public ArrayList obtenerOidsMovimBelCabec(ArrayList numSolicitudes) throws MareException {
        UtilidadesLog.info("DAOPED.obtenerOidsMovimBelCabec(ArrayList numSolicitudes) : Entrada");
        ArrayList Oids = new ArrayList();
        if (numSolicitudes!=null && numSolicitudes.size()>0)    {
            java.util.Vector parametros = new java.util.Vector();
            StringBuffer query = new StringBuffer();
            query.append(" SELECT DISTINCT mval_oid_movi_alma ");
            query.append(" FROM bel_movim_almac_detal ");
            query.append(" WHERE ");
            query.append( generarFiltroOidSolicitudes( "NUM_DOCU_REFE", numSolicitudes) );
            
            try{
                RecordSet rs = BelcorpService.getInstance().dbService.executePreparedQuery(query.toString(), parametros);
                if (rs!=null && !rs.esVacio())  {
                    for(int i=0; i<rs.getRowCount(); i++)   {
                        Oids.add( new Long(((BigDecimal)rs.getValueAt( i, 0)).longValue()) );
                    }
                }
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        else    {
            UtilidadesLog.info("No se puede obtener los OIDS de BEL_MOVIM_ALMAC_CABEC porque la lista de numeros de solicitudes esta vacía");
        }
        UtilidadesLog.info("DAOPED.obtenerOidsMovimBelCabec(ArrayList numSolicitudes) : Salida");
        return Oids;
    }
    
    /**
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @param oids
     */
    public void borrarMovimBelCabec(ArrayList oids) throws MareException {
        UtilidadesLog.info("DAOPED.borrarMovimBelCabec(ArrayList oids) : Entrada");
        if (oids!=null && oids.size()>0)  {
            java.util.Vector parametros = new java.util.Vector();
            StringBuffer upd = new StringBuffer();
            
            upd.append(" DELETE FROM bel_movim_almac_cabec WHERE ");
            upd.append( generarFiltroOidSolicitudes( "OID_MOVI_ALMA", oids) );
            
            try{
                BelcorpService.getInstance().dbService.executePreparedUpdate(upd.toString(), parametros);
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        else    {
            UtilidadesLog.info("No se borra en BEL_MOVIM_ALMAC_CABEC porque la lista de OIDS esta vacía");
        }
        UtilidadesLog.info("DAOPED.borrarMovimBelCabec(ArrayList oids) : Salida");
    }
    
    /**
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @param oids
     */
    public void borrarMovimBelDetal(ArrayList oids) throws MareException {
        UtilidadesLog.info("DAOPED.borrarMovimBelDetal(ArrayList oids) : Entrada");
        if (oids!=null && oids.size()>0)    {
            java.util.Vector parametros = new java.util.Vector();
            StringBuffer upd = new StringBuffer();
            
            upd.append(" DELETE FROM bel_movim_almac_detal WHERE ");
            upd.append( generarFiltroOidSolicitudes( "MVAL_OID_MOVI_ALMA", oids) );
            
            try{
                BelcorpService.getInstance().dbService.executePreparedUpdate(upd.toString(), parametros);
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        else    {
            UtilidadesLog.info("No se borra en BEL_MOVIM_ALMAC_DETAL porque la lista de OIDS esta vacía");
        }
        UtilidadesLog.info("DAOPED.borrarMovimBelDetal(ArrayList oids) : Salida");
    }
    
    /**
     * Agregado por HRCS - Fecha 25/07/2007 - Cambio Sicc20070303
     * @return 
     * @param solicitudes
     * @param columna
     */
    private StringBuffer generarFiltroOidSolicitudes(String columna, ArrayList solicitudes) {
        UtilidadesLog.info("DAOPED.generarFiltroOidSolicitudes(String columna, ArrayList solicitudes): Entrada ");
        Iterator it = solicitudes.iterator();
        StringBuffer query = new StringBuffer();      
        int count = 0;
        String oidsSolicitud = "";
        query.append("(");
        while (it.hasNext())    {
            Long oid = (Long) it.next();
            if (count == 0) {
               oidsSolicitud = oid.toString();
            } else {
               oidsSolicitud += "," + oid.toString();
            }
            if (count == 999)  {
               query.append(" "+ columna +" IN (" + oidsSolicitud.toString() + ") ");
               if (it.hasNext()){
                  query.append("  OR ");
               }
               count = 0;
            } else {
               if (!it.hasNext()){
                  query.append(" "+ columna +" IN (" + oidsSolicitud.toString() + ") ");
               }
               count++;            
            }
            if (!it.hasNext()){
              query.append(")");
            }
        }
        UtilidadesLog.info("DAOPED.generarFiltroOidSolicitudes(String columna, ArrayList solicitudes): Salida ");
        return query;
    }
    
   public StringBuffer desblCltes(long oidPais, long oidMarca) throws MareException {
      UtilidadesLog.info("DAOPED.desblCltes(long oidPais, long oidMarca): Entrada");
      StringBuffer query = new StringBuffer();
      
      String formatoFecha = new String("dd-MM-yyyy");
      DateFormat f =  new SimpleDateFormat(formatoFecha);
      
      query.append("UPDATE MAE_CLIEN_BLOQU SET FEC_DESB = to_date('" + f.format(new Date(System.currentTimeMillis())) + "','DD-MM-YYYY'), "); 
      query.append(" VAL_USUA_DESB = '" + user + "', ");
      query.append(" OBS_DESB = 'DesBloqueo por Monto Mínimo - Automático', ");
      query.append(" MAAB_OID_VALO_ACCI_DESB = " + this.obtOidIndDesblAut("A"));
      query.append(" WHERE CLIE_OID_CLIE IN ( ");
      query.append("SELECT mcb.CLIE_OID_CLIE FROM MAE_CLIEN_BLOQU mcb, ");
      query.append("MAE_CLIEN_MARCA mcm, MAE_TIPO_BLOQU mtb ");
      query.append("WHERE mtb.COD_TIPO_BLOQ = 'MM' ");
      query.append("AND mcb.CLIE_OID_CLIE IN ( ");
      query.append("SELECT mc.OID_CLIE ");
      query.append("FROM MAE_CLIEN mc ");
      query.append("WHERE mc.PAIS_OID_PAIS = " + oidPais + ") ");
      query.append("AND mcb.TIBQ_OID_TIPO_BLOQ = mtb.OID_TIPO_BLOQ ");
      query.append("AND mcb.FEC_DESB IS NULL ");
      query.append("AND mcm.MARC_OID_MARC = " + oidMarca);
      query.append(" AND mcm.CLIE_OID_CLIE IN (");
      query.append("SELECT mc.OID_CLIE ");
      query.append("FROM MAE_CLIEN mc ");
      query.append("WHERE mc.PAIS_OID_PAIS = " + oidPais + ") ");
      query.append("AND mcb.CLIE_OID_CLIE = mcm.CLIE_OID_CLIE)" + ";");
      
      UtilidadesLog.info("DAOPED.desblCltes(long oidPais, long oidMarca): Salida");
      return query;
      
   }    
   
   private long obtOidIndDesblAut(String codAutom) throws MareException {
      UtilidadesLog.info("DAOPED.obtOidIndDesbl(String codAutom) : Entrada");
      StringBuffer consulta = new StringBuffer();
      RecordSet resultado = null;
      
      consulta.append("SELECT OID_VALO_ACCI_BLOQ ");
      consulta.append("FROM MAE_VALOR_ACCIO_BLOQU mvab ");
      consulta.append("WHERE mvab.COD_VALO_BLOQ = '" + codAutom + "'");
      
      try {
          resultado = BelcorpService.getInstance().dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          UtilidadesLog.error(" Exception al ejecutar consulta en BBDD: " + e.getMessage());
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.debug("oid bloq. aut..: " + resultado);
      
      UtilidadesLog.info("DAOPED.obtOidIndDesbl(String codAutom): Salida");
      return ((BigDecimal)resultado.getValueAt(0,0)).longValue();
    }

  
/* Agregado por Brecha COL-BLO-001 ------ AL */
 public DTOPEDBloqueosClientes recuperarDatosBloqueos(Long oidPais) throws MareException {
   UtilidadesLog.info("DAOPED.recuperarDatosBloqueos(Long oidPais): Entrada"); 
   StringBuffer query = new StringBuffer();
   DTOPEDBloqueosClientes dtoBloqueos = new DTOPEDBloqueosClientes();
   
   query.append("SELECT ");
   query.append("  ( ");
   query.append("  SELECT SPIP.IND_EJMM ");
   query.append("  FROM SEG_PARAM_INTER_PAIS SPIP ");
   query.append("  WHERE SPIP.PAIS_OID_PAIS = " + oidPais );
   query.append("  ) IND_EJMM, ");
   query.append("  NVL(( ");
   query.append("   SELECT MTB.NUM_NIVE_GRAV_BLOQ "); 
   query.append("   FROM MAE_TIPO_BLOQU MTB ");
   query.append("   WHERE MTB.COD_TIPO_BLOQ = 'MM' ");
   query.append("  ), 0) NUM_NIVE_GRAV_BLOQ ");
   query.append("FROM DUAL ");
   
   RecordSet rs = null;
   rs = this.executeQuery(query.toString());
   
   if (rs != null && !rs.esVacio()) {
     dtoBloqueos.setIndicadorEjecMM(this.bigDecimalToBoolean(rs.getValueAt(0, "IND_EJMM")));   
     dtoBloqueos.setNivelGravedadBloqueo(this.bigDecimalToInteger(rs.getValueAt(0, "NUM_NIVE_GRAV_BLOQ")));
   }
   UtilidadesLog.info("DAOPED.recuperarDatosBloqueos(Long oidPais): Salida");
   return dtoBloqueos;
 }   

 public void realizarBloqueos(Long oidCliente, Integer nivelBloqueo) throws MareException {
   UtilidadesLog.info("DAOPED.recuperarDatosBloqueos(Long oidPais): Entrada"); 
   StringBuffer query = new StringBuffer();
   DTOPEDBloqueosClientes dtoBloqueos = new DTOPEDBloqueosClientes();
   
   query.append("SELECT MCB.OID_BLOQ, ");
   query.append("	    NVL(MTB.NUM_NIVE_GRAV_BLOQ, 999) - " + nivelBloqueo + " DIF_NIVEL "); 	    
   query.append("FROM MAE_CLIEN_BLOQU MCB, ");
   query.append("     MAE_TIPO_BLOQU MTB ");
   query.append("WHERE MCB.CLIE_OID_CLIE = " + oidCliente);
   query.append("  AND MCB.FEC_DESB IS NULL ");
   query.append("  AND MTB.OID_TIPO_BLOQ = MCB.TIBQ_OID_TIPO_BLOQ ");

   RecordSet rs = null;
   rs = this.executeQuery(query.toString());
   
   StringBuffer queryUpdate = new StringBuffer();
   if (rs != null && !rs.esVacio()) {
     if (this.bigDecimalToInteger(rs.getValueAt(0, "DIF_NIVEL")).intValue() > 0) {
        Long oidBloqueo = this.bigDecimalToLong(rs.getValueAt(0, "OID_BLOQ"));
        queryUpdate.append(this.armarStringDesbloqueo(oidBloqueo).toString());
        queryUpdate.append(this.armarStringBloqueo(oidCliente).toString());
        this.BloqueosIU(queryUpdate);
     }   
   } else {
     queryUpdate.append(this.armarStringBloqueo(oidCliente).toString());
     this.BloqueosIU(queryUpdate);
   }   
   UtilidadesLog.info("DAOPED.recuperarDatosBloqueos(Long oidPais): Salida");   
 }   

 private void BloqueosIU(StringBuffer queryUpdate) throws MareException {
   try{
      BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", queryUpdate.toString());
   }catch(Exception e){
      UtilidadesLog.error("ERROR",e);
      throw new MareException(e);
   }    
 }


 private StringBuffer armarStringDesbloqueo(Long oidBloqueo) {
    StringBuffer query = new StringBuffer();
    
    query.append("UPDATE MAE_CLIEN_BLOQU SET FEC_DESB = SYSDATE, VAL_USUA_DESB = '" + user + "'");
    query.append(", MAAB_OID_VALO_ACCI_DESB = (SELECT OID_VALO_ACCI_BLOQ FROM MAE_VALOR_ACCIO_BLOQU  WHERE COD_VALO_BLOQ = 'A') ");
    query.append(", OBS_DESB = 'Bloqueo por Monto Minimo - Automatico' WHERE OID_BLOQ = " + oidBloqueo + ";");
    
    return query;
 }  

 private StringBuffer armarStringBloqueo(Long oidCliente) {
    StringBuffer query = new StringBuffer();
    
    query.append("INSERT INTO MAE_CLIEN_BLOQU (OID_BLOQ, CLIE_OID_CLIE, TIBQ_OID_TIPO_BLOQ, FEC_BLOQ, VAL_USUA_BLOQ, VAL_MOTI_BLOQ, MAAB_OID_VALO_ACCI_BLOQ, OBS_BLOQ)"); 
    query.append("VALUES (MAE_CLBL_SEQ.NEXTVAL,  "+ oidCliente + ", (SELECT MTB.OID_TIPO_BLOQ FROM MAE_TIPO_BLOQU MTB WHERE MTB.COD_TIPO_BLOQ = 'MM'), SYSDATE, ");
    query.append("'" + user + "', 'Bloqueo por Monto Minimo - Automatico', (SELECT OID_VALO_ACCI_BLOQ FROM MAE_VALOR_ACCIO_BLOQU  WHERE COD_VALO_BLOQ = 'A'), ");
    query.append("'Bloqueo por Monto Minimo - Automatico');");
    
    return query;
 }  



 private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("DAOPED.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }       
    UtilidadesLog.info("DAOPED.executeQuery(String query): Salida");  
    return rs;
  }
  
  private Integer bigDecimalToInteger(Object numero) {    
    if (numero != null) {
      return new Integer(((BigDecimal) numero).intValue());
    } else {
      return null;
    }
  }
  
  private Boolean bigDecimalToBoolean(Object indicador) {    
    if (indicador != null) {
      if (((BigDecimal) indicador).intValue() == 1)  { 
         return Boolean.TRUE;
      } else {
         return Boolean.FALSE;           
      }           
    } else {
      return Boolean.FALSE;
    }
  }
  
  private Long bigDecimalToLong(Object numero) {    
    if (numero != null) {
      return new Long(((BigDecimal) numero).longValue());
    } else {
      return null;
    }
  }
/* Agregado por Brecha COL-BLO-001 ------ AL */

 public boolean existenciaMontoMinimo(DTOMontoMinimo dto, int i) throws MareException {
    UtilidadesLog.info("DAOPED.existenciaMontoMinimo(): Entrada"); 
    StringBuffer query = new StringBuffer();
    DTOPEDBloqueosClientes dtoBloqueos = new DTOPEDBloqueosClientes();
    
    query.append(" SELECT COUNT(*) ");
    query.append("   FROM PED_MONTO_MINIM P ");
    query.append("  WHERE P.TICL_OID_TIPO_CLIE = "+dto.getOidTipoCliente());
    if(dto.getOidSubtipoCliente()!=null){
       query.append("    AND P.SBTI_OID_SUBT_CLIE = "+dto.getOidSubtipoCliente());
    }else{
       query.append("    AND P.SBTI_OID_SUBT_CLIE IS NULL ");
    }
    if(dto.getOidTipoClasificacion()!=null){
       query.append("    AND P.TCCL_OID_TIPO_CLAS = "+dto.getOidTipoClasificacion());
    }else{
       query.append("    AND P.TCCL_OID_TIPO_CLAS IS NULL ");
    }
    if(dto.getOidClasificacion()!=null){
       query.append("    AND P.CLAS_OID_CLAS = "+dto.getOidClasificacion());
    }else{
       query.append("    AND P.CLAS_OID_CLAS IS NULL ");
    }
    if(dto.getOidRegiones()!=null){
       query.append("    AND P.ZORG_OID_REGI = "+dto.getOidRegiones().get(i));
    }else{
       query.append("    AND P.ZORG_OID_REGI IS NULL ");
    }
    if(dto.getOidZonas()!=null){
       query.append("    AND P.ZZON_OID_ZONA = "+dto.getOidZonas().get(i));
    }else{
       query.append("    AND P.ZZON_OID_ZONA IS NULL ");
    }

    RecordSet rs = null;
    rs = this.executeQuery(query.toString());
    UtilidadesLog.info("DAOPED.existenciaMontoMinimo(): Salida");  
    if (rs != null && !rs.esVacio()) {
      if(rs.getValueAt(0,0).toString().equals("0")){
         return false;
      }
    }
    return true;
   }   

    //sapaza -- cambio Optimizacion Reversa Solicitudes Servicio -- 12/05/2011
    public void reversarSolicitudesServicio(Long oidPais, java.sql.Date fecha) throws MareException {
        UtilidadesLog.info("DAOPED.reversarSolicitudesServicio((Long oidPais, java.sql.Date fecha): Entrada ");   
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        RecordSet rs;
        BelcorpService bs = getBelcorpService();

        try {
            ArrayList array = new ArrayList();
            array.add(oidPais.toString());
            array.add(df.format(fecha));
           
            bs.dbService.executeProcedure("PED_REVER_SOLIC_SERVI",array);
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.info("DAOPED.reversarSolicitudesServicio((Long oidPais, java.sql.Date fecha): Salida ");   
    }
   
}