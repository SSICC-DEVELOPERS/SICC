package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCatalData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCatalogo extends EJBObject {
    Vector query(PreCatalData preCatalFrom, PreCatalData preCatalTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Vector query(PreCatalData preCatalFrom, PreCatalData preCatalTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
