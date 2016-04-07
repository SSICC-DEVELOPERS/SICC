package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOP;
import es.indra.sicc.util.DTOBelcorp;

public interface MONTiposSolicitudPais extends EJBObject  {
	void elimina(DTOOIDs dto) throws MareException, RemoteException;

	void guarda(DTOTipoSolicitudPais dto) throws MareException, RemoteException;

	DTOSalida consulta(DTOTipoSolicitudPais dto) throws MareException, RemoteException;

	DTOTipoSolicitudPais consultaDetalles(DTOOID dto) throws MareException, RemoteException;

	DTOSalida obtieneTipoCliente(DTOOID dto) throws MareException, RemoteException;

	DTOSalida obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto) throws MareException, RemoteException;

	DTOSalida obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto) throws MareException, RemoteException;

  DTOTipoSolicitudOP obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto) throws MareException, RemoteException;

  DTOSalida obtenerTipoSolicitudPaisREP(DTOBelcorp dto) throws MareException, RemoteException;
}