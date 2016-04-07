package es.indra.sicc.logicanegocio.msg;
import java.util.ArrayList;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.msg.DTOSeleccionMensajes;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.msg.DTOMensajeImpresion;
import es.indra.sicc.dtos.msg.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.msg.DTOMensajeMarca;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;



public interface MONImpresionMensajes extends EJBObject  {

	DTOImpresion[] imprimirMensajesFacturacion(DTOFACConsolidado DTOConsolidado) throws MareException, RemoteException;

	void imprimirMensajesDesdeEditor(DTOSeleccionMensajes DTOE) throws  RemoteException, MareException, RemoteException;

	DTOSalida consultarMensajesPorConsultora(DTOSeleccionMensajes DTOE) throws RemoteException, MareException;

	void actualizarMensajesFacturacion(ArrayList DTOE, Long numeroLote) throws  RemoteException, MareException, RemoteException;

	Boolean existeOrdenCompra(DTOFACConsolidado DTOE) throws  RemoteException, MareException, RemoteException;

	DTOMensajeImpresion[] obtenerMensajesG2(DTOMensajeImpresion[] DTOE) throws  RemoteException, MareException, RemoteException;

	DTOMensajeImpresion[] obtenerRestoMensajes(DTOMensajeImpresion[] DTOE) throws  RemoteException, MareException, RemoteException;

	DTOOIDs obtenerClientes(DTOMensajeImpresion[] DTOE) throws  RemoteException, MareException, RemoteException;

	DTOMensajeUnidadAdministrativa obtenerUACliente(Long oidCliente) throws RemoteException, MareException;

	DTOMensajeTipoCliente[] obtenerTipificacionCliente(DTOOID DTOE) throws RemoteException, MareException;

	DTOMensajeMarca[] obtenerMarcasCliente(Long oidCliente) throws  RemoteException, MareException, RemoteException;

	DTODocumento simularMensajes(DTOSeleccionMensajes DTOE) throws  RemoteException, MareException, RemoteException;

    Boolean existeCodigoVenta(DTOFACConsolidado DTOE, Long oidMensaje) throws MareException, RemoteException;

    DTOImpresion[] crearDTOMensajesFinal(Integer i, Long oidPeriodo, DTOOIDs dtoClientes, DTOMensajeImpresion[] DTOMensa, DTOMensajeImpresion[] dtoMensaG2) throws MareException, RemoteException;

    boolean validarDestinatarioUA(DTOBuzonMensajes dto) throws MareException, RemoteException;

    boolean validarDestinatarioTipoCliente(DTOBuzonMensajes dto) throws MareException, RemoteException;

}