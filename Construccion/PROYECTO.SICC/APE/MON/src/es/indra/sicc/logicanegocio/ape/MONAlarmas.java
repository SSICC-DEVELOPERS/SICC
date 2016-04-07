package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOComprobarAlarmas;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOColeccion;

public interface MONAlarmas extends EJBObject  {
  DTOColeccion comprobarAlarmasValoresCubicaje(DTOComprobarAlarmas dtoe) throws RemoteException, MareException;

  void comprobarAlarmasRelativasAProductos(DTOComprobarAlarmas dtoe) throws RemoteException, MareException;
}