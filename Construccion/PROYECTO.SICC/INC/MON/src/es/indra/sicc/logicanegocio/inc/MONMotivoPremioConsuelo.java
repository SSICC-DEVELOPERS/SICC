package es.indra.sicc.logicanegocio.inc;

import es.indra.belcorp.mso.IncMotivPremiConsuData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMotivoPremioConsuelo extends EJBObject {
    Hashtable guardar(IncMotivPremiConsuData incMotivPremiConsu, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector incMotivPremiConsuFrom) throws MareException, 
                                                      RemoteException;

    Vector query(IncMotivPremiConsuData incMotivPremiConsuFrom, 
                 IncMotivPremiConsuData incMotivPremiConsuTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(IncMotivPremiConsuData incMotivPremiConsu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
