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
 */

package es.indra.sicc.logicanegocio.rec;

import es.indra.sicc.dtos.rec.DTOConsultarCabeceraReclamo;
import es.indra.sicc.dtos.rec.DTOValidarReclamo;
import es.indra.sicc.dtos.rec.DTOEvaluarChequeo;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

// Log
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.dtos.rec.DTOChequeoManual;
import es.indra.sicc.dtos.rec.DTOChequeoZona;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;

import javax.ejb.DuplicateKeyException;
import javax.ejb.SessionContext;

public class DAORec {

	private final static String REC_MOTIV_RECHA_DESBL = "REC_MOTIV_RECHA_DESBL";
    SessionContext ctx = null;

	public DAORec() {
	}

	public DAORec(SessionContext ctx) {
        this.ctx = ctx;
	}

	public RecordSet obtenerMotivosRechazoDesbloqueo(DTOBelcorp dto) throws MareException {

		UtilidadesLog.info("DAORec.obtenerMotivosRechazoDesbloqueo(DTOBelcorp):Entrada");
		/*
		 * Obtenemos el oid y descripcion (en el idioma indicado por el dto) de
		 * todos los registros de la tabla REC_MOTIV_RECHA_DESBL cuyo pais 
		 * coindida con el del dto.
		 */
         UtilidadesLog.info("Datos de entrada:"+dto);
		StringBuffer query = new StringBuffer();
        Vector datos = new Vector();
        query.append(" SELECT R.OID_MOTI_RECH_DESB, I.VAL_I18N AS DESCRIPCION ");
        query.append(" FROM V_GEN_I18N_SICC I ");
        query.append(" , REC_MOTIV_RECHA_DESBL R ");
        query.append(" WHERE I.ATTR_ENTI = '" + REC_MOTIV_RECHA_DESBL + "' ");
        query.append(" AND I.IDIO_OID_IDIO = ? ");
        datos.add( dto.getOidIdioma());
        query.append(" AND R.PAIS_OID_PAIS = ? ");
        datos.add( dto.getOidPais());
        query.append(" AND I.ATTR_NUM_ATRI = 1 " );
        query.append(" AND R.OID_MOTI_RECH_DESB = I.VAL_OID " );
        query.append("    ORDER BY DESCRIPCION   ");
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(query.toString(), datos);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerMotivosRechazoDesbloqueo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		UtilidadesLog.info("DAORec.obtenerMotivosRechazoDesbloqueo(DTOBelcorp):Salida");

        return resultado;
				
	}

	public RecordSet obtenerCodigosOperacion(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("DAORec.obtenerCodigosOperacion(DTOBelcorp):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        // por incidencia BELC300021340 se recupera también IND_ANUL
        /* sql.append(" SELECT OID_OPER, COD_OPER, VAL_PERD, IND_ANUL ");
        sql.append(" FROM REC_OPERA ");
        sql.append(" WHERE PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        sql.append(" ORDER BY COD_OPER ");  */
        
        /*  pperez incidencia 24268  */ 
        
        UtilidadesLog.debug(dto);
        
        sql.append(" SELECT DISTINCT op.oid_oper, op.cod_oper, op.val_perd, op.ind_anul   ");
        sql.append("            FROM REC_TIPOS_OPERA ti, REC_AUTOR au, REC_OPERA op, principals p  ");
        sql.append("           WHERE op.pais_oid_pais = ?  ");
        parametros.add(dto.getOidPais());
        sql.append("             AND au.ind_ingr = 1  ");
        sql.append("             AND au.tiop_oid_tipo_oper = ti.oid_tipo_oper  ");
        sql.append("             AND ti.rope_oid_oper = op.oid_oper  ");
        sql.append("             AND p.NAME = '" + ctx.getCallerPrincipal().getName() + "'");
        sql.append("             AND p.idprincipal = au.user_oid_user  ");
        sql.append("        ORDER BY op.cod_oper  ");


		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerCodigosOperacion: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    
        if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerCodigosOperacion: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }
        
		UtilidadesLog.info("DAORec.obtenerCodigosOperacion(DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerCodigosTipoOperacion(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAORec.obtenerCodigosTipoOperacion(DTOOID):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT OID_TIPO_OPER, VAL_TIPO_OPER ");
        sql.append(" FROM REC_TIPOS_OPERA ");
        sql.append(" WHERE ROPE_OID_OPER = ? ");
        parametros.add(dto.getOid());

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerCodigosTipoOperacion: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerCodigosTipoOperacion: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }

		UtilidadesLog.info("DAORec.obtenerCodigosTipoOperacion(DTOOID):Salida");
        return resultado;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public RecordSet obtenerTiposMovimiento(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("DAORec.obtenerTiposMovimiento(DTOBelcorp):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT OID_TIPO_MOVI, VAL_I18N ");
        sql.append(" FROM REC_TIPO_MOVIM TM, V_GEN_I18N_SICC GEN ");
        sql.append(" WHERE GEN.ATTR_ENTI = 'REC_TIPO_MOVIM' ");
        sql.append(" AND GEN.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND GEN.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND GEN.VAL_OID = TM.OID_TIPO_MOVI ");

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerTiposMovimiento: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerTiposMovimiento: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }

