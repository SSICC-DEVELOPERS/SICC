package es.indra.sicc.logicanegocio.pre;

import es.indra.belcorp.mso.PreArgumVentaData;
import es.indra.belcorp.mso.PreTipoEstraData;
import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONArgumentoVenta extends EJBObject {
    Vector query(PreTipoEstraData preTipoEstraFrom, 
                 PreTipoEstraData preTipoEstraTo, 
                 HashMap userProperties) throws MareException, RemoteException;

    Vector query(PreArgumVentaData preArgumVentaFrom, 
                 PreArgumVentaData preArgumVentaTo, HashMap userProperties, 
                 Integer pageCount, Integer pageSize) throws MareException, 
                                                             RemoteException;
}
