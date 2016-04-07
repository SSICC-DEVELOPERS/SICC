package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoViaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoVia extends EJBObject {
    Hashtable guardar(SegTipoViaData segTipoVia, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegTipoViaData segTipoViaFrom, SegTipoViaData segTipoViaTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector segTipoViaFrom) throws MareException, RemoteException;

    void update(SegTipoViaData segTipoVia, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
