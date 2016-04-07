package es.indra.sicc.logicanegocio.pre;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONIndicadorCuadreTipoEstrategiaHome extends EJBHome {
    MONIndicadorCuadreTipoEstrategia create() throws RemoteException, 
                                                     CreateException;
}
