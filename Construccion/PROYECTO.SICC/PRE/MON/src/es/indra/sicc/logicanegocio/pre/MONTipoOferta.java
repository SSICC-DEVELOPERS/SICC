package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreTipoOfertData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoOferta extends EJBObject {
    Vector query(PreTipoOfertData preTipoOfertFrom, 
                 PreTipoOfertData preTipoOfertTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
