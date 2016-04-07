package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONMontoMinimoHome extends EJBHome  {
    MONMontoMinimo create() throws RemoteException, CreateException;
}