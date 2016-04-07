package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOBuscarSolicitudVerificacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOObtenerPosicionesVerificacion;

public interface MONVerificarSolicitud extends EJBObject  {
    DTOSalida buscarSolicitud(DTOBuscarSolicitudVerificacion dtoe) throws MareException, RemoteException;

    void consolidarPosiciones(DTOCabeceraSolicitud dtoe) throws MareException, RemoteException;

    DTOSalida obtenerPosicionesVerificacion(DTOObtenerPosicionesVerificacion dtoe) throws MareException, RemoteException;

    void actualizarCabeceraVerificacion(DTOCabeceraSolicitud dtoe) throws MareException, RemoteException;

}