		UtilidadesLog.info("DAORec.obtenerTiposMovimiento(DTOBelcorp):Salida");
        return resultado;
    }
    
    /**
     * @author mmaidana
     * @date 09/06/2006
     * creado por REC-028
     */
    public RecordSet obtenerTiposMovimientoRecarga(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAORec.obtenerTiposMovimientoRecarga(DTOBelcorp):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT OID_TIPO_MOVI, VAL_I18N ");
        sql.append(" FROM REC_TIPO_MOVIM TM, V_GEN_I18N_SICC GEN ");
        sql.append(" WHERE GEN.ATTR_ENTI = 'REC_TIPO_MOVIM' ");
        sql.append(" AND GEN.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND GEN.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND GEN.VAL_OID = TM.OID_TIPO_MOVI ");

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerTiposMovimiento: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		UtilidadesLog.info("DAORec.obtenerTiposMovimientoRecarga(DTOBelcorp):Salida");
        return resultado;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public RecordSet obtenerMotivosDevolucionOperacion(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAORec.obtenerMotivosDevolucionOperacion(DTOOID):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ");
        // incidencia BELC300018736
        sql.append(" MD.OID_MOTI_DEVO OID, "); 
        sql.append(" GEN.VAL_I18N DESCRIPCION ");
        
        sql.append(" FROM ");
        sql.append(" REC_MOTIV_DEVOL_OPERA MDO, ");
        sql.append(" REC_MOTIV_DEVOL MD, ");
        sql.append(" V_GEN_I18N_SICC GEN ");
        
        sql.append(" WHERE ");
        sql.append(" MDO.ROPE_OID_OPER = ? ");
        parametros.add(dto.getOid());
        sql.append(" AND MDO.PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        sql.append(" AND MDO.MODV_OID_MOTI_DEVO = MD.OID_MOTI_DEVO ");
        sql.append(" AND MD.OID_MOTI_DEVO = GEN.VAL_OID "); 
        sql.append(" AND GEN.ATTR_ENTI = 'REC_MOTIV_DEVOL' "); 
        sql.append(" AND GEN.ATTR_NUM_ATRI = 1 "); 
        sql.append(" AND GEN.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" ORDER BY MDO.VAL_MARC_DEFE DESC ");

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerMotivosDevolucionOperacion: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerMotivosDevolucionOperacion: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }

		UtilidadesLog.info("DAORec.obtenerMotivosDevolucionOperacion(DTOOID):Salida");
        return resultado;
    }    
    
    /**
     * @author mmaidana
     * @date 09/06/2006
     * creado por REC-028
     */
    public RecordSet obtenerMotivosDevolucionOperacionRecarga(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAORec.obtenerMotivosDevolucionOperacionRecarga(DTOOID):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ");
        // incidencia BELC300018736
        sql.append(" MD.OID_MOTI_DEVO OID, "); 
        sql.append(" GEN.VAL_I18N DESCRIPCION ");
        
        sql.append(" FROM ");
        sql.append(" REC_MOTIV_DEVOL_OPERA MDO, ");
        sql.append(" REC_MOTIV_DEVOL MD, ");
        sql.append(" V_GEN_I18N_SICC GEN ");
        
        sql.append(" WHERE ");
        sql.append(" MDO.ROPE_OID_OPER = ? ");
        parametros.add(dto.getOid());
        sql.append(" AND MDO.PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        sql.append(" AND MDO.MODV_OID_MOTI_DEVO = MD.OID_MOTI_DEVO ");
        sql.append(" AND MD.OID_MOTI_DEVO = GEN.VAL_OID "); 
        sql.append(" AND GEN.ATTR_ENTI = 'REC_MOTIV_DEVOL' "); 
        sql.append(" AND GEN.ATTR_NUM_ATRI = 1 "); 
        sql.append(" AND GEN.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" ORDER BY MDO.VAL_MARC_DEFE DESC ");

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerMotivosDevolucionOperacion: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		UtilidadesLog.info("DAORec.obtenerMotivosDevolucionOperacionRecarga(DTOOID):Salida");
        return resultado;
    }    
    
    // Consulta modificada por la BELC300014868
    public RecordSet obtenerCabeceraReclamoDigitado(Long oidReclamo) throws MareException {
		UtilidadesLog.info("DAORec.obtenerCabeceraReclamoDigitado(Long):Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ");
        sql.append(" RD.OID_CABE_RECL_DIGI OID_RECLAMO, ");
        sql.append(" PA.COD_PAIS PAIS, ");
        sql.append(" RD.NUM_RECL NUMERO_RECLAMO, ");
        sql.append(" RD.TIIN_OID_TIPO_INGR TIPO_INGRESO, ");
        sql.append(" RD.COD_USUA USUARIO_INGRESO, ");
        sql.append(" RD.FEC_INGR FECHA_INGRESO, ");
        //REC-08 Incidencia  BELC300021854
        //mamontie 25/11/05
        sql.append(" RD.COD_CLIE COD_CLIEN_REC, ");
        sql.append(" CL.COD_CLIE COD_CLIEN_MAE, ");                        
        sql.append(" SC.OID_SOLI_CABE OID_DOCUMENTO, ");
        sql.append(" PE.MARC_OID_MARC OID_MARCA, ");
        sql.append(" CA.COD_CANA COD_CANAL, ");
        sql.append(" CA.OID_CANA OID_CANAL, ");
        sql.append(" AC.COD_ACCE COD_ACCESO, ");
        sql.append(" AC.OID_ACCE OID_ACCESO, ");
        sql.append(" SB.COD_SBAC COD_SUBACCESO, ");
        sql.append(" SB.OID_SBAC OID_SUBACCESO, ");
        sql.append(" SC.FEC_CRON FECHA_EMISION, ");
        sql.append(" SC.CLIE_OID_CLIE OID_CLIENTE, ");
        sql.append(" SC.SBTI_OID_SUBT_CLIE OID_SUBTIPO_CLIENTE, ");
        sql.append(" SC.TICL_OID_TIPO_CLIE OID_TIPO_CLIENTE, ");
        sql.append(" SC.ZTAD_OID_TERR_ADMI OID_TERRITORIO_ADM, ");
        sql.append(" SC.PERD_OID_PERI OID_PERIODO_SOLICITUD, ");
        sql.append(" SC.TIDO_OID_TIPO_DOCU OID_TIPO_DOCUMENTO_LEGAL, ");
        sql.append(" SC.RECQ_OID_RESU_CHEQ OID_RESULTADO_CHEQUEO, ");
        sql.append(" SC.COPA_OID_PARA_GENE OID_CONCURSO_PARAMETROS, ");
        sql.append(" TS.IND_SOLI_NEGA IND_SOLICITUD_NEGATIVA "); //BELC300021984
        
        sql.append(" FROM ");
        sql.append(" PED_SOLIC_CABEC SC, ");
        sql.append(" MAE_CLIEN CL, ");
        sql.append(" SEG_CANAL CA, ");
        sql.append(" SEG_ACCES AC, ");
        sql.append(" SEG_SUBAC SB, ");
        sql.append(" REC_CABEC_RECLA_DIGIT RD, ");
        sql.append(" SEG_PAIS PA, ");
        sql.append(" CRA_PERIO PE, ");
        sql.append(" PED_TIPO_SOLIC TS, "); //BELC300021984
        sql.append(" PED_TIPO_SOLIC_PAIS TSP "); //BELC300021984
        
        sql.append(" WHERE ");
        sql.append(" RD.OID_CABE_RECL_DIGI = ? AND ");
        parametros.add(oidReclamo);
        sql.append(" SC.PAIS_OID_PAIS = RD.PAIS_OID_PAIS AND ");
        sql.append(" PA.OID_PAIS = RD.PAIS_OID_PAIS AND ");
        sql.append(" SC.VAL_NUME_SOLI = RD.NUM_DOCU_REFE AND ");       
        sql.append(" SC.CLIE_OID_CLIE = CL.OID_CLIE AND ");
         //Se elimina la linea por Incidencia REC-08 BELC300021854 
        //mamontie 25/11/05
        //sql.append(" CL.COD_CLIE = RD.COD_CLIE AND ");
        sql.append(" CL.PAIS_OID_PAIS = SC.PAIS_OID_PAIS AND ");
        sql.append(" (SC.IND_TS_NO_CONSO = 0 OR SC.IND_TS_NO_CONSO IS NULL) AND ");
        sql.append(" SC.ESSO_OID_ESTA_SOLI = ? AND ");
        parametros.add(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        sql.append(" SC.SBAC_OID_SBAC = SB.OID_SBAC AND ");
        sql.append(" AC.OID_ACCE = SB.ACCE_OID_ACCE AND ");
        sql.append(" CA.OID_CANA = AC.CANA_OID_CANA AND ");
        sql.append(" PE.OID_PERI = SC.PERD_OID_PERI AND");
        sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND ");
        sql.append(" TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        
        sql.append(" ORDER BY SB.COD_SBAC  ");

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerCabeceraReclamoDigitado: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
     /*if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerCabeceraReclamoDigitado: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }
        mamontie 28/11/05 
        Incidencia DBLG400000522	BELC300021324
        Se comenta esta validacion, porque no permitia pasar por el metodo de MonvalidarReclamos.validarDocumentoReferencia()        
        */
		UtilidadesLog.info("DAORec.obtenerCabeceraReclamoDigitado(Long):Salida");
        return resultado;
    }
    
    public RecordSet obtenerReclamosDigitados (Long oidPais) throws MareException { 
        UtilidadesLog.info("DAORec.obtenerReclamosDigitados(Long):Entrada");

        // Obtiene los reclamos en estado digitado para el pais recibido
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
    
        sql.append("	SELECT  ");  
        sql.append("	RD.OID_CABE_RECL_DIGI OID_RECLAMO,  "); 
        sql.append("	RD.COD_CLIE COD_CLIENTE,    "); 
        sql.append("	RD.NUM_DOCU_REFE DOC_REFERENCIA "); 	
        sql.append("	FROM    "); 
        sql.append("	REC_CABEC_RECLA_DIGIT RD    "); 		
        sql.append("	WHERE   "); 
        sql.append("	RD.PAIS_OID_PAIS = ?    ");
        parametros.add(oidPais);
        // modificacion a la espera de que validen incidencia BELC300018721 
        sql.append("	AND RD.ESRE_OID_ESTA_RECL = ?");
        parametros.add(ConstantesREC.ESTADO_RECLAMO_DIGITADO);
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerReclamosDigitados: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
      //jrivas REC041 Bloqueante 05/09/05
       /* if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerReclamosDigitados: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }
    */
        UtilidadesLog.info("DAORec.obtenerReclamosDigitados(Long):Salida");
        return resultado;
        
    }
    
    public RecordSet obtenerOperacionesReclamoDigitado (Long oidReclamo) throws MareException {    
        UtilidadesLog.info("DAORec.obtenerOperacionesReclamoDigitado(Long):Entrada");
        
        // Obtiene las operaciones de un reclamo digitado 
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        //Modificada consulta por incidencia 18492
        sql.append("    SELECT  "); 
        sql.append("    ORD.OID_OPER_RECL_DIGI OID_OPERACION,   "); 
        sql.append("    ORD.NUM_OPER_RECL_DIGI NUMERO_OPERACION,    "); 
        sql.append("    ORD.RCDG_OID_CABE_RECL_DIGI OID_RECLAMO,    "); 
        sql.append("    OP.IND_ANUL IND_ANULACION,  "); 
        sql.append("    OP.VAL_PERD IND_PERDIDA,    "); 
        sql.append("    OP.PENV_OID_PRECIO_ENVIA OID_PRECIO_ENVIA,  "); 
        sql.append("    OP.IND_DEVU_FISI_FACT DEVUELVE_FISICO_FACTURA,  "); 
        sql.append("    TOP.MOBL_OID_BLOQ_UNID OID_BLOQUEO_UNIDADES,  "); 
        sql.append("    TOP.MOBL_OID_BLOQ_IMPO OID_BLOQUEO_IMPORTE,  ");
        sql.append("    TOP.MOBL_OID_BLOQ_DIFE OID_BLOQUEO_DIFERENCIA, ");
        sql.append("    TOP.MOBL_OID_RECL_ANTE OID_BLOQUEO_ANTERIOR, ");
        sql.append("    OP.MOBL_OID_MOTI_BLOQ OID_MOTIVO_BLOQUEO,   "); 
        sql.append("    TOP.OID_TIPO_OPER OID_TIPO_OPERACION,   "); 
        sql.append("    TOP.IND_DEVU_ESTA_FACT DEVUELVE_EN_FACTURA, "); 
        sql.append("    TOP.IND_ENVI_ESTA_FACT ENVIA_EN_FACTURA,    "); 
        sql.append("    ORD.ASPE_OID_ASUM_PERD OID_ASUME_PERDIDA,   "); 
        sql.append("    CL.OID_CLIE OID_RESPONSABLE_PERDIDA,    "); 
        sql.append("    CL2.OID_CLIE OID_CLIENTE_SEGURO,    "); 
        sql.append("    PR.OID_PROD OID_ARTICULO,   "); 
        sql.append("    ORD.IMP_MONT_ARTI MONTO_ARTICULO,   "); 
        sql.append("    PNM.PPER_OID_PREC_PERD OID_PRECIO_PERDIDA,  "); 
        sql.append("    PNM.VAL_PORC_RECA PORCENTAJE_PERDIDA,    ");
        sql.append("    OP.IND_ENVI_GENE_DEVU ENVIA_GENERA_DEVUELVE, "); // BELC300019154 
        sql.append("    OP.IND_DEVU_GENE_ENVI DEVUELVE_GENERA_ENVIA, "); // BELC300019154
        sql.append("    OP.PECI_OID_PECI OID_PRECIO, "); // BELC300015177
        sql.append("    OP.COD_OPER  COD_OPERACION,   "); //añadido por incidencia 22963 mamontie 05/04/06
        // COL-REC-001
        sql.append("    OP.IND_RECO, ");
        sql.append("    OP.TSPA_OID_TIPO_SOLI_REC_INIC, OP.TSPA_OID_TIPO_SOLI_PRI_NO_EXIT, ");
        sql.append("    OP.TSPA_OID_SOLI_PAIS_SEG_NO_EXIT, OP.TMAL_OID_TIPO_ALMA_REC_INIC, ");
        sql.append("    OP.TMAL_OID_TIPO_ALMA_REC_EXIT, OP.TMAL_OID_TIPO_ALMA_REC_NO_EXIT, ");
        sql.append("    OP.ALMC_OID_ALMA_POSV ");
        // COL-REC-001 fin
        
        sql.append("    FROM    "); 
        sql.append("    REC_OPERA_RECLA_DIGIT ORD,  "); 
        sql.append("    REC_TIPOS_OPERA TOP,    "); 
        sql.append("    REC_OPERA OP,   "); 
        sql.append("    MAE_CLIEN CL,   "); 
        sql.append("    MAE_CLIEN CL2,  "); 
        sql.append("    REC_CABEC_RECLA_DIGIT CRD,  "); 
        sql.append("    MAE_PRODU PR,   "); 
        sql.append("    REC_PARAM_NMPER PNM,    "); 
        sql.append("    MAE_CLIEN_TIPO_SUBTI CTS    "); 
        sql.append("    WHERE   ");   
        sql.append("    ORD.RCDG_OID_CABE_RECL_DIGI = ? AND "); 
        parametros.add(oidReclamo);
        
        // incidencia BELC300018492
        sql.append("    ORD.RCDG_OID_CABE_RECL_DIGI = CRD.OID_CABE_RECL_DIGI AND ");
               
        //  INDICADOR ANULACION 
        sql.append("    ORD.TIOP_OID_TIPO_OPER = TOP.OID_TIPO_OPER  AND "); 
        sql.append("    TOP.ROPE_OID_OPER = OP.OID_OPER AND "); 
        
        //  RESPONSABLE PERDIDA 
        sql.append("    ORD.VAL_RESP_PERD = CL.COD_CLIE (+) AND "); 
        sql.append("    (CRD.PAIS_OID_PAIS = CL.PAIS_OID_PAIS OR CL.PAIS_OID_PAIS IS NULL) AND  "); 
        //eliminada por incidencia 18492
        //sql.append("    CRD.OID_CABE_RECL_DIGI = ORD.RCDG_OID_CABE_RECL_DIGI AND    "); 
        
        //  CLIENTE SEGURO 
        sql.append("    ORD.VAL_CLIE_SEGU = CL2.COD_CLIE (+) AND    "); 
        sql.append("    (CRD.PAIS_OID_PAIS = CL2.PAIS_OID_PAIS OR CL2.PAIS_OID_PAIS IS NULL) AND    "); 
        //eliminada por incidencia 18492
        //sql.append("    CRD.OID_CABE_RECL_DIGI = ORD.RCDG_OID_CABE_RECL_DIGI AND   "); 
        
        //  ARTICULO
        //modificado por inc 18492
        sql.append("    ORD.COD_ARTI = PR.COD_SAP(+) AND   ");
        sql.append("    (CRD.PAIS_OID_PAIS = PR.PAIS_OID_PAIS OR PR.PAIS_OID_PAIS IS NULL) AND    "); 
        
        // PRECIO PERDIDA 
        //modificado por inc 18492
        sql.append("    CTS.CLIE_OID_CLIE(+) = CL.OID_CLIE AND ");
        sql.append("    CTS.TICL_OID_TIPO_CLIE = PNM.TICL_OID_TIPO_CLIE(+) AND "); 
        sql.append("    CTS.IND_PPAL(+) = 1 AND    "); 
        sql.append("    (PNM.PAIS_OID_PAIS = CL.PAIS_OID_PAIS OR CL.PAIS_OID_PAIS IS NULL)    ");
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerOperacionesReclamoDigitado: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        /*if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerOperacionesReclamoDigitado: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }*/

        UtilidadesLog.info("DAORec.obtenerOperacionesReclamoDigitado(Long):Salida");
        return resultado;
    }
    
    // Consulta modificada por la BELC300014902   
    public RecordSet obtenerLineasOperacion (Long oidOperacion, Long oidSolicitud) throws MareException {    
        UtilidadesLog.info("DAORec.obtenerLineasOperacion(Long, Long):Entrada");
        
        // Recupera los datos de las lineas digitadas para la operación recibida 
        // Si el código de venta digitado se encuentra en la solicitud recibida, 
        // obtenemos además, información de la posición de solicitud correspondiente 

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append("    SELECT  ");                                                                                                                                                     
        sql.append("    LOD.OID_LINE_OPER_RECL_DIGI OID_LINEA_OPERACION,    ");                                                                                                           
        sql.append("    LOD.NUM_LINE NUMERO_LINEA,  ");                                                                                                                                 
        sql.append("    LOD.RODG_OID_OPER_RECL_DIGI OID_OPERACION,  ");                                                                                                                 
        sql.append("    LOD.COD_VENT CODIGO_VENTA,  ");                                                                                                                                 
        sql.append("    LOD.NUM_UNID_RECL UNIDADES_RECLAMADAS,  ");                                                                                                                     
        sql.append("    LOD.NUM_UNID_DEVU UNIDADES_DEVUELTAS,   ");                                                                                                                      
        sql.append("    LOD.TIMO_OID_TIPO_MOVI OID_TIPO_MOVIMIENTO, ");                                                                                                                
        sql.append("    LOD.MODV_OID_MOTI_DEVO OID_MOTIVO_DEVOLUCION,  ");  // script 912 BBDD                                                                                                     
        sql.append("    SP.PROD_OID_PROD OID_PRODUCTO,  ");                                                                                                                             
        sql.append("    OD.TOFE_OID_TIPO_OFER OID_TIPO_OFERTA,  ");                                                                   
        sql.append("    SP.VAL_PREC_CATA_UNIT_LOCA PRECIO_CATALOGO_UNITARIO_LOCAL,  ");                                               
        sql.append("    SP.VAL_IMPO_DESC_UNIT_LOCA DESCUENTO_UNITARIO_LOCAL, ");                                                                                                                                                           
        sql.append("    MF.OID_MATR_FACT OID_MF, "); //inc. 14902 
        sql.append("    sp.OID_SOLI_POSI ");//inc. 22743
        sql.append("    FROM    ");                                                                                                     
        sql.append("    REC_LINEA_OPERA_RECLA_DIGIT LOD,    ");                                                                         
        sql.append("    PED_SOLIC_POSIC SP, ");                                                                                      
        sql.append("    PRE_OFERT_DETAL OD,  ");                                                                                                                                                                                              
        sql.append("    PRE_MATRI_FACTU MF, "); //inc. 14902
        sql.append("    PED_SOLIC_CABEC SC ");  //inc. 19158
        sql.append("    WHERE   ");
        //  OPERACION 
        sql.append("    LOD.RODG_OID_OPER_RECL_DIGI = ? AND  ");
        parametros.add(oidOperacion);
        //  POSICION SOLICITUD 
        // (Hacemos outer join porque el código de venta 
        //  puede no encontrase en la solicitud) 
        /*sql.append("    SP.VAL_CODI_VENT  = LOD.COD_VENT AND ");COMENTADO POR  INC REC-19  */
        sql.append("            DECODE ((SELECT precio.OID_prec ");
        sql.append("                        FROM rec_preci precio, ");
        sql.append("                             rec_opera_recla_digit opdigit, ");
        sql.append("                             rec_opera oper, ");
        sql.append("                             rec_tipos_opera tipo ");
        sql.append("                       WHERE opdigit.oid_oper_recl_digi = ? ");
        parametros.add(oidOperacion);
        sql.append("                         AND tipo.oid_tipo_oper = opdigit.tiop_oid_tipo_oper ");
        sql.append("                         AND tipo.rope_oid_oper = oper.oid_oper ");
        sql.append("                         AND precio.oid_prec = oper.peci_oid_peci), ");
        sql.append("'" + ConstantesREC.PRECIO_PRECIOS + "' , sp.val_codi_vent, ");
        sql.append("                     sp.val_codi_vent_fict ");
        sql.append("                    ) = lod.cod_vent AND ");
        // BELC300019158
        sql.append("    SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND    "); // esta estaba sin comentar
        sql.append("    SC.SOCA_OID_SOLI_CABE = ? AND    "); // esta estaba sin comentar
        parametros.add(oidSolicitud);

        //  TIPO OFERTA (Hacemos outer join porque el código de venta 
        //  puede no encontrase en la solicitud) 
        sql.append("    SP.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+) AND ");
        sql.append("    MF.OFDE_OID_DETA_OFER(+) = OD.OID_DETA_OFER "); //inc. 14902
        sql.append(" ORDER BY LOD.OID_LINE_OPER_RECL_DIGI ");
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerLineasOperacion: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        /*if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerLineasOperacion: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }*/
    
        UtilidadesLog.info("DAORec.obtenerLineasOperacion(Long, Long):Salida");
        return resultado;
    }
     
   
    
    public RecordSet obtenerSaldoPagarReclamo (Long oidReclamo) throws MareException {
        UtilidadesLog.info("DAORec.obtenerSaldoPagarReclamo(Long):Entrada");
        
        // Calcula el saldo a pagar del reclamo recibido 
        // Se hace un sumatorio del campo importe cargo para todas las lineas del reclamo 
        // Se hace un sumatorio del campo importe abono para todas las lineas del reclamo 
        // El saldo a pagar será la diferencia entre importe cargo e importe abono 
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append("    SELECT  ");                                       
        sql.append("    SUM(LR.IMP_CARG) IMPORTE_CARGO, ");              
        sql.append("    SUM(LR.IMP_ABON) IMPORTE_ABONO, ");              
        sql.append("    (SUM(LR.IMP_CARG)-SUM(LR.IMP_ABON)) SALDO_PAG   ");                                                 
        sql.append("    FROM    ");                                         
        sql.append("    REC_LINEA_OPERA_RECLA LR,   ");                    
        sql.append("    REC_OPERA_RECLA ORE ");                                                                       
        sql.append("    WHERE   ");
        //  RECLAMO 
        sql.append("    LR.OPRE_OID_OPER_RECL = ORE.OID_OPER_RECL AND   ");
        sql.append("    ORE.CARE_OID_CABE_RECL = ? "); 
        parametros.add(oidReclamo);
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerSaldoPagarReclamo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerSaldoPagarReclamo: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("DAORec.obtenerSaldoPagarReclamo(Long):Salida");
        return resultado;
    }
    
    public RecordSet obtenerLineasMovimientoAlmacen  (DTOValidarReclamo reclamo) throws MareException {
        UtilidadesLog.info("DAORec.obtenerLineasMovimientoAlmacen(Long):Entrada");
        
        // Obtiene las lineas del reclamo que cumplan: 
        // - Tipo movimiento: Devuelve 
        // - Unidades devueltas <> 0 
        // Para cada linea, además, obtiene el almacén y 
        //  tipo de movimiento de almacén correspondiente, 
        //  accediendo a la entidad Operacion con el tipo de 
        //  operación al que pertenece la linea
        Boolean recojo = Boolean.FALSE;
        
        if(reclamo.getNumeroRecojo()!=null &&
            reclamo.getNumeroRecojo().equals(ConstantesREC.RECOJO_INICIAL)){
          recojo = Boolean.TRUE;
        }
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();

        sql.append("	SELECT LO.PROD_OID_PROD OID_PRODUCTO, LO.TOFE_OID_TIPO_OFER OID_TIPO_OFERTA, ");
        sql.append("	       LO.NUM_UNID_DEVU UNIDADES_DEVUELTAS, OP.ALMC_OID_ALMA OID_ALMACEN, ");
        sql.append("	       OP.TMAL_OID_TIPO_MOVI_ALMA OID_TIPO_MOVIMIENTO_ALMACEN, ");
        sql.append("	       OP.ALMC_OID_ALMA_POSV, OP.TMAL_OID_TIPO_ALMA_REC_INIC, OP.IND_RECO ");
        sql.append("	  FROM REC_LINEA_OPERA_RECLA LO, ");
        sql.append("	       REC_OPERA_RECLA ORE, ");
        sql.append("	       REC_TIPOS_OPERA TOP, ");
        if(recojo.booleanValue()){
            sql.append("	       INC_ARTIC_LOTE AL, ");
        }
        sql.append("	       REC_OPERA OP ");
        sql.append("	 WHERE ORE.CARE_OID_CABE_RECL = ? AND ");
        parametros.add(reclamo.getOidReclamo());
        sql.append("	       ORE.OID_OPER_RECL = LO.OPRE_OID_OPER_RECL ");
        sql.append("	   AND LO.NUM_UNID_DEVU <> 0 ");
        sql.append("	   AND LO.TIMO_OID_TIPO_MOVI = " + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE  );
        sql.append("	   AND TOP.ROPE_OID_OPER = OP.OID_OPER ");
        sql.append("	   AND ORE.TIOP_OID_TIPO_OPER = TOP.OID_TIPO_OPER ");
        if(recojo.booleanValue()){
            sql.append("	   AND LO.LOPA_OID_LOTE_PREM_ARTI = AL.LOPA_OID_LOTE_PREM_ARTI ");
            sql.append("	   AND AL.OID_ARTI_LOTE NOT IN (SELECT NVL (PNR.ARLO_OID_ARTI_LOTE, 0) ");
            sql.append("	                                  FROM REC_PRODU_NO_RECOG PNR) ");
            sql.append("	UNION ");
            sql.append("	SELECT LO.PROD_OID_PROD OID_PRODUCTO, LO.TOFE_OID_TIPO_OFER OID_TIPO_OFERTA, ");
            sql.append("	       LO.NUM_UNID_DEVU UNIDADES_DEVUELTAS, OP.ALMC_OID_ALMA OID_ALMACEN, ");
            sql.append("	       OP.TMAL_OID_TIPO_MOVI_ALMA OID_TIPO_MOVIMIENTO_ALMACEN, ");
            sql.append("	       OP.ALMC_OID_ALMA_POSV, OP.TMAL_OID_TIPO_ALMA_REC_INIC, OP.IND_RECO ");
            sql.append("	  FROM REC_LINEA_OPERA_RECLA LO, ");
            sql.append("	       REC_OPERA_RECLA ORE, ");
            sql.append("	       REC_TIPOS_OPERA TOP, ");
            sql.append("	       PRE_MATRI_FACTU PMF, ");
            sql.append("	       REC_OPERA OP ");
            sql.append("	 WHERE ORE.CARE_OID_CABE_RECL = ? AND ");
            parametros.add(reclamo.getOidReclamo());
            sql.append("	       ORE.OID_OPER_RECL = LO.OPRE_OID_OPER_RECL ");
            sql.append("	   AND LO.NUM_UNID_DEVU <> 0 ");
            sql.append("	   AND LO.TIMO_OID_TIPO_MOVI = " + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE );
            sql.append("	   AND TOP.ROPE_OID_OPER = OP.OID_OPER ");
            sql.append("	   AND ORE.TIOP_OID_TIPO_OPER = TOP.OID_TIPO_OPER ");
            sql.append("	   AND PMF.OID_MATR_FACT = LO.MAFA_OID_MATR_FACT ");
            sql.append("	   AND PMF.OFDE_OID_DETA_OFER NOT IN (SELECT NVL (PNR.OFDE_OID_DETA_OFER, 0) ");
            sql.append("	                                        FROM REC_PRODU_NO_RECOG PNR) ");
        }
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerLineasMovimientoAlmacen: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        /*if(resultado.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "DAORec.obtenerLineasMovimientoAlmacen: no hay datos.";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }*/

        UtilidadesLog.info("DAORec.obtenerLineasMovimientoAlmacen(Long):Salida");
        return resultado;
    }
    
    public RecordSet obtenerOperacionesSolicitud(Long oidSolicitud) throws MareException{
        UtilidadesLog.info("DAORec.obtenerOperacionesSolicitud(Long):Entrada");
        
        // Obtiene las operaciones de reclamo con estado enviado para la solicitud recibida 
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT OPR.OID_OPER_RECL OID, OPR.CARE_OID_CABE_RECL OID_RECLAMO ");
        
        sql.append(" FROM REC_OPERA_RECLA OPR, REC_SOLIC_OPERA SO  ");
        
        sql.append(" WHERE SO.OPRE_OID_OPER_RECL = OPR.OID_OPER_RECL ");
        sql.append(" AND SO.SOCA_OID_SOLI_CABE =  ? ");  //oidSolicitud 
        parametros.add(oidSolicitud);
       // sql.append(" AND OPR.ESOP_OID_ESTA_OPER = ? ");   //ConstantesREC.ESTADO_OPERACION_ENVIADO 
       // parametros.add(ConstantesREC.ESTADO_OPERACION_ENVIADO);
        // no hace falta filtrar por estado sabiendo que solo llegan en viado e ingreados en el caso de on line
        //Devuelve resultado de la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerOperacionesSolicitud: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAORec.obtenerOperacionesSolicitud(Long):Salida");
        return resultado;
    }
    
    public RecordSet obtenerClientesChequeoLinea(Long oidPeriodo) throws MareException{

        UtilidadesLog.info("DAORec.obtenerClientesChequeoLinea(Long):Entrada");
        /* Accede a la tabla "Configuracion clientes a chequear en linea" (REC_CONFI_LINEA) 
        filtrando por el periodo recibido e indicador generado = 'N' y recupera los clientes en 
        estado activo pertenecientes a la subgerencia, region, zona y sección especificados en 
        la tabla y que tengan un número de operaciones de reclamo igual o mayor al atributo 
        ''Cantidad mínima de reclamos por chequeo' (NUM_CANT_MINI_RECL) 
        Para obtener los clientes accedemos a la tabla 'Cliente-Unidad administrativa' (MAE_CLIEN_UNIDA_ADMIN) 
        teniendo en cuenta que si no se ha especificado un valor de región, zona o 
        sección aplica a todas las que están por debajo. (por ejemplo, si se ha definido 
        una configuración con subgerencia 1 y el resto a null, se obtendrán todos los clientes 
        para dicha subgerencia de ventas, independientemente de su region, zona o sección). 
        Para calcular el número de reclamos por cliente, accedemos a la tabla 
        'Operaciones reclamo' (REC_OPERA_RECLA) agrupando por código de cliente y filtrando
         por periodo de reclamo, el cual deberá estar comprendido entre el periodo inicial 
        y fin de evaluación definidos en la configuración de clientes a chequear.
        */

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT AUX.OID_CONFIGURACION, AUX.OID_CLIENTE ");
        sql.append(" FROM (SELECT RL.OID_CONF_LINE OID_CONFIGURACION, ");
        //sql.append(" CUA.CLIE_OID_CLIE OID_CLIENTE, COUNT(ORE.CLIE_OID_CLIE) NUMERO_OPERACIONES, ");
        sql.append(" cabe.CLIE_OID_CLIE OID_CLIENTE, COUNT(cabe.CLIE_OID_CLIE) NUMERO_OPERACIONES, ");//incidencia Peru mamontie 170805
        sql.append(" RL.NUM_CANT_MINI_RECL NUMERO_MINIMO ");
        sql.append(" FROM REC_CONFI_LINEA RL, ZON_TERRI_ADMIN TA, MAE_CLIEN_UNIDA_ADMIN CUA, ");
        sql.append(" REC_CABEC_RECLA cabe, "); //incidencia Peru mamontie 170805
        sql.append(" ZON_SECCI SE, ZON_ZONA ZO, ZON_REGIO RE, REC_OPERA_RECLA ORE, CRA_PERIO PE, ");
        sql.append(" CRA_PERIO PEI, CRA_PERIO PEF ");
        sql.append(" WHERE ");
        //-- PERIODO 
        sql.append(" RL.PERD_OID_PERI = ? ");  //oidPeriodo 
        parametros.add(oidPeriodo);
        //-- GENERADO = 'N'' 
        sql.append(" AND RL.IND_GENE = 0 ");
        //-- CONSULTORAS ACTIVAS 
        sql.append(" AND  CUA.IND_ACTI = 1 AND ( ");
        //-- SECCION 
        sql.append(" (RL.ZSCC_OID_SECC = SE.OID_SECC AND ");
        sql.append(" TA.ZSCC_OID_SECC = RL.ZSCC_OID_SECC AND ");
        sql.append(" CUA.ZTAD_OID_TERR_ADMI = TA.OID_TERR_ADMI) OR ");
        //-- ZONA 
        sql.append(" (RL.ZSCC_OID_SECC IS NULL AND RL.ZZON_OID_ZONA = SE.ZZON_OID_ZONA AND ");
        sql.append(" SE.OID_SECC = TA.ZSCC_OID_SECC AND TA.OID_TERR_ADMI = CUA.ZTAD_OID_TERR_ADMI) OR ");
        //-- REGION 
        sql.append(" (RL.ZSCC_OID_SECC IS NULL AND RL.ZZON_OID_ZONA IS NULL AND RL.ZORG_OID_REGI = ZO.ZORG_OID_REGI AND ");
        sql.append(" ZO.OID_ZONA = SE.ZZON_OID_ZONA AND SE.OID_SECC = TA.ZSCC_OID_SECC AND TA.OID_TERR_ADMI = CUA.ZTAD_OID_TERR_ADMI) OR ");  
        //-- SUBGERENCIA DE VENTAS 
        sql.append(" (RL.ZSCC_OID_SECC IS NULL AND RL.ZZON_OID_ZONA IS NULL AND RL.ZORG_OID_REGI IS NULL AND ");
        sql.append(" RL.ZSGV_OID_SUBG_VENT = RE.ZSGV_OID_SUBG_VENT AND ZO.ZORG_OID_REGI = RE.OID_REGI AND ");
        sql.append(" ZO.OID_ZONA = SE.ZZON_OID_ZONA AND SE.OID_SECC = TA.ZSCC_OID_SECC AND TA.OID_TERR_ADMI = CUA.ZTAD_OID_TERR_ADMI)) AND ");
        // OPERACIONES 
        // -- CLIENTE 
        sql.append(" cabe.CLIE_OID_CLIE = CUA.CLIE_OID_CLIE AND "); //modificado cabe incidencia Peru mamontie 170805
        sql.append(" cabe.OID_CABE_RECL = ore.CARE_OID_CABE_RECL AND"); //incidencia Peru mamontie 170805
        //-- PERIODO_INICIAL <= PERIODO_RECLAMO <= PERIODO_FINAL 
        sql.append(" cabe.PERD_OID_PERI_RECL = PE.OID_PERI AND RL.PERD_OID_PERI_INIC = PEI.OID_PERI AND ");
        sql.append(" RL.PERD_OID_PERI_FINA = PEF.OID_PERI AND ");
        sql.append(" PE.FEC_INIC >= PEI.FEC_INIC AND ");
        sql.append(" PE.FEC_FINA <= PEF.FEC_FINA AND ");
        //jrivas 14/10/2005 
        //sql.append(" PE.PAIS_OID_PAIS = PEF.PAIS_OID_PAIS AND ");
        sql.append(" PE.MARC_OID_MARC = PEI.MARC_OID_MARC AND ");
        //jrivas 14/10/2005 
        //sql.append(" PE.MARC_OID_MARC = PEF.MARC_OID_MARC AND ");
        sql.append(" PE.CANA_OID_CANA = PEI.CANA_OID_CANA ");
        //jrivas 14/10/2005 
        //sql.append(" PE.CANA_OID_CANA = PEF.CANA_OID_CANA ");
        
        sql.append(" GROUP BY RL.OID_CONF_LINE, cabe.CLIE_OID_CLIE,RL.NUM_CANT_MINI_RECL) AUX "); 
        sql.append(" WHERE NUMERO_OPERACIONES >= AUX.NUMERO_MINIMO ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerClientesChequeoLinea: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        //Devuelve RecordSet con la consulta
        UtilidadesLog.info("DAORec.obtenerClientesChequeoLinea(Long):Salida");
        return resultado;
    }
    
    public RecordSet obtenerClientesChequeoCampo(Long oidPeriodo) throws MareException{

        /*Accede a la tabla "Configuracion clientes a chequear en campo" (REC_CONFI_CAMPO) 
        filtrando por el periodo recibido e indicador generado = 'N' y por cada registro 
        encontrado recupera los clientes en estado activo pertenecientes a la subgerencia, 
        region, zona y sección especificados en la tabla 'Zonas de chequeo' (REC_ZONAS_CAMPO) 
        para el registro asociado a la configuración. 

        Para obtener los clientes accedemos a la tabla 'Cliente-Unidad administrativa' (MAE_CLIEN_UNIDA_ADMIN) 
        teniendo en cuenta que si no se ha especificado un valor de región, zona o sección aplica a todas las 
        que están por debajo. (por ejemplo, si se ha definido una configuración con subgerencia 1 y el resto a null,
        se obtendrán todos los clientes para dicha subgerencia de ventas, independientemente de su region, zona o sección).   
        */
        UtilidadesLog.info("DAORec.obtenerClientesChequeoCampo(Long):Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        // Modificado por SiCC20080563 - Rafael Romero - 19/02/2007
        sql.append(" SELECT DISTINCT clua.CLIE_OID_CLIE ");
        sql.append("   FROM mae_clien_unida_admin clua, ");
        sql.append("        mae_clien_datos_adici clad, ");
        sql.append("        zon_terri_admin ta, ");
        sql.append("        zon_secci zsec, ");
        sql.append("        zon_zona zzon, ");
        sql.append("        zon_regio zreg, ");
        sql.append("        (SELECT rc.oid_conf_camp, zc.zsgv_oid_subg_vent, zc.zorg_oid_regi, ");
        sql.append("                zc.zzon_oid_zona, zc.zscc_oid_secc ");
        sql.append("           FROM rec_confi_campo rc, rec_zonas_campo zc ");
        sql.append("          WHERE zc.cccc_oid_conf_camp = rc.oid_conf_camp ");
        sql.append("            AND rc.perd_oid_peri = ? ");
        parametros.add(oidPeriodo);
        sql.append("            AND rc.ind_gene = 0) cccc ");
        sql.append("  WHERE clua.clie_oid_clie = clad.clie_oid_clie ");
        sql.append("    AND clad.ind_acti = 1 ");
        sql.append("    AND clua.ind_acti = 1 ");
        sql.append("    AND clua.perd_oid_peri_fin IS NULL ");
        sql.append("    AND clua.ztad_oid_terr_admi = ta.oid_terr_admi ");
        sql.append("    AND zsec.oid_secc = ta.zscc_oid_secc ");
        sql.append("    AND zzon.oid_zona = zsec.zzon_oid_zona ");
        sql.append("    AND zreg.oid_regi = zzon.zorg_oid_regi ");
        sql.append("    AND ta.IND_BORR = 0 ");
        sql.append("    AND zsec.IND_ACTI = 1 ");
        sql.append("    AND zsec.IND_BORR = 0 ");
        sql.append("    AND zzon.IND_ACTI = 1 ");
        sql.append("    AND zzon.IND_BORR = 0 ");
        sql.append("    AND zreg.IND_ACTI = 1 ");
        sql.append("    AND zreg.IND_BORR = 0 ");
        sql.append("    AND NVL (cccc.zsgv_oid_subg_vent, zreg.zsgv_oid_subg_vent) = zreg.zsgv_oid_subg_vent ");
        sql.append("    AND NVL (cccc.zorg_oid_regi, zzon.zorg_oid_regi) = zzon.zorg_oid_regi ");
        sql.append("    AND NVL (cccc.zzon_oid_zona, zsec.zzon_oid_zona) = zsec.zzon_oid_zona ");
        sql.append("    AND NVL (cccc.zscc_oid_secc, ta.zscc_oid_secc) = ta.zscc_oid_secc ");
        // Modificado por SiCC20080563
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerClientesChequeoCampo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        //Devuelve RecordSet con la consulta
        UtilidadesLog.info("DAORec.obtenerClientesChequeoCampo(Long):Salida");
        return resultado;
    }

    /**
     * Modificado por Incidencia Sicc20080563
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidConfiguracion
     * @modified HRCS
     * @date 26/02/2008
     */
    public RecordSet obtenerConsultorasFaltanteMercaderia(Long oidConfiguracion) throws MareException{

        /* Obtiene los clienets que tengan más operaciones de faltante de mercaderias (operaciones de
         reclamo con el indicador de faltante de mercaderia activo) entre el periodo inicial y fin de
         evaluación para la configuración recibida. 
         Para ello se accede a la tabla 'Operacion reclamo' (REC_OPERA_RECLA) agrupando por consultora 
         y filtrando por tipo de operación = pérdida y periodo reclamo o código periodo según se haya
         definido en la configuración.        
        */
        UtilidadesLog.info("DAORec.obtenerConsultorasFaltanteMercaderia(Long):Salida");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();

        sql.append(" SELECT cab.CLIE_OID_CLIE OID_CLIENTE, COUNT(DISTINCT CAB.NUM_RECL) NUMERO_OPERACIONES ");
        sql.append(" FROM REC_CONFI_CAMPO RC, REC_OPERA_RECLA ORE, REC_OPERA OP, REC_TIPOS_OPERA TOP, ");
        sql.append(" REC_CABEC_RECLA cab, ");
        sql.append(" PED_SOLIC_CABEC sc ");
        sql.append(" WHERE ");
        sql.append("ore.TIOP_OID_TIPO_OPER = top.OID_TIPO_OPER ");
        sql.append(" AND top.ROPE_OID_OPER = op.OID_OPER ");
        sql.append(" AND ore.CARE_OID_CABE_RECL = cab.OID_CABE_RECL  "); 
        sql.append(" AND op.IND_FALT_MERC = 1 ");
        sql.append(" AND op.ind_devu_fisi_fact = 1 ");
        sql.append(" AND rc.OID_CONF_CAMP = " + oidConfiguracion);
        sql.append(" AND ore.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
        sql.append("AND ( ");
        sql.append("(    rc.PERE_OID_PERI_RECL = (select oid_peri_recl from rec_perio_recla where cod_peri_recl='"+ ConstantesREC.PERIODO_RECLAMO +"')");
        sql.append(" AND ore.perd_oid_peri_recl BETWEEN rc.perd_oid_peri_inic AND rc.perd_oid_peri_fina ");
        sql.append(" ) ");
        sql.append(" OR ");
        sql.append("(    rc.PERE_OID_PERI_RECL = (select oid_peri_recl from rec_perio_recla where cod_peri_recl='"+ ConstantesREC.PERIODO_FACTURA +"')");
        sql.append(" AND sc.perd_oid_peri BETWEEN rc.perd_oid_peri_inic AND rc.perd_oid_peri_fina ");
        sql.append(") ) ");
        sql.append("GROUP BY cab.CLIE_OID_CLIE ");
        sql.append("ORDER BY NUMERO_OPERACIONES DESC, cab.CLIE_OID_CLIE ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
          resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
                UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
                
        } catch (Exception e) {
          UtilidadesLog.error("obtenerConsultorasFaltanteMercaderia: ",e);
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAORec.obtenerConsultorasFaltanteMercaderia(Long):Salida");
        return resultado;
    }

    public RecordSet obtenerPeriodosReclamo(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAORec.obtenerPeriodosReclamo(DTOBelcorp):Entrada");
        
        // Obtiene las operaciones de reclamo con estado enviado para la solicitud recibida 
        StringBuffer sql = new StringBuffer();

        /*sql.append(" SELECT PR.OID_PERI_RECL OID, PR.COD_PERI_RECL DESCRIPCION ");
        sql.append(" FROM REC_PERIO_RECLA PR  ");
        sql.append(" ORDER BY DESCRIPCION ");   */
        
        //Incidencia  22740 mamontie 29/03/06
        sql.append(" SELECT PR.OID_PERI_RECL OID, GEN.VAL_I18N DESCRIPCION ");
        sql.append(" FROM REC_PERIO_RECLA PR, V_GEN_I18N_SICC GEN ");
        sql.append(" WHERE GEN.ATTR_NUM_ATRI='1' ");
        sql.append(" AND GEN.IDIO_OID_IDIO= " + dto.getOidIdioma()); 
        sql.append(" AND GEN.ATTR_ENTI='REC_PERIO_RECLA' ");
        sql.append(" AND GEN.VAL_OID= PR.OID_PERI_RECL ");
        sql.append(" ORDER BY DESCRIPCION ");



       //Devuelve resultado de la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executeStaticQuery(sql.toString());
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerPeriodosReclamo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAORec.obtenerPeriodosReclamo(DTOBelcorp):Salida");
        return resultado;
    }


    public RecordSet obtenerZonasChequeo(Long oidConfiguracionCampo) throws MareException{
        UtilidadesLog.info("DAORec.obtenerZonasChequeo(Long):Entrada");
        
        // Obtiene las operaciones de reclamo con estado enviado para la solicitud recibida 
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();

        sql.append(" SELECT ZC.OID_ZONA_CAMP OID, ZC.COD_ZONA_CHEQ CODIGO, ");
        sql.append(" ZC.ZSGV_OID_SUBG_VENT OID_SGV, ");
        sql.append(" zsv.DES_SUBG_VENT as SGV, ");
        sql.append(" ZC.ZORG_OID_REGI as OID_REGION, ");
        sql.append(" zr.DES_REGI as REGION, ");
        sql.append(" ZC.ZZON_OID_ZONA as OID_ZONA, ");
        sql.append(" zz.DES_ZONA as ZONA, ");
        sql.append(" ZC.ZSCC_OID_SECC as OID_SECCION, ");
        sql.append(" zs.DES_SECCI as SECCION ");
        
        sql.append(" FROM REC_ZONAS_CAMPO ZC,  ");
        sql.append(" ZON_SECCI zs, ");
        sql.append(" ZON_ZONA zz, ");
        sql.append(" ZON_REGIO zr, ");
        sql.append(" ZON_SUB_GEREN_VENTA zsv ");
        sql.append(" WHERE ZC.CCCC_OID_CONF_CAMP = ? ");  
        parametros.add(oidConfiguracionCampo);
        sql.append(" AND ZC.ZSCC_OID_SECC = zs.OID_SECC (+)");
        sql.append(" AND ZC.ZZON_OID_ZONA = zz.OID_ZONA (+)");
        sql.append(" AND ZC.ZORG_OID_REGI = zr.OID_REGI (+)");
        sql.append(" AND ZC.ZSGV_OID_SUBG_VENT  = zsv.OID_subg_vent ");
        
       //Devuelve resultado de la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerZonasChequeo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAORec.obtenerZonasChequeo(Long):Salida");
        return resultado;
    }

    
    public RecordSet obtenerUnidadesOperacion(Long oidOperacion) throws MareException{
        
        // Devuelve el número de unidades reclamadas y devueltas para la operación recibida 
        
        UtilidadesLog.info("DAORec.obtenerUnidadesOperacion(Long):Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("SELECT ");
        consulta.append("SUM(LOR.NUM_UNID_RECL) UNIDADES_RECLAMADAS, ");
        consulta.append("SUM(LOR.NUM_UNID_DEVU) UNIDADES_DEVUELTAS "); 
        consulta.append("FROM ");
        consulta.append("REC_LINEA_OPERA_RECLA LOR ");
        consulta.append("WHERE  ");
        consulta.append("LOR.OPRE_OID_OPER_RECL = ?");
        parametros.add(oidOperacion);

        //Devuelve resultado de la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.debug("******** Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("DAORec.obtenerUnidadesOperacion: ", e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        UtilidadesLog.info("DAORec.obtenerUnidadesOperacion(Long):Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerImportesCargoAbonoOperacion(Long oidOperacion) throws MareException{
        
        // Devuelve la suma del campo importe cargo para todas las lineas "Devuelve" de la operación recibida 
        
        UtilidadesLog.info("DAORec.obtenerImportesCargoAbonoOperacion(Long):Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("SELECT ");
        consulta.append("SUM(LOR.IMP_CARG) IMPORTE_CARGO, ");
        consulta.append("SUM(LOR.IMP_ABON) IMPORTE_ABONO "); 
        consulta.append("FROM ");
        consulta.append("REC_LINEA_OPERA_RECLA LOR ");
        consulta.append("WHERE  ");
        consulta.append("LOR.OPRE_OID_OPER_RECL = ?");
        parametros.add(oidOperacion);
        consulta.append("AND LOR.TIMO_OID_TIPO_MOVI = ?");
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);

        //Devuelve resultado de la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.debug("******* Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("DAORec.obtenerImportesCargoAbonoOperacion: ", e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        UtilidadesLog.info("DAORec.obtenerImportesCargoAbonoOperacion(Long):Salida");
        
        return resultado;
    }

    public RecordSet obtenerReclamosAnteriores(Long oidDocumentoReferencia, Long codigoVenta, Long oidProducto, ArrayList operacionesAEliminar) throws MareException{ 
        UtilidadesLog.info("DAORec.obtenerReclamosAnteriores(Long, Long, Long):Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("SELECT LO.OID_LINE_OPER_RECL ");
        consulta.append(" FROM REC_OPERA_RECLA O, ");
        consulta.append(" REC_LINEA_OPERA_RECLA LO ");
        consulta.append(" WHERE LO.OPRE_OID_OPER_RECL = O.OID_OPER_RECL ");
        if(operacionesAEliminar!=null&& operacionesAEliminar.size()>0){
            consulta.append(" AND O.OID_OPER_RECL NOT IN ( ");
            for(int i=0 ;i<operacionesAEliminar.size();i++){
                consulta.append(" ?,");
                parametros.add(operacionesAEliminar.get(i));
            }
            consulta.deleteCharAt(consulta.length()-1);
            consulta.append(" ) ");
        }
        consulta.append(" AND O.SOCA_OID_SOLI_CABE = ? "); //oidDocumentoReferencia
        parametros.add(oidDocumentoReferencia);
        consulta.append(" AND LO.PROD_OID_PROD = ? "); //oidProducto
        parametros.add(oidProducto);
        
        if ( codigoVenta != null ){
            consulta.append(" AND LO.MAFA_OID_MATR_FACT = ?"); //codigoVenta
            parametros.add(codigoVenta);
        }
        
        //Devuelve resultado de la consulta
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.debug("******* Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("DAORec.obtenerReclamosAnteriores: ", e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        UtilidadesLog.info("DAORec.obtenerReclamosAnteriores(Long, Long, Long):Salida");
        return resultado;
    }
    
    /** 
    * Metodo obtenerComboOperaciones
    * @param DTOBelcorp dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
    public DTOSalida obtenerComboOperaciones(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAORec.obtenerComboOperaciones(DTOBelcorp):Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" select operacion.OID_OPER, operacion.VAL_DESC_LARG ");
    query.append(" from REC_OPERA operacion ");
    query.append(" where operacion.PAIS_OID_PAIS = " + dto.getOidPais());
    query.append(" order by 2 ");
        
     try {
         rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAORec.obtenerComboOperaciones(DTOBelcorp):Salida");
     return dtos;   
    
    }
    
    /** 
    * Metodo obtenerOperacionesAnulacion
    * @param DTOBelcorp dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
    public DTOSalida obtenerOperacionesAnulacion(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAORec.obtenerOperacionesAnulacion(DTOBelcorp):Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" select operacion.OID_OPER, operacion.VAL_DESC_LARG ");
    query.append(" from REC_OPERA operacion ");
    query.append(" where operacion.PAIS_OID_PAIS = " + dto.getOidPais());
    query.append(" and operacion.IND_ANUL = 1 ");
    query.append(" order by 2 ");
        
     try {
         rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAORec.obtenerOperacionesAnulacion(DTOBelcorp):Salida");
     return dtos;   
    
    }
    
    /** 
    * Metodo obtenerTipoOperacionREP
    * @param DTOBelcorp dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
    public DTOSalida obtenerTipoOperacionREP(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("DAORec.obtenerTipoOperacionREP(DTOBelcorp):Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT   topera.oid_tipo_oper, descripcion.val_i18n ");
    query.append("     FROM rec_tipos_opera topera, gen_i18n_sicc descripcion, rec_opera opera ");
    query.append(" WHERE topera.rope_oid_oper = opera.oid_oper ");
    query.append(" AND opera.pais_oid_pais = " + dto.getOidPais());
    query.append(" AND topera.oid_tipo_oper = descripcion.val_oid ");
    query.append(" AND descripcion.attr_enti = 'REC_TIPOS_OPERA' ");
    query.append(" AND descripcion.idio_oid_idio = " + dto.getOidIdioma());
    query.append(" ORDER BY 2 ");
        
     try {
         rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAORec.obtenerTipoOperacionREP(DTOBelcorp):Salida");
     return dtos;   
    
    }
    
    // creado por BELC300019827
    public Integer obtenerUsuario(DTOString dto) throws MareException
    {
        UtilidadesLog.info("DAORec.obtenerUsuario(DTOString):Entrada");
    
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
		sql.append("SELECT U.IDUSER IDUSUARIO ");
		
		sql.append("FROM ");
		sql.append("USERS U, ");
		sql.append("PRINCIPALS P, ");
		sql.append("REC_AUTOR AU ");
		
		sql.append("WHERE ");
		sql.append("AU.PAIS_OID_PAIS = ? AND ");
        parametros.add(dto.getOidPais());
		sql.append("AU.USER_OID_USER = U.IDUSER AND ");
		sql.append("U.IDUSER = P.IDPRINCIPAL AND ");
		sql.append("P.NAME = ?");
        parametros.add(dto.getCadena());

        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            
		} catch (Exception e) {
			UtilidadesLog.error("DAORec.obtenerUsuario: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        Integer idUsuario = new Integer(((BigDecimal)resultado.getValueAt(0, "IDUSUARIO")).intValue());
        
        UtilidadesLog.info("DAORec.obtenerUsuario(DTOString):Salida");
        return idUsuario;   
    }
    
    
    
    
    
    /* autor: mamontie
     * 11/05/2006  * Inc. 22744*/
        public Long obtenerImporteAbono(Long oidReclamo) throws MareException {
		UtilidadesLog.info("DAORec.obtenerImporteAbono Entrada");

        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        Long importeAbono = null;

        sql.append(" SELECT NVL(SUM(LR.IMP_ABON),0) IMPORTE_ABONO ");
        sql.append(" FROM REC_LINEA_OPERA_RECLA LR,REC_OPERA_RECLA ORE ");
        sql.append(" WHERE LR.OPRE_OID_OPER_RECL = ORE.OID_OPER_RECL AND ");
        sql.append(" ORE.CARE_OID_CABE_RECL = " + oidReclamo);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerCodigosTipoOperacion: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        if(resultado.esVacio() || resultado.getValueAt(0,0)==null) {
            return importeAbono;
        }else{
            importeAbono = new Long(((BigDecimal)resultado.getValueAt(0,0)).longValue());
        }

        UtilidadesLog.info("DAORec.obtenerImporteAbono Salida");
        return importeAbono;
    }
    
    public RecordSet obtenerCabecerasReclamoDigitado(DTOBelcorp dtoe)throws MareException {
        //Este método devuelve un agrupado de los reclamos digitados
        //según el filtro especificado. Se usa en la modificacion de reclamos digitados
        //GAcevedo.
        UtilidadesLog.info("DAORec.obtenerCabecerasReclamoDigitado (String numRec, Long numDocuRefe, String codClie, String codEsta) Entrada");        
        
        DTOConsultarCabeceraReclamo dtoCast = (DTOConsultarCabeceraReclamo)dtoe;
        String numRec= dtoCast.getNumeroReclamo();
        Long numDocuRefe= dtoCast.getNumeroDocReferencia();
        String codClie= dtoCast.getCodCliente();
        String codEsta=dtoCast.getCodigoEstado();

        
        StringBuffer buff = new StringBuffer("select count(*) cuenta, rc.esre_oid_esta_recl, re.COD_ESTA ");
        buff.append("from rec_cabec_recla_digit rc, rec_estad_recla re ");
        buff.append("where ");
        if(numRec!=null && !numRec.trim().equals("")){
            buff.append("num_recl = '"+numRec+"' AND " );    
        }
        if(numDocuRefe!=null){
            buff.append("num_docu_refe = " + numDocuRefe.toString() +" AND ");
        }
        if(codClie!=null && !codClie.trim().equals("")) {
            buff.append("cod_clie = '" + codClie +"' AND ");
        }
        if(codEsta!=null && !codEsta.trim().equals("")){
            buff.append("re.COD_ESTA = '"+codEsta+"' AND ");
        }else{//si es nulo, por defecto las digitadas
            buff.append("re.COD_ESTA = 'D' AND ");
        }
        buff.append("rc.ESRE_OID_ESTA_RECL = re.OID_ESTA_RECL ");
        buff.append("group by esre_oid_esta_recl, re.COD_ESTA");
        
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
		} catch (Exception e) {
			UtilidadesLog.error("obtenerCabecerasReclamoDigitado: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAORec.obtenerCabecerasReclamoDigitado (String numRec, Long numDocuRefe, String codClie, String codEsta) Salida");
        return resultado;
    }
    
    public RecordSet obtenerReclamosDigitados(DTOBelcorp dtoe) throws MareException   {
        UtilidadesLog.info("DAORec.obtenerReclamosDigitados (String numRec, Long numDocuRefe, String codClie, String codEsta) Entrada");        

        DTOConsultarCabeceraReclamo dtoCast = (DTOConsultarCabeceraReclamo)dtoe;
        String numRec= dtoCast.getNumeroReclamo();
        Long numDocuRefe= dtoCast.getNumeroDocReferencia();
        String codClie= dtoCast.getCodCliente();
        String codEsta=dtoCast.getCodigoEstado();

        StringBuffer buff = new StringBuffer("select * from (select 'O' tipo, to_char(ro.OID_OPER_RECL_DIGI) NUM_OPER_RECL_DIGI,");
        buff.append("to_char(r.cod_oper) cod_oper, to_char(rt.val_tipo_oper) val_tipo_oper,");
        buff.append("to_char(rt.oid_tipo_oper) oid_tipo_oper,to_char(ro.VAL_RESP_PERD) VAL_RESP_PERD,");
        buff.append("to_char(ro.ASPE_OID_ASUM_PERD) ASPE_OID_ASUM_PERD, ");
        buff.append("to_char(ro.IMP_MONT_ARTI) IMP_MONT_ARTI,to_char(ro.COD_ARTI) COD_ARTI,");
        buff.append("to_char(ro.VAL_CLIE_SEGU) VAL_CLIE_SEGU , null TIPOMOVIMIENTO ");
        buff.append("from ");
        buff.append("rec_opera_recla_digit ro, rec_tipos_opera rt, ");
        buff.append("rec_opera r, rec_cabec_recla_digit rc,  rec_estad_recla re ");
        buff.append("where ");
        buff.append("ro.TIOP_OID_TIPO_OPER = rt.oid_tipo_oper AND ");
        buff.append("rt.rope_oid_oper = r.oid_oper AND ");
        buff.append("ro.RCDG_OID_CABE_RECL_DIGI = rc.OID_CABE_RECL_DIGI ");
        buff.append("AND rc.ESRE_OID_ESTA_RECL = re.OID_ESTA_RECL ");
        if(numRec!=null && !numRec.trim().equals("")){
            buff.append(" AND num_recl = '"+numRec+"'" );    
        }
        if(numDocuRefe!=null){
            buff.append("AND num_docu_refe = " + numDocuRefe.toString() +" ");
        }
        if(codClie!=null && !codClie.trim().equals("")) {
            buff.append("AND cod_clie = '" + codClie +"' ");
        }
        if(codEsta!=null && !codEsta.trim().equals("")){
            buff.append("AND re.COD_ESTA = '"+codEsta+"' ");
        }else{//si es nulo, por defecto las digitadas
            buff.append("AND re.COD_ESTA = 'D' ");
        }
        buff.append("UNION ");
        buff.append("Select 'L' tipo, to_char(rl.NUM_LINE) NUM_LINE,  ");
        buff.append("to_char(ro.NUM_OPER_RECL_DIGI)NUM_OPER_RECL_DIGI, ");
        buff.append("to_char(rl.COD_VENT) COD_VENT,  to_char(rl.NUM_UNID_RECL) NUM_UNID_RECL, ");
        //buff.append("to_char(rd.COD_MOTI_DEVO) COD_MOTI_DEVO, ");
        buff.append("TO_CHAR (pq_apl_aux.Valor_Gen_I18n_Sicc("+dtoCast.getOidPais());
        buff.append(",(rd.COD_MOTI_DEVO),'REC_MOTIV_DEVOL')) motivoDevolucion, ");
        buff.append("to_char(rl.NUM_UNID_DEVU) NUM_UNID_DEVU, to_char(rm.COD_TIPO_MOVI) COD_TIPO_MOVI, ");
        buff.append("to_char(rl.MODV_OID_MOTI_DEVO) MODV_OID_MOTI_DEVO, ");
        buff.append("to_char(ro.OID_OPER_RECL_DIGI) NUM_OPER_RECL_DIGI, ");
        buff.append("TO_CHAR (rl.TIMO_OID_TIPO_MOVI) TIMO_OID_TIPO_MOVI ");
        buff.append("From  rec_linea_opera_recla_digit rl, rec_opera_recla_digit ro,");
        buff.append("rec_motiv_devol rd, REC_TIPO_MOVIM rm, rec_cabec_recla_digit rc , rec_estad_recla re ");
        buff.append("where rl.RODG_OID_OPER_RECL_DIGI = ro.OID_OPER_RECL_DIGI AND ");
        buff.append("rl.MODV_OID_MOTI_DEVO = rd.oid_moti_devo(+) AND ");
        buff.append("rl.TIMO_OID_TIPO_MOVI = rm.OID_TIPO_MOVI AND ");
        buff.append("ro.RCDG_OID_CABE_RECL_DIGI = rc.OID_CABE_RECL_DIGI AND ");
        buff.append("rc.ESRE_OID_ESTA_RECL = re.OID_ESTA_RECL ");
        if(numRec!=null && !numRec.trim().equals("")){
            buff.append(" AND num_recl = '"+numRec+"'" );    
        }
        if(numDocuRefe!=null){
            buff.append("AND num_docu_refe = " + numDocuRefe.toString() +" ");
        }
        if(codClie!=null && !codClie.trim().equals("")) {
            buff.append("AND cod_clie = '" + codClie +"' ");
        }
        if(codEsta!=null && !codEsta.trim().equals("")){
            buff.append("AND re.COD_ESTA = '"+codEsta+"' ");
        }else{//si es nulo, por defecto las digitadas
            buff.append("AND re.COD_ESTA = 'D' ");
        }
        buff.append(") order by tipo desc, num_oper_recl_digi asc");
        
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = BelcorpService.getInstance().dbService.executeStaticQuery(buff.toString());
		} catch (Exception e) {
			UtilidadesLog.error("obtenerReclamosDigitados: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAORec.obtenerReclamosDigitados(String numRec, Long numDocuRefe, String codClie, String codEsta) Salida");
        return resultado;
    }
    
    public void eliminaReclamosDigitados(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAORec.eliminaReclamosDigitados(DTOBelcorp dtoe): Entrada");
    
        DTOConsultarCabeceraReclamo dtoCast = (DTOConsultarCabeceraReclamo)dtoe;
        
        
        String numRec = dtoCast.getNumeroReclamo();
        Long numDocuRefe = dtoCast.getNumeroDocReferencia();
        String codClie = dtoCast.getCodCliente();
        String codEsta = dtoCast.getCodigoEstado();
        //se eliminan las lineas de operacion
        StringBuffer buff = new StringBuffer("delete rec_linea_opera_recla_digit rl	where  rl.OID_LINE_OPER_RECL_DIGI in( ");
		buff.append("select OID_LINE_OPER_RECL_DIGI	from rec_linea_opera_recla_digit rl2, rec_opera_recla_digit ro, ");
        buff.append("rec_cabec_recla_digit rc, rec_estad_recla re WHERE rl2.rodg_oid_oper_recl_digi = ro.oid_oper_recl_digi ");
        buff.append("AND ro.RCDG_OID_CABE_RECL_DIGI = rc.oid_cabe_recl_digi  AND rc.esre_oid_esta_recl = re.oid_esta_recl ");
        if(numRec!=null && !numRec.trim().equals("")){
            buff.append(" AND num_recl = '"+numRec+"'" );    
        }
        if(numDocuRefe!=null){
            buff.append("AND num_docu_refe = " + numDocuRefe.toString() +" ");
        }
        if(codClie!=null && !codClie.trim().equals("")) {
            buff.append("AND cod_clie = '" + codClie +"' ");
        }
        if(codEsta!=null && !codEsta.trim().equals("")){
            buff.append("AND re.COD_ESTA = '"+codEsta+"' ");
        }else{//si es nulo, por defecto las digitadas
            buff.append("AND re.COD_ESTA = 'D' ");
        }
        buff.append(")");
        
        UtilidadesLog.debug("Query 1: "+buff.toString());
        
		try {
			BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
		} catch (Exception e) {
			UtilidadesLog.error("eliminaReclamosDigitados1: ",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        //se eliminan las operaciones
        buff = new StringBuffer("delete rec_opera_recla_digit where OID_OPER_RECL_DIGI in( ");
        buff.append("SELECT ro2.OID_OPER_RECL_DIGI FROM rec_opera_recla_digit ro2,rec_cabec_recla_digit rc, ");
        buff.append("rec_estad_recla re WHERE ro2.RCDG_OID_CABE_RECL_DIGI = rc.oid_cabe_recl_digi ");
        buff.append("AND rc.esre_oid_esta_recl = re.oid_esta_recl ");
        if(numRec!=null && !numRec.trim().equals("")){
            buff.append(" AND num_recl = '"+numRec+"'" );    
        }
        if(numDocuRefe!=null){
            buff.append("AND num_docu_refe = " + numDocuRefe.toString() +" ");
        }
        if(codClie!=null && !codClie.trim().equals("")) {
            buff.append("AND cod_clie = '" + codClie +"' ");
        }
        if(codEsta!=null && !codEsta.trim().equals("")){
            buff.append("AND re.COD_ESTA = '"+codEsta+"' ");
        }else{//si es nulo, por defecto las digitadas
            buff.append("AND re.COD_ESTA = 'D' ");
        }
        buff.append(")");
        UtilidadesLog.debug("Query 2: "+buff.toString());
        
		try {
			BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
		} catch (Exception e) {
			UtilidadesLog.error("eliminaReclamosDigitados2: ",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        //se elimina la cabecera del reclamo
        buff = new StringBuffer("delete rec_cabec_recla_digit where OID_CABE_RECL_DIGI in(");
        buff.append(" select OID_CABE_RECL_DIGI	 from   rec_cabec_recla_digit rc,  rec_estad_recla re ");
        buff.append("where rc.esre_oid_esta_recl = re.oid_esta_recl ");
        if(numRec!=null && !numRec.trim().equals("")){
            buff.append(" AND num_recl = '"+numRec+"'" );    
        }
        if(numDocuRefe!=null){
            buff.append("AND num_docu_refe = " + numDocuRefe.toString() +" ");
        }
        if(codClie!=null && !codClie.trim().equals("")) {
            buff.append("AND cod_clie = '" + codClie +"' ");
        }
        if(codEsta!=null && !codEsta.trim().equals("")){
            buff.append("AND re.COD_ESTA = '"+codEsta+"' ");
        }else{//si es nulo, por defecto las digitadas
            buff.append("AND re.COD_ESTA = 'D' ");
        }
        buff.append(")");
        UtilidadesLog.debug("Query 3: "+buff.toString());
		try {
			BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
		} catch (Exception e) {
			UtilidadesLog.error("eliminaReclamosDigitados3: ",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        UtilidadesLog.info("DAORec.eliminaReclamosDigitados(DTOBelcorp dtoe): Salida");
        
    }
    
    public void grabarSolicitudReclamo(Long operacion, Long solicitud, Long tipoSolicitud)throws MareException{
        UtilidadesLog.info("DAORec.grabarSolicitudReclamo(Long operacion, Long solicitud, Long tipoSolicitud): Entrada");
        StringBuffer insert = new StringBuffer();
        try {
        BelcorpService bs;
        bs = BelcorpService.getInstance();
        insert.append(" INSERT INTO REC_SOLIC_OPERA ( OID_SOLI_OPER, OPRE_OID_OPER_RECL, "); 
        insert.append(" SOCA_OID_SOLI_CABE, TSPA_OID_TIPO_SOLI_PAIS  ");
        insert.append(" ) VALUES ( REC_SOOP_SEQ.nextval, "+operacion+", "+solicitud+", "+tipoSolicitud+" ) ");
        
        bs.dbService.executeUpdate(insert.toString());
		
        } catch (Exception e) {
			UtilidadesLog.error("DAORec.grabarSolicitudReclamo() ",e);
            String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}  
        UtilidadesLog.info("DAORec.grabarSolicitudReclamo(Long operacion, Long solicitud, Long tipoSolicitud): Salida");
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOSalida obtenerChequeoManual(DTOChequeoManual dtoe) throws MareException {
       UtilidadesLog.info("DAORec.obtenerChequeoManual(DTOChequeoManual dtoe): Entrada");                
       UtilidadesLog.debug("dtoe: " + dtoe);
                   
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
       
       query.append(" SELECT * FROM (SELECT ROWNUM AS OID, E.* FROM ( ");          

       query.append(" SELECT cli.COD_CLIE, ");       
       query.append(" perCorp.COD_PERI, tipoRev.VAL_DESC_TIPO_INDI_REVI ");
       query.append(" FROM REC_CLIEN_A_CHEQU cliCheq, MAE_CLIEN cli, ");
       query.append(" PED_INDIC_REVIS revis, PED_TIPO_INDIC_REVIS tipoRev, ");
       query.append(" CRA_PERIO per, SEG_PERIO_CORPO perCorp ");
       
       if(dtoe.getOidPeriodoDesde()!= null){
           query.append(" ,CRA_PERIO perD ");
       }
       
       if(dtoe.getOidPeriodoHasta()!= null){
           query.append(" ,CRA_PERIO perH "); 
       }
       
       query.append(" WHERE cliCheq.CLIE_OID_CLIE = cli.OID_CLIE ");
       query.append(" AND cliCheq.INRE_OID_INDI_REVI = revis.OID_INDI_REVI ");
       query.append(" AND revis.TIRV_OID_TIPO_INDI_REVI = tipoRev.OID_TIPO_INDI_REVI ");
       query.append(" AND cliCheq.PERD_OID_PERI = per.OID_PERI ");
       query.append(" AND per.PERI_OID_PERI = perCorp.OID_PERI ");       
       query.append(" AND cli.COD_CLIE = '" + dtoe.getCodigoCliente() + "' ");  
       
       if(dtoe.getOidTipoRevision()!= null){
           query.append(" AND cliCheq.INRE_OID_INDI_REVI = " + dtoe.getOidTipoRevision());  
       }
       
       if(dtoe.getOidPeriodoDesde()!= null){
           query.append(" AND perD.OID_PERI = " + dtoe.getOidPeriodoDesde());
           query.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS "); 
           query.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC "); 
           query.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");   
           query.append(" AND per.FEC_INIC >= perD.FEC_INIC "); 
       }
       
        if(dtoe.getOidPeriodoHasta()!= null){
            query.append(" AND perH.OID_PERI = " + dtoe.getOidPeriodoHasta());
            query.append(" AND per.PAIS_OID_PAIS = perH.PAIS_OID_PAIS "); 
            query.append(" AND per.MARC_OID_MARC = perH.MARC_OID_MARC "); 
            query.append(" AND per.CANA_OID_CANA = perH.CANA_OID_CANA ");   
            query.append(" AND per.FEC_FINA <= perH.FEC_FINA "); 
        }
        
       query.append(" ORDER BY cod_peri "); 
        
       query.append(" )E) WHERE ROWNUM < = " + dtoe.getTamanioPagina());
       query.append(" AND OID > " + dtoe.getIndicadorSituacion());
       query.append(" ORDER BY OID "); 
        
       try {
           rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
           UtilidadesLog.error("ERROR ", ex);
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }

       dtoSalida.setResultado(rs);

       UtilidadesLog.info("DAORec.obtenerChequeoManual(DTOChequeoManual dtoe): Salida");
       return dtoSalida;
          
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOChequeoManual verificarChequeoDefinidos(DTOChequeoManual dtoe) throws MareException {
        UtilidadesLog.info("DAORec.verificarChequeoDefinidos(DTOChequeoManual dtoe): Entrada");                
        UtilidadesLog.debug("dtoe: " + dtoe);
                    
        RecordSet rs = new RecordSet();
        RecordSet rs1 = new RecordSet();
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT COUNT(1) CANT ");       
        query.append(" FROM REC_CLIEN_A_CHEQU cliCheq, MAE_CLIEN cli, ");
        query.append(" CRA_PERIO per, CRA_PERIO perD ,CRA_PERIO perH ");
        query.append(" WHERE cliCheq.CLIE_OID_CLIE = cli.OID_CLIE ");
        query.append(" AND cliCheq.INRE_OID_INDI_REVI = " + dtoe.getOidTipoRevision());       
        query.append(" AND cliCheq.PERD_OID_PERI = per.OID_PERI ");
        query.append(" AND cli.COD_CLIE = '" + dtoe.getCodigoCliente() + "' ");
        query.append(" AND perD.OID_PERI = " + dtoe.getOidPeriodoDesde());
        query.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS "); 
        query.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC "); 
        query.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");         
        query.append(" AND per.FEC_INIC >= perD.FEC_INIC ");       
        query.append(" AND perH.OID_PERI = " + dtoe.getOidPeriodoHasta());
        query.append(" AND per.FEC_FINA <= perH.FEC_FINA ");
      
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        long cantidad = (new Long(((BigDecimal)rs.getValueAt(0, "CANT")).toString())).longValue();
        
        if (cantidad != 0) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC + 
                                                                                 ErroresDeNegocio.CHEQUEO_YA_DEFINIDO));
        }
        
        // Obtencion de fecha inicio de periodo desde y fecha fin de periodo hasta
        query1.append(" SELECT TO_CHAR(perD.FEC_INIC,'DD/MM/YYYY') FEC_INIC, TO_CHAR(perH.FEC_FINA,'DD/MM/YYYY') FEC_FINA ");       
        query1.append(" FROM CRA_PERIO perD ,CRA_PERIO perH ");       
        query1.append(" WHERE perD.OID_PERI = " + dtoe.getOidPeriodoDesde());   
        query1.append(" AND perH.OID_PERI = " + dtoe.getOidPeriodoHasta());
        
        try {
            rs1 = bs.dbService.executeStaticQuery(query1.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        dtoe.setFechaDesdeInicio((String)rs1.getValueAt(0, "FEC_INIC"));
        dtoe.setFechaHastaFin((String)rs1.getValueAt(0, "FEC_FINA"));

        UtilidadesLog.info("DAORec.verificarChequeoDefinidos(DTOChequeoManual dtoe): Salida");
        return dtoe;
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public RecordSet obtenerPeriodosAInsertar(Long oidPeriodoDesde, Long oidPeriodoHasta) throws MareException {
        UtilidadesLog.info("DAORec.obtenerPeriodosAInsertar(Long oidPeriodoDesde, Long oidPeriodoHasta): Entrada");                
        UtilidadesLog.debug("oidPeriodoDesde: " + oidPeriodoDesde);
        UtilidadesLog.debug("oidPeriodoHasta: " + oidPeriodoHasta);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT per.OID_PERI ");       
        query.append(" FROM CRA_PERIO per, CRA_PERIO perD ,CRA_PERIO perH ");
        query.append(" WHERE perD.OID_PERI = " + oidPeriodoDesde);
        query.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS "); 
        query.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC "); 
        query.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");   
        query.append(" AND per.FEC_INIC >= perD.FEC_INIC ");       
        query.append(" AND perH.OID_PERI = " + oidPeriodoHasta);
        query.append(" AND per.FEC_FINA <= perH.FEC_FINA ");
      
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAORec.obtenerPeriodosAInsertar(Long oidPeriodoDesde, Long oidPeriodoHasta): Salida");       
        return rs;
    }
    
     // vbongiov -- Cambio 20080756 -- 29/04/2009
     public DTOSalida obtenerChequeoLineaCampo(DTOChequeoZona dtoe) throws MareException {
       UtilidadesLog.info("DAORec.obtenerChequeoLineaCampo(DTOChequeoZona dtoe): Entrada");                
       UtilidadesLog.debug("dtoe: " + dtoe);
                   
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
       
       query.append(" SELECT * FROM (SELECT ROWNUM AS OID, E.* FROM ( ");          

       query.append(" SELECT perCorp.COD_PERI, subg.DES_SUBG_VENT, reg.DES_REGI, ");       
       query.append(" zon.DES_ZONA, sec.DES_SECCI ");    
       query.append(" FROM REC_CHEQU_UA cheqUA, ZON_SUB_GEREN_VENTA subg, ");    
       query.append(" ZON_REGIO reg, ZON_ZONA zon, ZON_SECCI sec, ");   
       query.append(" CRA_PERIO per, SEG_PERIO_CORPO perCorp, PED_TIPO_INDIC_REVIS tipoCheq ");       
       query.append(" WHERE cheqUA.PERD_OID_PERI = per.OID_PERI ");    
       query.append(" AND per.PERI_OID_PERI = perCorp.OID_PERI ");   
       query.append(" AND cheqUA.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");    
        
       if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_LINEA)){
            query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' ");    
       } else if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_CAMPO)){
            query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "' ");    
       }
       
       query.append(" AND cheqUA.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");   
       query.append(" AND subg.OID_SUBG_VENT = " + dtoe.getOidSubgerenciaVentas());       
       query.append(" AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");    
       query.append(" AND cheqUA.ZORG_OID_REGI = reg.OID_REGI ");    
       query.append(" AND reg.OID_REGI = " + dtoe.getOidRegion()); 
       query.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI ");       
       query.append(" AND cheqUA.ZZON_OID_ZONA = zon.OID_ZONA ");    
       query.append(" AND zon.OID_ZONA = " + dtoe.getOidZona()); 
       query.append(" AND cheqUA.ZSCC_OID_SECC = sec.OID_SECC(+) ");   
       
       if(dtoe.getOidSeccion()!= null){
            query.append(" AND sec.OID_SECC = " + dtoe.getOidSeccion()); 
       }
       
       query.append(" ORDER BY perCorp.COD_PERI, subg.DES_SUBG_VENT, reg.DES_REGI, ");    
       query.append(" zon.DES_ZONA, sec.DES_SECCI ");    
               
       query.append(" )E) WHERE ROWNUM < = " + dtoe.getTamanioPagina());
       query.append(" AND OID > " + dtoe.getIndicadorSituacion());
       query.append(" ORDER BY OID "); 
        
       try {
           rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
           UtilidadesLog.error("ERROR ", ex);
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }

       dtoSalida.setResultado(rs);

       UtilidadesLog.info("DAORec.obtenerChequeoLineaCampo" +
       "(DTOChequeoZona dtoe): Salida");
       return dtoSalida;
          
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOChequeoZona verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe) throws MareException {
        UtilidadesLog.info("DAORec.verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe): Entrada");                
        UtilidadesLog.debug("dtoe: " + dtoe);
                    
        RecordSet rs = new RecordSet();
        RecordSet rs1 = new RecordSet();
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT COUNT(1) CANT ");    
        query.append(" FROM REC_CHEQU_UA cheqUA, ZON_SUB_GEREN_VENTA subg, ");    
        query.append(" ZON_REGIO reg, ZON_ZONA zon, ZON_SECCI sec, ");   
        query.append(" CRA_PERIO per, CRA_PERIO perD ,CRA_PERIO perH, PED_TIPO_INDIC_REVIS tipoCheq ");       
        query.append(" WHERE cheqUA.PERD_OID_PERI = per.OID_PERI ");  
        query.append(" AND cheqUA.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");    
         
        if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_LINEA)){
             query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' ");    
        } else if(dtoe.getOidTipoRevision().equals(ConstantesREC.OID_TIPO_ORDEN_CHEQU_CAMPO)){
             query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "' ");    
        }
        
        query.append(" AND cheqUA.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");   
        query.append(" AND subg.OID_SUBG_VENT = " + dtoe.getOidSubgerenciaVentas());       
        query.append(" AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");    
        query.append(" AND cheqUA.ZORG_OID_REGI = reg.OID_REGI ");    
        query.append(" AND reg.OID_REGI = " + dtoe.getOidRegion()); 
        query.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI ");       
        query.append(" AND cheqUA.ZZON_OID_ZONA = zon.OID_ZONA ");    
        query.append(" AND zon.OID_ZONA = " + dtoe.getOidZona()); 
        query.append(" AND cheqUA.ZSCC_OID_SECC = sec.OID_SECC(+) ");   
        
        if(dtoe.getOidSeccion()!= null){
             query.append(" AND sec.OID_SECC = " + dtoe.getOidSeccion()); 
        }
        
        query.append(" AND perD.OID_PERI = " + dtoe.getOidPeriodoDesde());
        query.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS "); 
        query.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC "); 
        query.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");         
        query.append(" AND per.FEC_INIC >= perD.FEC_INIC ");       
        query.append(" AND perH.OID_PERI = " + dtoe.getOidPeriodoHasta());
        query.append(" AND per.FEC_FINA <= perH.FEC_FINA ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        long cantidad = (new Long(((BigDecimal)rs.getValueAt(0, "CANT")).toString())).longValue();
        
        if (cantidad != 0) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC + 
                                                                                 ErroresDeNegocio.CHEQUEO_YA_DEFINIDO));
        }
        
        // Obtencion de fecha inicio de periodo desde y fecha fin de periodo hasta
        query1.append(" SELECT TO_CHAR(perD.FEC_INIC,'DD/MM/YYYY') FEC_INIC, TO_CHAR(perH.FEC_FINA,'DD/MM/YYYY') FEC_FINA ");       
        query1.append(" FROM CRA_PERIO perD ,CRA_PERIO perH ");       
        query1.append(" WHERE perD.OID_PERI = " + dtoe.getOidPeriodoDesde());   
        query1.append(" AND perH.OID_PERI = " + dtoe.getOidPeriodoHasta());
        
        try {
            rs1 = bs.dbService.executeStaticQuery(query1.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        dtoe.setFechaDesdeInicio((String)rs1.getValueAt(0, "FEC_INIC"));
        dtoe.setFechaHastaFin((String)rs1.getValueAt(0, "FEC_FINA"));

        UtilidadesLog.info("DAORec.verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe): Salida");
        return dtoe;
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOBoolean validarFaltantes(DTOBuscarEnvia dtoe) throws MareException {
        UtilidadesLog.info("DAORec.validarFaltantes(DTOBuscarEnvia dtoe)): Entrada");                
        UtilidadesLog.debug("dtoe: " + dtoe);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOBoolean dtoBoolean = new DTOBoolean();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT ope.IND_FALT_MERC, ope.IND_DEVU_FISI_FACT, ");      
        query.append(" NVL(resul.COD_RESU_CHEQ,'KO') COD_RESU_CHEQ, tipoCheq.COD_TIPO_INDI_REVI ");  
        query.append(" FROM REC_OPERA ope, PED_SOLIC_CABEC ped, REC_RESUL_CHEQU resul, ");  
        query.append(" PED_INDIC_REVIS cheq, PED_TIPO_INDIC_REVIS tipoCheq ");  
        query.append(" WHERE ped.INRE_OID_INDI_REVI = cheq.OID_INDI_REVI(+) ");  
        query.append(" AND cheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI(+) ");  
        query.append(" AND ped.RECQ_OID_RESU_CHEQ = resul.OID_RESU_CHEQ(+) ");  
        query.append(" AND ped.OID_SOLI_CABE = " + dtoe.getOidNumDocumento());  
        query.append(" AND ope.OID_OPER = " + dtoe.getOidOperacion()); 
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(((BigDecimal)rs.getValueAt(0, "IND_FALT_MERC")).intValue()== 1 && 
           ((BigDecimal)rs.getValueAt(0, "IND_DEVU_FISI_FACT")).intValue()== 1){
           
           if(ConstantesREC.COD_TIPO_REVISION_LINEA.equals((String)rs.getValueAt(0, "COD_TIPO_INDI_REVI"))){
           
                UtilidadesLog.info("DAORec.validarFaltantes(DTOBuscarEnvia dtoe): Salida");       
                dtoBoolean.setValor(false);            
                return dtoBoolean;
                
           } else {
               
               if(((String)rs.getValueAt(0, "COD_RESU_CHEQ")).equals(ConstantesREC.VALIDACION_OK)){
                   UtilidadesLog.info("DAORec.validarFaltantes(DTOBuscarEnvia dtoe): Salida");       
                   dtoBoolean.setValor(true);            
                   return dtoBoolean;
                   
               } else {
                   UtilidadesLog.info("DAORec.validarFaltantes(DTOBuscarEnvia dtoe): Salida");       
                   dtoBoolean.setValor(false);            
                   return dtoBoolean;
               }
           }
            
        } else {
            UtilidadesLog.info("DAORec.validarFaltantes(DTOBuscarEnvia dtoe): Salida");       
            dtoBoolean.setValor(false);            
            return dtoBoolean;
        }
        
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public boolean validarPeriodoChequeado(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORec.validarPeriodoChequeado(Long oidPeriodo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        boolean periodoChequeado = false;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT perCheq.OID_PERI_CHEQ ");   
        query.append(" FROM REC_PERIO_CHEQU perCheq");   
        query.append(" WHERE perCheq.PERD_OID_PERI = " + oidPeriodo);   
      
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
            periodoChequeado = true;
        }
        
        UtilidadesLog.info("DAORec.validarPeriodoChequeado(Long oidPeriodo): Salida");       
        return periodoChequeado;
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public DTOEvaluarChequeo obtenerParametrizacionChequeReincidente(Long oidPeriodo, String codTipoChequeo) throws MareException {
        UtilidadesLog.info("DAORec.obtenererParametrizacionChequeReincidente(Long oidPeriodo, String codTipoChequeo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
        UtilidadesLog.debug("codTipoChequeo: " + codTipoChequeo);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;
        DTOEvaluarChequeo dtoEvaluarChequeo = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT paramCheq.NUM_CANT_MINI_RECL, paramCheq.NUM_CANT_PERI_EVAL_ATRA ");   
        query.append(" FROM REC_PARAM_CHEQU paramCheq, PED_TIPO_INDIC_REVIS tipoCheq ");   
        query.append(" WHERE paramCheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");   
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + codTipoChequeo + "' ");   
        query.append(" AND paramCheq.IND_CONS_REIN = 1 ");   
      
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
        
            dtoEvaluarChequeo = new DTOEvaluarChequeo();
        
            dtoEvaluarChequeo.setCantidadMinima(Integer.valueOf(((BigDecimal)rs.getValueAt(0, "NUM_CANT_MINI_RECL")).toString()));
            
            int peridosParaAtraz = ((BigDecimal)rs.getValueAt(0, "NUM_CANT_PERI_EVAL_ATRA")).intValue();
            
            // Obtener periodos desde y hasta
            query1.append(" SELECT per.OID_PERI ");   
            query1.append(" FROM CRA_PERIO per, CRA_PERIO perH ");   
            query1.append(" WHERE perH.OID_PERI = " + oidPeriodo);   
            query1.append(" AND per.PAIS_OID_PAIS = perH.PAIS_OID_PAIS ");   
            query1.append(" AND per.PAIS_OID_PAIS = perH.PAIS_OID_PAIS ");   
            query1.append(" AND per.MARC_OID_MARC = perH.MARC_OID_MARC ");   
            query1.append(" AND per.CANA_OID_CANA = perH.CANA_OID_CANA ");   
            query1.append(" AND per.FEC_INIC <= perH.FEC_INIC ");   
            query1.append(" ORDER BY per.FEC_INIC DESC ");   
            
            try {
                rs1 = bs.dbService.executeStaticQuery(query1.toString());
            } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            UtilidadesLog.debug("rs1: " + rs1);
            
            dtoEvaluarChequeo.setOidPeriodoReclamo(oidPeriodo);
            dtoEvaluarChequeo.setOidPeriodoDesde(Long.valueOf(((BigDecimal)rs1.getValueAt(peridosParaAtraz, "OID_PERI")).toString()));
            dtoEvaluarChequeo.setOidPeriodoHasta(Long.valueOf(((BigDecimal)rs1.getValueAt(1, "OID_PERI")).toString()));
            
        }
        
        UtilidadesLog.info("DAORec.obtenererParametrizacionChequeReincidente(Long oidPeriodo, String codTipoChequeo): Salida");       
        return dtoEvaluarChequeo;
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarChequeReincidenteL(DTOEvaluarChequeo dtoEvaluarChequeo) throws MareException {
        UtilidadesLog.info("DAORec.insertarChequeReincidenteL(DTOEvaluarChequeo dtoEvaluarChequeo): Entrada");                
        UtilidadesLog.debug("dtoEvaluarChequeo: " + dtoEvaluarChequeo);
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT ped.CLIE_OID_CLIE ");   
        query.append(" FROM REC_OPERA_RECLA opeRec, REC_TIPOS_OPERA tipoOpe, ");  
        query.append(" REC_OPERA ope, PED_SOLIC_CABEC ped, MAE_CLIEN_DATOS_ADICI cli, ");  
        query.append(" CRA_PERIO per, CRA_PERIO perD ,CRA_PERIO perH ");  
        query.append(" WHERE opeRec.TIOP_OID_TIPO_OPER = tipoOpe.OID_TIPO_OPER ");  
        query.append(" AND tipoOpe.ROPE_OID_OPER = ope.OID_OPER ");  
        query.append(" AND ope.IND_DEVU_FISI_FACT = 1 ");  
        query.append(" AND ope.IND_FALT_MERC = 1 ");  
        query.append(" AND opeRec.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");  
        query.append(" AND ped.CLIE_OID_CLIE =  cli.CLIE_OID_CLIE ");  
        query.append(" AND cli.IND_ACTI = 1 ");          
        query.append(" AND NOT EXISTS (SELECT 1 ");  
        query.append("                 FROM REC_CLIEN_A_CHEQU cliCheq ");  
        query.append("                 WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");  
        query.append("                 AND cliCheq.PERD_OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoReclamo() + ") ");          
        query.append(" AND opeRec.PERD_OID_PERI_RECL = per.OID_PERI ");  
        query.append(" AND perD.OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoDesde());  
        query.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS ");  
        query.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC ");   
        query.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");  
        query.append(" AND per.FEC_INIC >= perD.FEC_INIC ");  
        query.append(" AND perH.OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoHasta());  
        query.append(" AND per.FEC_FINA <= perH.FEC_FINA  ");  
        query.append(" GROUP BY ped.CLIE_OID_CLIE ");  
        query.append(" HAVING COUNT(ped.CLIE_OID_CLIE) >= " + dtoEvaluarChequeo.getCantidadMinima());  
      
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
        
            int cant = rs.getRowCount();
         
            query1.append("  BEGIN");
            
            for(int i=0; i < cant; i++){

                query1.append(" INSERT INTO REC_CLIEN_A_CHEQU ");   
                query1.append(" (OID_CLIE_A_CHEQ ,CLIE_OID_CLIE,PERD_OID_PERI, INRE_OID_INDI_REVI) ");
                query1.append("  VALUES (REC_CACH_SEQ.NEXTVAL, " + ((BigDecimal)rs.getValueAt(i, "CLIE_OID_CLIE")).toString() + ", " + 
                                 dtoEvaluarChequeo.getOidPeriodoReclamo() + "," + ConstantesREC.OID_TIPO_REVISION_D + "); ");
                            
            }            
            
            query1.append("  END;"); 
            
            try {
                  bs.dbService.executeUpdate(query1.toString());     
            } catch (DuplicateKeyException ex) {
                  ex.printStackTrace();
                  ctx.setRollbackOnly();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (Exception e){       
                  e.printStackTrace();
                  ctx.setRollbackOnly();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }              
        }
        
        UtilidadesLog.info("DAORec.insertarChequeReincidenteL(DTOEvaluarChequeo dtoEvaluarChequeo): Salida");    
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarChequeReincidenteC(DTOEvaluarChequeo dtoEvaluarChequeo) throws MareException {
        UtilidadesLog.info("DAORec.insertarChequeReincidenteC(DTOEvaluarChequeo dtoEvaluarChequeo): Entrada");                
        UtilidadesLog.debug("dtoEvaluarChequeo: " + dtoEvaluarChequeo);
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        RecordSet rs2 = new RecordSet();
        StringBuffer query2 = new StringBuffer();
        RecordSet rs3 = new RecordSet();
        StringBuffer query3 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Busca consultoras Reincidentes Campo
        query.append(" SELECT ped.CLIE_OID_CLIE ");   
        query.append(" FROM REC_OPERA_RECLA opeRec, REC_TIPOS_OPERA tipoOpe, ");  
        query.append(" REC_OPERA ope, PED_SOLIC_CABEC ped, MAE_CLIEN_DATOS_ADICI cli, ");  
        query.append(" CRA_PERIO per, CRA_PERIO perD ,CRA_PERIO perH ");  
        query.append(" WHERE opeRec.TIOP_OID_TIPO_OPER = tipoOpe.OID_TIPO_OPER ");  
        query.append(" AND tipoOpe.ROPE_OID_OPER = ope.OID_OPER ");  
        query.append(" AND ope.IND_DEVU_FISI_FACT = 1 ");  
        query.append(" AND ope.IND_FALT_MERC = 1 ");  
        query.append(" AND opeRec.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");  
        query.append(" AND ped.CLIE_OID_CLIE =  cli.CLIE_OID_CLIE ");  
        query.append(" AND cli.IND_ACTI = 1 ");          
        query.append(" AND NOT EXISTS (SELECT 1 ");  
        query.append("                 FROM REC_CLIEN_A_CHEQU cliCheq ");  
        query.append("                 WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");  
        query.append("                 AND cliCheq.PERD_OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoReclamo() + ") ");          
        query.append(" AND opeRec.PERD_OID_PERI_RECL = per.OID_PERI ");  
        query.append(" AND perD.OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoDesde());  
        query.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS ");  
        query.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC ");   
        query.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");  
        query.append(" AND per.FEC_INIC >= perD.FEC_INIC ");  
        query.append(" AND perH.OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoHasta());  
        query.append(" AND per.FEC_FINA <= perH.FEC_FINA  ");  
        query.append(" GROUP BY ped.CLIE_OID_CLIE ");  
        query.append(" HAVING COUNT(ped.CLIE_OID_CLIE) >= " + dtoEvaluarChequeo.getCantidadMinima());  
      
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
            // Inserto los cliente que no tienen chequeo Manual o Reincidente Linea
            int cant = rs.getRowCount();
                  
            query1.append("  BEGIN");
            
            for(int i=0; i < cant; i++){

                query1.append(" INSERT INTO REC_CLIEN_A_CHEQU ");   
                query1.append(" (OID_CLIE_A_CHEQ ,CLIE_OID_CLIE,PERD_OID_PERI, INRE_OID_INDI_REVI) ");
                query1.append("  VALUES (REC_CACH_SEQ.NEXTVAL, " + ((BigDecimal)rs.getValueAt(i, "CLIE_OID_CLIE")).toString() + ", " + 
                                 dtoEvaluarChequeo.getOidPeriodoReclamo() + "," + ConstantesREC.OID_TIPO_REVISION_E + "); ");
                            
            }            
            
            query1.append("  END;"); 
            
            try {
                  bs.dbService.executeUpdate(query1.toString());     
            } catch (DuplicateKeyException ex) {
                  ex.printStackTrace();
                  ctx.setRollbackOnly();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (Exception e){       
                  e.printStackTrace();
                  ctx.setRollbackOnly();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }              
        }
        
        // Busca consultores que son Reincidente Ambos
        query2.append(" SELECT ped.CLIE_OID_CLIE ");   
        query2.append(" FROM REC_OPERA_RECLA opeRec, REC_TIPOS_OPERA tipoOpe, ");  
        query2.append(" REC_OPERA ope, PED_SOLIC_CABEC ped, MAE_CLIEN_DATOS_ADICI cli, ");  
        query2.append(" CRA_PERIO per, CRA_PERIO perD ,CRA_PERIO perH ");  
        query2.append(" WHERE opeRec.TIOP_OID_TIPO_OPER = tipoOpe.OID_TIPO_OPER ");  
        query2.append(" AND tipoOpe.ROPE_OID_OPER = ope.OID_OPER ");  
        query2.append(" AND ope.IND_DEVU_FISI_FACT = 1 ");  
        query2.append(" AND ope.IND_FALT_MERC = 1 ");  
        query2.append(" AND opeRec.SOCA_OID_SOLI_CABE = ped.OID_SOLI_CABE ");  
        query2.append(" AND ped.CLIE_OID_CLIE =  cli.CLIE_OID_CLIE ");  
        query2.append(" AND cli.IND_ACTI = 1 ");          
        query2.append(" AND EXISTS (SELECT 1 ");  
        query2.append("             FROM REC_CLIEN_A_CHEQU cliCheq ");  
        query2.append("             WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");  
        query2.append("             AND cliCheq.PERD_OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoReclamo());          
        query2.append("             AND cliCheq.INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_D + ") ");   
        query2.append(" AND opeRec.PERD_OID_PERI_RECL = per.OID_PERI ");  
        query2.append(" AND perD.OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoDesde());  
        query2.append(" AND per.PAIS_OID_PAIS = perD.PAIS_OID_PAIS ");  
        query2.append(" AND per.MARC_OID_MARC = perD.MARC_OID_MARC ");   
        query2.append(" AND per.CANA_OID_CANA = perD.CANA_OID_CANA ");  
        query2.append(" AND per.FEC_INIC >= perD.FEC_INIC ");  
        query2.append(" AND perH.OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoHasta());  
        query2.append(" AND per.FEC_FINA <= perH.FEC_FINA  ");  
        query2.append(" GROUP BY ped.CLIE_OID_CLIE ");  
        query2.append(" HAVING COUNT(ped.CLIE_OID_CLIE) >= " + dtoEvaluarChequeo.getCantidadMinima());  
        
        try {
            rs2 = bs.dbService.executeStaticQuery(query2.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs2: " + rs2);
        
        if(!rs2.esVacio()){
            // Actualizo los cliente que son Reincidentes Linea y Reincidente Campo como Ambos
            int cant2 = rs2.getRowCount();
            
            query3.append("  BEGIN");
            
            for(int i=0; i < cant2; i++){

                query3.append(" UPDATE REC_CLIEN_A_CHEQU ");   
                query3.append(" SET INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_F);
                query3.append(" WHERE PERD_OID_PERI = " + dtoEvaluarChequeo.getOidPeriodoReclamo());
                query3.append(" AND INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_D);
                query3.append(" AND CLIE_OID_CLIE = " + ((BigDecimal)rs2.getValueAt(i, "CLIE_OID_CLIE")).toString() + "; ");                            
            }            
            
            query3.append("  END;"); 
            
            try {
                  bs.dbService.executeUpdate(query3.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  ctx.setRollbackOnly();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }              
        }
        
        UtilidadesLog.info("DAORec.insertarChequeReincidenteC(DTOEvaluarChequeo dtoEvaluarChequeo): Salida");    
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarChequeTipologiaClienteL(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORec.insertarChequeTipologiaClienteL(Long oidPeriodo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" INSERT INTO REC_CLIEN_A_CHEQU ");   
        query.append(" (OID_CLIE_A_CHEQ ,CLIE_OID_CLIE,PERD_OID_PERI, INRE_OID_INDI_REVI) ");
        query.append(" SELECT REC_CACH_SEQ.NEXTVAL, tipolog.CLIE_OID_CLIE, " + oidPeriodo + ", confCli.INRE_OID_INDI_REVI ");   
        query.append(" FROM REC_CONFI_TIPO_CLIEN confCli, V_MAE_TIPIF_CLIEN tipolog, CRA_PERIO per, ");   
        query.append(" PED_INDIC_REVIS cheq, PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli ");   
        query.append(" WHERE confCli.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");   
        query.append(" AND cheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");   
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' ");  
        query.append(" AND per.OID_PERI = " + oidPeriodo);   
        query.append(" AND confCli.PAIS_OID_PAIS = per.PAIS_OID_PAIS ");   
        query.append(" AND NOT EXISTS (SELECT 1 ");   
        query.append("                 FROM REC_CLIEN_A_CHEQU cliCheq ");   
        query.append("                 WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query.append("                 AND cliCheq.PERD_OID_PERI = " + oidPeriodo + ") ");   
        query.append(" AND confCli.TICL_OID_TIPO_CLIE = tipolog.TICL_OID_TIPO_CLIE ");   
        query.append(" AND confCli.SBTI_OID_SUBT_CLIE = tipolog.SBTI_OID_SUBT_CLIE ");   
        query.append(" AND confCli.TCCL_OID_TIPO_CLAS = tipolog.TCCL_OID_TIPO_CLASI ");   
        query.append(" AND confCli.CLAS_OID_CLAS = tipolog.CLAS_OID_CLAS ");   
        query.append(" AND tipolog.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query.append(" AND cli.IND_ACTI = 1 ");           
      
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (DuplicateKeyException ex) {
              ex.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){       
              e.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAORec.insertarChequeTipologiaClienteL(Long oidPeriodo): Salida");    
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarChequeTipologiaClienteC(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORec.insertarChequeTipologiaClienteC(Long oidPeriodo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        RecordSet rs2 = new RecordSet();
        StringBuffer query2 = new StringBuffer();
        RecordSet rs3 = new RecordSet();
        StringBuffer query3 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Busca consultoras tipo de tipologia Campo que no sean manual o linea       
        query.append(" INSERT INTO REC_CLIEN_A_CHEQU ");   
        query.append(" (OID_CLIE_A_CHEQ ,CLIE_OID_CLIE,PERD_OID_PERI, INRE_OID_INDI_REVI) ");
        query.append(" SELECT REC_CACH_SEQ.NEXTVAL, tipolog.CLIE_OID_CLIE, " + oidPeriodo + ", confCli.INRE_OID_INDI_REVI ");   
        query.append(" FROM REC_CONFI_TIPO_CLIEN confCli, V_MAE_TIPIF_CLIEN tipolog, CRA_PERIO per, ");   
        query.append(" PED_INDIC_REVIS cheq, PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli ");   
        query.append(" WHERE confCli.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");   
        query.append(" AND cheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");   
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "' ");  
        query.append(" AND per.OID_PERI = " + oidPeriodo);   
        query.append(" AND confCli.PAIS_OID_PAIS = per.PAIS_OID_PAIS ");  
        query.append(" AND NOT EXISTS (SELECT 1 ");   
        query.append("                 FROM REC_CLIEN_A_CHEQU cliCheq1 "); 
        query.append("                 WHERE cliCheq1.CLIE_OID_CLIE = cli.CLIE_OID_CLIE "); 
        query.append("                 AND cliCheq1.PERD_OID_PERI = " + oidPeriodo + ") ");  
        
        /*query.append("                 AND cliCheq1.INRE_OID_INDI_REVI in (SELECT DISTINCT confCli1.INRE_OID_INDI_REVI "); 
        query.append("                                                     FROM REC_CONFI_TIPO_CLIEN confCli1, CRA_PERIO per1, "); 
        query.append("                                                     PED_INDIC_REVIS cheq1, PED_TIPO_INDIC_REVIS tipoCheq1 "); 
        query.append("                                                     WHERE confCli1.INRE_OID_INDI_REVI =  cheq1.OID_INDI_REVI "); 
        query.append("                                                     AND cheq1.TIRV_OID_TIPO_INDI_REVI = tipoCheq1.OID_TIPO_INDI_REVI "); 
        query.append("                                                     AND tipoCheq1.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' ");  
        query.append("                                                     AND per1.OID_PERI = " + oidPeriodo);   
        query.append("                                                     AND confCli1.PAIS_OID_PAIS = per1.PAIS_OID_PAIS "); 
        query.append("                                                     AND confCli1.TICL_OID_TIPO_CLIE = tipolog.TICL_OID_TIPO_CLIE "); 
        query.append("                                                     AND confCli1.SBTI_OID_SUBT_CLIE = tipolog.SBTI_OID_SUBT_CLIE "); 
        query.append("                                                     AND confCli1.TCCL_OID_TIPO_CLAS = tipolog.TCCL_OID_TIPO_CLASI "); 
        query.append("                                                     AND confCli1.CLAS_OID_CLAS = tipolog.CLAS_OID_CLAS )) "); 
        */
        query.append(" AND confCli.TICL_OID_TIPO_CLIE = tipolog.TICL_OID_TIPO_CLIE ");   
        query.append(" AND confCli.SBTI_OID_SUBT_CLIE = tipolog.SBTI_OID_SUBT_CLIE ");   
        query.append(" AND confCli.TCCL_OID_TIPO_CLAS = tipolog.TCCL_OID_TIPO_CLASI ");   
        query.append(" AND confCli.CLAS_OID_CLAS = tipolog.CLAS_OID_CLAS ");   
        query.append(" AND tipolog.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query.append(" AND cli.IND_ACTI = 1 ");         
      
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (DuplicateKeyException ex) {
              ex.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){       
              e.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }       
        
        
        
        // Busca consultores que son Tipo de Tipologia Ambos
        query2.append(" SELECT tipolog.CLIE_OID_CLIE, ");   
        query2.append(" (SELECT confCli2.INRE_OID_INDI_REVI ");   
        query2.append(" FROM REC_CONFI_TIPO_CLIEN confCli2, V_MAE_TIPIF_CLIEN tipolog2, CRA_PERIO per2, ");   
        query2.append(" PED_INDIC_REVIS cheq2, PED_TIPO_INDIC_REVIS tipoCheq2 ");   
        query2.append(" WHERE confCli2.INRE_OID_INDI_REVI =  cheq2.OID_INDI_REVI ");   
        query2.append(" AND cheq2.TIRV_OID_TIPO_INDI_REVI = tipoCheq2.OID_TIPO_INDI_REVI ");   
        query2.append(" AND tipoCheq2.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' ");  
        query2.append(" AND per2.OID_PERI = " + oidPeriodo);  
        query2.append(" AND confCli2.PAIS_OID_PAIS = per2.PAIS_OID_PAIS ");   
        query2.append(" AND confCli2.TICL_OID_TIPO_CLIE = tipolog2.TICL_OID_TIPO_CLIE ");   
        query2.append(" AND confCli2.SBTI_OID_SUBT_CLIE = tipolog2.SBTI_OID_SUBT_CLIE ");   
        query2.append(" AND confCli2.TCCL_OID_TIPO_CLAS = tipolog2.TCCL_OID_TIPO_CLASI ");   
        query2.append(" AND confCli2.CLAS_OID_CLAS = tipolog2.CLAS_OID_CLAS ");   
        query2.append(" AND tipolog2.CLIE_OID_CLIE = tipolog.CLIE_OID_CLIE) INRE_OID_INDI_REVI_L, ");   
        query2.append(" tipologiaAmbos.COD_INDI_REVI COD_INDI_REVI_A ");   
        query2.append(" FROM REC_CONFI_TIPO_CLIEN confCli, V_MAE_TIPIF_CLIEN tipolog, CRA_PERIO per, ");   
        query2.append(" PED_INDIC_REVIS cheq, PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli, ");   
        query2.append(" (SELECT tipolog3.CLIE_OID_CLIE, MIN(cheq3.COD_INDI_REVI) COD_INDI_REVI ");   
        query2.append(" FROM REC_CONFI_TIPO_CLIEN confCli3, V_MAE_TIPIF_CLIEN tipolog3, CRA_PERIO per3, "); 
        query2.append(" PED_INDIC_REVIS cheq3, PED_TIPO_INDIC_REVIS tipoCheq3 ");   
        query2.append(" WHERE confCli3.INRE_OID_INDI_REVI =  cheq3.OID_INDI_REVI ");   
        query2.append(" AND cheq3.TIRV_OID_TIPO_INDI_REVI = tipoCheq3.OID_TIPO_INDI_REVI ");   
        query2.append(" AND tipoCheq3.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_A + "' ");  
        query2.append(" AND per3.OID_PERI = " + oidPeriodo);  
        query2.append(" AND confCli3.PAIS_OID_PAIS = per3.PAIS_OID_PAIS ");   
        query2.append(" AND confCli3.TICL_OID_TIPO_CLIE = tipolog3.TICL_OID_TIPO_CLIE ");   
        query2.append(" AND confCli3.SBTI_OID_SUBT_CLIE = tipolog3.SBTI_OID_SUBT_CLIE ");   
        query2.append(" AND confCli3.TCCL_OID_TIPO_CLAS = tipolog3.TCCL_OID_TIPO_CLASI ");   
        query2.append(" AND confCli3.CLAS_OID_CLAS = tipolog3.CLAS_OID_CLAS "); 
        query2.append(" GROUP BY tipolog3.CLIE_OID_CLIE) tipologiaAmbos ");   
        query2.append(" WHERE confCli.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");   
        query2.append(" AND cheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");   
        query2.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "' ");  
        query2.append(" AND per.OID_PERI = " + oidPeriodo);  
        query2.append(" AND confCli.PAIS_OID_PAIS = per.PAIS_OID_PAIS ");   
        query2.append(" AND EXISTS (SELECT 1 ");   
        query2.append(" FROM REC_CLIEN_A_CHEQU cliCheq1 ");   
        query2.append(" WHERE cliCheq1.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query2.append(" AND cliCheq1.PERD_OID_PERI = " + oidPeriodo);  
        query2.append(" AND cliCheq1.INRE_OID_INDI_REVI IN (SELECT DISTINCT confCli1.INRE_OID_INDI_REVI ");   
        query2.append(" FROM REC_CONFI_TIPO_CLIEN confCli1, CRA_PERIO per1, ");   
        query2.append(" PED_INDIC_REVIS cheq1, PED_TIPO_INDIC_REVIS tipoCheq1 ");   
        query2.append(" WHERE confCli1.INRE_OID_INDI_REVI =  cheq1.OID_INDI_REVI ");   
        query2.append(" AND cheq1.TIRV_OID_TIPO_INDI_REVI = tipoCheq1.OID_TIPO_INDI_REVI ");   
        query2.append(" AND tipoCheq1.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' ");  
        query2.append(" AND per1.OID_PERI = " + oidPeriodo);  
        query2.append(" AND confCli1.PAIS_OID_PAIS = per1.PAIS_OID_PAIS ");   
        query2.append(" AND confCli1.TICL_OID_TIPO_CLIE = tipolog.TICL_OID_TIPO_CLIE ");   
        query2.append(" AND confCli1.SBTI_OID_SUBT_CLIE = tipolog.SBTI_OID_SUBT_CLIE ");   
        query2.append(" AND confCli1.TCCL_OID_TIPO_CLAS = tipolog.TCCL_OID_TIPO_CLASI ");   
        query2.append(" AND confCli1.CLAS_OID_CLAS = tipolog.CLAS_OID_CLAS )) ");   
        query2.append(" AND confCli.TICL_OID_TIPO_CLIE = tipolog.TICL_OID_TIPO_CLIE ");   
        query2.append(" AND confCli.SBTI_OID_SUBT_CLIE = tipolog.SBTI_OID_SUBT_CLIE ");   
        query2.append(" AND confCli.TCCL_OID_TIPO_CLAS = tipolog.TCCL_OID_TIPO_CLASI ");   
        query2.append(" AND confCli.CLAS_OID_CLAS = tipolog.CLAS_OID_CLAS "); 
        query2.append(" AND tipolog.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query2.append(" AND cli.IND_ACTI = 1 ");   
        query2.append(" AND tipologiaAmbos.CLIE_OID_CLIE = tipolog.CLIE_OID_CLIE ");           
         
        
        try {
            rs2 = bs.dbService.executeStaticQuery(query2.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs2: " + rs2);
        
        if(!rs2.esVacio()){
            // Actualizo los cliente que son Reincidentes Linea y Reincidente Campo como Ambos
            int cant2 = rs2.getRowCount();
         
            // Obtener periodos desde y hasta
            query3.append("  BEGIN");
            
            for(int i=0; i < cant2; i++){

                query3.append(" UPDATE REC_CLIEN_A_CHEQU ");   
                query3.append(" SET INRE_OID_INDI_REVI = (SELECT cheq.OID_INDI_REVI ");
                query3.append("                           FROM PED_INDIC_REVIS cheq ");
                query3.append("                           WHERE cheq.COD_INDI_REVI = '" + (String)rs2.getValueAt(i, "COD_INDI_REVI_A") + "') ");
                query3.append(" WHERE PERD_OID_PERI = " + oidPeriodo);
                query3.append(" AND INRE_OID_INDI_REVI = " + ((BigDecimal)rs2.getValueAt(i, "INRE_OID_INDI_REVI_L")).toString());
                query3.append(" AND CLIE_OID_CLIE = " + ((BigDecimal)rs2.getValueAt(i, "CLIE_OID_CLIE")).toString() + "; ");                            
            }            
            
            query3.append("  END;"); 
            
            try {
                  bs.dbService.executeUpdate(query3.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  ctx.setRollbackOnly();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }              
        }
        
        UtilidadesLog.info("DAORec.insertarChequeTipologiaClienteC(Long oidPeriodo): Salida");    
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarChequeUnidadAdministrativaL(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORec.insertarChequeUnidadAdministrativaL(Long oidPeriodo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" INSERT INTO REC_CLIEN_A_CHEQU ");   
        query.append(" (OID_CLIE_A_CHEQ ,CLIE_OID_CLIE,PERD_OID_PERI, INRE_OID_INDI_REVI) ");
        query.append(" SELECT REC_CACH_SEQ.NEXTVAL, unidAdm.CLIE_OID_CLIE, " + oidPeriodo + ", " + ConstantesREC.OID_TIPO_REVISION_G);
        query.append(" FROM REC_CHEQU_UA cheqUA, MAE_CLIEN_UNIDA_ADMIN unidAdm, ");   
        query.append(" PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli, ");  
        query.append(" ZON_TERRI_ADMIN terrAdm, ZON_SECCI secc, ZON_ZONA zon,  ");  
        query.append(" ZON_REGIO reg, ZON_SUB_GEREN_VENTA subg ");  
        query.append(" WHERE cheqUA.PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND cheqUA.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");  
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "' "); 
        query.append(" AND NOT EXISTS (SELECT 1 ");   
        query.append("                 FROM REC_CLIEN_A_CHEQU cliCheq ");   
        query.append("                 WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query.append("                 AND cliCheq.PERD_OID_PERI = " + oidPeriodo + ") ");   
        query.append(" AND unidAdm.IND_ACTI = 1 ");  
        query.append(" AND unidAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");  
        query.append(" AND terrAdm.IND_BORR = 0 ");  
        query.append(" AND terrAdm.ZSCC_OID_SECC = secc.OID_SECC ");  
        query.append(" AND secc.IND_ACTI = 1 "); 
        query.append(" AND secc.IND_BORR = 0 ");  
        query.append(" AND secc.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query.append(" AND zon.IND_ACTI = 1 ");  
        query.append(" AND zon.IND_BORR = 0 ");  
        query.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI "); 
        query.append(" AND reg.IND_ACTI = 1 ");  
        query.append(" AND reg.IND_BORR = 0 ");  
        query.append(" AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");  
        query.append(" AND subg.IND_ACTI = 1 ");  
        query.append(" AND subg.IND_BORR = 0 "); 
        query.append(" AND cheqUA.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");  
        query.append(" AND cheqUA.ZORG_OID_REGI = reg.OID_REGI ");  
        query.append(" AND cheqUA.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query.append(" AND (cheqUA.ZSCC_OID_SECC = secc.OID_SECC OR cheqUA.ZSCC_OID_SECC IS NULL) ");  
        query.append(" AND unidAdm.CLIE_OID_CLIE = cli.CLIE_OID_CLIE "); 
        query.append(" AND cli.IND_ACTI = 1 "); 
      
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (DuplicateKeyException ex) {
              ex.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){       
              e.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAORec.insertarChequeUnidadAdministrativaL(Long oidPeriodo): Salida");    
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarChequeUnidadAdministrativaC(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORec.insertarChequeUnidadAdministrativaC(Long oidPeriodo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        RecordSet rs2 = new RecordSet();
        StringBuffer query2 = new StringBuffer();
        RecordSet rs3 = new RecordSet();
        StringBuffer query3 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Busca consultoras Unidad Administrativa Campo        
        query.append(" INSERT INTO REC_CLIEN_A_CHEQU ");   
        query.append(" (OID_CLIE_A_CHEQ ,CLIE_OID_CLIE,PERD_OID_PERI, INRE_OID_INDI_REVI) ");
        query.append(" SELECT REC_CACH_SEQ.NEXTVAL, unidAdm.CLIE_OID_CLIE, " + oidPeriodo + ", " + ConstantesREC.OID_TIPO_REVISION_H);
        query.append(" FROM REC_CHEQU_UA cheqUA, MAE_CLIEN_UNIDA_ADMIN unidAdm, ");   
        query.append(" PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli, ");  
        query.append(" ZON_TERRI_ADMIN terrAdm, ZON_SECCI secc, ZON_ZONA zon,  ");  
        query.append(" ZON_REGIO reg, ZON_SUB_GEREN_VENTA subg ");  
        query.append(" WHERE cheqUA.PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND cheqUA.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");  
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "' "); 
        query.append(" AND NOT EXISTS (SELECT 1 ");   
        query.append("                 FROM REC_CLIEN_A_CHEQU cliCheq ");   
        query.append("                 WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query.append("                 AND cliCheq.PERD_OID_PERI = " + oidPeriodo + ") ");   
      //  query.append("                 AND cliCheq.INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_G + ") ");   
        query.append(" AND unidAdm.IND_ACTI = 1 ");  
        query.append(" AND unidAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");  
        query.append(" AND terrAdm.IND_BORR = 0 ");  
        query.append(" AND terrAdm.ZSCC_OID_SECC = secc.OID_SECC ");  
        query.append(" AND secc.IND_ACTI = 1 "); 
        query.append(" AND secc.IND_BORR = 0 ");  
        query.append(" AND secc.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query.append(" AND zon.IND_ACTI = 1 ");  
        query.append(" AND zon.IND_BORR = 0 ");  
        query.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI "); 
        query.append(" AND reg.IND_ACTI = 1 ");  
        query.append(" AND reg.IND_BORR = 0 ");  
        query.append(" AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");  
        query.append(" AND subg.IND_ACTI = 1 ");  
        query.append(" AND subg.IND_BORR = 0 "); 
        query.append(" AND cheqUA.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");  
        query.append(" AND cheqUA.ZORG_OID_REGI = reg.OID_REGI ");  
        query.append(" AND cheqUA.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query.append(" AND (cheqUA.ZSCC_OID_SECC = secc.OID_SECC OR cheqUA.ZSCC_OID_SECC IS NULL) ");  
        query.append(" AND unidAdm.CLIE_OID_CLIE = cli.CLIE_OID_CLIE "); 
        query.append(" AND cli.IND_ACTI = 1 ");          
      
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (DuplicateKeyException ex) {
              ex.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){       
              e.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }       
               
        
        // Busca consultoras Unidad Administrativa Ambos
        query3.append(" UPDATE REC_CLIEN_A_CHEQU ");   
        query3.append(" SET INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_I);
        query3.append(" WHERE PERD_OID_PERI = " + oidPeriodo);
        query3.append(" AND INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_G);
        query3.append(" AND CLIE_OID_CLIE IN ( ");        
        query3.append(" SELECT unidAdm.CLIE_OID_CLIE "); 
        query3.append(" FROM REC_CHEQU_UA cheqUA, MAE_CLIEN_UNIDA_ADMIN unidAdm, ");   
        query3.append(" PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli, ");  
        query3.append(" ZON_TERRI_ADMIN terrAdm, ZON_SECCI secc, ZON_ZONA zon,  ");  
        query3.append(" ZON_REGIO reg, ZON_SUB_GEREN_VENTA subg ");  
        query3.append(" WHERE cheqUA.PERD_OID_PERI = " + oidPeriodo);
        query3.append(" AND cheqUA.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");  
        query3.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "' "); 
        query3.append(" AND EXISTS (SELECT 1 ");   
        query3.append("                 FROM REC_CLIEN_A_CHEQU cliCheq ");   
        query3.append("                 WHERE cliCheq.CLIE_OID_CLIE = cli.CLIE_OID_CLIE ");   
        query3.append("                 AND cliCheq.PERD_OID_PERI = " + oidPeriodo);   
        query3.append("                 AND cliCheq.INRE_OID_INDI_REVI = " + ConstantesREC.OID_TIPO_REVISION_G + ") ");   
        query3.append(" AND unidAdm.IND_ACTI = 1 ");  
        query3.append(" AND unidAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");  
        query3.append(" AND terrAdm.IND_BORR = 0 ");  
        query3.append(" AND terrAdm.ZSCC_OID_SECC = secc.OID_SECC ");  
        query3.append(" AND secc.IND_ACTI = 1 "); 
        query3.append(" AND secc.IND_BORR = 0 ");  
        query3.append(" AND secc.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query3.append(" AND zon.IND_ACTI = 1 ");  
        query3.append(" AND zon.IND_BORR = 0 ");  
        query3.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI "); 
        query3.append(" AND reg.IND_ACTI = 1 ");  
        query3.append(" AND reg.IND_BORR = 0 ");  
        query3.append(" AND reg.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");  
        query3.append(" AND subg.IND_ACTI = 1 ");  
        query3.append(" AND subg.IND_BORR = 0 "); 
        query3.append(" AND cheqUA.ZSGV_OID_SUBG_VENT = subg.OID_SUBG_VENT ");  
        query3.append(" AND cheqUA.ZORG_OID_REGI = reg.OID_REGI ");  
        query3.append(" AND cheqUA.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query3.append(" AND (cheqUA.ZSCC_OID_SECC = secc.OID_SECC OR cheqUA.ZSCC_OID_SECC IS NULL) ");  
        query3.append(" AND unidAdm.CLIE_OID_CLIE = cli.CLIE_OID_CLIE "); 
        query3.append(" AND cli.IND_ACTI = 1 )");    
        
        try {
              bs.dbService.executeUpdate(query3.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }              
       
        
        UtilidadesLog.info("DAORec.insertarChequeUnidadAdministrativaC(Long oidPeriodo): Salida");    
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public void insertarPeriodoChequeado(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORec.insertarPeriodoChequeado(Long oidPeriodo): Entrada");                
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" INSERT INTO REC_PERIO_CHEQU ");   
        query.append(" (OID_PERI_CHEQ,PERD_OID_PERI,IND_GENE) ");   
        query.append(" VALUES (REC_PECH_SEQ.NEXTVAL, " + oidPeriodo + ", NULL) ");   
      
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        UtilidadesLog.info("DAORec.insertarPeriodoChequeado(Long oidPeriodo): Salida");   
    }

    
}