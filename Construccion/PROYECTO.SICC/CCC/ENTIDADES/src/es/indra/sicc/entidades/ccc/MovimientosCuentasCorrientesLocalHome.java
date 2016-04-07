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

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;


import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

public interface MovimientosCuentasCorrientesLocalHome extends EJBLocalHome  {

	//MovimientosCuentasCorrientesLocal create() throws CreateException;

	/**
	 * Metodo ejbCreate al que se le pasan solo los parametros obligatorios
	 */
	MovimientosCuentasCorrientesLocal create(Long empresa, 
						Long marcaSituacion,
						// Long divisa, // BELC300004313
						Long periodoDesde,
						Long tipoAbonoUltimo,
						Long tipoAbonoCreacion,
						Long subacceso,
						Long subprocesoUltimo,
						Long subprocesoDeCreacion,
						Long cuentaOrigen,
						//Long cuentaCuota,
						Long cliente,
						String documentoAnyo,
						//String documentoMesSerie, // deja de ser obligatorio en la implantacion 2
						Integer documentoNumero,
						String ejercicioCuota,
						Timestamp fechaDocumento,
						Timestamp fechaUltimoMovimiento,
						Date fechaVencimiento, // BELC300004213									
						Double importe,
						Double importePagado,
						Double importePendiente,
						Integer numeroIdentificadorCuota,
						Integer numeroOrdenCuota,
						//String numeroSerieCuota,
						//Long medioPago, // BELC300004457
						Long TerritorioAdministrativo,
						//Long pais,
						Long tipoCliente, // BELC300004213
						BigDecimal tipoCambio, 
						String codigoUsuario,
						Long subtipoCliente,
						Long sugerencia,
						Long seccion,
						//Long tipoDocumentoLegal,
						//Long tipoSolicitud,
						Long region,
						BigDecimal importeMovimiento) throws CreateException;

	/**
	 * Metodo ejbCreate al que se le pasan todos los parametros
	 */
	MovimientosCuentasCorrientesLocal create(Long empresa,
						Long marcaSituacion,
						Long divisa,
						Long periodoDesde,
						Long tipoAbonoUltimo,
						Long tipoAbonoCreacion,
						Long subacceso,
						Long subprocesoUltimo,
						Long subprocesoDeCreacion,
						Long cuentaOrigen,
						Long cuentaCuota,
						Long cliente,
						String documentoAnyo,
						String documentoMesSerie,
						Integer documentoNumero,
						String ejercicioCuota,
						Date fechaContabilizacion,
						Timestamp fechaDocumento,
						Timestamp fechaUltimoMovimiento,
						Timestamp fechaValor,
						Date fechaVencimiento,
						Double importe,
						Double importeDivisa,
						Double importePagado,
						Double impPagadoDivisa,
						Double importePendiente,
						Boolean indicaDtoRecargo,
						Integer numeroIdentificadorCuota,
						String numLoteContab,
						Integer numeroOrdenCuota,
						//String numeroSerieCuota,
						String observaciones,
						String referenciaNumeroDocumentoExterno,
						String ultimoDocumentoAnyo,
						String ultimoDocumentoMesSerie,
						Integer ultimoDocumentoNumero,
						Integer ultimoNumeroHistoria,
						Long medioPago,
						Long TerritorioAdministrativo,
						//Long pais,
						Long tipoCliente,
						Long marca,
						BigDecimal tipoCambio, 
						String codigoUsuario,
						Long subtipoCliente,
						Long sugerencia,
						Long seccion,
						Integer numeroLoteFacturacion,
						//String dcAplicado,
						BigDecimal importePago,
						BigDecimal importePagoDivisa,
						BigDecimal importeMovimientoDivisa,
						Long tipoPeriodo,
						Long tipoDocumentoLegal,
						Long tipoSolicitud,
						Long region,
						Long consolidado,
						BigDecimal importeMovimiento) 
		throws CreateException;
						

	MovimientosCuentasCorrientesLocal findByPrimaryKey(Long primaryKey) 
		throws FinderException;

	MovimientosCuentasCorrientesLocal findByUK(Long subacceso, 
												String ejercicioCuota,
												Integer numeroIdentificadorCuota, 
												Integer numeroOrdenCuota,
                                                Long oidPais) throws FinderException;
}