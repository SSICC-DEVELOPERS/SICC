package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConsultaIntegralParticularHome extends EJBHome {
    MONConsultaIntegralParticular create() throws RemoteException, CreateException;
}