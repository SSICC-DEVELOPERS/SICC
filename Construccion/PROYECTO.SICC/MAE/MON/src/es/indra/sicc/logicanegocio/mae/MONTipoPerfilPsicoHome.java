package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONTipoPerfilPsicoHome extends EJBHome 
{
  MONTipoPerfilPsico create() throws RemoteException, CreateException;
}