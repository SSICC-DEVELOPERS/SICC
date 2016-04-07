package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeLineaProduData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONLineasProducto extends EJBObject {
    Hashtable guardarLineasProducto(MaeLineaProduData maeLineaProdu, 
                                    Vector localizationLabels, 
                                    HashMap userProperties) throws MareException, 
                                                                   RemoteException;

    Vector query(MaeLineaProduData maeLineaProduFrom, 
                 MaeLineaProduData maeLineaProduTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeLineaProduData maeLineaProdu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeLineaProdu) throws MareException, RemoteException;
}
