package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAccionesCobranzaHome extends EJBHome 
{
  MONAccionesCobranza create() throws RemoteException, CreateException;
}