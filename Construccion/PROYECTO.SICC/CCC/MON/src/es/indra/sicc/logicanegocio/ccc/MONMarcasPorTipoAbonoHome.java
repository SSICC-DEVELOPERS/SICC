package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONMarcasPorTipoAbonoHome extends EJBHome  {
  MONMarcasPorTipoAbono create() throws RemoteException, CreateException;
}