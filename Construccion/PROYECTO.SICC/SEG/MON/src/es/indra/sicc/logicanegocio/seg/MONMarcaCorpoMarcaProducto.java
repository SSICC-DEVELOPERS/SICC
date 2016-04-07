package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMarcaCorpoMarcaProduData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMarcaCorpoMarcaProducto extends EJBObject {
    Hashtable guardar(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, 
                 SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector segMarcaCorpoMarcaProduFrom) throws MareException, 
                                                           RemoteException;

    void update(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProdu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
