package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoProblTipoSolucData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAETipoProblTipoSoluc extends EJBObject {
    Vector query(MaeTipoProblTipoSolucData maeTipoProblTipoSolucFrom, 
                 MaeTipoProblTipoSolucData maeTipoProblTipoSolucTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Hashtable guardar(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
