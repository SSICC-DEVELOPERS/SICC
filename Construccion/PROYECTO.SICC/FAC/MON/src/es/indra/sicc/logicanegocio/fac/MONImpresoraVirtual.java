package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacImpreVirtuData;
import es.indra.belcorp.mso.FacTipoImpreData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONImpresoraVirtual extends EJBObject {
    Vector query(FacTipoImpreData facTipoImpreFrom, 
                 FacTipoImpreData facTipoImpreTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardar(FacImpreVirtuData facImpreVirtu, 
                      Vector localizationLabels, 
                      HashMap userProperties) throws MareException, 
                                                     RemoteException;

    Vector query(FacImpreVirtuData facImpreVirtuFrom, 
                 FacImpreVirtuData facImpreVirtuTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector facImpreVirtuFrom) throws MareException, 
                                                 RemoteException;

    void update(FacImpreVirtuData facImpreVirtu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    Long obtenerImpresoraPorRutinaFormulario(String rutina, 
                                             Long subacceso) throws MareException, 
                                                                    RemoteException;
}
