package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;

public interface MONRec extends EJBObject  {
	DTOSalida obtenerMotivosRechazoDesbloqueo(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerComboOperaciones(DTOBelcorp dto) throws MareException, RemoteException;
}