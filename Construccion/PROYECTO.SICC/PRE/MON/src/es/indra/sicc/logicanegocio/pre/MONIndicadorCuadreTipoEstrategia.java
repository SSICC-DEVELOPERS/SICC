package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreIndicCuadrData;
import es.indra.belcorp.mso.PreIndicCuadrTipoEstraData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONIndicadorCuadreTipoEstrategia extends EJBObject {

    Vector query(PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraFrom, 
                 PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraTo, 
                 HashMap userProperties, Integer pageCount, 
                 Integer pageSize) throws MareException, RemoteException;
}
