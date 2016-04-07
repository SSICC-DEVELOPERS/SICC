package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.dtos.mav.DTOEBuscarActividadesMAV;
import es.indra.sicc.dtos.mav.DTOLineaCombo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;

import java.math.BigDecimal;

import java.util.Vector;


public class DAOActividadesMAV {
    private String usuario;

    public DAOActividadesMAV(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      MAV
     * Fecha:       09/08/2004
     * @version     2.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: Query modificado por nuevo campo en la base
     */
    public DTOSalida buscarActividades(DTOEBuscarActividadesMAV dto)
        throws MareException {
        UtilidadesLog.info("DAOActividadesMAV.buscarActividades(DTOEBuscarActividadesMAV dto):Entrada");        
        
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        String queryPaginada = null;

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        query.append("SELECT actividad.oid_acti OID, actividad.oid_acti codigo, i18n.val_i18n des, ");
        query.append("       marca.des_marc, i18n1.val_i18n canal");
        query.append("  FROM mav_activ actividad,");
        query.append("       v_gen_i18n_sicc i18n,");
        query.append("       v_gen_i18n_sicc i18n1,");
        query.append("       vca_seg_marca marca,");
        query.append("       vca_seg_canal canal");
        query.append(" WHERE actividad.pais_oid_pais = " + dto.getOidPais());
        query.append("   AND marca.cod_usua = '" + usuario + "'");
        query.append("   AND marca.oid_marc = actividad.marc_oid_marc");

        if(dto.getMarca() != null)
            query.append("   AND ACTIVIDAD.MARC_OID_MARC = " + dto.getMarca().toString());

        if(dto.getCodigo() != null)
            query.append("   AND ACTIVIDAD.OID_ACTI = " + dto.getCodigo().toString());

        query.append("   AND canal.cod_usua = '" + usuario + "'");
        query.append("   AND canal.oid_cana = actividad.cana_oid_cana");

        if(dto.getCanal() != null)
            query.append("   AND ACTIVIDAD.CANA_OID_CANA = " + dto.getCanal().toString());

        query.append("   AND i18n.attr_enti = 'MAV_ACTIV'");
        query.append("   AND i18n.attr_num_atri = 1");
        query.append("   AND i18n.idio_oid_idio = " + dto.getOidIdioma().toString());
        query.append("   AND i18n.val_oid = actividad.oid_acti");

        if(dto.getDescripcion() == null)
            dto.setDescripcion("");

        query.append("   AND i18n.val_i18n LIKE '%" + dto.getDescripcion() + "%'");
        query.append("   AND i18n1.attr_enti = 'SEG_CANAL'");
        query.append("   AND i18n1.attr_num_atri = 1");
        query.append("   AND i18n1.idio_oid_idio = " + dto.getOidIdioma());
        query.append("   AND i18n1.val_oid = actividad.cana_oid_cana");

        belcorpService = null;
        queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

        try {
            belcorpService = BelcorpService.getInstance();
            rSet = belcorpService.dbService.executeStaticQuery(queryPaginada);
            UtilidadesLog.debug("DAOActividadesMAV.buscarActividades - rSet: " + rSet);
        } catch(MareException me) {
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if(rSet.esVacio())
        {
            UtilidadesLog.debug("DAOActividadesMAV.buscarActividades - Rset Vacio");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        dtoSalida.setResultado(rSet);
        UtilidadesLog.debug("DAOActividadesMAV.buscarActividades - Retorno rSet");    
        UtilidadesLog.info("DAOActividadesMAV.buscarActividades(DTOEBuscarActividadesMAV dto):Salida");        
        return dtoSalida;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      MAV
     * Fecha:       10/08/2004
     * @version     2.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: Modificado para agregar filtrado por MARCA
     */
    public DTOSalida obtieneActividadesMAV(DTOActividadMAV dto)
        throws MareException {

        UtilidadesLog.info("DAOActividadesMAV.obtieneActividadesMAV(DTOActividadMAV dto):Entrada");

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        /* Modificacion por ssantana, 12/05/2006, inc. 23074 */
        /*query.append("SELECT   OID_ACTI OID, I18N.VAL_I18N DESCRIPCIONCORTA");
        query.append("    FROM MAV_ACTIV MA, V_GEN_I18N_SICC I18N");
        query.append("   WHERE MA.OID_ACTI = I18N.VAL_OID");
        query.append("     AND I18N.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("     AND I18N.ATTR_NUM_ATRI = 1");
        query.append("     AND I18N.ATTR_ENTI = 'MAV_ACTIV'");

        if(dto.getOidCanal() != null)
            query.append("     AND MA.CANA_OID_CANA = " + dto.getOidCanal());

        if(dto.getOidPais() != null)
            query.append("     AND MA.PAIS_OID_PAIS = " + dto.getOidPais());

        if(dto.getOidMarca() != null)
            query.append("     AND MA.MARC_OID_MARC = " + dto.getOidMarca() + " ");

        query.append("ORDER BY DESCRIPCIONCORTA");*/
        
        query.append(" SELECT   oid_acti OID, i18n.val_i18n descripcioncorta, ");
        query.append(" ind_fact_inte_comp ");
        query.append(" FROM mav_activ ma, v_gen_i18n_sicc i18n ");
        query.append(" WHERE ma.oid_acti = i18n.val_oid ");
        query.append(" AND i18n.idio_oid_idio = 1 ");
        query.append(" AND i18n.attr_num_atri = 1 ");
        query.append(" AND i18n.attr_enti = 'MAV_ACTIV' ");
        
        if(dto.getOidCanal() != null)
            query.append("     AND MA.CANA_OID_CANA = " + dto.getOidCanal());

        if(dto.getOidPais() != null)
            query.append("     AND MA.PAIS_OID_PAIS = " + dto.getOidPais());

        if(dto.getOidMarca() != null)
            query.append("     AND MA.MARC_OID_MARC = " + dto.getOidMarca() + " ");
        
        query.append(" ORDER BY descripcioncorta ");
        
        /* Fin Modificacion ssantana, 12/05/2006, inc. 23074*/ 

        belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rSet);
        } catch(MareException me) {
            throw me;
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOActividadesMAV.obtieneActividadesMAV(DTOActividadMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerParametrizacionMavPorTipoSubtipoCliente(DTOOIDs tiposCliente, DTOOIDs subtiposCliente)
        throws MareException {
        
        UtilidadesLog.info("DAOActividadesMAV.obtenerParametrizacionMavPorTipoSubtipoCliente(DTOOIDs tiposCliente, DTOOIDs subtiposCliente):Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;

        StringBuffer tiposClte = new StringBuffer();
        StringBuffer subTiposClte = new StringBuffer();

        Long[] oidsA = tiposCliente.getOids();
        Long[] oidsB = subtiposCliente.getOids();

        //armo 2 strings con el contenido de los oids, para el query
        for(int i = 0; i < oidsA.length; i++)
            tiposClte.append("'" + oidsA[i] + "', ");

        UtilidadesLog.debug("Quedo: " + tiposClte.toString());
        UtilidadesLog.debug("---------------------------------------------------------");

        for(int i = 0; i < oidsB.length; i++)
            //		subTiposClte.concat("'" + oidsB[i] + "', ");
            subTiposClte.append("'" + oidsB[i] + "', ");

        UtilidadesLog.debug("Quedo: " + subTiposClte.toString());
        UtilidadesLog.debug("---------------------------------------------------------");
        //mocho las comas finales
        String tiposClteAux = new String(tiposClte.substring(0, tiposClte.length() - 2));

        //  subTiposClteAux.concat(subTiposClteAux.substring(0, subTiposClteAux.length()-2));
        String subTiposClteAux = new String(subTiposClte.substring(0, subTiposClte.length() - 2));

        //	subTiposClteAux.concat(subTiposClte.substring(0, subTiposClte.length() - 2));
        //armo
        query.append("Select OID_PARA_MAV ");
        query.append("from MAV_PARAM mparam, MAV_PARAM_GEREN_REGIO mpgr, MAV_PARAM_GEREN_ZONA mpgz ");
        query.append("where mparam.TICL_OID_TIPO_CLIE_ZONA in (");
        query.append(tiposClteAux);
        query.append(") and ");
        query.append("mparam.TICL_OID_TIPO_CLIE_REGI in (");
        query.append(tiposClteAux);
		// MODIFICACION -------------------------------
		// Autor: Maximiliano Dello Russo (grusso).
		// Motivo: INC BELC300011000
		//
		/*        query.append("mpgr.OID_PARA_GERE_REGI = mparam.TICL_OID_TIPO_CLIE_REGI ");
        query.append("and mpgz.OID_PARA_GERE_ZONA = mparam.TICL_OID_TIPO_CLIE_ZONA ");
        query.append("and mpgr.SBTI_OID_SUBT_CLIE in (");
        query.append(subTiposClteAux);
        query.append(") and mpgz.SBTI_OID_SUBT_CLIE in (");
        query.append(subTiposClteAux);
        query.append(")");*/
        query.append(") and ( ");
        query.append(" (mpgr.PARM_OID_PARA_MAV = mparam.oid_para_mav and mpgr.sbti_oid_subt_clie IN ( ");
        query.append(subTiposClteAux);
        query.append(" )) or (");
        query.append(" mpgz.PARM_OID_PARA_MAV = mparam.oid_para_mav and mpgz.sbti_oid_subt_clie IN ( ");
        query.append(subTiposClteAux);
        query.append(" ))");
        query.append(" )");
    		// FIN MODIFICACION ---------------------------

		

        //    belcorpService = null;
        try {
            RecordSet rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rSet);
        } catch(MareException me) {
            throw me;
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("DAOActividadesMAV.obtenerParametrizacionMavPorTipoSubtipoCliente(DTOOIDs tiposCliente, DTOOIDs subtiposCliente):Salida");
        return dtoSalida;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      MAV
     * Fecha:       06/08/2004
     * @version     2.0
     * @autor       Maximiliano Dello Russo
     * Descripcion:
     */
    public DTOActividadMAV consultaActividad(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOActividadesMAV.consultaActividad(DTOOID dto):Entrada");
        DTOActividadMAV dtoActividad = new DTOActividadMAV();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;
        query.append("SELECT i18n_pais.val_i18n AS pais, i18n_actividad.val_i18n AS actividad, ");
        query.append("       actividad.des_deta, actividad.marc_oid_marc, marca.des_marc,");
        query.append("       actividad.cana_oid_cana AS oidcanal, i18n_canal.val_i18n AS canal,");
        query.append("       actividad.ticl_oid_tipo_clie AS oidtipocliente,");
        query.append("       i18n_tipo_cliente.val_i18n AS tipocliente,");
        // Cambio 1  x ssantana, 28/11/2004
//        query.append("       actividad.tspa_oid_tipo_soli_pais_dest oidtiposolicitud,");
//        query.append("       i18n_tiposolicitud.val_i18n AS tiposolicitud,");

        // Modificado x ssantana, 12/11/2004
        // Se corrige devolviendo el oid de Tipo Solicitud Pais en lugar del oid de Tipo 
        // Solicitud Proceso (la descripcion sigue siendo de PED_TIPO_SOLIC_PROCE, sin embargo).
        //query.append("       ped_tipo_solic_proce.oid_tipo_soli_proc oidtiposolicitud, ");
        query.append("       TSPAIS.OID_TIPO_SOLI_PAIS oidtiposolicpais, ");
        query.append("       (select val_i18n  from v_gen_i18n_sicc i ");
        query.append("       where i.attr_enti(+) = 'PED_TIPO_SOLIC_PROCE' ");
        query.append("       AND i.attr_num_atri(+) = 1 ");
        query.append("       AND i.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append(" 		   AND i.VAL_OID = ped_tipo_solic_proce.oid_tipo_soli_proc ");
        query.append("       ) tiposolicitud, ");
        // Fin cambio ssantana 1
        query.append("       actividad.tpos_oid_tipo_posi_dest oidtipoposicion, ");
        query.append("       i18n_tipoposicion.val_i18n AS tipoposicion,");
        query.append("       actividad.stpo_oid_subt_posi_envi AS oidsubtipoposcenvio,");
        query.append("       i18n_subtipoposcenvio.val_i18n AS subtipo_posc_envio,");
        query.append("       actividad.tcpa_oid_tipo_cond_pago,");
        query.append("       tipocondicionpago.des_tipo_cond_pago,");
        query.append("       actividad.fopa_oid_form_pago AS oidformapago,");
        query.append("       i18n_formapago.val_i18n AS formapago, actividad.val_camp_eval,");
        query.append("       actividad.ind_fact_inte_comp, actividad.val_porc_sobr_cost,");
        query.append("       actividad.soci_oid_soci, sociedad.val_deno AS sociedad,");
        query.append("       actividad.clie_oid_clie AS oidcliente, cliente.cod_clie codcliente,");
        query.append("       actividad.tspa_oid_tipo_soli_pais_pago AS oidtiposolicitudpaispago,");
        //modificado por eyache 18/03/2005
        // Corregida i18n por ssantana, 30/5/2005
        /*query.append(" (SELECT ");
        query.append(" a.val_i18n ");
        query.append(" FROM ");
        query.append(" v_gen_i18n_sicc a, ");
        query.append(" ped_tipo_solic b, ");
        query.append(" ped_tipo_solic_pais c, ");
        query.append(" mav_activ d ");
        query.append(" WHERE a.attr_enti (+) = 'PED_TIPO_SOLIC' ");
        query.append(" AND a.attr_num_atri (+)= 1 ");
        query.append(" AND a.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append(" AND a.val_oid (+) = b.OID_TIPO_SOLI ");
        query.append(" AND c.TSOL_OID_TIPO_SOLI  = b.OID_TIPO_SOLI(+) ");
        query.append(" and d.TSPA_OID_TIPO_SOLI_PAIS_PAGO = c.OID_TIPO_SOLI_PAIS(+) ");
        query.append(" AND d.oid_acti = " + dto.getOid().toString() + ") tiposolicitudpaispago, ");*/
        
        // Vuelvo a modificar por ssantana, provisorio por inc. BELC300019984
        // 19/7/2005
        query.append(" ( SELECT ");
        query.append(" i18n_tiposolicitudpago.val_i18n ");
        query.append(" FROM v_gen_i18n_sicc i18n_tiposolicitudpago, ");
        query.append(" mav_activ actividad, ");
        query.append(" ped_tipo_solic_proce ");
        query.append(" WHERE i18n_tiposolicitudpago.attr_enti(+) = 'PED_TIPO_SOLIC_PROCE' ");
        query.append(" AND i18n_tiposolicitudpago.attr_num_atri(+) = 1");
        query.append(" AND i18n_tiposolicitudpago.idio_oid_idio(+) = " + dto.getOidIdioma());
        query.append(" AND i18n_tiposolicitudpago.val_oid(+) =  ");
        query.append("                                      ped_tipo_solic_proce.oid_tipo_soli_proc ");
        query.append(" AND actividad.tspa_oid_tipo_soli_pais_pago = ");
        query.append("                                      ped_tipo_solic_proce.tspa_oid_tipo_soli_pais ");
        query.append(" AND actividad.oid_acti = " + dto.getOid());
        query.append(" AND ped_tipo_solic_proce.oper_oid_oper = ");
        query.append(                            ConstantesBEL.MAV023 + ") tiposolicitudpaispago,");
        // Fin modificacion ssantana, 19/7/2005, BELC300019984
        
        query.append("       actividad.tpos_oid_tipo_posi_pago AS oidtipoposicionpago,");
        query.append("       i18n_tipoposicionpago.val_i18n AS tipoposicionpago,");
        query.append("       actividad.stpo_oid_subt_posi_pago AS oidsubtipoposcpago,");
        query.append("       i18n_subtipoposcpago.val_i18n AS subtipoposcpago");
        query.append("  FROM mav_activ actividad,");
        query.append("       seg_marca marca,");
        query.append("       v_gen_i18n_sicc i18n_pais,");
        query.append("       v_gen_i18n_sicc i18n_actividad,");
        query.append("       v_gen_i18n_sicc i18n_canal,");
        query.append("       v_gen_i18n_sicc i18n_tipo_cliente,");
        query.append("       v_gen_i18n_sicc i18n_tiposolicitud,");
        query.append("       v_gen_i18n_sicc i18n_tipoposicion,");
        query.append("       v_gen_i18n_sicc i18n_subtipoposcenvio,");
        query.append("       mav_tipo_condi_pago tipocondicionpago,");
        query.append("       v_gen_i18n_sicc i18n_formapago,");
        query.append("       seg_socie sociedad,");
        query.append("       mae_clien cliente,");
       // query.append("       v_gen_i18n_sicc i18n_tiposolicitudpago,");
        query.append("       v_gen_i18n_sicc i18n_tipoposicionpago,");
        query.append("       v_gen_i18n_sicc i18n_subtipoposcpago,");
        query.append("		 PED_TIPO_SOLIC TIPOSOLIC,");
        query.append("       PED_TIPO_SOLIC_PAIS TSPAIS, ");
        // Se agrega ped_tipo_solic_proce, ssantana, 28/11/2004"
        query.append("  ped_tipo_solic_proce ");
        
        query.append(" WHERE actividad.oid_acti = " + dto.getOid().toString() + " ");
        query.append("   AND marca.oid_marc(+) = actividad.marc_oid_marc");
        query.append("   AND tipocondicionpago.oid_tipo_cond_pago(+) = actividad.tcpa_oid_tipo_cond_pago");
        query.append("   AND sociedad.oid_soci(+) = actividad.soci_oid_soci");
        query.append("   AND cliente.oid_clie(+) = actividad.clie_oid_clie");
        query.append("   AND i18n_pais.attr_enti(+) = 'SEG_PAIS'");
        query.append("   AND i18n_pais.attr_num_atri(+) = 1");
        query.append("   AND i18n_pais.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_pais.val_oid(+) = actividad.pais_oid_pais");
        query.append("   AND i18n_actividad.attr_enti(+) = 'MAV_ACTIV'");
        query.append("   AND i18n_actividad.attr_num_atri(+) = 1");
        query.append("   AND i18n_actividad.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_actividad.val_oid(+) = actividad.oid_acti");
        query.append("   AND i18n_canal.attr_enti(+) = 'SEG_CANAL'");
        query.append("   AND i18n_canal.attr_num_atri(+) = 1");
        query.append("   AND i18n_canal.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_canal.val_oid(+) = actividad.cana_oid_cana");
        query.append("   AND i18n_tipo_cliente.attr_enti(+) = 'MAE_TIPO_CLIEN'");
        query.append("   AND i18n_tipo_cliente.attr_num_atri(+) = 1");
        query.append("   AND i18n_tipo_cliente.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_tipo_cliente.val_oid(+) = actividad.ticl_oid_tipo_clie");
        query.append("   AND i18n_tiposolicitud.attr_enti(+) = 'PED_TIPO_SOLIC'");
        query.append("   AND i18n_tiposolicitud.attr_num_atri(+) = 1");
        query.append("   AND i18n_tiposolicitud.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   and tspais.OID_TIPO_SOLI_PAIS(+) = actividad.TSPA_OID_TIPO_SOLI_PAIS_DEST");
        //query.append("   and TSPAIS.TSOL_OID_TIPO_SOLI(+) = TIPOSOLIC.OID_TIPO_SOLI");
        query.append("   and TIPOSOLIC.OID_TIPO_SOLI(+) = TSPAIS.TSOL_OID_TIPO_SOLI");
        // Se agrega la sig. linea, ssantana, 28/11/2004
        query.append("   AND ped_tipo_solic_proce.tspa_oid_tipo_soli_pais(+) = tspais.oid_tipo_soli_pais ");
        query.append("   AND i18n_tiposolicitud.val_oid(+) = tiposolic.OID_TIPO_SOLI");
        query.append("   AND i18n_tipoposicion.attr_enti(+) = 'PED_TIPO_POSIC'");
        query.append("   AND i18n_tipoposicion.attr_num_atri(+) = 1");
        query.append("   AND i18n_tipoposicion.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_tipoposicion.val_oid(+) = actividad.tpos_oid_tipo_posi_dest");
        query.append("   AND i18n_subtipoposcenvio.attr_enti(+) = 'PED_SUBTI_POSIC'");
        query.append("   AND i18n_subtipoposcenvio.attr_num_atri(+) = 1");
        query.append("   AND i18n_subtipoposcenvio.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_subtipoposcenvio.val_oid(+) = actividad.stpo_oid_subt_posi_envi");
        query.append("   AND i18n_formapago.attr_enti(+) = 'BEL_FORMA_PAGO'");
        query.append("   AND i18n_formapago.attr_num_atri(+) = 1");
        query.append("   AND i18n_formapago.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_formapago.val_oid(+) = actividad.fopa_oid_form_pago");
        /*query.append("   AND i18n_tiposolicitudpago.attr_enti(+) = 'PED_TIPO_SOLIC'");
        query.append("   AND i18n_tiposolicitudpago.attr_num_atri(+) = 1");
        query.append("   AND i18n_tiposolicitudpago.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND I18N_TIPOSOLICITUDPAGO.VAL_OID(+) = TIPOSOLIC.OID_TIPO_SOLI");*/
        query.append("   AND i18n_tipoposicionpago.attr_enti(+) = 'PED_TIPO_POSIC'");
        query.append("   AND i18n_tipoposicionpago.attr_num_atri(+) = 1");
        query.append("   AND i18n_tipoposicionpago.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_tipoposicionpago.val_oid(+) = actividad.tpos_oid_tipo_posi_pago");
        query.append("   AND i18n_subtipoposcpago.attr_enti(+) = 'PED_SUBTI_POSIC'");
        query.append("   AND i18n_subtipoposcpago.attr_num_atri(+) = 1");
        query.append("   AND i18n_subtipoposcpago.idio_oid_idio(+) = " + dto.getOidIdioma().toString() + " ");
        query.append("   AND i18n_subtipoposcpago.val_oid(+) = actividad.stpo_oid_subt_posi_pago");

        try {
            bs = BelcorpService.getInstance();
            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());

            if(rs.esVacio()) {
                UtilidadesLog.debug("ES VACIO");
                UtilidadesLog.info("DAOActividadesMAV.consultaActividad(DTOOID dto):Salida");                
                return dtoActividad;
            }

            UtilidadesLog.debug("---- SETEANDO DTO");
            UtilidadesLog.debug("RECORDSET: " + rs.toString());
            dtoActividad.setOidPais(dto.getOidPais());
            dtoActividad.setOidActividad(dto.getOid());
            // Falta mapear la descripcion del pais, pero el DTO no tiene dicho atributo.  Esperando
            // respuesta de la incidencia 7401.
            dtoActividad.setDescripcionPais((String)rs.getValueAt(0, "PAIS"));
            dtoActividad.setDescripcion((String)rs.getValueAt(0, "ACTIVIDAD"));
            dtoActividad.setDescripcionDetallada((String)rs.getValueAt(0, "DES_DETA"));
            BigDecimal valor = (BigDecimal)rs.getValueAt(0, "MARC_OID_MARC");

            if(valor != null)
                dtoActividad.setOidMarca(new Long(valor.longValue()));

            dtoActividad.setDescripcionMarca((String)rs.getValueAt(0, "DES_MARC"));
            UtilidadesLog.debug("MARCA: " + dtoActividad.getDescripcionMarca());
            valor = (BigDecimal)rs.getValueAt(0, "OIDCANAL");

            if(valor != null)
                dtoActividad.setOidCanal(new Long(valor.longValue()));

            dtoActividad.setDescripcionCanal((String)rs.getValueAt(0, "CANAL"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDTIPOCLIENTE");

            if(valor != null)
                dtoActividad.setOidTipoCliente(new Long(valor.longValue()));

            dtoActividad.setDescripcionTipoCliente((String)rs.getValueAt(0, "TIPOCLIENTE"));
            valor = (BigDecimal)rs.getValueAt(0, 9);

            if(valor != null)
                dtoActividad.setOidTipoSolicitudDestino(new Long(valor.longValue()));

            dtoActividad.setDescripcionTipoSolicitudDestino((String)rs.getValueAt(0, "TIPOSOLICITUD"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDTIPOPOSICION");

            if(valor != null)
                dtoActividad.setOidTipoPosicionEnvio(new Long(valor.longValue()));

            dtoActividad.setDescripcionTipoPosicionEnvio((String)rs.getValueAt(0, "TIPOPOSICION"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDSUBTIPOPOSCENVIO");

            if(valor != null)
                dtoActividad.setOidSubtipoPosicionEnvio(new Long(valor.longValue()));

            dtoActividad.setDescripcionSubtipoPosicionEnvio((String)rs.getValueAt(0, "SUBTIPO_POSC_ENVIO"));
            valor = (BigDecimal)rs.getValueAt(0, "TCPA_OID_TIPO_COND_PAGO");

            if(valor != null)
                dtoActividad.setOidTipoCondicionPago(new Long(valor.longValue()));

            dtoActividad.setDescripcionTipoCondicionPago((String)rs.getValueAt(0, "DES_TIPO_COND_PAGO"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDFORMAPAGO");

            if(valor != null)
                dtoActividad.setOidFormaPago(new Long(valor.longValue()));

            dtoActividad.setDescripcionFormaPago((String)rs.getValueAt(0, "FORMAPAGO"));
            valor = (BigDecimal)rs.getValueAt(0, "VAL_CAMP_EVAL");

            if(valor != null)
                dtoActividad.setCampagnaEvaluacion(new Integer(valor.intValue()));

            valor = (BigDecimal)rs.getValueAt(0, "IND_FACT_INTE_COMP");

            if(valor != null)
                dtoActividad.setFacturaIntercompanias(new Boolean(valor.intValue() == 1));

            valor = (BigDecimal)rs.getValueAt(0, "VAL_PORC_SOBR_COST");

            if(valor != null)
                dtoActividad.setCosto(new Integer(valor.intValue()));

            valor = (BigDecimal)rs.getValueAt(0, "SOCI_OID_SOCI");

            if(valor != null)
                dtoActividad.setOidEmpresa(new Long(valor.longValue()));

            dtoActividad.setDescripcionEmpresa((String)rs.getValueAt(0, "SOCIEDAD"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDCLIENTE");

            if(valor != null)
                dtoActividad.setOidCliente(new Long(valor.longValue()));

            dtoActividad.setCodigoCliente((String)rs.getValueAt(0, "CODCLIENTE"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDTIPOSOLICITUDPAISPAGO");

            if(valor != null)
                dtoActividad.setOidTipoSolicitudParaPago(new Long(valor.longValue()));

            dtoActividad.setDescripcionTipoSolicitudParaPago((String)rs.getValueAt(0, "TIPOSOLICITUDPAISPAGO"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDTIPOPOSICIONPAGO");

            if(valor != null)
                dtoActividad.setOidTipoPosicionParaPago(new Long(valor.longValue()));

            dtoActividad.setDescripcionTipoPosicionParaPago((String)rs.getValueAt(0, "TIPOPOSICIONPAGO"));
            valor = (BigDecimal)rs.getValueAt(0, "OIDSUBTIPOPOSCPAGO");

            if(valor != null)
                dtoActividad.setOidSubtipoPosicionParaPago(new Long(valor.longValue()));

            dtoActividad.setDescripcionSubtipoPosicionParaPago((String)rs.getValueAt(0, "SUBTIPOPOSCPAGO"));

            // Segun incidencia 7401:
            // -> Tomar oid de Actividad y hacer consulta JDBC para obtener oid y descripción, 
            // internacionalizada donde aplique, en las siguientes entidades: 
            // TipoOfertaActividad (MAV_ACTIV_TIPO_OFERT), 
            // CicloVidaActividad (MAV_ACTIV_CICLO_VIDA), 
            // TipoDespachoActividad (MAV_ACTIV_TIPO_DESPA), 
            // TipoSolicitudOrigenActividad (MAV_ACTIV_TIPO_SOLIC),
            // SubtipoClienteActividad (MAV_ACTIV_SUBTI_CLIEN), 
            // EstadosActividad (MAV_ACTIV_ESTAD) y 
            // CriterioAsignacionActividad (MAV_CRITE_ASIGN_ACTIV). 
            // Para cada consulta realizada hacer: 
            // ->Tomar RecordSet obtenido 
            // -> Crear objeto arrayList 
            // Para cada registro del RecordSet hacer 
            // -> Crear objeto DTOLineaCombo (oid y descripcion) 
            // -> Asignar oid y descripción a los atributos del dto creado 
            // -> Añadir el dto creado al arrayList 
            // 	Fin Para 
            // /** En la consulta correspondiente a TipoDespachoActividad hay que obtener también el oid de EnvioConSolicitud, 
            // que de existir es el mismo en todos. Se halla el oid de EnvioConSolicitud y descripción, y se 
            // añade a los atributos DTOActividadMAV.oidEnvioConSolicitud y DTOActividadMAV.descripcionEnvioConSolicitud */ 
            // -> Asignar el arrayList creado a su lugar correspondiente en el DTOActividadMAV 
            // TipoOfertaActividad (MAV_ACTIV_TIPO_OFERT)
            query = new StringBuffer();
            query.append("SELECT activtipoofert.TOFE_OID_TIPO_OFER AS OID, i18n.val_i18n AS descripcion");
            query.append("  FROM mav_activ_tipo_ofert activtipoofert,");
            query.append("       pre_tipo_ofert tipoofert,");
            query.append("       v_gen_i18n_sicc i18n");
            query.append(" WHERE activtipoofert.acti_oid_acti = " + dto.getOid().toString());
            query.append("   AND activtipoofert.tofe_oid_tipo_ofer = tipoofert.oid_tipo_ofer");
            query.append("   AND i18n.attr_enti = 'PRE_TIPO_OFERT'");
            query.append("   AND i18n.attr_num_atri = 1");
            query.append("   AND i18n.idio_oid_idio = " + dto.getOidIdioma().toString());
            query.append("   AND i18n.val_oid = tipoofert.oid_tipo_ofer");

            //			bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug(">> Recordset de ACTIVIDAD: " + rs.toString());
            Vector dtos = armaVector(rs);
            dtoActividad.setTipoOferta(dtos);

            // CicloVidaActividad (MAV_ACTIV_CICLO_VIDA), 
            query = new StringBuffer();
            query.append("SELECT   activCicloVida.CIVI_OID_CICL_VIDA AS OID,");
            query.append("         i18n.val_i18n AS descripcion");
            query.append("    FROM mav_activ_ciclo_vida activciclovida,");
            query.append("         pre_ciclo_vida ciclovida,");
            query.append("         v_gen_i18n_sicc i18n");
            query.append("   WHERE activciclovida.acti_oid_acti = " + dto.getOid().toString());
            query.append("     AND activciclovida.civi_oid_cicl_vida = ciclovida.oid_cicl_vida");
            query.append("     AND i18n.attr_enti = 'PRE_CICLO_VIDA'");
            query.append("     AND i18n.attr_num_atri = 1");
            query.append("     AND i18n.idio_oid_idio = " + dto.getOidIdioma().toString());
            query.append("     AND i18n.val_oid = ciclovida.oid_cicl_vida ");

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug(">> Recordset de CICLO VIDA: " + rs.toString());
            dtos = null;
            dtos = armaVector(rs);
            UtilidadesLog.debug("" + dtos);
            dtoActividad.setCicloVida(dtos);

            // TipoDespachoActividad (MAV_ACTIV_TIPO_DESPA), 
            query = new StringBuffer();
            query.append("SELECT   activtipodespa.TDCH_OID_TIPO_DESP AS OID,");
            query.append("         tipodespa.des_tipo_desp AS descripcion,");
            query.append("         enviosolic.oid_envi_soli AS oidenviosoli,");
            query.append("         enviosolic.des_envi_soli AS descripcionenviosolic");
            query.append("    FROM mav_activ_tipo_despa activtipodespa,");
            query.append("         mav_tipo_despa tipodespa,");
            query.append("         mav_envio_solic enviosolic");
            query.append("   WHERE activtipodespa.acti_oid_acti = " + dto.getOid().toString());
            query.append("     AND activtipodespa.tdch_oid_tipo_desp = tipodespa.oid_tipo_desp");
            query.append("     AND enviosolic.oid_envi_soli(+) = activtipodespa.envs_oid_envi_soli ");

            rs = bs.dbService.executeStaticQuery(query.toString());
            dtos = armaVector(rs);
            dtoActividad.setTipoDespacho(dtos);

            if(!rs.esVacio()) {
                valor = (BigDecimal)rs.getValueAt(0, "OIDENVIOSOLI");

                if(valor != null)
                    dtoActividad.setOidEnvioConSolicitud(new Long(valor.longValue()));

                dtoActividad.setDescripcionEnvioConSolicitud((String)rs.getValueAt(0, "DESCRIPCIONENVIOSOLIC"));
            }

            // TipoSolicitudOrigenActividad (MAV_ACTIV_TIPO_SOLIC),
            query = new StringBuffer();
            query.append("SELECT activtiposolic.TSPA_OID_TIPO_SOLI_PAIS AS OID, i18n.val_i18n AS descripcion");
            query.append("  FROM mav_activ_tipo_solic activtiposolic,");
            query.append("       ped_tipo_solic_pais tiposolicpais,");
            query.append("       v_gen_i18n_sicc i18n");
            query.append(" WHERE activtiposolic.acti_oid_acti = " + dto.getOid().toString());
            query.append("   AND activtiposolic.tspa_oid_tipo_soli_pais = tiposolicpais.oid_tipo_soli_pais");
            query.append("   AND i18n.attr_enti = 'PED_TIPO_SOLIC'");
            query.append("   AND i18n.attr_num_atri = 1");
            query.append("   AND i18n.idio_oid_idio = " + dto.getOidIdioma().toString());
            query.append("   AND i18n.val_oid = tiposolicpais.tsol_oid_tipo_soli");

            rs = bs.dbService.executeStaticQuery(query.toString());
            dtos = armaVector(rs);
            dtoActividad.setTipoSolicitudOrigen(dtos);

            // SubtipoClienteActividad (MAV_ACTIV_SUBTI_CLIEN), 
            query = new StringBuffer();
            query.append("SELECT activsubticlien.SBTI_OID_SUBT_CLIE AS OID,");
            query.append("       i18n.val_i18n AS descripcion");
            query.append("  FROM mav_activ_subti_clien activsubticlien,");
            query.append("       mae_subti_clien subticlien,");
            query.append("       v_gen_i18n_sicc i18n");
            query.append(" WHERE activsubticlien.acti_oid_acti = " + dto.getOid().toString());
            query.append("   AND activsubticlien.sbti_oid_subt_clie = subticlien.oid_subt_clie");
            query.append("   AND i18n.attr_enti = 'MAE_SUBTI_CLIEN'");
            query.append("   AND i18n.attr_num_atri = 1");
            query.append("   AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma().toString());
            query.append("   AND i18n.val_oid = subticlien.oid_subt_clie");

            rs = bs.dbService.executeStaticQuery(query.toString());
            dtos = armaVector(rs);
            dtoActividad.setSubtipoCliente(dtos);

            // EstadosActividad (MAV_ACTIV_ESTAD)
            query = new StringBuffer();
            query.append("SELECT activEstad.EMAV_OID_ESTA_MAV AS OID,");
            query.append("       i18n.val_i18n AS descripcion");
            query.append("  FROM MAV_ACTIV_ESTAD activEstad,");
            query.append("       MAV_ESTAD_MAV estad,");
            query.append("       v_gen_i18n_sicc i18n");
            query.append(" WHERE activEstad.ACTI_OID_ACTI = " + dto.getOid().toString());
            query.append("   AND activEstad.EMAV_OID_ESTA_MAV = estad.OID_ESTA_MAV");
            query.append("   AND i18n.attr_enti = 'MAV_ESTAD_MAV'");
            query.append("   AND i18n.attr_num_atri = 1");
            query.append("   AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma().toString());
            query.append("   AND i18n.val_oid = estad.OID_ESTA_MAV");

            rs = bs.dbService.executeStaticQuery(query.toString());
            dtos = armaVector(rs);
            dtoActividad.setEstado(dtos);

            // CriterioAsignacionActividad (MAV_CRITE_ASIGN_ACTIV). 
            query = new StringBuffer();
            query.append("SELECT activcriteasign.CRAS_OID_CRIT_ASIG AS OID,");
            query.append("       criteasign.des_crit_asig AS descripcion");
            query.append("  FROM mav_crite_asign_activ activcriteasign, mav_crite_asign criteasign");
            query.append(" WHERE activcriteasign.acti_oid_acti = " + dto.getOid().toString());
            query.append("   AND activcriteasign.cras_oid_crit_asig = criteasign.oid_crit_asig");

            rs = bs.dbService.executeStaticQuery(query.toString());
            dtos = armaVector(rs);
            dtoActividad.setCriterioAsignacion(dtos);
            UtilidadesLog.info("DAOActividadesMAV.consultaActividad(DTOOID dto):Salida");
            return dtoActividad;
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      MAV
     * Fecha:       23/08/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * Descripcion:
     */
    private Vector armaVector(RecordSet rs) {
        UtilidadesLog.info("DAOActividadesMAV.armaVector(RecordSet rs):Entrada");    
        BigDecimal valor = null;
        Vector dtos = new Vector();

        if(!rs.esVacio()) {
            DTOLineaCombo dtoCombo = null;

            for(int i = 0; i < rs.getRowCount(); i++) {
                dtoCombo = new DTOLineaCombo();
                valor = (BigDecimal)rs.getValueAt(i, "OID");
                dtoCombo.setOid(new Long(valor.longValue()));
                dtoCombo.setDescripcion((String)rs.getValueAt(i, "DESCRIPCION"));
                dtos.add(dtoCombo);
            }
            UtilidadesLog.info("DAOActividadesMAV.armaVector(RecordSet rs):Salida");    
            return dtos;
        } else { 
            UtilidadesLog.info("DAOActividadesMAV.armaVector(RecordSet rs):Salida");            
            return null;
        }
    }
    
    
  /**
   * @author: ssantana, 22/6/2005 - inc. 16866
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param  dtoOid
   */
  public DTOSalida obtenerSubtiposClienteMAV(DTOOID dtoOid) throws MareException {
    UtilidadesLog.info("DAOActividadesMAV.obtenerSubtiposClienteMAV(DTOOID dtoOid):Entrada");
    DTOSalida dtoSalida = new DTOSalida();
    StringBuffer sqlQuery = new StringBuffer("");
    
    sqlQuery.append(" SELECT mav_activ_subti_clien.sbti_oid_subt_clie, v_gen_i18n_sicc.val_i18n ");
    sqlQuery.append(" FROM mav_activ_subti_clien, v_gen_i18n_sicc ");
    sqlQuery.append(" WHERE mav_activ_subti_clien.acti_oid_acti = " + dtoOid.getOid() );
    sqlQuery.append(" AND mav_activ_subti_clien.sbti_oid_subt_clie = v_gen_i18n_sicc.val_oid ");
    sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'MAE_SUBTI_CLIEN' ");
    sqlQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
    sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dtoOid.getOidIdioma());
    
    try {
       BelcorpService bs = BelcorpService.getInstance();
       RecordSet rs = bs.dbService.executeStaticQuery( sqlQuery.toString() );
       UtilidadesLog.debug("rs: " + rs);
       dtoSalida.setResultado(rs);
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    UtilidadesLog.info("DAOActividadesMAV.obtenerSubtiposClienteMAV(DTOOID dtoOid):Salida");
    return dtoSalida;
    
  }
  
  
  public DTOSalida obtieneTiposClienteActividad(DTOOID dtoOid) throws MareException {
    UtilidadesLog.info("DAOActividadesMAV.obtieneTiposClienteActividad(DTOOID dtoOid):Entrada");
    StringBuffer sqlQuery = new StringBuffer();
    DTOSalida dtoSalida = new DTOSalida();
    BelcorpService bs = BelcorpService.getInstance();

    sqlQuery.append(" SELECT mav_activ.TICL_OID_TIPO_CLIE, v_gen_i18n_sicc.VAL_I18N ");
    sqlQuery.append(" FROM mav_activ, v_gen_i18n_sicc ");
    sqlQuery.append(" WHERE v_gen_i18n_sicc.attr_num_atri = 1 ");
    sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'MAE_TIPO_CLIEN' ");
    sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dtoOid.getOidIdioma());
    sqlQuery.append(" AND v_gen_i18n_sicc.val_oid = mav_activ.ticl_oid_tipo_clie ");
    sqlQuery.append(" AND mav_activ.oid_acti = " + dtoOid.getOid() );
    
    try {
       RecordSet rs = bs.dbService.executeStaticQuery(sqlQuery.toString());
       UtilidadesLog.debug("rs: " + rs);
       dtoSalida.setResultado(rs);
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    UtilidadesLog.info("DAOActividadesMAV.obtieneTiposClienteActividad(DTOOID dtoOid):Salida");
    return dtoSalida;

  }

  /**
   * 19-06-2007   agregado por Sapaza, incidencia SiCC-20070288. Obtiene lista de actividades MAV
   *              filtrado por tipo de despacho MAV, pais, canal, marca.
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   */
    public DTOSalida obtenerActividadesTipoDespacho(DTOEBuscarActividadesMAV dto)
        throws MareException {
        UtilidadesLog.info("DAOServicioMAV.obtenerActividadesTipoDespacho(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = BelcorpService.getInstance();

        query.append(" SELECT actividad.oid_acti OID, i18n.val_i18n des ");
        query.append(" FROM   mav_activ actividad, mav_activ_tipo_despa despacho, v_gen_i18n_sicc i18n ");
        query.append(" WHERE actividad.OID_ACTI = despacho.ACTI_OID_ACTI ");
        query.append("   AND actividad.pais_oid_pais = " + dto.getOidPais().toString());
        query.append("   AND actividad.MARC_OID_MARC = " + dto.getMarca().toString());        
        query.append("   AND actividad.CANA_OID_CANA = " + dto.getCanal().toString());        
        query.append("   AND despacho.TDCH_OID_TIPO_DESP = " + dto.getCodigo().toString());
        query.append("   AND i18n.attr_enti = 'MAV_ACTIV' ");
        query.append("   AND i18n.attr_num_atri = 1 ");
        query.append("   AND i18n.idio_oid_idio = " + dto.getOidIdioma().toString());
        query.append("   AND i18n.val_oid = actividad.oid_acti ");
        query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            dtoSalida.setResultado(rs);
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en obtenerActividadesTipoDespacho");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOServicioMAV.obtenerActividadesTipoDespacho(DTOOID dto):Salida");
        return dtoSalida;
    }

}