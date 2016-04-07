package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgMedioEnvioData;
import es.indra.belcorp.mso.MsgMedioEnvioPaisData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMedioEnvio extends EJBObject {
    Vector query(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, 
                 MsgMedioEnvioPaisData msgMedioEnvioPaisTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;

    Vector query(MsgMedioEnvioData msgMedioEnvioFrom, 
                 MsgMedioEnvioData msgMedioEnvioTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    void update(MsgMedioEnvioPaisData msgMedioEnvioPais, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;

    void remove(Vector entities) throws MareException, RemoteException;

    Hashtable guardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, 
                                Vector localizationLabels, 
                                HashMap userProperties) throws MareException, 
                                                               RemoteException;
}
