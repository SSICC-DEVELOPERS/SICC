package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONParticipantesConcursoCabeceraHome extends EJBHome {
    MONParticipantesConcursoCabecera create() throws RemoteException, 
                                                     CreateException;
}
