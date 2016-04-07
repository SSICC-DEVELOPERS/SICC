package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCobranzaExternaHome extends EJBHome 
{
  MONCobranzaExterna create() throws RemoteException, CreateException;
}