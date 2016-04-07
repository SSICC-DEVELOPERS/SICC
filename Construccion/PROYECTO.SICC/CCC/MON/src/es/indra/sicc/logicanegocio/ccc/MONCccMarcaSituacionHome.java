package es.indra.sicc.logicanegocio.ccc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONCccMarcaSituacionHome extends EJBHome {
    MONCccMarcaSituacion create() throws RemoteException, CreateException;
}
