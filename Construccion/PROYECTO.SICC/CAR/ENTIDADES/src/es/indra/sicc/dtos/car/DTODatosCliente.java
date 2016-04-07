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

public class DTODatosCliente extends DTOAuditableSICC  {
    private BigDecimal lineaCreditoDisponible;
    private Long oidCliente;
    private BigDecimal montoDeudaVencida;
    private BigDecimal deudaTotalCliente;
    private Long numDiasAtraso;
    private BigDecimal montoSolicitudesNuevas;
    private BigDecimal cuponTramiteCliente;
    private Long nivelRiesgo;
    private BigDecimal lineaCredito;

    public DTODatosCliente() {
    }

    public BigDecimal getLineaCreditoDisponible() {
        return lineaCreditoDisponible;
    }

    public void setLineaCreditoDisponible(BigDecimal newLineaCreditoDisponible) {
        lineaCreditoDisponible = newLineaCreditoDisponible;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public BigDecimal getMontoDeudaVencida() {
        return montoDeudaVencida;
    }

    public void setMontoDeudaVencida(BigDecimal newMontoDeudaVencida) {
        montoDeudaVencida = newMontoDeudaVencida;
    }

    public BigDecimal getDeudaTotalCliente() {
        return deudaTotalCliente;
    }

    public void setDeudaTotalCliente(BigDecimal newDeudaTotalCliente) {
        deudaTotalCliente = newDeudaTotalCliente;
    }

    public Long getNumDiasAtraso() {
        return numDiasAtraso;
    }

    public void setNumDiasAtraso(Long newNumDiasAtraso) {
        numDiasAtraso = newNumDiasAtraso;
    }

    public BigDecimal getMontoSolicitudesNuevas() {
        return montoSolicitudesNuevas;
    }

    public void setMontoSolicitudesNuevas(BigDecimal newMontoSolicitudesNuevas) {
        montoSolicitudesNuevas = newMontoSolicitudesNuevas;
    }

    public BigDecimal getCuponTramiteCliente() {
        return cuponTramiteCliente;
    }

    public void setCuponTramiteCliente(BigDecimal newCuponTramiteCliente) {
        cuponTramiteCliente = newCuponTramiteCliente;
    }

    public Long getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(Long newNivelRiesgo) {
        nivelRiesgo = newNivelRiesgo;
    }

    public BigDecimal getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(BigDecimal newLineaCredito) {
        lineaCredito = newLineaCredito;
    }
}