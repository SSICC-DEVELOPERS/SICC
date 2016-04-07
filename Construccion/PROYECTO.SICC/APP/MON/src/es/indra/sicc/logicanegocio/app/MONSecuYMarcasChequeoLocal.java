package es.indra.sicc.logicanegocio.app;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.app.DTOSolicCabecSecu;

public interface MONSecuYMarcasChequeoLocal extends EJBLocalObject 
{
    DTOFACConsolidado[] generarMarcasChequeo(DTOFACConsolidado[] dtoE) throws MareException;

    DTOFACCabeceraSolicitud[] generarSecuenciacionPorMonitor(DTOFACCabeceraSolicitud[] dtoE) throws MareException;

    DTOFACCabeceraSolicitud[] generarSecuenciacionPorRutas(DTOFACCabeceraSolicitud[] dtoE) throws MareException;

    void actualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE) throws MareException;

  void reversarActualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE) throws MareException;

    void generarMarcasChequeo(DTOFACConsolidado consolidado) throws MareException;

    DTOFACCabeceraSolicitud[] generarSecuenciacionPorCliente(DTOFACCabeceraSolicitud[] dtoE, Character indicadorSecuenciacion) throws MareException;
}