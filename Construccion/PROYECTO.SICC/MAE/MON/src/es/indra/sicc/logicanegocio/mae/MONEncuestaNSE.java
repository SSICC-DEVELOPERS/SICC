package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEncueNseData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mae.DTOTipoEncuesta;
import es.indra.sicc.util.DTOOIDs;

import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONEncuestaNSE extends EJBObject {
    Hashtable guardarEncuestaNse(MaeEncueNseData maeEncueNse, 
                                 Vector localizationLabels, 
                                 HashMap userProperties) throws MareException, 
                                                                RemoteException;

    Vector query(MaeEncueNseData maeEncueNseFrom, 
                 MaeEncueNseData maeEncueNseTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MaeEncueNseData maeEncueNse, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(DTOOIDs maeEncueNse) throws MareException, RemoteException;

    DTOSalida buscarEncuestaNSE(DTOTipoEncuesta dtoe) throws MareException, 
                                                             RemoteException;
                                                             
}
