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
 * @author Sergio Platas
 * @date 25/07/2005
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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;


public class DAOConcursoEvolutivo {
    public DAOConcursoEvolutivo() {
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @autor: Sergio Platas
     * @param DTOE
     */
    public RecordSet recuperarConcursosRanking(DTOSiccPaginacion DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoEvolutivo.recuperarConcursosRanking( "
            +"DTOSiccPaginacion DTOE): Entrada");
        UtilidadesLog.debug("DTOSiccPaginacion: " + DTOE);

        BelcorpService bs = null;
        RecordSet rs = null;
        String codigoError = "";

        /* query : ok ! - 01/08/2005
        select cpg.OID_PARA_GRAL AS OID,
               cpg.NUM_CONC,
               cpg.VAL_NOMB,
               i18ntv.val_i18n DIRI_OID_DIRI,
               pdesde.VAL_NOMB_PERI DESDE,
                           phasta.VAL_NOMB_PERI HASTA,
               i18nbc.val_i18n BASE_CALCULO,
               i18nfc.val_i18n FORMA_CALCULO,
                           i18ntv.val_i18n TIPO_VENTA
        from   inc_concu_param_gener cpg,
               inc_param_ranki pr,
               inc_concu_param_geren cpgeren,
                           cra_perio pdesde,
                           cra_perio phasta,
               v_gen_i18n_sicc i18nbc,
               v_gen_i18n_sicc i18nfc,
                           v_gen_i18n_sicc i18ntv,
                           v_gen_i18n_sicc i18ndiri
        where  ind_rank = 1
        and    ind_acti = 1
        and    cpg.OID_PARA_GRAL = pr.COPA_OID_PARA_GRAL
        and    pr.TPRK_OID_TIPO_RANK = 1 --'%'     -- = 
            ConstantesINC.TIPO_RANKING_EVOLUTIVO
        and    cpg.OID_PARA_GRAL = cpgeren.COPA_OID_PARA_GRAL
        and    cpg.BCAL_OID_BASE_CALC = i18nbc.VAL_OID(+)
        and    cpgeren.FCAL_OID_FORM_CALC = i18nfc.VAL_OID
        and    i18nbc.ATTR_ENTI(+) = 'INC_BASE_CALCU'
                and    i18nbc.ATTR_NUM_ATRI(+) = 1
        and    i18nbc.IDIO_OID_IDIO(+) = 1  -- + DTOE.getOidIdioma()
        and    i18nfc.ATTR_ENTI = 'INC_FORMA_CALCU'
        and    i18nfc.IDIO_OID_IDIO = 1  -- + DTOE.getOidIdioma()
                and    i18nfc.ATTR_NUM_ATRI = 1
                and           i18ntv.VAL_OID(+) = cpgeren.TVEN_OID_TIPO_VENT
                and    i18ntv.ATTR_ENTI(+) = 'INC_TIPO_VENTA'
                and    i18ntv.IDIO_OID_IDIO(+) = 1 -- + DTOE.getOidIdioma()
                and    i18ntv.ATTR_NUM_ATRI(+) = 1
                and           i18ndiri.VAL_OID = cpg.DIRI_OID_DIRI
                and    i18ndiri.ATTR_ENTI = 'INC_DIRIG'
                and    i18ndiri.IDIO_OID_IDIO = 1 -- + DTOE.getOidIdioma()
                and    i18ndiri.ATTR_NUM_ATRI = 1
                and    pdesde.oid_peri = cpg.PERD_OID_PERI_DESD
                and           phasta.oid_peri = cpg.PERD_OID_PERI_HAST
         */
        StringBuffer query = new StringBuffer();

        query.append(" select cpg.OID_PARA_GRAL AS OID, ");
        query.append("        cpg.NUM_CONC, ");
        query.append("        cpg.VAL_NOMB, ");
        query.append("        i18ndiri.val_i18n DIRI_OID_DIRI, ");
        query.append("        pdesde.VAL_NOMB_PERI DESDE, ");
        query.append(" 	      phasta.VAL_NOMB_PERI HASTA, ");
        query.append("        i18nfc.val_i18n FORMA_CALCULO, ");
        query.append("        i18nbc.val_i18n BASE_CALCULO, ");
        query.append(" 	      NVL(i18ntv.val_i18n, i18ntv1.val_i18n) TIPO_VENTA, ");
        query.append("(case when ((pc.FEC_INIC <= TRUNC(SYSDATE)) and (pc.FEC_FINA >= TRUNC(SYSDATE))) ");
        query.append("    THEN '1' else '0'	end) indCalificar ");
        query.append(" from   inc_concu_param_gener cpg, ");
        query.append("        inc_param_ranki pr, ");
        query.append("        inc_concu_param_geren cpgeren, ");
        query.append("        INC_CONCU_PARAM_CONSU cpcons, ");
        query.append(" 	      cra_perio pdesde, ");
        query.append(" 	      cra_perio phasta, ");
        query.append(" 	      cra_perio pc, ");
        query.append("        v_gen_i18n_sicc i18nbc, ");
        query.append("        v_gen_i18n_sicc i18nfc, ");
        query.append(" 	      v_gen_i18n_sicc i18ntv, ");
        query.append(" 	      v_gen_i18n_sicc i18ntv1, ");        
        query.append(" 	      v_gen_i18n_sicc i18ndiri ");
        query.append(" where  ind_rank = 1 ");
        query.append(" and   ind_acti = 1 ");
        query.append(" and   cpg.OID_PARA_GRAL = pr.COPA_OID_PARA_GRAL ");
        query.append(" and   pr.TPRK_OID_TIPO_RANK = " +
            ConstantesINC.TIPO_RANKING_EVOLUTIVO);
        query.append(" and   cpg.OID_PARA_GRAL = cpgeren.COPA_OID_PARA_GRAL(+) ");
        query.append(" and   cpg.OID_PARA_GRAL = cpcons.COPA_OID_PARA_GRAL(+) ");
        query.append(" and   cpg.BCAL_OID_BASE_CALC = i18nbc.VAL_OID(+) ");
        query.append(" and   cpgeren.FCAL_OID_FORM_CALC = i18nfc.VAL_OID(+) ");
        query.append(" and   i18nbc.ATTR_ENTI(+) = 'INC_BASE_CALCU' ");
        query.append(" and   i18nbc.ATTR_NUM_ATRI(+) = 1 ");
        query.append(" and   i18nbc.IDIO_OID_IDIO(+) = " +
            DTOE.getOidIdioma());
        query.append(" and   i18nfc.ATTR_ENTI(+) = 'INC_FORMA_CALCU' ");
        query.append(" and   i18nfc.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
        query.append(" and   i18nfc.ATTR_NUM_ATRI(+) = 1 ");
        query.append(" and	 i18ntv.VAL_OID(+) = cpgeren.TVEN_OID_TIPO_VENT ");
        query.append(" and   i18ntv.ATTR_ENTI(+) = 'INC_TIPO_VENTA' ");
        query.append(" and   i18ntv.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
        query.append(" and   i18ntv.ATTR_NUM_ATRI(+) = 1 ");        
        query.append(" and	 i18ntv1.VAL_OID(+) = cpcons.TVEN_OID_TIPO_VENT ");
        query.append(" and   i18ntv1.ATTR_ENTI(+) = 'INC_TIPO_VENTA' ");
        query.append(" and   i18ntv1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
        query.append(" and   i18ntv1.ATTR_NUM_ATRI(+) = 1 ");        
        query.append(" and	 i18ndiri.VAL_OID = cpg.DIRI_OID_DIRI ");
        query.append(" and   i18ndiri.ATTR_ENTI = 'INC_DIRIG' ");
        query.append(" and   i18ndiri.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" and   i18ndiri.ATTR_NUM_ATRI = 1 ");
        query.append(" and   pdesde.oid_peri = cpg.PERD_OID_PERI_DESD ");
        query.append(" and	 phasta.oid_peri = cpg.PERD_OID_PERI_HAST ");
        query.append(" and   pc.oid_peri = pr.PERD_OID_PERI ");
        
        UtilidadesLog.debug("La query es = " + query.toString());

        try {
            String queryPagina = 
                UtilidadesPaginacion.armarQueryPaginacion(query.toString(),
                    DTOE);
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPagina);
            UtilidadesLog.debug("Se asignó query paginada al ROWSET 'rs' ");
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOConcursoEvolutivo.recuperarConcursosRanking"
                +"(DTOSiccPaginacion DTOE): Salida");

            String sCodigoError = CodigosError
                .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.debug("Sale de 'DAOConcursoEvolutivo.recuperarConcursos"
            +"Ranking()' retornando : " +rs.toString());
        UtilidadesLog.info("DAOConcursoEvolutivo.recuperarConcursosRanking"
            +"(DTOSiccPaginacion DTOE): Salida");

        return rs;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @autor: Sergio Platas
     * @param oidConcurso
     */
    public RecordSet recuperarNivelesConcursoEvolutivo(DTOOIDPaginado DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoEvolutivo.recuperarNivelesConcursoEvo"
            +"lutivo(DTOOIDPaginado DTOE): Entrada");

        BelcorpService bs = null;
        RecordSet rs = null;
        String codigoError = "";
        StringBuffer query = new StringBuffer();
        StringBuffer queryPaginado = new StringBuffer();

        query.append(" SELECT pnp.num_nive, pnp.num_cant_inic_punt, ");
        query.append("      pnp.num_cant_fina_punt, ");
        query.append("      pnp.num_aspi, pm.num_prem numero_premio, ");
        query.append("      pnp.oid_para_nive_prem oidparamnivelpremiacion, ");
        query.append("      pnp.tpre_oid_tipo_prem oidtipopremio,  ");
        query.append("      pm.oid_prem_mone oidpremio ");
        query.append(" FROM inc_concu_param_gener cpg, ");
        query.append("      inc_param_ranki pr,   ");
        query.append("      inc_param_nivel_premi pnp, ");
        query.append("      inc_param_gener_premi pgp, ");
        query.append("      inc_premi_monet pm ");
        query.append(" WHERE cpg.oid_para_gral = pr.copa_oid_para_gral ");
        query.append("   AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append("   AND pgp.oid_para_gene_prem =  ");
        query.append(" pnp.pagp_oid_para_gene_prem ");
        query.append("   AND pnp.tpre_oid_tipo_prem = " +
            ConstantesINC.OID_TIPO_PREMIO_MONETARIO);
        query.append("   AND pm.panp_oid_para_nive_prem =  ");
        query.append(" pnp.oid_para_nive_prem ");
        query.append("   AND cpg.oid_para_gral = " + DTOE.getOid());
        query.append(" UNION ");
        query.append(" SELECT pnp.num_nive, pnp.num_cant_inic_punt, ");
        query.append(" pnp.num_cant_fina_punt, ");
        query.append("      pnp.num_aspi, lpa.num_prem numero_premio,");
        query.append("      pnp.oid_para_nive_prem oidparamnivelpremiacion, ");
        query.append("      pnp.tpre_oid_tipo_prem oidtipopremio, ");
        query.append("      pa.oid_prem_arti oidpremio ");
        query.append("  FROM inc_concu_param_gener cpg, ");
        query.append("      inc_param_ranki pr, ");
        query.append("      inc_param_nivel_premi pnp, ");
        query.append("      inc_param_gener_premi pgp, ");
        query.append("      inc_premi_artic pa, ");
        query.append("      inc_lote_premi_artic lpa ");
        query.append(" WHERE cpg.oid_para_gral = pr.copa_oid_para_gral ");
        query.append("   AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append(
            "   AND pgp.oid_para_gene_prem = pnp.pagp_oid_para_gene_prem ");
        query.append("   AND pnp.tpre_oid_tipo_prem = " +
            ConstantesINC.OID_TIPO_PREMIO_ARTICULO);
        query.append(
            "   AND pa.panp_oid_para_nive_prem = pnp.oid_para_nive_prem ");
        query.append("   AND pa.oid_prem_arti = lpa.prar_oid_prem_arti ");
        query.append("   AND cpg.oid_para_gral = " + DTOE.getOid());
        query.append(" UNION ");
        query.append(" SELECT pnp.num_nive, pnp.num_cant_inic_punt, ");
        query.append(" pnp.num_cant_fina_punt, ");
        query.append("      pnp.num_aspi, pd.num_prem numero_premio, ");
        query.append("      pnp.oid_para_nive_prem oidparamnivelpremiacion, ");
        query.append("      pnp.tpre_oid_tipo_prem oidtipopremio,  ");
        query.append("      pd.oid_prem_desc oidpremio ");
        query.append(" FROM inc_concu_param_gener cpg, ");
        query.append("      inc_param_ranki pr, ");
        query.append("      inc_param_nivel_premi pnp, ");
        query.append("      inc_param_gener_premi pgp, ");
        query.append("      inc_premi_descu pd ");
        query.append(" WHERE cpg.oid_para_gral = pr.copa_oid_para_gral ");
        query.append("   AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append("   AND pgp.oid_para_gene_prem =  ");
        query.append("      pnp.pagp_oid_para_gene_prem ");
        query.append("   AND pnp.tpre_oid_tipo_prem = " +
            ConstantesINC.OID_TIPO_PREMIO_DESCUENTO);
        query.append("   AND pd.oid_para_nive_prem = pnp.oid_para_nive_prem ");
        query.append("   AND cpg.oid_para_gral = " + DTOE.getOid());
        query.append(" UNION ");
        query.append(" SELECT pnp.num_nive, pnp.num_cant_inic_punt,  ");
        query.append("      pnp.num_cant_fina_punt, ");
        query.append("      pnp.num_aspi, pp.num_prem numero_premio, ");
        query.append("      pnp.oid_para_nive_prem oidparamnivelpremiacion, ");
        query.append("      pnp.tpre_oid_tipo_prem oidtipopremio, ");
        query.append("      pp.oid_prem_punt oidpremio ");
        query.append(" FROM inc_concu_param_gener cpg, ");
        query.append("      inc_param_ranki pr, ");
        query.append("      inc_param_nivel_premi pnp, ");
        query.append("      inc_param_gener_premi pgp, ");
        query.append("      inc_premi_punto pp ");
        query.append(" WHERE cpg.oid_para_gral = pr.copa_oid_para_gral ");
        query.append("   AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append("   AND pgp.oid_para_gene_prem =  ");
        query.append("      pnp.pagp_oid_para_gene_prem ");
        query.append("   AND pnp.tpre_oid_tipo_prem = " +
            ConstantesINC.OID_TIPO_PREMIO_PUNTOS);
        query.append("   AND pp.panp_oid_para_nive_prem =  ");
        query.append("      pnp.oid_para_nive_prem ");
        query.append("   AND cpg.oid_para_gral = " + DTOE.getOid());
        query.append(" ORDER BY 1 DESC ");

        // Se hace el paginado.
        queryPaginado.append(" SELECT * FROM ( ");
        queryPaginado.append("     SELECT ROWNUM AS linea, queryPrincipal.* ");
        queryPaginado.append("     FROM ( ");
        queryPaginado.append(query.toString());
        queryPaginado.append("     )  queryPrincipal ");
        queryPaginado.append(" ) WHERE ROWNUM <= " + DTOE.getTamanioPagina() +
            " AND linea > " + DTOE.getIndicadorSituacion());

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPaginado.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOConcursoEvolutivo.recuperarNivelesConcurso"
                 +"Evolutivo(DTOOIDPaginado DTOE): Salida");

            String sCodigoError = CodigosError
                .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursoEvolutivo.recuperarNivelesConcursoEvo"
            +"lutivo(DTOOIDPaginado DTOE): Salida");

        return rs;
    }
}