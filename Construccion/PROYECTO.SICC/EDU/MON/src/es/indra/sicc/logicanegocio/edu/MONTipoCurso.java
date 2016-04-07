package es.indra.sicc.logicanegocio.edu;

import es.indra.belcorp.mso.EduTipoCursoData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoCurso extends EJBObject {
    Vector query(EduTipoCursoData eduTipoCursoFrom, 
                 EduTipoCursoData eduTipoCursoTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    void update(EduTipoCursoData eduTipoCurso, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Hashtable guardar(EduTipoCursoData eduTipoCurso, Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;
}
