package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeNegocData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONNegocio extends EJBObject {
    Vector query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(MaeNegocData maeNegoc, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeNegoc) throws MareException, RemoteException;
}
