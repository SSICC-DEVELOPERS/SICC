package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ped.DTOLoteSolicitudes;
import es.indra.sicc.dtos.ped.DTORegistrarSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudRegistro;

public interface MONRegistrarSolicitud extends EJBObject  {
  void validarProcesoRegistro(DTOOID dtoe) throws MareException, RemoteException;

  DTOLoteSolicitudes grabarLote(DTOLoteSolicitudes dtoe) throws MareException, RemoteException;

  DTOOID generarNumeroDocumento(DTOOID dtoOid) throws MareException, RemoteException;

  void registrarClienteSolicitud(DTORegistrarSolicitud dtoRegistrarSolicitud, Long oidLote) throws MareException, RemoteException;

  DTOLoteSolicitudes validarClientes(DTOLoteSolicitudes dtoe) throws MareException, RemoteException;

  DTOTipoSolicitudRegistro obtenerValoresAsociadosTipoSolicitud(DTOTipoSolicitudRegistro dtoe) throws MareException, RemoteException;
}