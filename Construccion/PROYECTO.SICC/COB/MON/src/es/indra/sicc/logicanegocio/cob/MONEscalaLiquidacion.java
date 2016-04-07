package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEscalLiquiData;
import es.indra.belcorp.mso.CobMetodLiquiViewData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEscalaLiquidacion extends EJBObject {
    Vector query(CobEscalLiquiData cobEscalLiquiFrom, 
                 CobEscalLiquiData cobEscalLiquiTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    Vector query(CobMetodLiquiViewData cobMetodLiquiViewFrom, 
                 CobMetodLiquiViewData cobMetodLiquiViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobEscalLiquiData cobEscalLiqui, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, 
                               Vector localizationLabels, 
                               HashMap userProperties) throws MareException, 
                                                              RemoteException;
}
