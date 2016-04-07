package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoVincuData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAETipoVincu extends EJBObject {
    Vector query(MaeTipoVincuData maeTipoVincuFrom, 
                 MaeTipoVincuData maeTipoVincuTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(MaeTipoVincuData maeTipoVincu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(MaeTipoVincuData maeTipoVincu, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
