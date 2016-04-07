package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClasiViewData;
import es.indra.belcorp.mso.MaeExencFleteData;
import es.indra.belcorp.mso.MaeSubtiClienViewData;
import es.indra.belcorp.mso.MaeTipoClasiClienViewData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONExencionFlete extends EJBObject {
    Vector query(MaeSubtiClienViewData maeSubtiClienViewFrom, 
                 MaeSubtiClienViewData maeSubtiClienViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, 
                 MaeTipoClasiClienViewData maeTipoClasiClienViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MaeClasiViewData maeClasiViewFrom, 
                 MaeClasiViewData maeClasiViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarExencionFlete(MaeExencFleteData maeExencFlete, 
                                   Vector localizationLabels, 
                                   HashMap userProperties) throws MareException, 
                                                                  RemoteException;

    Vector query(MaeExencFleteData maeExencFleteFrom, 
                 MaeExencFleteData maeExencFleteTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeExencFleteData maeExencFlete, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeExencFlete) throws MareException, RemoteException;
}
