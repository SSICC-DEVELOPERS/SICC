package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarJerarData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONJerarquias extends EJBObject {
    Vector query(CarJerarData carJerarFrom, CarJerarData carJerarTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CarJerarData carJerar, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarJerarquias(CarJerarData carJerar, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;
}
