package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
public interface MONGestionMedioPagoBelCenter extends EJBObject  {
	Long obtenerOidMedioPago(Long pais, String codigo) throws MareException, RemoteException;

	DTOSalida obtenerMediosPagoCombo(DTOBelcorp dto) throws MareException, RemoteException;
}