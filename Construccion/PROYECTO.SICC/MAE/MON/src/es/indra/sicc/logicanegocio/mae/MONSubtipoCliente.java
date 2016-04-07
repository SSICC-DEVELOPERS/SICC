package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeSubtiClienData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONSubtipoCliente extends EJBObject {
    Hashtable guardarSubtipoCliente(MaeSubtiClienData maeSubtiClien, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(MaeSubtiClienData maeSubtiClienFrom, 
                 MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeSubtiClienData maeSubtiClien, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeSubtiClien) throws MareException, RemoteException;
}
