package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONGrupoProcesoHome extends EJBHome  {
  MONGrupoProceso create() throws RemoteException, CreateException;  
}