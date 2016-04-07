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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.ArrayList;

import es.indra.sicc.dtos.ape.DTOBuscarCaja;
import es.indra.sicc.dtos.ape.DTODatosCajaCabecera;
import es.indra.sicc.dtos.ape.DTODatosCajaDetalle;
import es.indra.sicc.dtos.ape.DTOBuscarProducto;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;

public class DAOChequeoCajas {

 public DTODatosCajaCabecera obtenerCajaChequear(DTOBuscarCaja dtoe) throws MareException {
    UtilidadesLog.info("DAOChequeoCajas.obtenerCajaChequear(DTOBuscarCaja dtoe): Entrada");
    
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    BelcorpService bs;
    DTODatosCajaCabecera dtoDatosCajaCabecera = new DTODatosCajaCabecera();
    DTODatosCajaDetalle dtoDatosCajaDetalle = null;
    ArrayList detalles = new ArrayList();

    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    // vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
    RecordSet rs1 = new RecordSet();
    StringBuffer query1 = new StringBuffer();
    Long oidOrdenVisual = null;
    String ordenVisualChequeo = null;
    
    
    if(dtoe.getOidOrdenVisual() == null || dtoe.getOrdenVisualChequeo() == null){
    
        query1.append(" SELECT centro.OVCH_OID_ORDE_VISU_CHEQ, centro.VAL_ORDE_VISU_CHEQ ");
        query1.append(" FROM ape_etiqu etiq, ped_solic_cabec ped, app_confi_centr_distr centro ");
        query1.append(" WHERE etiq.num_caja = " + dtoe.getNumeroCaja());
        query1.append(" AND etiq.soca_oid_soli_cabe = ped.oid_soli_cabe ");
        query1.append(" AND ped.val_nume_soli = '" + dtoe.getNumeroConsolidado() + "' ");
        query1.append(" AND etiq.ccdi_oid_conf_cent_dist = centro.oid_conf_cent_dist ");
        
        try {
            rs1 = bs.dbService.executeStaticQuery(query1.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if(rs1.getRowCount()==0)  return dtoDatosCajaCabecera;
        
        if(dtoe.getOidOrdenVisual() == null){
            oidOrdenVisual = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "OVCH_OID_ORDE_VISU_CHEQ")).toString());
        } else {
            oidOrdenVisual = dtoe.getOidOrdenVisual();
        }
        
        if(dtoe.getOrdenVisualChequeo() == null){
            ordenVisualChequeo = (String) rs1.getValueAt(0, "VAL_ORDE_VISU_CHEQ");
        } else {
            ordenVisualChequeo = dtoe.getOrdenVisualChequeo();
        }
        
    } else {
        oidOrdenVisual = dtoe.getOidOrdenVisual();
        ordenVisualChequeo = dtoe.getOrdenVisualChequeo();
    }
    
    UtilidadesLog.debug("oidOrdenVisua: " + oidOrdenVisual);
    UtilidadesLog.error("ordenVisualChequeo: " + ordenVisualChequeo);
    

