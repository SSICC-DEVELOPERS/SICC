/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *obtenerOperacionesReclamo
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclobtenerClientesIntroducirusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOBloqueoTipoOperacionREC;
import es.indra.sicc.dtos.rec.DTOBuscarClientesREC;
import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.dtos.rec.DTOBuscarProductosDevuelveNoREC;
import es.indra.sicc.dtos.rec.DTOBuscarProductosREC;
import es.indra.sicc.dtos.rec.DTOBuscarReclamosREC;
import es.indra.sicc.dtos.rec.DTODatosClienteREC;
import es.indra.sicc.dtos.rec.DTODatosDocumentoREC;
import es.indra.sicc.dtos.rec.DTODetalleReclamosREC;
import es.indra.sicc.dtos.rec.DTODocumentoReferenciaREC;
import es.indra.sicc.dtos.rec.DTOIndicadoresOperacionREC;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;
import es.indra.sicc.dtos.rec.DTOOperacion;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.ejb.SessionContext;

public class DAOCapturaProcesoReclamos  {
    private String usuario;
    SessionContext ctx = null;
    
    public DAOCapturaProcesoReclamos() {
    }
    
    public DAOCapturaProcesoReclamos(String usuario){
        this.usuario = usuario;
    }
    
    public DAOCapturaProcesoReclamos(SessionContext ctx) {
      this.ctx= ctx;
    }
    
