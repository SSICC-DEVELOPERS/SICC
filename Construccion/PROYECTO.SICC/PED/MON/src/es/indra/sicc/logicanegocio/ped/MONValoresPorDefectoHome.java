package es.indra.sicc.logicanegocio.ped;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONValoresPorDefectoHome extends EJBHome  {
  MONValoresPorDefecto create() throws RemoteException, CreateException;
}