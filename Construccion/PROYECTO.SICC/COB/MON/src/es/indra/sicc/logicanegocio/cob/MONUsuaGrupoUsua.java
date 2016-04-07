package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobGrupoUsuarCobraData;
import es.indra.belcorp.mso.CobUsuarGrupoUsuarData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONUsuaGrupoUsua extends EJBObject {
    Vector query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, 
                 CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, 
                 CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Hashtable guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
