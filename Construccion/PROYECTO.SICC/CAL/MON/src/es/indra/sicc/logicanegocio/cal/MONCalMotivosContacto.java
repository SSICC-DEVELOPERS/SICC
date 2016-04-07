package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalMotivContaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCalMotivosContacto extends EJBObject {
    Hashtable guardarMotivosContacto(CalMotivContaData calMotivConta, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(CalMotivContaData calMotivContaFrom, 
                 CalMotivContaData calMotivContaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CalMotivContaData calMotivConta, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector calMotivConta) throws MareException, RemoteException;
}
