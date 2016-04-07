package es.indra.sicc.logicanegocio.cal;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.cal.DTOMensajeCallCenter;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;

public interface MONParametrizacionCallCenter extends EJBObject {
  DTOMensajeCallCenter obtenerMensajeCallCenter(DTOBelcorp dtoe) throws RemoteException, MareException;
  void actualizarMensajeCallCenter(DTOMensajeCallCenter dtoe) throws RemoteException, MareException;
}