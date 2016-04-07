package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.math.BigDecimal;

public class DTOEscalon extends DTOAuditableSICC {
    private Long oidEscalon;
    private BigDecimal escalaDesde;
    private BigDecimal escalaHasta;
    private Double porcentajeDescuento;

    public DTOEscalon() {
    }

    public Long getOidEscalon() {
        return oidEscalon;
    }

    public void setOidEscalon(Long newOidEscalon) {
        oidEscalon = newOidEscalon;
    }

    public BigDecimal getEscalaDesde() {
        return escalaDesde;
    }

    public void setEscalaDesde(BigDecimal newEscalaDesde) {
        escalaDesde = newEscalaDesde;
    }

    public BigDecimal getEscalaHasta() {
        return escalaHasta;
    }

    public void setEscalaHasta(BigDecimal newEscalaHasta) {
        escalaHasta = newEscalaHasta;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double newPorcentajeDescuento) {
        porcentajeDescuento = newPorcentajeDescuento;
    }
}