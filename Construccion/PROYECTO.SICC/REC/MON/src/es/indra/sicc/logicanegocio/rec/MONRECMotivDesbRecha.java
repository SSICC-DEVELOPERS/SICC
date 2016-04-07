package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivRechaDesblData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRECMotivDesbRecha extends EJBObject {
    Hashtable guardarMotivDesblRecha(RecMotivRechaDesblData recMotivRechaDesbl, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(RecMotivRechaDesblData recMotivRechaDesblFrom, 
                 RecMotivRechaDesblData recMotivRechaDesblTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(RecMotivRechaDesblData recMotivRechaDesbl, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
