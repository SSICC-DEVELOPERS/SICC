package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOTiposCajaEmbalaje;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;

public interface MONMantenimientoTiposCajaEmbalaje extends EJBObject  {
  Long actualizarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE) throws RemoteException, MareException;

  void actualizarTiposCajaEmbalajeLineas(DTOTiposCajaEmbalaje dtoE) throws RemoteException, MareException;

  DTOSalida buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE) throws RemoteException, MareException;

  void eliminarTiposCajaEmbalaje(DTOOIDs dtoE) throws RemoteException, MareException;

  DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje(DTOOID dtoE) throws RemoteException, MareException;
}