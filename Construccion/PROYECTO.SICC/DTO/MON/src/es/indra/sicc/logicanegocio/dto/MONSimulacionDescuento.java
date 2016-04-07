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
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.dto.DTOAprobarDescuento;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID; 
import es.indra.sicc.dtos.dto.DTOAprobacionDescuento;


public interface MONSimulacionDescuento extends EJBObject {
    DTOColeccion cargarSolicitudes(DTOColeccion dto) throws RemoteException, MareException;

    DTOSalida pedirSolicitudesDetalle(DTOOID dto) throws RemoteException, MareException;

    DTOAprobarDescuento cargarAprobarDescuento(DTOOID dto) throws RemoteException, MareException;

    void aprobarDescuento(DTOAprobacionDescuento dto) throws RemoteException, MareException;

}