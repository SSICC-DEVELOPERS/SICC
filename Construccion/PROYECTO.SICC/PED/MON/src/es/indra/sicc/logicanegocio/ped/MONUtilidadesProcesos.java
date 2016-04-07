package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import javax.ejb.CreateException;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;
import es.indra.sicc.dtos.ped.DTOAtributoEspecial;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

public interface MONUtilidadesProcesos extends EJBObject  {
	DTOSalida consultaTipoSolicitudPais(DTOBelcorp dto) throws RemoteException, MareException;

	DTOSalida consultaClasesSolicitud(DTOBelcorp dto) throws RemoteException, MareException;

	DTOSalida consultaTiposPosicion(DTOBelcorp dto) throws RemoteException, MareException;

	DTOSalida consultaSubtiposPosicion(DTOOID dto) throws MareException, RemoteException;

  DTOSalida consultaGruposProcesos(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida consultaCodigosProcesos(DTOOID dto) throws MareException, RemoteException;

  DTOSalida consultaAtributosEspeciales(DTOAtributoEspecial dto) throws  CreateException, MareException, RemoteException;

	DTOSalida consultaTiposConsolidado(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida consultaTiposSolicitud(DTOBelcorp dto) throws MareException, RemoteException;

	DTOSalida consultaTiposDespacho(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida consultaClasesSolicitudOrdenCompra(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto) throws RemoteException, MareException;

  DTOSalida obtenerTipoSolicitudPorClase(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida consultaTipoSolicitudPaisConsolidadas(DTOBelcorp dto) throws MareException, RemoteException;

}