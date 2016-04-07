package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedTipoDespaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoDespachos extends EJBObject {
    Hashtable guardarTipoDespacho(PedTipoDespaData pedTipoDespa, 
                                  Vector localizationLabels, 
                                  HashMap userProperties) throws MareException, 
                                                                 RemoteException;

    Vector query(PedTipoDespaData pedTipoDespaFrom, 
                 PedTipoDespaData pedTipoDespaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedTipoDespaData pedTipoDespa, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
