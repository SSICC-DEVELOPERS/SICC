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
import java.math.BigDecimal;
import java.sql.Timestamp;

public interface CopiaMovimientoBancarioLocal extends EJBLocalObject  {


	Long getNumeroLote();

	void setNumeroLote(Long newNumeroLote);

	Long getConsecutivoTransaccion();

	void setConsecutivoTransaccion(Long newConsecutivoTransaccion);

	Long getOid();

	void setOid(Long newOid);

	Integer getNumeroHistoria();

	void setNumeroHistoria(Integer newNumeroHistoria);

	Long getNumeroFacturaBoleta();

	void setNumeroFacturaBoleta(Long newNumeroFacturaBoleta);

	Date getFechaPago();

	void setFechaPago(Date newFechaPago);

	BigDecimal getImportePago();

	void setImportePago(BigDecimal newImportePago);

	BigDecimal getImporteAplicado();

	void setImporteAplicado(BigDecimal newImporteAplicado);



	BigDecimal getSaldoPendiente();

	void setSaldoPendiente(BigDecimal newSaldoPendiente);

	Long getNumeroCupon();

	void setNumeroCupon(Long newNumeroCupon);

	String getCodigoConsultora();

	void setCodigoConsultora(String newCodigoConsultora);

	Integer getDigitoChequeoFactura();

	void setDigitoChequeoFactura(Integer newDigitoChequeoFactura);

	String getOficinaRecaudadora();

	void setOficinaRecaudadora(String oficinaRecaudadora);

	String getNombreOficina();

	void setNombreOficina(String newNombreOficina);

	String getNumeroDocumento();

	void setNumeroDocumento(String newNumeroDocumento);

	String getHorarioNormalAdicional();

	void setHorarioNormalAdicional(String newHorarioNormalAdicional);

	String getUsuarioProceso();

	void setUsuarioProceso(String newUsuarioProceso);

	Date getFechaProceso();

	void setFechaProceso(Date newFechaProceso);

	Timestamp getHoraProceso();

	void setHoraProceso(Timestamp newHoraProceso);

	String getDocumentoCreacionMesSerie();

	void setDocumentoCreacionMesSerie(String newDocumentoCreacionMesSerie);

	String getDocumentoCreacionAnyo();

	void setDocumentoCreacionAnyo(String newDocumentoCreacionAnyo);

	Integer getDocumentoCreacionNumero();

	void setDocumentoCreacionNumero(Integer newDocumentoCreacionNumero);

	String getDocumentoAplicacionMesSerie();

	void setDocumentoAplicacionMesSerie(String newDocumentoAplicacionMesSerie);

	String getDocumentoAplicacionAnyo();

	void setDocumentoAplicacionAnyo(String newDocumentoAplicacionAnyo);

	Integer getDocumentoAplicacionNumero();

	void setDocumentoAplicacionNumero(Integer newDocumentoAplicacionNumero);

	Timestamp getFechaMovimientoAplicacion();

	void setFechaMovimientoAplicacion(Timestamp newFechaMovimientoAplicacion);

	String getEstatusMovimientoPendienteAplicado();

	void setEstatusMovimientoPendienteAplicado(String newEstatusMovimientoPendienteAplicado);

	String getIdentificadorProceso();

	void setIdentificadorProceso(String newIdentificadorProceso);

	String getNumeroLoteContabilizacion();

	void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion);

	Date getFechaContabilizacion();

	void setFechaContabilizacion(Date newFechaContabilizacion);

	String getObservaciones();

	void setObservaciones(String newObservaciones);

	Long getNumeroLoteExterno();

	void setNumeroLoteExterno(Long newNumeroLoteExterno);

	String getCodigoUsuario();

	void setCodigoUsuario(String newCodigoUsuario);

	Long getPais();

	void setPais(Long newPais);

	Long getEmpresa();

	void setEmpresa(Long newEmpresa);

	Long getTipoAbonoCreacion();

	void setTipoAbonoCreacion(Long newTipoAbonoCreacion);

	Long getSubacceso();

	void setSubacceso(Long newSubacceso);

	Long getCuentaCorriente();

	void setCuentaCorriente(Long newCuentaCorriente);

	Long getError();

	void setError(Long newError);

	Long getTipoTransaccion();

	void setTipoTransaccion(Long newTipoTransaccion);

	Long getSubprocesoMarcasUltimo();

	void setSubprocesoMarcasUltimo(Long newSubprocesoMarcasUltimo);

	Long getSubprocesoMarcaCreacion();

	void setSubprocesoMarcaCreacion(Long newSubprocesoMarcaCreacion);

	Long getConsultoraReal();

	void setConsultoraReal(Long newConsultoraReal);

	Long getNMovimientoCaja();

	void setNMovimientoCaja(Long newNMovimientoCaja);

	Long getTipoAbonoUltimo();

	void setTipoAbonoUltimo(Long newTipoAbonoUltimo);

	String getCodigoError();

	void setCodigoError(String newCodigoError);
}