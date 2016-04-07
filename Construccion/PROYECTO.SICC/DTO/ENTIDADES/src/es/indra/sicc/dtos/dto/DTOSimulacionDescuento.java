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

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOSimulacionDescuento 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOSimulacionDescuento extends DTOAuditableSICC {
    private Long oidDescuento;
    private ArrayList listaSolicitudes;

    public DTOSimulacionDescuento() {
    }

    public Long getOidDescuento()
    {
        return oidDescuento;
    }

    public void setOidDescuento(Long newOidDescuento)
    {
        oidDescuento = newOidDescuento;
    }

    public ArrayList getListaSolicitudes()
    {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList newListaSolicitudes)
    {
        listaSolicitudes = newListaSolicitudes;
    }

}