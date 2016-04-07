package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarCondiEvaluNrData;
import es.indra.belcorp.mso.CarParamEvaluNrData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCondicionEvaluacionNr extends EJBObject {

    Vector query(CarCondiEvaluNrData carCondiEvaluNrFrom, 
                 CarCondiEvaluNrData carCondiEvaluNrTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CarCondiEvaluNrData carCondiEvaluNr, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarHasMap(CarCondiEvaluNrData carCondiEvaluNr, 
                            Vector localizationLabels, 
                            HashMap userProperties) throws MareException, 
                                                           RemoteException;

    Vector query(CarParamEvaluNrData carParamEvaluNrFrom, 
                 CarParamEvaluNrData carParamEvaluNrTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
