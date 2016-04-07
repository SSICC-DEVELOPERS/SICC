package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGenerarMovimientoAlmacenLocalHome extends EJBLocalHome  {
  MONGenerarMovimientoAlmacenLocal create() throws CreateException;
}