package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClaseTarjeData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONClaseTarjeta extends EJBObject {
    Hashtable guardarClaseTarjeta(MaeClaseTarjeData maeClaseTarje, 
                                  Vector localizationLabels, 
                                  HashMap userProperties) throws MareException, 
                                                                 RemoteException;

    Vector query(MaeClaseTarjeData maeClaseTarjeFrom, 
                 MaeClaseTarjeData maeClaseTarjeTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeClaseTarjeData maeClaseTarje, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeClaseTarje) throws MareException, RemoteException;
}
