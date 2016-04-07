package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.cob.DTOBuscarClientesAsignados;
import es.indra.sicc.dtos.cob.DTOIdLote;
public interface MONSoporteCobranza extends EJBObject 
{
  DTOSalida cargarEtapasPais(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida cargarMensajesLote(DTOOID dtoe) throws MareException, RemoteException;

  void grabarMensajesLote(DTOColeccion dtoe) throws MareException, RemoteException;

  DTOSalida buscarClientesAsignados(DTOBuscarClientesAsignados dtoe) throws RemoteException, MareException;

  DTOOID generarMensajes(DTOColeccion dto) throws RemoteException, MareException;

  DTOSalida listadoMensajesEmitidos(DTOIdLote dto) throws RemoteException, MareException;

  DTOSalida cargarIdLotes(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalida cargarEtapasPaisMensaje(DTOBelcorp dto) throws RemoteException, MareException;
}