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

import javax.ejb.EJBLocalObject;

public interface HistoricoMovimientosBancLocal extends EJBLocalObject {

	Long getCc();

	void setCc(Long newCc);

	Long getCliente();

	void setCliente(Long newCliente);

	String getCodigoConsultora();

	void setCodigoConsultora(String newCodigoConsultora);


	String getCodigoError();

	void setCodigoError(String newCodigoError);

	Long getConsecutivoTransaccion();

	void setConsecutivoTransaccion(Long newConsecutivoTransaccion);

	Integer getDigitoChequeoNumFac();

	void setDigitoChequeoNumFac(Integer newDigitoChequeoNumFac);

	String getDocumentoAplicacionAnio();

	void setDocumentoAplicacionAnio(String newDocumentoAplicacionAnio);

	String getDocumentoAplicacionMes();

	void setDocumentoAplicacionMes(String newDocumentoAplicacionMes);

	Integer getDocumentoAplicacionNumero();

	void setDocumentoAplicacionNumero(Integer newDocumentoAplicacionNumero);

	String getDocumentoCreacionAnio();

	void setDocumentoCreacionAnio(String newDocumentoCreacionAnio);

	String getDocumentoCreacionMes();

	void setDocumentoCreacionMes(String newDocumentoCreacionMes);

	Integer getDocumentoCreacionNumero();

	void setDocumentoCreacionNumero(Integer newDocumentoCreacionNumero);

	Long getEmpresa();

	void setEmpresa(Long newEmpresa);

	String getEstatusMovimientoTesoreria();

	void setEstatusMovimientoTesoreria(String newEstatusMovimientoTesoreria);

	Date getFechaContabilizacion();

	void setFechaContabilizacion(Date newFechaContabilizacion);

	Timestamp getFechaMovimientoAplicacion();

	void setFechaMovimientoAplicacion(Timestamp newFechaMovimientoAplicacion);

	Date getFechaPago();

	void setFechaPago(Date newFechaPago);

	Date getFechaPasoAHistorico();

	void setFechaPasoAHistorico(Date newFechaPasoAHistorico);

	Date getFechaProceso();

	void setFechaProceso(Date newFechaProceso);

	Timestamp getHoraProceso();

	void setHoraProceso(Timestamp newHoraProceso);

	String getHorarioNormalAdicional();

	void setHorarioNormalAdicional(String newHorarioNormalAdicional);

	String getIdentificadorProceso();

	void setIdentificadorProceso(String newIdentificadorProceso);

	BigDecimal getImporteAplicado();

	void setImporteAplicado(BigDecimal newImporteAplicado);

	BigDecimal getImportePago();

	void setImportePago(BigDecimal newImportePago);

	Long getMovimiento();

	void setMovimiento(Long newMovimiento);

	//Long getNMovimientoCaja();

	//void setNMovimientoCaja(Long newNMovimientoCaja);

	String getNombreOficina();

	void setNombreOficina(String newNombreOficina);

	Long getNumeroCupon();

	void setNumeroCupon(Long newNumeroCupon);

	String getNumeroDocumento();

	void setNumeroDocumento(String newNumeroDocumento);

	Long getNumeroFacturaOBoleta();

	void setNumeroFacturaOBoleta(Long newNumeroFacturaOBoleta);

	Integer getNumeroHistoria();

	void setNumeroHistoria(Integer newNumeroHistoria);

	Long getNumeroLote();

	void setNumeroLote(Long newNumeroLote);

	String getNumeroLoteContabilizacion();

	void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion);

	Long getNumeroLoteExterno();

	void setNumeroLoteExterno(Long newNumeroLoteExterno);

	String getObservaciones();

	void setObservaciones(String newObservaciones);

	//modificado tipo a string por inc 21735
    String getOficinaRecaudadora();

    //modificado tipo a string por inc 21735
	void setOficinaRecaudadora(String oficinaRecaudadora);

	BigDecimal getSaldoPendiente();

	void setSaldoPendiente(BigDecimal newSaldoPendiente);

	Long getSubacceso();

	void setSubacceso(Long newSubacceso);

	Long getSubprocesoMarcasCreacion();

	void setSubprocesoMarcasCreacion(Long newSubprocesoMarcasCreacion);

	Long getSubprocesoMarcasUltimo();

	void setSubprocesoMarcasUltimo(Long newSubprocesoMarcasUltimo);

	Long getTipoError();

	void setTipoError(Long newTipoError);

	Long getTiposAbonoCreacion();

	void setTiposAbonoCreacion(Long newTiposAbonoCreacion);

	Long getTiposAbonoUltimo();

	void setTiposAbonoUltimo(Long newTiposAbonoUltimo);

	Long getTransaccion();

	void setTransaccion(Long newTransaccion);

	String getUsuarioProceso();

	void setUsuarioProceso(String newUsuarioProceso);

	Long getOid();

	void setOid(Long newOid);
	
	String getCodigoUsuario();

	void setCodigoUsuario(String newCodigoUsuario);

}