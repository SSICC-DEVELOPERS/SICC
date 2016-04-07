package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacDestiImpreData;
import es.indra.belcorp.mso.FacFormuData;
import es.indra.belcorp.mso.FacTecnoImpreData;
import es.indra.belcorp.mso.FacTipoDocumData;
import es.indra.belcorp.mso.FacTipoFormuData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONFormulario extends EJBObject {
    Vector query(FacTecnoImpreData facTecnoImpreFrom, 
                 FacTecnoImpreData facTecnoImpreTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(FacDestiImpreData facDestiImpreFrom, 
                 FacDestiImpreData facDestiImpreTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(FacTipoFormuData facTipoFormuFrom, 
                 FacTipoFormuData facTipoFormuTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(FacTipoDocumData facTipoDocumFrom, 
                 FacTipoDocumData facTipoFormuTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Hashtable guardarFormulario(FacFormuData facFormu, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;

    Vector query(FacFormuData facFormuFrom, FacFormuData facFormuTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    void remove(Vector facFormuFrom) throws MareException, RemoteException;

    void update(FacFormuData facFormu, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
