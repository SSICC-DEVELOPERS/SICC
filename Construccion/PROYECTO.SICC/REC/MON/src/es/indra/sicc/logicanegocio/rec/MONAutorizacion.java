package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.rec.DTOAutorizacion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;

public interface MONAutorizacion extends EJBObject 
{
  void actualizarAutorizacion(DTOAutorizacion DTOE) throws MareException, RemoteException;

  DTOSalida buscarAutorizaciones(DTOAutorizacion DTOE) throws MareException, RemoteException;

  DTOAutorizacion obtenerAutorizacion(DTOOID DTOE) throws MareException, RemoteException;

  void eliminarAutorizacion(DTOOIDs dtoe) throws MareException, RemoteException;
}