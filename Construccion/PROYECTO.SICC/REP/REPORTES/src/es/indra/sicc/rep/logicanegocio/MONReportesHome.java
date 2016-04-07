package es.indra.sicc.rep.logicanegocio;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONReportesHome extends EJBHome 
{
  MONReportes create() throws RemoteException, CreateException;
}