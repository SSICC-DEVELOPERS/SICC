/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOAccionesProcesosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarAccionesProcesosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarTiposBloqueoUsuario;
import es.indra.sicc.dtos.mae.DTOClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOTipoBloqueo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.mae.DTOUsuariosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarUsuariosBloqueo;

import es.indra.sicc.util.DTOString;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONBloqueosClientes extends EJBObject {

    DTOSalida obtenerValoresAccionesBloqueo() throws RemoteException, MareException;

    DTOSalida obtenerMotivosRechazo() throws MareException, RemoteException;

    void guardarTipoBloqueo(DTOTipoBloqueo dtoe) throws MareException, RemoteException;

    DTOSalida consultarTiposBloqueo(DTOTipoBloqueo dtoe) throws MareException, RemoteException;

    void eliminarTiposBloqueo(DTOOIDs dtoe) throws MareException, RemoteException;

    DTOSalida obtenerTiposBloqueo(DTOBelcorp dtoe) throws MareException, RemoteException;

    DTOSalida obtenerBloqueosFinancieros(DTOBelcorp dtoe) throws RemoteException, MareException;

    void guardarAccionesProcesosBloqueo(DTOAccionesProcesosBloqueo dtoE) throws MareException, RemoteException;

    DTOSalida buscarAccionesProcesosBloqueo(DTOBuscarAccionesProcesosBloqueo dtoE) throws MareException, RemoteException;

    void eliminarAccionesProcesosBloqueo(DTOOIDs dtoE) throws MareException, RemoteException;

    DTOSalida obtenerProcesosBloqueo(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerAccionesBloqueo(DTOOID dtoE) throws MareException, RemoteException;
    
    DTOSalida buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe) throws MareException, RemoteException;

    DTOSalida obtenerTiposDocumentoPais(DTOBelcorp dtoe) throws MareException, RemoteException;

    DTOSalida obtenerValoresUsuarioBloqueo(DTOBelcorp dtoE) throws MareException, RemoteException;
    
    void guardarUsuariosBloqueo(DTOUsuariosBloqueo dtoE) throws MareException, RemoteException;
    
    void eliminarUsuariosBloqueo(DTOOIDs dtoE) throws MareException, RemoteException;
    
    DTOSalida buscarUsuariosBloqueo(DTOBuscarUsuariosBloqueo dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposBloqueoUsuario(DTOString dtoe) throws MareException, RemoteException;

    void guardarBloqueo(DTOClienteBloqueo dtoe) throws MareException, RemoteException;

    DTOSalida consultarHistoricoBloqueosCliente(DTOOID dtoe) throws MareException, RemoteException;
  
    DTOSalida obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe) throws MareException, RemoteException;

}