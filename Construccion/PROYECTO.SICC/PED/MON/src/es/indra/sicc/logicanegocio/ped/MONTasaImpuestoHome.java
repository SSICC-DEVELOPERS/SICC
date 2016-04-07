package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONTasaImpuestoHome extends EJBHome {
    MONTasaImpuesto create() throws RemoteException, CreateException;
}
