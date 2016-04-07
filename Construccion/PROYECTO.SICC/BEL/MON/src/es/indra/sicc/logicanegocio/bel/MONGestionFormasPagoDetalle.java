package es.indra.sicc.logicanegocio.bel;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

public interface MONGestionFormasPagoDetalle extends EJBObject  {
  RecordSet obtenerFormasPagoPorPais(DTOBelcorp dto) throws MareException, RemoteException;
}
