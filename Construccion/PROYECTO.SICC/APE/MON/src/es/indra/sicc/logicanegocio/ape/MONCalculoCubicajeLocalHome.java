package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCalculoCubicajeLocalHome extends EJBLocalHome 
{
  MONCalculoCubicajeLocal create() throws CreateException;
}