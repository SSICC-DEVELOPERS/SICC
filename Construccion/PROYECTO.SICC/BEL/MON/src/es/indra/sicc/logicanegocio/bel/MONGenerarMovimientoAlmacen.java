package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.bel.DTOGrabarStock;
public interface MONGenerarMovimientoAlmacen extends EJBObject  {
	public DTOReportePedidos grabarMovimientoAlmacenYStock (DTOMovimientoAlmacen dto)  throws RemoteException, MareException;

	void reversionMovimientoAlmacen(DTOReversionMovimiento dto) throws RemoteException, MareException;

  DTOGrabarStock grabarStock(DTOGrabarStock dtoGrabarStock) throws MareException, RemoteException;
}