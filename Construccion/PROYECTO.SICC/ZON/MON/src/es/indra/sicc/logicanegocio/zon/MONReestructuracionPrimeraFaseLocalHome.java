package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONReestructuracionPrimeraFaseLocalHome extends EJBLocalHome 
{
  MONReestructuracionPrimeraFaseLocal create() throws CreateException;
}