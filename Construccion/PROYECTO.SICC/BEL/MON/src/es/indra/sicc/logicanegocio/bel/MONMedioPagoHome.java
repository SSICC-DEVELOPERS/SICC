package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMedioPagoHome extends EJBHome 
{
  MONMedioPago create() throws RemoteException, CreateException;
}