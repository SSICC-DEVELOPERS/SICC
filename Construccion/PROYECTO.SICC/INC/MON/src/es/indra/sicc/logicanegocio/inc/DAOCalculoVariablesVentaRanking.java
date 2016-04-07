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
 * @author: DMorello
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 *  
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


public class DAOCalculoVariablesVentaRanking {
    public DAOCalculoVariablesVentaRanking() {
    }

    /**
     * Se obtiene la cantidad de clientes, agrupados por unidad administrativa,
     * cuya zonificacion coincida con la del gerente pasado por parametro
     * y el periodo fin de cliente unidades administrativas coincida con el
     * periodo pasado por parametro
     *
         * Sistema:     Belcorp
         * Modulo:      INC
         * Fecha:       23/06/2005
         * @version     1.00
         * @autor       Diego Morello
         */
    public RecordSet recuperarEntregadas(UnidadAdministrativa uniAdmGer,
        Periodo periodoAnteriorDesdeConcurso, Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarEntrega"
            +"das(UnidadAdministrativa uniAdmGer, Periodo periodoAnteriorDesde"
            +"Concurso):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        /*
         * Tomo de los parámetros la informacion necesaria para armar la 
         * consulta
         */
        Long oidPeriodo = periodoAnteriorDesdeConcurso.getOidPeriodo();
        Long oidSubgerencia = uniAdmGer.getOidSubgerencia();
        Long oidRegion = uniAdmGer.getOidSubgerencia();
        Long oidZona = uniAdmGer.getOidZona();
        Long oidSeccion = uniAdmGer.getOidSeccion();

        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );
        
