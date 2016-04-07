package es.indra.sicc.logicanegocio.inc;

import es.indra.belcorp.mso.IncDirigData;
import es.indra.belcorp.mso.IncPartiConcuCabecData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParticipantesConcursoCabecera extends EJBObject {
    Vector query(IncDirigData incDirigFrom, IncDirigData incDirigTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardar(IncPartiConcuCabecData incPartiConcuCabec, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(IncPartiConcuCabecData incPartiConcuCabecFrom, 
                 IncPartiConcuCabecData incPartiConcuCabecTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector incPartiConcuCabecFrom) throws MareException, 
                                                      RemoteException;

    void update(IncPartiConcuCabecData incPartiConcuCabec, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
