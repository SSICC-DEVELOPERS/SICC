package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONPEDValidacionHome extends EJBHome {
    MONPEDValidacion create() throws RemoteException, CreateException;
}
