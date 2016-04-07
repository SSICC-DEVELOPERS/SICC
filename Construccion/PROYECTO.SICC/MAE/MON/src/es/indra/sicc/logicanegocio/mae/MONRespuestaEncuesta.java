package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaePreguEncueData;
import es.indra.belcorp.mso.MaeRespuEncueData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRespuestaEncuesta extends EJBObject {
    Vector query(MaePreguEncueData maePreguEncueFrom, 
                 MaePreguEncueData maePreguEncueTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarRespuestaEncuesta(MaeRespuEncueData maeRespuEncue, 
                                       Vector localizationLabels, 
                                       HashMap userProperties) throws MareException, 
                                                                      RemoteException;

    Vector query(MaeRespuEncueData maeRespuEncueFrom, 
                 MaeRespuEncueData maeRespuEncueTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeRespuEncueData maeRespuEncue, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector maeRespuEncue) throws MareException, RemoteException;
}
