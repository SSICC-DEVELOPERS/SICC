package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONBancos extends EJBObject {
    Hashtable guardarBancos(CccBancoData cccBanco, Vector localizationLabels, 
                            HashMap userProperties) throws MareException, 
                                                           RemoteException;

    Vector query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CccBancoData cccBanco, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccBanco) throws MareException, RemoteException;
}
