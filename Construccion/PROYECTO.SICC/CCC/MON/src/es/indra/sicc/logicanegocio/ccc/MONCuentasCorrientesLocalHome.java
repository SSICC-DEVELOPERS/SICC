package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuentasCorrientesLocalHome extends EJBLocalHome 
{
  MONCuentasCorrientesLocal create() throws CreateException;
}