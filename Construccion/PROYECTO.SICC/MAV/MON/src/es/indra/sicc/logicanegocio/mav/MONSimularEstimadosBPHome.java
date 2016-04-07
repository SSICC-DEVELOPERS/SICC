package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONSimularEstimadosBPHome extends EJBHome {
    MONSimularEstimadosBP create() throws RemoteException, CreateException;
}