package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONImpuestosUBIGEOHome extends EJBHome  {
    MONImpuestosUBIGEO create() throws RemoteException, CreateException;
}