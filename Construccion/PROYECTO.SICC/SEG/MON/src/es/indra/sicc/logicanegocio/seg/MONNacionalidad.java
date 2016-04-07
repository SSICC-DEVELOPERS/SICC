package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegNacioData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONNacionalidad extends EJBObject {
    Hashtable guardar(SegNacioData segNacio, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegNacioData segNacioFrom, SegNacioData segNacioTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector segNacioFrom) throws MareException, RemoteException;

    void update(SegNacioData segNacio, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
