package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccCuentContaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCuentaContable extends EJBObject {
    Hashtable guardarCuentaContable(CccCuentContaData cccCuentConta, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(CccCuentContaData cccCuentContaFrom, 
                 CccCuentContaData cccCuentContaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CccCuentContaData cccCuentConta, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccCuentConta) throws MareException, RemoteException;
}
