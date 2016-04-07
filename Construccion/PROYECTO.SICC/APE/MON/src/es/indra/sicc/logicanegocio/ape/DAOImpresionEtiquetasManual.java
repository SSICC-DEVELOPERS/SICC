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
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.dtos.ape.DTOImpresionEtiquetasManual;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class DAOImpresionEtiquetasManual {

    /**
     * Recupera info de las etiquetas a imprimir, segun los filtros
     * que indique el DTO de entrada.
     * @author dmorello
     * @since 22/01/2007
     */
    public DTOSalida buscarEtiquetasImprimir(DTOBusquedaEtiqueta dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasManual.buscarEtiquetasImprimir(DTOBusquedaEtiqueta dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("  SELECT etiqueta.oid_etiq AS oid, etiqueta.num_etiq, solicitud.val_nume_soli, etiqueta.num_caja, ");
				query.append("         gen.val_i18n AS tipocajaembalaje, etiqueta.num_secu, etiqueta.ind_impr ");
				query.append("    FROM ape_etiqu etiqueta, ped_solic_cabec solicitud, v_gen_i18n_sicc gen ");
				query.append("   WHERE etiqueta.soca_oid_soli_cabe = solicitud.oid_soli_cabe ");
				if (dtoe.getNroSolicCabec() != null) {
            query.append(" AND solicitud.val_nume_soli = ");
            query.append(dtoe.getNroSolicCabec());
        }
				if (dtoe.getImpresa() != null)   {
            query.append(" AND etiqueta.ind_impr = '");
            if (dtoe.getImpresa().booleanValue()) {
                query.append(ConstantesAPE.IMPRESION_SI).append('\'');
            } else {
                query.append(ConstantesAPE.IMPRESION_NO).append('\'');
            }
        }
        query.append("     AND etiqueta.pais_oid_pais =  ");
        query.append(dtoe.getOidPais());
				if (dtoe.getNroCaja() != null) {
            query.append("    AND etiqueta.num_caja = ");
            query.append(dtoe.getNroCaja());
        }
        query.append("    AND (etiqueta.ind_esta != '");
        query.append(ConstantesAPE.ESTADO_ANULADA).append("' OR etiqueta.ind_esta IS NULL) ");
				query.append("    AND etiqueta.tcem_oid_tipo_caja_emba = gen.val_oid ");
				query.append("    AND gen.idio_oid_idio = ");
        query.append(dtoe.getOidIdioma());
				query.append("    AND gen.attr_enti = 'APE_TIPO_CAJA_EMBAL' ");
        query.append(" ORDER BY OID ASC ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs.esVacio()) {
            String modulo = ConstantesSEG.MODULO_APE;
            String error = ErroresDeNegocio.APE_0027;
            throw new MareException("", UtilidadesError.armarCodigoError(modulo, error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOImpresionEtiquetasManual.buscarEtiquetasImprimir(DTOBusquedaEtiqueta dtoe): Salida");
        return dtoSalida;
    }

    /**
     * Recupera info del formato de las etiquetas cuyos OIDs vienen por parametro.
     * Nota dmorello 22/10/2007: Se asume que los OIDs recibidos son de etiquetas de la
     * misma lista de picado.
     * @author dmorello
     * @since 22/01/2007
     * 
     * CHANGELOG
     * ---------
     * 08/10/2009 - dmorello, Cambio 20090839 - Recupero desc linea armado y fecha facturacion
     */
    public RecordSet recuperarFormatosEtiquetas(DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasManual.recuperarFormatosEtiquetas(DTOOIDs dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Long[] oids = dtoE.getOids();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT DISTINCT etiqueta.oid_etiq, etiqueta.num_etiq as numeroetiqueta, ");
        query.append("     solicitud.val_nume_soli, solicitud.sbac_oid_sbac, ");
        query.append("     NVL(solicitud.clie_oid_clie_dest, solicitud.clie_oid_clie) AS oid_clie, ");
        query.append(" 	   pc.cod_peri, ");
        query.append(" 	   region.cod_regi, zona.cod_zona, seccion.cod_secc, ");
        query.append("     etiqueta.num_caja, etiqueta.num_tota_caja, etiqueta.num_secu, ");
        query.append(" 	   listacab.clie_oid_clie AS clie_oid_clie_list, ");
        query.append("     listacab.inre_oid_indi_revi, ");
        query.append(" 	   listacab.val_text_cheq, listacab.val_text_prim_pedi, ");
        query.append(" 	   linea.num_long_nume_etiq, ");
        query.append("     subl_y_prog.oid_subl_arma, ");
        query.append("     subl_y_prog.val_nomb_prog AS nombr_progr, ");
        query.append("     tipocaja.num_etiq, ");
        query.append("     tipocaja.val_tipo_caja, ");
        query.append("     sociedad.val_deno, ");
        query.append("     subtipo.cod_subt_clie, ");
        query.append("     cd.ind_impr_dato_basi_clie, ");
        query.append("     pq_apl_aux.valor_gen_i18n_sicc(1, linea.oid_line_arma, 'APE_LINEA_ARMAD') AS desc_linea, ");
        query.append("     solicitud.fec_fact ");
        query.append(" FROM ape_etiqu etiqueta, ");
        query.append(" 	 ape_lista_picad_cabec listacab, ");
        query.append(" 	 ape_lista_picad_detal listadet, ");
        query.append(" 	 ape_tipo_caja_embal tipocaja, ");
        query.append(" 	 ped_solic_cabec solicitud, ");
        query.append(" 	 ape_linea_armad linea, ");
        query.append("   app_confi_centr_distr cd, ");
        query.append(" 	 (SELECT * FROM (");
        query.append(" 	     SELECT datos.oid_subl_arma, programa.val_nomb_prog");
        query.append(" 	       FROM (");
        query.append(" 	             SELECT DISTINCT sublinea.oid_subl_arma, formato.pret_oid_prog_etiq");
        query.append(" 	               FROM ape_etiqu etiqueta,");
        query.append(" 	                    ape_lista_picad_detal listadet,");
        query.append(" 	                    ape_mapa_centr_distr_detal mcdd,");
        query.append(" 	                    ape_subli_armad sublinea,");
        query.append(" 	                    ape_forma_etiqu formato");
        query.append(" 	              WHERE etiqueta.oid_etiq = ").append(oids[0]);
        query.append(" 	                AND etiqueta.lpca_oid_list_pica_cabe = listadet.lpca_oid_list_pica_cabe");
        query.append(" 	                AND listadet.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta");
        query.append(" 	                AND mcdd.sbar_oid_subl_arma = sublinea.oid_subl_arma");
        query.append(" 	                AND sublinea.oid_subl_arma = formato.sbar_oid_subl_arma (+)");
        query.append(" 	         ) datos,");
        query.append(" 	         ape_progr_etiqu programa");
        query.append(" 	      WHERE datos.pret_oid_prog_etiq = programa.oid_prog_etiq (+)");
        query.append(" 	     ORDER BY programa.num_prio DESC NULLS LAST, oid_subl_arma");
        query.append(" 	     ) WHERE ROWNUM = 1");
        query.append(" 	 ) subl_y_prog,");
        query.append(" 	 cra_perio periodo, ");
        query.append("   seg_perio_corpo pc, ");
        query.append(" 	 zon_regio region, ");
        query.append(" 	 zon_zona zona, ");
        query.append(" 	 zon_secci seccion, ");
        query.append(" 	 zon_terri_admin ta, ");
        query.append("   zon_terri terr, ");
        query.append("   seg_socie sociedad, ");
        query.append("   mae_clien_tipo_subti cts, ");
        query.append("   mae_subti_clien subtipo ");
        query.append(" WHERE etiqueta.oid_etiq in (");
        for (int i = 0; i < oids.length; ) {
            query.append(oids[i]).append( (++i < oids.length)? ',' : ')' );
        }
        query.append("   AND etiqueta.lpca_oid_list_pica_cabe = listacab.oid_list_pica_cabe ");
        query.append("   AND listadet.lpca_oid_list_pica_cabe = listacab.oid_list_pica_cabe ");
        query.append("   AND listadet.tcem_oid_tipo_caja_emba = tipocaja.oid_tipo_caja_emba (+) ");
        query.append("   AND listacab.soca_oid_soli_cabe = solicitud.oid_soli_cabe ");
        query.append("   AND listacab.liar_oid_line_arma = linea.oid_line_arma ");
        query.append("   AND listacab.ccdi_oid_conf_cent_dist = cd.oid_conf_cent_dist ");
        query.append("   AND etiqueta.num_caja = listadet.num_caja "); // Agregado 14/02/2007, no figura en el DECU
        query.append("   AND solicitud.perd_oid_peri = periodo.oid_peri ");
        query.append("   AND periodo.peri_oid_peri = pc.oid_peri ");
        query.append("   AND solicitud.zzon_oid_zona = zona.oid_zona ");
        query.append("   AND zona.zorg_oid_regi = region.oid_regi ");
        query.append("   AND solicitud.ztad_oid_terr_admi = ta.oid_terr_admi ");
        query.append("   AND ta.zscc_oid_secc = seccion.oid_secc ");
        query.append("   AND solicitud.terr_oid_terr = terr.oid_terr ");
        query.append("   AND solicitud.soci_oid_soci = sociedad.oid_soci ");
        query.append("   AND NVL(solicitud.clie_oid_clie_dest,solicitud.clie_oid_clie) = cts.clie_oid_clie ");
        query.append("   AND cts.ind_ppal = ").append(ConstantesAPE.TRUE);
        query.append("   AND cts.sbti_oid_subt_clie = subtipo.oid_subt_clie ");
        query.append(" ORDER BY val_nume_soli, num_caja ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("Elementos del recordset: " + rs.getRowCount());
        
        UtilidadesLog.info("DAOImpresionEtiquetasManual.recuperarFormatosEtiquetas(DTOOIDs dtoE): Salida");
        return rs;
    }
    
    
    /**
     * Busca el texto variable para cada cliente recibido por parámetro
     * de acuerdo a su tipificación. El DTOOIDs que recibe como parámetro
     * debe tener seteado el OID de país.
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet que contiene OIDs de clientes y los textos variables para ellos
     * @param dtoe DTOOIDs con los OIDs de los clientes a buscar y el OID de país
     */
    public HashMap recuperarTextosVariables(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasManual.recuperarTextosVariables(DTOOIDs dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Long[] oids = dtoe.getOids();
        StringBuffer query = new StringBuffer();

				/*
         * dmorello, 01/02/2007
         * Se busca la tipificacion principal para cada cliente en una subquery.
         * Se buscan todos los textos variables para el pais recibido por parámetro en otra subquery.
         * Se hace un join de ambas tablas virtuales por tipo de cliente
         * De todos los registros de texto variable, se toma para cada cliente solo uno,
         * que es el que se ajusta más específicamente a la tipificación del mismo.
         */
        query.append(" SELECT   clie_oid_clie, val_text_vari ");
				query.append("     FROM (SELECT ROW_NUMBER () OVER (PARTITION BY tipif.clie_oid_clie ORDER BY tipif.clie_oid_clie, ");
				query.append(" 	                  tipif.ticl_oid_tipo_clie, ");
				query.append(" 	                  texto.sbti_oid_subt_clie NULLS LAST, ");
				query.append(" 	                  texto.tccl_oid_tipo_clas NULLS LAST, ");
				query.append(" 	                  texto.clas_oid_clas NULLS LAST) AS auxiliar, ");
				query.append("                  tipif.clie_oid_clie, texto.val_text_vari ");
				query.append("             FROM (SELECT cts.clie_oid_clie, cts.ticl_oid_tipo_clie, ");
				query.append("                          cts.sbti_oid_subt_clie, cc.tccl_oid_tipo_clasi, ");
				query.append("                          cc.clas_oid_clas ");
				query.append("                     FROM mae_clien_tipo_subti cts, mae_clien_clasi cc ");
				query.append("                    WHERE cts.clie_oid_clie IN (");
        for (int i = 0; i < oids.length; ) {
            query.append(oids[i]);
            query.append( (++i < oids.length)? ',' : ')' );
        }
				query.append("                      AND cts.ind_ppal = ").append(ConstantesAPE.TRUE);
				query.append("                      AND cc.ctsu_oid_clie_tipo_subt(+) =cts.oid_clie_tipo_subt ");
				query.append("                      AND cc.ind_ppal(+) = ").append(ConstantesAPE.TRUE);
        query.append("                      ) tipif, ");
				query.append("                  (SELECT texto.ticl_oid_tipo_clie, texto.sbti_oid_subt_clie, ");
				query.append("                          texto.tccl_oid_tipo_clas, texto.clas_oid_clas, ");
				query.append("                          texto.oid_conf_text_vari, texto.val_text_vari ");
				query.append("                     FROM ape_confi_texto_varia texto ");
				query.append("                    WHERE texto.pais_oid_pais = ").append(dtoe.getOidPais());
        query.append("                      ) texto ");
				query.append("            WHERE tipif.ticl_oid_tipo_clie = texto.ticl_oid_tipo_clie ");
				query.append("              AND (   (    texto.clas_oid_clas IS NOT NULL ");
				query.append("                       AND texto.clas_oid_clas = tipif.clas_oid_clas ");
				query.append("                      ) ");
				query.append("                   OR (    texto.clas_oid_clas IS NULL ");
				query.append("                       AND texto.tccl_oid_tipo_clas IS NULL ");
				query.append("                       AND texto.sbti_oid_subt_clie IS NOT NULL ");
				query.append("                       AND texto.sbti_oid_subt_clie = tipif.sbti_oid_subt_clie ");
				query.append("                      ) ");
				query.append("                   OR (    texto.clas_oid_clas IS NULL ");
				query.append("                       AND texto.tccl_oid_tipo_clas IS NULL ");
				query.append("                       AND texto.sbti_oid_subt_clie IS NULL ");
				query.append("                       AND texto.ticl_oid_tipo_clie = tipif.ticl_oid_tipo_clie ");
				query.append("                      ) ");
				query.append("                  )) ");
				query.append("    WHERE auxiliar = 1 ");
				query.append(" ORDER BY clie_oid_clie ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        HashMap hashMap = new HashMap();
        int rowCount = rs.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Long cliente = new Long(((BigDecimal)rs.getValueAt(i, "CLIE_OID_CLIE")).longValue());
            Object texto = rs.getValueAt(i, "VAL_TEXT_VARI");
            hashMap.put(cliente,texto);
        }
        UtilidadesLog.debug("hashMap: " + hashMap);
        
        UtilidadesLog.info("DAOImpresionEtiquetasManual.recuperarTextosVariables(DTOOIDs dtoe): Salida");
        return hashMap;
    }
    
    
    
    /**
     * Obtiene nombres, apellidos, dirección y teléfono
     * de los clientes que recibe en el parámetro de entrada
     * 
     * CHANGELOG
     * ---------
     * dmorello, 08/05/2008 - Cambio APE-10: Se recupera el barrio
     */
    public RecordSet obtenerDatosClientes(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasManual.obtenerDatosClientes(DTOOIDs dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        Long[] oids = dtoe.getOids();
        StringBuffer query = new StringBuffer();
        
        query.append("   SELECT cliente.oid_clie, ");
        query.append("          cliente.val_nom1, ");
        query.append("          cliente.val_nom2, ");
        query.append("   	      cliente.val_ape1, ");
        query.append("          cliente.val_ape2, ");
        query.append("    	     direccion.val_nomb_via, ");
        query.append("   	      direccion.num_ppal, ");
        query.append("          direccion.val_cod_post, ");
        query.append(" 	     (SELECT val_text_comu ");
        query.append("   	      FROM mae_clien_comun ");
        query.append(" 		     WHERE clie_oid_clie = cliente.oid_clie ");
        query.append(" 		       AND ticm_oid_tipo_comu = ").append(ConstantesMAE.TIPO_COMUNICACION_TFNO);
        query.append("       ) telefono ");
        query.append("        , direccion.val_barr ");
        query.append("     FROM mae_clien cliente, ");
        query.append("          mae_clien_direc direccion ");
        query.append("    WHERE cliente.oid_clie IN (");
        for (int i = 0; i < oids.length; ) {
            query.append(oids[i]).append( (++i < oids.length)? ',' : ')' );
        }
        query.append("      AND cliente.oid_clie = direccion.clie_oid_clie ");
        query.append("      AND direccion.ind_dire_ppal = ").append(ConstantesAPE.TRUE);
        //query.append("      AND direccion.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        query.append("      AND direccion.ind_elim = ").append(ConstantesAPE.FALSE);
        query.append(" ORDER BY oid_clie ASC");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionEtiquetasManual.obtenerDatosClientes(DTOOIDs dtoe): Salida");
        return rs;
    }
    
    /**
     * Actualiza en APE_ETIQU los campos IND_ESTA, IND_IMPR.
     * Si no es una reimpresión también actualiza ESTP_OID_ESTA_PEDI
     * @author dmorello
     * 
     * CHANGELOG
     * ---------
     * dmorello, 05/06/2008 - Cambio APE-09 - Se renombra el método a actualizarEtiquetas
     *                        Se agrega actualización de estatus pedido
     *                        sólo si la etiqueta está siendo impresa por 1ra vez
     */
    public void actualizarEtiquetas(ArrayList oidsEtiquetas, boolean reimpresas) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasManual.actualizarEtiquetas"
                           + "(ArrayList oidsEtiquetas, boolean reimpresas): Entrada");
                           
        if (oidsEtiquetas != null && oidsEtiquetas.size() > 0) {
            StringBuffer update = new StringBuffer();
            update.append("UPDATE APE_ETIQU SET IND_ESTA = '");
            update.append(reimpresas? ConstantesAPE.ESTADO_REIMPRESA : ConstantesAPE.ESTADO_IMPRESA);
            update.append("', IND_IMPR = '").append(ConstantesAPE.IMPRESION_SI).append('\'');
            if (!reimpresas) {
                update.append(", ESTP_OID_ESTA_PEDI = ").append(ConstantesAPE.OID_ESTADO_PEDIDO_INDUCIDO);
            }
            update.append(" WHERE OID_ETIQ IN (");
            for (int i = 0; i < oidsEtiquetas.size(); ) {
                update.append(oidsEtiquetas.get(i));
                update.append((++i < oidsEtiquetas.size())? ',' : ')');
            }
            
            try {
                UtilidadesEJB.getBelcorpService().dbService.executeUpdate(update.toString());
            } catch (Exception e) {
                String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        }
        UtilidadesLog.info("DAOImpresionEtiquetasManual.actualizarEtiquetas"
                           + "(ArrayList oidsEtiquetas, boolean reimpresas): Salida");
    }
    
    /**
     * CAMBIO APE-09
     * Busca en APE_ETIQU las etiquetas pertenecientes al consolidado/caja
     * recibidos por parámetro.
     * Devuelve un RecordSet con: OID consolidado, código lista picado,
     * OID de etiqueta
     * @author dmorello
     * @since 05-jun-2008
     */
    public RecordSet obtenerInfoEtiquetas(DTOImpresionEtiquetasManual dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionEtiquetasManualobtenerInfoEtiquetas(DTOImpresionEtiquetasManual dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("   SELECT cons.oid_soli_cabe, lista.oid_list_pica_cabe, lista.cod_list_pica, etiqueta.oid_etiq ");
        query.append("     FROM ape_etiqu etiqueta ");
        query.append("        , ped_solic_cabec cons ");
        query.append("        , ape_lista_picad_cabec lista ");
        query.append("    WHERE (etiqueta.ind_esta != '");
        query.append(ConstantesAPE.ESTADO_ANULADA).append("' OR etiqueta.ind_esta IS NULL) ");
        query.append("      AND etiqueta.ind_impr = '").append(ConstantesAPE.IMPRESION_NO).append('\'');
        query.append("      AND etiqueta.soca_oid_soli_cabe = cons.oid_soli_cabe ");
        query.append("      AND cons.val_nume_soli = ").append(dtoe.getNumConsolidado());
        if (dtoe.getNumCaja() != null) {
            query.append("  AND etiqueta.num_caja = ").append(dtoe.getNumCaja());
        }
        query.append("      AND etiqueta.lpca_oid_list_pica_cabe = lista.oid_list_pica_cabe ");
        query.append("ORDER BY etiqueta.num_caja");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionEtiquetasManualobtenerInfoEtiquetas(DTOImpresionEtiquetasManual dtoe): Salida");
        return rs;
    }
}