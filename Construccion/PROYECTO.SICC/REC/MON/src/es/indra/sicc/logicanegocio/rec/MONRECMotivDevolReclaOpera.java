package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivDevolData;
import es.indra.belcorp.mso.RecMotivDevolOperaData;
import es.indra.belcorp.mso.RecOperaViewData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONRECMotivDevolReclaOpera extends EJBObject {
    Vector query(RecMotivDevolData recMotivDevolFrom, 
                 RecMotivDevolData recMotivDevolTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(RecOperaViewData recOperaViewFrom, 
                 RecOperaViewData recOperaViewTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarMotivoDevolucion(RecMotivDevolOperaData recMotivDevolOpera, 
                                      Vector localizationLabels, 
                                      HashMap userProperties) throws MareException, 
                                                                     RemoteException;

    Vector query(RecMotivDevolOperaData recMotivDevolOperaFrom, 
                 RecMotivDevolOperaData recMotivDevolOperaTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(RecMotivDevolOperaData recMotivDevolOpera, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;
}
