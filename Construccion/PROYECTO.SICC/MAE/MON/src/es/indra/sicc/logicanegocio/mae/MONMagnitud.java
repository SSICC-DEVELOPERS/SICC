package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeMagniData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMagnitud extends EJBObject {
    Hashtable guardarMagnitud(MaeMagniData maeMagni, Vector localizationLabels, 
                              HashMap userProperties) throws MareException, 
                                                             RemoteException;

    Vector query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(MaeMagniData maeMagni, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeMagni) throws MareException, RemoteException;
}
