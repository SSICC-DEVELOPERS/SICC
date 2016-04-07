/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

public class DTOSolicitudBloqueada extends DTOAuditableSICC  {

    private Long oidTipoSolPED;
    private Long oidSubAcceso;
    private Long oidNivelRiesgo;
    private Long oidSolicitud;
    private Long oidJerarquia;
    private Long oidEjecutivo;
    private Long oidPeriodo;
    private Long oidCliente;
    private Long oidGrupoSolicitud;
    private Long estatus;
    private Long oidZona;
    private BigDecimal montoSolicitud;
    private BigDecimal montoDeudaVencida;
    private Boolean indDeudaVencida;
    private Boolean indLineaCredito;
    private Boolean indMontoMaximo;
    private Boolean indPorcentajeMaximo;
    private Boolean notificado;
    private Date fechaSolicitud;

    public DTOSolicitudBloqueada() {
    }

    public Long getOidTipoSolPED() {
        return oidTipoSolPED;
    }

    public void setOidTipoSolPED(Long newOidTipoSolPais) {
        oidTipoSolPED = newOidTipoSolPais;
    }

    public Long getOidSubAcceso() {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long newOidSubAcceso) {
        oidSubAcceso = newOidSubAcceso;
    }

    public Long getOidNivelRiesgo() {
        return oidNivelRiesgo;
    }

    public void setOidNivelRiesgo(Long newOidNivelRiesgo) {
        oidNivelRiesgo = newOidNivelRiesgo;
    }

    public Long getOidSolicitud() {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long newOidSolicitud) {
        oidSolicitud = newOidSolicitud;
    }

    public Long getOidJerarquia() {
        return oidJerarquia;
    }

    public void setOidJerarquia(Long newOidJerarquia) {
        oidJerarquia = newOidJerarquia;
    }

    public Long getOidEjecutivo() {
        return oidEjecutivo;
    }

    public void setOidEjecutivo(Long newOidEjecutivo) {
        oidEjecutivo = newOidEjecutivo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo) {
        oidPeriodo = newOidPeriodo;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public Long getOidGrupoSolicitud() {
        return oidGrupoSolicitud;
    }

    public void setOidGrupoSolicitud(Long newOidGrupoSolicitud) {
        oidGrupoSolicitud = newOidGrupoSolicitud;
    }

    public Long getEstatus() {
        return estatus;
    }

    public void setEstatus(Long newEstatus) {
        estatus = newEstatus;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long newOidZona) {
        oidZona = newOidZona;
    }

    public BigDecimal getMontoSolicitud() {
        return montoSolicitud;
    }

    public void setMontoSolicitud(BigDecimal newMontoSolicitud) {
        montoSolicitud = newMontoSolicitud;
    }

    public BigDecimal getMontoDeudaVencida() {
        return montoDeudaVencida;
    }

    public void setMontoDeudaVencida(BigDecimal newMontoDeudaVencida) {
        montoDeudaVencida = newMontoDeudaVencida;
    }


    public void setIndDeudaVencida(Boolean newIndDeudaVencida) {
        indDeudaVencida = newIndDeudaVencida;
    }


    public void setIndLineaCredito(Boolean newIndLineaCredito) {
        indLineaCredito = newIndLineaCredito;
    }


    public void setIndMontoMaximo(Boolean newIndMontoMaximo) {
        indMontoMaximo = newIndMontoMaximo;
    }


    public void setIndPorcentajeMaximo(Boolean newIndPorcentajeMaximo) {
        indPorcentajeMaximo = newIndPorcentajeMaximo;
    }


    public void setNotificado(Boolean newNotificado) {
        notificado = newNotificado;
    }

    public Boolean getIndDeudaVencida() {
        return indDeudaVencida;
    }


    public Boolean getIndLineaCredito() {
        return indLineaCredito;
    }


    public Boolean getIndMontoMaximo() {
        return indMontoMaximo;
    }


    public Boolean getIndPorcentajeMaximo() {
        return indPorcentajeMaximo;
    }


    public Boolean getNotificado() {
        return notificado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date newFechaSolicitud) {
        fechaSolicitud = newFechaSolicitud;
    }


}