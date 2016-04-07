package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEstadGrupoUsuarData;
import es.indra.belcorp.mso.CobGrupoUsuarCobraData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONGrupoUsuariosCobranza extends EJBObject {
    Vector query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, 
                 CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, 
                 CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
