package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONCargaListaClientesHome extends EJBHome {
    MONCargaListaClientes create() throws RemoteException, CreateException;
}