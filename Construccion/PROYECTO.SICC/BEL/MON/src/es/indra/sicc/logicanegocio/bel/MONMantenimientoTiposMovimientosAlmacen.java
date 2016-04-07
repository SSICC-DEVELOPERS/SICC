package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.bel.DTOEBuscarTiposMovimientosAlmacen;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
public interface MONMantenimientoTiposMovimientosAlmacen extends EJBObject  {
	public DTOSalida buscarTiposMovimientosAlmacen (DTOEBuscarTiposMovimientosAlmacen dto) throws MareException,RemoteException;
	public void eliminarTiposMovimientosAlmacen (DTOOIDs dto) throws MareException,RemoteException;
	public void guardarTipoMovimientoAlmacen (DTOTipoMovimientoAlmacen dto) throws MareException,RemoteException;
	public  DTOTipoMovimientoAlmacen consultarTipoMovimientoAlmacen (DTOOID dto) throws MareException,RemoteException;
	public DTOSalida obtenerTiposMovimientosAlmacen (DTOBelcorp dto) throws MareException,RemoteException;

    DTOSalida obtenerTiposMovimientosIndicadorSAP(DTOBelcorp dto) throws MareException, RemoteException;
}