package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoProblData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

import es.indra.mare.common.exception.MareException;

public interface MAETipoProbl extends EJBObject {
    Vector query(MaeTipoProblData maeTipoProblFrom, 
                 MaeTipoProblData maeTipoProblTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(MaeTipoProblData maeTipoProbl, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(MaeTipoProblData maeTipoProbl, Vector localizationLabels, 
                      HashMap userProperties) throws RemoteException, 
                                                     MareException;

    Vector query(MaeTipoProblData maeTipoProblFrom, 
                 MaeTipoProblData maeTipoProblTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
