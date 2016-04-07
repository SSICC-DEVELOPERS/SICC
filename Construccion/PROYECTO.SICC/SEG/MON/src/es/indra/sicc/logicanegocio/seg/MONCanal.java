package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegCanalData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCanal extends EJBObject {
    Hashtable guardar(SegCanalData segCanal, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector segCanalFrom) throws MareException, RemoteException;

    void update(SegCanalData segCanal, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Vector query(SegCanalData segCanalFrom, SegCanalData segCanalTo, 
                 HashMap userProperties, Integer pageCount, Integer pageSize, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(SegCanalViewData segCanalViewFrom, 
                 SegCanalViewData segCanalViewTo, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
