package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobBaseEscalData;
import es.indra.belcorp.mso.CobMetodLiquiData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMetodosLiquidacion extends EJBObject {
    Vector query(CobBaseEscalData cobBaseEscalFrom, 
                 CobBaseEscalData cobBaseEscalTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobMetodLiquiData cobMetodLiquiFrom, 
                 CobMetodLiquiData cobMetodLiquiTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, 
                               Vector localizationLabels, 
                               HashMap userProperties) throws MareException, 
                                                              RemoteException;

    void update(CobMetodLiquiData cobMetodLiqui, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
