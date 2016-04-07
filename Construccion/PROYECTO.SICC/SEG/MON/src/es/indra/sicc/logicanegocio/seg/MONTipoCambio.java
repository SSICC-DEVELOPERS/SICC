package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoCambiData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoCambio extends EJBObject {
    Hashtable guardar(SegTipoCambiData segTipoCambi, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegTipoCambiData segTipoCambiFrom, 
                 SegTipoCambiData segTipoCambiTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector segTipoCambiFrom) throws MareException, RemoteException;

    void update(SegTipoCambiData segTipoCambi, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
