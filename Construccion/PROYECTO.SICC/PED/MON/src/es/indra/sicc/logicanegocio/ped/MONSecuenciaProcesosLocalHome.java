package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSecuenciaProcesosLocalHome extends EJBLocalHome  {
  MONSecuenciaProcesosLocal create() throws CreateException;
}