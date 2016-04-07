/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       11/08/2004
 * @version     1.0
 * @autor       Hugo Andrés Mansi
 */
 
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import es.indra.sicc.util.DTOOID;


public interface IPEDGenerarSolicitudesExternas {
    DTOOID generarSolicitud(DTOCabeceraSolicitud dto) throws MareException;
}
