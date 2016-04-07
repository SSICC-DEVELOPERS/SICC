package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONSoporteCobranzaHome extends EJBHome 
{
  MONSoporteCobranza create() throws RemoteException, CreateException;
}