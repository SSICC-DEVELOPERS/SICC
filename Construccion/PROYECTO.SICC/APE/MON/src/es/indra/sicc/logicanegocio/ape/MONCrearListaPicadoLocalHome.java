package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCrearListaPicadoLocalHome extends EJBLocalHome  {
  MONCrearListaPicadoLocal create() throws CreateException;
}