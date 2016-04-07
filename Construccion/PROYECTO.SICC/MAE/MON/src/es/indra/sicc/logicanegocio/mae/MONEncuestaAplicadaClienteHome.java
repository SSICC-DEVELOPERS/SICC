package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONEncuestaAplicadaClienteHome extends EJBHome 
{
    MONEncuestaAplicadaCliente create() throws RemoteException, CreateException;
}