package es.indra.sicc.logicanegocio.com;

import es.indra.belcorp.mso.ComEstadComisData;

import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;



public interface MONMantenimientoEstadoComision extends EJBObject {
    Vector query(ComEstadComisData comEstadComisFrom, 
                 ComEstadComisData comEstadComisTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws RemoteException, 
                                                             MareException;

    void update(ComEstadComisData comEstadComis, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
