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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;

import es.indra.sicc.dtos.ape.DTODatosLinea;
import es.indra.sicc.dtos.ape.DTOEtiqueta;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import es.indra.sicc.dtos.ape.DTOMapas;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.UtilidadesBD;

import java.util.ArrayList;

public class DAOCrearListaPicado {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOCrearListaPicado(){}


    /**
    * @throws es.indra.mare.common.exception.MareException
     * @param DTOOID
     * @autor gpons
     * @fecha 07-05-2007
     * @Descripción: Obtiene datos de la configuración del centro de 
                     distribución a partir del almacén del consolidado.     
     * CHANGELOG
     * ---------
     * 13/10/2009 - dmorello, Cambio 20090839
     *  - Se recupera del CD el nuevo flag impresion datos basicos cliente
     */
 
    public DTOConfiguracionCentroDistribucion obtenerConfiguracionCD 
        (Long oidAlmacen) throws MareException {

        UtilidadesLog.info("DAOCrearListaPicado.obtenerConfiguracionCD(DTOOID oidAlmacen) : Entrada");
    
		StringBuffer query = new StringBuffer("");	
        query.append("SELECT configuracionCD.OID_CONF_CENT_DIST, ");
        query.append("configuracionCD.VAL_TEXT_CHEQ, ");
        query.append("configuracionCD.VAL_TEXT_PRIM_PEDI, ");
        query.append("configuracionCD.ORPR_OID_ORDE_PROD, ");
        query.append("configuracionCD.ORLP_OID_ORDE_LIST_PICA, ");
        query.append("configuracionCD.IND_IMPR_DATO_BASI_CLIE ");
        
        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        query.append(", configuracionCD.AAFP_OID_AAFP_OLAS ");
        query.append(", orden_produ.COD_ORDE_PROD ");
        query.append(", orden_lista.COD_ORDE_LIST_PICA ");
        
        query.append("FROM APP_CONFI_CENTR_DISTR configuracionCD,  ");
        query.append("BEL_ALMAC almacen  ");

        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        query.append(", APE_ORDEN_PRODU orden_produ ");
        query.append(", APE_ORDEN_LISTA_PICAD  orden_lista ");
        
        query.append("WHERE configuracionCD.OID_CONF_CENT_DIST = almacen.CCDI_OID_CONFI_CENTR_DISTR " );
        query.append("AND almacen.OID_ALMA = " + oidAlmacen );

        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        query.append(" AND configuracionCD.ORPR_OID_ORDE_PROD = orden_produ.OID_ORDE_PROD ");
        query.append(" AND configuracionCD.ORLP_OID_ORDE_LIST_PICA = orden_lista.OID_ORDE_LIST_PICA ");


        RecordSet rs = new RecordSet();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError
                      (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        DTOConfiguracionCentroDistribucion dtoConfCentroDistribucion = new DTOConfiguracionCentroDistribucion();
        
        if (!rs.esVacio()) 
        {
          BigDecimal oidConfCentDist = (BigDecimal)rs.getValueAt(0, "OID_CONF_CENT_DIST");
          dtoConfCentroDistribucion.setOidCentroDistribucion(new Long(oidConfCentDist.longValue()));
          String textoChequeos = (String)rs.getValueAt(0, "VAL_TEXT_CHEQ");
          dtoConfCentroDistribucion.setTextoChequeos(textoChequeos);
          String textoPrimerPedido = (String)rs.getValueAt(0, "VAL_TEXT_PRIM_PEDI");
          dtoConfCentroDistribucion.setTextoPrimerPedido(textoPrimerPedido);
          Long indImprDatosBasicos = UtilidadesBD.convertirALong(rs.getValueAt(0, "IND_IMPR_DATO_BASI_CLIE"));
          dtoConfCentroDistribucion.setImpresionDatosbasicos(indImprDatosBasicos);
          //SB RI 20091777 ORDEN EN LISTADO DEPICADO 
          Long oidOrdenAscDesc = UtilidadesBD.convertirALong(rs.getValueAt(0, "ORPR_OID_ORDE_PROD"));
          dtoConfCentroDistribucion.setOrdenAscDesc(oidOrdenAscDesc);
          
          // sapaza -- Cambios para WCS y MUO -- 22/09/2010
          Long oidOrdenListaPicado = UtilidadesBD.convertirALong(rs.getValueAt(0, "ORLP_OID_ORDE_LIST_PICA"));
          dtoConfCentroDistribucion.setOrdenPedidoPicado(oidOrdenListaPicado);
          Long oidAgrupacionOlas = UtilidadesBD.convertirALong(rs.getValueAt(0, "AAFP_OID_AAFP_OLAS"));
          dtoConfCentroDistribucion.setAgrupacionOlas(oidAgrupacionOlas);
          String codigoOrdenAscDesc = (String)rs.getValueAt(0, "COD_ORDE_PROD");
          dtoConfCentroDistribucion.setCodigoOrdenAsDesc(codigoOrdenAscDesc);
          String codigoOrdenPedidoPicado = (String)rs.getValueAt(0, "COD_ORDE_LIST_PICA");
          dtoConfCentroDistribucion.setCodigoOrdenPedidoPicado(codigoOrdenPedidoPicado);
          
        }        
       
        UtilidadesLog.info("DAOCrearListaPicado.obtenerConfiguracionCD(DTOOID oidAlmacen) : Salida");
        return dtoConfCentroDistribucion;
    }
    
    /*
     * Modificado por dmorello - 04/07/2007
     * Por cambio en DMCO, se agrega el parámetro oidConfiguracionCD y el filtrado por el mismo
     * Nota: este cambio aparece en la incidencia BELC400000547.
     */
    public DTOMapas obtenerDatosMapa(Long oidPeriodo, Long oidIdioma, Long oidConfiguracionCD, Long oidTipoSolicitud) throws MareException {
           UtilidadesLog.info("DAOCrearListaPicado.obtenerDatosMapa(Long oidPeriodo, Long oidIdioma, Long oidConfiguracionCD, Long oidTipoSolicitud) : Entrada");    
                   

           StringBuffer query = new StringBuffer("");	
           /* dmorello, 04/07/2007
            * Por modif. en DMCO se elimina la recuperacion de datos de Mapa de Zonas
            * Nota: este cambio aparece en la incidencia BELC400000547. */
           // vbongiov -- Cambio APE-02 -- 15/11/2007
           query.append(" SELECT mapaCD.OID_MAPA_CENT_DIST_CABE, ");
           query.append("            (SELECT val_i18n ");
           query.append("               FROM v_gen_i18n_sicc ");
           query.append("              WHERE attr_enti = 'APE_MAPA_CENTR_DISTR_CABEC' ");
           query.append("              AND val_oid = mapaCD.OID_MAPA_CENT_DIST_CABE ");
           query.append("              AND idio_oid_idio = " + oidIdioma + ") DESC_MAPA_CD_CABE ");
           query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC asignacion, ");
           query.append(" APE_MAPA_CENTR_DISTR_CABEC mapaCD, ");
           query.append(" APE_MAPA_CENTR_DISTR_DETAL mcdd ");
           query.append(" WHERE asignacion.PERD_OID_PERI = " + oidPeriodo );
           query.append(" and asignacion.IND_ACTI_FACT = 'S' ");
           query.append(" and mapaCD.OID_MAPA_CENT_DIST_CABE = asignacion.MCDC_OID_MAPA_CENT_DIST_CABE");
           /* dmorello, 04/07/2007 - Se agrega este filtro por modificacion en DMCO
            * Nota: este cambio aparece en la incidencia BELC400000547. */
           query.append(" AND mapaCD.ccdi_oid_conf_cent_dist = ").append(oidConfiguracionCD);
           /* Fin dmorello 04/07/2007 */           
           query.append(" and mcdd.MCDC_OID_MAPA_CENT_DIST_CABE = mapaCD.OID_MAPA_CENT_DIST_CABE ");
           query.append(" and mcdd.SBAR_OID_SUBL_ARMA IN ( select subl.OID_SUBL_ARMA ");
           query.append("                                  from APE_TIPO_SOLIC_LINEA tsl, APE_SUBLI_ARMAD subl ");
           query.append("                                  where subl.LIAR_OID_LINE_ARMA = tsl.LIAR_OID_LINE_ARMA ");
           query.append("                                  and tsl.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSolicitud + ") ");
    
           RecordSet rs = new RecordSet();
           BelcorpService bs;

           try {
                bs = BelcorpService.getInstance();
           } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError
                          (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           }

           try {
                rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }

           DTOMapas dtoMapas = new DTOMapas();
        
           if (!rs.esVacio()) {
              BigDecimal oidConfCentDist = (BigDecimal)rs.getValueAt(0, "OID_MAPA_CENT_DIST_CABE");
              dtoMapas.setOidMapaCD(new Long(oidConfCentDist.longValue()));
              
              /* BELC400000547 - dmorello, 04/07/2007 */
              //BigDecimal oidMapaZona = (BigDecimal)rs.getValueAt(0, "OID_MAPA_ZONA_CABE");
              //dtoMapas.setOidMapaZonas(new Long(oidMapaZona.longValue()));

              String descripcionMapaCD = (String)rs.getValueAt(0, "DESC_MAPA_CD_CABE");
              dtoMapas.setDescripcionMapaCD(descripcionMapaCD);

              /* BELC400000547 - dmorello, 04/07/2007 */
              //String descripcionMapaZona = (String)rs.getValueAt(0, "DESC_MAPA_ZONA_CABE");
              //dtoMapas.setOidDescripcionMapaZonas(descripcionMapaZona);
           }
        
           UtilidadesLog.info("DAOCrearListaPicado.obtenerDatosMapa(Long oidPeriodo, Long oidIdioma, Long oidConfiguracionCD, Long oidTipoSolicitud) : Salida");    
           return dtoMapas;
                
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080528 - dmorello, 08/10/2008
     *    - Se agrega filtro por Indicador Linea AFP = NO
     * dmorello, 15/10/2008
     *    - Se modifica query para obtener (para cada linea) su asignacion prod anaquel activa
     *      para el periodo y mapa de zonas correspondiente a la linea.
     *    - Se modifica firma, pasa a recibir OID CD, OID tipo solicitud, OID periodo, OID idioma
     * sapaza, 22/09/2010
     *    - Se esta redifiniendo la funcionalidad del metodo, de acuerdo a los cambios para WCS y MUO
     */
    public DTODatosLinea obtenerDatosLinea(Long oidCD, Long oidTipoSolicitud, Long oidPeriodo, Long oidIdioma, Long oidConsolidado, Long oidAgrupOlas) throws MareException {
        UtilidadesLog.info("DAOCrearListaPicado.obtenerDatosLinea(Long oidMapaCD, Long oidTipoSolicitud, Long oidIdioma, Long oidConsolidado, Long oidAgrupOlas) : Entrada");        
        DTODatosLinea dtoDatosLinea = null;        
        
        ArrayList arrayParametros = new ArrayList();
        arrayParametros.add(oidTipoSolicitud);
        arrayParametros.add(oidConsolidado);
        arrayParametros.add(oidCD);
        arrayParametros.add(oidAgrupOlas);
        
        String lineaArmado = null;
        try {       
          lineaArmado = BelcorpService.getInstance().dbService.ExecuteFunction("APE_FN_OBTEN_LINEA_ARMAD", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          //throw new MareException(e);
        }
        UtilidadesLog.debug("lineaArmado: " + lineaArmado);
        
        Long oidLineaArmado = null;
        if(lineaArmado != null) {
            oidLineaArmado = new Long(lineaArmado);
        }
        
        StringBuffer query = new StringBuffer();
        query.append(" SELECT lin.oid_line_arma, ");
        query.append("        pq_apl_aux.valor_gen_i18n_sicc (").append(oidIdioma);
        query.append("                 , lin.oid_line_arma, 'APE_LINEA_ARMAD') AS desc_line_arma, ");
        query.append("        lin.sicj_oid_prog_cubi, ");
        query.append("        datos_asign.oid_asig_prod_anaq_cabe, ");
        query.append(" 	      datos_asign.mcdc_oid_mapa_cent_dist_cabe ");
        query.append("   FROM ape_linea_armad lin, ");
        query.append("        (SELECT DISTINCT subl.liar_oid_line_arma, ");
        query.append("                asign.mcdc_oid_mapa_cent_dist_cabe, ");
        query.append(" 	              asign.oid_asig_prod_anaq_cabe ");
        query.append("           FROM ape_asign_produ_anaqu_cabec asign, ");
        query.append("                ape_mapa_zona_detal mzd, ");
        query.append("                ape_subli_armad subl ");
        query.append("          WHERE asign.mzca_oid_mapa_zona_cabe = mzd.mzca_oid_mapa_zona_cabe ");
        query.append("            AND mzd.sbar_oid_subl_arma = subl.oid_subl_arma ");
        query.append("            AND asign.perd_oid_peri = ").append(oidPeriodo);
        query.append("            AND asign.ind_acti_fact = 'S') datos_asign ");
        query.append("  WHERE lin.ccdi_oid_conf_cent_dist = ").append(oidCD);
        query.append("    AND lin.NUM_LINE_AFP = 0 ");
        query.append("    AND lin.oid_line_arma = ").append(oidLineaArmado);
        query.append("    AND lin.oid_line_arma = datos_asign.liar_oid_line_arma (+) ");
        query.append(" ORDER BY oid_asig_prod_anaq_cabe NULLS LAST ");
        
        RecordSet rs = new RecordSet();
        
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if(log.isDebugEnabled())
          UtilidadesLog.debug("--- rs: " + rs);
        
        if (!rs.esVacio()) {
            Object oidAsignacion = rs.getValueAt(0, "OID_ASIG_PROD_ANAQ_CABE");
            dtoDatosLinea = new DTODatosLinea();
            if (oidAsignacion != null) {
                String descripcion = (String)rs.getValueAt(0, "DESC_LINE_ARMA");
                BigDecimal oidProgramaCubicaje = (BigDecimal)rs.getValueAt(0, "SICJ_OID_PROG_CUBI");
                BigDecimal oidMapaCD = (BigDecimal)rs.getValueAt(0, "MCDC_OID_MAPA_CENT_DIST_CABE");
                
                dtoDatosLinea.setOidLinea(oidLineaArmado);
                dtoDatosLinea.setDescripcionLinea(descripcion);
                dtoDatosLinea.setOidProgramaCubicaje(new Long(oidProgramaCubicaje.longValue())); 
                if (oidMapaCD != null) {
                    dtoDatosLinea.setOidMapaCD(new Long(oidMapaCD.longValue()));
                }
            }
        }        
        else {
            UtilidadesLog.debug("*** El Tipo solicitud no tiene asociada alguna de las lineas del MapaCD.");
        }
        
        UtilidadesLog.info("DAOCrearListaPicado.obtenerDatosLinea(Long oidMapaCD, Long oidTipoSolicitud, Long oidIdioma, Long oidConsolidado, Long oidAgrupOlas) : Salida");            
        return dtoDatosLinea;
    }
    
    public DTOSalida obtenerCodigosProductos (Enumeration listaOIDs) throws MareException {
           UtilidadesLog.info("DAOCrearListaPicado.obtenerCodigosProductos(Enumeration listaOIDs) : Entrada");                
    /*
    SELECT produ.OID_PROD, produ.COD_SAP
    FROM MAE_PRODU produ
    WHERE  produ.OID_PROD IN (listaOIDs) 
    */
        StringBuffer query = new StringBuffer("");	
        query.append("SELECT produ.OID_PROD, produ.COD_SAP ");
        query.append("FROM MAE_PRODU produ ");
        query.append("WHERE  produ.OID_PROD IN (" );     

        while (listaOIDs.hasMoreElements()){
               query.append((Long)listaOIDs.nextElement());
               query.append(",");
        }
        query.deleteCharAt(query.length()-1);
        query.append(" )");
        
         RecordSet rs = new RecordSet();
         BelcorpService bs;

         try {
                bs = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError
                          (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }

         try {
                rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }  
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodigosProductos(Enumeration listaOIDs) : Salida");                

        return dtoSalida;
    }
    
   /**
    * 
    * @observaciones
    *  13/08/2007 - eiraola - Se corrige la consulta pues no estaba hecha de acuerdo
    *                         a lo definido en el DMCO.
    */
    public Boolean verificarPrimerPedidoCliente(Long oidCliente) throws MareException{
       UtilidadesLog.info("DAOCrearListaPicado.verificarPrimerPedidoCliente(Long oidCliente) : Entrada");                

                        /*
                        SELECT clienteDatosBásicos.OID_CLIE_DATO_ADIC
                        FROM MAE_CLIEN_DATOS_ADICI clienteDatosBasicos 
                        WHERE clienteDatosBasicos.OID_CLIE_DATO_ADIC = oidCliente 
                        clienteDatosBasicos.ESTA_OID_ESTA_CLIE = ConstantesMAE.OID_ESTATUS_NUEVA 
                         * */
        StringBuffer query = new StringBuffer("");	
        // Eliminado - eiraola - 13/08/2007 [inicio]
        //query.append("SELECT clienteDatosBasicos.OID_CLIE_DATO_ADIC ");
        //query.append("FROM MAE_CLIEN_DATOS_ADICI clienteDatosBasicos ");
        //query.append("WHERE clienteDatosBasicos.OID_CLIE_DATO_ADIC = " + oidCliente);
        //query.append(" AND clienteDatosBasicos.ESTA_OID_ESTA_CLIE = " + ConstantesMAE.OID_ESTATUS_NUEVA );
        // Eliminado - eiraola - 13/08/2007 [fin]
        
        // Agregado - eiraola - 13/08/2007 [inicio]
        query.append("SELECT OID_CLIE_DATO_ADIC ");
        query.append("  FROM MAE_CLIEN_DATOS_ADICI ");
        query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
        query.append("   AND ESTA_OID_ESTA_CLIE = " + ConstantesMAE.OID_ESTATUS_NUEVA);
        // Agregado - eiraola - 13/08/2007 [fin]
        
         RecordSet rs = new RecordSet();
         BelcorpService bs;

         try {
                bs = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError
                          (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }

         try {
                rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }  
            
         UtilidadesLog.info("DAOCrearListaPicado.verificarPrimerPedidoCliente(Long oidCliente) : Salida");                       

         // Si se recupera al menos un registro devolver true, false en otro caso
         if (!rs.esVacio()) {
             //return  Boolean.FALSE; // eiraola 13/08/2007
             return  Boolean.TRUE;
         } else {
             //return Boolean.TRUE; // eiraola 13/08/2007
             return Boolean.FALSE;
         }
    } 

    public String obtenerAnaq(Long oidMapaCDDetalle) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerAnaq(Long oidMapaCDDetalle) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        query.append("SELECT num_anaq ");
        query.append("FROM APE_MAPA_CENTR_DISTR_DETAL ");
        query.append("WHERE OID_MAPA_CENT_DIST_DETA = " + oidMapaCDDetalle);

        RecordSet rs = new RecordSet();
        BelcorpService bs;

        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        resu = ((String)rs.getValueAt(0, "NUM_ANAQ")).trim();
        UtilidadesLog.info("DAOCrearListaPicado.obtenerAnaq(Long oidMapaCDDetalle) : Salida");                       
        return resu;
    }
    
    public String obtenerDescProd(Long oidProd, Long oidIdioma) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerDescProd(Long oidProd) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        query.append("SELECT PQ_APL_AUX.Valor_Gen_I18n_Sicc(").append(oidIdioma).append(", OID_PROD, 'MAE_PRODU') DES_CORT ");
        query.append("FROM MAE_PRODU ");
        query.append("WHERE OID_PROD = " + oidProd);

        RecordSet rs = new RecordSet();
        BelcorpService bs;

        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        Object desCort = rs.getValueAt(0, "DES_CORT"); 
        if (desCort != null) {
        
          if (desCort.toString().length() > 40) {
              resu = desCort.toString().substring(0, 40);
          }else{
              resu = desCort.toString().trim();
          }
        } else {
          resu = "  ";
        }
        UtilidadesLog.info("DAOCrearListaPicado.obtenerDescProd(Long oidProd) : Salida");                       
        return resu;
    }

    public String obtenerCodigoTerritorial(long oidSoliCabe) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodigoTerritorial(Long oidRe, Long oidZo, Long oidSecc) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        
        query.append("SELECT zr.COD_REGI||zz.COD_ZONA||zs.COD_SECC||cod_terr AS ct ");
        query.append("FROM ZON_TERRI zt, ZON_TERRI_ADMIN zta, PED_SOLIC_CABEC psc, ZON_SECCI zs, ZON_ZONA zz, ZON_REGIO zr ");
        query.append("WHERE psc.oid_soli_cabe = " + oidSoliCabe);
        query.append("AND psc.ZTAD_OID_TERR_ADMI = zta.OID_TERR_ADMI ");
        query.append("AND zta.TERR_OID_TERR = zt.OID_TERR ");
        query.append("AND zta.ZSCC_OID_SECC = zs.OID_SECC ");
        query.append("AND zs.ZZON_OID_ZONA = zz.OID_ZONA "); 
        query.append("AND zz.ZORG_OID_REGI = zr.OID_REGI ");       

        RecordSet rs = new RecordSet();
        BelcorpService bs;

        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        resu = rs.getValueAt(0, "CT").toString();
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodigoTerritorial(Long oidRe, Long oidZo, Long oidSecc) : Salida");                       
        return resu;
    }
 
    public String obtenerDescrLiArm(long oidLinea, long oidIdioma) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerDescrLiArm(long oidLinea) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        
        query.append("SELECT val_i18n AS DESC_LA ");
        query.append("FROM v_gen_i18n_sicc ");
        query.append("WHERE attr_enti = 'APE_LINEA_ARMAD' ");
        query.append("AND val_oid = " + oidLinea);
        query.append(" AND idio_oid_idio = " + oidIdioma);
        
        RecordSet rs = new RecordSet();
        BelcorpService bs;
    
        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        
        resu = ((String)rs.getValueAt(0, "DESC_LA")).trim();
        UtilidadesLog.info("DAOCrearListaPicado.obtenerDescrLiArm(long oidLinea) : Salida");                       
        return resu;
    
   }
   
   public String obtenerCogConsult(long oidClie) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCogConsult(long oidClie) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        
        query.append("SELECT cl.COD_CLIE AS CODE ");
        query.append("FROM MAE_CLIEN cl ");
        query.append("WHERE OID_CLIE = ").append(oidClie);

        RecordSet rs = new RecordSet();
        BelcorpService bs;
    
        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        
        resu = ((String)rs.getValueAt(0, "CODE")).trim();
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCogConsult(long oidClie) : Salida");                       
        return resu;
    
   }

