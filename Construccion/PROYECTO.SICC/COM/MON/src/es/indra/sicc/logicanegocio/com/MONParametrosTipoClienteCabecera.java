package es.indra.sicc.logicanegocio.com;

import es.indra.belcorp.mso.ComTipoClienComisCabecData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParametrosTipoClienteCabecera extends EJBObject {
    Vector query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, 
                 ComTipoClienComisCabecData comTipoClienComisCabecTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(ComTipoClienComisCabecData comTipoClienComisCabec, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardar(ComTipoClienComisCabecData comTipoClienComisCabec, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
