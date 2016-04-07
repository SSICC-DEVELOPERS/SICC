package es.indra.sicc.logicanegocio.ped.applet;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRegistroOnlineHome extends EJBHome  {
  MONRegistroOnline create() throws RemoteException, CreateException;
}