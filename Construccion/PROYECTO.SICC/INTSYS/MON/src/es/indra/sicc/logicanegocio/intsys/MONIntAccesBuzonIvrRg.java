package es.indra.sicc.logicanegocio.intsys;

import es.indra.belcorp.mso.IntAccesBuzonIvrrgData;
import es.indra.belcorp.mso.ZonRegioView2Data;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONIntAccesBuzonIvrRg extends EJBObject {
    Vector query(ZonRegioView2Data zonRegioView2From, 
                 ZonRegioView2Data zonRegioView2To, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom, 
                 IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Vector query(ZonRegioView2Data zonRegioView2From, 
                 ZonRegioView2Data zonRegioView2To, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    void update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
