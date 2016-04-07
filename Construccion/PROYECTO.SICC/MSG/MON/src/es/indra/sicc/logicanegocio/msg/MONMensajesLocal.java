package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.msg.DTOMensaje;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.msg.DTODestinatario;
import es.indra.sicc.dtos.msg.DTOMensajeCliente;
import es.indra.sicc.dtos.msg.DTOMensajeCodigoVenta;
import es.indra.sicc.dtos.msg.DTOMensajeMarca;
import java.util.Vector;
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public interface MONMensajesLocal extends EJBLocalObject 
{
    DTOSalida buscarMensajes(DTOMensaje DTOE) throws MareException;

    DTOBoolean comprobarDestinatariosExcluyentes(DTOOIDs DTOE) throws MareException;

    DTOBoolean comprobarMensajeCodigoVenta(DTODestinatario DTOE) throws MareException;

    DTOMensajeCliente crearDTOMensajeCliente(Long oid, Long cliente) throws MareException;

    DTOMensajeCodigoVenta crearDTOMensajeCodigoVenta(Long oid, String codigo) throws MareException;

    DTOMensajeMarca crearDTOMensajeMarca(Long oid, Long marca) throws MareException;

    DTOMensajeTipoCliente crearDTOMensajeTipoCliente(Vector fila) throws MareException;

    DTOMensajeUnidadAdministrativa crearDTOMensajeUnidadAdministrativa(Vector fila) throws MareException;

    void eliminarDestinatarioMensaje(Long oidMensaje) throws MareException;

    void eliminarMensaje(DTOOIDs DTOE) throws MareException;

    DTODestinatario generarMensajeCliente(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    DTODestinatario generarMensajeCodigoVenta(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    DTODestinatario generarMensajeMarca(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    DTODestinatario generarMensajePedido(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    DTODestinatario generarMensajePrograma(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    DTODestinatario generarMensajeTipoCliente(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    DTODestinatario generarMensajeUnidadAdministrativa(Long oidMensaje, DTODestinatario DTOE) throws MareException;

    void guardarDestinatarioExcluyente(DTODestinatario dto) throws MareException;

    void guardarDestinatarioMensaje(DTODestinatario DTOE) throws MareException;

    DTOOID guardarMensaje(DTOMensaje DTOE) throws MareException;

    void guardarTipoDestinatario(Long tipo, Long mensaje) throws MareException;

    void modificarDestinatarioExcluyente(DTODestinatario dto) throws MareException;

    void modificarDestinatarioMensaje(DTODestinatario DTOE) throws MareException;

    DTOOID modificarMensaje(DTOMensaje DTOE) throws MareException;

    RecordSet obtenerCodigosMensajesPorPais(DTOBelcorp dtoe) throws MareException;

    DTODestinatario obtenerDatosDestinatario(DTOOID DTOE) throws MareException;

    DTOMensaje obtenerMensaje(DTOOID DTOE) throws MareException;

    DTOSalida obtenerMensajesPorPais(DTOSiccPaginacion DTOE) throws MareException;

    DTOSalida obtenerMetacaracteres(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerTiposDestinatario(DTOBelcorp DTOE) throws MareException;

    Vector obtenerTiposDestinatarioMensaje(Long oidMensaje) throws MareException;

    DTOSalida obtenerTiposGeneracionDatos(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerTiposMensaje(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerTiposPermanencia(DTOBelcorp DTOE) throws MareException;
}