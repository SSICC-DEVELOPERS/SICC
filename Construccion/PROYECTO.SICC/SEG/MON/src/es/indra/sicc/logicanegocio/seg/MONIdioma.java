package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegIdiomData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONIdioma extends EJBObject {
    Hashtable guardar(SegIdiomData segIdiom, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegIdiomData segIdiomFrom, SegIdiomData segIdiomTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector segIdiomFrom) throws MareException, RemoteException;

    void update(SegIdiomData segIdiom, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
