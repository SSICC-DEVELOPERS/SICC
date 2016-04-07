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
 * 
 * Autor : Diego Morello
 */


package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOConsultarPremiosConsuelo extends DTOSiccPaginacion  {
    private String codCliente;
    private Long nroConcurso;
    private Long articulo;
    private Long region;
    private Long zona;
    private Long oidCliente;

    public DTOConsultarPremiosConsuelo() {
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Long getNroConcurso() {
        return nroConcurso;
    }

    public void setNroConcurso(Long nroConcurso) {
        this.nroConcurso = nroConcurso;
    }

    public Long getArticulo() {
        return articulo;
    }

    public void setArticulo(Long articulo) {
        this.articulo = articulo;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long zona) {
        this.zona = zona;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }
}