package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONLiquidacionCobranzaHome extends EJBHome 
{
  MONLiquidacionCobranza create() throws RemoteException, CreateException;
}