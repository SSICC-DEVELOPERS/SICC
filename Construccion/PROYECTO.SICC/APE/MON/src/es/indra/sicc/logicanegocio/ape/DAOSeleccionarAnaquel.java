/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelBusqueda;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

public class DAOSeleccionarAnaquel {

    public DAOSeleccionarAnaquel() {
    }

    /**
     * Recupera los datos de la asignacion de un producto a anaquel.
     * @author eiraola
     * @since 13/Abr/2007
     * @observaciones
     *        22/Ago/2007 BELC400000628 eiraola - Solamente se consideran las Asignaciones prod/anaq de 
     *                                            la cabecera Activa para facturacion.
     *        03/09/2009 - dmorello, Cambio 20090839 - Recupero letra para anaquel de la sublinea
     */
    public DTOSalida obtenerAsignacionProductoAnaquel(DTOAsignacionProductoAnaquelBusqueda dtoE) 
            throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerAsignacionProductoAnaquel(dtoE): Entrada");
        
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT mad.OID_MAPA_CENT_DIST_DETA, ");
        query.append("       mad.NUM_ANAQ, ");
        query.append("       subli.LIAR_OID_LINE_ARMA, ");
        query.append("       liar.SICJ_OID_PROG_CUBI, ");
        query.append("       subli.OID_SUBL_ARMA, ");
        query.append("       subli.IND_IMPR_LIST_PICA, ");
        query.append("       subli.SIPI_OID_SIST_PICA, ");
        
        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        query.append("       subli.NUM_ORD_IMPR_SUBL, ");
        
        query.append("       pad.IND_SIGU_ASIG, ");
        query.append("       pad.OID_ASIG_PROD_ANAQ, ");
        query.append("       pac.OID_ASIG_PROD_ANAQ_CABE, ");
        query.append(      " NVL ((SELECT mzd.NUM_IDZO ");
        query.append(              " FROM APE_MAPA_ZONA_DETAL mzd ");
        query.append(              " WHERE mzd.MZCA_OID_MAPA_ZONA_CABE = pac.mzca_oid_mapa_zona_cabe ");
        query.append(                " AND mzd.SBAR_OID_SUBL_ARMA = subli.oid_subl_arma ");
        query.append(                " AND mzd.num_bahi_desd <= TO_NUMBER (SUBSTR (mad.num_anaq, 2, 2)) ");
        query.append(                " AND mzd.num_bahi_hast >= TO_NUMBER (SUBSTR (mad.num_anaq, 2, 2)) ");
        query.append(                " AND ROWNUM = 1), ");
        query.append(           " 1) AS IDZONA, ");
        query.append(      " NVL ((SELECT mzd.OID_MAPA_ZONA_DETA ");
        query.append(              " FROM APE_MAPA_ZONA_DETAL mzd ");
        query.append(             " WHERE mzd.MZCA_OID_MAPA_ZONA_CABE = pac.mzca_oid_mapa_zona_cabe ");
        query.append(               " AND mzd.SBAR_OID_SUBL_ARMA = subli.oid_subl_arma ");
        query.append(               " AND mzd.num_bahi_desd <= TO_NUMBER (SUBSTR (mad.num_anaq, 2, 2)) ");
        query.append(               " AND mzd.num_bahi_hast >= TO_NUMBER (SUBSTR (mad.num_anaq, 2, 2)) ");
        query.append(               " AND ROWNUM = 1), ");
        query.append(           " (SELECT mzd.OID_MAPA_ZONA_DETA ");
        query.append(              " FROM APE_MAPA_ZONA_DETAL mzd ");
        query.append(             " WHERE mzd.MZCA_OID_MAPA_ZONA_CABE = pac.mzca_oid_mapa_zona_cabe ");
        query.append(               " AND mzd.SBAR_OID_SUBL_ARMA = subli.oid_subl_arma ");
        query.append(               " AND mzd.NUM_IDZO = 1 ");
        query.append(               " AND ROWNUM = 1)) AS OIDMAPAZONADETALLE, ");
        query.append("       subli.cod_subl_arma codigoSublinea");
        query.append("     , subli.val_letr_para_anaq LETRAANAQUEL ");
        query.append("  FROM ape_asign_produ_anaqu_detal pad, ");
        query.append("       ape_asign_produ_anaqu_cabec pac, ");
        query.append("       ape_mapa_centr_distr_cabec mac, ");
        query.append("       ape_mapa_centr_distr_detal mad, ");
        query.append("       ape_subli_armad subli, ");
        query.append("       ape_linea_armad liar ");
        query.append(" WHERE pad.apac_oid_asig_prod_anaq_cabe = pac.oid_asig_prod_anaq_cabe ");
        query.append("   AND pac.IND_ACTI_FACT = '" + ConstantesAPE.ACTIVO_FACTURACION_S + "' "); // Agregado eiraola Inc. BELC400000628 22/08/2007
        query.append("   AND pac.perd_oid_peri = " + dtoE.getOidPeriodo());
        query.append("   AND pad.prod_oid_prod = " + dtoE.getOidProducto());
        query.append("   AND pac.mcdc_oid_mapa_cent_dist_cabe = mac.oid_mapa_cent_dist_cabe ");
        query.append("   AND mac.oid_mapa_cent_dist_cabe = " + dtoE.getOidMapaCDCabecera());
        query.append("   AND mac.oid_mapa_cent_dist_cabe = mad.mcdc_oid_mapa_cent_dist_cabe ");
        query.append("   AND mad.sbar_oid_subl_arma = subli.oid_subl_arma ");
        query.append("   AND subli.liar_oid_line_arma = liar.oid_line_arma ");
        query.append("   AND liar.oid_line_arma = " + dtoE.getOidLinea());
        query.append("   AND mad.oid_mapa_cent_dist_deta = pad.mcdd_oid_mapa_cent_dist_deta ");
        query.append("ORDER BY mad.NUM_ANAQ ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerAsignacionProductoAnaquel: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("rs: " + rs);
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerAsignacionProductoAnaquel(dtoE): Salida");
        return dtoSalida;
    }

