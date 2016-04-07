package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeGenerData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONGenerico extends EJBObject {
    Vector query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(MaeGenerData maeGener, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeGener) throws MareException, RemoteException;
}
