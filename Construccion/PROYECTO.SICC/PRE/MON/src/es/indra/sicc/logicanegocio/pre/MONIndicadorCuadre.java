package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreIndicCuadrData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONIndicadorCuadre extends EJBObject {
    Vector query(PreIndicCuadrData preIndicCuadrFrom, 
                 PreIndicCuadrData preIndicCuadrTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;

    Vector query(PreIndicCuadrData preIndicCuadrFrom, 
                 PreIndicCuadrData preIndicCuadrTo, 
                 HashMap userProperties) throws MareException, RemoteException;
}
