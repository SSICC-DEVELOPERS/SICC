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

import javax.ejb.EJBLocalObject;
import java.sql.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;

public interface MovimientosCuentasCorrientesLocal extends EJBLocalObject  {

	Long getCliente();

	void setCliente(Long newCliente);

	Long getCuentaCuota();

	void setCuentaCuota(Long newCuentaCuota);

	Long getCuentaOrigen();

	void setCuentaOrigen(Long newCuentaOrigen);

	Long getDivisa();

	void setDivisa(Long newDivisa);

	String getDocumentoAnyo();

	void setDocumentoAnyo(String newDocumentoAnyo);

	String getDocumentoMesSerie();

	void setDocumentoMesSerie(String newDocumentoMesSerie);

	Integer getDocumentoNumero();

	void setDocumentoNumero(Integer newDocumentoNumero);

	String getEjercicioCuota();

	void setEjercicioCuota(String newEjercicioCuota);

	Long getEmpresa();

	void setEmpresa(Long newEmpresa);

	Date getFechaContabilizacion();

	void setFechaContabilizacion(Date newFechaContabilizacion);

	Timestamp getFechaDocumento();

	void setFechaDocumento(Timestamp newFechaDocumento);

	Timestamp getFechaUltimoMovimiento();

	void setFechaUltimoMovimiento(Timestamp newFechaUltimoMovimiento);

	Timestamp getFechaValor();

	void setFechaValor(Timestamp newFechaValor);

	Date getFechaVencimiento();

	void setFechaVencimiento(Date newFechaVencimiento);

	Double getImporte();

	void setImporte(Double newImporte);

	Double getImporteDivisa();

	void setImporteDivisa(Double newImporteDivisa);

	Double getImportePagado();

	void setImportePagado(Double newImportePagado);

	Double getImportePagadoDivisa();

	void setImportePagadoDivisa(Double newImportePagadoDivisa);

	Double getImportePendiente();

	void setImportePendiente(Double newImportePendiente);

	Boolean getIndicaDescuentoRecargo();

	void setIndicaDescuentoRecargo(Boolean newIndicaDescuentoRecargo);

	Long getMarca();

	void setMarca(Long newMarca);

	Long getMarcaSituacion();

	void setMarcaSituacion(Long newMarcaSituacion);

	Long getMedioPago();

	void setMedioPago(Long newMedioPago);

	Integer getNumeroIdentificadorCuota();

	void setNumeroIdentificadorCuota(Integer newNumeroIdentificadorCuota);

	String getNumeroLoteContabilizacion();

	void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion);

	Integer getNumeroOrdenCuota();

	void setNumeroOrdenCuota(Integer newNumeroOrdenCuota);

	//String getNumeroSerieCuota();

	//void setNumeroSerieCuota(String newNumeroSerieCuota);

	String getObservaciones();

	void setObservaciones(String newObservaciones);

	Long getOid();

	//Long getPais();

	//void setPais(Long newPais);

	Long getPeriodoDesde();

	void setPeriodoDesde(Long newPeriodoDesde);

	String getReferenciaNumeroDocumentoExterno();

	void setReferenciaNumeroDocumentoExterno(String newReferenciaNumeroDocumentoExterno);

	Long getSubacceso();

	void setSubacceso(Long newSubacceso);

	Long getTerritorioAdministrativo();

	void setTerritorioAdministrativo(Long newTerritorioAdministrativo);

	Long getTipoAbonoCreacion();

	void setTipoAbonoCreacion(Long newTipoAbonoCreacion);

	Long getTipoAbonoUltimo();

	void setTipoAbonoUltimo(Long newTipoAbonoUltimo);

	Long getTipoCliente();

	void setTipoCliente(Long newTipoCliente);

	String getUltimoDocumentoAnyo();

	void setUltimoDocumentoAnyo(String newUltimoDocumentoAnyo);

	String getUltimoDocumentoMesSerie();

	void setUltimoDocumentoMesSerie(String newUltimoDocumentoMesSerie);

	Integer getUltimoDocumentoNumero();

	void setUltimoDocumentoNumero(Integer newUltimoDocumentoNumero);

	Integer getUltimoNumeroHistoria();

	void setUltimoNumeroHistoria(Integer newUltimoNumeroHistoria);

	void setOid(Long newOid);

	Long getSubprocesoDeCreacion();

	void setSubprocesoDeCreacion(Long newSubprocesoDeCreacion);

	Long getSubprocesoUltimo();

	void setSubprocesoUltimo(Long newSubprocesoUltimo);

	BigDecimal getTipoCambio();

	void setTipoCambio(BigDecimal newTipoCambio);

	String getCodigoUsuario();

	void setCodigoUsuario(String newCodigoUsuario);

	Long getTipoDocumentoLegal();

	void setTipoDocumentoLegal(Long newTipoDocumentoLegal);

	Long getSubtipoCliente();

	void setSubtipoCliente(Long newSubtipoCliente);

	Long getSugerencia();

	void setSugerencia(Long newSugerencia);

	Long getSeccion();

	void setSeccion(Long newSeccion);

	BigDecimal getImporteMovimiento();

	void setImporteMovimiento(BigDecimal newImporteMovimiento);

	Integer getNumeroLoteFacturacion();

	void setNumeroLoteFacturacion(Integer newNumeroLoteFacturacion);

	//String getDcAplicado();

	//void setDcAplicado(String newDcAplicado);

	BigDecimal getImportePago();

	void setImportePago(BigDecimal newImportePago);

	BigDecimal getImportePagoDivisa();

	void setImportePagoDivisa(BigDecimal newImportePagoDivisa);

	BigDecimal getImporteMovimientoDivisa();

	void setImporteMovimientoDivisa(BigDecimal newImporteMovimientoDivisa);

	Long getTipoPeriodo();

	void setTipoPeriodo(Long newTipoPeriodo);

	Long getConsolidado();

	void setConsolidado(Long newConsolidado);

	Long getRegion();

	void setRegion(Long newRegion);

	Long getTipoSolicitud();

	void setTipoSolicitud(Long newTipoSolicitud);



}