package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaProduData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMarcaProducto extends EJBObject {
    Hashtable guardar(SegMarcaProduData segMarcaProdu, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegMarcaProduData segMarcaProduFrom, 
                 SegMarcaProduData segMarcaProduTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector segMarcaProduFrom) throws MareException, 
                                                 RemoteException;

    void update(SegMarcaProduData segMarcaProdu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Vector query(SegMarcaProduData segMarcaProduFrom, 
                 SegMarcaProduData segMarcaProduTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
