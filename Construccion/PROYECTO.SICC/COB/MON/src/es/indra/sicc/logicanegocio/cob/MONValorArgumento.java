package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobValorArgumData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONValorArgumento extends EJBObject {
    Vector query(CobValorArgumData cobValorArgumFrom, 
                 CobValorArgumData cobValorArgumTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobValorArgumData cobValorArgum, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(CobValorArgumData cobValorArgum, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(CobValorArgumData cobValorArgumFrom, 
                 CobValorArgumData cobValorArgumTo, HashMap userProperties, 
                 Boolean applyStructuralSecurity) throws MareException, 
                                                         RemoteException;
}
