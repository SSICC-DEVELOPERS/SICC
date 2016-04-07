/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.cra;
import java.io.Serializable;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Subm�dulo:         
 * Componente:        DTO's
 * Fecha:             06/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del 
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 *                    
 * @version           1.0
 * @autor             Federico G. Stilman
 * @version           2.0
 * @autor             Carlos Ferreira
 */


public class DTOCriteriosPeriodo extends DTOSiccPaginacion {
    private Long marca;
    private String periodo;
    private Long pais;
    private Long canal;
    private Long tipo;
    private String nombre;
    private Integer anio;
    private String codigoTipo;
    private Long oidPeriodo;
    Boolean periodoCorto;
    Boolean periodoCruce;
    private Long acceso;
    
    public DTOCriteriosPeriodo() {
        super();
    }    

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer newAnio) {
        anio = newAnio;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String newPeriodo) {
        periodo = newPeriodo;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipo) {
        tipo = newTipo;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String newCodigoTipo) {
        codigoTipo = newCodigoTipo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo) {
        oidPeriodo = newOidPeriodo;
    }

    public Boolean getPeriodoCorto()
    {
        return periodoCorto;
    }

    public void setPeriodoCorto(Boolean newPeriodoCorto)
    {
        periodoCorto = newPeriodoCorto;
    }

    public Boolean getPeriodoCruce()
    {
        return periodoCruce;
    }

    public void setPeriodoCruce(Boolean newPeriodoCruce)
    {
        periodoCruce = newPeriodoCruce;
    }
    public Long getAcceso()
    {
       return acceso;
    }

    public void setAcceso(Long acceso)
    {
       this.acceso = acceso;
    }
    
}