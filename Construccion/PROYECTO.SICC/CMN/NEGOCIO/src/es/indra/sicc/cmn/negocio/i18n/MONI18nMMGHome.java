package es.indra.sicc.cmn.negocio.i18n;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONI18nMMGHome extends EJBHome {
    MONI18nMMG create() throws RemoteException, CreateException;
}
