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
 * @date 28/04/2005
 * @author Gustavo Viñales
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 */
package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

import java.math.BigDecimal;


public class ArticuloLote implements Serializable {
    private Long numeroUnidades;
    private Long oidCodigoProducto;
    private BigDecimal precioPublico;
    private String codigoVentaFicticio;
    
    // DBLG500001023 - gPineda - 25/10/2006
    private String nombre;

    // INC 001 - gPineda - 13/01/2007
    private String codSapProducto;
    
    //INC-003 5-9-07
    private String tipoEntregaPremio;
    private String codigoCentroServicio;
    private String descripcionCentroServicio; 
    
    // vbongiov -- Cambio 20090828 -- 8/06/2009
    private Long oidArticuloLote;
    

    public ArticuloLote() {
    }

    public void setNumeroUnidades(Long numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public Long getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setOidCodigoProducto(Long oidCodigoProducto) {
        this.oidCodigoProducto = oidCodigoProducto;
    }

    public Long getOidCodigoProducto() {
        return oidCodigoProducto;
    }

    public void setPrecioPublico(BigDecimal precioPublico) {
        this.precioPublico = precioPublico;
    }

    public BigDecimal getPrecioPublico() {
        return precioPublico;
    }

    public void setCodigoVentaFicticio(String codigoVentaFicticio) {
        this.codigoVentaFicticio = codigoVentaFicticio;
    }

    public String getCodigoVentaFicticio() {
        return codigoVentaFicticio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setCodSapProducto(String codSapProducto) {
        this.codSapProducto = codSapProducto;
    }

    public String getCodSapProducto() {
        return codSapProducto;
    }

    public String getTipoEntregaPremio() {
        return tipoEntregaPremio;
    }

    public void setTipoEntregaPremio(String tipoEntregaPremio) {
        this.tipoEntregaPremio = tipoEntregaPremio;
    }

    public String getCodigoCentroServicio(){
        return codigoCentroServicio;
    }

    public void setCodigoCentroServicio(String codigoCentroServicio) {
        this.codigoCentroServicio = codigoCentroServicio;
    }

    public String getDescripcionCentroServicio() {
        return descripcionCentroServicio;
    }

    public void setDescripcionCentroServicio(String descripcionCentroServicio) {
        this.descripcionCentroServicio = descripcionCentroServicio;
    }    
    
    public void setOidArticuloLote(Long oidArticuloLote) {
        this.oidArticuloLote = oidArticuloLote;
    }

    public Long getOidArticuloLote() {
        return oidArticuloLote;
    }
}
