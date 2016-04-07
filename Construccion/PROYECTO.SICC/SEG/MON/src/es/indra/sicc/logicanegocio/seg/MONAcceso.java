package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegAccesData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONAcceso extends EJBObject {
    Hashtable guardar(SegAccesData segAcces, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector segAccesFrom) throws MareException, RemoteException;

    Vector query(SegAccesData segAccesFrom, SegAccesData SegAccesTo, 
                 HashMap userProperties, Integer pageCount, Integer pageSize, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    void update(SegAccesData segAcces, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
