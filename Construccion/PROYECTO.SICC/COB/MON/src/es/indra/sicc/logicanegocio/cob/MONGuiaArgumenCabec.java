package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobGuionArgumCabecData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONGuiaArgumenCabec extends EJBObject {
    Vector query(CobGuionArgumCabecData cobGuionArgumCabecFrom, 
                 CobGuionArgumCabecData cobGuionArgumCabecTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobGuionArgumCabecData cobGuionArgumCabec, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(CobGuionArgumCabecData cobGuionArgumCabec, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
