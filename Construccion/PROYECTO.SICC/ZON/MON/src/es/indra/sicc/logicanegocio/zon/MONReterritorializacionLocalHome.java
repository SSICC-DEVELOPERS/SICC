package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONReterritorializacionLocalHome extends EJBLocalHome 
{
  MONReterritorializacionLocal create() throws CreateException;
}