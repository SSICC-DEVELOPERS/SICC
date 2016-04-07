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

package es.indra.sicc.dtos.zon;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

/**
 * Sistema:           Belcorp
 * Modulo:            ZON 
 * Submódulo:         Zonificación
 * Componente:        DTO's
 * Fecha:             19/05/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-ZON-201-334-N028
 *                    (Subido al portal el //)
 * @version           1.0
 * @autor             
 */

public class DTORezonificacionCabecera  extends DTOBelcorp {
    private String codCanal;
    private String codPais;
    private String codMarca;
    private String tipoPeriodo;
    private String periodoInicio;
    private Date fechaActualizacion;
    private Date fechaCreacionGIS;


    public DTORezonificacionCabecera() {
        super();
    }

    public String getCodPais(){
        return codPais;
    }
    
    public String getCodCanal(){
        return codCanal;
    }

    public String getCodMarca() {
        return codMarca;
    }


    public String getTipoPeriodo() {
        return tipoPeriodo;
    }


    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public void setCodCanal(String codCanal) {
        this.codCanal = codCanal;
    }

    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public String getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacionGIS() {
        return fechaCreacionGIS;
    }

    public void setFechaCreacionGIS(Date fechaCreacionGIS) {
        this.fechaCreacionGIS = fechaCreacionGIS;
    }


}
