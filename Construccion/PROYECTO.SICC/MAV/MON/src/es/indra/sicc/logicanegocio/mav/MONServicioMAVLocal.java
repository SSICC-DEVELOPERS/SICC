package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mav.DTOActividadMAV;

public interface MONServicioMAVLocal extends EJBLocalObject 
{
    DTOSalida obtenerCiclosVidaActividad(DTOOID dto) throws MareException;

    DTOSalida obtenerCriteriosAsignacion() throws MareException;

    DTOSalida obtenerEnvioConSolicitud() throws MareException;

    DTOSalida obtenerEstadosMAVActividad(DTOOID dto) throws MareException;

    DTOSalida obtenerEstadosMAV(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerFormaCobro(DTOOID dtoOid) throws MareException;

    DTOSalida obtenerTiposDespacho() throws MareException;

    DTOSalida obtenerTiposDespachoActividad(DTOOID dto) throws MareException;

    DTOSalida obtenerTiposOfertaActividad(DTOOID dto) throws MareException;

    DTOSalida obtenerTiposCondicionPago() throws MareException;

    DTOSalida obtieneActividadesMAV(DTOActividadMAV dto) throws MareException;

    DTOSalida obtieneMensajesTipoDespacho(DTOOID dto) throws MareException;

    DTOSalida obtieneTiposClienteActividad(DTOOID dto) throws MareException;

    DTOSalida obtieneSubcriteriosPorCriterio(DTOOID dto) throws MareException;

    DTOSalida obtieneEstadosEnvio(DTOBelcorp dto) throws MareException;

    DTOSalida obtieneFormasPagoActividad(DTOOID dtoOid) throws MareException;

    DTOSalida obtieneTiposEstadoProceso(DTOBelcorp dto) throws MareException;

  DTOSalida obtenerTiposDespachoIniFinPeriodo() throws MareException;
}