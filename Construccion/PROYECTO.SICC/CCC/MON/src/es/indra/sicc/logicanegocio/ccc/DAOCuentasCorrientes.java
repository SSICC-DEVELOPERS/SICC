
/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOBuscarCuentasCorrientes;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes;
import es.indra.sicc.dtos.ccc.DTOBuscarLotesTrabajo;
import es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos;
import es.indra.sicc.dtos.ccc.DTONumeroLote;
import es.indra.sicc.dtos.ccc.DTONumeroRegistros;
import es.indra.sicc.dtos.ccc.DTONumerosLineaVistaLotes;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.lang.StringBuffer;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.Vector;

import javax.ejb.EJBException;


public class DAOCuentasCorrientes  {
	private String usuario;

	//private static final String VCA_SEG_SOCIE = "VCA_SEG_SOCIE";
	private static final String BEL_MEDIO_PAGO = "BEL_MEDIO_PAGO";
	//private static final String SEG_MONED = "SEG_MONED";
	private static final String SEG_CANAL = "SEG_CANAL";
	private static final String SEG_ACCES = "SEG_ACCES";
	private static final String SEG_SUBAC = "SEG_SUBAC";
	

	public DAOCuentasCorrientes(String usuario) {
		this.usuario = usuario;
	}
	

	public DTOSalida obtenerCuentasCorrientesEmpresa(DTOOID dto) throws MareException {

		/**
		 * Hacemos la siguiente consulta JDBC: 
		 * 
		 * SELECT c.OID_CUEN_CORR_BANC, c.DES_CC 
		 * FROM CCC_CUENT_CORRI_BANCA c, VCA_SEG_SOCIE so 
		 * WHERE 
		 *	c.SOCI_OID_SOCI = so.OID_SOCI AND 
		 *	so.OID_SOCI = dto.oid AND 
		 *	so.COD_USUA = usuario 
		 *  
		 *  Devolvemos el resultado de la consulta.
		 */
		 
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerCuentasCorrientesEmpresa(DTOOID dto): Entrada ");
		Long oid = dto.getOid();

		// Se crea la consulta SQL
		// Ver incidencia 3587
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT c.OID_CUEN_CORR_BANC, c.DES_CC ");
		consulta.append("FROM CCC_CUENT_CORRI_BANCA c,  ");
		consulta.append("VCA_SEG_SOCIE so ");
		consulta.append("WHERE c.SOCI_OID_SOCI = so.OID_SOCI AND ");
		consulta.append("so.OID_SOCI = ? AND ");
		consulta.append("so.COD_USUA = ? ");
		consulta.append("ORDER BY c.DES_CC ASC ");

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(oid);
		parametros.add(this.usuario);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerCuentasCorrientesEmpresa: Exception",e);
			this.logSql("obtenerCuentasCorrientesEmpresa. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		// Se devuelve un DTOSalida
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerCuentasCorrientesEmpresa(DTOOID dto): Salida ");
		return dtoSalida;
	}

	public DTOSalida buscarCuotasPendientesCancelacion(DTOBuscarCuentasCorrientes dto) throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.buscarCuotasPendientesCancelacion(DTOBuscarCuentasCorrientes dto): Entrada ");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT M.OID_MOVI_CC OID, c.COD_CLIE, ");

