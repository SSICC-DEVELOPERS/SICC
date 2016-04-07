package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONINTGEOHome extends EJBHome {
  MONINTGEO create() throws RemoteException, CreateException;
}

