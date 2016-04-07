package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.MaeNegocData;
import es.indra.belcorp.mso.PedImpueNegocData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONImpuestosNegocio extends EJBObject {
    Vector query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarImpuestosNegocio(PedImpueNegocData pedImpueNegoc, 
                                      Vector localizationLabels, 
                                      HashMap userProperties) throws MareException, 
                                                                     RemoteException;

    Vector query(PedImpueNegocData pedImpueNegocFrom, 
                 PedImpueNegocData pedImpueNegocTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedImpueNegocData pedImpueNegoc, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
