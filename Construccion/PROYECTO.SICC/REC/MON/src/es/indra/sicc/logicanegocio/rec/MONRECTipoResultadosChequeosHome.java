package es.indra.sicc.logicanegocio.rec;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONRECTipoResultadosChequeosHome extends EJBHome {
    MONRECTipoResultadosChequeos create() throws RemoteException, 
                                                 CreateException;
}
