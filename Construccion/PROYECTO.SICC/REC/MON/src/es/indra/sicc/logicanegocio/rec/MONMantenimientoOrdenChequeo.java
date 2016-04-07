/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.rec;

import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.dtos.rec.DTOChequeoZona;

import es.indra.sicc.util.DTOBoolean;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.rec.DTOChequeoEnCampo;
import es.indra.sicc.dtos.rec.DTOChequeo;
import es.indra.sicc.dtos.rec.DTOChequeoManual;
import es.indra.sicc.dtos.rec.DTOChequeoEnLinea;
import es.indra.sicc.util.DTOOID;

public interface MONMantenimientoOrdenChequeo extends EJBObject  {
   void evaluarClientesChequear(MareDTO dtoE) throws RemoteException, MareException;

   DTOSalida obtenerTiposOrdenChequeo(DTOBelcorp dtoE) throws RemoteException, MareException;
   DTOSalida obtenerPeriodosReclamo (DTOBelcorp dtoE) throws RemoteException, MareException;
   DTOChequeoEnCampo obtenerChequeoEnCampo (DTOOID dto) throws RemoteException, MareException;
   void grabarChequeoManual (DTOChequeo dto) throws  RemoteException, MareException;
   void grabarClienteAChequear (DTOChequeoManual dto) throws RemoteException, MareException;
   void grabarChequeoEnCampo(DTOChequeoEnCampo  dto) throws RemoteException, MareException;
   void grabarZonasChequeo(java.util.ArrayList zonas, Long oidConfiguracionClientes) throws RemoteException, MareException;
   void modificarChequeoEnCampo(DTOChequeoEnCampo  dto) throws RemoteException, MareException;

    void grabarChequeoEnLinea(DTOChequeoEnLinea dtoE) throws MareException, 
                                                             RemoteException;

    DTOSalida obtenerChequeoManual(DTOChequeoManual dtoe) throws MareException, 
                                                                 RemoteException;

    DTOChequeoManual verificarChequeoDefinidos(DTOChequeoManual dtoe) throws MareException, 
                                                                             RemoteException;

    DTOSalida obtenerChequeoLineaCampo(DTOChequeoZona dtoe) throws MareException, 
                                                                   RemoteException;

    DTOChequeoZona verificarChequeoDefinidosLineaCampo(DTOChequeoZona dtoe) throws MareException, 
                                                                                   RemoteException;

    void grabarChequeoLineaCampo(DTOChequeo dtoe) throws MareException, 
                                                         RemoteException;

    DTOBoolean validarFaltantes(DTOBuscarEnvia dtoe) throws MareException, 
                                                            RemoteException;
}
