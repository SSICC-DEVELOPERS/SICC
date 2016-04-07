package es.indra.sicc.cmn.negocio.busqueda;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONBusquedaGenericaHome extends EJBHome 
{
  MONBusquedaGenerica create() throws RemoteException, CreateException;
}