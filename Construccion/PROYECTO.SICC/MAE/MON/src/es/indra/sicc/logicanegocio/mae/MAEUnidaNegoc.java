package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeUnidaNegocData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAEUnidaNegoc extends EJBObject {
    Vector query(MaeUnidaNegocData maeUnidaNegocFrom, 
                 MaeUnidaNegocData maeUnidaNegocTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector maeUnidaNegoc) throws MareException, RemoteException;

    void update(MaeUnidaNegocData maeUnidaNegoc, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(MaeUnidaNegocData maeUnidaNegoc, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
