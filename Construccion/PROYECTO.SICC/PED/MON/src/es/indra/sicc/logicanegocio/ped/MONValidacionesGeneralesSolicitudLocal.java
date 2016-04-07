package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONValidacionesGeneralesSolicitudLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud validacionKO(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validacionOK(DTOCabeceraSolicitud DTOE) throws MareException;

    Boolean validarAcceso(Long tipoSolicitud) throws MareException;

    DTOCabeceraSolicitud validarAlmacen(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarCliente(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarCronograma(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarFormaPago(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarMoneda(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarSecuenciaProcesos(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarSolicitud(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarSubacceso(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarTipoFacturacion(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarTipoSolicitud(DTOCabeceraSolicitud DTOE) throws MareException;

    DTOCabeceraSolicitud validarZona(DTOCabeceraSolicitud DTOE) throws MareException;

    String armarMensajeError(String numeroSolicitud, String mensaje, String alternativo) throws MareException;
}