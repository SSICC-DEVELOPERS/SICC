package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOValoresDefecto;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTOBuscarSolicitudesDTO;
import es.indra.sicc.dtos.ped.DTOPeriodoDocumentoReferencia;

public interface MONDigitacionInicial extends EJBObject  {
	DTOValoresDefecto obtenerValoresDefecto(DTOValoresDefecto DTOE) throws RemoteException, MareException;

	DTOSalida obtenerTipoDespacho(DTOBelcorp DTOE) throws RemoteException, MareException;

	DTOSalida obtenerAccesoFisico(DTOBelcorp DTOE) throws RemoteException, MareException;

	DTOSalida obtenerTiposSolicitudDigitacionVD(DTOBelcorp DTOE) throws RemoteException, MareException;

    DTOPeriodoDocumentoReferencia obtenerPeriodoDocumentoReferencia(DTOOID dtoe) throws RemoteException, MareException;

    DTOSalida buscarSolicitudesDTO(DTOBuscarSolicitudesDTO dtoe) throws RemoteException, MareException;

	DTOCabeceraSolicitud grabarSolicitud(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud guardarSolicitud(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

  DTOSalida obtenerTiposSolicitudPaisNoConsolidados(DTOBelcorp dtoe) throws RemoteException, MareException;
}