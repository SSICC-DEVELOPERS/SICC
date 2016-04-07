package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedSubtiPosicData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONSubtipoPosicion extends EJBObject {
    Hashtable guardarSubtipoPosicion(PedSubtiPosicData pedSubtiPosic, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(PedSubtiPosicData pedSubtiPosicFrom, 
                 PedSubtiPosicData pedSubtiPosicTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedSubtiPosicData pedSubtiPosic, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
