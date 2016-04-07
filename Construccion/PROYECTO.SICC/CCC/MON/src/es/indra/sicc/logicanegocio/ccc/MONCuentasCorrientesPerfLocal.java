package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOBelcorp;

public interface MONCuentasCorrientesPerfLocal extends EJBLocalObject  {
  void generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto) throws MareException;

  Integer obtenerSecuenciaPais(DTOBelcorp dtoBelcorp) throws MareException;
  
}