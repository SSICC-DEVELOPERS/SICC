package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacParamFactuData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParametrosFacturacion extends EJBObject {
    Hashtable guardar(FacParamFactuData facParamFactu, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(FacParamFactuData facParamFactuFrom, 
                 FacParamFactuData facParamFactuTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector facParamFactuFrom) throws MareException, 
                                                 RemoteException;

    void update(FacParamFactuData facParamFactu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
