package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarParamEvaluNrData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParametrosEvaluacionNr extends EJBObject {
    Vector query(CarParamEvaluNrData carParamEvaluNrFrom, 
                 CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CarParamEvaluNrData carParamEvaluNr, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardarParamEvalu(CarParamEvaluNrData carParamEvaluNr, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;
}
