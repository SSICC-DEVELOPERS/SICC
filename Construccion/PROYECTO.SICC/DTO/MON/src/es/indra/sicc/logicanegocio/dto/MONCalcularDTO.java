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
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.dto.DTOSolicitudDescuento;
import es.indra.sicc.dtos.dto.DTOSimulacionDescuento;
import es.indra.sicc.dtos.dto.DTOSolicitudPosicionDescuento;
import java.util.ArrayList;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;


public interface MONCalcularDTO extends EJBObject {
    DTOSimulacionDescuento simularDescuentos(DTOSimulacionDescuento dto) throws RemoteException, MareException;

    DTOSolicitudDescuento validarDescuentos(DTOSolicitudValidacion dto) throws RemoteException, MareException;

    DTOSBaseAplicacion buscarBaseAplicacionMasEspecifica(DTOSolicitudPosicionDescuento posicion, ArrayList basesAplicables) throws RemoteException, MareException;
}