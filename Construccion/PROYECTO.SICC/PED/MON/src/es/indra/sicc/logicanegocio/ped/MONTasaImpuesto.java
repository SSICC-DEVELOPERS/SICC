package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedTasaImpueData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTasaImpuesto extends EJBObject {
    Hashtable guardarTasaImpuesto(PedTasaImpueData pedTasaImpue, 
                                  Vector localizationLabels, 
                                  HashMap userProperties) throws MareException, 
                                                                 RemoteException;

    Vector query(PedTasaImpueData pedTasaImpueFrom, 
                 PedTasaImpueData pedTasaImpueTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedTasaImpueData pedTasaImpue, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
