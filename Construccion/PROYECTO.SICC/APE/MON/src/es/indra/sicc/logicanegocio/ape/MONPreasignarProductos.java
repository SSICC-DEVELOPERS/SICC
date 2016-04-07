package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOPreasignarProducto;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;

public interface MONPreasignarProductos extends EJBObject  {
  DTOSalida obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe) throws RemoteException, MareException;

  DTOBoolean preasignarProductosValidacion(DTOPreasignarProducto dtoe) throws RemoteException, MareException;

  void preasignarProductos(DTOPreasignarProducto dtoe) throws RemoteException, MareException;

  void preasignarProductosElimina(DTOPreasignarProducto dtoe) throws RemoteException, MareException;

  void eliminarAsignacionProdDetalles(Long oid, String codProcedenciaNoElimina) throws RemoteException, MareException;

  DTOSalida obtenerPeriodoSiguiente(DTOOID oidPeriodo) throws RemoteException, MareException;
}