package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCatalData;
import es.indra.belcorp.mso.PreCatalOrdenData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCatalogoOrden extends EJBObject {

    Hashtable guardar(PreCatalOrdenData preCatalOrden, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(PreCatalOrdenData preCatalOrdenFrom, 
                 PreCatalOrdenData preCatalOrdenTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector preCatalOrdenFrom) throws MareException, 
                                                 RemoteException;

    void update(PreCatalOrdenData preCatalOrden, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
