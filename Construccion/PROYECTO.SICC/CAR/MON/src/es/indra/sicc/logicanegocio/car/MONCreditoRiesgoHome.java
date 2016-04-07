package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONCreditoRiesgoHome extends EJBHome 
{
  MONCreditoRiesgo create() throws RemoteException, CreateException;
}