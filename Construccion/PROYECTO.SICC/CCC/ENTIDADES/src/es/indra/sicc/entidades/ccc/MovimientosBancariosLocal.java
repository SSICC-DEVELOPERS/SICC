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
//import java.sql.Time;  ==>> No es usado
import java.sql.Timestamp;
import java.math.BigDecimal;

public interface MovimientosBancariosLocal extends EJBLocalObject  {
	String getCodigoConsultora();

	void setCodigoConsultora(String newCodigoConsultora);

	Long getConsultoraReal();

	void setConsultoraReal(Long newConsultoraReal);

	String getCodigoError();

	void setCodigoError(String newCodigoError);

	Long getConsecutivoTransaccion();

	void setConsecutivoTransaccion(Long newConsecutivoTransaccion);

	Long getCuentaCorriente();

	void setCuentaCorriente(Long newCuentaCorriente);

	Integer	 getDigitoChequeoFactura();

	void setDigitoChequeoFactura(Integer newDigitoChequeoFactura);

	String getDocumentoAplicacionAnyo();

	void setDocumentoAplicacionAnyo(String newDocumentoAplicacionAnyo);

	String getDocumentoAplicacionMesSerie();

	void setDocumentoAplicacionMesSerie(String newDocumentoAplicacionMesSerie);

	Integer getDocumentoAplicacionNumero();

	void setDocumentoAplicacionNumero(Integer newDocumentoAplicacionNumero);

	String getDocumentoCreacionAnyo();

	void setDocumentoCreacionAnyo(String newDocumentoCreacionAnyo);

	String getDocumentoCreacionMesSerie();

	void setDocumentoCreacionMesSerie(String newDocumentoCreacionMesSerie);

	Integer getDocumentoCreacionNumero();

	void setDocumentoCreacionNumero(Integer newDocumentoCreacionNumero);

	Long getEmpresa();

	void setEmpresa(Long newEmpresa);

	String getEstatusMovimientoPendienteAplicado();

	void setEstatusMovimientoPendienteAplicado(String newEstatusMovimientoPendienteAplicado);

	Date getFechaContabilizacion();

	void setFechaContabilizacion(Date newFechaContabilizacion);

	Timestamp getFechaMovimientoAplicacion();

	void setFechaMovimientoAplicacion(Timestamp newFechaMovimientoAplicacion);

	Date getFechaPago();

	void setFechaPago(Date newFechaPago);

	Date getFechaProceso();

	void setFechaProceso(Date newFechaProceso);

	Timestamp getHoraProceso();

	void setHoraProceso(Timestamp newHoraProceso);

	String getHorarioNormalAdicional();

	void setHorarioNormalAdicional(String newHorarioNormalAdicional);

	String getIdentificadorProceso();

	void setIdentificadorProceso(String newIdentificadorProceso);

	BigDecimal getImportePago();

	void setImportePago(BigDecimal newImportePago);



	String getNombreOficina();

	void setNombreOficina(String newNombreOficina);

	Long getNumeroCupon();

	void setNumeroCupon(Long newNumeroCupon);

	String getNumeroDocumento();

	void setNumeroDocumento(String newNumeroDocumento);

	Long getNumeroFacturaBoleta();

	void setNumeroFacturaBoleta(Long newNumeroFacturaBoleta);

	Long getNumeroLote();

	void setNumeroLote(Long newNumeroLote);

	String getNumeroLoteContabilizacion();

	void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion);

	String getObservaciones();

	void setObservaciones(String newObservaciones);

	//modificado el tipo a String poir inc 21735
    String getOficinaRecaudadora();

	//modificado el tipo a String poir inc 21735
    void setOficinaRecaudadora(String oficinaRecaudadora);

	Long getOid();

	void setOid(Long newOid);

	Long getSubprocesoMarcaCreacion();

	void setSubprocesoMarcaCreacion(Long newSubprocesoMarcaCreacion);

	Long getSubprocesoMarcasUltimo();

	void setSubprocesoMarcasUltimo(Long newSubprocesoMarcasUltimo);

	Long getTipoAbonoCreacion();

	void setTipoAbonoCreacion(Long newTipoAbonoCreacion);

	Long getTipoAbonoUltimo();

	void setTipoAbonoUltimo(Long newTipoAbonoUltimo);

	Long getTipoTransaccion();

	void setTipoTransaccion(Long newTipoTransaccion);

	String getUsuarioProceso();

	void setUsuarioProceso(String newUsuarioProceso);

	Long getNumeroLoteExterno();

	void setNumeroLoteExterno(Long newNumeroLoteExterno);

	Long getNMovimientoCaja();

	void setNMovimientoCaja(Long newNMovimientoCaja);

	BigDecimal getSaldoPendiente();

	void setSaldoPendiente(BigDecimal newSaldoPendiente);

	BigDecimal getImporteMovimiento();

	void setImporteMovimiento(BigDecimal newImporteMovimiento);
  
	String getCodigoUsuario();

	void setCodigoUsuario(String newCodigoUsuario);

	Integer getNumeroHistoria();

	void setNumeroHistoria(Integer newNumeroHistoria);

	BigDecimal getImporteAplicado();

	void setImporteAplicado(BigDecimal newImporteAplicado);

	Long getError();

	void setError(Long newError);

	Long getPais();

	void setPais(Long newPais);

	Long getOidCliente();

	void setOidCliente(Long newOidCliente);
  
  Long getSubacceso();

	void setSubacceso(Long newSubacceso);
   
  
}