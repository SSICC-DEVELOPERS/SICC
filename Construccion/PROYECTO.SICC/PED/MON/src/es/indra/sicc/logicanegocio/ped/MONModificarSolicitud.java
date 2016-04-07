package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ped.DTOInformacionSolicitud;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOInformacionBasicaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionClienteSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionAdministrativaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionEconomicaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionEstadoSolicitud;
import es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ped.DTOBuscarSolicitud;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

public interface MONModificarSolicitud extends EJBObject  {
  DTOInformacionSolicitud obtenerSolicitud(DTOOID dtoOid) throws MareException, RemoteException;

  DTOInformacionBasicaSolicitud crearDTOInformacionBasicaSolicitud(RecordSet resultado) throws MareException, RemoteException;

  DTOInformacionClienteSolicitud crearDTOInformacionClienteSolicitud(RecordSet resultado) throws MareException, RemoteException;

  DTOInformacionAdministrativaSolicitud crearDTOInformacionAdministrativaSolicitud(RecordSet resultado) throws MareException, RemoteException;

  DTOInformacionEconomicaSolicitud crearDTOInformacionEconomicaSolicitud(RecordSet resultado) throws MareException, RemoteException;

  DTOInformacionEstadoSolicitud crearDTOInformacionEstadoSolicitud(RecordSet resultado) throws MareException, RemoteException;

  DTOInformacionSolicitud consultarCabeceraSolicitud(DTOOID dtoOid) throws MareException, RemoteException;

  DTOSalida consultarPosicionesSolicitud(DTOConsultarPosicionesSolicitud dtoe) throws MareException, RemoteException;

  DTOSalida obtenerBloquesInformacionPosicion(DTOBelcorp dtoBelcorp) throws MareException, RemoteException;

  DTOSalida obtenerEstadosSolicitud(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida buscarSolicitud(DTOBuscarSolicitud dtoe) throws MareException, RemoteException;

  DTOSalida obtenerTiposSolicitudModificar(DTOBelcorp dtoe) throws MareException, RemoteException;

  void modificarCabecera(DTOCabeceraSolicitud dtoe) throws MareException, RemoteException;

  DTOCabeceraSolicitud modificarPosiciones(DTOCabeceraSolicitud dtoe) throws MareException, RemoteException;
}