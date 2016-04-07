package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeUnidaMedidData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAEUnidMedida extends EJBObject {
    Vector query(MaeUnidaMedidData maeUnidaMedidFrom, 
                 MaeUnidaMedidData maeUnidaMedidTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    Hashtable guardar(MaeUnidaMedidData maeUnidaMedid, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(MaeUnidaMedidData maeUnidaMedid, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
