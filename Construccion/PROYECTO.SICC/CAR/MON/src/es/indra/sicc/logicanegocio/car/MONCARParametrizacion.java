package es.indra.sicc.logicanegocio.car;
import es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.car.DTOGrupoSolicitud;
import java.util.Vector;
import es.indra.sicc.dtos.car.DTOCriteriosGrupoSol;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.car.DTOAsignaciones;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.car.DTOTiposSolicitudenGrupo;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.car.DTOCriteriosCodigoConf;
import es.indra.sicc.dtos.car.DTOEjecutivo;
import es.indra.sicc.dtos.car.DTOCriteriosEjecutivo;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.car.DTOUsuarioJerarquia;
import es.indra.sicc.dtos.car.DTOEliminarCodigoConf;

public interface MONCARParametrizacion extends EJBObject  {

	 //void actualizarTiposSolicitud(DTOGrupoSolicitud dtoin) throws RemoteException, MareException;

	DTOSalida buscarGruposSolicitud(DTOCriteriosGrupoSol dtoin) throws RemoteException, MareException;

	 void eliminarGrupoSolicitud(DTOOIDs dtoin) throws RemoteException, MareException;

	DTOGrupoSolicitud consultarGrupoSolicitud(DTOOID dtoin) throws RemoteException, MareException;

	 //void actualizarDescripcion(Vector attriTraducible) throws RemoteException, MareException;

	 //void eliminarDescripcion(Long oid) throws RemoteException, MareException;

	DTOSalida obtenerTiposSolicitud(DTOTiposSolicitudenGrupo dtoin) throws RemoteException, MareException;

	//void  desasignarTiposSolicitud(Long oidTipoSolicitud, DTOOIDs dtoin) throws RemoteException, MareException;

	DTOSalida obtenerNivelesRiesgo(DTOOID dtoin) throws RemoteException, MareException;

	DTOSalida obtenerGruposSolicitud(DTOFiltroGrupoSolicitud dtoin) throws RemoteException, MareException;

	DTOSalida obtenerIndicadoresValidacion(DTOBelcorp dtoin) throws RemoteException, MareException;

	DTOSalida obtenerCodigosConfiguracion(DTOBelcorp dtoin) throws RemoteException, MareException;

	 void guardarCodigoConf(DTOCodigoConfiguracion dtoin) throws RemoteException, MareException;

	 void guardarAsignacionesCod(DTOAsignaciones dtoin) throws RemoteException, MareException;

	 void eliminarAsignaciones(DTOEliminarCodigoConf dtoin) throws RemoteException, MareException;

	DTOCodigoConfiguracion consultarCodigoConf(DTOOID dtoin) throws RemoteException, MareException;

	DTOSalida buscarCodigosConf(DTOCriteriosCodigoConf dtoin) throws RemoteException, MareException;

	void guardarEjecutivo(DTOEjecutivo dtoin) throws RemoteException, MareException;

	DTOSalida buscarEjecutivos(DTOCriteriosEjecutivo dtoin) throws RemoteException, MareException;

	void eliminarEjecutivos(DTOOIDs dtoin) throws RemoteException, MareException;

	DTOEjecutivo consultaEjecutivo(DTOOID dtoin) throws RemoteException, MareException;

	void guardarAsignacionesEjecutivo(DTOAsignaciones dtoin) throws RemoteException, MareException;

	DTOSalida obtenerJerarquias(DTOBelcorp dtoin) throws RemoteException, MareException;

	DTOSalida obtenerEjecutivos(DTOBelcorp dtoin) throws RemoteException, MareException;

	void guardarGrupoSolicitud(DTOGrupoSolicitud grupoSol) throws RemoteException, MareException;

	DTOSalida obtenerCodigosAprobacion(DTOBelcorp dtoin) throws RemoteException, MareException;

	DTOSalida obtenerEstatusPedidos(DTOBelcorp dtoin) throws RemoteException, MareException;

	DTOUsuarioJerarquia obtenerJerarquiaUsuario(DTOUsuarioJerarquia dtoin) throws RemoteException, MareException;

    DTOSalida obtenerGruposSolicitud(DTOOID dtoin) throws RemoteException, MareException;

  DTOSalida buscarAsignacionesCodigoConf(DTOOID dtoin) throws MareException, RemoteException;


}