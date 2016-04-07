package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoCargoAbonoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCccTipoCargoAbono extends EJBObject {
    Hashtable guardarTipoCargoAbono(CccTipoCargoAbonoData cccTipoCargoAbono, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, 
                 CccTipoCargoAbonoData cccTipoCargoAbonoTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CccTipoCargoAbonoData cccTipoCargoAbono, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccTipoCargoAbono) throws MareException, 
                                                 RemoteException;
}
