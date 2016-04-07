package es.indra.sicc.logicanegocio.cal;
import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cal.DTOCargarOID;
import es.indra.sicc.dtos.cal.DTOIngresoConsultora;
import es.indra.sicc.dtos.cal.DTODatosClien;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;


import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cal.DTOReclamo;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import es.indra.sicc.dtos.cal.DTOConsultaGerente;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;

public interface MONContactos extends EJBObject 
{
    DTOSalida consultarProgramasLanzamiento(DTOSiccPaginacion dto) throws RemoteException, MareException;

  DTOSalida cargarContactos(DTOCargarOID dto) throws RemoteException, MareException;

  DTOSalida cargarMotivosTipoCliente(DTOCargarOID dto) throws RemoteException, MareException;

  DTOSalida obtenerZonaMarcaCanal(DTOOID dto) throws RemoteException, MareException;

  void insertarReclamos(DTOReclamo DTOE) throws RemoteException, MareException;

    DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws RemoteException, MareException;

    DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws RemoteException, MareException;

  DTOSalida detalleInformacionProducto(DTOOID dtoOid) throws RemoteException, MareException;

    DTOSalida obtenerDatosGerente(DTOConsultaGerente entrada) throws RemoteException, MareException;

    DTOSalida obtenerCodUsuario(DTOBelcorp DTOE) throws RemoteException, MareException;

    DTOSalida obtenerBuzonUsuario(DTOCliente DTOE) throws RemoteException, MareException;

  DTOSalida consultarGerente(DTOOID dto) throws RemoteException, MareException;

  DTOSalida buscarStockProducto(DTOBuscarStockProducto dto) throws RemoteException, MareException;

    DTOSalida consultarNombresCliente(DTOOID oidCliente) throws RemoteException, MareException;
    DTOSalida consultarConsultorasHijas(DTOOID datosCliente) throws RemoteException, MareException;
    DTOSalida obtenerStatusConsultora (DTOIngresoConsultora entrada) throws RemoteException, MareException;
    DTOSalida obtenerHistoricoDatos (DTOIngresoConsultora entrada) throws MareException, RemoteException;
    DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws RemoteException, MareException;
    DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws RemoteException, MareException;

   DTOSalida consultarClasificacion(DTODatosClien DTOE) throws RemoteException, MareException;

  DTOSalida obtenerMotivosContacto(DTOBelcorp dto) throws RemoteException, MareException;

}