   public String obtenerNombrComplConsult(long oidClie) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerNombrComplConsult(long oidClie) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        
        query.append("SELECT CL.VAL_NOM1 || ' ' || CL.VAL_NOM2 || ' ' || CL.VAL_APE1 || ' ' || CL.VAL_APE2 AS NOMBRE_APELLIDOS ");
        query.append("FROM MAE_CLIEN cl ");
        query.append("WHERE OID_CLIE = ").append(oidClie);

        RecordSet rs = new RecordSet();
        BelcorpService bs;
    
        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        
        resu = ((String)rs.getValueAt(0, "NOMBRE_APELLIDOS")).trim();
        UtilidadesLog.info("DAOCrearListaPicado.obtenerNombrComplConsult(long oidClie) : Salida");                       
        return resu;
    
   }
   
    public String obtenerCodPeri(long oidPeri) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodPeri(long oidPeri) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        
        query.append("SELECT spc.cod_peri as cp ");
        query.append("FROM seg_perio_corpo spc, CRA_PERIO crap ");
        query.append("WHERE crap.oid_peri = " + oidPeri);
        query.append(" AND crap.peri_oid_peri = spc.oid_peri");
        
        RecordSet rs = new RecordSet();
        BelcorpService bs;
    
        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        
        resu = ((String)rs.getValueAt(0, "CP")).trim();
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodPeri(long oidPeri) : Salida");                
        return resu;
    }    

    public String obtenerCodBar(long oidSoliCabe) throws MareException{
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodBar(long oidSoliCabe) : Entrada");                
        StringBuffer query = new StringBuffer("");	
        String resu = new String();
        
        query.append("SELECT psc.val_nume_soli as codbar ");
        query.append("FROM PED_SOLIC_CABEC psc ");
        query.append("WHERE psc.oid_soli_cabe = " + oidSoliCabe);

        RecordSet rs = new RecordSet();
        BelcorpService bs;
    
        try {
               bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError
                         (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
               UtilidadesLog.error("ERROR ", ex);
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        
        resu = rs.getValueAt(0, "CODBAR").toString().trim();
        
        if( resu.length() > 8 ){    
                UtilidadesLog.debug("es mayor q' 8!!: " + resu);
                UtilidadesLog.debug("retorno: " + resu.substring((resu.length()-8), resu.length()));
                return resu.substring((resu.length()-8), resu.length()); // Pasar sólo los últimos 8 caracteres 
        }
        UtilidadesLog.info("DAOCrearListaPicado.obtenerCodBar(long oidSoliCabe) : Salida");                
        return resu;
    } 
    public void procesoEmbalajeTerminado(DTOEtiqueta dtoe ,String usuario) throws MareException
    {
        UtilidadesLog.info("DAOCrearListaPicado.proceso(DTOEtiqueta dtoe): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        StringBuffer queryActualizacion = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();
        String codigoError;
        String indicadorCheque = null;
        Date fechaHoraFinEmbalaje;
        String nombreFacturador = null;
        Long oidEtiqueta;
        Long oidApeListaPicaCabe;
        try
        {
          bs = BelcorpService.getInstance();
        }catch(MareMiiServiceNotFoundException ex)
        {
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" select ape_etiqu.OID_ETIQ, ape_etiqu.NUM_ETIQ, ape_lista_picad_cabec.IND_ORIG_CHEQ, ape_etiqu.LPCA_OID_LIST_PICA_CABE, ");
        query.append("  ape_lista_picad_cabec.FEC_HORA_FINA_EMBA, ape_lista_picad_cabec.VAL_NOMB_FACT ");
        query.append("  from ape_etiqu, ped_solic_cabec, ape_lista_picad_cabec  ");
        query.append(" where  ape_etiqu.PAIS_OID_PAIS = " + dtoe.getOidPais() );
        query.append(" and ape_etiqu.SOCA_OID_SOLI_CABE =  ped_solic_cabec.OID_SOLI_CABE  and ");
        query.append(" ped_solic_cabec.VAL_NUME_SOLI = " + dtoe.getSolicitudCabecera());
        query.append(" and ape_etiqu.NUM_CAJA = " + dtoe.getNumeroCaja());
        query.append(" and ape_etiqu.LPCA_OID_LIST_PICA_CABE = ape_lista_picad_cabec.OID_LIST_PICA_CABE");
        try{
               rs = bs.dbService.executeStaticQuery(query.toString());
           
        } catch (Exception ex) {
       
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
          indicadorCheque =(String) rs.getValueAt(0, "IND_ORIG_CHEQ");
          oidEtiqueta = (Long.valueOf(((BigDecimal) rs.getValueAt(0, "OID_ETIQ")).toString())); 
          if(indicadorCheque != null )
          {  
             queryActualizacion = new StringBuffer();
             queryActualizacion.append("UPDATE APE_ETIQU ");
             queryActualizacion.append("  SET ESTP_OID_ESTA_PEDI = " + ConstantesAPE.OID_ESTADO_PEDIDO_EMBALADO );
             queryActualizacion.append(" WHERE OID_ETIQ = " + oidEtiqueta);
             try
             {
                bs.dbService.executeUpdate(queryActualizacion.toString());
             }catch(Exception ex)
             {
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
             }
          }else if(indicadorCheque == null)
          {
            queryActualizacion = new StringBuffer();
            queryActualizacion.append(" UPDATE  APE_ETIQU ");
            queryActualizacion.append(" SET  ESTP_OID_ESTA_PEDI = " + ConstantesAPE.OID_ESTADO_PEDIDO_TERMINADO);
            queryActualizacion.append(" WHERE OID_ETIQ = " + oidEtiqueta);
            try
             {   UtilidadesLog.debug("query 1: " +queryActualizacion.toString());
                bs.dbService.executeUpdate(queryActualizacion.toString());
             }catch(Exception ex)
             {  ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
             }
          }
          UtilidadesLog.debug("1");
          fechaHoraFinEmbalaje = (Date) rs.getValueAt(0, "FEC_HORA_FINA_EMBA" );
          oidApeListaPicaCabe = (Long.valueOf(((BigDecimal) rs.getValueAt(0, "LPCA_OID_LIST_PICA_CABE")).toString())); 
          UtilidadesLog.debug("2");
          if(fechaHoraFinEmbalaje == null )
          {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            StringBuffer update = new StringBuffer();
            update.append("UPDATE ape_lista_picad_cabec ");
            update.append("SET FEC_HORA_FINA_EMBA = ");
            update.append("TO_DATE('").append(sdf.format(date)).append("','DD/MM/YYYY HH24:MI:SS') ");
            update.append("WHERE oid_list_pica_cabe = ").append(oidApeListaPicaCabe);
           try
            {
              bs.dbService.executeUpdate(update.toString());
            }catch(Exception ex)
            {
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
          }                             
          nombreFacturador = (String) rs.getValueAt(0,"VAL_NOMB_FACT");
          if(nombreFacturador == null)
          {
            queryActualizacion = new StringBuffer();
            queryActualizacion.append(" UPDATE ape_lista_picad_cabec ");
            queryActualizacion.append(" SET VAL_NOMB_FACT = '" + usuario + "'");
            queryActualizacion.append(" WHERE OID_LIST_PICA_CABE = " + oidApeListaPicaCabe);
            try
            { UtilidadesLog.debug("query 2: " +queryActualizacion.toString());
              bs.dbService.executeUpdate(queryActualizacion.toString());
            }catch(Exception ex)
            {  ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
          }                                  
        }else
        {
          ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                           ErroresDeNegocio.APE_0939));
          ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
          ex.addParameter(dtoe.getCodigoImpresora());
          throw ex;                                  
         }
        
    }
    
    /**
     * Cambio RI 20080528
     * Elimina todos los registros de la tabla APE_ANAQU_POST_VENTA
     * @author dmorello
     * @since 08-oct-2008
     */
    public void eliminarAnaquelesPostVenta(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOCrearListaPicado.eliminarAnaquelesPostVenta(DTOBelcorp dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer delete = new StringBuffer();
        delete.append("DELETE FROM ape_anaqu_post_venta");
        
        try {
            bs.dbService.executeUpdate(delete.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCrearListaPicado.eliminarAnaquelesPostVenta(DTOBelcorp dtoe): Entrada");
    }
    
    /**
     * Cambio 20090839
     * Cambios para WCS y MUO -- 22/09/2010
     * 
     * Obtiene el valor del campo "longitud numero etiqueta" de la linea de armado
     * cuyo OID recibe por parametro.
     * @author dmorello
     * @since 06-10-2009
     */
    public Integer obtenerLongitudNumeroEtiqueta(Long oidLineaArmado) throws MareException {
        UtilidadesLog.info("DAOCrearListaPicado.obtenerLongitudNumeroEtiqueta(Long oidLineaArmado): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT con.num_long_etiq FROM ape_linea_armad lin, app_confi_centr_distr con ");
        query.append("  WHERE con.oid_conf_cent_dist = lin.ccdi_oid_conf_cent_dist ");
        query.append("    AND lin.oid_line_arma = " + oidLineaArmado);
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Integer longitud = null;
        if (rs != null && ! rs.esVacio()) {
            longitud = UtilidadesBD.convertirAInteger(rs.getValueAt(0,0));
        }
        
        UtilidadesLog.info("DAOCrearListaPicado.obtenerLongitudNumeroEtiqueta(Long oidLineaArmado): Salida");
        return longitud;
    }

    /**
     * Cambio RI 20091777
     * Obtiene el valor del campo "codigo orden producto"
     * cuyo OID recibe por parametro.
     * @author dmorello
     * @since 06-10-2009
     */    
    public String obtenerCodigoOrdenAscDescProd(long oidOrdenProducto) throws MareException{
         UtilidadesLog.info("DAOCrearListaPicado.obtenerCodigoOrdenAscDescProd(long oidOrdenProducto) : Entrada");                
         StringBuffer query = new StringBuffer("");      
         String resu = new String();
         
         query.append("SELECT COD_ORDE_PROD AS CODE ");
         query.append("FROM APE_ORDEN_PRODU  ");
         query.append("WHERE OID_ORDE_PROD = ").append(oidOrdenProducto);

         RecordSet rs = new RecordSet();
         BelcorpService bs;
     
         try {
                bs = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError
                          (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
     
         try {
                rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }  
         
         resu = ((String)rs.getValueAt(0, "CODE")).trim();
         UtilidadesLog.info("DAOCrearListaPicado.obtenerCodigoOrdenAscDescProd(long oidOrdenProducto) : Salida");                       
         return resu;
     
    }
    
    
    /**
    * @throws es.indra.mare.common.exception.MareException
     * @param DTOOID
     * @autor gpons
     * @fecha 07-05-2007
     * @Descripción: Obtiene datos de la configuración del centro de 
                     distribución a partir del almacén del consolidado.     
     *
     *  - Se recupera del CD el nuevo flag impresion datos basicos cliente
     */
    
    public DTOConfiguracionCentroDistribucion obtenerByIdConfiguracionCD 
        (Long oidCentroDistribucion) throws MareException {

        UtilidadesLog.info("DAOCrearListaPicado.obtenerByIdConfiguracionCD(DTOOID oidCentroDistribucion) : Entrada");
    
                StringBuffer query = new StringBuffer("");      
        query.append("SELECT configuracionCD.OID_CONF_CENT_DIST, ");
        query.append("configuracionCD.VAL_TEXT_CHEQ, ");
        query.append("configuracionCD.VAL_TEXT_PRIM_PEDI, ");
        query.append("configuracionCD.ORPR_OID_ORDE_PROD, ");
        query.append("configuracionCD.ORLP_OID_ORDE_LIST_PICA, ");
        query.append("configuracionCD.IND_IMPR_DATO_BASI_CLIE ");
        query.append("FROM APP_CONFI_CENTR_DISTR configuracionCD,  ");
        query.append("BEL_ALMAC almacen  ");
        query.append("WHERE configuracionCD.OID_CONF_CENT_DIST = almacen.CCDI_OID_CONFI_CENTR_DISTR " );
        query.append("AND configuracionCD.OID_CONF_CENT_DIST = " + oidCentroDistribucion );

        RecordSet rs = new RecordSet();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError
                      (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        DTOConfiguracionCentroDistribucion dtoConfCentroDistribucion = new DTOConfiguracionCentroDistribucion();
        
        if (!rs.esVacio()) 
        {
          BigDecimal oidConfCentDist = (BigDecimal)rs.getValueAt(0, "OID_CONF_CENT_DIST");
          dtoConfCentroDistribucion.setOidCentroDistribucion(new Long(oidConfCentDist.longValue()));
          String textoChequeos = (String)rs.getValueAt(0, "VAL_TEXT_CHEQ");
          dtoConfCentroDistribucion.setTextoChequeos(textoChequeos);
          String textoPrimerPedido = (String)rs.getValueAt(0, "VAL_TEXT_PRIM_PEDI");
          dtoConfCentroDistribucion.setTextoPrimerPedido(textoPrimerPedido);
          Long indImprDatosBasicos = UtilidadesBD.convertirALong(rs.getValueAt(0, "IND_IMPR_DATO_BASI_CLIE"));
          dtoConfCentroDistribucion.setImpresionDatosbasicos(indImprDatosBasicos);
          //SB RI 20091777 ORDEN EN LISTADO DEPICADO 
          Long oidOrdenAscDesc = UtilidadesBD.convertirALong(rs.getValueAt(0, "ORPR_OID_ORDE_PROD"));
          dtoConfCentroDistribucion.setOrdenAscDesc(oidOrdenAscDesc);
          //
        }        
       
        UtilidadesLog.info("DAOCrearListaPicado.obtenerByIdConfiguracionCD(DTOOID oidCentroDistribucion) : Salida");
        return dtoConfCentroDistribucion;
    }
    
    
    public String obtenerNombrComplConsultByCodigo(String codClie) throws MareException{
         UtilidadesLog.info("DAOCrearListaPicado.obtenerNombrComplConsultByCodigo(String oidClie) : Entrada");                
         StringBuffer query = new StringBuffer("");      
         String resu = new String();
         
         query.append("SELECT CL.VAL_NOM1 || ' ' || CL.VAL_NOM2 || ' ' || CL.VAL_APE1 || ' ' || CL.VAL_APE2 AS NOMBRE_APELLIDOS ");
         query.append("FROM MAE_CLIEN cl ");
         query.append("WHERE COD_CLIE = '").append(codClie).append("'");

         RecordSet rs = new RecordSet();
         BelcorpService bs;
     
         try {
                bs = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError
                          (CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
     
         try {
                rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }  
         
         resu = ((String)rs.getValueAt(0, "NOMBRE_APELLIDOS")).trim();
         UtilidadesLog.info("DAOCrearListaPicado.obtenerNombrComplConsultByCodigo(String oidClie) : Salida");                       
         return resu;
     
    }
    
}