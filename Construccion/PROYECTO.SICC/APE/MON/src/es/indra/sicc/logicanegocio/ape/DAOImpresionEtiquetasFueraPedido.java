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
 *
 */

package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOImpresionFP;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DAOImpresionEtiquetasFueraPedido {

    public RecordSet buscarEtiquetasFP(DTOImpresionFP dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.buscarEtiquetasFP(DTOImpresionFP dtoe): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        /* BELC400000177 - dmorello, 07/03/2007: Paso a agrupar etiquetas por lista de picado */
        //query.append("  SELECT listacab.cod_list_pica, ");
        query.append("  SELECT listacab.oid_list_pica_cabe AS OID, ");
        query.append("         listacab.cod_list_pica, ");
        query.append("         region.cod_regi, zona.cod_zona, seccion.cod_secc, ");
        //query.append("         NVL (listacab.num_agru,config.num_agrup) AS num_agru, ");
        /* dmorello, 19/06/2007 - Cambia el origen del dato num_agru*/
        //query.append("         listacab.num_agru, ");
        query.append("         config.num_agru, ");
        //query.append("         linea.num_etiq, etiqueta.oid_etiq ");
        query.append("         COUNT(DISTINCT etiqueta.oid_etiq) AS num_etiq ");
        query.append("    FROM ape_lista_picad_cabec listacab, ");
        query.append("         ape_lista_picad_detal listadet, ");
        query.append("         cra_perio periodo, ");
        query.append("         zon_regio region, ");
        query.append("         zon_zona zona, ");
        query.append("         zon_secci seccion, ");
        //query.append("         ape_confi_liafp config, ");
        query.append("         ape_confi_liafp_cabec config, ");  /* dmorello, 19/06/2007 */
        query.append("         ape_etiqu etiqueta, ");
        query.append("         ape_linea_armad linea, ");
        query.append("         ape_subli_armad sublinea, ");
        query.append("         ape_mapa_centr_distr_detal mcdd ");
        query.append("   WHERE listacab.ccdi_oid_conf_cent_dist = linea.ccdi_oid_conf_cent_dist ");
        query.append("     AND listacab.perd_oid_peri = periodo.oid_peri ");
        //query.append("     AND listacab.cafp_oid_conf_lafp = config.oid_conf_lafp ");
        query.append("     AND listacab.oid_list_pica_cabe = listadet.lpca_oid_list_pica_cabe ");
        /*
         * BELC300024709 - dmorello, 30/03/2007
         * Se elimina el acceso a la tabla APE_CONFI_LIAFP
         */
        //query.append("     AND (   (    listacab.num_agru IS NOT NULL ");
        ////query.append("              AND config.zscc_oid_secc = seccion.oid_secc ");
        ////query.append("              AND config.zzon_oid_zona = zona.oid_zona ");
        ////query.append("              AND config.zorg_oid_regi = region.oid_regi ");
        ////query.append("              AND listacab.zscc_oid_secc = seccion.oid_secc ");
        ////query.append("              AND listacab.zzon_oid_zona = zona.oid_zona ");
        //query.append("              AND EXISTS ( ");
        //query.append("                   SELECT config.oid_conf_lafp");
        //query.append("                     FROM ape_confi_liafp config");
        //query.append("                    WHERE config.num_agrup = listacab.num_agru");
        //query.append("                      AND config.zorg_oid_regi = region.oid_regi");
        //query.append("                      AND config.zzon_oid_zona = zona.oid_zona");
        //query.append("                      AND config.zscc_oid_secc = seccion.oid_secc) )");
        //query.append("          OR (    listacab.num_agru IS NULL ");
        query.append("              AND listacab.zscc_oid_secc = seccion.oid_secc (+) ");
        query.append("              AND listacab.zzon_oid_zona = zona.oid_zona (+) ");
        /* dmorello, 02/08/2007 */
        //query.append("              AND zona.zorg_oid_regi = region.oid_regi ");
        query.append("              AND listacab.zorg_oid_regi = region.oid_regi ");
        /* Fin dmorello 02/08/2007 */
        //query.append("             ) ");
        //query.append("         ) ");
        /* dmorello, 21/03/2007: Por modifiación en DECU, filtro por consolidado nulo */
        //query.append("     AND listacab.clie_oid_clie IS NULL ");
        query.append("     AND listacab.soca_oid_soli_cabe IS NULL ");
        /* dmorello, 19/07/2007: agrego outer join con ape_confi_liafp_cabec */
        query.append("     AND listacab.liac_oid_conf_lafp_cabe = config.oid_conf_lafp_cabe (+) ");
        query.append("     AND etiqueta.lpca_oid_list_pica_cabe = listacab.oid_list_pica_cabe ");
        query.append("     AND etiqueta.ccdi_oid_conf_cent_dist = listacab.ccdi_oid_conf_cent_dist ");
        query.append("     AND etiqueta.num_caja = listadet.num_caja ");
        query.append("     AND listadet.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        query.append("     AND mcdd.sbar_oid_subl_arma = sublinea.oid_subl_arma ");
        query.append("     AND sublinea.liar_oid_line_arma = linea.oid_line_arma ");
        if (dtoe.getOidCentroDistribucion() != null) {
            query.append(" AND listacab.ccdi_oid_conf_cent_dist = ");
            query.append(dtoe.getOidCentroDistribucion());
        }
        if (dtoe.getOidLineaArmado() != null) {
            query.append("     AND linea.oid_line_arma = ");
            query.append(dtoe.getOidLineaArmado());
        }
        if (dtoe.getOidMarca() != null) {
            query.append("     AND periodo.marc_oid_marc = ");
            query.append(dtoe.getOidMarca());
        }
        if (dtoe.getOidCanal() != null) {
            query.append("     AND periodo.cana_oid_cana = ");
            query.append(dtoe.getOidCanal());
        }
        if (dtoe.getOidRegion() != null) {
            query.append("     AND region.oid_regi = ");
            query.append(dtoe.getOidRegion());
        }
        if (dtoe.getOidZona() != null) {
            query.append("     AND zona.oid_zona = ");
            query.append(dtoe.getOidZona());
        }
        if (dtoe.getOidSeccion() != null) {
            query.append("     AND seccion.oid_secc = ");
            query.append(dtoe.getOidSeccion());
        }
        if (dtoe.getFecha() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            query.append("     AND TO_CHAR(listacab.fec_crea, 'DD/MM/YYYY') = ");
            query.append('\'').append(sdf.format(dtoe.getFecha())).append('\'');
        }
        query.append(" GROUP BY oid_list_pica_cabe, cod_list_pica, ");
        query.append("          cod_regi, cod_zona, cod_secc, ");
        //query.append("          NVL(listacab.num_agru,config.num_agrup) ");
        /* dmorello, 19/07/2007: cambia el origen del dato num_agru */
        //query.append("          listacab.num_agru ");
        query.append("            config.num_agru ");
        //query.append(" ORDER BY cod_list_pica, cod_regi, cod_zona, cod_secc, ");
        //query.append("          num_agru, num_etiq ");
        query.append(" ORDER BY cod_list_pica, cod_regi, cod_zona, cod_secc ");
        /* Fin BELC400000177 dmorello 07/03/2007 */
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.buscarEtiquetasFP(DTOImpresionFP dtoe): Entrada");
        return rs;        
    }
    

    /**
     * Recupera las etiquetas correspondientes a los OIDs de lista de picado
     * recibidos por parámetro. Creado por BELC400000177
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * @author dmorello
     * @since 07-03-2007
     */
    public DTOSalida buscarEtiquetasListaPicado(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.buscarEtiquetasListaPicado(DTOOIDs dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        Long[] oids = dtoe.getOids();
        
        query.append("   SELECT etiqueta.oid_etiq ");
        query.append("     FROM ape_lista_picad_cabec lista, ape_etiqu etiqueta ");
        query.append("    WHERE lista.oid_list_pica_cabe = etiqueta.lpca_oid_list_pica_cabe ");
        if (dtoe.getOids() != null && dtoe.getOids().length > 0) {
            query.append("  AND lista.oid_list_pica_cabe IN (");
            for (int i = 0; i < oids.length; ) {
                query.append(dtoe.getOids()[i]).append( (++i < oids.length)? ',' : ')' );
            }
        }
        query.append(" ORDER BY lista.oid_list_pica_cabe, etiqueta.num_caja ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.buscarEtiquetasListaPicado(DTOOIDs dtoe): Salida");
        return new DTOSalida(rs);
    }
    
    public void marcarEtiquetasComoImpresas(ArrayList oidsEtiquetas) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.marcarEtiquetasComoImpresas(Long oidEtiqueta): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append(" UPDATE APE_ETIQU SET IND_IMPR = '");
        update.append(ConstantesAPE.IMPRESION_SI).append("' WHERE OID_ETIQ IN (");
        for (int i = 0; i < oidsEtiquetas.size(); ) {
            update.append(oidsEtiquetas.get(i));
            update.append((++i < oidsEtiquetas.size())? ',' : ')');
        }
        
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.marcarEtiquetasComoImpresas(Long oidEtiqueta): Salida");
    }
    
    /**
     * Recupera info del formato de las etiquetas AFP cuyos OIDs vienen por parametro.
     * Es similar a DAOImpresionEtiquetasManual.recuperarFormatosEtiquetas(oids) pero 
     * sin tomar datos desde PED_SOLIC_CABEC.
     * @author eiraola
     * @since 08/Ago/2007
     * @observaciones
     *         Inc. LG_V400000046 16/10/2007 eiraola - Cambio de lado el Outer Join hacia TipoCajaEmbalaje
     */
    public RecordSet recuperarFormatosEtiquetasFP(DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.recuperarFormatosEtiquetasFP(DTOOIDs dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        Long[] oids = dtoE.getOids();
        if (oids == null) {
            UtilidadesLog.debug(" --- No hay oids de Etiqueta para las cuales buscar Formatos");
            UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.recuperarFormatosEtiquetasFP(DTOOIDs dtoE): Salida [vacio]");
            return rs;
        }
        StringBuffer query = new StringBuffer();
        
        // Consulta de Marta
        query.append("SELECT OID_ETIQ, ");
        query.append("       NUMEROETIQUETA, ");
        query.append("       COD_PERI, ");
        query.append("       COD_REGI, ");
        query.append("       COD_ZONA, ");
        query.append("       COD_SECC, ");
        query.append("       NUM_CAJA, ");
        query.append("       NUM_TOTA_CAJA, ");
        query.append("       NUM_SECU, ");
        query.append("       INRE_OID_INDI_REVI, ");
        query.append("       VAL_TEXT_CHEQ, ");
        query.append("       VAL_TEXT_PRIM_PEDI,  ");
        query.append("       NUM_LONG_NUME_ETIQ, ");
        query.append("       OID_SUBL_ARMA, ");
        query.append("       clie_oid_clie_list AS OID_CLIE, ");
        query.append("       VAL_TIPO_CAJA, ");
        query.append("       VAL_DENO, ");
        query.append("       NUM_ETIQ, ");
        query.append("       progr.VAL_NOMB_PROG AS NOMBR_PROGR, ");
        query.append("       NULL AS VAL_NUME_SOLI, ");
        query.append("       NULL AS COD_SUBT_CLIE, ");
        query.append("       COD_LIST_PICA ");
        query.append("  FROM ( ");
        query.append("        SELECT DISTINCT etiqueta.oid_etiq, ");
        query.append("               etiqueta.num_etiq AS numeroetiqueta, ");
        query.append("               pc.cod_peri, ");
        query.append("               etiqueta.num_caja, ");
        query.append("               etiqueta.num_tota_caja,  ");
        query.append("               etiqueta.num_secu, ");
        query.append("               listacab.clie_oid_clie AS clie_oid_clie_list, ");
        query.append("               listacab.inre_oid_indi_revi, ");
        query.append("               listacab.val_text_cheq, ");
        query.append("               listacab.val_text_prim_pedi, ");
        query.append("               linea.num_long_nume_etiq , ");
        query.append("               region.cod_regi, ");
        query.append("               zona.cod_zona, ");
        query.append("               tipocaja.VAL_TIPO_CAJA, ");
        query.append("               tipocaja.NUM_ETIQ, ");
        query.append("               seccion.COD_SECC,  ");
        query.append("               programa.OID_PROG_ETIQ oidPrograma, ");
        query.append("               programa.num_prio prioridad,  ");
        query.append("               sublinea.OID_SUBL_ARMA, ");
        query.append("               sociedad.VAL_DENO, ");
        query.append("               listacab.COD_LIST_PICA, ");
        query.append("               programa.val_nomb_prog, ");
        query.append("               MAX(programa.num_prio) OVER (PARTITION BY etiqueta.num_caja ORDER BY etiqueta.num_caja) AS maximaPrioridad ");
        query.append("          FROM APE_ETIQU etiqueta, ");
        query.append("               APE_LISTA_PICAD_CABEC listacab, ");
        query.append("               APE_LISTA_PICAD_DETAL listadet, ");
        query.append("               APE_MAPA_CENTR_DISTR_DETAL mcdd, ");
        query.append("               APE_TIPO_CAJA_EMBAL tipocaja, ");
        query.append("               APE_LINEA_ARMAD linea, ");
        query.append("               APE_SUBLI_ARMAD sublinea, ");
        query.append("               CRA_PERIO periodo, ");
        query.append("               seg_perio_corpo pc, ");
        query.append("               ZON_REGIO region, ");
        query.append("               ZON_ZONA zona, ");
        query.append("               ZON_SECCI seccion, ");
        query.append("               APE_FORMA_ETIQU formato, ");
        query.append("               ape_progr_etiqu programa, ");
        query.append("               APE_TIPO_SOLIC_LINEA tipoSoliLine, ");
        query.append("               PED_TIPO_SOLIC_PAIS tipoSoliPais, ");
        query.append("               SEG_SOCIE sociedad");
        query.append("         WHERE etiqueta.oid_etiq IN "+ this.armarListaSql("etiqueta.oid_etiq", oids) );
        query.append("           AND etiqueta.lpca_oid_list_pica_cabe = listacab.oid_list_pica_cabe ");
        query.append("           AND listadet.lpca_oid_list_pica_cabe = listacab.oid_list_pica_cabe ");
        query.append("           AND listadet.tcem_oid_tipo_caja_emba = tipocaja.oid_tipo_caja_emba (+)"); // Inc. LG_V400000046
        query.append("           AND listacab.ccdi_oid_conf_cent_dist = linea.ccdi_oid_conf_cent_dist ");
        query.append("           AND linea.oid_line_arma = sublinea.liar_oid_line_arma ");
        query.append("           AND etiqueta.num_caja = listadet.num_caja ");
        query.append("           AND listadet.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        query.append("           AND mcdd.sbar_oid_subl_arma = sublinea.oid_subl_arma ");
        query.append("           AND region.oid_regi = listacab.ZORG_OID_REGI ");
        query.append("           AND seccion.OID_SECC(+) = listacab.ZSCC_OID_SECC ");
        query.append("           AND zona.OID_ZONA(+) = listacab.ZZON_OID_ZONA ");
        query.append("           AND listacab.PERD_OID_PERI = periodo.OID_PERI ");
        query.append("           AND periodo.peri_oid_peri = pc.oid_peri ");
        query.append("           AND formato.PRET_OID_PROG_ETIQ = programa.oid_prog_etiq ");
        query.append("           AND sublinea.oid_subl_arma = formato.sbar_oid_subl_arma ");
        query.append("           AND tipoSoliLine.LIAR_OID_LINE_ARMA = linea.OID_LINE_ARMA ");
	      query.append("           AND tipoSoliLine.TSPA_OID_TIPO_SOLI_PAIS = tipoSoliPais.OID_TIPO_SOLI_PAIS ");
	      query.append("           AND tipoSoliPais.SOCI_OID_SOCI = sociedad.OID_SOCI ) datos, ");
        query.append("        ape_progr_etiqu progr ");
        query.append("  WHERE oidPrograma = progr.OID_PROG_ETIQ ");
        query.append("    AND progr.NUM_PRIO = maximaPrioridad ");
        
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" Error al recuperar FORMATOS de Etiquetas AFP");
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug(" --- rs: " + rs);
        
        UtilidadesLog.info("DAOImpresionEtiquetasFueraPedido.recuperarFormatosEtiquetasFP(DTOOIDs dtoE): Salida");
        return rs;
    }
    
    /**
     * Crea una lista SQL fragmentada cada 1000 elementos por restriccion del
     * operador IN.
     * Ej.: (1723, 1728,..... 1999) OR cac.clie_oid_clie IN (322, 4545,.....)
     * @author eiraola
     * @date 09/08/2007
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

}