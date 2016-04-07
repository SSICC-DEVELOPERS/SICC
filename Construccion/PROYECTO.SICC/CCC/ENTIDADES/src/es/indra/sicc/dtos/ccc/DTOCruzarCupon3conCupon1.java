/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

import java.util.Date;


public class DTOCruzarCupon3conCupon1 extends DTOBelcorp {
    private String anio;
    private String mes;
    private Integer numero;
    private Long oidSubacceso;
    private Date fechaDigitacion;
    private String referenciaExterna;
    private String observaciones;
    private String codigoCliente;
    private Long oidBanco;
    private BigDecimal importe;
    private Integer numeroCupon;
    private Date fechaDoc;
    
    //--Agregado por incidencia BELC300019692
    //--Paola Cabrera 15/11/2005
    private Long oidAcceso;
    private Long oidCanal;
    //-- Fin agregacion BELC300019692
    
    //cambio fac 03, modulo ccc (SCS-29/01/2008)
    private Long oidMarca;
    private Long oidPeriodo;
    
    //cambio fac 03, jzd, 28/02/2008
    private Long oidCtaCteBria;    

    public DTOCruzarCupon3conCupon1() {
        super();
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String newAnio) {
        anio = newAnio;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public Date getFechaDigitacion() {
        return fechaDigitacion;
    }

    public void setFechaDigitacion(Date newFechaDigitacion) {
        fechaDigitacion = newFechaDigitacion;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date newFechaDoc) {
        fechaDoc = newFechaDoc;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal newImporte) {
        importe = newImporte;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String newMes) {
        mes = newMes;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer newNumero) {
        numero = newNumero;
    }

    public Integer getNumeroCupon() {
        return numeroCupon;
    }

    public void setNumeroCupon(Integer newNumeroCupon) {
        numeroCupon = newNumeroCupon;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }

    public Long getOidBanco() {
        return oidBanco;
    }

    public void setOidBanco(Long newOidBanco) {
        oidBanco = newOidBanco;
    }

    public Long getOidSubacceso() {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long newOidSubacceso) {
        oidSubacceso = newOidSubacceso;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setReferenciaExterna(String newReferenciaExterna) {
        referenciaExterna = newReferenciaExterna;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }
    
    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }


    public Long getOidMarca()
    {
        return oidMarca;
    }


    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }


    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }


    public void setOidCtaCteBria(Long oidCtaCteBria)
    {
        this.oidCtaCteBria = oidCtaCteBria;
    }


    public Long getOidCtaCteBria()
    {
        return oidCtaCteBria;
    }
    
}
