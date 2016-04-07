package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeCicloVidaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCicloVida extends EJBObject {
    Hashtable guardarCicloVida(MaeCicloVidaData maeCicloVida, 
                               Vector localizationLabels, 
                               HashMap userProperties) throws MareException, 
                                                              RemoteException;

    Vector query(MaeCicloVidaData maeCicloVidaFrom, 
                 MaeCicloVidaData maeCicloVidaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeCicloVidaData maeCicloVida, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeCicloVida) throws MareException, RemoteException;
}
