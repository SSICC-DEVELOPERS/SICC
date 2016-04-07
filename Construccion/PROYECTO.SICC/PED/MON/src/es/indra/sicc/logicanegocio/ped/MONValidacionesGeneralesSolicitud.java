package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

public interface MONValidacionesGeneralesSolicitud extends EJBObject  {
    Boolean validarAcceso(Long tipoSolicitud) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarSubacceso(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validacionKO(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validacionOK(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarTipoSolicitud(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarAlmacen(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarFormaPago(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarTipoFacturacion(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarCronograma(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarZona(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarMoneda(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarCliente(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarSecuenciaProcesos(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    DTOCabeceraSolicitud validarSolicitud(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;

    String armarMensajeError(String numeroSolicitud, String mensaje, String alternativo) throws RemoteException, MareException;
}