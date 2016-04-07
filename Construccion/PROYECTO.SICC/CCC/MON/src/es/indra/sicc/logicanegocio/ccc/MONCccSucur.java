package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccSucurData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCccSucur extends EJBObject {
    Hashtable guardarSucursales(CccSucurData cccSucur, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;

    Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CccSucurData cccSucur, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccSucur) throws MareException, RemoteException;
}
