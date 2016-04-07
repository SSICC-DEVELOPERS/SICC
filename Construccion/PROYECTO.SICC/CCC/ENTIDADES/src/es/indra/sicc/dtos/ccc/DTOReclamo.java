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

import es.indra.sicc.dtos.ccc.DTOBuscarReclamos;
import java.util.Date;
import java.math.BigDecimal;

public class DTOReclamo extends DTOBuscarReclamos  {


		private Long  oid;    
		private Long  oidCabeceraCargoAbono;
		private Long  oidSubacceso;  
		private Long  oidEmpresa ;   
		private Long  oidMedioPago;   
		private Long  oidMotivoRechazoDesbloqueo;    
		private Long  oidPeriodoReclamante;
		private Long  oidCanal;    
		private Long  oidAcceso;
		private Long  oidMovimientoCC;    
   
		private String  observacionesClienteReclamante ; 
		private String  observacionesAreaReclamos ; 
		private String  ficheroDocumentoAdjunto ;   
		private String  observacionesResolucionReclamos;
		private String  ejercicioCuota; 
		private String  anioCargoAbono;   
		private String  mesCargoAbono;   

		private Date  fechaResolucionPrevista;
		private Date  fechaResolucionReal;
		private Date  fechaValor;       
   
		private BigDecimal importeReclamado;  

		private Integer   numeroIdentificadorCuota;  
		private Integer   numeroOrdenCuota;   
		private Integer   numeroCargoAbono;    

	public String getAnioCargoAbono() {
		return anioCargoAbono;
	}

	public void setAnioCargoAbono(String newAnioCargoAbono) {
		anioCargoAbono = newAnioCargoAbono;
	}

	public String getEjercicioCuota() {
		return ejercicioCuota;
	}

	public void setEjercicioCuota(String newEjercicioCuota) {
		ejercicioCuota = newEjercicioCuota;
	}

	public Date getFechaResolucionPrevista() {
		return fechaResolucionPrevista;
	}

	public void setFechaResolucionPrevista(Date newFechaResolucionPrevista) {
		fechaResolucionPrevista = newFechaResolucionPrevista;
	}

	public Date getFechaResolucionReal() {
		return fechaResolucionReal;
	}

	public void setFechaResolucionReal(Date newFechaResolucionReal) {
		fechaResolucionReal = newFechaResolucionReal;
	}

	public Date getFechaValor() {
		return fechaValor;
	}

	public void setFechaValor(Date newFechaValor) {
		fechaValor = newFechaValor;
	}

	public String getFicheroDocumentoAdjunto() {
		return ficheroDocumentoAdjunto;
	}

	public void setFicheroDocumentoAdjunto(String newFicheroDocumentoAdjunto) {
		ficheroDocumentoAdjunto = newFicheroDocumentoAdjunto;
	}

	public BigDecimal getImporteReclamado() {
		return importeReclamado;
	}

	public void setImporteReclamado(BigDecimal newImporteReclamado) {
		importeReclamado = newImporteReclamado;
	}

	public String getMesCargoAbono() {
		return mesCargoAbono;
	}

	public void setMesCargoAbono(String newMesCargoAbono) {
		mesCargoAbono = newMesCargoAbono;
	}

	public Integer getNumeroCargoAbono() {
		return numeroCargoAbono;
	}

	public void setNumeroCargoAbono(Integer newNumeroCargoAbono) {
		numeroCargoAbono = newNumeroCargoAbono;
	}

	public Integer getNumeroIdentificadorCuota() {
		return numeroIdentificadorCuota;
	}

	public void setNumeroIdentificadorCuota(Integer newNumeroIdentificadorCuota) {
		numeroIdentificadorCuota = newNumeroIdentificadorCuota;
	}

	public Integer getNumeroOrdenCuota() {
		return numeroOrdenCuota;
	}

	public void setNumeroOrdenCuota(Integer newNumeroOrdenCuota) {
		numeroOrdenCuota = newNumeroOrdenCuota;
	}

	public String getObservacionesAreaReclamos() {
		return observacionesAreaReclamos;
	}

	public void setObservacionesAreaReclamos(String newObservacionesAreaReclamos) {
		observacionesAreaReclamos = newObservacionesAreaReclamos;
	}

	public String getObservacionesClienteReclamante() {
		return observacionesClienteReclamante;
	}

	public void setObservacionesClienteReclamante(String newObservacionesClienteReclamante) {
		observacionesClienteReclamante = newObservacionesClienteReclamante;
	}

	public String getObservacionesResolucionReclamos() {
		return observacionesResolucionReclamos;
	}

	public void setObservacionesResolucionReclamos(String newObservacionesResolucionReclamos) {
		observacionesResolucionReclamos = newObservacionesResolucionReclamos;
	}

	public Long getOidAcceso() {
		return oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		oidAcceso = newOidAcceso;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidEmpresa() {
		return oidEmpresa;
	}

	public void setOidEmpresa(Long newOidEmpresa) {
		oidEmpresa = newOidEmpresa;
	}

	public Long getOidMedioPago() {
		return oidMedioPago;
	}

	public void setOidMedioPago(Long newOidMedioPago) {
		oidMedioPago = newOidMedioPago;
	}

	public Long getOidMotivoRechazoDesbloqueo() {
		return oidMotivoRechazoDesbloqueo;
	}

	public void setOidMotivoRechazoDesbloqueo(Long newOidMotivoRechazoDesbloqueo) {
		oidMotivoRechazoDesbloqueo = newOidMotivoRechazoDesbloqueo;
	}

	public Long getOidMovimientoCC() {
		return oidMovimientoCC;
	}

	public void setOidMovimientoCC(Long newOidMovimientoCC) {
		oidMovimientoCC = newOidMovimientoCC;
	}

	public Long getOidPeriodoReclamante() {
		return oidPeriodoReclamante;
	}

	public void setOidPeriodoReclamante(Long newOidPeriodoReclamante) {
		oidPeriodoReclamante = newOidPeriodoReclamante;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getOidCabeceraCargoAbono() {
		return oidCabeceraCargoAbono;
	}

	public void setOidCabeceraCargoAbono(Long newOidCabeceraCargoAbono) {
		oidCabeceraCargoAbono = newOidCabeceraCargoAbono;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}
  
}