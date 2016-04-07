package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mav.DTOAgrupacionEnvios;
import es.indra.sicc.dtos.mav.DTOECBRegistrosMAV;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.lang.StringBuffer;

import java.sql.*;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;


public class DAORegistrosMAV {
    public DAORegistrosMAV() {}

    public DTOSalida buscarEnviosMAVATC(DTOECBRegistrosMAV dto)
        throws MareException {
        
        UtilidadesLog.info("DAORegistrosMAV.buscarEnviosMAVATC(DTOECBRegistrosMAV dto):Entrada");
        StringBuffer sql = new StringBuffer("");

        StringBuffer sqlSelect = new StringBuffer(" SELECT detalle.TICL_OID_TIPO_CLIE, v_gen_i18n_sicc.val_i18n, ");
        sqlSelect.append(" mae_clien.cod_clie, ");
        sqlSelect.append(
            " mae_clien.val_ape1 || ' ' || mae_clien.val_ape2 || ' ' || mae_clien.val_nom1 || ' ' || mae_clien.val_nom2 AS fullname, ");
        sqlSelect.append(" tipo_despa.des_tipo_desp, envio.fec_entr, acti_tipo_despa.tdch_oid_tipo_desp, envio.fec_entr ");

        //sqlSelect.append(" tipo_despa.des_tipo_desp, envio.fec_entr ");    
        // Estas tablas van siempre. Luego se agregán otras mas adelante de acuerdo
        // a la existencia de ciertos valores. 
        StringBuffer sqlTablas = new StringBuffer(" FROM mav_envio envio, ");
        sqlTablas.append(" mav_activ_tipo_despa acti_tipo_despa, mav_tipo_despa tipo_despa, ");
        sqlTablas.append(" mav_detal_mav detalle, cra_perio perio, mae_clien, ");
        //sqlTablas.append(" v_mae_tipif_clien, v_gen_i18n_sicc ");
        sqlTablas.append(" v_gen_i18n_sicc ");

        // ----------------------------------------------------------------------------------
        // Arma parte de SQL correspondiente al bloque WHERE.
        StringBuffer sqlWhere = new StringBuffer("");
        /*    sqlWhere.append(" WHERE envio.acti_oid_acti = acti_tipo_despa.acti_oid_acti "); // Envio con Actividad
            sqlWhere.append(" AND acti_tipo_despa.tdch_oid_tipo_desp = tipo_despa.oid_tipo_desp ");*/
        sqlWhere.append(" WHERE envio.atde_oid_acti_tipo_desp = acti_tipo_despa.oid_acti_tipo_desp ");
        sqlWhere.append(" AND acti_tipo_despa.tdch_oid_tipo_desp = tipo_despa.oid_tipo_desp ");
        sqlWhere.append(" AND envio.denv_oid_deta_mav = detalle.oid_deta_mav "); // Periodo
        sqlWhere.append(" AND detalle.perd_oid_peri = perio.oid_peri ");

        if(dto.getOidMarca() != null)
            sqlWhere.append(" AND perio.marc_oid_marc = " + dto.getOidMarca());

        if(dto.getOidCanal() != null)
            sqlWhere.append(" AND perio.cana_oid_cana = " + dto.getOidCanal());

        sqlWhere.append(" AND perio.pais_oid_pais = " + dto.getOidPais());

        if(dto.getOidPeriodo() != null)
            sqlWhere.append(" AND perio.oid_peri = " + dto.getOidPeriodo());

        if(dto.getOidActividadMAV() != null)
            sqlWhere.append(" AND envio.acti_oid_acti = " + dto.getOidActividadMAV());

        if(dto.getOidTipoEstadoProceso() != null)
            sqlWhere.append(" AND envio.esen_oid_esta_envi = " + dto.getOidTipoEstadoProceso());

        if(dto.getEstadoEnvio() != null)
            sqlWhere.append(" AND envio.ind_envi = '" + dto.getEstadoEnvio() + "'");

        // Si Zonas, Regiones y Subgerencia Ventas son nulos, entonces no hay que 
        // incluir UnidadAdministrativa ni ninguna parte del codigo correspondiente a esto.
        ArrayList zonas = dto.getZona();
        ArrayList regiones = dto.getRegion();
        ArrayList subgV = dto.getSubgerencia();

        if((zonas != null) || (regiones != null) || (subgV != null)) {
            // Incluye la tabla corresp. en la parte de FROM 
            sqlTablas.append(", mav_detal_mav_unida_admin uadmin ");
            sqlWhere.append(" AND detalle.oid_deta_mav(+) = uadmin.denv_oid_deta_mav "); // Unidad Administrativa

            if((subgV != null) && (subgV.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < subgV.size(); i++) {
                    Long oidSubgV = (Long)subgV.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zsgv_oid_subg_vent = " + oidSubgV);
                }
                sqlWhere.append(" ) ");
                //sqlWhere.append(" or uadmin.zsgv_oid_subg_vent is null)");
            }

            // Regiones
            // --------
            if((regiones != null) && (regiones.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < regiones.size(); i++) {
                    Long oidRegiones = (Long)regiones.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zorg_oid_regi = " + oidRegiones);
                }

                sqlWhere.append(" ) ");
                //sqlWhere.append(" or uadmin.zorg_oid_regi is null)");
            }

            //    Zonas
            //    -----
            if((zonas != null) && (zonas.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < zonas.size(); i++) {
                    Long oidZona = (Long)zonas.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zzon_oid_zona = " + oidZona);
                }
                
                sqlWhere.append(" ) ");
                //sqlWhere.append(" or uadmin.zzon_oid_zona is null)");
            }
        }

        sqlWhere.append(" AND envio.clie_oid_clie = mae_clien.oid_clie "); // Cliente / Tipo Cliente
        //sqlWhere.append(" AND mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
        ArrayList cliente = dto.getTipoCliente();

        if(cliente != null) {
            sqlWhere.append(" AND ( ");

            for(int i = 0; i < cliente.size(); i++) {
                Long oidCliente = (Long)cliente.get(i);

                if(i != 0)
                    sqlWhere.append(" OR ");

                sqlWhere.append(" detalle.TICL_OID_TIPO_CLIE = " + oidCliente);
            }

            sqlWhere.append(" ) ");
        }

        //    sqlWhere.append(" AND v_mae_tipif_clien.ticl_oid_tipo_clie =  v_gen_i18n_sicc.val_oid "); // I18n Tipo Cliente
        sqlWhere.append(" AND detalle.TICL_OID_TIPO_CLIE =  v_gen_i18n_sicc.val_oid "); // I18n Tipo Cliente
        sqlWhere.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        sqlWhere.append(" AND v_gen_i18n_sicc.attr_enti = 'MAE_TIPO_CLIEN' ");
        sqlWhere.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dto.getOidIdioma());
        //    sqlWhere.append(" GROUP BY v_mae_tipif_clien.ticl_oid_tipo_clie, v_gen_i18n_sicc.val_i18n, ");
        sqlWhere.append(" GROUP BY detalle.TICL_OID_TIPO_CLIE, v_gen_i18n_sicc.val_i18n, ");
        sqlWhere.append(" mae_clien.cod_clie, mae_clien.val_ape1 || ' ' || mae_clien.val_ape2 || ' ' ");
        sqlWhere.append(
            " || mae_clien.val_nom1 || ' ' || mae_clien.val_nom2, acti_tipo_despa.tdch_oid_tipo_desp, tipo_despa.des_tipo_desp, ");
        //    sqlWhere.append(" envio.fec_entr ORDER  BY v_mae_tipif_clien.ticl_oid_tipo_clie ASC ");
        sqlWhere.append(" envio.fec_entr ORDER  BY detalle.TICL_OID_TIPO_CLIE ASC ");

