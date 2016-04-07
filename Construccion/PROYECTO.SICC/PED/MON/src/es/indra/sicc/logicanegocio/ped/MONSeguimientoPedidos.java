package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import java.util.Date;
import es.indra.sicc.dtos.ped.DTOBuscarSeguimientoPedidos;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

public interface MONSeguimientoPedidos extends EJBObject  {
  void actualizarSeguimientoPedidos(DTOSeguimientoPedidos dto) throws RemoteException, MareException;

  void guardarSeguimientoPedidos(Long solicitud, Long consolidado, Long hitoSeguimiento, Long tipoDocumento, String numeroDocumento, Date fecha, Boolean indCompleto) throws RemoteException, MareException;

  void actualizarConsolidado(Long consolidado) throws RemoteException, MareException;

  DTOSalida buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos dto) throws RemoteException, MareException;

  DTOSalida obtenerTiposDocumentoSeguimiento(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerHitosSeguimiento(DTOBelcorp dto) throws RemoteException, MareException;

	void eliminarHitosPosteriores(DTOSeguimientoPedidos DTOE) throws RemoteException, MareException;

}