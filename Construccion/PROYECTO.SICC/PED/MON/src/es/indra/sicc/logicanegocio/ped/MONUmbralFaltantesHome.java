package es.indra.sicc.logicanegocio.ped;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONUmbralFaltantesHome extends EJBHome {
    MONUmbralFaltantes create() throws RemoteException, CreateException;
}
