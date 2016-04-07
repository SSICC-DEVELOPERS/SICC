package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEAlcanceAdministrativoDetalleDTO extends DTOAuditableSICC {
    private Long oidSubgerenciaVentas;
    private Long oidRegion;
    private Long oidZona;
    private Double porcentajeAdicional;

    public DTOEAlcanceAdministrativoDetalleDTO() {
    }

    public Long getOidSubgerenciaVentas() {
        return oidSubgerenciaVentas;
    }

    public void setOidSubgerenciaVentas(Long newOidSubgerenciaVentas) {
        oidSubgerenciaVentas = newOidSubgerenciaVentas;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidRegion(Long newOidRegion) {
        oidRegion = newOidRegion;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long newOidZona) {
        oidZona = newOidZona;
    }

    public Double getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    public void setPorcentajeAdicional(Double newPorcentajeAdicional) {
        porcentajeAdicional = newPorcentajeAdicional;
    }
}