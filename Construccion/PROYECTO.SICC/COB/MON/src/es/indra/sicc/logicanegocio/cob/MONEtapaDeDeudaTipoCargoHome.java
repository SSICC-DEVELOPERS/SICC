package es.indra.sicc.logicanegocio.cob;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONEtapaDeDeudaTipoCargoHome extends EJBHome {
    MONEtapaDeDeudaTipoCargo create() throws RemoteException, CreateException;
}
