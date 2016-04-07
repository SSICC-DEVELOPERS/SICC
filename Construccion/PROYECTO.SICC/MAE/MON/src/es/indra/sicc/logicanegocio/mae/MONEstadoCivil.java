package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEstadCivilData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEstadoCivil extends EJBObject {
    Hashtable guardarEstadoCivil(MaeEstadCivilData maeEstadCivil, 
                                 Vector localizationLabels, 
                                 HashMap userProperties) throws MareException, 
                                                                RemoteException;

    Vector query(MaeEstadCivilData maeEstadCivilFrom, 
                 MaeEstadCivilData maeEstadCivilTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeEstadCivilData maeEstadCivil, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeEstadCivil) throws MareException, RemoteException;
}
