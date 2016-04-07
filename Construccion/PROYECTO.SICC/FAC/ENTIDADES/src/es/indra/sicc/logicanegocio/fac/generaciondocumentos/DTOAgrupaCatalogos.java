package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.DTOBelcorp;

public class DTOAgrupaCatalogos extends DTOBelcorp {
    private String codigoAgrupacion;
    private String descripcion;
    private Float valorTotal;
    private String codigo;

    public DTOAgrupaCatalogos() {
    }

    public String getCodigoAgrupacion() {
        return codigoAgrupacion;
    }

    public void setCodigoAgrupacion(String codigoAgrupacion) {
        this.codigoAgrupacion = codigoAgrupacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}