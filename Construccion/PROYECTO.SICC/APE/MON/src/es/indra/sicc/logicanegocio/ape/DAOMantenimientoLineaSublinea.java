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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ape.DTOBuscarSublineaArmado;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOTipoCajaProducto;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.dtos.ape.DTOSublineasLineaOrdenacion;

import java.math.BigDecimal;

import java.util.ArrayList;


public class DAOMantenimientoLineaSublinea {

    public DAOMantenimientoLineaSublinea() {
    }
    
    public DTOSalida buscarTipoCajaProducto(DTOTipoCajaProducto dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTipoCajaProducto(DTOTipoCajaProducto dtoe): Entrada");
        
        RecordSet rs = null;
        DTOSalida dtoSalida = null;
		    StringBuffer consulta = new StringBuffer("");	
        
        consulta.append(" select tcp.OID_TIPO_CAJA_PROD OID, ");
        consulta.append("        tcp.COD_CAJA, ");
        consulta.append(" 	     i.VAL_I18N DESCRIPCION ");
        consulta.append("   from APP_TIPO_CAJA_PRODU tcp, ");
        consulta.append("        v_gen_i18n_sicc i ");
        consulta.append("  where tcp.PAIS_OID_PAIS = " + dtoe.getOidPais());
        consulta.append("    and i.val_oid = tcp.OID_TIPO_CAJA_PROD ");
        consulta.append("    and i.attr_enti = 'APP_TIPO_CAJA_PRODU' ");
        consulta.append("    and i.attr_num_atri = 1 ");
        consulta.append("    and i.idio_oid_idio = " + dtoe.getOidIdioma());
        
        if (dtoe.getCodigoCaja() != null) {
            consulta.append("    and tcp.COD_CAJA like upper('" + dtoe.getCodigoCaja() + "') "); // Requisito general: Mayuscula para codigos alfanumericos
        }
        
        if (dtoe.getDescripcion() != null) {
            consulta.append("    and i.val_i18n like '" + dtoe.getDescripcion() + "' ");
        }
        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();	
        
        try {
            rs = bs.dbService.executeStaticQuery(
                    UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dtoe) );
        } catch (Exception e) {
            UtilidadesLog.error("buscarTipoCajaProducto: Exception", e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));						
        }
        
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {
            throw new MareException(null, null, 
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTipoCajaProducto(DTOTipoCajaProducto dtoe): Salida");
        dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        return dtoSalida;
    }
    
    
    /**
     * @author dmorello
     * @since 15/01/2007
     */
    public DTOSalida obtenerLineasArmadoCD(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasArmadoCD(DTOOID dtoe): Entrada");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        
				query.append(" SELECT linea.oid_line_arma, gen.val_i18n, linea.num_valo_defe ");
				query.append("   FROM ape_linea_armad linea, v_gen_i18n_sicc gen ");
				query.append("  WHERE linea.ccdi_oid_conf_cent_dist = ");
        query.append(dtoe.getOid());
				query.append("    AND linea.oid_line_arma = gen.val_oid ");
				query.append("    AND gen.idio_oid_idio = ");
        query.append(dtoe.getOidIdioma());
				query.append("    AND gen.attr_enti = 'APE_LINEA_ARMAD' ");
        // Se ordenan asi para que queden ordenados en el combo
        query.append(" ORDER BY val_i18n ASC ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("buscarTipoCajaProducto: Exception", e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));						
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasArmadoCD(DTOOID dtoe): Salida");
        return dtoSalida;
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 18/1/2007
   */
    public DTOSalida obtenerSublineasArmadoCD(DTOOID dtoe) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerSublineasArmadoCD"+
        "(DTOOID dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT SUBLINEA.OID_SUBL_ARMA , GEN.VAL_I18N ");
        query.append(" FROM APE_SUBLI_ARMAD SUBLINEA, V_GEN_I18N_SICC GEN ");
        query.append(" WHERE SUBLINEA.LIAR_OID_LINE_ARMA = " + dtoe.getOid());
        query.append(" AND SUBLINEA.OID_SUBL_ARMA = GEN.VAL_OID ");
        query.append(" AND GEN.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND GEN.ATTR_ENTI = 'APE_SUBLI_ARMAD' ");
        query.append(" ORDER BY GEN.VAL_I18N ASC ");
        
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
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerSublineasArmadoCD"+
        "(DTOOID dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
   /**
    * Recupera un codigo de linea nuevo que se utilizara para la insercion de 
    * una linea de armado. Para obtener dicho codigo suma una unidad al codigo 
    * mayor encontrado en la BBDD (APE_LINEA_ARMAD).
    * Tener en cuenta que puede generar facilmente error de codigo duplicado 
    * debido a uso en simultaneo del CU Insertar Linea de Armado (esta construido 
    * de acuerdo al DMCO).
    * @author eiraola
    * @date 18/01/2007
    */
    public Long obtenerProximoCodigoLinea() throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerProximoCodigoLinea(): Entrada");
        Long proximoCodigo = null;
        
        try {
            StringBuffer consulta = new StringBuffer("");
            consulta.append(" select max(num_codi_line) + 1 prox_codi_line ");
            consulta.append("   from ape_linea_armad ");
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();	
            
            RecordSet rs = bs.dbService.executeStaticQuery(consulta.toString());
            
            if (rs.esVacio() || rs.getValueAt(0, 0) == null) {
                proximoCodigo = new Long("1");
            } else {
                proximoCodigo = new Long(((BigDecimal)rs.getValueAt(0, 0)).longValue());
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("obtenerProximoCodigoLinea: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerProximoCodigoLinea(): Salida");
        return proximoCodigo;
    }
    
   /**
    * Recupera la informacion de Sistemas de picado cuya descripcion es 
    * internacionalizable. La tabla contiene datos fijos (no hay mantenimiento 
    * por sistema). La consulta no es paginada.
    * @author eiraola
    * @date 18/01/2007
    */
    public DTOSalida consultarSistemaPicado(DTOSiccPaginacion dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.consultarSistemaPicado(): Entrada");
        RecordSet rs = null;
        DTOSalida dtoSalida = new DTOSalida();
		    StringBuffer consulta = new StringBuffer("");	
        
        consulta.append(" select asp.oid_sist_pica OID, ");
        consulta.append("        asp.cod_sist_pica, ");
        consulta.append("        i.val_i18n as desc_sist_pica ");
        consulta.append("   from ape_siste_picad asp, ");
        consulta.append("        v_gen_i18n_sicc i ");
        consulta.append("  where i.attr_enti = 'APE_SISTE_PICAD' ");
        consulta.append("    and i.attr_num_atri = 1 ");
        consulta.append("    and i.idio_oid_idio = " + dtoe.getOidIdioma());
        consulta.append("    and i.val_oid = asp.oid_sist_pica ");
        // Agregado GPONS - 23/03/2007: Ordena el combo SistemaPicado 
        consulta.append("    order by desc_sist_pica ");
        // Fin Agregado
        
        try {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();	
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("consultarSistemaPicado: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));						
        }
        
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.consultarSistemaPicado(): Salida");
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       23/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOSalida obtenerLineasMapaCD(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasMapaCD(DTOOID dtoe): Entrada");
        
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

        query.append(" SELECT DISTINCT lin.OID_LINE_ARMA, i18n.VAL_I18N, lin.NUM_VALO_DEFE ");
        query.append(" FROM APE_MAPA_CENTR_DISTR_DETAL cendet, APE_LINEA_ARMAD lin, ");
        query.append(" APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
        query.append(" WHERE cendet.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA ");
        query.append(" AND sublin.LIAR_OID_LINE_ARMA = lin.OID_LINE_ARMA ");
        query.append(" AND cendet.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOid());
        query.append(" AND lin.OID_LINE_ARMA = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'APE_LINEA_ARMAD' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasMapaCD(DTOOID dtoe): Salida");
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       23/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOSalida obtenerSublineasLinea(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerSublineasLinea(DTOOID dtoe): Entrada");
        
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

        query.append(" SELECT sublin.OID_SUBL_ARMA, i18n.VAL_I18N ");
        query.append(" FROM APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
        query.append(" WHERE sublin.LIAR_OID_LINE_ARMA = " + dtoe.getOid());
        query.append(" AND sublin.OID_SUBL_ARMA = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'APE_SUBLI_ARMAD' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerSublineasLinea(DTOOID dtoe): Salida");
        return dtoSalida;
    }
    
    public DTOSalida obtenerProgramasCubicaje(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerProgramasCubicaje(): Entrada");
        
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

        query.append(" SELECT A.OID_PROG_CUBI AS OID, B.VAL_I18N AS DESCRIPCION ");
        query.append(" FROM APE_PROGR_CUBIC A, V_GEN_I18N_SICC B ");
        query.append(" WHERE ATTR_ENTI = 'APE_PROGR_CUBIC' ");
        query.append(" AND A.OID_PROG_CUBI = B.VAL_OID ");
        query.append(" AND B.IDIO_OID_IDIO = " + dtoE.getOidIdioma());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerProgramasCubicaje(): Salida");
        return dtoSalida;
    }


    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       30/01/2007
    * @version     1.0
    * @autor       gpons
    * Descripción: Obtiene los tipos de caja de la sublinea 
    */
    public DTOSalida buscarTipoCajaSublinea(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTipoCajaSublinea(DTOOID dtoe): Entrada");

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

        query.append(" SELECT tcs.OID_TIPO_CAJA_SUBL, tcs.NUM_CAJA, ");
        query.append(" tcs.TICP_OID_TIPO_CAJA_PROD, i18n.VAL_I18N DESCRIPCION ");
        query.append(" FROM APE_TIPO_CAJA_SUBLI tcs, v_gen_i18n_sicc i18n, ");
        query.append(" APP_TIPO_CAJA_PRODU tcp, APE_SUBLI_ARMAD sla ");        
        query.append(" WHERE tcs.SBAR_OID_SUBL_ARMA = " + dtoe.getOid());
        query.append(" AND tcs.TICP_OID_TIPO_CAJA_PROD = tcp.OID_TIPO_CAJA_PROD "); 
        query.append(" AND tcs.SBAR_OID_SUBL_ARMA = sla.OID_SUBL_ARMA ");
        query.append(" AND tcp.OID_TIPO_CAJA_PROD = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'APP_TIPO_CAJA_PRODU' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTipoCajaSublinea(DTOOID dtoe): Salida");
        return dtoSalida;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       30/01/2007
    * @version     1.0
    * @autor       gpons
    * Descripción: Recupera las sublineas de armado que se corresponden con los filtros recibidos. 
    */
    public DTOSalida buscarSublineasArmado(DTOBuscarSublineaArmado dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarSublineasArmado(DTOBuscarSublineaArmado dtoe): Entrada");

        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        
        query.append(" SELECT sla.OID_SUBL_ARMA OID, ");

        query.append(" ccd.OID_CONF_CENT_DIST , ");
        query.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
        query.append(" IDIO.attr_enti = 'APP_CONFI_CENTR_DISTR' AND IDIO.idio_oid_idio = ").append(dtoe.getOidIdioma());           
        query.append(" AND IDIO.val_oid = ccd.OID_CONF_CENT_DIST) as DESC_CENT_DIST, ");        

        query.append(" la.OID_LINE_ARMA , ");
        query.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
        query.append(" IDIO.attr_enti = 'APE_LINEA_ARMAD' AND IDIO.idio_oid_idio = ").append(dtoe.getOidIdioma());           
        query.append(" AND IDIO.val_oid = la.OID_LINE_ARMA) as DESC_LINEA_ARMADO, ");        

        query.append(" sla.COD_SUBL_ARMA, idioSL.val_i18n, ");        

        query.append(" sp.OID_SIST_PICA , ");        
        query.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
        query.append(" IDIO.attr_enti = 'APE_SISTE_PICAD' AND IDIO.idio_oid_idio = ").append(dtoe.getOidIdioma());           
        query.append(" AND IDIO.val_oid = sp.OID_SIST_PICA) as DESC_SIST_PICADO, ");  

        query.append(" sla.VAL_LETR_PARA_ANAQ, sla.IND_IMPR_LIST_PICA, sla.IND_POST_VENT, sla.IND_FREN_ESPA, ");                
        query.append(" sla.NUM_BAHI_FREN, sla.NUM_BAHI_ESPA, sla.NUM_NIVE_FREN, sla.NUM_NIVE_ESPA, ");                        
        query.append(" sla.NUM_COLU_FREN, sla. NUM_COLU_ESPA, sla.NUM_ORDE_BALA ");                        
        query.append(" , fiv.cod_impr , aai.num_impr_ptl, fiv.oid_impr "); //ciglesias incidencia 480
       
        query.append(" FROM APE_SUBLI_ARMAD sla, APE_LINEA_ARMAD la, V_GEN_I18N_SICC idioSL, ");
        query.append(" APE_SISTE_PICAD sp,  APP_CONFI_CENTR_DISTR ccd ");        
        query.append(" , APE_ASIGN_IMPRE aai , FAC_IMPRE_VIRTU fiv "); //ciglesias incidencia 480
       
        query.append(" WHERE sla.LIAR_OID_LINE_ARMA = la.OID_LINE_ARMA ");
        query.append(" AND sla.SIPI_OID_SIST_PICA = sp.OID_SIST_PICA "); 
        query.append(" AND la.CCDI_OID_CONF_CENT_DIST = ccd.OID_CONF_CENT_DIST "); 
        query.append(" AND idioSL.attr_enti = 'APE_SUBLI_ARMAD' AND idioSL.idio_oid_idio = ").append(dtoe.getOidIdioma());           
        query.append(" AND idioSL.val_oid = sla.OID_SUBL_ARMA ");   
        query.append(" AND aai.sbar_oid_subl_arma = sla.OID_SUBL_ARMA "); //ciglesias incidencia 480
        query.append(" AND fiv.oid_impr = aai.imvi_oid_impr "); //ciglesias incidencia 480

        
        if (dtoe.getLetraParaAnaquel() != ' ') {
            query.append(" AND sla.VAL_LETR_PARA_ANAQ = '" + dtoe.getLetraParaAnaquel() + "'");
        }
    
        if (dtoe.getCodigoSublinea() != null) {
            query.append(" AND sla.COD_SUBL_ARMA  = " + dtoe.getCodigoSublinea());
        }
        if (dtoe.getDescripcionSublinea() != null) {
            query.append(" AND idioSL.val_i18n LIKE '" + dtoe.getDescripcionSublinea() + "'"); 
        }        
        if (dtoe.getOidSistemaPicado() != null) {        
            query.append(" AND sla.SIPI_OID_SIST_PICA = " + dtoe.getOidSistemaPicado());
        }
        if (dtoe.getOidCentroDistribucion() != null) {        
            query.append(" AND la.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOidCentroDistribucion());        
        }
        if (dtoe.getOidLineaArmado() != null) {        
            query.append(" AND la.OID_LINE_ARMA = " + dtoe.getOidLineaArmado());                
        }
        if (dtoe.getImpresoraVirtual() != null) {
            query.append(" AND fiv.OID_IMPR = " + dtoe.getImpresoraVirtual());
        }
                
      
         String sqlPag = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
         RecordSet rs = null;
         String codigoError = null;

         try {
              rs = bs.dbService.executeStaticQuery(sqlPag);
         } catch (Exception e) {
               codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
               throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }
         if (rs.esVacio()) {
             UtilidadesLog.debug("****buscarTipoCajaSublinea: no hay datos ");
             codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(new Exception(),
                 UtilidadesError.armarCodigoError(codigoError));
         }
    
         DTOSalida dtoSalida = new DTOSalida();
         dtoSalida.setResultado(rs);
         
         UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTipoCajaSublinea(DTOBuscarSublineaArmado dtoE): Salida");                      
         return dtoSalida;
    }
           
 

    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       30/01/2007
    * @version     1.0
    * @autor       gpons
    * Descripción: Obtiene el primer código de sublinea disponible 
    */
    public Long obtenerProximoCodigoSublinea () throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerProximoCodigoSublinea(): Entrada");

        Long proximoCodigo = null;
        
        try {
            StringBuffer query = new StringBuffer("");
            query.append(" SELECT MAX(sla.COD_SUBL_ARMA) + 1 proxCodSublinea ");
            query.append("   FROM APE_SUBLI_ARMAD sla ");
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();	
            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());            
            
            if (rs.esVacio() || rs.getValueAt(0, 0) == null) {
                proximoCodigo = new Long("1");
            } else {
                proximoCodigo = new Long(((BigDecimal)rs.getValueAt(0, 0)).longValue());
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("obtenerProximoCodigoSublinea: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerProximoCodigoSublinea(): Salida");
        return proximoCodigo;        
    }
 
 
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       30/01/2007
    * @version     1.0
    * @autor       gpons
    * Descripción: Se obtienen los sistemas de etiquetado.
    */
  
    public DTOSalida obtenerSistemasEtiquetado(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerSistemasEtiquetado(DTOBelcorp dtoe): Entrada");

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

        query.append("SELECT sistEtiq.OID_SIST_ETIQ OID, ");
        query.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        query.append("IDIO.attr_enti = 'APE_SISTE_ETIQU' AND IDIO.idio_oid_idio =  ").append(dtoe.getOidIdioma());  
        query.append("AND IDIO.val_oid = sistEtiq.OID_SIST_ETIQ) as DESC_SISTE_ETIQU ");         
        query.append("FROM APE_SISTE_ETIQU sistEtiq ");
        query.append("ORDER BY DESC_SISTE_ETIQU ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerSistemasEtiquetado(DTOBelcorp dtoe): Salida");
        return dtoSalida;        
    }  



    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 6/2/2007
   */
   
   //Gpons - 12/03/07 - Inc. BELC400000223: Cambio Tipo Datos
    public ArrayList buscarSublineasCD(DTOOID dtoe) 
        throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarSublineasCD"+
        "(DTOOID dtoe): Entrada");
        
        ArrayList dtosSublinea = new ArrayList();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT ALA.OID_LINE_ARMA, ");
		query.append(" ASA.OID_SUBL_ARMA, ");
		query.append(" ASA.VAL_LETR_PARA_ANAQ, ");
		query.append(" ASA.IND_FREN_ESPA, ");
		query.append(" ASA.NUM_BAHI_FREN, ");
		query.append(" ASA.NUM_BAHI_ESPA, ");
		query.append(" ASA.NUM_NIVE_FREN, ");
		query.append(" ASA.NUM_NIVE_ESPA, ");
		query.append(" ASA.NUM_COLU_FREN, ");
		query.append(" ASA.NUM_COLU_ESPA ");
		query.append(" FROM APE_SUBLI_ARMAD ASA, ");
		query.append(" APE_LINEA_ARMAD ALA ");
		query.append(" WHERE ASA.LIAR_OID_LINE_ARMA = ALA.OID_LINE_ARMA ");
		query.append(" AND ALA.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOid());
		query.append(" ORDER BY ALA.OID_LINE_ARMA ");
        
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
        UtilidadesLog.debug("*********** cant " + cant);
        
        for(int i=0; i<cant; i++) {
            DTOSublineaArmado dtoSublinea = new DTOSublineaArmado();
            
            dtoSublinea.setOid(new Long(((BigDecimal)rs.getValueAt(i, "OID_SUBL_ARMA")).longValue()));            
            
            String strLetra = (String)rs.getValueAt(i, "VAL_LETR_PARA_ANAQ");
            char letra = strLetra.charAt(0);
            dtoSublinea.setLetraParaAnaquel(letra);
            
            String strFrenteEspalda = ((BigDecimal)rs.getValueAt(i, "IND_FREN_ESPA")).toString();
            Boolean frenteEspalda;
            if(strFrenteEspalda.equals("1")) {
                frenteEspalda = new Boolean(true);
            }
            else {
                frenteEspalda = new Boolean(false);
            }           
            
            dtoSublinea.setFrenteEspalda(frenteEspalda);            
            
            dtoSublinea.setBahiasFrente(new Integer(((BigDecimal)rs.getValueAt(i, "NUM_BAHI_FREN")).intValue()));
            
            if(rs.getValueAt(i, "NUM_BAHI_ESPA")!=null) {
                dtoSublinea.setBahiaEspalda(new Integer(((BigDecimal)rs.getValueAt(i, "NUM_BAHI_ESPA")).intValue()));    
            }
            
            dtoSublinea.setNumeroNivelesFrente(new Integer(((BigDecimal)rs.getValueAt(i, "NUM_NIVE_FREN")).intValue()));
            
            if(rs.getValueAt(i, "NUM_NIVE_ESPA")!=null) {
                dtoSublinea.setNumeroNivelesEspalda(new Integer(((BigDecimal)rs.getValueAt(i, "NUM_NIVE_ESPA")).intValue()));    
            }
                
            dtoSublinea.setNumeroColumnasFrente(new Integer(((BigDecimal)rs.getValueAt(i, "NUM_COLU_FREN")).intValue()));
            
            if(rs.getValueAt(i, "NUM_COLU_ESPA")!=null) {
                dtoSublinea.setNumeroColumnasEspalda(new Integer(((BigDecimal)rs.getValueAt(i, "NUM_COLU_ESPA")).intValue()));          
            }  
            
            dtosSublinea.add(dtoSublinea);   
        }
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarSublineasCD"+
        "(DTOOID dtoe): Entrada");
        
        return dtosSublinea;    
    }

    public DTOSalida recuperarTiposSolicitudLinea(DTOOID dtoE) throws MareException{
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarTiposSolicitudLinea(DTOParamBalanceoAreaChequeo  dtoE): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT apetsolp.tspa_oid_tipo_soli_pais OID, ");
        query.append("       (SELECT (SELECT val_i18n ");
        query.append("                  FROM v_gen_i18n_sicc ");
        query.append("                 WHERE attr_enti = 'PED_TIPO_SOLIC' ");
        query.append("                   AND idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        query.append("                   AND val_oid = pedtsolp.tsol_oid_tipo_soli) ");
        query.append("          FROM PED_TIPO_SOLIC_PAIS pedtsolp ");
        query.append("         WHERE pedtsolp.oid_tipo_soli_pais = apetsolp.tspa_oid_tipo_soli_pais) descripcion ");
        query.append("  FROM APE_TIPO_SOLIC_LINEA apetsolp ");
        query.append(" WHERE apetsolp.liar_oid_line_arma = "+dtoE.getOid()+" ");

        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs.getRowCount(): " + rs.getRowCount());
        
        if (rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarTiposSolicitudLinea(DTOParamBalanceoAreaChequeo dtoE): Salida");
        return dtoSalida;
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 13/2/2007
   */
    public DTOSalida obtenerLineasArmadoCDNoAFP(DTOOID dtoe) 
        throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasArmadoCDNoAFP"+
        "(DTOOID dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT LINEA.OID_LINE_ARMA,GEN.VAL_I18N,LINEA.NUM_VALO_DEFE ");
        query.append(" FROM APE_LINEA_ARMAD LINEA,V_GEN_I18N_SICC GEN ");
        query.append(" WHERE LINEA.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOid());
        
        /*
        query.append(" AND LINEA.NUM_LINE_AFP = 0 ");  //  Inc. 24708 cambia nombre de campo de NUM_LINE a NUM_LINE_AFP
        SCS - 12/07/2007, se elimina x inc.: BELC400000570 
        */
        
        query.append(" AND LINEA.OID_LINE_ARMA = GEN.VAL_OID ");
        query.append(" AND GEN.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND GEN.ATTR_ENTI = 'APE_LINEA_ARMAD' ");
        query.append(" ORDER BY VAL_I18N ASC ");
        
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
        
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasArmadoCDNoAFP"+
        "(DTOOID dtoe): Salida");
        
        return dtoSalida;    
    }

   /**
    * Consulta para cargar el combo de Lineas de Armado de tipo Fuera de Pedido.
    * @author eiraola
    * @date 23/02/2007
    */
    public DTOSalida obtenerLineasArmadoCDAFP(DTOOID dtoe) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasArmadoCDAFP (DTOOID dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT LINEA.OID_LINE_ARMA, GEN.VAL_I18N, LINEA.NUM_VALO_DEFE ");
        query.append(" FROM APE_LINEA_ARMAD LINEA, V_GEN_I18N_SICC GEN ");
        query.append(" WHERE LINEA.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOid());
        query.append(" AND LINEA.NUM_LINE_AFP = 1 ");
        query.append(" AND LINEA.OID_LINE_ARMA = GEN.VAL_OID ");
        query.append(" AND GEN.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" AND GEN.ATTR_ENTI = 'APE_LINEA_ARMAD' ");
        query.append(" AND GEN.ATTR_NUM_ATRI = 1 ");
        query.append(" ORDER BY VAL_I18N ASC ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasArmadoCDNoAFP (DTOOID dtoe): Salida");
        return dtoSalida;    
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       13/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOSalida obtenerLineasMapaZona(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasMapaZona(DTOOID dtoe): Entrada");
        
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

        query.append(" SELECT DISTINCT lin.OID_LINE_ARMA, i18n.VAL_I18N ");
        query.append(" FROM APE_MAPA_ZONA_DETAL mapDet, APE_LINEA_ARMAD lin, ");
        query.append(" APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
        query.append(" WHERE mapDet.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA ");
        query.append(" AND sublin.LIAR_OID_LINE_ARMA = lin.OID_LINE_ARMA ");
        query.append(" AND mapDet.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getOid());
        query.append(" AND lin.OID_LINE_ARMA = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'APE_LINEA_ARMAD' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineasMapaZona(DTOOID dtoe): Salida");
        return dtoSalida;
    }


    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       13/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOSalida obtenerUsuariosAlarmaLinea(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerUsuariosALarmaLinea(DTOOID dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT OID_USUA_ALAR_LINE as OID, VAL_MAIL as MAIL ");
        query.append(" FROM APE_USUAR_ALARM_LINEA ");
        query.append(" WHERE LIAR_OID_LINE_ARMA = " + dtoE.getOid());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerUsuariosALarmaLinea(DTOOID dtoe): Salida");
        return dtoSalida;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       13/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOSalida obtenerDescripcionesLineas(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerDescripcionesLineas(DTOBelcorp dtoe): Entrada");
        
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

        query.append(" SELECT A.OID_LINE_ARMA AS OID, B.VAL_I18N AS DESCRIPCION ");
        query.append(" FROM APE_LINEA_ARMAD A, V_GEN_I18N_SICC B ");
        query.append(" WHERE B.ATTR_ENTI = 'APE_LINEA_ARMAD' ");
        query.append(" AND B.VAL_OID = A.OID_LINE_ARMA ");
        query.append(" AND B.IDIO_OID_IDIO = " + dtoE.getOidPais());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerDescripcionesLineas(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       14/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOLineaArmado obtenerLineaArmadoDefaultCD(DTOConfiguracionCentroDistribucion dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineaArmadoDefaultCD(DTOConfiguracionCentroDistribucion dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        /* dmorello, 27/04/2007: Agrego recuperación de descripción I18N */
        query.append(" SELECT A.* ");
        query.append("      , gen.val_i18n ");
        query.append(" FROM APE_LINEA_ARMAD A, APP_CONFI_CENTR_DISTR B ");
        query.append("    , V_GEN_I18N_SICC GEN ");
        query.append(" WHERE A.NUM_VALO_DEFE = 1 ");
        query.append(" AND B.OID_CONF_CENT_DIST = " + dtoE.getOidCentroDistribucion());
        query.append(" AND B.OID_CONF_CENT_DIST = A.CCDI_OID_CONF_CENT_DIST ");
        query.append(" AND gen.attr_enti = 'APE_LINEA_ARMAD' ");
        query.append(" AND gen.idio_oid_idio  = ").append(dtoE.getOidIdioma());
        query.append(" AND val_oid = A.oid_line_arma ");
        

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
        
        if (!rs.esVacio()) 
        {
          BigDecimal bd = (BigDecimal)rs.getValueAt(0, "OID_LINE_ARMA");
          dtoLineaArmado.setOid(new Long(bd.longValue()));
          /* dmorello, 27/04/2007 */
          dtoLineaArmado.setDescripcion(rs.getValueAt(0, "VAL_I18N").toString());
        }

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerLineaArmadoDefaultCD(DTOConfiguracionCentroDistribucion dtoe): Salida");
        return dtoLineaArmado;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       14/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOSalida buscarLineasArmado(DTOLineaArmado dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarLineasArmado(DTOLineaArmado dtoe): Entrada");
        
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

        query.append(" SELECT A.OID_LINE_ARMA AS OID, ");
        query.append(" 	   C.VAL_I18N AS DESCRIPCIONCD,  ");
        query.append(" 	   A.NUM_CODI_LINE AS CODIGO, ");
        query.append(" 	   B.VAL_I18N AS DESCRIPCION, ");
        //query.append(" 	   A.VAL_IMPR_LIST_PICA AS IMPRIMIR, "); //ciglesias incidencia 356
        query.append(" 	   A.NUM_LINE_AFP AS LINEAAFP, ");
        query.append(" 	   A.NUM_VALO_DEFE AS DEFECTO, ");
        //query.append("	   e.val_i18n AS PROGRAMA, "); // Eliminado eiraola incidencia 476
        query.append(" 	   A.NUM_LONG_NUME_ETIQ AS LONGITUD, ");
        //query.append(" 	   A.VAL_FORM_ETIQ AS ETIQUETAS, "); //ciglesias incidencia 374
        query.append(" 	   A.NUM_ETIQ NUMETIQUETAS, ");
        query.append("	   D.OID_CONF_CENT_DIST as OIDCD, ");
        query.append("	   A.SICJ_OID_PROG_CUBI AS OIDPROG ");
        query.append(" FROM APE_LINEA_ARMAD A, ");
        query.append(" 	 V_GEN_I18N_SICC B, ");
        query.append(" 	 V_GEN_I18N_SICC C,");
        query.append("	 APP_CONFI_CENTR_DISTR D ");
        //query.append("	 V_GEN_I18N_SICC E "); // Eliminado eiraola incidencia 476
        query.append("WHERE B.ATTR_ENTI = 'APE_LINEA_ARMAD' ");
        query.append("	  AND C.ATTR_ENTI = 'APP_CONFI_CENTR_DISTR' ");
        //query.append("	  AND E.ATTR_ENTI = 'APE_PROGR_CUBIC' "); // Eliminado eiraola incidencia 476
        query.append("	  AND B.VAL_OID = A.OID_LINE_ARMA ");
        query.append(" 	  AND A.CCDI_OID_CONF_CENT_DIST = D.OID_CONF_CENT_DIST ");
        query.append(" 	  AND C.VAL_OID = D.OID_CONF_CENT_DIST ");
        query.append(" 	  AND C.IDIO_OID_IDIO = B.IDIO_OID_IDIO ");
        query.append(" 	  AND B.IDIO_OID_IDIO = " + dtoE.getOidIdioma());
        //query.append("	  AND E.VAL_OID = A.SICJ_OID_PROG_CUBI "); // Eliminado eiraola incidencia 476
        //query.append("	  AND E.IDIO_OID_IDIO = 1 "); // Eliminado eiraola incidencia 476

        if (dtoE.getDescripcion() != null) {
          query.append(" 	  AND B.VAL_I18N = '" + dtoE.getDescripcion() + "' ");
        }
        
        if (dtoE.getCentroDistribucion().getDescripcion() != null) {
          query.append(" 	  AND C.VAL_I18N = '" + dtoE.getCentroDistribucion().getDescripcion() + "' ");
        }
        
        if (dtoE.getCodigoLinea() != null) {
          query.append(" 	  AND A.NUM_CODI_LINE = " + dtoE.getCodigoLinea());
        }

        try {
            rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(
                    query.toString(), dtoE));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerDescripcionesLineas(DTOLineaArmado dtoe): Salida");
        return dtoSalida;
    }
  
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       15/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOSalida buscarTSLporLinea(Long oid) throws MareException 
    {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTSLporLinea(Lond oid): Entrada");
        
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

        query.append(" SELECT OID_TIPO_SOLI_LINE FROM APE_TIPO_SOLIC_LINEA ");
        query.append(" WHERE LIAR_OID_LINE_ARMA = " + oid);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarTSLporLinea(Long oid): Salida");
        return dtoSalida;
      
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       15/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOSalida buscarUALporLinea(Long oid) throws MareException 
    {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarUALporLinea(Long oid): Entrada");
        
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

        query.append(" SELECT OID_USUA_ALAR_LINE FROM APE_USUAR_ALARM_LINEA ");
        query.append(" WHERE LIAR_OID_LINE_ARMA = " + oid);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarUALporLinea(Long oid): Salida");
        return dtoSalida;
      
    }
    
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       20/02/2007
    * @version     1.0
    * @autor       Carlos Iglesias
    */
    public DTOSalida obtenerTiposSolicitudLinea(DTOOID dtoE) throws MareException 
    {
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerTiposSolicitudLinea(DTOOID dtoE): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT A.OID_TIPO_SOLI_LINE AS OID, ");
        query.append(" 	   A.TSPA_OID_TIPO_SOLI_PAIS  AS OIDPAIS, ");
        query.append(" 	   B.VAL_GLOS AS DESCRIPCION ");
        query.append(" FROM APE_TIPO_SOLIC_LINEA A, PED_TIPO_SOLIC_PAIS B ");
        query.append(" WHERE LIAR_OID_LINE_ARMA = " + dtoE.getOid());
        query.append(" AND A.TSPA_OID_TIPO_SOLI_PAIS = B.OID_TIPO_SOLI_PAIS ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOSalida dtoSalida = new DTOSalida();
        if (!rs.esVacio()) {
          dtoSalida.setResultado(rs);
        }
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.obtenerTiposSolicitudLinea(DTOOID dtoE): Salida");
        return dtoSalida;
    }
    
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 26/2/2007
   */
    public DTOSalida recuperarSublineasLinea(DTOOID dtoe) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarSublineasLinea"+
        "(DTOOID dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT sublin.OID_SUBL_ARMA, i18n.VAL_I18N ");
        query.append(" FROM APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
        query.append(" WHERE sublin.LIAR_OID_LINE_ARMA = " + dtoe.getOid());
        query.append(" AND sublin.OID_SUBL_ARMA = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1 ");
        query.append(" AND i18n.attr_enti = 'APE_SUBLI_ARMAD' ");
        query.append(" ORDER BY sublin.NUM_ORDE_BALA ");
        
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
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarSublineasLinea"+
        "(DTOOID dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
  /** 
   * Autor: vbongiov
   * Fecha: 30/08/2007
   */
  public DTOSalida recuperarSublineasLineaBalanceo(DTOSublineasLineaOrdenacion dtoe) throws MareException {  
      UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarSublineasLineaBalanceo(DTOOID dtoe): Entrada");
      
      DTOSalida dtoSalida = new DTOSalida();
      BelcorpService bs;
      RecordSet rs;
      String codigoError;
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT sublin.OID_SUBL_ARMA, i18n.VAL_I18N, sublin.NUM_ORDE_BALA ");
      query.append(" FROM APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
      query.append(" WHERE sublin.LIAR_OID_LINE_ARMA = " + dtoe.getOidLinea());
      query.append(" AND EXISTS (SELECT 1 ");
      query.append(" FROM APE_ORDEN_ANAQU_CABEC cab, APE_ORDEN_ANAQU_DETAL det, APE_MAPA_CENTR_DISTR_DETAL mcdet ");
      query.append(" WHERE cab.OID_ANAQ_CABE = " + dtoe.getOidOrdenAnaquelCab());
      query.append(" AND cab.LIAR_OID_LINE_ARMA = sublin.LIAR_OID_LINE_ARMA ");
      query.append(" AND det.OACA_OID_ANAQ_CABE = cab.OID_ANAQ_CABE ");
      query.append(" AND det.MCDD_OID_MAPA_CENT_DIST_DETA = mcdet.OID_MAPA_CENT_DIST_DETA ");
      query.append(" AND mcdet.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA) ");
      query.append(" AND sublin.OID_SUBL_ARMA = i18n.VAL_OID ");
      query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
      query.append(" AND i18n.attr_num_atri = 1 ");
      query.append(" AND i18n.attr_enti = 'APE_SUBLI_ARMAD' ");
      query.append(" ORDER BY sublin.NUM_ORDE_BALA ");
      
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
      
      dtoSalida.setResultado(rs);
      
      UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarSublineasLineaBalanceo(DTOOID dtoe): Salida");
      return dtoSalida;    
  }
  
  /** 
   * Autor: vbongiov
   * Fecha: 30/08/2007
   */
  public DTOSalida recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe): Entrada");
      
      DTOSalida dtoSalida = new DTOSalida();
      BelcorpService bs;
      RecordSet rs;
      String codigoError;
      StringBuffer query = new StringBuffer();
      
      if(dtoe.getOidOrdenAnaquelCab()==null){
      
          query.append(" SELECT sublin.OID_SUBL_ARMA, i18n.VAL_I18N,'NO' ORDENADO, '' ANAQUELES ");
          query.append(" FROM APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
          query.append(" WHERE sublin.LIAR_OID_LINE_ARMA = " + dtoe.getOidLinea());
          query.append(" AND sublin.OID_SUBL_ARMA = i18n.VAL_OID ");
          query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
          query.append(" AND i18n.attr_num_atri = 1 ");
          query.append(" AND i18n.attr_enti = 'APE_SUBLI_ARMAD' ");
          query.append(" ORDER BY i18n.VAL_I18N ");          
      
          try {
              bs = BelcorpService.getInstance();
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          } catch (Exception e) {
              UtilidadesLog.error("ERROR ", e);
              codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          }
          
          dtoSalida.setResultado(rs);
      
      } else {
      
          query.append(" SELECT sublin.OID_SUBL_ARMA, i18n.VAL_I18N, sublinAnq.MCDD_OID_MAPA_CENT_DIST_DETA, ");
          query.append(" sublinAnq.NUM_ANAQ, sublinAnq.NUM_ORDE, ");
          query.append(" sublinAnq.IND_EXPA, sublinAnq.NUM_ANAQ_DEST ");
          query.append(" FROM APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n, ");
          query.append(" (SELECT mcdet.SBAR_OID_SUBL_ARMA, det.MCDD_OID_MAPA_CENT_DIST_DETA, mcdet.NUM_ANAQ, det.NUM_ORDE, ");
          query.append(" nvl(mcdet.IND_EXPA,0) IND_EXPA, nvl(mcdet1.NUM_ANAQ, 'BLANCO') NUM_ANAQ_DEST  ");
          query.append(" FROM APE_ORDEN_ANAQU_DETAL det, APE_MAPA_CENTR_DISTR_DETAL mcdet, APE_MAPA_CENTR_DISTR_DETAL mcdet1 ");
          query.append(" WHERE det.OACA_OID_ANAQ_CABE = " + dtoe.getOidOrdenAnaquelCab());
          query.append(" AND det.MCDD_OID_MAPA_CENT_DIST_DETA = mcdet.OID_MAPA_CENT_DIST_DETA ");
          query.append(" AND mcdet.MCDD_OID_MAPA_CENT_DIST_DETA = mcdet1.OID_MAPA_CENT_DIST_DETA(+) ) sublinAnq ");
          query.append(" WHERE sublin.LIAR_OID_LINE_ARMA = " + dtoe.getOidLinea());          
          query.append(" AND sublinAnq.SBAR_OID_SUBL_ARMA(+) = sublin.OID_SUBL_ARMA ");          
          query.append(" AND sublin.OID_SUBL_ARMA = i18n.VAL_OID ");
          query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
          query.append(" AND i18n.attr_num_atri = 1 ");
          query.append(" AND i18n.attr_enti = 'APE_SUBLI_ARMAD' ");
          query.append(" ORDER BY i18n.VAL_I18N, sublinAnq.NUM_ANAQ ");          
      
          try {
              bs = BelcorpService.getInstance();
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          } catch (Exception e) {
              UtilidadesLog.error("ERROR ", e);
              codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          }
      
          int cant = rs.getRowCount();
      
          RecordSet rsSalida = new RecordSet();         
          rsSalida.addColumn("OID_SUBL_ARMA");
          rsSalida.addColumn("VAL_I18N");
          rsSalida.addColumn("ORDENADO");
          rsSalida.addColumn("ANAQUELES");
          
          BigDecimal oidSubLineaAnt = null;
          BigDecimal oidSubLineaAct = null;
          BigDecimal oidAnaquel = null;
          String subLinDesc = null;
          String ordenado= "";
          StringBuffer anaqueles = new StringBuffer();
                    
          for(int i=0; i<cant; i++){
                          
             oidSubLineaAct = (BigDecimal)rs.getValueAt(i,"OID_SUBL_ARMA");
             UtilidadesLog.debug("oidSubLineaAct: "+ oidSubLineaAct);
             
             if(i==0){
                oidSubLineaAnt = new BigDecimal(oidSubLineaAct.toString());
             }
             
             UtilidadesLog.debug("oidSubLineaAnt: "+ oidSubLineaAnt);
             
             if(oidSubLineaAct.equals(oidSubLineaAnt)){
             
                UtilidadesLog.debug("Iguales");
                
               if((BigDecimal)rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")==null){
                  UtilidadesLog.debug("null anaquel");
                  ordenado= "NO";
                  oidSubLineaAnt = new BigDecimal(oidSubLineaAct.toString());
                  subLinDesc = (String)rs.getValueAt(i,"VAL_I18N");
                  
                  if(i==(cant-1)){
                      rsSalida.addRow(new Object[] {
                                    oidSubLineaAct.toString(), 
                                    subLinDesc,
                                    ordenado
                      }); 
                  }
                  
               } else {
                  UtilidadesLog.debug("no null anaquel");
                  ordenado= "SI";
                  subLinDesc = (String)rs.getValueAt(i,"VAL_I18N");
                  
                  anaqueles.append("|").append(((BigDecimal)rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")).toString());
                  anaqueles.append("#").append((String)rs.getValueAt(i,"NUM_ANAQ"));
                  anaqueles.append("#").append(((BigDecimal)rs.getValueAt(i,"NUM_ORDE")).toString());
                  anaqueles.append("#").append(((BigDecimal)rs.getValueAt(i,"IND_EXPA")).toString());
                  anaqueles.append("#").append((String)rs.getValueAt(i,"NUM_ANAQ_DEST"));
                  
                  if(i==(cant-1)){
                      rsSalida.addRow(new Object[] {
                                    oidSubLineaAct.toString(), 
                                    subLinDesc,
                                    ordenado,
                                    anaqueles.toString().substring(1)
                      }); 
                  }
               } 
               
             } else {
                UtilidadesLog.debug("guardo registro");
                rsSalida.addRow(new Object[] {
                                    oidSubLineaAnt.toString(), 
                                    (String)rs.getValueAt(i-1,"VAL_I18N"),
                                    ordenado,
                                    anaqueles.toString().equals("")?"":anaqueles.toString().substring(1)
                      }); 
                      
                anaqueles = new StringBuffer();
                
                if((BigDecimal)rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")==null){
                    UtilidadesLog.debug("no anaq");
                    ordenado= "NO";
                    oidSubLineaAnt = new BigDecimal(oidSubLineaAct.toString());
                    subLinDesc = (String)rs.getValueAt(i,"VAL_I18N");
                    
                    if(i==(cant-1)){
                        rsSalida.addRow(new Object[] {
                                      oidSubLineaAct.toString(), 
                                      subLinDesc,
                                      ordenado
                        }); 
                    }
                    
                 } else {
                    ordenado= "SI";
                    oidSubLineaAnt = new BigDecimal(oidSubLineaAct.toString());
                    subLinDesc = (String)rs.getValueAt(i,"VAL_I18N");
                    anaqueles.append("|").append(((BigDecimal)rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")).toString());
                    anaqueles.append("#").append((String)rs.getValueAt(i,"NUM_ANAQ"));
                    anaqueles.append("#").append(((BigDecimal)rs.getValueAt(i,"NUM_ORDE")).toString());
                    anaqueles.append("#").append(((BigDecimal)rs.getValueAt(i,"IND_EXPA")).toString());
                    anaqueles.append("#").append((String)rs.getValueAt(i,"NUM_ANAQ_DEST"));
                    
                    if(i==(cant-1)){
                        rsSalida.addRow(new Object[] {
                                      oidSubLineaAct.toString(), 
                                      subLinDesc,
                                      ordenado,
                                      anaqueles.toString().substring(1)
                        }); 
                    }
                 } 
             }
          }
          
          UtilidadesLog.debug("rsSalida: "+ rsSalida);
          dtoSalida.setResultado(rsSalida);
      
      }
      
      UtilidadesLog.info("DAOMantenimientoLineaSublinea.recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe): Salida");
      return dtoSalida;    
  }
    
  /** 
   * Autor: ciglesias
   * Fecha: 01/03/2007
   */
    public Long[] buscarSTLEliminar(Long oids[], Long oidLinea) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarSTLElimanr Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        String elementos = "( " + oids[0];
        
        for (int j = 1; j < oids.length; j++) 
        {
          elementos = elementos + ", " + oids[j];
        }
        
        elementos = elementos + " )";
        
        query.append(" SELECT OID_TIPO_SOLI_LINE FROM APE_TIPO_SOLIC_LINEA ");
        query.append(" WHERE TSPA_OID_TIPO_SOLI_PAIS IN " + elementos);
        query.append(" AND LIAR_OID_LINE_ARMA = " + oidLinea);
        
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
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.buscarSTLElimanr Salida");
        
        if (!rs.esVacio()) 
        {
          Long salida[] = new Long[rs.getRowCount()];
          for(int i = 0; i < rs.getRowCount(); i++) 
          {
            salida[i] = new Long(((BigDecimal)rs.getValueAt(i,0)).toString());
          }
          return salida;
        }else 
        {
          return null;
        }
    }    
 
  /** 
   * Autor: ciglesias
   * Fecha: 01/06/2007
   */
    public DTOSalida consultaCodigosImpresora() throws MareException {             
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.consultaCodigosImpresora Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT OID_IMPR, COD_IMPR FROM FAC_IMPRE_VIRTU A ");
        query.append(" WHERE A.IND_ESTA_ACTI = 1 ");
        query.append(" ORDER BY COD_IMPR ");
        
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
        
        UtilidadesLog.info("DAOMantenimientoLineaSublinea.consultaCodigosImpresora Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;
    }    
}