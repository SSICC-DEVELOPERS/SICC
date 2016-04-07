package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONConsultaIntegralGeneralHome extends EJBHome {
    MONConsultaIntegralGeneral create() throws RemoteException, CreateException;
}