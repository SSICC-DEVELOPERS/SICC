package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;

public interface MONCuentasCorrientesPerf extends EJBObject  {
  void generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto) throws MareException, RemoteException;

  Integer obtenerSecuenciaPais(DTOBelcorp dtoBelcorp) throws MareException, RemoteException;

 
}