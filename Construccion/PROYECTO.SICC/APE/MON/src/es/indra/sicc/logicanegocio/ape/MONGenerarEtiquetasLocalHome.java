package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGenerarEtiquetasLocalHome extends EJBLocalHome 
{
  MONGenerarEtiquetasLocal create() throws CreateException;
}