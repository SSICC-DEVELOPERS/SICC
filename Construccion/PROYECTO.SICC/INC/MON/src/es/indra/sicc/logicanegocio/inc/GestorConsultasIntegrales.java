package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;

public class GestorConsultasIntegrales {
    public GestorConsultasIntegrales() { }

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
	public CadenaFiltro getCadenaFiltroUnidadAdmin(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaFiltroUnidadAdmin(DTOCabeceraConsultaIntegral dtoCab): Entrada");

		CadenaFiltro cadenaFiltro = new CadenaFiltro();

		if(dtoCab.getOidSeccion()!=null) {
			StringBuffer sb1 = new StringBuffer();
			sb1.append(" AND EXISTS (SELECT 1  ");
			sb1.append(" FROM INC_AMBIT_GEOGR AMB,  ");
			sb1.append(" INC_CONCU_PARAM_GENER CPG1  ");
            sb1.append(" WHERE 1=1  ");
            
            if(dtoCab.getOidConcurso()!=null) {
                sb1.append(" AND CPG1.OID_PARA_GRAL = " + dtoCab.getOidConcurso());    
            }
			
			sb1.append(" AND AMB.COPA_OID_PARA_GRAL(+) = CPG1.OID_PARA_GRAL  ");
			sb1.append(" AND AMB.ZSCC_OID_SECC(+) = ?) ");

			cadenaFiltro.concatenar(sb1);
			cadenaFiltro.concatenarParametro(dtoCab.getOidSeccion());
		}

		if(dtoCab.getOidZona()!=null) {
			StringBuffer sb2 = new StringBuffer();

			sb2.append(" AND EXISTS (SELECT 1  ");
			sb2.append(" FROM INC_AMBIT_GEOGR AMB,  ");
			sb2.append(" INC_CONCU_PARAM_GENER CPG1  ");
            sb2.append(" WHERE 1=1  ");
            
            if(dtoCab.getOidConcurso()!=null) {
                sb2.append(" AND CPG1.OID_PARA_GRAL = " + dtoCab.getOidConcurso());    
            }			
            
			sb2.append(" AND AMB.COPA_OID_PARA_GRAL(+) = CPG1.OID_PARA_GRAL  ");
			sb2.append(" AND AMB.ZZON_OID_ZONA(+) = ?)  ");

			cadenaFiltro.concatenar(sb2);
			cadenaFiltro.concatenarParametro(dtoCab.getOidZona());
		}

		if(dtoCab.getOidRegion()!=null) {
			StringBuffer sb3 = new StringBuffer();

			sb3.append(" AND EXISTS (SELECT 1  ");
			sb3.append(" FROM INC_AMBIT_GEOGR AMB,  ");
			sb3.append(" INC_CONCU_PARAM_GENER CPG1  ");
			sb3.append(" WHERE 1=1  ");
            
            if(dtoCab.getOidConcurso()!=null) {
                sb3.append(" AND CPG1.OID_PARA_GRAL = " + dtoCab.getOidConcurso());    
            }            
            
			sb3.append(" AND AMB.COPA_OID_PARA_GRAL(+) = CPG1.OID_PARA_GRAL  ");
			sb3.append(" AND AMB.ZORG_OID_REGI(+) = ?)  ");

			cadenaFiltro.concatenar(sb3);
			cadenaFiltro.concatenarParametro(dtoCab.getOidRegion());		
		}

		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaFiltroUnidadAdmin(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       21/06/2006
    * Incidencia:  DBLG500000923
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public CadenaFiltro getQueryPremiosProceGral(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceGral(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
    
    //Agregado - Cristian Valenzuela - 21/06/2006
    cadenaFiltro.concatenar(new StringBuffer(this.getQueryInicioPaginado()));    
    //FIN - Agregado - Cristian Valenzuela - 21/06/2006
		cadenaFiltro.concatenar(new StringBuffer(" SELECT * FROM ( "));
		cadenaFiltro.concatenar(getQueryPremiosProceArticulo(dtoCab));
		cadenaFiltro.concatenar(new StringBuffer(" UNION ALL "));
		cadenaFiltro.concatenar(getQueryPremiosProceMonetario(dtoCab));
		cadenaFiltro.concatenar(new StringBuffer(" UNION ALL "));
		cadenaFiltro.concatenar(getQueryPremiosProcePuntos(dtoCab));
		cadenaFiltro.concatenar(new StringBuffer(" UNION ALL "));
		cadenaFiltro.concatenar(getQueryPremiosProceDescuento(dtoCab));
		cadenaFiltro.concatenar(new StringBuffer(" ) WHERE 1=1 "));
		cadenaFiltro.concatenar(getFiltrosGralDetalle(dtoCab));
		cadenaFiltro.concatenar(new StringBuffer(" ORDER BY FECHA_OBTENCION DESC "));
    //Agregado - Cristian Valenzuela - 21/06/2006
    cadenaFiltro.concatenar(new StringBuffer(this.getQueryFinPaginado(dtoCab)));    
    //FIN - Agregado - Cristian Valenzuela - 21/06/2006

		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceGral(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}	

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       30/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       11/1/2006
    * Incidencia:  BELC300022389
    * 
    * Modificado:  Hugo Cordero
    * Fecha:       08/02/2007
    * Nota: Este metodo incluye todas las incidencias resueltas hasta esta fecha en el eevolutivo.
    * 
    * Modificado:  Hugo Cordero
    * Fecha:       15/02/2007
    * Nota: Se modificaron los querys y se agrego un nuevo query (cuarto)
    */
	public CadenaFiltro getQueryDetalleConcurso(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		 UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleConcurso"+
         "(DTOCabeceraConsultaIntegral dtoCab): Entrada");

		 CadenaFiltro cadenaFiltro = new CadenaFiltro();
		 StringBuffer sb1 = new StringBuffer();
    
         //--------------------------------------------------------------------------------------------
         //
         // PRIMER QUERY: Obtiene los registros de monto unidades y numero de pedidos
         //
         //--------------------------------------------------------------------------------------------
         sb1.append(" SELECT ");
         sb1.append("  cpg.oid_para_gral oid_concurso,  ");
         sb1.append("  iscp_psc.clie_oid_clie, spc.cod_peri,  ");
         sb1.append("  NVL (ISCP_PSC.IND_ANUL, 0) ANULACION,  ");
         sb1.append("  NVL (pts.ind_devo, 0) devolucion,  ");
         sb1.append("  iscp_psc.fec_docu fec_movi, ");
         sb1.append("  iscp_psc.val_nume_soli,  ");
         sb1.append("  (SELECT idio.val_i18n    FROM v_gen_i18n_sicc idio    WHERE idio.attr_enti = 'PED_TIPO_SOLIC'      ");
         sb1.append("   AND idio.idio_oid_idio = ?      AND idio.val_oid = pts.oid_tipo_soli) tipo_documento,    ");
         sb1.append("   DECODE( DECODE( NVL(ISCP_PSC.IND_ANUL, 0), 1, 1, DECODE( NVL(pts.ind_devo, 0), 1, 1, 0) ), 0,    ");
         sb1.append("   (SELECT idio.val_i18n     FROM v_gen_i18n_sicc idio     WHERE idio.attr_enti = 'INC_TIPO_MOVIM'     AND idio.idio_oid_idio = ?     AND idio.val_oid = "+ ConstantesINC.TIPO_MOVIMIENTO_ABONO +"),    ");
         sb1.append("   (SELECT idio.val_i18n     FROM v_gen_i18n_sicc idio     WHERE idio.attr_enti = 'INC_TIPO_MOVIM'     AND idio.idio_oid_idio = ?     AND idio.val_oid = "+ ConstantesINC.TIPO_MOVIMIENTO_CARGO +")    ");
         sb1.append("  ) tipo_movimiento,    ");
         sb1.append("  DECODE(DECODE(NVL (ISCP_PSC.IND_ANUL, 0),1,1,DECODE(NVL (pts.ind_devo, 0),1,1,0)),0, "+ ConstantesINC.TIPO_MOVIMIENTO_ABONO +","+ ConstantesINC.TIPO_MOVIMIENTO_CARGO +") oid_tipo_movimiento,  ");
         sb1.append("  DECODE((pts.ind_devo+ISCP_PSC.IND_ANUL), 1, (NVL(iscp_psc.num_punt,0) - NVL(iscp_psc.val_punt_boni,0) - NVL(iscp_psc.val_punt_falt_nanu,0)) * -1 ");
         sb1.append("         ,(NVL(iscp_psc.num_punt,0) - NVL(iscp_psc.val_punt_boni,0) - NVL(iscp_psc.val_punt_falt_nanu,0)))puntaje_facturado, ");
         sb1.append("  DECODE((pts.ind_devo+ISCP_PSC.IND_ANUL), 1, NVL(iscp_psc.val_punt_boni, 0)*-1, NVL(iscp_psc.val_punt_boni, 0)) puntaje_bonificado,  ");
         sb1.append("  DECODE((pts.ind_devo+ISCP_PSC.IND_ANUL), 1, NVL(iscp_psc.val_punt_falt_nanu, 0)*-1, NVL(iscp_psc.val_punt_falt_nanu, 0)) punt_falt_nanu,  ");
         sb1.append("  DECODE((pts.ind_devo+ISCP_PSC.IND_ANUL), 1, NVL(iscp_psc.num_punt,0)*-1, NVL(iscp_psc.num_punt,0)) total_puntaje,	  ");
         sb1.append("  periodo_actual.fecha_inicio,  ");
         sb1.append("  NVL ((SELECT   MAX (pnp_na.num_nive) nivel           ");
         sb1.append("        FROM inc_ganad gan_na, inc_param_nivel_premi pnp_na, inc_param_gener_premi pgp_na          ");
         sb1.append("        WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem            AND ");
         sb1.append("              pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem            AND ");
         sb1.append("              pgp_na.copa_oid_para_gral = cpg.oid_para_gral            AND ");
         sb1.append("              gan_na.clie_oid_clie = iscp_psc.clie_oid_clie       ");
         sb1.append("        GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie),      0) nivel,  ");
         sb1.append("       (SELECT DISTINCT cga.clie_oid_clie              ");
         sb1.append("        FROM inc_candi_ganad cga             ");
         sb1.append("        WHERE cga.copa_oid_para_gral = cpg.oid_para_gral               AND ");
         sb1.append("              cga.clie_oid_clie = iscp_psc.clie_oid_clie) cliente_candidato,  ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         sb1.append("        spc.cod_peri periodo  ");
         sb1.append("        , 0 DESCALIFICA ");
         // vbongiov --  RI 20070481 -- 29/08/2008         
         sb1.append("        , (SELECT CCP.VAL_DESC ");
         sb1.append("           FROM inc_cuent_corri_punto ccp ");
         sb1.append("           WHERE ccp.clie_oid_clie = iscp_psc.clie_oid_clie ");
         sb1.append("           AND ccp.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("           AND ccp.perd_oid_peri = iscp_psc.perd_oid_peri  ");
         sb1.append("           AND ((ccp.tmov_oid_tipo_movi = 1 AND (iscp_psc.ind_anul = 0 AND pts.ind_devo = 0))  ");
         sb1.append("            OR (ccp.tmov_oid_tipo_movi = 2 AND (iscp_psc.ind_anul = 1 OR pts.ind_devo = 1)))  ");
         sb1.append("           AND ROWNUM = 1) VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    ,mtv.IMP_MONTO_VENTA IMP_MONTO_VENTA  ");
         sb1.append(" FROM    ");
         sb1.append("     (SELECT iscp.num_punt, ");
         sb1.append("             iscp.val_punt_boni,          ");
         sb1.append("             iscp.val_punt_falt_nanu,          ");
         sb1.append("             iscp.fec_docu, iscp.ind_anul,          ");
         sb1.append("             iscp.copa_oid_para_gral,          ");
         sb1.append("             iscp.soca_oid_soli_cabe,          ");
         sb1.append("             iscp.perd_oid_peri,          ");
         sb1.append("             iscp.clie_oid_clie,          ");
         sb1.append("             psc.val_nume_soli,          ");
         sb1.append("             psc.tspa_oid_tipo_soli_pais     ");
         sb1.append("      FROM inc_solic_concu_punta iscp,  ");
         sb1.append("           ped_solic_cabec psc    ");
         sb1.append("      WHERE iscp.soca_oid_soli_cabe = psc.oid_soli_cabe) iscp_psc,  ");
         sb1.append("            inc_concu_param_gener cpg,  ");
         sb1.append("            cra_perio crp,  ");
         sb1.append("            seg_perio_corpo spc,  ");
         sb1.append("            ped_tipo_solic_pais ptsp,  ");
         sb1.append("            ped_tipo_solic pts,  ");
         sb1.append("     (SELECT fec_inic fecha_inicio,          ");
         sb1.append("             fec_fina fecha_fin,          "); 
         sb1.append("             crp.pais_oid_pais,          ");
         sb1.append("             crp.marc_oid_marc,          ");
         sb1.append("             crp.cana_oid_cana, ");
         sb1.append("             crp.oid_peri     ");
         sb1.append("      FROM cra_perio crp, ");
         sb1.append("           seg_perio_corpo spc    ");
         sb1.append("      WHERE crp.peri_oid_peri = spc.oid_peri      AND ");
         sb1.append("            crp.fec_inic <= TRUNC (SYSDATE)      AND ");
         sb1.append("            crp.fec_fina >= TRUNC (SYSDATE)      AND ");
         sb1.append("      ROWNUM = 1) periodo_actual,  ");
         sb1.append("     (SELECT *     FROM inc_metas_tipo_venta mtv    ");
         sb1.append("      WHERE mtv.clie_oid_clie = ?      AND ");
         sb1.append("            mtv.copa_oid_para_gral = ?) mtv,  ");
         sb1.append("      INC_PLANT_CONCU PLA  ");
         sb1.append(" WHERE   ");
         sb1.append("      iscp_psc.copa_oid_para_gral = cpg.oid_para_gral  AND ");
         sb1.append("      iscp_psc.perd_oid_peri = crp.oid_peri  AND ");
         sb1.append("      crp.pais_oid_pais = cpg.pais_oid_pais  AND ");
         sb1.append("      crp.marc_oid_marc = cpg.marc_oid_marc  AND ");
         sb1.append("      crp.cana_oid_cana = cpg.cana_oid_cana  AND ");
         sb1.append("      crp.peri_oid_peri = spc.oid_peri  AND ");
         sb1.append("      iscp_psc.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais(+)  AND ");
         sb1.append("      ptsp.tsol_oid_tipo_soli = pts.oid_tipo_soli(+)  AND ");
         sb1.append("      crp.fec_fina <= periodo_actual.fecha_inicio(+)  AND ");
         sb1.append("      cpg.oid_para_gral = NVL (mtv.copa_oid_para_gral, cpg.oid_para_gral)  AND ");
         sb1.append("      iscp_psc.clie_oid_clie = mtv.clie_oid_clie(+)  AND ");
         sb1.append("      cpg.pais_oid_pais = NVL (periodo_actual.pais_oid_pais, cpg.pais_oid_pais)  AND ");
         sb1.append("      cpg.marc_oid_marc = NVL (periodo_actual.marc_oid_marc, cpg.marc_oid_marc)  AND ");
         sb1.append("      cpg.cana_oid_cana = NVL (periodo_actual.cana_oid_cana, cpg.cana_oid_cana)  AND ");
         sb1.append("      cpg.bcal_oid_base_calc <> "+ ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS +" AND ");
         sb1.append("      cpg.plc2_oid_plan_conc = pla.oid_plan_conc(+)  AND ");
         sb1.append("      pla.IND_PROG_NUEV(+) = 0 ");
         // -------------------
         //
         // -------------------
         // vbongiov --12/06/2008
         // No esta mostrando todos los registros en inc_cuent_corri_punto 
         // porque los campos a mostrar son iguales, para solucionarlo se agrega el ALL
         sb1.append(" UNION  ALL ");
         sb1.append(" select ");
         sb1.append("     icc.copa_oid_para_gral oid_concurso, ");
         sb1.append("     icc.clie_oid_clie      clie_oid_clie, ");
         sb1.append("     spc.cod_peri           cod_peri,      ");
         sb1.append("     null                   anulacion,     ");
         sb1.append("     null                   devolucion,    ");
         sb1.append("     icc.fec_movi           fec_movi,      ");
         sb1.append("     null,                                 ");
         sb1.append("     icc.val_desc,                         ");
         sb1.append("    (SELECT idio.val_i18n                  ");
         sb1.append("       FROM v_gen_i18n_sicc idio           ");
         sb1.append("      WHERE idio.attr_enti = 'INC_TIPO_MOVIM' ");
         sb1.append("       AND idio.idio_oid_idio = " + dtoCab.getOidIdioma());
         sb1.append("       AND idio.val_oid       = icc.tmov_oid_tipo_movi) tipo_movimiento,   ");
         sb1.append("     icc.tmov_oid_tipo_movi                             oid_tipo_movimiento,    ");
         sb1.append("     icc.num_punt                                       puntaje_facturado, ");
         sb1.append("     null, ");
         sb1.append("     null, ");
         sb1.append("     icc.num_punt                                       total_puntaje, ");
         sb1.append("     null, ");
         sb1.append("     null, ");
         sb1.append("     null, ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         //sb1.append("     null                                               meta, ");
         sb1.append("     spc.cod_peri                                       periodo, ");
         sb1.append("     0                                                  descalifica ");
         // vbongiov --  RI 20070481 -- 29/08/2008
         sb1.append("     ,icc.VAL_DESC VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    , NULL IMP_MONTO_VENTA  ");
         sb1.append(" from ");
         sb1.append("     inc_cuent_corri_punto icc, ");
         sb1.append("     cra_perio             crp, ");
         sb1.append("     seg_perio_corpo       spc  ");
         sb1.append(" where ");
         sb1.append("     1=1 ");
         sb1.append(" and icc.clie_oid_clie            = " + dtoCab.getOidCliente() );
         sb1.append(" and icc.copa_oid_para_gral       = " + dtoCab.getOidConcurso() );
         sb1.append(" and upper (icc.val_desc)         like upper ('PUNTOS_POR_VENTA_ECM_CLIENTE') ");
         sb1.append(" and crp.oid_peri                 = icc.perd_oid_peri ");
         sb1.append(" and spc.oid_peri                 = crp.peri_oid_peri ");          

         //--------------------------------------------------------------------------------------------
         //
         // SEGUNDO QUERY: Para obtener el valor del abono de la solicitud original devuelta o anulada   
         //
         //--------------------------------------------------------------------------------------------
         // vbongiov --12/06/2008
         // No esta mostrando todos los registros en inc_cuent_corri_punto 
         // porque los campos a mostrar son iguales, para solucionarlo se agrega el ALL
         sb1.append(" UNION ALL ");
         sb1.append(" SELECT ");
         sb1.append("  cpg.oid_para_gral oid_concurso,  ");
         sb1.append("  iscp_psc.clie_oid_clie, spc.cod_peri, ");
         sb1.append("  NVL (PTS.IND_ANUL, 0) ANULACION, ");
         sb1.append("  NVL (pts.ind_devo, 0) devolucion,  ");
         sb1.append("  iscp_psc.fec_docu fec_movi, ");
         sb1.append("  iscp_psc.val_nume_soli,  ");
         sb1.append("  (SELECT idio.val_i18n    FROM v_gen_i18n_sicc idio    WHERE idio.attr_enti = 'PED_TIPO_SOLIC' ");
         sb1.append("   AND idio.idio_oid_idio = ?      AND idio.val_oid = pts.oid_tipo_soli) tipo_documento,    ");
         sb1.append("  DECODE( DECODE( NVL(ISCP_PSC.IND_ANUL, 0), 1, 0, DECODE( NVL(pts.ind_devo, 0), 1, 0, 1) ), 0, ");
         sb1.append("  (SELECT idio.val_i18n     FROM v_gen_i18n_sicc idio     WHERE idio.attr_enti = 'INC_TIPO_MOVIM'     AND idio.idio_oid_idio = ?     AND idio.val_oid = "+ ConstantesINC.TIPO_MOVIMIENTO_ABONO +"), ");
         sb1.append("  (SELECT idio.val_i18n     FROM v_gen_i18n_sicc idio     WHERE idio.attr_enti = 'INC_TIPO_MOVIM'     AND idio.idio_oid_idio = ?     AND idio.val_oid = "+ ConstantesINC.TIPO_MOVIMIENTO_CARGO +")  ");
         sb1.append("   ) tipo_movimiento,    ");
         sb1.append("  DECODE(DECODE(NVL (ISCP_PSC.IND_ANUL, 0),1, 0,DECODE(NVL (pts.ind_devo, 0),1,0,1)),0, "+ ConstantesINC.TIPO_MOVIMIENTO_ABONO +","+ ConstantesINC.TIPO_MOVIMIENTO_CARGO +") oid_tipo_movimiento, ");
         sb1.append("  abs(NVL(iscp_psc.num_punt,0) - NVL(iscp_psc.val_punt_boni,0) - NVL(iscp_psc.val_punt_falt_nanu,0)) puntaje_facturado,  ");
         sb1.append("  abs(NVL(iscp_psc.val_punt_boni, 0)) puntaje_bonificado,  ");
         sb1.append("  abs(NVL(iscp_psc.val_punt_falt_nanu, 0)) punt_falt_nanu,  ");
         sb1.append("  abs(NVL(iscp_psc.num_punt,0)) total_puntaje,	  ");
         sb1.append("  periodo_actual.fecha_inicio,  ");
         sb1.append("  NVL ((SELECT   MAX (pnp_na.num_nive) nivel           ");
         sb1.append("        FROM inc_ganad gan_na, inc_param_nivel_premi pnp_na, inc_param_gener_premi pgp_na          ");
         sb1.append("        WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem            AND ");
         sb1.append("              pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem            AND ");
         sb1.append("              pgp_na.copa_oid_para_gral = cpg.oid_para_gral            AND ");
         sb1.append("              gan_na.clie_oid_clie = iscp_psc.clie_oid_clie       ");
         sb1.append("        GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie),      0) nivel,  ");
         sb1.append("  (SELECT DISTINCT cga.clie_oid_clie              ");
         sb1.append("   FROM inc_candi_ganad cga             ");
         sb1.append("   WHERE cga.copa_oid_para_gral = cpg.oid_para_gral               AND ");
         sb1.append("         cga.clie_oid_clie = iscp_psc.clie_oid_clie) cliente_candidato,  ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         sb1.append("         spc.cod_peri periodo  ");
         sb1.append("   , 0 DESCALIFICA ");
         // vbongiov --  RI 20070481 -- 29/08/2008         
         sb1.append("   , (SELECT CCP.VAL_DESC ");
         sb1.append("      FROM inc_cuent_corri_punto ccp ");
         sb1.append("      WHERE ccp.clie_oid_clie = iscp_psc.clie_oid_clie  ");
         sb1.append("      AND ccp.copa_oid_para_gral = cpg.oid_para_gral  ");
         sb1.append("      AND ccp.perd_oid_peri = iscp_psc.perd_oid_peri  ");
         sb1.append("      AND ((ccp.tmov_oid_tipo_movi = 1 AND (iscp_psc.ind_anul = 0 AND pts.ind_devo = 0)) ");
         sb1.append("        OR (ccp.tmov_oid_tipo_movi = 2 AND (iscp_psc.ind_anul = 1 OR pts.ind_devo = 1)))  ");
         sb1.append("      AND ccp.fec_movi = iscp_psc.fec_docu ");
         sb1.append("      AND ROWNUM = 1) VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    ,mtv.IMP_MONTO_VENTA IMP_MONTO_VENTA  ");
         sb1.append("   FROM    ");
         sb1.append("   (SELECT iscp.num_punt, ");
         sb1.append("           iscp.val_punt_boni,          ");
         sb1.append("           iscp.val_punt_falt_nanu,          ");
         sb1.append("           iscp.fec_docu, iscp.ind_anul,          ");
         sb1.append("           iscp.copa_oid_para_gral,          ");
         sb1.append("           iscp.soca_oid_soli_cabe,          ");
         sb1.append("           iscp.perd_oid_peri,          ");
         sb1.append("           iscp.clie_oid_clie,          ");
         sb1.append("           psc.val_nume_soli,          ");
         sb1.append("           psc.tspa_oid_tipo_soli_pais     ");
         sb1.append("    FROM inc_solic_concu_punta iscp,  ");
         sb1.append("         ped_solic_cabec psc    ");
         sb1.append("    WHERE iscp.soca_oid_soli_cabe = psc.oid_soli_cabe) iscp_psc,  ");
         sb1.append("          inc_concu_param_gener cpg,  ");
         sb1.append("          cra_perio crp,  ");
         sb1.append("          seg_perio_corpo spc,  ");
         sb1.append("          ped_tipo_solic_pais ptsp,  ");
         sb1.append("          ped_tipo_solic pts,  ");
         sb1.append("   (SELECT fec_inic fecha_inicio,          ");
         sb1.append("           fec_fina fecha_fin,          ");
         sb1.append("           crp.pais_oid_pais,          ");
         sb1.append("           crp.marc_oid_marc,          ");
         sb1.append("           crp.cana_oid_cana, ");
         sb1.append("           crp.oid_peri     ");
         sb1.append("    FROM cra_perio crp, ");
         sb1.append("         seg_perio_corpo spc    ");
         sb1.append("    WHERE crp.peri_oid_peri = spc.oid_peri      AND ");
         sb1.append("          crp.fec_inic <= TRUNC (SYSDATE)      AND ");
         sb1.append("          crp.fec_fina >= TRUNC (SYSDATE)      AND ");
         sb1.append("    ROWNUM = 1) periodo_actual,  ");
         sb1.append("   (SELECT *     FROM inc_metas_tipo_venta mtv    ");
         sb1.append("    WHERE mtv.clie_oid_clie = ?      AND ");
         sb1.append("          mtv.copa_oid_para_gral = ?) mtv,  ");
         sb1.append("   INC_PLANT_CONCU PLA  ");
         sb1.append(" WHERE   ");
         sb1.append("      iscp_psc.copa_oid_para_gral = cpg.oid_para_gral  AND ");
         sb1.append("      iscp_psc.perd_oid_peri = crp.oid_peri  AND ");
         sb1.append("      crp.pais_oid_pais = cpg.pais_oid_pais  AND ");
         sb1.append("      crp.marc_oid_marc = cpg.marc_oid_marc  AND ");
         sb1.append("      crp.cana_oid_cana = cpg.cana_oid_cana  AND ");
         sb1.append("      crp.peri_oid_peri = spc.oid_peri  AND ");
         sb1.append("      iscp_psc.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais(+)  AND ");
         sb1.append("      ptsp.tsol_oid_tipo_soli = pts.oid_tipo_soli(+)  AND ");
         sb1.append("      crp.fec_fina <= periodo_actual.fecha_inicio(+)  AND ");
         sb1.append("      cpg.oid_para_gral = NVL (mtv.copa_oid_para_gral, cpg.oid_para_gral)  AND ");
         sb1.append("      iscp_psc.clie_oid_clie = mtv.clie_oid_clie(+)  AND ");
         sb1.append("      cpg.pais_oid_pais = NVL (periodo_actual.pais_oid_pais, cpg.pais_oid_pais)  AND ");
         sb1.append("      cpg.marc_oid_marc = NVL (periodo_actual.marc_oid_marc, cpg.marc_oid_marc)  AND ");
         sb1.append("      cpg.cana_oid_cana = NVL (periodo_actual.cana_oid_cana, cpg.cana_oid_cana)  AND ");
         sb1.append("      cpg.bcal_oid_base_calc <> "+ ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS +" AND ");
         sb1.append("      cpg.plc2_oid_plan_conc = pla.oid_plan_conc(+)  AND ");
         sb1.append("      pla.IND_PROG_NUEV(+) = 0  	   ");
         sb1.append("      AND ISCP_PSC.IND_ANUL = 1 ");
         sb1.append("      AND ISCP_PSC.NUM_PUNT > 0 ");
         
         //--------------------------------------------------------------------------------------------
         //
         // TERCER QUERY: Obtiene los registro de entrega premio
         //
         //--------------------------------------------------------------------------------------------
         // vbongiov --12/06/2008
         // No esta mostrando todos los registros en inc_cuent_corri_punto 
         // porque los campos a mostrar son iguales, para solucionarlo se agrega el ALL
         sb1.append(" UNION ALL ");
		 sb1.append(" SELECT cpg.oid_para_gral oid_concurso, ");
         sb1.append(" icc.clie_oid_clie, spc.cod_peri, ");
         sb1.append(" 0 anulacion, ");
         sb1.append(" 0 devolucion, ");
         sb1.append(" icc.fec_movi, NULL val_nume_soli, ");
		 sb1.append(" NULL tipo_documento, ");
		 sb1.append("   (SELECT idio.val_i18n ");
         sb1.append("   FROM v_gen_i18n_sicc idio ");
         sb1.append("  WHERE idio.attr_enti = 'INC_TIPO_MOVIM' ");
         sb1.append("    AND idio.idio_oid_idio = ? ");
         sb1.append("    AND idio.val_oid = "+ ConstantesINC.TIPO_MOVIMIENTO_CARGO + ")tipo_movimiento, ");
         sb1.append(" icc.tmov_oid_tipo_movi  oid_tipo_movimiento, ");
         sb1.append(" 0 puntaje_facturado, ");
         sb1.append(" 0 puntaje_bonificado, ");
         sb1.append(" 0 punt_falt_nanu, ");
         sb1.append(" icc.num_punt total_puntaje,  ");
         sb1.append(" periodo_actual.fecha_inicio, ");
         sb1.append(" NVL ");
         sb1.append("    ((SELECT   MAX (pnp_na.num_nive) nivel ");
         sb1.append("          FROM inc_ganad gan_na, ");
         sb1.append("               inc_param_nivel_premi pnp_na, ");
         sb1.append("               inc_param_gener_premi pgp_na ");
         sb1.append("         WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem ");
         sb1.append("           AND pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem ");
         sb1.append("           AND pgp_na.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("           AND gan_na.clie_oid_clie = icc.clie_oid_clie ");
         sb1.append("      GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie), ");
         sb1.append("     0) nivel, ");
         sb1.append(" (SELECT DISTINCT cga.clie_oid_clie ");
         sb1.append("             FROM inc_candi_ganad cga ");
         sb1.append("            WHERE cga.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("              AND cga.clie_oid_clie = icc.clie_oid_clie) cliente_candidato, ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         sb1.append(" spc.cod_peri periodo ");
         sb1.append(" , 0 DESCALIFICA ");
         // vbongiov --  RI 20070481 -- 29/08/2008
         sb1.append("     ,icc.VAL_DESC VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    ,0 IMP_MONTO_VENTA  ");
		 sb1.append(" FROM inc_cuent_corri_punto icc, ");
		 sb1.append("     inc_concu_param_gener cpg, ");
         sb1.append("     cra_perio crp, ");
         sb1.append("     seg_perio_corpo spc, ");
	     sb1.append("     (SELECT fec_inic fecha_inicio, ");
	     sb1.append("             fec_fina fecha_fin, ");
	     sb1.append("             crp.pais_oid_pais, ");
	     sb1.append("             crp.marc_oid_marc, ");
	     sb1.append("             crp.cana_oid_cana, crp.oid_peri ");
	     sb1.append("       FROM cra_perio crp, seg_perio_corpo spc ");
	     sb1.append("       WHERE crp.peri_oid_peri = spc.oid_peri ");
	     sb1.append("       AND crp.fec_inic <= TRUNC (SYSDATE) ");
	     sb1.append("       AND crp.fec_fina >= TRUNC (SYSDATE) ");
	     sb1.append("       AND ROWNUM = 1) periodo_actual, ");
	     sb1.append("      INC_PLANT_CONCU PLA ");
		 sb1.append("  WHERE ICC.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
		 sb1.append("  AND ICC.PERD_OID_PERI = CRP.OID_PERI ");
		 sb1.append("  AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
		 sb1.append("  AND cpg.pais_oid_pais = NVL (periodo_actual.pais_oid_pais, cpg.pais_oid_pais) ");
         sb1.append("  AND cpg.marc_oid_marc = NVL (periodo_actual.marc_oid_marc, cpg.marc_oid_marc) ");
         sb1.append("  AND cpg.cana_oid_cana = NVL (periodo_actual.cana_oid_cana, cpg.cana_oid_cana) ");
		 sb1.append("  AND cpg.plc2_oid_plan_conc = pla.oid_plan_conc(+) ");
		 sb1.append("  AND ICC.TMOV_OID_TIPO_MOVI = "+ ConstantesINC.TIPO_MOVIMIENTO_CARGO );
		 sb1.append("  AND icc.CLIE_OID_CLIE = ? ");
		 sb1.append("  AND icc.COPA_OID_PARA_GRAL = ? ");
		 sb1.append("  AND UPPER(ICC.VAL_DESC) LIKE UPPER('%"+ ConstantesINC.DESC_ENTREGA_PREMIO +"%') ");

         //--------------------------------------------------------------------------------------------
         //
         // CUARTO QUERY: Obtiene las descalificaciones por "Falta de Actividad" y "Falta de Documento"
         //
         //--------------------------------------------------------------------------------------------
         // vbongiov --12/06/2008
         // No esta mostrando todos los registros en inc_cuent_corri_punto 
         // porque los campos a mostrar son iguales, para solucionarlo se agrega el ALL
         sb1.append(" UNION ALL ");
		 sb1.append(" SELECT cpg.oid_para_gral oid_concurso, ");
         sb1.append("  icc.clie_oid_clie, spc.cod_peri, ");
         sb1.append("  0 anulacion, ");
         sb1.append("  0 devolucion, ");
         sb1.append("  icc.fec_movi, NULL val_nume_soli, ");
		 sb1.append("  icc.val_desc tipo_documento, ");                         // JVM, sicc 20070422, se reemplaza NULL por icc.val_desc
		 sb1.append("  (SELECT idio.val_i18n ");
         sb1.append("   FROM v_gen_i18n_sicc idio ");
         sb1.append("   WHERE idio.attr_enti = 'INC_TIPO_MOVIM' ");
         sb1.append("   AND idio.idio_oid_idio = ? ");
         sb1.append("   AND idio.val_oid = "+ ConstantesINC.TIPO_MOVIMIENTO_CARGO + ") tipo_movimiento, ");
         sb1.append("  icc.tmov_oid_tipo_movi  oid_tipo_movimiento, ");
         sb1.append("  0 puntaje_facturado, ");
         sb1.append("  0 puntaje_bonificado, ");
         sb1.append("  0 punt_falt_nanu, ");
         sb1.append("  icc.num_punt total_puntaje,  ");
         sb1.append("  periodo_actual.fecha_inicio, ");
         sb1.append("  NVL ");
         sb1.append("  ((SELECT MAX (pnp_na.num_nive) nivel ");
         sb1.append("    FROM inc_ganad gan_na, ");
         sb1.append("         inc_param_nivel_premi pnp_na, ");
         sb1.append("         inc_param_gener_premi pgp_na ");
         sb1.append("    WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem ");
         sb1.append("    AND pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem ");
         sb1.append("    AND pgp_na.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("    AND gan_na.clie_oid_clie = icc.clie_oid_clie ");
         sb1.append("    GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie), ");
         sb1.append("  0) nivel, ");
         sb1.append("  (SELECT DISTINCT cga.clie_oid_clie ");
         sb1.append("   FROM inc_candi_ganad cga ");
         sb1.append("   WHERE cga.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("   AND cga.clie_oid_clie = icc.clie_oid_clie) cliente_candidato, ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         sb1.append("  spc.cod_peri periodo , 1 DESCALIFICA ");
         // vbongiov --  RI 20070481 -- 29/08/2008
         sb1.append("     ,icc.VAL_DESC VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    ,0 IMP_MONTO_VENTA  ");
		 sb1.append(" FROM inc_cuent_corri_punto icc, ");
		 sb1.append("      inc_concu_param_gener cpg, ");
         sb1.append("      cra_perio crp, ");
         sb1.append("      seg_perio_corpo spc, ");
	     sb1.append("      (SELECT fec_inic fecha_inicio, ");
	     sb1.append("              fec_fina fecha_fin, ");
	     sb1.append("              crp.pais_oid_pais, ");
	     sb1.append("              crp.marc_oid_marc, ");
	     sb1.append("              crp.cana_oid_cana, crp.oid_peri ");
	     sb1.append("       FROM cra_perio crp, seg_perio_corpo spc ");
	     sb1.append("       WHERE crp.peri_oid_peri = spc.oid_peri ");
	     sb1.append("       AND crp.fec_inic <= TRUNC (SYSDATE) ");
	     sb1.append("       AND crp.fec_fina >= TRUNC (SYSDATE) ");
	     sb1.append("       AND ROWNUM = 1) periodo_actual, ");
	     sb1.append("      INC_PLANT_CONCU PLA ");
		 sb1.append(" WHERE ICC.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
		 sb1.append("   AND ICC.PERD_OID_PERI = CRP.OID_PERI ");
		 sb1.append("   AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
		 sb1.append("   AND cpg.pais_oid_pais = NVL (periodo_actual.pais_oid_pais, cpg.pais_oid_pais) ");
         sb1.append("   AND cpg.marc_oid_marc = NVL (periodo_actual.marc_oid_marc, cpg.marc_oid_marc) ");
         sb1.append("   AND cpg.cana_oid_cana = NVL (periodo_actual.cana_oid_cana, cpg.cana_oid_cana) ");
		 sb1.append("   AND cpg.plc2_oid_plan_conc = pla.oid_plan_conc ");
		 sb1.append("   AND ICC.TMOV_OID_TIPO_MOVI = "+ ConstantesINC.TIPO_MOVIMIENTO_CARGO );
		 sb1.append("   AND icc.CLIE_OID_CLIE = ? ");
		 sb1.append("   AND icc.COPA_OID_PARA_GRAL = ? ");
		 sb1.append("   AND ( UPPER(ICC.VAL_DESC) LIKE UPPER('%"+ ConstantesINC.DESC_FALTA_ACTIVIDAD +"%') ");
	     sb1.append("    OR UPPER(ICC.VAL_DESC) LIKE UPPER('%"+ ConstantesINC.DESC_FALTA_CONSTANCIA +"%') ) "); // Mod. 08/03/2007

         //--------------------------------------------------------------------------------------------
         //
         // QUINTO QUERY: Obtiene los registro de las recomendadas
         //
         //--------------------------------------------------------------------------------------------
         // vbongiov --12/06/2008
         // No esta mostrando todos los registros en inc_cuent_corri_punto 
         // porque los campos a mostrar son iguales, para solucionarlo se agrega el ALL
         sb1.append(" UNION ALL ");
         sb1.append(" SELECT cpg.oid_para_gral oid_concurso, ");
         sb1.append(" ICC.CLIE_OID_CLIE, spc.cod_peri, ");
         sb1.append(" NVL (ISCP_PSC.IND_ANUL, 0) ANULACION, ");
         sb1.append(" NVL (PTS.IND_DEVO, 0) DEVOLUCION, ");
         sb1.append(" icc.fec_movi, ");
         sb1.append(" iscp_psc.val_nume_soli, ");
         sb1.append(" (SELECT idio.val_i18n ");
         sb1.append("   FROM v_gen_i18n_sicc idio ");
         sb1.append("   WHERE idio.attr_enti = 'PED_TIPO_SOLIC' ");
         sb1.append("   AND idio.idio_oid_idio = ? ");
         sb1.append("   AND idio.val_oid = pts.oid_tipo_soli)tipo_documento, ");
         sb1.append(" (SELECT idio.val_i18n ");
         sb1.append("   FROM v_gen_i18n_sicc idio ");
         sb1.append("   WHERE idio.attr_enti = 'INC_TIPO_MOVIM' ");
         sb1.append("   AND idio.idio_oid_idio = ? ");
         sb1.append("   AND idio.val_oid = icc.tmov_oid_tipo_movi) tipo_movimiento, ");
         sb1.append(" icc.tmov_oid_tipo_movi oid_tipo_movimiento, ");
         sb1.append(" icc.num_punt puntaje_facturado, 0, 0, ");
         sb1.append(" (icc.num_punt) total_puntaje, ");
         sb1.append(" periodo_actual.fecha_inicio, ");
         sb1.append(" NVL ");
         sb1.append("    ((SELECT   MAX (pnp_na.num_nive) nivel ");
         sb1.append("          FROM inc_ganad gan_na, ");
         sb1.append("               inc_param_nivel_premi pnp_na, ");
         sb1.append("               inc_param_gener_premi pgp_na ");
         sb1.append("         WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem ");
         sb1.append("           AND pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem ");
         sb1.append("           AND pgp_na.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("           AND gan_na.clie_oid_clie = icc.clie_oid_clie ");
         sb1.append("      GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie), ");
         sb1.append("     0 ) nivel, ");
         sb1.append(" (SELECT DISTINCT cga.clie_oid_clie ");
         sb1.append("             FROM inc_candi_ganad cga ");
         sb1.append("            WHERE cga.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append("              AND cga.clie_oid_clie = icc.clie_oid_clie) cliente_candidato, ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         sb1.append("  spc.cod_peri periodo ");
         sb1.append(" , 0 DESCALIFICA ");
         // vbongiov --  RI 20070481 -- 29/08/2008
         sb1.append("     ,icc.VAL_DESC VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    ,mtv.IMP_MONTO_VENTA IMP_MONTO_VENTA  ");
         sb1.append(" FROM inc_cuent_corri_punto icc, ");
         sb1.append(" (select max(iscp.fec_docu) fec_docu, iscp.ind_anul, ");
		 sb1.append(" iscp.copa_oid_para_gral, ");
		 sb1.append(" iscp.perd_oid_peri, ");
		 sb1.append(" PSC.CLIE_OID_CLIE, ");
		 sb1.append(" max(psc.val_nume_soli) val_nume_soli, ");
		 sb1.append(" psc.tspa_oid_tipo_soli_pais  ");
		 sb1.append(" from inc_solic_concu_recom iscp, ");
		 sb1.append(" ped_solic_cabec psc ");
		 sb1.append(" where iscp.soca_oid_soli_cabe = psc.oid_soli_cabe ");
         /*
          * Autor : JVM
          * Fecha : 4-Abr-2007
          * Desc  : se realizan cambios debido a la incidencia SICC-20070168
          *         se agregan las condiciones 
          *         and psc.clie_oid_clie = dtoCab.getOidCliente()
          *         and psc.copa_oid_para_gene = dtoCab.getOidConcursor()
          */
         sb1.append(" and psc.clie_oid_clie = " + dtoCab.getOidCliente() + " ");
         sb1.append(" and psc.copa_oid_para_gene = " + dtoCab.getOidConcurso() + " ");
         
		 sb1.append(" group by iscp.copa_oid_para_gral, ");
         sb1.append(" PSC.CLIE_OID_CLIE, ");
         sb1.append(" iscp.perd_oid_peri, ");
		 sb1.append(" iscp.ind_anul,psc.tspa_oid_tipo_soli_pais) ISCP_PSC, ");
         sb1.append(" inc_concu_param_gener cpg, ");
         sb1.append(" cra_perio crp, ");
         sb1.append(" seg_perio_corpo spc, ");
         sb1.append(" ped_tipo_solic_pais ptsp, ");
         sb1.append(" ped_tipo_solic pts, ");
         sb1.append(" (SELECT fec_inic fecha_inicio, ");
         sb1.append("         fec_fina fecha_fin, ");
         sb1.append("         crp.pais_oid_pais, ");
         sb1.append("         crp.marc_oid_marc, ");
         sb1.append("         crp.cana_oid_cana ");
         sb1.append("    FROM cra_perio crp, seg_perio_corpo spc ");
         sb1.append("   WHERE crp.peri_oid_peri = spc.oid_peri ");
         sb1.append("     AND crp.fec_inic <= TRUNC (SYSDATE) ");
         sb1.append("     AND crp.fec_fina >= TRUNC (SYSDATE) ");
         sb1.append("     AND ROWNUM = 1) periodo_actual, ");
         sb1.append(" (SELECT * ");
         sb1.append("    FROM inc_metas_tipo_venta mtv ");
         sb1.append("   WHERE mtv.clie_oid_clie = ? ");
         sb1.append("     AND mtv.copa_oid_para_gral = ?) mtv ");
         sb1.append(" WHERE icc.copa_oid_para_gral = iscp_psc.copa_oid_para_gral(+) ");
         sb1.append(" AND icc.clie_oid_clie = iscp_psc.clie_oid_clie(+) ");
         sb1.append(" AND icc.perd_oid_peri = iscp_psc.perd_oid_peri(+) ");
         sb1.append(" AND icc.copa_oid_para_gral = cpg.oid_para_gral ");
         sb1.append(" AND icc.perd_oid_peri = crp.oid_peri ");
         sb1.append(" AND crp.pais_oid_pais = cpg.pais_oid_pais ");
         sb1.append(" AND crp.marc_oid_marc = cpg.marc_oid_marc ");
         sb1.append(" AND crp.cana_oid_cana = cpg.cana_oid_cana ");
         sb1.append(" AND crp.peri_oid_peri = spc.oid_peri ");
         sb1.append(" AND iscp_psc.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais(+) ");
         sb1.append(" AND ptsp.tsol_oid_tipo_soli = pts.oid_tipo_soli(+) ");
         sb1.append(" AND crp.fec_fina <= periodo_actual.fecha_inicio(+) ");
         sb1.append(" AND cpg.oid_para_gral =  NVL (mtv.copa_oid_para_gral, cpg.oid_para_gral) ");
         sb1.append(" AND iscp_psc.clie_oid_clie = mtv.clie_oid_clie(+) ");
         sb1.append(" AND cpg.pais_oid_pais = NVL (periodo_actual.pais_oid_pais, cpg.pais_oid_pais) ");
         sb1.append(" AND cpg.marc_oid_marc = NVL (periodo_actual.marc_oid_marc, cpg.marc_oid_marc) ");
         sb1.append(" AND cpg.cana_oid_cana = NVL (periodo_actual.cana_oid_cana, cpg.cana_oid_cana) ");
         sb1.append(" AND cpg.bcal_oid_base_calc = " + ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS );
		 sb1.append(" AND UPPER(ICC.VAL_DESC) NOT LIKE UPPER('%"+ ConstantesINC.DESC_ENTREGA_PREMIO +"%') ");
		 sb1.append(" AND UPPER(ICC.VAL_DESC) NOT LIKE UPPER('%"+ ConstantesINC.DESC_FALTA_ACTIVIDAD +"%') ");
		 sb1.append(" AND UPPER(ICC.VAL_DESC) NOT LIKE UPPER('%"+ ConstantesINC.DESC_FALTA_CONSTANCIA +"%') ");

         //--------------------------------------------------------------------------------------------
         //
         // SEXTO QUERY: Obtiene los registro del programa de pedido y nuevos
         //
         //--------------------------------------------------------------------------------------------
         // vbongiov --12/06/2008
         // No esta mostrando todos los registros en inc_cuent_corri_punto 
         // porque los campos a mostrar son iguales, para solucionarlo se agrega el ALL
         sb1.append(" UNION ALL ");
         sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, ");
         sb1.append(" ISCP_PSC.CLIE_OID_CLIE, SPC.COD_PERI, ");
         sb1.append(" NVL (ISCP_PSC.IND_ANUL, 0) ANULACION, ");
         sb1.append(" NVL (PTS.IND_DEVO, 0) DEVOLUCION, ");
         sb1.append(" ISCP_PSC.FECHA FEC_MOVI, ISCP_PSC.VAL_NUME_SOLI, ");
         sb1.append(" (SELECT IDIO.VAL_I18N  ");
         sb1.append(" FROM V_GEN_I18N_SICC IDIO  ");
         sb1.append("   WHERE IDIO.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
         sb1.append("     AND IDIO.IDIO_OID_IDIO = ?  ");
         sb1.append("     AND IDIO.VAL_OID = PTS.OID_TIPO_SOLI) TIPO_DOCUMENTO, ");
         sb1.append(" NULL TIPO_MOVIMIENTO,  ");
         sb1.append(" NULL OID_TIPO_MOVIMIENTO,  ");
         sb1.append(" NVL(iscp_psc.num_punt,0) - NVL(iscp_psc.val_punt_boni,0) - NVL(iscp_psc.val_punt_falt_nanu,0) puntaje_facturado, ");
         sb1.append(" NVL(ISCP_PSC.VAL_PUNT_BONI, 0) PUNTAJE_BONIFICADO, ");
         sb1.append(" NVL(ISCP_PSC.VAL_PUNT_FALT_NANU, 0) PUNT_FALT_NANU,  ");
         sb1.append(" NVL(iscp_psc.num_punt,0) total_puntaje, ");
         sb1.append(" PERIODO_ACTUAL.FECHA_INICIO, ");
         sb1.append(" NVL ((SELECT   MAX (PNP_NA.NUM_NIVE) NIVEL ");
         sb1.append("      FROM INC_GANAD GAN_NA, ");
         sb1.append("      INC_PARAM_NIVEL_PREMI PNP_NA, ");
         sb1.append("      INC_PARAM_GENER_PREMI PGP_NA ");
         sb1.append("      WHERE GAN_NA.PANP_OID_PARA_NIVE_PREM = PNP_NA.OID_PARA_NIVE_PREM ");
         sb1.append("           AND PNP_NA.PAGP_OID_PARA_GENE_PREM = PGP_NA.OID_PARA_GENE_PREM ");
         sb1.append("           AND PGP_NA.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append("           AND GAN_NA.CLIE_OID_CLIE = ISCP_PSC.CLIE_OID_CLIE ");
         sb1.append("      GROUP BY PGP_NA.COPA_OID_PARA_GRAL, GAN_NA.CLIE_OID_CLIE), 0) NIVEL, ");
         sb1.append(" NULL CLIENTE_CANDIDATO, ");
         // vbongiov -- RI 20070467 -- 19/09/2008
         // Se elimina mtv.val_meta meta
         sb1.append("  SPC.COD_PERI PERIODO  ");
         sb1.append(" , 0 DESCALIFICA ");
         // vbongiov --  RI 20070481 -- 29/08/2008         
         sb1.append("    , (SELECT CCP.VAL_DESC ");
         sb1.append("       FROM inc_cuent_corri_punto ccp ");
         sb1.append("       WHERE ccp.clie_oid_clie = iscp_psc.clie_oid_clie ");
         sb1.append("       AND ccp.copa_oid_para_gral = cpg.oid_para_gral  ");
         sb1.append("       AND ccp.perd_oid_peri = iscp_psc.perd_oid_peri ");
         sb1.append("       AND ((ccp.tmov_oid_tipo_movi = 1 AND (iscp_psc.ind_anul = 0 AND pts.ind_devo = 0))  ");
         sb1.append("          OR (ccp.tmov_oid_tipo_movi = 2 AND (iscp_psc.ind_anul = 1 OR pts.ind_devo = 1)))  ");
         sb1.append("       AND ccp.fec_movi = iscp_psc.fec_docu ");
         sb1.append("       AND ROWNUM = 1)  VAL_DESC ");
         // vbongiov --  RI 20070467 -- 4/09/2008
         sb1.append("    ,NULL IMP_MONTO_VENTA  ");
         sb1.append(" FROM (SELECT ISCP.NUM_PUNT, ISCP.VAL_PUNT_BONI, ");
         sb1.append("         ISCP.VAL_PUNT_FALT_NANU, ");
         sb1.append("         ISCP.FEC_DOCU, ISCP.IND_ANUL, ");
         sb1.append("         ISCP.COPA_OID_PARA_GRAL, ");
         sb1.append("         ISCP.SOCA_OID_SOLI_CABE, ");
         sb1.append("         ISCP.PERD_OID_PERI, ");
         sb1.append("         ISCP.CLIE_OID_CLIE, ");
         sb1.append("         PSC.VAL_NUME_SOLI, ");
         sb1.append("         PSC.TSPA_OID_TIPO_SOLI_PAIS,");
		 sb1.append("         ISCP.FEC_DOCU FECHA  ");
         sb1.append("       FROM INC_SOLIC_CONCU_PUNTA ISCP,  PED_SOLIC_CABEC PSC ");
         sb1.append("       WHERE ISCP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE) ISCP_PSC, ");
         sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
         sb1.append(" CRA_PERIO CRP, ");
         sb1.append(" SEG_PERIO_CORPO SPC, ");
         sb1.append(" PED_TIPO_SOLIC_PAIS PTSP, ");
         sb1.append(" PED_TIPO_SOLIC PTS, ");
         sb1.append(" (SELECT FEC_INIC FECHA_INICIO, ");
         sb1.append("         FEC_FINA FECHA_FIN, ");
         sb1.append("         CRP.PAIS_OID_PAIS, ");
         sb1.append("         CRP.MARC_OID_MARC, ");
         sb1.append("         CRP.CANA_OID_CANA, CRP.OID_PERI ");
         sb1.append("   FROM CRA_PERIO CRP, SEG_PERIO_CORPO SPC ");
         sb1.append("   WHERE CRP.PERI_OID_PERI = SPC.OID_PERI ");
         sb1.append("   AND CRP.FEC_INIC <= TRUNC (SYSDATE) ");
         sb1.append("   AND CRP.FEC_FINA >= TRUNC (SYSDATE) ");
         sb1.append("   AND ROWNUM = 1) PERIODO_ACTUAL,");
	     sb1.append(" INC_PLANT_CONCU PLC ");
         sb1.append(" WHERE ISCP_PSC.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append(" AND ISCP_PSC.PERD_OID_PERI = CRP.OID_PERI ");
	     sb1.append(" AND CRP.PAIS_OID_PAIS = CPG.PAIS_OID_PAIS ");
         sb1.append(" AND CRP.MARC_OID_MARC = CPG.MARC_OID_MARC ");
         sb1.append(" AND CRP.CANA_OID_CANA = CPG.CANA_OID_CANA ");
         sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
         sb1.append(" AND ISCP_PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS(+) ");
         sb1.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI(+) ");
         sb1.append(" AND CRP.FEC_FINA <= PERIODO_ACTUAL.FECHA_INICIO(+) "); 
         sb1.append(" AND CPG.PAIS_OID_PAIS = NVL (PERIODO_ACTUAL.PAIS_OID_PAIS, CPG.PAIS_OID_PAIS) ");
         sb1.append(" AND CPG.MARC_OID_MARC = NVL (PERIODO_ACTUAL.MARC_OID_MARC, CPG.MARC_OID_MARC) ");
         sb1.append(" AND CPG.CANA_OID_CANA = NVL (PERIODO_ACTUAL.CANA_OID_CANA, CPG.CANA_OID_CANA) ");
         sb1.append(" AND CPG.BCAL_OID_BASE_CALC = " + ConstantesINC.OID_BASE_CALCULO_NPEDIDOS);
	     sb1.append(" AND CPG.PLC2_OID_PLAN_CONC = PLC.OID_PLAN_CONC ");
	     sb1.append(" AND PLC.IND_PROG_NUEV = 1 ");
        
         cadenaFiltro.concatenar(sb1);
         //  Para el primer query
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidCliente());
         cadenaFiltro.concatenarParametro(dtoCab.getOidConcurso());
         //  Para el segundo query
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidCliente());
         cadenaFiltro.concatenarParametro(dtoCab.getOidConcurso());
         //  Para el tercer query
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidCliente());
         cadenaFiltro.concatenarParametro(dtoCab.getOidConcurso());
         //  Para el cuarto query (nuevo)
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidCliente());
         cadenaFiltro.concatenarParametro(dtoCab.getOidConcurso());
         //  Para el quinto query
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());        
         cadenaFiltro.concatenarParametro(dtoCab.getOidCliente());
         cadenaFiltro.concatenarParametro(dtoCab.getOidConcurso());
         //  Para el sexto query
         cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());

		 UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleConcurso"+
         "(DTOCabeceraConsultaIntegral dtoCab): Salida");
		
         return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     3.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       7/4/2006
    * Incidencia:  22531
    * Modificado:  Cristian Valenzuela
    * Fecha:       5/5/2006
    * Incidencia:  DBLG500000310
    * Modificado:  Cristian Valenzuela
    * Fecha:       1/11/2006
    * Incidencia:  BELC300023086
    */

	public CadenaFiltro getQueryPremiosProceArticulo(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceArticulo(DTOCabeceraConsultaIntegral dtoCab): Entrada");

		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();

		if(dtoCab.getOidConcurso()!=null) {

            /*
             * Autor : JVM
             * Fecha : 29-Mar-2007
             * Desc  : se realizan cambios debido a la incidencia SICC-20070170
             *         sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, CONS.VAL_NUME_SOLI NUMERO_DOCUMENTO, ");             
             */
            sb1.append(" SELECT ");
            sb1.append("   t.OID_CONCURSO, ");                 
            sb1.append("   t.CLIE_OID_CLIE, ");                
            sb1.append("   t.NUMERO_DOCUMENTO, ");             
            sb1.append("   t.TIPO_DOCUMENTO, ");               
            sb1.append("   t.FECHA_OBTENCION, ");              
            sb1.append("   t.NUMERO_CONCURSO, ");                    
            sb1.append("   t.DESC_CONCURSO, ");                
            sb1.append("   t.NIVEL, ");                        
            sb1.append("   t.NUMERO_PREMIO,  ");               
            sb1.append("   t.TIPO_PREMIO,  ");		                   
            sb1.append("   t.CODIGO_PRODUCTO, ");                     
            sb1.append("   t.DESC_PREMIO,  ");                  
            sb1.append("   t.CODIGO_VTA_FICTICIO, ");      
            // vbongiov -- RI 20080781 -- 22/10/2008
            sb1.append("   t.NUM_UNID_DEMA_REAL CANTIDAD,  ");                     
            sb1.append("   t.SITUACION,  ");                          
            sb1.append("   t.PREMIO_REEMPLAZO,  ");                   
            sb1.append("   t.PERIODO_DESPACHO  ");
            sb1.append(" FROM ( ");
            sb1.append(" SELECT ");
            sb1.append("  distinct infosit.oid_soli_cabe                         OID_SOLI_CABE, ");
            sb1.append("  CPG.OID_PARA_GRAL                                      OID_CONCURSO, ");
            sb1.append("  GAN.CLIE_OID_CLIE                                      CLIE_OID_CLIE, ");
            sb1.append("  CONS.VAL_NUME_SOLI                                     NUMERO_DOCUMENTO, ");             
			sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO ");
            sb1.append("  WHERE IDIO.ATTR_ENTI = 'PED_TIPO_SOLIC'  ");
			sb1.append("  AND IDIO.IDIO_OID_IDIO = ? ");
            sb1.append("  AND IDIO.VAL_OID = PTS.OID_TIPO_SOLI)                  TIPO_DOCUMENTO, ");
            /*
             * Autor : JVM
             * Fecha : 19-Abr-2007
             * Desc  : se realizan cambios debido a la incidencia SICC-20070214
             *         sb1.append(" GAN.FEC_OBTE                                                             FECHA_OBTENCION,    ");
             */                
            sb1.append("  PSC.FEC_FACT                                           FECHA_OBTENCION, ");            
			sb1.append("  CPG.NUM_CONC                                           NUMERO_CONCURSO, ");
            sb1.append("  CPG.VAL_NOMB                                           DESC_CONCURSO, ");
            sb1.append("  PNP.NUM_NIVE                                           NIVEL, ");
            sb1.append("  LPA.NUM_PREM                                           NUMERO_PREMIO,  ");
			sb1.append(" 'A'                                                     TIPO_PREMIO,  ");		
            // DBLG500001242 - gPineda - 01/09/2006
            //sb1.append(" MPR.COD_SAP CODIGO_PRODUCTO,LPA.VAL_DESC_LOTE_PREM_ARTI DESC_PREMIO,  ");
			sb1.append("  MPR.COD_SAP                                           CODIGO_PRODUCTO, ");
            // vbongiov -- Cambio RI 20080814 -- 6/01/2009
            sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO    ");
            sb1.append(" WHERE IDIO.ATTR_ENTI = 'MAE_PRODU'  ");
            sb1.append(" AND IDIO.IDIO_OID_IDIO = " + dtoCab.getOidIdioma());
            sb1.append(" AND IDIO.VAL_OID = mpr.OID_PROD) DESC_PREMIO, ");
                                
            sb1.append("  ARL.COD_VENT_FICT                                     CODIGO_VTA_FICTICIO, ");
            // vbongiov -- RI 20080781 -- 22/10/2008
            sb1.append("  infosit.NUM_UNID_DEMA_REAL                            NUM_UNID_DEMA_REAL,  ");
            
			sb1.append(" DECODE(PSC.FEC_FACT,  ");
			sb1.append(" NULL,  ");
			sb1.append(" 'POR DESPACHAR',  ");
			sb1.append(" DECODE(INFOSIT.NUM_UNID_ATEN,  ");
			sb1.append(" 0,  ");
			sb1.append(" 'FALTANTE',  ");
			sb1.append(" DECODE(INFOSIT.NUM_UNID_DEMA,  ");
			sb1.append(" INFOSIT.NUM_UNID_COMPR,  ");
			sb1.append(" 'DESPACHADO',  ");
			sb1.append(" 'DESPACHADO'||' '||INFOSIT.NUM_UNID_ATEN  ");
			sb1.append(" )  ");
			sb1.append(" )  ");
			sb1.append(" )                                                      SITUACION,  ");
			sb1.append(" PREREM.PREMIO_REEMPLAZO                                PREMIO_REEMPLAZO,  ");
            /*
             * Autor : JVM
             * Fecha : 19-Abr-2007
             * Desc  : se realizan cambios debido a la incidencia SICC-20070214
             *         sb1.append(" SPC_DES.COD_PERI                                                          PERIODO_DESPACHO  ");
             */                
            sb1.append(" ( ");
            sb1.append("  SELECT ");
            sb1.append("  	    P.COD_PERI ");
            sb1.append("   FROM SEG_PERIO_CORPO S, CRA_PERIO C, SEG_PERIO_CORPO P ");
            sb1.append("  WHERE S.OID_PERI = PSC.PERD_OID_PERI ");
            sb1.append("    AND C.OID_PERI = S.OID_PERI            (+) ");
            sb1.append("    AND P.OID_PERI = C.PERI_OID_PERI	   (+) ");                                
            sb1.append(" )                                                                        PERIODO_DESPACHO ");                         
		}
		else {
            /*
             * Autor : JVM
             * Fecha : 29-Mar-2007
             * Desc  : se realizan cambios debido a la incidencia SICC-20070170
             *         sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, GAN.FEC_OBTE FECHA_OBTENCION, CONS.VAL_NUME_SOLI NUMERO_DOCUMENTO, ");			         
             */                
            sb1.append(" SELECT ");
            sb1.append("   t.OID_CONCURSO, ");
            sb1.append("   t.clie_oid_clie, ");
            sb1.append("   t.fecha_obtencion, ");
            sb1.append("   t.numero_documento, ");
            sb1.append("   t.tipo_documento, ");
            sb1.append("   t.numero_concurso, ");
            sb1.append("   t.desc_concurso, ");
            sb1.append("   t.nivel, ");
            sb1.append("   t.numero_premio, ");
            sb1.append("   t.tipo_premio, ");
            sb1.append("   t.datos_premio, ");
            sb1.append("   t.situacion, ");
            sb1.append("   t.premio_reemplazo, ");
            sb1.append("   t.periodo_despacho ");
            sb1.append(" FROM ( ");
            sb1.append(" SELECT ");
            sb1.append(" distinct infosit.oid_soli_cabe                                           SOLI_CABE, ");
            sb1.append(" CPG.OID_PARA_GRAL                                                        OID_CONCURSO,  ");
            sb1.append(" GAN.CLIE_OID_CLIE                                                        CLIE_OID_CLIE, ");             
            /*
             * Autor : JVM
             * Fecha : 19-Abr-2007
             * Desc  : se realizan cambios debido a la incidencia SICC-20070214
             *         sb1.append(" GAN.FEC_OBTE                                                             FECHA_OBTENCION,    ");
             */                
            sb1.append(" PSC.FEC_FACT                                                             FECHA_OBTENCION, ");
            sb1.append(" CONS.VAL_NUME_SOLI                                                       NUMERO_DOCUMENTO,   ");            
			sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO    ");
            sb1.append(" WHERE IDIO.ATTR_ENTI = 'PED_TIPO_SOLIC'  ");
			sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = PTS.OID_TIPO_SOLI)          TIPO_DOCUMENTO,  ");
			sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, ");
            sb1.append(" CPG.VAL_NOMB                                                              DESC_CONCURSO, ");
            sb1.append(" PNP.NUM_NIVE                                                              NIVEL, ");
            sb1.append(" LPA.NUM_PREM                                                              NUMERO_PREMIO,  ");
			sb1.append(" 'A'                                                                       TIPO_PREMIO,  ");
            // vbongiov -- 8/09/2006 -- inc DBLG500001264 
            sb1.append(" MPR.COD_SAP||' '||  ");
            // vbongiov -- Cambio RI 20080814 -- 6/01/2009
            sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO    ");
            sb1.append(" WHERE IDIO.ATTR_ENTI = 'MAE_PRODU'  ");
            sb1.append(" AND IDIO.IDIO_OID_IDIO = " + dtoCab.getOidIdioma());
            sb1.append(" AND IDIO.VAL_OID = mpr.OID_PROD) ");             
            sb1.append("||' '||ARL.COD_VENT_FICT||' '||ARL.NUM_UNID DATOS_PREMIO,  ");
                    
			sb1.append(" DECODE(PSC.FEC_FACT,  ");
			sb1.append(" NULL,  ");
			sb1.append(" 'POR DESPACHAR',  ");
			sb1.append(" DECODE(INFOSIT.NUM_UNID_ATEN,  ");
			sb1.append(" 0,  ");
			sb1.append(" 'FALTANTE',  ");
			sb1.append(" DECODE(INFOSIT.NUM_UNID_DEMA,  ");
			sb1.append(" INFOSIT.NUM_UNID_COMPR,  ");
			sb1.append(" 'DESPACHADO',  ");
			sb1.append(" 'DESPACHADO'||' '||INFOSIT.NUM_UNID_ATEN  ");
			sb1.append(" )  ");
			sb1.append(" )  ");
			sb1.append(" )                                                                         SITUACION,  ");
			sb1.append(" PREREM.PREMIO_REEMPLAZO                                                   PREMIO_REEMPLAZO,  ");
            /*
             * Autor : JVM
             * Fecha : 19-Abr-2007
             * Desc  : se realizan cambios debido a la incidencia SICC-20070214
             *         sb1.append(" SPC_DES.COD_PERI                                                          PERIODO_DESPACHO  ");
             */                
            sb1.append(" ( ");
            sb1.append("  SELECT ");
            sb1.append("  	    P.COD_PERI ");
            sb1.append("   FROM SEG_PERIO_CORPO S, CRA_PERIO C, SEG_PERIO_CORPO P ");
            sb1.append("  WHERE S.OID_PERI = PSC.PERD_OID_PERI ");
            sb1.append("    AND C.OID_PERI = S.OID_PERI            (+) ");
            sb1.append("    AND P.OID_PERI = C.PERI_OID_PERI	   (+) ");                                
            sb1.append(" )                                                                        PERIODO_DESPACHO ");             
		}

		sb1.append(" FROM INC_GANAD GAN,  ");
		sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
		sb1.append(" INC_PARAM_GENER_PREMI PGP,  ");
		sb1.append(" INC_CONCU_PARAM_GENER CPG,  ");
		sb1.append(" INC_PREMI_ARTIC PRA,  ");
		sb1.append(" INC_LOTE_PREMI_ARTIC LPA,  ");
		sb1.append(" INC_ARTIC_LOTE ARL,  ");
		sb1.append(" MAE_PRODU MPR,  ");
		sb1.append(" PED_SOLIC_CABEC PSC,  ");
        sb1.append(" PED_SOLIC_CABEC CONS, ");
		sb1.append(" PED_TIPO_SOLIC_PAIS PTSP,  ");
		sb1.append(" PED_TIPO_SOLIC PTS,  ");
		sb1.append(" ( SELECT DISTINCT PSC_SIT.OID_SOLI_CABE, PSP_SIT.NUM_UNID_DEMA,  ");
		sb1.append(" PSP_SIT.NUM_UNID_COMPR, PSP_SIT.NUM_UNID_ATEN,  ");
		sb1.append(" PSP_SIT.OID_SOLI_POSI, PSP_SIT.PROD_OID_PROD PROD_OID_PROD  ");
        // vbongiov -- RI 20080781 -- 22/10/2008
        sb1.append(" , psp_sit.NUM_UNID_DEMA_REAL  ");        
        
		sb1.append(" FROM PED_SOLIC_CABEC PSC_SIT,  ");
		sb1.append(" PED_SOLIC_POSIC PSP_SIT  ");
		sb1.append(" WHERE ");
        /*
         * Autor : JVM
         * Fecha : 16-Abr-2007
         * Desc  : se realizan cambios debido a la incidencia SICC-20070214
         *         Se adiciona los OID_SOLI_CABE del concurso para lista los articulos faltantes
         *         despachados
         */
        sb1.append("     PSC_SIT.OID_SOLI_CABE IN (SELECT DISTINCT OID_SOLI_CABE OID_SOLI_CABE FROM PED_SOLIC_CABEC ");
        sb1.append( "    WHERE PED_SOLIC_CABEC.CLIE_OID_CLIE      = "+dtoCab.getOidCliente());
        sb1.append(" ) ");
        sb1.append(" AND PSC_SIT.OID_SOLI_CABE = PSP_SIT.SOCA_OID_SOLI_CABE  ");
		sb1.append(" AND PSP_SIT.TPOS_OID_TIPO_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO.toString());
		sb1.append(" AND PSC_SIT.CLIE_OID_CLIE = " + dtoCab.getOidCliente()); //agregado por Sapaza, incidencia SiCC-20070022  
		/* 
         * Autor : JVM
         * Fecha : 25-Abr-2007
         * Desc  : SICC-20070214, se agregan los pedidos con FEC_FACT nulos
         *         sb1.append(" AND PSC_SIT.FEC_FACT IS NOT NULL "); 
        */        
        
        sb1.append(" ) INFOSIT,  ");
		sb1.append(" CRA_PERIO CRP_DES,  ");
		sb1.append(" SEG_PERIO_CORPO SPC_DES,  ");
        
        /*
         * Autor : JVM
         * Fecha : 29-Mar-2007
         * Desc  : se realizan cambios debido a la incidencia SICC-20070170
         * 
		 * sb1.append(" ( SELECT DISTINCT LPA_PA.NUM_PREM||' '||LPA_PA.VAL_DESC_LOTE_PREM_ARTI PREMIO_REEMPLAZO,  ");
		 * sb1.append(" IBF_PA.SOPO_OID_SOLI_POSI  ");
		 * sb1.append(" FROM INC_BOLSA_FALTA IBF_PA,  ");
		 * sb1.append(" INC_ARTIC_PREMI_ALTER IAPA_PA,  ");
		 * sb1.append(" INC_LOTE_PREMI_ARTIC LPA_PA  ");
		 * sb1.append(" WHERE IBF_PA.OID_BOLS_FALT = IAPA_PA.BOFA_OID_BOLS_FALT  ");
		 * sb1.append(" AND IAPA_PA.VAL_PREM_ALTE = LPA_PA.NUM_PREM ) PREREM  ");
        */
        sb1.append(" ( ");
        sb1.append(" SELECT DISTINCT ");
        sb1.append(" cra_perio.val_nomb_peri premio_reemplazo, ");
        sb1.append(" inc_bolsa_falta.sopo_oid_soli_posi ");
        sb1.append(" FROM ");
        sb1.append(" ped_solic_cabec, ");
        sb1.append(" ped_solic_posic,    ");    
        sb1.append(" inc_bolsa_falta,      ");
        sb1.append(" inc_artic_premi_alter, ");
        sb1.append(" inc_lote_premi_artic, ");
        sb1.append(" cra_perio  ");
        sb1.append(" WHERE ");
        sb1.append("    ped_solic_cabec.clie_oid_clie      		  = "+dtoCab.getOidCliente()+" ");
        sb1.append(" AND ped_solic_cabec.copa_oid_para_gene 	  = "+dtoCab.getOidConcurso()+" ");
        /*
         * Autor : JVM
         * Fecha : 16-Abr-2007
         * Desc  : se realizan cambios debido a la incidencia SICC-20070214
         *         Se adiciona los OID_SOLI_CABE del concurso para lista los articulos faltantes
         *         despachados
         */
        sb1.append(" AND PED_SOLIC_CABEC.OID_SOLI_CABE IN (SELECT DISTINCT OID_SOLI_CABE OID_SOLI_CABE FROM PED_SOLIC_CABEC ");
        sb1.append("     WHERE PED_SOLIC_CABEC.CLIE_OID_CLIE      = "+dtoCab.getOidCliente());
        sb1.append(" ) ");
        sb1.append(" AND cra_perio.oid_peri                       = ped_solic_cabec.perd_oid_peri ");
        sb1.append(" AND ped_solic_posic.soca_oid_soli_cabe 	  = ped_solic_cabec.oid_soli_cabe   ");
        sb1.append(" AND inc_bolsa_falta.sopo_oid_soli_posi 	  = ped_solic_posic.oid_soli_posi ");
        sb1.append(" AND inc_artic_premi_alter.bofa_oid_bols_falt = inc_bolsa_falta.oid_bols_falt ");	
        sb1.append(" )PREREM ");
        sb1.append(" WHERE GAN.PANP_OID_PARA_NIVE_PREM  = PNP.OID_PARA_NIVE_PREM ");        
        sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM  = PGP.OID_PARA_GENE_PREM ");              
        sb1.append(" AND PGP.COPA_OID_PARA_GRAL       = CPG.OID_PARA_GRAL ");      
        sb1.append(" AND PNP.OID_PARA_NIVE_PREM       = PRA.PANP_OID_PARA_NIVE_PREM ");      
        sb1.append(" AND PRA.OID_PREM_ARTI            = LPA.PRAR_OID_PREM_ARTI ");      
        sb1.append(" AND ARL.LOPA_OID_LOTE_PREM_ARTI  = LPA.OID_LOTE_PREM_ARTI ");      
        sb1.append(" AND ARL.PROD_OID_PROD            = MPR.OID_PROD ");      
        /*
         * Autor : JVM
         * Fecha : 16-Abr-2007
         * Desc  : se realizan cambios debido a la incidencia SICC-20070214
         *         Se adiciona los OID_SOLI_CABE del concurso para lista los articulos faltantes
         *         despachados
         */
        //sb1.append(" AND GAN.SOCA_OID_SOLI_CABE     = PSC.OID_SOLI_CABE ");
        sb1.append(" AND LPA.NUM_PREM                 = DECODE(PSC.COPA_OID_PARA_GENE,NULL, LPA.NUM_PREM,PSC.NUM_PREM) ");      
        sb1.append(" AND PSC.OID_SOLI_CABE            = INFOSIT.OID_SOLI_CABE     (+) ");
        sb1.append(" AND MPR.OID_PROD                 = INFOSIT.PROD_OID_PROD ");
        sb1.append(" AND PGP.PERD_OID_PERI            = CRP_DES.OID_PERI          (+) ");
        sb1.append(" AND CRP_DES.PERI_OID_PERI        = SPC_DES.OID_PERI          (+) ");
        sb1.append(" AND INFOSIT.OID_SOLI_POSI        = PREREM.SOPO_OID_SOLI_POSI (+) ");
        sb1.append(" AND PSC.SOCA_OID_SOLI_CABE       = CONS.OID_SOLI_CABE        (+) ");
        sb1.append(" AND CONS.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS   (+) ");
        sb1.append(" AND PTSP.TSOL_OID_TIPO_SOLI      = PTS.OID_TIPO_SOLI         (+) ");
        sb1.append(" ) t ");
    
		cadenaFiltro.concatenar(sb1);
		cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());

		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceArticulo(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       1/11/2006
    * Incidencia:  BELC300023086
    */

	public CadenaFiltro getQueryPremiosProceMonetario(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceMonetario(DTOCabeceraConsultaIntegral dtoCab): Entrada");

		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();

		if(dtoCab.getOidConcurso()!=null) {
			sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, GAN.FEC_OBTE FECHA_OBTENCION,  ");
			sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL,IPM.NUM_PREM NUMERO_PREMIO,  ");
			sb1.append(" 'M' TIPO_PREMIO, SMO.VAL_NOMB_CORT_MONE TIPO_MONEDA, GAN.NUM_UNID IMPORTE,  ");
			sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_FORMA_PAGO'  ");
			sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = IPM.FPAG_OID_FORM_PAGO) DESTINO,  ");
      // vbongiov -- 14/09/2006 -- inc DBLG500001243
			sb1.append(" DECODE (PSC.OID_SOLI_CABE,NULL, 'DESPACHADO', DECODE (PSC.FEC_FACT, NULL, 'POR DESPACHAR', 'DESPACHADO')) SITUACION, ");
			sb1.append(" '' PREMIO_REEMPLAZO,  ");
			sb1.append(" SPC_DES.COD_PERI PERIODO_DESPACHO  ");
		}
		else {
      // DBLG500001264 - gPineda 31/08/06
			//sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, GAN.FEC_OBTE FECHA_OBTENCION,NULL NUMERO_DOCUMENTO,  ");
      sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, GAN.FEC_OBTE FECHA_OBTENCION, PSC.VAL_NUME_SOLI NUMERO_DOCUMENTO,  ");
			//sb1.append(" '' TIPO_DOCUMENTO,  ");
      sb1.append(" (SELECT IDIO.VAL_I18N ");
      sb1.append(" FROM V_GEN_I18N_SICC IDIO ");
      sb1.append(" WHERE IDIO.ATTR_ENTI = 'PED_TIPO_SOLIC' AND IDIO.IDIO_OID_IDIO = 1 ");
      sb1.append(" AND IDIO.VAL_OID = PTS.OID_TIPO_SOLI) TIPO_DOCUMENTO, ");
		
    	sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL,IPM.NUM_PREM NUMERO_PREMIO,  ");
			sb1.append(" 'M' TIPO_PREMIO,  ");
			sb1.append(" SMO.VAL_NOMB_CORT_MONE||' '||GAN.NUM_UNID||' '||  ");
			sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_FORMA_PAGO'  ");
			sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = IPM.FPAG_OID_FORM_PAGO) DATOS_PREMIO,  ");
		
    	//sb1.append(" '' SITUACION,  ");
      sb1.append(" DECODE (PSC.OID_SOLI_CABE,NULL, 'DESPACHADO', DECODE (PSC.FEC_FACT, NULL, 'POR DESPACHAR', 'DESPACHADO')) SITUACION, ");
			sb1.append(" '' PREMIO_REEMPLAZO,  ");
			sb1.append(" SPC_DES.COD_PERI PERIODO_DESPACHO  ");
		}

		sb1.append(" FROM INC_GANAD GAN,  ");
		sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
		sb1.append(" INC_PARAM_GENER_PREMI PGP,  ");
		sb1.append(" INC_CONCU_PARAM_GENER CPG,  ");
		sb1.append(" INC_PREMI_MONET IPM,  ");
		sb1.append(" SEG_MONED SMO,  ");
		sb1.append(" CRA_PERIO CRP_DES,  ");
		sb1.append(" SEG_PERIO_CORPO SPC_DES,  ");
    
    // DBLG500001264 - gPineda 31/08/06
    sb1.append(" PED_SOLIC_CABEC PSC, ");
    sb1.append(" PED_TIPO_SOLIC PTS, ");
    sb1.append(" PED_TIPO_SOLIC_PAIS PTSP ");
		
    sb1.append(" WHERE GAN.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
		sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM  ");
		sb1.append(" AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL  ");
		sb1.append(" AND PNP.OID_PARA_NIVE_PREM = IPM.PANP_OID_PARA_NIVE_PREM  ");
		sb1.append(" AND IPM.MONE_OID_MONE = SMO.OID_MONE  ");
		sb1.append(" AND PGP.PERD_OID_PERI = CRP_DES.OID_PERI(+)  ");
		sb1.append(" AND CRP_DES.PERI_OID_PERI = SPC_DES.OID_PERI(+)  ");    
    // DBLG500001264 - gPineda 31/08/06
    
    //cvalenzu - BELC300023086
    //sb1.append(" AND CPG.OID_PARA_GRAL = PSC.COPA_OID_PARA_GENE(+) ");
    sb1.append(" AND GAN.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE(+) ");
    //FIN - cvalenzu - BELC300023086   
    
    sb1.append(" AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS(+) ");
    sb1.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI(+) ");

		cadenaFiltro.concatenar(sb1);
		cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());

		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceMonetario(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public CadenaFiltro getQueryPremiosProcePuntos(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProcePuntos(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();

		if(dtoCab.getOidConcurso()!=null) {
			sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, GAN.FEC_OBTE FECHA_OBTENCION,  ");
			sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, SPC_DES.COD_PERI PERIODO_DESPACHO, ");
			sb1.append(" PNP.NUM_NIVE NIVEL,IPP.NUM_PREM NUMERO_PREMIO, 'P' TIPO_PREMIO, ");
			sb1.append(" CPG_PP.NUM_CONC NUMERO_CONCURSO_DEST, CPG_PP.VAL_NOMB DESC_CONCURSO_DESTINO, GAN.NUM_UNID NUMERO_PUNTOS  ");
		}
		else {
			sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE, GAN.FEC_OBTE FECHA_OBTENCION,NULL NUMERO_DOCUMENTO,  ");
			sb1.append(" '' TIPO_DOCUMENTO,  ");
			sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL,IPP.NUM_PREM NUMERO_PREMIO,  ");
			sb1.append(" 'P' TIPO_PREMIO,  ");
      // vbongiov -- 11/09/2006 -- inc DBLG500000316
			sb1.append(" CPG_PP.NUM_CONC||' '||CPG_PP.VAL_NOMB||' '||GAN.NUM_UNID DATOS_PREMIO,  ");
			sb1.append(" '' SITUACION,  ");
			sb1.append(" '' PREMIO_REEMPLAZO,  ");
			sb1.append(" SPC_DES.COD_PERI PERIODO_DESPACHO  ");
		}

		sb1.append(" FROM INC_GANAD GAN,  ");
		sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
		sb1.append(" INC_PARAM_GENER_PREMI PGP,  ");
		sb1.append(" INC_CONCU_PARAM_GENER CPG,  ");
		sb1.append(" INC_PREMI_PUNTO IPP,  ");
		sb1.append(" INC_CONCU_PARAM_GENER CPG_PP,  ");
		sb1.append(" CRA_PERIO CRP_DES,  ");
		sb1.append(" SEG_PERIO_CORPO SPC_DES  ");
		sb1.append(" WHERE GAN.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
		sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM  ");
		sb1.append(" AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL  ");
		sb1.append(" AND PNP.OID_PARA_NIVE_PREM = IPP.PANP_OID_PARA_NIVE_PREM  ");
		sb1.append(" AND IPP.COPA_OID_PARA_GRAL = CPG_PP.OID_PARA_GRAL  ");
		sb1.append(" AND PGP.PERD_OID_PERI = CRP_DES.OID_PERI(+)  ");
		sb1.append(" AND CRP_DES.PERI_OID_PERI = SPC_DES.OID_PERI(+)  ");

		cadenaFiltro.concatenar(sb1);

		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProcePuntos(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public CadenaFiltro getQueryPremiosProceDescuento(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceDescuento(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();

		if(dtoCab.getOidConcurso()!=null) {
			sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE,GAN.FEC_OBTE FECHA_OBTENCION,  ");
			sb1.append(" SPC_DES.COD_PERI PERIODO_DESPACHO,  ");
            sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL,IPD.NUM_PREM NUMERO_PREMIO,  ");
			sb1.append(" 'D' TIPO_PREMIO,  ");
			sb1.append(" IPD.VAL_PORC_DESC PORC_DESCUENTO, GAN.NUM_UNID MONTO  ");
		}
		else {
			sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, GAN.CLIE_OID_CLIE,GAN.FEC_OBTE FECHA_OBTENCION,NULL NUMERO_DOCUMENTO,  ");
			sb1.append(" '' TIPO_DOCUMENTO,  ");
			sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL,IPD.NUM_PREM NUMERO_PREMIO,  ");
			sb1.append(" 'D' TIPO_PREMIO,  ");
			sb1.append(" IPD.VAL_PORC_DESC||' '||GAN.NUM_UNID DATOS_PREMIO,  ");
			sb1.append(" '' SITUACION,  ");
			sb1.append(" '' PREMIO_REEMPLAZO,  ");
			sb1.append(" SPC_DES.COD_PERI PERIODO_DESPACHO  ");
		}

		sb1.append(" FROM INC_GANAD GAN,  ");
		sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
		sb1.append(" INC_PARAM_GENER_PREMI PGP,  ");
		sb1.append(" INC_CONCU_PARAM_GENER CPG,  ");
		sb1.append(" INC_PREMI_DESCU IPD,  ");
		sb1.append(" CRA_PERIO CRP_DES,  ");
		sb1.append(" SEG_PERIO_CORPO SPC_DES  ");    
		sb1.append(" WHERE gan.panp_oid_para_nive_prem = pnp.oid_para_nive_prem ");
		sb1.append(" AND pnp.PAGP_OID_PARA_GENE_PREM  = pgp.oid_para_gene_prem  ");
		sb1.append(" AND pgp.copa_oid_para_gral = cpg.oid_para_gral  ");
    sb1.append(" AND pnp.oid_para_nive_prem = ipd.OID_PARA_NIVE_PREM  ");  
    // vbongiov -- 14/09/2006 -- inc DBLG500001265
		sb1.append(" AND GAN.PERD_OID_PERI = CRP_DES.OID_PERI(+)  ");
		sb1.append(" AND CRP_DES.PERI_OID_PERI = SPC_DES.OID_PERI(+)  ");    

		cadenaFiltro.concatenar(sb1);
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosProceDescuento(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     3.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela - 5/1/2006
    * Incidencia:  BELC300022316
    * Modificado:  Cristian Valenzuela - 28/4/2006
    * Incidencia:  DBLG500000607
    */

	public CadenaFiltro getQueryPremiosSelecionados(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosSelecionados(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT DISTINCT ");        // JVM, sicc 20070421, se agrega distinct 
        
        // vbongiov -- DBLG500000607
        sb1.append(" CPG.OID_PARA_GRAL OID_CONCURSO, IPE.CLIE_OID_CLIE, IPE.FEC_SIST FECHA_DIGITACION,  ");
        sb1.append(" SPC.COD_PERI PERIODO, CPG.NUM_CONC NUMERO_CONCURSO, ");
        sb1.append(" CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL, LPA.NUM_PREM NUMERO_PREMIO, ");
        sb1.append(" MPR.COD_SAP CODIGO_PRODUCTO, LPA.VAL_DESC_LOTE_PREM_ARTI DESC_PREMIO, ARL.COD_VENT_FICT CODIGO_VENTA_FICTICIO, ARL.NUM_UNID CANTIDAD, ");
        sb1.append(" NVL(PNP.NUM_CANT_FIJA_PUNT, PNP.NUM_CANT_INIC_PUNT) PUNTAJE_PREMIO, PUNTAJE_TOTAL.PUNTAJE PUNTAJE_TOTAL, ");
        sb1.append(" DECODE(PSC.FEC_FACT,NULL,'POR DESPACHAR',DECODE(INFOSIT.NUM_UNID_ATEN,0,'FALTANTE', ");
        sb1.append(" DECODE(INFOSIT.NUM_UNID_DEMA,INFOSIT.NUM_UNID_COMPR,'DESPACHADO','DESPACHADO'||' '||INFOSIT.NUM_UNID_ATEN))) SITUACION	     ");
        sb1.append(" FROM INC_PREMI_ELEGI IPE, ");
        sb1.append(" INC_PARAM_NIVEL_PREMI PNP, ");
        sb1.append(" INC_PARAM_GENER_PREMI PGP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" CRA_PERIO CRP, ");
        sb1.append(" SEG_PERIO_CORPO SPC, ");
        sb1.append(" INC_PREMI_ARTIC PRA, ");
        sb1.append(" INC_LOTE_PREMI_ARTIC LPA, ");
        sb1.append(" INC_ARTIC_LOTE ARL, ");
        sb1.append(" MAE_PRODU MPR, ");
        sb1.append(" PED_SOLIC_CABEC PSC,	  ");
        sb1.append(" (SELECT DISTINCT ");
        sb1.append("         PSC_SIT.OID_SOLI_CABE, PSP_SIT.NUM_UNID_DEMA,  ");
        sb1.append("         PSP_SIT.NUM_UNID_COMPR, PSP_SIT.NUM_UNID_ATEN, ");
        sb1.append("         PSP_SIT.OID_SOLI_POSI ");
        sb1.append("  FROM ");
        sb1.append("         PED_SOLIC_CABEC PSC_SIT, ");
        sb1.append("          PED_SOLIC_POSIC PSP_SIT ");
        sb1.append(" WHERE "); 
        sb1.append("       PSC_SIT.CLIE_OID_CLIE = " + dtoCab.getOidCliente()); // JVM, sicc 20070421, se agrega condicion de filtro por oidCliente por Performance
        sb1.append("   AND PSC_SIT.OID_SOLI_CABE = PSP_SIT.SOCA_OID_SOLI_CABE ");
        sb1.append("   AND PSP_SIT.TPOS_OID_TIPO_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
        sb1.append("   AND PSC_SIT.FEC_FACT IS NOT NULL ");
        sb1.append(" ) INFOSIT, ");
        sb1.append(" (SELECT SUM(NUM_PUNT) PUNTAJE, CPG_PT.OID_PARA_GRAL OID_PARA_GRAL, ");
        sb1.append(" ICCP.CLIE_OID_CLIE CLIE_OID_CLIE ");
        sb1.append(" FROM INC_CUENT_CORRI_PUNTO ICCP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG_PT ");
        sb1.append(" WHERE ICCP.COPA_OID_PARA_GRAL = CPG_PT.OID_PARA_GRAL ");
        sb1.append(" GROUP BY CPG_PT.OID_PARA_GRAL,ICCP.CLIE_OID_CLIE) PUNTAJE_TOTAL 	  ");
        sb1.append(" WHERE IPE.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
        sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM ");
        sb1.append(" AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        sb1.append(" AND CRP.OID_PERI(+) = PSC.PERD_OID_PERI ");
        sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI(+) ");
        sb1.append(" AND PNP.OID_PARA_NIVE_PREM = PRA.PANP_OID_PARA_NIVE_PREM ");
        sb1.append(" AND PRA.OID_PREM_ARTI = LPA.PRAR_OID_PREM_ARTI ");
        sb1.append(" AND ARL.LOPA_OID_LOTE_PREM_ARTI = LPA.OID_LOTE_PREM_ARTI ");
        sb1.append(" AND IPE.NUM_PREM = LPA.NUM_PREM ");
        sb1.append(" AND ARL.PROD_OID_PROD = MPR.OID_PROD ");
        sb1.append(" AND CPG.OID_PARA_GRAL = PSC.COPA_OID_PARA_GENE(+) ");
        sb1.append(" AND IPE.CLIE_OID_CLIE = DECODE(PSC.COPA_OID_PARA_GENE, NULL,IPE.CLIE_OID_CLIE,PSC.CLIE_OID_CLIE)  ");
        sb1.append(" AND LPA.NUM_PREM = DECODE(PSC.COPA_OID_PARA_GENE, NULL,LPA.NUM_PREM,PSC.NUM_PREM) ");
        sb1.append(" AND PSC.CLIE_OID_CLIE = " + dtoCab.getOidCliente());       // JVM, sicc 20070421, se agrega condicion de filtro por oidCliente por Performance
        sb1.append(" AND PSC.OID_SOLI_CABE = INFOSIT.OID_SOLI_CABE(+) ");
        sb1.append(" AND CPG.OID_PARA_GRAL = PUNTAJE_TOTAL.OID_PARA_GRAL ");
        sb1.append(" AND IPE.CLIE_OID_CLIE = PUNTAJE_TOTAL.CLIE_OID_CLIE ");
        sb1.append(" UNION ALL ");
        sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, IPE.CLIE_OID_CLIE,  ");
        sb1.append(" IPE.FEC_SIST FECHA_DIGITACION, SPC.COD_PERI PERIODO, CPG.NUM_CONC NUMERO_CONCURSO, ");
        sb1.append(" CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL, IPM.NUM_PREM NUMERO_PREMIO, ");
        sb1.append(" '' CODIGO_PRODUCTO, SMO.VAL_NOMB_CORT_MONE||' '||IPM.VAL_CANT||' '|| ");
        sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_FORMA_PAGO'  ");
        sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = IPM.FPAG_OID_FORM_PAGO)  DESC_PREMIO, '' CODIGO_VENTA_FICTICIO, IPM.VAL_CANT CANTIDAD, ");
        sb1.append(" NVL(PNP.NUM_CANT_FIJA_PUNT, PNP.NUM_CANT_INIC_PUNT) PUNTAJE_PREMIO,  ");
        sb1.append(" PUNTAJE_TOTAL.PUNTAJE PUNTAJE_TOTAL, ");        
        sb1.append(" DECODE (PSC.OID_SOLI_CABE,NULL, 'DESPACHADO', DECODE(PSC.FEC_FACT,NULL,'POR DESPACHAR',DECODE(INFOSIT.NUM_UNID_ATEN,0,'FALTANTE', ");
        sb1.append(" DECODE(INFOSIT.NUM_UNID_DEMA,INFOSIT.NUM_UNID_COMPR,'DESPACHADO','DESPACHADO'||' '||INFOSIT.NUM_UNID_ATEN)))) SITUACION ");
        sb1.append(" FROM INC_PREMI_ELEGI IPE, ");
        sb1.append(" INC_PARAM_NIVEL_PREMI PNP, ");
        sb1.append(" INC_PARAM_GENER_PREMI PGP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" INC_PREMI_MONET IPM, ");
        sb1.append(" SEG_MONED SMO,	  ");
        sb1.append(" PED_SOLIC_CABEC PSC,	  ");
        sb1.append(" CRA_PERIO CRP, ");
        sb1.append(" SEG_PERIO_CORPO SPC, ");
        sb1.append(" (SELECT DISTINCT ");
        sb1.append("         PSC_SIT.OID_SOLI_CABE, PSP_SIT.NUM_UNID_DEMA,  ");
        sb1.append("         PSP_SIT.NUM_UNID_COMPR, PSP_SIT.NUM_UNID_ATEN, ");
        sb1.append("         PSP_SIT.OID_SOLI_POSI ");
        sb1.append("    FROM PED_SOLIC_CABEC PSC_SIT, ");
        sb1.append("         PED_SOLIC_POSIC PSP_SIT ");
        sb1.append(" WHERE ");
        sb1.append("     PSC_SIT.CLIE_OID_CLIE = "+dtoCab.getOidCliente());     // JVM, sicc 20070421, se agrega filto por cliente por performance
        sb1.append(" AND PSC_SIT.OID_SOLI_CABE = PSP_SIT.SOCA_OID_SOLI_CABE ");
        sb1.append(" AND PSP_SIT.TPOS_OID_TIPO_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
        sb1.append(" AND PSC_SIT.FEC_FACT IS NOT NULL ) INFOSIT, ");
        sb1.append(" (SELECT SUM(NUM_PUNT) PUNTAJE, CPG_PT.OID_PARA_GRAL OID_PARA_GRAL, ");
        sb1.append(" ICCP.CLIE_OID_CLIE CLIE_OID_CLIE ");
        sb1.append(" FROM INC_CUENT_CORRI_PUNTO ICCP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG_PT ");
        sb1.append(" WHERE ICCP.COPA_OID_PARA_GRAL = CPG_PT.OID_PARA_GRAL ");
        sb1.append(" GROUP BY CPG_PT.OID_PARA_GRAL,ICCP.CLIE_OID_CLIE ) PUNTAJE_TOTAL  ");
        sb1.append(" WHERE IPE.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
        sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM ");
        sb1.append(" AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");        
        sb1.append(" AND PNP.OID_PARA_NIVE_PREM = IPM.PANP_OID_PARA_NIVE_PREM ");
        sb1.append(" AND IPM.MONE_OID_MONE = SMO.OID_MONE ");        
        sb1.append(" AND CPG.OID_PARA_GRAL = PSC.COPA_OID_PARA_GENE(+) ");
        sb1.append(" AND CRP.OID_PERI(+) = PSC.PERD_OID_PERI ");
        sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI(+) ");
        sb1.append(" AND IPE.CLIE_OID_CLIE = DECODE(PSC.COPA_OID_PARA_GENE, NULL,IPE.CLIE_OID_CLIE,PSC.CLIE_OID_CLIE) ");
        sb1.append(" AND IPM.NUM_PREM = DECODE(PSC.COPA_OID_PARA_GENE, NULL,IPM.NUM_PREM,PSC.NUM_PREM) ");
        sb1.append(" AND PSC.CLIE_OID_CLIE  = " + dtoCab.getOidCliente());      // JVM, sicc 20070421, se agrega filtro por cliente para performance
        sb1.append(" AND PSC.OID_SOLI_CABE = INFOSIT.OID_SOLI_CABE(+) ");
        sb1.append(" AND CPG.OID_PARA_GRAL = PUNTAJE_TOTAL.OID_PARA_GRAL ");
        sb1.append(" AND IPE.CLIE_OID_CLIE = PUNTAJE_TOTAL.CLIE_OID_CLIE ");
        sb1.append(" UNION ALL ");
        sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, IPE.CLIE_OID_CLIE,  ");
        sb1.append(" IPE.FEC_SIST FECHA_DIGITACION, '' PERIODO, CPG.NUM_CONC NUMERO_CONCURSO, ");
        sb1.append(" CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL, IPP.NUM_PREM NUMERO_PREMIO, ");
        sb1.append(" '' CODIGO_PRODUCTO, CPG_PP.NUM_CONC||' '||CPG_PP.VAL_NOMB  DESC_PREMIO, '' CODIGO_VENTA_FICTICIO, IPP.VAL_CANT CANTIDAD, ");
        sb1.append(" NVL(PNP.NUM_CANT_FIJA_PUNT, PNP.NUM_CANT_INIC_PUNT) PUNTAJE_PREMIO,  ");
        sb1.append(" PUNTAJE_TOTAL.PUNTAJE PUNTAJE_TOTAL, ");
        sb1.append(" '' SITUACION     ");
        sb1.append(" FROM INC_PREMI_ELEGI IPE, ");
        sb1.append(" INC_PARAM_NIVEL_PREMI PNP, ");
        sb1.append(" INC_PARAM_GENER_PREMI PGP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" INC_PREMI_PUNTO IPP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG_PP,	  ");
        sb1.append(" CRA_PERIO CRP, ");
        sb1.append(" SEG_PERIO_CORPO SPC, ");
        sb1.append(" (SELECT SUM(NUM_PUNT) PUNTAJE, CPG_PT.OID_PARA_GRAL OID_PARA_GRAL, ");
        sb1.append(" ICCP.CLIE_OID_CLIE CLIE_OID_CLIE ");
        sb1.append(" FROM INC_CUENT_CORRI_PUNTO ICCP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG_PT ");
        sb1.append(" WHERE ICCP.COPA_OID_PARA_GRAL = CPG_PT.OID_PARA_GRAL ");
        sb1.append(" GROUP BY CPG_PT.OID_PARA_GRAL, ICCP.CLIE_OID_CLIE) PUNTAJE_TOTAL  ");
        sb1.append(" WHERE IPE.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
        sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM ");        
        sb1.append(" AND PNP.OID_PARA_NIVE_PREM = IPP.PANP_OID_PARA_NIVE_PREM ");
        sb1.append(" AND IPP.COPA_OID_PARA_GRAL = CPG_PP.OID_PARA_GRAL ");
        sb1.append(" AND CPG.OID_PARA_GRAL = PUNTAJE_TOTAL.OID_PARA_GRAL ");
        sb1.append(" AND IPE.CLIE_OID_CLIE = PUNTAJE_TOTAL.CLIE_OID_CLIE ");
        sb1.append(" UNION ALL ");
        // sb1.append(" SELECT DISTINCT "); // sicc 20070448, se agrega DISTINCT
        sb1.append(" SELECT "); // sicc 20070448, se elimina DISTINCT
        sb1.append(" CPG.OID_PARA_GRAL OID_CONCURSO, IPE.CLIE_OID_CLIE,  ");
        sb1.append(" IPE.FEC_SIST FECHA_DIGITACION, '' PERIODO, CPG.NUM_CONC NUMERO_CONCURSO, ");
        sb1.append(" CPG.VAL_NOMB DESC_CONCURSO, PNP.NUM_NIVE NIVEL, IPD.NUM_PREM NUMERO_PREMIO, ");
        sb1.append(" '' CODIGO_PRODUCTO, IPD.VAL_PORC_DESC||' '||IPD.VAL_CANT_DESC DESC_PREMIO, '' CODIGO_VENTA_FICTICIO, IPD.VAL_CANT_DESC CANTIDAD, ");
        sb1.append(" NVL(PNP.NUM_CANT_FIJA_PUNT, PNP.NUM_CANT_INIC_PUNT) PUNTAJE_PREMIO,  ");
        sb1.append(" PUNTAJE_TOTAL.PUNTAJE PUNTAJE_TOTAL, ");        
        sb1.append(" '' SITUACION     ");
        sb1.append(" FROM INC_PREMI_ELEGI IPE, ");
        sb1.append(" INC_PARAM_NIVEL_PREMI PNP, ");
        sb1.append(" INC_PARAM_GENER_PREMI PGP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" INC_PREMI_DESCU IPD,  ");
        sb1.append(" CRA_PERIO CRP, ");
        sb1.append(" SEG_PERIO_CORPO SPC, ");
        sb1.append(" (	SELECT SUM(NUM_PUNT) PUNTAJE, CPG_PT.OID_PARA_GRAL OID_PARA_GRAL, ");
        sb1.append(" ICCP.CLIE_OID_CLIE CLIE_OID_CLIE ");
        sb1.append(" FROM INC_CUENT_CORRI_PUNTO ICCP, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG_PT ");
        sb1.append(" WHERE ICCP.COPA_OID_PARA_GRAL = CPG_PT.OID_PARA_GRAL ");
        sb1.append(" GROUP BY CPG_PT.OID_PARA_GRAL, ICCP.CLIE_OID_CLIE) PUNTAJE_TOTAL  ");
        sb1.append(" WHERE IPE.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
        sb1.append(" AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM ");
        sb1.append(" AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");        
        // sicc 20070448, se agrega (+), se modifica  
        // sb1.append(" AND PNP.OID_PARA_NIVE_PREM = IPD.OID_PARA_NIVE_PREM(+) ");  
        sb1.append(" AND PNP.OID_PARA_NIVE_PREM = IPD.OID_PARA_NIVE_PREM ");
        sb1.append(" AND CPG.OID_PARA_GRAL = PUNTAJE_TOTAL.OID_PARA_GRAL ");
        sb1.append(" AND IPE.CLIE_OID_CLIE = PUNTAJE_TOTAL.CLIE_OID_CLIE ");

		cadenaFiltro.concatenar(sb1);
		cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());

		UtilidadesLog.info("GestorConsultasIntegrales.getQueryPremiosSelecionados(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     2.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela - 5/1/2006
    * Incidencia:  BELC300022328
    */
 public CadenaFiltro getQueryRecomendacion(DTOCabeceraConsultaIntegral dtoCab) 
                 throws MareException {
                 UtilidadesLog.info("GestorConsultasIntegrales.getQueryRecomendacion(DTOCabeceraConsultaIntegral dtoCab): Entrada");
                 
                 CadenaFiltro cadenaFiltro = new CadenaFiltro();
                 StringBuffer sb1 = new StringBuffer();
       
         // vbongiov -- 11/09/2006 -- inc DBLG500001233
         /*
         sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, ISCR.RECOMENDANTE CLIE_OID_CLIE, ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_IN + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_IN + "', ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_OUT + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_OUT + "')) ORIGEN, "); 
         sb1.append(" MCPC.FEC_CONT FECHA_INSCRIPCION, CPG.NUM_CONC NUMERO_CONCURSO,  ");
         sb1.append(" CPG.VAL_NOMB DESC_CONCURSO,  '' PERIODO, MCLIE.COD_CLIE CODIGO_RECOM, ");
         sb1.append(" MCLIE.VAL_NOM1||' '||MCLIE.VAL_NOM2||' '||MCLIE.VAL_APE1||' '||MCLIE.VAL_APE2 NOMBRE_APELLIDO, ");
         sb1.append(" NULL NIVEL,  NULL NUMERO_PREMIO, '' TIPO_PREMIO, ");
         sb1.append(" '' DATOS_PREMIO, ");
         sb1.append(" DECODE(ISCR.IND_EFEC,1,'EFECTIVA','NO EFECTIVA') SITUACION, ");
         sb1.append(" NVL(DES.CADE_OID_CAUS_DESC, BASE_INC.DESC_BASE_INCUM) MOTIVO_INCUMPLIMIENTO, ");
         sb1.append(" '' DETALLE_PREMIO_REEMPLAZO ");
         sb1.append(" FROM  ");
         sb1.append(" (SELECT RTE.CLIE_OID_CLIE RECOMENDANTE, RTE.COPA_OID_PARA_GRAL,  ");
         sb1.append(" RDO.IND_EFEC, RDO.CLIE_OID_CLIE RECOMENDADO  ");
         sb1.append(" FROM INC_CLIEN_RECTE RTE, INC_CLIEN_RECDO RDO  ");
         sb1.append(" WHERE RTE.OID_CLIE_RETE = RDO.CLR3_OID_CLIE_RETE) ISCR, ");        
         sb1.append(" INC_CONCU_PARAM_GENER CPG,  ");
         sb1.append(" MAE_CLIEN MCLIE, ");
         sb1.append(" INC_DESCA DES,  ");
         sb1.append(" MAE_CLIEN_PRIME_CONTA MCPC, ");        
         sb1.append(" (SELECT CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU, ");
         sb1.append("    MAX((SELECT IDIO.VAL_I18N ");
         sb1.append("    FROM V_GEN_I18N_SICC IDIO ");
         sb1.append("    WHERE IDIO.IDIO_OID_IDIO = ? ");
         sb1.append("    AND IDIO.ATTR_ENTI = 'INC_BASE_INCUM' ");
         sb1.append("    AND IDIO.VAL_OID = BAI.OID_BASE_INCU)) DESC_BASE_INCUM ");
         sb1.append(" FROM INC_CANDI_GANAD CAND, ");
         sb1.append(" CRA_PERIO PER, INC_BASE_INCUM BAI ");
         sb1.append(" WHERE CAND.PERD_OID_PERI = PER.OID_PERI ");
         sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
         sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC) ");
         sb1.append("                     FROM INC_CANDI_GANAD CAND_SUB, CRA_PERIO PER_SUB ");
         sb1.append("                     WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
         sb1.append("                     AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
         sb1.append("                     AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
         sb1.append(" GROUP BY CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU) BASE_INC ");
         sb1.append(" WHERE ISCR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append(" AND ISCR.RECOMENDADO = MCLIE.OID_CLIE ");

         // DBLG700000040 - gPineda - 09/10/2006
         // sb1.append(" AND ISCR.RECOMENDANTE = DES.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.RECOMENDADO = DES.CLIE_OID_CLIE(+) ");
         
         sb1.append(" AND iscr.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL(+) ");
         // vbongiov -- 4/12/2006 -- inc DBLG700000040
         sb1.append(" AND ISCR.RECOMENDADO = MCPC.CLIE_OID_CLIE(+) ");
         sb1.append(" AND NOT EXISTS (SELECT 1 ");        
         sb1.append("                 FROM INC_GANAD GAN, ");
         sb1.append("                 INC_PARAM_NIVEL_PREMI PNP,   ");
         sb1.append("                 INC_PARAM_GENER_PREMI PGP ");
         sb1.append("                 WHERE GAN.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM ");
         sb1.append("                 AND PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM ");
         sb1.append("                 AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append("                 AND GAN.CLIE_OID_CLIE = ISCR.RECOMENDANTE) ");
         sb1.append(" AND BASE_INC.COPA_OID_PARA_GRAL(+) = ISCR.COPA_OID_PARA_GRAL ");
         sb1.append(" AND BASE_INC.CLIE_OID_CLIE(+) = ISCR.RECOMENDANTE ");
         
 // art        
         sb1.append(" UNION ");*/
         // vbongiov -- 6/12/2006 -- inc DBLG700000040
         // vbongiov -- 9/02/2009 -- Cambio 20080806
         sb1.append(" SELECT ISCR.COPA_OID_PARA_GRAL OID_CONCURSO, ISCR.RECOMENDANTE CLIE_OID_CLIE, ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_IN + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_IN + "', ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_OUT + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_OUT + "')) ORIGEN, "); 
         sb1.append(" MCPC.FEC_CONT FECHA_INSCRIPCION, CPG.NUM_CONC NUMERO_CONCURSO,  ");
         sb1.append(" CPG.VAL_NOMB DESC_CONCURSO,  SPC.COD_PERI PERIODO, MCLIE.COD_CLIE CODIGO_RECOM, ");
         sb1.append(" MCLIE.VAL_NOM1||' '||MCLIE.VAL_NOM2||' '||MCLIE.VAL_APE1||' '||MCLIE.VAL_APE2 NOMBRE_APELLIDO, ");        
         sb1.append(" DECODE(ISCR.IND_EFEC,1,'EFECTIVA','NO EFECTIVA') SITUACION, ");
         
         // DBLG700000040 - gPineda - 09/10/2006
         //sb1.append(" DES.CADE_OID_CAUS_DESC MOTIVO_INCUMPLIMIENTO,  ");
         // vbongiov -- SiCC 20090973 -- 6/07/2009
         sb1.append(" DECODE(des.cade_oid_caus_desc, NULL, base_inc.desc_base_incum,des.cade_oid_caus_desc) MOTIVO_INCUMPLIMIENTO, ");
         
         sb1.append(" ' ' DETALLE_PREMIO_REEMPLAZO ");
         // vbongiov -- INC 014 -- 20/10/2008
         sb1.append(", NULL IMP_MONT_SOLI, ");
         sb1.append(" PNP.NUM_NIVE NIVEL, LPA.NUM_PREM NUMERO_PREMIO, I18N.val_i18n TIPO_PREMIO, ");
         sb1.append(" MPR.COD_SAP||' '||LPA.VAL_DESC_LOTE_PREM_ARTI||' '||ARL.COD_VENT_FICT||' '||ARL.NUM_UNID DATOS_PREMIO, MCLIE.OID_CLIE ");
         sb1.append(" FROM  ");
         
         sb1.append(" (SELECT RTE.CLIE_OID_CLIE RECOMENDANTE, RTE.COPA_OID_PARA_GRAL,  ");
         sb1.append(" RDO.IND_EFEC, RDO.CLIE_OID_CLIE RECOMENDADO,  ");
         sb1.append(" RDO.PANP_OID_PARA_NIVE_PREM, RDO.NUM_PREM, RDO.PERD_OID_PERI  ");
         sb1.append(" FROM INC_CLIEN_RECTE RTE, INC_CLIEN_RECDO RDO  ");
         sb1.append(" WHERE RTE.OID_CLIE_RETE = RDO.CLR3_OID_CLIE_RETE ");
         sb1.append(" AND RDO.PANP_OID_PARA_NIVE_PREM IS NOT NULL ");
         sb1.append(" AND RDO.NUM_PREM IS NOT NULL ) ISCR, ");        
         
         sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
         sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
         sb1.append(" INC_PREMI_ARTIC PRA, ");
         sb1.append(" INC_LOTE_PREMI_ARTIC LPA, ");
         sb1.append(" INC_ARTIC_LOTE ARL, ");
         sb1.append(" MAE_PRODU MPR, ");
         sb1.append(" V_GEN_I18N_SICC  I18N, ");
         sb1.append(" MAE_CLIEN MCLIE, ");
         sb1.append(" INC_DESCA DES, ");
         sb1.append(" MAE_CLIEN_PRIME_CONTA MCPC, ");
         sb1.append(" CRA_PERIO CRP, ");
         sb1.append(" SEG_PERIO_CORPO SPC, ");
         
         // DBLG700000040 - gPineda - 09/10/2006
         sb1.append(" (SELECT CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU, ");
         sb1.append(" MAX((SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_BASE_INCUM' ");
         sb1.append(" AND IDIO.IDIO_OID_IDIO = "+ dtoCab.getOidIdioma() );
         sb1.append(" AND IDIO.VAL_OID = BAI.OID_BASE_INCU)) DESC_BASE_INCUM ");
         sb1.append(" FROM INC_CANDI_GANAD CAND, ");
         sb1.append(" CRA_PERIO PER, ");
         sb1.append(" INC_BASE_INCUM BAI ");
         sb1.append(" WHERE CAND.PERD_OID_PERI = PER.OID_PERI ");
         sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
         sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC) ");
         sb1.append(" FROM INC_CANDI_GANAD CAND_SUB, ");
         sb1.append(" CRA_PERIO PER_SUB ");
         sb1.append(" WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
         sb1.append(" AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
         sb1.append(" AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
         sb1.append(" GROUP BY CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU) BASE_INC ");
         
         sb1.append(" WHERE ISCR.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
         sb1.append(" AND ISCR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append(" AND PNP.OID_PARA_NIVE_PREM = PRA.PANP_OID_PARA_NIVE_PREM ");
         sb1.append(" AND LPA.NUM_PREM =  ISCR.NUM_PREM ");
         sb1.append(" AND PRA.OID_PREM_ARTI = LPA.PRAR_OID_PREM_ARTI ");
         sb1.append(" AND ARL.LOPA_OID_LOTE_PREM_ARTI = LPA.OID_LOTE_PREM_ARTI ");
         sb1.append(" AND ARL.PROD_OID_PROD = MPR.OID_PROD ");        
         sb1.append(" AND ISCR.RECOMENDADO = MCLIE.OID_CLIE ");
         
         // DBLG700000040 - gPineda - 09/10/2006
         //sb1.append(" AND ISCR.RECOMENDANTE = DES.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.RECOMENDADO = DES.CLIE_OID_CLIE(+) ");
         
         sb1.append(" AND iscr.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL(+) ");
         // vbongiov -- 4/12/2006 -- inc DBLG700000040
         sb1.append(" AND ISCR.RECOMENDADO = MCPC.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.PERD_OID_PERI = CRP.OID_PERI ");
         sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
         sb1.append(" AND I18N.attr_enti = 'INC_TIPO_PREMI' ");
         sb1.append(" AND I18N.attr_num_atri = 1 ");
         sb1.append(" AND I18N.idio_oid_idio = ? ");
         sb1.append(" AND I18N.val_oid = PNP.TPRE_OID_TIPO_PREM ");
         sb1.append(" AND BASE_INC.COPA_OID_PARA_GRAL(+) = ISCR.COPA_OID_PARA_GRAL ");
         sb1.append(" AND BASE_INC.CLIE_OID_CLIE(+) = ISCR.RECOMENDANTE ");            
 // monet
         sb1.append(" UNION ");
         // vbongiov -- 6/12/2006 -- inc DBLG700000040
         sb1.append(" SELECT ISCR.COPA_OID_PARA_GRAL OID_CONCURSO, ISCR.RECOMENDANTE CLIE_OID_CLIE, ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_IN + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_IN + "', ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_OUT + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_OUT + "')) ORIGEN, "); 
         sb1.append(" MCPC.FEC_CONT FECHA_INSCRIPCION, CPG.NUM_CONC NUMERO_CONCURSO,  ");
         sb1.append(" CPG.VAL_NOMB DESC_CONCURSO,  SPC.COD_PERI PERIODO, MCLIE.COD_CLIE CODIGO_RECOM, ");
         sb1.append(" MCLIE.VAL_NOM1||' '||MCLIE.VAL_NOM2||' '||MCLIE.VAL_APE1||' '||MCLIE.VAL_APE2 NOMBRE_APELLIDO, ");       
         sb1.append(" DECODE(ISCR.IND_EFEC,1,'EFECTIVA','NO EFECTIVA') SITUACION, ");
         sb1.append(" DES.CADE_OID_CAUS_DESC ||'' MOTIVO_INCUMPLIMIENTO,  ");
         sb1.append(" '' DETALLE_PREMIO_REEMPLAZO ");
         // vbongiov -- INC 014 -- 20/10/2008
         sb1.append(", NULL IMP_MONT_SOLI, ");
         sb1.append(" PNP.NUM_NIVE NIVEL, IPM.NUM_PREM NUMERO_PREMIO, I18N.val_i18n TIPO_PREMIO, ");
         sb1.append(" SMO.VAL_NOMB_CORT_MONE||' '|| ");
         sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_FORMA_PAGO'  ");
         sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = IPM.FPAG_OID_FORM_PAGO) DATOS_PREMIO, MCLIE.OID_CLIE ");
         sb1.append(" FROM  ");
         
         sb1.append(" (SELECT RTE.CLIE_OID_CLIE RECOMENDANTE, RTE.COPA_OID_PARA_GRAL,  ");
         sb1.append(" RDO.IND_EFEC, RDO.CLIE_OID_CLIE RECOMENDADO,  ");
         sb1.append(" RDO.PANP_OID_PARA_NIVE_PREM, RDO.NUM_PREM, RDO.PERD_OID_PERI  ");
         sb1.append(" FROM INC_CLIEN_RECTE RTE, INC_CLIEN_RECDO RDO  ");
         sb1.append(" WHERE RTE.OID_CLIE_RETE = RDO.CLR3_OID_CLIE_RETE ");
         sb1.append(" AND RDO.PANP_OID_PARA_NIVE_PREM IS NOT NULL ");
         sb1.append(" AND RDO.NUM_PREM IS NOT NULL ) ISCR, ");
         
         sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
         sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
         sb1.append(" INC_PREMI_MONET IPM, ");
         sb1.append(" SEG_MONED SMO, ");
         sb1.append(" MAE_CLIEN MCLIE, ");
         sb1.append(" INC_DESCA DES, ");
         sb1.append(" MAE_CLIEN_PRIME_CONTA MCPC, ");
         sb1.append(" CRA_PERIO CRP, ");
         sb1.append(" V_GEN_I18N_SICC  I18N, ");
         sb1.append(" SEG_PERIO_CORPO SPC , ");

         // DBLG700000040 - gPineda - 09/10/2006        
         sb1.append(" (SELECT CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU, ");
         sb1.append(" MAX((SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_BASE_INCUM'  ");
         sb1.append(" AND IDIO.IDIO_OID_IDIO = "+dtoCab.getOidIdioma() );
         sb1.append(" AND IDIO.VAL_OID = BAI.OID_BASE_INCU)) DESC_BASE_INCUM ");
         sb1.append(" FROM INC_CANDI_GANAD CAND, ");
         sb1.append(" CRA_PERIO PER, ");
         sb1.append(" INC_BASE_INCUM BAI ");
         sb1.append(" WHERE CAND.PERD_OID_PERI = PER.OID_PERI ");
         sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
         sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC) ");
         sb1.append(" FROM INC_CANDI_GANAD CAND_SUB, ");
         sb1.append(" CRA_PERIO PER_SUB ");
         sb1.append(" WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
         sb1.append(" AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
         sb1.append(" AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
         sb1.append(" GROUP BY CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU) BASE_INC ");

         sb1.append(" WHERE ISCR.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM  ");
         sb1.append(" AND ISCR.PANP_OID_PARA_NIVE_PREM = IPM.PANP_OID_PARA_NIVE_PREM ");
         sb1.append(" AND ISCR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL  ");
         sb1.append(" AND ISCR.NUM_PREM = IPM.NUM_PREM ");
         sb1.append(" AND IPM.MONE_OID_MONE = SMO.OID_MONE ");
         sb1.append(" AND ISCR.RECOMENDADO = MCLIE.OID_CLIE ");
         sb1.append(" AND ISCR.RECOMENDANTE = DES.CLIE_OID_CLIE(+) ");
         sb1.append(" AND iscr.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL(+) ");
         // vbongiov -- 4/12/2006 -- inc DBLG700000040
         sb1.append(" AND ISCR.RECOMENDADO = MCPC.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.PERD_OID_PERI = CRP.OID_PERI ");
         sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
         sb1.append(" AND I18N.attr_enti = 'INC_TIPO_PREMI' ");
         sb1.append(" AND I18N.attr_num_atri = 1 ");
         sb1.append(" AND I18N.idio_oid_idio = ? ");
         sb1.append(" AND I18N.val_oid = PNP.TPRE_OID_TIPO_PREM ");
         
         // DBLG700000040 - gPineda - 09/10/2006
         sb1.append(" AND BASE_INC.COPA_OID_PARA_GRAL(+) = ISCR.COPA_OID_PARA_GRAL ");
         sb1.append(" AND BASE_INC.CLIE_OID_CLIE(+) = ISCR.RECOMENDANTE ");
          
 //punt
         sb1.append(" UNION ");
         // vbongiov -- 6/12/2006 -- inc DBLG700000040
         sb1.append(" SELECT ISCR.COPA_OID_PARA_GRAL OID_CONCURSO, ISCR.RECOMENDANTE CLIE_OID_CLIE,  ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_IN + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_IN + "', ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_OUT + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_OUT + "')) ORIGEN, "); 
         sb1.append(" MCPC.FEC_CONT FECHA_INSCRIPCION, CPG.NUM_CONC NUMERO_CONCURSO,  ");
         sb1.append(" CPG.VAL_NOMB DESC_CONCURSO, SPC.COD_PERI PERIODO, MCLIE.COD_CLIE CODIGO_RECOM, ");
         sb1.append(" MCLIE.VAL_NOM1||' '||MCLIE.VAL_NOM2||' '||MCLIE.VAL_APE1||' '||MCLIE.VAL_APE2 NOMBRE_APELLIDO, ");        
         sb1.append(" DECODE(ISCR.IND_EFEC,1,'EFECTIVA','NO EFECTIVA') SITUACION, ");
         
         // DBLG700000040 - gPineda - 09/10/2006
         //sb1.append(" DES.CADE_OID_CAUS_DESC MOTIVO_INCUMPLIMIENTO,  ");
         // vbongiov -- SiCC 20090973 -- 6/07/2009
         sb1.append(" DECODE(des.cade_oid_caus_desc, NULL, base_inc.desc_base_incum,des.cade_oid_caus_desc) MOTIVO_INCUMPLIMIENTO, ");
         
         sb1.append(" '' DETALLE_PREMIO_REEMPLAZO ");
         // vbongiov -- INC 014 -- 20/10/2008
         sb1.append(", NULL IMP_MONT_SOLI, ");
         sb1.append(" PNP.NUM_NIVE NIVEL, IPP.NUM_PREM NUMERO_PREMIO, I18N.val_i18n TIPO_PREMIO, ");
         // vbongiov -- 11/09/2006 -- inc DBLG500000316
         sb1.append(" CPG_PP.NUM_CONC||' '||CPG_PP.VAL_NOMB DATOS_PREMIO, MCLIE.OID_CLIE ");
         
         sb1.append(" FROM  ");
         sb1.append(" (SELECT RTE.CLIE_OID_CLIE RECOMENDANTE, RTE.COPA_OID_PARA_GRAL,  ");
         sb1.append(" RDO.IND_EFEC, RDO.CLIE_OID_CLIE RECOMENDADO,  ");
         sb1.append(" RDO.PANP_OID_PARA_NIVE_PREM, RDO.NUM_PREM, RDO.PERD_OID_PERI  ");
         sb1.append(" FROM INC_CLIEN_RECTE RTE, INC_CLIEN_RECDO RDO  ");
         sb1.append(" WHERE RTE.OID_CLIE_RETE = RDO.CLR3_OID_CLIE_RETE ");
         sb1.append(" AND RDO.PANP_OID_PARA_NIVE_PREM IS NOT NULL ");
         sb1.append(" AND RDO.NUM_PREM IS NOT NULL ) ISCR, ");
         
         sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
         sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
         sb1.append(" INC_PREMI_PUNTO IPP, ");
         sb1.append(" INC_CONCU_PARAM_GENER CPG_PP, ");
         sb1.append(" MAE_CLIEN MCLIE, ");
         sb1.append(" INC_DESCA DES, ");
         sb1.append(" MAE_CLIEN_PRIME_CONTA MCPC, ");
         sb1.append(" CRA_PERIO CRP, ");
         sb1.append(" V_GEN_I18N_SICC  I18N, ");
         sb1.append(" SEG_PERIO_CORPO SPC , ");

         // DBLG700000040 - gPineda - 09/10/2006        
         sb1.append(" (SELECT CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU, ");
         sb1.append(" MAX((SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_BASE_INCUM'  ");
         sb1.append(" AND IDIO.IDIO_OID_IDIO = "+ dtoCab.getOidIdioma() );
         sb1.append(" AND IDIO.VAL_OID = BAI.OID_BASE_INCU)) DESC_BASE_INCUM ");
         sb1.append(" FROM INC_CANDI_GANAD CAND, ");
         sb1.append(" CRA_PERIO PER, ");
         sb1.append(" INC_BASE_INCUM BAI ");
         sb1.append(" WHERE CAND.PERD_OID_PERI = PER.OID_PERI ");
         sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
         sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC) ");
         sb1.append(" FROM INC_CANDI_GANAD CAND_SUB, ");
         sb1.append(" CRA_PERIO PER_SUB ");
         sb1.append(" WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
         sb1.append(" AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
         sb1.append(" AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
         sb1.append(" GROUP BY CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU) BASE_INC ");
         
         sb1.append(" WHERE ISCR.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM ");
         sb1.append(" AND ISCR.PANP_OID_PARA_NIVE_PREM = IPP.PANP_OID_PARA_NIVE_PREM   ");
         sb1.append(" AND ISCR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL  ");
         sb1.append(" AND ISCR.NUM_PREM = IPP.NUM_PREM ");
         sb1.append(" AND IPP.COPA_OID_PARA_GRAL = CPG_PP.OID_PARA_GRAL ");
         sb1.append(" AND ISCR.RECOMENDADO = MCLIE.OID_CLIE ");
         
         // DBLG700000040 - gPineda - 09/10/2006  
         //sb1.append(" AND ISCR.RECOMENDANTE = DES.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.RECOMENDADO = DES.CLIE_OID_CLIE(+) ");
         
         sb1.append(" AND iscr.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL(+) ");
         // vbongiov -- 4/12/2006 -- inc DBLG700000040
         sb1.append(" AND ISCR.RECOMENDADO = MCPC.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.PERD_OID_PERI = CRP.OID_PERI ");
         sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
         sb1.append(" AND I18N.attr_enti = 'INC_TIPO_PREMI' ");
         sb1.append(" AND I18N.attr_num_atri = 1 ");
         sb1.append(" AND I18N.idio_oid_idio = ? ");
         sb1.append(" AND I18N.val_oid = PNP.TPRE_OID_TIPO_PREM ");
         
         // DBLG700000040 - gPineda - 09/10/2006  
         sb1.append(" AND BASE_INC.COPA_OID_PARA_GRAL(+) = ISCR.COPA_OID_PARA_GRAL ");
         sb1.append(" AND BASE_INC.CLIE_OID_CLIE(+) = ISCR.RECOMENDANTE ");
     
 // desc
         sb1.append(" UNION ");
         // vbongiov -- 6/12/2006 -- inc DBLG700000040
         sb1.append(" SELECT ISCR.COPA_OID_PARA_GRAL OID_CONCURSO, ISCR.RECOMENDANTE CLIE_OID_CLIE, ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_IN + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_IN + "', ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_OUT + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_OUT + "')) ORIGEN, "); 
         sb1.append(" MCPC.FEC_CONT FECHA_INSCRIPCION, CPG.NUM_CONC NUMERO_CONCURSO,  ");
         sb1.append(" CPG.VAL_NOMB DESC_CONCURSO,  SPC.COD_PERI PERIODO, MCLIE.COD_CLIE CODIGO_RECOM, ");
         sb1.append(" MCLIE.VAL_NOM1||' '||MCLIE.VAL_NOM2||' '||MCLIE.VAL_APE1||' '||MCLIE.VAL_APE2 NOMBRE_APELLIDO, ");        
         sb1.append(" DECODE(ISCR.IND_EFEC,1,'EFECTIVA','NO EFECTIVA') SITUACION, ");
         
         // DBLG700000040 - gPineda - 09/10/2006  
         //sb1.append(" DES.CADE_OID_CAUS_DESC MOTIVO_INCUMPLIMIENTO, 
         // vbongiov -- SiCC 20090973 -- 6/07/2009
         sb1.append(" DECODE(des.cade_oid_caus_desc, NULL, base_inc.desc_base_incum,des.cade_oid_caus_desc) MOTIVO_INCUMPLIMIENTO, ");
         
         sb1.append(" '' DETALLE_PREMIO_REEMPLAZO ");
         // vbongiov -- INC 014 -- 20/10/2008
         sb1.append(", NULL IMP_MONT_SOLI, ");
         sb1.append(" PNP.NUM_NIVE NIVEL, IPD.NUM_PREM NUMERO_PREMIO, I18N.val_i18n TIPO_PREMIO, ");
         sb1.append(" TO_CHAR(IPD.VAL_PORC_DESC) DATOS_PREMIO, MCLIE.OID_CLIE ");
         
         sb1.append(" FROM  ");
         sb1.append(" (SELECT RTE.CLIE_OID_CLIE RECOMENDANTE, RTE.COPA_OID_PARA_GRAL,  ");
         sb1.append(" RDO.IND_EFEC, RDO.CLIE_OID_CLIE RECOMENDADO,  ");
         sb1.append(" RDO.PANP_OID_PARA_NIVE_PREM, RDO.NUM_PREM, RDO.PERD_OID_PERI  ");
         sb1.append(" FROM INC_CLIEN_RECTE RTE, INC_CLIEN_RECDO RDO  ");
         sb1.append(" WHERE RTE.OID_CLIE_RETE = RDO.CLR3_OID_CLIE_RETE ");
         sb1.append(" AND RDO.PANP_OID_PARA_NIVE_PREM IS NOT NULL ");
         sb1.append(" AND RDO.NUM_PREM IS NOT NULL ) ISCR, ");
         
         sb1.append(" INC_PARAM_NIVEL_PREMI PNP,  ");
         sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
         sb1.append(" INC_PREMI_DESCU IPD, ");
         sb1.append(" MAE_CLIEN MCLIE, ");
         sb1.append(" INC_DESCA DES, ");
         sb1.append(" MAE_CLIEN_PRIME_CONTA MCPC, ");
         sb1.append(" CRA_PERIO CRP, ");
         sb1.append(" V_GEN_I18N_SICC  I18N, ");
         sb1.append(" SEG_PERIO_CORPO SPC, ");
         
         // DBLG700000040 - gPineda - 09/10/2006  
         sb1.append(" (SELECT CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU,  ");
         sb1.append(" MAX((SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_BASE_INCUM'  ");
         sb1.append(" AND IDIO.IDIO_OID_IDIO = ? ");
         sb1.append(" AND IDIO.VAL_OID = BAI.OID_BASE_INCU)) DESC_BASE_INCUM ");
         sb1.append(" FROM INC_CANDI_GANAD CAND, ");
         sb1.append(" CRA_PERIO PER, ");
         sb1.append(" INC_BASE_INCUM BAI "); 
         sb1.append(" WHERE CAND.PERD_OID_PERI = PER.OID_PERI ");
         sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
         sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC) ");
         sb1.append(" FROM INC_CANDI_GANAD CAND_SUB, ");
         sb1.append(" CRA_PERIO PER_SUB ");
         sb1.append(" WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
         sb1.append(" AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
         sb1.append(" AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
         sb1.append(" GROUP BY CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU) BASE_INC ");
         
         sb1.append(" WHERE ISCR.PANP_OID_PARA_NIVE_PREM = PNP.OID_PARA_NIVE_PREM ");
         sb1.append(" AND ISCR.PANP_OID_PARA_NIVE_PREM = IPD.OID_PARA_NIVE_PREM ");
         sb1.append(" AND ISCR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append(" AND ISCR.NUM_PREM = IPD.NUM_PREM ");
                 
         sb1.append(" AND ISCR.RECOMENDADO = MCLIE.OID_CLIE ");

         // DBLG700000040 - gPineda - 09/10/2006    
         //sb1.append(" AND ISCR.RECOMENDANTE = DES.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.RECOMENDADO = DES.CLIE_OID_CLIE(+) ");

         sb1.append(" AND iscr.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL(+) ");
         // vbongiov -- 4/12/2006 -- inc DBLG700000040
         sb1.append(" AND ISCR.RECOMENDADO = MCPC.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.PERD_OID_PERI = CRP.OID_PERI ");
         sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
         sb1.append(" AND I18N.attr_enti = 'INC_TIPO_PREMI' ");
         sb1.append(" AND I18N.attr_num_atri = 1 ");
         sb1.append(" AND I18N.idio_oid_idio = ? ");
         sb1.append(" AND I18N.val_oid = PNP.TPRE_OID_TIPO_PREM ");

         // DBLG700000040 - gPineda - 09/10/2006    
         sb1.append(" AND BASE_INC.COPA_OID_PARA_GRAL(+) = ISCR.COPA_OID_PARA_GRAL ");
         sb1.append(" AND BASE_INC.CLIE_OID_CLIE(+) = ISCR.RECOMENDANTE ");
             
         
         // vbongiov -- 6/12/2006 -- inc DBLG700000040
         // No tiene cupon de recomendacion
         sb1.append(" UNION ");
         sb1.append(" SELECT ISCR.COPA_OID_PARA_GRAL OID_CONCURSO, ISCR.RECOMENDANTE CLIE_OID_CLIE, ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_IN + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_IN + "', ");
         sb1.append(" DECODE(MCPC.COD_TIPO_CONT, '" + ConstantesMAE.CODIGO_TIPO_CONTACTO_OUT + "', '" + ConstantesMAE.DESC_TIPO_CONTACTO_OUT + "')) ORIGEN, "); 
         sb1.append(" MCPC.FEC_CONT FECHA_INSCRIPCION, CPG.NUM_CONC NUMERO_CONCURSO,  ");
         sb1.append(" CPG.VAL_NOMB DESC_CONCURSO,  SPC.COD_PERI PERIODO, MCLIE.COD_CLIE CODIGO_RECOM, ");
         sb1.append(" MCLIE.VAL_NOM1||' '||MCLIE.VAL_NOM2||' '||MCLIE.VAL_APE1||' '||MCLIE.VAL_APE2 NOMBRE_APELLIDO, ");      
         sb1.append(" DECODE(ISCR.IND_EFEC,1,'EFECTIVA','NO EFECTIVA') SITUACION, ");
         // vbongiov -- SiCC 20090973 -- 6/07/2009
         sb1.append(" DECODE(des.cade_oid_caus_desc, NULL, base_inc.desc_base_incum,des.cade_oid_caus_desc) MOTIVO_INCUMPLIMIENTO, ");
            
         sb1.append(" '' DETALLE_PREMIO_REEMPLAZO ");
         // vbongiov -- INC 014 -- 20/10/2008
         sb1.append(", NULL IMP_MONT_SOLI, ");
         sb1.append(" NULL NIVEL, NULL NUMERO_PREMIO, NULL TIPO_PREMIO, ");
         sb1.append(" NULL DATOS_PREMIO, MCLIE.OID_CLIE ");
         sb1.append(" FROM  ");
         
         sb1.append(" (SELECT RTE.CLIE_OID_CLIE RECOMENDANTE, RTE.COPA_OID_PARA_GRAL,  ");
         sb1.append(" RDO.IND_EFEC, RDO.CLIE_OID_CLIE RECOMENDADO,  ");
         sb1.append(" RDO.PERD_OID_PERI  ");
         sb1.append(" FROM INC_CLIEN_RECTE RTE, INC_CLIEN_RECDO RDO  ");
         sb1.append(" WHERE RTE.OID_CLIE_RETE = RDO.CLR3_OID_CLIE_RETE ");
         sb1.append(" AND RDO.PANP_OID_PARA_NIVE_PREM IS NULL ");
         sb1.append(" AND RDO.NUM_PREM IS NULL ) ISCR, ");
         
         sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
         sb1.append(" MAE_CLIEN MCLIE, ");
         sb1.append(" INC_DESCA DES, ");
         sb1.append(" MAE_CLIEN_PRIME_CONTA MCPC, ");
         sb1.append(" CRA_PERIO CRP, ");
         sb1.append(" SEG_PERIO_CORPO SPC, ");
         
         sb1.append(" (SELECT CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU,  ");
         sb1.append(" MAX((SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_BASE_INCUM'  ");
         sb1.append(" AND IDIO.IDIO_OID_IDIO = ? ");
         sb1.append(" AND IDIO.VAL_OID = BAI.OID_BASE_INCU)) DESC_BASE_INCUM ");
         sb1.append(" FROM INC_CANDI_GANAD CAND, ");
         sb1.append(" CRA_PERIO PER, ");
         sb1.append(" INC_BASE_INCUM BAI "); 
         sb1.append(" WHERE CAND.PERD_OID_PERI = PER.OID_PERI ");
         sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
         sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC) ");
         sb1.append(" FROM INC_CANDI_GANAD CAND_SUB, ");
         sb1.append(" CRA_PERIO PER_SUB ");
         sb1.append(" WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
         sb1.append(" AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
         sb1.append(" AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
         sb1.append(" GROUP BY CAND.CLIE_OID_CLIE, CAND.COPA_OID_PARA_GRAL, BINC_OID_BASE_INCU) BASE_INC ");
         
         sb1.append(" WHERE ISCR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sb1.append(" AND ISCR.RECOMENDADO = MCLIE.OID_CLIE ");
         sb1.append(" AND ISCR.RECOMENDADO = DES.CLIE_OID_CLIE(+) ");
         sb1.append(" AND iscr.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL(+) ");
         // vbongiov -- 4/12/2006 -- inc DBLG700000040
         sb1.append(" AND ISCR.RECOMENDADO = MCPC.CLIE_OID_CLIE(+) ");
         sb1.append(" AND ISCR.PERD_OID_PERI = CRP.OID_PERI ");
         sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
         // DBLG700000040 - gPineda - 09/10/2006    
         sb1.append(" AND BASE_INC.COPA_OID_PARA_GRAL(+) = ISCR.COPA_OID_PARA_GRAL ");
         sb1.append(" AND BASE_INC.CLIE_OID_CLIE(+) = ISCR.RECOMENDANTE ");
       
                 cadenaFiltro.concatenar(sb1);
   //  cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
                 cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
     cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
     cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
     cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
     cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
     cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
     cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());

                 UtilidadesLog.info("GestorConsultasIntegrales.getQueryRecomendacion(DTOCabeceraConsultaIntegral dtoCab): Salida");
                 return cadenaFiltro;
}
	
	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public CadenaFiltro getQueryMotivoDescalificacion(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryMotivoDescalificacion(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadenaFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT CPG.OID_PARA_GRAL OID_CONCURSO, DES.CLIE_OID_CLIE, CPG.NUM_CONC NUMERO_CONCURSO,  ");
        sb1.append(" CPG.VAL_NOMB DESC_CONCURSO, SPC.COD_PERI CAMPANIA,DES.FEC_DESC FECHA_DESCALIF,  ");
        sb1.append(" INC_CAUSA_DESCA.COD_CAUS  CODIGO_MOTIVO,  ");
        sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO  ");
        sb1.append(" WHERE IDIO.ATTR_ENTI = 'INC_CAUSA_DESCA'   ");
        sb1.append(" AND IDIO.IDIO_OID_IDIO = ?  ");
        sb1.append(" AND IDIO.VAL_OID  = INC_CAUSA_DESCA.OID_CAUS_DESC  ) DESC_MOTIVO_DESCALIF ");
        sb1.append(" FROM INC_DESCA DES, ");
        sb1.append(" INC_CAUSA_DESCA,	 ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" CRA_PERIO CRP, ");
        sb1.append(" SEG_PERIO_CORPO SPC ");
        sb1.append(" WHERE DES.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        sb1.append(" AND DES.PERD_OID_PERI = CRP.OID_PERI ");
        sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
        sb1.append(" AND INC_CAUSA_DESCA.OID_CAUS_DESC  = DES.CADE_OID_CAUS_DESC ");
        
        // vbongiov -- inc DBLG500001233 -- 10/10/2006
        sb1.append(" UNION	 ");
        sb1.append(" SELECT CAND.COPA_OID_PARA_GRAL OID_CONCURSO, CAND.CLIE_OID_CLIE, ");
        sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.VAL_NOMB DESC_CONCURSO, ");
        sb1.append(" SPC.COD_PERI CAMPANIA, CAND.FEC_ULTI_ACTU FECHA_DESCALIF, ");
        sb1.append(" TO_CHAR(BINC_OID_BASE_INCU) CODIGO_MOTIVO, ");
        sb1.append(" (SELECT IDIO.VAL_I18N ");
        sb1.append("  FROM V_GEN_I18N_SICC IDIO ");
        sb1.append("  WHERE IDIO.ATTR_ENTI = 'INC_BASE_INCUM' ");
        sb1.append("  AND IDIO.IDIO_OID_IDIO = ? ");
        sb1.append("  AND IDIO.VAL_OID = BAI.OID_BASE_INCU) DESC_MOTIVO_DESCALIF ");
        sb1.append(" FROM INC_CANDI_GANAD CAND,	 ");
        sb1.append(" CRA_PERIO PER, ");
        sb1.append(" INC_BASE_INCUM BAI, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" SEG_PERIO_CORPO SPC ");
        sb1.append(" WHERE CAND.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        sb1.append(" AND CAND.PERD_OID_PERI = PER.OID_PERI ");
        sb1.append(" AND CAND.BINC_OID_BASE_INCU = BAI.OID_BASE_INCU ");
        sb1.append(" AND PER.PERI_OID_PERI = SPC.OID_PERI ");
        sb1.append(" AND PER.FEC_INIC = (SELECT MAX(PER_SUB.FEC_INIC)	 ");
        sb1.append("                     FROM INC_CANDI_GANAD CAND_SUB,  CRA_PERIO PER_SUB ");
        sb1.append("                     WHERE CAND_SUB.PERD_OID_PERI = PER_SUB.OID_PERI ");
        sb1.append("                     AND CAND_SUB.COPA_OID_PARA_GRAL = CAND.COPA_OID_PARA_GRAL ");
        sb1.append("                     AND CAND_SUB.CLIE_OID_CLIE = CAND.CLIE_OID_CLIE) ");
        
        cadenaFiltro.concatenar(sb1);
        cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());
        cadenaFiltro.concatenarParametro(dtoCab.getOidIdioma());        

		UtilidadesLog.info("GestorConsultasIntegrales.getQueryMotivoDescalificacion(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadenaFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       22/12/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Incidencia:  DBLG500000317
    * Fecha:       23/05/2006
    */
	public CadenaFiltro getQueryDetalleMultinivel(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
        UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleMultinivel(DTOCabeceraConsultaIntegral dtoCab): Entrada");        
        
        CadenaFiltro cadFiltro = new CadenaFiltro();
        StringBuffer sb1 = new StringBuffer();
        
        sb1.append(" SELECT ICRO.CLIE_OID_CLIE OID_CLIENTE_REDO, MCLIE_RO.COD_CLIE CODIGO_CONSUL_HIJA, ");
        sb1.append(" MCLIE_RO.VAL_NOM1||' '||MCLIE_RO.VAL_NOM2||' '||MCLIE_RO.VAL_APE1||' '||MCLIE_RO.VAL_APE2 NOMBRES_APELLIDOS, ");
        sb1.append(" IPRO.PERD_OID_PERI, SPC.COD_PERI CAMPANIA_INGRESO,IPRO.NUM_CANT IMPORTE_VENTA, ");
        sb1.append(" CCC.IMPORTE_INICIAL IMPORTE_INICIAL, CCC.IMPORTE_PAGADO IMPORTE_PAGADO, ");
        sb1.append(" CPG.NUM_CONC NUMERO_CONCURSO, CPG.OID_PARA_GRAL OID_CONCURSO, ICRE.CLIE_OID_CLIE, ");
        sb1.append(" DECODE(EST_RO.ESTA_OID_ESTA_CLIE, 2, 1,0) ESTADO_NUEVA, ");
        sb1.append(" DECODE(EST_RO.ESTA_OID_ESTA_CLIE,1,1,0) HIJA_ACTIVA, ");
        sb1.append(" MCLIE_RE.COD_CLIE LACODIGOMADRE,  ");
        sb1.append(" MCLIE_RE.VAL_NOM1||' '||MCLIE_RE.VAL_NOM2||' '||MCLIE_RE.VAL_APE1||' '||MCLIE_RE.VAL_APE2 LANOMBREAPELLIDO,   ");
        sb1.append(" ICRE.OID_CLIE_RECO_MULT, ");
        sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'MAE_ESTAT_CLIEN'  ");
        sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = EST_RE.ESTA_OID_ESTA_CLIE) ESTADO_RE, ");
        sb1.append(" (TDOC.VAL_SIGL || IDEN.NUM_DOCU_IDEN) LADOCUMIDENTIDAD, ZZO.COD_ZONA LAZONA, ");
        sb1.append(" (SELECT COUNT(1) FROM INC_GANAD GAN  ");
        sb1.append(" WHERE GAN.CLIE_OID_CLIE = ICRE.CLIE_OID_CLIE AND GAN.PERD_OID_PERI = IPRO.PERD_OID_PERI) GANADORA, ");
        sb1.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'INC_BASE_CALCU'  ");
        sb1.append(" AND IDIO.IDIO_OID_IDIO = ? AND IDIO.VAL_OID = IBC.OID_BASE_CALC) LABASECALCULO  ");
        sb1.append(" FROM INC_CLIEN_RECTE_MULTI ICRE, ");
        sb1.append(" INC_CLIEN_RECDO_MULTI ICRO, ");
        sb1.append(" INC_PEDID_RECDA_MULTI IPRO, ");
        sb1.append(" CRA_PERIO CRP, ");
        sb1.append(" SEG_PERIO_CORPO SPC, ");
        sb1.append(" MAE_CLIEN MCLIE_RO, ");
        sb1.append(" MAE_CLIEN MCLIE_RE,				  ");
        sb1.append(" (SELECT CMCC.PERD_OID_PERI, CMCC.CLIE_OID_CLIE,  ");
        sb1.append(" SUM(CMCC.IMP_MOVI) IMPORTE_INICIAL, ");
        sb1.append(" SUM(CMCC.IMP_PAGA) IMPORTE_PAGADO ");
        sb1.append(" FROM CCC_MOVIM_CUENT_CORRI CMCC ");
        sb1.append(" GROUP BY CMCC.PERD_OID_PERI, CMCC.CLIE_OID_CLIE) CCC, ");
        sb1.append(" INC_CONCU_PARAM_GENER CPG, ");
        sb1.append(" MAE_CLIEN_HISTO_ESTAT EST_RO, ");
        sb1.append(" MAE_CLIEN_HISTO_ESTAT EST_RE, ");
        sb1.append(" MAE_CLIEN_IDENT IDEN, ");
        sb1.append(" MAE_TIPO_DOCUM TDOC, ");
        sb1.append(" MAE_CLIEN_UNIDA_ADMIN MCUA, ");
        sb1.append(" ZON_TERRI_ADMIN ZTA, ");
        sb1.append(" ZON_SECCI ZSE, ");
        sb1.append(" ZON_ZONA ZZO, ");
        sb1.append(" INC_BASE_CALCU IBC ");
        sb1.append(" WHERE ICRE.OID_CLIE_RECO_MULT = ICRO.CLR2_CLIE_OID_CLIE  ");
        sb1.append(" AND ICRO.OID_CLIE_RECO_MULT = IPRO.CLRM_OID_CLIE_RECO_MULT ");
        sb1.append(" AND IPRO.PERD_OID_PERI = ? ");       
        sb1.append(" AND IPRO.PERD_OID_PERI = CRP.OID_PERI ");
        sb1.append(" AND CRP.PERI_OID_PERI = SPC.OID_PERI ");
        sb1.append(" AND ICRO.CLIE_OID_CLIE = MCLIE_RO.OID_CLIE ");
        sb1.append(" AND ICRE.CLIE_OID_CLIE = MCLIE_RE.OID_CLIE			 ");
        sb1.append(" AND IPRO.PERD_OID_PERI = CCC.PERD_OID_PERI ");
        sb1.append(" AND ICRE.CLIE_OID_CLIE = CCC.CLIE_OID_CLIE ");
        sb1.append(" AND ICRE.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        sb1.append(" AND ICRO.CLIE_OID_CLIE = EST_RO.CLIE_OID_CLIE ");
        sb1.append(" AND IPRO.PERD_OID_PERI = EST_RO.PERD_OID_PERI ");
        sb1.append(" AND ICRE.CLIE_OID_CLIE = EST_RE.CLIE_OID_CLIE ");
        sb1.append(" AND IPRO.PERD_OID_PERI = EST_RE.PERD_OID_PERI ");
        sb1.append(" AND ICRE.CLIE_OID_CLIE = IDEN.CLIE_OID_CLIE ");
        sb1.append(" AND IDEN.VAL_IDEN_DOCU_PRIN = 1 ");
        sb1.append(" AND IDEN.TDOC_OID_TIPO_DOCU = TDOC.OID_TIPO_DOCU ");
        sb1.append(" AND ICRE.CLIE_OID_CLIE = MCUA.CLIE_OID_CLIE ");
        sb1.append(" AND MCUA.IND_ACTI = 1 ");
        sb1.append(" AND MCUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
        sb1.append(" AND ZTA.ZSCC_OID_SECC = ZSE.OID_SECC ");
        sb1.append(" AND ZSE.ZZON_OID_ZONA = ZZO.OID_ZONA ");
        sb1.append(" AND CPG.BCAL_OID_BASE_CALC = IBC.OID_BASE_CALC ");
		
        cadFiltro.concatenar(sb1);	  
        cadFiltro.concatenarParametro(dtoCab.getOidIdioma());            
        cadFiltro.concatenarParametro(dtoCab.getOidIdioma());        
        cadFiltro.concatenarParametro(dtoCab.getOidCampania());
		
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleMultinivel(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public CadenaFiltro getFiltrosGralDetalle(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getFiltrosGralDetalle(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadFiltro = new CadenaFiltro();

		cadFiltro.concatenar(getCadenaConcurso(dtoCab));		
		cadFiltro.concatenar(getCadenaCliente(dtoCab));		
    // vbongiov -- 30/08/2006 -- Inc DBLG500001231 y DBLG500001232
    cadFiltro.concatenar(getCadenaDirigConsultora(dtoCab));

		if(dtoCab.getOidConcurso()==null) {
            CadenaFiltro cadTemp = getCadenaFiltroUnidadAdmin(dtoCab);
            if(cadTemp.getCadena().length()>0) {
                cadFiltro.concatenar(getCadenaFiltroUnidadAdmin(dtoCab));		    
            }	
		}
		
		UtilidadesLog.info("GestorConsultasIntegrales.getFiltrosGralDetalle(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public CadenaFiltro getCadenaConcurso(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaConcurso(DTOCabeceraConsultaIntegral dtoCab): Entrada");
		
		CadenaFiltro cadFiltro = new CadenaFiltro();

		if(dtoCab.getOidConcurso()==null) {
            if(dtoCab.getNumeroConcurso()!=null) {
                cadFiltro.concatenar(new StringBuffer(" AND NUMERO_CONCURSO <= ? "));		
                cadFiltro.concatenarParametro(dtoCab.getNumeroConcurso());    
            }			
		}
		else {
			cadFiltro.concatenar(new StringBuffer(" AND OID_CONCURSO = ? "));		
			cadFiltro.concatenarParametro(dtoCab.getOidConcurso());
		}		
		
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaConcurso(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public CadenaFiltro getCadenaCliente(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaCliente(DTOCabeceraConsultaIntegral dtoCab): Entrada");		
		CadenaFiltro cadFiltro = new CadenaFiltro();
	
		cadFiltro.concatenar(new StringBuffer(" AND CLIE_OID_CLIE = ? "));		
		cadFiltro.concatenarParametro(dtoCab.getOidCliente());	
		
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaCliente(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadFiltro;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       24/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Incidencia:  DBLG500000607
    * Fecha:       25/4/2006
    * 
    * Modificado:  Hugo Cordero
    * Fecha:       08/02/2007
    * Nota: Este metodo incluye todas las incidencias resueltas hasta esta fecha en el eevolutivo.
    * 
    * Modificado:  Hugo Cordero
    * Fecha:       15/02/2007
    * Nota: Se modifico los calculos de los totales
    */
	public CadenaFiltro getQueryTotalesConcursoDetalle(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryTotalesConcursoDetalle(DTOCabeceraConsultaIntegral dtoCab): Entrada");

		CadenaFiltro cadFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();

		sb1.append("SELECT OID_CONCURSO, ");
		sb1.append("   CLIE_OID_CLIE,   ");
		sb1.append("   SUM(DECODE(OID_TIPO_MOVIMIENTO,"+ ConstantesINC.TIPO_MOVIMIENTO_ABONO +",total_puntaje,0)) TOTAL_PUNTAJE_OBTENIDO, ");
        sb1.append("   SUM(DECODE(OID_TIPO_MOVIMIENTO,"+ ConstantesINC.TIPO_MOVIMIENTO_CARGO +", ");
		sb1.append("              DECODE(DEVOLUCION+ANULACION, ");
		sb1.append("                     1,total_puntaje, ");
		sb1.append("                     2,total_puntaje, ");
		sb1.append("                     0,DECODE(DESCALIFICA,1,total_puntaje,0)), ");
		sb1.append("              0)) TOTAL_PUNTAJE_PERDIDO, ");
	    sb1.append("   SUM(DECODE(OID_TIPO_MOVIMIENTO,"+ ConstantesINC.TIPO_MOVIMIENTO_CARGO +", ");
		sb1.append("              DECODE(DEVOLUCION+ANULACION, ");
		sb1.append("                     0,DECODE(DESCALIFICA,0,total_puntaje,0), ");
		sb1.append("                     0), ");
		sb1.append("              0)) TOTAL_PUNTAJE_UTILIZADO, ");
		sb1.append("   SUM(total_puntaje)SALDO_PUNTAJE,	      ");
        sb1.append("   SUM(total_puntaje) PUNTAJE_DISPONIBLE, ");
		sb1.append("   MAX(NVL(NIVEL,0)) NIVEL_ALCANZADO,   ");
		sb1.append("   MAX(DECODE( NIVEL,   0,   DECODE(CLIENTE_CANDIDATO, NULL, 'NO GANADORA', 'EN COMPETENCIA'),   'GANADORA'   )   )SITUACION, ");        
        // vbongiov --  RI 20070467 -- 4/09/2008
        sb1.append("   MAX (NVL (IMP_MONTO_VENTA, 0)) VENTA_BASE,   ");       
        // vbongiov -- RI 20070467 -- 19/09/2008
        // Se elimina  META_PERSONALIZADA
		//sb1.append("   MAX(NVL(META,0)) META_PERSONALIZADA,   ");
		//sb1.append("   DECODE(SIGN(SUM(DECODE(OID_TIPO_MOVIMIENTO,1,PUNTAJE_FACTURADO,0))- MAX(NVL(META,0)) ),   -1, 'NO LLEGA AL PUNTAJE MINIMO','LLEGÓ AL PUNTAJE MÍNIMO') OBSERVACIONES, ");
		sb1.append("   (SELECT  SUM( NVL (pnp.num_cant_fija_punt, pnp.num_cant_inic_punt)) puntaje  ");
		sb1.append("    FROM inc_premi_elegi ipe, inc_param_nivel_premi pnp  ");
		sb1.append("    WHERE  ipe.copa_oid_para_gral = "+ dtoCab.getOidConcurso() +" AND ");
		sb1.append("           ipe.clie_oid_clie = "+ dtoCab.getOidCliente() +" AND ");
		sb1.append("           ipe.panp_oid_para_nive_prem = pnp.oid_para_nive_prem  AND ");
		sb1.append("           NOT EXISTS (SELECT   gan_na.oid_gana  ");
		sb1.append("                       FROM inc_ganad gan_na,  ");
		sb1.append("                            inc_param_nivel_premi pnp_na,  ");
		sb1.append("                            inc_param_gener_premi pgp_na  ");
		sb1.append("                       WHERE gan_na.CLIE_OID_CLIE = "+ dtoCab.getOidCliente() +" AND ");
		sb1.append("                             gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem  AND ");
		sb1.append("                             gan_na.panp_oid_para_nive_prem = pnp.oid_para_nive_prem  AND ");
		sb1.append("                             pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem  AND ");
		sb1.append("                             pgp_na.copa_oid_para_gral = "+ dtoCab.getOidConcurso() +") ");
        
        // vbongiov -- INC 014 -- 20/10/2008
		sb1.append("   ) as total_puntaje_digitado,  ");
        sb1.append(" CASE WHEN(((SELECT con.IND_DUPL_CYZO FROM INC_CONCU_PARAM_GENER con WHERE con.OID_PARA_GRAL = " + dtoCab.getOidConcurso() + ") = 1) ");
        sb1.append(" AND (EXISTS (SELECT 1 FROM MAE_CLIEN_VINCU vin WHERE vin.CLIE_OID_CLIE_VNTE = " + dtoCab.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
        sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE)))) ");
        sb1.append(" THEN (SELECT cli.COD_CLIE FROM  MAE_CLIEN cli WHERE cli.OID_CLIE = (SELECT vin.CLIE_OID_CLIE_VNDO FROM MAE_CLIEN_VINCU vin  ");
        sb1.append(" WHERE vin.CLIE_OID_CLIE_VNTE = " + dtoCab.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
        sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE))) ");
        sb1.append(" ELSE '-' END COD_DUPLACYZ, ");
        sb1.append(" CASE WHEN(((SELECT con.IND_DUPL_CYZO FROM INC_CONCU_PARAM_GENER con WHERE con.OID_PARA_GRAL = " + dtoCab.getOidConcurso() + ") = 1) ");
        sb1.append(" AND (EXISTS (SELECT 1 FROM MAE_CLIEN_VINCU vin WHERE vin.CLIE_OID_CLIE_VNTE = " + dtoCab.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
        sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE)))) ");
        sb1.append(" THEN (SELECT cli.VAL_NOM1 ||' '||cli.VAL_NOM2 ||' '|| cli.VAL_APE1 ||' '|| cli.VAL_APE2 ");
        sb1.append(" FROM  MAE_CLIEN cli WHERE cli.OID_CLIE = (SELECT vin.CLIE_OID_CLIE_VNDO FROM MAE_CLIEN_VINCU vin  ");
        sb1.append(" WHERE vin.CLIE_OID_CLIE_VNTE = " + dtoCab.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
        sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE))) ");
        sb1.append(" ELSE '-' END NOMBRE_DUPLACYZ, ");
        sb1.append(" SUM (total_puntaje) TOTAL_PUNTAJE ");
		sb1.append("FROM ( ");

		cadFiltro.concatenar(sb1);		
		
		UtilidadesLog.info("GestorConsultasIntegrales.getQueryTotalesConcursoDetalle(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadFiltro;
	}
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       21/06/2006
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
    public String getQueryInicioPaginado() throws MareException {
      UtilidadesLog.info("GestorConsultasIntegrales.getQueryInicioPaginado(DTOCabeceraConsultaIntegral dtoCab): Entrada");
      StringBuffer sb1 = new StringBuffer();
      sb1.append(" SELECT * FROM (SELECT ROWNUM AS OID, E.* FROM ( ");    
      UtilidadesLog.info("GestorConsultasIntegrales.getQueryInicioPaginado(DTOCabeceraConsultaIntegral dtoCab): Salida");
      return sb1.toString();
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       21/06/2006
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
    public String getQueryFinPaginado(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
      UtilidadesLog.info("GestorConsultasIntegrales.getQueryFinPaginado(DTOCabeceraConsultaIntegral dtoCab): Entrada");
      StringBuffer sb1 = new StringBuffer();     
      sb1.append(" )E) WHERE ROWNUM < = " + dtoCab.getTamanioPagina());
      sb1.append(" AND OID > " + dtoCab.getIndicadorSituacion());
      sb1.append(" ORDER BY OID "); 
      UtilidadesLog.info("GestorConsultasIntegrales.getQueryFinPaginado(DTOCabeceraConsultaIntegral dtoCab): Salida");
      return sb1.toString();
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       30/08/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc DBLG500001231 y DBLG500001232
    */

	public CadenaFiltro getCadenaDirigConsultora(DTOCabeceraConsultaIntegral dtoCab) 
		throws MareException {
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaDirigConsultora(DTOCabeceraConsultaIntegral dtoCab): Entrada");		
    
    CadenaFiltro cadFiltro = new CadenaFiltro();
		StringBuffer sb1 = new StringBuffer();
    
    sb1.append(" AND EXISTS (SELECT 1  ");
    sb1.append(" FROM inc_concu_param_gener concurso ");
    sb1.append(" WHERE concurso.oid_para_gral = OID_CONCURSO ");
    // vbongiov -- 17/10/2006 -- DBLG500001231
    //sb1.append(" AND concurso.ind_rank = 0 ");
    sb1.append(" AND concurso.DIRI_OID_DIRI = " + ConstantesINC.TIPO_CONSULTORA + ") ");

		cadFiltro.concatenar(sb1);
		
		UtilidadesLog.info("GestorConsultasIntegrales.getCadenaDirigConsultora(DTOCabeceraConsultaIntegral dtoCab): Salida");
		return cadFiltro;
	}
        
           
    // vbongiov -- Cambio RI 20080810 -- 6/01/2009
    public CadenaFiltro getQueryDetalleConcursoCC(DTOCabeceraConsultaIntegral dto) 
            throws MareException {
            UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleConcursoCC(DTOCabeceraConsultaIntegral dto): Entrada");
            
            CadenaFiltro cadenaFiltro = new CadenaFiltro();
            StringBuffer sb1 = new StringBuffer();           

            sb1.append(" SELECT spc.cod_peri cod_peri, ");
            sb1.append(" TO_CHAR(icc.fec_movi, 'DD/MM/YYYY') fec_movi, ");
            sb1.append(" (SELECT idio.val_i18n  FROM v_gen_i18n_sicc idio ");
            sb1.append(" WHERE idio.attr_enti = 'INC_TIPO_MOVIM' ");
            sb1.append(" AND idio.idio_oid_idio = " + dto.getOidIdioma());
            sb1.append(" AND idio.val_oid = icc.tmov_oid_tipo_movi) tipo_movimiento, ");
            sb1.append(" icc.NUM_PUNT, icc.val_desc, ");
            sb1.append(" TO_CHAR(icc.FEC_ULTI_ACTU, 'DD/MM/YYYY HH24:MI:SS') FEC_ULTI_ACTU, ");
            sb1.append(" icc.COPA_OID_PARA_GRAL oid_concurso, ");
            sb1.append(" icc.CLIE_OID_CLIE clie_oid_clie, ");
            // vbongiov -- Cambio 20090861 -- 14/04/2009
            sb1.append(" icc.fec_movi fec_moviOrd, icc.FEC_ULTI_ACTU fechaUltiActuOrd");
            sb1.append(" FROM inc_cuent_corri_punto icc, ");
            sb1.append(" cra_perio crp, seg_perio_corpo spc ");
            sb1.append(" WHERE icc.clie_oid_clie = " + dto.getOidCliente());
            sb1.append(" AND icc.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append(" AND crp.oid_peri = icc.perd_oid_peri ");
            sb1.append(" AND spc.oid_peri = crp.peri_oid_peri ");
            
            cadenaFiltro.concatenar(sb1);

            UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleConcursoCC(DTOCabeceraConsultaIntegral dto): Salida");
            return cadenaFiltro;
    }        
    
    // vbongiov -- Cambio RI 20080810 -- 6/01/2009
    public CadenaFiltro getQueryTotalesConcursoDetalleCC(DTOCabeceraConsultaIntegral dto) 
            throws MareException {
            UtilidadesLog.info("GestorConsultasIntegrales.getQueryTotalesConcursoDetalleCC(DTOCabeceraConsultaIntegral dto): Entrada");
            
            CadenaFiltro cadenaFiltro = new CadenaFiltro();
            StringBuffer sb1 = new StringBuffer();           
            
            sb1.append(" SELECT NVL((SELECT   MAX (pnp_na.num_nive) "); 
            sb1.append("        FROM inc_ganad gan_na, ");
            sb1.append("        inc_param_nivel_premi pnp_na, ");
            sb1.append("        inc_param_gener_premi pgp_na ");
            sb1.append("        WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem ");
            sb1.append("        AND pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem ");
            sb1.append("        AND pgp_na.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append("        AND gan_na.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("        GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie), 0) NIVEL_ALCANZADO, ");
            sb1.append(" DECODE( NVL((SELECT   MAX (pnp_na.num_nive)  ");
            sb1.append("          FROM inc_ganad gan_na, ");
            sb1.append("          inc_param_nivel_premi pnp_na, ");
            sb1.append("          inc_param_gener_premi pgp_na "); 
            sb1.append("          WHERE gan_na.panp_oid_para_nive_prem = pnp_na.oid_para_nive_prem ");
            sb1.append("          AND pnp_na.pagp_oid_para_gene_prem = pgp_na.oid_para_gene_prem ");
            sb1.append("          AND pgp_na.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append("          AND gan_na.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("          GROUP BY pgp_na.copa_oid_para_gral, gan_na.clie_oid_clie),0) ");
            sb1.append(" ,   0,   DECODE((SELECT DISTINCT cga.clie_oid_clie ");
            sb1.append("                  FROM inc_candi_ganad cga ");
            sb1.append("                  WHERE cga.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append("                  AND cga.clie_oid_clie = " + dto.getOidCliente() + ") ");
            sb1.append("          , NULL, 'NO GANADORA', 'EN COMPETENCIA'),   'GANADORA'   )  SITUACION, ");
            sb1.append(" CASE WHEN(((SELECT con.IND_DUPL_CYZO FROM INC_CONCU_PARAM_GENER con WHERE con.OID_PARA_GRAL = " + dto.getOidConcurso() + ") = 1) ");
            sb1.append(" AND (EXISTS (SELECT 1 FROM MAE_CLIEN_VINCU vin WHERE vin.CLIE_OID_CLIE_VNTE = " + dto.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
            sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE)))) ");
            sb1.append(" THEN (SELECT cli.COD_CLIE FROM  MAE_CLIEN cli WHERE cli.OID_CLIE = (SELECT vin.CLIE_OID_CLIE_VNDO FROM MAE_CLIEN_VINCU vin  ");
            sb1.append(" WHERE vin.CLIE_OID_CLIE_VNTE = " + dto.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
            sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE))) ");
            sb1.append(" ELSE '-' END COD_DUPLACYZ, ");
            sb1.append(" CASE WHEN(((SELECT con.IND_DUPL_CYZO FROM INC_CONCU_PARAM_GENER con WHERE con.OID_PARA_GRAL = " + dto.getOidConcurso() + ") = 1) ");
            sb1.append(" AND (EXISTS (SELECT 1 FROM MAE_CLIEN_VINCU vin WHERE vin.CLIE_OID_CLIE_VNTE = " + dto.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
            sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE)))) ");
            sb1.append(" THEN (SELECT cli.VAL_NOM1 ||' '||cli.VAL_NOM2 ||' '|| cli.VAL_APE1 ||' '|| cli.VAL_APE2 ");
            sb1.append(" FROM  MAE_CLIEN cli WHERE cli.OID_CLIE = (SELECT vin.CLIE_OID_CLIE_VNDO FROM MAE_CLIEN_VINCU vin  ");
            sb1.append(" WHERE vin.CLIE_OID_CLIE_VNTE = " + dto.getOidCliente() + " AND vin.TIVC_OID_TIPO_VINC = 1 AND  ");
            sb1.append(" (vin.FEC_HAST IS NULL OR vin.FEC_HAST > SYSDATE))) ");
            sb1.append(" ELSE '-' END NOMBRE_DUPLACYZ, ");
            sb1.append(" NVL((SELECT IMP_MONTO_VENTA ");
            sb1.append("         FROM inc_metas_tipo_venta mtv ");
            sb1.append("         WHERE mtv.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("         AND mtv.copa_oid_para_gral = " + dto.getOidConcurso() + ") ,0)  VENTA_BASE, ");
            sb1.append(" NVL((SELECT SUM(icc.NUM_PUNT) TOTAL_PUNTAJE_OBTENIDO ");
            sb1.append("         FROM inc_cuent_corri_punto icc ");
            sb1.append("         WHERE icc.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("         AND icc.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append("         AND icc.TMOV_OID_TIPO_MOVI = " + ConstantesINC.TIPO_MOVIMIENTO_ABONO + " ) ,0) TOTAL_PUNTAJE_OBTENIDO, ");
            sb1.append(" NVL((SELECT SUM(icc.NUM_PUNT) TOTAL_PUNTAJE_PERDIDO ");
            sb1.append("         FROM inc_cuent_corri_punto icc ");
            sb1.append("         WHERE icc.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("         AND icc.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append("         AND icc.TMOV_OID_TIPO_MOVI = " + ConstantesINC.TIPO_MOVIMIENTO_CARGO );
            sb1.append("         AND UPPER(ICC.VAL_DESC) NOT LIKE UPPER('%"+ ConstantesINC.DESC_ENTREGA_PREMIO + "%')) ,0) TOTAL_PUNTAJE_PERDIDO, ");
            sb1.append(" NVL((SELECT SUM(icc.NUM_PUNT) TOTAL_PUNTAJE_UTILIZADO ");
            sb1.append("         FROM inc_cuent_corri_punto icc ");
            sb1.append("         WHERE icc.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("         AND icc.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append("         AND UPPER(ICC.VAL_DESC) LIKE UPPER('%" + ConstantesINC.DESC_ENTREGA_PREMIO + "%')) ,0) TOTAL_PUNTAJE_UTILIZADO , ");
            sb1.append(" (SELECT SUM(icc.NUM_PUNT) SALDO_PUNTAJE ");
            sb1.append("         FROM inc_cuent_corri_punto icc");
            sb1.append("         WHERE icc.clie_oid_clie = " + dto.getOidCliente());
            sb1.append("         AND icc.copa_oid_para_gral = " + dto.getOidConcurso() + ") SALDO_PUNTAJE ");
            sb1.append(" FROM DUAL");                  
            
            cadenaFiltro.concatenar(sb1);

            UtilidadesLog.info("GestorConsultasIntegrales.getQueryTotalesConcursoDetalleCC(DTOCabeceraConsultaIntegral dto): Salida");
            return cadenaFiltro;
    }   
    
    // vbongiov -- Cambio RI 20080810 -- 6/01/2009
    public CadenaFiltro getQueryDetalleSolicitudes(DTOCabeceraConsultaIntegral dto) 
            throws MareException {
            UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleSolicitudes(DTOCabeceraConsultaIntegral dto): Entrada");
            
            CadenaFiltro cadenaFiltro = new CadenaFiltro();
            StringBuffer sb1 = new StringBuffer();           

            sb1.append(" SELECT spc.cod_peri cod_peri, ");
            sb1.append(" TO_CHAR(solCon.FEC_DOCU, 'DD/MM/YYYY') FEC_DOCU, ");
            sb1.append(" cabPed.VAL_NUME_SOLI NUM_SOLICITUD, ");
            sb1.append(" (SELECT idio.val_i18n  FROM v_gen_i18n_sicc idio  ");
            sb1.append(" WHERE idio.attr_enti = 'PED_TIPO_SOLIC'  ");
            sb1.append(" AND idio.idio_oid_idio = "  + dto.getOidIdioma());
            sb1.append(" AND idio.val_oid = tipoSolP.TSOL_OID_TIPO_SOLI) tipo_solicitud, ");
            sb1.append(" TO_CHAR(cabCons.FEC_FACT, 'DD/MM/YYYY') FEC_FACT, ");
            sb1.append(" cabCons.VAL_NUME_SOLI NUM_CONSOLIDADO, solCon.NUM_PUNT,  ");
            sb1.append(" (solCon.NUM_PUNT - solCon.VAL_PUNT_BONI - solCon.VAL_PUNT_FALT_NANU) PUNT_FACTURADO, ");
            sb1.append(" solCon.VAL_PUNT_BONI, solCon.VAL_PUNT_FALT_NANU, solCon.IND_ANUL ");
            sb1.append(" FROM INC_SOLIC_CONCU_PUNTA solCon, PED_SOLIC_CABEC cabPed, ");
            sb1.append(" PED_TIPO_SOLIC_PAIS tipoSolP, PED_SOLIC_CABEC cabCons, ");
            sb1.append(" cra_perio crp, seg_perio_corpo spc ");
            sb1.append(" WHERE solCon.clie_oid_clie = " + dto.getOidCliente());
            sb1.append(" AND solCon.copa_oid_para_gral = " + dto.getOidConcurso());
            sb1.append(" AND crp.oid_peri = solCon.perd_oid_peri ");
            sb1.append(" AND spc.oid_peri = crp.peri_oid_peri ");
            sb1.append(" AND cabPed.OID_SOLI_CABE = solCon.SOCA_OID_SOLI_CABE ");
            sb1.append(" AND tipoSolP.OID_TIPO_SOLI_PAIS = cabPed.TSPA_OID_TIPO_SOLI_PAIS ");
            sb1.append(" AND cabCons.OID_SOLI_CABE = cabPed.SOCA_OID_SOLI_CABE ");
            sb1.append(" ORDER BY cod_peri DESC, FEC_DOCU DESC ");
            
            cadenaFiltro.concatenar(sb1);

            UtilidadesLog.info("GestorConsultasIntegrales.getQueryDetalleSolicitudes(DTOCabeceraConsultaIntegral dto): Salida");
            return cadenaFiltro;
    }           
}

