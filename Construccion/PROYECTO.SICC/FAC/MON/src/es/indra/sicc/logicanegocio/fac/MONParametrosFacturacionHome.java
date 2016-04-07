package es.indra.sicc.logicanegocio.fac;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParametrosFacturacionHome extends EJBHome {
    MONParametrosFacturacion create() throws RemoteException, CreateException;
}
