/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelDetalle;
import es.indra.sicc.dtos.ape.DTOCalcularHit;
import es.indra.sicc.dtos.ape.DTODesasignarProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.entidades.ape.EstimadosProductoLocal;
import es.indra.sicc.entidades.ape.EstimadosProductoLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOMantenerEstimadosProducto;
import es.indra.sicc.logicanegocio.rec.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAOAsignacionProductos 
{
   
    /** 
    * Autor: Guido Pons
    * Fecha: 09-01-2007
    * Descripcion: Recupera los valores de la Entidad APE:Procedencia 
    * @param dtoE DTOBelcorp 
    * @return DTOSalida el resultado de la busqueda
    * @exception MareException 
    */
    public DTOSalida obtenerProcedencia (DTOBelcorp dtoE) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionProductos.obtenerProcedencia(DTOBelcorp dtoE): Entrada");
    
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT APE_PROCE.OID_PROC, gen.val_i18n ");
        query.append("   FROM APE_PROCE, v_gen_i18n_sicc gen ");
        query.append("  WHERE APE_PROCE.OID_PROC = gen.val_oid ");
        query.append("    AND gen.attr_enti = 'APE_PROCE' ");
        query.append("    AND gen.idio_oid_idio = ").append(dtoE.getOidIdioma());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error("Exception en DAOAsignacionProductos.obtenerProcedencia: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOAsignacionProductos.obtenerProcedencia(DTOBelcorp dtoE): Salida");
        return dtoSalida;
    }
   
    
    /** 
    * Autor: Guido Pons
    * Fecha: 09-01-2007
    * Descripcion: retorna los valores correspondientes a los parametros de busqueda 
    * @param dtoE DTOMantenerEstimadosProducto 
    * @return DTOSalida el resultado de la busqueda
    * @exception MareException 
    */     
    public DTOSalida consultarEstimadosProducto (DTOMantenerEstimadosProducto dtoE) throws MareException {
         UtilidadesLog.info("DAOAsignacionProductos.consultarEstimadosProducto(DTOMantenerEstimadosProducto dtoE): Entrada");           

         StringBuffer sql = new StringBuffer();
         Vector parametros = new Vector();         

         sql.append(" SELECT ep.oid_esti_prod AS OID, ccd.OID_CONF_CENT_DIST, ");
         sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
         sql.append(" IDIO.attr_enti = 'APP_CONFI_CENTR_DISTR' AND IDIO.idio_oid_idio = ").append(dtoE.getOidIdioma());
         sql.append(" AND IDIO.val_oid = ccd.OID_CONF_CENT_DIST) as DESC_CENT_DIST,");
         sql.append(" la.OID_LINE_ARMA, (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
         sql.append(" IDIO.attr_enti = 'APE_LINEA_ARMAD' AND IDIO.idio_oid_idio = ").append(dtoE.getOidIdioma());           
         sql.append(" AND IDIO.val_oid = la.OID_LINE_ARMA) as DESC_LINEA_ARMADO,");
         sql.append(" marca.OID_MARC, marca.DES_MARC,");
         sql.append(" canal.OID_CANA, (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
         sql.append(" IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ").append(dtoE.getOidIdioma());           
         sql.append(" AND IDIO.val_oid = canal.OID_CANA) as DESC_CANAL,");
         sql.append(" perio.OID_PERI, perio.VAL_NOMB_PERI, mae_produ.COD_SAP, V_GEN_I18N_SICC.VAL_I18N, ");
         sql.append(" ep.num_unid_esti,  ep.ind_fuer_pedi");
         sql.append(" , ep.PRCE_OID_PROC "); // Agregado - 05/11/2007 - eiraola - LG_V400000056
         sql.append(" FROM ape_estim_produ ep,");
         sql.append(" mae_produ,");
         sql.append(" ape_linea_armad la,");
         sql.append(" app_confi_centr_distr ccd, ");
         sql.append(" ape_proce, ");
         sql.append(" seg_marca marca, ");
         sql.append(" cra_perio perio, ");
         sql.append(" seg_canal canal, ");
         sql.append(" v_gen_i18n_sicc ");
         sql.append(" WHERE ep.PROD_OID_PROD = mae_produ.OID_PROD ");
         /*if(dtoE.getCodigoProducto()!= null){
             sql.append("   AND MAE_PRODU.COD_SAP >= '" + dtoE.getCodigoProducto() + "' ");
         }*/
          sql.append("  AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_PRODU' ");
          sql.append("  AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
          sql.append("  AND V_GEN_I18N_SICC.VAL_OID = MAE_PRODU.OID_PROD ");
          
         // vbongiov -- Cambio 20090839 -- 17/11/2009
         if(dtoE.getDesProducto() != null){      
            sql.append("  AND (V_GEN_I18N_SICC.VAL_I18N like  '" + dtoE.getDesProducto() + "%'");                                           
            sql.append("   OR V_GEN_I18N_SICC.VAL_I18N >=  '" + dtoE.getDesProducto()+"')");                                            
         }
          
         sql.append(" AND ep.LIAR_OID_LINE_ARMA = la.OID_LINE_ARMA ");
         sql.append(" AND ep.PERD_OID_PERI = perio.OID_PERI ");   
         sql.append(" AND ep.PRCE_OID_PROC = ape_proce.OID_proc ");
         sql.append(" AND la.CCDI_OID_CONF_CENT_DIST = ccd.OID_CONF_CENT_DIST ");
         /* dmorello, 26/06/2007: Join incorrecto, se reemplaza... */
         //sql.append(" AND mae_produ.MAPR_OID_MARC_PROD = marca.OID_MARC ");
         sql.append(" AND perio.MARC_OID_MARC = marca.OID_MARC ");
         /* Fin dmorello 26/06/2007 */
         sql.append(" AND perio.CANA_OID_CANA = canal.OID_CANA ");
         
         if (dtoE.getOidCentroDistribucion() != null) {
            sql.append(" AND ccd.OID_CONF_CENT_DIST =  " + dtoE.getOidCentroDistribucion());
         
         }
         if (dtoE.getOidLineaArmado() != null) {
            sql.append(" AND la.OID_LINE_ARMA =  " + dtoE.getOidLineaArmado());
            
         }
         if (dtoE.getOidMarca() != null) {
            sql.append(" AND marca.OID_MARC =  " + dtoE.getOidMarca());
            
         }
         if (dtoE.getOidCanal() != null) {
            sql.append(" AND canal.OID_CANA =  " + dtoE.getOidCanal());
            
         }
         if (dtoE.getOidPeriodo() != null) {
            sql.append(" AND perio.OID_PERI = " + dtoE.getOidPeriodo());
            
         }
         if (dtoE.getCodigoProducto() != null) {
            sql.append(" AND mae_produ.COD_SAP >=  " + dtoE.getCodigoProducto());
            
         }
         int indicador;
         
         if (dtoE.getFueraPedido() != null) {
            if(dtoE.getFueraPedido().booleanValue() ){
                indicador = 1;
            }else{
                indicador = 0;
            }
            sql.append(" AND ep.IND_FUER_PEDI =  " + indicador);                    
         }
         
        // vbongiov -- Cambio 20090839 -- 17/11/2009
        //sbuchelli la priorida lo tine el codigo d eproducto
        if(dtoE.getCodigoProducto() != null ){     
           sql.append(" ORDER BY mae_produ.cod_sap ASC ");
        } else {
            sql.append(" ORDER BY val_i18n ");
        }
        
         UtilidadesLog.info("dtoE: " + dtoE);
         
         String sqlPag = UtilidadesPaginacion.armarQueryPaginacionEspecial(sql.toString(), dtoE);
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         RecordSet rs = null;
         String codigoError = null;

         try {
              rs = bs.dbService.executeStaticQuery(sqlPag);
         } catch (Exception e) {
               codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                //this.logError("obtenerSolicitudesCupon: Exception", e);
                //this.logSql("obtenerSolicitudesCupon. SQL: ", sql.toString(), parametros);
               throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }
         if (rs.esVacio()) {
             UtilidadesLog.debug("****consultarEstimadosProducto: no hay datos ");
             codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(codigoError));
         }
    
         DTOSalida dtoSalida = new DTOSalida();
         dtoSalida.setResultado(rs);
         
         UtilidadesLog.info("DAOAsignacionProductos.consultarEstimadosProducto(DTOMantenerEstimadosProducto dtoE): Salida");                      
         return dtoSalida;
    }
    
    /*
    Descripcion: recupera el registro donde se debe guardar la configuracion y lo actualiza 
    Eliminar los registros de la Entidad APE:EstimadosProducto segun los oids informados en el atributo de entrada    
    */
    
    /** 
    * Autor: Guido Pons
    * Fecha: 09-01-2007
    * Descripcion: retorna los valores correspondientes a los parametros de busqueda 
    * @param dtoE DTOOIDs 
    * @return DTOSalida el resultado de la busqueda
    * @exception MareException 
    */   
    public void eliminarEstimadosProducto (DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.eliminarEstimadosProducto(DTOOIDs dtoE): Salida");                      
        
        EstimadosProductoLocalHome estimadosProductoLocalHome = new EstimadosProductoLocalHome();
        EstimadosProductoLocal estimadosProductoLocal = null;
        
        if ((dtoE != null) && (dtoE.getOids() != null)) {
 
            Long[] oids = dtoE.getOids();
            UtilidadesLog.debug("Se eliminaran " + oids.length + " estimados de producto");
        
            for (int i = 0; i < oids.length; i++) {
                UtilidadesLog.debug("Intento encontrar registro con OID: " + oids[i]);
                try {
                    estimadosProductoLocal = estimadosProductoLocalHome.findByPrimaryKey(oids[i]);
                    try {
                        estimadosProductoLocalHome.remove(estimadosProductoLocal);
                    } catch (PersistenceException e) {
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                } catch (NoResultException e) {
                    UtilidadesLog.error("DAOAsignacionProductos.eliminarEstimadosProducto: NoResultException", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException e) {
                    UtilidadesLog.error("Exception: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }
        UtilidadesLog.info("DAOAsignacionProductos.eliminarEstimadosProducto(DTOOIDs dtoE): Salida");                              
    }
    
    /**
     * Recupera, en base a los parametros recibidos, los datos de 
     * APE_ASIGN_PRODU_ANAQU_CABEC (APE:AsignacionProductoAnaquelCabecera)
     * para cargar el combo de 'Versiones'. Utilizado como recarga de dicho combo.
     * @autor eiraola
     * @since 24/01/2007
     */
    public DTOSalida obtenerVersionesAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.obtenerVersionesAsignacion(dtoe): Entrada");
    
        Long oidMapaCD = dtoe.getOidMapaCentroDistribucion();
        UtilidadesLog.debug("   - SAP601: oidMapaCD = " + oidMapaCD);
        
        /* BELC400000546 - dmorello, 04/07/2007 */
        //Long oidMapaZ = dtoe.getOidMapaZona();
        //UtilidadesLog.debug("   - SAP601: oidMapaZ = " + oidMapaZ);
        
        Long oidCentro = dtoe.getOidCentroDistribucion();
        UtilidadesLog.debug("oidCentro: " + oidCentro);
        
        StringBuffer query = new StringBuffer();
        
        /* BELC400000692 - dmorello, 29/08/2007: Se agrega DISTINCT */
        query.append(" select DISTINCT apa.oid_asig_prod_anaq_cabe OID, ");
        query.append("        apa.val_vers VERSION ");
        query.append("   from ape_asign_produ_anaqu_cabec apa ");
        query.append("      , ape_mapa_centr_distr_cabec mcdc "); /* dmorello, 05/07/2007 */
        /* BELC400000692 - dmorello, 29/08/2007 */
        query.append("      , ape_mapa_zona_cabec mzc ");
        query.append("      , ape_mapa_zona_detal mzd ");
        query.append("      , ape_subli_armad subl ");
        /* Fin BELC400000692 - dmorello, 29/08/2007 */
        query.append("  where apa.perd_oid_peri = " + dtoe.getOidPeriodo());
        
        if( oidMapaCD != null ){     
            query.append("      and apa.mcdc_oid_mapa_cent_dist_cabe = " + oidMapaCD);
        }
        
        /* dmorello, 05/07/2007 */
        query.append("    AND apa.mcdc_oid_mapa_cent_dist_cabe = mcdc.oid_mapa_cent_dist_cabe ");
        if (oidCentro != null) {
            query.append("   AND mcdc.ccdi_oid_conf_cent_dist = ").append(oidCentro);
        }
        /* Fin dmorello 05/07/2007 */
        
        /* BELC400000546 - dmorello, 04/07/2007 */
        //if( oidMapaZ != null ){     
        //    query.append("        and apa.mzca_oid_mapa_zona_cabe = " + oidMapaZ);
        //}
        /* Fin BELC400000546 dmorello 04/07/2007 */
        
        /* BELC400000692 - dmorello, 29/08/2007 */
        query.append(" AND mzc.oid_mapa_zona_cabe = apa.mzca_oid_mapa_zona_cabe ");
        query.append(" AND mzc.oid_mapa_zona_cabe = mzd.mzca_oid_mapa_zona_cabe ");
        query.append(" AND mzd.sbar_oid_subl_arma = subl.oid_subl_arma ");
        if (dtoe.getOidLineaArmado() != null) {
            query.append(" and subl.LIAR_OID_LINE_ARMA = ").append(dtoe.getOidLineaArmado());
        }
        /* Fin BELC400000692 - dmorello, 29/08/2007 */
        
        query.append("  order by apa.val_vers "); // Se consulto a DT y no aplica to_number() pues es Alfanumerico 10 - eiraola
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
               UtilidadesLog.error("<dao>.obtenerVersionesAsignacion: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOAsignacionProductos.obtenerVersionesAsignacion(dtoe): Salida");
        return dtoSalida;
    }
    
    /**
     * Recupera los registros de Asignaciones de productos a anaqueles (el detalle).
     * Recibe como parametro el oid de la cabecera de Asignacion de productos a 
     * anaqueles (también denominada 'Version').
     * La consulta es paginada pero al requerir ordenamiento por Texto de codigos
     * y no por Oids observar que lo que retorna como OID es rownum.
     * @autor eiraola
     * @since 29/01/2007
     */
    public DTOSalida consultarAsignacionProductosAnaqueles(DTODesasignarProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.consultarAsignacionProductosAnaqueles(dtoe): Entrada");
    
        StringBuffer query = new StringBuffer();
        
        // Agregado para paginar y mantener los distintos ordenes de registros
        query.append(" select rownum as OID, consultaOriginal.* from ( ");
        
        // Consulta original - Inicio
        query.append(" SELECT   pad.oid_asig_prod_anaq, mcd.num_anaq, mae.cod_sap, I18N.VAL_I18N ");
            query.append(" FROM ape_asign_produ_anaqu_detal pad, ");
                 query.append(" ape_mapa_centr_distr_detal mcd, ");
                 query.append(" mae_produ mae, ");
                 query.append(" v_gen_i18n_sicc i18n ");
           query.append(" WHERE pad.apac_oid_asig_prod_anaq_cabe = " + dtoe.getOid());
             query.append(" AND pad.mcdd_oid_mapa_cent_dist_deta = mcd.oid_mapa_cent_dist_deta ");
             query.append(" AND pad.prod_oid_prod = mae.oid_prod ");
             query.append(" and MAE.OID_PROD = I18N.VAL_OID ");
             query.append(" and I18N.ATTR_ENTI = 'MAE_PRODU' ");
             query.append(" and I18N.IDIO_OID_IDIO = "+dtoe.getOidIdioma()+" ");
             query.append(" and I18N.ATTR_NUM_ATRI = 1 ");
             if (dtoe.getDescripcion()!=null&&!"".equals(dtoe.getDescripcion())) {
                query.append(" and I18N.VAL_I18N >= '"+dtoe.getDescripcion()+"' ");
                query.append(" ORDER BY I18N.VAL_I18N ASC ");                
             } else if (dtoe.getCodSAP()!=null&&!"".equals(dtoe.getCodSAP())) {
                query.append(" and MAE.COD_SAP >= '"+dtoe.getCodSAP()+"' ");
                query.append(" ORDER BY MAE.COD_SAP ASC ");                
             } else if (dtoe.getNumAnaq()!=null&&!"".equals(dtoe.getNumAnaq())) {
                query.append(" AND mcd.num_anaq >= '"+dtoe.getNumAnaq()+"' ");
                query.append(" ORDER BY mcd.num_anaq ASC ");                
             } else {
                query.append(" ORDER BY MAE.COD_SAP ASC ");   // Agregado por Inc. 490 - eiraola - 11/Jun/2007       
             }        
        
        /* ELIMINADO por Inc. 490 - eiraola 11/Jun/2007
        UtilidadesLog.debug(" *** codigo de ordenamiento: " + dtoe.getCodOrdenamiento());
        long codOrdenamientoValAbs = Math.abs(dtoe.getCodOrdenamiento().longValue());
        
        if (codOrdenamientoValAbs == ConstantesAPE.ORDEN_POR_ANAQUEL.longValue()) {
            query.append(" order by mcd.num_anaq ");
            
            if (dtoe.getCodOrdenamiento().longValue() < 0) {
                query.append(" desc ");
            }
        } else if (codOrdenamientoValAbs == ConstantesAPE.ORDEN_POR_PRODUCTO.longValue()) {
            query.append(" order by mae.cod_sap ");
            
            if (dtoe.getCodOrdenamiento().longValue() < 0) {
                query.append(" desc ");
            }
        }
        FIN ELIMINADO por Inc. 490*/
        //query.append(" order by mae.cod_sap asc "); // Agregado por Inc. 490 - eiraola - 11/Jun/2007
        
        
        // Consulta original - Fin
        
        query.append(" ) consultaOriginal "); // Agregado para paginar
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(
                    UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoe));
                    //this.armarQueryPaginacionEspecial(query.toString(), dtoe)); // eiraola uso este metodo local para ordenar por campo no oid
        } catch (Exception e) {
               UtilidadesLog.error("<dao>.consultarAsignacionProductosAnaqueles: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOAsignacionProductos.consultarAsignacionProductosAnaqueles(dtoe): Salida");
        return dtoSalida;
    }
    
    /**
     * Recupera los registros de la Cabecera de Asignaciones de productos a anaqueles.
     * Se trata de una consulta paginada para lista editable. No confundir con 
     * obtenerVersionesAsignacion ya que este ultimo es para combo.
     * Utilizada en: CU Copiar asignacion de prod/anaq
     * @autor eiraola
     * @since 29/01/2007
     */
    public DTOSalida consultarVersionesAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.consultarVersionesAsignacion(dtoe): Entrada");
    
        StringBuffer query = new StringBuffer();
        
        // vbongiov -- APE-02 -- 16/11/2007
        query.append(" select pac.oid_asig_prod_anaq_cabe OID, ");
        query.append("     i1.val_i18n MAPA_CD_DESC, ");
        query.append("     pac.val_vers VERSION, ");
        query.append("     i2.val_i18n||' - '||i3.val_i18n MAPA_ZONA_DESC, ");
        query.append("     DECODE (pac.ind_acti_fact, 'S', '1', '0') activo_fact, ");
        query.append("     mcdc.oid_mapa_cent_dist_cabe MAPA_CD_OID, ");
        query.append("     pac.mzca_oid_mapa_zona_cabe MAPA_ZONA_OID, ");        
        query.append("     mapLin.LIAR_OID_LINE_ARMA, ");  
        query.append("     pac.ind_acti_fact activo_fact1 ");  
        query.append(" from ape_asign_produ_anaqu_cabec pac, ");
        query.append("     app_confi_centr_distr ccd, ");
        query.append("     ape_mapa_centr_distr_cabec mcdc, ");
        query.append(" (select distinct mapDet.MZCA_OID_MAPA_ZONA_CABE, subLin.LIAR_OID_LINE_ARMA ");
        query.append("  from APE_MAPA_ZONA_DETAL mapDet, APE_SUBLI_ARMAD subLin ");
        query.append("  where subLin.OID_SUBL_ARMA = mapDet.SBAR_OID_SUBL_ARMA ) mapLin, ");
        query.append("     v_gen_i18n_sicc i1, ");
        query.append("     v_gen_i18n_sicc i2, ");
        query.append("     v_gen_i18n_sicc i3 ");
        query.append(" where ccd.oid_conf_cent_dist = mcdc.ccdi_oid_conf_cent_dist ");
        
        if (dtoe.getOidCentroDistribucion() != null) {
            query.append("   and ccd.oid_conf_cent_dist = " + dtoe.getOidCentroDistribucion());
        }
        query.append("   and mcdc.oid_mapa_cent_dist_cabe = pac.mcdc_oid_mapa_cent_dist_cabe ");
        
        if (dtoe.getOidPeriodo() != null) {
            query.append("   and pac.perd_oid_peri = " + dtoe.getOidPeriodo());
        }
        
        if (dtoe.getOidAsignacionProductoAnaquel() != null) {
            query.append("   and pac.oid_asig_prod_anaq_cabe = " + dtoe.getOidAsignacionProductoAnaquel());
        }
        
        query.append(" and mapLin.MZCA_OID_MAPA_ZONA_CABE =pac.mzca_oid_mapa_zona_cabe ");
        query.append("   and i1.attr_enti = 'APE_MAPA_CENTR_DISTR_CABEC' ");
        query.append("   and i1.attr_num_atri = 1 ");
        query.append("   and i1.val_oid = mcdc.oid_mapa_cent_dist_cabe ");
        query.append("   and i1.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append("   and i2.attr_enti = 'APE_MAPA_ZONA_CABEC' ");
        query.append("   and i2.attr_num_atri = 1 ");
        query.append("   and i2.val_oid = pac.mzca_oid_mapa_zona_cabe ");
        query.append("   and i2.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append("   and i3.attr_enti = 'APE_LINEA_ARMAD' ");
        query.append("   and i3.attr_num_atri = 1 ");
        query.append("   and i3.val_oid = mapLin.LIAR_OID_LINE_ARMA ");
        query.append("   and i3.idio_oid_idio = " + dtoe.getOidIdioma());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(
                    UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe));
        } catch (Exception e) {
               UtilidadesLog.error("<dao>.consultarVersionesAsignacion: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (rs.esVacio()) {
            throw new MareException("No hay resultados para la busqueda", UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOAsignacionProductos.consultarVersionesAsignacion(dtoe): Salida");
        return dtoSalida;
    }
    
    /**
     * Consulta acorde al DMCO APE-19-01 como parte de la validacion a realizar
     * para cada linea de detalle de asignacion de producto y anaquel.
     * @autor eiraola
     * @since 29/01/2007
     * CHANGELOG
     * vbongiov -- BELC400000594 -- 26/07/2007
     * dmorello - Incidencia 20080502 - 27/05/2008
     *            Se considera que, para los productos, "fuera de pedido" es "B"
     *            o "C", y dentro de pedido es "C"
     */
    public Long validacionAFPProductoLinea(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.validacionAFPProductoLinea(dtoe): Entrada");
        Boolean validacionAFP = new Boolean(false);
        RecordSet rs = null;
        StringBuffer consulta = new StringBuffer("");    
        
        consulta.append(" select mp.oid_prod,  ");
        consulta.append("     mp.cod_sap,  ");
        consulta.append("     mcd.mcdd_oid_mapa_cent_dist_deta,   ");
        consulta.append("     mcd.num_anaq,  ");
        consulta.append("     la.oid_line_Arma,  ");
        consulta.append("     sla.oid_subl_arma,  ");
        consulta.append("     ep.perd_oid_peri,  ");
        consulta.append("     ep.num_unid_esti,  ");
        consulta.append("     ep.ind_fuer_pedi ");
        consulta.append(" from ape_mapa_centr_distr_detal mcd, ");
        consulta.append("     ape_subli_armad sla, ");
        consulta.append("     ape_linea_armad la, ");
        consulta.append("     ape_estim_produ ep, ");
        consulta.append("     mae_produ mp ");
        consulta.append(" where mcd.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOidMapaCentroDistribucion());
        consulta.append("   and mcd.num_anaq = '" + dtoe.getCodigoAnaquel() +"' ");
        consulta.append("   and mcd.sbar_oid_subl_arma = sla.oid_subl_arma ");
        consulta.append("   and sla.liar_oid_line_arma = la.oid_line_arma ");
        consulta.append("   and mp.cod_sap = '" + dtoe.getCodigoProducto() + "' ");
        consulta.append("   and mp.pais_oid_pais = " + dtoe.getOidPais());
        consulta.append("   and ep.prod_oid_prod = mp.oid_prod ");
        consulta.append("   and ep.perd_oid_peri = " + dtoe.getOidPeriodo());
        // Eliminado - eiraola - 01/Oct/2007 [INICIO]
        //consulta.append("   and ep.liar_oid_line_arma = la.oid_line_arma ");    // No estaba en DMCO
        // Eliminado - eiraola - 01/Oct/2007 [FIN]
        
        // vbongiov -- 2/07/2007 
        //( APE:LineaArmado.lineaAFP = TRUE AND MAE:MaestroProductos.indCajaBolsa = ConstantesMAE.FUERA_CAJA ) 
        // OR ( APE:LineaArmado.lineaAFP = FALSE AND MAE:MaestroProductos.indCajaBolsa != ConstantesMAE.FUERA_CAJA ) 
        // como no se ha ingresado la contante en MAE se filtra por su valor
        consulta.append("   and ((la.num_line_afp = " + ConstantesAPE.TRUE + " and mp.cod_ind_dent_caja IN ('F','B')) ");
		    consulta.append("        or (la.num_line_afp = " + ConstantesAPE.FALSE + " and mp.cod_ind_dent_caja NOT IN ('F','B'))) ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.validacionAFPProductoLinea: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));                        
        }
        
        if (rs.esVacio()) {
            UtilidadesLog.debug("... validacionAFPProductoLinea (1): " + validacionAFP + " rs:" + rs);
            UtilidadesLog.info("DAOAsignacionProductos.validacionAFPProductoLinea(dtoe): Salida");
            return null;
        } else {
            UtilidadesLog.debug("... validacionAFPProductoLinea (2): " + validacionAFP + " rs:" + rs);
            UtilidadesLog.info("DAOAsignacionProductos.validacionAFPProductoLinea(dtoe): Salida");
            return Long.valueOf(((BigDecimal)rs.getValueAt(0,"NUM_UNID_ESTI")).toString());
        }
    }
    
    /**
     * Consulta acorde al DMCO APE-19-01 como parte de la validacion a realizar
     * para cada linea de detalle de asignacion de producto y anaquel.
     * @autor eiraola
     * @since 29/01/2007
     */
    public Boolean validarAsignacionAnteriorAnaquel(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.validarAsignacionAnteriorAnaquel(dtoe): Entrada");
        Boolean noHayAnteriorAsignacion = new Boolean(false);
        RecordSet rs = null;
        StringBuffer consulta = new StringBuffer("");    
        
        consulta.append(" select pac.oid_asig_prod_anaq_cabe, ");
        consulta.append("     pad.oid_asig_prod_anaq,  ");
        consulta.append("     mcd.num_anaq, ");
        consulta.append("     pad.prod_oid_prod  ");
        consulta.append(" from ape_mapa_centr_distr_detal mcd, ");
        consulta.append("     ape_asign_produ_anaqu_cabec pac, ");
        consulta.append("     ape_asign_produ_anaqu_detal pad ");
        consulta.append(" where mcd.num_anaq = '" + dtoe.getCodigoAnaquel() + "' ");
        consulta.append("   and mcd.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOidMapaCentroDistribucion());
        consulta.append("   and mcd.oid_mapa_cent_dist_deta = pad.mcdd_oid_mapa_cent_dist_deta ");
        consulta.append("   and pad.apac_oid_asig_prod_anaq_cabe = pac.oid_asig_prod_anaq_cabe ");
        //consulta.append("   and pac.mzca_oid_mapa_zona_cabe = " + dtoe.getOidMapaZona()); // Eliminado LG_V400000028
        consulta.append("   AND pac.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getOidAsignacionProductoAnaquel()); // Agregado LG_V400000028
        consulta.append("   and pac.perd_oid_peri = " + dtoe.getOidPeriodo());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.validarAsignacionAnteriorAnaquel: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));                        
        }
        
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {
            noHayAnteriorAsignacion = new Boolean(true);
        } else { // Si se recupero algun registro en la consulta anterior
            noHayAnteriorAsignacion = new Boolean(false);
        }
        
        UtilidadesLog.debug("... validarAsignacionAnteriorAnaquel: " + noHayAnteriorAsignacion + " rs:" + rs);
        UtilidadesLog.info("DAOAsignacionProductos.validarAsignacionAnteriorAnaquel(dtoe): Salida");
        return noHayAnteriorAsignacion;
    }
    
    /**
     * Consulta acorde al DMCO APE-19-01 como parte de la validacion a realizar
     * para cada linea de detalle de asignacion de producto y anaquel.
     * @autor eiraola
     * @since 29/01/2007
     */
    public Boolean validarExistenciaProducto(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.validarExistenciaProducto(dtoe): Entrada");
        Boolean existeProducto = new Boolean(false);
        RecordSet rs = null;
        StringBuffer consulta = new StringBuffer("");    
        
        consulta.append(" select mp.oid_prod, ");
        consulta.append("     ep.oid_esti_prod,  ");
        consulta.append("     ep.perd_oid_peri ");
        consulta.append(" from mae_produ mp, ");
        consulta.append("     ape_estim_produ ep ");
        consulta.append(" where mp.cod_sap = '" + dtoe.getCodigoProducto() + "' ");
        consulta.append("   and mp.pais_oid_pais = " + dtoe.getOidPais());
        consulta.append("   and mp.oid_prod = ep.prod_oid_prod ");
        consulta.append("   and ep.perd_oid_peri = " + dtoe.getOidPeriodo());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.validarExistenciaProducto: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));                        
        }
        
        // Inc. BELC400000630 - eiraola - 21/08/2007 Ya no se exige exactamente un registro 
        // sino que alcanza con que se recupere mas de uno.
        if (rs != null && !rs.esVacio()) {
            existeProducto = new Boolean(true);
        } else {
            existeProducto = new Boolean(false);
        }
        
        UtilidadesLog.debug("... validarExistenciaProducto: " + existeProducto + " rs:" + rs);
        UtilidadesLog.info("DAOAsignacionProductos.validarExistenciaProducto(dtoe): Salida");
        return existeProducto;
    }
    
    /**
     * Consulta acorde al DMCO APE-19-01 como parte de la validacion a realizar
     * para cada linea de detalle de asignacion de producto y anaquel.
     * @autor eiraola
     * @since 29/01/2007
     */
    public Boolean validarExistenciaVigenciaAnaquel(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.validarExistenciaVigenciaAnaquel(dtoe): Entrada");
        Boolean anaquelExisteYVigente = new Boolean(false);
        RecordSet rs = null;
        StringBuffer consulta = new StringBuffer("");    
        
        consulta.append(" select mcd.oid_mapa_cent_dist_deta, ");
        consulta.append("     mcd.num_anaq, ");
        consulta.append("     mcd.ind_expa, ");
        consulta.append("     mcd.sbar_oid_subl_arma ");
        consulta.append(" from ape_mapa_centr_distr_detal mcd ");
        consulta.append(" where mcd.num_anaq = '" + dtoe.getCodigoAnaquel() + "' ");
        consulta.append("   and (mcd.ind_expa is null or mcd.ind_expa = '" + ConstantesAPE.FALSE + "') ");
        consulta.append("   and mcd.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOidMapaCentroDistribucion());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.validarExistenciaVigenciaAnaquel: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));                        
        }
        
        if (rs.esVacio() || rs.getRowCount() > 1) {
            anaquelExisteYVigente = new Boolean(false);
        } else { // Si se recupero exactamente un registro
            anaquelExisteYVigente = new Boolean(true);
        }
        
        UtilidadesLog.debug("... validarExistenciaVigenciaAnaquel: " + anaquelExisteYVigente + " rs:" + rs);
        UtilidadesLog.info("DAOAsignacionProductos.validarExistenciaVigenciaAnaquel(dtoe): Salida");
        return anaquelExisteYVigente;
    }
    
    /**
     * Elimina los registros correspondientes a los oid que se pasan por parametro
     * de la entidad APE:AsignacionProductoAnaquelDetalle.
     * @autor eiraola
     * @since 29/01/2007
     */
    public void eliminarAsignacionProductosAnaqueles(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.eliminarAsignacionProductosAnaqueles(DTOOIDs dtoE): Entrada");
        
        Long oids[] = dtoe.getOids();
        int cantOids = 0;
        
        if (oids != null) {
            cantOids = oids.length;
        }
        
        if (cantOids > 0) {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer delete = new StringBuffer();
    
            delete.append(" delete from ape_asign_produ_anaqu_detal pad ");
            delete.append(" where pad.oid_asig_prod_anaq in ( " + oids[0]);
            
            for (int i = 1; i < cantOids; i++) {
                delete.append(", " + oids[i]);
            }
            delete.append(") ");
            
            try {
                int cantRegsEliminados = bs.dbService.executeUpdate(delete.toString());
                UtilidadesLog.debug("... se eliminaron " + cantRegsEliminados + " registros");
            } catch (Exception e) {
                UtilidadesLog.error("<dao>.eliminarAsignacionProductosAnaqueles: Exception", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOAsignacionProductos.eliminarAsignacionProductosAnaqueles(DTOOIDs dtoE): Salida");                              
    }
  
    private Long booleanALong(Boolean b) {
        if (b.booleanValue()) {
            return new Long(1);
        }
        return new Long(0);
    }    

    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoE
     */     
    public DTOSalida calcularHit(DTOCalcularHit dtoE) throws MareException
    {
        UtilidadesLog.info("DAOAsignacionProductos.calcularHit(DTOCalcularHit dtoE): Entrada");                              
        UtilidadesLog.debug("   - SAP601: recibió DTOCalcularHit = " + dtoE);
        
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT  line.oid_line_arma OID, gena.val_i18n DESC_LINEA, "); // linea.descripcion(internacionalizable)
        query.append(" genb.val_i18n DESC_SUBLINEA, "); // subline.descripcion(internacionalizable)
        query.append(" NVL(mapzcab.cod_mapa_zona,1) cod_mapa_zona, ");
        query.append(" SUM (CEIL((listd.num_unid_prod / NVL (produ.num_capa_oper, 1)))) AS HIT ");
        query.append(" FROM app_confi_centr_distr confcd, ape_mapa_centr_distr_cabec mapcdcab, ");
        query.append(" ape_mapa_centr_distr_detal mapcddet, ape_mapa_zona_cabec mapzcab, ");
        query.append(" ape_mapa_zona_detal mapzdet, ape_linea_armad line, ape_subli_armad subline, ");
        query.append(" ape_lista_picad_cabec listc, ape_lista_picad_detal listd, ");
        query.append(" mae_produ produ, gen_i18n_sicc_pais gena, ");
        query.append(" gen_i18n_sicc_pais genb ");
        query.append(" WHERE mapcdcab.ccdi_oid_conf_cent_dist = ").append(dtoE.getOidCentroDistribucion());
        // vbongiov --  BELC400000623 -- 6/08/2007
        query.append(" AND mapcdcab.OID_MAPA_CENT_DIST_CABE = ").append(dtoE.getOidMapaCentroDistribucion());
        query.append(" AND mapcddet.sbar_oid_subl_arma = subline.oid_subl_arma ");
        query.append(" AND mapzcab.oid_mapa_zona_cabe = ").append(dtoE.getOidMapaZona());
        query.append(" AND mapzdet.mzca_oid_mapa_zona_cabe = mapzcab.oid_mapa_zona_cabe ");
        
        
        // Se deben tomar las posiciones 2 y 3 del nro anaquel
        query.append(" AND mapzdet.num_bahi_desd <= SUBSTR(mapcddet.num_anaq, 2, 2) ");
        query.append(" AND SUBSTR(mapcddet.num_anaq, 2, 2) <= mapzdet.num_bahi_hast ");
            
            // Se quitó por error en diseño.
            //query.append(" AND line.oid_line_arma = ").append(dtoE.getOidLineaArmado());
        
        query.append(" AND line.oid_line_arma = subline.liar_oid_line_arma ");
        query.append(" AND subline.oid_subl_arma = mapzdet.sbar_oid_subl_arma ");
        query.append(" AND listc.ccdi_oid_conf_cent_dist = ").append(dtoE.getOidCentroDistribucion());    
        
        /* 
         * SPLATAS - 17/04/2007 - Modificación: BELC400000377
         * 2007.04.16 HMANSI DT: Se modifica el filtro de oidPeriodo por el filtro fechaFacturacion
         *
         *      query.append(" AND listc.perd_oid_peri = ").append(dtoE.getOidPeriodo());
         */
        Date fecha = dtoE.getFechaFactu();
        if( fecha != null ) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
            String fechaFactu = sdf.format(fecha);
             
            query.append(" AND listc.fec_factu = to_date('").append(fechaFactu).append("', 'dd/MM/yyyy') ");
        }

        
        query.append(" AND listd.lpca_oid_list_pica_cabe = listc.oid_list_pica_cabe ");
        query.append(" AND listd.mcdd_oid_mapa_cent_dist_deta = mapcddet.oid_mapa_cent_dist_deta ");
        query.append(" AND produ.oid_prod = listd.prod_oid_prod ");     
        query.append(" AND gena.val_oid = line.oid_line_arma ");     
        query.append(" AND gena.attr_enti LIKE 'APE_LINEA_ARMAD' ");     
            
            // Se quitó por error en diseño.
            //query.append(" AND line.oid_line_arma = ").append(dtoE.getOidLineaArmado());     
                        
        query.append(" AND genb.val_oid = subline.oid_subl_arma ");     
        query.append(" AND genb.attr_enti LIKE 'APE_SUBLI_ARMAD' ");     
        query.append(" AND subline.liar_oid_line_arma = line.oid_line_arma ");     
        query.append(" GROUP BY line.oid_line_arma, gena.val_i18n, ");     // LineaArmado.descripcion(internacionalizable)
        query.append(" genb.val_i18n, ");     // SublineaArmado.descripcion(internacionalizable)
        query.append(" NVL(mapzcab.cod_mapa_zona,1) ");   
 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        UtilidadesLog.debug("   - SAP601: armarQueryPaginacion... ");
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoE);
        
        try {
            rs = bs.dbService.executeStaticQuery(queryPaginada);
        
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error("Exception en DAOAsignacionProductos.calcularHit(DTOCalcularHit dtoE): ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if(rs.esVacio()) {
          throw new MareException(null, null,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.debug("   - SAP601: retorna DTOSalida= " + rs);
        UtilidadesLog.info("DAOAsignacionProductos.calcularHit(DTOCalcularHit dtoE): Salida");                              
        return dtoSalida;
        
    }
    
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 1/2/2007
   */
    public RecordSet recuperarEstimadosAGenerar(DTOMantenerEstimadosProducto dtoe) 
        throws MareException {             
        UtilidadesLog.info("DAOAsignacionProductos.recuperarEstimadosAGenerar"+
        "(DTOMantenerEstimadosProducto dtoe): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        boolean query1 = false;       
        
        if(dtoe.getOidLineaArmado()!=null){
            query1 = true;
            query.append(" SELECT MP.OID_PROD AS OID, ");
            query.append(" SUM(PEV.NUM_UNID_ESTI) AS UNIDADES, ");
            query.append(" MP.COD_IND_DENT_CAJA AS INDICADOR, ");
            query.append(dtoe.getOidLineaArmado() + " AS OIDLINEA ");
            query.append(" FROM MAE_PRODU MP, ");
            query.append(" PRE_ESTIM_VENTA PEV, ");
            query.append(" APE_LINEA_ARMAD ALA ");
            query.append(" WHERE PEV.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append(" AND PEV.PROD_OID_PROD = MP.OID_PROD ");
            query.append(" AND ALA.OID_LINE_ARMA = "+dtoe.getOidLineaArmado() +" ");
            query.append(" AND (MP.COD_IND_DENT_CAJA = DECODE(ALA.NUM_LINE_AFP, '1', 'B','C') ");
            query.append(" OR MP.COD_IND_DENT_CAJA = DECODE(ALA.NUM_LINE_AFP, '1', 'F','C') ");
            query.append(" OR MP.COD_IND_DENT_CAJA = DECODE(ALA.NUM_LINE_AFP, '1', null,'C')) ");           
            query.append(" GROUP BY MP.OID_PROD, MP.COD_IND_DENT_CAJA ");
        }
        
        if(dtoe.getOidLineaArmadoMAV()!=null) {
            if(query1==true) {
                query.append(" UNION ");    
            }
            
            query.append(" SELECT MP.OID_PROD AS OID, ");
            query.append(" SUM(MBI.NUM_UNID) AS UNIDADES, ");
            query.append(" MP.COD_IND_DENT_CAJA AS INDICADOR, ");
            query.append(dtoe.getOidLineaArmadoMAV() + " AS OIDLINEA ");
            query.append(" FROM MAE_PRODU MP, ");
            query.append(" MAV_BPS_INTER MBI, ");
            query.append(" APE_LINEA_ARMAD ALA ");            
            query.append(" WHERE MBI.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append(" AND MBI.PROD_OID_PROD = MP.OID_PROD ");
            query.append(" AND ALA.OID_LINE_ARMA = "+dtoe.getOidLineaArmadoMAV() +" ");
            query.append(" AND (MP.COD_IND_DENT_CAJA = DECODE(ALA.NUM_LINE_AFP, '1', 'B','C') ");
            query.append(" OR MP.COD_IND_DENT_CAJA = DECODE(ALA.NUM_LINE_AFP, '1', 'F','C') ");
            query.append(" OR MP.COD_IND_DENT_CAJA = DECODE(ALA.NUM_LINE_AFP, '1', null,'C')) ");              
            query.append(" GROUP BY MP.OID_PROD, MP.COD_IND_DENT_CAJA ");
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

        UtilidadesLog.info("DAOAsignacionProductos.recuperarEstimadosAGenerar"+
        "(DTOMantenerEstimadosProducto dtoe): Salida");
        
        return rs;    
    }

    /**
     * Dado un oid de Cabecera de Asignacion Productos a Anaqueles se recuperan
     * todos sus Detalles.
     * @autor eiraola
     * @since 16/02/2007
     * @observaciones
     *     Modificado por: Cristian Valenzuela - Incidencia: BELC400000347 - Fecha: 19/04/2007
     *     Modificado por: eiraola - Incidencia: BELC400000607 - Fecha: 01/08/2007 (deshago lo modificado por 347)
     */
    public ArrayList obtenerAsignacionProductoDetalles(Long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.obtenerAsignacionProductoDetalles(oidCabecera): Entrada");
        
        StringBuffer query = new StringBuffer();
        
        /*query.append(" select pad.oid_asig_prod_anaq OID, ");
        query.append("        pad.ind_proce PROC, ");
        query.append(" 	      pad.num_unida UNID, ");
        query.append(" 	      pad.ind_sigu_asig SIGU_ASIG, ");
        query.append(" 	      pad.ind_asig_petl ASIG_PTL, ");
        query.append("    	  pad.mcdd_oid_mapa_cent_dist_deta OID_MAPA_CD, ");
        query.append(" 	      pad.prod_oid_prod OID_PROD ");
        query.append("   from ape_asign_produ_anaqu_detal pad ");
        query.append("  where pad.apac_oid_asig_prod_anaq_cabe = " + oidCabecera);*/
        
        query.append(" SELECT PAD.OID_ASIG_PROD_ANAQ OID,  ");
        //query.append(" PROCE.COD_PROC PROC,  "); // Eliminado eiraola - Inc. BELC400000607
        query.append(" PAD.PRCE_OID_PROC,  "); // Agregado eiraola - Inc. BELC400000607
        query.append(" PAD.NUM_UNIDA UNID,  ");
        query.append(" PAD.IND_SIGU_ASIG SIGU_ASIG,  ");
        query.append(" PAD.IND_ASIG_PETL ASIG_PTL,  ");
        query.append(" PAD.MCDD_OID_MAPA_CENT_DIST_DETA OID_MAPA_CD,  ");
        query.append(" PAD.PROD_OID_PROD OID_PROD  ");
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_DETAL PAD ");
        //query.append(" APE_PROCE PROCE  "); // Eliminado eiraola - Inc. BELC400000607
        query.append(" WHERE PAD.APAC_OID_ASIG_PROD_ANAQ_CABE = " + oidCabecera);
        //query.append(" AND PAD.PRCE_OID_PROC = PROCE.OID_PROC "); // Eliminado eiraola - Inc. BELC400000607
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
               UtilidadesLog.error("<dao>.obtenerAsignacionProductoDetalles: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        ArrayList lstDetalles = new ArrayList();
        int cantDetalles = rs.getRowCount();
        UtilidadesLog.debug(" Se recuperaron " + cantDetalles + " detalles de asignacion: " + rs);
        
        for (int i = 0; i < cantDetalles; i++) {
            // Campos Not Null en la tabla APE_ASIGN_PRODU_ANAQU_DETAL
            Long oid = new Long(((BigDecimal)rs.getValueAt(i, "OID")).longValue());
            //String procedencia = new String((String)rs.getValueAt(i, "PROC")); // Eliminado eiraola - Inc. BELC400000607
            Long oidProcedencia = new Long(((BigDecimal)rs.getValueAt(i, "PRCE_OID_PROC")).longValue()); // Agregado eiraola - Inc. BELC400000607
            Long oidProducto = new Long(((BigDecimal)rs.getValueAt(i, "OID_PROD")).longValue());
            
            // Campos que pueden ser nulos
            Long unidades = null;
            String siguienteAsignacion = null;
            Boolean ind_asig_ptl = null;
            Long oidMapaCDDetalle = null;
            
            if (rs.getValueAt(i, "UNID") != null) {
                unidades = new Long(((BigDecimal)rs.getValueAt(i, "UNID")).longValue());
            }
            
            if (rs.getValueAt(i, "SIGU_ASIG") != null) {
                siguienteAsignacion = new String((String)rs.getValueAt(i, "SIGU_ASIG"));
            }
            
            if (rs.getValueAt(i, "ASIG_PTL") != null) {
                String asignacionPTL = new String((String)rs.getValueAt(i, "ASIG_PTL"));
                if (asignacionPTL.equals(ConstantesAPE.TRUE.toString())) {
                    ind_asig_ptl = new Boolean(true);
                } else if (asignacionPTL.equals(ConstantesAPE.FALSE.toString())) {
                    ind_asig_ptl = new Boolean(false);
                } else {
                    throw new MareException("Valor desconocido en ind_asig_petl ("+ asignacionPTL +")",
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_PARAMETROS_INCORRECTOS));
                }
            }
            
            if (rs.getValueAt(i, "OID_MAPA_CD") != null) {
                oidMapaCDDetalle = new Long(((BigDecimal)rs.getValueAt(i, "OID_MAPA_CD")).longValue());
            }
                        
            DTOAsignacionProductoAnaquelDetalle dtoDetalle = new DTOAsignacionProductoAnaquelDetalle();
            dtoDetalle.setOid(oid);                                             // Es Not null
            //dtoDetalle.setProcedencia(procedencia);                             // Es Not null
            dtoDetalle.setProcedencia(oidProcedencia.toString());               // Es Not null
            dtoDetalle.setUnidades(unidades);
            dtoDetalle.setSiguienteAsignacion(siguienteAsignacion);
            dtoDetalle.setAsignacionPTL(ind_asig_ptl);
            dtoDetalle.setOidMapaCDDetalle(oidMapaCDDetalle);
            dtoDetalle.setOidProducto(oidProducto);                             // Es Not null
            dtoDetalle.setOidAsignacionProductoCabecera(oidCabecera);           // Es Not null

            lstDetalles.add(dtoDetalle);
        }
                
        UtilidadesLog.info("DAOAsignacionProductos.obtenerAsignacionProductoDetalles(oidCabecera): Salida");
        return lstDetalles;
    }
    
    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * 
     * Descripcion: desactiva el registro deseado de la Entidad APE:AsignacionProductoAnaquelCabecera 
     */
    public void desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE) throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE): Entrada");
        
        Long oidCD = dtoE.getOidCentroDistribucion();
        UtilidadesLog.debug("   - SAP601: oidCD = " + oidCD);
        Long oidPeri = dtoE.getOidPeriodo();
        UtilidadesLog.debug("   - SAP601: oidPeri = " + oidPeri);
        
        if( oidCD != null && oidPeri != null ){     
            StringBuffer update = new StringBuffer();
        
            update.append(" UPDATE ape_asign_produ_anaqu_cabec SET ind_acti_fact = 'N' ");
            update.append(" WHERE ape_asign_produ_anaqu_cabec.oid_asig_prod_anaq_cabe IN ( ");
            update.append(" SELECT asigprodancabe.oid_asig_prod_anaq_cabe ");            
            update.append(" FROM ape_asign_produ_anaqu_cabec asigprodancabe, ");
            update.append(" ape_mapa_centr_distr_cabec mapcdcabe, ");
            update.append(" (select distinct mapDet.MZCA_OID_MAPA_ZONA_CABE ");
            update.append(" from APE_MAPA_ZONA_DETAL mapDet, APE_SUBLI_ARMAD subLin ");
            update.append(" where subLin.OID_SUBL_ARMA = mapDet.SBAR_OID_SUBL_ARMA ");
            update.append(" and subLin.LIAR_OID_LINE_ARMA= " + dtoE.getOidLineaArmado());
            update.append(" ) mapLin ");
            update.append(" WHERE mapcdcabe.ccdi_oid_conf_cent_dist = " + dtoE.getOidCentroDistribucion());
            update.append(" AND asigprodancabe.mcdc_oid_mapa_cent_dist_cabe = mapcdcabe.oid_mapa_cent_dist_cabe ");
            update.append(" AND asigprodancabe.mzca_oid_mapa_zona_cabe = mapLin.MZCA_OID_MAPA_ZONA_CABE ");
            update.append(" AND asigprodancabe.perd_oid_peri = " + dtoE.getOidPeriodo());
            update.append(" ) ");
            
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            try {
                bs.dbService.executeUpdate(update.toString());                        
                
            } catch (Exception ex) {
                
                ex.printStackTrace();
                throw new MareException(ex, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS ));
            
            }
        
        }
        
        UtilidadesLog.info("DAOAsignacionProductos.desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE): Salida");    
    }
    
    /**
     * Funciona de modo similar a armarQueryPaginacion
     * con la diferencia de que no altera ningun ORDER BY que ya tenga la query
     * (asume que la query recibida ya está ordenada por el campo OID)
     * @author dmorello (prolijamente en UtilidadesPaginacion)
     * @since 17-01-2007
     * @observacion 11/Jun/2007 eiraola - Este método pertenecía a UtilidadesPaginacion
     * de la versión Evolutiva, luego fue pisada dicha version con la Productiva... 
     * por lo tanto lo agrego localmente para evitar problemas de despliegue (desprolijamente).
     */
    public static String armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto) {
        
        Long ultLineaPresentada = dto.getIndicadorSituacion();
        Integer cantidadLineas = dto.getTamanioPagina();
  
        if ((ultLineaPresentada == null) || (cantidadLineas == null)) {
           return consultaOri;
        } else {
            StringBuffer salida = new StringBuffer();
  
           if ((consultaOri.toUpperCase().indexOf(" OID,") == -1) &&
                  (consultaOri.toUpperCase().indexOf(" OID ") == -1)) {
              throw new RuntimeException("Necesita tener un campo llamado OID");
           }
  
           salida.append("SELECT * FROM ( SELECT X.*, ");
           salida.append("CASE WHEN (("+ cantidadLineas + " -  COUNT(*)  OVER (PARTITION BY 1)) < 0) THEN 0 ELSE 1 END SICC_ES_ULTIMA_PAGINA ");
           salida.append("FROM (" + consultaOri + " )  X  WHERE ROWNUM <= " +(cantidadLineas.intValue()+1)+ "  AND OID > " +ultLineaPresentada+ ") Y ");
           salida.append(" WHERE ROWNUM <= " + cantidadLineas);
           salida.append(" and OID > " + ultLineaPresentada);
  
           return salida.toString();
        }
    }

    
    
    /**
     * Creado por incidencia BELC400000516
     * Busca un producto a partir de país y código SAP, filtrando por
     * indicador caja/bolsa NULO.
     * @author dmorello
     * @since 25/06/2007
     */
    public RecordSet buscarProducto(Long oidPais, String codigoSAP) throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.buscarProducto(Long oidPais, String codigoSAP): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM mae_produ ");
        query.append(" WHERE pais_oid_pais = ").append(oidPais);
        query.append("   AND cod_sap = '").append(codigoSAP).append('\'');
        /* BELC400000542 - dmorello 27/06/2007
         * Se elimina el sig filtro, volviendo atras el cambio de la inc BELC400000516 */
        //query.append("   AND cod_ind_dent_caja IS NULL");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOAsignacionProductos.buscarProducto(Long oidPais, String codigoSAP): Entrada");
        return rs;
    }

    /**
     * Creado por incidencia BELC400000652
     * Busca versiones de Asignacion producto anaquel cabecera activas para facturacion.
     * @author eiraola
     * @since 07/Sep/2007
     */
    public RecordSet obtenerVersionesAsignacionActiva(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOAsignacionProductos.obtenerVersionesAsignacionActiva(...dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT apac.OID_ASIG_PROD_ANAQ_CABE, apac.VAL_VERS ");
        query.append("  FROM APE_ASIGN_PRODU_ANAQU_CABEC apac ");
        //query.append(" WHERE apac.IND_ACTI_FACT = '"+ ConstantesAPE.ACTIVO_FACTURACION_S +"' ");
        //se saca el filtro de activo fact. x cbio. APE-02
        query.append(" WHERE 1 = 1");
        if (dtoe.getOidPeriodo() != null) {
            query.append("   AND apac.PERD_OID_PERI = " + dtoe.getOidPeriodo());
        }
        if (dtoe.getOidMapaCentroDistribucion() != null) {
            query.append("   AND apac.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCentroDistribucion());
        }
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.debug(" --- rs: " + rs);
        UtilidadesLog.info("DAOAsignacionProductos.obtenerVersionesAsignacionActiva(...dtoe): Salida");
        return rs;
    }
    public RecordSet lineaAFP(DTOMantenerEstimadosProducto dtoe)throws MareException{
        UtilidadesLog.info("DAOAsignacionProductos.lineaAFP(DTOMantenerEstimadosProducto dtoe): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT APE_LINEA_ARMAD.NUM_LINE_AFP, V_GEN_I18N_SICC.VAL_I18N, ");
        query.append("       V_GEN_I18N_SICC.VAL_OID   ");
        query.append(" FROM APE_LINEA_ARMAD, v_gen_i18n_sicc  ");
        query.append("      WHERE APE_LINEA_ARMAD.OID_LINE_ARMA =  " + dtoe.getOidLineaArmado());
        query.append("           AND  V_GEN_I18N_SICC.ATTR_ENTI = 'APE_LINEA_ARMAD' ");
        query.append("           AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
        query.append("            and V_GEN_I18N_SICC.VAL_OID = APE_LINEA_ARMAD.OID_LINE_ARMA ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.debug(" --- rs: " + rs);
        
        UtilidadesLog.info("DAOAsignacionProductos.lineaAFP(DTOMantenerEstimadosProducto dtoe): Salida");
        return rs;
    }
    public DTOSalida desProductoInt(DTOMantenerEstimadosProducto dtoe)throws MareException{
        UtilidadesLog.info("DAOAsignacionProductos.desProducto(DTOMantenerEstimadosProducto dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();                  
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();
        try{
                bs = BelcorpService.getInstance();
               
        } catch(Exception e ){                       
                   throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT  I18N.VAL_OID, I18N.VAL_I18N ");
        query.append("       FROM GEN_I18N_SICC I18N, MAE_PRODU  ");
        query.append("            WHERE I18N.ATTR_ENTI = 'MAE_PRODU' ");
        query.append("                  AND I18N.IDIO_OID_IDIO = 1  ");
        query.append("                  AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("                  AND I18N.VAL_OID = MAE_PRODU.OID_PROD ");
        query.append("                  AND MAE_PRODU.COD_SAP =  '" + dtoe.getCodigoProducto() + "'");
        try{
             rs = bs.dbService.executeStaticQuery(query.toString());
                  
        } catch (Exception ex) {
                  
                     throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if( !rs.esVacio() )
        {           
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAODetalleMAV.desProducto(DTODEtalleMav dtoe): Salida");
            return dtoSalida;                
        }else
        {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT + ErroresDeNegocio.REC_0010));
        }
        
    }

}