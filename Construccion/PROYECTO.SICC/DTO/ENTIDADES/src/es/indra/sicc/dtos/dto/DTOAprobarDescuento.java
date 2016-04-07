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

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOAprobarDescuento 
 * Fecha:         28/07/2004
 * 
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOAprobarDescuento extends DTOAuditableSICC {
    private String descripcionDescuento;
    private String descripcionPeriodoDesde;
    private String descripcionPeriodoHasta;
    private Boolean indicadorActivo;
    private Boolean indicadorAprobado;
    private ArrayList listaTiposCliente;

    public DTOAprobarDescuento() {

    }

    public String getDescripcionDescuento()
    {
        return descripcionDescuento;
    }

    public void setDescripcionDescuento(String newDescripcionDescuento)
    {
        descripcionDescuento = newDescripcionDescuento;
    }

    public String getDescripcionPeriodoDesde()
    {
        return descripcionPeriodoDesde;
    }

    public void setDescripcionPeriodoDesde(String newDescripcionPeriodoDesde)
    {
        descripcionPeriodoDesde = newDescripcionPeriodoDesde;
    }

    public String getDescripcionPeriodoHasta()
    {
        return descripcionPeriodoHasta;
    }

    public void setDescripcionPeriodoHasta(String newDescripcionPeriodoHasta)
    {
        descripcionPeriodoHasta = newDescripcionPeriodoHasta;
    }

    public Boolean getIndicadorActivo()
    {
        return indicadorActivo;
    }

    public void setIndicadorActivo(Boolean newIndicadorActivo)
    {
        indicadorActivo = newIndicadorActivo;
    }

    public Boolean getIndicadorAprobado()
    {
        return indicadorAprobado;
    }

    public void setIndicadorAprobado(Boolean newIndicadorAprobado)
    {
        indicadorAprobado = newIndicadorAprobado;
    }

    public ArrayList getListaTiposCliente()
    {
        return listaTiposCliente;
    }

    public void setListaTiposCliente(ArrayList newListaTiposCliente)
    {
        listaTiposCliente = newListaTiposCliente;
    }

}