package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobAccioCobraData;
import es.indra.belcorp.mso.CobSubtiAccioData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONAccionesDeCobranza extends EJBObject {
    Vector query(CobSubtiAccioData cobSubtiAccioFrom, 
                 CobSubtiAccioData cobSubtiAccioTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobAccioCobraData cobAccioCobraFrom, 
                 CobAccioCobraData cobAccioCobraTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobAccioCobraData cobAccioCobra, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardarAccion(CobAccioCobraData cobAccioCobra, 
                            Vector localizationLabels, 
                            HashMap userProperties) throws MareException, 
                                                           RemoteException;
}
