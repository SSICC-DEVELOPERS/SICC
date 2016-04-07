package es.indra.sicc.logicanegocio.seg;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONDepartamentoEmpresaHome extends EJBHome {
    MONDepartamentoEmpresa create() throws RemoteException, CreateException;
}