    query.append(" SELECT DISTINCT etiq.OID_ETIQ, cab.OID_LIST_PICA_CABE, ped.VAL_NUME_SOLI, ");
    query.append(" NVL((SELECT turno.NUM_TURN FROM APE_TURNO_CHEQU turno ");
    query.append(" WHERE SYSDATE BETWEEN turno.FEC_HORA_INIC_TURN AND turno.FEC_HORA_FINA_TURN), 1) TURNOCHEQUEO,  ");
    query.append(" ( SELECT DISTINCT estado.VAL_ESTA_CAJA ");
    query.append("   FROM APE_ETIQU etiq, PED_SOLIC_CABEC ped, APE_ESTAD_PEDID estado  ");
    query.append("   WHERE etiq.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
    query.append("   AND ped.VAL_NUME_SOLI = '" + dtoe.getNumeroConsolidado() + "' ");
    query.append("   AND etiq.ESTP_OID_ESTA_PEDI = estado.OID_ESTA_PEDI ");
    query.append("   AND estado.NUM_ORDE = (SELECT MIN(estado.NUM_ORDE) ");
    query.append("                        FROM APE_ETIQU etiq, PED_SOLIC_CABEC ped, APE_ESTAD_PEDID estado ");
    query.append("                        WHERE etiq.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
    query.append("                        AND ped.VAL_NUME_SOLI = '" + dtoe.getNumeroConsolidado() + "' ");
    query.append("                        AND etiq.ESTP_OID_ESTA_PEDI = estado.OID_ESTA_PEDI) ");
    query.append(" ) ESTADOPEDIDO,  ");
    query.append(" estadoCaj.VAL_ESTA_CAJA ESTADOCAJA, i18n.VAL_I18N TIPOCHEQUEO, ");
    query.append(" cab.IND_ORIG_CHEQ, etiq.NUM_CAJA, ");
    query.append(" etiq.NUM_TOTA_CAJA, det.TCEM_OID_TIPO_CAJA_EMBA, ");
    query.append(" (SELECT SUM(det.NUM_UNID_PROD) ");
    query.append("  FROM APE_ETIQU etiq, APE_LISTA_PICAD_CABEC cab, APE_LISTA_PICAD_DETAL det,PED_SOLIC_CABEC ped ");
    query.append("  WHERE etiq.NUM_CAJA = " + dtoe.getNumeroCaja());
    query.append("  AND etiq.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
    query.append("  AND ped.VAL_NUME_SOLI = '" + dtoe.getNumeroConsolidado() + "' ");
    query.append("  AND etiq.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append("  AND det.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append(" ) TOTALPRODUCTOS, ");
    query.append(" (SELECT SUM(det.NUM_UNID_PROD) ");
    query.append("  FROM APE_ETIQU etiq, APE_LISTA_PICAD_CABEC cab, APE_LISTA_PICAD_DETAL det,PED_SOLIC_CABEC ped ");
    query.append("  WHERE etiq.NUM_CAJA = " + dtoe.getNumeroCaja());
    query.append("  AND etiq.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
    query.append("  AND ped.VAL_NUME_SOLI = '" + dtoe.getNumeroConsolidado() + "' ");
    query.append("  AND etiq.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append("  AND det.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append("  AND etiq.NUM_CAJA = det.NUM_CAJA ");
    query.append(" ) UNIDADESCAJA, ");
    query.append(" (SELECT SUM(DECODE(det.SIPI_OID_SIST_PICA, 1, NVL(det.NUM_UNID_PICA,0) , NVL(det.NUM_UNID_PROD,0))) ");
    query.append("  FROM APE_ETIQU etiq, APE_LISTA_PICAD_CABEC cab, APE_LISTA_PICAD_DETAL det,PED_SOLIC_CABEC ped ");
    query.append("  WHERE etiq.NUM_CAJA = " + dtoe.getNumeroCaja());
    query.append("  AND etiq.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
    query.append("  AND ped.VAL_NUME_SOLI = '" + dtoe.getNumeroConsolidado() + "' ");
    query.append("  AND etiq.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append("  AND det.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append("  AND etiq.NUM_CAJA = det.NUM_CAJA ");    
    query.append(" ) UNIDADESPICADAS, ");
    query.append(" det.OID_LIST_PICA_DETA, det.NUM_CODI_POSI, ");
    // vbongiov -- Inc APE20080516 -- 25/06/2008
    query.append(" i18n2.VAL_I18N DES_CORT, ");
    query.append(" mcd.NUM_ANAQ, det.NUM_UNID_PROD CANTIDADREQUERIDA ");
    /* BELC400000722 - dmorello, 12/09/2007 */
    query.append(" , cab.PERD_OID_PERI ");
    /* Fin BELC400000722 - dmorello, 12/09/2007 */    
    
    // vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_VOLUMEN)){
    
        query.append(", ((CASE WHEN (prod.VAL_VOLU IS NULL OR prod.UNMD_OID_UNID_MEDI IS NULL)  ");
        query.append("    THEN  param.VAL_VOLU_POR_DEFE  ELSE  prod.VAL_VOLU END) * ");
        query.append("  (SELECT fac.NUM_FACT_CONV  ");
        query.append("   FROM MAE_UNIDA_MEDID uni, APE_FACTO_CONVE fac  ");
        query.append("   WHERE fac.UNMD_OID_UNID_MEDI_DEST = uni.OID_UNID_MEDI     ");
        query.append("   AND uni.PAIS_OID_PAIS =  " + dtoe.getOidPais());
        query.append("   AND uni.IND_UM_STND = 1  ");
        query.append("   AND fac.UNMD_OID_UNID_MEDI_ORIG = (SELECT CASE WHEN (prod1.VAL_VOLU IS NULL OR prod1.UNMD_OID_UNID_MEDI IS NULL)  ");
        query.append("                                      THEN param.UNMD_OID_UNID_MEDI ELSE prod1.UNMD_OID_UNID_MEDI END  UNMD_OID_UNID_MEDI  ");
        query.append("                                      FROM MAE_PRODU prod1,  SEG_PARAM_INTER_PAIS param1 ");
        query.append("                                      WHERE prod1.OID_PROD = prod.OID_PROD ");
        query.append("                                      AND param1.PAIS_OID_PAIS = " + dtoe.getOidPais() + " ))) VOL_ESTANDAR ");        
    }
      if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_CLAS_PROD)){
          query.append(" , neg.cod_nego ");
      }
    query.append(" FROM APE_ETIQU etiq, APE_LISTA_PICAD_CABEC cab, APE_LISTA_PICAD_DETAL det, ");
    query.append(" APE_MAPA_CENTR_DISTR_DETAL mcd, MAE_PRODU prod, ");
    query.append(" PED_SOLIC_CABEC ped, v_gen_i18n_sicc i18n, APE_ESTAD_PEDID estadoCaj ");
    query.append(" , v_gen_i18n_sicc i18n2, ");  // vbongiov -- Inc APE20080516 -- 25/06/2008
    //agredo por cambio 20090839
    query.append("  app_confi_centr_distr centro, ");
    query.append("  ape_orden_visua_chequ visua ");
     
    // vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_CLAS_PROD)){
        query.append(" , MAE_NEGOC neg ");
    }
    
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_VOLUMEN)){
        query.append(" , SEG_PARAM_INTER_PAIS param ");
    }
     
    query.append(" WHERE etiq.NUM_CAJA = " + dtoe.getNumeroCaja());
    query.append(" AND etiq.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");
    query.append(" AND ped.VAL_NUME_SOLI = '" + dtoe.getNumeroConsolidado() + "' ");
    query.append(" AND etiq.ESTP_OID_ESTA_PEDI IN (" + ConstantesAPE.OID_ESTADO_EMBALADO + "," + ConstantesAPE.OID_ESTADO_TERMINADO + ") ");    
    query.append(" AND etiq.ESTP_OID_ESTA_PEDI = estadoCaj.OID_ESTA_PEDI ");    
    query.append(" AND etiq.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append(" AND det.LPCA_OID_LIST_PICA_CABE = cab.OID_LIST_PICA_CABE ");
    query.append(" AND det.PROD_OID_PROD = prod.OID_PROD ");
    query.append(" AND etiq.NUM_CAJA = det.NUM_CAJA ");
    query.append(" AND det.MCDD_OID_MAPA_CENT_DIST_DETA = mcd.OID_MAPA_CENT_DIST_DETA ");
    query.append(" AND ped.INRE_OID_INDI_REVI = i18n.VAL_OID(+) ");
    query.append(" AND i18n.idio_oid_idio(+) = " + dtoe.getOidIdioma());
    query.append(" AND i18n.attr_num_atri(+) = 1  ");
    query.append(" AND i18n.attr_enti(+) = 'PED_INDIC_REVIS' ");
    // vbongiov -- Inc APE20080516 -- 25/06/2008
    query.append(" AND prod.OID_PROD  = i18n2.VAL_OID ");
    query.append(" AND i18n2.idio_oid_idio = " + dtoe.getOidIdioma());
    query.append(" AND i18n2.attr_num_atri = 1 ");
    query.append(" AND i18n2.attr_enti = 'MAE_PRODU' ");
    
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_VOLUMEN)){
        query.append(" AND param.PAIS_OID_PAIS = " + dtoe.getOidPais());
    }
    
    // vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_NRO_UNIDADES)){
        query.append(" ORDER BY CANTIDADREQUERIDA ");
    }
    
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_CLAS_PROD)){
        query.append(" AND prod.NEGO_OID_NEGO = neg.OID_NEGO ");
        query.append(" ORDER BY COD_NEGO ");
    }    
      
    if(oidOrdenVisual.equals(ConstantesAPE.ORDEN_VISU_CHEQ_VOLUMEN)){
        query.append(" ORDER BY VOL_ESTANDAR ");
    }
        
    if(ordenVisualChequeo.equals("D")){
        query.append(" DESC ");
    }
    
    
    try {
        rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    int cant = rs.getRowCount();
    
    for(int i=0; i<cant; i++){
        if(i==0){
            dtoDatosCajaCabecera.setOidEtiqueta(Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_ETIQ")).toString()));
            
            dtoDatosCajaCabecera.setOidListaPicadoCabecera(Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_LIST_PICA_CABE")).toString()));
            
            BigDecimal numConsolidado = (BigDecimal) rs.getValueAt(0, "VAL_NUME_SOLI");
            dtoDatosCajaCabecera.setNumeroConsolidado(numConsolidado!=null?Long.valueOf(numConsolidado.toString()):null);
            
            dtoDatosCajaCabecera.setTurnoChequeo(Long.valueOf(((BigDecimal)rs.getValueAt(0, "TURNOCHEQUEO")).toString()));
            
            String estPedido = (String) rs.getValueAt(0, "ESTADOPEDIDO");
            dtoDatosCajaCabecera.setEstadoPedido(estPedido!=null?estPedido:null);
            
            String estCaja = (String) rs.getValueAt(0, "ESTADOCAJA");
            dtoDatosCajaCabecera.setEstadoCaja(estCaja!=null?estCaja:null);
            
            String tipoChequeo = (String) rs.getValueAt(0, "TIPOCHEQUEO");
            dtoDatosCajaCabecera.setTipoChequeo(tipoChequeo!=null?tipoChequeo:null);
            
            String origenChequeo = (String) rs.getValueAt(0, "IND_ORIG_CHEQ");
            dtoDatosCajaCabecera.setOrigenChequeo(origenChequeo!=null?origenChequeo:null);
            
            dtoDatosCajaCabecera.setNumeroCaja(Long.valueOf(((BigDecimal)rs.getValueAt(0, "NUM_CAJA")).toString()));
            
            dtoDatosCajaCabecera.setTotalCajas(Long.valueOf(((BigDecimal)rs.getValueAt(0, "NUM_TOTA_CAJA")).toString()));
            
            BigDecimal oidTipoCAja = (BigDecimal) rs.getValueAt(0, "TCEM_OID_TIPO_CAJA_EMBA");
            dtoDatosCajaCabecera.setOidTipoCajaEmbalaje(oidTipoCAja!=null?Long.valueOf(oidTipoCAja.toString()):null);
            
            dtoDatosCajaCabecera.setTotalProductos(Long.valueOf(((BigDecimal)rs.getValueAt(0, "TOTALPRODUCTOS")).toString()));
            
            dtoDatosCajaCabecera.setUnidadesCaja(Long.valueOf(((BigDecimal)rs.getValueAt(0, "UNIDADESCAJA")).toString()));
            
            dtoDatosCajaCabecera.setUnidadesPicadas(Long.valueOf(((BigDecimal)rs.getValueAt(0, "UNIDADESPICADAS")).toString()));
            
            /* BELC400000722 - dmorello, 12/09/2007 */
            dtoDatosCajaCabecera.setOidPeriodo(new Long(((BigDecimal)rs.getValueAt(0, "PERD_OID_PERI")).longValue()));
        }
        
        dtoDatosCajaDetalle = new DTODatosCajaDetalle();
        
        dtoDatosCajaDetalle.setOidListaPicadoDetalle(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_LIST_PICA_DETA")).toString()));
        
        dtoDatosCajaDetalle.setSecuencia(Long.valueOf(((BigDecimal)rs.getValueAt(i, "NUM_CODI_POSI")).toString()));
        
        dtoDatosCajaDetalle.setDescripcionProducto((String)rs.getValueAt(i, "DES_CORT"));
        
        dtoDatosCajaDetalle.setNumeroAnaquel((String)rs.getValueAt(i, "NUM_ANAQ"));
        
        dtoDatosCajaDetalle.setCantidadRequerida(Long.valueOf(((BigDecimal)rs.getValueAt(i, "CANTIDADREQUERIDA")).toString()));
        
        UtilidadesLog.debug("i=" + i + " dtoDatosCajaDetalle: " + dtoDatosCajaDetalle);
        
        detalles.add(dtoDatosCajaDetalle);
    }
    
    dtoDatosCajaCabecera.setDetalles(detalles);
    
    UtilidadesLog.debug("dtoDatosCajaCabecera: " + dtoDatosCajaCabecera);
    
    UtilidadesLog.info("DAOChequeoCajas.obtenerCajaChequear(DTOBuscarCaja dtoe): Salida");
    return dtoDatosCajaCabecera;
  }
  
  public DTOSalida buscarProducto(DTOBuscarProducto dtoe) throws MareException {
    UtilidadesLog.info("DAOChequeoCajas.buscarProducto(DTOBuscarProducto dtoe): Entrada");
    
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    BelcorpService bs;
    DTOSalida dtoSalida = new DTOSalida();

    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    // vbongiov -- Cambio 20090839 -- 12/11/2009
    query.append(" SELECT ROWNUM OID, prod.COD_SAP, i18n.VAL_I18N DES_CORT, mcd.NUM_ANAQ, ");
    query.append(" '' UNIDADES , mcd.OID_MAPA_CENT_DIST_DETA, prod.OID_PROD ");
    query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC cab, APE_ASIGN_PRODU_ANAQU_DETAL det, ");
    query.append(" APE_MAPA_CENTR_DISTR_DETAL mcd, MAE_PRODU prod, v_gen_i18n_sicc i18n ");
    query.append(" WHERE det.PROD_OID_PROD = prod.OID_PROD ");
    
    if(dtoe.getCodigoProducto()!=null){
        query.append(" AND prod.COD_SAP LIKE '" + dtoe.getCodigoProducto() + "' ");
    }
    
    query.append(" AND prod.oid_prod = i18n.VAL_OID ");
    query.append(" AND i18n.idio_oid_idio = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
    query.append(" AND i18n.attr_num_atri = 1 ");
    query.append(" AND i18n.attr_enti = 'MAE_PRODU' ");    
    
    if(dtoe.getDescripcionProducto()!=null){
        query.append(" AND i18n.VAL_I18N LIKE '" + dtoe.getDescripcionProducto() + "' ");
    }
    
    /* BELC400000722 - dmorello, 12/09/2007 */
    if (dtoe.getOidPeriodo() != null) {
        query.append(" AND cab.perd_oid_peri = ").append(dtoe.getOidPeriodo());
    }
    
    query.append(" AND det.APAC_OID_ASIG_PROD_ANAQ_CABE = cab.OID_ASIG_PROD_ANAQ_CABE ");
    query.append(" AND cab.IND_ACTI_FACT = 'S' ");
    query.append(" AND det.MCDD_OID_MAPA_CENT_DIST_DETA = mcd.OID_MAPA_CENT_DIST_DETA ");
    
    try {
        rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe));
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    /* dmorello, 07/09/2007 */
    if (rs == null || rs.esVacio()) {
        String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException("", UtilidadesError.armarCodigoError(error));
    }
    
    dtoSalida.setResultado(rs);
    
    UtilidadesLog.info("DAOChequeoCajas.buscarProducto(DTOBuscarProducto dtoe): Salida");
    return dtoSalida;    
  }
  
  // vbongiov -- Cambio APE-012 -- 15/05/2008
  public Boolean todasEtiquetaCheq(DTOBelcorp dtoe) throws MareException {
  
    UtilidadesLog.info("DAOChequeoCajas.todasEtiquetaCheq(DTODatosCajaCabecera dtoe): Entrada");
    
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    BelcorpService bs;
    Boolean todasEtiquetaCheq = null;

    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    if(dtoe instanceof DTODatosCajaCabecera) {
        DTODatosCajaCabecera dtoDatosCajaCabecera = (DTODatosCajaCabecera)dtoe;
    
        query.append(" select count(etiq.OID_ETIQ) CAJAS_CHEQ, MAX(etiq.NUM_TOTA_CAJA) NUM_TOTA_CAJA ");
        query.append(" from APE_ETIQU etiq, PED_SOLIC_CABEC cab ");
        query.append(" where etiq.SOCA_OID_SOLI_CABE = cab.OID_SOLI_CABE ");
        query.append(" and cab.VAL_NUME_SOLI = '" + dtoDatosCajaCabecera.getNumeroConsolidado() + "' ");
        query.append(" and etiq.ESTP_OID_ESTA_PEDI = " + ConstantesAPE.OID_ESTADO_CHEQUEADO);
        query.append(" group by etiq.SOCA_OID_SOLI_CABE ");    
        
    } else if(dtoe instanceof DTOListaPicadoDetalle) {
        DTOListaPicadoDetalle dtoListaPicadoDetalle = (DTOListaPicadoDetalle)dtoe;
        
        query.append(" select count(etiq.OID_ETIQ) CAJAS_CHEQ, MAX(etiq.NUM_TOTA_CAJA) NUM_TOTA_CAJA ");
        query.append(" from APE_ETIQU etiq ");
        query.append(" where etiq.LPCA_OID_LIST_PICA_CABE = " + dtoListaPicadoDetalle.getOidCabecera());
        query.append(" and etiq.ESTP_OID_ESTA_PEDI IN (" + ConstantesAPE.OID_ESTADO_CHEQUEADO + ", " + ConstantesAPE.OID_ESTADO_PEDIDO_REVISADO + ") ");
        query.append(" group by etiq.SOCA_OID_SOLI_CABE ");           
    }
    
    try {
        rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.debug("rs: " + rs);
    
    if (rs.esVacio()) {
        todasEtiquetaCheq = Boolean.FALSE;
        
    } else {
        if(((BigDecimal) rs.getValueAt(0, "CAJAS_CHEQ")).equals((BigDecimal) rs.getValueAt(0, "NUM_TOTA_CAJA"))){
            todasEtiquetaCheq = Boolean.TRUE;
        } else {
            todasEtiquetaCheq = Boolean.FALSE;
        }
    }
        
    UtilidadesLog.info("DAOChequeoCajas.todasEtiquetaCheq(DTODatosCajaCabecera dtoe): Salida");
    return todasEtiquetaCheq;    
  }
  
  
  // vbongiov -- Cambio APE-012 -- 15/05/2008
  public Long validarClienteChequear(DTOBelcorp dtoe) throws MareException {
  
    UtilidadesLog.info("DAOChequeoCajas.validarClienteChequear(DTODatosCajaCabecera dtoe): Entrada");
    
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    BelcorpService bs;
    Long oidCabecera = null;

    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    if(dtoe instanceof DTODatosCajaCabecera) {
        DTODatosCajaCabecera dtoDatosCajaCabecera = (DTODatosCajaCabecera)dtoe;
        
        query.append(" select cab.OID_SOLI_CABE ");
        query.append(" from REC_CLIEN_A_CHEQU cliCheq, PED_SOLIC_CABEC cab, PED_INDIC_REVIS rev ");
        query.append(" where cab.VAL_NUME_SOLI = '" + dtoDatosCajaCabecera.getNumeroConsolidado() + "' ");
        query.append(" and cliCheq.CLIE_OID_CLIE = cab.CLIE_OID_CLIE ");
        query.append(" and cliCheq.PERD_OID_PERI = cab.PERD_OID_PERI ");
        query.append(" and cliCheq.INRE_OID_INDI_REVI = rev.OID_INDI_REVI ");
        query.append(" and rev.COD_INDI_REVI = '" + ConstantesAPE.TIPO_REVISION + "' ");
        
    } else if(dtoe instanceof DTOListaPicadoDetalle) {
        DTOListaPicadoDetalle dtoListaPicadoDetalle = (DTOListaPicadoDetalle)dtoe;
        
        query.append(" select distinct cab.OID_SOLI_CABE ");
        query.append(" from REC_CLIEN_A_CHEQU cliCheq, APE_ETIQU etiq, PED_SOLIC_CABEC cab, PED_INDIC_REVIS rev ");
        query.append(" where etiq.LPCA_OID_LIST_PICA_CABE = " + dtoListaPicadoDetalle.getOidCabecera());
        query.append(" and cab.OID_SOLI_CABE = etiq.SOCA_OID_SOLI_CABE ");
        query.append(" and cliCheq.CLIE_OID_CLIE = cab.CLIE_OID_CLIE ");
        query.append(" and cliCheq.PERD_OID_PERI = cab.PERD_OID_PERI ");
        query.append(" and cliCheq.INRE_OID_INDI_REVI = rev.OID_INDI_REVI ");
        query.append(" and rev.COD_INDI_REVI = '" + ConstantesAPE.TIPO_REVISION + "' ");         
    }
    
    try {
        rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.debug("rs: " + rs);
    
    if (!rs.esVacio()) {
        oidCabecera = Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_SOLI_CABE")).toString());
    } 
    
    UtilidadesLog.info("DAOChequeoCajas.validarClienteChequear(DTODatosCajaCabecera dtoe): Salida");
    return oidCabecera;    
  }
  
  // vbongiov -- Cambio APE-012 -- 15/05/2008
  public void actualizarResultRevision(Long oidCabecera) throws MareException {
      UtilidadesLog.info("DAOChequeoCajas.actualizarResultRevision(Long oidCabecera): Entrada");
      
      StringBuffer query = new StringBuffer();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" update PED_SOLIC_CABEC cab ");
      query.append(" set cab.RECQ_OID_RESU_CHEQ = (select res.OID_RESU_CHEQ ");
      query.append("                               from REC_RESUL_CHEQU res ");
      query.append("                               where res.COD_RESU_CHEQ ='" + ConstantesAPE.CHEQUEO_CONFORME + "') ");
      query.append(" where cab.OID_SOLI_CABE = " + oidCabecera);
      
      try {
          int cant = bs.dbService.executeUpdate(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOChequeoCajas.actualizarResultRevision(Long oidCabecera): Salida");
  }
    
}