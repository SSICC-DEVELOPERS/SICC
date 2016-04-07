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

package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOBuscarConsultoras;
import es.indra.sicc.dtos.msg.DTOBuscarConsultorasInicial;
import es.indra.sicc.dtos.msg.DTODatosConsultora;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONConsultoras extends EJBObject {
    DTOSalida cargarListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE) throws RemoteException, MareException;

    DTOSalida buscarListaConsultoras(DTOBuscarConsultoras DTOE) throws RemoteException, MareException;

    DTOSalida consultarConsultoras(DTOBuscarConsultoras DTOE) throws RemoteException, MareException;

    void insertarDatosConsultora(DTODatosConsultora DTOE) throws RemoteException, MareException;

    DTODatosConsultora obtenerDatosConsultora(DTOOID DTOE) throws RemoteException, MareException;

    void modificarDatosConsultora(DTODatosConsultora DTOE) throws RemoteException, MareException;

    void eliminarDatosConsultora(DTOOIDs DTOE) throws RemoteException, MareException;
}
