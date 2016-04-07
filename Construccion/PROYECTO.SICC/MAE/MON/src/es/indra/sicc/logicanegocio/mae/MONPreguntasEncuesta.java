package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEncueNseViewData;
import es.indra.belcorp.mso.MaePreguEncueData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONPreguntasEncuesta extends EJBObject {
    Vector query(MaeEncueNseViewData maeEncueNseViewFrom, 
                 MaeEncueNseViewData maeEncueNseViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarPreguntasEncuesta(MaePreguEncueData maePreguEncue, 
                                       Vector localizationLabels, 
                                       HashMap userProperties) throws MareException, 
                                                                      RemoteException;

    Vector query(MaePreguEncueData maePreguEncueFrom, 
                 MaePreguEncueData maePreguEncueTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaePreguEncueData maePreguEncue, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeEncueNse) throws MareException, RemoteException;
}
