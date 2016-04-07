package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreCicloVidaData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONPreCicloVida extends EJBObject {
    Vector query(PreCicloVidaData preCicloVidaFrom, 
                 PreCicloVidaData preCicloVidaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
