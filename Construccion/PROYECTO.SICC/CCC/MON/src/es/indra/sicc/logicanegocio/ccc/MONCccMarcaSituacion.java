package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccMarcaSituaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCccMarcaSituacion extends EJBObject {
    Hashtable guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(CccMarcaSituaData cccMarcaSituaFrom, 
                 CccMarcaSituaData cccMarcaSituaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CccMarcaSituaData cccMarcaSitua, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector cccMarcaSitua) throws MareException, RemoteException;
}
