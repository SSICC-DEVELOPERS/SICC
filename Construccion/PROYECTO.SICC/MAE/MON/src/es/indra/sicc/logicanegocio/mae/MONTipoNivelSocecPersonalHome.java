package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoNivelSocecPersonalHome extends EJBHome 
{
  MONTipoNivelSocecPersonal create() throws RemoteException, CreateException;
}