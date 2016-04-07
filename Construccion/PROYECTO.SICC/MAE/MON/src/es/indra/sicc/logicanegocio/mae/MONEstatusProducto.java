package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEstatProduData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEstatusProducto extends EJBObject {
    Hashtable guardarEstatusProducto(MaeEstatProduData maeEstatProdu, 
                                     Vector localizationLabels, 
                                     HashMap userProperties) throws MareException, 
                                                                    RemoteException;

    Vector query(MaeEstatProduData maeEstatProduFrom, 
                 MaeEstatProduData maeEstatProduTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeEstatProduData maeEstatProdu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeEstatProdu) throws MareException, RemoteException;
}
