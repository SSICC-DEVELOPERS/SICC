package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ccc.DTOBloqueo;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.util.DTOBelcorp;

import javax.ejb.EJBLocalObject;

public interface MONCuentasCorrientesLocal extends EJBLocalObject 
{
  Integer obtenerSecuenciaPais(DTOBelcorp dtoBelcorp) throws MareException;

   void actualizarCuentaDos(DTOMovimientoCuentaCompleto movimientoCuenta) throws MareException;

   void insertarBloqueo(DTOBloqueo dto) throws MareException;

}