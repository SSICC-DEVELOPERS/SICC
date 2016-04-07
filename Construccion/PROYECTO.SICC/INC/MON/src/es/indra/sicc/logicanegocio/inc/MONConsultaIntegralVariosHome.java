package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConsultaIntegralVariosHome extends EJBHome {
    MONConsultaIntegralVarios create() throws RemoteException, CreateException;
}