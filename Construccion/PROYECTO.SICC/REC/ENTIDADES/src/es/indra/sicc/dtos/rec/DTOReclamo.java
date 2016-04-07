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
 
package es.indra.sicc.dtos.rec;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class DTOReclamo extends DTOSiccPaginacion  {
    private Long numAtencion;	
    private Long numReclamo;	
    private Long oidDocumentoReferencia;	
    private Long oidCliente;	
    private BigDecimal totalEnvia;	
    private BigDecimal totalDevuelve;	
    private BigDecimal saldoAPagar;	
    private Date fechaDocumentoReferencia;	
    private Long periodoDocumentoReferencia;	
    private Long tipoDocumento;	
    private Long UACliente;	
    private Long tipoCliente;	
    private Long subtipoCliente;	
    private Long motivoBloqueo;	
    private ArrayList operaciones;	
    private Long oidReclamo;	
    private Long periodoReclamo; // añadido por incidencia BELC300014318
    
    //campos añadidos para el paquete N041
    private Long numeroDocumentoReferencia;
    private String codigoCliente;
    private Boolean chequeoFisico;
    private ArrayList operacionesAEliminar;
    private String opeAEliminar;
    private BigDecimal precioContable;
    
    public DTOReclamo() {
    }

    public Long getUACliente() {
        return UACliente;
    }

    public void setUACliente(Long UACliente) {
        this.UACliente = UACliente;
    }

    public Date getFechaDocumentoReferencia() {
        return fechaDocumentoReferencia;
    }

    public void setFechaDocumentoReferencia(Date fechaDocumentoReferencia) {
        this.fechaDocumentoReferencia = fechaDocumentoReferencia;
    }

    public Long getMotivoBloqueo() {
        return motivoBloqueo;
    }

    public void setMotivoBloqueo(Long motivoBloqueo) {
        this.motivoBloqueo = motivoBloqueo;
    }

    public Long getNumAtencion() {
        return numAtencion;
    }

    public void setNumAtencion(Long numAtencion) {
        this.numAtencion = numAtencion;
    }

    public Long getNumReclamo() {
        return numReclamo;
    }

    public void setNumReclamo(Long numReclamo) {
        this.numReclamo = numReclamo;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidDocumentoReferencia() {
        return oidDocumentoReferencia;
    }

    public void setOidDocumentoReferencia(Long oidDocumentoReferencia) {
        this.oidDocumentoReferencia = oidDocumentoReferencia;
    }

    public Long getOidReclamo() {
        return oidReclamo;
    }

    public void setOidReclamo(Long oidReclamo) {
        this.oidReclamo = oidReclamo;
    }

    public ArrayList getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList operaciones) {
        this.operaciones = operaciones;
    }

    public Long getPeriodoDocumentoReferencia() {
        return periodoDocumentoReferencia;
    }

    public void setPeriodoDocumentoReferencia(Long periodoDocumentoReferencia) {
        this.periodoDocumentoReferencia = periodoDocumentoReferencia;
    }

    public BigDecimal getSaldoAPagar() {
        return saldoAPagar;
    }

    public void setSaldoAPagar(BigDecimal saldoAPagar) {
        this.saldoAPagar = saldoAPagar;
    }

    public Long getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(Long subtipoCliente) {
        this.subtipoCliente = subtipoCliente;
    }

    public Long getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Long tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigDecimal getTotalDevuelve() {
        return totalDevuelve;
    }

    public void setTotalDevuelve(BigDecimal totalDevuelve) {
        this.totalDevuelve = totalDevuelve;
    }

    public BigDecimal getTotalEnvia() {
        return totalEnvia;
    }

    public void setTotalEnvia(BigDecimal totalEnvia) {
        this.totalEnvia = totalEnvia;
    }

   public Long getPeriodoReclamo() {
      return periodoReclamo;
   }

   public void setPeriodoReclamo(Long periodoReclamo) {
      this.periodoReclamo = periodoReclamo;
   }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente)
    {
        this.codigoCliente = codigoCliente;
    }

    public Long getNumeroDocumentoReferencia()
    {
        return numeroDocumentoReferencia;
    }

    public void setNumeroDocumentoReferencia(Long numeroDocumentoReferencia)
    {
        this.numeroDocumentoReferencia = numeroDocumentoReferencia;
    }

    public Boolean getChequeoFisico() {
        return chequeoFisico;
    }

    public void setChequeoFisico(Boolean chequeoFisico) {
        this.chequeoFisico = chequeoFisico;
    }

    public ArrayList getOperacionesAEliminar() {
        return operacionesAEliminar;
    }

    public void setOperacionesAEliminar(ArrayList operacionesAEliminar) {
        this.operacionesAEliminar = operacionesAEliminar;
    }

    public String getOpeAEliminar() {
        return opeAEliminar;
    }

    public void setOpeAEliminar(String opeAEliminar) {
        this.opeAEliminar = opeAEliminar;
    }

    public BigDecimal getPrecioContable() {
        return precioContable;
    }

    public void setPrecioContable(BigDecimal precioContable) {
        this.precioContable = precioContable;
    }
}