        /*
         * Armo la consulta
         */
        query.append(" SELECT ");
        query.append("      COUNT(*) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("      sec.OID_SECC, ");
        query.append("      zon.OID_ZONA, ");
        query.append("      reg.OID_REGI, ");
        query.append("      sub.OID_SUBG_VENT ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append(" FROM ");
        query.append("      MAE_CLIEN_UNIDA_ADMIN unida, ");
        query.append("      ZON_TERRI_ADMIN terr, ");
        query.append("      ZON_SECCI sec, ");
        query.append("      ZON_ZONA zon, ");
        query.append("      ZON_REGIO reg, ");
        query.append("      ZON_SUB_GEREN_VENTA sub ");
        query.append(" WHERE ");
        // vbongiov -- 16/11/2006
        query.append("      unida.perd_oid_peri_ini = " + oidPeriodo);
        query.append("      AND unida.IND_ACTI = 1 ");
        query.append("      AND unida.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append("      AND terr.ZSCC_OID_SECC = sec.OID_SECC ");
        query.append("      AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
        query.append("      AND zon.ZORG_OID_REGI = reg.OID_REGI ");
        query.append("      AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");

        // ------ Zonificación ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append("AND sub.OID_SUBG_VENT = " +
                uniAdmGer.getOidSubgerencia());
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append("AND reg.OID_REGI = " + uniAdmGer.getOidRegion());
        } else if (uniAdmGer.getOidZona() != null) {
            query.append("AND zon.OID_ZONA = " + uniAdmGer.getOidZona());
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append("AND sec.OID_SECC = " + uniAdmGer.getOidSeccion());
        }

        query.append(" GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("      sec.OID_SECC, ");
        query.append("      zon.OID_ZONA, ");
        query.append("      reg.OID_REGI, ");
        query.append("      sub.OID_SUBG_VENT ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        /*
         * Ejecuto y devuelvo resultados
         */
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info( "DAOCalculoVariablesVentaRanking.recuperarEntrega"
            +"das(UnidadAdministrativa uniAdmGer, Periodo periodoAnteriorDesde"
            +"Concurso):Salida");

        return rs;
    }

    /**
     * Se obtiene la cantidad de clientes, agrupados por unidad administrativa,
     * cuya zonificacion coincida con la del gerente pasado por parametro,
     * el periodo de inicio coincida con el periodo pasado por parametro
     * y el estatus del cliente para dicho periodo no sea Nueva o Registrado.
     *
         * Sistema:     Belcorp
         * Modulo:      INC
         * Fecha:       23/06/2005
         * @version     1.00
         * @autor       Diego Morello
         */
    public RecordSet recuperarRecibidas(UnidadAdministrativa uniAdmGer,
        Periodo periodoDesdeConcurso, Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarRecibidas"
            +"(UnidadAdministrativa uniAdmGer, Periodo periodoDesdeConcurso):"
            +"Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        /*
         * Formateo las fechas al formato estándar en búsquedas
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesdeConcurso.getFechaDesde());
        String strFechaHasta = sdf.format(periodoDesdeConcurso.getFechaHasta());
        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        /*
         * Armo la consulta
         */
        query.append(" SELECT ");
        query.append("    COUNT(*) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("    sec.OID_SECC, ");
        query.append("    zon.OID_ZONA, ");
        query.append("    reg.OID_REGI, ");
        query.append("    sub.OID_SUBG_VENT ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append(" FROM ");
        query.append("    MAE_CLIEN_UNIDA_ADMIN unida, ");
        query.append("    ZON_TERRI_ADMIN terr, ");
        query.append("    ZON_SECCI sec, ");
        query.append("    ZON_ZONA zon, ");
        query.append("    ZON_REGIO reg, ");
        query.append("    ZON_SUB_GEREN_VENTA sub, ");
        query.append("    CRA_PERIO p3 ");
        //query.append("    CRA_PERIO p4 ");
        query.append(" WHERE ");
        query.append("    unida.PERD_OID_PERI_INI = ? ");
        parametros.add(periodoDesdeConcurso.getOidPeriodo());
        query.append("    AND unida.IND_ACTI = 1 ");
        query.append("    AND unida.PERD_OID_PERI_INI = p3.OID_PERI ");
        //query.append("    AND unida.PERD_OID_PERI_FIN = p4.OID_PERI(+) ");
        query.append("    AND p3.FEC_INIC <= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaDesde);
        /*query.append("    AND (");
        query.append("         p4.FEC_FINA IS NULL");
        query.append("         OR p4.FEC_FINA >= TO_DATE(?,'YYYY-MM-DD') ");
        query.append("        ) ");
        parametros.add(strFechaHasta);*/
        query.append("    AND unida.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append("    AND terr.ZSCC_OID_SECC = sec.OID_SECC ");
        query.append("    AND SEC.ZZON_OID_ZONA = zon.OID_ZONA ");
        query.append("    AND zon.ZORG_OID_REGI = reg.OID_REGI ");
        query.append("    AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");

        // ------ Zonificación ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append("AND sub.OID_SUBG_VENT = ? ");
            parametros.add(uniAdmGer.getOidSubgerencia());
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append("AND reg.OID_REGI = ? ");
            parametros.add(uniAdmGer.getOidRegion());
        } else if (uniAdmGer.getOidZona() != null) {
            query.append("AND zon.OID_ZONA = ? ");
            parametros.add(uniAdmGer.getOidZona());
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append("AND sec.OID_SECC = ? "); // oidSeccion
            parametros.add(uniAdmGer.getOidSeccion());
        }

        query.append("GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("    sec.OID_SECC, ");
        query.append("    zon.OID_ZONA, ");
        query.append("    reg.OID_REGI, ");
        query.append("    sub.OID_SUBG_VENT ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        /*
         * Ejecuto y devuelvo resultados
         */
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarRecibidas"
            +"(UnidadAdministrativa uniAdmGer, Periodo periodoDesdeConcurso):"
                +"Salida");

        return rs;
    }

    /**
     * Este método recupera la cantidad de solicitudes ingresadas por todas las
     * consultoras del gerente en todos los periodos que conforman el concurso
     * agrupandolas por Unidad Administrativa.
     *
     * Sistema:  Belcorp
     * Modulo:   INC
     * Fecha:    24/06/2005
     * @version  1.00
     * @autor    Diego Morello
     */
    public RecordSet recuperarNumeroSolicitudes(
        UnidadAdministrativa uniAdmGer, Periodo periodoDesde,
        Periodo periodoHasta, Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarNumeroSo"
            +"licitudes(UnidadAdministrativa uniAdmGer, Periodo periodoDesde, "
                +"Periodo periodoHasta):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        /*
         * Formateo las fechas al formato estándar en búsquedas
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());
        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        /*
         * Armo la consulta
         */
        query.append(" SELECT ");
        query.append("    COUNT(psc.OID_SOLI_CABE) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("    sec.OID_SECC, ");
        query.append("    zon.OID_ZONA, ");
        query.append("    reg.OID_REGI, ");
        query.append("    sub.OID_SUBG_VENT ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        query.append(" FROM ");
        query.append("    MAE_CLIEN_UNIDA_ADMIN unida, ");
        query.append("    CRA_PERIO p1, ");
        query.append("    CRA_PERIO p2, ");
        query.append("    CRA_PERIO p3, ");
        query.append("    ZON_TERRI_ADMIN terr, ");
        query.append("    ZON_SECCI sec, ");
        query.append("    ZON_ZONA zon, ");
        query.append("    ZON_REGIO reg, ");
        query.append("    ZON_SUB_GEREN_VENTA sub, ");
        query.append("    PED_SOLIC_CABEC psc ");
        query.append(" WHERE ");
        query.append("    unida.PERD_OID_PERI_INI = p1.OID_PERI ");
        query.append("    AND unida.PERD_OID_PERI_FIN = p2.OID_PERI(+) ");
        query.append("    AND p1.FEC_INIC <= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaHasta);
        query.append("    AND (");
        query.append("         p2.FEC_FINA IS NULL ");
        query.append("         OR p2.FEC_FINA >= TO_DATE(?,'YYYY-MM-DD') ");
        query.append("        )");
        parametros.add(strFechaDesde);
        query.append("    AND psc.CLIE_OID_CLIE = unida.CLIE_OID_CLIE ");
        query.append("    AND unida.IND_ACTI = 1 ");
        query.append("    AND unida.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append("    AND terr.ZSCC_OID_SECC = sec.OID_SECC ");
        query.append("    AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
        query.append("    AND zon.ZORG_OID_REGI = reg.OID_REGI ");
        query.append("    AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");

        // ------ Zonificación ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append("AND sub.OID_SUBG_VENT = ? "); // oidSubgerencia
            parametros.add(uniAdmGer.getOidSubgerencia());
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append("AND reg.OID_REGI = ? "); // oidRegion
            parametros.add(uniAdmGer.getOidRegion());
        } else if (uniAdmGer.getOidZona() != null) {
            query.append("AND zon.OID_ZONA = ? "); // oidZona
            parametros.add(uniAdmGer.getOidZona());
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append("AND sec.OID_SECC = ? ");
            parametros.add(uniAdmGer.getOidSeccion());
        }

        query.append("    AND psc.FEC_FACT IS NOT NULL ");
        query.append("    AND psc.IND_OC = 1");

        //Filtros de solicitudes dentro de los periodos del concurso 
        query.append("    AND psc.PERD_OID_PERI = p3.OID_PERI ");
        query.append("    AND p3.FEC_INIC >= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaDesde);
        query.append("    AND p3.FEC_FINA <= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaHasta);
        query.append("    AND p3.FEC_INIC >= p1.FEC_INIC ");
        query.append("    AND ( ");
        query.append("          ( ");
        query.append("            p2.FEC_FINA IS NULL ");
        query.append("            AND p3.FEC_FINA <= TO_DATE(?,'YYYY-MM-DD') ");
        query.append("          ) ");
        query.append("          OR ( ");
        query.append("            p2.FEC_FINA IS NOT NULL ");
        query.append("            AND p3.FEC_FINA <= p2.FEC_FINA ");
        query.append("          ) ");
        query.append("    ) ");
        parametros.add(strFechaHasta);
        query.append(" GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("    sec.OID_SECC, ");
        query.append("    zon.OID_ZONA, ");
        query.append("    reg.OID_REGI, ");
        query.append("    sub.OID_SUBG_VENT ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        /*
         * Ejecuto y devuelvo resultados
         */
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), 
                parametros);
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarNumeroSo"
            +"licitudes(UnidadAdministrativa uniAdmGer, Periodo periodoDesde,"
                +"Periodo periodoHasta):Salida");

        return rs;
    }

    /**
     * Este método recupera la cantidad de pedidos realizados para todas las 
     * consultoras del gerente en todos los periodos que conforman el concurso
     *  agrupandolas por Unidad Administrativa.
     * 
     * Por cada consultora, los pedidos son los periodos en los que esa consul
     * tora ingreso al menos una solicitud
     *
     *
     * Sistema:  Belcorp
     * Modulo:   INC
     * Fecha:    27/06/2005
     * @version  1.00
     * @autor    Sergio Saavedra
     */
    public RecordSet recuperarNumeroPedidos(UnidadAdministrativa uniAdmGer,
        Periodo periodoDesde, Periodo periodoHasta, Long oidConcurso) throws MareException {
        UtilidadesLog.info( "DAOCalculoVariablesVentaRanking.recuperarNumero"
            +"Pedidos(UnidadAdministrativa uniAdmGer, Periodo periodoDesde,"
            +"Periodo periodoHasta):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        UtilidadesLog.debug("dentro de recuperarNumeroPedidos, recibo : " +
            uniAdmGer + " - " + periodoDesde + " - " + periodoHasta + "-" + oidConcurso);

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());
        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        query.append("SELECT COUNT (*) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("result.oid_secc, result.oid_zona, ");
        query.append("result.oid_regi, result.oid_subg_vent ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append(
            "FROM (SELECT DISTINCT sec.oid_secc, zon.oid_zona, reg.oid_regi, ");
        query.append("sub.oid_subg_vent, psc.clie_oid_clie, psc.perd_oid_peri ");
        query.append("FROM mae_clien_unida_admin unida, ");
        query.append("cra_perio p1, ");
        query.append("cra_perio p2, ");
        query.append("cra_perio p3, ");
        query.append("zon_terri_admin terr, ");
        query.append("zon_secci sec, ");
        query.append("zon_zona zon, ");
        query.append("zon_regio reg, ");
        query.append("zon_sub_geren_venta sub, ");
        query.append("ped_solic_cabec psc ");
        query.append("WHERE ");

        // Filtro de la unidad administrativa del cliente dentro de los perio
        //dos del concurso 
        query.append("unida.perd_oid_peri_ini = p1.oid_peri ");
        query.append("AND unida.perd_oid_peri_fin = p2.oid_peri(+) ");
        query.append("AND ( p2.fec_fina IS NULL OR p2.fec_fina >= TO_DATE('" +
            strFechaDesde + "', 'YYYY-MM-DD')) ");
        query.append("AND ( p1.fec_inic <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD')) ");
        query.append("AND psc.clie_oid_clie = unida.clie_oid_clie ");
        query.append("AND unida.IND_ACTI = 1 ");
        query.append("AND unida.ztad_oid_terr_admi = terr.oid_terr_admi ");
        query.append("AND terr.zscc_oid_secc = sec.oid_secc ");
        query.append("AND sec.zzon_oid_zona = zon.oid_zona ");
        query.append("AND zon.zorg_oid_regi = reg.oid_regi ");
        query.append("AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");

        // ------ Zonificación ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append("AND sub.OID_SUBG_VENT = " +
                uniAdmGer.getOidSubgerencia().longValue()); // oidSubgerencia
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append(" AND reg.OID_REGI = " +
                uniAdmGer.getOidRegion().longValue()); // oidRegion
        } else if (uniAdmGer.getOidZona() != null) {
            query.append("AND zon.OID_ZONA = " +
                uniAdmGer.getOidZona().longValue()); // oidZona
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append("AND sec.OID_SECC = " +
                uniAdmGer.getOidSeccion().longValue());
        }

        // Filtros sobre algunos campos de la solicitud 
        query.append(" AND psc.FEC_FACT IS NOT NULL ");
        query.append("AND psc.IND_OC = 1 ");

        // Filtros de solicitudes dentro de los periodos del concurso 
        query.append("AND psc.perd_oid_peri = p3.oid_peri ");

        query.append("AND p3.fec_inic >= TO_DATE('" + strFechaDesde +
            "', 'YYYY-MM-DD') ");
        query.append("AND p3.fec_fina <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");
        query.append("AND p3.fec_inic >= p1.fec_inic ");
        query.append("AND p3.fec_fina <= DECODE(p2.FEC_FINA,NULL,TO_DATE('" +
            strFechaHasta + "','YYYY-MM-DD'),p2.FEC_FINA) ");
        query.append(") result ");

        //query.append("    AND p3.FEC_INIC >= p1.FEC_INIC ");
        //query.append("    AND p3.FEC_FINA <= DECODE(p2.FEC_FINA,NULL,TO_DATE(
        ///" + strFechaHasta + ",'YYYY-MM-DD'),p2.FEC_FINA) ");
        query.append("GROUP BY ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("result.oid_secc, ");
        query.append("result.oid_zona, ");
        query.append("result.oid_regi, ");
        query.append("result.oid_subg_vent");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarNumeroPe"
            +"didos(UnidadAdministrativa uniAdmGer, Periodo periodoDesde,"
            +"Periodo periodoHasta):Salida");

        return rs;
    }

    /**
     * Descripción: Este método recupera la cantidad de consultoras del gerente 
     * que tengan el estado pasado por parametro durante el transcurso 
     * del concurso, agrupandolas por Unidad Administrativa.
     *  
     *
     * Sistema:  Belcorp
     * Modulo:   INC
     * Fecha:    27/06/2005
     * @version  1.00
     * @autor    Sergio Saavedra
     */
    public RecordSet recuperarCantidadConsultorasPorEstado(
        UnidadAdministrativa uniAdmGer, Periodo periodoDesde,
        Periodo periodoHasta, Long codigoEstado, Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarCantidad"
            +"ConsultorasPorEstado(UnidadAdministrativa uniAdmGer, Periodo "
            +"periodoDesde, Periodo periodoHasta,Long codigoEstado):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        UtilidadesLog.debug(
            "dentro de recuperarCantidadConsultorasPorEstado, recibo : " +
            uniAdmGer + " - " + periodoDesde + " - " + periodoHasta + " - " +
            codigoEstado);

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());
        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        query.append("SELECT COUNT (unida.clie_oid_clie) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("sub.oid_subg_vent, ");
        query.append("sec.oid_secc, ");
        query.append("zon.oid_zona, ");
        query.append("reg.oid_regi ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append("FROM mae_clien_unida_admin unida, ");
        query.append("cra_perio p1, ");
        query.append("cra_perio p2, ");
        query.append("zon_terri_admin terr, ");
        query.append("zon_secci sec, ");
        query.append("zon_zona zon, ");
        query.append("zon_regio reg, ");
        query.append("zon_sub_geren_venta sub, ");
        query.append("mae_clien_histo_estat histo, ");
        query.append("cra_perio p3, ");
        query.append("cra_perio p4 ");
        query.append("WHERE ");
        query.append("unida.perd_oid_peri_ini = p1.oid_peri ");
        query.append("AND unida.perd_oid_peri_fin = p2.oid_peri(+) ");
        query.append("AND ( p2.fec_fina IS NULL OR p2.fec_fina >= TO_DATE('" +
            strFechaDesde + "', 'YYYY-MM-DD')) ");
        query.append("AND ( p1.fec_inic <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD')) ");
        query.append("AND histo.clie_oid_clie = unida.clie_oid_clie ");
        query.append("AND histo.perd_oid_peri = p3.oid_peri ");
        query.append("AND histo.perd_oid_peri_peri_fin = p4.oid_peri(+) ");
        query.append("AND (p4.fec_fina IS NULL OR p4.fec_fina >= TO_DATE('" +
            strFechaDesde + "', 'YYYY-MM-DD')) ");
        query.append("AND p3.fec_inic <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");        
        query.append("AND unida.IND_ACTI = 1 ");
        query.append("AND unida.ztad_oid_terr_admi = terr.oid_terr_admi ");
        query.append("AND terr.zscc_oid_secc = sec.oid_secc ");
        query.append("AND sec.zzon_oid_zona = zon.oid_zona ");
        query.append("AND zon.zorg_oid_regi = reg.oid_regi ");
        query.append("AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");
        query.append("AND histo.esta_oid_esta_clie = " +
            codigoEstado.longValue());

        // ------ Zonificación ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append(" AND sub.OID_SUBG_VENT = " +
                uniAdmGer.getOidSubgerencia().longValue()); // oidSubgerencia
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append(" AND reg.OID_REGI = " +
                uniAdmGer.getOidRegion().longValue()); // oidRegion
        } else if (uniAdmGer.getOidZona() != null) {
            query.append(" AND zon.OID_ZONA = " +
                uniAdmGer.getOidZona().longValue()); // oidZona
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append(" AND sec.OID_SECC = " +
                uniAdmGer.getOidSeccion().longValue());
        }

        query.append(" GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" sec.oid_secc, zon.oid_zona, reg.oid_regi,  ");
        query.append(" sub.oid_subg_vent");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarCantidad"
            +"ConsultorasPorEstado(UnidadAdministrativa uniAdmGer, Periodo "
            +"periodoDesde, Periodo periodoHasta,Long codigoEstado):Salida");

        return rs;
    }

    /**
     * Este metodo cuenta la cantidad de clientes, agrupadas por unidad admi
     * nistrativa, que pertenecen a la unidades administrativas recibidas
     *  por parametro, que pasaron solicitudes en los periodos tambien 
     * recibidos por parametro.
     *
     * Sistema:  Belcorp
     * Modulo:   INC
     * Fecha:    29/06/2005
     * @version  1.00
     * @autor    Diego Morello
     */
    public RecordSet recuperarActivasPorPeriodo(
        UnidadAdministrativa uniAdmGer, ArrayList arrPer, Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarActivas"
            +"PorPeriodo(UnidadAdministrativa uniAdmGer, ArrayList arrPer):"
            +"Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        Long oidPeriodoDesde = ((Periodo) arrPer.get(2)).getOidPeriodo();
        Long oidPeriodoHasta = ((Periodo) arrPer.get(1)).getOidPeriodo();
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        query.append(" SELECT ");
        query.append("     COUNT(DISTINCT solcab.CLIE_OID_CLIE) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" 	   terr.ZSCC_OID_SECC, ");
        query.append(" 	   secc.ZZON_OID_ZONA, ");
        query.append(" 	   zona.ZORG_OID_REGI, ");
        query.append(" 	   reg.ZSGV_OID_SUBG_VENT ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append(" FROM ");
        query.append(" 	   PED_SOLIC_CABEC solcab, ");
        query.append(" 	   ZON_TERRI_ADMIN terr, ");
        query.append(" 	   ZON_SECCI secc, ");
        query.append(" 	   ZON_ZONA zona, ");
        query.append(" 	   ZON_REGIO reg, ");
        query.append(" 	   ZON_SUB_GEREN_VENTA sub ");
        query.append(" WHERE ");
        query.append(" 	 	solcab.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append(" 	 	AND terr.ZSCC_OID_SECC = secc.OID_SECC ");
        query.append("  	AND secc.ZZON_OID_ZONA = zona.OID_ZONA ");
        query.append(" 	 	AND zona.ZORG_OID_REGI = reg.OID_REGI ");
        query.append(" 	 	AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT  ");

        // ------ Zonificacion ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append(" 	AND sub.OID_SUBG_VENT = " +
                uniAdmGer.getOidSubgerencia());
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append(" 	AND reg.OID_REGI = " + uniAdmGer.getOidRegion());
        } else if (uniAdmGer.getOidZona() != null) {
            query.append(" 	AND zona.OID_ZONA = " + uniAdmGer.getOidZona());
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append(" 	AND secc.OID_SECC = " + uniAdmGer.getOidSeccion());
        }

        // Filtro por los periodos ubicados en las dos primeras posiciones de 
        //la ArrayList
        query.append("     AND solcab.PERD_OID_PERI IN (" + oidPeriodoDesde +
            " , " + oidPeriodoHasta + ") ");

        // Fecha de facturacion no nula
        query.append("     AND solcab.FEC_FACT IS NOT NULL ");

        // indicadorOC = true
        query.append("     AND solcab.IND_OC = 1 ");
        query.append(" GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" 	   terr.ZSCC_OID_SECC, ");
        query.append(" 	   secc.ZZON_OID_ZONA, ");
        query.append(" 	   zona.ZORG_OID_REGI, ");
        query.append(" 	   reg.ZSGV_OID_SUBG_VENT ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarActivas"
            +"PorPeriodo(UnidadAdministrativa uniAdmGer, ArrayList arrPer):"
            +"Salida");

        return rs;
    }

    /**
     * Este método recupera el detalle de los pedidos realizados para todas las 
     * consultoras del gerente en todos los periodos que conforman el concurso
     *  agrupandolas por Unidad Administrativa.
     * 
     * Por cada consultora, los pedidos son los periodos en los que esa consul
     * tora ingreso al menos una solicitud
     * 
     *
     * Sistema:  Belcorp
     * Modulo:   INC
     * Fecha:    29/06/2005
     * @version  1.00
     * @autor    Sergio Saavedra
     */
    public RecordSet recuperarDetallePedidos(UnidadAdministrativa uniAdmGer,
        Periodo periodoDesde, Periodo periodoHasta, Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarDetalle"
            +"Pedidos(UnidadAdministrativa uniAdmGer, Periodo periodoDesde, "
            +"Periodo periodoHasta):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());
        
        // vbongiov -- 9/11/2006
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        query.append("SELECT DISTINCT ");
        
        // vbongiov -- 9/11/2006
        //query.append("sec.oid_secc, zon.oid_zona, reg.oid_regi, sub.oid_subg_vent, ");
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking()));
        
        query.append(" , psc.clie_oid_clie oid_clie, psc.perd_oid_peri oid_peri, ");
        query.append("(SELECT pericont.fec_inic ");
        query.append("FROM mae_clien_prime_conta pcont, cra_perio pericont ");
        query.append("WHERE pcont.clie_oid_clie = unida.clie_oid_clie ");
        query.append(
            "AND pcont.perd_oid_peri = pericont.oid_peri) fechaContacto ");
        query.append("FROM mae_clien_unida_admin unida, ");
        query.append("cra_perio p1, ");
        query.append("cra_perio p2, ");
        query.append("cra_perio p3, ");
        query.append("zon_terri_admin terr, ");
        query.append("zon_secci sec, ");
        query.append("zon_zona zon, ");
        query.append("zon_regio reg, ");
        query.append("zon_sub_geren_venta sub, ");
        query.append("ped_solic_cabec psc ");
        query.append("WHERE ");

        //-- Filtro de la unidad administrativa del cliente dentro de los perio
        //dos del concurso 
        query.append("unida.perd_oid_peri_ini = p1.oid_peri ");
        query.append("AND unida.perd_oid_peri_fin = p2.oid_peri(+) ");

        query.append("AND ( p2.fec_fina IS NULL OR p2.fec_fina >= TO_DATE('" +
            strFechaDesde + "', 'YYYY-MM-DD')) ");
        query.append("AND ( p1.fec_inic <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD')) ");

        query.append(" AND psc.clie_oid_clie = unida.clie_oid_clie ");
        query.append(" AND unida.IND_ACTI = 1 ");
        query.append("AND unida.ztad_oid_terr_admi = terr.oid_terr_admi ");
        query.append("AND terr.zscc_oid_secc = sec.oid_secc ");
        query.append("AND sec.zzon_oid_zona = zon.oid_zona ");
        query.append("AND zon.zorg_oid_regi = reg.oid_regi ");
        query.append("AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");

        // ------ Zonificación ------
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append(" AND sub.OID_SUBG_VENT = " +
                uniAdmGer.getOidSubgerencia().longValue()); // oidSubgerencia
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append(" AND reg.OID_REGI = " +
                uniAdmGer.getOidRegion().longValue()); // oidRegion
        } else if (uniAdmGer.getOidZona() != null) {
            query.append(" AND zon.OID_ZONA = " +
                uniAdmGer.getOidZona().longValue()); // oidZona
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append(" AND sec.OID_SECC = " +
                uniAdmGer.getOidSeccion().longValue());
        }

        //-- Filtros sobre algunos campos de la solicitud
        query.append(" AND psc.fec_fact is not null ");
        query.append(" AND psc.ind_oc = 1 ");

        //-- Filtros de solicitudes dentro de los periodos del concurso
        query.append(" AND psc.perd_oid_peri = p3.oid_peri ");

        query.append(" AND p3.fec_inic >= TO_DATE('" + strFechaDesde +
            "', 'YYYY-MM-DD') ");
        query.append(" AND p3.fec_fina <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");
        query.append(" AND p3.fec_inic >= p1.fec_inic ");
        query.append(" AND p3.fec_fina <= DECODE(p2.FEC_FINA,NULL,TO_DATE('" +
            strFechaHasta + "','YYYY-MM-DD'),p2.FEC_FINA) ");

        // vbongiov -- 9/11/2006
        query.append(" ORDER BY ");
        //query.append(" ORDER BY sec.oid_secc, zon.oid_zona, reg.oid_regi,  ");
        //query.append(" sub.oid_subg_vent, ");        
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        query.append(" , psc.clie_oid_clie, psc.perd_oid_peri ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarDetallePe"
            +"didos(UnidadAdministrativa uniAdmGer, Periodo periodoDesde, "
            +"Periodo periodoHasta):Salida");

        return rs;
    }

    /**
     * Recupera el total de monto y unidades acordes a los parametros recibidos.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   04/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet recuperarMontoUnidadesSinExigencias(Long gerente,
        Long concurso, Periodo periodoDesde, Periodo periodoHasta,
        UnidadAdministrativa unidadAdm) throws MareException {
        UtilidadesLog.info( "DAOCalculoVariablesVentaRanking.recuperarMontoUni"
            +"dadesSinExigencias(Long gerente, Long concurso, Periodo periodo"
            +"Desde, Periodo periodoHasta,UnidadAdministrativa unidadAdm): "
            +"Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        // Formateo las fechas al formato estándar en búsquedas
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());

        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( concurso );
        
        query.append(" SELECT ");
        query.append(" 	SUM(solConcPunt.IMP_MONT) monto, ");
        query.append(" 	SUM(solConcPunt.NUM_UNID) unidades, ");
        query.append(" 	sub.OID_SUBG_VENT, ");

        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" 	reg.OID_REGI, ");
        query.append(" 	zona.OID_ZONA, ");
        query.append(" 	secc.OID_SECC ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        query.append(" FROM ");
        query.append(" 	INC_SOLIC_CONCU_PUNTA solConcPunt, ");
        query.append(" 	PED_SOLIC_CABEC solCab, ");
        query.append(" 	ZON_TERRI_ADMIN terrAdmin, ");
        query.append(" 	ZON_SECCI secc, ");
        query.append(" 	ZON_ZONA zona, ");
        query.append(" 	ZON_REGIO reg, ");
        query.append(" 	ZON_SUB_GEREN_VENTA sub, ");
        query.append(" 	CRA_PERIO peri ");
        query.append(" WHERE ");
        query.append(" 	solConcPunt.SOCA_OID_SOLI_CABE =  ");
        query.append(" solCab.OID_SOLI_CABE ");

        // ------ Zonificación ------
        query.append(
            " 	AND solCab.ZTAD_OID_TERR_ADMI = terrAdmin.OID_TERR_ADMI ");
        query.append(" 	AND terrAdmin.ZSCC_OID_SECC = secc.OID_SECC ");
        query.append(" 	AND secc.ZZON_OID_ZONA = zona.OID_ZONA ");
        query.append(" 	AND zona.ZORG_OID_REGI = reg.OID_REGI ");
        query.append(" 	AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");

        if (unidadAdm.getOidSeccion() != null) {
            query.append(" 	AND secc.OID_SECC = ? ");
            parametros.add(unidadAdm.getOidSeccion());
        } else if (unidadAdm.getOidZona() != null) {
            query.append(" 	AND zona.OID_ZONA = ? ");
            parametros.add(unidadAdm.getOidZona());
        } else if (unidadAdm.getOidRegion() != null) {
            query.append(" 	AND reg.OID_REGI = ? ");
            parametros.add(unidadAdm.getOidRegion());
        } else if (unidadAdm.getOidSubgerencia() != null) {
            query.append(" 	AND sub.OID_SUBG_VENT = ? ");
            parametros.add(unidadAdm.getOidSubgerencia());
        }

        // Fin zonificación
        query.append(" 	AND solConcPunt.COPA_OID_PARA_GRAL = " + concurso);
        query.append(" 	AND solConcPunt.CLIE_OID_CLIE_GERE = " + gerente);

        // ------ Filtro de período ------
        query.append(" 	AND peri.OID_PERI = solConcPunt.PERD_OID_PERI ");
        query.append(" 	AND peri.FEC_INIC >= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaDesde);
        query.append(" 	AND peri.FEC_FINA <= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaHasta);

        // Fin filtro de período
        query.append(" 	AND solCab.FEC_FACT IS NOT NULL ");
        query.append(" 	AND solCab.IND_OC = 1 ");
        query.append(" GROUP BY ");

        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" 	sub.OID_SUBG_VENT, ");
        query.append(" 	reg.OID_REGI, ");
        query.append(" 	zona.OID_ZONA, ");
        query.append(" 	secc.OID_SECC ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        try {
            rs = bs.dbService.executePreparedQuery(query.toString(),
                parametros);
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarMontoUni"
            +"dadesSinExigencias(Long gerente, Long concurso, Periodo "
            +"periodoDesde, Periodo periodoHasta, UnidadAdministrativa "
            +"unidadAdm):Salida");

        return rs;
    }

    /**
     * Recupera el total de monto y unidades acordes a los parametros recibidos
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   04/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet recuperarMontoUnidadesConExigencias(Long gerente,
        Long concurso, Periodo periodoDesde, Periodo periodoHasta,
        UnidadAdministrativa unidadAdm) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarMontoUni"
            +"dadesConExigencias(Long gerente, Long concurso, Periodo periodo"
            +"esde, Periodo periodoHasta,UnidadAdministrativa unidadAdm):Entra"
            +"da");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        // Formateo las fechas al formato estándar en búsquedas
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());
        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( concurso );

        query.append(" SELECT ");
        query.append(" 	SUM(solConcPunt.IMP_MONT) monto, ");
        query.append(" 	SUM(solConcPunt.NUM_UNID) unidades, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" 	sub.OID_SUBG_VENT, ");
        query.append(" 	reg.OID_REGI, ");
        query.append(" 	zona.OID_ZONA, ");
        query.append(" 	secc.OID_SECC ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append(" FROM ");
        query.append(" 	INC_SOLIC_CONCU_PUNTA solConcPunt, ");
        query.append(" 	PED_SOLIC_CABEC solCab, ");
        query.append(" 	ZON_TERRI_ADMIN terrAdmin, ");
        query.append(" 	ZON_SECCI secc, ");
        query.append(" 	ZON_ZONA zona, ");
        query.append(" 	ZON_REGIO reg, ");
        query.append(" 	ZON_SUB_GEREN_VENTA sub, ");
        query.append("     ( SELECT ");
        query.append("         inc.CLIE_OID_CLIE ");
        query.append("       FROM ");
        query.append("         INC_EXIGE_CUMPL exig ");
        query.append("       WHERE ");
        query.append("         exig.COPA_OID_PARA_GRAL = ? ");
        parametros.add(concurso);
        query.append("         AND exig.IND_EXIG_CUMP = 1 ");
        query.append("         AND exig.FEC_CUMP <= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaHasta);
        query.append("     ) clieCump, ");
        query.append(" 	CRA_PERIO peri ");
        query.append(" WHERE ");
        query.append(" 	solConcPunt.SOCA_OID_SOLI_CABE = solCab.OID_SOLI_CABE ");
        query.append(
            "     AND solCab.ZTAD_OID_TERR_ADMI = terrAdmin.OID_TERR_ADMI ");

        // ------ Zonificación ------
        query.append(" 	AND terrAdmin.ZSCC_OID_SECC = secc.OID_SECC ");
        query.append(" 	AND secc.ZZON_OID_ZONA = zona.OID_ZONA ");
        query.append(" 	AND zona.ZORG_OID_REGI = reg.OID_REGI ");
        query.append(" 	AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");

        if (unidadAdm.getOidSeccion() != null) {
            query.append(" 	AND secc.OID_SECC = ? ");
            parametros.add(unidadAdm.getOidSeccion());
        } else if (unidadAdm.getOidZona() != null) {
            query.append(" 	AND zona.OID_ZONA = ? ");
            parametros.add(unidadAdm.getOidZona());
        } else if (unidadAdm.getOidRegion() != null) {
            query.append(" 	AND reg.OID_REGI = ? ");
            parametros.add(unidadAdm.getOidRegion());
        } else if (unidadAdm.getOidSubgerencia() != null) {
            query.append(" 	AND sub.OID_SUBG_VENT = ? ");
            parametros.add(unidadAdm.getOidSubgerencia());
        }

        // Fin Zonificación
        query.append(
            "  AND solConcPunt.CLIE_OID_CLIE = clieCump.CLIE_OID_CLIE ");
        query.append(" 	AND solConcPunt.COPA_OID_PARA_GRAL = ? ");
        parametros.add(concurso);
        query.append(" 	AND solConcPunt.CLIE_OID_CLIE_GERE = ? ");
        parametros.add(gerente);

        // ------ Filtro de período ------
        query.append(" 	AND peri.OID_PERI = solConcPunt.PERD_OID_PERI ");
        query.append(" 	AND peri.FEC_INIC >= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaDesde);
        query.append(" 	AND peri.FEC_FINA <= TO_DATE(?,'YYYY-MM-DD') ");
        parametros.add(strFechaHasta);

        // Fin Filtro de período
        query.append(" 	AND solCab.FEC_FACT IS NOT NULL ");
        query.append(" 	AND solCab.IND_OC = 1 ");
        
        query.append(" GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append(" 	sub.OID_SUBG_VENT, ");
        query.append(" 	reg.OID_REGI, ");
        query.append(" 	zona.OID_ZONA, ");
        query.append(" 	secc.OID_SECC ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.recuperarMontoUni"
            +"dadesConExigencias(Long gerente, Long concurso, Periodo periodo"
            +"Desde, Periodo periodoHasta,UnidadAdministrativa unidadAdm):Sali"
            +"da");

        return rs;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   12/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public HashMap recuperarCantidadConsultorasConMovimientos(
        UnidadAdministrativa uniAdmGer, Periodo periodoDesde,
        Periodo periodoHasta, Long diasGracia, Boolean filtroVencimiento, Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVentaRanking.ecuperarCantidad"
            +"ConsultorasConMovimientos(UnidadAdministrativa uniAdmGer, Perio"
            +"do periodoDesde, Periodo periodoHasta,Long diasGracia, Boolean "
            +"filtroVencimiento):Entrada");

        HashMap map = new HashMap();

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());
        
        Concurso concu = new DespacharPremiosHelper().obtenerConcurso( oidConcurso );

        query.append(" SELECT ");
        query.append("   COUNT(*) count, ");
        
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("   result.OID_SECC, ");
        query.append("   result.OID_ZONA, ");
        query.append("   result.OID_REGI, ");
        query.append("   result.OID_SUBG_VENT ");*/
        query.append( this.armarSelectAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );
        
        query.append(" FROM ");
        query.append("   (SELECT DISTINCT ");
        query.append("      sec.OID_SECC, ");
        query.append("      zon.OID_ZONA, ");
        query.append("      reg.OID_REGI, ");
        query.append("      sub.OID_SUBG_VENT, ");
        query.append("      mcc.CLIE_OID_CLIE, ");
        query.append("      mcc.FEC_VENC ");
        query.append("    FROM ");
        query.append("      MAE_CLIEN_UNIDA_ADMIN unida, ");
        query.append("      CRA_PERIO p1, ");
        query.append("      CRA_PERIO p2, ");
        query.append("      CRA_PERIO p3, ");
        query.append("      ZON_TERRI_ADMIN terr, ");
        query.append("      ZON_SECCI sec, ");
        query.append("      ZON_ZONA zon, ");
        query.append("      ZON_REGIO reg, ");
        query.append("      ZON_SUB_GEREN_VENTA sub, ");
        query.append("      CCC_MOVIM_CUENT_CORRI mcc ");
        query.append("    WHERE ");

        // Filtro de la unidad administrativa del cliente dentro de los perío
        //dos del concurso
        query.append("      unida.PERD_OID_PERI_INI = p1.OID_PERI ");
        query.append("      AND unida.PERD_OID_PERI_FIN = p2.OID_PERI(+) ");
        query.append(
            "      AND (p2.FEC_FINA IS NULL OR p2.FEC_FINA >= TO_DATE('" +
            strFechaDesde + "','YYYY-MM-DD')) ");
        query.append("      AND p1.FEC_INIC <= TO_DATE('" + strFechaHasta +
            "','YYYY-MM-DD') ");

        query.append("      AND mcc.CLIE_OID_CLIE = unida.CLIE_OID_CLIE ");
        query.append("      AND unida.IND_ACTI = 1 ");
        query.append("      AND unida.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append("      AND terr.ZSCC_OID_SECC = sec.OID_SECC ");
        query.append("      AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
        query.append("      AND zon.ZORG_OID_REGI = reg.OID_REGI ");
        query.append("      AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");

        // ---- Zonificación
        if (uniAdmGer.getOidSubgerencia() != null) {
            query.append("      AND sub.OID_SUBG_VENT = " +
                uniAdmGer.getOidSubgerencia());
        } else if (uniAdmGer.getOidRegion() != null) {
            query.append("      AND reg.OID_REGI = " +
                uniAdmGer.getOidRegion());
        } else if (uniAdmGer.getOidZona() != null) {
            query.append("      AND zon.OID_ZONA = " + uniAdmGer.getOidZona());
        } else if (uniAdmGer.getOidSeccion() != null) {
            query.append("      AND sec.OID_SECC = " +
                uniAdmGer.getOidSeccion());
        }

        // Fin zonificación
        if (filtroVencimiento.booleanValue()) {
            query.append("      AND (mcc.IMP_PEND <> 0  ");
            query.append(" OR mcc.FEC_ULTI_MOVI >  mcc.FEC_VENC + " +
                diasGracia + ") ");
        }

        // ---- Filtros de movimientos dentro de los períodos del concurso
        query.append("      AND mcc.PERD_OID_PERI = p3.OID_PERI ");
        query.append("      AND p3.FEC_INIC >= TO_DATE('" + strFechaDesde +
            "','YYYY-MM-DD') ");
        query.append("      AND p3.FEC_FINA <= TO_DATE('" + strFechaHasta +
            "','YYYY-MM-DD') ");
        query.append("      AND p3.FEC_INIC >= p1.FEC_INIC ");
        query.append(
            "      AND p3.FEC_FINA <= DECODE(p2.FEC_FINA,NULL,TO_DATE('" +
            strFechaHasta + "','YYYY-MM-DD'),p2.FEC_FINA) ");
        query.append("      AND p3.FEC_FINA <= SYSDATE - " + diasGracia);
        query.append("    ) result ");
        query.append(" GROUP BY ");
        /* BELC300024408 - gPineda - 03/11/2006
        query.append("   result.OID_SECC, ");
        query.append("   result.OID_ZONA, ");
        query.append("   result.OID_REGI, ");
        query.append("   result.OID_SUBG_VENT ");*/
        query.append( this.armarGroupByAgrupacionNivelRanking( concu.getNivelAgrupacionRanking() ) );

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        int rows = rs.getRowCount();

        for (int i = 0; i < rows; i++) {
            // Tomo información del registro
            Integer count = new Integer(((BigDecimal) rs.getValueAt(i, "COUNT")).intValue());
                
            // vbongiov -- 10/11/2006    
            BigDecimal oidSubgerenciaBigD = (BigDecimal) rs.getValueAt(i,"OID_SUBG_VENT");
            Long oidSubgerencia = oidSubgerenciaBigD!= null?new Long(oidSubgerenciaBigD.longValue()):null;
            
            BigDecimal oidRegionBigD = (BigDecimal) rs.getValueAt(i,"OID_REGI");
            Long oidRegion = oidRegionBigD!= null?new Long(oidRegionBigD.longValue()):null;
            
            BigDecimal oidZonaBigD = (BigDecimal) rs.getValueAt(i,"OID_ZONA");
            Long oidZona = oidZonaBigD!= null?new Long(oidZonaBigD.longValue()):null;
            
            BigDecimal oidSeccionBigD = (BigDecimal) rs.getValueAt(i,"OID_SECC");
            Long oidSeccion = oidSeccionBigD!= null?new Long(oidSeccionBigD.longValue()):null;
           
            // Asigno...
            UnidadAdministrativa uniAdm = new UnidadAdministrativa();
            uniAdm.setOidSubgerencia(oidSubgerencia);
            uniAdm.setOidRegion(oidRegion);
            uniAdm.setOidZona(oidZona);
            uniAdm.setOidSeccion(oidSeccion);

            // Agrego al hashmap
            map.put(uniAdm, count);
        }

        UtilidadesLog.debug("HashMap de UnidadAdministrativa: " + map);
        UtilidadesLog.info( "DAOCalculoVariablesVentaRanking.ecuperarCantidad"
            +"ConsultorasConMovimientos(UnidadAdministrativa uniAdmGer, Perio"
            +"do periodoDesde, Periodo periodoHasta,Long diasGracia, Boolean "
            +"filtroVencimiento):Salida");

        return map;
    }
    
    
    
    private String armarSelectAgrupacionNivelRanking(Long oidNivelAgrupacion){
        if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_GENERAL_RANKING) 
            || oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA_RANKING) ){
          return " OID_SUBG_VENT, null OID_REGI, null OID_ZONA, null OID_SECC ";
        } else if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_REGION_RANKING) ){
          return  " OID_SUBG_VENT, OID_REGI, null OID_ZONA, null OID_SECC ";
        } else if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_ZONA_RANKING) ){
          return  " OID_SUBG_VENT, OID_REGI, OID_ZONA, null OID_SECC ";
        } else if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_SECCION_RANKING) 
                  || oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_TERRITORIO_RANKING) ){
          return  " OID_SUBG_VENT, OID_REGI, OID_ZONA, OID_SECC ";
        }
        return null;
    }
    
    private String armarGroupByAgrupacionNivelRanking(Long oidNivelAgrupacion){
        if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_GENERAL_RANKING) 
            || oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA_RANKING) ){
          return " OID_SUBG_VENT ";
        } else if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_REGION_RANKING) ){
          return  " OID_SUBG_VENT, OID_REGI ";
        } else if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_ZONA_RANKING) ){
          return  " OID_SUBG_VENT, OID_REGI, OID_ZONA ";
        } else if( oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_SECCION_RANKING) 
                  || oidNivelAgrupacion.equals( ConstantesINC.OID_AGRUPACION_TERRITORIO_RANKING) ){
          return  " OID_SUBG_VENT, OID_REGI, OID_ZONA, OID_SECC ";
        }
        return null;
    }
}
