package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOSBaseCalculoDetalle extends DTOAuditableSICC {
    private Long marca;
    private String descripcionMarca;
    private Long unidadNegocio;
    private String descripcionUnidadNegocio;
    private Long negocio;
    private String descripcionNegocio;
    private Long supergenerico;
    private String descripcionSupergenerico;
    private Long generico;
    private String descripcionGenerico;
    private Boolean exclusionTipoOferta;
    private Long tipoOferta;
    private String descripcionTipoOferta;
    private Long cicloVida;
    private String descripcionCicloVida;
    private Long producto;
    private String descripcionProducto;

    public DTOSBaseCalculoDetalle() {
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setDescripcionMarca(String newDescripcionMarca) {
        descripcionMarca = newDescripcionMarca;
    }

    public Long getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(Long newUnidadNegocio) {
        unidadNegocio = newUnidadNegocio;
    }

    public String getDescripcionUnidadNegocio() {
        return descripcionUnidadNegocio;
    }

    public void setDescripcionUnidadNegocio(String newDescripcionUnidadNegocio) {
        descripcionUnidadNegocio = newDescripcionUnidadNegocio;
    }

    public Long getNegocio() {
        return negocio;
    }

    public void setNegocio(Long newNegocio) {
        negocio = newNegocio;
    }

    public String getDescripcionNegocio() {
        return descripcionNegocio;
    }

    public void setDescripcionNegocio(String newDescripcionNegocio) {
        descripcionNegocio = newDescripcionNegocio;
    }

    public Long getSupergenerico() {
        return supergenerico;
    }

    public void setSupergenerico(Long newSupergenerico) {
        supergenerico = newSupergenerico;
    }

    public String getDescripcionSupergenerico() {
        return descripcionSupergenerico;
    }

    public void setDescripcionSupergenerico(String newDescripcionSupergenerico) {
        descripcionSupergenerico = newDescripcionSupergenerico;
    }

    public Long getGenerico() {
        return generico;
    }

    public void setGenerico(Long newGenerico) {
        generico = newGenerico;
    }

    public String getDescripcionGenerico() {
        return descripcionGenerico;
    }

    public void setDescripcionGenerico(String newDescripcionGenerico) {
        descripcionGenerico = newDescripcionGenerico;
    }

    public Boolean getExclusionTipoOferta() {
        return exclusionTipoOferta;
    }

    public void setExclusionTipoOferta(Boolean newExclusionTipoOferta) {
        exclusionTipoOferta = newExclusionTipoOferta;
    }

    public Long getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(Long newTipoOferta) {
        tipoOferta = newTipoOferta;
    }

    public String getDescripcionTipoOferta() {
        return descripcionTipoOferta;
    }

    public void setDescripcionTipoOferta(String newDescripcionTipoOferta) {
        descripcionTipoOferta = newDescripcionTipoOferta;
    }

    public Long getCicloVida() {
        return cicloVida;
    }

    public void setCicloVida(Long newCicloVida) {
        cicloVida = newCicloVida;
    }

    public String getDescripcionCicloVida() {
        return descripcionCicloVida;
    }

    public void setDescripcionCicloVida(String newDescripcionCicloVida) {
        descripcionCicloVida = newDescripcionCicloVida;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long newProducto) {
        producto = newProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String newDescripcionProducto) {
        descripcionProducto = newDescripcionProducto;
    }
}