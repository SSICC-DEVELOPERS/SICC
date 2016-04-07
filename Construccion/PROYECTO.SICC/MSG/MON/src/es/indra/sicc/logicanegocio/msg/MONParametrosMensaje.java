package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgParamMensaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONParametrosMensaje extends EJBObject {
    Vector query(MsgParamMensaData msgParamMensaFrom, 
                 MsgParamMensaData msgParamMensaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void update(MsgParamMensaData msgParamMensa, 
                Vector localizationLabels) throws MareException, 
                                                  RemoteException;
}
