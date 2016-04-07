package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecResulChequData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRECTipoResultadosChequeos extends EJBObject {
    Hashtable guardarTipoResultadoCliente(RecResulChequData recResulChequ, 
                                          Vector localizationLabels, 
                                          HashMap userProperties) throws MareException, 
                                                                         RemoteException;

    Vector query(RecResulChequData recResulChequFrom, 
                 RecResulChequData recResulChequTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(RecResulChequData recResulChequ, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
