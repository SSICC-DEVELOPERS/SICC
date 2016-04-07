package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalTipoGestiClienData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCalTipoGestionCliente extends EJBObject {
    Hashtable guardarTipoGestionCliente(CalTipoGestiClienData calTipoGestiClien, 
                                        Vector localizationLabels, 
                                        HashMap userProperties) throws MareException, 
                                                                       RemoteException;

    Vector query(CalTipoGestiClienData calTipoGestiClienFrom, 
                 CalTipoGestiClienData calTipoGestiClienTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CalTipoGestiClienData calTipoGestiClien, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector calTipoGestiClien) throws MareException, 
                                                 RemoteException;
}
