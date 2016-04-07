package es.indra.sicc.cmn.negocio.busqueda;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONBusquedaGenericaLocalHome extends EJBLocalHome 
{
  MONBusquedaGenericaLocal create() throws CreateException;
}