        String queryCompleta = sqlSelect.toString() + sqlTablas.toString() + sqlWhere.toString();

        //    UtilidadesLog.debug("Query Completa: " + queryCompleta);
        BelcorpService bp = BelcorpService.getInstance();
        RecordSet resultado = null;

        try {
            resultado = bp.dbService.executeStaticQuery(queryCompleta);
        } catch(Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Cant. Registros: " + resultado.getRowCount());

        if(resultado.getRowCount() == 0)
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        else
            UtilidadesLog.debug("---- RecordSet: " + resultado);

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);

        UtilidadesLog.info("DAORegistrosMAV.buscarEnviosMAVATC(DTOECBRegistrosMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSalida buscarEnviosMAVATD(DTOECBRegistrosMAV dto)
        throws MareException {
        
        UtilidadesLog.info("DAORegistrosMAV.buscarEnviosMAVATD(DTOECBRegistrosMAV dto):Entrada");
        StringBuffer sql = new StringBuffer("");
        StringBuffer sqlSelect = new StringBuffer("");
        StringBuffer sqlFrom = new StringBuffer("");
        StringBuffer sqlWhere = new StringBuffer("");
        String queryCompleta = new String("");

        sqlSelect.append(" SELECT  acti_tipo_despa.tdch_oid_tipo_desp, tipo_despa.des_tipo_desp, ");
        sqlSelect.append(" mae_clien.cod_clie, mae_clien.val_ape1 || ' ' || mae_clien.val_ape2 || ' ' || mae_clien.val_nom1 ");
        sqlSelect.append(" || ' ' || mae_clien.val_nom2 AS fullname, v_gen_i18n_sicc.val_i18n, ");
        //sqlSelect.append(" || ' ' || mae_clien.val_nom2 AS fullname, v_gen_i18n_sicc.val_i18n, ");    
        sqlSelect.append(" envio.fec_entr, detalle.TICL_OID_TIPO_CLIE, envio.fec_entr ");

        sqlFrom.append(" FROM mav_envio envio, mav_activ_tipo_despa acti_tipo_despa, mav_tipo_despa tipo_despa, ");
        sqlFrom.append(" mav_detal_mav detalle, cra_perio perio, mae_clien, v_mae_tipif_clien, v_gen_i18n_sicc ");

        sqlWhere.append(" WHERE envio.atde_oid_acti_tipo_desp = acti_tipo_despa.oid_acti_tipo_desp ");
        sqlWhere.append(" AND acti_tipo_despa.tdch_oid_tipo_desp = tipo_despa.oid_tipo_desp ");

        ArrayList arrayTipoDespacho = dto.getTipoDespacho();

        if(arrayTipoDespacho != null) {
            for(int i = 0; i < arrayTipoDespacho.size(); i++) {
                if(i != 0)
                    sqlWhere.append(" OR ");

                if(i == 0) // Primer elemento - Agrega "AND (" para abrir parte de TipoDespacho.

                    sqlWhere.append(" AND ( ");

                sqlWhere.append(" acti_tipo_despa.tdch_oid_tipo_desp = " + arrayTipoDespacho.get(i));

                if(i == (arrayTipoDespacho.size() - 1)) // Ultimo elemento - Cierro ")"

                    sqlWhere.append(" ) ");
            }
        }

        sqlWhere.append(" AND envio.clie_oid_clie = mae_clien.oid_clie ");
        sqlWhere.append(" AND mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
        sqlWhere.append(" AND envio.denv_oid_deta_mav = detalle.oid_deta_mav ");
        sqlWhere.append(" AND detalle.perd_oid_peri = perio.oid_peri ");

        if(dto.getOidMarca() != null)
            sqlWhere.append(" AND perio.marc_oid_marc = " + dto.getOidMarca().toString());

        if(dto.getOidCanal() != null)
            sqlWhere.append(" AND perio.cana_oid_cana = " + dto.getOidCanal().toString());

        sqlWhere.append(" AND perio.pais_oid_pais = " + dto.getOidPais().toString());

        if(dto.getOidPeriodo() != null)
            sqlWhere.append(" AND perio.oid_peri = " + dto.getOidPeriodo().toString());

        if(dto.getOidActividadMAV() != null)
            sqlWhere.append(" AND envio.acti_oid_acti = " + dto.getOidActividadMAV().toString());

        if(dto.getOidTipoEstadoProceso() != null)
            sqlWhere.append(" AND envio.esen_oid_esta_envi = " + dto.getOidTipoEstadoProceso().toString());

        if(dto.getEstadoEnvio() != null)
            sqlWhere.append(" AND envio.ind_envi = '" + dto.getEstadoEnvio().toString() + "'");

        ArrayList zonas = dto.getZona();
        ArrayList subgV = dto.getSubgerencia();
        ArrayList regiones = dto.getRegion();

        if((zonas != null) || (subgV != null) || (regiones != null)) {
            // Incluye la tabla corresp. en la parte de FROM 
            sqlFrom.append(", mav_detal_mav_unida_admin uadmin ");
            sqlWhere.append(" AND detalle.oid_deta_mav(+) = uadmin.denv_oid_deta_mav "); // Unidad Administrativa

            if((subgV != null) && (subgV.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < subgV.size(); i++) {
                    Long oidSubgV = (Long)subgV.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zsgv_oid_subg_vent = " + oidSubgV);
                }
                sqlWhere.append(" ) ");
                //sqlWhere.append(" or uadmin.zsgv_oid_subg_vent is null)");
            }

            // Regiones
            // --------
            if((regiones != null) && (regiones.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < regiones.size(); i++) {
                    Long oidRegiones = (Long)regiones.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zorg_oid_regi = " + oidRegiones);
                }
                sqlWhere.append(" ) ");
                //sqlWhere.append(" or uadmin.zorg_oid_regi is null)");
            }

            //    Zonas
            //    -----
            if((zonas != null) && (zonas.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < zonas.size(); i++) {
                    Long oidZona = (Long)zonas.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zzon_oid_zona = " + oidZona);
                }
                sqlWhere.append(" ) ");
                //sqlWhere.append(" or uadmin.zzon_oid_zona is null)");
            }
        }

        sqlWhere.append(" AND detalle.TICL_OID_TIPO_CLIE = v_gen_i18n_sicc.val_oid ");
        sqlWhere.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        sqlWhere.append(" AND v_gen_i18n_sicc.attr_enti = 'MAE_TIPO_CLIEN' ");
        sqlWhere.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dto.getOidIdioma());
        sqlWhere.append(" group by detalle.TICL_OID_TIPO_CLIE, v_gen_i18n_sicc.val_i18n, ");
        sqlWhere.append(" mae_clien.cod_clie, mae_clien.val_ape1 || ' ' || mae_clien.val_ape2 || ' ' ");
        sqlWhere.append(" || mae_clien.val_nom1 || ' ' || mae_clien.val_nom2, ");
        sqlWhere.append(" acti_tipo_despa.tdch_oid_tipo_desp, tipo_despa.des_tipo_desp, ");
        sqlWhere.append(" envio.fec_entr ORDER BY acti_tipo_despa.tdch_oid_tipo_desp ASC ");

        queryCompleta = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();

        BelcorpService bp = BelcorpService.getInstance();
        RecordSet resultado = null;

        try {
            resultado = bp.dbService.executeStaticQuery(queryCompleta);
        } catch(Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Cant. Registros: " + resultado.getRowCount());

        if(resultado.getRowCount() == 0) {
            throw new MareException(new Exception(),
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } else { 
            UtilidadesLog.debug("---- RecordSet: " + resultado);
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);

        UtilidadesLog.info("DAORegistrosMAV.buscarEnviosMAVATD(DTOECBRegistrosMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSalida buscarEnviosMAVProductos(DTOECBRegistrosMAV dto)
        throws MareException {
        UtilidadesLog.info("DAORegistrosMAV.buscarEnviosMAVProductos(DTOECBRegistrosMAV dto):Entrada");
        String queryCompleta = "";
        StringBuffer sqlSelect = new StringBuffer("");
        StringBuffer sqlFrom = new StringBuffer("");
        StringBuffer sqlWhere = new StringBuffer("");

        sqlSelect.append(" SELECT mav_envio.oid_envi, mae_produ.cod_sap, mae_produ.des_cort, mav_detal_mav.num_unid_tota, ");
        sqlSelect.append(" bel_stock.val_sald, mae_clien.cod_clie, mae_clien.val_ape1 || ' ' ");
        sqlSelect.append(" || mae_clien.val_ape2 || ' ' || mae_clien.val_nom1 || ' ' || mae_clien.val_nom2 AS fullname, ");
        sqlSelect.append(" i18n.VAL_I18N, mav_crite_asign.des_crit_asig, ");
        sqlSelect.append(
            " mav_envio.fec_entr, mav_envio.num_unid, mav_envio.ind_envi, mav_envio.esen_oid_esta_envi, mav_detal_mav.ticl_oid_tipo_clie ");

        sqlFrom.append(" FROM mav_envio, pre_matri_factu, pre_ofert_detal, mae_produ, bel_stock, bel_almac, ");
        sqlFrom.append(" mav_param, bel_estad_merca, mav_detal_mav, mav_subcr_asign, mav_crite_asign, mav_activ_tipo_despa, ");
        sqlFrom.append(" mav_tipo_despa, mae_clien, cra_perio, v_gen_i18n_sicc i18n ");

        sqlWhere.append(" WHERE mav_envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact ");
        sqlWhere.append(" AND pre_matri_factu.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
        sqlWhere.append(" AND pre_ofert_detal.prod_oid_prod = mae_produ.oid_prod ");

        ArrayList arrayProd = dto.getProductos();

        if((arrayProd != null) && (arrayProd.size() != 0)) {
            for(int i = 0; i < arrayProd.size(); i++) {
                if(i == 0)
                    sqlWhere.append(" AND ( ");

                if(i != 0)
                    sqlWhere.append(" OR ");

                sqlWhere.append(" mae_produ.oid_prod = " + arrayProd.get(i).toString());

                if(i == (arrayProd.size() - 1))
                    sqlWhere.append(" ) ");
            }
        }

        sqlWhere.append(" AND mae_produ.oid_prod = bel_stock.prod_oid_prod ");
        sqlWhere.append(" AND mae_produ.oid_prod = bel_stock.prod_oid_prod ");
        sqlWhere.append(" AND bel_stock.almc_oid_alma = bel_almac.oid_alma ");
        sqlWhere.append(" AND bel_almac.oid_alma = mav_param.almc_oid_alma ");
        sqlWhere.append(" AND bel_stock.esme_oid_esta_merc = bel_estad_merca.oid_esta_merc ");
        sqlWhere.append(" AND bel_estad_merca.cod_esta = '" + ConstantesBEL.COD_EST_LIBRE_DISP + "' ");
        sqlWhere.append(" and BEL_ALMAC.PAIS_OID_PAIS = BEL_ESTAD_MERCA.PAIS_OID_PAIS ");
        sqlWhere.append(" AND mav_detal_mav.scas_oid_subc = mav_subcr_asign.oid_subc ");
        sqlWhere.append(" AND mav_subcr_asign.cras_oid_crit_asig = mav_crite_asign.oid_crit_asig ");
        sqlWhere.append(" AND mav_envio.denv_oid_deta_mav = mav_detal_mav.oid_deta_mav ");
        sqlWhere.append(" AND mav_envio.atde_oid_acti_tipo_desp = mav_activ_tipo_despa.OID_ACTI_TIPO_DESP ");
        sqlWhere.append(" AND mav_activ_tipo_despa.tdch_oid_tipo_desp = mav_tipo_despa.oid_tipo_desp ");
        sqlWhere.append(" AND mav_envio.clie_oid_clie = mae_clien.oid_clie ");
        sqlWhere.append(" AND mav_detal_mav.perd_oid_peri = cra_perio.oid_peri ");

        if(dto.getOidMarca() != null)
            sqlWhere.append(" AND cra_perio.marc_oid_marc = " + dto.getOidMarca().toString());

        if(dto.getOidCanal() != null)
            sqlWhere.append(" AND cra_perio.cana_oid_cana = " + dto.getOidCanal().toString());

        if(dto.getOidPais() != null)
            sqlWhere.append(" AND cra_perio.pais_oid_pais = " + dto.getOidPais().toString());

        if(dto.getOidPeriodo() != null)
            sqlWhere.append(" AND cra_perio.peri_oid_peri = " + dto.getOidPeriodo().toString());

        if(dto.getOidActividadMAV() != null)
            sqlWhere.append(" AND mav_envio.acti_oid_acti = " + dto.getOidActividadMAV().toString());

        if(dto.getOidTipoEstadoProceso() != null)
            sqlWhere.append(" AND mav_envio.esen_oid_esta_envi = " + dto.getOidTipoEstadoProceso().toString());

        if(dto.getEstadoEnvio() != null)
            sqlWhere.append(" AND mav_envio.ind_envi = '" + dto.getEstadoEnvio().toString() + "'"); // "P" o "E"

        ArrayList zonas = dto.getZona();
        ArrayList subgV = dto.getSubgerencia();
        ArrayList regiones = dto.getRegion();

        if((zonas != null) || (subgV != null) || (regiones != null)) {
            // Incluye la tabla corresp. en la parte de FROM 
            sqlFrom.append(", mav_detal_mav_unida_admin uadmin ");
            sqlWhere.append(" AND mav_detal_mav.oid_deta_mav = uadmin.denv_oid_deta_mav "); // Unidad Administrativa

            if((subgV != null) && (subgV.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < subgV.size(); i++) {
                    Long oidSubgV = (Long)subgV.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zsgv_oid_subg_vent = " + oidSubgV);
                }

                sqlWhere.append(" )");
            }

            // Regiones
            // --------
            if((regiones != null) && (regiones.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < regiones.size(); i++) {
                    Long oidRegiones = (Long)regiones.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zorg_oid_regi = " + oidRegiones);
                }

                sqlWhere.append(" )");
            }

            //    Zonas
            //    -----
            if((zonas != null) && (zonas.size() != 0)) {
                sqlWhere.append(" AND ( ");

                for(int i = 0; i < zonas.size(); i++) {
                    Long oidZona = (Long)zonas.get(i);

                    if(i != 0)
                        sqlWhere.append(" OR ");

                    sqlWhere.append(" uadmin.zzon_oid_zona = " + oidZona);
                }

                sqlWhere.append(" )");
            }
        }

        sqlWhere.append(" AND mav_detal_mav.ticl_oid_tipo_clie = i18n.val_oid ");
        sqlWhere.append(" AND i18n.attr_num_atri = 1 ");
        sqlWhere.append(" AND i18n.attr_enti = 'MAE_TIPO_CLIEN' ");
        sqlWhere.append(" AND i18n.idio_oid_idio = " + dto.getOidIdioma());
        sqlWhere.append(" ORDER BY mae_produ.cod_sap ");

        queryCompleta = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();

        BelcorpService bp = BelcorpService.getInstance();
        RecordSet resultado = null;

        try {
            /*      StringBuffer prueba = new StringBuffer(" SELECT   envio.oid_envi, bel_stock.* FROM mav_envio envio, ");
                  prueba.append(" pre_matri_factu, pre_ofert_detal, mae_produ, mav_param, bel_stock, bel_almac, bel_estad_merca ");
                  prueba.append(" WHERE envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact AND pre_matri_factu.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                  prueba.append(" AND pre_ofert_detal.prod_oid_prod = mae_produ.oid_prod AND mae_produ.oid_prod = bel_stock.prod_oid_prod  AND bel_stock.almc_oid_alma = bel_almac.oid_alma ");
                  prueba.append(" AND bel_almac.oid_alma = mav_param.almc_oid_alma AND bel_stock.esme_oid_esta_merc = bel_estad_merca.oid_esta_merc ");
                  prueba.append(" and bel_estad_merca.COD_ESTA = 'LD' ORDER BY oid_envi ");
                  RecordSet rPrueba = bp.dbService.executeStaticQuery( prueba.toString() );*/
            resultado = bp.dbService.executeStaticQuery(queryCompleta);
        } catch(Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Cant. Registros: " + resultado.getRowCount());

        if(resultado.getRowCount() == 0)
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        else
            UtilidadesLog.debug("---- RecordSet: " + resultado);

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);

        UtilidadesLog.info("DAORegistrosMAV.buscarEnviosMAVProductos(DTOECBRegistrosMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSalida detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto)
        throws MareException {
        UtilidadesLog.info("DAORegistrosMAV.detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto):Entrada");
        UtilidadesLog.debug("dtoEntrada: " + dto);
        StringBuffer query = new StringBuffer("");
        DTOSalida dtoSalida = new DTOSalida();
        String sFechaFormateada = null;

        if (dto.getFechaEntrega() != null) 
        {
          Timestamp fechaTemp = dto.getFechaEntrega();
          SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
          long fechaLong = fechaTemp.getTime();
  
          java.util.Date sqlDate = new java.util.Date(fechaTemp.getTime());
          sFechaFormateada = simpleDate.format(sqlDate);
          UtilidadesLog.debug("Fecha Formateada: " + sFechaFormateada);
        } else
        {
          UtilidadesLog.debug("Fecha de Entrega es NULL");          
        }

        query.append(" SELECT mav_envio.OID_ENVI, mae_produ.cod_sap, v1.val_i18n, mav_envio.num_unid, ");
        query.append(" mav_envio.ind_envi, mav_envio.esen_oid_esta_envi ");
        query.append(" FROM mav_envio, ");
        query.append(" pre_matri_factu, ");
        query.append(" pre_ofert_detal, ");
        query.append(" mae_produ, ");
        query.append(" v_gen_i18n_sicc v1, ");
        query.append(" mae_clien, ");
        query.append(" v_mae_tipif_clien, ");
        query.append(" mav_activ_tipo_despa ");
        // se cambia la parte de tipo de despacho, para que filtre por el oid (en la consulta 
        // buscarEnviosMAVATD se trae en realidad el oid de despacho, por lo que llega aca
        // en el dto es el oid, no el oid de mav_activ_tipo_despa como dice el DMCO
        query.append(" WHERE mav_envio.atde_oid_acti_tipo_desp = mav_activ_tipo_despa.OID_ACTI_TIPO_DESP ");
        query.append(" and mav_activ_tipo_despa.TDCH_OID_TIPO_DESP = " + dto.getOidTipoDespacho().toString() + " ");
        //      query.append(" WHERE mav_envio.atde_oid_acti_tipo_desp = " + dto.getOidTipoDespacho().toString() );
        if (dto.getFechaEntrega() != null)       
          query.append(" AND mav_envio.fec_entr = to_date('" + sFechaFormateada + "', 'YYYY-MM-DD') ");
        else
          query.append(" AND mav_envio.fec_entr IS NULL ");
          
        query.append(" AND mav_envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact ");
        query.append(" AND pre_matri_factu.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
        query.append(" AND pre_ofert_detal.prod_oid_prod = mae_produ.oid_prod ");
        query.append(" AND mae_produ.oid_prod = v1.val_oid ");
        query.append(" AND v1.attr_num_atri = 1 ");
        query.append(" AND v1.attr_enti = 'MAE_PRODU' ");
        query.append(" AND v1.idio_oid_idio = " + dto.getOidIdioma().toString());
        query.append(" AND mav_envio.clie_oid_clie = mae_clien.oid_clie ");
        query.append(" AND mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
        query.append(" AND mae_clien.pais_oid_pais = " + dto.getOidPais().toString());
        query.append(" AND mae_clien.cod_clie = '" + dto.getCodigoCliente().toString() + "' ");
        query.append(" AND v_mae_tipif_clien.ticl_oid_tipo_clie = " + dto.getOidTipoCliente().toString());

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = new RecordSet();

        try {
            r = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Exception al ejecutar query");
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("1");

        if(r.esVacio()) {
            UtilidadesLog.debug("1-1");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.debug("2");

        dtoSalida.setResultado(r);
        UtilidadesLog.debug("3");
        UtilidadesLog.debug("DToSalida: " + dtoSalida);
        UtilidadesLog.debug("100");
        UtilidadesLog.info("DAORegistrosMAV.detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto):Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerAgrupacionEnviosMAV(DTOAgrupacionEnvios dto)
        throws MareException {
        UtilidadesLog.info("DAORegistrosMAV.obtenerAgrupacionEnviosMAV(DTOAgrupacionEnvios dto):Entrada");
        StringBuffer sql = new StringBuffer("");
        DTOSalida dtoSalida = new DTOSalida();
        String fechaFormateada = null;

        if(dto.getFechaEntrega() != null)
            fechaFormateada = this.timestampToString(dto.getFechaEntrega(), "dd/MM/yyyy");

        //String fechaFormateada = this.timestampToString(dto.getFechaEntrega(), "dd/MM/yyyy");
        sql.append(" SELECT perio.pais_oid_pais, perio.marc_oid_marc, perio.cana_oid_cana ");
        sql.append(" FROM mav_envio envio, mae_clien cliente, ");
        sql.append(" v_mae_tipif_clien v_cliente, mav_detal_mav detallemav, cra_perio perio ");
        sql.append(" WHERE envio.atde_oid_acti_tipo_desp = " + dto.getOidTipoDespacho().toString() + " ");

        if(fechaFormateada == null)
            sql.append(" AND envio.fec_entr IS NULL ");
        else
            sql.append(" AND envio.fec_entr = TO_DATE('" + fechaFormateada + "', 'dd/MM/yyyy') ");

        sql.append(" AND envio.clie_oid_clie = cliente.oid_clie ");
        sql.append(" AND cliente.oid_clie = v_cliente.clie_oid_clie ");
        sql.append(" AND cliente.pais_oid_pais = " + dto.getOidPais().toString() + " ");
        sql.append(" AND cliente.cod_clie = '" + dto.getCodigoCliente() + "' ");
        sql.append(" AND v_cliente.ticl_oid_tipo_clie = " + dto.getOidTipoCliente().toString() + " ");
        sql.append(" AND envio.denv_oid_deta_mav = detallemav.oid_deta_mav ");
        sql.append(" AND detallemav.perd_oid_peri = perio.peri_oid_peri ");
        sql.append(" GROUP BY perio.pais_oid_pais, perio.marc_oid_marc, perio.cana_oid_cana ");

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;

        try {
            r = bs.dbService.executeStaticQuery(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(r);
        UtilidadesLog.info("DAORegistrosMAV.obtenerAgrupacionEnviosMAV(DTOAgrupacionEnvios dto):Salida");
        return dtoSalida;
    }

    private String timestampToString(Timestamp t, String formato)
        throws MareException {
        // Toma un Timestamp, y devuelve un String con la fecha formateada
        // segun <formato>
        UtilidadesLog.info("DAORegistrosMAV.timestampToString(Timestamp t, String formato):Entrada");        
        UtilidadesLog.debug("Fecha de entrada: " + t.toString());

        SimpleDateFormat simpleDate = new SimpleDateFormat(formato);
        java.util.Date dateTemp = new java.util.Date(t.getTime());
        String fechaFormateada = simpleDate.format(dateTemp);

        UtilidadesLog.debug("Fecha de salida: " + fechaFormateada);
        UtilidadesLog.info("DAORegistrosMAV.timestampToString(Timestamp t, String formato):Salida");        
        return fechaFormateada;
    }
}