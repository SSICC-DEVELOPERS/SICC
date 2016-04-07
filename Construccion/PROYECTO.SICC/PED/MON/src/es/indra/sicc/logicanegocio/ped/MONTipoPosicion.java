package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedTipoPosicData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoPosicion extends EJBObject {
    Hashtable guardarTipoPosicion(PedTipoPosicData pedTipoPosic, 
                                  Vector localizationLabels, 
                                  HashMap userProperties) throws MareException, 
                                                                 RemoteException;

    Vector query(PedTipoPosicData pedTipoPosicFrom, 
                 PedTipoPosicData pedTipoPosicTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedTipoPosicData pedTipoPosic, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
