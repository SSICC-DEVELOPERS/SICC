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

public class DTODatosBasesIncumplidas extends DTOBelcorp  {
    private Long oidCliente;
    private String codCliente;
    private String numConcurso;
    private Long baseIncumplida;
    private Long oidPeriodo;

    /**
     * Constructor
     */
    public DTODatosBasesIncumplidas() {
    }

    /**
     * Obtiene la propiedad oidCliente
     * @return la propiedad oidCliente
     */
    public Long getOidCliente() {
        return oidCliente;
    }

    /**
     * Asigna un valor a la propiedad oidCliente
     * @param oidCliente valor a asignar
     */
    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    /**
     * Obtiene la propiedad codCliente
     * @return la propiedad codCliente
     */
    public String getCodCliente() {
        return codCliente;
    }

    /**
     * Asigna un valor a la propiedad codCliente
     * @param codCliente valor a asignar
     */
    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * Obtiene la propiedad numConcurso
     * @return la propiedad numConcurso
     */
    public String getNumConcurso() {
        return numConcurso;
    }

    /**
     * Asigna un valor a la propiedad numConcurso
     * @param numConcurso valor a asignar
     */
    public void setNumConcurso(String numConcurso) {
        this.numConcurso = numConcurso;
    }

    /**
     * Obtiene la propiedad baseIncumplida
     * @return la propiedad baseIncumplida
     */
    public Long getBaseIncumplida() {
        return baseIncumplida;
    }

    /**
     * Asigna un valor a la propiedad baseIncumplida
     * @param baseIncumplida valor a asignar
     */
    public void setBaseIncumplida(Long baseIncumplida) {
        this.baseIncumplida = baseIncumplida;
    }

    /**
     * Obtiene la propiedad oidPeriodo
     * @return la propiedad oidPeriodo
     */
    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    /**
     * Asigna un valor a la propiedad oidPeriodo
     * @param oidPeriodo valor a asignar
     */
    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }
}