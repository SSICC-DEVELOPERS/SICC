package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCodigosAnterioresHome extends EJBHome 
{
  MONCodigosAnteriores create() throws RemoteException, CreateException;
}