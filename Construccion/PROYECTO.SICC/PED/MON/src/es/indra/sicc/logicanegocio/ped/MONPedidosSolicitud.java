package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import java.math.BigDecimal;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;

public interface MONPedidosSolicitud extends EJBObject 
{
  Boolean haPasadoPedidoPeriodo(Long cliente, Long periodoActual, Boolean esFacturada) throws RemoteException, MareException;

  BigDecimal calcularPedidoPromedio(DTOCalculoPedidos dto) throws MareException, RemoteException;

  Integer calcularPeriodosPedido(DTOCalculoPedidos dto) throws MareException, RemoteException;

  DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws RemoteException, MareException;

  DTOSalida obtenerPosicionesReclamo(DTOOID dto) throws RemoteException, MareException;

  DTOSalida obtenerIndicadoresRevision(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida obtenerPosicionesReclamoAnulacion(DTOOID DTOOID) throws RemoteException, MareException;


}