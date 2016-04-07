package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobUsuarCobraViewData;
import es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONUsuEtapaCobraCabe extends EJBObject {
    Vector query(CobUsuarCobraViewData cobUsuarCobraViewFrom, 
                 CobUsuarCobraViewData cobUsuarCobraViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, 
                 CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
