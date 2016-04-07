package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConfiguracionCamposHome extends EJBHome 
{
    MONConfiguracionCampos create() throws RemoteException, CreateException;
}