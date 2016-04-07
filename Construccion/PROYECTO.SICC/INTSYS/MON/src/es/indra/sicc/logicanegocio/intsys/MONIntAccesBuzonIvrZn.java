package es.indra.sicc.logicanegocio.intsys;

import es.indra.belcorp.mso.IntAccesBuzonIvrznData;
import es.indra.belcorp.mso.ZonZonaView2Data;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONIntAccesBuzonIvrZn extends EJBObject {
    Vector query(ZonZonaView2Data zonZonaView2From, 
                 ZonZonaView2Data zonZonaView2To, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom, 
                 IntAccesBuzonIvrznData intAccesBuzonIvrznTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(IntAccesBuzonIvrznData intAccesBuzonIvrzn, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(ZonZonaView2Data zonZonaView2From, 
                 ZonZonaView2Data zonZonaView2To, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