    /**
     * Recupera, entre las lineas de armado que se pasan por parametro, aquellas
     * marcadas como Fuera de Pedido. Devuelve el oid de la Linea y los indicadores
     * que permiten conocer de cual de las listas de entrada forman parte (lineas del 
     * MapaCD o lineas por el TipoSolicitud).
     * @author eiraola
     * @since 13/Abr/2007
     * 
     * CHANGELOG
     * ---------
     * Cambio RI 20080528 - dmorello, 08/10/2008
     *    - Se elimina obtencion de flag "linea pertenece a mapa CD"
     *    - Se elimina parametro lineasMapaCD
     */
    public DTOSalida obtenerLineasAFP(DTOAsignacionProductoAnaquelBusqueda dtoE, 
            DTOOIDs lineasTipoSolicitud) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerLineasAFP(dtoE, lineasMapaCD, " +
                           "lineasTipoSolicitud): Entrada");

        int cantLineasTipoSoli = 0;
        StringBuffer listaLineasTipoSoli = null;
        
        if (lineasTipoSolicitud != null && lineasTipoSolicitud.getOids() != null 
                && lineasTipoSolicitud.getOids().length > 0) {
            cantLineasTipoSoli = lineasTipoSolicitud.getOids().length;
            listaLineasTipoSoli = this.armarListaSql("linea.OID_LINE_ARMA", lineasTipoSolicitud.getOids());
        }
        
        
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT linea.OID_LINE_ARMA, ");
        
        if (cantLineasTipoSoli > 0) {
            query.append("       CASE WHEN (linea.OID_LINE_ARMA IN "+ listaLineasTipoSoli +") ");
            query.append("            THEN " + ConstantesAPE.TRUE);
            query.append("            ELSE " + ConstantesAPE.FALSE);
            query.append("            END ");
        } else {
            query.append(ConstantesAPE.FALSE);
        }
        query.append("            AS INDTIPOSOLICITUD ");
        
