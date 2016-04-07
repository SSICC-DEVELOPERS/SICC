package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCobroDevolucionHome extends EJBHome 
{
  MONCobroDevolucion create() throws RemoteException, CreateException;
}