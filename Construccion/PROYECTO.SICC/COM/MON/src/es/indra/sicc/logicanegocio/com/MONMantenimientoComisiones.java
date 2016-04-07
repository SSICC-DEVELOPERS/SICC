package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.com.DTORepCargaComision;
import es.indra.sicc.dtos.com.DTOObtenerTramos;

public interface MONMantenimientoComisiones extends EJBObject {
  
  DTOComisiones consultarComisiones(DTOOID dto) throws MareException, RemoteException;

  void guardarComisiones(DTOComisiones dto) throws MareException, RemoteException;

  DTOSalida obtenerTiposClienteCOM(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTiposParticipantes(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTiposComisionesVenta(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTiposComisionesVentaIncremental(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerFormulas(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida recCargaComision(DTORepCargaComision dtoIn) throws MareException, RemoteException;


    void calcularMetas(DTOOID dtoE) throws MareException, RemoteException;

  DTOSalida obtenerTramos(DTOOID dtoIn) throws RemoteException, MareException;

  DTOSalida obtenerComisiones(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTramosPorComisionyPeriodo(DTOObtenerTramos dto) throws MareException, RemoteException;

  DTOSalida obtenerPeriodosPorComision(DTOOID dto) throws MareException, RemoteException;
  
}