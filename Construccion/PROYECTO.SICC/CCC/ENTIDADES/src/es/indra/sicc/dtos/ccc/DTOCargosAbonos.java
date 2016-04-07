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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Date;

public class DTOCargosAbonos extends DTOBelcorp {

	private Integer numeroIdentificacion; // short
	private String codigoCliente;
	private Date fechaDocumento;
	private Long empresa;
	private String referenciaExterna;
	private String empresaDesc;
	private Long subacceso;
	private String subaccesoDesc;
	private String observaciones;
	private RecordSet cancelacionCuotas;
	private RecordSet aplicacionCobros;
	private RecordSet conceptosGastosAbonos;
	private RecordSet generacionVencimientos;
	private Long oid;
	private Long oidCliente;
	private Long proceso;
	private String procesoDesc;
	private Long canal;
	private String canalDesc;
	private Long acceso;
	private String accesoDesc;
	private Integer anio;
	private Integer mes;
	private String numeroLoteCont;
	private Date fechaValor;
	private Date fechaCont;
	private String codigoUsuario;
	private Date fechaDocuDesde;
	private Date fechaDocuHasta;
	private Date fechaVtoDesde;
	private Date fechaVtoHasta;
	private String codigoClienteDesde;
	private String codigoClienteHasta;
	private String codigoPeriodoDesde;
	private String codigoPeriodoHasta;
	private Long oidCuentaCorriente;
	private Long oidTipoAbonoSubproceso;
	private Long oidSituacionIncobrable;


	public DTOCargosAbonos() {
	}

	public Long getAcceso() {
		return this.acceso;
	}

	public void setAcceso(Long newAcceso) {
		this.acceso = newAcceso;
	}

	public String getAccesoDesc() {
		return this.accesoDesc;
	}

	public void setAccesoDesc(String newAccesoDesc) {
		this.accesoDesc = newAccesoDesc;
	}

	public RecordSet getAplicacionCobros() {
		return this.aplicacionCobros;
	}

	public void setAplicacionCobros(RecordSet newAplicacionCobros) {
		this.aplicacionCobros = newAplicacionCobros;
	}

	public Long getCanal() {
		return this.canal;
	}

	public void setCanal(Long newCanal) {
		this.canal = newCanal;
	}

	public String getCanalDesc() {
		return this.canalDesc;
	}

	public void setCanalDesc(String newCanalDesc) {
		this.canalDesc = newCanalDesc;
	}

	public RecordSet getCancelacionCuotas() {
		return this.cancelacionCuotas;
	}

