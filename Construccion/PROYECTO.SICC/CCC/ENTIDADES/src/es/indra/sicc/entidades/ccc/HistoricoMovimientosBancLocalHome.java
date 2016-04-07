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

package es.indra.sicc.entidades.ccc;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface HistoricoMovimientosBancLocalHome extends EJBLocalHome {

	/**
	 * Metodo ejbCreate al que se le pasan solo los parametros obligatorios
	 */
	HistoricoMovimientosBancLocal create(Date fechaPasoAHistorico,
							Long cc,
							Long empresa,
							Long subprocesoMarcasCreacion,
							Long tiposAbonoCreacion,
							Long cliente) throws CreateException;

	/**
	 * Metodo ejbCreate al que se le pasan todos los parametros
	 */
	HistoricoMovimientosBancLocal create(Date fechaPasoAHistorico,
							Long cc,
							Long empresa,
							Long subprocesoMarcasCreacion,
							Long tiposAbonoCreacion,
							Long cliente,
							Long subacceso,
							Long numeroLote,
							Long consecutivoTransaccion,
							Integer numeroHistoria,
							Long numeroFacturaOBoleta,
							Date fechaPago,
							BigDecimal importePago,
							BigDecimal importeAplicado,
							BigDecimal saldoPendiente,
							Long numeroCupon,
							String codigoConsultora,
							Integer digitoChequeoNumFac,
                            //modificado tipo a string por inc 21735
							String oficinaRecaudadora,
							String nombreOficina,
							String numeroDocumento,
							String horarioNormalAdicional,
							String usuarioProceso,
							Date fechaProceso,
							Timestamp horaProceso,
							//String codigoConsultoraReal,
							String documentoCreacionMes,
							String documentoCreacionAnio,
							Integer documentoCreacionNumero,
							String documentoAplicacionMes,
							String documentoAplicacionAnio,
							Integer documentoAplicacionNumero,
							Timestamp fechaMovimientoAplicacion,
							String codigoError,
							String estatusMovimientoTesoreria,
							String identificadorProceso,
							String numeroLoteContabilizacion,
							Date fechaContabilizacion,
							String observaciones,
							Long numeroLoteExterno,
							//Long nMovimientoCaja,
							Long subprocesoMarcasUltimo,
							Long tiposAbonoUltimo,
							Long transaccion,
							Long movimiento,
							Long tipoError,
							String codigoUsuario) throws CreateException;

	HistoricoMovimientosBancLocal findByPrimaryKey(Long primaryKey) throws FinderException;
}