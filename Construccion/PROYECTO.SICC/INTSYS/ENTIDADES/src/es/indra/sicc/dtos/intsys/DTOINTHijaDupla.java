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
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTHijaDupla extends DTOBelcorp  {

    private String codigoCliente;
    private String codigoMadreDupla;
    private String nombreCompleto;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
    private String fechaNacimiento;
    private String email;
    private String telefonoFijo;
    private String telefonoMovil;
    private String indicadorContactada;
    private String estatus;
    private String campaniaIngreso;
    private String fechaIngreso;
    private String fechaUltimaActualizacion;
    private String codigoCanalIngreso;
    //PER-SiCC-2010-0002 Implementar nuevo atributo en Interfaces
    private String indicadorConfirmacion;

    public DTOINTHijaDupla() {
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoMadreDupla(String codigoMadreDupla) {
        this.codigoMadreDupla = codigoMadreDupla;
    }

    public String getCodigoMadreDupla() {
        return codigoMadreDupla;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setIndicadorContactada(String indicadorContactada) {
        this.indicadorContactada = indicadorContactada;
    }

    public String getIndicadorContactada() {
        return indicadorContactada;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setCampaniaIngreso(String campaniaIngreso) {
        this.campaniaIngreso = campaniaIngreso;
    }

    public String getCampaniaIngreso() {
        return campaniaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public String getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setCodigoCanalIngreso(String codigoCanalIngreso) {
        this.codigoCanalIngreso = codigoCanalIngreso;
    }

    public String getCodigoCanalIngreso() {
        return codigoCanalIngreso;
    }
    
    public String getIndicadorConfirmacion() {
        return indicadorConfirmacion;
    }

    public void setIndicadorConfirmacion(String indicadorConfirmacion) {
        this.indicadorConfirmacion = indicadorConfirmacion;
    }
}