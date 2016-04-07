package es.indra.sicc.logicanegocio.app;

import es.indra.belcorp.mso.AppRutasTransData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONAppRutasTransporte extends EJBObject {
    Hashtable guardarRutasTransporte(AppRutasTransData appRutasTrans, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(AppRutasTransData appRutasTransFrom, 
                 AppRutasTransData appRutasTransTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(AppRutasTransData appRutasTrans, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector appRutasTrans) throws MareException, RemoteException;
}
