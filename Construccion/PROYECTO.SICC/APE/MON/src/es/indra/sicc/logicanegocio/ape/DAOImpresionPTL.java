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
import es.indra.sicc.dtos.ape.DTOEtiqueta;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class DAOImpresionPTL {

    /**
     * CHANGELOG
     * ---------
     * 03/09/2009 - dmorello, Cambio 20090839 - Recupero flag imprimir datos basicos cliente (del centro dist).
     * 19/10/2009 - dmorello, Cambio 20090839 - Recupero fecha de facturacion y descripcion linea armado
     */
    public RecordSet recuperarInformacionEtiquetasPTL(DTOBusquedaEtiqueta dtoe) throws MareException {
        UtilidadesLog.info("DAOImpresionPTL.recuperarInformacionEtiquetasPTL(DTOBusquedaEtiqueta dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT DISTINCT solicitud.val_nume_soli, ");
        query.append(" 	   solicitud.oid_soli_cabe, ");
        query.append(" 	   solicitud.sbac_oid_sbac,  ");
        query.append("     centro.oid_conf_cent_dist,  ");
        query.append("     centro.ind_impr_dato_basi_clie, ");
        query.append("     listacab.oid_list_pica_cabe,  ");
        query.append("     NVL(solicitud.clie_oid_clie_dest, solicitud.clie_oid_clie) AS oid_clie,  ");
        query.append("     pc.cod_peri, region.cod_regi,  ");
        query.append("     zona.oid_zona, ");
        query.append(" 	   zona.cod_zona, ");
        query.append(" 	   seccion.oid_secc, ");
        query.append(" 	   seccion.cod_secc, ");
        query.append("     listacab.num_tota_caja,  ");
        query.append("     listadet.tcem_oid_tipo_caja_emba, ");
        query.append("     listadet.num_caja, ");
        query.append(" 	   listacab.val_text_cheq,  ");
        query.append("     listacab.val_text_prim_pedi, listacab.inre_oid_indi_revi,  ");
        query.append("     tipocaja.num_etiq, tipocaja.val_tipo_caja,  ");
        query.append("     linea.num_long_nume_etiq, ");
        query.append("     subl_y_prog.oid_subl_arma, ");
        query.append("     subl_y_prog.val_nomb_prog AS nombr_progr, ");
        query.append("     sociedad.val_deno,  ");
        query.append("     subtipo.cod_subt_clie, ");
        query.append(" 	   (select etiqueta.oid_etiq ");
        query.append(" 	      from ape_etiqu etiqueta ");
        query.append(" 		   where etiqueta.LPCA_OID_LIST_PICA_CABE = listacab.oid_list_pica_cabe ");
        query.append(" 		     and etiqueta.num_caja = listadet.num_caja) AS oid_etiq ");
        query.append("   , listacab.fec_factu ");
        query.append("   , pq_apl_aux.valor_gen_i18n_sicc(1, linea.oid_line_arma, 'APE_LINEA_ARMAD') AS desc_linea ");
        query.append("   FROM ape_lista_picad_cabec listacab,  ");
        query.append("        ape_lista_picad_detal listadet,  ");
        query.append("        ape_tipo_caja_embal tipocaja,  ");
        query.append("        ped_solic_cabec solicitud,  ");
	query.append("        ape_linea_armad linea,  ");
        query.append("        (SELECT * FROM (");
        query.append("             SELECT datos.oid_subl_arma, programa.val_nomb_prog");
        query.append("        	     FROM (SELECT DISTINCT sublinea.oid_subl_arma, formato.pret_oid_prog_etiq");
        query.append("                                FROM ped_solic_cabec consolidado,");
        query.append("        	                           ape_lista_picad_cabec listacab,");
        query.append("        	                           ape_lista_picad_detal listadet,");
        query.append("        	                           ape_mapa_centr_distr_detal mcdd,");
        query.append("        	                           ape_subli_armad sublinea,");
        query.append("        	                           ape_forma_etiqu formato");
        query.append("        	                     WHERE consolidado.val_nume_soli = ").append(dtoe.getNroSolicCabec());
        query.append("                                 AND consolidado.pais_oid_pais = ").append(dtoe.getOidPais());
        query.append("                                 AND consolidado.oid_soli_cabe = listacab.soca_oid_soli_cabe");
        query.append("                                 AND listacab.oid_list_pica_cabe = listadet.lpca_oid_list_pica_cabe");
        query.append("                                 AND listadet.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta");
        query.append("                                 AND mcdd.sbar_oid_subl_arma = sublinea.oid_subl_arma");
        query.append("                                 AND sublinea.oid_subl_arma = formato.sbar_oid_subl_arma(+)) datos,");
        query.append("                    ape_progr_etiqu programa");
        query.append("              WHERE datos.pret_oid_prog_etiq = programa.oid_prog_etiq(+)");
        query.append("              ORDER BY programa.num_prio DESC NULLS LAST, oid_subl_arma)");
        query.append("          WHERE ROWNUM = 1) subl_y_prog,");
        query.append("        app_confi_centr_distr centro,  ");
        query.append("        cra_perio periodo,  ");
        query.append("        seg_perio_corpo pc,  ");
        query.append("        seg_socie sociedad,  ");
        query.append("        zon_regio region,  ");
        query.append("        zon_zona zona,  ");
        query.append("        zon_secci seccion,  ");
        query.append("        zon_terri_admin tad,  ");
        query.append("        zon_terri terr,  ");
        query.append("        mae_clien_tipo_subti cts,  ");
        query.append("        mae_subti_clien subtipo ");
        query.append("  WHERE solicitud.val_nume_soli = ").append(dtoe.getNroSolicCabec());
        query.append("    AND solicitud.pais_oid_pais = ").append(dtoe.getOidPais());
        query.append("    AND listacab.soca_oid_soli_cabe = solicitud.oid_soli_cabe  ");
        query.append("    AND listacab.oid_list_pica_cabe = listadet.lpca_oid_list_pica_cabe ");
        query.append("    AND listadet.num_caja = ").append(dtoe.getNroCaja());
        query.append("    AND listacab.clie_oid_clie IS NOT NULL  ");
        query.append("    AND tipocaja.oid_tipo_caja_emba (+) = listadet.tcem_oid_tipo_caja_emba  ");
        query.append("    AND listacab.perd_oid_peri = periodo.oid_peri  ");
        query.append("    AND periodo.peri_oid_peri = pc.oid_peri  ");
        query.append("    AND solicitud.zzon_oid_zona = zona.oid_zona  ");
        query.append("    AND zona.zorg_oid_regi = region.oid_regi  ");
        query.append("    AND solicitud.ztad_oid_terr_admi = tad.oid_terr_admi  ");
        query.append("    AND tad.zscc_oid_secc = seccion.oid_secc  ");
        query.append("    AND solicitud.terr_oid_terr = terr.oid_terr  ");
        query.append("    AND linea.ccdi_oid_conf_cent_dist = centro.oid_conf_cent_dist  ");
        query.append("    AND linea.oid_line_arma = listacab.liar_oid_line_arma ");
        query.append("    AND centro.oid_conf_cent_dist = listacab.ccdi_oid_conf_cent_dist  ");
        query.append("    AND solicitud.soci_oid_soci = sociedad.oid_soci  ");
        query.append("    AND NVL(solicitud.clie_oid_clie_dest,solicitud.clie_oid_clie) = cts.clie_oid_clie  ");
        query.append("    AND cts.ind_ppal = ").append(ConstantesAPE.TRUE);
        query.append("    AND cts.sbti_oid_subt_clie = subtipo.oid_subt_clie ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        return rs;
    }
    
    
    /**
     * Inserta una etiqueta con la informacion del RecordSet recibido y devuelve su OID.
     * Este RecordSet debe tener necesariamente un registro. No puede estar vacio.
     * Nota: este metodo fue introducido por Construcción. No figura en el DMCO.
     * @throws es.indra.mare.common.exception.MareException
     * @param etiqueta
     * @return OID de la etiqueta insertada
     * @author dmorello
     * @since 05-03-2007
     */
    public Long insertarEtiqueta(RecordSet etiqueta, String textoVariable, Long oidPais, Long numCaja, Long numTotalCajas) throws MareException {
        UtilidadesLog.info("DAOImpresionPTL.insertarEtiqueta(RecordSet etiqueta): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer insert = new StringBuffer();
        Vector parametros = new Vector();

        // Obtengo el OID para la etiqueta
        Long oidEtiqueta = SecuenciadorOID.obtenerSiguienteValor("APE_ETIQ_SEQ");
        
        // Armo el numero de secuencia
        BigDecimal longitud = (BigDecimal)etiqueta.getValueAt(0, "NUM_LONG_NUME_ETIQ");
        String solicitud = etiqueta.getValueAt(0, "VAL_NUME_SOLI").toString();
        Long secuencial = new Long(solicitud.substring(solicitud.length() - longitud.intValue()));
        
        // Obtengo el resto de los datos
        // dmorello, 05/03/2007: el número de etiqueta se genera mediante trigger
        Object textoChequeo = etiqueta.getValueAt(0, "VAL_TEXT_CHEQ");
        Object textoPrimerPedido = etiqueta.getValueAt(0, "VAL_TEXT_PRIM_PEDI");
        Object oidSeccion = etiqueta.getValueAt(0, "OID_SECC");
        Object oidSolicitud = new Long(((BigDecimal)etiqueta.getValueAt(0, "OID_SOLI_CABE")).longValue());
        Object oidListaCab = etiqueta.getValueAt(0, "OID_LIST_PICA_CABE");
        Object oidTipoCaja = etiqueta.getValueAt(0, "TCEM_OID_TIPO_CAJA_EMBA");
        Object oidCentro = etiqueta.getValueAt(0, "OID_CONF_CENT_DIST");
        Object oidZona = etiqueta.getValueAt(0, "OID_ZONA");
        
        // Genero el codigo SQL
        insert.append("INSERT INTO APE_ETIQU ( ");
        insert.append("   OID_ETIQ, NUM_CAJA, NUM_TOTA_CAJA, NUM_SECU, ");
        //insert.append("   IND_IMPR, IND_ESTA, ");
        insert.append("   IND_IMPR, ");
        insert.append("   PAIS_OID_PAIS, ZSCC_OID_SECC, SOCA_OID_SOLI_CABE, ");
        insert.append("   LPCA_OID_LIST_PICA_CABE, TCEM_OID_TIPO_CAJA_EMBA, ");
        insert.append("   CCDI_OID_CONF_CENT_DIST, ZZON_OID_ZONA, ");
        // vbongiov -- 28/05/2007 -- Inc BELC400000443
        insert.append("   ESTP_OID_ESTA_PEDI ");        
        
        if (textoChequeo != null) {
            insert.append(" , VAL_TEXT_CHEQ ");
        }
        if (textoPrimerPedido != null) {
            insert.append(" , VAL_TEXT_PRIM_PEDI ");
        }
        if (textoVariable != null) {
            insert.append(" , VAL_TEXT_VARI ");
        }
        /* dmorello, 21/08/2007:
         * Se agrega temporalmente el seteo de este campo, a la espera de una
         * indicacion de DT al respecto. */
        insert.append(" , NUM_ETIQ ");
        
        insert.append(") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
        parametros.add(oidEtiqueta);
        parametros.add(numCaja);
        parametros.add(numTotalCajas);
        parametros.add(secuencial);
        parametros.add(ConstantesAPE.IMPRESION_NO.toString());
        parametros.add(oidPais);
        parametros.add(oidSeccion);
        parametros.add(oidSolicitud);
        parametros.add(oidListaCab);
        parametros.add(oidTipoCaja);
        parametros.add(oidCentro);
        parametros.add(oidZona);
        // vbongiov -- 28/05/2007 -- Inc BELC400000443
        parametros.add(ConstantesAPE.OID_ESTADO_PEDIDO_INDUCIDO.toString());
        
        if (textoChequeo != null) {
            insert.append(", ?");
            parametros.add(textoChequeo);
        }
        if (textoPrimerPedido != null) {
            insert.append(", ?");
            parametros.add(textoPrimerPedido);
        }
        if (textoVariable != null) {
            insert.append(", ?");
            parametros.add(textoVariable);
        }
        

        /* dmorello, 21/08/2007:
         * Se agrega temporalmente el seteo de este campo, a la espera de una
         * indicacion de DT al respecto. */
        insert.append(", (SELECT NVL(MAX(NUM_ETIQ), 0) + 1 FROM APE_ETIQU WHERE PAIS_OID_PAIS = ?) ");
        parametros.add(oidPais);
        
        insert.append(')');
        
        // Ejecuto la insercion
        try {
            bs.dbService.executePreparedUpdate(insert.toString(), parametros);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionPTL.insertarEtiqueta(RecordSet etiqueta): Salida");
        return oidEtiqueta;
    }
    
    
    /**
     * Marca como impresa la etiqueta cuyo OID se recibe por parametro
     * Este metodo fue creado por Construccion, no figura en DMCO.
     * 
     * dmorello 22/06/2007 Se modifica nombre y firma del metodo para actualizar
     * varias etiquetas de una sola vez. Incidencia BELC400000524
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param oidEtiqueta OID de la etiqueta a actualizar
     * @author dmorello
     * @since 22-06-2007
     */
    public void marcarEtiquetasComoImpresas(ArrayList oidsEtiquetas) throws MareException {
        UtilidadesLog.info("DAOImpresionPTL.marcarEtiquetaComoImpresa(Long oidEtiqueta): Entrada");
        
        if (oidsEtiquetas == null || oidsEtiquetas.size() == 0) {
            UtilidadesLog.debug(" --> No hay etiquetas para actualizar el campo IND_IMPR");
            return;
        }

        StringBuffer update = new StringBuffer();
        update.append("UPDATE APE_ETIQU SET IND_IMPR = '"+ConstantesAPE.IMPRESION_SI+"' ");
        update.append("WHERE OID_ETIQ IN " + this.armarListaSql("OID_ETIQ", oidsEtiquetas));
        
        try {
            UtilidadesEJB.getBelcorpService().dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionPTL.marcarEtiquetaComoImpresa(Long oidEtiqueta): Salida");
    }
    
    public RecordSet getCodFechaInicioEmbalajeLista(Long oidListaPicado) throws MareException {
        UtilidadesLog.info("DAOImpresionPTL.getCodFechaInicioEmbalajeLista(Long oidListaPicado): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT cod_list_pica, fec_hora_inic_emba ");
        query.append("  FROM ape_lista_picad_cabec ");
        query.append(" WHERE oid_list_pica_cabe = ").append(oidListaPicado);
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionPTL.getCodFechaInicioEmbalajeLista(Long oidListaPicado): Salida");
        return rs;
    }
    
    public void actualizarFechaInicioEmbalajeLista(Long oidListaPicado) throws MareException {

        UtilidadesLog.info("DAOImpresionPTL.actualizarFechaInicioEmbalajeLista(Long oidListaPicado): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        
        StringBuffer update = new StringBuffer();
        update.append("UPDATE ape_lista_picad_cabec ");
        update.append("SET fec_hora_inic_emba = ");
        update.append("TO_DATE('").append(sdf.format(date)).append("','DD/MM/YYYY HH24:MI:SS') ");
        update.append("WHERE oid_list_pica_cabe = ").append(oidListaPicado);
        
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionPTL.actualizarFechaInicioEmbalajeLista(Long oidListaPicado): Salida");
    }
    
    /**
     * Crea una lista SQL fragmentada cada 1000 elementos por restriccion del
     * operador IN.
     * Ej.: (1723, 1728,..... 1999) OR cac.clie_oid_clie IN (322, 4545,.....)
     * @author eiraola
     * @date 03/Sep/2007
     */
    private StringBuffer armarListaSql(String nombreCampo, ArrayList valoresLista) throws MareException {
        StringBuffer fragmentoQuery = new StringBuffer();
        int cantValores = valoresLista.size();
        
        fragmentoQuery.append("(");
                
        for (int i = 0; i < cantValores; i++) {
            if ( (i+1) < cantValores ) {
                if ((i+1)%1000 == 0) {
                    fragmentoQuery.append(valoresLista.get(i) + ") OR "+ nombreCampo +" IN (");
                } else {
                    fragmentoQuery.append(valoresLista.get(i) + ",");
                }
            } else {
                fragmentoQuery.append(valoresLista.get(i));
            }
        }
        fragmentoQuery.append(")");
        
        return fragmentoQuery;
    }
    
    
    public void insertarEtiquetas(ArrayList arrayDTOEtiquetas) throws MareException {
        UtilidadesLog.info("DAOImpresionPTL.insertarEtiqueta(DTOEtiqueta dto): Entrada");
        
        if (arrayDTOEtiquetas == null || arrayDTOEtiquetas.size() == 0) {
            UtilidadesLog.debug("No hay etiquetas para insertar");
            UtilidadesLog.info("DAOImpresionPTL.insertarEtiqueta(DTOEtiqueta dto): Salida");
            return;
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer inserts = new StringBuffer();
        Long oidPais = null;
        int size = arrayDTOEtiquetas.size();
        for (int i = 0; i < size; i++) {
            DTOEtiqueta dto = (DTOEtiqueta)arrayDTOEtiquetas.get(i);
            Long oidEtiqueta = SecuenciadorOID.obtenerSiguienteValor("APE_ETIQ_SEQ");
            dto.setOidEtiqueta(oidEtiqueta);
            
            if (oidPais == null) {
                oidPais = dto.getOidPais();
            }
            
            inserts.append("INSERT INTO APE_ETIQU ( ");
            inserts.append("   OID_ETIQ, NUM_CAJA, NUM_TOTA_CAJA, NUM_SECU, ");
            //inserts.append("   IND_IMPR, IND_ESTA, ");
            inserts.append("   IND_IMPR, ");
            inserts.append("   PAIS_OID_PAIS, ZSCC_OID_SECC, SOCA_OID_SOLI_CABE, ");
            inserts.append("   LPCA_OID_LIST_PICA_CABE, TCEM_OID_TIPO_CAJA_EMBA, ");
            inserts.append("   CCDI_OID_CONF_CENT_DIST, ZZON_OID_ZONA, ");
            // vbongiov -- 28/05/2007 -- Inc BELC400000443
            inserts.append("   ESTP_OID_ESTA_PEDI ");        
            
            if (dto.getTextoChequeo() != null) {
                inserts.append(" , VAL_TEXT_CHEQ ");
            }
            if (dto.getTextoPrimerPedido() != null) {
                inserts.append(" , VAL_TEXT_PRIM_PEDI ");
            }
            if (dto.getTextoVariable() != null) {
                inserts.append(" , VAL_TEXT_VARI ");
            }
            
            inserts.append(") VALUES (");
            inserts.append(oidEtiqueta);
            inserts.append(',').append(dto.getNumeroCaja());
            inserts.append(',').append(dto.getNumeroTotalCajas());
            inserts.append(',').append(dto.getSecuencial());
            inserts.append(",'").append(ConstantesAPE.IMPRESION_NO).append('\'');
            inserts.append(',').append(dto.getOidPais());
            inserts.append(',').append(dto.getSeccion());
            inserts.append(',').append(dto.getSolicitudCabecera());
            inserts.append(',').append(dto.getListaPicado());
            inserts.append(',').append(dto.getTipoCajaEmbalaje());
            inserts.append(',').append(dto.getCentroDistribucion());
            inserts.append(',').append(dto.getZona());
            // vbongiov -- 28/05/2007 -- Inc BELC400000443
            inserts.append(',').append(dto.getEstadoPedido());
            
            if (dto.getTextoChequeo() != null) {
                inserts.append(", '").append(dto.getTextoChequeo()).append('\'');
            }
            if (dto.getTextoPrimerPedido() != null) {
                inserts.append(", '").append(dto.getTextoPrimerPedido()).append('\'');
            }
            if (dto.getTextoVariable() != null) {
                inserts.append(", '").append(dto.getTextoVariable()).append('\'');
            }
            
            inserts.append(");");
        }

        // Inserto las etiquetas
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", inserts.toString());
            bs.dbService.executeUpdate("BEGIN  APE_GENE_NUME_ETIQ(" + oidPais + "); END;");
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("DAOImpresionPTL.insertarEtiqueta(DTOEtiqueta dto): Salida");
    }
    
    
    /**
     * Creado por cambio APE-04
     * Actualiza registros en APE_ETIQU con los datos de cada DTO de la
     * lista recibida: secuencial, nº caja, nº total cajas, tipo caja.
     * @param arrayEtiquetas ArrayList que contiene objetos DTOEtiqueta
     * @author dmorello
     * @since 10-01-2008
     */
    public void actualizarEtiquetas(ArrayList arrayEtiquetas) throws MareException {
        UtilidadesLog.info("DAOImpresionPTL.actualizarEtiquetas(ArrayList arrayEtiquetas): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer updates = new StringBuffer();
        
        int size = arrayEtiquetas.size();
        for (int i = 0; i < size; i++) {
            DTOEtiqueta dto = (DTOEtiqueta)arrayEtiquetas.get(i);
            
            updates.append("UPDATE ape_etiqu SET ");
            updates.append("  num_secu = ").append(dto.getSecuencial());
            updates.append(", num_caja = ").append(dto.getNumeroCaja());
            updates.append(", num_tota_caja = ").append(dto.getNumeroTotalCajas());
            updates.append(" WHERE oid_etiq = ").append(dto.getOidEtiqueta());
            
            //if (i < size - 1) updates.append(';');
            updates.append(';');
        }
        
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", updates.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOImpresionPTL.actualizarEtiquetas(ArrayList arrayEtiquetas): Salida");
    }
}