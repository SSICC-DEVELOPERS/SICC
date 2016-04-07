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
 *
 */
package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOBuscarCodigoVentaPeriodo extends DTOSiccPaginacion {
    private Long periodo;
    private String codigoVenta;
    private Long catalogo;
    private Integer paginaDesde;
    private Integer paginaHasta;
    /*
     * campo (+seter+geter) agregado por cambio SiCC 20070284
     * Rafael Romero - 07/06/2007
     */
    private String codigoSAP;

    public DTOBuscarCodigoVentaPeriodo() {
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long newPeriodo) {
        periodo = newPeriodo;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String newCodigoVenta) {
        codigoVenta = newCodigoVenta;
    }

    public Long getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Long newCatalogo) {
        catalogo = newCatalogo;
    }

    public Integer getPaginaDesde() {
        return paginaDesde;
    }

    public void setPaginaDesde(Integer newPaginaDesde) {
        paginaDesde = newPaginaDesde;
    }

    public Integer getPaginaHasta() {
        return paginaHasta;
    }

    public void setPaginaHasta(Integer newPaginaHasta) {
        paginaHasta = newPaginaHasta;
    }

    public String getCodigoSAP() {
        return codigoSAP;
    }

    public void setCodigoSAP(String codigoSAP) {
        this.codigoSAP = codigoSAP;
    }
}
