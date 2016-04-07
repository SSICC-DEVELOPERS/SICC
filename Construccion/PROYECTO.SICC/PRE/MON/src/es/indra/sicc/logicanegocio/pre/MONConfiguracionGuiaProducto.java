package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreConfiGpData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONConfiguracionGuiaProducto extends EJBObject {
    Hashtable guardar(PreConfiGpData preConfiGp, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector preConfiGpFrom) throws MareException, RemoteException;

    Vector query(PreConfiGpData preConfiGpFrom, PreConfiGpData preConfiGpTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(PreConfiGpData preConfiGp, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
