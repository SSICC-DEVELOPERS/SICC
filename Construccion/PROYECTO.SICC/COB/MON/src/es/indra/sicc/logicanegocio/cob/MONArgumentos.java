package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONArgumentos extends EJBObject {
    Vector query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CobArgumData cobArgum, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarArgumentos(CobArgumData cobArgum, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;
}
