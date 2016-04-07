package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeNivelEstudData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONNivelEstudio extends EJBObject {
    Hashtable guardarNivelEstudio(MaeNivelEstudData maeNivelEstud, 
                                  Vector localizationLabels, 
                                  HashMap userProperties) throws MareException, 
                                                                 RemoteException;

    Vector query(MaeNivelEstudData maeNivelEstudFrom, 
                 MaeNivelEstudData maeNivelEstudTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeNivelEstudData maeNivelEstud, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeNivelEstud) throws MareException, RemoteException;
}
