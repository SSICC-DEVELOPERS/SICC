package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecParamNmperData;
import es.indra.belcorp.mso.RecPreciPerdiData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRECParametrizacionNMPCliente extends EJBObject {
    Vector query(RecPreciPerdiData recPreciPerdiFrom, 
                 RecPreciPerdiData recPreciPerdiTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(RecParamNmperData recParamNmperFrom, 
                 RecParamNmperData recParamNmperTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    Hashtable guardarParametrizacionCliente(RecParamNmperData recParamNmper, 
                                            Vector localizationLabels, 
                                            HashMap userProperties) throws MareException, 
                                                                           RemoteException;

    void update(RecParamNmperData recParamNmper, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
