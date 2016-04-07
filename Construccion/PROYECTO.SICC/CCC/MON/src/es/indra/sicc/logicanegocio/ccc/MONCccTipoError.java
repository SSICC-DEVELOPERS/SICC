package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoErrorData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCccTipoError extends EJBObject {
    Vector query(CccTipoErrorData cccTipoErrorFrom, 
                 CccTipoErrorData cccTipoErrorTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
