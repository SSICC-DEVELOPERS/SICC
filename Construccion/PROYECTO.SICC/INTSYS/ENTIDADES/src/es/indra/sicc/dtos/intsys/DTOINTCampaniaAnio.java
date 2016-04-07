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
import java.util.Date;

public class DTOINTCampaniaAnio extends DTOBelcorp  {
    private Date fechaInicio;
    private Date fechaFin;
    private String codigoPeriodo;
    private Boolean inicioPeriodo;
    private Boolean finPeriodo;

    public DTOINTCampaniaAnio() {
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

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public Boolean getInicioPeriodo() {
        return inicioPeriodo;
    }

    public void setInicioPeriodo(Boolean inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    public Boolean getFinPeriodo() {
        return finPeriodo;
    }

    public void setFinPeriodo(Boolean finPeriodo) {
        this.finPeriodo = finPeriodo;
    }
}