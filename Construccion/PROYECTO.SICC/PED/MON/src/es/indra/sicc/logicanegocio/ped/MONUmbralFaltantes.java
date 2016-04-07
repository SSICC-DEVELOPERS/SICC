package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedUmbraFaltaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONUmbralFaltantes extends EJBObject {
    Hashtable guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(PedUmbraFaltaData pedUmbraFaltaFrom, 
                 PedUmbraFaltaData pedUmbraFaltaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(PedUmbraFaltaData pedUmbraFalta, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
