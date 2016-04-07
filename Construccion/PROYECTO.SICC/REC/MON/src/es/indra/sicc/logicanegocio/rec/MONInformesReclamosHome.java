package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONInformesReclamosHome extends EJBHome 
{
    MONInformesReclamos create() throws RemoteException, CreateException;
}