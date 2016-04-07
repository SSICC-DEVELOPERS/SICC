package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONNivelRiesgo extends EJBObject {
    Vector query(CarNivelRiesgData carNivelRiesgFrom, 
                 CarNivelRiesgData carNivelRiesgTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CarNivelRiesgData carNivelRiesg, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardarNivelRiesgo(CarNivelRiesgData carNivelRiesg, 
                                 Vector localizationLabels, 
                                 HashMap userProperties) throws MareException, 
                                                                RemoteException;
}
