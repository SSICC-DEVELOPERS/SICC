package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalTipoEstadContaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCalTipoEstadoContacto extends EJBObject {
    Hashtable guardarTipoEstadoContacto(CalTipoEstadContaData calTipoEstadConta, 
                                        Vector localizationLabels, 
                                        HashMap userProperties) throws MareException, 
                                                                       RemoteException;

    Vector query(CalTipoEstadContaData calTipoEstadContaFrom, 
                 CalTipoEstadContaData calTipoEstadContaTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector calTipoEstadConta) throws MareException, 
                                                 RemoteException;

    void update(CalTipoEstadContaData calTipoEstadConta, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
