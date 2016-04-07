package es.indra.sicc.cmn.negocio.correo;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronico;

public interface MONServicioCorreoElectronicoHome extends EJBHome  {
	MONServicioCorreoElectronico create() throws RemoteException, CreateException;
}