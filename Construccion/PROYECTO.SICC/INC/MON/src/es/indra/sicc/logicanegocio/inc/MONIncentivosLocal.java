package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import java.util.ArrayList;

public interface MONIncentivosLocal extends EJBLocalObject 
{
    void actualizarDatosAnulacion(DTOSolicitudValidacion dtoSolicitudValidacion, Long periodoAnulacion) throws MareException;

    DTOEstatusSolicitud anularSolicitud(DTOSolicitudValidacion dtoSolicitud) throws MareException;

    DTOEstatusSolicitud calcularPuntajeMontoUnidades(DTOSolicitudValidacion solicitud) throws MareException;

    DTOEstatusSolicitud calcularPuntajeNumeroPedidos(DTOSolicitudValidacion solicitud) throws MareException;

    DTOEstatusSolicitud calcularPuntajeProgramaNuevas(DTOSolicitudValidacion solicitud) throws MareException;

    DTOEstatusSolicitud calcularPuntajeRecomendacion(DTOSolicitudValidacion solicitud) throws MareException;

    DTOEstatusSolicitud concursarSolicitud(DTOSolicitudValidacion solicitud) throws MareException;

    DTOEstatusSolicitud concursarSolicitudPorConcursos(DTOSolicitudValidacion solicitud, ArrayList arrConcursos) throws MareException;

    DTOEstatusSolicitud concursarSolicitudRanking(DTOSolicitudValidacion solicitud, Long oidConcurso) throws MareException;

    void rechazarSolicitudEnConcursoRanking(Solicitud solicitud, ArrayList concursos) throws MareException;

    DTOEstatusSolicitud revertirPuntajes(DTOSolicitudValidacion solicitudValidacion) throws MareException;

  void devolverSolicitud(DTOSolicitudValidacion dtoSolicitud) throws MareException;

  void procesarEvaluacionesDevolucion(Solicitud solicitud, ArrayList concursos) throws MareException;

  DTOEstatusSolicitud concursarSolicitudPorConcursosCierre(DTOSolicitudValidacion solicitud, ArrayList arrConcursos) throws MareException;

  void insertaCandidata(Long oidConcurso, Long oidLiente, Long periodo, int numerPeriodosEvaluados, boolean metasSuperadas, boolean requisitosSuperados) throws MareException;
}