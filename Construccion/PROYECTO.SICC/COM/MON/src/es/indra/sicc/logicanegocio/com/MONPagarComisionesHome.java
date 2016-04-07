package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONPagarComisionesHome extends EJBHome  {
    MONPagarComisiones create() throws RemoteException, CreateException;
}