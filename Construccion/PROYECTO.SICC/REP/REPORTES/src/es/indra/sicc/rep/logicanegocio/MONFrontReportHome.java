package es.indra.sicc.rep.logicanegocio;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONFrontReportHome extends EJBHome 
{
  MONFrontReport create() throws RemoteException, CreateException;
}