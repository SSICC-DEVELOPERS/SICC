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
 * @author Dante Castiglione
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.sql.Date;

import java.util.HashMap;


public class ClienteRecomendado implements Serializable {
    private Long recomendante;
    private Long recomendado;
    private Periodo periodo;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean contenidoEnPeriodo;
    private HashMap periodosConPedidos;

    public ClienteRecomendado() {
    }

    public Boolean pasoPedidos(Long oidPeriodo) {
        return new Boolean(this.periodosConPedidos.containsKey(oidPeriodo));
    }

    public Long getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(Long recomendado) {
        this.recomendado = recomendado;
    }

    public Long getRecomendante() {
        return recomendante;
    }

    public void setRecomendante(Long recomendante) {
        this.recomendante = recomendante;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public HashMap getPeriodosConPedidos() {
        return periodosConPedidos;
    }

    public void setPeriodosConPedidos(HashMap periodosConPedidos) {
        this.periodosConPedidos = periodosConPedidos;
    }


    /*
     * JVM, sicc 20070381, setPeriodo
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    /*
     * JVM, sicc 20070381, getPeriodo
     */
    public Periodo getPeriodo() {
        return this.periodo;
    }


    public void setContenidoEnPeriodo(boolean contenidoEnPeriodo) {
        this.contenidoEnPeriodo = contenidoEnPeriodo;
    }


    public boolean getContenidoEnPeriodo() {
        return contenidoEnPeriodo;
    }


    
}
