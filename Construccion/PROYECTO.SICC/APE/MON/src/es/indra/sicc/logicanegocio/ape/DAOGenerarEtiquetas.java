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
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

public class DAOGenerarEtiquetas {

    /**
     * Recupera de BD la información para generar las etiquetas
     * correspondientes a la lista de picado recibida por parámetro.
     * @author dmorello
     * @since 05-02-2007
     * @deprecated Se usa el metodo obtenerDatosListaPicado de este mismo DAO
     */
    public RecordSet obtenerFormatoEtiquetas(DTOListaPicado dtoe) throws MareException {
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerFormatoEtiquetas(DTOListaPicado dtoe): Entrada");
  
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
  
				query.append(" SELECT solicitud.val_nume_soli, solicitud.oid_soli_cabe, solicitud.sbac_oid_sbac, ");
				query.append("        centro.oid_conf_cent_dist, ");
				query.append("        listacab.oid_list_pica_cabe, ");
        query.append("        NVL(solicitud.clie_oid_clie_dest, solicitud.clie_oid_clie) AS oid_clie, ");
				query.append("        pc.cod_peri, region.cod_regi, ");
				query.append("        zona.oid_zona, zona.cod_zona, seccion.oid_secc, seccion.cod_secc,");
        query.append("        terr.cod_terr, ");
				query.append("        listacab.num_tota_caja, ");
				query.append("        listadet.tcem_oid_tipo_caja_emba, listacab.val_text_cheq, ");
        
				//SCS, por inc.: BELC400000473 query.append("        listacab.val_text_prim_pedi, listacab.ind_cheq, ");
        query.append("        listacab.val_text_prim_pedi, listacab.inre_oid_indi_revi, ");
        
        query.append("        tipocaja.num_etiq, tipocaja.val_tipo_caja, ");
				/* dmorello, 20/04/2007: Se eliminó el campo SIET_OID_SIST_ETIQ */
        //query.append("        linea.num_long_nume_etiq, sublinea.siet_oid_sist_etiq, ");
        query.append("        linea.num_long_nume_etiq, ");
        query.append("        (SELECT programa.val_nomb_prog ");
        query.append("           FROM ape_progr_etiqu programa, ape_forma_etiqu formato ");
        query.append("          WHERE formato.pret_oid_progr_etiqu = programa.oid_progr_etiqu ");
        query.append("            AND sublinea.oid_subl_arma = formato.sbar_oid_subl_arma ");
        query.append("         ) AS nombr_progr, ");
        query.append("        sociedad.val_deno, ");
        query.append("        subtipo.cod_subt_clie, ");
        query.append("        sublinea.oid_subl_arma, ");
				query.append("        COUNT (*) OVER () AS numerocajas ");
				query.append("   FROM ape_lista_picad_cabec listacab, ");
				query.append("        ape_lista_picad_detal listadet, ");
        query.append("        ape_tipo_caja_embal tipocaja, ");
				query.append("        ped_solic_cabec solicitud, ");
				query.append("        ape_linea_armad linea, ");
				query.append("        ape_subli_armad sublinea, ");
				query.append("        app_confi_centr_distr centro, ");
        query.append("        ape_mapa_centr_distr_detal mcdd, ");
				query.append("        cra_perio periodo, ");
        query.append("        seg_perio_corpo pc, ");
				query.append("        seg_socie sociedad, ");
				query.append("        zon_regio region, ");
				query.append("        zon_zona zona, ");
				query.append("        zon_secci seccion, ");
				query.append("        zon_terri_admin tad, ");
        query.append("        zon_terri terr, ");
        query.append("        mae_clien_tipo_subti cts, ");
        query.append("        mae_subti_clien subtipo ");
				query.append("  WHERE listacab.oid_list_pica_cabe = ").append(dtoe.getOidListaPicado());
				query.append("    AND listacab.soca_oid_soli_cabe = solicitud.oid_soli_cabe ");
				query.append("    AND listacab.oid_list_pica_cabe = listadet.lpca_oid_list_pica_cabe ");
				query.append("    AND listacab.clie_oid_clie IS NOT NULL ");
        query.append("    AND tipocaja.oid_tipo_caja_emba = listadet.tcem_oid_tipo_caja_emba ");
        query.append("    AND listadet.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        query.append("    AND mcdd.sbar_oid_subl_arma = sublinea.oid_subl_arma ");
				query.append("    AND listacab.perd_oid_peri = periodo.oid_peri ");
        query.append("    AND periodo.peri_oid_peri = pc.oid_peri ");
				query.append("    AND solicitud.zzon_oid_zona = zona.oid_zona ");
				query.append("    AND zona.zorg_oid_regi = region.oid_regi ");
				query.append("    AND solicitud.ztad_oid_terr_admi = tad.oid_terr_admi ");
				query.append("    AND tad.zscc_oid_secc = seccion.oid_secc ");
        query.append("    AND solicitud.terr_oid_terr = terr.oid_terr ");
				query.append("    AND linea.oid_line_arma = sublinea.liar_oid_line_arma ");
				query.append("    AND linea.ccdi_oid_conf_cent_dist = centro.oid_conf_cent_dist ");
				query.append("    AND centro.oid_conf_cent_dist = listacab.ccdi_oid_conf_cent_dist ");
				query.append("    AND solicitud.soci_oid_soci = sociedad.oid_soci ");
        query.append("    AND NVL(solicitud.clie_oid_clie_dest,solicitud.clie_oid_clie) = cts.clie_oid_clie ");
        query.append("    AND cts.ind_ppal = ").append(ConstantesAPE.TRUE);
        query.append("    AND cts.sbti_oid_subt_clie = subtipo.oid_subt_clie ");

        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerFormatoEtiquetas(DTOListaPicado dtoe): Salida");
        return rs;
    }
    
    
    /**
     * Obtiene el máximo número de etiqueta de la entidad APE_ETIQU
     * @deprecated Reemplazado por el uso de un trigger
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param pais
     */
    public Long obtenerUltimoNumeroEtiqueta(Long pais) throws MareException {
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerUltimoNumeroEtiqueta(): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append(" SELECT NVL(MAX(etiqueta.num_etiq),0)  ");
        query.append(" FROM APE_ETIQU etiqueta ");
        query.append(" WHERE etiqueta.pais_oid_pais = ").append(pais);
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long ultimo = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerUltimoNumeroEtiqueta(): Entrada");
        return ultimo;
    }
    
    
    /**
     * Devuelve el numero de la etiqueta cuyo OID recibe por parametro.
     * Si no existe tal etiqueta devuelve null.
     * @author dmorello
     * @since 21/03/2007
     */
    public Long obtenerNumeroEtiqueta(Long oidEtiqueta) throws MareException {
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerNumeroEtiqueta(Long oidEtiqueta): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT num_etiq FROM ape_etiqu WHERE oid_etiq = ");
        query.append(oidEtiqueta);
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
       
        Long numEtiqueta = null;
        if (! rs.esVacio()) {
            numEtiqueta = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
        }
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerNumeroEtiqueta(Long oidEtiqueta): Salida");
        return numEtiqueta;
    }
    
    
    /**
     * Creado por incidencia BELC400000379.
     * Sustituye en su uso al metodo obtenerFormatoEtiquetas.
     * @author dmorello
     * @since 20-04-2007
     */
    public RecordSet obtenerDatosListaPicado(DTOListaPicado dtoe) throws MareException {
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerDatosListaPicado(DTOListaPicado dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        /* dmorello, 07/06/2007: Se modifica para que recupere un solo registro
         * para todos los detalles que tengan igual numero de caja */
        //query.append(" SELECT solicitud.oid_soli_cabe, centro.oid_conf_cent_dist, ");
        query.append(" SELECT DISTINCT solicitud.oid_soli_cabe, centro.oid_conf_cent_dist, ");
        query.append("        listacab.oid_list_pica_cabe, solicitud.val_nume_soli, ");
        query.append("        NVL (solicitud.clie_oid_clie_dest, solicitud.clie_oid_clie) AS oid_clie, ");
        query.append("        zona.oid_zona, seccion.oid_secc, listacab.num_tota_caja, ");
        query.append("        listadet.tcem_oid_tipo_caja_emba, listacab.val_text_cheq, ");
        
        //SCS, por inc.: BELC400000473 query.append("        listacab.val_text_prim_pedi, listacab.ind_cheq, tipocaja.num_etiq, ");
        query.append("        listacab.val_text_prim_pedi, listacab.inre_oid_indi_revi, tipocaja.num_etiq, ");
        
        /* dmorello, 07/06/2007 */
        //query.append("        tipocaja.val_tipo_caja, linea.num_long_nume_etiq, sublinea.oid_subl_arma, ");
        query.append("        tipocaja.val_tipo_caja, linea.num_long_nume_etiq, listadet.num_caja ");
        /* BELC400000575 - dmorello, 16/07/2007 */
        //query.append("        COUNT(*) OVER () AS numerocajas ");
        /* Fin BELC400000575 dmorello 16/07/2007 */
        /* Fin dmorello 07/06/2007 */
        query.append("   FROM ape_lista_picad_cabec listacab, ");
        query.append("        ape_lista_picad_detal listadet, ");
        query.append("        ape_tipo_caja_embal tipocaja, ");
        query.append("        ped_solic_cabec solicitud, ");
        query.append("        ape_linea_armad linea, ");
        query.append("        ape_subli_armad sublinea, ");
        query.append("        app_confi_centr_distr centro, ");
        query.append("        ape_mapa_centr_distr_detal mcdd, ");
        query.append("        zon_zona zona, ");
        query.append("        zon_secci seccion, ");
        query.append("        zon_terri_admin tad ");
                
        query.append("  WHERE listacab.oid_list_pica_cabe = ").append(dtoe.getOidListaPicado());
        query.append("    AND listacab.soca_oid_soli_cabe = solicitud.oid_soli_cabe ");
        query.append("    AND listacab.oid_list_pica_cabe = listadet.lpca_oid_list_pica_cabe ");
        query.append("    AND listacab.clie_oid_clie IS NOT NULL ");
        /* BELC400000391 - dmorello, 23/04/2007: Se agrega el siguiente outer join */
        query.append("    AND tipocaja.oid_tipo_caja_emba (+) = listadet.tcem_oid_tipo_caja_emba ");
        query.append("    AND listadet.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        query.append("    AND mcdd.sbar_oid_subl_arma = sublinea.oid_subl_arma ");
        query.append("    AND solicitud.zzon_oid_zona = zona.oid_zona ");
        query.append("    AND solicitud.ztad_oid_terr_admi = tad.oid_terr_admi ");
        query.append("    AND tad.zscc_oid_secc = seccion.oid_secc ");
        query.append("    AND linea.oid_line_arma = sublinea.liar_oid_line_arma ");
        query.append("    AND linea.ccdi_oid_conf_cent_dist = centro.oid_conf_cent_dist ");
        query.append("    AND centro.oid_conf_cent_dist = listacab.ccdi_oid_conf_cent_dist ");
        
        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        query.append("  ORDER BY listadet.num_caja ");
       
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.info("DAOGenerarEtiquetas.obtenerDatosListaPicado(DTOListaPicado dtoe): Salida");
        return rs;
    }

    /**
     * dmorello, 19/07/2007
	 * Sustituye al método insertarEtiqueta, realizando la inserción de todas las etiquetas
     * de la lista de picado en un solo acceso a BD.
     * CHANGELOG
     * ---------
     * dmorello, 05/03/2007: El número de etiqueta se genera mediante trigger
     * vbongiov, 28/05/2007: Se setea estatus pedido = inducido para las etiquetas
     * dmorello, 05/06/2008: Cambio APE-09 - Se deja en blanco estatus pedido
     *                       deshaciendo el cambio anterior del 28/05/2007
     * dmorello, 15/10/2009: Cambio 20090839 - Se elimina insercion de valor
     *                       en el campo NUM_SECU de la etiqueta
     */
    public void insertarEtiquetas(RecordSet rs, String textoVariable, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOGenerarEtiquetas.insertarEtiquetas(RecordSet rs, String textoVariable, Long oidPais): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer inserts = new StringBuffer();
        
        for (int i = 0; i < rs.getRowCount(); i++) {
        
            Integer numCaja = new Integer(i + 1);
    
            // Obtengo el resto de los datos
            Object numeroTotalCajas = new Long(((BigDecimal)rs.getValueAt(i, "NUM_TOTA_CAJA")).longValue());
            Object textoChequeo = rs.getValueAt(i, "VAL_TEXT_CHEQ");
            Object textoPrimerPedido = rs.getValueAt(i, "VAL_TEXT_PRIM_PEDI");
            Object oidSeccion = rs.getValueAt(i, "OID_SECC");
            Object oidSolicitud = new Long(((BigDecimal)rs.getValueAt(i, "OID_SOLI_CABE")).longValue());
            Object oidListaCab = rs.getValueAt(i, "OID_LIST_PICA_CABE");
            Object oidTipoCaja = rs.getValueAt(i, "TCEM_OID_TIPO_CAJA_EMBA");
            Object oidCentro = rs.getValueAt(i, "OID_CONF_CENT_DIST");
            Object oidZona = rs.getValueAt(i, "OID_ZONA");
            
            // Genero el codigo SQL
            inserts.append("INSERT INTO APE_ETIQU ( ");
            inserts.append("   OID_ETIQ, NUM_CAJA, NUM_TOTA_CAJA, IND_IMPR, ");
            inserts.append("   PAIS_OID_PAIS, ZSCC_OID_SECC, SOCA_OID_SOLI_CABE, ");
            inserts.append("   LPCA_OID_LIST_PICA_CABE, TCEM_OID_TIPO_CAJA_EMBA, ");
            inserts.append("   CCDI_OID_CONF_CENT_DIST, ZZON_OID_ZONA ");
            
            if (textoChequeo != null) {
                inserts.append(" , VAL_TEXT_CHEQ ");
            }
            if (textoPrimerPedido != null) {
                inserts.append(" , VAL_TEXT_PRIM_PEDI ");
            }
            if (textoVariable != null) {
                inserts.append(" , VAL_TEXT_VARI ");
            }
            inserts.append(") VALUES (APE_ETIQ_SEQ.nextval, "); //?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            inserts.append(numCaja).append(',');
            inserts.append(numeroTotalCajas).append(',');
            inserts.append('\'').append(ConstantesAPE.IMPRESION_NO).append("',");
            inserts.append(oidPais).append(',');
            inserts.append(oidSeccion).append(',');
            inserts.append(oidSolicitud).append(',');
            inserts.append(oidListaCab).append(',');
            inserts.append(oidTipoCaja).append(',');
            inserts.append(oidCentro).append(',');
            inserts.append(oidZona);
            
            if (textoChequeo != null) {
                inserts.append(",'").append(textoChequeo).append('\'');
            }
            if (textoPrimerPedido != null) {
                inserts.append(",'").append(textoPrimerPedido).append('\'');
            }
            if (textoVariable != null) {
                inserts.append(",'").append(textoVariable).append('\'');
            }
            inserts.append(");");
        }
        
        // Ejecuto la insercion
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", inserts.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOGenerarEtiquetas.insertarEtiquetas(RecordSet rs, String textoVariable, Long oidPais): Salida");
   }
}