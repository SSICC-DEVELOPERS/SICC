package es.indra.sicc.cmn.negocio.i18n;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONI18nMMG extends EJBObject {
    Vector query(GenDetaSiccData genDetaSiccFrom, 
                 GenDetaSiccData genDetaSiccTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
