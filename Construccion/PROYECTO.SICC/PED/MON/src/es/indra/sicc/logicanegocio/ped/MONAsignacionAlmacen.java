package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.BelAlmacData;
import es.indra.belcorp.mso.PedAsignAlmacData;
import es.indra.belcorp.mso.SegAccesData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegSubacData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONAsignacionAlmacen extends EJBObject {
    Vector query(SegCanalViewData segCanalViewFrom, 
                 SegCanalViewData segCanalViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegAccesData segAccesFrom, SegAccesData segAccesTo, 
                 HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(SegAccesData segAccesFrom, SegAccesData segAccesTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegSubacData segSubacFrom, SegSubacData segSubacTo, 
                 HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    Vector query(SegSubacData segSubacFrom, SegSubacData segSubacTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(BelAlmacData belAlmacFrom, BelAlmacData belAlmacTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarAsignacionAlmacen(PedAsignAlmacData pedAsignAlmac, 
                                       Vector localizationLabels, 
                                       HashMap userProperties) throws MareException, 
                                                                      RemoteException;

    Vector query(PedAsignAlmacData pedAsignAlmacFrom, 
                 PedAsignAlmacData pedAsignAlmacTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
