package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeSuperGenerData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONSuperGenerico extends EJBObject {
    Vector query(MaeSuperGenerData maeSuperGenerFrom, 
                 MaeSuperGenerData maeSuperGenerTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    void remove(Vector maeSuperGener) throws MareException, RemoteException;
}
