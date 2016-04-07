package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarCodigAprobData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCodigosAprobacion extends EJBObject {
    Vector query(CarCodigAprobData carCodigAprobFrom, 
                 CarCodigAprobData carCodigAprobTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(CarCodigAprobData carCodigAprob, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarCarCoAp(CarCodigAprobData carCodigAprob, 
                             Vector localizationLabels, 
                             HashMap userProperties) throws MareException, 
                                                            RemoteException;
}
