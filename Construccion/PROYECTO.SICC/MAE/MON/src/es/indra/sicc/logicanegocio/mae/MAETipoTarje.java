package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoTarjeData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAETipoTarje extends EJBObject {
    Hashtable guardar(MaeTipoTarjeData maeTipoTarje, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(MaeTipoTarjeData maeTipoTarjeFrom, 
                 MaeTipoTarjeData maeTipoTarjeTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeTipoTarjeData maeTipoTarje, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
