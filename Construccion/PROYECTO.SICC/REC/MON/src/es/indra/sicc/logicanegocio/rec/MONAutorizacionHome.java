package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAutorizacionHome extends EJBHome 
{
  MONAutorizacion create() throws RemoteException, CreateException;
}