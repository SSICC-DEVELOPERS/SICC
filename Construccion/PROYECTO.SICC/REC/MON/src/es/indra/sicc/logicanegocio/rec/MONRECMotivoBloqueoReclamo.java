package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivBloquData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRECMotivoBloqueoReclamo extends EJBObject {
    Hashtable guardarMotivoBloqueoReclamo(RecMotivBloquData recMotivBloqu, 
                                          Vector localizationLabels, 
                                          HashMap userProperties) throws MareException, 
                                                                         RemoteException;

    Vector query(RecMotivBloquData recMotivBloquFrom, 
                 RecMotivBloquData recMotivBloquTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(RecMotivBloquData recMotivBloqu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
