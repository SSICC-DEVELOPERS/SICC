package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONZONLogLocalHome extends EJBLocalHome 
{
  MONZONLogLocal create() throws CreateException;
}