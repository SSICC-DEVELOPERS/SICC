package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONUnidadesGeograficasHome extends EJBHome  {
    MONUnidadesGeograficas create() throws RemoteException, CreateException;
}