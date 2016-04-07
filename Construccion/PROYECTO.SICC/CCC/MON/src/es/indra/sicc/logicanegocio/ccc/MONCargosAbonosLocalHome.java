package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCargosAbonosLocalHome extends EJBLocalHome 
{
  MONCargosAbonosLocal create() throws CreateException;
}