	public void setCancelacionCuotas(RecordSet newCancelacionCuotas) {
		this.cancelacionCuotas = newCancelacionCuotas;
	}

	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		this.codigoCliente = newCodigoCliente;
	}

	public RecordSet getConceptosGastosAbonos() {
		return this.conceptosGastosAbonos;
	}

	public void setConceptosGastosAbonos(RecordSet newConceptosGastosAbonos) {
		this.conceptosGastosAbonos = newConceptosGastosAbonos;
	}

	public Long getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Long newEmpresa) {
		this.empresa = newEmpresa;
	}

	public String getEmpresaDesc() {
		return this.empresaDesc;
	}

	public void setEmpresaDesc(String newEmpresaDesc) {
		this.empresaDesc = newEmpresaDesc;
	}

	public Date getFechaDocumento() {
		return this.fechaDocumento;
	}

	public void setFechaDocumento(Date newFechaDocumento) {
		this.fechaDocumento = newFechaDocumento;
	}

	public RecordSet getGeneracionVencimientos() {
		return this.generacionVencimientos;
	}

	public void setGeneracionVencimientos(RecordSet newGeneracionVencimientos) {
		this.generacionVencimientos = newGeneracionVencimientos;
	}

	public Integer getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer newNumeroIdentificacion) {
		this.numeroIdentificacion = newNumeroIdentificacion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long newOid) {
		this.oid = newOid;
	}

	public Long getOidCliente() {
		return this.oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		this.oidCliente = newOidCliente;
	}

	public Long getProceso() {
		return this.proceso;
	}

	public void setProceso(Long newProceso) {
		this.proceso = newProceso;
	}

	public String getProcesoDesc() {
		return this.procesoDesc;
	}

	public void setProcesoDesc(String newProcesoDesc) {
		this.procesoDesc = newProcesoDesc;
	}

	public String getReferenciaExterna() {
		return this.referenciaExterna;
	}

	public void setReferenciaExterna(String newReferenciaExterna) {
		this.referenciaExterna = newReferenciaExterna;
	}

	public Long getSubacceso() {
		return this.subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		this.subacceso = newSubacceso;
	}

	public String getSubaccesoDesc() {
		return this.subaccesoDesc;
	}

	public void setSubaccesoDesc(String newSubaccesoDesc) {
		this.subaccesoDesc = newSubaccesoDesc;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer newAnio) {
		this.anio = newAnio;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer newMes) {
		this.mes = newMes;
	}

	public String getNumeroLoteCont() {
		return this.numeroLoteCont;
	}

	public void setNumeroLoteCont(String newNumeroLoteCont) {
		this.numeroLoteCont = newNumeroLoteCont;
	}

	public Date getFechaValor() {
		return this.fechaValor;
	}

	public void setFechaValor(Date newFechaValor) {
		this.fechaValor = newFechaValor;
	}

	public Date getFechaCont() {
		return this.fechaCont;
	}

	public void setFechaCont(Date newFechaCont) {
		this.fechaCont = newFechaCont;
	}

	public String getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(String newCodigoUsuario) {
		this.codigoUsuario = newCodigoUsuario;
	}

	public Date getFechaDocuDesde() {
		return this.fechaDocuDesde;
	}

	public void setFechaDocuDesde(Date newFechaDocuDesde) {
		this.fechaDocuDesde = newFechaDocuDesde;
	}

	public Date getFechaDocuHasta() {
		return this.fechaDocuHasta;
	}

	public void setFechaDocuHasta(Date newFechaDocuHasta) {
		this.fechaDocuHasta = newFechaDocuHasta;
	}

	public Date getFechaVtoDesde() {
		return this.fechaVtoDesde;
	}

	public void setFechaVtoDesde(Date newFechaVtoDesde) {
		this.fechaVtoDesde = newFechaVtoDesde;
	}

	public Date getFechaVtoHasta() {
		return this.fechaVtoHasta;
	}

	public void setFechaVtoHasta(Date newFechaVtoHasta) {
		this.fechaVtoHasta = newFechaVtoHasta;
	}

	public String getCodigoClienteDesde() {
		return this.codigoClienteDesde;
	}

	public void setCodigoClienteDesde(String newCodigoClienteDesde) {
		this.codigoClienteDesde = newCodigoClienteDesde;
	}

	public String getCodigoClienteHasta() {
		return this.codigoClienteHasta;
	}

	public void setCodigoClienteHasta(String newCodigoClienteHasta) {
		this.codigoClienteHasta = newCodigoClienteHasta;
	}

	public String getCodigoPeriodoDesde() {
		return this.codigoPeriodoDesde;
	}

	public void setCodigoPeriodoDesde(String newCodigoPeriodoDesde) {
		this.codigoPeriodoDesde = newCodigoPeriodoDesde;
	}

	public String getCodigoPeriodoHasta() {
		return this.codigoPeriodoHasta;
	}

	public void setCodigoPeriodoHasta(String newCodigoPeriodoHasta) {
		this.codigoPeriodoHasta = newCodigoPeriodoHasta;
	}

	public Long getOidCuentaCorriente() {
		return this.oidCuentaCorriente;
	}

	public void setOidCuentaCorriente(Long newOidCuentaCorriente) {
		this.oidCuentaCorriente = newOidCuentaCorriente;
	}

	public Long getOidTipoAbonoSubproceso() {
		return this.oidTipoAbonoSubproceso;
	}

	public void setOidTipoAbonoSubproceso(Long newOidTipoAbonoSubproceso) {
		this.oidTipoAbonoSubproceso = newOidTipoAbonoSubproceso;
	}

	public Long getOidSituacionIncobrable() {
		return this.oidSituacionIncobrable;
	}

	public void setOidSituacionIncobrable(Long newOidSituacionIncobrable) {
		this.oidSituacionIncobrable = newOidSituacionIncobrable;
	}
}