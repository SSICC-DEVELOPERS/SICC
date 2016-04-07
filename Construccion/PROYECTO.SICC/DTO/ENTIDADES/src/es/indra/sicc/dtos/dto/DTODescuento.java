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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTODescuento 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTODescuento extends DTOAuditableSICC {

    private DTODescuentoDG datosGenerales;
    private DTOSAlcanceTipoClienteDTO alcanceTipoCliente;
    private RecordSet descuentosACliente;
    private RecordSet alcanceAdministrativo;
    private ArrayList baseCalculo;
    private ArrayList baseAplicacion;

    public DTODescuento() {
    }

    public DTODescuentoDG getDatosGenerales()
    {
        return datosGenerales;
    }

    public void setDatosGenerales(DTODescuentoDG newDatosGenerales)
    {
        datosGenerales = newDatosGenerales;
    }

    public DTOSAlcanceTipoClienteDTO getAlcanceTipoCliente()
    {
        return alcanceTipoCliente;
    }

    public void setAlcanceTipoCliente(DTOSAlcanceTipoClienteDTO newAlcanceTipoCliente)
    {
        alcanceTipoCliente = newAlcanceTipoCliente;
    }

    public RecordSet getDescuentosACliente()
    {
        return descuentosACliente;
    }

    public void setDescuentosACliente(RecordSet newDescuentosACliente)
    {
        descuentosACliente = newDescuentosACliente;
    }

    public RecordSet getAlcanceAdministrativo()
    {
        return alcanceAdministrativo;
    }

    public void setAlcanceAdministrativo(RecordSet newAlcanceAdministrativo)
    {
        alcanceAdministrativo = newAlcanceAdministrativo;
    }

    public ArrayList getBaseCalculo()
    {
        return baseCalculo;
    }

    public void setBaseCalculo(ArrayList newBaseCalculo)
    {
        baseCalculo = newBaseCalculo;
    }

    public ArrayList getBaseAplicacion()
    {
        return baseAplicacion;
    }

    public void setBaseAplicacion(ArrayList newBaseAplicacion)
    {
        baseAplicacion = newBaseAplicacion;
    }

    
}