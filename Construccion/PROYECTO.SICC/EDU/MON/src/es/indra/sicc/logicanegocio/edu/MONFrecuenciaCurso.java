package es.indra.sicc.logicanegocio.edu;

import es.indra.belcorp.mso.EduFrecuCursoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONFrecuenciaCurso extends EJBObject {
    Vector query(EduFrecuCursoData eduFrecuCursoFrom, 
                 EduFrecuCursoData eduFrecuCursoTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(EduFrecuCursoData eduFrecuCurso, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(EduFrecuCursoData eduFrecuCurso, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
