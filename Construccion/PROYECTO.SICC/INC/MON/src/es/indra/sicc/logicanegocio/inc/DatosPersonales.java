/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 *
 * @date 27/04/2005
 * @author Gustavo Viñales
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 * 
 * 
 */
 
package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable; 
 
public class DatosPersonales
        implements Serializable {
    private String apellido1;
    private String apellido2;
    private String codCliente;
    private String codTerritorio;
    private String codZona;
    private String nombre1;
    private String nombre2;
    
    //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010                        
    private String codRegion;

    public DatosPersonales() {
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodTerritorio(String codTerritorio) {
        this.codTerritorio = codTerritorio;
    }

    public String getCodTerritorio() {
        return codTerritorio;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getCodRegion() {
        return codRegion;
    }
}
