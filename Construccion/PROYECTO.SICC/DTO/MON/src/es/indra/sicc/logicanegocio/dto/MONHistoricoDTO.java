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
 */
package es.indra.sicc.logicanegocio.dto;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID; 
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.dto.DTOHistoricoDescuento;
import es.indra.sicc.dtos.dto.DTOEBuscarClientesDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarSolicitudesClienteDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarDetalleSolicitudDTO;
import java.util.ArrayList;

public interface MONHistoricoDTO extends EJBObject {
    void generarHistoricoDescuentos(ArrayList historicosDescuentos, Long oidPais, Long oidSolicitud) throws RemoteException, MareException;

    void borrarHistoricoSolicitud(DTOOID dto) throws RemoteException, MareException;

    DTOSalida buscarClientesDTO(DTOEBuscarClientesDTO dto) throws RemoteException, MareException;

    DTOSalida buscarSolicitudesPorClienteDTO(DTOEBuscarSolicitudesClienteDTO dto) throws RemoteException, MareException;

    DTOSalida buscarDetalleSolicitudDTO(DTOEBuscarDetalleSolicitudDTO dto) throws RemoteException, MareException;
}