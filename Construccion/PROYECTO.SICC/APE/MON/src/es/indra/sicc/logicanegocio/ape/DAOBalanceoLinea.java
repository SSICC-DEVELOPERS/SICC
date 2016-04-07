package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOBalanceoLinea;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOEstimadoSublinea;
import es.indra.sicc.dtos.ape.DTONumeroZonasSublineas;
import es.indra.sicc.dtos.ape.DTOUnidadesSublineas;
import es.indra.sicc.dtos.ape.DTOUnidadesZonasSublineas;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DAOBalanceoLinea {
    public DAOBalanceoLinea() { }
    
   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 05/03/2007
    */
    public DTOSalida obtenerOrdenacionProductos(DTOBelcorp dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.obtenerOrdenacionProductos"+
        "(DTOBelcorp dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT ORDENACION.OID_ORDE_PROD AS OID, ");
        query.append(" V1.VAL_I18N AS DESCRIPCION ");
        query.append(" FROM APE_ORDEN_PRODU ORDENACION, V_GEN_I18N_SICC V1 ");
        query.append(" WHERE V1.VAL_OID = ORDENACION.OID_ORDE_PROD ");
        query.append(" AND V1.ATTR_ENTI = 'APE_ORDEN_PRODU' ");
        query.append(" AND V1.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND V1.ATTR_NUM_ATRI = 1 ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOBalanceoLinea.obtenerOrdenacionProductos"+
        "(DTOBelcorp dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 05/03/2007
    */
    public DTOSalida obtenerOrigenDatos(DTOBelcorp dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.obtenerOrigenDatos"+
        "(DTOBelcorp dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT ORIGEN.OID_ORIG_DATO AS OID, ");
        query.append(" V1.VAL_I18N AS DESCRIPCION ");
        query.append(" FROM APE_ORIGE_DATOS ORIGEN, V_GEN_I18N_SICC V1 ");
        query.append(" WHERE V1.VAL_OID = ORIGEN.OID_ORIG_DATO ");
        query.append(" AND V1.ATTR_ENTI = 'APE_ORIGE_DATOS' ");
        query.append(" AND V1.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND V1.ATTR_NUM_ATRI = 1 ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOBalanceoLinea.obtenerOrigenDatos"+
        "(DTOBelcorp dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
    public DTOSalida emitirAlarmas(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.emitirAlarmas(dtoe): Entrada");     
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" select mp.cod_sap ");
        query.append("   from mae_produ mp, ");
        query.append("        ape_linea_armad la, ");
        query.append("        ape_subli_armad sl, ");
        //query.append("        ape_asign_produ_anaqu_cabec apac, "); // Eliminado (01)
        query.append("        ape_asign_produ_anaqu_detal apad, ");
        //query.append("        ape_mapa_centr_distr_cabec mcdc, "); // Eliminado (01)
        query.append("        ape_mapa_centr_distr_detal mcdd, ");
        query.append("        pre_matri_factu pmf, ");
        query.append("        pre_ofert_detal pod ");
        query.append("  where mcdd.sbar_oid_subl_arma = sl.oid_subl_arma ");
        query.append("    and mcdd.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOidMapaCentroDistribucion()); // Agregado (01)
        query.append("    and apad.apac_oid_asig_prod_anaq_cabe = " + dtoe.getOidAsignacionProductoAnaquel()); // Agregado (01)
        //query.append("    and mcdd.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe "); // Eliminado (01)
        //query.append("    and mcdc.ccdi_oid_conf_cent_dist = " + dtoe.getOidCentroDistribucion()); // Eliminado (01)
        query.append("    and sl.liar_oid_line_arma = la.oid_line_arma ");
        query.append("    and la.oid_line_arma = " + dtoe.getOidLineaArmado());
        query.append("    and apad.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        //query.append("    and apad.apac_oid_asig_prod_anaq_cabe = apac.oid_asig_prod_anaq_cabe "); // Eliminado (01)
        //query.append("    and apac.ind_acti_fact = '" + ConstantesAPE.ACTIVO_FACTURACION_S + "' "); // Eliminado (01)
        //query.append("    and apac.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe "); // Eliminado (01)
        //query.append("    and apac.perd_oid_peri = " + dtoe.getOidPeriodo()); // Eliminado (01)
        query.append("    and apad.prod_oid_prod = pod.prod_oid_prod ");
        query.append("    and pmf.ofde_oid_deta_ofer = pod.oid_deta_ofer ");
        query.append("    and pmf.fec_ulti_actu > la.fec_hora_revi_alar ");
        query.append("    and pod.prod_oid_prod = mp.oid_prod ");
        query.append(" UNION ");
        query.append(" select mp.cod_sap ");
        query.append("   from mae_produ mp, ");
        query.append("        ape_linea_armad la, ");
        query.append("        ape_subli_armad sl, ");
        //query.append("        ape_asign_produ_anaqu_cabec apac, "); // Eliminado (01)
        query.append("        ape_asign_produ_anaqu_detal apad, ");
        //query.append("        ape_mapa_centr_distr_cabec mcdc, "); // Eliminado (01)
        query.append("        ape_mapa_centr_distr_detal mcdd, ");
        query.append("        pre_matri_factu pmf, ");
        query.append(" 	      pre_matri_reemp pmr, ");
        query.append("        pre_ofert_detal pod ");
        query.append("  where mcdd.sbar_oid_subl_arma = sl.oid_subl_arma ");
        query.append("    and mcdd.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOidMapaCentroDistribucion()); // Agregado (01)
        query.append("    and apad.apac_oid_asig_prod_anaq_cabe = " + dtoe.getOidAsignacionProductoAnaquel()); // Agregado (01)
        //query.append("    and mcdd.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe "); // Eliminado (01)
        //query.append("    and mcdc.ccdi_oid_conf_cent_dist = " + dtoe.getOidCentroDistribucion()); // Eliminado (01)
        query.append("    and sl.liar_oid_line_arma = la.oid_line_arma ");
        query.append("    and la.oid_line_arma = " + dtoe.getOidLineaArmado());
        query.append("    and apad.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        //query.append("    and apad.apac_oid_asig_prod_anaq_cabe = apac.oid_asig_prod_anaq_cabe "); // Eliminado (01)
        //query.append("    and apac.ind_acti_fact = '" + ConstantesAPE.ACTIVO_FACTURACION_S + "' "); // Eliminado (01)
        //query.append("    and apac.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe "); // Eliminado (01)
        //query.append("    and apac.perd_oid_peri = " + dtoe.getOidPeriodo()); // Eliminado (01)
        query.append("    and apad.prod_oid_prod = pod.prod_oid_prod ");
        query.append("    and pmf.ofde_oid_deta_ofer = pod.oid_deta_ofer ");
        query.append("    and pmr.mafa_oid_cod_reem = pmf.oid_matr_fact ");
        query.append("    and pmr.fec_ulti_actu > la.fec_hora_revi_alar ");
        query.append("    and pod.prod_oid_prod = mp.oid_prod ");
        query.append(" UNION ");
        query.append(" select mp.cod_sap ");
        query.append("   from mae_produ mp, ");
        query.append("        ape_linea_armad la, ");
        query.append("        ape_subli_armad sl, ");
        //query.append("        ape_asign_produ_anaqu_cabec apac, "); // Eliminado (01)
        query.append("        ape_asign_produ_anaqu_detal apad, ");
        //query.append("        ape_mapa_centr_distr_cabec mcdc, "); // Eliminado (01)
        query.append("        ape_mapa_centr_distr_detal mcdd, ");
        query.append("        pre_matri_factu pmf, ");
        query.append(" 	      pre_matri_reemp pmr, ");
        query.append("        pre_ofert_detal pod ");
        query.append("  where mcdd.sbar_oid_subl_arma = sl.oid_subl_arma ");
        query.append("    and mcdd.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOidMapaCentroDistribucion()); // Agregado (01)
        query.append("    and apad.apac_oid_asig_prod_anaq_cabe = " + dtoe.getOidAsignacionProductoAnaquel()); // Agregado (01)
        //query.append("    and mcdd.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe "); // Eliminado (01)
        //query.append("    and mcdc.ccdi_oid_conf_cent_dist = " + dtoe.getOidCentroDistribucion()); // Eliminado (01)
        query.append("    and sl.liar_oid_line_arma = la.oid_line_arma ");
        query.append("    and la.oid_line_arma = " + dtoe.getOidLineaArmado());
        query.append("    and apad.mcdd_oid_mapa_cent_dist_deta = mcdd.oid_mapa_cent_dist_deta ");
        //query.append("    and apad.apac_oid_asig_prod_anaq_cabe = apac.oid_asig_prod_anaq_cabe "); // Eliminado (01)
        //query.append("    and apac.ind_acti_fact = '" + ConstantesAPE.ACTIVO_FACTURACION_S + "' "); // Eliminado (01)
        //query.append("    and apac.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe "); // Eliminado (01)
        //query.append("    and apac.perd_oid_peri = " + dtoe.getOidPeriodo()); // Eliminado (01)
        query.append("    and apad.prod_oid_prod = pod.prod_oid_prod ");
        query.append("    and pmf.ofde_oid_deta_ofer = pod.oid_deta_ofer ");
        query.append("    and pmr.mafa_oid_cod_ppal = pmf.oid_matr_fact "); // Unico cambio respecto de la anterior query
        query.append("    and pmr.fec_ulti_actu > la.fec_hora_revi_alar ");
        query.append("    and pod.prod_oid_prod = mp.oid_prod ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException msnfe) {
            UtilidadesLog.error("ERROR ", msnfe);
            throw new MareException(msnfe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOBalanceoLinea.emitirAlarmas(dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 09/03/2007
    * 
    * CHANGELOG
    * ---------
    * dmorello, 27/05/2008: Incidencia 20080502
    *                       Se considera que, para los productos, el indicador
    *                       de "fuera de pedido" (fuera de caja) es "F" o "B".
    */
    public DTOSalida ordenarProductos(DTOBalanceoLinea dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.ordenarProductos"+
        "(DTOBalanceoLinea dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        // vbongiov -- LG_V400000035 -- 9/11/2007        
        if(dtoe.getOidOrigenDatos().equals(ConstantesAPE.FUENTE_ESTIMADO)){
        
            query.append(" SELECT DISTINCT ");
            query.append(" MAESTROPRODUCTOS.OID_PROD AS OIDPRODUCTO, ");
            query.append(" ESTIMADOSPRODUCTOS.NUM_UNID_ESTI AS UNIDADESESTIMADAS, ");
            query.append(" DECODE(asigProAnaq.OID_ASIG_PROD_ANAQ, NULL, 'false', 'true') AS ASIGNADO,  ");
            query.append(" SUBLINEAARMADO.OID_SUBL_ARMA AS OIDSUBLINEA ");
            query.append(" FROM ");
            query.append(" MAE_PRODU MAESTROPRODUCTOS, ");
            query.append(" APE_ESTIM_PRODU ESTIMADOSPRODUCTOS, ");
            query.append(" APE_LINEA_ARMAD LINEAARMADO, ");
            query.append(" APE_SUBLI_ARMAD SUBLINEAARMADO, ");
            query.append(" ( SELECT anaqueldetalle.oid_asig_prod_anaq, anaqueldetalle.prod_oid_prod, centrodetalle.sbar_oid_subl_arma ");
            query.append(" FROM ");
            query.append(" APE_ASIGN_PRODU_ANAQU_DETAL ANAQUELDETALLE, ");
            query.append(" APE_ASIGN_PRODU_ANAQU_CABEC ANAQUELCABECERA, ");
            query.append(" APE_MAPA_CENTR_DISTR_DETAL CENTRODETALLE, ");
            query.append(" APE_MAPA_CENTR_DISTR_CABEC CENTROCABECERA ");
            query.append(" WHERE ");
            query.append("  ANAQUELDETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE = ANAQUELCABECERA.OID_ASIG_PROD_ANAQ_CABE ");
            query.append(" AND ANAQUELCABECERA.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append(" AND ANAQUELCABECERA.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getOidAsignacionProductosAnaqueles());
            query.append(" AND ANAQUELDETALLE.MCDD_OID_MAPA_CENT_DIST_DETA = CENTRODETALLE.OID_MAPA_CENT_DIST_DETA ");
            query.append(" AND CENTRODETALLE.MCDC_OID_MAPA_CENT_DIST_CABE = CENTROCABECERA.OID_MAPA_CENT_DIST_CABE ");
            query.append(" AND CENTROCABECERA.OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCentroDistribucion());
            query.append(" ) asigProAnaq ");
            query.append(" WHERE ");
            query.append(" LINEAARMADO.OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
            query.append(" AND ESTIMADOSPRODUCTOS.LIAR_OID_LINE_ARMA = LINEAARMADO.OID_LINE_ARMA ");
            query.append(" AND  LINEAARMADO.NUM_LINE_AFP = ESTIMADOSPRODUCTOS.IND_FUER_PEDI ");
            query.append(" AND ESTIMADOSPRODUCTOS.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append(" AND ESTIMADOSPRODUCTOS.PROD_OID_PROD = MAESTROPRODUCTOS.OID_PROD ");
            query.append(" AND asigProAnaq.prod_oid_prod(+) = maestroproductos.oid_prod ");
            query.append(" AND asigProAnaq.sbar_oid_subl_arma = SUBLINEAARMADO.OID_SUBL_ARMA(+) ");
        
        } else if(dtoe.getOidOrigenDatos().equals(ConstantesAPE.FUENTE_FACT_PROY)){
        
            query.append(" SELECT  DISTINCT ");
            query.append(" MAESTROPRODUCTOS.OID_PROD AS OIDPRODUCTO, ");
            query.append(" FACTURACIONPROYECTADA.NUM_UNID_PROY AS UNIDADESESTIMADAS, ");
            query.append(" DECODE(asigProAnaq.OID_ASIG_PROD_ANAQ, NULL, 'false', 'true') AS ASIGNADO, ");
            query.append(" SUBLINEAARMADO.OID_SUBL_ARMA AS OIDSUBLINEA  ");
            query.append(" FROM  ");
            query.append(" MAE_PRODU MAESTROPRODUCTOS, ");
            query.append(" INT_FACTU_PROYE FACTURACIONPROYECTADA, ");
            query.append(" APE_LINEA_ARMAD LINEAARMADO, ");
            query.append(" APE_SUBLI_ARMAD SUBLINEAARMADO, ");
            query.append(" ( SELECT anaqueldetalle.oid_asig_prod_anaq, anaqueldetalle.prod_oid_prod, centrodetalle.sbar_oid_subl_arma ");
            query.append(" FROM ");
            query.append(" APE_ASIGN_PRODU_ANAQU_DETAL ANAQUELDETALLE, ");
            query.append(" APE_ASIGN_PRODU_ANAQU_CABEC ANAQUELCABECERA, ");
            query.append(" APE_MAPA_CENTR_DISTR_DETAL CENTRODETALLE, ");
            query.append(" APE_MAPA_CENTR_DISTR_CABEC CENTROCABECERA ");
            query.append(" WHERE ");
            query.append("  ANAQUELDETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE = ANAQUELCABECERA.OID_ASIG_PROD_ANAQ_CABE ");
            query.append(" AND ANAQUELCABECERA.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append(" AND ANAQUELCABECERA.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getOidAsignacionProductosAnaqueles());
            query.append(" AND ANAQUELDETALLE.MCDD_OID_MAPA_CENT_DIST_DETA = CENTRODETALLE.OID_MAPA_CENT_DIST_DETA ");
            query.append(" AND CENTRODETALLE.MCDC_OID_MAPA_CENT_DIST_CABE = CENTROCABECERA.OID_MAPA_CENT_DIST_CABE ");
            query.append(" AND CENTROCABECERA.OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCentroDistribucion());
            query.append(" ) asigProAnaq ");
            query.append(" WHERE  ");
            query.append(" FACTURACIONPROYECTADA.PROD_OID_PROD = MAESTROPRODUCTOS.OID_PROD ");
            query.append(" AND  FACTURACIONPROYECTADA.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append(" AND  LINEAARMADO.OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
            query.append(" AND  ((LINEAARMADO.NUM_LINE_AFP =  1 AND MAESTROPRODUCTOS.COD_IND_DENT_CAJA IN ('F','B')) OR ");
            query.append(" (LINEAARMADO.NUM_LINE_AFP =  0 AND MAESTROPRODUCTOS.COD_IND_DENT_CAJA NOT IN ('F','B'))) ");
            query.append(" AND asigProAnaq.prod_oid_prod(+) = maestroproductos.oid_prod ");
            query.append(" AND asigProAnaq.sbar_oid_subl_arma = SUBLINEAARMADO.OID_SUBL_ARMA(+) ");         
        }
        
        if(dtoe.getOidOrdenacionProductos().longValue()==
        ConstantesAPE.OID_ORDENACION_ASCENDENTE.longValue())  {
            query.append(" ORDER BY UNIDADESESTIMADAS ASC ");
        }
        else {
            query.append(" ORDER BY UNIDADESESTIMADAS DESC ");            
        }
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOBalanceoLinea.ordenarProductos"+
        "(DTOBalanceoLinea dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
   
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       1/03/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOSalida ordenarAnaqueles(DTOBalanceoLinea dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.ordenarAnaqueles(DTOBalanceoLinea dtoe): Entrada");
        
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
       
        query.append(" SELECT sublin.OID_SUBL_ARMA, anaqDet.MCDD_OID_MAPA_CENT_DIST_DETA, ");
        query.append(" anaqDet.OID_ORDE_ANAQ_DETA, sublin.NUM_ORDE_BALA ");
        query.append(" FROM APE_SUBLI_ARMAD sublin, APE_ORDEN_ANAQU_CABEC anaqCab, ");
        query.append(" APE_ORDEN_ANAQU_DETAL anaqDet, APE_MAPA_CENTR_DISTR_DETAL det ");
        query.append(" WHERE anaqcab.LIAR_OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
        query.append(" AND anaqcab.LIAR_OID_LINE_ARMA = sublin.LIAR_OID_LINE_ARMA ");        
        query.append(" AND anaqCab.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getOidMapaZonas());
        query.append(" AND anaqcab.OID_ANAQ_CABE = " + dtoe.getOidOrdenAnaqueles());
        query.append(" AND anaqdet.MCDD_OID_MAPA_CENT_DIST_DETA = det.OID_MAPA_CENT_DIST_DETA ");
        // vbongiov -- LG_V400000035 -- 9/11/2007       
        query.append(" AND det.IND_EXPA = 0 ");
        query.append(" AND anaqDet.OACA_OID_ANAQ_CABE = anaqCab.OID_ANAQ_CABE ");
        query.append(" AND det.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA ");
        query.append(" AND NOT EXISTS (SELECT 1 ");
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC asigCab, ");
        query.append(" APE_ASIGN_PRODU_ANAQU_DETAL asigDet ");
        query.append(" WHERE asigDet.APAC_OID_ASIG_PROD_ANAQ_CABE = asigCab.OID_ASIG_PROD_ANAQ_CABE ");
        query.append(" AND asigCab.PERD_OID_PERI = " + dtoe.getOidPeriodo()); 
        // vbongiov -- LG_V400000035 -- 9/11/2007       
        query.append(" AND asigCab.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getOidAsignacionProductosAnaqueles()); 
        query.append(" AND asigCab.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getOidMapaZonas());
        query.append(" AND asigDet.MCDD_OID_MAPA_CENT_DIST_DETA = anaqDet.MCDD_OID_MAPA_CENT_DIST_DETA) ");
        query.append(" ORDER BY sublin.NUM_ORDE_BALA, anaqDet.NUM_ORDE ");
       
       
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        // Elimino la columna de ordenamiento
        rs.removeColumn(3);

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoMapas.ordenarAnaqueles(DTOBalanceoLinea dtoe): Salida");
        return dtoSalida;
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 22/03/2007
    */
    public ArrayList obtenerEstimadosSublineas(DTOBalanceoLinea dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.obtenerEstimadosSublineas"+
        "(DTOBalanceoLinea dtoe): Entrada");
        
        ArrayList lista = new ArrayList();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT SUBLINEA.OID_SUBL_ARMA AS OIDSUBLINEA, ");
        query.append(" GEN.VAL_I18N AS DESCRIPCION, ");
        // LG_V400000059 - dmorello, 16/11/2007: Traigo cero para sublíneas sin productos asignados
        //query.append(" SUM(ASIGNACIONDETALLE.NUM_UNIDA) AS TOTAL ");
        query.append(" NVL ( SUM(ASIGNACIONDETALLE.NUM_UNIDA) , 0 ) AS TOTAL ");
        // Fin LG_V400000059 dmorello 16/11/2007
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_DETAL ASIGNACIONDETALLE, ");
        query.append(" APE_MAPA_CENTR_DISTR_DETAL MAPACDDETALLE, ");
        query.append(" APE_SUBLI_ARMAD SUBLINEA, ");
        query.append(" V_GEN_I18N_SICC GEN ");
        // LG_V400000059 - dmorello, 16/11/2007: Agrego outer joins para traer sublíneas s/prod asignados
        query.append(" WHERE ASIGNACIONDETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE (+) = " + dtoe.getOidAsignacionProductosAnaqueles());
        query.append(" AND ASIGNACIONDETALLE.MCDD_OID_MAPA_CENT_DIST_DETA (+) = MAPACDDETALLE.OID_MAPA_CENT_DIST_DETA ");
        query.append(" AND MAPACDDETALLE.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCentroDistribucion());
        query.append(" AND MAPACDDETALLE.SBAR_OID_SUBL_ARMA (+) = SUBLINEA.OID_SUBL_ARMA ");
        query.append(" AND SUBLINEA.LIAR_OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
        // Fin LG_V400000059 dmorello 16/11/2007
        query.append(" AND SUBLINEA.OID_SUBL_ARMA = GEN.VAL_OID ");
        query.append(" AND GEN.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND GEN.ATTR_ENTI = 'APE_SUBLI_ARMAD' ");
        query.append(" GROUP BY SUBLINEA.OID_SUBL_ARMA, GEN.VAL_I18N ");
        // dmorello, 13/11/2007 - Para mostrar combo de sublíneas ordenado en modal Evaluar Carga
        query.append(" ORDER BY DESCRIPCION ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        int cant = rs.getRowCount();
        
        for(int i=0; i<cant; i++) {
            DTOEstimadoSublinea dto = new DTOEstimadoSublinea();
            
            BigDecimal oidSublinea = (BigDecimal)rs.getValueAt(i, "OIDSUBLINEA");
            String descripcion = (String)rs.getValueAt(i, "DESCRIPCION");
            BigDecimal total = (BigDecimal)rs.getValueAt(i, "TOTAL");
            
            if(oidSublinea!=null) {
                dto.setOidSublinea(new Long(oidSublinea.longValue()));    
            }
            
            if(descripcion!=null)  {
                dto.setDescripcion(descripcion);    
            }
            
            if(total!=null)  {
                dto.setTotal(new Long(total.longValue()));    
            }     
            
            lista.add(dto);            
        }       
        
        UtilidadesLog.info("DAOBalanceoLinea.obtenerEstimadosSublineas"+
        "(DTOBalanceoLinea dtoe): Salida");
        
        return lista;    
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 22/03/2007
    */
    public ArrayList obtenerNumeroZonasSublineas(DTOBalanceoLinea dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.obtenerNumeroZonasSublineas"+
        "(DTOBalanceoLinea dtoe): Entrada");            
        
        ArrayList lista = new ArrayList();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT SUBLINEA.OID_SUBL_ARMA AS OIDSUBLINEA, ");
        /* LG_V400000059 - dmorello, 13/11/2007 */
        //query.append(" SUM(MAPAZONADETALLE.NUM_IDZO) NUMERO ");
        query.append(" COUNT(DISTINCT MAPAZONADETALLE.NUM_IDZO) NUMERO ");
        /* Fin LG_V400000059 - dmorello, 13/11/2007 */
        query.append(" FROM APE_MAPA_ZONA_DETAL MAPAZONADETALLE, ");
        query.append(" APE_SUBLI_ARMAD SUBLINEA ");
        query.append(" WHERE MAPAZONADETALLE.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getOidMapaZonas());
        query.append(" AND MAPAZONADETALLE.SBAR_OID_SUBL_ARMA = SUBLINEA.OID_SUBL_ARMA ");
        query.append(" AND SUBLINEA.LIAR_OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
        query.append(" GROUP BY SUBLINEA.OID_SUBL_ARMA ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        int cant = rs.getRowCount();
        
        for(int i=0; i<cant; i++) {
            DTONumeroZonasSublineas dto = new DTONumeroZonasSublineas();
            
            BigDecimal oidSublinea = (BigDecimal)rs.getValueAt(i, "OIDSUBLINEA");
            BigDecimal numero = (BigDecimal)rs.getValueAt(i, "NUMERO");
            
            if(oidSublinea!=null) {
                dto.setOidSublinea(new Long(oidSublinea.longValue()));    
            }
            
            if(numero!=null) {
                dto.setNumero(new Long(numero.longValue()));    
            }    
            
            lista.add(dto);       
        }        
        
        UtilidadesLog.info("DAOBalanceoLinea.obtenerNumeroZonasSublineas"+
        "(DTOBalanceoLinea dtoe): Salida");
        
        return lista;    
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 22/03/2007
    */
    public ArrayList obtenerUnidadesAsignadasZonasSublineas (DTOBalanceoLinea dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.obtenerUnidadesAsignadasZonasSublineas "+
        "(DTOBalanceoLinea dtoe): Entrada");            
        
        ArrayList lista = new ArrayList();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT SUBLINEA.OID_SUBL_ARMA AS OIDSUBLINEA, ");
        query.append(" MAPAZONADETALLE.NUM_IDZO AS IDZONA, ");
        // LG_V400000059 - dmorello, 13/11/2007
        //query.append(" SUM(ASIGNACIONDETALLE.NUM_UNIDA) AS UNIDADESASIGNADAS ");
        query.append(" SUM(NVL(ASIGNACIONDETALLE.NUM_UNIDA,0)) AS UNIDADESASIGNADAS ");
        // Fin LG_V400000059 - dmorello, 13/11/2007
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_DETAL ASIGNACIONDETALLE, ");
        query.append(" APE_MAPA_ZONA_DETAL MAPAZONADETALLE, ");
        query.append(" APE_MAPA_CENTR_DISTR_DETAL MAPACDDETALLE, ");
        query.append(" APE_SUBLI_ARMAD SUBLINEA ");
        query.append(" WHERE SUBLINEA.LIAR_OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
        query.append(" AND MAPAZONADETALLE.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getOidMapaZonas());
        query.append(" AND MAPAZONADETALLE.SBAR_OID_SUBL_ARMA = SUBLINEA.OID_SUBL_ARMA ");
        // LG_V400000059 - dmorello, 13/11/2007 - Agrego outer joins para recuperar zonas sin asignados
        query.append(" AND ASIGNACIONDETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE (+) = " + dtoe.getOidAsignacionProductosAnaqueles());
        query.append(" AND ASIGNACIONDETALLE.MCDD_OID_MAPA_CENT_DIST_DETA (+) = MAPACDDETALLE.OID_MAPA_CENT_DIST_DETA ");
        query.append(" AND MAPACDDETALLE.MCDC_OID_MAPA_CENT_DIST_CABE (+) = " + dtoe.getOidMapaCentroDistribucion());
        query.append(" AND MAPACDDETALLE.SBAR_OID_SUBL_ARMA = SUBLINEA.OID_SUBL_ARMA (+) ");
        /* LG_V400000059 - dmorello, 13/11/2007: En los siguientes filtros
         * cambio < y > por <= y >= para que abarque bahías desde y hasta */
        query.append(" AND TO_NUMBER(SUBSTR(MAPACDDETALLE.NUM_ANAQ (+), 2, 2)) >= MAPAZONADETALLE.NUM_BAHI_DESD ");
        query.append(" AND TO_NUMBER(SUBSTR(MAPACDDETALLE.NUM_ANAQ (+), 2, 2)) <= MAPAZONADETALLE.NUM_BAHI_HAST ");
        /* Fin LG_V400000059 - dmorello, 13/11/2007 */
        query.append(" GROUP BY SUBLINEA.OID_SUBL_ARMA, MAPAZONADETALLE.NUM_IDZO ");
        query.append(" ORDER BY SUBLINEA.OID_SUBL_ARMA, MAPAZONADETALLE.NUM_IDZO "); // dmorello, 13/11/2007
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        int cant = rs.getRowCount();
        
        for(int i=0; i<cant; i++) {
            DTOUnidadesZonasSublineas dto = new DTOUnidadesZonasSublineas();
            
            BigDecimal oidSublinea = (BigDecimal)rs.getValueAt(i, "OIDSUBLINEA");
            BigDecimal idZona = (BigDecimal)rs.getValueAt(i, "IDZONA");
            BigDecimal unidades = (BigDecimal)rs.getValueAt(i, "UNIDADESASIGNADAS");
            
            if(oidSublinea!=null) {
                dto.setOidSublinea(new Long(oidSublinea.longValue()));    
            }
            
            if(idZona!=null) {
                dto.setIdZona(new Long(idZona.longValue()));    
            }
            
            if(unidades!=null)  {
                dto.setUnidadesAsignadas(new Long(unidades.longValue()));    
            }
            
            lista.add(dto);
        }      
        
        UtilidadesLog.info("DAOBalanceoLinea.obtenerUnidadesAsignadasZonasSublineas "+
        "(DTOBalanceoLinea dtoe): Salida");
        
        return lista;    
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 22/03/2007
    */
    public ArrayList obtenerUnidadesSublineas(DTOBalanceoLinea dtoe) throws MareException {             
        UtilidadesLog.info("DAOBalanceoLinea.obtenerUnidadesSublineas"+
        "(DTOBalanceoLinea dtoe): Entrada");    
        
        ArrayList lista = new ArrayList();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT SUBLINEA.OID_SUBL_ARMA AS OIDSUBLINEA, ");
        // LG_V400000059 - dmorello, 16/11/2007: Traigo cero para sublíneas s/prod asignados
        //query.append(" SUM(ASIGNACIONDETALLE.NUM_UNIDA) AS UNIDADES ");
        query.append(" NVL ( SUM(ASIGNACIONDETALLE.NUM_UNIDA) , 0 ) AS UNIDADES ");
        // Fin LG_V400000059 - dmorello, 16/11/2007
        query.append(" FROM  APE_ASIGN_PRODU_ANAQU_DETAL ASIGNACIONDETALLE, ");
        query.append(" APE_MAPA_CENTR_DISTR_DETAL MAPACDDETALLE, ");
        query.append(" APE_SUBLI_ARMAD SUBLINEA, ");
        query.append(" V_GEN_I18N_SICC GEN ");
        // LG_V400000059 - dmorello, 16/11/2007: Agrego filtro por OID asignacion cabecera
        // Agrego también outer joins para recuperar sublíneas sin productos asignados
        query.append(" WHERE ASIGNACIONDETALLE.MCDD_OID_MAPA_CENT_DIST_DETA (+) = MAPACDDETALLE.OID_MAPA_CENT_DIST_DETA ");
        query.append(" AND ASIGNACIONDETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE (+) = ").append(dtoe.getOidAsignacionProductosAnaqueles());
        // Fin LG_V400000059 - dmorello, 16/11/2007
        query.append(" AND MAPACDDETALLE.SBAR_OID_SUBL_ARMA = SUBLINEA.OID_SUBL_ARMA ");
        query.append(" AND SUBLINEA.LIAR_OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
        query.append(" AND SUBLINEA.OID_SUBL_ARMA = GEN.VAL_OID ");
        query.append(" AND GEN.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND GEN.ATTR_ENTI = 'APE_SUBLI_ARMAD' ");
        query.append(" GROUP BY SUBLINEA.OID_SUBL_ARMA, GEN.VAL_I18N ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        int cant = rs.getRowCount();
        
        for(int i=0; i<cant; i++) {
            DTOUnidadesSublineas dto = new DTOUnidadesSublineas();
            
            BigDecimal oidSublinea = (BigDecimal)rs.getValueAt(i, "OIDSUBLINEA");
            BigDecimal unidades = (BigDecimal)rs.getValueAt(i, "UNIDADES");
            
            if(oidSublinea!=null) {
                dto.setOidSublinea(new Long(oidSublinea.longValue()));    
            }
            
            if(unidades!=null) {
                dto.setUnidades(new Long(unidades.longValue()));    
            }
            
            lista.add(dto);
        }
        
        UtilidadesLog.info("DAOBalanceoLinea.obtenerUnidadesSublineas "+
        "(DTOBalanceoLinea dtoe): Salida");
        
        return lista;    
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       28/06/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc BELC400000525
    */
  public DTOSalida obtenerProductosAsignados(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException {
      UtilidadesLog.info("DAOBalanceoLinea.obtenerProductosAsignados(DTOMantenerAsignacionProductosAnaqueles dtoe): Entrada");
      
      RecordSet rs = new RecordSet();        
      BelcorpService bs;
      DTOSalida dtoSalida = new DTOSalida();
      StringBuffer query = new StringBuffer();
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
     
      query.append(" SELECT distinct det.PROD_OID_PROD ");
      query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC cab, APE_ASIGN_PRODU_ANAQU_DETAL det ");
      query.append(" WHERE det.APAC_OID_ASIG_PROD_ANAQ_CABE = cab.OID_ASIG_PROD_ANAQ_CABE ");
      query.append(" AND cab.PERD_OID_PERI = " + dtoe.getOidPeriodo());
      query.append(" AND cab.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCentroDistribucion());
      query.append(" AND cab.IND_ACTI_FACT = 'S' ");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("rs: " + rs);
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      dtoSalida.setResultado(rs);
      
      UtilidadesLog.info("DAOBalanceoLinea.obtenerProductosAsignados(DTOMantenerAsignacionProductosAnaqueles dtoe): Salida");
      
      return dtoSalida;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       28/06/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc BELC400000525
    */
  public DTOSalida obtenerProductosMatriz(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException {
      UtilidadesLog.info("DAOBalanceoLinea.obtenerProductosMatriz(DTOMantenerAsignacionProductosAnaqueles dtoe): Entrada");
      
      RecordSet rs = new RecordSet();        
      BelcorpService bs;
      DTOSalida dtoSalida = new DTOSalida();
      StringBuffer query = new StringBuffer();
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
     
      query.append(" SELECT DISTINCT prod.OID_PROD, prod.COD_SAP, prod.DES_CORT ");
      query.append(" FROM PRE_MATRI_FACTU matri, APE_LINEA_ARMAD lin, ");
      query.append(" PRE_OFERT_DETAL oferDet, MAE_PRODU prod ");
      query.append(" WHERE prod.OID_PROD = oferDet.PROD_OID_PROD ");
      query.append(" AND oferDet.OID_DETA_OFER = matri.OFDE_OID_DETA_OFER ");
      query.append(" AND matri.FEC_ULTI_ACTU > lin.FEC_HORA_REVI_ALAR ");
      query.append(" AND lin.OID_LINE_ARMA = " + dtoe.getOidLineaArmado());
      query.append(" UNION ");
      query.append(" SELECT DISTINCT prod.OID_PROD, prod.COD_SAP, prod.DES_CORT ");
      query.append(" FROM PRE_MATRI_FACTU matri, APE_LINEA_ARMAD lin, PRE_MATRI_FACTU matriReem, ");
      query.append(" PRE_MATRI_REEMP reem, PRE_OFERT_DETAL oferDet, MAE_PRODU prod ");
      query.append(" WHERE prod.OID_PROD = oferDet.PROD_OID_PROD ");
      query.append(" AND oferDet.OID_DETA_OFER = matriReem.OFDE_OID_DETA_OFER ");
      query.append(" AND matriReem.FEC_ULTI_ACTU > lin.FEC_HORA_REVI_ALAR ");
      query.append(" AND reem.MAFA_OID_COD_REEM = matriReem.OID_MATR_FACT ");
      query.append(" AND matri.OID_MATR_FACT = reem.MAFA_OID_COD_PPAL ");
      query.append(" AND matri.FEC_ULTI_ACTU > lin.FEC_HORA_REVI_ALAR ");
      query.append(" AND lin.OID_LINE_ARMA = ").append(dtoe.getOidLineaArmado());
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("rs: " + rs);
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      dtoSalida.setResultado(rs);
      
      UtilidadesLog.info("DAOBalanceoLinea.obtenerProductosMatriz(DTOMantenerAsignacionProductosAnaqueles dtoe): Salida");
      
      return dtoSalida;
  }
}