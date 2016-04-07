package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTOParametrosContables;

public interface MONMantenimientoParametrosContables extends EJBObject  {
  DTOSalida obtenerProcesosPais(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerCuentasContablesPais(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerSubProcesosPorProceso(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerObtencionCuenta(DTOBelcorp dto) throws MareException, RemoteException;

  void actualizarParametrosContables(DTOParametrosContables dtoPC) throws MareException, RemoteException;

  DTOSalida buscarParametrosContables(DTOParametrosContables dtoPC) throws MareException, RemoteException;

  DTOParametrosContables obtenerParametroContable(DTOOID dto) throws MareException, RemoteException;

  void eliminarParametrosContables(DTOOIDs dtoOIDs) throws MareException, RemoteException;
}