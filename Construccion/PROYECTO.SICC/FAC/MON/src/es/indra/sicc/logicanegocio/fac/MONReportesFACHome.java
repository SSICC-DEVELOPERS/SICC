package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONReportesFACHome extends EJBHome 
{
  MONReportesFAC create() throws RemoteException, CreateException;
}