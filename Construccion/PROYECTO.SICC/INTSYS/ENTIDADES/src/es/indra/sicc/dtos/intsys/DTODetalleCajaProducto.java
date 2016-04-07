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


public class DTODetalleCajaProducto extends DTOBelcorp { // SS:
    private String anaquel; // 7:
    private Long cantidadRequeridaPicar; // 8:
    private Long cantidadActualPicada; // 9:
    private String nombrePicadorProducto; // 16:
    private String descripcionProducto; // 21:
    private String indicadorCambios; // 29:
    private String codigoProducto; // 30:        
    
    public DTODetalleCajaProducto() {
    }

    public void setAnaquel(String anaquel) {
        this.anaquel = anaquel;
    }

    public String getAnaquel() {
        return anaquel;
    }

    public void setCantidadRequeridaPicar(Long cantidadRequeridaPicar) {
        this.cantidadRequeridaPicar = cantidadRequeridaPicar;
    }

    public Long getCantidadRequeridaPicar() {
        return cantidadRequeridaPicar;
    }

    public void setCantidadActualPicada(Long cantidadActualPicada) {
        this.cantidadActualPicada = cantidadActualPicada;
    }

    public Long getCantidadActualPicada() {
        return cantidadActualPicada;
    }

    public void setNombrePicadorProducto(String nombrePicadorProducto) {
        this.nombrePicadorProducto = nombrePicadorProducto;
    }

    public String getNombrePicadorProducto() {
        return nombrePicadorProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setIndicadorCambios(String indicadorCambios) {
        this.indicadorCambios = indicadorCambios;
    }

    public String getIndicadorCambios() {
        return indicadorCambios;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

}