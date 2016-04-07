package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivDevolData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRECMotivoDevolucionReclamo extends EJBObject {
    Hashtable guardarMotivoDevolucion(RecMotivDevolData recMotivDevol, 
                                      Vector localizationLabels, 
                                      HashMap userProperties) throws MareException, 
                                                                     RemoteException;

    Vector query(RecMotivDevolData recMotivDevolFrom, 
                 RecMotivDevolData recMotivDevolTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(RecMotivDevolData recMotivDevol, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
