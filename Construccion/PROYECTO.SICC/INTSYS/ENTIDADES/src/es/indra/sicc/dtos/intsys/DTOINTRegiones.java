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

public class DTOINTRegiones extends DTOBelcorp  {
    private String codigoSGV;
    private String nombreSGV;
    private String codigoRegion;
    private String nombreRegion;
    private String codigoPais;
    private String nombrePais;
    private String codigoGerenteRegional;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;

    public DTOINTRegiones() {
    }

    public String getCodigoSGV() {
        return codigoSGV;
    }

    public void setCodigoSGV(String codigoSGV) {
        this.codigoSGV = codigoSGV;
    }

    public String getNombreSGV() {
        return nombreSGV;
    }

    public void setNombreSGV(String nombreSGV) {
        this.nombreSGV = nombreSGV;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCodigoGerenteRegional() {
        return codigoGerenteRegional;
    }

    public void setCodigoGerenteRegional(String codigoGerenteRegional) {
        this.codigoGerenteRegional = codigoGerenteRegional;
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
}