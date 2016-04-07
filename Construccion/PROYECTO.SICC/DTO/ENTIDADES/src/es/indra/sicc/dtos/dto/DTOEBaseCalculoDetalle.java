package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOEBaseCalculoDetalle extends DTOAuditableSICC {
    private Long marca;
    private Long unidadNegocio;
    private Long negocio;
    private Long supergenerico;
    private Long genericos;
    private Boolean exclusionTipoOferta;
    private Long tipoOferta;
    private Long cicloVida;
    private Long producto;
    private Long oidBase;
    private Long oidDescuento;

    public DTOEBaseCalculoDetalle() {
    }





    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(Long newUnidadNegocio) {
        unidadNegocio = newUnidadNegocio;
    }

    public Long getNegocio() {
        return negocio;
    }

    public void setNegocio(Long newNegocio) {
        negocio = newNegocio;
    }

    public Long getSupergenerico() {
        return supergenerico;
    }

    public void setSupergenerico(Long newSupergenerico) {
        supergenerico = newSupergenerico;
    }

    public Long getGenericos() {
        return genericos;
    }

    public void setGenericos(Long newGenericos) {
        genericos = newGenericos;
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

    public Long getCicloVida() {
        return cicloVida;
    }

    public void setCicloVida(Long newCicloVida) {
        cicloVida = newCicloVida;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long newProducto) {
        producto = newProducto;
    }

    public Long getOidBase() {
        return oidBase;
    }

    public void setOidBase(Long newOidBase) {
        oidBase = newOidBase;
    }

    public Long getOidDescuento() {
        return oidDescuento;
    }

    public void setOidDescuento(Long newOidDescuento) {
        oidDescuento = newOidDescuento;
    }

















}