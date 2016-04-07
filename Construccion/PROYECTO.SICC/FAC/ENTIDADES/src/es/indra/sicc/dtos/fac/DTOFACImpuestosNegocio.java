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


package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTOFACImpuestosNegocio extends DTOBelcorp {

    public DTOFACImpuestosNegocio() {
    }

    /*Incidencia BELC300008464   
     Se ha modificado la clase DTOFACImpuestosNegocio de la siguiente forma:

    - por innecesarios, se han eliminado los atributos 'canal' y 'acceso'
    - especificados a tipo Long 'pais', 'subacceso', 'negocio' e 'indicadorImpuesto'*/
    private Long pais;    
    private Long subacceso;   
    private Long negocio;  
    private Long indicadorImpuesto;

    public Long getIndicadorImpuesto() {
        return indicadorImpuesto;
    }

    public void setIndicadorImpuesto(Long newIndicadorImpuesto) {
        indicadorImpuesto = newIndicadorImpuesto;
    }

    public Long getNegocio() {
        return negocio;
    }

    public void setNegocio(Long newNegocio) {
        negocio = newNegocio;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long newSubacceso) {
        subacceso = newSubacceso;
    }
    
}