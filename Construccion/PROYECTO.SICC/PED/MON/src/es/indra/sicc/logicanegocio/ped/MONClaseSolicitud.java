package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedClaseSolicData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONClaseSolicitud extends EJBObject {
    Hashtable guardarClaseSolicitud(PedClaseSolicData pedClaseSolic, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(PedClaseSolicData pedClaseSolicFrom, 
                 PedClaseSolicData pedClaseSolicTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedClaseSolicData pedClaseSolic, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
