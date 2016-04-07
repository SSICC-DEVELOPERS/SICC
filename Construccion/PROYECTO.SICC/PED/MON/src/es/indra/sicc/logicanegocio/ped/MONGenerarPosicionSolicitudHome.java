package es.indra.sicc.logicanegocio.ped;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONGenerarPosicionSolicitudHome extends EJBHome  {
	MONGenerarPosicionSolicitud create() throws RemoteException, CreateException;
}