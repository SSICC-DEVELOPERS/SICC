package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarIndicNivelJerarData;
import es.indra.belcorp.mso.CarNivelRedonData;
import es.indra.belcorp.mso.CarParamGenerCarteData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParamGeneraCartera extends EJBObject {
    Vector query(CarIndicNivelJerarData carIndicNivelJerarFrom, 
                 CarIndicNivelJerarData carIndicNivelJerarTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CarNivelRedonData carNivelRedonFrom, 
                 CarNivelRedonData carNivelRedonTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CarParamGenerCarteData carParamGenerCarteFrom, 
                 CarParamGenerCarteData carParamGenerCarteTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CarParamGenerCarteData carParamGenerCarte, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(CarParamGenerCarteData carParamGenerCarte, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
