package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAsignacionesCobranzaHome extends EJBHome 
{
  MONAsignacionesCobranza create() throws RemoteException, CreateException;
}