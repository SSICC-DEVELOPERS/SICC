package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMonedData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMoneda extends EJBObject {
    Hashtable guardar(SegMonedData segMoned, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegMonedData segMonedFrom, SegMonedData segMonedTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector segMonedFrom) throws MareException, RemoteException;

    void update(SegMonedData segMoned, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Vector query(SegMonedData SegMonedFrom, SegMonedData SegMonedTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegMonedData segMonedFrom, SegMonedData segMonedTo, 
                 HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
