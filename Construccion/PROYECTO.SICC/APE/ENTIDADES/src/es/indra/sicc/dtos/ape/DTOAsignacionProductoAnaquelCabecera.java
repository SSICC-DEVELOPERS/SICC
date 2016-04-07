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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;


public class DTOAsignacionProductoAnaquelCabecera extends DTOBelcorp {
    private Long oid;
    private String version;
    private Boolean estado;
    private String activoFacturacion;
    private Long oidMapaCDCabecera;
    private Long oidMapaZonaCabecera;
    private Long oidPeriodo;
    private Long oidCentroDistribucion;
    private DTOMapaZonasCabecera mapaZonaCabecera;


    public DTOAsignacionProductoAnaquelCabecera() {
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
  
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
  
    public Boolean getEstado() {
        return estado;
    }

    public void setActivoFacturacion(String activoFacturacion) {
        this.activoFacturacion = activoFacturacion;
    }

    public String getActivoFacturacion() {
        return activoFacturacion;
    }

    public void setOidMapaCDCabecera(Long oidMapaCDCabecera) {
        this.oidMapaCDCabecera = oidMapaCDCabecera;
    }

    public Long getOidMapaCDCabecera() {
        return oidMapaCDCabecera;
    }

    public void setOidMapaZonaCabecera(Long oidMapaZonaCabecera) {
        this.oidMapaZonaCabecera = oidMapaZonaCabecera;
    }

    public Long getOidMapaZonaCabecera() {
        return oidMapaZonaCabecera;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getOidCentroDistribucion() {
        return oidCentroDistribucion;
    }

    public void setMapaZonaCabecera(DTOMapaZonasCabecera mapaZonaCabecera) {
        this.mapaZonaCabecera = mapaZonaCabecera;
    }

    public DTOMapaZonasCabecera getMapaZonaCabecera() {
        return mapaZonaCabecera;
    }

}