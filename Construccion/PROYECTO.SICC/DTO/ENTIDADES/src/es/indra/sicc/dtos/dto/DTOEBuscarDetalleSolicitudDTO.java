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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOEBuscarDetalleSolicitudDTO 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024-1
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */


public class DTOEBuscarDetalleSolicitudDTO extends DTOSiccPaginacion {
    private Long oidSolicitudCabecera;

    public DTOEBuscarDetalleSolicitudDTO() {
    }

    public Long getOidSolicitudCabecera()
    {
        return oidSolicitudCabecera;
    }

    public void setOidSolicitudCabecera(Long newOidSolicitudCabecera)
    {
        oidSolicitudCabecera = newOidSolicitudCabecera;
    }
}