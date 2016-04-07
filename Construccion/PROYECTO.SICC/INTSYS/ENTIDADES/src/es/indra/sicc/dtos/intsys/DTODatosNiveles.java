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

public class DTODatosNiveles extends DTOBelcorp  {
    private Long oidPeriodoHasta;
    private String numeroConcurso;
    private Long numeroNivel;
    private Long cantidadInicialPuntos;
    private Long cantidadFijaPuntos;
    private Integer numPeriodos;
    private Long oidPeriodoDespacho;

    /**
     * Constructor
     */
    public DTODatosNiveles() {
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
     * Obtiene la propiedad numeroNivel
     * @return la propiedad numeroNivel
     */
    public Long getNumeroNivel() {
        return numeroNivel;
    }

    /**
     * Asigna un valor a la propiedad numeroNivel
     * @param numeroNivel valor a asignar
     */
    public void setNumeroNivel(Long numeroNivel) {
        this.numeroNivel = numeroNivel;
    }

    /**
     * Obtiene la propiedad cantidadInicialPuntos
     * @return la propiedad cantidadInicialPuntos
     */
    public Long getCantidadInicialPuntos() {
        return cantidadInicialPuntos;
    }

    /**
     * Asigna un valor a la propiedad cantidadInicialPuntos
     * @param cantidadInicialPuntos valor a asignar
     */
    public void setCantidadInicialPuntos(Long cantidadInicialPuntos) {
        this.cantidadInicialPuntos = cantidadInicialPuntos;
    }

    /**
     * Obtiene la propiedad cantidadFinalPuntos
     * @return la propiedad cantidadFinalPuntos
     */
    public Long getCantidadFijaPuntos() {
        return cantidadFijaPuntos;
    }

    /**
     * Asigna un valor a la propiedad cantidadFinalPuntos
     * @param cantidadFinalPuntos valor a asignar
     */
    public void setCantidadFijaPuntos(Long cantidadFinalPuntos) {
        this.cantidadFijaPuntos = cantidadFinalPuntos;
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