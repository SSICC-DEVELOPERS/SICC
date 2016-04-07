package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalAtribEstadContaData;
import es.indra.belcorp.mso.CalTipoEstadContaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCalAtributoEstadoContactos extends EJBObject {
    Hashtable guardarAtributoEstadoContactos(CalAtribEstadContaData calAtribEstadConta, 
                                             Vector localizationLabels, 
                                             HashMap userProperties) throws MareException, 
                                                                            RemoteException;

    Vector query(CalAtribEstadContaData calAtribEstadContaFrom, 
                 CalAtribEstadContaData calAtribEstadContaTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Vector query(CalTipoEstadContaData calTipoEstadContaFrom, 
                 CalTipoEstadContaData calTipoEstadContaTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    void update(CalAtribEstadContaData calAtribEstadConta, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector calAtribEstadConta) throws MareException, 
                                                  RemoteException;
}
