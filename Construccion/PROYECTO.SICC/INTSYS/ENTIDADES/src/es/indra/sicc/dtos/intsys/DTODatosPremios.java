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

public class DTODatosPremios extends DTOBelcorp  {
    private String numeroConcurso;
    private Long numeroNivel;
    private String codProducto;
    private Long numUnidades;

    /**
     * Constructor
     */
    public DTODatosPremios() {
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
     * Obtiene la propiedad codProducto
     * @return la propiedad codProducto
     */
    public String getCodProducto() {
        return codProducto;
    }

    /**
     * Asigna un valor a la propiedad codProducto
     * @param codProducto valor a asignar
     */
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    /**
     * Obtiene la propiedad numUnidades
     * @return la propiedad numUnidades
     */
    public Long getNumUnidades() {
        return numUnidades;
    }

    /**
     * Asigna un valor a la propiedad numUnidades
     * @param numUnidades valor a asignar
     */
    public void setNumUnidades(Long numUnidades) {
        this.numUnidades = numUnidades;
    }
}