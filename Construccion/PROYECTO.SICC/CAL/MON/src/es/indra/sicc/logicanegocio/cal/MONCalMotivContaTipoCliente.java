package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalMotivContaData;
import es.indra.belcorp.mso.CalMotivTipoClienData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCalMotivContaTipoCliente extends EJBObject {
    Vector query(CalMotivContaData calMotivContaFrom, 
                 CalMotivContaData calMotivContaTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarMotivContaTipoCliente(CalMotivTipoClienData calMotivTipoClien, 
                                           Vector localizationLabels, 
                                           HashMap userProperties) throws MareException, 
                                                                          RemoteException;

    Vector query(CalMotivTipoClienData calMotivTipoClienFrom, 
                 CalMotivTipoClienData calMotivTipoClienTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector calMotivTipoClien) throws MareException, 
                                                 RemoteException;
}
