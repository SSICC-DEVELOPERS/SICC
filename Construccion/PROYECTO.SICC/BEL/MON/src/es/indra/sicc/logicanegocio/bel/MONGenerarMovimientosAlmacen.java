package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOGMA;
public interface MONGenerarMovimientosAlmacen extends EJBObject  {
  public DTOSalida consultaAlmacen(DTOBelcorp dto) throws RemoteException, MareException;
  public void guardarGMA (DTOGMA dto) throws MareException, RemoteException;
}