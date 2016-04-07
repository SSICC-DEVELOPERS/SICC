package es.indra.sicc.logicanegocio.seg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConfiguracionAyudaHome extends EJBHome 
{
  MONConfiguracionAyuda create() throws RemoteException, CreateException;
}