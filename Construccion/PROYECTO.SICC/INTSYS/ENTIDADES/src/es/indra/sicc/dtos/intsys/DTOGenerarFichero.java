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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOGenerarFichero extends DTOBelcorp{


    private String numeroDocumento;
    private String numeroLote;
    private String descripcionLote;
    private Date fechaCreacion;
    private Date fechaVencimientoDesde;
    private Date fechaVencimientoHasta;
    private Long oidEstatus;
    private String estatus;
    private String observaciones;
    private RecordSet lstDetalle;
    private Long oidCanal;
    private Long oidMarca;
    private Long oidAcceso;
    private String marca;
    private String canal;
    private String acceso;


    public void setNumeroDocumento(String numeroDocumento){
        this.numeroDocumento = numeroDocumento;
    }


    public String getNumeroDocumento(){
        return numeroDocumento;
    }


    public void setNumeroLote(String numeroLote){
        this.numeroLote = numeroLote;
    }


    public String getNumeroLote(){
        return numeroLote;
    }


    public void setDescripcionLote(String descripcionLote){
        this.descripcionLote = descripcionLote;
    }


    public String getDescripcionLote(){
        return descripcionLote;
    }


    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }


    public Date getFechaCreacion(){
        return fechaCreacion;
    }


    public void setFechaVencimientoDesde(Date fechaVencimientoDesde){
        this.fechaVencimientoDesde = fechaVencimientoDesde;
    }


    public Date getFechaVencimientoDesde(){
        return fechaVencimientoDesde;
    }


    public void setFechaVencimientoHasta(Date fechaVencimientoHasta){
        this.fechaVencimientoHasta = fechaVencimientoHasta;
    }


    public Date getFechaVencimientoHasta(){
        return fechaVencimientoHasta;
    }


    public void setOidEstatus(Long oidEstatus){
        this.oidEstatus = oidEstatus;
    }


    public Long getOidEstatus(){
        return oidEstatus;
    }


    public void setEstatus(String estatus){
        this.estatus = estatus;
    }


    public String getEstatus(){
        return estatus;
    }


    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }


    public String getObservaciones(){
        return observaciones;
    }


    public void setLstDetalle(RecordSet lstDetalle){
        this.lstDetalle = lstDetalle;
    }


    public RecordSet getLstDetalle(){
        return lstDetalle;
    }


    public void setOidCanal(Long oidCanal){
        this.oidCanal = oidCanal;
    }


    public Long getOidCanal(){
        return oidCanal;
    }


    public void setOidMarca(Long oidMarca){
        this.oidMarca = oidMarca;
    }


    public Long getOidMarca(){
        return oidMarca;
    }


    public void setOidAcceso(Long oidAcceso){
        this.oidAcceso = oidAcceso;
    }


    public Long getOidAcceso(){
        return oidAcceso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

}