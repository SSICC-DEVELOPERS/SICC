package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoPerioData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoPeriodo extends EJBObject {
    Hashtable guardar(SegTipoPerioData segTipoPerio, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegTipoPerioData segTipoPerioFrom, 
                 SegTipoPerioData segTipoPerioTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector segTipoPerioFrom) throws MareException, RemoteException;

    void update(SegTipoPerioData segTipoPerio, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Vector query(SegTipoPerioData segTipoPerioFrom, 
                 SegTipoPerioData segTipoPerioTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(SegTipoPerioData segTipoPerioFrom, 
                 SegTipoPerioData segTipoPerioTo, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
