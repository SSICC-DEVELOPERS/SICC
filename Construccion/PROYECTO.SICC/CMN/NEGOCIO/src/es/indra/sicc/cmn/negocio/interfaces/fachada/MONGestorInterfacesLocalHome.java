package es.indra.sicc.cmn.negocio.interfaces.fachada;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesLocal;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface MONGestorInterfacesLocalHome extends EJBLocalHome 
{
  MONGestorInterfacesLocal create() throws  MareException, InterfacesException, CreateException;
}