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

public class DTOINTSecciones extends DTOBelcorp  {
    private String codigoSGV;
    private String codigoRegion;
    private String codigoSeccion;
    private String codigoZona;
    private String nombreSGV;
    private String nombreRegion;
    private String nombreZona;
    private String codigoLider;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String flagAptaLider;

    public DTOINTSecciones() {
    }


    public String getCodigoSGV() {
        return codigoSGV;
    }

    public void setCodigoSGV(String codigoSGV) {
        this.codigoSGV = codigoSGV;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getNombreSGV() {
        return nombreSGV;
    }

    public void setNombreSGV(String nombreSGV) {
        this.nombreSGV = nombreSGV;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getCodigoLider() {
        return codigoLider;
    }

    public void setCodigoLider(String codigoLider) {
        this.codigoLider = codigoLider;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFlagAptaLider() {
        return flagAptaLider;
    }

    public void setFlagAptaLider(String flagAptaLider) {
        this.flagAptaLider = flagAptaLider;
    }
}
