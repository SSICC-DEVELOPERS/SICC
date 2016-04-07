package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoPrefeData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAETipoPrefer extends EJBObject {
    Vector query(MaeTipoPrefeData maeTipoPrefeFrom, 
                 MaeTipoPrefeData maeTipoPrefeTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardar(MaeTipoPrefeData maeTipoPrefe, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void update(MaeTipoPrefeData maeTipoPrefe, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
