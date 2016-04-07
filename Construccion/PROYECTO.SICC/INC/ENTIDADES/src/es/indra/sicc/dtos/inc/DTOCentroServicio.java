package es.indra.sicc.dtos.inc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOCentroServicio extends DTOSiccPaginacion {

    private Long oidCentroServicio;
    private Long oidPais;
    private String codigo;
    private String descripcion;
    private String observaciones;

    public DTOCentroServicio()  {
    }

    public Long getOidCentroServicio() {
        return oidCentroServicio;
    }

    public void setOidCentroServicio(Long OIDCentroServicio) {
        this.oidCentroServicio = OIDCentroServicio;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long OIDPais) {
        this.oidPais = OIDPais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}