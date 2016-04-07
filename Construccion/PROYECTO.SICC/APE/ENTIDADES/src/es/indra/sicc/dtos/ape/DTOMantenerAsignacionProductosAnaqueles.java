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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.ArrayList;


public class DTOMantenerAsignacionProductosAnaqueles extends DTOSiccPaginacion {
    private Long oidAsignacionProductoAnaquel;
    private String codigoAnaquel;
    private String codigoProducto;
    private Long oidCentroDistribucion;
    private Long oidLineaArmado;
    private Long oidMapaCentroDistribucion;
    private Long oidMapaZona;
    private Long oidPeriodo;
    private String version;
    private ArrayList lstValidacionProductoAnaquel;
    private String descripcionCentroDistribucion;
    private String descripcionLineaArmado;
    private String descripcionMapaCentroDistribucion;
    private String descripcionMapaZona;
    private String descripcionMarca;
    private String descripcionCanal;
    private String descripcionPeriodo;


    public DTOMantenerAsignacionProductosAnaqueles() {
    }

    public void setOidAsignacionProductoAnaquel(Long oidAsignacionProductoAnaquel) {
        this.oidAsignacionProductoAnaquel = oidAsignacionProductoAnaquel;
    }

    public Long getOidAsignacionProductoAnaquel() {
        return oidAsignacionProductoAnaquel;
    }

    public void setCodigoAnaquel(String codigoAnaquel) {
        this.codigoAnaquel = codigoAnaquel;
    }

    public String getCodigoAnaquel() {
        return codigoAnaquel;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getOidCentroDistribucion() {
        return oidCentroDistribucion;
    }

    public void setOidMapaCentroDistribucion(Long oidMapaCentroDistribucion) {
        this.oidMapaCentroDistribucion = oidMapaCentroDistribucion;
    }

    public Long getOidMapaCentroDistribucion() {
        return oidMapaCentroDistribucion;
    }

    public void setOidMapaZona(Long oidMapaZona) {
        this.oidMapaZona = oidMapaZona;
    }

    public Long getOidMapaZona() {
        return oidMapaZona;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setLstValidacionProductoAnaquel(ArrayList lstValidacionProductoAnaquel) {
      this.lstValidacionProductoAnaquel = lstValidacionProductoAnaquel;
    }

    public ArrayList getLstValidacionProductoAnaquel() {
        return lstValidacionProductoAnaquel;
    } 

    public void setOidLineaArmado(Long oidLineaArmado) {
        this.oidLineaArmado = oidLineaArmado;
    }

    public Long getOidLineaArmado() {
        return oidLineaArmado;
    }

    public void setDescripcionMapaCentroDistribucion(String descripcionMapaCentroDistribucion) {
        this.descripcionMapaCentroDistribucion = descripcionMapaCentroDistribucion;
    }

    public String getDescripcionMapaCentroDistribucion() {
        return descripcionMapaCentroDistribucion;
    }

    public void setDescripcionCentroDistribucion(String descripcionCentroDistribucion) {
        this.descripcionCentroDistribucion = descripcionCentroDistribucion;
    }

    public String getDescripcionCentroDistribucion() {
        return descripcionCentroDistribucion;
    }

    public void setDescripcionLineaArmado(String descripcionLineaArmado) {
        this.descripcionLineaArmado = descripcionLineaArmado;
    }

    public String getDescripcionLineaArmado() {
        return descripcionLineaArmado;
    }

    public void setDescripcionMapaZona(String descripcionMapaZona) {
        this.descripcionMapaZona = descripcionMapaZona;
    }

    public String getDescripcionMapaZona() {
        return descripcionMapaZona;
    }

    public void setDescripcionMarca(String descripcionMarca) {
        this.descripcionMarca = descripcionMarca;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setDescripcionCanal(String descripcionCanal) {
        this.descripcionCanal = descripcionCanal;
    }

    public String getDescripcionCanal() {
        return descripcionCanal;
    }

    public void setDescripcionPeriodo(String descripcionPeriodo) {
        this.descripcionPeriodo = descripcionPeriodo;
    }

    public String getDescripcionPeriodo() {
        return descripcionPeriodo;
    }

}