    public RecordSet obtenerAsumePerdida (DTOBelcorp dtoE) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerAsumePerdida(DTOBelcorp):Entrada");
        
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        
        //SELECT
        sql.append(" SELECT OID_ASUM_PERD as OID,  idio.VAL_I18N as DESCRIPCION  ");
        //FROM
        sql.append(" FROM REC_ASUME_PERDI,V_GEN_I18N_SICC idio "); 
        //WHERE
        sql.append(" WHERE  idio.VAL_OID = OID_ASUM_PERD "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.ATTR_ENTI = 'REC_ASUME_PERDI' ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerAsumePerdida: Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
                                                                       
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerAsumePerdida(DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerPrecioCalculo (DTOBelcorp dtoE) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerPrecioCalculo(DTOBelcorp):Entrada");
        
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        //SELECT
        sql.append(" SELECT OID_PREC_PERD as OID,  idio.VAL_I18N as DESCRIPCION  ");
        //FROM
        sql.append(" FROM REC_PRECI_PERDI, V_GEN_I18N_SICC idio "); 
        //WHERE
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_PRECI_PERDI' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = OID_PREC_PERD ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerPrecioCalculo: Exception",e);                                                  
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }     

        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerPrecioCalculo(DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerClientesREC (DTOBuscarClientesREC dtoE) throws MareException{
        //BELC300015514
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerClientesREC (DTOBuscarClientesREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        //Select
        sql.append(" SELECT * FROM ( ");
        sql.append(" SELECT mc.OID_CLIE as OID, mc.COD_CLIE as CODIGOCLIENTE, ");
        sql.append(" mc.VAL_NOM1 as NOMBRE, mc.VAL_APE1 as APELLIDOPATERNO, ");
        sql.append(" mc.VAL_APE2 as APELLIDOMATERNO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_CLIEN' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = ct.TICL_OID_TIPO_CLIE) as DESCRIPCIONTIPOCLIENTE, ");
        sql.append(" ct.TICL_OID_TIPO_CLIE as OIDTIPOCLIENTE, ");
        sql.append(" pn.PPER_OID_PREC_PERD as OIDPRECIOCALCULO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_PRECI_PERDI' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = pn.PPER_OID_PREC_PERD) as DESCPRECIOCALCULO, ");
        sql.append(" pn.VAL_PORC_RECA as PORCENTRECARGO, ");
        sql.append(" pn.IND_PARA_MODI as PARAMMODIFICACION ");

        //FROM
        sql.append(" FROM MAE_CLIEN mc,  ");
        sql.append("     (SELECT clie_oid_clie, ticl_oid_tipo_clie ");
        sql.append("        FROM mae_clien_tipo_subti ct ");
        if (dtoE.getOidTipoCliente() != null){
            sql.append("  WHERE ct.ticl_oid_tipo_clie = ? ");
            parametros.add(dtoE.getOidTipoCliente());
        }
        sql.append(" ) ct, (SELECT DISTINCT pn.val_porc_reca, pn.ind_para_modi, ");
        sql.append("                        pn.pper_oid_prec_perd, ");
        sql.append("                        pn.ticl_oid_tipo_clie ");
        sql.append("          FROM rec_param_nmper pn ");
        sql.append("         WHERE pn.pais_oid_pais = ? ) pn ");
        parametros.add(dtoE.getOidPais());
        //WHERE
        sql.append(" WHERE mc.OID_CLIE = ct.CLIE_OID_CLIE AND ");
        sql.append(" ct.TICL_OID_TIPO_CLIE = pn.TICL_OID_TIPO_CLIE ");
      //  sql.append(" AND pn.PAIS_OID_PAIS = ?  "); modificado por bloqueante
 
        
        if (dtoE.getCodigoCliente() != null){
            /*
             * Modificado por ssantana, 09/03/2006
             * No funciona con '?'. 
             */
            /* sql.append(" AND mc.COD_CLIE = '" + "?" + "' ");
            parametros.add(dtoE.getCodigoCliente());  */
            sql.append(" AND mc.COD_CLIE = '" + dtoE.getCodigoCliente() + "' ");
            
        }
        
        if (dtoE.getNombre() != null){
            sql.append(" AND mc.VAL_NOM1 LIKE '" + dtoE.getNombre() + "' ");
            
        }
        
        if (dtoE.getApellidoPaterno() != null){
            sql.append(" AND mc.VAL_APE1 LIKE '" + dtoE.getApellidoPaterno() + "' ");
            
        }
        
        if (dtoE.getApellidoMaterno() != null){
            sql.append(" AND mc.VAL_APE2 LIKE '" + dtoE.getApellidoMaterno() + "' ");
            
        }
        
        sql.append(" )ORDER BY OID ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada,      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerClientesREC: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }     
        
        if (resultado.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerClientesREC: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerClientesREC (DTOBuscarClientesREC):Salida");
        return resultado;
    }
    
    public RecordSet obtenerProductosREC (DTOBuscarProductosREC dtoE) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosREC(DTOBuscarProductosREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        StringBuffer sqlWhere = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        RecordSet resultado = null;
        
        //SELECT
        sql.append("SELECT OID_PROD as OID, COD_SAP as CODIGOPRODUCTO, ");
        sql.append(" DES_CORT as DESCRIPCIONPRODUCTO");
        //FROM
        sql.append(" FROM MAE_PRODU ");
        //WHERE
        if (dtoE.getCodigoProducto() != null){
            sqlWhere.append(" COD_SAP LIKE '" + dtoE.getCodigoProducto() + "' AND ");
            
        }
        
        if (dtoE.getDescripcionProducto() != null){
            sqlWhere.append(" DES_CORT LIKE '" + dtoE.getDescripcionProducto() + "' AND ");
            
        }
        
        if (sqlWhere.length() > 0){
            sql.append(" WHERE "); 
            sql.append(sqlWhere.toString().substring(0,sqlWhere.length() - 5));
            
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada,      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerProductosREC: Exception",e);                                                  
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }     
         
         if (resultado.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerProductosREC: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosREC(DTOBuscarProductosREC):Salida");
        return resultado;
       
    }
    
    // Incidencia BELC300013675 
    // Incidencia BELC300021602: primero dijeron que se debia obtener la descripcion del tipo de operacion
    // pero se vio despues que no era necesario
    public RecordSet obtenerTipoOperacion(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerTipoOperacion(DTOOID):Entrada");

        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        UtilidadesLog.info("Antes del conetext");
        String usuarioContext = ctx.getCallerPrincipal().getName();
        UtilidadesLog.info("despues del conetext");
        // Select modificada por la BELC300013675 
        sql.append(" SELECT ti.OID_TIPO_OPER, ti.VAL_TIPO_OPER ");
        sql.append(" FROM REC_TIPOS_OPERA ti , REC_AUTOR au, REC_OPERA op, principals p ");
       //sql.append(" FROM REC_TIPOS_OPERA ti , REC_AUTOR au, REC_OPERA op");
        sql.append(" WHERE op.OID_OPER = ? ");
        parametros.add(DTOE.getOid());
        // au.IND_INGR = 'true'
        sql.append(" AND au.IND_INGR = 1 ");
        sql.append(" AND au.TIOP_OID_TIPO_OPER = ti.OID_TIPO_OPER " );
        sql.append(" AND ti.ROPE_OID_OPER = op.OID_OPER " );        
        
        //Incidencia BELC300023154 
        UtilidadesLog.info("usuarioContext" + usuarioContext );
        sql.append(" AND p.NAME = '" + usuarioContext + "' ");
        sql.append(" AND p.IDPRINCIPAL = au.USER_OID_USER");
        
        UtilidadesLog.info("sql" + sql.toString());
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();        
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerTipoOperacion(DTOOID):Salida");
        return rs;
    }
    
   // por incidencia 21602 se obtiene también la descripción internacionalizada de la operación
   public RecordSet obtenerOperaciones(DTOBelcorp dtoE) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperaciones(DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        /* Cambio por ssantana, 06/09/2006, inc. DBLG500001198 */
        /*sql.append(" SELECT distinct ro.OID_OPER as OIDCODIGOOPERACION, ");
        sql.append(" ro.COD_OPER as CODIGOOPERACION, ");
        sql.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_OPERA' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = ro.OID_OPER) as DESCRIPCION ");
        sql.append(" FROM REC_OPERA ro, ");
        sql.append(" REC_TIPOS_OPERA rto, ");
        sql.append(" REC_AUTOR ra ");
        sql.append(" WHERE rto.ROPE_OID_OPER = ro.OID_OPER ");
        sql.append(" AND ra.TIOP_OID_TIPO_OPER = rto.OID_TIPO_OPER ");
        sql.append(" AND ra.IND_INGR = 1 ");
        sql.append(" AND ra.PAIS_OID_PAIS = ? ");
        parametros.add(dtoE.getOidPais());
        sql.append("  order by ro.COD_OPER ");*/
        
        sql.append(" SELECT DISTINCT ro.oid_oper AS oidoperacion, ro.cod_oper AS codigooperacion, ");
        sql.append("    (SELECT idio.val_i18n ");
        sql.append("     FROM v_gen_i18n_sicc idio ");
        sql.append("     WHERE idio.attr_enti = 'REC_OPERA' ");
        sql.append("     AND idio.idio_oid_idio = " + dtoE.getOidIdioma());
        sql.append("     AND idio.val_oid = ro.oid_oper) AS descripcion ");
        sql.append(" FROM rec_opera ro, rec_tipos_opera rto, rec_autor ra, principals p ");
        sql.append(" WHERE rto.rope_oid_oper = ro.oid_oper ");
        sql.append("  AND ra.tiop_oid_tipo_oper = rto.oid_tipo_oper ");
        sql.append("  AND ra.ind_ingr = 1 ");
        sql.append("  AND ra.pais_oid_pais = " + dtoE.getOidPais());
        //sql.append("  AND p.NAME = '" + ctx.getCallerPrincipal().toString()  + "' ");
        sql.append("  AND p.NAME = '" + ctx.getCallerPrincipal().getName()  + "' ");
        sql.append("  AND p.idprincipal = ra.user_oid_user ");
        sql.append("  ORDER BY ro.cod_oper ");
        /* Fin cambio por ssantana, 06/09/2006, inc. DBLG500001198 */
        
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executeStaticQuery(sql.toString());
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperaciones(DTOBelcorp):Entrada");
        return rs;
    }

    public RecordSet obtenerSecuencialOperacion(DTOAtencionReclamoREC dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerSecuencialOperacion(DTOAtencionReclamoREC):Entrada");

        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT op.NUM_SECU_OPER ");
        sql.append(" FROM REC_OPERA_RECLA op, REC_CABEC_RECLA cr ");
        sql.append(" WHERE op.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        sql.append(" AND cr.NUM_ATEN = ? ");
        parametros.add(dto.getNumAtencion());
        sql.append(" ORDER BY op.NUM_SECU_OPER ");
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerSecuencialOperacion(DTOAtencionReclamoREC):Entrada");
        return rs;
    }

    public RecordSet obtenerDocumentoReferencia(DTODocumentoReferenciaREC dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDocumentoReferencia(DTODocumentoReferenciaREC):Entrada");

        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
       // sql.append(" SELECT sc2.oid_soli_cabe OID, td.COD_TIPO_DOCU, sc2.VAL_NUME_SOLI, ");
       sql.append(" SELECT sc2.oid_soli_cabe OID, ");
       //sql.append(" sc2.TIDO_OID_TIPO_DOCU, "); comentado por inc DBLG400000350
       sql.append(" ftd.des_tipo_docu,  "); //mamontie inc DBLG400000350
       sql.append(" sc2.VAL_NUME_SOLI, ");//21614 mamontie 20/12/2005        
        sql.append(" sc2.FEC_CRON, pe2.VAL_NOMB_PERI, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'SEG_TIPO_PERIO' "); 
        sql.append(" AND idio.VAL_OID = pc.tipe_oid_tipo_peri "); 
        sql.append(" AND idio.ATTR_NUM_ATRI = 1 "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? ) TIPO_PERIODO "); 
        parametros.add(dto.getOidIdioma());
        
        sql.append(" FROM PED_SOLIC_CABEC sc1, PED_SOLIC_CABEC sc2, PED_ESTAD_SOLIC es, ");
        sql.append(" CRA_PERIO pe1, CRA_PERIO pe2, ");
      // sql.append(" MAE_TIPO_DOCUM td, SEG_PERIO_CORPO pc ");
        sql.append(" SEG_PERIO_CORPO pc "); //Inc 21614 mamontie 20/12/2005 
        sql.append(" ,FAC_TIPO_DOCUM ftd   "); //mamontie inc DBLG400000350
        sql.append(" WHERE sc2.IND_TS_NO_CONSO = 0 AND es.COD_ESTA_SOLI = 'VA' ");
        sql.append(" AND ((sc1.MONE_OID_MONE IS NULL AND sc2.MONE_OID_MONE IS NULL) OR (sc1.MONE_OID_MONE = sc2.MONE_OID_MONE)) ");
        sql.append(" AND sc2.esso_oid_esta_soli  = es.oid_esta_soli ");
        sql.append(" AND sc2.perd_oid_peri  = pe2.oid_peri ");  //14725
        sql.append(" AND pe2.peri_oid_peri = pc.oid_peri ");
      //  sql.append(" AND sc2.tdoc_oid_tipo_docu = td.oid_tipo_docu ");
        sql.append(" AND sc1.perd_oid_peri  = pe1.oid_peri ");
        sql.append(" AND pe1.marc_oid_marc  = pe2.marc_oid_marc ");
        sql.append(" AND pe1.cana_oid_cana  = pe2.cana_oid_cana ");
        sql.append(" and ftd.OID_TIPO_DOCU = sc2.TIDO_OID_TIPO_DOCU ");//mamontie inc DBLG400000350
        if(dto.getOidSolicitud()!=null){
            sql.append(" AND sc1.OID_SOLI_CABE = ? ");
            parametros.add(dto.getOidSolicitud());
        }
        if(dto.getFechaFiltro()!=null){
            sql.append(" AND sc2.FEC_CRON>=TO_DATE(?, 'yyyy-MM-dd') ");
            parametros.add(formateaFecha(dto.getFechaFiltro()));
        }
        if(dto.getOidCliente()!=null){
            sql.append(" AND sc2.CLIE_OID_CLIE = ? ");
            parametros.add(dto.getOidCliente());
        }

    	String consulta = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(consulta, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
       /* if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.info("****DAOCapturaProcesoReclamos.obtenerDocumentoReferencia: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
        } */       
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDocumentoReferencia(DTODocumentoReferenciaREC):Salida");
        return rs;
    }

    /** 
     * Método para obtener los motivos de devolución de un pais
     * @param dto DTOBelcorp con los criterios de pais e idioma
     * @return RecordSet con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     * 
     * @modified Marcelo J. Maidana
     * @date 10/03/2006
     * Se modificó la query y el parámetro de entrada ahora es DTOOID.
     */
    public RecordSet obtenerMotivosDevolucion(DTOOID dto) throws MareException {
        /*
         En DAOCapturaProcesoReclamos.obtenerMotivosDevolucion():
        Acceder a la Tabla REC_MOTIV_DEVOL filtrando por: 
          - pais = DTOE.pais
        
        Obtener:
           - oid = OID_MOTI_DEVO
           - descripcion = descripcion internacionalizable correspondiente a OID_MOTI_DEVO 
         */
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerMotivosDevolucion(DTOBelcorp):Entrada");

        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT md.oid_moti_devo OID, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_DEVOL' "); 
        sql.append(" AND idio.VAL_OID = md.oid_moti_devo "); 
        sql.append(" AND idio.ATTR_NUM_ATRI = 1 "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? ) DESCRIPCION, "); 
        parametros.add(dto.getOidIdioma());

        sql.append(" MDO.VAL_MARC_DEFE ");
        sql.append(" FROM REC_MOTIV_DEVOL md, REC_MOTIV_DEVOL_OPERA MDO ");
        
        // Falta comprobar si hay que cruzar más
        sql.append(" WHERE md.pais_oid_pais  = ? ");
        parametros.add(dto.getOidPais());
        sql.append(" AND md.OID_MOTI_DEVO = mdo.MODV_OID_MOTI_DEVO ");
        sql.append(" AND MDO.ROPE_OID_OPER = ? ");
        parametros.add(dto.getOid());

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        UtilidadesLog.debug("query: " + sql);
        
        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch(Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerMotivosDevolucion(DTOBelcorp):Salida");
        return rs;
    }

    // incidencia BELC300014350
    public RecordSet obtenerCampaña(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerCampaña(DTOOID):Entrada");

        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT IND_CAMP_REFE_UNIC , NUM_DIAS_HACI_ATRA  ");
        sql.append(" FROM REC_TIPOS_OPERA ");
        sql.append(" WHERE OID_TIPO_OPER = ? ");
        parametros.add(dto.getOid());
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if(rs.esVacio()) {
            // Lanzar excepcion
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "No se han encontrado registros en DAOCapturaProcesoReclamos..obtenerCampaña";
            throw new MareException(mensaje , UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerCampaña(DTOOID):Salida");
        return rs;
    }
    
    public RecordSet obtenerReclamosREC(DTOBuscarReclamosREC dtoE) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerReclamosREC(DTOBuscarReclamosREC):Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        //CAMBIADO POR INCIDENCIA 21609
        sql.append("SELECT DISTINCT cr.oid_cabe_recl as OID, ");
        sql.append(" cr.NUM_RECL as NUMRECLAMO, ");
        sql.append(" mc.COD_CLIE as CODCLIENTE, ");
        sql.append(" mc.OID_CLIE as OIDCLIENTE, ");
        sql.append(" mc.VAL_NOM1 as NOMBRE, ");
        sql.append(" mc.VAL_APE1 || ' ' || mc.VAL_APE2 as APELLIDOS, ");
        sql.append(" zsv.DES_SUBG_VENT as SGV, ");
        sql.append(" zr.DES_REGI as REGION, ");
        sql.append(" zz.DES_ZONA as ZONA, ");
        sql.append(" zs.DES_SECCI as SECCION, ");
        sql.append(" zt.COD_TERR as TERRITORIO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = me.OID_ESTA_CLIE) as ESTADOCLIENTE, ");
        sql.append(" sc.VAL_NUME_SOLI as CODDOCUREFERENCIA, ");
        sql.append(" sc.OID_SOLI_CABE as OIDNUMDOCUMENTO, ");
        sql.append(" pe1.VAL_NOMB_PERI as PERIODOREFERENCIA, ");
        sql.append(" cr.NUM_TOTA_ENVI as TOTALENVIA, ");
        sql.append(" cr.NUM_TOTA_DEVU as TOTALDEVUELVE, ");
        sql.append(" cr.IMP_SALD_PAGA as SALDOPAGAR, ");
        sql.append(" pe1.OID_PERI as OIDPERIODO, ");
        sql.append(" (SELECT idio.val_i18n ");
        sql.append("    FROM v_gen_i18n_sicc idio ");
        sql.append("   WHERE idio.attr_enti = 'SEG_MONED' ");
        sql.append("     AND idio.idio_oid_idio = ? ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("     AND idio.val_oid = sm.oid_mone) AS moneda, ");
		sql.append("	pe1.CANA_OID_CANA, ");
        sql.append("	pe1.ACCE_OID_ACCE, ");
		sql.append("    sc.SBAC_OID_SBAC , ");
		sql.append("	ta.OID_TERR_ADMI, ");
        sql.append("	zz.COD_ZONA, ");
        sql.append("    cr.ESRE_OID_ESTA_RECL ESTADORECLAMO, ");
        sql.append("    cr.NUM_ATEN as NUMATENCION ");
        sql.append(", cr.perd_oid_peri_recl AS PERIODORECLAMO ");   // Obtiene el periodo reclamo
        sql.append(", pc.cod_peri AS CODPERIODORECLAMO ");   // Obtiene el codigo de periodo reclamo
        //FROM
        sql.append(" FROM REC_CABEC_RECLA cr, ");
        sql.append(" MAE_CLIEN mc, ");
        sql.append(" MAE_ESTAT_CLIEN me, ");
        sql.append(" MAE_CLIEN_DATOS_ADICI md, ");
        sql.append(" CRA_PERIO pe1, ");
        sql.append(" CRA_PERIO pe2, ");
        sql.append(" ZON_TERRI_ADMIN ta, ");
        sql.append(" ZON_SECCI zs, ");
        sql.append(" ZON_ZONA zz, ");
        sql.append(" ZON_TERRI zt, ");
        sql.append(" ZON_REGIO zr, ");
        sql.append(" ZON_SUB_GEREN_VENTA zsv, ");
        sql.append(" PED_SOLIC_CABEC sc ");
        sql.append(" ,SEG_MONED sm ");
        //añadido por incidencia 21609
        if ((dtoE.getOpcionMenu()!=null) && (dtoE.getOpcionMenu().equals("modificar"))){
            sql.append(" ,REC_OPERA_RECLA ror ");
            
        }
        sql.append(" ,seg_perio_corpo pc ");   //  Agregado por Cambio SICC-GCC-REC-007-Periodo de Reclamo V3
        
        //WHERE
        sql.append(" WHERE cr.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND mc.oid_clie= md.clie_oid_clie ");
        sql.append(" AND md.esta_oid_esta_clie = me.oid_esta_clie ");
        sql.append(" AND cr.ZTAD_OID_TERR_ADMI = ta.OID_TERR_ADMI (+)");
        sql.append(" AND ta.TERR_OID_TERR = zt.OID_TERR (+) ");
        sql.append(" AND ta.ZSCC_OID_SECC = zs.OID_SECC (+) ");
        sql.append(" AND zs.ZZON_OID_ZONA = zz.OID_ZONA (+) ");
        sql.append(" AND zz.ZORG_OID_REGI = zr.OID_REGI (+) ");
        sql.append(" AND zr.ZSGV_OID_SUBG_VENT  = zsv.OID_subg_vent (+) ");
        sql.append(" AND (cr.ZTAD_OID_TERR_ADMI IS NULL OR ");
        sql.append(" (ta.CANA_OID_CANA = pe1.CANA_OID_CANA AND ta.MARC_OID_MARC = pe1.MARC_OID_MARC )) ");
        sql.append(" AND cr.PERD_OID_PERI_RECL = pe2.OID_PERI ");
        sql.append(" AND pe2.peri_oid_peri = pc.oid_peri ");   //  Agregado por Cambio SICC-GCC-REC-007-Periodo de Reclamo V3
        sql.append(" AND cr.PERD_OID_PERI_DOCU_REFE = pe1.OID_PERI ");
        sql.append(" AND pe1.MARC_OID_MARC = pe2.MARC_OID_MARC ");
        sql.append(" AND pe1.CANA_OID_CANA = pe2.CANA_OID_CANA ");
        sql.append(" AND cr.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
        sql.append(" AND cr.PAIS_OID_PAIS = ? ");
        parametros.add(dtoE.getOidPais());
        sql.append(" AND sc.MONE_OID_MONE = sm.OID_MONE(+) ");     
        /*if (dtoE.getNumAtencion() != null){
            sql.append(" AND cr.NUM_ATEN = ? ");
            parametros.add(dtoE.getNumAtencion());
        }*/
    //DBLG700000187 por mejora se busca por numero de reclamo  no por numero de atencion

        if (dtoE.getNumReclamo() != null){
            sql.append(" AND cr.NUM_RECL = ? ");
            parametros.add(dtoE.getNumReclamo());
        }
        
        if (dtoE.getCodCliente() != null){
            sql.append(" AND mc.COD_CLIE LIKE '" + dtoE.getCodCliente() + "' ");
            
        }
        
        if (dtoE.getNombre() != null){
            sql.append(" AND mc.VAL_NOM1 LIKE '" + dtoE.getNombre() + "' ");
            
        }
        
        if (dtoE.getApellidoMaterno() != null){
            sql.append(" AND mc.VAL_APE2 LIKE '" + dtoE.getApellidoMaterno() + "' ");
            
        }
        
        if (dtoE.getApellidoPaterno() != null){
            sql.append(" AND mc.VAL_APE1 LIKE '" + dtoE.getApellidoPaterno() + "' ");
            
        }
        
        if (dtoE.getOidMarca() != null){
            sql.append(" AND pe1.MARC_OID_MARC = ? ");
            parametros.add(dtoE.getOidMarca());
       }
        
        if (dtoE.getOidCanal() != null){
            sql.append(" AND pe1.CANA_OID_CANA = ? ");
            parametros.add(dtoE.getOidCanal());
        }
        
        if (dtoE.getOidTerritorio() != null){
            sql.append(" AND ta.TERR_OID_TERR = ? ");
            parametros.add(dtoE.getOidTerritorio());
        }
        
        if (dtoE.getOidSeccion() != null){
            sql.append(" AND zs.OID_SECC = ? ");
            parametros.add(dtoE.getOidSeccion());
        }
        
        if (dtoE.getOidZona() != null){
            sql.append(" AND zs.ZZON_OID_ZONA = ? ");
            parametros.add(dtoE.getOidZona());
        }

        if (dtoE.getOidRegion() != null){
            sql.append(" AND zz.ZORG_OID_REGI = ? ");
            parametros.add(dtoE.getOidRegion());
        }
        
        if (dtoE.getOidSGV() != null){
            sql.append(" AND zr.ZSGV_OID_SUBG_VENT = ? ");
            parametros.add(dtoE.getOidSGV());
        }
        
        if (dtoE.getOidPerDesdeRef() != null){
            sql.append(" AND pe1.FEC_INIC >= ");
            sql.append(" (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = ?) ");
            parametros.add(dtoE.getOidPerDesdeRef());
        }
        
        if (dtoE.getOidPerHastaRef() != null){
            sql.append(" AND pe1.FEC_FINA <= ");
            sql.append(" (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = ?) ");
            parametros.add(dtoE.getOidPerHastaRef());
        }
        
        if (dtoE.getOidPerDesdeRecl() != null){
            sql.append(" AND pe2.FEC_INIC >= ");
            sql.append(" (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = ?) ");
            parametros.add(dtoE.getOidPerDesdeRecl());
        }
        
        if (dtoE.getOidPerHastaRecl() != null){
            sql.append(" AND pe2.FEC_FINA <= ");
            sql.append(" (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = ?) ");
            parametros.add(dtoE.getOidPerHastaRecl());
        }
        
        //añadido poir inc 21609
        if ((dtoE.getOpcionMenu()!=null) && (dtoE.getOpcionMenu().equals("modificar"))){
            sql.append(" AND (cr.esre_oid_esta_recl = ? ");
            parametros.add(ConstantesREC.ESTADO_RECLAMO_INGRESADO); //2
            sql.append("   OR cr.esre_oid_esta_recl = ? ) ");
            parametros.add(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO); //3
            sql.append(" AND ror.care_oid_cabe_recl = cr.oid_cabe_recl ");
            sql.append(" AND (ror.esop_oid_esta_oper = ? ");
            parametros.add(ConstantesREC.ESTADO_OPERACION_INGRESADO); //1
            sql.append("   OR ror.esop_oid_esta_oper = ? ) ");
            parametros.add(ConstantesREC.ESTADO_OPERACION_BLOQUEO); //4
            
        }
    
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.info("****DAOCapturaProcesoReclamos.obtenerDetalleReclamosREC: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }

        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerReclamosREC(DTOBuscarReclamosREC):Salida");
        return rs;
    }
    
    public RecordSet obtenerClientesIntroducir(DTOBuscarClientesREC dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerClientesIntroducir(DTOBuscarClientesREC):Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT DISTINCT mc.OID_CLIE OID, ");
        sql.append(" mc.cod_clie codigoCliente, ");
        sql.append(" mc.VAL_NOM1 || ' ' || mc.VAL_APE1 || ' ' || mc.VAL_APE2 nombreApellidos, ");
        sql.append(" zz.cod_zona codigoZona, ");
        sql.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        sql.append(" WHERE v.VAL_OID = ec.oid_esta_clie ");
        sql.append(" AND v.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND v.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND v.ATTR_ENTI = 'MAE_ESTAT_CLIEN') AS estadoCliente, ");
        sql.append(" za.oid_terr_admi OIDTERRADMI, ");
        
        sql.append(" (SELECT COUNT (*) ");
        sql.append("    FROM fac_contr_cierr f ");
        sql.append("   WHERE zz.zorg_oid_regi = f.zorg_oid_regi ");
        sql.append("     AND f.PERD_OID_PERI = "+dto.getOidPeriodo());
        sql.append(" ) CIERRE ");
         
        sql.append(" FROM  MAE_CLIEN mc, ");
        sql.append(" MAE_CLIEN_DATOS_ADICI ca, ");
        sql.append(" MAE_CLIEN_UNIDA_ADMIN cu, ");
        sql.append(" MAE_ESTAT_CLIEN ec, ");
        sql.append(" ZON_TERRI_ADMIN za,  ");
        sql.append(" ZON_SECCI zs,  ");
		    sql.append(" ZON_ZONA zz, ");
        sql.append(" PED_SOLIC_CABEC sc ");
        sql.append(" WHERE mc.oid_clie = ca.clie_oid_clie ");
        sql.append(" AND ca.esta_oid_esta_clie = ec.oid_esta_clie (+) ");
        sql.append(" AND sc.clie_oid_clie = mc.oid_clie ");
        sql.append(" AND mc.oid_clie = cu.clie_oid_clie ");
        sql.append(" AND cu.ztad_oid_terr_admi = za.oid_terr_admi ");
        sql.append(" AND za.zscc_oid_secc = zs.oid_secc ");  
	 	    sql.append(" AND zs.zzon_oid_zona = zz.oid_zona ");
		    sql.append(" AND sc.IND_TS_NO_CONSO = 0  ");	
        sql.append(" AND cu.perd_oid_peri_fin is null  "); //agregado por Sapaza, fecha 08-11-2007, incidencia SiCC-20070502    
        
        if(dto.getCodigoCliente() != null) {
            sql.append("  AND mc.cod_clie = ? ");
            parametros.add(dto.getCodigoCliente());
        }
        if(dto.getNombre() != null) {
          sql.append(" AND mc.val_nom1 like '" + dto.getNombre() + "' ");
          
          
        }
        if(dto.getApellidoPaterno() != null) {
            sql.append("  AND mc.val_ape1 like '" + dto.getApellidoPaterno() + "' ");
                    
            
        }
        if(dto.getApellidoMaterno() != null) {
            sql.append(" AND mc.val_ape2 like '" + dto.getApellidoMaterno() + "' ");
        
            
        }
        if (dto.getNumDocumento()!=null){
            sql.append(" AND sc.val_nume_soli = ?");
            parametros.add(dto.getNumDocumento());
        }
                
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            UtilidadesLog.error(" obtenerClientesIntroducir: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
         if (rs.esVacio()){
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerClientesIntroducir: No hay datos ");
            throw new MareException(new Exception(),                                                            
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerClientesIntroducir(DTOBuscarClientesREC):Salida");
        return rs;
    }
    
    public RecordSet obtenerDocumentoCliente(DTOBuscarClientesREC dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDocumentoCliente(DTOBuscarClientesREC):Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT sc.oid_soli_cabe OIDSOLICITUD, sc.val_nume_soli NUMDOCUMENTO, ");
        sql.append(" mc.oid_clie OIDCLIENTE, mc.cod_clie CODIGOCLIENTE, ");
        sql.append(" mc.VAL_NOM1 || ' ' || mc.VAL_APE1 || ' ' || mc.VAL_APE2 nombreApellidos,  ");
        sql.append(" zz.cod_zona codigoZona,ec.cod_esta_clie,  ");
        sql.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v  WHERE v.VAL_OID = ec.oid_esta_clie ");
        sql.append(" AND v.IDIO_OID_IDIO = 1 AND v.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND v.ATTR_ENTI = 'MAE_ESTAT_CLIEN') AS ESTADOCLIENTE, ");
        sql.append(" pe.cana_oid_cana  AS CANAL, ");
        sql.append(" su.acce_oid_acce AS ACCESO, sc.sbac_oid_sbac AS SUBACCESO ");
        sql.append(" FROM PED_SOLIC_CABEC sc, PED_ESTAD_SOLIC es, MAE_CLIEN mc, ");
        sql.append(" MAE_CLIEN_DATOS_ADICI ca,  MAE_CLIEN_UNIDA_ADMIN cu, ");
        sql.append(" MAE_ESTAT_CLIEN ec,  ZON_TERRI_ADMIN za,  ZON_SECCI zs, ");
        sql.append(" ZON_ZONA zz, SEG_SUBAC su, CRA_PERIO pe ");
        sql.append(" WHERE sc.clie_oid_clie = mc.oid_clie  AND mc.oid_clie = ca.clie_oid_clie ");
        sql.append(" AND ca.esta_oid_esta_clie = ec.oid_esta_clie ");
        sql.append(" AND sc.PERD_OID_PERI = pe.OID_PERI ");
        sql.append(" AND es.oid_esta_soli = sc.esso_oid_esta_soli ");
        sql.append(" AND mc.oid_clie = cu.clie_oid_clie ");
        sql.append(" AND sc.sbac_oid_sbac = su.oid_sbac ");
        sql.append(" AND cu.ztad_oid_terr_admi = za.oid_terr_admi ");
        sql.append(" AND za.zscc_oid_secc =zs.oid_secc  ");
        sql.append(" AND zs.zzon_oid_zona = zz.oid_zona ");
        sql.append(" AND sc.pais_oid_pais = ? ");
        parametros.add(dto.getOidPais());
        if (dto.getNumDocumento() != null) {
            sql.append("AND sc.val_nume_soli = ? ");
            parametros.add(dto.getNumDocumento());
        }
        sql.append(" AND sc.ind_ts_no_conso = 0 ");
        sql.append(" AND es.cod_esta_soli  = 'VA' ");
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerDocumentoCliente: Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
         if (rs.esVacio()){
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerDocumentoCliente: No hay datos ");
            throw new MareException(new Exception(),                                                            
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDocumentoCliente(DTOBuscarClientesREC):Entrada");
        return rs;
    }
    
    public Long obtenerFechaCampania(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerFechaCampania(DTOOID):Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT NUM_DIAS_HACI_ATRA  ");
        sql.append(" FROM REC_TIPOS_OPERA ");
        sql.append(" WHERE oid_tipo_oper = ? ");
        parametros.add(dto.getOid());
        
        RecordSet rs = null;
        
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" obtenerFechaCampania: Exception",e);                                                     
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        Long numDias = null;
        if (!rs.esVacio()){
            if(rs.getValueAt(0,"NUM_DIAS_HACI_ATRA") != null) {
                numDias = new Long(((BigDecimal)rs.getValueAt(0,"NUM_DIAS_HACI_ATRA")).longValue());
            }
        }
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerFechaCampania(DTOOID):Entrada");
        return numDias;
    }
       
    public DTOOID obtenerUnidadAdministrativaCliente(Long cliente, Long periodo) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerUnidadAdministrativaCliente(Long , Long):Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer("");
        
        sql.append(" SELECT ua.OID_CLIE_UNID_ADMI OID");
        sql.append(" FROM MAE_CLIEN_UNIDA_ADMIN ua, ");
        sql.append(" CRA_PERIO pe1 , CRA_PERIO pe2 ");
        sql.append(" WHERE ua.perd_oid_peri_ini = pe1.oid_peri ");
        sql.append(" AND ua.perd_oid_peri_fin = pe2.oid_peri ");
        sql.append(" AND ua.clie_oid_clie = ? ");
        parametros.add(cliente);
        sql.append(" AND ua.ind_acti = 1 ");
        sql.append(" AND pe1.fec_inic <= (SELECT FEC_INIC FROM CRA_PERIO WHERE oid_peri = ?) ");
        parametros.add(periodo);
        sql.append(" AND (pe2.fec_fina > (SELECT FEC_FINA FROM CRA_PERIO WHERE oid_peri = ?) or pe2.fec_fina is null) ");
        parametros.add(periodo);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" obtenerUnidadAdministrativaCliente: Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        DTOOID dto = new DTOOID();
        if(!rs.esVacio()) {
            dto.setOid(new Long(((BigDecimal)rs.getValueAt(0,"OID")).longValue()));                                       
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerUnidadAdministrativaCliente(Long , Long):Salida");
        return dto;
    }

    // 14497 
    public RecordSet obtenerDocumento(DTOBuscarClientesREC dto) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDocumento(DTOBuscarClientesREC):Entrada");
        
        UtilidadesLog.debug("NUMERO DOCUMENTO: " + dto.getNumDocumento());
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        //SELECT
        sql.append(" SELECT sc.OID_SOLI_CABE as OIDSOLICITUD, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = ts.OID_TIPO_SOLI) as TIPOSOLICITUD, ");
        sql.append(" sc.VAL_NUME_SOLI as NUMSOLICITUD, ");
        sql.append(" sc.FEC_FACT as FECHAEMISION, ");
        sql.append(" pe.VAL_NOMB_PERI as PERIODO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'SEG_CANAL' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = ca.OID_CANA) as CANAL, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'SEG_ACCES' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = sa.OID_ACCE) as ACCESO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'SEG_SUBAC' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = ss.OID_SBAC) as SUBACCESO, ");
        sql.append(" ca.OID_CANA as OIDCANAL,");
        sql.append(" sa.OID_ACCE as OIDACCESO,");
        sql.append(" ss.oid_sbac as OIDSUBACCESO, ");
        sql.append(" pe.oid_peri as OIDPERIODO, ");
        
        sql.append(" DECODE (sm.OID_MONE, null, ( ");
        sql.append(" SELECT IDIO.VAL_I18N ");
        sql.append(" FROM SEG_PAIS SP, SEG_MONED SM, V_GEN_I18N_SICC IDIO ");
        sql.append(" WHERE SP.MONE_OID_MONE = SM.OID_MONE ");
        sql.append(" AND SM.OID_MONE = IDIO.VAL_OID ");
        sql.append(" AND IDIO.ATTR_ENTI = 'SEG_MONED' ");
        sql.append(" AND IDIO.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND SP.OID_PAIS = ?)");
        parametros.add(dto.getOidPais());
        sql.append(", (SELECT idio.val_i18n ");
        sql.append(" FROM v_gen_i18n_sicc idio ");
        sql.append(" WHERE idio.attr_enti = 'SEG_MONED' ");
        sql.append(" AND idio.idio_oid_idio = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.val_oid = sm.OID_MONE)) AS moneda, ");
        sql.append(" SC.FEC_CRON FECHAINGRESO ");
        //FROM
        sql.append(" FROM PED_SOLIC_CABEC sc, ");
        sql.append(" PED_ESTAD_SOLIC es, ");
        sql.append(" CRA_PERIO pe, ");
        sql.append(" PED_TIPO_SOLIC_PAIS tp, ");
        sql.append(" PED_TIPO_SOLIC ts, ");
        sql.append(" SEG_SUBAC ss, ");
        sql.append(" SEG_ACCES sa, ");
        sql.append(" SEG_CANAL ca, ");
        sql.append(" SEG_MONED sm, ");
        sql.append(" MAE_CLIEN mc ");
        //WHERE
        sql.append(" WHERE sc.ESSO_OID_ESTA_SOLI = es.OID_ESTA_SOLI ");
        sql.append(" AND sc.PERD_OID_PERI = pe.OID_PERI ");
        sql.append(" AND sc.TSPA_OID_TIPO_SOLI_PAIS = tp.OID_TIPO_SOLI_PAIS ");
        sql.append(" AND tp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
        sql.append(" AND sc.SBAC_OID_SBAC = ss.OID_SBAC ");
        sql.append(" AND ss.ACCE_OID_ACCE = sa.OID_ACCE ");
        sql.append(" AND sa.CANA_OID_CANA = ca.OID_CANA ");
        sql.append(" AND sc.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND sc.IND_TS_NO_CONSO = 0 ");
        sql.append(" AND ts.IND_SOLI_NEGA = 0 "); //incidencia DBLG  350
        sql.append(" AND es.COD_ESTA_SOLI = 'VA' ");
        sql.append(" AND sc.MONE_OID_MONE = sm.OID_MONE(+) ");
        sql.append(" AND sc.PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        sql.append(" AND mc.OID_CLIE = ? ");
        parametros.add(dto.getOidCliente());
        
        //Agregado por mmaidana por inc. 21601. Fecha: 27/02/2006.
        if (dto.getNumDocumento() != null){
            sql.append(" AND sc.VAL_NUME_SOLI = ? ");
            parametros.add(dto.getNumDocumento());
        }
        //Fin Agregado por mmaidana.
        
        sql.append(" ORDER BY sc.FEC_FACT DESC ");

        UtilidadesLog.debug("query: " + sql);

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDocumento(DTOBuscarClientesREC):Salida");
        return rs;
    }
    
   public DTODatosClienteREC obtenerDatosCliente(Long cliente) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosCliente(Long):Salida");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT st.OID_SUBT_CLIE SUBTIPO, ");
        sql.append(" st.TICL_OID_TIPO_CLIE TIPO ");
        sql.append(" FROM MAE_CLIEN mc, ");
        sql.append(" MAE_CLIEN_TIPO_SUBTI mct, ");
        sql.append(" MAE_SUBTI_CLIEN st ");
        sql.append(" WHERE mc.oid_clie = mct.clie_oid_clie ");
        sql.append(" AND mct.sbti_oid_subt_clie = st.oid_subt_clie ");
        sql.append(" AND mc.oid_clie = ? ");
        parametros.add(cliente);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerDatosCliente: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
         if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerDatosCliente: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         }
        
        DTODatosClienteREC dto = new DTODatosClienteREC();
         dto.setSubtipoCliente(new Long(((BigDecimal)rs.getValueAt(0,"SUBTIPO")).longValue()));                                       
         dto.setTipoCliente(new Long(((BigDecimal)rs.getValueAt(0,"TIPO")).longValue()));

        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosCliente(Long):Salida");
        return dto;
    }
    
    public DTOReclamo obtenerDetalleReclamosREC(DTODetalleReclamosREC dtoe) throws MareException
    {
        //BELC300015132
        //BELC300018670
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDetalleReclamosREC(DTODetalleReclamosREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = "";
        
        //sql.append(" SELECT RO.OID_OPER OID, ");
        /*
        sql.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        /*sql.append(" SELECT LO.OID_LINE_OPER_RECL OID, ");
        sql.append(" RO.COD_OPER AS codigoOperacion , ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_OPERA' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND RO.OID_OPER = I.VAL_OID) AS descripcionOperacion, ");
        sql.append(" RTO.VAL_TIPO_OPER AS codigoTipoOperacion, ");
        //sql.append(" RTO.VAL_DESC_TIPO_OPER AS descripcionTipoOperacion, ");
        sql.append(" (SELECT I.VAL_I18N ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_TIPOS_OPERA' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND RTO.OID_TIPO_OPER = I.VAL_OID ) AS descripcionTipoOperacion, ");
        sql.append(" MD.COD_MOTI_DEVO motivoDevolucion, ");
        sql.append(" (SELECT I.VAL_I18N ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_MOTIV_DEVOL' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND MD.OID_MOTI_DEVO = I.VAL_OID ) AS descripcionMotivoDevolucion, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_TIPO_MOVIM' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND TM.OID_TIPO_MOVI= I.VAL_OID )AS descripcionTipoMovimiento, ");
        sql.append(" SC.VAL_NUME_SOLI AS numerodocumentoReferencia, ");
        sql.append(" OD.VAL_CODI_VENT AS codigoVenta, ");
        sql.append(" MP.COD_SAP AS codigoProducto, ");
        sql.append(" MP.DES_CORT AS descripcionProducto, ");
        sql.append(" LO.NUM_UNID_RECL AS unidadesReclamadas, ");
        sql.append(" LO.VAL_PREC AS precioProducto, ");
        sql.append(" SP.VAL_IMPO_DESC_UNIT_DOCU AS descuento, ");
        sql.append(" LO.IMP_CARG AS importeCargo, ");
        sql.append(" LO.IMP_ABON AS importeAbono, ");
        sql.append(" LO.NUM_UNID_DEVU AS unidadesDevueltas, ");
        sql.append(" MC.COD_CLIE AS responsablePerdida, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_ASUME_PERDI' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND AP.OID_ASUM_PERD= I.VAL_OID ) AS asumePerdida, ");
        sql.append(" MP.COD_SAP AS codigoArticulo,  ");
        sql.append(" MP.DES_CORT descripcionArticulo,  ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_PRECI_PERDI' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND PP.OID_PREC_PERD = I.VAL_OID ) AS precioPerdida, ");
        sql.append(" PN.VAL_PORC_RECA AS porcentajeRecargo, ");
        sql.append(" LO.IMP_MONT_PERD AS montoPerdida, ");
        sql.append(" TS.COD_TIPO_SOLI AS tipoSolicitudParaPerdida, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append(" AND TS.OID_TIPO_SOLI = I.VAL_OID ) AS descTipoSolicitudParaPerdida  ");
        sql.append(" FROM REC_CABEC_RECLA CR, ");
        sql.append(" REC_OPERA_RECLA ROR, ");
        sql.append(" REC_LINEA_OPERA_RECLA LO, ");
        sql.append(" REC_OPERA RO, ");
        sql.append(" REC_TIPOS_OPERA RTO, ");
        sql.append(" PED_SOLIC_CABEC SC, ");
        sql.append(" PRE_OFERT_DETAL OD, ");
        sql.append(" MAE_PRODU MP, ");
        sql.append(" MAE_CLIEN MC, ");
        sql.append(" REC_ASUME_PERDI AP, ");
        sql.append(" REC_PRECI_PERDI PP, ");
        sql.append(" PED_TIPO_SOLIC_PAIS TSP, ");
        sql.append(" PED_TIPO_SOLIC TS, ");
        sql.append(" REC_PARAM_NMPER  PN, ");
        sql.append(" REC_MOTIV_DEVOL MD, ");
        sql.append(" REC_TIPO_MOVIM TM, ");
        sql.append(" PED_SOLIC_POSIC SP, ");
        sql.append(" MAE_TIPO_CLIEN MTC ");
        sql.append(" WHERE ");
        sql.append(" CR.OID_CABE_RECL = ? ");
        parametros.add(dtoe.getOidReclamo());
        sql.append(" AND CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL ");
        sql.append(" AND LO.OPRE_OID_OPER_RECL (+) = ROR.OID_OPER_RECL ");
        sql.append(" AND ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
        sql.append(" AND RTO.ROPE_OID_OPER = RO.OID_OPER ");
        sql.append(" AND ROR.SOCA_OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE  (+) ");
        sql.append(" AND SC.OID_SOLI_CABE = SP.SOCA_OID_SOLI_CABE (+)  ");
        sql.append(" AND SP.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+) ");	  
        sql.append(" AND LO.MODV_OID_MOTI_DEVO = MD.OID_MOTI_DEVO(+)  ");
        sql.append(" AND LO.TIMO_OID_TIPO_MOVI = TM.OID_TIPO_MOVI (+) ");
        sql.append(" AND LO.PROD_OID_PROD = MP.OID_PROD (+) ");
        sql.append(" AND ROR.CLIE_OID_RESP_PERD = MC.OID_CLIE (+) ");
        sql.append(" AND ROR.ASPE_OID_ASUM_PERD = AP.OID_ASUM_PERD (+) ");
        sql.append(" AND ROR.PPER_OID_PREC_PERD = PP.OID_PREC_PERD  (+) ");
        sql.append(" AND TSP.OID_TIPO_SOLI_PAIS (+) = RO.TSPA_OID_SOLI_PAIS_PERD ");
        sql.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI (+) ");
        sql.append(" AND CR.TICL_OID_TIPO_CLIE = MTC.OID_TIPO_CLIE ");
        sql.append(" AND PN.TICL_OID_TIPO_CLIE = MTC.OID_TIPO_CLIE ");
        sql.append(" AND PN.PAIS_OID_PAIS= ? ");
        parametros.add(dtoe.getOidPais());
        sql.append(" ORDER BY RO.COD_OPER, RTO.VAL_TIPO_OPER ");
        
        Comentado por incidencia BELC300021671 mamontie 03/05/06  */
        /*
         sql.append(" SELECT   lo.oid_line_oper_recl OID, ro.cod_oper AS codigooperacion, ");
         sql.append(" (SELECT i.val_i18n ");
         sql.append("  FROM v_gen_i18n_sicc i ");
         sql.append("  WHERE i.attr_enti = 'REC_OPERA' ");
         sql.append("  AND i.attr_num_atri = 1 ");
         sql.append("   AND i.idio_oid_idio = 1 ");
         sql.append("   AND ro.oid_oper = i.val_oid) AS descripcionoperacion, ");
         sql.append("  rto.val_tipo_oper AS codigotipooperacion, ");
         sql.append("  (SELECT i.val_i18n ");
         sql.append("     FROM v_gen_i18n_sicc i ");
         sql.append("   WHERE i.attr_enti = 'REC_TIPOS_OPERA' ");
         sql.append("     AND i.attr_num_atri = 1 ");
         sql.append("    AND i.idio_oid_idio = 1 ");
         sql.append("    AND rto.oid_tipo_oper = i.val_oid) AS descripciontipooperacion, ");
         sql.append("   md.cod_moti_devo motivodevolucion, ");
         sql.append("  (SELECT i.val_i18n ");
         sql.append("    FROM v_gen_i18n_sicc i ");
         sql.append("   WHERE i.attr_enti =  'REC_MOTIV_DEVOL' ");
         sql.append("     AND i.attr_num_atri = 1 ");
         sql.append("     AND i.idio_oid_idio = 1 ");
         sql.append("     AND md.oid_moti_devo = i.val_oid) AS descripcionmotivodevolucion, ");
         sql.append("  (SELECT i.val_i18n ");
         sql.append("    FROM v_gen_i18n_sicc i ");
         sql.append("  WHERE i.attr_enti = 'REC_TIPO_MOVIM' ");
         sql.append("   AND i.attr_num_atri = 1 ");
         sql.append("     AND i.idio_oid_idio = 1 ");
         sql.append("   AND tm.oid_tipo_movi = i.val_oid) AS descripciontipomovimiento, ");
         sql.append("  sc.val_nume_soli AS numerodocumentoreferencia, ");
         sql.append("  od.val_codi_vent AS codigoventa, mp.cod_sap AS codigoproducto, ");
         sql.append("  mp.des_cort AS descripcionproducto, ");
         sql.append("  lo.num_unid_recl AS unidadesreclamadas, ");
         sql.append("   lo.val_prec AS precioproducto, ");
         sql.append("   sp.val_impo_desc_unit_docu AS descuento, lo.imp_carg AS importecargo, ");
         sql.append("   lo.imp_abon AS importeabono, lo.num_unid_devu AS unidadesdevueltas, ");
         sql.append("   mc.cod_clie AS responsableperdida, ");
         sql.append("   (SELECT i.val_i18n ");
         sql.append("     FROM v_gen_i18n_sicc i ");
         sql.append("     WHERE i.attr_enti = 'REC_ASUME_PERDI' ");
         sql.append("      AND i.attr_num_atri = 1 ");
         sql.append("     AND i.idio_oid_idio = 1 ");
         sql.append("     AND ap.oid_asum_perd = i.val_oid) AS asumeperdida, ");
         sql.append("    (CASE ");
         sql.append("    WHEN ro.val_perd = 1 ");
         sql.append("        THEN CASE ");
         sql.append("     WHEN ap.cod_peri_recl = 'S' ");
         sql.append("        THEN mp.cod_sap ");
         sql.append("  END   ");                                                  //    SEGURO
         sql.append("  END ");
         sql.append("   ) AS codigoarticulo, ");
         sql.append("  (CASE ");
         sql.append("    WHEN ro.val_perd = 1 ");
         sql.append("     THEN CASE ");
         sql.append("  WHEN ap.cod_peri_recl = 'S' ");
         sql.append("   THEN mp.des_cort ");
         sql.append("   END ");
         sql.append("    END ");
         sql.append("   ) AS descripcionarticulo,    ");                               //  SEGURO
         sql.append("  (CASE ");
         sql.append("   WHEN ro.val_perd = 1 ");
         sql.append("     THEN CASE ");
         sql.append("  WHEN ap.cod_peri_recl = 'C' ");
         sql.append("  THEN (SELECT i.val_i18n ");
         sql.append("        FROM v_gen_i18n_sicc i ");
         sql.append("    WHERE i.attr_enti = 'REC_PRECI_PERDI' ");
         sql.append("       AND i.attr_num_atri = 1 ");
         sql.append("    AND i.idio_oid_idio = 1 ");
         sql.append("     AND pp.oid_prec_perd = i.val_oid) ");
         sql.append("   END ");
         sql.append("    END ");
         sql.append("    ) AS precioperdida,  ");                                      //Cliente
         sql.append("   (CASE ");
         sql.append("     WHEN ro.val_perd = 1 ");
         sql.append("       THEN CASE ");
         sql.append("     WHEN ap.cod_peri_recl = 'C' ");
         sql.append("       THEN pn.val_porc_reca ");
         sql.append("    END ");
         sql.append("   END ");
         sql.append("  ) AS porcentajerecargo,  ");                                   //Cliente
         sql.append(" (CASE ");
         sql.append("  WHEN ro.val_perd = 1 ");
         sql.append("    THEN CASE ap.cod_peri_recl ");
         sql.append("   WHEN 'C' ");
         sql.append("       THEN lo.imp_mont_perd ");
         sql.append("    WHEN 'S' ");
         sql.append("      THEN lo.imp_mont_perd ");
         sql.append("   END ");
         sql.append("   END ");
         sql.append("   ) AS montoperdida, ");
         sql.append("   (CASE ");
         sql.append("    WHEN ro.val_perd = 1 ");
         sql.append("    THEN CASE ap.cod_peri_recl ");
         sql.append("   WHEN 'C' ");
         sql.append("     THEN ts.cod_tipo_soli ");
         sql.append("   WHEN 'S' ");
         sql.append("    THEN ts.cod_tipo_soli ");
         sql.append("    END ");
         sql.append("   END ");
         sql.append("   ) AS tiposolicitudparaperdida,  ");                         // no belcorp
         sql.append("   (CASE ");
         sql.append("    WHEN ro.val_perd = 1 ");
         sql.append("    THEN CASE ap.cod_peri_recl ");
         sql.append("    WHEN 'C' ");
         sql.append("   THEN (SELECT i.val_i18n ");
         sql.append("   FROM v_gen_i18n_sicc i ");
         sql.append("   WHERE i.attr_enti = 'PED_TIPO_SOLIC' ");
         sql.append("   AND i.attr_num_atri = 1 ");
         sql.append("     AND i.idio_oid_idio =  " + dtoe.getOidIdioma());
         sql.append("    AND ts.oid_tipo_soli = i.val_oid) ");
         sql.append("    WHEN 'S' ");
         sql.append("   THEN (SELECT i.val_i18n ");
         sql.append("   FROM v_gen_i18n_sicc i ");
         sql.append("     WHERE i.attr_enti = 'PED_TIPO_SOLIC' ");
         sql.append("    AND i.attr_num_atri = 1 ");
         sql.append("   AND i.idio_oid_idio = " + dtoe.getOidIdioma());
         sql.append("    AND ts.oid_tipo_soli = i.val_oid) ");
         sql.append("     END ");
         sql.append("    END ");
         sql.append("   ) AS desctiposolicitudparaperdida  ");                      //no belcorp
         sql.append(" FROM rec_cabec_recla cr, ");
         sql.append(" rec_opera_recla ror, ");
         sql.append(" rec_linea_opera_recla lo, ");
         sql.append(" rec_opera ro, ");
         sql.append(" rec_tipos_opera rto, ");
         sql.append(" ped_solic_cabec sc, ");
         sql.append(" pre_ofert_detal od, ");
         sql.append(" mae_produ mp, ");
         sql.append(" mae_clien mc, ");
         sql.append(" rec_asume_perdi ap, ");
         sql.append(" rec_preci_perdi pp, ");
         sql.append(" ped_tipo_solic_pais tsp, ");
         sql.append(" ped_tipo_solic ts, ");
         sql.append(" rec_param_nmper pn, ");
         sql.append(" rec_motiv_devol md, ");
         sql.append(" rec_tipo_movim tm, ");
         sql.append(" ped_solic_posic sp, ");
         sql.append(" mae_tipo_clien mtc ");
        sql.append(" WHERE cr.oid_cabe_recl =  " + dtoe.getOidReclamo()); 
        sql.append(" AND cr.oid_cabe_recl = ror.care_oid_cabe_recl ");
        sql.append(" AND lo.opre_oid_oper_recl(+) = ror.oid_oper_recl ");
        sql.append(" AND ror.tiop_oid_tipo_oper = rto.oid_tipo_oper ");
        sql.append("  AND rto.rope_oid_oper = ro.oid_oper ");
        sql.append(" AND ror.soca_oid_soli_cabe = sc.soca_oid_soli_cabe(+) ");
        sql.append("  AND sc.oid_soli_cabe = sp.soca_oid_soli_cabe(+) ");
        sql.append("  AND sp.ofde_oid_deta_ofer = od.oid_deta_ofer(+) ");
        sql.append("  AND lo.modv_oid_moti_devo = md.oid_moti_devo(+) ");
        sql.append("  AND lo.timo_oid_tipo_movi = tm.oid_tipo_movi(+) ");
        sql.append("  AND lo.prod_oid_prod = mp.oid_prod(+) ");
        sql.append("  AND ror.clie_oid_resp_perd = mc.oid_clie(+) ");
        sql.append("  AND ror.aspe_oid_asum_perd = ap.oid_asum_perd(+) ");
        sql.append("  AND ror.pper_oid_prec_perd = pp.oid_prec_perd(+) ");
        sql.append("  AND tsp.oid_tipo_soli_pais(+) = ro.tspa_oid_soli_pais_perd ");
        sql.append(" AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli(+) ");
        sql.append("  AND cr.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
        sql.append("  AND pn.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
        sql.append("   AND pn.pais_oid_pais =  " + dtoe.getOidPais());
        sql.append(" ORDER BY ro.cod_oper, rto.val_tipo_oper ");
            
        sql.append(") XY ) WHERE linea > " + dtoe.getIndicadorSituacion() + " AND ROWNUM <= " + dtoe.getTamanioPagina() );*/
        

        sql.append(" SELECT ro.cod_oper, ");
        sql.append("        ror.oid_oper_recl AS oid, ");
        sql.append("        rto.val_tipo_oper AS codigotipooperacion, ");
        sql.append("        ror.num_secu_oper, ");
        sql.append("        (SELECT v.val_i18n ");
        sql.append("           FROM v_gen_i18n_sicc v ");
        sql.append("          WHERE v.val_oid = ro.oid_oper ");
        sql.append("            AND v.idio_oid_idio = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append("            AND v.attr_num_atri = 1 ");
        sql.append("            AND v.attr_enti = 'REC_OPERA') AS descripcioncorta, ");
        sql.append("        sc.val_nume_soli AS numerodocumentoreferencia, ");
        sql.append("        mc.cod_clie AS responsableperdida, ");
        sql.append("        (SELECT i.val_i18n ");
        sql.append("           FROM v_gen_i18n_sicc i ");
        sql.append("          WHERE i.attr_enti = 'REC_ASUME_PERDI' ");
        sql.append("            AND i.attr_num_atri = 1 ");
        sql.append("            AND i.idio_oid_idio =  ?");
        parametros.add(dtoe.getOidIdioma());
        sql.append("            AND ap.oid_asum_perd = i.val_oid) AS asumeperdida, ");
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE WHEN ap.cod_peri_recl = 'C' ");
        sql.append("                   THEN (SELECT i.val_i18n ");
        sql.append("                           FROM v_gen_i18n_sicc i ");
        sql.append("                          WHERE i.attr_enti = 'REC_PRECI_PERDI' ");
        sql.append("                            AND i.attr_num_atri = 1 ");
        sql.append("                            AND i.idio_oid_idio =  ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append("                            AND pp.oid_prec_perd = i.val_oid) ");
        sql.append("              END ");
        sql.append("         END) AS precioperdida, "); /** se debe recuperar info cuando el cliente asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE WHEN ap.cod_peri_recl = 'C' ");
        /* Modificacion por ssantana, 31/07/2006, inc. BELC300023894 (DBLG500001100) */ 
        /* sql.append("                   THEN pn.val_porc_reca ");*/
        sql.append("                   THEN ror.val_porc_perd ");
        /* Fin modificacion por ssantana, 31/07/2006, inc. BELC300023894 (DBLG500001100) */         
        sql.append("              END ");
        sql.append("         END) AS porcentajerecargo, "); /** se debe recuperar info cuando el cliente asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE WHEN ap.cod_peri_recl = 'S' ");
        sql.append("                   THEN mcs.COD_CLIE ");
        sql.append("              END ");
        sql.append("         END) AS codigoclienteseguro, "); /** se debe recuperar info cuando el seguro asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE WHEN ap.cod_peri_recl = 'S' ");
        sql.append("                   THEN mcs.VAL_NOM1 || ' ' || mcs.VAL_NOM2 || ' ' || mcs.VAL_APE1 || ' ' || mcs.VAL_APE2 ");
        sql.append("              END ");
        sql.append("         END) AS nombreclienteseguro, ");/** se debe recuperar info cuando el seguro asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE WHEN ap.cod_peri_recl = 'S' ");
        sql.append("                   THEN mp.cod_sap ");
        sql.append("              END ");
        sql.append("         END) AS codigoarticulo,  ");/** se debe recuperar info cuando el seguro asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE WHEN ap.cod_peri_recl = 'S' ");
        sql.append("                   THEN mp.des_cort ");
        sql.append("              END ");
        sql.append("         END) AS descripcionarticulo, "); /** se debe recuperar info cuando el seguro asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE ap.cod_peri_recl ");
        sql.append("                   WHEN 'C' ");
        sql.append("                   THEN ror.imp_mont_perd ");
        sql.append("                   WHEN 'S' ");
        sql.append("                   THEN ror.imp_mont_perd ");
        sql.append("              END ");
        sql.append("         END) AS montoperdida, "); /** se debe recuperar info cuando no sea belcorp quien asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE ap.cod_peri_recl ");
        sql.append("                   WHEN 'C' ");
        sql.append("                   THEN ts.cod_tipo_soli ");
        sql.append("                   WHEN 'S' ");
        sql.append("                   THEN ts.cod_tipo_soli ");
        sql.append("              END ");
        sql.append("         END) AS tiposolicitudparaperdida, "); /** se debe recuperar info cuando no sea belcorp quien asume la perdida */
        sql.append("        (CASE WHEN ro.val_perd = 1 ");
        sql.append("              THEN ");
        sql.append("              CASE ap.cod_peri_recl ");
        sql.append("                   WHEN 'C' ");
        sql.append("                   THEN (SELECT i.val_i18n ");
        sql.append("                           FROM v_gen_i18n_sicc i ");
        sql.append("                          WHERE i.attr_enti = 'PED_TIPO_SOLIC' ");
        sql.append("                            AND i.attr_num_atri = 1 ");
        sql.append("                            AND i.idio_oid_idio =  ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append("                            AND ts.oid_tipo_soli = i.val_oid) ");
        sql.append("                   WHEN 'S' ");
        sql.append("                   THEN (SELECT i.val_i18n ");
        sql.append("                           FROM v_gen_i18n_sicc i ");
        sql.append("                          WHERE i.attr_enti = 'PED_TIPO_SOLIC' ");
        sql.append("                            AND i.attr_num_atri = 1 ");
        sql.append("                            AND i.idio_oid_idio = ? ");
        parametros.add(dtoe.getOidIdioma());
        sql.append("                            AND ts.oid_tipo_soli = i.val_oid) ");
        sql.append("              END ");
        sql.append("         END) AS desctiposolicitudparaperdida  ");/** se debe recuperar info cuando no sea belcorp quien asume la perdida */
        sql.append("   FROM rec_cabec_recla cr, ");
        sql.append("        rec_opera_recla ror, ");
        sql.append("        rec_opera ro, ");
        sql.append("        rec_tipos_opera rto, ");
        sql.append("        rec_param_nmper pn, ");
        sql.append("        rec_asume_perdi ap, ");
        sql.append("        rec_preci_perdi pp, ");
        sql.append("        ped_solic_cabec sc, ");
        sql.append("        ped_tipo_solic_pais tsp, ");
        sql.append("        ped_tipo_solic ts, ");
        sql.append("        mae_clien mc, ");
        sql.append("        mae_clien mcs, ");
        sql.append("        mae_produ mp, ");
        sql.append("        mae_tipo_clien mtc ");
        sql.append("  WHERE cr.oid_cabe_recl = ? ");
        parametros.add(dtoe.getOidReclamo());
        sql.append("    AND cr.oid_cabe_recl = ror.care_oid_cabe_recl ");
        sql.append("    AND ror.tiop_oid_tipo_oper = rto.oid_tipo_oper ");
        sql.append("    AND rto.rope_oid_oper = ro.oid_oper ");
        sql.append("    AND ror.soca_oid_soli_cabe = sc.oid_soli_cabe(+) ");
        sql.append("    AND ror.clie_oid_resp_perd = mc.oid_clie(+) ");
        sql.append("    AND ror.aspe_oid_asum_perd = ap.oid_asum_perd(+) ");
        sql.append("    AND ror.pper_oid_prec_perd = pp.oid_prec_perd(+) ");
        sql.append("    AND tsp.oid_tipo_soli_pais(+) = ror.TSPA_OID_TIPO_SOLI_PAIS ");
        sql.append("    AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli(+) ");
        sql.append("    AND cr.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
        sql.append("    AND pn.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
        sql.append("    AND ror.prod_oid_prod = mp.oid_prod (+) ");
        sql.append("    AND ror.clie_oid_clie = mcs.oid_clie(+) ");
        sql.append("    AND pn.pais_oid_pais = ? ");
        parametros.add(dtoe.getOidPais());
        sql.append("  ORDER BY ror.num_secu_oper ");

        
        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = new RecordSet();
       // String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoe);
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerDetalleReclamosREC: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        ArrayList arrOperaciones = new ArrayList();
       
        for(int i=0;i<resultado.getRowCount();i++){
         
         DTOOperacionReclamo dtoOp = new DTOOperacionReclamo();
            
        if(resultado.getValueAt(i,"COD_OPER")!=null){       
            dtoOp.setCodigoOperacion(resultado.getValueAt(i,"COD_OPER").toString());
        }
        if(resultado.getValueAt(i,"OID")!=null){
            dtoOp.setOidOperacionReclamo(new Long(((BigDecimal) resultado.getValueAt(i,"OID")).longValue()));
        }
        if(resultado.getValueAt(i,"CODIGOTIPOOPERACION")!=null){
            dtoOp.setCodigoTipoOperacion( resultado.getValueAt(i,"CODIGOTIPOOPERACION").toString());
        }
        if(resultado.getValueAt(i,"NUM_SECU_OPER")!=null){
            dtoOp.setNumSecuencial(new Integer(((BigDecimal)resultado.getValueAt(i,"NUM_SECU_OPER")).intValue()));
        }
        if(resultado.getValueAt(i,"DESCRIPCIONCORTA")!=null){
            dtoOp.setDescripcionCorta(resultado.getValueAt(i,"DESCRIPCIONCORTA").toString());
        }
        if(resultado.getValueAt(i,"NUMERODOCUMENTOREFERENCIA")!=null){
            dtoOp.setNumDocReferencia(resultado.getValueAt(i,"NUMERODOCUMENTOREFERENCIA").toString());
        }
        if(resultado.getValueAt(i,"RESPONSABLEPERDIDA")!=null){
            dtoOp.setCodigoResponsablePerdida(resultado.getValueAt(i,"RESPONSABLEPERDIDA").toString());
        }
        if(resultado.getValueAt(i,"ASUMEPERDIDA")!=null){
            dtoOp.setDescripcionAsumePerdida(resultado.getValueAt(i,"ASUMEPERDIDA").toString());
        }
        if(resultado.getValueAt(i,"PRECIOPERDIDA")!=null){
            dtoOp.setDescripcionPrecioPerdida(resultado.getValueAt(i,"PRECIOPERDIDA").toString());
        }
        if(resultado.getValueAt(i,"PORCENTAJERECARGO")!=null){
            dtoOp.setPorcentajePerdida(new Double(resultado.getValueAt(i,"PORCENTAJERECARGO").toString()));
        }
        if(resultado.getValueAt(i,"NOMBRECLIENTESEGURO")!=null){
            dtoOp.setNombreClienteSeguro(resultado.getValueAt(i,"NOMBRECLIENTESEGURO").toString());
        }
        if(resultado.getValueAt(i,"CODIGOCLIENTESEGURO")!=null){
            dtoOp.setCodigoClienteSeguro(resultado.getValueAt(i,"CODIGOCLIENTESEGURO").toString());
        }
        if(resultado.getValueAt(i,"CODIGOARTICULO")!=null){
            dtoOp.setCodigoArticuloSeguro(resultado.getValueAt(i,"CODIGOARTICULO").toString());
        }
        if(resultado.getValueAt(i,"DESCRIPCIONARTICULO")!=null){
            dtoOp.setDescripcionArticuloSeguro(resultado.getValueAt(i,"DESCRIPCIONARTICULO").toString()); 
        }
        if(resultado.getValueAt(i,"MONTOPERDIDA")!=null){
            dtoOp.setMontoPerdida((BigDecimal)resultado.getValueAt(i,"MONTOPERDIDA"));
        }
        if(resultado.getValueAt(i,"TIPOSOLICITUDPARAPERDIDA")!=null){
            dtoOp.setCodigoTipoSolicitudPerdida(resultado.getValueAt(i,"TIPOSOLICITUDPARAPERDIDA").toString());
        }
        if(resultado.getValueAt(i,"DESCTIPOSOLICITUDPARAPERDIDA")!=null){
            dtoOp.setDescripcionTipoSolicitudPerdida(resultado.getValueAt(i,"DESCTIPOSOLICITUDPARAPERDIDA").toString()); 
        }
        dtoOp.setLineas(new ArrayList());
        arrOperaciones.add(dtoOp);
        }
         sql = new StringBuffer();
        
        parametros = new Vector();
        
         sql.append(" SELECT   LO.OPRE_OID_OPER_RECL AS OID, "); 
         sql.append(" (SELECT I.VAL_I18N ");
         sql.append(" FROM V_GEN_I18N_SICC I  ");
         sql.append(" WHERE I.ATTR_ENTI = 'REC_TIPO_MOVIM'  ");
         sql.append(" AND I.ATTR_NUM_ATRI = 1 ");
         sql.append(" AND I.IDIO_OID_IDIO = "+dtoe.getOidIdioma() );
         sql.append(" AND TM.OID_TIPO_MOVI = I.VAL_OID )AS TIPOMOVIMIENTO,  ");
         sql.append(" OD.VAL_CODI_VENT AS CODVENTA,  ");
         sql.append(" mp.cod_sap AS CODPRODU , ");
        
         //modificado por Sapaza - fecha 04/09/2007 - incidencia SiCC20070403         
         //sql.append(" MP.DES_CORT AS DESCPRODUCTO, ");          
         sql.append("  PQ_APL_AUX.VALOR_GEN_I18N_SICC( "+dtoe.getOidIdioma() + ", MP.OID_PROD, 'MAE_PRODU') DESCPRODUCTO, ");        
         
         sql.append(" LO.NUM_UNID_RECL  AS URECLAMADAS,  ");
         sql.append(" LO.VAL_PREC AS PRECIO, ");
         //Agregado por Sapaza, fecha 08-02-2008, incidencia SiCC-20080557
         sql.append(" LO.VAL_PREC_CONT AS PRECIOCONTABLE, ");
         //pzerbino 15/11/2006 incidencia 24290
         sql.append(" nvl(psp.VAL_IMPO_DESC_UNIT_LOCA,0) as descuento, ");
    	   sql.append(" LO.NUM_UNID_DEVU AS UDEVUELTAS,  ");
         sql.append(" LO.IMP_CARG AS IMPORTECARGO,  ");
         sql.append(" LO.IMP_ABON AS IMPORTEABONO, ");
    	   sql.append(" nvl(LO.IMP_MONT_PERD,0) AS MONTOPERDIDA ");
         sql.append(" FROM  ");
         sql.append(" REC_LINEA_OPERA_RECLA LO,  ");
         sql.append(" REC_TIPO_MOVIM TM,  ");
         sql.append(" PRE_MATRI_FACTU MF,  ");
         sql.append(" PRE_OFERT_DETAL OD,  ");
         sql.append(" MAE_PRODU MP,  ");
         sql.append(" PED_TIPO_SOLIC_PAIS PS,   ");
         //pzerbino 15/11/2006 incidencia 24290
         sql.append(" ped_solic_posic psp   ");
         sql.append(" WHERE LO.OPRE_OID_OPER_RECL IN( ");
         for(int j=0;j<arrOperaciones.size();j++){
          sql.append(" ? ");
          parametros.add(((DTOOperacionReclamo)arrOperaciones.get(j)).getOidOperacionReclamo());
          if((j+1)<arrOperaciones.size()){
            sql.append(",");    
          }
         }
         
         sql.append(" ) AND LO.TIMO_OID_TIPO_MOVI = TM.OID_TIPO_MOVI  ");
         sql.append(" AND LO.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT (+)  ");
         sql.append(" AND MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+)  ");
         sql.append(" AND LO.PROD_OID_PROD = MP.OID_PROD (+) ");
         sql.append(" AND LO.TSPA_OID_TIPO_SOLI_PAIS = PS.OID_TIPO_SOLI_PAIS (+) ");
         //pzerbino 15/11/2006 incidencia 24290
         sql.append(" AND psp.OID_SOLI_POSI(+) = lo.SOPO_OID_SOLI_POSI ");
         sql.append(" ORDER BY oid, LO.NUM_LINE ");
        
         
         
        if(resultado !=null && resultado.getRowCount()>0){        
        RecordSet resultado2 = new RecordSet();
        try {                                                                  
            
            resultado2 = bs.dbService.executePreparedQuery(sql.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerDetalleReclamosREC: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        ArrayList arrLienas = new ArrayList();
        
            for(int b=0;b<resultado2.getRowCount();b++){
               
                DTOLineaOperacion dtoLin = new DTOLineaOperacion();
               if(resultado2.getValueAt(b,"OID")!=null){
                    dtoLin.setOperacion(new Long(((BigDecimal)resultado2.getValueAt(b,"OID")).longValue()));
               }
               if(resultado2.getValueAt(b,"TIPOMOVIMIENTO")!=null){
                    dtoLin.setTipoMovimiento(resultado2.getValueAt(b,"TIPOMOVIMIENTO").toString());
               }
               if(resultado2.getValueAt(b,"CODVENTA")!=null){
                    dtoLin.setCodigoVenta(resultado2.getValueAt(b,"CODVENTA").toString());
               }
               if(resultado2.getValueAt(b,"CODPRODU")!=null){
                    dtoLin.setCodProducto(resultado2.getValueAt(b,"CODPRODU").toString());
               }
               if(resultado2.getValueAt(b,"DESCPRODUCTO")!=null){
                    dtoLin.setDescProducto(resultado2.getValueAt(b,"DESCPRODUCTO").toString());
               }
               if(resultado2.getValueAt(b,"URECLAMADAS")!=null){
                    dtoLin.setUnidadesReclamadas(new Integer(((BigDecimal)resultado2.getValueAt(b,"URECLAMADAS")).intValue()));
               }
               if(resultado2.getValueAt(b,"PRECIO")!=null){
                    dtoLin.setPrecio((BigDecimal)resultado2.getValueAt(b,"PRECIO"));
               }
               //Agregado por Sapaza, fecha 08-02-2008, incidencia SiCC-20080557               
               if(resultado2.getValueAt(b,"PRECIOCONTABLE")!=null){
                    dtoLin.setPrecioContable((BigDecimal)resultado2.getValueAt(b,"PRECIOCONTABLE"));
               }
               //pzerbino 15/11/2006  incidencia 24290
               if(resultado2.getValueAt(b,"DESCUENTO")!=null){
                    dtoLin.setDescuento((BigDecimal)resultado2.getValueAt(b,"DESCUENTO"));
               }               
               if(resultado2.getValueAt(b,"UDEVUELTAS")!=null){
                    dtoLin.setUnidadesDevueltas(new Integer(((BigDecimal)resultado2.getValueAt(b,"UDEVUELTAS")).intValue()));
               }
               if(resultado2.getValueAt(b,"IMPORTECARGO")!=null){
                    dtoLin.setImporteCargo((BigDecimal)resultado2.getValueAt(b,"IMPORTECARGO"));
               }
               if(resultado2.getValueAt(b,"IMPORTEABONO")!=null){
                    dtoLin.setImporteAbono((BigDecimal)resultado2.getValueAt(b,"IMPORTEABONO"));
               }
               if(resultado2.getValueAt(b,"MONTOPERDIDA")!=null){
                    dtoLin.setMontoPerdida((BigDecimal)resultado2.getValueAt(b,"MONTOPERDIDA"));
               }
               for(int h=0;h<arrOperaciones.size();h++){
                  if(((DTOOperacionReclamo)arrOperaciones.get(h)).getOidOperacionReclamo().equals(dtoLin.getOperacion())){
                      ((DTOOperacionReclamo)arrOperaciones.get(h)).getLineas().add(dtoLin);
                  }  
                }
            }

        }
        DTOReclamo dtoR = new DTOReclamo();
        dtoR.setOperaciones(arrOperaciones);
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDetalleReclamosREC(DTODetalleReclamosREC):Salida " + resultado +" --- ");
        return dtoR;
 }

    public RecordSet obtenerAlmacenOperacion(DTOOID dto) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerAlmacenOperacion(Long):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = "";
        
        sql.append(" SELECT OP.ALMC_OID_ALMA AS almacen , ");
        sql.append(" OP.TMAL_OID_TIPO_MOVI_ALMA AS movimientoAlmacen, ");
        sql.append(" OP.IND_RECO , ");
        sql.append(" OP.ALMC_OID_ALMA_POSV, ");
	      sql.append(" OP.TMAL_OID_TIPO_ALMA_REC_INIC ");
        
        sql.append(" FROM REC_OPERA OP ");
       /*sql.append(" REC_TIPOS_OPERA RTO, ");
        sql.append("  REC_OPERA_RECLA ROR ");
        sql.append(" WHERE ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
        sql.append(" AND RTO.ROPE_OID_OPER = OP.OID_OPER ");
        sql.append(" AND OP.OID_OPER = ? ");*/ // quitado para que no repita registros
        sql.append(" WHERE OP.OID_OPER = ? ");
        parametros.add(dto.getOid());
        sql.append(" AND OP.PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        
        RecordSet resultado = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerAlmacenOperacion(Long):Salida");
        return resultado;
    }

  /**
   * @author: ssantana, 01/03/2006
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOBloqueoTipoOperacionREC 
   * @param DTOBuscarBloqueosTipo dto
   */
   
   // Long oidCodTipoOperacion, String usuario
    public DTOBloqueoTipoOperacionREC obtenerBloqueosTipo(Long oidCodTipoOperacion,
                                                          String sUsuario) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerBloqueosTipo(DTOOID):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = "";
        
        sql.append(" SELECT rto.mobl_oid_bloq_unid AS bloqueounidades, ");
        sql.append(" rto.mobl_oid_bloq_impo AS bloqueoimporte, ");
        sql.append(" rto.mobl_oid_bloq_dife AS bolqueodiferencia, ");
        sql.append(" rto.mobl_oid_recl_ante AS bloqueoanterior, ");
        sql.append(" ra.imp_maxi AS importemaximo, ra.imp_mont_maxi_dife AS montomaximo ");
        sql.append(" FROM rec_tipos_opera rto, rec_autor ra, users u, principals p ");
        sql.append(" WHERE ra.tiop_oid_tipo_oper = rto.oid_tipo_oper ");
        sql.append(" AND ra.user_oid_user = u.iduser ");
        sql.append(" AND p.idprincipal = u.iduser ");
        sql.append(" AND p.NAME = '" + sUsuario + "'");
        sql.append(" AND rto.oid_tipo_oper = " + oidCodTipoOperacion );
        
        RecordSet resultado = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            //resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            resultado = bs.dbService.executeStaticQuery(sql.toString());
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        /* if (resultado.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerBloqueosTipo: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         } */       
        
        
        DTOBloqueoTipoOperacionREC dtoBloqueo = new DTOBloqueoTipoOperacionREC();
       
        if (!resultado.esVacio() ) {
            if (resultado.getValueAt(0, "BLOQUEOUNIDADES") != null) {
                  dtoBloqueo.setBloqueoUnidades(new Long(((BigDecimal)resultado.getValueAt(0, "BLOQUEOUNIDADES")).longValue()));      
            }
            if (resultado.getValueAt(0, "BLOQUEOIMPORTE") != null) {
                  dtoBloqueo.setBloqueoImporte(new Long(((BigDecimal)resultado.getValueAt(0, "BLOQUEOIMPORTE")).longValue()));      
            }
            if (resultado.getValueAt(0, "BOLQUEODIFERENCIA") != null) {
                  dtoBloqueo.setBloqueoDiferencia(new Long(((BigDecimal)resultado.getValueAt(0, "BOLQUEODIFERENCIA")).longValue()));      
            }
            // no es muy seguro que se asigne a este atributo del DTO
            if (resultado.getValueAt(0, "BLOQUEOANTERIOR") != null) {
                  dtoBloqueo.setBloqueoAnterior(new Long(((BigDecimal)resultado.getValueAt(0, "BLOQUEOANTERIOR")).longValue()));      
            } 
            if (resultado.getValueAt(0, "IMPORTEMAXIMO") != null) {
                  dtoBloqueo.setImporteMaximo((BigDecimal)resultado.getValueAt(0, "IMPORTEMAXIMO"));      
            }
            if (resultado.getValueAt(0, "MONTOMAXIMO") != null) {
                  dtoBloqueo.setMontoMaximo((BigDecimal)resultado.getValueAt(0, "MONTOMAXIMO"));      
            }
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerBloqueosTipo(DTOOID):Salida");
        return dtoBloqueo;
    }
    

    
    public RecordSet obtenerTiposBloqueo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerTiposBloqueo(DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
                      
        sql.append("SELECT tb.oid_tipo_bloq, ");
        sql.append("(SELECT v.VAL_I18N ");
        sql.append("FROM V_GEN_I18N_SICC v ");
        sql.append("WHERE v.VAL_OID = tb.oid_tipo_bloq ");
        sql.append("AND v.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append("AND v.ATTR_NUM_ATRI = 1 ");
        sql.append("AND v.ATTR_ENTI = 'REC_TIPOS_BLOQU') AS DESCRIPCION ");
        sql.append("FROM REC_TIPOS_BLOQU tb ");
        if (dto.getOidPais() != null) {
            sql.append("WHERE tb.pais_oid_pais = ?");
            parametros.add(dto.getOidPais());
        }
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch(Exception e) {
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerTiposBloqueo : Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
         if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerTiposBloqueo: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         }        
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerTiposBloqueo(DTOBelcorp):Salida");
        return rs;
    }
    
    public RecordSet obtenerOperacionesDescripcion (DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperacionesDescripcion (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ro.oid_oper OID, ");
        sql.append(" (SELECT v.VAL_I18N ");
        sql.append(" FROM V_GEN_I18N_SICC v ");
        sql.append(" WHERE v.VAL_OID = ro.oid_oper ");
        sql.append(" AND v.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND v.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND v.ATTR_ENTI = 'REC_OPERA') AS DESCRIPCION ");
        sql.append(" FROM REC_OPERA ro ");
        if(dto.getOidPais() != null) {
            sql.append(" WHERE ro.pais_oid_pais = ? ");
            parametros.add(dto.getOidPais());
        }
         
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error("DAOCapturaProcesoReclamos.obtenerOperacionesDescripcion : Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
         if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerTiposBloqueo: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         }        
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperacionesDescripcion (DTOBelcorp):Salida");
        return rs;
    }
    
    public RecordSet obtenerMotivosRechazoDesbloqueo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerMotivosRechazoDesbloqueo (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
                        
        sql.append(" SELECT rd.oid_moti_rech_desb OID, ");
        sql.append(" (SELECT v.VAL_I18N ");
        sql.append(" FROM V_GEN_I18N_SICC v ");
        sql.append(" WHERE v.VAL_OID = rd.oid_moti_rech_desb ");
        sql.append(" AND v.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND v.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND v.ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL') AS DESCRIPCION ");
        sql.append(" FROM REC_MOTIV_RECHA_DESBL rd ");
        if(dto.getOidPais() != null) {
            sql.append(" WHERE rd.pais_oid_pais = ? ");
            parametros.add(dto.getOidPais());
        }
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerMotivosRechazoDesbloqueo  : Exception",e);                                                  
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
         if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerMotivosRechazoDesbloqueo: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         }        
         
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerMotivosRechazoDesbloqueo (DTOBelcorp):Salida");
        return rs;
    }
    
    public ArrayList obtenerDetalleModificacionREC(DTODetalleReclamosREC dtoE) throws MareException{
        //Incidencia BELC300021669
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDetalleModificacionREC(DTODetalleReclamosREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        StringBuffer sql2 = new StringBuffer();
        Vector parametros = new Vector();
        Vector parametros2 = new Vector();

        sql.append(" SELECT   ror.oid_oper_recl AS OID, ro.cod_oper, ");
        sql.append("          rto.val_tipo_oper AS codtipoopera, ror.num_secu_oper, ");
        sql.append("          (SELECT v.val_i18n ");
        sql.append("             FROM v_gen_i18n_sicc v ");
        sql.append("            WHERE v.val_oid = ro.oid_oper ");
        sql.append("              AND v.idio_oid_idio = ? ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("              AND v.attr_num_atri = 1 ");
        sql.append("              AND v.attr_enti = 'REC_OPERA') AS descripcioncorta, ");
        sql.append("          sc.val_nume_soli AS numdocurefe, ");
        sql.append("          DECODE ((SELECT au.ind_ingr ");
        sql.append("                     FROM rec_autor au, users u, principals p ");
        sql.append("                    WHERE rto.oid_tipo_oper = au.tiop_oid_tipo_oper ");
        sql.append("                      AND au.user_oid_user = u.iduser ");
        sql.append("                      AND u.iduser = p.idprincipal ");
        sql.append("                      AND p.NAME = ?), ");
        parametros.add(usuario);
        sql.append("                  1, 'Si', ");
        sql.append("                  'No' ");
        sql.append("                 ) AS indicadoringreso, ");
        sql.append("          ro.ind_anul ");
        sql.append("     FROM rec_opera_recla ror, ");
        sql.append("          rec_tipos_opera rto, ");
        sql.append("          rec_opera ro, ");
        sql.append("          ped_solic_cabec sc ");
        sql.append("    WHERE ror.care_oid_cabe_recl = ? ");
        parametros.add(dtoE.getOidReclamo());
        sql.append("      AND ror.tiop_oid_tipo_oper = rto.oid_tipo_oper ");
        sql.append("      AND rto.rope_oid_oper = ro.oid_oper ");
        sql.append("      AND ror.soca_oid_soli_cabe = sc.oid_soli_cabe ");
        sql.append("      AND (ror.esop_oid_esta_oper = ? OR ror.esop_oid_esta_oper = ?) ");
        parametros.add(ConstantesREC.ESTADO_OPERACION_INGRESADO);
        parametros.add(ConstantesREC.ESTADO_OPERACION_BLOQUEO);
        sql.append(" ORDER BY num_secu_oper ");
         
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
       // String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        ArrayList arrDtoS = new ArrayList();
        UtilidadesLog.info("Luego de recuperar Operaciones");
        if(!rs.esVacio()) {
            UtilidadesLog.info("RecordSet "+rs.toString());
            for (int i=0;i<rs.getRowCount();i++ )  {
                DTOOperacionReclamo dtoS = new DTOOperacionReclamo();
                dtoS.setOidOperacionReclamo(new Long(((BigDecimal)rs.getValueAt(i,"OID")).longValue()));
                UtilidadesLog.info("1");
                if(rs.getValueAt(i,"COD_OPER")!=null){
                    dtoS.setCodigoOperacion(rs.getValueAt(i,"COD_OPER").toString());
                }
                UtilidadesLog.info("2");
                if(rs.getValueAt(i,"CODTIPOOPERA")!=null){
                    dtoS.setCodigoTipoOperacion(rs.getValueAt(i,"CODTIPOOPERA").toString());
                }
                UtilidadesLog.info("3");
                if(rs.getValueAt(i,"NUM_SECU_OPER")!=null){
                    dtoS.setNumSecuencial(new Integer(((BigDecimal)rs.getValueAt(i,"NUM_SECU_OPER")).intValue()));
                }
                UtilidadesLog.info("4");
                if(rs.getValueAt(i,"DESCRIPCIONCORTA")!=null){
                    dtoS.setDescripcionCorta(rs.getValueAt(i,"DESCRIPCIONCORTA").toString());
                }
                UtilidadesLog.info("5");
                if(rs.getValueAt(i,"NUMDOCUREFE")!=null){
                    dtoS.setNumDocReferencia(rs.getValueAt(i,"NUMDOCUREFE").toString());
                }
                UtilidadesLog.info("6");
                if(rs.getValueAt(i,"INDICADORINGRESO")!=null){
                    dtoS.setAutorizacion(rs.getValueAt(i,"INDICADORINGRESO").toString());
                }
                UtilidadesLog.info("7");
                if(rs.getValueAt(i,"IND_ANUL")!=null&& rs.getValueAt(i,"IND_ANUL").toString().equals("1")){
                    dtoS.setIndAnulacion(Boolean.TRUE);
                }else{
                    dtoS.setIndAnulacion(Boolean.FALSE);
                }
                arrDtoS.add(dtoS);
            }
            UtilidadesLog.info("Array de dtos "+arrDtoS); 
          
            sql2.append(" SELECT   rlor.opre_oid_oper_recl AS OID, ");
            sql2.append("          (SELECT v.val_i18n ");
            sql2.append("          FROM v_gen_i18n_sicc v ");
            sql2.append("          WHERE v.val_oid = tm.oid_tipo_movi ");
            sql2.append("          AND v.attr_enti = 'REC_TIPO_MOVIM' ");
            sql2.append("          AND v.attr_num_atri = 1 ");
            sql2.append("          AND v.idio_oid_idio = ? ) AS desctipomovi, ");
            parametros2.add(dtoE.getOidIdioma());
            sql2.append("          pod.val_codi_vent, rlor.num_unid_recl, rlor.val_prec, ");
            //Agregado por Sapaza, fecha 08-02-2008, incidencia SiCC-20080557
            sql2.append("          rlor.val_prec_cont, ");
            //pzerbino 15/11/2006 Incidencia BELC300024290
            sql2.append("          nvl(psp.VAL_IMPO_DESC_UNIT_LOCA,0) as descuento, ");
            sql2.append("          rlor.num_unid_devu, mp.cod_sap, rlor.imp_carg, rlor.imp_abon, ");
            sql2.append("          (SELECT v.val_i18n ");
            sql2.append("          FROM v_gen_i18n_sicc v ");
            sql2.append("          WHERE v.val_oid = mp.oid_prod ");
            sql2.append("          AND v.attr_enti = 'MAE_PRODU' ");
            sql2.append("          AND v.attr_num_atri = 1 ");
            sql2.append("          AND v.idio_oid_idio = ? ) AS descprodu, ");
            parametros2.add(dtoE.getOidIdioma());
            sql2.append("          rlor.SOPO_OID_SOLI_POSI AS posicion");
            sql2.append("  FROM rec_linea_opera_recla rlor, ");
            sql2.append("       rec_tipo_movim tm, ");
            sql2.append("       mae_produ mp, ");
            sql2.append("       pre_ofert_detal pod, ");
            sql2.append("       pre_matri_factu mf, ");
            //pzerbino 15/11/2006 Incidencia BELC300024290
            sql2.append("       ped_solic_posic psp ");
            sql2.append("  WHERE rlor.opre_oid_oper_recl IN ( ? ");
            parametros2.add(((DTOOperacionReclamo)arrDtoS.get(0)).getOidOperacionReclamo().toString());
            if(arrDtoS.size()>1){
                for (int b=0;b<arrDtoS.size()-1;b++ )  {
                    sql2.append(", ? ");
                    parametros2.add(((DTOOperacionReclamo)arrDtoS.get(b+1)).getOidOperacionReclamo().toString());
                }
            }
            sql2.append("      ) ");
            sql2.append("    AND rlor.prod_oid_prod = mp.oid_prod ");
            sql2.append("    AND rlor.timo_oid_tipo_movi = tm.oid_tipo_movi ");
            sql2.append("    AND rlor.MAFA_OID_MATR_FACT = mf.OID_MATR_FACT(+) ");
            sql2.append("    AND mf.OFDE_OID_DETA_OFER = pod.OID_DETA_OFER(+) ");
            //pzerbino 15/11/2006 Incidencia BELC300024290
            sql2.append("    AND psp.OID_SOLI_POSI(+) = rlor.SOPO_OID_SOLI_POSI ");
            sql2.append("  ORDER BY OID ");
       
          
            try{
                rs = bs.dbService.executePreparedQuery(sql2.toString(), parametros2);
            }catch(Exception e){
                String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
            if(!rs.esVacio()){
               UtilidadesLog.info("Recordset Lineas "+rs.toString());
                for (int c=0;c<arrDtoS.size();c++)  {
                    ArrayList arrLineas = new ArrayList();
                    for (int d=0;d<rs.getRowCount() ;d++)  {
                        DTOLineaOperacion dtoL = new DTOLineaOperacion();
                        if(((DTOOperacionReclamo)arrDtoS.get(c)).getOidOperacionReclamo().equals(new Long(((BigDecimal)rs.getValueAt(d,"OID")).longValue()))){
                            dtoL.setOperacion(new Long(((BigDecimal)rs.getValueAt(d,"OID")).longValue()));
                            if(rs.getValueAt(d,"DESCTIPOMOVI")!=null){
                                dtoL.setTipoMovimiento(rs.getValueAt(d,"DESCTIPOMOVI").toString());
                            }
                            if(rs.getValueAt(d,"VAL_CODI_VENT")!=null){
                                dtoL.setCodigoVenta(rs.getValueAt(d,"VAL_CODI_VENT").toString());
                            }
                            if(rs.getValueAt(d,"NUM_UNID_RECL")!=null){
                                dtoL.setUnidadesReclamadas(new Integer(((BigDecimal)rs.getValueAt(d,"NUM_UNID_RECL")).intValue()));
                            }
                            if(rs.getValueAt(d,"VAL_PREC")!=null){
                                dtoL.setPrecio((BigDecimal)rs.getValueAt(d,"VAL_PREC"));
                            }
                            //Agregado por Sapaza, fecha 08-02-2008, incidencia SiCC-20080557                            
                            if(rs.getValueAt(d,"VAL_PREC_CONT")!=null){
                                dtoL.setPrecioContable((BigDecimal)rs.getValueAt(d,"VAL_PREC_CONT"));
                            }
                            //pzerbino 15/11/2006 Incidencia BELC300024290
                            if(rs.getValueAt(d,"DESCUENTO")!=null){
                                dtoL.setDescuento((BigDecimal)rs.getValueAt(d,"DESCUENTO"));
                            }
                            if(rs.getValueAt(d,"NUM_UNID_DEVU")!=null){
                                dtoL.setUnidadesDevueltas(new Integer(((BigDecimal)rs.getValueAt(d,"NUM_UNID_DEVU")).intValue()));
                            }
                            if(rs.getValueAt(d,"COD_SAP")!=null){
                                dtoL.setCodProducto(rs.getValueAt(d,"COD_SAP").toString());
                            }
                            if(rs.getValueAt(d,"IMP_CARG")!=null){
                                dtoL.setImporteCargo((BigDecimal)rs.getValueAt(d,"IMP_CARG"));
                            }
                            if(rs.getValueAt(d,"IMP_ABON")!=null){
                                dtoL.setImporteAbono((BigDecimal)rs.getValueAt(d,"IMP_ABON"));
                            }
                            if(rs.getValueAt(d,"DESCPRODU")!=null){
                                dtoL.setDescProducto(rs.getValueAt(d,"DESCPRODU").toString());
                            }
                            if(rs.getValueAt(d,"POSICION")!=null){
                                dtoL.setPosicionReferencia(new Long(((BigDecimal)rs.getValueAt(d,"POSICION")).longValue()));
                            }
                            
                            arrLineas.add(dtoL);
                        }
                    }
                    ((DTOOperacionReclamo)arrDtoS.get(c)).setLineas(arrLineas);
                }
                
                
            }
        }else{
            UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDetalleModificacionREC(DTODetalleReclamosREC):Salida");
            return null;
        }
      
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDetalleModificacionREC(DTODetalleReclamosREC):Salida");
        return arrDtoS;
    }
    
    public DTODatosDocumentoREC obtenerDatosDocumento(Long documento) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosDocumento(Long):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT FEC_CRON as FECHADOCUMENTO, ");
        sql.append(" PERD_OID_PERI as PERIODODOCUMENTO, ");
        sql.append(" TIDO_OID_TIPO_DOCU as TIPODOCUMENTO, ");
        sql.append(" sc.PAIS_OID_PAIS as PAIS,");
        sql.append(" pe.MARC_OID_MARC as MARCA,");
        sql.append(" pe.CANA_OID_CANA as CANAL ");
        sql.append(" FROM PED_SOLIC_CABEC sc, CRA_PERIO pe ");
        sql.append(" WHERE sc.PERD_OID_PERI = pe.OID_PERI AND OID_SOLI_CABE = ? ");
        parametros.add(documento);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerDatosDocumento: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }        
        
         DTODatosDocumentoREC dto = new DTODatosDocumentoREC();
         if (rs.getValueAt(0,"FECHADOCUMENTO") != null){
             dto.setFecha((Date)rs.getValueAt(0,"FECHADOCUMENTO"));
         }
         if (rs.getValueAt(0,1) != null){
            BigDecimal variable =(BigDecimal)rs.getValueAt(0,1);
             dto.setPeriodo(variable.toString());
         }
         if (rs.getValueAt(0,"TIPODOCUMENTO") != null){
             dto.setOidTipoDocumento(new Long(((BigDecimal)rs.getValueAt(0,"TIPODOCUMENTO")).toString()));
         }
        dto.setOidCanal(new Long(((BigDecimal)rs.getValueAt(0,"CANAL")).longValue()));
        dto.setOidMarca(new Long(((BigDecimal)rs.getValueAt(0,"MARCA")).longValue()));
        dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(0,"PAIS")).longValue()));
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosDocumento(Long):Salida");
        return dto;
    }
    
    //mamontie Incidencia 21616 05/12/05
    public RecordSet obtenerProductosDevuelveSi(DTOBuscarClientesREC dto) throws MareException{
        //Pendiente de incidencia 13872
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosDevuelveSi(DTOBuscarClientesREC):Entrada");
        
        
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        //SELECT
        
        sql.append("SELECT codigoventa || ROWNUM OID, TABLA.* ");
        sql.append(" FROM ( ");
        sql.append(" SELECT DISTINCT gen2.VAL_I18N AS DESCRIPCION, ");  // Modificado HRCS - Incidencia SiCC 20070080
        sql.append(" pe.VAL_NOMB_PERI as PERIODO, ");
        sql.append(" gen.VAL_I18N DESCRIPCIONTIPOOFERTA, ");  //Inc.21616
        sql.append(" od.TOFE_OID_TIPO_OFER as OIDTIPOOFERTA, ");
        sql.append(" NVL(sp.NUM_UNID_ATEN,'0') as UNIDADADESATENDIDAS, ");
        sql.append("NVL((SELECT SUM(lo.NUM_UNID_RECL) "); 
        sql.append("FROM REC_LINEA_OPERA_RECLA lo, ");
        sql.append("REC_OPERA_RECLA ror, ");
        sql.append("REC_CABEC_RECLA cr ");
        sql.append("WHERE lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
        sql.append("AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        if (dto.getOidCliente() != null) {
            sql.append("AND cr.CLIE_OID_CLIE = ? "); // -- cliente
            parametros.add(dto.getOidCliente());
        }
        sql.append("AND lo.MAFA_OID_MATR_FACT = MF.oid_matr_fact "); 
        sql.append("AND lo.TIMO_OID_TIPO_MOVI = ? "); // -- tipo movimiento
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
        if (dto.getNumDocumento() != null) {
            sql.append("AND cr.SOCA_OID_SOLI_CABE = ?"); // -- numero documento
            parametros.add(dto.getNumDocumento());
        }
        sql.append("),'0') as UNIDADESYARECLAMADAS, ");
        sql.append(" NVL(sp.NUM_UNID_ATEN,'0') - NVL((SELECT SUM(lo.NUM_UNID_RECL) "); 
        sql.append("FROM REC_LINEA_OPERA_RECLA lo, ");
        sql.append("REC_OPERA_RECLA ror, ");
        sql.append("REC_CABEC_RECLA cr ");
        sql.append("WHERE lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
        sql.append("AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        if (dto.getOidCliente() != null) {
            sql.append("AND cr.CLIE_OID_CLIE = ? "); // -- cliente
            parametros.add(dto.getOidCliente());
        }
        sql.append("AND lo.MAFA_OID_MATR_FACT = MF.oid_matr_fact "); // -- CODIGO VENTA
        sql.append("AND lo.TIMO_OID_TIPO_MOVI = ? "); // -- tipo movimiento
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
        if (dto.getNumDocumento() != null) {
            sql.append("AND cr.SOCA_OID_SOLI_CABE = ? "); // -- numero documento
            parametros.add(dto.getNumDocumento());
        }
        sql.append("),'0') as UNIDADESDISPONIBLES, ");
        sql.append(" od.VAL_CODI_VENT as CODIGOVENTA, ");
        sql.append(" MF.oid_matr_fact OID_COD_VENTA, ");
        
        sql.append(" sp.VAL_PREC_CATA_UNIT_LOCA AS precio_catalogo_unitario_loca, ");  
        sql.append(" sp.VAL_IMPO_DESC_UNIT_LOCA as descuento_unitario, ");
        sql.append(" CASE WHEN sp.VAL_PREC_CONT_UNIT_LOCA <> 0 ");
        sql.append("   THEN 0 ");
        sql.append("   ELSE sp.VAL_PREC_FACT_UNIT_LOCA ");
        sql.append(" END AS precio_factura_unitario_local, ");
        sql.append(" sp.VAL_PREC_CONT_UNIT_LOCA AS precio_contable_unitario_loca, ");
        sql.append(" '' NUMEROCONCURSO, '' NUMERONIVEL, '' NUMPREMIO, ");
        sql.append(" mp.COD_SAP as CODIGOPRODUCTO, ");
        sql.append(" mp.OID_PROD OID_PRODUCTO, ");
        sql.append(" sp.OID_SOLI_POSI, ");
        
        sql.append(" '' OIDCONCURSO, ");
        sql.append(" '' OIDNIVEL, ");
        sql.append(" '' OIDPREMIO ");
        
        sql.append(" FROM PED_SOLIC_CABEC sc,  ");
        sql.append(" PED_SOLIC_POSIC sp, ");
        sql.append(" PED_ESTAD_POSIC ep, ");
        sql.append(" MAE_PRODU mp, ");
        sql.append(" v_gen_i18n_sicc gen2, ");  // Agregado por HRCS - Incidencia SiCC 20070080
        sql.append(" CRA_PERIO pe, ");
        sql.append(" PRE_OFERT_DETAL od, PRE_MATRI_FACTU MF, ");
        sql.append(" PRE_TIPO_OFERT tipo, "); 
        sql.append(" V_GEN_I18N_SICC gen "); 
        
        sql.append(" ,PRE_MATRI_FACTU_CABEC pmfc ");
        
        sql.append(" WHERE sp.ESPO_OID_ESTA_POSI = ep.OID_ESTA_POSI ");
        sql.append(" AND MF.ofde_oid_deta_ofer = od.oid_deta_ofer "); // -- CODIGO VENTA
        sql.append(" AND sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
        sql.append(" AND sp.PROD_OID_PROD = mp.OID_PROD ");
        
        //Modificado por Cristian Valenzuela - 3/11/2006
        //Incidencia: DBLG700000113
        sql.append(" AND sc.PERD_OID_PERI = pe.OID_PERI ");
        sql.append(" AND mf.MFCA_OID_CABE = pmfc.OID_CABE ");
        //sql.append(" AND pmfc.PERD_OID_PERI = pe.oid_peri ");
        //FIN - Modificado por Cristian Valenzuela - 3/11/2006        
        if(dto.getCodigoVenta()!=null){
          sql.append(" AND od.VAL_CODI_VENT LIKE '"+dto.getCodigoVenta()+"'");
        }
        sql.append(" AND sp.OFDE_OID_DETA_OFER = od.OID_DETA_OFER ");
        sql.append(" AND od.TOFE_OID_TIPO_OFER = tipo.OID_TIPO_OFER "); //Inc.21616
        sql.append(" AND gen.ATTR_ENTI='PRE_TIPO_OFERT' "); //Inc.21616
        sql.append(" AND gen.IDIO_OID_IDIO = " + dto.getOidIdioma()); //Inc.21616
        sql.append(" AND gen.VAL_OID = tipo.OID_TIPO_OFER "); //Inc.21616
        sql.append(" AND gen.ATTR_NUM_ATRI = 1 "); //Inc.21616        
        sql.append(" and gen2.ATTR_ENTI = 'MAE_PRODU' ");   // Agregado por HRCS - Incidencia SiCC 20070080
		sql.append(" and gen2.VAL_OID = mp.OID_PROD ");
        sql.append(" and gen2.ATTR_NUM_ATRI = 1 ");
		sql.append(" and gen2.IDIO_OID_IDIO = " + dto.getOidIdioma());
        //sql.append(" AND sc.MONE_OID_MONE = mo.OID_MONE (+) "); 22743
        sql.append(" AND ep.OID_ESTA_POSI <> ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        if (dto.getNumDocumento() != null){
            sql.append("AND sc.SOCA_OID_SOLI_CABE = ? ");
            parametros.add(dto.getNumDocumento());
        }
            
        sql.append(" ORDER BY codigoventa ) TABLA ");
        
        /*inicio ciglesias incidencia BELC300024561*/
        String sqlPaginada = this.armarQueryPaginacionEspecial(sql.toString(), dto);
        /*fin ciglesias incidencia BELC300024561*/
        
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosDevuelveSi(DTOBuscarClientesREC):Salida");
        return rs;
    }
    
    private String armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto) {
      UtilidadesLog.info("DAOCapturaProcesoReclamos.armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto):Entrada");
      
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

         UtilidadesLog.info("DAOCapturaProcesoReclamos.armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto):Salida");
         return salida.toString();
      }
  } 

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * @author Marcelo J. Maidana
     * @date 10/03/2006
     * Este método reemplaza a obtenerValidaOperacion(DTOValidaOperacionREC)
     */
    public RecordSet obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC dto) 
            throws MareException {
    
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC):Entrada");
    
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT rec_motiv_bloqu.val_moti_bloq AS chequeofisico, ");
        sql.append(" rec_opera.ind_anul AS indicadoranulacion, ");
        sql.append(" rec_opera.val_perd AS indicadorperdida, ");
        sql.append(" rec_opera.val_ingr_devu AS ingresadevuelve, ");
        sql.append(" rec_opera.ind_ingr_envi AS ingresaenvia, ");
        sql.append(" rec_opera.ind_envi_gene_devu enviageneradevuelve, ");
        sql.append(" rec_opera.ind_devu_gene_envi devuelvegeneraenvia, ");
        sql.append(" rec_opera.ind_devu_fisi_fact AS devuelvefisicofactura, ");
        sql.append(" rec_tipos_opera.ind_devu_esta_fact AS devuelvefactura, ");
        sql.append(" rec_tipos_opera.ind_envi_esta_fact AS enviafactura, ");
        sql.append(" penvia.COD_PREC_ENVI AS precioenvia, ");
        sql.append(" mprecio.COD_PREC AS matriz ");
        //Cambio 20080765 
        sql.append(" ,REC_OPERA.IND_RECO ");
        //-Cambio 20080765 
        sql.append(" FROM rec_opera, rec_tipos_opera, rec_motiv_bloqu, rec_preci_envia  penvia , rec_preci mprecio ");
        sql.append(" WHERE rec_tipos_opera.rope_oid_oper = rec_opera.oid_oper ");
        sql.append(" AND rec_opera.oid_oper = ? ");
        parametros.add(dto.getOidOperacion());
        sql.append(" AND rec_tipos_opera.oid_tipo_oper = ? ");
        parametros.add(dto.getOidTipoOperacion());
        sql.append(" AND rec_opera.mobl_oid_moti_bloq = rec_motiv_bloqu.oid_moti_bloq(+) ");
        sql.append(" AND rec_opera.PENV_OID_PRECIO_ENVIA = penvia.OID_PREC_ENVI(+) ");
        sql.append(" AND rec_opera.PECI_OID_PECI = mprecio.OID_PREC ");
        
        UtilidadesLog.debug("query: " + sql);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        // Añadido por hsanchez
        if(rs.esVacio()){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "No hay datos en DAOCapturaProcesoReclamos.obtenerValidaOperacion";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC):Salida");
        
        return rs;
    }


/*
    public RecordSet obtenerValidaOperacion(DTOValidaOperacionREC dto) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerValidaOperacion(DTOValidaOperacionREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT op.VAL_INGR_DEVU AS INGRESADEVUELVE, ");
        sql.append(" op.IND_INGR_ENVI AS INGRESAENVIA, ");
        sql.append(" op.IND_ENVI_GENE_DEVU ENVIAGENERADEVUELVE, ");
        sql.append(" op.IND_DEVU_GENE_ENVI DEVUELVEGENERAENVIA, ");
        sql.append(" op.IND_DEVU_FISI_FACT AS DEVUELVEFISICOFACTURA, ");
        sql.append(" rto.IND_DEVU_ESTA_FACT AS DEVUELVEFACTURA, ");
        sql.append(" rto.IND_ENVI_ESTA_FACT AS ENVIAFACTURA ");
        sql.append(" FROM REC_OPERA oP, REC_TIPOS_OPERA rto ");
        sql.append(" WHERE rto.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND op.OID_OPER = ? ");
        parametros.add(dto.getOidOperacion());
        sql.append(" AND rto.OID_TIPO_OPER = ? ");
        parametros.add(dto.getOidTipoOperacion());
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        // Añadido por hsanchez
        if(rs.esVacio()){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "No hay datos en DAOCapturaProcesoReclamos.obtenerValidaOperacion";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerValidaOperacion(DTOValidaOperacionREC):Salida");
        return rs;
    }
*/
    
    public RecordSet obtenerEstadoLineasReclamo(Long numAtencion) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerEstadoLineasReclamo(Long):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT lo.OPRE_OID_OPER_RECL OIDOPERACION, ");
        sql.append(" lo.OID_LINE_OPER_RECL OIDLINEA, ");
        sql.append(" lo.IND_ESTA ESTADOLINEA ,");
        sql.append(" ror.ESOP_OID_ESTA_OPER OIDESTADOPERA " );
        sql.append(" FROM REC_CABEC_RECLA cr , ");
        sql.append(" REC_OPERA_RECLA ror, ");
        sql.append(" REC_LINEA_OPERA_RECLA lo ");
        sql.append(" WHERE lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
        sql.append(" AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        if (numAtencion != null){
            sql.append(" AND cr.NUM_ATEN = ? ");    
            parametros.add(numAtencion);
        }
        sql.append(" ORDER BY lo.OPRE_OID_OPER_RECL ");

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("RecordSet obtenido: " + rs);

        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerEstadoLineasReclamo(Long):Salida");
        return rs;
    }
    
    // Incidencia 13876 resuelta
    // BELC300014262 resuelta
    // BELC300015175 resuelta
    // BELC300015203 resuelta
    public RecordSet obtenerDatosPerdida(DTOOperacion oidOperacion, Long oidTipoSolicitudPais) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosPerdida(DTOOperacion):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros  = new Vector();
        
        //SELECT
        sql.append(" SELECT lo.OID_LINE_OPER_RECL OIDLINEA, op.VAL_PERD AS PERDIDA, ");
        sql.append(" ror.ASPE_OID_ASUM_PERD AS ASUMEPERDIDA, ");
        sql.append(" lo.IMP_MONT_PERD AS MONTOPERDIDA, ");
        sql.append(" op.TSPA_OID_SOLI_PAIS_PERD AS SOLICITUDPERDIDA, "); // BELC300019211
        sql.append(" ror.CLIE_OID_CLIE AS CLIENTESEGURO, ");
        sql.append(" ts.MARC_OID_MARC AS MARCA, ");
        sql.append(" ts.SBAC_OID_SBAC AS SUBACCESO, ");
        sql.append(" cr.CLIE_OID_CLIE AS OIDCLIENTE, ");
        sql.append(" ror.PERD_OID_PERI_RECL AS OIDPERIODO, ");
        sql.append(" cr.SOCA_OID_SOLI_CABE AS OIDSOLICITUDREFERENCIA, ");
        sql.append(" lo.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO, ");
        sql.append(" do.VAL_CODI_VENT AS CODVENTA, ");
        
                
        sql.append(" mp.COD_SAP AS CODPRODUCTO, ");
        sql.append(" mp2.COD_SAP AS CODIGOARTICULO, ");
        sql.append(" lo.NUM_UNID_RECL AS UDEMANDADAS, ");
        sql.append(" mp.OID_PROD AS OIDPRODUCTO, lo.val_prec precio,");
        sql.append(" mp2.OID_PROD AS OIDARTICULO, ");
        sql.append(" ror.IMP_MONT_PERD AS MONTOPERDIDAOPERACION, "); // BELC300019551
        sql.append(" ror.CLIE_OID_RESP_PERD RESPONSABLEPERDIDA, "); //mamontie REC-12  prueba
        sql.append(" op.OID_OPER , ");
        sql.append(" rto.IND_DEVU_ESTA_FACT, ");
        //Gacevedo: El cambio en la forma de obtener el precio catalogo unitario local
        //responde al intento de solucion de la incidencia DBLG700000110.
        //Si la linea de operacion no tiene posicion de referencia, se usa el
        //detalle de oferta para traer el precio en cuestion.
        //sql.append(" posi.val_prec_cata_unit_loca AS preciocataunitariolocal, ");//incidencia 22743
         sql.append(" CASE WHEN lo.sopo_oid_soli_posi IS NULL ");
	   	sql.append(" THEN (SELECT precio_unitario FROM pre_ofert_detal p WHERE p.OID_DETA_OFER = mf.ofde_oid_deta_ofer) ");
			sql.append(" ELSE posi.val_prec_cata_unit_loca ");
	   	sql.append(" END AS preciocataunitariolocal, ");
        //Fin del cambio de Gacevedo (DBLG700000110).
        sql.append(" lo.VAL_PREC_CONT AS preciocontunitariolocal, ");//incidencia 22743
        sql.append(" posi.val_impo_desc_unit_loca AS impdescunilocal, ");//incidencia 22743
        sql.append(" posi.val_porc_desc AS porcentajedesc, ");//incidencia 22743
        sql.append(" posi.val_prec_cata_unit_docu AS preccataunidocu, ");//incidencia 22743
        sql.append(" posi.val_prec_conta_unit_docu AS preccontunidocu, ");//incidencia 22743
        sql.append(" posi.val_impo_desc_unit_docu AS impdescunidocu, ");//incidencia 22743
        //se agrega el campo a fin de grabarlo en la posicion que se genera por el reclamo
        sql.append(" do.OID_DETA_OFER AS detalleoferta, ");//incidencia 22743
        sql.append(" lo.SOPO_OID_SOLI_POSI AS OIDPOSICION, ");//V-REC-18
        sql.append(" op.IND_FALT_MERC,  ");
        sql.append(" op.IND_DEVU_FISI_FACT ");
        //FROM
        sql.append(" FROM REC_OPERA_RECLA ror, ");
        sql.append(" REC_TIPOS_OPERA rto, ");
        sql.append(" REC_OPERA op, ");
        sql.append(" PED_TIPO_SOLIC_PAIS sp, ");
        sql.append(" REC_LINEA_OPERA_RECLA lo, ");
        sql.append(" PRE_MATRI_FACTU mf, ");
        sql.append(" PRE_OFERT_DETAL do, ");
               
        sql.append(" MAE_PRODU mp, ");
        sql.append(" MAE_PRODU mp2, ");
        sql.append(" REC_CABEC_RECLA cr, ");
        sql.append(" PED_TIPO_SOLIC ts, ");
        sql.append(" PED_SOLIC_POSIC posi ");//incidencia 22743
        //WHERE
        sql.append(" WHERE ror.TIOP_OID_TIPO_OPER = rto.OID_TIPO_OPER ");
        sql.append(" AND rto.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND op.TSPA_OID_SOLI_PAIS_PERD = sp.OID_TIPO_SOLI_PAIS(+) ");
        sql.append(" AND lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
        sql.append(" AND lo.MAFA_OID_MATR_FACT = mf.OID_MATR_FACT (+)");
        sql.append(" AND mf.OFDE_OID_DETA_OFER = do.OID_DETA_OFER (+)");
        
        //Agrego cambio REC-004
        // Se agrega este filtro para que solo se trabaje con las lineas de precios
        // las lineas de premio se procesaran luego 
        sql.append(" AND lo.COPA_OID_PARA_GRAL is null ");
        // FIN del REC-004
        
        sql.append(" AND lo.PROD_OID_PROD = mp.OID_PROD(+) ");
        sql.append(" AND ror.PROD_OID_PROD = mp2.OID_PROD(+) ");
        sql.append(" AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        sql.append(" AND sp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI(+) ");
        sql.append(" AND lo.SOPO_OID_SOLI_POSI = posi.OID_SOLI_POSI(+) ");//incidencia 22743
        sql.append(" AND cr.PAIS_OID_PAIS = ? ");
        parametros.add(oidOperacion.getOidPais());

        if (oidTipoSolicitudPais != null)  {
            sql.append(" AND lo.TSPA_OID_TIPO_SOLI_PAIS = ? ");
            parametros.add(oidTipoSolicitudPais);
        }        
        if (oidOperacion.getOidOperacion() != null){
            sql.append(" AND ror.OID_OPER_RECL = ? ");
            parametros.add(oidOperacion.getOidOperacion());
        }
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("******** RecordSet obtenido: " + rs);        
         
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosPerdida(DTOOperacion):Salida");
        return rs;
    }
    
     
    // incidencia BELC300015203
    public RecordSet obtenerLineasPorSolicitud(DTOAtencionReclamoREC numAtencion) throws MareException{
        // BELC300014262
        //Modificado nuevamente por BELC300018563
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasPorSolicitud(DTOAtencionReclamoREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append(" SELECT lo.OPRE_OID_OPER_RECL AS OIDOPERACION, cr.NUM_ATEN, ");
 		sql.append(" lo.OID_LINE_OPER_RECL AS  OIDLINEA,  ");
 		sql.append(" ts.MARC_OID_MARC AS MARCA, ");
 		sql.append(" ac.CANA_OID_CANA AS CANAL, ");
 		sql.append(" ts.ACCE_OID_ACCE AS ACCESO, ");
 		sql.append(" ts.SBAC_OID_SBAC AS SUBACCESO, ");
 		sql.append(" cr.CLIE_OID_CLIE AS OIDCLIENTE, ");
 		sql.append(" cr.PERD_OID_PERI_RECL AS OIDPERIODO, ");
 		sql.append(" sp.OID_TIPO_SOLI_PAIS AS OIDTIPOSOLICITUD, ");
 		sql.append(" cr.SOCA_OID_SOLI_CABE AS OIDSOLICITUDREFERENCIA, ");
 		sql.append(" lo.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO, ");
 		sql.append(" do.VAL_CODI_VENT AS CODVENTA, ");
 		sql.append(" lo.VAL_PREC AS PRECIO, ");
 		sql.append(" mp.COD_SAP AS CODPRODUCTO, ");
 		sql.append(" lo.NUM_UNID_RECL AS UDEMANDADAS, ");
 		sql.append(" mp.OID_PROD AS OIDPRODUCTO ");
    //sql.append(" opera.peci_oid_peci as INDPRECIO ");
        //sql.append(" cr.TIDO_OID_TIPO_DOCU AS TIPODOCUMENTO ");
    if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(numAtencion.getNumRecojo())
       || ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(numAtencion.getNumRecojo())){   
          sql.append(" , ");
          sql.append(" ( ");
          sql.append(" SELECT MIN(FEC_INIC) ");
          sql.append(" FROM CRA_CRONO CCR, CRA_ACTIV CAC ");
          sql.append(" WHERE CCR.ZZON_OID_ZONA = PSC.ZZON_OID_ZONA ");
          sql.append(" AND CCR.CACT_OID_ACTI = CAC.OID_ACTI ");
          sql.append(" AND CAC.COD_ACTI = 'FA' ");
          sql.append(" AND CCR.FEC_INIC > SYSDATE ");
          sql.append(" ) AS FECHAFACT, ");
          sql.append(" ( ");
          sql.append(" SELECT CCR.PERD_OID_PERI ");
          sql.append(" FROM CRA_CRONO CCR, CRA_ACTIV CAC ");
          sql.append(" WHERE CCR.ZZON_OID_ZONA = PSC.ZZON_OID_ZONA ");
          sql.append(" AND CCR.CACT_OID_ACTI = CAC.OID_ACTI ");
          sql.append(" AND CAC.COD_ACTI = 'FA' ");
          sql.append(" AND CCR.FEC_INIC >= SYSDATE ");
          sql.append(" AND CCR.FEC_INIC = (SELECT MIN(FEC_INIC) ");
          sql.append(" FROM CRA_CRONO CCR, CRA_ACTIV CAC ");
          sql.append(" WHERE CCR.ZZON_OID_ZONA = PSC.ZZON_OID_ZONA ");
          sql.append(" AND CCR.CACT_OID_ACTI = CAC.OID_ACTI ");
          sql.append(" AND CAC.COD_ACTI = 'FA' ");
          sql.append(" AND CCR.FEC_INIC > SYSDATE) ");
          sql.append(" ) AS PERIODOFACTURACION ");
    }
 		sql.append(" FROM REC_CABEC_RECLA cr, ");
 		sql.append(" REC_OPERA_RECLA ror, ");
 		sql.append(" REC_LINEA_OPERA_RECLA lo, ");
 		sql.append(" PED_TIPO_SOLIC_PAIS sp, ");
 		sql.append(" PRE_MATRI_FACTU mf, ");
 		sql.append(" PRE_OFERT_DETAL do, ");
 		sql.append(" MAE_PRODU mp, ");
 		sql.append(" PED_TIPO_SOLIC ts, ");
 		sql.append(" SEG_ACCES ac");
    if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(numAtencion.getNumRecojo())
       || ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(numAtencion.getNumRecojo())){    
          sql.append(" ,ped_solic_cabec psc ");
          sql.append(" ,rec_solic_opera rso ");
          sql.append(" ,PED_SOLIC_CABEC PSC2 ");
       }
        
 		sql.append(" WHERE lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
 		sql.append(" AND cr.PAIS_OID_PAIS = " + numAtencion.getOidPais());
 		sql.append(" AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
 		sql.append(" AND lo.MAFA_OID_MATR_FACT = mf.OID_MATR_FACT(+) ");
 		sql.append(" AND mf.OFDE_OID_DETA_OFER = do.OID_DETA_OFER(+) ");
 		sql.append(" AND lo.PROD_OID_PROD = mp.OID_PROD(+) ");
 		sql.append(" AND lo.TSPA_OID_TIPO_SOLI_PAIS = sp.OID_TIPO_SOLI_PAIS (+)  ");
 		sql.append(" AND sp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI (+) ");
 		sql.append(" AND ts.ACCE_OID_ACCE = ac.OID_ACCE (+) ");
        
 		sql.append(" AND lo.COPA_OID_PARA_GRAL is null ");
        
        sql.append(" AND (ror.INEM_OID_INDI_ENTR_MERC = " + ConstantesREC.IND_MERCADERIA_S);
 		sql.append(" OR ror.INEM_OID_INDI_ENTR_MERC = " + ConstantesREC.IND_MERCADERIA_C + ") ");

        if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(numAtencion.getNumRecojo())
           || ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(numAtencion.getNumRecojo())){
            sql.append(" AND ror.OID_OPER_RECL = rso.OPRE_OID_OPER_RECL ");
            sql.append(" AND rso.SOCA_OID_SOLI_CABE = psc.oid_soli_cabe ");
            sql.append(" AND psc.GRPR_OID_GRUP_proc = "+ConstantesPED.GP5+" ");
            sql.append(" AND lo.TIMO_OID_TIPO_MOVI = "+ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE+" ");
            sql.append(" AND RSO.SOCA_OID_SOLI_CABE = PSC2.OID_SOLI_CABE ");
            sql.append(" AND PSC2.PERD_OID_PERI = CR.PERD_OID_PERI_RECL ");
        } else {
            //agregado por inc 22749
            sql.append(" AND (ror.ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_INGRESADO);
            sql.append(" OR ror.ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_DIGITADO);
            sql.append(" OR ror.ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_PARCIAL + ")");
            sql.append(" AND (cr.ESRE_OID_ESTA_RECL = " + ConstantesREC.ESTADO_RECLAMO_INGRESADO);
            sql.append(" OR cr.ESRE_OID_ESTA_RECL = " + ConstantesREC.ESTADO_RECLAMO_DIGITADO);
            sql.append(" OR cr.ESRE_OID_ESTA_RECL = " + ConstantesREC.ESTADO_RECLAMO_PARCIAL + ")");
            //FIN agregado por inc 22749
        }
        if (numAtencion.getNumAtencion() != null){
            sql.append(" AND cr.NUM_ATEN = " + numAtencion.getNumAtencion());
        }
    
    sql.append(" AND sp.oid_tipo_soli_pais IS NOT NULL ");
        //sql.append(" AND ror.tiop_oid_tipo_oper = tipooperacion.oid_tipo_oper ");
    //sql.append(" AND tipooperacion.rope_oid_oper = opera.oid_oper ");
    
 		sql.append(" ORDER BY sp.TSOL_OID_TIPO_SOLI, ");
 		sql.append(" lo.OPRE_OID_OPER_RECL ");
 
    UtilidadesLog.debug("sql: " + sql);
    UtilidadesLog.debug("Parametros: " + parametros);
    
    RecordSet rs = null;
    BelcorpService bs = BelcorpService.getInstance();
    try {
        rs = bs.dbService.executeStaticQuery(sql.toString());
    } catch(Exception e) {
        String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    UtilidadesLog.debug("RecordSet obtenido: " + rs);
    
    UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasPorSolicitud(DTOAtencionReclamoREC):Salida");
    return rs;
 }
    
	public RecordSet obtenerTotales(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerTotales(DTOOID):Entrada");
		
		StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
		
		sql.append("SELECT SUM(lo.imp_abon) as TOTALABONO, SUM(lo.imp_carg) AS TOTALCARGO ");
		sql.append("FROM REC_LINEA_OPERA_RECLA lo ");
		sql.append("WHERE lo.opre_oid_oper_recl = ?");
		parametros.add(dto.getOid());
		
		RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      try{
         rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      }catch(Exception e){
         String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
        
      if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
         UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerTotales: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }        
		
		UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerTotales(DTOOID):Salida");
		return rs;
	}
	
    // Incidencia BELC300014526
	public RecordSet obtenerOperacionesReclamo (DTOBuscarReclamosREC dto) throws MareException {
		UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperacionesReclamo(DTOBuscarReclamosREC):Entrada");
		
		StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
		
        sql.append(" SELECT re.OID_OPER_RECL AS OID, ");
        sql.append(" re.NUM_SECU_OPER AS NUMSECOPERACION, ");
        sql.append(" op.COD_OPER AS CODOPERACION, ");
        //internacionalizable correspondiente a ti.OID_TIPO_OPER TIPOOPERACION, 
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_TIPOS_OPERA' ");
        sql.append(" AND idio.VAL_OID = ti.OID_TIPO_OPER ");
        sql.append(" AND idio.ATTR_NUM_ATRI=1  ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ) AS TIPOOPERACION, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" sc.VAL_NUME_SOLI AS NUMDOCREFERENCIA, ");
        
        sql.append(" pe.val_nomb_peri AS periodo, ");
        //internacionalizable correspondiente a pc.OID_PERI PERIODO
        /*sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'SEG_PERIO_CORPO' ");
        sql.append(" AND idio.VAL_OID = pc.OID_PERI ");
        sql.append(" AND idio.ATTR_NUM_ATRI=1 "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? ) AS PERIODO, ");
        parametros.add(dto.getOidIdioma());*/        
        
        //internacionalizable correspondiente a eo.OID_ESTA_OPER ESTADOOPERACION,
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_ESTAD_OPERA' ");
        sql.append(" AND idio.VAL_OID = eo.OID_ESTA_OPER ");
        sql.append(" AND idio.ATTR_NUM_ATRI=1 "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? ) AS ESTADOOPERACION, ");
        parametros.add(dto.getOidIdioma());
        //internacionalizable correspondiente a mb.OID_MOTI_BLOQ MOTIVOBLOQUEO
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_BLOQU' ");
        sql.append(" AND idio.VAL_OID = mb.OID_MOTI_BLOQ ");
        sql.append(" AND idio.ATTR_NUM_ATRI=1 "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? ) AS MOTIVOBLOQUEO ");
        parametros.add(dto.getOidIdioma());
        // Elimino MAE_CLIEN y REC_TIPOS_BLOQU. No se usan
        
        sql.append(" FROM REC_OPERA_RECLA re, REC_OPERA op, "); 
        sql.append(" REC_TIPOS_OPERA ti, CRA_PERIO pe, "); 
        //sql.append(" SEG_PERIO_CORPO pc, PED_SOLIC_CABEC sc, REC_MOTIV_BLOQU mb, REC_ESTAD_OPERA eo ");
        sql.append(" PED_SOLIC_CABEC sc, REC_MOTIV_BLOQU mb, REC_ESTAD_OPERA eo ");
        
        sql.append(" WHERE ");
        sql.append(" ti.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND re.TIOP_OID_TIPO_OPER = ti.OID_TIPO_OPER ");
        //sql.append(" AND re.PERD_OID_PERI = pe. oid_peri (+)");//comentado por laInc. 22380 (REC-11).
        sql.append(" AND re.PERD_OID_PERI_RECL = pe.OID_PERI (+)");
        sql.append(" AND re.MOBL_OID_MOTI_BLOQ = mb.oid_moti_bloq  (+)");
        sql.append(" AND re.ESOP_OID_ESTA_OPER = eo.oid_esta_oper (+)");
        sql.append(" AND re.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE (+)");
        //sql.append(" AND pe.PERI_OID_PERI = pc.OID_PERI (+)"); //comentado por laInc. 22380 (REC-11). 
        //sql.append(" AND re.PERD_OID_PERI_RECL = pc.OID_PERI (+)");        
        sql.append(" AND ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_BLOQUEO ); //inc.DBLG400001062 mamontie 14/02/06
        // BELC300014526
        /*if (dto.getOidsReclamo() != null && dto.getOidsReclamo().size() > 0){
            sql.append(" AND re.CARE_OID_CABE_RECL = ? ");
            parametros.add(dto.getOidsReclamo().get(0));    
        }*/
        //modificado por incidencia 15099
        sql.append(" AND re.CARE_OID_CABE_RECL = ? ");
         parametros.add(dto.getOid());
        
        if(dto.getOidsOperaciones() != null && dto.getOidsOperaciones().size()>0) {
            sql.append(" AND op.OID_OPER IN ( ? ");
            parametros.add(dto.getOidsOperaciones().get(0));
            for(int i=1; i<dto.getOidsOperaciones().size(); i++) {
                sql.append(", ? ");
                parametros.add(dto.getOidsOperaciones().get(i));
            }
            sql.append(" ) ");
        }
        if(dto.getOidsTiposBloqueo() != null && dto.getOidsTiposBloqueo().size()>0) {
            sql.append(" AND re.TIBL_OID_TIPO_BLOQ IN ( ? ");
            parametros.add(dto.getOidsTiposBloqueo().get(0));
            for(int i=1; i<dto.getOidsTiposBloqueo().size(); i++) {
                sql.append(", ? ");
                parametros.add(dto.getOidsTiposBloqueo().get(i));
            }
            sql.append(" ) ");
        }

        sql.append(" ORDER BY NUMSECOPERACION ");
        
		RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

      if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerOperacionesReclamo: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }
		
		UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperacionesReclamo (DTOBuscarReclamosREC):Salida");
		return rs;
	}
	
   public RecordSet obtenerProductosEnvia(DTOBuscarEnvia dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosEnvia(DTOBuscarEnvia):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
         
         sql.append("  SELECT * FROM (   ");
         sql.append("  SELECT ROWNUM OID, query.* ");
         sql.append("  FROM ( SELECT DISTINCT gen2.VAL_I18N  AS DESCRIPCION, pe.val_nomb_peri periodo, ");
         sql.append("           gen.val_i18n descripciontipooferta, od.tofe_oid_tipo_ofer oidtipooferta, ");
         sql.append("           sp.num_unid_aten unidadesatendidas, ");
         sql.append("           (SELECT SUM (lo.num_unid_recl) ");
         sql.append("              FROM rec_linea_opera_recla lo, ");
         sql.append("                   rec_opera_recla ror, ");
         sql.append("                   rec_cabec_recla cr ");
         sql.append("             WHERE lo.opre_oid_oper_recl = ror.oid_oper_recl ");
         sql.append("               AND ror.care_oid_cabe_recl = cr.oid_cabe_recl ");
         sql.append("               AND lo.mafa_oid_matr_fact = mf.oid_matr_fact ");
         sql.append("               AND lo.timo_oid_tipo_movi = " + ConstantesREC.TIPO_MOVIMIENTO_ENVIA);
         if (dto.getOidCliente() != null) {
            sql.append(" AND cr.CLIE_OID_CLIE = ? "); // -- cliente
            parametros.add(dto.getOidCliente());
         }
         if (dto.getOidNumDocumento() != null) {
            sql.append(" AND cr.SOCA_OID_SOLI_CABE = ?"); // -- numero documento
            parametros.add(dto.getOidNumDocumento());
         }         
         sql.append("  			 ) AS unidadesyareclamadas, ");
         sql.append("           od.val_codi_vent codigoventa, mf.oid_matr_fact oid_cod_venta, ");
         sql.append("           DECODE (sp.val_prec_cont_unit_loca, ");
         sql.append("                    0, DECODE (rp.oid_prec_envi, ");
         sql.append(                    ConstantesREC.PRECIO_ENVIA_FACTURA + ", sp.val_prec_fact_unit_loca, ");
         sql.append("                       sp.val_prec_cata_unit_loca ),0 ) PRECIOENVIADO, ");
         sql.append("                        NVL(SP.VAL_PREC_CONT_UNIT_LOCA, 0) AS PRECIOCONTAUNITARIODOC, ");
         /*sql.append("           DECODE (rp.oid_prec_envi, ");
         sql.append("                   " + ConstantesREC.PRECIO_ENVIA_FACTURA + ", sp.val_prec_fact_unit_loca, ");
         sql.append("                   sp.val_prec_cata_unit_loca ");
         sql.append("                  ) precioenviado, ");
         sql.append(" sp.VAL_PREC_CONT_UNIT_loca AS PRECIOCONTAUNITARIOLOCA, ");*///comentado por REC-004

         sql.append("  		 '' NUMEROCONCURSO, '' NUMERONIVEL, '' NUMPREMIO, ");
         sql.append("           mp.cod_sap codigoproducto, mp.oid_prod,  ");
         sql.append("  			 sp.OID_SOLI_POSI OIDPOSICION ");
         sql.append("          , '' OIDCONCURSO "); //  Agregado 02/08/2007
         sql.append("          , '' OIDNIVEL ");
		 sql.append("          , '' OIDPREMIO ");
         sql.append("      FROM ped_solic_cabec sc, ");
         sql.append("           seg_moned mo, ");
         sql.append("           ped_solic_cabec sc2, ");
         sql.append("           ped_solic_posic sp, ");
         sql.append("           ped_estad_posic ep, ");
         sql.append("           mae_produ mp, ");
         sql.append("           cra_perio pe, ");
         sql.append("           pre_ofert_detal od, ");
         sql.append("           pre_matri_factu mf, ");
         sql.append("           pre_tipo_ofert tipo, ");
         sql.append("           v_gen_i18n_sicc gen, ");
         sql.append("           v_gen_i18n_sicc gen2, ");
         sql.append("           rec_opera ro, ");
         sql.append("           rec_preci_envia rp ");
         sql.append("          ,PRE_MATRI_FACTU_CABEC pmfc ");
         sql.append("     WHERE sc.oid_soli_cabe = sc2.soca_oid_soli_cabe ");
         sql.append("       AND sc2.oid_soli_cabe = sp.soca_oid_soli_cabe ");
         sql.append("       AND sc.mone_oid_mone = mo.oid_mone(+) ");
         sql.append("       AND sp.espo_oid_esta_posi = ep.oid_esta_posi ");
         sql.append("       AND sp.prod_oid_prod = mp.oid_prod ");
         sql.append("       AND mf.MFCA_OID_CABE = pmfc.OID_CABE ");
				 sql.append("       AND pmfc.PERD_OID_PERI = pe.oid_peri ");
         sql.append("       AND sp.ofde_oid_deta_ofer = od.oid_deta_ofer ");
         sql.append("       AND mf.ofde_oid_deta_ofer = od.oid_deta_ofer ");
         sql.append("       AND ro.penv_oid_precio_envia = rp.oid_prec_envi ");
         sql.append("       AND od.tofe_oid_tipo_ofer = tipo.oid_tipo_ofer ");
         sql.append("       AND gen.attr_enti = 'PRE_TIPO_OFERT' ");
         sql.append("       AND gen.idio_oid_idio = " + dto.getOidIdioma());
         sql.append("       AND gen.val_oid = tipo.oid_tipo_ofer ");
         sql.append("       AND gen.attr_num_atri = 1 ");
         sql.append("       AND gen2.ATTR_ENTI = 'MAE_PRODU' ");
		     sql.append("       AND gen2.VAL_OID = mp.OID_PROD ");
		     sql.append("       AND gen2.ATTR_NUM_ATRI = 1 ");
         sql.append("       AND gen2.idio_oid_idio = " + dto.getOidIdioma());
         sql.append("       AND sc.pais_oid_pais = " + dto.getOidPais());
         if (dto.getOidNumDocumento() != null) {
            sql.append("    AND sc.OID_SOLI_CABE = ? "); // -- numero documento
            parametros.add(dto.getOidNumDocumento());
         } 
         if (dto.getCodigoVenta() != null) {
            sql.append("    AND od.val_codi_vent LIKE '"+dto.getCodigoVenta()+"' "); // -- COD VENTA
           
         } 
         sql.append("       AND ep.oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
         if (dto.getOidOperacion() != null) {
            sql.append("    AND ro.oid_oper = ? ");
            parametros.add(dto.getOidOperacion());
         }
         sql.append("  	 ORDER BY codigoventa) query ");
         sql.append("  	 ) WHERE ROWNUM <=  " + dto.getTamanioPagina());
         sql.append("  	   AND OID > " + dto.getIndicadorSituacion());
         
         
         
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        //String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);
        
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerProductosEnvia: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosEnvia(DTOBuscarEnvia):Salida");
        return rs;
    }
    
	public RecordSet obtenerReclamosGestion (DTOBuscarReclamosREC dto) throws MareException {
		UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerReclamosGestion (DTOBuscarReclamosREC):Entrada");
		
		StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
		sql.append(" SELECT DISTINCT cr.OID_CABE_RECL AS OID, cr.NUM_RECL NUMRECLAMO, ");
        sql.append(" mc.COD_CLIE CODCLIENTE, mc.VAL_NOM1 || ' ' || mc.VAL_APE1 || ' ' || mc.VAL_APE2 nombreApellidos, ");
        sql.append(" cr.FEC_DOCU_REFE FECHADOCUMENTO, sc2.VAL_NUME_SOLI NUMDOCREFERENCIA, ");
        sql.append(" pe.VAL_NOMB_PERI  as PERIODOREFERENCIA,  ");
        sql.append(" cr.NUM_TOTA_ENVI TOTALENVIA, cr.NUM_TOTA_DEVU TOTALDEVUELVE, ");
        sql.append(" cr.IMP_SALD_PAGA SALDOAPAGAR, cr.FEC_INGR FECHARECLAMO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append("  WHERE idio.ATTR_ENTI = 'REC_ESTAD_RECLA' AND idio.ATTR_NUM_ATRI=1 ");
        sql.append("  AND idio.IDIO_OID_IDIO = ? AND idio.VAL_OID = er.OID_ESTA_RECL) as ESTADOCABECERA, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio WHERE idio.ATTR_ENTI = 'REC_MOTIV_BLOQU' "); 
        sql.append(" AND idio.ATTR_NUM_ATRI=1 AND idio.IDIO_OID_IDIO = ? ");  
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = mb.OID_MOTI_BLOQ) as MOTIVOBLOQUEO "); 
        sql.append(" FROM REC_CABEC_RECLA cr, REC_OPERA_RECLA opre, MAE_CLIEN mc, REC_ESTAD_RECLA er, ");          
        sql.append(" CRA_PERIO pe, PED_SOLIC_CABEC sc1, PED_SOLIC_CABEC sc2, ");  
        sql.append(" REC_MOTIV_BLOQU mb, REC_OPERA op, REC_TIPOS_OPERA tiop, REC_TIPOS_BLOQU tb "); 
    
        sql.append("  WHERE cr.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append("  AND cr.pais_oid_pais = ? ");
        parametros.add(dto.getOidPais());
        if(dto.getCodCliente() != null){
            sql.append(" AND mc.COD_CLIE LIKE '" + dto.getCodCliente() + "' ");            
        }
        sql.append(" AND cr.perd_oid_peri_docu_refe = pe.oid_peri ");
        //sql.append(" AND pc.OID_PERI = cr.PERD_OID_PERI_DOCU_REFE ");
        /*if(dto.getNumAtencion() != null){
            sql.append(" AND cr.NUM_ATEN = ? ");
            parametros.add(dto.getNumAtencion());
        }*/ 
         //DBLG700000187 por mejora se busca por numero de reclamo  no por numero de atencion
        if(dto.getNumReclamo() != null){
            sql.append(" AND cr.NUM_RECL = ? ");
            parametros.add(dto.getNumReclamo());
        }
        
        sql.append("  AND sc2.OID_SOLI_CABE = cr.SOCA_OID_SOLI_CABE ");
        sql.append("  AND sc1.SOCA_OID_SOLI_CABE = sc2.OID_SOLI_CABE ");
        if(dto.getNumDocReferencia() != null){
            sql.append(" AND sc2.VAL_NUME_SOLI = ? ");
            parametros.add(dto.getNumDocReferencia());
        }
        sql.append(" AND tiop.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND opre.TIOP_OID_TIPO_OPER = tiop.OID_TIPO_OPER "); 
        sql.append(" AND cr.OID_CABE_RECL = opre.CARE_OID_CABE_RECL "); 
        if(dto.getOidsOperaciones()!= null){
            if(dto.getOidsOperaciones().size()>0) {
                sql.append(" AND op.OID_OPER IN (? ");
                parametros.add(dto.getOidsOperaciones().get(0));
                for(int i=1; i<dto.getOidsOperaciones().size(); i++) {
                    sql.append(", ? ");
                    parametros.add(dto.getOidsOperaciones().get(i));
                }
                sql.append(")");
            }
        }
        sql.append(" AND opre.tibl_oid_tipo_bloq = tb.oid_tipo_bloq (+)");
        sql.append(" AND cr.esre_oid_esta_recl = er.oid_esta_recl ");
        sql.append(" AND cr.mobl_oid_moti_bloq = mb.oid_moti_bloq (+)");
        if(dto.getOidsTiposBloqueo()!= null){
            if(dto.getOidsTiposBloqueo().size()>0) {
                sql.append(" AND tb.OID_TIPO_BLOQ IN ( ? ");
                parametros.add(dto.getOidsTiposBloqueo().get(0));
                for(int i=1; i<dto.getOidsTiposBloqueo().size(); i++) {
                    sql.append(", ? ");
                    parametros.add(dto.getOidsTiposBloqueo().get(i));
                }
                sql.append(")");
            } 
        }
          
        if(dto.getOidPerDesdeRef()!=null){
            sql.append(" AND pe.FEC_INIC >= (SELECT p1.FEC_INIC ");
            sql.append(" FROM CRA_PERIO p1 WHERE p1.OID_PERI = ?) ");
            parametros.add(dto.getOidPerDesdeRef());
        }
        if(dto.getOidPerHastaRef()!=null){
            sql.append(" AND pe.FEC_FINA <= (SELECT p2.FEC_FINA ");
            sql.append(" FROM CRA_PERIO p2 WHERE p2.OID_PERI = ?) ");
            parametros.add(dto.getOidPerHastaRef());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		               
        if(dto.getFechaReclamoDesde()!=null){
            java.sql.Date fechaDesde = new java.sql.Date(dto.getFechaReclamoDesde().getTime());
            String sFechaDesde = sdf.format(fechaDesde);
            sql.append(" AND pe.FEC_INIC > TO_DATE(?, 'yyyy-MM-dd') ");
            parametros.add(sFechaDesde);
           
        }
        if(dto.getFechaReclamoHasta()!=null){
            java.sql.Date fechaHasta = new java.sql.Date(dto.getFechaReclamoHasta().getTime());
            String sFechaHasta = sdf.format(fechaHasta);
            sql.append(" AND pe.FEC_FINA < TO_DATE(?, 'yyyy-MM-dd') ");
            parametros.add(sFechaHasta);
        }
        if (dto.getMostrarSoloRechazadas()!=null){
            if(dto.getMostrarSoloRechazadas().booleanValue()){
                sql.append(" AND (cr.ESRE_OID_ESTA_RECL = ? OR ");
                sql.append(" opre.ESOP_OID_ESTA_OPER = ? )");
                parametros.add(ConstantesREC.ESTADO_RECLAMO_RECHAZADO);
                parametros.add(ConstantesREC.ESTADO_OPERACION_RECHAZADO);
            } else {
                sql.append(" AND (cr.ESRE_OID_ESTA_RECL = ? OR ");
                sql.append(" opre.ESOP_OID_ESTA_OPER = ? OR ");
                sql.append(" cr.ESRE_OID_ESTA_RECL = ? OR ");
                sql.append(" opre.ESOP_OID_ESTA_OPER = ? )");
                parametros.add(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO);
                parametros.add(ConstantesREC.ESTADO_OPERACION_BLOQUEO);
                parametros.add(ConstantesREC.ESTADO_RECLAMO_PARCIAL);
                parametros.add(ConstantesREC.ESTADO_OPERACION_PARCIAL);
            }
        }
        if (dto.getReclamosDigitados()!= null){
            if(dto.getReclamosDigitados().booleanValue()) {
                sql.append(" AND cr.TIIN_OID_TIPO_INGR = ? ");
                parametros.add(ConstantesREC.TIPO_INGRESO_DIGITACION);
            }
        }
        if (dto.getReclamosEnLinea()!= null){
            if(dto.getReclamosEnLinea().booleanValue()) {
                sql.append(" AND cr.TIIN_OID_TIPO_INGR = ? ");
                parametros.add(ConstantesREC.TIPO_INGRESO_LINEA);
            }
        }               
		RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerReclamosGestion: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
		
		UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerReclamosGestion (DTOBuscarReclamosREC):Salida");
		return rs;
	}
	
    private void logSql(String metodo, String sql, Vector params) {            
         UtilidadesLog.info(metodo + sql);                                      
                                                                                
         if ((params != null) && (params.size() > 0)) {                         
             String sParams = "";                                               
                                                                                
             for (int i = 0; i < params.size(); i++) {                          
                 sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +  
                 ", ");                                                         
             }                                                                  
                                                                                
             UtilidadesLog.info(metodo + sParams);                              
         }
    }
    
    private String formateaFecha(Date fecha){
        UtilidadesLog.info("DAOCapturaProcesoReclamos.formateaFecha(Date):Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
        UtilidadesLog.info("DAOCapturaProcesoReclamos.formateaFecha(Date):Salida");
        return sdf.format(fechaDesde); 
    }
    
  /**
   * @author Emilio Noziglia
   * @since 14/10/2005
   * @param DTOOID numAtencion
   * @return RecordSet 
   * @throws MareException
   * @reference UBEL004, BELC300013912, BELC300014262, BELC300018563, BELC300018986
   */  
    public RecordSet obtenerLineasReclamo(DTOOID numAtencion) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasReclamo(DTOOID):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        /*sql.append(" SELECT ");
        sql.append(" LO.OPRE_OID_OPER_RECL AS OIDOPERACION , ");
        sql.append(" LO.OID_LINE_OPER_RECL AS LINEAOPERACION, ");
        sql.append(" LO.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO , ");
        sql.append(" OP.TSPA_OID_SOLI_CON_STOC AS TIPOSOLICITUD1 , ");
        sql.append(" OP.TSPA_OID_SOLI_SIN_STOC AS TIPOSOLICITUD2 , ");
        sql.append(" ST.VAL_SALD AS SALDO, ");
        sql.append(" LO.NUM_UNID_RECL AS URECLAMADAS , ");
        sql.append(" LO.NUM_UNID_DEVU AS UDEVUELTAS , ");
        sql.append(" OP.IND_ESPE_MERC_FISI AS ESPERA ");
        sql.append(" FROM ");
        sql.append(" REC_CABEC_RECLA CR, ");
        sql.append(" REC_OPERA_RECLA ROR, ");
        sql.append(" REC_LINEA_OPERA_RECLA LO, ");
        sql.append(" REC_TIPOS_OPERA RTO, ");
        sql.append(" REC_OPERA OP, ");
        sql.append(" MAE_PRODU MP, ");
        sql.append(" BEL_STOCK ST, ");
        sql.append(" BEL_ESTAD_MERCA EM ");
        sql.append(" WHERE ");
        sql.append(" CR.NUM_ATEN = ? ");
        parametros.add(numAtencion.getOid());
        //INCIDENCIA BELC300014262
        sql.append(" AND CR.PAIS_OID_PAIS = ? ");
        parametros.add(numAtencion.getOidPais());
        sql.append(" AND (CR.ESRE_OID_ESTA_RECL = ? ");
        //paramtro  ConstantesREC.ESTADO_RECLAMO_INGRESADO
        parametros.add(ConstantesREC.ESTADO_RECLAMO_INGRESADO);
        sql.append(" OR CR.ESRE_OID_ESTA_RECL = ? ) ");
        //parametro ConstantesREC.ESTADO_RECLAMO_DIGITADO 
        parametros.add(ConstantesREC.ESTADO_RECLAMO_DIGITADO);
        sql.append(" AND ROR.ESOP_OID_ESTA_OPER = ? ");
        //Parametro ConstantesREC.ESTADO_OPERACION_INGRESADO
        parametros.add(ConstantesREC.ESTADO_OPERACION_INGRESADO);
        sql.append(" AND LO.IND_ESTA  <> ? ");
        //Parametro ConstantesREC.ESTADO_LINEA_ENVIADO 
        parametros.add(ConstantesREC.ESTADO_LINEA_ENVIADO.toString());
        sql.append(" AND CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL ");
        sql.append(" AND LO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
        sql.append(" AND ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
        sql.append(" AND RTO.ROPE_OID_OPER = OP.OID_OPER ");
        sql.append(" AND MP.OID_PROD = LO.PROD_OID_PROD ");
        sql.append(" AND MP.OID_PROD = ST.PROD_OID_PROD ");
        sql.append(" AND ST.ESME_OID_ESTA_MERC = EM.OID_ESTA_MERC ");
        sql.append(" AND EM.COD_ESTA = ? ");
        parametros.add("LD");
        sql.append(" ORDER BY OIDOPERACION, LINEAOPERACION ");*/
        sql.append(" SELECT xxx.*,DECODE(ST.VAL_SALD,NULL,0,ST.VAL_SALD) AS SALDO FROM ");
		sql.append("  (SELECT ");
		sql.append("   LO.OPRE_OID_OPER_RECL AS OIDOPERACION , ");
		sql.append("   LO.OID_LINE_OPER_RECL AS LINEAOPERACION, ");
		sql.append("   LO.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO , ");
		sql.append("   OP.TSPA_OID_SOLI_CON_STOC AS TIPOSOLICITUD1 , ");
		sql.append("   OP.TSPA_OID_SOLI_SIN_STOC AS TIPOSOLICITUD2 , ");
		sql.append("   LO.NUM_UNID_RECL AS URECLAMADAS , ");
		sql.append("   LO.NUM_UNID_DEVU AS UDEVUELTAS,  ");
		sql.append("   OP.IND_ESPE_MERC_FISI AS ESPERA, ");
		sql.append("   LO.PROD_OID_PROD OID_PROD, ");
		sql.append("   OP.ALMC_OID_ALMA ALMC_OP, ");
        sql.append("   OP.TSPA_OID_SOLI_PAIS_GENE TIPOSOLICITUDGENERA, "); // BELC300018986
        sql.append(" lo.val_prec precioUnitario, ");
        sql.append(" op.ind_devu_fisi_fact devueltoFisico, ");
    /*
    - recojo = op.IND_RECO
    - tipoSolicitudRecojoInicial = op.TSPA_OID_TIPO_SOLI_REC_INIC
    - tipoSolicitudPrimerRecojoNoExitoso = op.TSPA_OID_TIPO_SOLI_PRI_NO_EXIT
    - tipoSolicitudSegundoRecojoNoExitoso = op.TSPA_OID_SOLI_PAIS_SEG_NO_EXIT 
     */
     
		sql.append("   op.IND_RECO, ");
		sql.append("   op.TSPA_OID_TIPO_SOLI_REC_INIC, ");
		sql.append("   op.TSPA_OID_TIPO_SOLI_PRI_NO_EXIT, ");
		sql.append("   op.TSPA_OID_SOLI_PAIS_SEG_NO_EXIT, ");
                sql.append("   (SELECT COUNT(PNR.OID_PROD_NO_RECO) ");
                sql.append("   FROM REC_PRODU_NO_RECOG PNR, PRE_OFERT_DETAL POD ");
                sql.append("   WHERE PNR.OFDE_OID_DETA_OFER = POD.OID_DETA_OFER ");
                sql.append("   AND POD.PROD_OID_PROD = LO.PROD_OID_PROD ");
                sql.append("   AND PNR.PAIS_OID_PAIS = "+numAtencion.getOidPais()+" ");
                sql.append("   AND PNR.PERD_OID_PERI = ROR.PERD_OID_PERI_RECL) AS RECO ");                
		sql.append("   FROM ");
		sql.append("   REC_CABEC_RECLA CR, ");
		sql.append("   REC_OPERA_RECLA ROR, ");
		sql.append("   REC_LINEA_OPERA_RECLA LO, ");
		sql.append("   REC_TIPOS_OPERA RTO, ");
		sql.append("   REC_OPERA OP, ");
		sql.append("   MAE_PRODU MP ");
	
		sql.append("   WHERE ");
		sql.append("   CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL ");
		sql.append("   AND LO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
		sql.append("   AND ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
		sql.append("   AND RTO.ROPE_OID_OPER = OP.OID_OPER ");
		sql.append("   AND MP.OID_PROD(+) = LO.PROD_OID_PROD ");
        
		sql.append("   AND (ROR.ESOP_OID_ESTA_OPER = ? OR ROR.ESOP_OID_ESTA_OPER = ? OR ROR.ESOP_OID_ESTA_OPER = ?) ");
        parametros.add(ConstantesREC.ESTADO_OPERACION_INGRESADO);
        parametros.add(ConstantesREC.ESTADO_OPERACION_DIGITADO);                 //AGREGADO INC. 22749
        parametros.add(ConstantesREC.ESTADO_OPERACION_PARCIAL);                 //AGREGADO INC. 22749
        
		sql.append("   AND (CR.ESRE_OID_ESTA_RECL = ? OR CR.ESRE_OID_ESTA_RECL = ? OR CR.ESRE_OID_ESTA_RECL = ?) ");
        parametros.add(ConstantesREC.ESTADO_RECLAMO_DIGITADO);
        parametros.add(ConstantesREC.ESTADO_RECLAMO_INGRESADO);
        parametros.add(ConstantesREC.ESTADO_RECLAMO_PARCIAL);                   //AGREGADO INC. 22749
        
		
    
    sql.append(" AND cr.NUM_ATEN = ? ");
    parametros.add(numAtencion.getOid());
		
    
    
    sql.append("   AND CR.PAIS_OID_PAIS = ? ");
        parametros.add(numAtencion.getOidPais());
        
		sql.append("   AND (LO.IND_ESTA  <> ? or LO.IND_ESTA is null) ");
        parametros.add(ConstantesREC.ESTADO_LINEA_ENVIADO.toString());
        
		sql.append("   ORDER BY OIDOPERACION, LINEAOPERACION) xxx, ");
		sql.append("   BEL_STOCK ST, ");
		sql.append("   BEL_ESTAD_MERCA EM ");
		sql.append("   WHERE ");
		sql.append("   ST.ESME_OID_ESTA_MERC = EM.OID_ESTA_MERC (+) ");
		sql.append("   AND XXX.OID_PROD = ST.PROD_OID_PROD (+)  ");
		sql.append("   AND XXX.ALMC_OP =ST.ALMC_OID_ALMA (+) ");

		sql.append("   AND DECODE(TIPOMOVIMIENTO, ?, NVL(COD_ESTA, 'LD'), '1') = DECODE (TIPOMOVIMIENTO, ?, ?, '1') ");
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_ENVIA.toString());
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_ENVIA.toString());
        parametros.add(ConstantesBEL.COD_EST_LIBRE_DISP);
        
        UtilidadesLog.debug("sql: " + sql);
        System.out.println("Parametros: " + parametros);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        System.out.println("RecordSet obtenido: " + rs);
        UtilidadesLog.debug("RecordSet obtenido: " + rs);
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasReclamo(DTOOID):Salida");
        
        return rs;
    }

    public RecordSet obtenerGeneraOperacion(DTOOID dto) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerGeneraOperacion(DTOOID):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT IND_DEVU_GENE_ENVI AS DEVUELVEGENERAENVIA, ");
        sql.append(" IND_ENVI_GENE_DEVU AS ENVIAGENERADEVUELVE ");
        sql.append(" FROM REC_OPERA ");
        sql.append(" WHERE OID_OPER = ? ");
        parametros.add(dto.getOid());
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerOperacionesReclamo: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerGeneraOperacion(DTOOID):Salida");
        return rs;
    }
    //falta cambiar
    public RecordSet obtenerOperacionesLineaReclamo(DTOOID dto) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperacionesLineaReclamo(DTOOID):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT DISTINCT ");
        sql.append(" LO.OPRE_OID_OPER_RECL AS OIDOPERACION, ");
        sql.append(" LO.OID_LINE_OPER_RECL AS OIDLINEA, ");
        sql.append(" LO.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO, ");
        sql.append(" RTO.VAL_INFO_EBEL_NOTI AS EBELNOTICIAS, ");
        sql.append(" CR.TIIN_OID_TIPO_INGR  AS TIPOINGRESO, ");
        sql.append(" CR.CLIE_OID_CLIE AS CODIGOCLIENTE, ");
        sql.append(" MC.VAL_NOM1 AS NOMBRE, ");
        sql.append(" MC.VAL_APE1 AS APELLIDO, ");
        sql.append(" SC2.VAL_NUME_SOLI AS NUMSOLICITUD, ");
        sql.append(" SC1.VAL_NUME_SOLI AS NUMDOCUREFERENCIA, ");
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( ? , pc1.oid_peri,'SEG_PERIO_CORPO') AS PERIDOREFERENCIA, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( ? ,pc2.oid_peri,'SEG_PERIO_CORPO') AS PERIODORECLAMO, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" CR.NUM_RECL AS NUMERORECLAMO , ");
        sql.append(" OP.COD_OPER AS CODOPERACION,");
		sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( ? ,op.oid_oper,'REC_OPERA') AS NOMBREOPERACION, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" OD.VAL_CODI_VENT AS CODVENTA, ");
        //sql.append(" LO.VAL_PREC AS PRECIO, "); 1059
        sql.append(" pos.VAL_PREC_FACT_UNIT_LOCA AS precio, ");
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( ? ,mp.oid_prod,'MAE_PRODU') AS DESCPRODUCTO, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" LO.NUM_UNID_RECL AS URECLAMADAS, ");
        //sql.append(" sc1.num_unid_aten_tota AS uatendidas, ");
        sql.append(" SC2.NUM_UNID_ATEN_TOTA AS UATENDIDAS, ");// comentado por REC-19 
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( ? ,rd.oid_moti_rech_desb,'REC_MOTIV_RECHA_DESBL') AS MOTIVORECHAZODESBLOQUEO, ");
        parametros.add(dto.getOidIdioma());
		sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc( ? ,eo.oid_esta_oper,'REC_ESTAD_OPERA') AS ESTADOOPERACION, ");
        parametros.add(dto.getOidIdioma());
        sql.append(" OP.TSPA_OID_SOLI_SIN_STOC AS TIPOSOLICITUD2, ");
        sql.append(" MM.COD_MENS AS CODIGOTS2 ");
        sql.append(" FROM REC_CABEC_RECLA CR, ");
        sql.append(" REC_OPERA_RECLA ROR, ");
        sql.append(" REC_LINEA_OPERA_RECLA LO, ");
        sql.append(" REC_OPERA OP, ");
        sql.append(" REC_TIPOS_OPERA RTO, ");
        sql.append(" MAE_CLIEN MC, ");
        sql.append(" PED_SOLIC_CABEC SC1, ");
        sql.append(" PED_SOLIC_CABEC SC2, ");
        sql.append(" SEG_PERIO_CORPO PC2, ");
        sql.append(" SEG_PERIO_CORPO PC1, ");
        sql.append(" CRA_PERIO CP2, ");
        sql.append(" CRA_PERIO CP1, ");
        sql.append(" PRE_MATRI_FACTU MF, ");
        sql.append(" PRE_OFERT_DETAL OD, ");
        sql.append(" MAE_PRODU MP, ");
        sql.append(" REC_MOTIV_RECHA_DESBL RD, ");
        sql.append(" REC_ESTAD_OPERA EO, ");
        sql.append(" BEL_STOCK ST, ");
        sql.append(" BEL_ESTAD_MERCA EM, ");
        sql.append(" MSG_MENSA MM, ");
        sql.append(" rec_solic_opera solop, ");
		sql.append(" ped_solic_posic pos  ");
        sql.append(" WHERE ");
        sql.append(" CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL ");
        sql.append(" AND ROR.OID_OPER_RECL = LO.OPRE_OID_OPER_RECL ");
        sql.append(" AND ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
        sql.append(" AND RTO.ROPE_OID_OPER = OP.OID_OPER ");
        sql.append(" AND CR.CLIE_OID_CLIE = MC.OID_CLIE ");
        sql.append(" AND cr.SOCA_OID_SOLI_CABE = sc1.OID_SOLI_CABE");
        
        //BELC300014236
        //sql.append(" AND sc1.SOCA_OID_DOCU_REFE = sc2.OID_SOLI_CABE "); //se comenta por REC-19
        //sql.append(" AND sc1.soca_oid_soli_cabe = sc2.OID_SOLI_CABE ");
        
        sql.append(" AND solop.soca_oid_soli_cabe = sc2.oid_soli_cabe ");
        
        sql.append(" AND CP1.PERI_OID_PERI = PC1.OID_PERI ");
        sql.append(" AND CP2.PERI_OID_PERI = PC2.OID_PERI ");
        sql.append(" AND CP1.OID_PERI = CR.PERD_OID_PERI_RECL ");
        sql.append(" AND CP2.OID_PERI = CR.PERD_OID_PERI_DOCU_REFE ");
        sql.append(" AND RTO.ROPE_OID_OPER = OP.OID_OPER ");
        sql.append(" AND LO.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT(+) ");//OUTEJOIN POR REC-19
        sql.append(" AND MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER(+) ");//OUTEJOIN POR REC-19
        sql.append(" AND LO.PROD_OID_PROD = MP.OID_PROD ");
        sql.append(" AND LO.MRDB_OID_MOTI_RECH_DESB = RD.OID_MOTI_RECH_DESB(+) ");//OUTEJOIN POR REC-19
        sql.append(" AND ROR.ESOP_OID_ESTA_OPER = EO.OID_ESTA_OPER ");
        sql.append(" AND ST.PROD_OID_PROD = MP.OID_PROD ");
        sql.append(" AND EM.COD_ESTA = ? ");
        parametros.add("LD");
        sql.append(" AND ST.ESME_OID_ESTA_MERC = EM.OID_ESTA_MERC ");
        sql.append(" AND OP.MENS_OID_MENS = MM.OID_MENS ");
        sql.append(" AND solop.opre_oid_oper_recl = ror.oid_oper_recl  ");
        //sql.append(" AND solop.soca_oid_soli_cabe = pos.soca_oid_soli_cabe(+) ");
        sql.append(" AND sc2.oid_soli_cabe = pos.soca_oid_soli_cabe ");
        sql.append(" AND cr.NUM_ATEN = ? ");
        parametros.add(dto.getOid());
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerOperacionesLineaReclamo(DTOOID):Salida");
        return rs;
    }

    public DTOSalida obtenerParametrosMensaje(DTOOID oidOperacion, Long oidLinea) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerParametrosMensaje(DTOOID, Long):Salida");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ");
        sql.append(" MC.OID_CLIE  AS OIDCLIENTE, ");
        sql.append(" MC.COD_CLIE AS CODCLIENTE, ");
        sql.append(" MC.VAL_NOM1 AS NOMBRECLIENTE, ");
        sql.append(" MC.VAL_APE1 AS APELLIDOCLIENTE, ");
        sql.append(" SC2.VAL_NUME_SOLI AS NUMDOCREFERENCIA, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'SEG_PERIO_CORP' ");
        sql.append(" AND I.ATTR_NUM_ATRI = ? ");
        parametros.add(new Long(1));
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        //filtrar por idioma
        parametros.add(oidOperacion.getOidIdioma());
        sql.append(" AND PC1.OID_PERI = I.VAL_OID )AS PERIODOREFERENCIA, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'SEG_PERIO_CORPO' ");
        sql.append(" AND I.ATTR_NUM_ATRI = ? ");
        parametros.add(new Long(1));
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        //filtrar por oid idioma
        parametros.add(oidOperacion.getOidIdioma());
        sql.append(" AND PC2.OID_PERI = I.VAL_OID )AS PERIODORECLAMO, ");
        sql.append(" CR.NUM_RECL AS NUMRECLAMO, ");
        sql.append(" OP.COD_OPER AS OPERACION, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_OPERA' ");
        sql.append(" AND I.ATTR_NUM_ATRI = ? ");
        parametros.add(new Long(1));
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        //Falta filtrar por idioma
        parametros.add(oidOperacion.getOidIdioma());
        sql.append(" AND OP.OID_OPER = I.VAL_OID )AS NOMBREOPERACION, ");
        sql.append(" OD.VAL_CODI_VENT AS CODVENTA, ");
        sql.append(" MP.DES_CORT AS DESCPRODUCTO, ");
        sql.append(" LO.NUM_UNID_RECL AS URECLAMADAS, ");
        sql.append(" LO.NUM_UNID_DEVU AS UATENDIDAS, ");
        sql.append(" (SELECT I.VAL_I18N ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL' ");
        sql.append(" AND I.ATTR_NUM_ATRI = ? ");
        parametros.add(new Long(1));
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        //Falta filtrar por idioma
        parametros.add(oidOperacion.getOidIdioma());
        sql.append(" AND MD.OID_MOTI_RECH_DESB = I.VAL_OID )AS MOTIVORECHAZO ");
        sql.append(" FROM ");
        sql.append(" REC_CABEC_RECLA CR, ");
        sql.append(" REC_OPERA_RECLA ROR, ");
        sql.append(" MAE_CLIEN MC, ");
        sql.append(" CRA_PERIO PE1, ");
        sql.append(" CRA_PERIO PE2, ");
        sql.append(" SEG_PERIO_CORPO PC1, ");
        sql.append(" SEG_PERIO_CORPO PC2, ");
        sql.append(" PED_SOLIC_CABEC SC1, ");
        sql.append(" PED_SOLIC_CABEC SC2, ");
        sql.append(" REC_MOTIV_RECHA_DESBL MD, ");
        sql.append(" REC_OPERA OP, ");
        sql.append(" REC_TIPOS_OPERA RTO, ");
        sql.append(" REC_LINEA_OPERA_RECLA LO, ");
        sql.append(" PRE_MATRI_FACTU MF, ");
        sql.append(" PRE_OFERT_DETAL OD, ");
        sql.append(" MAE_PRODU MP ");
        sql.append(" WHERE ");
        sql.append(" CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL ");
        sql.append(" AND ROR.OID_OPER_RECL = LO.OPRE_OID_OPER_RECL ");
        sql.append(" AND MC.OID_CLIE = CR.CLIE_OID_CLIE ");
        sql.append(" AND CR.PERD_OID_PERI_DOCU_REFE = PE1.OID_PERI ");
        sql.append(" AND CR.PERD_OID_PERI_RECL = PE2.OID_PERI ");
        sql.append(" AND PE1.PERI_OID_PERI = PC1.OID_PERI ");
        sql.append(" AND PE2.PERI_OID_PERI = PC2.OID_PERI ");
        sql.append(" AND CR.SOCA_OID_SOLI_CABE = SC1.OID_SOLI_CABE ");
        //sql.append(" AND CR.SOCA_OID_SOLI_CABE = SC2.OID_SOLI_CABE ");
        sql.append(" AND SC2.SOCA_OID_SOLI_CABE = SC1.OID_SOLI_CABE ");
        sql.append(" AND ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
        sql.append(" AND RTO.ROPE_OID_OPER = OP.OID_OPER ");
        sql.append(" AND LO.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT (+) ");
        sql.append(" AND MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+) ");
        sql.append(" AND OD.PROD_OID_PROD = MP.OID_PROD ");
        //sql.append(" AND ROR.PROD_OID_PROD = MP.OID_PROD ");
        //Incidencia 14310
        sql.append(" AND ROR.MRDB_OID_MOTI_RECH_DESB = MD.OID_MOTI_RECH_DESB (+) ");
        sql.append(" AND ROR.OID_OPER_RECL = ? ");
        parametros.add(oidOperacion.getOid());
        sql.append(" AND LO.OID_LINE_OPER_RECL = ? ");
        parametros.add(oidLinea);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        DTOSalida dtoSalida = new DTOSalida(rs);
          
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerParametrosMensaje(DTOOID, Long):Salida");
        return dtoSalida;
    }

    public boolean obtenerEbelNoticias(DTOOID dto) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerEbelNoticias(DTOOID):Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT  ");
        sql.append(" RTO.VAL_INFO_EBEL_NOTI ");
        sql.append(" FROM ");
        sql.append(" REC_OPERA_RECLA ROR, ");
        sql.append(" REC_TIPOS_OPERA RTO ");
        sql.append(" WHERE ");
        sql.append(" ROR.TIOP_OID_TIPO_OPER = RTO.OID_TIPO_OPER ");
        sql.append(" AND ROR.OID_OPER_RECL = ?");
        parametros.add(dto.getOid());
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
      if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerLineasOperacion: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }        

        // como el valor que se recupera de BBDD no es obligatorio, si viene vacio se 
        // devuelve false
        Boolean eBelNoticias = new Boolean(false); 
        
        if (rs.getValueAt(0,0) != null) {
            eBelNoticias = new Boolean(((BigDecimal)rs.getValueAt(0,0)).intValue() == 1 ? true : false);
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerEbelNoticias(DTOOID):Salida");
        return eBelNoticias.booleanValue();
    }

    // incidencia BELC300014440
    public RecordSet obtenerLineasOperacion(DTOOIDPaginado dto) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasOperacion(DTOOIDPaginado):Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ");
        sql.append(" LO.OID_LINE_OPER_RECL AS OID, ");
        sql.append(" (SELECT I.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC I ");
        sql.append(" WHERE I.ATTR_ENTI = 'REC_TIPO_MOVIM' ");
        sql.append(" AND I.ATTR_NUM_ATRI = ? ");
        parametros.add(new Long(1));
        sql.append(" AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND TM.OID_TIPO_MOVI = I.VAL_OID )AS TIPOMOVIMIENTO, ");
        sql.append(" OD.VAL_CODI_VENT AS CODVENTA, ");
        sql.append("  PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , MP.OID_PROD, 'MAE_PRODU') DESCPRODUCTO, ");        
        parametros.add(dto.getOidIdioma());
        
        sql.append(" LO.NUM_UNID_RECL  AS URECLAMADAS, ");
        sql.append(" LO.NUM_UNID_DEVU AS UDEVUELTAS, ");
        sql.append(" LO.VAL_PREC AS PRECIO, ");
        sql.append(" LO.IMP_CARG AS IMPORTECARGO, ");
        sql.append(" LO.IMP_ABON AS IMPORTEABONO ");
        sql.append(" FROM ");
        sql.append(" REC_LINEA_OPERA_RECLA LO, ");
        sql.append(" REC_TIPO_MOVIM TM, ");
        sql.append(" PRE_MATRI_FACTU MF, ");
        sql.append(" PRE_OFERT_DETAL OD, ");
        sql.append(" MAE_PRODU MP, ");
        sql.append(" PED_TIPO_SOLIC_PAIS PS "); // para obtener el pais
        sql.append(" WHERE ");
        sql.append(" LO.OPRE_OID_OPER_RECL = ?");
        parametros.add(dto.getOid());
        sql.append(" AND LO.TIMO_OID_TIPO_MOVI = TM.OID_TIPO_MOVI ");
        sql.append(" AND LO.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT (+) ");
        sql.append(" AND MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+) ");
        sql.append(" AND LO.PROD_OID_PROD = MP.OID_PROD (+)");
        sql.append(" AND LO.TSPA_OID_TIPO_SOLI_PAIS = PS.OID_TIPO_SOLI_PAIS (+)");
        sql.append(" ORDER BY LO.NUM_LINE");
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
      if (rs.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerLineasOperacion: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }        
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasOperacion(DTOOIDPaginado):Salida");
        return rs;
    }
    

    // se crea por incidencia BELC300014385
    public RecordSet obtenerDatosSolicitud(Long solicitud) throws MareException
    {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosSolicitud(Long):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append("SELECT ");
        sql.append("sc.PAIS_OID_PAIS AS PAIS, ");
        sql.append("pe.MARC_OID_MARC AS MARCA, ");
        sql.append("pe.CANA_OID_CANA AS CANAL ");
        sql.append("FROM ");
        sql.append("PED_SOLIC_CABEC sc, ");
        sql.append("CRA_PERIO pe ");
        sql.append("WHERE ");
        sql.append("sc.PERD_OID_PERI = pe.OID_PERI ");
        sql.append("AND sc.OID_SOLI_CABE = ?");
        parametros.add(solicitud);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
         if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerDatosSolicitud: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         }        
              
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDatosSolicitud(Long):Salida");
        return rs;
    }
    
    public RecordSet obtenerAutorizacion(Long pais, String usuario, Long tipoOperacion) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerAutorizacion(Long , String , Long):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT au.IMP_MAXI AS IMPORTEMAXIMO, ");
        sql.append(" au.IMP_MONT_MAXI_DIFE AS MONTOMAXIMODIFERENCIA ");
        sql.append(" FROM REC_AUTOR AU, USERS U,PRINCIPALS P ");
        sql.append(" WHERE au.IND_INGR=1 AND au.USER_OID_USER=U.IDUSER AND U.IDUSER=P.IDPRINCIPAL ");
        sql.append(" AND au.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        sql.append(" AND p.NAME = ? ");
        parametros.add(usuario);
        sql.append(" AND au.TIOP_OID_TIPO_OPER  = ? ");
        parametros.add(tipoOperacion);
        sql.append(" AND au.IND_DESB = 1 ");
        
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();

        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerAutorizacion(Long , String , Long):Salida");
        return rs;
    }
    
    private RecordSet obtenerDatosProductosCodigoVentaSi(DTOBuscarProductosDevuelveNoREC dto, String codigo) throws MareException {
        StringBuffer query = new StringBuffer();
        
        if (codigo.equals("I")) {
           query = (StringBuffer)this.armarQueryProdCodigoI(dto);
        } else {
           query = (StringBuffer)this.armarQueryProdCodigoP(dto); 
        }
        
        RecordSet rs = null;
        
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
        rs = this.executeQuery(sqlPaginada.toString());        
        return rs;

    }
    
    private StringBuffer armarQueryProdCodigoI (DTOBuscarProductosDevuelveNoREC dto) {
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT ROWNUM OID, TABLA.* ");
        query.append(" FROM ( ");
        query.append("    SELECT PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", MP.OID_PROD, 'MAE_PRODU') AS DESCRIPCION, ");
        query.append("           CP.VAL_NOMB_PERI AS PERIODO, ");
        query.append("           '' DESCRIPCIONTIPOOFERTA,  ");
        query.append("           '' OIDTIPOOFERTA,  ");
        query.append("           '' UNIDADADESATENDIDAS, ");
		    query.append("           '' UNIDADESYARECLAMADAS, ");
        query.append("           AL.COD_VENT_FICT CODIGOVENTA,  ");
        query.append("           '' OIDCODIGOVENTA, ");
        query.append("           '0' PRECIOUNITARIO, ");
        query.append("           NVL(AL.IMP_PREC_PUBL,0) PRECIOCONTABLE, ");
        query.append("           CPG.NUM_CONC NUMEROCONCURSO,  ");
        query.append("           PN.NUM_NIVE NUMERONIVEL,  ");
        query.append("           LA.NUM_PREM NUMPREMIO, ");
        query.append("           MP.COD_SAP AS CODIGOPRODUCTO, ");
        query.append("           MP.OID_PROD AS OIDPRODUCTO, ");
		    query.append("           '' OID_SOLI_POSI,  ");
        query.append("           CPG.OID_PARA_GRAL OIDCONCURSO, ");
        query.append("           PN.OID_PARA_NIVE_PREM OIDNIVEL, ");
        query.append("           LA.OID_LOTE_PREM_ARTI OIDPREMIO ");
        query.append("   FROM CRA_PERIO CP, ");
        query.append("        PED_SOLIC_CABEC SC,   ");      
        query.append("        MAE_PRODU MP, ");
        query.append("        INC_ARTIC_LOTE AL,"); 
        query.append("        INC_LOTE_PREMI_ARTIC LA, ");
        query.append("        INC_PREMI_ARTIC PA, ");
        query.append("        INC_PARAM_NIVEL_PREMI PN, ");
        query.append("        INC_PARAM_GENER_PREMI PG, ");
        query.append("        INC_CONCU_PARAM_GENER CPG ");
        query.append("   WHERE SC.PERD_OID_PERI = CP.OID_PERI ");
        query.append("     AND AL.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
        query.append("     AND AL.PROD_OID_PROD = MP.OID_PROD ");
        query.append("     AND LA.PRAR_OID_PREM_ARTI = PA.OID_PREM_ARTI ");
        query.append("     AND PA.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
        query.append("     AND PN.PAGP_OID_PARA_GENE_PREM = PG.OID_PARA_GENE_PREM ");
        query.append("     AND PG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        if (dto.getCodigoVenta() != null){
            query.append("     AND AL.COD_VENT_FICT LIKE '" + dto.getCodigoVenta() + "'");
        }
       // query.append("     AND CPG.OID_PARA_GRAL = SC.COPA_OID_PARA_GENE(+)             ");
        query.append("     AND SC.OID_SOLI_CABE = " + dto.getNumDocumento());
        query.append(") TABLA ");

        
        return query;
    }
    
    private StringBuffer armarQueryProdCodigoP (DTOBuscarProductosDevuelveNoREC dto) {
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT ROWNUM OID, TABLA.* ");
        query.append(" FROM (					");
        query.append("   SELECT PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", MP.OID_PROD, 'MAE_PRODU') AS DESCRIPCION, ");
        query.append("          CP.VAL_NOMB_PERI AS PERIODO, ");
     		query.append("          PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", OD.TOFE_OID_TIPO_OFER, 'PRE_TIPO_OFERT') DESCRIPCIONTIPOOFERTA, ");
	    	query.append("          OD.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
        query.append("          0 AS UNIDADADESATENDIDAS, ");
        query.append("          0 AS UNIDADESYARECLAMADAS, ");
        query.append("          OD.VAL_CODI_VENT CODIGOVENTA, ");
        query.append("          MF.OID_MATR_FACT OIDCODIGOVENTA, ");
        
        if (dto.getDevuelveFisicoFactura() != null && !dto.getDevuelveFisicoFactura().booleanValue()){
            query.append("      0 PRECIOUNITARIO, ");
        } else { 
            query.append("      NVL (OD.PRECIO_UNITARIO, 0) PRECIOUNITARIO, ");
        }
        query.append("          CASE WHEN OD.IMP_PREC_CATA <> 0 THEN "); 
        query.append("              0 ");
        query.append("          ELSE "); 
        query.append("              OD.IMP_PREC_POSI ");
        query.append("          END AS PRECIOCONTABLE, ");

        query.append("          '' NUMEROCONCURSO, ");
    		query.append("          '' NUMERONIVEL, ");
        query.append("          '' NUMPREMIO, ");
        query.append("          MP.COD_SAP AS CODIGOPRODUCTO, ");
        query.append("          MP.OID_PROD AS OIDPRODUCTO, ");
        query.append("          '' OID_SOLI_POSI,  ");
        query.append("          '' OIDCONCURSO, ");
        query.append("          '' OIDNIVEL,  ");
        query.append("          '' OIDPREMIO ");
        query.append("  FROM CRA_PERIO CP, ");
        query.append("       PED_SOLIC_CABEC SC, ");
        query.append("       MAE_PRODU MP, ");
        query.append("       PRE_OFERT_DETAL OD, ");
        query.append("       PRE_MATRI_FACTU MF, ");
        query.append("       PRE_MATRI_FACTU_CABEC MFC ");
        query.append("WHERE MP.OID_PROD = OD.PROD_OID_PROD ");
        query.append("  AND OD.OID_DETA_OFER = MF.OFDE_OID_DETA_OFER ");
        query.append("  AND MF.MFCA_OID_CABE = MFC.OID_CABE ");
        query.append("  AND MFC.PERD_OID_PERI = CP.OID_PERI ");
        if (dto.getCodigoVenta() != null) {
            query.append("  AND OD.VAL_CODI_VENT LIKE '" + dto.getCodigoVenta() + "' ");
        }
        query.append("  AND SC.OID_SOLI_CABE = " + dto.getNumDocumento());
	    query.append("  AND SC.PERD_OID_PERI = CP.OID_PERI ");
        if (dto.getPaginaCatalogo() != null){
            query.append(" AND OD.NUM_PAGI_CATA = " + dto.getPaginaCatalogo());  // En el caso de que este atributo sea distinto de null 
        }
        query.append(" ) TABLA ");
        
        return query;
    }

  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("DAOCapturaProcesoReclamos.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }       
    UtilidadesLog.info("DAOCapturaProcesoReclamos.executeQuery(String query): Salida");  
    return rs;
  }
    
    //mamontie inc 21616 DBLG400000354
    public RecordSet obtenerProductosCodigoVentaSi(DTOBuscarProductosDevuelveNoREC dto) throws MareException{
        //Incidencias BELC300013813 y BELC300014714
        //BELC300014955
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosCodigoVentaSi(DTOBuscarProductosDevuelveNoREC):Entrada");
        
        String codigo = null;        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append(" SELECT rp.COD_PREC ");
        sql.append(" FROM REC_OPERA ro, REC_PRECI rp ");
        sql.append(" WHERE ro.PECI_OID_PECI = rp.OID_PREC ");
        sql.append(" AND ro.OID_OPER = ? ");
        parametros.add(dto.getOperacion());

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch(Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        if (!rs.esVacio()) {
           codigo = (String)rs.getValueAt(0, 0);                                                            
        }

        if (dto.getOidIdioma()==null){
            dto.setOidIdioma(RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
        }

        rs = null;
        rs = this.obtenerDatosProductosCodigoVentaSi(dto, codigo);
        
        if (rs.esVacio()) {
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerProductosCodigoVentaSi: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosCodigoVentaSi(DTOBuscarProductosDevuelveNoREC):Salida");
        return rs;
    }

    
    /**
     * @Observaciones
     *   - DBLG700000265 19/Dic/2006 eiraola
     *     Se vuelve a aplicar la correcion del 12/Dic/2006 pues fue sobreescrita 
     *     con la version Productiva.
     *   - DBLG700000265 12/Dic/2006 eiraola
     *     Accedemos solamente al Maestro de productos y no a la Matriz de Facturacion 
     *     cuando se Busca Productos por Código o Descripcion de Producto (y con el
     *     criterio de Cod Venta en blanco).
     *   - 21212 10/01/06 mamontie
     *   - 21616 06/12/05 mamontie
     */
    public RecordSet obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC dto) throws MareException{
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC):Entrada");
        UtilidadesLog.debug("  El Dto con los indicadores para buscar productos es: \n" + dto);

        String codigo = null;        
        String codigoOperacion = null;   // sapaza -- Cambio PER-SiCC-2010-0309  -- 10/05/2010
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append(" SELECT rp.COD_PREC, ro.COD_OPER ");
        sql.append(" FROM REC_OPERA ro, REC_PRECI rp ");
        sql.append(" WHERE ro.PECI_OID_PECI = rp.OID_PREC ");
        sql.append(" AND ro.OID_OPER = ? ");
        parametros.add(dto.getOperacion());

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch(Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        if (!rs.esVacio()) {
               codigo = (String)rs.getValueAt(0, 0);                                                            
               codigoOperacion = (String)rs.getValueAt(0, 1); // sapaza -- Cambio PER-SiCC-2010-0309  -- 10/05/2010                                                           
        }

        sql = new StringBuffer();
        parametros = new Vector();
        
        sql.append("SELECT ROWNUM OID, TABLA.* ");
        sql.append(" FROM ( ");
        sql.append(" SELECT DISTINCT gen.VAL_I18N AS DESCRIPCION, ");
        sql.append(" pe.VAL_NOMB_PERI AS PERIODO, " );        
        
        /*
        Si indicadorPrecios = "I" 
        */
        if (codigo.equals("I")){
            sql.append(" '' DESCRIPCIONTIPOOFERTA, ");
            sql.append(" '' OIDTIPOOFERTA, ");
            
            // sapaza -- Cambio PER-SiCC-2010-0309  -- 10/05/2010
            if(codigoOperacion.equals("DP")) { 
              sql.append(" '0' AS UNIDADADESATENDIDAS, "); 
              sql.append(" '0' AS UNIDADESYARECLAMADAS, ");
            }  
            else {
              sql.append(" '' UNIDADADESATENDIDAS, ");                
              sql.append(" '' UNIDADESYARECLAMADAS, ");
            }
                
            sql.append(" AL.COD_VENT_FICT CODIGOVENTA, ");
            sql.append(" '' OID_COD_VENTA, ");
        } else {
            sql.append(" '' as DESCRIPCIONTIPOOFERTA, " );
            sql.append(" null as OIDTIPOOFERTA, " );
            sql.append(" '0' AS UNIDADADESATENDIDAS, ");  // Incidencia Sicc20080555
            sql.append(" '0' AS UNIDADESYARECLAMADAS, "); // Incidencia Sicc20080555
            sql.append(" '' AS CODIGOVENTA, "); // Incidencia Sicc20080555
            sql.append(" null AS OID_COD_VENTA, ");
        }
        


        if (dto.getDevuelveFisicoFactura() != null && !dto.getDevuelveFisicoFactura().booleanValue()){
            sql.append(" '0' PRECIOUNITARIO ");
        } else {
            if (codigo.equals("I")){
                sql.append(" '0' PRECIOUNITARIO ");
            } else {
                sql.append(" NVL(MP.VAL_PREC_POSI,0) PRECIOUNITARIO ");
            }
        }
        if (codigo.equals("I")){
            sql.append(" , NVL(AL.IMP_PREC_PUBL,0) PRECIOCONTABLE, ");
			      sql.append(" CPG.NUM_CONC NUMEROCONCURSO, ");
            sql.append(" PN.NUM_NIVE NUMERONIVEL, ");
            sql.append(" LA.NUM_PREM NUMPREMIO, ");
            sql.append(" MP.COD_SAP CODIGOPRODUCTO, ");
            sql.append(" MP.OID_PROD OID_PRODUCTO, ");
            sql.append(" '' OID_SOLI_POSI,  ");
            sql.append(" cpg.OID_PARA_GRAL OIDCONCURSO, ");
            sql.append(" pn.OID_PARA_NIVE_PREM OIDNIVEL, ");
            sql.append(" la.OID_LOTE_PREM_ARTI OIDPREMIO ");
        }else    {
            
            sql.append(", CASE WHEN MP.VAL_PREC_CATA <> 0 ");
            sql.append(" THEN 0 ");
		      	sql.append(" ELSE MP.VAL_PREC_POSI  ");
            sql.append(" END AS PRECIOCONTABLE, ");          
            sql.append(" '' NUMEROCONCURSO, ");
            sql.append(" '' NUMERONIVEL, ");
            sql.append(" '' NUMPREMIO, ");
            sql.append(" MP.COD_SAP CODIGOPRODUCTO, ");
            sql.append(" MP.OID_PROD OID_PRODUCTO, ");
            sql.append(" '' OID_SOLI_POSI, ");    // Incidencia Sicc20080555
            sql.append(" '' OIDCONCURSO, ");
            sql.append(" '' OIDNIVEL, ");
            sql.append(" '' OIDPREMIO ");
        }

        sql.append(" FROM CRA_PERIO pe, ");
        sql.append(" PED_SOLIC_CABEC sc, ");        
        sql.append(" MAE_PRODU mp, ");
        sql.append(" V_GEN_I18N_SICC gen ");
        
        if (codigo.equals("I")){

            sql.append(" , ");
            sql.append(" INC_ARTIC_LOTE AL, ");
            sql.append(" INC_LOTE_PREMI_ARTIC LA, ");
            sql.append(" INC_PREMI_ARTIC PA, ");
            sql.append(" INC_PARAM_NIVEL_PREMI PN, ");
            sql.append(" INC_PARAM_GENER_PREMI PG, ");
            sql.append(" INC_CONCU_PARAM_GENER CPG ");
        } else {
            // Incidencia Sicc20070555
        }
        
        sql.append(" WHERE MP.PAIS_OID_PAIS = " + dto.getOidPais());

        if (codigo.equals("I")){
            sql.append(" AND SC.PERD_OID_PERI = PE.OID_PERI ");
            sql.append(" AND AL.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
            sql.append(" AND AL.PROD_OID_PROD = MP.OID_PROD ");
            sql.append(" AND LA.PRAR_OID_PREM_ARTI = PA.OID_PREM_ARTI ");
            sql.append(" AND PA.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
            sql.append(" AND PN.PAGP_OID_PARA_GENE_PREM = PG.OID_PARA_GENE_PREM ");
            sql.append(" AND PG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");            
            // Comentado por SiCC 20080558 - Rafael Romero - 08/02/2008
            // sql.append(" AND cpg.oid_para_gral = sc.copa_oid_para_gene(+) ");
            // Fin comentado SiCC 20080558
        } else {
            sql.append(" AND sc.perd_oid_peri = pe.oid_peri ");
            // Incidencia Sicc20070555
        }
        
        sql.append(" and gen.ATTR_ENTI = 'MAE_PRODU' ");
		sql.append(" and gen.VAL_OID = mp.OID_PROD ");
		sql.append(" and gen.ATTR_NUM_ATRI = 1 ");
        if (dto.getOidIdioma()==null){
            dto.setOidIdioma(RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
        }
		sql.append(" and gen.IDIO_OID_IDIO = "+dto.getOidIdioma());

        if (dto.getCodigoProducto() != null){
            sql.append(" AND MP.COD_SAP LIKE '" + dto.getCodigoProducto() + "'");
            
        }
        
        if (dto.getDescripcion() != null){
            sql.append(" and gen.VAL_I18N LIKE '" + dto.getDescripcion() + "'");
        }
        
        sql.append(" AND SC.SOCA_OID_SOLI_CABE = " + dto.getNumDocumento());
        sql.append(" order by codigoventa ) TABLA");
        
        UtilidadesLog.debug("query: " + sql.toString());
        
        
        String sqlPaginada = this.armarQueryPaginacionEspecial(sql.toString(),dto);
        
        try {
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        } catch(Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs.esVacio()) {                                                                               
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerProductosCodigoVentaNo: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC):Salida");
        return rs;
    }
    
   // creado por incidencia BELC300014631
   public RecordSet obtenerEstadoOperacionesReclamo(Long numAtencion) throws MareException {
   
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerEstadoOperacionesReclamo(Long):Salida");
      
      StringBuffer sql = new StringBuffer();
      Vector parametros = new Vector();
      
      //	-> Hacer consulta JDBC, filtrando por el campo de entrada sobre las tablas REC_CABEC_RECLA cr ,
      //	REC_OPERA_RECLA or
   
      //	-> cr.NUM_ATEN = numAtencion
   
      //	-> Devolver el RecordSet, ordenado por oidOperacion obtenido en la actividad anterior que contendrá los
      //	siguientes campos en este orden:
      //	- oidOperacion = or.OID_OPER_RECL
      //	- estadoOperacion = or.ESOP_OID_ESTA_OPER
      
      sql.append("SELECT ror.OID_OPER_RECL AS OIDOPERACION, ");
      sql.append("ror.ESOP_OID_ESTA_OPER AS ESTADOOPERACION ");
      sql.append("FROM REC_CABEC_RECLA cr, REC_OPERA_RECLA ror ");
      sql.append("WHERE ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
      sql.append("AND cr.NUM_ATEN = ?");
      parametros.add(numAtencion);
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
         rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      } catch(Exception e) { 
         String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.debug("RecordSet obtenido: " + rs);
            
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerEstadoOperacionesReclamo(Long):Salida");
      return rs;
   }    
   
   public RecordSet obtenerIndicadorAnulacionOperaciones(DTOBelcorp dto) throws MareException {
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerIndicadorAnulacionOperaciones(DTOBelcorp):Entrada");
      StringBuffer sql = new StringBuffer("");
      Vector parametros = new Vector();
      
      sql.append(" SELECT ro.OID_OPER AS OIDCODIGOOPERACION, ");
      sql.append(" ro.IND_ANUL AS INDICADORANULACION ");
      sql.append(" FROM REC_OPERA ro, ");
      sql.append(" REC_TIPOS_OPERA rto, ");
      sql.append(" REC_AUTOR ra ");
      sql.append(" WHERE rto.ROPE_OID_OPER = ro.OID_OPER ");
      sql.append(" AND ra.TIOP_OID_TIPO_OPER = rto.OID_TIPO_OPER ");
      sql.append(" AND ra.IND_INGR = 1 ");
      sql.append(" AND ra.PAIS_OID_PAIS = ? ");
      parametros.add(dto.getOidPais());
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
          rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      if(rs.esVacio()) {
          String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
          String mensaje = "DAOCapturaProcesoReclamos.obtenerindicadorAnulacionOperaciones: no se han "
                            +"encontrado datos para idioma="+dto.getOidIdioma()+", pais="+dto.getOidPais();
          throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
      }
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerIndicadorAnulacionOperaciones(DTOBelcorp):Salida");
      return rs;
   }
   
 /**
  * @autor Noziglia C.
  * @throws MareException
  * @param 
  * @return 
  * @documentation 
  * Descripción: verifica el resultado del chequeo efectuado para una solicitud. 
        
        Implementación: 
        
        Acceder a la Tabla PED_SOLIC_CABEC sc y REC_RESUL_CHEQU rc filtrando por: 
        - sc.OID_SOLI_CABE = oidSolicitud 
        - rc.COD_RESU_CHEQ = ConstantesREC.BLOQUEO_POR_CHEQUEO 
        Segun el valor del campo rc.IND_RESU, si es true retornar el valor correspondiente a OID_MOTI_BLOQ, sino, retornar null. 

  * @date
  * 
  * Modificado por HRCS - Fecha 13/02/2007
  * Incidencia DBLG700000289
  */
  public boolean comprobarResultadoChequeoFisico(Long oidSolicitud)throws MareException{
      UtilidadesLog.info("DAOCapturaProcesoReclamos.comprobarResultadoChequeoFisico(Long oidSolicitud):Entrada");
      StringBuffer sql = new StringBuffer("");
      Vector parametros = new Vector();

      sql.append("SELECT oid_soli_cabe, recq_oid_resu_cheq ");
      sql.append("FROM ped_solic_cabec sc, rec_resul_chequ rc ");
      sql.append("WHERE sc.oid_soli_cabe = ? ");
      parametros.add(oidSolicitud);
      sql.append("AND sc.recq_oid_resu_cheq = rc.oid_resu_cheq ");
      sql.append("AND sc.pais_oid_pais = rc.pais_oid_pais ");
      sql.append("AND rc.ind_resu = 1 ");  

      boolean retorno = false;
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      try {
          rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.comprobarResultadoChequeoFisico(Long oidSolicitud):Salida");

      if (rs!=null && !rs.esVacio()) {
          retorno = true;
      }
      return retorno;
    }
    
    public Long obtenerMotivoBloqueoChequeoDeOperaciones( DTOReclamo datosReclamo ) throws MareException    {
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerMotivoBloqueoChequeoDeOperaciones(DTOReclamo datosReclamo):Entrada");
      StringBuffer sql = new StringBuffer("");
      Vector parametros = new Vector();

      //    Obtiene la cadena
      String cadenaSalida = "";
      ArrayList operacion = datosReclamo.getOperaciones();
      java.util.Iterator ite = operacion.iterator();
      while (ite.hasNext()) {
          DTOOperacionReclamo dtoOperacionR = (DTOOperacionReclamo) ite.next();
          cadenaSalida = cadenaSalida + "'" + dtoOperacionR.getCodigoOperacion();
          if(dtoOperacionR!=null){
             cadenaSalida = cadenaSalida + "',";
          }
      }
      cadenaSalida = cadenaSalida.substring(0, cadenaSalida.length() -1);
       
      sql.append("SELECT mobl_oid_moti_bloq, cod_oper, pais_oid_pais ");
      sql.append("FROM rec_opera ");
      sql.append("WHERE pais_oid_pais = ? AND ");
      parametros.add( datosReclamo.getOidPais() );
	  sql.append("mobl_oid_moti_bloq is not NULL AND ");
	  sql.append("cod_oper IN ("+ cadenaSalida +") AND ");
      sql.append(" ROWNUM = 1 ");
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      try {
          rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
    
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerMotivoBloqueoChequeoDeOperaciones(DTOReclamo datosReclamo):Salida");
      if(rs==null||rs.esVacio()) {
           return null;
      } else {
          return Long.valueOf(rs.getValueAt(0,0).toString());
      }
    }
    
    public Long obtieneConsolidado(Long oidSolicitud, Long oidBoletaRecojo)throws MareException{
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtieneConsolidado(Long oidSolicitud):Entrada");
      StringBuffer sql = new StringBuffer("");
      Vector parametros = new Vector();
      
      sql.append(" 		SELECT SC.SOCA_OID_SOLI_CABE, SC.VAL_NUME_SOLI NUMEROFACTURA, "); 
      sql.append("       OBTENER_FECHA_ENTREGA (SC.ZZON_OID_ZONA, SC.PERD_OID_PERI, SC.PAIS_OID_PAIS, "); 
      sql.append("                              SC.FEC_FACT ) FECHARECOJO, SC.FEC_FACT FECHAEMISION, "); 
      sql.append("       CASE WHEN ((SELECT COUNT (*) "); 
      sql.append("                     FROM PED_SOLIC_CABEC PSC "); 
      sql.append("                    WHERE PSC.CLIE_OID_CLIE = SC.CLIE_OID_CLIE "); 
      sql.append("                      AND PSC.FEC_FACT = SC.FEC_FACT "); 
      sql.append("                      AND PSC.IND_OC = 1) > 1 ) THEN 0 "); 
      sql.append("          ELSE 1 END INDICADORPEDIDOSEVICIO "); 
      sql.append("  FROM PED_SOLIC_CABEC SC "); 
      sql.append(" WHERE SC.OID_SOLI_CABE = ? ");  
      parametros.add(oidSolicitud);
   
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
          rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtieneConsolidado(Long oidSolicitud):Salida");
      if(rs==null||rs.esVacio()){
          return null;
      }else{
          if(rs.getValueAt(0,0)!=null){
           if(oidBoletaRecojo!=null){ 
                StringBuffer sql2 = new StringBuffer("");
                sql2.append(" UPDATE REC_BOLET_RECOJ ");
                if(rs.getValueAt(0,"FECHAEMISION")!=null){
                  sql2.append("    SET FEC_EMIS = TO_DATE ('" + rs.getValueAt(0,"FECHAEMISION").toString() + "', 'yyyy-MM-dd'), ");
                }
                if(rs.getValueAt(0,"FECHARECOJO")!=null){
                  sql2.append("        FEC_RECO = TO_DATE ('" + rs.getValueAt(0,"FECHARECOJO").toString() + "', 'yyyy-MM-dd'), ");
                }
                if(rs.getValueAt(0,"INDICADORPEDIDOSEVICIO")!=null){
                  sql2.append("        IND_PEDI_SERV = "+ rs.getValueAt(0,"INDICADORPEDIDOSEVICIO").toString()+" , ");
                }
                sql2.append("        NUM_FACT = " + rs.getValueAt(0,"NUMEROFACTURA").toString());
                sql2.append("  WHERE OID_BOLE_RECO = "+oidBoletaRecojo);
               
            try {
              bs.dbService.executeUpdate(sql2.toString());
            } catch (Exception e) {
              UtilidadesLog.error("ERROR: ",e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }        
           }
            return Long.valueOf(rs.getValueAt(0,0).toString());    
          }else{
            return null;
          }
          
      }
      
    }
    
    //cambio REC-004 se agrega este metodo alternativo para que solo se procesen solicitudes de premio
    
    public RecordSet obtenerDatosPerdidaPremios(DTOOperacion oidOperacion, Long oidTipoSolicitudPais, Long oidConcurso, Long oidNivel, Long oidPremio) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamosPremios.obtenerDatosPerdidaPremios(DTOOperacion):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros  = new Vector();
        
        //SELECT
        sql.append(" SELECT lo.OID_LINE_OPER_RECL OIDLINEA, op.VAL_PERD AS PERDIDA, ");
        sql.append(" ror.ASPE_OID_ASUM_PERD AS ASUMEPERDIDA, ");
        sql.append(" lo.IMP_MONT_PERD AS MONTOPERDIDA, ");
        sql.append(" op.TSPA_OID_SOLI_PAIS_PERD AS SOLICITUDPERDIDA, "); // BELC300019211
        sql.append(" ror.CLIE_OID_CLIE AS CLIENTESEGURO, ");
        sql.append(" ts.MARC_OID_MARC AS MARCA, ");
        sql.append(" ts.SBAC_OID_SBAC AS SUBACCESO, ");
        sql.append(" cr.CLIE_OID_CLIE AS OIDCLIENTE, ");
        sql.append(" ror.PERD_OID_PERI_RECL AS OIDPERIODO, ");
        sql.append(" cr.SOCA_OID_SOLI_CABE AS OIDSOLICITUDREFERENCIA, ");
        sql.append(" lo.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO, ");
        //sql.append(" do.VAL_CODI_VENT AS CODVENTA, ");    // Comentado 26/07/2007
        sql.append(" al.COD_VENT_FICT AS codventa, ");  //  Agregado 26/07/2007
                
        sql.append(" mp.COD_SAP AS CODPRODUCTO, ");
        sql.append(" mp2.COD_SAP AS CODIGOARTICULO, ");
        sql.append(" lo.NUM_UNID_RECL AS UDEMANDADAS, ");
        sql.append(" mp.OID_PROD AS OIDPRODUCTO, lo.val_prec precio,");
        sql.append(" mp2.OID_PROD AS OIDARTICULO, ");
        sql.append(" ror.IMP_MONT_PERD AS MONTOPERDIDAOPERACION, "); // BELC300019551
        sql.append(" ror.CLIE_OID_RESP_PERD RESPONSABLEPERDIDA, "); //mamontie REC-12  prueba
        sql.append(" op.OID_OPER , ");
        sql.append(" rto.IND_DEVU_ESTA_FACT, ");
        //Gacevedo: El cambio en la forma de obtener el precio catalogo unitario local
        //responde al intento de solucion de la incidencia DBLG700000110.
        //Si la linea de operacion no tiene posicion de referencia, se usa el
        //detalle de oferta para traer el precio en cuestion.
        //sql.append(" posi.val_prec_cata_unit_loca AS preciocataunitariolocal, ");//incidencia 22743
        /*sql.append(" CASE WHEN lo.sopo_oid_soli_posi IS NULL ");
	   	sql.append(" THEN (SELECT precio_unitario FROM pre_ofert_detal p WHERE p.OID_DETA_OFER = mf.ofde_oid_deta_ofer) ");
			sql.append(" ELSE posi.val_prec_cata_unit_loca ");
	   	sql.append(" END AS preciocataunitariolocal, ");*/
        //Fin del cambio de Gacevedo (DBLG700000110).
        sql.append(" posi.val_prec_cata_unit_loca AS preciocataunitariolocal, ");   //  Agregado 26/07/2007
        sql.append(" al.imp_prec_publ AS preciocontunitariolocal, ");//incidencia 22743
        sql.append(" posi.val_impo_desc_unit_loca AS impdescunilocal, ");//incidencia 22743
        sql.append(" posi.val_porc_desc AS porcentajedesc, ");//incidencia 22743
        sql.append(" posi.val_prec_cata_unit_docu AS preccataunidocu, ");//incidencia 22743
        sql.append(" posi.val_prec_conta_unit_docu AS preccontunidocu, ");//incidencia 22743
        sql.append(" posi.val_impo_desc_unit_docu AS impdescunidocu, ");//incidencia 22743
        //se agrega el campo a fin de grabarlo en la posicion que se genera por el reclamo
        //sql.append(" do.OID_DETA_OFER AS detalleoferta, ");//incidencia 22743     Comentado 26/07/2007
        sql.append(" '' AS detalleoferta, ");   //  Agregado 26/07/2007
        sql.append(" lo.SOPO_OID_SOLI_POSI AS OIDPOSICION, ");//V-REC-18
        sql.append("  lo.COPA_OID_PARA_GRAL OIDCONCURSO, ");
		sql.append("  lo.PANP_OID_PARA_NIVE_PREM OIDNIVEL, ");
		sql.append("  lo.LOPA_OID_LOTE_PREM_ARTI OIDPREMIO, ");
        sql.append(" op.IND_FALT_MERC,  ");
        sql.append(" op.IND_DEVU_FISI_FACT ");
        //FROM
        sql.append(" FROM REC_OPERA_RECLA ror, ");
        sql.append(" REC_TIPOS_OPERA rto, ");
        sql.append(" REC_OPERA op, ");
        sql.append(" PED_TIPO_SOLIC_PAIS sp, ");
        sql.append(" REC_LINEA_OPERA_RECLA lo, ");
        //sql.append(" PRE_MATRI_FACTU mf, ");      //  Comentado 26/07/2007
        //sql.append(" PRE_OFERT_DETAL do, ");      
        sql.append(" INC_LOTE_PREMI_ARTIC lpa, ");  //  Agregado 26/07/2007
        sql.append(" INC_ARTIC_LOTE al, ");
        sql.append(" MAE_PRODU mp, ");
        sql.append(" MAE_PRODU mp2, ");
        sql.append(" REC_CABEC_RECLA cr, ");
        sql.append(" PED_TIPO_SOLIC ts, ");
        sql.append(" PED_SOLIC_POSIC posi ");//incidencia 22743
        //WHERE
        sql.append(" WHERE ror.TIOP_OID_TIPO_OPER = rto.OID_TIPO_OPER ");
        sql.append(" AND rto.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND op.TSPA_OID_SOLI_PAIS_PERD = sp.OID_TIPO_SOLI_PAIS(+) ");
        sql.append(" AND lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
        //sql.append(" AND lo.MAFA_OID_MATR_FACT = mf.OID_MATR_FACT (+)");  //  Comentado 26/07/2007
        //sql.append(" AND mf.OFDE_OID_DETA_OFER = do.OID_DETA_OFER (+)");
        sql.append(" AND lo.lopa_oid_lote_prem_arti = lpa.oid_lote_prem_arti ");    // Agregado 26/07/2007
        sql.append(" AND lpa.OID_LOTE_PREM_ARTI = al.LOPA_OID_LOTE_PREM_ARTI ");
        sql.append(" AND al.PROD_OID_PROD = lo.PROD_OID_PROD ");

        sql.append(" AND lo.COPA_OID_PARA_GRAL is not null  ");
        
        sql.append(" AND lo.PROD_OID_PROD = mp.OID_PROD(+) ");
        sql.append(" AND ror.PROD_OID_PROD = mp2.OID_PROD(+) ");
        sql.append(" AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
        sql.append(" AND sp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI(+) ");
        sql.append(" AND lo.SOPO_OID_SOLI_POSI = posi.OID_SOLI_POSI(+) ");//incidencia 22743
        sql.append(" AND cr.PAIS_OID_PAIS = ? ");
        parametros.add(oidOperacion.getOidPais());

        if (oidTipoSolicitudPais != null)  {
            sql.append(" AND lo.TSPA_OID_TIPO_SOLI_PAIS = ? ");
            parametros.add(oidTipoSolicitudPais);
        }        
        if (oidOperacion.getOidOperacion() != null){
            sql.append(" AND ror.OID_OPER_RECL = ? ");
            parametros.add(oidOperacion.getOidOperacion());
        }

        if ( oidConcurso != null){
            sql.append(" AND lo.COPA_OID_PARA_GRAL = ? ");
            parametros.add(oidConcurso);
        }
        if ( oidNivel != null){
            sql.append(" AND lo.PANP_OID_PARA_NIVE_PREM = ? ");
            parametros.add(oidNivel);
        }
        if ( oidPremio != null){
            sql.append(" AND lo.LOPA_OID_LOTE_PREM_ARTI = ? ");
            parametros.add(oidPremio);
        }
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("******** RecordSet obtenido: " + rs);        
         
        UtilidadesLog.info("DAOCapturaProcesoReclamosPremios.obtenerDatosPerdidaPremios(DTOOperacion):Salida");
        return rs;
    }
    
    public RecordSet obtenerLineasPorSolicitudPremio(DTOAtencionReclamoREC numAtencion) throws MareException{
        // BELC300014262
        //Modificado nuevamente por BELC300018563
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasPorSolicitudPremio(DTOAtencionReclamoREC):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append(" SELECT lo.OPRE_OID_OPER_RECL AS OIDOPERACION, cr.NUM_ATEN, ");
 		sql.append(" lo.OID_LINE_OPER_RECL AS  OIDLINEA,  ");
 		sql.append(" ts.MARC_OID_MARC AS MARCA, ");
 		sql.append(" ac.CANA_OID_CANA AS CANAL, ");
 		sql.append(" ts.ACCE_OID_ACCE AS ACCESO, ");
 		sql.append(" ts.SBAC_OID_SBAC AS SUBACCESO, ");
 		sql.append(" cr.CLIE_OID_CLIE AS OIDCLIENTE, ");
 		sql.append(" cr.PERD_OID_PERI_RECL AS OIDPERIODO, ");
 		sql.append(" sp.OID_TIPO_SOLI_PAIS AS OIDTIPOSOLICITUD, ");
 		sql.append(" cr.SOCA_OID_SOLI_CABE AS OIDSOLICITUDREFERENCIA, ");
 		sql.append(" lo.TIMO_OID_TIPO_MOVI AS TIPOMOVIMIENTO, ");
 		//sql.append(" do.VAL_CODI_VENT AS CODVENTA, ");
        sql.append(" al.COD_VENT_FICT AS CODVENTA, ");  //  agregado 25/07/2007
 		sql.append(" lo.VAL_PREC AS PRECIO, ");
 		sql.append(" mp.COD_SAP AS CODPRODUCTO, ");
 		sql.append(" lo.NUM_UNID_RECL AS UDEMANDADAS, ");
 		sql.append(" mp.OID_PROD AS OIDPRODUCTO, ");
        
        sql.append("  lo.COPA_OID_PARA_GRAL OIDCONCURSO, ");
		sql.append("  lo.PANP_OID_PARA_NIVE_PREM OIDNIVEL, ");
		sql.append("  lo.LOPA_OID_LOTE_PREM_ARTI OIDPREMIO, ");
        sql.append("  lpa.NUM_PREM NUMPREMIO ");
 		sql.append(" FROM REC_CABEC_RECLA cr, ");
 		sql.append(" REC_OPERA_RECLA ror, ");
 		sql.append(" REC_LINEA_OPERA_RECLA lo, ");
 		sql.append(" PED_TIPO_SOLIC_PAIS sp, ");
 		//sql.append(" PRE_MATRI_FACTU mf, ");
 		//sql.append(" PRE_OFERT_DETAL do, ");
 		sql.append(" MAE_PRODU mp, ");
 		sql.append(" PED_TIPO_SOLIC ts, ");
 		sql.append(" INC_LOTE_PREMI_ARTIC lpa, ");
        sql.append(" INC_ARTIC_LOTE al, "); //  agregado 25/07/2007
        sql.append(" SEG_ACCES ac");
        
 		sql.append(" WHERE lo.OPRE_OID_OPER_RECL = ror.OID_OPER_RECL ");
 		sql.append(" AND cr.PAIS_OID_PAIS = " + numAtencion.getOidPais());
 		sql.append(" AND ror.CARE_OID_CABE_RECL = cr.OID_CABE_RECL ");
 		//sql.append(" AND lo.MAFA_OID_MATR_FACT = mf.OID_MATR_FACT(+) ");
 		//sql.append(" AND mf.OFDE_OID_DETA_OFER = do.OID_DETA_OFER(+) ");
 		sql.append(" AND lo.PROD_OID_PROD = mp.OID_PROD(+) ");
 		sql.append(" AND lo.TSPA_OID_TIPO_SOLI_PAIS = sp.OID_TIPO_SOLI_PAIS (+)  ");
 		sql.append(" AND sp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI (+) ");
 		sql.append(" AND ts.ACCE_OID_ACCE = ac.OID_ACCE (+) ");
        
        sql.append(" AND lo.LOPA_OID_LOTE_PREM_ARTI = lpa.OID_LOTE_PREM_ARTI ");
        sql.append(" AND lpa.OID_LOTE_PREM_ARTI = al.LOPA_OID_LOTE_PREM_ARTI ");    //  agregado 25/07/2007
        sql.append(" AND al.PROD_OID_PROD = lo.PROD_OID_PROD ");    //  agregado 25/07/2007
 		sql.append(" AND lo.COPA_OID_PARA_GRAL is not null ");
        
        sql.append(" AND (ror.INEM_OID_INDI_ENTR_MERC = " + ConstantesREC.IND_MERCADERIA_S);
 		sql.append(" OR ror.INEM_OID_INDI_ENTR_MERC = " + ConstantesREC.IND_MERCADERIA_C + ") ");
        
        //agregado por inc 22749
        sql.append(" AND (ror.ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_INGRESADO);
        sql.append(" OR ror.ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_DIGITADO);
        sql.append(" OR ror.ESOP_OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_PARCIAL + ")");
        sql.append(" AND (cr.ESRE_OID_ESTA_RECL = " + ConstantesREC.ESTADO_RECLAMO_INGRESADO);
        sql.append(" OR cr.ESRE_OID_ESTA_RECL = " + ConstantesREC.ESTADO_RECLAMO_DIGITADO);
        sql.append(" OR cr.ESRE_OID_ESTA_RECL = " + ConstantesREC.ESTADO_RECLAMO_PARCIAL + ")");
        //FIN agregado por inc 22749

        
        if (numAtencion.getNumAtencion() != null){
            sql.append(" AND cr.NUM_ATEN = " + numAtencion.getNumAtencion());
        }
    
    sql.append(" AND sp.oid_tipo_soli_pais IS NOT NULL ");
        //sql.append(" AND ror.tiop_oid_tipo_oper = tipooperacion.oid_tipo_oper ");
    //sql.append(" AND tipooperacion.rope_oid_oper = opera.oid_oper ");
    
 		sql.append(" ORDER BY sp.TSOL_OID_TIPO_SOLI, ");
 		sql.append(" lo.OPRE_OID_OPER_RECL, ");
        sql.append("  lo.COPA_OID_PARA_GRAL, ");
		sql.append("  lo.PANP_OID_PARA_NIVE_PREM, ");
		sql.append("  lo.LOPA_OID_LOTE_PREM_ARTI  ");
 
    UtilidadesLog.debug("sql: " + sql);
    UtilidadesLog.debug("Parametros: " + parametros);
    
    RecordSet rs = null;
    BelcorpService bs = BelcorpService.getInstance();
    try {
        rs = bs.dbService.executeStaticQuery(sql.toString());
    } catch(Exception e) {
        String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    UtilidadesLog.debug("RecordSet obtenido: " + rs);
    
    UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasPorSolicitudPremio(DTOAtencionReclamoREC):Salida");
    return rs;
 }
 /**
  * @autor Noziglia C.
  * @throws MareException
  * @param 
  * @return 
  * @documentation  REC-004
  * 
  * @date
  */
   public RecordSet obtenerProductosEnviaPremio(DTOBuscarEnvia dto) throws MareException {
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosEnviaPremio(DTOBuscarEnvia):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
         sql.append("  SELECT * FROM (   ");
         sql.append("  SELECT ROWNUM OID, query.* ");
         sql.append(" FROM (SELECT DISTINCT PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , MP.OID_PROD,'MAE_PRODU') AS DESCRIPCION, ");
                                     parametros.add(dto.getOidIdioma());
         sql.append("             PE.VAL_NOMB_PERI PERIODO, ");
         sql.append("             '' DESCRIPCIONTIPOOFERTA, ");
         sql.append("             ''OIDTIPOOFERTA, ");
         sql.append("             SP.NUM_UNID_ATEN UNIDADESATENDIDAS, ");
         sql.append("             NVL((SELECT SUM(LO.NUM_UNID_RECL) ");
         //sql.append("             SP.VAL_CODI_VENT_FICT CODIGOVENTA, ");
         //sql.append("             '' OID_COD_VENTA, ");
         //sql.append("             DECODE (RP.OID_PREC_ENVI, ");
         //sql.append("                 " + ConstantesREC.PRECIO_ENVIA_FACTURA + ", SP.VAL_PREC_FACT_UNIT_LOCA, ");
         //sql.append("                 SP.VAL_PREC_CATA_UNIT_LOCA ) PRECIOENVIADO, ");
         //sql.append(" sp.VAL_PREC_CONT_UNIT_LOCA AS PRECIOCONTAUNITARIODOC, ");
         //sql.append("             CPG.NUM_CONC NUMEROCONCURSO, ");
         //sql.append("             PN.NUM_NIVE NUMERONIVEL, ");
         //sql.append("             LA.NUM_PREM NUMPREMIO,  ");
        // sql.append("             MP.COD_SAP CODIGOPRODUCTO, MP.OID_PROD ");
        
         sql.append("                FROM REC_LINEA_OPERA_RECLA LO, ");
         sql.append("                     REC_OPERA_RECLA ROR, ");
         sql.append("                     REC_CABEC_RECLA CR ");
         sql.append("               WHERE LO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
         sql.append("                 AND ROR.CARE_OID_CABE_RECL = CR.OID_CABE_RECL ");
         sql.append("                 AND LO.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sql.append("                 AND LO.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
         sql.append("                 AND LO.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
        sql.append("                  AND LO.SOPO_OID_SOLI_POSI = SP.oid_soli_posi  ");
         sql.append("                 AND LO.TIMO_OID_TIPO_MOVI = " + ConstantesREC.TIPO_MOVIMIENTO_ENVIA);
                
                if (dto.getOidCliente() != null) {
                    sql.append(" AND cr.CLIE_OID_CLIE = ? "); // -- cliente
                    parametros.add(dto.getOidCliente());
                }
                if (dto.getOidNumDocumento() != null) {
                    sql.append(" AND cr.SOCA_OID_SOLI_CABE = ?"); // -- numero documento
                    parametros.add(dto.getOidNumDocumento());
                }
         sql.append("                 ),0) AS UNIDADESYARECLAMADAS, ");
         sql.append("             SP.VAL_CODI_VENT_FICT CODIGOVENTA, ");
         sql.append("             '' OID_COD_VENTA,  ");
         sql.append("             DECODE (RP.OID_PREC_ENVI, ");
         sql.append("             " + ConstantesREC.PRECIO_ENVIA_FACTURA + ", SP.VAL_PREC_FACT_UNIT_LOCA, ");
         sql.append("             SP.VAL_PREC_CATA_UNIT_LOCA ) PRECIOENVIADO, ");
         sql.append("             sp.VAL_PREC_CONT_UNIT_LOCA AS PRECIOCONTAUNITARIODOC, ");
         sql.append("             CPG.NUM_CONC NUMEROCONCURSO, ");
         sql.append("             PN.NUM_NIVE NUMERONIVEL,  ");
         sql.append("             LA.NUM_PREM NUMPREMIO, ");
         sql.append("             MP.COD_SAP CODIGOPRODUCTO, MP.OID_PROD, ");       
         
         sql.append("             SP.OID_SOLI_POSI OIDPOSICION, ");
         sql.append("             CPG.OID_PARA_GRAL OIDCONCURSO, ");
         sql.append("             PN.OID_PARA_NIVE_PREM OIDNIVEL, ");
         sql.append("             LA.OID_LOTE_PREM_ARTI OIDPREMIO ");
            
         sql.append("        FROM PED_SOLIC_CABEC SC, ");
         sql.append("             SEG_MONED MO, ");
         sql.append("             PED_SOLIC_CABEC SC2, ");
         sql.append("             PED_SOLIC_POSIC SP, ");
         sql.append("             PED_ESTAD_POSIC EP, ");
         sql.append("             MAE_PRODU MP, ");
         sql.append("             CRA_PERIO PE, ");
         sql.append("             REC_OPERA RO, ");
         sql.append("             REC_PRECI_ENVIA RP, ");
         sql.append("             INC_ARTIC_LOTE AL, ");
         sql.append("             INC_LOTE_PREMI_ARTIC LA, ");
         sql.append("             INC_PARAM_NIVEL_PREMI PN, ");
         sql.append("             INC_PARAM_GENER_PREMI PG, ");
         sql.append("             INC_PREMI_ARTIC PA, ");
         sql.append("             INC_CONCU_PARAM_GENER CPG ");
         sql.append("       WHERE SC.OID_SOLI_CABE = SC2.SOCA_OID_SOLI_CABE ");
         sql.append("         AND SC2.OID_SOLI_CABE = SP.SOCA_OID_SOLI_CABE ");
         sql.append("         AND SC.MONE_OID_MONE = MO.OID_MONE(+) ");
         sql.append("         AND SP.ESPO_OID_ESTA_POSI = EP.OID_ESTA_POSI ");
         sql.append("         AND SP.PROD_OID_PROD = MP.OID_PROD ");
         sql.append("         AND RO.PENV_OID_PRECIO_ENVIA = RP.OID_PREC_ENVI ");
         sql.append("         AND SC.PERD_OID_PERI = PE.OID_PERI ");
         sql.append("         AND SC.PAIS_OID_PAIS = " + dto.getOidPais());
         sql.append("         AND EP.OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
        
        if (dto.getOidNumDocumento() != null) {
            sql.append(" AND SC.OID_SOLI_CABE =  ? "); // -- numero documento
            parametros.add(dto.getOidNumDocumento());
        }       
         
         if (dto.getOidOperacion() != null) {
            sql.append(" AND RO.OID_OPER = ? ");
            parametros.add(dto.getOidOperacion());
         }
        
         sql.append("         AND SP.PROD_OID_PROD = AL.PROD_OID_PROD ");
         sql.append("         AND AL.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
         sql.append("         AND LA.PRAR_OID_PREM_ARTI = PA.OID_PREM_ARTI ");
         sql.append("         AND PA.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
         sql.append("         AND PN.PAGP_OID_PARA_GENE_PREM = PG.OID_PARA_GENE_PREM  ");
         sql.append("         AND PG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
         sql.append("         AND sc2.copa_oid_para_gene = pg.copa_oid_para_gral ");
			   sql.append("         AND sc2.num_prem = la.num_prem ");
         sql.append("  	 ORDER BY UNIDADESYARECLAMADAS) query ");
         sql.append("  	 ) WHERE ROWNUM <=  " + dto.getTamanioPagina());
         sql.append("  	   AND OID > " + dto.getIndicadorSituacion());        
                
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            UtilidadesLog.error(" DAOCapturaProcesoReclamos.obtenerProductosEnvia: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosEnviaPremio(DTOBuscarEnvia):Salida");
        return rs;
    } 
    
   /**
    * @autor Noziglia C.
    * @throws MareException
    * @param 
    * @return 
    * @documentation REC-004
    * 
    * @date
    */  
  public RecordSet obtenerProductosDevuelveSiPremio(DTOBuscarClientesREC dto) throws MareException{
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosDevuelveSiPremio(DTOBuscarClientesREC):Entrada");
        
        
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        //SELECT
        
        sql.append(" SELECT codigoventa || ROWNUM OID, TABLA.* ");
        
        sql.append(" FROM (SELECT DISTINCT PQ_APl_AUX.Valor_Gen_I18n_Sicc( ? ,mp.oid_prod, 'MAE_PRODU') AS descripcion, ");
            parametros.add(dto.getOidIdioma());
        sql.append("         pe.val_nomb_peri AS periodo, ");
        sql.append("         '' descripciontipooferta, ");
        sql.append("         '' AS oidtipooferta, ");
        sql.append("         NVL(sp.num_unid_aten,'0' ) AS unidadadesatendidas, ");
        sql.append("         NVL((SELECT SUM (lo.num_unid_recl) ");
        sql.append("                FROM rec_linea_opera_recla lo, ");
        sql.append("                     rec_opera_recla ror, ");
        sql.append("                     rec_cabec_recla cr ");
        sql.append("               WHERE lo.opre_oid_oper_recl = ror.oid_oper_recl ");
        sql.append("                 AND ror.care_oid_cabe_recl = cr.oid_cabe_recl ");
        if (dto.getOidCliente() != null) { 
            sql.append("             AND cr.clie_oid_clie = ? ");
            parametros.add(dto.getOidCliente());
        }
        sql.append("                 AND LO.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        sql.append("                 AND LO.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
        sql.append("                 AND LO.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
        sql.append("                 AND LO.PROD_OID_PROD = MP.OID_PROD "); // Incidencia Sicc20080542    
        sql.append("                 AND lo.timo_oid_tipo_movi = ? ");
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
        if (dto.getNumDocumento() != null) {
            sql.append("             AND cr.soca_oid_soli_cabe = ? ");
           parametros.add(dto.getNumDocumento());
         }
        sql.append("                 ), '0') AS unidadesyareclamadas, ");
        sql.append("           NVL(sp.num_unid_aten,'0' )- NVL ");
        sql.append("              ((SELECT SUM (lo.num_unid_recl) ");
        sql.append("                  FROM rec_linea_opera_recla lo, ");
        sql.append("                       rec_opera_recla ror, ");
        sql.append("                       rec_cabec_recla cr ");
        sql.append("                 WHERE lo.opre_oid_oper_recl = ror.oid_oper_recl ");
        sql.append("                   AND ror.care_oid_cabe_recl = cr.oid_cabe_recl ");
        if (dto.getOidCliente() != null) { 
            sql.append("               AND cr.clie_oid_clie = ? ");
            parametros.add(dto.getOidCliente());
        }
        sql.append("                   AND LO.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        sql.append("                   AND LO.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
        sql.append("                   AND LO.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
        sql.append("                   AND LO.PROD_OID_PROD = MP.OID_PROD "); // Incidencia Sicc20080542
        sql.append("                   AND lo.timo_oid_tipo_movi = ? ");
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
        if (dto.getNumDocumento() != null) {
            sql.append("               AND cr.soca_oid_soli_cabe = ? ");
           parametros.add(dto.getNumDocumento());
         }
        sql.append("                   ),'0') AS unidadesdisponibles, ");
         sql.append("         al.cod_vent_fict AS codigoventa, ");
        sql.append("         '' oid_cod_venta, ");
        sql.append("         sp.val_prec_cata_unit_loca  AS preciocatalogounitarioloca, ");
        sql.append("         sp.val_impo_desc_unit_loca AS descuentounitario, ");
        sql.append("         CASE WHEN sp.VAL_PREC_CONT_UNIT_LOCA <> 0 ");
	    	sql.append("         THEN 0 ");
			  sql.append("         ELSE sp.val_prec_fact_unit_loca  ");
	    	sql.append("         END AS PRECIOFACTURAUNITARIOLOCA, ");
        sql.append("         sp.VAL_PREC_CONT_UNIT_LOCA AS PRECIOCONTALOGOUNITARIOLOCA, ");
        sql.append("         NVL(cpg.num_conc,'') numeroconcurso, ");
        sql.append("         NVL(pn.NUM_NIVE, '') numeronivel,  ");
        sql.append("         NVL(la.NUM_PREM ,'') numpremio, ");
        sql.append("         mp.cod_sap AS codigoproducto, ");
        sql.append("         mp.oid_prod oid_producto, ");
        sql.append("         sp.OID_SOLI_POSI, ");
        sql.append("         cpg.oid_para_gral oidconcurso, ");
        sql.append("         pn.oid_para_nive_prem oidnivel, ");
        sql.append("         la.oid_lote_prem_arti oidpremio ");
        sql.append("    FROM ped_solic_cabec sc, ");
        sql.append("         ped_solic_posic sp, ");
        sql.append("         ped_estad_posic ep, ");
        sql.append("         mae_produ mp, ");
        sql.append("         cra_perio pe, ");
        sql.append("         INC_ARTIC_LOTE AL, ");
        sql.append("         INC_LOTE_PREMI_ARTIC LA, ");
        sql.append("         INC_PARAM_NIVEL_PREMI PN, ");
        sql.append("         INC_PARAM_GENER_PREMI PG, ");
        sql.append("         INC_PREMI_ARTIC PA, ");
        sql.append("         INC_CONCU_PARAM_GENER CPG ");
        
        sql.append("   WHERE sp.espo_oid_esta_posi = ep.oid_esta_posi ");
        sql.append("     AND sp.soca_oid_soli_cabe = sc.oid_soli_cabe ");
        sql.append("     AND sp.prod_oid_prod = mp.oid_prod ");
        sql.append("     AND sc.perd_oid_peri = pe.oid_peri ");
        sql.append("     AND ep.oid_esta_posi <> ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        if (dto.getNumDocumento() != null){
            sql.append(" AND sc.soca_oid_soli_cabe = ? ");
            parametros.add(dto.getNumDocumento());
        }            
        sql.append("     AND LA.NUM_PREM = SC.NUM_PREM ");
        sql.append("     AND SP.PROD_OID_PROD = AL.PROD_OID_PROD ");
        sql.append("     AND AL.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
        sql.append("     AND LA.PRAR_OID_PREM_ARTI = PA.OID_PREM_ARTI ");
        sql.append("     AND PA.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
        sql.append("     AND PN.PAGP_OID_PARA_GENE_PREM = PG.OID_PARA_GENE_PREM  ");
        sql.append("     AND PG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL   ");
        sql.append("     AND sc.COPA_OID_PARA_GENE = cpg.oid_para_gral ");
        sql.append(" ORDER BY codigoventa ) TABLA ");
        
        String sqlPaginada = this.armarQueryPaginacionEspecial(sql.toString(), dto);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerProductosDevuelveSiPremio(DTOBuscarClientesREC):Salida");
        return rs;
    }
    
    /*
           
      Descripcion: <<GCC-COL-REC-001>>
      
      Implementacion:
      
      -> Hacer consulta JDBC, filtrando por los campos de entrada que no sean NULL, y para el pais activo, sobre las tablas REC_CABEC_RECLA cr , REC_OPERA_RECLA or, REC_SOLIC_OPERA so y REC_LINEA_OPERA_RECL lo, con las siguientes consideraciones:
      
      -> Cruzar REC_CABEC_RECLA, REC_OPERA_RECLA, REC_SOLIC_OPERA y REC_LINEA_OPERA para obtener lineas de operacion que hayan sido facturadas con las siguientes consideraciones:
      - cr.NUM_ATEN = numAtencion
      - lo.TIMO_OID_TIPO_MOVI = ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
      
      -> Cruzar REC_OPERA_RECLA y REC_OPERA op, para recuperar la parametrizacion de las operaciones
      -> Cruzar REC_LINEA_OPERA_RECLA lo con MAE_PRODU mp para obtener el producto
      lo.PROD_OID_PROD = mp.OID_PROD
      
      -> Devolver el RecordSet, ordenado por lo.OPRE_OID_OPER_RECL y lo.OID_LINE_OPER_RECL, obtenido en la actividad anterior que contendrá los siguientes campos en este orden:
      - oidOperacion = lo.OPRE_OID_OPER_RECL
      - oidLinea = lo.OID_LINE_OPER_RECL
      - tipoMovimiento = lo.TIMO_OID_TIPO_MOVI
      - tipoSolicitud1 = op.TSPA_OID_SOLI_CON_STOC
      - tipoSolicitud2 = op.TSPA_OID_SOLI_SIN_STOC
      - tipoSolicitudGenera = op.TSPA_OID_SOLI_PAIS_GENE
      - recojo = op.IND_RECO
      - tipoSolicitudRecojoInicial = op.TSPA_OID_TIPO_SOLI_REC_INIC
      - tipoSolicitudPrimerRecojoNoExitoso = op.TSPA_OID_TIPO_SOLI_PRI_NO_EXIT
      - tipoSolicitudSegundoRecojoNoExitoso = op.TSPA_OID_SOLI_PAIS_SEG_NO_EXIT
      - saldo = st.VAL_SALD
      - uReclamadas = lo.NUM_UNID_RECL
      - uDevueltas = lo.NUM_UNID_DEVU
      - espera = op.IND_ESPE_MERC_FISI
      - precioUnitario = lo.VAL_PREC
      - devueltoFisicoEnFactura = op.IND_DEVU_FISI_FACT
     */
    public RecordSet obtenerLineasDevuelveFacturadas (DTOOID dto )throws MareException{
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasDevuelveFacturadas (Long numAtencion):Entrada");
      StringBuffer sql = new StringBuffer("");
      Vector parametros = new Vector();
      
      sql.append(" SELECT   LO.OPRE_OID_OPER_RECL OIDOPERACION , LO.OID_LINE_OPER_RECL LINEAOPERACION, LO.TIMO_OID_TIPO_MOVI TIPOMOVIMIENTO, ");
      sql.append("          OP.TSPA_OID_SOLI_CON_STOC TIPOSOLICITUD1 , OP.TSPA_OID_SOLI_SIN_STOC TIPOSOLICITUD2, ");
      sql.append("          OP.TSPA_OID_SOLI_PAIS_GENE TIPOSOLICITUDGENERA , OP.IND_RECO, ");
      sql.append("          OP.TSPA_OID_TIPO_SOLI_REC_INIC, OP.TSPA_OID_TIPO_SOLI_PRI_NO_EXIT, ");
      sql.append("          OP.TSPA_OID_SOLI_PAIS_SEG_NO_EXIT, ");
      sql.append("    		  LO.NUM_UNID_RECL URECLAMADAS, ");
      sql.append("    		  LO.NUM_UNID_DEVU UDEVUELTAS, OP.IND_ESPE_MERC_FISI ESPERA, LO.VAL_PREC PRECIOUNITARIO, ");
      sql.append("    		  OP.IND_DEVU_FISI_FACT DEVUELTOFISICO ");  
      sql.append("     FROM REC_CABEC_RECLA CR, ");
      sql.append("          REC_OPERA_RECLA ROR, ");      
      sql.append("          REC_LINEA_OPERA_RECLA LO, ");
      sql.append("          REC_SOLIC_OPERA SO, ");
      sql.append("          REC_OPERA OP, ");
      sql.append("          REC_TIPOS_OPERA RTO, ");
      sql.append("          PED_SOLIC_CABEC SC, ");      
      sql.append("          PED_SOLIC_CABEC SC2 ");  
      sql.append("    WHERE CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL ");
      sql.append("      AND ROR.OID_OPER_RECL = LO.OPRE_OID_OPER_RECL ");      
      sql.append("      AND RTO.OID_TIPO_OPER = ROR.TIOP_OID_TIPO_OPER ");
      sql.append("      AND SO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
      sql.append("      AND OP.OID_OPER = RTO.ROPE_OID_OPER ");
      sql.append("      AND CR.PAIS_OID_PAIS = "+dto.getOidPais());
      sql.append("      AND CR.NUM_ATEN = "+dto.getOid());
      sql.append("      AND LO.TIMO_OID_TIPO_MOVI =  "+ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
      sql.append("      AND SO.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
      sql.append("      AND SC.GRPR_OID_GRUP_proc = "+ConstantesPED.GP5+" ");
      sql.append("      AND SO.SOCA_OID_SOLI_CABE = SC2.OID_SOLI_CABE ");
      sql.append("      AND SC2.PERD_OID_PERI = CR.PERD_OID_PERI_RECL ");
      sql.append(" ORDER BY LO.OPRE_OID_OPER_RECL, LO.OID_LINE_OPER_RECL ");
      
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
          rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineasDevuelveFacturadas (Long numAtencion):Salida");
      if(rs==null||rs.esVacio()){
          return null;
      }
      return rs;
    
      
         
    }
    
    /*
     Descripcion: <<GCC-COL-REC-001>>
      
      Implementacion:
      
      -> Hacer consulta JDBC, filtrando por los campos de entrada que no sean NULL, y para el pais activo, sobre las tablas REC_CABEC_RECLA cr , REC_OPERA_RECLA or, REC_LINEA_OPERA_RECL lo y REC_PRODU_NO_RECOG nr, con las siguientes consideraciones:
      
      -> Cruzar REC_CABEC_RECLA, REC_OPERA_RECLA, REC_LINEA_OPERA y REC_PRODU_NO_RECOG para obtener lineas de operacion de tipo devuelve y cuyos Productos NO se encuentren marcados como NO recogibles con las siguientes consideraciones:
      - cr.NUM_ATEN = numAtencion
      - lo.TIMO_OID_TIPO_MOVI = ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
      - lo.PROD_OID_PROD not in REC_PRODU_NO_RECOG
      -> Si se recupera al menos 1 registro, devolver cr.OID_CABE_RECL //se retorna el oidReclamo donde existen productos que deben recogerse
      Sino, devolver null 
     */
    public Long existenProductosRecogibles (DTOAtencionReclamoREC dtoE)throws MareException{
    
    UtilidadesLog.info("DAOCapturaProcesoReclamos.existenProductosRecogibles (DTOAtencionReclamoREC dtoE):Entrada");
      StringBuffer sql = new StringBuffer("");
      Vector parametros = new Vector();
      
        sql.append(" SELECT CR.OID_CABE_RECL	");
        sql.append("   FROM REC_CABEC_RECLA CR,	");
        sql.append("        REC_OPERA_RECLA ROR,	");
        sql.append("        REC_LINEA_OPERA_RECLA LOR,	");
        sql.append("        INC_ARTIC_LOTE AL	");
        sql.append("  WHERE CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL	");
        sql.append("    AND ROR.OID_OPER_RECL = LOR.OPRE_OID_OPER_RECL	");
        sql.append("    AND CR.NUM_ATEN = "+dtoE.getNumAtencion() );// --numAtencioN
        sql.append("    AND LOR.TIMO_OID_TIPO_MOVI = " + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE ); //     --ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
        sql.append("    AND LOR.LOPA_OID_LOTE_PREM_ARTI = AL.LOPA_OID_LOTE_PREM_ARTI	");
        sql.append("    AND LOR.PROD_OID_PROD = AL.PROD_OID_PROD	");
        sql.append("    AND AL.OID_ARTI_LOTE NOT IN (SELECT NVL (PNR.ARLO_OID_ARTI_LOTE, 0)	");
        sql.append("                                   FROM REC_PRODU_NO_RECOG PNR	");
        sql.append("                                  WHERE PNR.PERD_OID_PERI = CR.PERD_OID_PERI_RECL)	");
        sql.append(" UNION	");
        sql.append(" SELECT CR.OID_CABE_RECL	");
        sql.append("   FROM REC_CABEC_RECLA CR,	");
        sql.append("        REC_OPERA_RECLA ROR,	");
        sql.append("        REC_LINEA_OPERA_RECLA LOR,	");
        sql.append("        PRE_MATRI_FACTU MF	");
        sql.append("  WHERE CR.OID_CABE_RECL = ROR.CARE_OID_CABE_RECL	");
        sql.append("    AND ROR.OID_OPER_RECL = LOR.OPRE_OID_OPER_RECL	");
        sql.append("    AND CR.NUM_ATEN = "+dtoE.getNumAtencion() );// --numAtencioN
        sql.append("    AND LOR.TIMO_OID_TIPO_MOVI = " + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE ); //     --ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
        sql.append("    AND LOR.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT	");
        sql.append("    AND MF.OFDE_OID_DETA_OFER NOT IN (SELECT NVL (PNR.OFDE_OID_DETA_OFER, 0)	");
        sql.append("                                        FROM REC_PRODU_NO_RECOG PNR)	");


      /*sql.append(" SELECT DISTINCT cr.oid_cabe_recl	");
      sql.append("   FROM rec_cabec_recla cr,	");
      sql.append("        rec_opera_recla ror,	");
      sql.append("        rec_linea_opera_recla lor,	");
      sql.append("        inc_artic_lote al,	");
      sql.append("        pre_matri_factu mf,	");
      sql.append("        rec_produ_no_recog pnr	");
      sql.append("  WHERE cr.oid_cabe_recl = ror.care_oid_cabe_recl	");
      sql.append("    AND ror.oid_oper_recl = lor.opre_oid_oper_recl	");
      sql.append("    AND CR.NUM_ATEN = "+dtoE.getNumAtencion() );// --numAtencioN
      sql.append("    AND lor.timo_oid_tipo_movi = " + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE ); //     --ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
      sql.append("    AND (   (    lor.lopa_oid_lote_prem_arti = al.lopa_oid_lote_prem_arti	");
      sql.append("             AND lor.prod_oid_prod = al.prod_oid_prod	");
      sql.append("             AND al.oid_arti_lote != pnr.arlo_oid_arti_lote )	");
      sql.append("         OR (    lor.mafa_oid_matr_fact != mf.oid_matr_fact	");
      sql.append("             AND mf.ofde_oid_deta_ofer = pnr.ofde_oid_deta_ofer )) 	");*/
      
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
          rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.existenProductosRecogibles (DTOAtencionReclamoREC dtoE):Salida");
      if(rs==null||rs.esVacio()){
           return null;
      }else{
          if(rs.getValueAt(0,0)!=null){
            return Long.valueOf(rs.getValueAt(0,0).toString());    
          }else{
            return null;
          }
          
      }
      
  }
  
  // vbongiov -- SiCC 20090852 -- 6/03/2009
  public int obtenerDecimalesMonedaPais(Long oidPais) throws MareException{
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDecimalesMonedaPais(Long oidPais):Entrada");
      StringBuffer sql = new StringBuffer("");
      
      sql.append(" SELECT mon.NUM_DECI ");
      sql.append(" FROM SEG_PAIS pais, SEG_MONED mon ");
      sql.append(" WHERE mon.OID_MONE = pais.MONE_OID_MONE ");     
      sql.append(" AND pais.OID_PAIS = " + oidPais);      
      
      RecordSet rs = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
          rs = bs.dbService.executeStaticQuery(sql.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerDecimalesMonedaPais(Long oidPais):Salida");
      return ((BigDecimal)rs.getValueAt(0, "NUM_DECI")).intValue();         
 }   
 
 
 /**
  * Obtiene la info de una linea operacion reclamo cuyo OID recibe por parametro
  * @author dmorello
  * @since 22-sep-2009
  */
 public DTOLineaOperacion obtenerLineaOperacionReclamo(Long oidLinea) throws MareException {
     UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineaOperacionReclamo(Long oidLinea): Entrada");
     
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     String query = " SELECT * FROM rec_linea_opera_recla WHERE oid_line_oper_recl = " + oidLinea;
     
     RecordSet rs = null;
     try {
         rs = bs.dbService.executeStaticQuery(query);
     } catch (Exception e) {
         String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
     }
     
     DTOLineaOperacion dto = null;
     if (rs != null && !rs.esVacio()) {
         dto = new DTOLineaOperacion();
         dto.setAtendido(UtilidadesBD.convertirABoolean(rs.getValueAt(0, "IND_ATEN")));
         dto.setImporteAbono((BigDecimal)rs.getValueAt(0, "IMP_ABON"));
         dto.setImporteCargo((BigDecimal)rs.getValueAt(0, "IMP_CARG"));
         dto.setIndicadorEstado(UtilidadesBD.convertirACharacter(rs.getValueAt(0, "IND_ESTA")));
         dto.setIndicadorRecogible(UtilidadesBD.convertirACharacter(rs.getValueAt(0, "IND_RECO")));
         dto.setMontoPerdida((BigDecimal)rs.getValueAt(0, "IMP_MONT_PERD"));
         dto.setMotivoDesbloqueo(UtilidadesBD.convertirALong(rs.getValueAt(0, "MRDB_OID_MOTI_RECH_DESB")));
         dto.setNumLinea(UtilidadesBD.convertirAInteger(rs.getValueAt(0, "NUM_LINE")));
         dto.setOid(UtilidadesBD.convertirALong(rs.getValueAt(0, "OID_LINE_OPER_RECL")));
         dto.setOidCodProducto(UtilidadesBD.convertirALong(rs.getValueAt(0, "PROD_OID_PROD")));
         dto.setOidCodVenta(UtilidadesBD.convertirALong(rs.getValueAt(0, "MAFA_OID_MATR_FACT")));
         dto.setOidConcurso(UtilidadesBD.convertirALong(rs.getValueAt(0, "COPA_OID_PARA_GRAL")));
         dto.setOidMotivoDevolucion(UtilidadesBD.convertirALong(rs.getValueAt(0, "MODV_OID_MOTI_DEVO")));
         dto.setOidNivel(UtilidadesBD.convertirALong(rs.getValueAt(0, "PANP_OID_PARA_NIVE_PREM")));
         dto.setOidPremio(UtilidadesBD.convertirALong(rs.getValueAt(0, "LOPA_OID_LOTE_PREM_ARTI")));
         dto.setOidTipoMovimiento(UtilidadesBD.convertirALong(rs.getValueAt(0, "TIMO_OID_TIPO_MOVI")));
         dto.setOidTipoPosicion(UtilidadesBD.convertirALong(rs.getValueAt(0, "TPOS_OID_TIPO_POSI")));
         dto.setOidTipoSolicitud(UtilidadesBD.convertirALong(rs.getValueAt(0, "TSPA_OID_TIPO_SOLI_PAIS")));
         dto.setOidTpoOferta(UtilidadesBD.convertirALong(rs.getValueAt(0, "TOFE_OID_TIPO_OFER")));
         dto.setOperacion(UtilidadesBD.convertirALong(rs.getValueAt(0, "OPRE_OID_OPER_RECL")));
         dto.setPosicionReferencia(UtilidadesBD.convertirALong(rs.getValueAt(0, "SOPO_OID_SOLI_POSI")));
         dto.setPrecio((BigDecimal)rs.getValueAt(0, "VAL_PREC"));
         dto.setPrecioContable((BigDecimal)rs.getValueAt(0, "VAL_PREC_CONT"));
         dto.setPrecioPerdida(UtilidadesBD.convertirALong(rs.getValueAt(0, "PPER_OID_PREC_PERD")));
         dto.setUnidadesDevueltas(UtilidadesBD.convertirAInteger(rs.getValueAt(0, "NUM_UNID_DEVU")));
         dto.setUnidadesReclamadas(UtilidadesBD.convertirAInteger(rs.getValueAt(0, "NUM_UNID_RECL")));
     }
     
     UtilidadesLog.info("DAOCapturaProcesoReclamos.obtenerLineaOperacionReclamo(Long oidLinea):Salida");
     return dto;
 }
 
 
 /**
  * Actualiza la linea operacion reclamo cuya info, incluyendo su OID, es recibida
  * en el DTO de entrada.
  * @author dmorello
  * @since 22-sep-2009
  */
 public void actualizarLineaOperacionReclamo(DTOLineaOperacion dtoe) throws MareException {
     UtilidadesLog.info("DAOCapturaProcesoReclamos.actualizarLineaOperacionReclamo(DTOLineaOperacion dtoe): Entrada");
     
     UtilidadesLog.debug("dtoe: " + dtoe);
     
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     StringBuffer update = new StringBuffer();
     Vector params = new Vector();
     
     Integer indAtendido = null;
     String indEstado = null;
     String indRecogible = null;
     
     if (dtoe.getAtendido() != null) {
         indAtendido = Integer.valueOf( (dtoe.getAtendido().booleanValue())? 1 : 0 );
     }
     if (dtoe.getIndicadorEstado() != null) {
         indEstado = dtoe.getIndicadorEstado().toString();
     }
     if (dtoe.getIndicadorRecogible() != null) {
         indRecogible = dtoe.getIndicadorRecogible().toString();
     }
     
     update.append("UPDATE rec_linea_opera_recla SET ");

     update.append(" IND_ATEN = ?");
     params.add(indAtendido);
     update.append(",IMP_ABON = ?");
     params.add(dtoe.getImporteAbono());
     update.append(",IMP_CARG = ?");
     params.add(dtoe.getImporteCargo());
     update.append(",IND_ESTA = ?");
     params.add(indEstado);
     update.append(",IND_RECO = ?");
     params.add(indRecogible);
     update.append(",IMP_MONT_PERD = ?");
     params.add(dtoe.getMontoPerdida());
     update.append(",MRDB_OID_MOTI_RECH_DESB = ?");
     params.add(dtoe.getMotivoDesbloqueo());
     update.append(",NUM_LINE = ?");
     params.add(dtoe.getNumLinea());
     update.append(",OID_LINE_OPER_RECL = ?");
     params.add(dtoe.getOid());
     update.append(",PROD_OID_PROD = ?");
     params.add(dtoe.getOidCodProducto());
     update.append(",MAFA_OID_MATR_FACT = ?");
     params.add(dtoe.getOidCodVenta());
     update.append(",COPA_OID_PARA_GRAL = ?");
     params.add(dtoe.getOidConcurso());
     update.append(",MODV_OID_MOTI_DEVO = ?");
     params.add(dtoe.getOidMotivoDevolucion());
     update.append(",PANP_OID_PARA_NIVE_PREM = ?");
     params.add(dtoe.getOidNivel());
     update.append(",LOPA_OID_LOTE_PREM_ARTI = ?");
     params.add(dtoe.getOidPremio());
     update.append(",TIMO_OID_TIPO_MOVI = ?");
     params.add(dtoe.getOidTipoMovimiento());
     update.append(",TPOS_OID_TIPO_POSI = ?");
     params.add(dtoe.getOidTipoPosicion());
     update.append(",TSPA_OID_TIPO_SOLI_PAIS = ?");
     params.add(dtoe.getOidTipoSolicitud());
     update.append(",TOFE_OID_TIPO_OFER = ?");
     params.add(dtoe.getOidTpoOferta());
     update.append(",OPRE_OID_OPER_RECL = ?");
     params.add(dtoe.getOperacion());
     update.append(",SOPO_OID_SOLI_POSI = ?");
     params.add(dtoe.getPosicionReferencia());
     update.append(",VAL_PREC = ?");
     params.add(dtoe.getPrecio());
     update.append(",VAL_PREC_CONT = ?");
     params.add(dtoe.getPrecioContable());
     update.append(",PPER_OID_PREC_PERD = ?");
     params.add(dtoe.getPrecioPerdida());
     update.append(",NUM_UNID_DEVU = ?");
     params.add(dtoe.getUnidadesDevueltas());
     update.append(",NUM_UNID_RECL = ?");
     params.add(dtoe.getUnidadesReclamadas());
     
     update.append(" WHERE oid_line_oper_recl = ").append(dtoe.getOid());
     
     try {
         bs.dbService.executePreparedUpdate(update.toString(), params);
     } catch (Exception e) {
         String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
     }
     
     UtilidadesLog.info("DAOCapturaProcesoReclamos.actualizarLineaOperacionReclamo(DTOLineaOperacion dtoe): Salida");
 }
    
}