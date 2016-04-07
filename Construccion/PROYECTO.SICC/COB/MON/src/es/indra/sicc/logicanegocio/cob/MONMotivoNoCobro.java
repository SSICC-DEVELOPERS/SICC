package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobMotivIncobData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMotivoNoCobro extends EJBObject {
    Vector query(CobMotivIncobData cobMotivIncobFrom, 
                 CobMotivIncobData cobMotivIncobTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CobMotivIncobData cobMotivIncob, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarMotivIncob(CobMotivIncobData cobMotivIncob, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;
}
