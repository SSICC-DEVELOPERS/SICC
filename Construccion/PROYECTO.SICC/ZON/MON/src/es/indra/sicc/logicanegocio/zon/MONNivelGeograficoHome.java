package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONNivelGeograficoHome extends EJBHome 
{
    MONNivelGeografico create() throws RemoteException, CreateException;
}