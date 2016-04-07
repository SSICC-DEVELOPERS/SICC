package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;
import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;
import es.indra.sicc.dtos.cal.DTOCargarOID;
import es.indra.sicc.dtos.cal.DTODatosClien;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cal.DTOReclamo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTOConsultaGerente;
import es.indra.sicc.dtos.cal.DTOIngresoConsultora;

public interface MONContactosLocal extends EJBLocalObject 
{
    DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws MareException;

    DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws MareException;

    DTOSalida buscarStockProducto(DTOBuscarStockProducto dto) throws MareException;

    DTOSalida cargarContactos(DTOCargarOID dto) throws MareException;

    DTOSalida cargarMotivosTipoCliente(DTOCargarOID dto) throws MareException;

    DTOSalida consultarClasificacion(DTODatosClien DTOE) throws MareException;

    DTOSalida consultarConsultorasHijas(DTOOID datosCliente) throws MareException;

    DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws MareException;

    DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws MareException;

    DTOSalida consultarGerente(DTOOID dto) throws MareException;

    DTOSalida consultarNombresCliente(DTOOID oidCliente) throws MareException;

    DTOSalida consultarProgramasLanzamiento(DTOSiccPaginacion dto) throws MareException;

    DTOSalida detalleInformacionProducto(DTOOID dtoOid) throws MareException;

    void insertarReclamos(DTOReclamo dtoE) throws MareException;

    DTOSalida obtenerCodUsuario(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerBuzonUsuario(DTOCliente DTOE) throws MareException;

    DTOSalida obtenerDatosGerente(DTOConsultaGerente entrada) throws MareException;

    DTOSalida obtenerHistoricoDatos(DTOIngresoConsultora datosCliente) throws MareException;

    DTOSalida obtenerMotivosContacto(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerStatusConsultora(DTOIngresoConsultora entrada) throws MareException;

    DTOSalida obtenerZonaMarcaCanal(DTOOID dto) throws MareException;
}