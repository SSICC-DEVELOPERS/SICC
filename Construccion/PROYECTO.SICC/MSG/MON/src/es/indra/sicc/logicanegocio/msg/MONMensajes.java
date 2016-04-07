package es.indra.sicc.logicanegocio.msg;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOCombosMSG;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.msg.DTOMensaje;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.msg.DTODestinatario;
import java.util.Vector;
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.msg.DTOMensajeMarca;
import es.indra.sicc.dtos.msg.DTOMensajeCodigoVenta;
import es.indra.sicc.dtos.msg.DTOMensajeCliente;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface MONMensajes extends EJBObject  {  
  DTOSalida obtenerTiposMensaje(DTOBelcorp DTOE) throws RemoteException, MareException;

  DTOSalida obtenerTiposGeneracionDatos(DTOBelcorp DTOE) throws RemoteException, MareException;

  DTOSalida obtenerTiposPermanencia(DTOBelcorp DTOE) throws RemoteException, MareException;

  DTOSalida obtenerTiposDestinatario(DTOBelcorp DTOE) throws RemoteException, MareException;

  DTOBoolean comprobarDestinatariosExcluyentes(DTOOIDs DTOE) throws RemoteException, MareException;

  DTOOID guardarMensaje(DTOMensaje DTOE) throws RemoteException, MareException;

  void guardarDestinatarioMensaje(DTODestinatario DTOE) throws RemoteException, MareException;

  DTOSalida buscarMensajes(DTOMensaje DTOE) throws RemoteException, MareException;

  DTOMensaje obtenerMensaje(DTOOID DTOE) throws RemoteException, MareException;
 
  DTOBoolean comprobarMensajeCodigoVenta(DTODestinatario DTOE) throws RemoteException, MareException;

  void guardarTipoDestinatario(Long tipo, Long mensaje) throws RemoteException, MareException;

  Vector obtenerTiposDestinatarioMensaje(Long oidMensaje) throws RemoteException, MareException;

  DTOOID modificarMensaje(DTOMensaje DTOE) throws RemoteException, MareException;

  DTODestinatario obtenerDatosDestinatario(DTOOID DTOE) throws RemoteException, MareException;

  DTODestinatario generarMensajeUnidadAdministrativa(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTOMensajeTipoCliente crearDTOMensajeTipoCliente(Vector fila) throws RemoteException, MareException;

  DTODestinatario generarMensajeMarca(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTOMensajeMarca crearDTOMensajeMarca(Long oid, Long marca) throws RemoteException, MareException;

  DTODestinatario generarMensajeCodigoVenta(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTOMensajeCodigoVenta crearDTOMensajeCodigoVenta(Long oid, String codigo) throws RemoteException, MareException;

  DTODestinatario generarMensajePedido(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTODestinatario generarMensajePrograma(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTODestinatario generarMensajeCliente(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTOMensajeCliente crearDTOMensajeCliente(Long oid, Long cliente) throws RemoteException, MareException;

  void modificarDestinatarioMensaje(DTODestinatario DTOE) throws RemoteException, MareException;

  void eliminarDestinatarioMensaje(Long oidMensaje) throws RemoteException, MareException;

  void eliminarMensaje(DTOOIDs DTOE) throws RemoteException, MareException;

  DTOMensajeUnidadAdministrativa crearDTOMensajeUnidadAdministrativa(Vector fila) throws RemoteException, MareException;

  DTODestinatario generarMensajeTipoCliente(Long oidMensaje, DTODestinatario DTOE) throws RemoteException, MareException;

  DTOSalida obtenerMensajesPorPais(DTOSiccPaginacion DTOE) throws RemoteException, MareException;

  DTOSalida obtenerMetacaracteres(DTOBelcorp DTOE) throws RemoteException, MareException;

  void guardarDestinatarioExcluyente(DTODestinatario dto) throws RemoteException, MareException;

  void modificarDestinatarioExcluyente(DTODestinatario dto) throws RemoteException, MareException;

  RecordSet obtenerCodigosMensajesPorPais(DTOBelcorp dtoe) throws RemoteException, MareException;



  
}