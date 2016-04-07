package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCalcularVolumenFacturasHome extends EJBHome 
{
  MONCalcularVolumenFacturas create() throws RemoteException, CreateException;
}