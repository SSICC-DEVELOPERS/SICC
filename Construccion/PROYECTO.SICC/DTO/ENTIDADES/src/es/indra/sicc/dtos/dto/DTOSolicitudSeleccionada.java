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


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOSolicitudSeleccionada 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOSolicitudSeleccionada extends DTOAuditableSICC {

    private DTOObtenerCabeceraDTO cabecera;
    private RecordSet detalle;

    public DTOSolicitudSeleccionada() {

    }

    public DTOObtenerCabeceraDTO getCabecera()
    {
        return cabecera;
    }

    public void setCabecera(DTOObtenerCabeceraDTO newCabecera)
    {
        cabecera = newCabecera;
    }

    public RecordSet getDetalle()
    {
        return detalle;
    }

    public void setDetalle(RecordSet newDetalle)
    {
        detalle = newDetalle;
    }
}