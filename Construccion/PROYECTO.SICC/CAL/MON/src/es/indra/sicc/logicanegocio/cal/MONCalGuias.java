package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalGuiasData;
import es.indra.belcorp.mso.SegDeptoEmpreData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONCalGuias extends EJBObject {
    Vector query(SegDeptoEmpreData segDeptoEmpreFrom, 
                 SegDeptoEmpreData segDeptoEmpreTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarGuias(CalGuiasData calGuias, Vector localizationLabels, 
                           HashMap userProperties) throws MareException, 
                                                          RemoteException;

    Vector query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void update(CalGuiasData calGuias, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector calGuias) throws MareException, RemoteException;
}
