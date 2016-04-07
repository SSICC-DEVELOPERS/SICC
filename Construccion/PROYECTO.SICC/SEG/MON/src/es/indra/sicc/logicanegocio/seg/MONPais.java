package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.BelFormaPagoTaponData;
import es.indra.belcorp.mso.SegPaisData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONPais extends EJBObject {
    Vector query(BelFormaPagoTaponData belFormaPagoTaponFrom, 
                 BelFormaPagoTaponData belFormaPagoTaponTo, 
                 HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Hashtable guardar(SegPaisData segPais, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector segPaisFrom) throws MareException, RemoteException;

    void update(SegPaisData segPais, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Vector query(SegPaisData segPaisFrom, SegPaisData segPaisTo, 
                 HashMap userProperties, Integer pageCount, Integer pageSize, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(SegPaisViewData segPaisViewFrom, 
                 SegPaisViewData segPaisViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegPaisViewData segPaisViewFrom, 
                 SegPaisViewData segPaisViewTo, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
