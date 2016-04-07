package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegDeptoEmpreData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONDepartamentoEmpresa extends EJBObject {
    Hashtable guardar(SegDeptoEmpreData segDeptoEmpre, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(SegDeptoEmpreData segDeptoEmpreFrom, 
                 SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector segDeptoEmpreFrom) throws MareException, 
                                                 RemoteException;

    void update(SegDeptoEmpreData segDeptoEmpre, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
