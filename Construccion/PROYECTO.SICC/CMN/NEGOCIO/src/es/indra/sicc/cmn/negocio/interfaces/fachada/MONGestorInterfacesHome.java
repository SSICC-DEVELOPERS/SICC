package es.indra.sicc.cmn.negocio.interfaces.fachada;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface MONGestorInterfacesHome extends EJBHome 
{
  MONGestorInterfaces create() throws  MareException, InterfacesException, RemoteException, CreateException;
}