		//Subselect para obtener la descripcion del canal
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("WHERE v.VAL_OID = l.oid_cana AND v.IDIO_OID_IDIO = ? ");
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND v.ATTR_ENTI = '"+SEG_CANAL+"') AS DESC_CANAL, ");

		//Subselect para obtener la descripcion del acceso
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("WHERE v.VAL_OID = a.oid_acce AND v.IDIO_OID_IDIO = ? ");
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND v.ATTR_ENTI = '"+SEG_ACCES+"') AS DESC_ACCESO, ");

		//Subselect para obtener la descripcion del subacceso
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("WHERE v.VAL_OID = sub.oid_sbac AND v.IDIO_OID_IDIO = ? ");
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND v.ATTR_ENTI = '"+SEG_SUBAC+"') AS DESC_SUBACCESO, ");
		
		consulta.append(" CONCAT(m.val_ejer_cuot, LPAD(m.num_iden_cuot, 8, 0)),");
		consulta.append(" m.num_orde_cuot, m.fec_docu, m.fec_venc,");

		// Subselect para obtener la descripcion del medio de pago
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = m.MPAB_OID_MEDI_PAGO AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");//IDIOMA
		consulta.append("v.ATTR_ENTI = '"+BEL_MEDIO_PAGO+"') AS DESC_MEDI_PAGO,");


		consulta.append(" m.imp_movi, m.imp_paga, m.imp_pend,");

		// Subselect para obtener la descripcion de la moneda 
		consulta.append(" mon.cod_mone,");
		/*consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = m.MONE_OID_MONE AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");//IDIOMA
		consulta.append("v.ATTR_ENTI = '"+SEG_MONED+"') AS DESC_MONE,");*/

		consulta.append(" m.imp_divi,m.imp_pend imp_apli,m.MPAB_OID_MEDI_PAGO,");
		consulta.append(" M.OID_MOVI_CC OID2,");
		consulta.append(" l.cod_cana, a.cod_acce, sub.cod_sbac");

		//parte FROM de la consulta
		consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m LEFT JOIN SEG_MONED mon ON (m.mone_oid_mone = mon.oid_mone),");
		consulta.append(" MAE_CLIEN c,");
		consulta.append(" VCA_SEG_SOCIE so,");
		consulta.append(" VCA_SEG_CANAL l,");
		consulta.append(" VCA_SEG_ACCES a,");
		consulta.append(" VCA_SEG_SUBAC sub");

		
		//parte WHERE de la consulta
		consulta.append(" WHERE m.sbac_oid_sbac=sub.oid_sbac");
		consulta.append(" AND sub.acce_oid_acce=a.oid_acce");
		consulta.append(" AND a.cana_oid_cana = l.oid_cana");
		consulta.append(" AND m.clie_oid_clie = c.oid_clie");
		consulta.append(" AND m.soci_oid_soci = so.oid_soci");
		consulta.append(" AND so.cod_usua = ?"); //usuario
		//insertado por incidencia 8031
		consulta.append(" AND l.cod_usua = ?"); //usuario
		consulta.append(" AND a.cod_usua = ?"); //usuario
		consulta.append(" AND sub.cod_usua = ?"); //usuario
		///
		consulta.append(" AND m.imp_pend <> 0");
		consulta.append(" AND m.masi_oid_marc_situ IN");
		//subconsulta del IN
		consulta.append(" (SELECT mta.masi_oid_marc_sali");
		consulta.append(" FROM ccc_marca_tipo_abono mta,");
		consulta.append(" ccc_tipo_abono_subpr tas,");
		consulta.append(" ccc_subpr s");
		consulta.append(" WHERE mta.tasp_oid_tipo_abon_subp = tas.oid_tipo_abon_subp");
		consulta.append(" AND tas.subp_oid_subp = s.oid_subp");
		consulta.append(" AND s.ccpr_oid_proc = ?"); //dto.proceso
		consulta.append(" AND s.cod_subp = ?"); //dto.Subproceso()
        consulta.append(" AND mta.IND_ENTR_SALI LIKE 'E')");

		Long oidIdioma = dto.getOidIdioma();
		Long proceso = dto.getProceso();
		String subproceso = dto.getSubproceso();

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(oidIdioma);//canal
		parametros.add(oidIdioma);//acceso
		parametros.add(oidIdioma);//subacceso
		parametros.add(oidIdioma);
		//parametros.add(oidIdioma);//descmoneda
		//parametros.add("USUARIO1");
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(proceso);
		parametros.add(subproceso);
		
		//condiciones adicionales si dto.parametro  != null
		// and so.oid_soci = dto.empresa
		if (dto.getEmpresa()!=null){
			consulta.append(" AND so.oid_soci = ?");
			parametros.add(dto.getEmpresa());
		}
		// and c.cod_clie = dto.cliente
		if (dto.getCliente()!=null){
			consulta.append(" AND c.cod_clie = ?");
			parametros.add(dto.getCliente());
		}
		// and m.num_iden_cuot = dto.identificadorCuota
		if (dto.getIdentificadorCuota()!=null){
			consulta.append(" AND m.num_iden_cuot = ?");
			parametros.add(dto.getIdentificadorCuota());
		}
		// and m.val_ejer_cuot = dto.ejercicioCuota
		if (dto.getEjercicioCuota()!=null){
			consulta.append(" AND m.val_ejer_cuot = ?");
			parametros.add(dto.getEjercicioCuota());
		}
		// and m.sbac_oid_sbac = dto.subAcceso
		if (dto.getSubacceso()!= null ){
			consulta.append(" AND m.sbac_oid_sbac = ?");
			parametros.add(dto.getSubacceso());
		}
		// and l.oid_cana = dto.canal
		if (dto.getCanal()!=null){
			consulta.append(" AND l.oid_cana = ?");
			parametros.add (dto.getCanal());
		}
		// and a.oid_acce = dto.acceiso
		if (dto.getAcceso()!=null){
			consulta.append(" AND a.oid_acce = ?");
			parametros.add(dto.getAcceso());
		}

		// La consulta debe ser paginada
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
		this.logSql("buscarCuotasPendientesCancelacion. SQL: ", sql, parametros);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql,parametros);
        } catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("buscarCuotasPendientesCancelacion: Exception",e);
			this.logSql("buscarCuotasPendientesCancelacion. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		if (resultado.esVacio()) {
			UtilidadesLog.debug("buscarCuotasPendientesCancelacion: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

		//Se devuelve un DTOSalida
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAOCuentasCorrientes.buscarCuotasPendientesCancelacion(DTOBuscarCuentasCorrientes dto): Salida ");
		return dtoSalida;
		
///// VIEJO /////
/*
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT m.OID_MOVI_CC OID, c.COD_CLIE, CONCAT(m.VAL_NUME_SERI_CUOT, LPAD(m.NUM_IDEN_CUOT, 8, 0)), ");
		consulta.append("m.NUM_ORDE_CUOT, m.VAL_NUME_LOTE_CONT, m.FEC_DOCU, m.FEC_VENC, ");

		// Subselect para obtener la descripcion del medio de pago
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = m.MPAB_OID_MEDI_PAGO AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = '"+BEL_MEDIO_PAGO+"') AS DESC_MEDI_PAGO, ");

		consulta.append("m.IMP_MOVI, m.IMP_PAGA, m.IMP_PEND PEND1, ");

		// Subselect para obtener la descripcion de la moneda 
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = m.MONE_OID_MONE AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = '"+SEG_MONED+"') AS DESC_MONE, ");

		consulta.append("m.IMP_DIVI, m.IMP_PEND PEND2, m.MPAB_OID_MEDI_PAGO, ");
		consulta.append("m.MONE_OID_MONE, m.OID_MOVI_CC OID2, '' VACIO2 ");
		consulta.append("FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c, VCA_SEG_SOCIE so ");
		consulta.append("WHERE m.CLIE_OID_CLIE = c.OID_CLIE AND ");
		consulta.append("m.SOCI_OID_SOCI = so.OID_SOCI AND ");
		consulta.append("so.COD_USUA = ? AND ");

		/* Eliminada esta parte de la consulta. Ver incidencia 2959
		consulta.append("m.TCAB_OID_TIPO_CARG_ABON IN ");
		consulta.append("(SELECT t.TCAB_OID_TCAB ");
		consulta.append("FROM CCC_TIPO_ABONO_SUBPR t, CCC_SUBPR s ");
		consulta.append("WHERE t.SUBP_OID_SUBP = s.OID_SUBP AND ");
		consulta.append("s.CCPR_OID_PROC = ?) AND ");*/
/*
		// Añadida esta condición. Ver incidencia 2959
		consulta.append("m.IMP_PEND > 0 AND ");
		
		consulta.append("m.MASI_OID_MARC_SITU IN ");
		consulta.append("(SELECT e.MASI_OID_MARC_SITU ");
		consulta.append("FROM CCC_MARCA_TIPO_ABONO m, CCC_SUBPR s, CCC_DETAL_MARCA_ENTRA e ");
		consulta.append("WHERE e.MTAB_OID_MARC_TIPO_ABON = m.OID_MARC_TIPO_ABON AND ");
		consulta.append("m.SUBP_OID_SUBP = s.OID_SUBP AND ");
		consulta.append("s.CCPR_OID_PROC = ? ");
		//Añadida ver incidencia 5115
		consulta.append("AND s.COD_SUBP = ?) ");

		Long oidIdioma = dto.getOidIdioma();
		Long proceso = dto.getProceso();
		String subproceso = dto.getSubproceso();

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(oidIdioma);
		parametros.add(oidIdioma);
		parametros.add(this.usuario);
		parametros.add(proceso);
		parametros.add(subproceso);

		// Sentencias adicionales si los campos del DTO no son nulos
		String cliente = dto.getCliente(); //incidencia BELC300005212
		Integer identificadorCuota =  dto.getIdentificadorCuota();
		Integer numeroOrdenCuota = dto.getNumeroOrdenCuota();
		Long empresa = dto.getEmpresa(); //incidencia 5115
		if (cliente != null) {
			consulta.append("AND c.COD_CLIE = ? "); //incidencia BELC300005212
			parametros.add(cliente);
		}
		if (identificadorCuota != null) {
			consulta.append("AND m.NUM_IDEN_CUOT = ? ");
			parametros.add(identificadorCuota);
		}
		if (numeroOrdenCuota != null) {
			consulta.append("AND m.NUM_ORDE_CUOT = ? ");
			parametros.add(numeroOrdenCuota);
		}
		if (empresa != null) {
			consulta.append("AND so.OID_SOCI = ? ");
			parametros.add(empresa);
		}

		// La consulta debe ser paginada
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
		this.logSql("buscarCuotasPendientesCancelacion. SQL: ",sql, parametros);
		
		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql, 
				parametros);
        } catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("buscarCuotasPendientesCancelacion: Exception",e);
			this.logSql("buscarCuotasPendientesCancelacion. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		if (resultado.esVacio()) {
			this.getLog().info("buscarCuotasPendientesCancelacion: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

		Se devuelve un DTOSalida
		DTOSalida dtoSalida = new DTOSalida(resultado);
		this.getLog().info("*** Método buscarCuotasPendientesCancelacion: Salida ***");
		return null; //dtoSalida;
*/
	}

	public DTOSalida buscarCuotasPendientes(DTOBuscarCuotasPendientes dto) throws MareException {
		        
        UtilidadesLog.info("DAOCuentasCorrientes.buscarCuotasPendientes(DTOBuscarCuotasPendientes dto): Entrada ");
		
		// Se crea la consulta SQL
		// Ver incidencias 3923
		StringBuffer consulta = new StringBuffer();
		/*consulta.append("SELECT b.OID_MOVI_BANC OID, ");

		// Subselect para obtener la descripcion de la sociedad
		// incidncia BELC300005218
		consulta.append("so.VAL_DENO AS DESC_SOCI, ");
		
		//incidencia BELC300007589
		consulta.append("b.COD_CONS, c.DES_CC, b.FEC_PAGO, b.IMP_PAGO IMP1, ");
		consulta.append("b.IMP_PAGO IMP2, c.OID_CUEN_CORR_BANC, b.OID_MOVI_BANC OID2, '' VACIA2 ");*/
		//Cambia la parte SELECT incidencia BELC300007598
		/*consulta.append(" SELECT b.CLIE_OID_CLIE,  m.COD_CLIE, c.DES_CC,");
		consulta.append(" b.FEC_PAGO, b.NUM_LOTE, b.NUM_CONS_TRAN, b.IMP_PAGO, ");
		consulta.append(" b.SALDO_PENDIENTE, b.SALDO_PENDIENTE, ");
		consulta.append(" c.OID_CUEN_CORR_BANC, b.OID_MOVI_BANC, '' ");*/

		// incidencia BELC300007589 (06/09/2004) - falta probar este metodo
		consulta.append("SELECT b.OID_MOVI_BANC as OID, ");
		consulta.append("m.COD_CLIE, ");
		consulta.append("c.DES_CC, ");
		consulta.append("b.FEC_PAGO, ");
		consulta.append("b.NUM_LOTE, ");
		consulta.append("b.NUM_CONS_TRAN, ");
		consulta.append("b.IMP_PAGO, ");
		consulta.append("b.IMP_SALD_PEND, ");
		// consulta.append("b.IMP_APLI, ");
		consulta.append("b.IMP_SALD_PEND as SALDO, ");
		consulta.append("c.OID_CUEN_CORR_BANC ");
			
		consulta.append("FROM CCC_MOVIM_BANCA b, CCC_CUENT_CORRI_BANCA c, ");
		//incidencia BELC300007598
		consulta.append("MAE_CLIEN m, VCA_SEG_SOCIE so ");

		consulta.append("WHERE b.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC AND ");
		//incidencia BELC300007598
		consulta.append(" CLIE_OID_CLIE = m.OID_CLIE AND ");

		consulta.append("so.COD_USUA = ? AND ");
		consulta.append("b.SOCI_OID_SOCI = so.OID_SOCI AND ");
		consulta.append("b.VAL_ESTA_MOVI_PEND = ? AND ");
		consulta.append("(b.COD_IDEN_PROC = ? OR ");
		consulta.append("b.COD_IDEN_PROC = ?) AND ");
		consulta.append("so.OID_SOCI = ? ");
    //mdolce 10/01/07 Segun consensuo AGuardiola, falta validar que el pendiente no sea 0 ni nulo
    consulta.append(" and b.IMP_SALD_PEND <> 0 ");
    consulta.append(" and b.IMP_SALD_PEND is not null ");
		
		String movimientoPendiente = CCCConstantes.MOVIMIENTO_BANCARIO_PENDIENTE ;
    //mdolce 10/01/07 Segun consensuo AGuardiola, debe ser procesado y no Transmitido
		String movimientoProcesado = CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO;
		String movimientoIncorrecto = CCCConstantes.MOVIMIENTO_BANCARIO_INCORRECTO;
		String empresa = dto.getEmpresa();				

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(this.usuario);
		//parametros.add("USUARIO1");
		parametros.add(movimientoPendiente);
		parametros.add(movimientoProcesado);
		parametros.add(movimientoIncorrecto);
		parametros.add(empresa);
		

		// Sentencias adicionales si los campos del DTO no son nulos
		String codigoCliente = dto.getCodigoCliente();
		Long cuota = dto.getCuota();
		if (codigoCliente != null) {
			consulta.append("AND m.COD_CLIE = ? ");
			parametros.add(codigoCliente);
		}
		if (cuota != null) {
			consulta.append("AND b.CCBA_OID_CC_BANC = ? ");
			parametros.add(cuota);
		}

		// La consulta debe ser paginada
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
		this.logSql("buscarCuotasPendientes. SQL: ",sql, parametros);
		
		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql, 
				parametros);
        } catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("buscarCuotasPendientes: Exception",e);
			this.logSql("buscarCuotasPendientes. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		if (resultado.esVacio()) {
			UtilidadesLog.debug("buscarCuotasPendientes: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

		// Se devuelve un DTOSalida
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAOCuentasCorrientes.buscarCuotasPendientes(DTOBuscarCuotasPendientes dto): Salida ");
		return dtoSalida;
	}

	public DTOSalida buscarSaldosMorosos(DTOBuscarSaldosMorosos dto, Long proceso)
		throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.buscarSaldosMorosos(DTOBuscarSaldosMorosos dto, Long proceso): Entrada ");
        
 	SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");		
        String clienteDesde = dto.getClienteDesde();
        String clienteHasta = dto.getClienteHasta();
        Date fechaDocumentoDesde = null;
        if (dto.getFechaDocumentoDesde() != null) {
            fechaDocumentoDesde = new Date(dto.getFechaDocumentoDesde().getTime());
        }
        Date fechaDocumentoHasta = null;
        if (dto.getFechaDocumentoHasta() != null) {
            fechaDocumentoHasta = new Date(dto.getFechaDocumentoHasta().getTime());
        }
        
        Double importeDesde = dto.getImporteDesde();
        Double importeHasta = dto.getImporteHasta();
        
        Long empresa = dto.getEmpresa();
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT m.OID_MOVI_CC OID , u.VAL_DENO,");

		//Subselect para obtener la descripcion del canal
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("WHERE v.VAL_OID = l.oid_cana AND v.IDIO_OID_IDIO = ? ");
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND v.ATTR_ENTI = '"+SEG_CANAL+"') AS DESC_CANAL, ");
		parametros.add(dto.getOidIdioma());
		
		//Subselect para obtener la descripcion del acceso
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("WHERE v.VAL_OID = a.oid_acce AND v.IDIO_OID_IDIO = ? ");
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND v.ATTR_ENTI = '"+SEG_ACCES+"') AS DESC_ACCESO, ");
		parametros.add(dto.getOidIdioma());
		
		//Subselect para obtener la descripcion del subacceso
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("WHERE v.VAL_OID = s.oid_sbac AND v.IDIO_OID_IDIO = ? ");
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND v.ATTR_ENTI = '"+SEG_SUBAC+"') AS DESC_SUBACCESO, ");
		parametros.add(dto.getOidIdioma());
		
        consulta.append(" m.NUM_IDEN_CUOT, ");
        consulta.append(" m.VAL_EJER_CUOT, m.NUM_ORDE_CUOT, c.COD_CLIE, ");
        consulta.append(" m.FEC_DOCU, m.FEC_VENC,  ");
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append(" WHERE v.VAL_OID = m.MPAB_OID_MEDI_PAGO AND ");
        consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
        consulta.append(" v.ATTR_ENTI = 'BEL_MEDIO_PAGO') AS DESC_MEDI_PAGO ,  ");
        parametros.add(dto.getOidIdioma());
		consulta.append(" m.IMP_PEND ");
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c,  VCA_SEG_SUBAC s, ");
		//la tabla cra desaparece por la incidencia 10240
        //consulta.append(" VCA_SEG_ACCES a, VCA_SEG_CANAL l, VCA_SEG_SOCIE u , CRA_PERIO p ");
		consulta.append(" VCA_SEG_ACCES a, VCA_SEG_CANAL l, VCA_SEG_SOCIE u  ");
                
        if (dto.getOidPeriodoDesde() != null || dto.getOidPeriodoHasta() != null) {
            consulta.append(" , cra_perio perio");
        }
        
        // SPLATAS - DBLG700000225 - 21/11/2006
        if( dto.getOidPeriodoDesde() != null ){   
            consulta.append(" , cra_perio perioDesde");
        }
        
        // SPLATAS - DBLG700000225 - 21/11/2006
        if( dto.getOidPeriodoHasta() != null ){   
            consulta.append(" , cra_perio perioHasta");
        }        
        
        consulta.append(" WHERE m.CLIE_OID_CLIE = c.OID_CLIE AND ");
        consulta.append(" m.SBAC_OID_SBAC = s.OID_SBAC AND ");
        consulta.append(" s.ACCE_OID_ACCE = a.OID_ACCE AND ");
        consulta.append(" a.CANA_OID_CANA = l.OID_CANA AND ");
		//quitado por incidencia 10240
		//consulta.append(" m.PERD_OID_PERI = p.OID_PERI AND ");
        consulta.append(" m.SOCI_OID_SOCI = u.OID_SOCI AND ");
        
        // SPLATAS - DBLG700000225 - 15/11/2006
        //consulta.append(" m.COD_USUA = ? AND ");
        //parametros.add(usuario);
        
        consulta.append(" u.COD_USUA = ? AND ");
        parametros.add(usuario);
        consulta.append(" a.COD_USUA = ? AND ");
        parametros.add(usuario);
        consulta.append(" l.COD_USUA = ? AND");
		parametros.add(usuario);
		consulta.append(" s.COD_USUA = ? AND");
        parametros.add(usuario);

        consulta.append(" m.MASI_OID_MARC_SITU IN ");
        consulta.append(" (SELECT r.OID_MARC_SITU FROM CCC_MARCA_SITUA r, ");
        consulta.append(" CCC_MARCA_TIPO_ABONO m, CCC_TIPO_ABONO_SUBPR t, ");
        consulta.append(" CCC_SUBPR s,CCC_PROCE p ");
        consulta.append(" WHERE r.OID_MARC_SITU = m.MASI_OID_MARC_SALI AND ");
        consulta.append(" m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP AND ");
        consulta.append(" t.SUBP_OID_SUBP = s.OID_SUBP AND ");
        consulta.append(" s.CCPR_OID_PROC = p.OID_PROC AND ");
        consulta.append(" p.OID_PROC = ? AND m.IND_ENTR_SALI like 'E') ");
        parametros.add(proceso);
        consulta.append(" AND IMP_PEND <> 0 ");

		// Insertados filtros por incidencia 9046
        if (dto.getOidPeriodoDesde() != null || dto.getOidPeriodoHasta() != null) {
            consulta.append(" AND m.perd_oid_peri = perio.oid_peri  ");
        }
                
        
        if (dto.getOidPeriodoDesde() != null) {
            /* SPLATAS - DBLG700000225 - 21/11/2006
            consulta.append(" AND perio.fec_inic >= (SELECT cra_perio.FEC_INIC  ");
            consulta.append("                          FROM cra_perio  ");
            consulta.append("                         WHERE cra_perio.OID_PERI = ?)  ");
            */
            consulta.append(" and perioDesde.PERI_OID_PERI = ? ");            
            parametros.add(dto.getOidPeriodoDesde());
            consulta.append(" and perioDesde.CANA_OID_CANA = ? ");
            parametros.add(dto.getCanal());
            consulta.append(" and perioDesde.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
            consulta.append(" and perioDesde.MARC_OID_MARC = m.MARC_OID_MARC ");            
            consulta.append(" and perio.FEC_INIC >= perioDesde.FEC_INIC ");
            
        }
        
        if (dto.getOidPeriodoHasta() != null) {
            /* SPLATAS - DBLG700000225 - 21/11/2006
            consulta.append(" AND perio.fec_fina <= (SELECT cra_perio.FEC_FINA  ");
            consulta.append("                          FROM cra_perio  ");
            consulta.append("                         WHERE cra_perio.OID_PERI = ?)  ");
            */
            consulta.append(" and perioHasta.PERI_OID_PERI = ? ");
            parametros.add(dto.getOidPeriodoHasta());
            consulta.append(" and perioHasta.CANA_OID_CANA = ? ");
            parametros.add(dto.getCanal());
            consulta.append(" and perioHasta.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
            consulta.append(" and perioHasta.MARC_OID_MARC = m.MARC_OID_MARC ");
            consulta.append(" and perio.FEC_FINA <= perioHasta.FEC_FINA ");
                        
        }

        if (dto.getFechaVencimientoDesde() != null) {
			java.sql.Date fecvencD = new java.sql.Date(dto.getFechaVencimientoDesde().getTime());
			String sFechaDesde = formato.format(fecvencD);  
			consulta.append(" AND (m.FEC_VENC >= TO_DATE( ? ,'YYYY-MM-DD') ) "); 
			parametros.add(sFechaDesde);
        }
        if (dto.getFechaVencimientoHasta() != null) {
			java.sql.Date fecvencH = new java.sql.Date(dto.getFechaVencimientoHasta().getTime());
			String sFechaHasta = formato.format(fecvencH);  
			consulta.append(" AND (m.FEC_VENC <= TO_DATE( ? ,'YYYY-MM-DD') ) "); 
			parametros.add(sFechaHasta);
        }
        
        //if(tipoCargoAbono != null)
        //{
        //    consulta.append(" AND m.TCAB_OID_TCAB_ULTI = ? ");
        //    consulta.append(" AND m.TCAB_OID_TCAB_CREA = ? ");
        //    parametros.add(tipoCargoAbono);
        //    parametros.add(tipoCargoAbono);
        //}
		/* NO SE FILTRA POR ESTOS CAMPOS: Incidencia 9046
        if(subacceso != null)
        {
            consulta.append(" AND s.OID_SBAC = ? ");
            parametros.add(subacceso);
        }
        if(acceso != null)
        {
            consulta.append(" AND a.OID_ACCE = ? ");
            parametros.add(acceso);
        }
        if(canal != null)
        {
            consulta.append(" AND a.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        if(fechaImputacion != null)
        {
            consulta.append(" AND m.FEC_VENC = ? ");
			//parametros.add(fechaImputacion);
			java.sql.Date fecven = new java.sql.Date(fechaImputacion.getTime());
			StringBuffer fechaStringVen=new StringBuffer();
			StringBuffer fecha=formato.format(fecven, fechaStringVen, pos);
			parametros.add(fechaStringVen.toString());

        }
        //if(referenciaExterna != null)
        //{
        //    consulta.append(" AND m.VAL_REFE_NUME_DOCU_EXTE = ? ");
        //    parametros.add(referenciaExterna);
        //}
		*/
        if (clienteDesde != null) {
            consulta.append(" AND c.COD_CLIE >= ? ");
            parametros.add(clienteDesde);
        }
        if(clienteHasta != null) {
            consulta.append(" AND c.COD_CLIE <= ? ");
            parametros.add(clienteHasta);
        }

        if(fechaDocumentoDesde != null) {
			java.sql.Date fecdocuD = new java.sql.Date(dto.getFechaDocumentoDesde().getTime());
			String sFechaDocuD = formato.format(fecdocuD);  
			// Se cambia porque no filtra bien
            //consulta.append(" AND (m.FEC_DOCU >= TO_DATE( ? ,'YYYY-MM-DD') ) "); 
            consulta.append(" AND TO_DATE(TO_CHAR(m.FEC_DOCU, 'YYYY-MM-DD'), 'YYYY-MM-DD')  >=  TO_DATE( ? ,'YYYY-MM-DD')  "); 
			parametros.add(sFechaDocuD);
        }
        if(fechaDocumentoHasta != null) {
			java.sql.Date fecdocuH = new java.sql.Date(dto.getFechaDocumentoHasta().getTime());
			String sFechaDocuH = formato.format(fecdocuH);  
            // Se cambia porque no filtra bien
			//consulta.append(" AND (m.FEC_DOCU <= TO_DATE( ? ,'YYYY-MM-DD') ) "); 
            consulta.append(" AND TO_DATE(TO_CHAR(m.FEC_DOCU, 'YYYY-MM-DD'), 'YYYY-MM-DD')  <=  TO_DATE( ? ,'YYYY-MM-DD')  "); 
			parametros.add(sFechaDocuH);
        }
        if(importeDesde != null) {
            // SPLATAS - DBLG700000225 - 13/11/2006
            consulta.append(" AND m.IMP_MOVI >= ? ");
            parametros.add(importeDesde);
        }
        if(importeHasta != null) {
            // SPLATAS - DBLG700000225 - 13/11/2006
            consulta.append(" AND m.IMP_MOVI <= ? ");
            parametros.add(importeHasta);
        }
        if(empresa != null) {
            consulta.append(" AND m.SOCI_OID_SOCI = ? ");
            parametros.add(empresa);
        }
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);
		UtilidadesLog.debug("SQL Paginada= " + sqlPaginada);
        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        }
        catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("buscarSaldosMorosos: Exception", e);
            logSql("buscarSaldosMorosos. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida(resultado);
        logSql("buscarSaldosMorosos. SQL: ", consulta.toString(), parametros);
        UtilidadesLog.info("DAOCuentasCorrientes.buscarSaldosMorosos(DTOBuscarSaldosMorosos dto, Long proceso): Salida ");
        return dtoSalida;
	}

	// **********************  METODO CDOS ****************
	public RecordSet obtenerCuentasCorrientesBanco(DTOOID dto) throws MareException {

        UtilidadesLog.info("DAOCuentasCorrientes.obtenerCuentasCorrientesBanco(DTOOID dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append("  SELECT c.oid_cuen_corr_banc, c.des_cc  ");
        query.append("  FROM ccc_cuent_corri_banca c, ccc_sucur s  ");
        query.append("  WHERE c.sucu_oid_sucu = s.oid_sucu AND s.cban_oid_banc = " + dto.getOid());
		query.append("  ORDER BY c.DES_CC ASC ");
        
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerCuentasCorrientesBanco(DTOOID dto): Salida ");
        return rs;
    }
    
 	// **********************  METODO CDOS ****************   
    public RecordSet recargaCC(DTOBelcorp dto) throws MareException {

        UtilidadesLog.info("DAOCuentasCorrientes.recargaCC(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append("  SELECT c.oid_cuen_corr_banc, c.des_cc, c.SUCU_OID_SUCU  ");
        query.append("    FROM ccc_cuent_corri_banca c");
        query.append("   ORDER BY c.DES_CC ASC ");
        
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCuentasCorrientes.recargaCC(DTOBelcorp dto): Salida ");
        return rs;
    }

	//************** Metodo de CDOS********************************************
    //modificaciones: 12/07/2005 - BELC300017903 - pperanzola

    public DTOSalida buscarLotesMovimientosBancarios(DTOBuscarLotesTrabajo dto) throws MareException {

        UtilidadesLog.info("DAOCuentasCorrientes.buscarLotesMovimientosBancarios(DTOBuscarLotesTrabajo dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT  v.num_line OID, cc.des_cc, fec_pago, v.num_lote, v.imp_tota, des_banc, v.oid_mov ");
        query.append("   FROM V_CCC_LOTES_MOVIM v, CCC_CUENT_CORRI_BANCA cc   ");
        query.append("  WHERE cc.OID_CUEN_CORR_BANC = v.OID_CUEN_CORR_BANC  ");

        
        if (dto.getNumeroLote() != null)  {
            query.append(" AND v.NUM_LOTE = " + dto.getNumeroLote());
        }
        
       if (dto.getFechaMovimiento() != null)  {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovimiento = sdf.format(dto.getFechaMovimiento());
            query.append(" AND  v.FEC_PAGO = TO_DATE('" + fechaMovimiento + "', 'dd/MM/yyyy')");
        }
       
        if (dto.getCuentaCorriente() != null)  {
            query.append(" AND  v.OID_CUEN_CORR_BANC = " + dto.getCuentaCorriente() );  
        }
        if (dto.getBanco() != null)  {
            query.append(" AND v.OID_BANC = " + dto.getBanco());

        }    
        UtilidadesLog.debug("Esta es la query: " + query.toString());
        try  {

            String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
            rs = getBelcorpService().dbService.executeStaticQuery(sql);


            UtilidadesLog.info("query.toString()" + query.toString());
          /*  if (rs.esVacio())  {
               throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
            }           
        } catch (MareException me)  {
            throw me;*/			
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

		if (rs.esVacio())  {
               throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
        }
	   
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOCuentasCorrientes.buscarLotesMovimientosBancarios(DTOBuscarLotesTrabajo dto): Salida ");
        return dtoSalida;
    }

	//**************** Metodo de CDOS ***************************************
    public DTOSalida obtenerTiposTransaccion(DTOBelcorp dto) throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerTiposTransaccion(DTOBelcorp dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" SELECT c.oid_tipo_tran, v.val_i18n,  c.COD_TIPO_TRAN ");
        query.append("   FROM ccc_tipo_trans c, v_gen_i18n_sicc v");
        query.append("  WHERE c.pais_oid_pais = " + dto.getOidPais());
        query.append("    AND c.oid_tipo_tran = v.val_oid ");
        query.append("    AND v.idio_oid_idio = " + dto.getOidIdioma());
        query.append("    AND v.attr_enti = 'CCC_TIPO_TRANS'  ");
        query.append("    AND v.attr_num_atri = 1");
		query.append("    ORDER BY v.VAL_I18N ASC");
		
        try  {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
			UtilidadesLog.debug("contenido de rs ===>>> " + rs);            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);  
		UtilidadesLog.debug("contenido de dtoSalida::: " + dtoSalida);
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerTiposTransaccion(DTOBelcorp dto): Salida ");
        return dtoSalida;
    }

	//************* Método de CDOS ************************************
    public Long[] comprobarLoteContabilizado(Long oid) throws MareException {
      
        UtilidadesLog.info("DAOCuentasCorrientes.comprobarLoteContabilizado(Long oid): Entrada ");
        Long[] movimBanc = null;
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT DISTINCT m.oid_movi_banc, m.fec_cont,              ");
        query.append("                 m.val_esta_movi_pend, m.num_lote,         ");
		query.append("                 m.COD_IDEN_PROC, m.NUM_HIST               ");		
        query.append("            FROM ccc_movim_banca m, v_ccc_lotes_movim l    ");
        query.append("           WHERE l.num_lote = m.num_lote                   ");
        query.append("             AND (   (l.fec_pago = m.fec_pago)             ");
        query.append("                  OR (l.fec_pago IS NULL AND m.fec_pago IS NULL)  ");
        query.append("                 )                                         ");
        query.append("             AND (   (l.fec_cont = m.fec_cont)             ");
        query.append("                  OR (l.fec_cont IS NULL AND m.fec_cont IS NULL)  ");
        query.append("                 )                                         ");
        query.append("             AND l.oid_cuen_corr_banc = m.ccba_oid_cc_banc ");
        query.append("             AND l.num_line =  " + oid);
        
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs.getRowCount "  + rs.getRowCount());
			UtilidadesLog.debug("rs>>>>" + rs);
            movimBanc = new Long[rs.getRowCount()];            
            for ( int i=0 ;i<rs.getRowCount() ; i++ )  {
                UtilidadesLog.debug("Antes de rs.getValueAt(i,1) " + rs.getValueAt(i,1));
				
                Date fechaConta = (Date)rs.getValueAt(i,1);
                UtilidadesLog.debug(" + " + fechaConta);
				
                UtilidadesLog.debug("  -----------   ");
                String idProceso = (String)rs.getValueAt(i,4);
				UtilidadesLog.debug("idProceso >>>> " + rs.getValueAt(i,4));
				
				String numHistoria = rs.getValueAt(i,5).toString();
				UtilidadesLog.debug("numHistoria >>>> " + rs.getValueAt(i,5));		
				
				
                if (idProceso == null)  {
                    idProceso = "";
                }
				
                if (( fechaConta != null) || (idProceso.equals(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO)) || (!numHistoria.equals("0"))){
					    UtilidadesLog.debug("Entro a la exception ");                      
			   		    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.CCC_0038) );
                        // throw new LoteContabilizadoException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",ErroresDeNegocio.CCC_0038) );
			      } else {
						 UtilidadesLog.debug("444444444444444   No se genero una LoteContabilizadoException");
					     movimBanc[i] = new Long(((BigDecimal)rs.getValueAt(i,0)).longValue());
						 UtilidadesLog.debug("contendido de i>>> " + movimBanc[i] );             
                }                
            }
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("Este es el movimiento bancario " + movimBanc);
        UtilidadesLog.info("DAOCuentasCorrientes.comprobarLoteContabilizado(Long oid): Salida ");
        return movimBanc;
    }


	//*********** 
	
    /**
     * @author ****************  METODO CDOS *********************
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * modificaciones - Incidencia 7626
     *                - BELC300017903   - 13/07/2005 -  pperanzola  se reestructura todo el qry
     */
	public DTOSalida obtenerMovimientosLote(DTOOID dto) throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovimientosLote(DTOOID dto): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT  ");
            query.append(" m2.OID_MOVI_BANC,  m2.FEC_CONT,  m2.NUM_HIST,  m2.COD_IDEN_PROC , m2.NUM_LOTE ");
        query.append(" FROM ");
            query.append("  ccc_movim_banca m2, ");
            query.append("  (SELECT ");
            query.append("      mv.CCBA_OID_CC_BANC a ,mv.FEC_PAGO b ,mv.NUM_LOTE c  ");
            query.append("   FROM ");
            query.append("      ccc_movim_banca mv  ");
            query.append("   WHERE   ");
            query.append("      OID_MOVI_BANC= " + dto.getOid() + ") filtro   ");
        query.append("   WHERE ");
            query.append("     filtro.a=m2.CCBA_OID_CC_BANC ");
            query.append(" AND filtro.b=m2.FEC_PAGO ");
            query.append(" AND filtro.c=m2.NUM_LOTE ");
        /*query.append(" SELECT DISTINCT m.oid_movi_banc, c.des_cc, m.fec_pago, m.num_lote,  ");
        //Se trae COD_CLIE en lugar de OID_CLIE segun INC
        //query.append("                 m.num_cons_tran, v.val_i18n tipoTransaccion, m.imp_pago, te.OID_CLIE consReal, ");
        query.append("                 m.num_cons_tran, v.val_i18n tipoTransaccion, m.imp_pago, te.COD_CLIE consReal, ");
        query.append("                 m.cod_cons, m.num_fact_bole, m.val_digi_cheq_fact, m.num_cupo, ");
        query.append("                 m.val_nume_docu, m.COD_OFIC_RECA, ");
        query.append("                 m.VAL_NOMB_OFIC, m.VAL_HORA_NORM_ADIC, m.VAL_USUA_proc, ");
        query.append("                 m.fec_proc, m.VAL_HORA_proc, m.cod_erro, ");
        query.append("                 m.VAL_ESTA_MOVI_PEND, m.cod_iden_proc, m.val_obse ");
        query.append("            FROM ccc_movim_banca m,       ");
        query.append("                 v_ccc_lotes_movim l,     ");
        query.append("                 ccc_cuent_corri_banca c, ");
        query.append("                 ccc_sucur su,            ");
        query.append("                 ccc_banco ba,  ");
		query.append("                 MAE_CLIEN te,  ");
        query.append("                 v_gen_i18n_sicc v  ");
        query.append("           WHERE c.oid_cuen_corr_banc = m.ccba_oid_cc_banc ");
        query.append("             AND su.oid_sucu = c.sucu_oid_sucu ");
        query.append("             AND su.cban_oid_banc = ba.oid_banc ");
        query.append("             AND l.num_lote = m.num_lote  ");
        query.append("             AND (   (l.fec_pago = m.fec_pago)  ");
        query.append("                  OR (l.fec_pago IS NULL AND m.fec_pago IS NULL) ");
        query.append("                 )   ");
        query.append("             AND (   (l.fec_cont = m.fec_cont) ");
        query.append("                  OR (l.fec_cont IS NULL AND m.fec_cont IS NULL)   ");
        query.append("                 )   ");
        query.append("             AND l.oid_cuen_corr_banc = c.oid_cuen_corr_banc ");
        query.append("             AND l.oid_banc = ba.oid_banc    ");
		query.append("             AND te.OID_CLIE = m.CLIE_OID_CLIE  ");
        query.append("             AND l.num_lote =  " +  dto.getNumeroLinea());        
		query.append("			   AND ((m.ttra_oid_tipo_trans = v.val_oid)	 ");
		query.append("			   OR (m.ttra_oid_tipo_trans IS NULL	 ");
		query.append(" 			   OR v.val_oid IS NULL))	");
        query.append("             AND v.attr_num_atri = 1  ");
        query.append("             AND v.idio_oid_idio = " +  dto.getOidIdioma());
        query.append("             AND v.attr_enti = 'CCC_TIPO_TRANS'  ");
        */
        
        try  {

            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs); 
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovimientosLote(DTOOID dto): Salida ");
        return dtoSalida;
    }

	// BELC300004891
	public DTOSalida obtenerDetalleMovimientos(DTOOIDs dto) throws MareException {
		/*
		 * Hacemos la consulta JDBC: 
		 * SELECT m.OID_MOVI_CC, m.VAL_NUME_SERI_CUOT, m.NUM_IDEN_CUOT, m.VAL_EJER_CUOT, m.NUM_ORDE_CUOT, c.COD_CLIE, m.FEC_DOCU, m.FEC_VENC, m.IMP_MOVI, m.MPAB_OID_MEDI_PAGO 
		 * FROM CCC_MOVIM_CUENT_CORRI m JOIN MAE_CLIEN c ON (m.CLIE_OID_CLIE = c.OID_CLIE) 
		 * WHERE OID_MOVI_CC IN (ponemos la lista del oids del dto) 
		 * Devolvemos el resultado de la consulta
		 */
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerDetalleMovimientos(DTOOIDs dto): Entrada ");

		StringBuffer sql = new StringBuffer("");
		sql.append("SELECT m.OID_MOVI_CC, m.VAL_NUME_SERI_CUOT, m.NUM_IDEN_CUOT, ");
		sql.append("m.VAL_EJER_CUOT, m.NUM_ORDE_CUOT, c.COD_CLIE, m.FEC_DOCU, ");
		sql.append("m.FEC_VENC, m.IMP_MOVI, m.MPAB_OID_MEDI_PAGO ");
		sql.append("FROM CCC_MOVIM_CUENT_CORRI m JOIN MAE_CLIEN c ON (m.CLIE_OID_CLIE = c.OID_CLIE) ");

		Vector parametros = new Vector();
		if (dto != null && dto.getOids() != null) {
			sql.append("WHERE OID_MOVI_CC IN ( ");
			Long oids[] = dto.getOids();
			for (int i=0; i<oids.length; i++) {
				sql.append("?,");
				parametros.addElement(oids[i]);				
			}
			sql.deleteCharAt(sql.length()-1);
			sql.append(" ) ");
		}

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql.toString(),parametros);
        } catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerDetalleMovimientos: Exception",e);
			this.logSql("obtenerDetalleMovimientos. SQL: ",sql.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		// Se devuelve un DTOSalida
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerDetalleMovimientos(DTOOIDs dto): Salida ");
		return dtoSalida;		
	}

   public RecordSet obtenerMovCCSolicitudPedido(Long oidPais, Long oidCliente,
        Long oidEmpresa, String ejercicioCuota, Integer numeroIdentCuota, 
        Long oidPedidoSolicCab, Long oidsMarcasEntrada []) throws MareException {

		UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovCCSolicitudPedido(Long oidPais, Long oidCliente, Long oidEmpresa, String ejercicioCuota, Integer numeroIdentCuota,  Long oidPedidoSolicCab, Long oidsMarcasEntrada []): Entrada ");
        // Parametros de la consulta
        Vector parametros = new Vector(); 
        StringBuffer consulta = new StringBuffer();
        String strOids = null;
        if (oidsMarcasEntrada != null){
            strOids = this.cadenaInt(oidsMarcasEntrada);
        }
        int i=0;
         
        consulta.append("SELECT m.* " );
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m" );
        consulta.append(" , MAE_CLIEN c " );
        consulta.append(" WHERE c.OID_CLIE = m.CLIE_OID_CLIE ");
        if ( oidPais != null ){
            consulta.append(" AND c.PAIS_OID_PAIS= ? ");
            parametros.add(oidPais);
        }
        if ( oidCliente != null ){
            consulta.append(" AND m.CLIE_OID_CLIE = ? ");
            parametros.add(oidCliente);
        }
        if ( oidEmpresa != null ){
            consulta.append(" AND m.SOCI_OID_SOCI  = ? ");
            parametros.add(oidEmpresa );
        }
        if ( oidsMarcasEntrada!= null && !strOids.equals("") ){ 
            consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");
            for( i=0; i < oidsMarcasEntrada.length; i++){
                parametros.add(oidsMarcasEntrada[i]);
            }
        }
        if ( ejercicioCuota != null ){
            consulta.append(" AND m.VAL_EJER_CUOT  = ? ");
            parametros.add(ejercicioCuota );
        }
        if ( numeroIdentCuota != null){
            consulta.append(" AND m.NUM_IDEN_CUOT   = ? ");
            parametros.add(numeroIdentCuota);
        }
        if ( oidPedidoSolicCab != null ){	
            consulta.append(" AND m.SOCA_OID_SOLI_CABE   = ? ");
             parametros.add(oidPedidoSolicCab);
        }
        consulta.append(" AND m.IMP_PEND > 0 ");
        consulta.append(" ORDER BY m.NUM_ORDE_CUOT ASC ");
  
        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
                parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerUltimoMovHistBancario: Exception",e);
            this.logSql("obtenerUltimoMovHistBancario. SQL: ",consulta.toString(),
                parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }         
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovCCSolicitudPedido(Long oidPais, Long oidCliente, Long oidEmpresa, String ejercicioCuota, Integer numeroIdentCuota,  Long oidPedidoSolicCab, Long oidsMarcasEntrada []): Salida");
        return resultado;            
    }
    
   /*	
     *       @ssaavedr 25/04/2006 -> Se agrega el parámetro de entrada String tipoDeuda y se recuperan los movimientos con 
     *       importe pendiente >0 o <0 según el tipoDeuda.     	
     *       (Cancelación automática de deuda positiva y negativa.doc)
   */
	public RecordSet obtenerMovCCIndicadorEmisionVto(String indEmisionVto, Long oidPais, 
		Long oidCliente, Long oidEmpresa, Long oidMoneda, Long oidsMarcasEntrada[], String tipoDeuda) 
		throws MareException {
		//BELC300008036 tipos de los parametros
		//BELC300008175  Long oidsMarcasEntrada[]
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovCCIndicadorEmisionVto(String indEmisionVto, Long oidPais, Long oidCliente, Long oidEmpresa, Long oidMoneda, Long oidsMarcasEntrada[]): Entrada ");

		RecordSet resultado = null;
		StringBuffer consulta = new StringBuffer();
		String codigoError = null;
		Vector parametros = new Vector();
		String strOids = null;
		if (oidsMarcasEntrada != null){
			strOids = this.cadenaInt(oidsMarcasEntrada);
		}
		
		//se crea la consulta SQL 
		consulta.append("SELECT m.* ");
		consulta.append("FROM CCC_MOVIM_CUENT_CORRI m, ");
		consulta.append("SEG_SOCIE s ");
		consulta.append("WHERE m.SOCI_OID_SOCI = s.OID_SOCI ");
		
		if ( oidPais != null ) {
			consulta.append("AND s.PAIS_OID_PAIS = ? "); //parametro1: oidPais
			parametros.add(oidPais);
		}
		if ( oidCliente != null ) {
			consulta.append("AND m.CLIE_OID_CLIE = ? "); //parametro2: oidCliente
			parametros.add(oidCliente);
		}
		if ( oidEmpresa != null ) {
			consulta.append("AND m.SOCI_OID_SOCI = ? "); //parametro3: oidEmpresa
			parametros.add(oidEmpresa );
		}
		if ( oidMoneda != null ) {
			consulta.append("AND m.MONE_OID_MONE = ? ");  //parametro4: oidMoneda
			parametros.add(oidMoneda);
		}
        //@ssaavedr 24/04/2006, quitado por cbios. P2 E.Arese        
		/*consulta.append("AND m.IMP_PEND > 0 ");*/
        if (tipoDeuda.equals(String.valueOf('N'))) 
        {
            consulta.append("AND m.IMP_PEND > 0 ");
        }
        if (tipoDeuda.equals(String.valueOf('P'))) 
        {
            consulta.append("AND m.IMP_PEND < 0 ");    
        }
        
		if ( oidsMarcasEntrada!= null && !strOids.equals("") ) {
			//modificado segun decu @ssaavedr consulta.append("AND m.MARC_OID_MARC IN (" + strOids + ") "); //parametro5: oidsMarcasEntrada
            consulta.append("AND m.MASI_OID_MARC_SITU IN (" + strOids + ") "); //parametro5: oidsMarcasEntrada
			for (int i=0; i < oidsMarcasEntrada.length; i++) {
				parametros.add(oidsMarcasEntrada[i]);
			}
		}
		if(indEmisionVto == "1") {	//por fecha de facturación
			//@ssaavedr 24/10/2005...Inc.: BELC300021276    consulta.append(" ORDER BY FEC_VALO ");
            consulta.append(" ORDER BY FEC_DOCU ");
		} else {	//por fecha Vto
			consulta.append(" ORDER BY FEC_VENC ");
		}        
					
		//se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerMovCCIndicadorEmisionVto: Exception", e);
			this.logSql("obtenerMovCCIndicadorEmisionVto. SQL: ",consulta.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovCCIndicadorEmisionVto(String indEmisionVto, Long oidPais, Long oidCliente, Long oidEmpresa, Long oidMoneda, Long oidsMarcasEntrada[]): Salida");
		return resultado;
	}

	private void logError(String mensaje,Throwable e) {
    
		UtilidadesLog.error("*** Error Metodo " + mensaje + ": " + e.getMessage());
		this.logStackTrace(e);
	}

	private void logStackTrace(Throwable e) {
		try {						
			UtilidadesLog.error(e);
		} catch(Exception ex) {
			UtilidadesLog.error("Traza de la pila: "+ex.getMessage());
		}			
	}

	private void logSql(String metodo, String sql, Vector params) {
    
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size(); i++) {
				sParams += "param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}
    
    private String cadenaInt(Long cadena []) {
        
        UtilidadesLog.info("DAOCuentasCorrientes.cadenaInt(Long cadena []): Entrada");
        int i;
        int size = cadena.length;
        StringBuffer sentencia = new StringBuffer("");
        String retorno = "";
        if (size > 0) {
            for (i = 0; i < size; i++) {
                sentencia.append(" ?, ");
            }
            //Quitamos la coma y el espacio del final
            retorno = sentencia.substring(0, sentencia.length() - 2);
        }
        UtilidadesLog.info("DAOCuentasCorrientes.cadenaInt(Long cadena []): Salida");
        return retorno;    
    }

	public RecordSet bloquearBloqueoMovBanc() throws MareException {
		/**
		 * Obtenemos los OIDs que el usuario actual tiene bloqueados y bloqueamos la tabla de bloqueos para que no 
		 * se pueda modificar mientras se ejecuta la actualización de datos en las tablas de Movimientos. 
		 * SELECT OID_BLOQ_MOVI FROM CCC_BLOQU_MOVIM_BANCO WHERE COD_USUA = usuario FOR UPDATE 
		 * Devolvemos el recordset con una columna de OIDs 
		 */
		UtilidadesLog.info("DAOCuentasCorrientes.bloquearBloqueoMovBanc(): Entrada");		
		
                RecordSet rs;	
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT b.OID_BLOQ_MOVI oids ");
		consulta.append(" FROM CCC_BLOQU_MOVIM_BANCO b ");
		consulta.append(" WHERE b.COD_USUA = '" + this.usuario + "' ");
		consulta.append(" FOR UPDATE ");

		try  {

            rs = getBelcorpService().dbService.executeStaticQuery(consulta.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
		UtilidadesLog.debug("contenido de  dtoSalida -- " + rs);
		UtilidadesLog.info("DAOCuentasCorrientes.bloquearBloqueoMovBanc(): Salida");
        return rs;
    }

	public DTONumeroRegistros eliminarBloqueoMovBanc(String usuario) throws MareException {
	/**
	 * //Concepto 
	 *	Elimina todos los registros pertenecientes al usuario en cuestión. 
	 *
	 *	//Parámetros de e/s 
	 *	Entrada: String usuario 
	 * Salida: DTONumeroRegistros numeroRegistrosBorrados 
	 *
	 * //Proceso 
	 * DELETE FROM CCC_BLOQU_MOVIM_BANCO WHERE COD_USUA = usuario 
	 *
	 * return new DTONumeroRegistros(numeroRegistrosBorrados);
	 */
		UtilidadesLog.info("DAOCuentasCorrientes.eliminarBloqueoMovBanc(String usuario): Entrada");		
                
                int numrs = 0;	        
		StringBuffer consulta = new StringBuffer();
		consulta.append(" DELETE FROM CCC_BLOQU_MOVIM_BANCO b ");
		consulta.append(" WHERE b.COD_USUA = '" + usuario + "' ");

		try  {

            numrs = new Long(getBelcorpService().dbService.executeUpdate(consulta.toString())).intValue();
            UtilidadesLog.debug("numrs: " + numrs);
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
		DTONumeroRegistros dtoNumeroRegistrosBorrados = new DTONumeroRegistros();
    		dtoNumeroRegistrosBorrados.setNumeroRegistros(new Long(numrs));	
        UtilidadesLog.debug("dtoNumeroRegistrosBorrados: " + dtoNumeroRegistrosBorrados);
		UtilidadesLog.info("DAOCuentasCorrientes.eliminarBloqueoMovBanc(String usuario): Salida");
		return 	dtoNumeroRegistrosBorrados;
	}

	//*********** Método privado de CDOS ******************************
    private BelcorpService getBelcorpService() {
    
        UtilidadesLog.info("DAOCuentasCorrientes.getBelcorpService(): Entrada");
        try {
          UtilidadesLog.info("DAOCuentasCorrientes.getBelcorpService(): Salida");
          return BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException mmsnfe) {
          throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }	

	//*********** Método de CDOS ******************************
	public DTOSalida bloquearBloqueoMovCC(String usuario) throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.bloquearBloqueoMovCC(String usuario): Entrada");
		
                RecordSet rs;	
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT b.OID_BLOQ_MOVI_CUCO oids ");
		consulta.append(" FROM CCC_BLOQU_MOVIM_CUECO b ");
		consulta.append(" WHERE b.COD_USUA = '" + usuario + "' ");
		consulta.append(" FOR UPDATE ");

		try  {

            rs = getBelcorpService().dbService.executeStaticQuery(consulta.toString());
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);     
		UtilidadesLog.debug("contenido de  dtoSalida -- " + dtoSalida);
        UtilidadesLog.info("DAOCuentasCorrientes.bloquearBloqueoMovCC(String usuario): Entrada");
        return dtoSalida;
    }

	//*********** Método de CDOS ******************************
	public DTONumeroRegistros eliminarBloqueoMovCC(String usuario) throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.eliminarBloqueoMovCC(String usuario): Entrada");
	        
                int rs = 0;	        
		StringBuffer consulta = new StringBuffer();
		consulta.append(" DELETE FROM CCC_BLOQU_MOVIM_CUECO c ");
		consulta.append(" WHERE c.COD_USUA = '" + usuario + "' ");

		try  {

            rs = new Long(getBelcorpService().dbService.executeUpdate(consulta.toString())).intValue();
            UtilidadesLog.debug("rs: " + rs);
            
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
		DTONumeroRegistros dto = new DTONumeroRegistros();
        dto.setNumeroRegistros(new Long(rs));	
        UtilidadesLog.debug("dto: " + dto);
        UtilidadesLog.info("DAOCuentasCorrientes.eliminarBloqueoMovCC(String usuario): Salida");
		return 	dto;
	}

	//************ metodo de GPM - Paquete N0016 ************

/*	ELIMINADO POR INCIDENCIA 10254
 
		public DTOSalida ultiNumCupTramite() throws MareException {

		UtilidadesLog.info("*** Metodo ultiNumCupTramite: Entrada. ***");

		RecordSet resultado = null;
		StringBuffer consulta = new StringBuffer(); 

		consulta.append(" SELECT MAX(NUM_CUPE) FROM CCC_CUPON_TRAMI_DEPUR ");

		//se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			resultado = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("ultiNumCupTramite: Exception", e);
			this.logSql("ultiNumCupTramite. SQL: ",consulta.toString(), null);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(resultado);

		UtilidadesLog.info("*** Metodo ultiNumCupTramite: Salida. ***");
		return dtoSalida;
	}

	//************ metodo de GPM - Paquete N0016 ************
	public DTOSalida ultiNumCupTramiteAnio(String anio) throws MareException{

		UtilidadesLog.info("*** Metodo ultiNumCupTramiteAnio: Entrada. ***");

		RecordSet resultado = null;
		Vector parametros = new Vector();
		
		StringBuffer consulta = new StringBuffer(); 

		consulta.append(" SELECT MAX(NUM_CUPE) FROM CCC_CUPON_TRAMI_DEPUR ");
		consulta.append(" WHERE VAL_ANIO = ? "); 
		parametros.add(anio);

		//se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("ultiNumCupTramiteAnio: Exception", e);
			this.logSql("ultiNumCupTramiteAnio. SQL: ",consulta.toString(),parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(resultado);

		UtilidadesLog.info("*** Metodo ultiNumCupTramiteAnio: Salida. ***");
		return dtoSalida;
	}
*/
	//************ metodo de GPM - Paquete N0016 ************
	public DTOSalida movBancPorNumLote(DTONumeroLote dto) throws MareException {
		        
        UtilidadesLog.info("DAOCuentasCorrientes.movBancPorNumLote(DTONumeroLote dto): Entrada");
		RecordSet resultado = null;
		Vector parametros = new Vector();
		StringBuffer consulta = new StringBuffer();
		DTOSalida dtoSalida = new DTOSalida();
		consulta.append(" SELECT C.*, NVL(T.COD_TIPO_TRAN_CHEQ,'A') AS COD_TIPO_TRAN_CHEQ ");
		consulta.append(" FROM CCC_MOVIM_BANCA C, CCC_TIPO_TRANS T ");
		consulta.append(" WHERE NUM_LOTE = ? ");
      consulta.append(" AND C.TTRA_OID_TIPO_TRANS = T.OID_TIPO_TRAN(+) ");
      consulta.append(" ORDER BY NUM_CONS_TRAN ASC");
		parametros.add(dto.getNumeroLote());
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("movBancPorNumLote: Exception", e);
			this.logSql("movBancPorNumLote. SQL: ", consulta.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		dtoSalida.setResultado(resultado);		
		UtilidadesLog.info("DAOCuentasCorrientes.movBancPorNumLote(DTONumeroLote dto): Salida");
		return dtoSalida;
	}

	//************ metodo de GPM - Paquete N0016 ************
/*	ELIMINADO POR INCIDENCIA 10254
		public DTOSalida ultiNumCupTramiteAnioMes(String anio, String mes) throws MareException{

		UtilidadesLog.info("*** Metodo ultiNumCupTramiteAnioMes: Entrada. ");

		RecordSet resultado = null;
		Vector parametros = new Vector();
		
		StringBuffer consulta = new StringBuffer(); 

		consulta.append(" SELECT MAX(NUM_CUPE) FROM CCC_CUPON_TRAMI_DEPUR ");
		consulta.append(" WHERE VAL_ANIO = ? ");
		parametros.add(anio);
		consulta.append(" AND VAL_PERI_MES = ? "); 
		parametros.add(mes);

		//se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("ultiNumCupTramiteAnioMes: Exception", e);
			this.logSql("ultiNumCupTramiteAnioMes. SQL: ",consulta.toString(),parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(resultado);

		UtilidadesLog.info("*** Metodo ultiNumCupTramiteAnioMes: Salida. ***");
		return dtoSalida;
	}
	*/
		
        
        
      /**
     * @author Paola Cabrera
     * @date  08/11/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return      
     * modificaciones -Se sobrecarga el metodo original por la inc BELC300021307
     * modificaciones -se modifica la query por la incidencia V-CCC-039
     */
	public DTOSalida obtenerMovimientosLote(DTONumerosLineaVistaLotes dto) throws MareException {
		
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovimientosLote(DTONumerosLineaVistaLotes dto): Entrada ");
        
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT DISTINCT m.oid_movi_banc, c.des_cc, m.fec_pago, m.num_lote,  ");
        query.append("                 m.num_cons_tran, v.val_i18n tipoTransaccion, m.imp_pago, (select COD_CLIE from MAE_CLIEN where OID_CLIE = m.CLIE_OID_CLIE) consReal, ");
        query.append("                 m.cod_cons, m.num_fact_bole, m.val_digi_cheq_fact, m.num_cupo, ");
        query.append("                 m.val_nume_docu, m.COD_OFIC_RECA, ");
        query.append("                 m.VAL_NOMB_OFIC, m.VAL_HORA_NORM_ADIC, m.VAL_USUA_proc, ");
        query.append("                 m.fec_proc, m.VAL_HORA_proc, m.cod_erro, ");
        query.append("                 m.VAL_ESTA_MOVI_PEND, m.cod_iden_proc, m.val_obse ");
        query.append("            FROM ccc_movim_banca m,       ");
        query.append("                 v_ccc_lotes_movim l,     ");
        query.append("                 ccc_cuent_corri_banca c, ");
        query.append("                 ccc_sucur su,            ");
        query.append("                 ccc_banco ba,  ");
		//query.append("                 MAE_CLIEN te,  ");
        query.append("                 (select * from v_gen_i18n_sicc where attr_enti = 'CCC_TIPO_TRANS') v  ");
        query.append("           WHERE c.oid_cuen_corr_banc = m.ccba_oid_cc_banc ");
        query.append("             AND su.oid_sucu = c.sucu_oid_sucu ");
        query.append("             AND su.cban_oid_banc = ba.oid_banc ");
        query.append("             AND l.num_lote = m.num_lote  ");
      
        //--Paola Cabrera
        //-- 09/11/2005
        //--Se modifica dado que la vista no contiene esta columna
        //-- inc BELC300021307
      
       /* query.append("             AND (   (l.fec_pago = m.fec_pago)  ");
        query.append("                  OR (l.fec_pago IS NULL AND m.fec_pago IS NULL) ");
        query.append("                 )   ");
        query.append("             AND (   (l.fec_cont = m.fec_cont) ");
        query.append("                  OR (l.fec_cont IS NULL AND m.fec_cont IS NULL)   ");
        query.append("                 )   ");
        
        */
        
        //--Fin de la modificacion ---
        //--BELC300021307 
        
        query.append("             AND l.oid_cuen_corr_banc = c.oid_cuen_corr_banc ");
        query.append("             AND l.oid_banc = ba.oid_banc    ");
		//query.append("             AND te.OID_CLIE = m.CLIE_OID_CLIE  ");
        
        
        
        //--Paola Cabrera --- Incidencia Original: BELC300021307
        //-- 09/11/2005
        //-- Se cambia la condicion de l.num_lote
        //-- Existia un inc BELC300009040
        //-- en la cual queda definido que se debe hacer sobre la columna 
        //-- l.num_line -- 
        
        //query.append("             AND l.num_lote =  " +  dto.getNumeroLinea());       
        query.append("             AND l.num_line =  " +  dto.getNumeroLinea());  
        // Fin de la modificacion --
        // -- Paola Cabrera -- Incidencia Original: BELC300021307
        
        
		query.append("			   AND m.ttra_oid_tipo_trans = v.val_oid	 ");
		//query.append("			   OR (m.ttra_oid_tipo_trans IS NULL	 ");
		//query.append(" 			   OR v.val_oid IS NULL))	");
        query.append("             AND v.attr_num_atri = 1  ");
        query.append("             AND v.idio_oid_idio = " +  dto.getOidIdioma());
        //query.append("             AND v.attr_enti = 'CCC_TIPO_TRANS'  ");
  
        RecordSet rs = null;
        String codigoError = null;
         
        try {
        
             UtilidadesLog.info("query.toString()" + query.toString());
             
           rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerProductosReemplazo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } //catch

        DTOSalida dtoSalida = new DTOSalida();
        
        if (rs.esVacio())  {
               throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
        }
        
        
        dtoSalida.setResultado(rs); 
        
        UtilidadesLog.info("Contenido de rs:  " + rs.toString());
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovimientosLote(DTONumerosLineaVistaLotes dto): Salida ");
        return dtoSalida;
    }
    
    
    /**
     * Autor: Emilio Iraola
     * Fecha: 15/12/2005
     * Descripción: Metodo que recupera los movimientos bancarios que hayan
     *              sido procesados (P) y tengan saldo pendiente para una
     *              empresa/consultora.
     * @throws MareException
     * Notas:
     *       @eiraola 15/12/2005, este método se agrega a la Clase segun
     *       modelo: GCC-CCC-001_2005.11.09 GMIOTTI DT 
     */
    public RecordSet obtenerMovBancarios(Long pais, Long cliente, Long empresa)
            throws MareException {
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovBancarios(Long pais, Long cliente, Long empresa): Entrada");		
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT m.* ");
        query.append(" FROM ccc_movim_banca m ");
        query.append(" WHERE m.pais_oid_pais = " + pais);
        query.append("   AND m.clie_oid_clie = " + cliente);
        query.append("   AND m.soci_oid_soci = " + empresa);
        query.append("   AND m.imp_sald_pend > 0 ");
        query.append("   AND m.cod_iden_proc = 'P' "); //(P)rocesado
        try  {
            rs = getBelcorpService().dbService.executeStaticQuery(
                    query.toString());  
        } catch (MareException me)  {
            throw me;
        } catch (Exception ex){
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovBancarios(Long pais, Long cliente, Long empresa): Salida");
        return rs;
    }
   public RecordSet obtenerPeriodoByPk(Long oidPeriodo)throws MareException  {
     RecordSet salida ;
     StringBuffer query = new StringBuffer();
     
     query.append("SELECT OID_PERI, PAIS_OID_PAIS, MARC_OID_MARC, CANA_OID_CANA, ACCE_OID_ACCE, ");
     query.append("PERI_OID_PERI, VAL_NOMB_PERI, FEC_INIC, FEC_FINA, VAL_ESTA, IND_PERI_CORT, IND_PERI_CRUC ");
     query.append("FROM CRA_PERIO WHERE OID_PERI = "+oidPeriodo.toString());
     
      try  {
          salida = getBelcorpService().dbService.executeStaticQuery(query.toString());  
      } catch (MareException me)  {
          throw me;
      } catch (Exception ex){
          throw new MareException(ex, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      return salida;
   }
   
       public DTOSalida obtenerCuentasCorrientesBancarias(DTOBelcorp dtoE) throws MareException
    {
		/**
		 * Hacemos la siguiente consulta JDBC: 
         * SELECT cCorriente.OID_CUEN_CORR_BANC OID, 
         *        cCorriente.DES_CC 
         * FROM   CCC_CUENT_CORRI_BANCA cCorriente 
         * WHERE cCorriente.PAIS_OID_PAIS = 2
         */
        
		UtilidadesLog.info("DAOMantenimientoParametrosBel.obtenerCuentasCorrientesBancarias(DTOBelcorp dtoE): Entrada ");
       
        // Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT cCorriente.OID_CUEN_CORR_BANC OID, ");
		consulta.append("cCorriente.DES_CC ");
		consulta.append("FROM  CCC_CUENT_CORRI_BANCA cCorriente ");
		consulta.append("WHERE cCorriente.PAIS_OID_PAIS = ?");

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(dtoE.getOidPais().toString());

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerCuentasCorrientesBancarias: Exception",e);
			this.logSql("obtenerCuentasCorrientesBancarias. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAOMantenimientoParametrosBel.obtenerCuentasCorrientesBancarias(DTOBelcorp dtoE): Salida ");
		return dtoSalida;        
     
    }
}