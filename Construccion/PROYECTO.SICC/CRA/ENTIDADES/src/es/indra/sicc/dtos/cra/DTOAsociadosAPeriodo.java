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
 */

package es.indra.sicc.dtos.cra;

import java.util.Vector;
import java.sql.Date;
import java.io.Serializable;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * Sistema:           Belcorp
 * Modulo:            Cronograma de Actividades (CRA)
 * Submodulo:         Entidades
 * Componente:        DTOAsociadosAPeriodo
 * Fecha:             09/06/2003
 * Descripcion:       Este componente ha sido creado de acuerdo a lo especificado 
 *                    en el modelo de componentes SICC-DMCO-CRA-001-222.zip
 *                    
 * @version           1.0
 * @autor             Guillermo López
 * @version           2.0
 * @autor             Carlos Ferreira
 */  
 
public class DTOAsociadosAPeriodo extends DTOSiccPaginacion {
    private Long marca;
    private Long pais;
    private Long canal;
    private Integer anio;
    private String periodo;
    private Long tipoPeriodo;
    private Date fecha;
    private String nombrePeriodo;
    private Long oidPeriodoCorporativo;

    public DTOAsociadosAPeriodo() {
        super();
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarcas) {
        marca = newMarcas;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer newAnio) {
        anio = newAnio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String newPeriodo) {
        periodo = newPeriodo;
    }

    public Long getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(Long newTipoPeriodo) {
        tipoPeriodo = newTipoPeriodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date newFecha) {
        fecha = newFecha;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String newNombrePeriodo) {
        nombrePeriodo = newNombrePeriodo;
    }

    public Long getOidPeriodoCorporativo()
    {
        return oidPeriodoCorporativo;
    }

    public void setOidPeriodoCorporativo(Long newOidPeriodoCorporativo)
    {
        oidPeriodoCorporativo = newOidPeriodoCorporativo;
    }

}