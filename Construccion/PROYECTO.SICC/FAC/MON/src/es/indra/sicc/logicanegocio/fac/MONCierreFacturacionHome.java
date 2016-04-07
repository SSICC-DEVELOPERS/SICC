package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCierreFacturacionHome extends EJBHome  {
    MONCierreFacturacion create() throws RemoteException, CreateException;
}