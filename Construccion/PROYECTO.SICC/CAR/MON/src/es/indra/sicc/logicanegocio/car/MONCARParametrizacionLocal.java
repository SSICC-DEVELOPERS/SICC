package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.car.DTOCriteriosCodigoConf;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.car.DTOCriteriosEjecutivo;
import es.indra.sicc.dtos.car.DTOCriteriosGrupoSol;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.car.DTOEjecutivo;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.car.DTOGrupoSolicitud;
import es.indra.sicc.dtos.car.DTOEliminarCodigoConf;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.car.DTOAsignaciones;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud;
import es.indra.sicc.dtos.car.DTOUsuarioJerarquia;
import es.indra.sicc.dtos.car.DTOTiposSolicitudenGrupo;

public interface MONCARParametrizacionLocal extends EJBLocalObject 
{
    DTOSalida buscarCodigosConf(DTOCriteriosCodigoConf dtoin) throws MareException;

    DTOSalida buscarEjecutivos(DTOCriteriosEjecutivo dtoin) throws MareException;

    DTOSalida buscarGruposSolicitud(DTOCriteriosGrupoSol dtoin) throws MareException;

    DTOEjecutivo consultaEjecutivo(DTOOID dtoin) throws MareException;

    DTOCodigoConfiguracion consultarCodigoConf(DTOOID dtoin) throws MareException;

    DTOGrupoSolicitud consultarGrupoSolicitud(DTOOID dtoin) throws MareException;

    void eliminarAsignaciones(DTOEliminarCodigoConf dtoin) throws MareException;

    void eliminarEjecutivos(DTOOIDs dtoin) throws MareException;

    void eliminarGrupoSolicitud(DTOOIDs dtoin) throws MareException;

    void guardarAsignacionesCod(DTOAsignaciones dtoin) throws MareException;

    void guardarAsignacionesEjecutivo(DTOAsignaciones dtoin) throws MareException;

    void guardarCodigoConf(DTOCodigoConfiguracion dtoin) throws MareException;

    void guardarEjecutivo(DTOEjecutivo dtoin) throws MareException;

    void guardarGrupoSolicitud(DTOGrupoSolicitud grupoSol) throws MareException;

    DTOSalida obtenerCodigosAprobacion(DTOBelcorp dtoin) throws MareException;

    DTOSalida obtenerCodigosConfiguracion(DTOBelcorp dtoin) throws MareException;

    DTOSalida obtenerEjecutivos(DTOBelcorp dtoin) throws MareException;

    DTOSalida obtenerEstatusPedidos(DTOBelcorp dtoin) throws MareException;

    DTOSalida obtenerGruposSolicitud(DTOFiltroGrupoSolicitud dtoin) throws MareException;

    DTOSalida obtenerGruposSolicitud(DTOOID dtoin) throws MareException;

    DTOSalida obtenerIndicadoresValidacion(DTOBelcorp dtoin) throws MareException;

    DTOUsuarioJerarquia obtenerJerarquiaUsuario(DTOUsuarioJerarquia dtoin) throws MareException;

    DTOSalida obtenerJerarquias(DTOBelcorp dtoin) throws MareException;

    DTOSalida obtenerNivelesRiesgo(DTOOID dtoin) throws MareException;

    DTOSalida obtenerTiposSolicitud(DTOTiposSolicitudenGrupo dtoin) throws MareException;

    DTOSalida buscarAsignacionesCodigoConf(DTOOID dtoin) throws MareException;
}