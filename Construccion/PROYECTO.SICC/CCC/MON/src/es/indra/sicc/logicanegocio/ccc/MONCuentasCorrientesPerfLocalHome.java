package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuentasCorrientesPerfLocalHome extends EJBLocalHome  {
  MONCuentasCorrientesPerfLocal create() throws CreateException;
}