package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSeleccionarAnaquelLocalHome extends EJBLocalHome 
{
  MONSeleccionarAnaquelLocal create() throws CreateException;
}