        query.append("  FROM APE_LINEA_ARMAD linea ");
        query.append(" WHERE linea.CCDI_OID_CONF_CENT_DIST = " + dtoE.getOidCD());
        query.append("   AND linea.NUM_LINE_AFP = " + ConstantesAPE.TRUE);
        if (cantLineasTipoSoli > 0) {
            query.append("   AND linea.OID_LINE_ARMA IN "+ listaLineasTipoSoli +" ");
        }
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerLineasAFP: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("rs: " + rs);
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerLineasAFP(dtoE, lineasMapaCD, " +
                           "lineasTipoSolicitud): Salida");
        return dtoSalida;
    }

    /**
     * Recupera las lineas de armado de la cabecera de MapaCD.
     * @author eiraola
     * @since 13/Abr/2007
     */
    public DTOOIDs obtenerLineasMapaCD(Long oidMapaCDCabecera) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerLineasMapaCD(oidMapaCDCabecera): Entrada");
        
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT distinct sublinea.LIAR_OID_LINE_ARMA ");
        query.append("  FROM APE_MAPA_CENTR_DISTR_DETAL detalle, ");
        query.append("       APE_SUBLI_ARMAD sublinea ");
        query.append(" WHERE detalle.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCDCabecera);
        query.append("   AND detalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerLineasMapaCD: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("rs: " + rs);
        DTOOIDs dtoOids = new DTOOIDs();
        
        if (rs == null || rs.esVacio()) {
            UtilidadesLog.debug(" No se recuperaron Lineas de Armado para el MapaCD");
            return dtoOids;
        }
        
        int cantLineasMapaCD = rs.getRowCount();
        Long oids[] = new Long[cantLineasMapaCD];
        
        for (int i = 0; i < cantLineasMapaCD; i++) {
            oids[i] = new Long(((BigDecimal) rs.getValueAt(i, "LIAR_OID_LINE_ARMA")).longValue());
        }
        dtoOids.setOids(oids);
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerLineasMapaCD(oidMapaCDCabecera): Salida");
        return dtoOids;
    }

    /**
     * Recupera las lineas de armado correspondientes al Tipo Solicitud Pais que
     * se pasa por parametro.
     * @author eiraola
     * @since 13/Abr/2007
     */
    public DTOOIDs obtenerLineasTipoSolicitud(Long oidTipoSolicitudPais) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerLineasTipoSolicitud(oidTipoSolicitudPais): Entrada");
        
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT distinct tipoSolLinea.LIAR_OID_LINE_ARMA ");
        query.append("  FROM APE_TIPO_SOLIC_LINEA tipoSolLinea ");
        query.append(" WHERE tipoSolLinea.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerLineasTipoSolicitud: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("rs: " + rs);
        DTOOIDs dtoOids = new DTOOIDs();
        
        if (rs == null || rs.esVacio()) {
            UtilidadesLog.debug(" No se recuperaron Lineas de Armado para el TipoSolicitudPais");
            return dtoOids;
        }
        
        int cantLineas = rs.getRowCount();
        Long oids[] = new Long[cantLineas];
        
        for (int i = 0; i < cantLineas; i++) {
            oids[i] = new Long(((BigDecimal) rs.getValueAt(i, "LIAR_OID_LINE_ARMA")).longValue());
        }
        dtoOids.setOids(oids);
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerLineasTipoSolicitud(oidTipoSolicitudPais): Salida");
        return dtoOids;
    }

    /**
     * Recupera los anaqueles (APE: MapaCD Detalle) correspondientes a Postventa para 
     * la linea y MapaCD Cabecera del parametro.
     * @author eiraola
     * @since 13/Abr/2007
     * @observaciones
     *     03/09/2009 - dmorello, Cambio 20090839 - Recupero letra para anaquel de la sublinea
     */
    public RecordSet obtenerSublineasPostVenta(DTOAsignacionProductoAnaquelBusqueda dtoE) 
            throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.asignarSublineaPostVenta(dtoE): Entrada");
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT * FROM ( ");
        query.append("SELECT mapaCDDetalle.OID_MAPA_CENT_DIST_DETA, ");
        query.append("       mapaCDDetalle.NUM_ANAQ, ");
        query.append("       sublinea.OID_SUBL_ARMA, ");
        query.append("       sublinea.COD_SUBL_ARMA, ");
        query.append("       sublinea.VAL_LETR_PARA_ANAQ, ");
        query.append("       sublinea.IND_IMPR_LIST_PICA, ");
        query.append("       sublinea.SIPI_OID_SIST_PICA, ");
        
        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        query.append("       sublinea.NUM_ORD_IMPR_SUBL, ");
        
        query.append("       (SELECT linea.SICJ_OID_PROG_CUBI ");
        query.append("          FROM APE_LINEA_ARMAD linea ");
        query.append("         WHERE linea.OID_LINE_ARMA = sublinea.LIAR_OID_LINE_ARMA) SICJ_OID_PROG_CUBI, ");
        query.append("       NVL((SELECT mapaZonaDetalle.OID_MAPA_ZONA_DETA ");
        query.append("              FROM APE_MAPA_ZONA_CABEC mapaZonaCabecera, ");
        query.append("                   APE_MAPA_ZONA_DETAL mapaZonaDetalle ");
        query.append("             WHERE mapaZonaCabecera.MCDC_OID_MAPA_CENT_DIST_CABE = ");
        query.append("                   mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE ");
        query.append("               AND mapaZonaDetalle.MZCA_OID_MAPA_ZONA_CABE = mapaZonaCabecera.OID_MAPA_ZONA_CABE ");
        query.append("               AND mapaZonaDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
        query.append("               AND mapaZonaDetalle.NUM_BAHI_DESD <= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
        query.append("               AND mapaZonaDetalle.NUM_BAHI_HAST >= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
        query.append("               AND ROWNUM = 1), ");
        query.append("           (SELECT OID_MAPA_ZONA_DETA ");
        query.append("              FROM APE_MAPA_ZONA_DETAL ");
        query.append("             WHERE SBAR_OID_SUBL_ARMA = sublinea.LIAR_OID_LINE_ARMA ");
        query.append("               AND MZCA_OID_MAPA_ZONA_CABE IN (SELECT OID_MAPA_ZONA_CABE ");
        query.append("                                                 FROM APE_MAPA_ZONA_CABEC ");
        query.append("                                                WHERE MCDC_OID_MAPA_CENT_DIST_CABE = ");
        query.append("                                                      mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE) ");
        query.append("               AND NUM_IDZO = 1 ");
        query.append("               AND ROWNUM = 1) ");
        query.append("          ) OID_MAPA_ZONA_DETA, ");
        query.append("       NVL((SELECT mapaZonaDetalle.NUM_IDZO ");
        query.append("              FROM APE_MAPA_ZONA_CABEC mapaZonaCabecera, ");
        query.append("                   APE_MAPA_ZONA_DETAL mapaZonaDetalle ");
        query.append("             WHERE mapaZonaCabecera.MCDC_OID_MAPA_CENT_DIST_CABE = ");
        query.append("                   mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE ");
        query.append("               AND mapaZonaDetalle.MZCA_OID_MAPA_ZONA_CABE = mapaZonaCabecera.OID_MAPA_ZONA_CABE ");
        query.append("               AND mapaZonaDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
        query.append("               AND mapaZonaDetalle.NUM_BAHI_DESD <= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
        query.append("               AND mapaZonaDetalle.NUM_BAHI_HAST >= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
        query.append("               AND ROWNUM = 1), 1) NUM_IDZO, ");
        query.append("               anaquel.OID_ASIG_PROD_ANAQ    ");
        query.append("  FROM APE_SUBLI_ARMAD sublinea, ");
        query.append("       APE_MAPA_CENTR_DISTR_DETAL mapaCDDetalle, ");
        query.append("       APE_ASIGN_PRODU_ANAQU_DETAL anaquel, ");        
        query.append("       ape_asign_produ_anaqu_cabec pac ");
        query.append(" WHERE sublinea.LIAR_OID_LINE_ARMA = " + dtoE.getOidLinea()); // PARAMETRO
        query.append("   AND sublinea.IND_POST_VENT = " + ConstantesAPE.TRUE); // PARAMETRO (fijo)
        query.append("   AND mapaCDDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
        query.append("   AND mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoE.getOidMapaCDCabecera()); // PARAMETRO
        query.append("   AND mapaCDDetalle.OID_MAPA_CENT_DIST_DETA = anaquel.MCDD_OID_MAPA_CENT_DIST_DETA ");
        query.append("   AND anaquel.PROD_OID_PROD IS NULL "); 
        query.append("   AND anaquel.apac_oid_asig_prod_anaq_cabe = pac.oid_asig_prod_anaq_cabe ");
        query.append("   AND pac.IND_ACTI_FACT = '" + ConstantesAPE.ACTIVO_FACTURACION_S + "' "); 
        query.append("   AND pac.perd_oid_peri = " + dtoE.getOidPeriodo());
        query.append(" ORDER BY mapaCDDetalle.NUM_ANAQ ");
        query.append(" ) WHERE ROWNUM = 1  ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.asignarSublineaPostVenta: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if(rs != null && !rs.esVacio())
            UtilidadesLog.debug("rs Anaquel Vacio: " + rs);
        else {
            StringBuffer query2 = new StringBuffer();
            query2.append("  SELECT NUM_ANAQ FROM ( ");
            query2.append("  SELECT mapaCDDetalle.NUM_ANAQ ");
            query2.append("    FROM APE_SUBLI_ARMAD sublinea, ");
            query2.append("         APE_MAPA_CENTR_DISTR_DETAL mapaCDDetalle, ");
            query2.append("         APE_ANAQU_POST_VENTA pos ");
            query2.append(" WHERE sublinea.LIAR_OID_LINE_ARMA = " + dtoE.getOidLinea()); // PARAMETRO
            query2.append("   AND sublinea.IND_POST_VENT = " + ConstantesAPE.TRUE); 
            query2.append("   AND mapaCDDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
            query2.append("   AND mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoE.getOidMapaCDCabecera()); // PARAMETRO
            query2.append("   AND mapaCDDetalle.OID_MAPA_CENT_DIST_DETA = pos.MCDD_OID_MAPA_CENT_DIST_DETA ");
            query2.append(" ORDER BY pos.OID_ANAQ_POST_VENT DESC ");
            query2.append(" ) WHERE ROWNUM = 1 ");

            RecordSet rs2 = null;
            String oidMaximoAnaquel = null;
            try {
                rs2 = bs.dbService.executeStaticQuery(query2.toString());
                
                if(rs2!= null && !rs2.esVacio())
                    oidMaximoAnaquel = (String)rs2.getValueAt(0, 0);

                UtilidadesLog.debug("oidMaximoAnaquel: " + oidMaximoAnaquel);
            } catch (Exception e) {
                UtilidadesLog.error("<dao>.asignarSublineaPostVenta: Exception ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            StringBuffer query3 = new StringBuffer();
            query3.append("  SELECT MIN(mapaCdDetalle.Num_Anaq), MAX(mapaCdDetalle.Num_Anaq) ");
            query3.append("    FROM APE_SUBLI_ARMAD sublinea, ");
            query3.append("         APE_MAPA_CENTR_DISTR_DETAL mapaCDDetalle ");
            query3.append(" WHERE sublinea.LIAR_OID_LINE_ARMA = " + dtoE.getOidLinea()); // PARAMETRO
            query3.append("   AND sublinea.IND_POST_VENT = " + ConstantesAPE.TRUE); 
            query3.append("   AND mapaCDDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
            query3.append("   AND mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoE.getOidMapaCDCabecera()); // PARAMETRO

             RecordSet rs3 = null;
             String minimoAnaquel = null;
             String maximoAnaquel = null;
             boolean inicioAnaquel = false;
             
             try {
                 rs3 = bs.dbService.executeStaticQuery(query3.toString());
                 
                 minimoAnaquel = (String)rs3.getValueAt(0, 0);
                 maximoAnaquel = (String)rs3.getValueAt(0, 1);
                 
                 if(oidMaximoAnaquel == null)
                    inicioAnaquel = true;
                     
                 if((oidMaximoAnaquel != null) && oidMaximoAnaquel.equals(maximoAnaquel))
                    inicioAnaquel = true;

                 UtilidadesLog.debug("oidMaximoAnaquel: " + oidMaximoAnaquel);
             } catch (Exception e) {
                 UtilidadesLog.error("<dao>.asignarSublineaPostVenta: Exception ", e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
            
            query = new StringBuffer();
            query.append("SELECT * FROM ( ");
            query.append("SELECT mapaCDDetalle.OID_MAPA_CENT_DIST_DETA, ");
            query.append("       mapaCDDetalle.NUM_ANAQ, ");
            query.append("       sublinea.OID_SUBL_ARMA, ");
            query.append("       sublinea.COD_SUBL_ARMA, ");
            query.append("       sublinea.VAL_LETR_PARA_ANAQ, ");
            query.append("       sublinea.IND_IMPR_LIST_PICA, ");
            query.append("       sublinea.SIPI_OID_SIST_PICA, ");
            query.append("       sublinea.NUM_ORD_IMPR_SUBL, ");
            query.append("       (SELECT linea.SICJ_OID_PROG_CUBI ");
            query.append("          FROM APE_LINEA_ARMAD linea ");
            query.append("         WHERE linea.OID_LINE_ARMA = sublinea.LIAR_OID_LINE_ARMA) SICJ_OID_PROG_CUBI, ");
            query.append("       NVL((SELECT mapaZonaDetalle.OID_MAPA_ZONA_DETA ");
            query.append("              FROM APE_MAPA_ZONA_CABEC mapaZonaCabecera, ");
            query.append("                   APE_MAPA_ZONA_DETAL mapaZonaDetalle ");
            query.append("             WHERE mapaZonaCabecera.MCDC_OID_MAPA_CENT_DIST_CABE = ");
            query.append("                   mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE ");
            query.append("               AND mapaZonaDetalle.MZCA_OID_MAPA_ZONA_CABE = mapaZonaCabecera.OID_MAPA_ZONA_CABE ");
            query.append("               AND mapaZonaDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
            query.append("               AND mapaZonaDetalle.NUM_BAHI_DESD <= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
            query.append("               AND mapaZonaDetalle.NUM_BAHI_HAST >= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
            query.append("               AND ROWNUM = 1), ");
            query.append("           (SELECT OID_MAPA_ZONA_DETA ");
            query.append("              FROM APE_MAPA_ZONA_DETAL ");
            query.append("             WHERE SBAR_OID_SUBL_ARMA = sublinea.LIAR_OID_LINE_ARMA ");
            query.append("               AND MZCA_OID_MAPA_ZONA_CABE IN (SELECT OID_MAPA_ZONA_CABE ");
            query.append("                                                 FROM APE_MAPA_ZONA_CABEC ");
            query.append("                                                WHERE MCDC_OID_MAPA_CENT_DIST_CABE = ");
            query.append("                                                      mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE) ");
            query.append("               AND NUM_IDZO = 1 ");
            query.append("               AND ROWNUM = 1) ");
            query.append("          ) OID_MAPA_ZONA_DETA, ");
            query.append("       NVL((SELECT mapaZonaDetalle.NUM_IDZO ");
            query.append("              FROM APE_MAPA_ZONA_CABEC mapaZonaCabecera, ");
            query.append("                   APE_MAPA_ZONA_DETAL mapaZonaDetalle ");
            query.append("             WHERE mapaZonaCabecera.MCDC_OID_MAPA_CENT_DIST_CABE = ");
            query.append("                   mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE ");
            query.append("               AND mapaZonaDetalle.MZCA_OID_MAPA_ZONA_CABE = mapaZonaCabecera.OID_MAPA_ZONA_CABE ");
            query.append("               AND mapaZonaDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
            query.append("               AND mapaZonaDetalle.NUM_BAHI_DESD <= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
            query.append("               AND mapaZonaDetalle.NUM_BAHI_HAST >= TO_NUMBER ( SUBSTR (mapaCDDetalle.NUM_ANAQ, 2, 2) ) ");
            query.append("               AND ROWNUM = 1), 1) NUM_IDZO, ");
            query.append("               NULL OID_ASIG_PROD_ANAQ    ");
            query.append("  FROM APE_SUBLI_ARMAD sublinea, ");
            query.append("       APE_MAPA_CENTR_DISTR_DETAL mapaCDDetalle ");
            query.append(" WHERE sublinea.LIAR_OID_LINE_ARMA = " + dtoE.getOidLinea()); // PARAMETRO
            query.append("   AND sublinea.IND_POST_VENT = " + ConstantesAPE.TRUE); // PARAMETRO (fijo)
            query.append("   AND mapaCDDetalle.SBAR_OID_SUBL_ARMA = sublinea.OID_SUBL_ARMA ");
            query.append("   AND mapaCDDetalle.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoE.getOidMapaCDCabecera()); // PARAMETRO
            
            if(inicioAnaquel)
                query.append("   AND mapaCDDetalle.Num_Anaq = '" + minimoAnaquel + "'"); 
            else    
                query.append("   AND mapaCDDetalle.Num_Anaq > '" + oidMaximoAnaquel + "'"); 
                
            query.append(" ORDER BY mapaCDDetalle.NUM_ANAQ ");
            query.append(" ) WHERE ROWNUM = 1 ");

            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error("<dao>.asignarSublineaPostVenta: Exception ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            UtilidadesLog.debug("rs: " + rs);
            
        }
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.asignarSublineaPostVenta(dtoE): Salida");
        return rs;
    }

    /**
     * Actualiza el registro de APE: Asignacion de Prod / Anaquel Detalle cuyo oid 
     * pasamos por parametro, seteando a NULL el valor del campo Siguiente Asignacion 
     * del mismo.
     * @author eiraola
     * @since 13/Abr/2007
     */
    public void limpiarFlagSgteAsignacion(Long oidAsigProdAnaqDet) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.limpiarFlagSgteAsignacion(oidAsigProdAnaqDet): Entrada");
        if (oidAsigProdAnaqDet != null) {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            update.append("UPDATE APE_ASIGN_PRODU_ANAQU_DETAL apad  ");
            update.append("SET apad.IND_SIGU_ASIG = NULL ");
            update.append("WHERE apad.OID_ASIG_PROD_ANAQ = " + oidAsigProdAnaqDet); 
            
            try {
                int cantRegsModificados = bs.dbService.executeUpdate(update.toString());
                UtilidadesLog.debug("... se realizo el Update de " + cantRegsModificados + " registros");
            } catch (Exception e) {
                UtilidadesLog.error("<dao>.limpiarFlagSgteAsignacion: Exception", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSeleccionarAnaquel.limpiarFlagSgteAsignacion(oidAsigProdAnaqDet): Salida");
    }

    /**
     * Actualiza el registro de APE: Asignacion de Prod / Anaquel Detalle cuyo oid 
     * pasamos por parametro, seteando a "S" el valor del campo Siguiente Asignacion 
     * del mismo.
     * @author eiraola
     * @since 13/Abr/2007
     */
    public void asignarFlagSgteAsignacion(Long oidAsigProdAnaqDet) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.asignarFlagSgteAsignacion(oidAsigProdAnaqDet): Entrada");
        if (oidAsigProdAnaqDet != null) {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            update.append("UPDATE APE_ASIGN_PRODU_ANAQU_DETAL apad ");
            update.append("SET apad.IND_SIGU_ASIG = '" + ConstantesAPE.COD_SGTE_ASIGNACION + "' ");
            update.append("WHERE apad.OID_ASIG_PROD_ANAQ = " + oidAsigProdAnaqDet); 
            
            try {
                int cantRegsModificados = bs.dbService.executeUpdate(update.toString());
                UtilidadesLog.debug("... se realizo el Update de " + cantRegsModificados + " registros");
            } catch (Exception e) {
                UtilidadesLog.error("<dao>.asignarFlagSgteAsignacion: Exception", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSeleccionarAnaquel.asignarFlagSgteAsignacion(oidAsigProdAnaqDet): Salida");
    }

    /*
     * Actualiza el registro de APE: Anaquel Postventa localizandolo por su UK
     * y modificando el campo MapaCD Detalle (que es parte de la UK).
     * @author eiraola
     * @since 13/Abr/2007
     * @deprecated since 24/Jul/2007
     *
    public void actualizarAnaqPostventa(Long oidPeriodo, Long oidMapaCDDetalleAnterior, 
            Long oidMapaCDDetalleNuevo) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.actualizarAnaqPostventa(oidPeriodo, " +
                           "oidMapaCDDetalleAnterior, oidMapaCDDetalleNuevo): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE APE_ANAQU_POST_VENTA apv ");
        update.append("SET apv.MCDD_OID_MAPA_CENT_DIST_DETA = " + oidMapaCDDetalleNuevo + " ");
        update.append("WHERE apv.MCDD_OID_MAPA_CENT_DIST_DETA = " + oidMapaCDDetalleAnterior);
        update.append("  AND apv.PERD_OID_PERI = " + oidPeriodo);
        
        try {
            int cantRegsModificados = bs.dbService.executeUpdate(update.toString());
            UtilidadesLog.debug("... se realizo el Update de " + cantRegsModificados + " registros");
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.actualizarAnaqPostventa: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.actualizarAnaqPostventa(oidPeriodo, " +
                           "oidMapaCDDetalleAnterior, oidMapaCDDetalleNuevo): Salida");
    }*/
    
    /**
     * Inserta registro de APE: Anaquel Postventa. 
     * Metodo creado por Inc. BELC400000576/577.
     * La tabla en si, tiene como finalidad saber cuantos productos tiene asignado un anaquel 
     * de PostVenta, dato que se usa para elegir entre dichos anaqueles al momento de tener 
     * que asignar un nuevo producto a este tipo de anaquel.
     * @author eiraola
     * @since 26/Jul/2007
     */
    public void insertarAnaqPostventa(Long oidPeriodo, Long oidMapaCDDetalle, Long oidProducto) 
            throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.insertarAnaqPostventa(oidPeriodo, " +
                           "oidMapaCDDetalle, oidProducto): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer insert = new StringBuffer();
        
        insert.append("INSERT INTO APE_ANAQU_POST_VENTA ");
        insert.append("(OID_ANAQ_POST_VENT, MCDD_OID_MAPA_CENT_DIST_DETA, PERD_OID_PERI, PROD_OID_PROD) ");
        insert.append(" VALUES ");
        insert.append("(APE_APVN_SEQ.NEXTVAL, "+oidMapaCDDetalle+", "+oidPeriodo+", "+oidProducto+")");	   
        
        try {
            int cantRegsInsertados = bs.dbService.executeUpdate(insert.toString());
            UtilidadesLog.debug("... se realizo el Insert de " + cantRegsInsertados + " registros");
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.insertarAnaqPostventa: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.insertarAnaqPostventa(oidPeriodo, " +
                           "oidMapaCDDetalle, oidProducto): Salida");
    }

    /**
     * Recupera los registros de la entidad APE: Cabecera de Asignacion Prod / Anaquel 
     * correspondientes al periodo, a la Cabecera de MapaCD y cuya bandera de Activo 
     * Facturacion este en "S".
     * @author eiraola
     * @since 13/Abr/2007
     * 
     * CHANGELOG
     * ---------
     * Cambio RI 20080528 - dmorello, 08/10/2008
     *   - Se agrega parametro oidLinea
     *   - Se agrega filtro por mapa de zonas y oidLinea
     */
    public DTOOID obtenerAsigAnaqActivaFact(Long oidPeriodo, Long oidMapaCDCabecera, Long oidLinea) 
            throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerAsigAnaqActivaFact(oidPeriodo, oidMapaCDCabecera): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT cabecera.OID_ASIG_PROD_ANAQ_CABE ");
        query.append("  FROM APE_ASIGN_PRODU_ANAQU_CABEC cabecera, ");
        query.append(" (select distinct mapDet.MZCA_OID_MAPA_ZONA_CABE, subLin.LIAR_OID_LINE_ARMA ");
        query.append("  from APE_MAPA_ZONA_DETAL mapDet, APE_SUBLI_ARMAD subLin ");
        query.append("  where subLin.OID_SUBL_ARMA = mapDet.SBAR_OID_SUBL_ARMA ) mapLin ");
        query.append(" WHERE cabecera.PERD_OID_PERI = " + oidPeriodo);
        query.append("   AND cabecera.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCDCabecera);
        query.append("   AND cabecera.IND_ACTI_FACT = 'S'");
        query.append("   AND mapLin.MZCA_OID_MAPA_ZONA_CABE = cabecera.MZCA_OID_MAPA_ZONA_CABE ");
        query.append("   AND mapLin.LIAR_OID_LINE_ARMA = " + oidLinea);
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerAsigAnaqActivaFact: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        int cantReg = rs.getRowCount();
        DTOOID oidAsigAnaq = new DTOOID();
        
        if (cantReg == 0) {
            UtilidadesLog.debug("*** ATENCION: No hay Version ACTIVA FACTURACION (Asig Prod/Anaq Cabec) para el periodo y mapaCD");
            oidAsigAnaq.setOid(null);
        } else if (cantReg >= 1) {
            Long oidAsigAnaqActivFactu = new Long(((BigDecimal) rs.getValueAt(0, "OID_ASIG_PROD_ANAQ_CABE")).longValue());
            oidAsigAnaq.setOid(oidAsigAnaqActivFactu);
        }
        UtilidadesLog.debug(" retornamos oidAsigAnaqActivFactu: " + oidAsigAnaq.getOid());
        UtilidadesLog.info("DAOSeleccionarAnaquel.obtenerAsigAnaqActivaFact(oidPeriodo, oidMapaCDCabecera): Salida");
        return oidAsigAnaq;
    }

    /**
     * Realiza la insercion de un registro en la Tabla APE_ASIGN_PRODU_ANAQU_DETAL
     * @author eiraola
     * @since 13/Abr/2007
     */
    public void insertarAsigProdAnaq(Long oidCabecera, Long oidMapaCDDetalle, Long oidProducto, 
            Long oidProcedencia) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.insertarAsigProdAnaq(oidCabecera, oidMapaCDDetalle, " +
                           "oidProducto, codProcedencia, numAnaquel): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer insert = new StringBuffer();
        
        insert.append("INSERT INTO APE_ASIGN_PRODU_ANAQU_DETAL apad ( ");
        insert.append("   apad.OID_ASIG_PROD_ANAQ, ");
        insert.append("   apad.PRCE_OID_PROC, ");
        insert.append("   apad.APAC_OID_ASIG_PROD_ANAQ_CABE, ");
        insert.append("   apad.PROD_OID_PROD, ");
        insert.append("   apad.MCDD_OID_MAPA_CENT_DIST_DETA ");
        insert.append(" ) VALUES ( ");
        insert.append("   APE_APAN_SEQ.nextval, ");
        insert.append(    oidProcedencia + ", ");
        insert.append(    oidCabecera + ", ");
        insert.append(    oidProducto + ", ");
        insert.append(    oidMapaCDDetalle);
        insert.append(" )");
        
        try {
            int cantRegsInsertados = bs.dbService.executeUpdate(insert.toString());
            UtilidadesLog.debug("... se realizo el Insert de " + cantRegsInsertados + " registros");
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.insertarAsigProdAnaq: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.insertarAsigProdAnaq(oidCabecera, oidMapaCDDetalle, " +
                           "oidProducto, codProcedencia, numAnaquel): Salida");
    }
    
    /**
     * Crea una lista SQL fragmentada cada 1000 elementos por restriccion del
     * operador IN.
     * Ej.: (1723, 1728,..... 1999) OR cac.clie_oid_clie IN (322, 4545,.....)
     * @author eiraola
     * @since 11/Abr/2007
     */
    private StringBuffer armarListaSql(String nombreCampo, Long[] valoresLista) throws MareException {
        StringBuffer fragmentoQuery = new StringBuffer();
        int cantValores = valoresLista.length;
        
        fragmentoQuery.append("(");
        
        for (int i = 0; i < cantValores; i++) {
            if ( (i+1) < cantValores ) {
                if ((i+1)%1000 == 0) {
                    fragmentoQuery.append(valoresLista[i] + ") OR "+ nombreCampo +" IN (");
                } else {
                    fragmentoQuery.append(valoresLista[i] + ",");
                }
            } else {
                fragmentoQuery.append(valoresLista[i]);
            }
        }
        fragmentoQuery.append(")");
        
        return fragmentoQuery;
    }
 
    // sapaza -- Cambios para WCS y MUO -- 17/11/2011
    /**
     * Realiza la actualizacion de un registro en la Tabla APE_ASIGN_PRODU_ANAQU_DETAL
     * 
     * @author sapaza
     * @since 17/11/2011
     */
    public void actualizarAsigProdAnaq(Long oid, Long oidProducto, Long oidProcedencia) throws MareException {
        UtilidadesLog.info("DAOSeleccionarAnaquel.actualizarAsigProdAnaq(oid, oidProducto, oidProcedencia): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append(" UPDATE APE_ASIGN_PRODU_ANAQU_DETAL ");
        update.append("    SET PROD_OID_PROD = " + oidProducto);
        update.append("      , PRCE_OID_PROC = " + oidProcedencia);
        update.append("  WHERE OID_ASIG_PROD_ANAQ = " + oid);
        
        try {
            int cantRegs = bs.dbService.executeUpdate(update.toString());
            UtilidadesLog.debug("... se realizo el Update de " + cantRegs + " registros");
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.actualizarAsigProdAnaq: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSeleccionarAnaquel.actualizarAsigProdAnaq(oid, oidProducto, oidProcedencia): Salida");
    }
    
}