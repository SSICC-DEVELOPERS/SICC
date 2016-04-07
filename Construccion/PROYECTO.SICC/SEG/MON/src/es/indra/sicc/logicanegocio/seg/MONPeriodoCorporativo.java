package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegPerioCorpoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONPeriodoCorporativo extends EJBObject {
    Hashtable guardar(SegPerioCorpoData segPerioCorpo, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegPerioCorpoData segPerioCorpoFrom, 
                 SegPerioCorpoData segPerioCorpoTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector segPerioCorpoFrom) throws MareException, 
                                                 RemoteException;

    void update(SegPerioCorpoData segPerioCorpo, 
                  Vector localizationLabels) throws MareException, 
                                                    RemoteException;
}
