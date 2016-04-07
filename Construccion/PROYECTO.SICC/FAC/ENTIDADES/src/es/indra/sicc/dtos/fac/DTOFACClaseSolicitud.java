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

public class DTOFACClaseSolicitud extends DTOBelcorp {

    public DTOFACClaseSolicitud() {
    }

    private Long claseSolicitud;     
    private String descripcion;     
    private Boolean indicadorOrdenCompra; //Incidencia BELC300008616

    public Long getClaseSolicitud() {
        return claseSolicitud;
    }

    public void setClaseSolicitud(Long newClaseSolicitud) {
        claseSolicitud = newClaseSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

    public Boolean getIndicadorOrdenCompra() {
        return indicadorOrdenCompra;
    }

    public void setIndicadorOrdenCompra(Boolean newIndicadorOrdenCompra) {
        indicadorOrdenCompra = newIndicadorOrdenCompra;
    }
}