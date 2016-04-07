package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMarca extends EJBObject {
    Hashtable guardar(SegMarcaData segMarca, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector segMarcaFrom) throws MareException, RemoteException;

    void update(SegMarcaData segMarca, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Vector query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, 
                 HashMap userProperties, Integer pageCount, Integer pageSize, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
