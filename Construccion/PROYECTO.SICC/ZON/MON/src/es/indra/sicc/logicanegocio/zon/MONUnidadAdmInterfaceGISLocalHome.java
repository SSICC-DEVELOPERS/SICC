package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONUnidadAdmInterfaceGISLocalHome extends EJBLocalHome 
{
  MONUnidadAdmInterfaceGISLocal create() throws CreateException;
}