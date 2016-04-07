package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarNivelRiesgData;
import es.indra.belcorp.mso.CarParamCalcuLcData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParametrosCalculoLc extends EJBObject {
    Vector query(CarNivelRiesgData carNivelRiesgFrom, 
                 CarNivelRiesgData carNivelRiesgTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    void update1(CarParamCalcuLcData carParamCalcuLc, 
                 Vector localizationLabels) throws MareException, 
                                                   RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarParam(CarParamCalcuLcData carParamCalcuLc, 
                           Vector localizationLabels, 
                           HashMap userProperties) throws MareException, 
                                                          RemoteException;

    Vector query(CarParamCalcuLcData carParamCalcuLcFrom, 
                 CarParamCalcuLcData carParamCalcuLcTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
