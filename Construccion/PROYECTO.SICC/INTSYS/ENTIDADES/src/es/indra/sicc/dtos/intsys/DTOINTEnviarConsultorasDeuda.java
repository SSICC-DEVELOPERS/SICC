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
*/
package es.indra.sicc.dtos.intsys;

import java.util.Date;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;

public class DTOINTEnviarConsultorasDeuda extends DTOBelcorp {
       
    private String numeroLote;      
    private String descripcionLote;      
    private String observaciones;      
    private DTOOIDs listaEmpresa;
    private DTOOIDs listaRegiones;      
    private DTOOIDs listaZonas;      
    private Date fechaDesde;      
    private Date fechaHasta;     
    private DTOOIDs listaTiposCliente;     
    private DTOOIDs listaSubtiposCliente;      
    private DTOOIDs listaTiposClasificacion;      
    private DTOOIDs  listaClasificacion;     
    private Boolean enviarConsultoras;      
    private Boolean enviarMovimientos;   

    public DTOINTEnviarConsultorasDeuda() {
        super();
    }
    
    public String getDescripcionLote() {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote) {
        this.descripcionLote = descripcionLote;
    }

    public DTOOIDs getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(DTOOIDs empresa) {
        this.listaEmpresa = empresa;
    }

    public Boolean getEnviarConsultoras() {
        return enviarConsultoras;
    }

    public void setEnviarConsultoras(Boolean enviarConsultoras) {
        this.enviarConsultoras = enviarConsultoras;
    }

    public Boolean getEnviarMovimientos() {
        return enviarMovimientos;
    }

    public void setEnviarMovimientos(Boolean enviarMovimientos) {
        this.enviarMovimientos = enviarMovimientos;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public DTOOIDs getListaClasificacion() {
        return listaClasificacion;
    }

    public void setListaClasificacion(DTOOIDs listaClasificacion) {
        this.listaClasificacion = listaClasificacion;
    }

    public DTOOIDs getListaRegiones() {
        return listaRegiones;
    }

    public void setListaRegiones(DTOOIDs listaRegiones) {
        this.listaRegiones = listaRegiones;
    }

    public DTOOIDs getListaSubtiposCliente() {
        return listaSubtiposCliente;
    }

    public void setListaSubtiposCliente(DTOOIDs listaSubtiposCliente) {
        this.listaSubtiposCliente = listaSubtiposCliente;
    }

    public DTOOIDs getListaTiposClasificacion() {
        return listaTiposClasificacion;
    }

    public void setListaTiposClasificacion(DTOOIDs listaTiposClasificacion) {
        this.listaTiposClasificacion = listaTiposClasificacion;
    }

    public DTOOIDs getListaTiposCliente() {
        return listaTiposCliente;
    }

    public void setListaTiposCliente(DTOOIDs listaTiposCliente) {
        this.listaTiposCliente = listaTiposCliente;
    }

    public DTOOIDs getListaZonas() {
        return listaZonas;
    }

    public void setListaZonas(DTOOIDs listaZonas) {
        this.listaZonas = listaZonas;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}