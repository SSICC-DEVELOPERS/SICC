package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCargarFicheroConsultorasHome extends EJBHome  {
	MONCargarFicheroConsultoras create() throws RemoteException, CreateException;
}