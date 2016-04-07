package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoTransData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCccTipoTransaccion extends EJBObject {
    Hashtable guardarTipoTransaccion(CccTipoTransData cccTipoTrans, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(CccTipoTransData cccTipoTransFrom, 
                 CccTipoTransData cccTipoTransTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CccTipoTransData cccTipoTrans, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccTipoTrans) throws MareException, RemoteException;
}
