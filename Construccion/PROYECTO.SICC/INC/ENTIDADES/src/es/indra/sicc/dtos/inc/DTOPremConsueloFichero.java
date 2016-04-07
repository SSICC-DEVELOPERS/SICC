/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 * Autor : Paola Cabrera
 */
 
package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOPremConsueloFichero extends DTOBelcorp {       
    //Incidencia BELC300023493
    //cvalenzu
    private String nroConcurso;
    private String codCliente;
    
    private Long oidConcurso;
    private Long oidCliente;
    
    public DTOPremConsueloFichero() { }    
    
    public Long getOidConcurso() {
        return this.oidConcurso;
    }
    
    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }
    
    public Long getOidCliente() {
        return this.oidCliente;
    }
    
    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }
    
    
    public String getNroConcurso() {
        return nroConcurso;
    }

    public void setNroConcurso(String nroConcurso) {
        this.nroConcurso = nroConcurso;
    }    
    
    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }   
}