package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.cal.DTOContacto;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.cal.DTOInterfazIVR;
import es.indra.sicc.dtos.cal.DTOCabeceraPedido;
import es.indra.sicc.dtos.cal.DTODetallePedido;
import es.indra.sicc.dtos.cal.DTOFichaCliente;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.cal.DTOBloqueoAdm;

public interface MONRecepcionLlamadasLocal extends EJBLocalObject 
{
    void actualizarContacto(DTOContacto dto) throws MareException;

    DTOOID guardarContacto(DTOCliente dtoE) throws MareException;

    DTOSalida obtenerAtributoEstado(DTOOID dto) throws MareException;

    DTOSalida obtenerCabeceraPedidoNoFacturado(DTOOIDPaginado DTOE) throws MareException;

    DTOSalida obtenerCabeceraPedidos(DTOOIDPaginado DTOE) throws MareException;

    DTOInterfazIVR obtenerClientePorTelefono(DTOInterfazIVR DTOE) throws MareException;

    DTOSalida obtenerClientes(DTOCliente DTOE) throws MareException;

    DTOSalida obtenerContactos(DTOCliente DTOE) throws MareException;

    DTOSalida obtenerCuentasCorrientes(DTOOIDPaginado DTOE) throws MareException;

    DTOCabeceraPedido obtenerDatosAdicionalesCabecera(DTOOID DTOE) throws MareException;

    DTODetallePedido obtenerDatosAdicionalesDetalle(DTOOID DTOE) throws MareException;

    DTOFichaCliente obtenerDatosFichaCliente(DTOCliente DTOE) throws MareException;

    DTOSalida obtenerDetalleCabecera(DTOOIDPaginado DTOE) throws MareException;

    DTOSalida obtenerDirecciones(DTOOIDPaginado DTOE) throws MareException;

    DTOSalida obtenerDocumentos(DTOOIDPaginado DTOE) throws MareException;

    DTOSalida obtenerEstadoContacto(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerTipoLlamada(DTOBelcorp dto) throws MareException;

    DTOSalida obtenerTiposCliente(DTOCodigoCliente DTOE) throws MareException;

    DTOSalida obtenerVinculos(DTOOIDPaginado DTOE) throws MareException;

    void realizarBloqueoAdministrativo(DTOOID DTOE) throws MareException;

    void guardarBloqueoAdm(DTOBloqueoAdm dtoGuardado) throws MareException;

    DTOSalida obtenerTiposBloqueo(DTOOID dtoEnt) throws MareException;

    DTOCliente obtenerIndicadorActivo(DTOCliente dtoe) throws MareException;
}
