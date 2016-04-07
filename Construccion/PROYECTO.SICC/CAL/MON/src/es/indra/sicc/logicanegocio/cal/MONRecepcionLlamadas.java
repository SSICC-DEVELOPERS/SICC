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

package es.indra.sicc.logicanegocio.cal;
import es.indra.sicc.dtos.cal.DTOCabeceraPedido;
import es.indra.sicc.dtos.cal.DTODetallePedido;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cal.DTOContacto;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTOInterfazIVR;
import es.indra.sicc.dtos.cal.DTOFichaCliente;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.cal.DTOBloqueoAdm;

public interface MONRecepcionLlamadas extends EJBObject 
{
  DTOOID guardarContacto(DTOCliente dtoE) throws RemoteException, MareException;

    void realizarBloqueoAdministrativo(DTOOID DTOE) throws RemoteException, MareException;

    void actualizarContacto(DTOContacto dto) throws RemoteException, MareException;

    DTOSalida obtenerEstadoContacto(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtenerAtributoEstado(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerContactos(DTOCliente DTOE) throws RemoteException, MareException;

    DTOSalida obtenerCuentasCorrientes(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    DTOSalida obtenerVinculos(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    DTOSalida obtenerDocumentos(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    DTOSalida obtenerDirecciones(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    DTOSalida obtenerCabeceraPedidos(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    DTOSalida obtenerDetalleCabecera(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    DTOCabeceraPedido obtenerDatosAdicionalesCabecera(DTOOID DTOE) throws RemoteException, MareException;

    DTODetallePedido obtenerDatosAdicionalesDetalle(DTOOID DTOE) throws RemoteException, MareException;

    DTOInterfazIVR obtenerClientePorTelefono(DTOInterfazIVR DTOE) throws RemoteException, MareException;

    DTOSalida obtenerClientes(DTOCliente DTOE) throws RemoteException, MareException;

    DTOSalida obtenerTiposCliente(DTOCodigoCliente DTOE) throws RemoteException, MareException;

    DTOFichaCliente obtenerDatosFichaCliente(DTOCliente DTOE) throws RemoteException, MareException;

   DTOSalida obtenerTipoLlamada(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerCabeceraPedidoNoFacturado(DTOOIDPaginado DTOE) throws RemoteException, MareException;

    void guardarBloqueoAdm(DTOBloqueoAdm dtoGuardado) throws MareException, RemoteException;

    DTOSalida obtenerTiposBloqueo(DTOOID dtoEnt) throws MareException, RemoteException;


    DTOCliente obtenerIndicadorActivo(DTOCliente dtoe) throws MareException, 
                                                              RemoteException;
}
