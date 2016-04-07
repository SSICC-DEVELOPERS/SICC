package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.bel.DTOAlmacen;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

public interface MONAlmacen extends EJBObject  {
  void guardarAlmacen(DTOAlmacen dtoe) throws RemoteException, MareException;

  DTOSalida buscarAlmacen(DTOAlmacen dtoe) throws RemoteException, MareException;

  DTOAlmacen obtenerAlmacen(DTOOID dtoe) throws RemoteException, MareException;

  void eliminarAlmacen(DTOOIDs dtoe) throws RemoteException, MareException;
}
