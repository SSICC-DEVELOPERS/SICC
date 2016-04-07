package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegSocieData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONSociedad extends EJBObject {
    Hashtable guardar(SegSocieData segSocie, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegSocieData segSocieFrom, SegSocieData segSocieTo, 
                 HashMap userProperties, Integer pageCount, Integer pageSize, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;

    void remove(Vector SegSocieFrom) throws MareException, RemoteException;

    void update(SegSocieData segSocie, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
