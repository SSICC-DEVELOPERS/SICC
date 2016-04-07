/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;


public class DTOPedidoFacturadoAPicar extends DTOBelcorp {
    private String numSolicitud;
    private String codProd;
    private String descProd;
    private Long unidadesAtendidas;
    private Boolean indicadorChequeo;
    private Long oidListaPicadoCabecera;
    private Long oidListaPicadoDetalle;
    
    
    public DTOPedidoFacturadoAPicar() {
    }

    public void setNumSolicitud(String numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public String getNumSolicitud() {
        return numSolicitud;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setUnidadesAtendidas(Long unidadesAtendidas) {
        this.unidadesAtendidas = unidadesAtendidas;
    }

    public Long getUnidadesAtendidas() {
        return unidadesAtendidas;
    }

    public void setIndicadorChequeo(Boolean indicadorChequeo) {
        this.indicadorChequeo = indicadorChequeo;
    }

    public Boolean getIndicadorChequeo() {
        return indicadorChequeo;
    }

    public void setOidListaPicadoCabecera(Long oidListaPicadoCabecera) {
        this.oidListaPicadoCabecera = oidListaPicadoCabecera;
    }

    public Long getOidListaPicadoCabecera() {
        return oidListaPicadoCabecera;
    }

    public void setOidListaPicadoDetalle(Long oidListaPicadoDetalle) {
        this.oidListaPicadoDetalle = oidListaPicadoDetalle;
    }

    public Long getOidListaPicadoDetalle() {
        return oidListaPicadoDetalle;
    }
    
}