package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarParamNrData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParametrosNr extends EJBObject {
    Vector query(CarParamNrData carParamNrFrom, CarParamNrData carParamNrTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CarParamNrData carParamNr, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardarParamNr(CarParamNrData carParamNr, 
                             Vector localizationLabels, 
                             HashMap userProperties) throws MareException, 
                                                            RemoteException;
}
