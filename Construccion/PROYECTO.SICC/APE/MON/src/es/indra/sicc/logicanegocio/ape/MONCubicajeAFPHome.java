package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCubicajeAFPHome extends EJBHome  {
    MONCubicajeAFP create() throws RemoteException, CreateException;
}