package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedImpueGenerData;
import es.indra.belcorp.mso.PedTasaImpueData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONImpuestosGenerales extends EJBObject {
    Vector query(PedTasaImpueData pedTasaImpueFrom, 
                 PedTasaImpueData pedTasaImpueTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarImpuestosGenerales(PedImpueGenerData pedImpueGener, 
                                        Vector localizationLabels, 
                                        HashMap userProperties) throws MareException, 
                                                                       RemoteException;

    Vector query(PedImpueGenerData pedImpueGenerFrom, 
                 PedImpueGenerData pedImpueGenerTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedImpueGenerData pedImpueGener, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
