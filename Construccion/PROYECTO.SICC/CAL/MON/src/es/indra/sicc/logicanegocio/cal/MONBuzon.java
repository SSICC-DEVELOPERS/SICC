package es.indra.sicc.logicanegocio.cal;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTORedirigirDetalle;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;

public interface MONBuzon extends EJBObject  {
  DTOSalida obtenerCabeceraBuzon(DTOBusqueda dtoe) throws RemoteException, MareException;
  void insertarCabeceraBuzon(DTOCabecera dtoe) throws RemoteException, MareException;
  void insertarDetalleBuzon(DTODetalle dtoe) throws RemoteException, MareException;
  DTOSalida obtenerDetalleBuzon(DTOBusqueda dtoe) throws RemoteException, MareException;
  void procesarActividad(DTODetalle dtoe) throws RemoteException, MareException;
  void redirigirActividad(DTORedirigirDetalle dtoe) throws RemoteException, MareException;
  DTOSalida obtenerContactosPorCliente(DTOCliente dtoe) throws RemoteException, MareException;
  DTOSalida obtenerCodBuzon(DTOBelcorp dtoe) throws RemoteException, MareException;
  DTOSalida obtenerGestiones(DTOBelcorp dtoe) throws RemoteException, MareException;

  DTOSalida obtenerCabeceraBuzonCombo(DTOBelcorp dto) throws RemoteException, MareException;

  Long obtenerNumeroSecuencialProximoDetalle(Long oidBuzon) throws RemoteException, MareException;
}