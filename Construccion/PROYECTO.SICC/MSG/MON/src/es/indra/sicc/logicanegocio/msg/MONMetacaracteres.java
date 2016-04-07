package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgMetacData;
import es.indra.belcorp.mso.MsgTipoMetacData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMetacaracteres extends EJBObject {
    Vector query(MsgTipoMetacData msgTipoMetacFrom, 
                 MsgTipoMetacData msgTipoMetacTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(MsgMetacData msgMetac, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardarMetac(MsgMetacData msgMetac, Vector localizationLabels, 
                           HashMap userProperties) throws MareException, 
                                                          RemoteException;
}
