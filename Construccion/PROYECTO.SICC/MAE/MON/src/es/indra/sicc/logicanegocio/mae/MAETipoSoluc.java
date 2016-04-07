package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoSolucData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAETipoSoluc extends EJBObject {
    Vector query(MaeTipoSolucData maeTipoSolucFrom, 
                 MaeTipoSolucData maeTipoSolucTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(MaeTipoSolucData maeTipoSolucFrom, 
                 MaeTipoSolucData maeTipoSolucTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(MaeTipoSolucData maeTipoSoluc, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(MaeTipoSolucData maeTipoSoluc, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
