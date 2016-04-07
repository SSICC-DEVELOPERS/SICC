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

public class DTODatosConcursos extends DTOBelcorp  {
    private String codCliente;
    private Long oidPeriodoHasta;
    private String numeroConcurso;
    private String tipoConcurso;
    private Long puntajeAcumulado;
    private Integer numPeriodos;
    private Long oidPeriodoDespacho;

    /**
     * Constructor
     */
    public DTODatosConcursos() {
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
     * Obtiene la propiedad oidPeriodoHasta
     * @return la propiedad oidPeriodoHasta
     */
    public Long getOidPeriodoHasta() {
        return oidPeriodoHasta;
    }

    /**
     * Asigna un valor a la propiedad oidPeriodoHasta
     * @param oidPeriodoHasta valor a asignar
     */
    public void setOidPeriodoHasta(Long oidPeriodoHasta) {
        this.oidPeriodoHasta = oidPeriodoHasta;
    }

    /**
     * Obtiene la propiedad numeroConcurso
     * @return la propiedad numeroConcurso
     */
    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    /**
     * Asigna un valor a la propiedad numeroConcurso
     * @param numeroConcurso valor a asignar
     */
    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    /**
     * Obtiene la propiedad tipoConcurso
     * @return la propiedad tipoConcurso
     */
    public String getTipoConcurso() {
        return tipoConcurso;
    }

    /**
     * Asigna un valor a la propiedad tipoConcurso
     * @param tipoConcurso valor a asignar
     */
    public void setTipoConcurso(String tipoConcurso) {
        this.tipoConcurso = tipoConcurso;
    }

    /**
     * Obtiene la propiedad puntajeAcumulado
     * @return la propiedad puntajeAcumulado
     */
    public Long getPuntajeAcumulado() {
        return puntajeAcumulado;
    }

    /**
     * Asigna un valor a la propiedad puntajeAcumulado
     * @param puntajeAcumulado valor a asignar
     */
    public void setPuntajeAcumulado(Long puntajeAcumulado) {
        this.puntajeAcumulado = puntajeAcumulado;
    }

    /**
     * Obtiene la propiedad numPeriodos
     * @return la propiedad numPeriodos
     */
    public Integer getNumPeriodos() {
        return numPeriodos;
    }

    /**
     * Asigna un valor a la propiedad numPeriodos
     * @param numPeriodos valor a asignar
     */
    public void setNumPeriodos(Integer numPeriodos) {
        this.numPeriodos = numPeriodos;
    }

    /**
     * Obtiene la propiedad oidPeriodoDespacho
     * @return la propiedad oidPeriodoDespacho
     */
    public Long getOidPeriodoDespacho() {
        return oidPeriodoDespacho;
    }

    /**
     * Asigna un valor a la propiedad oidPeriodoDespacho
     * @param oidPeriodoDespacho valor a asignar
     */
    public void setOidPeriodoDespacho(Long oidPeriodoDespacho) {
        this.oidPeriodoDespacho = oidPeriodoDespacho;
    }
}