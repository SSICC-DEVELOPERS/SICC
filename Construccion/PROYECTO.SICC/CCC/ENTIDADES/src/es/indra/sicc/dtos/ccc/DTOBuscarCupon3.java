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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.Date;


public class DTOBuscarCupon3 extends DTOSiccPaginacion {
    private String anio;
    private String mes;
    private Integer numero;
    private Long oidSubacceso;
    private String codigoCliente;
    private Date fechaDoc;
    private Long oidBanco;
    private Long oidSituacion;
    private Long oidMarca;
    private Long oidPeriodo;
    //cambio fac 03, jzd, 28/02/2008
    private Long oidCtaCteBria;    
    

    public DTOBuscarCupon3() {
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

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date newFechaDoc) {
        fechaDoc = newFechaDoc;
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

    public Long getOidBanco() {
        return oidBanco;
    }

    public void setOidBanco(Long newOidBanco) {
        oidBanco = newOidBanco;
    }

    public Long getOidSituacion() {
        return oidSituacion;
    }

    public void setOidSituacion(Long newOidSituacion) {
        oidSituacion = newOidSituacion;
    }

    public Long getOidSubacceso() {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long newOidSubacceso) {
        oidSubacceso = newOidSubacceso;
    }


    public void setOidCtaCteBria(Long oidCtaCteBria)
    {
        this.oidCtaCteBria = oidCtaCteBria;
    }


    public Long getOidCtaCteBria()
    {
        return oidCtaCteBria;
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
}
