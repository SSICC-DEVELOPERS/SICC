package es.indra.sicc.cmn.negocio.validacion;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONValidacionHome extends EJBHome 
{
  MONValidacion create() throws RemoteException, CreateException;
}