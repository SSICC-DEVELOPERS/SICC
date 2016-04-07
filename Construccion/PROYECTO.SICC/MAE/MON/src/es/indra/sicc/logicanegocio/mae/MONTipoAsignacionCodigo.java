package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeParamClienData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONTipoAsignacionCodigo extends EJBObject {
    Hashtable guardarTipoAsignacionCodigo(MaeParamClienData maeParamClien, 
                                          Vector localizationLabels, 
                                          HashMap userProperties) throws MareException, 
                                                                         RemoteException;

    Vector query(MaeParamClienData maeParamClienFrom, 
                 MaeParamClienData maeParamClienTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
