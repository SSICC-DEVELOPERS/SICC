package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeCriteBusquData;
import es.indra.belcorp.mso.PedAtribEspecData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCriterioBusqueda extends EJBObject {
    Vector query(PedAtribEspecData pedAtribEspecFrom, 
                 PedAtribEspecData pedAtribEspecTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, 
                                      Vector localizationLabels, 
                                      HashMap userProperties) throws MareException, 
                                                                     RemoteException;

    Vector query(MaeCriteBusquData maeCriteBusquFrom, 
                 MaeCriteBusquData maeCriteBusquTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeCriteBusquData maeCriteBusqu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeCriteBusqu) throws MareException, RemoteException;
}
