package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONProcesoFueraPedidoLocalHome extends EJBLocalHome 
{
  MONProcesoFueraPedidoLocal create() throws CreateException;
}