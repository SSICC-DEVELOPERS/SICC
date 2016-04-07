package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeMagniData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MAEMagni extends EJBObject {
    Vector query(MaeMagniData maeMagniFrom, MaeMagniData maeMagniTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
