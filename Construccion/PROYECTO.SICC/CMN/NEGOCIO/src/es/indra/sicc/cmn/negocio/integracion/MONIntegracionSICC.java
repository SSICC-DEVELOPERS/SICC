package es.indra.sicc.cmn.negocio.integracion;

import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONIntegracionSICC extends EJBObject {
    DTOSalidaSICC ejecutarProceso(DTOEntradaSICC dto) throws MareException, 
                                                             RemoteException;
}
