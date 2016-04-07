package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONGuiaArgumenDetalHome extends EJBHome {
    MONGuiaArgumenDetal create() throws RemoteException, CreateException;
}
