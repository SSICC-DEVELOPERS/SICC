package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConfiguracionTextosVariablesHome extends EJBHome {
    MONConfiguracionTextosVariables create() throws RemoteException, CreateException;
}