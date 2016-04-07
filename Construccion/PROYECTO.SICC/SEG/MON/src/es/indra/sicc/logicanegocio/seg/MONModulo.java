package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegModulData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONModulo extends EJBObject {
    Hashtable guardar(SegModulData segModul, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegModulData segModulFrom, SegModulData segModulTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector segModulFrom) throws MareException, RemoteException;

    void update(SegModulData segModul, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
