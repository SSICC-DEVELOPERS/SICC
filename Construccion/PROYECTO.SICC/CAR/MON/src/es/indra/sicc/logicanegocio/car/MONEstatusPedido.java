package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarEstatPedidData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEstatusPedido extends EJBObject {
    Vector query(CarEstatPedidData carEstatPedidFrom, 
                 CarEstatPedidData carEstatPedidTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CarEstatPedidData carEstatPedid, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarEstPed(CarEstatPedidData carEstatPedid, 
                            Vector localizationLabels, 
                            HashMap userProperties) throws MareException, 
                                                           RemoteException;
}
