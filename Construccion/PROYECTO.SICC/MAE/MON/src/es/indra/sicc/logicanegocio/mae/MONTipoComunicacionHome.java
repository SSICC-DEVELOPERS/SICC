package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoComunicacionHome extends EJBHome 
{
  MONTipoComunicacion create() throws RemoteException, CreateException;
}