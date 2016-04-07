package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTOProductoMatriz;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.pre.DTOEConsultarMF;
import es.indra.sicc.dtos.pre.DTOECopiarMF;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.dtos.pre.DTOECabeceraMF;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.pre.DTOObtenerProductoRecuperacion;
import es.indra.sicc.dtos.pre.DTOProductoReemplazo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.pre.DTOEValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import java.util.Hashtable;

public interface MONMantenimientoMFLocal extends EJBLocalObject 
{
    void actualizarMatrizFacturada(Long oidPeriodo, Boolean estado) throws MareException;

    DTOProductoMatriz buscaProductoEnMatriz(DTOProductoMatriz DTOE) throws MareException;

    Boolean buscarCodigoVenta(String codigoVenta, Long pais) throws MareException;

    DTOSalida buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto) throws MareException;

    DTOSalida buscarMFPeriodoActualYFuturo(DTOSiccPaginacion dto) throws MareException;

    DTOSalida buscarMFPeriodoAnterior(DTOSiccPaginacion dto) throws MareException;

    DTOSalida buscarProductosRegistro(DTOBuscarProductosRegistro dtoe) throws MareException;

    DTOSalida consultarCabeceraMF(DTOOID dto) throws MareException;

    DTOSalida consultarMF(DTOEConsultarMF dto) throws MareException;

    Integer contarCodigoVenta(Long pais, Long marca, Long canal, Long acceso, Long subacceso, String codigoVenta, Long codigoCatalogo) throws MareException;

    void copiarMF(DTOECopiarMF dto) throws MareException;

    void crearMF(DTOCabecCatal dto) throws MareException;

    void eliminarMF(DTOOID dto) throws MareException;

    void eliminarMatrizYOfertas(DTOOID dto) throws MareException;

    DTOOID guardarCabeceraMF(DTOECabeceraMF dto) throws MareException;

    Hashtable insertarProductoEnMatrizAgregados(DTOProductoMatriz dto) throws MareException;

    void modificarCabeceraMF(DTOECabeceraMF dto) throws MareException;

    DTOSalida obtenerCodigosVenta(DTOInfoProducto dtoe) throws MareException;

    Long obtenerFormaPagoMF(Long oidPeriodo, String codigoVenta) throws MareException;

    DTOSalida obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe) throws MareException;

    DTOProductoReemplazo obtenerProductoReemplazo(DTOProductoReemplazo dtoe) throws MareException;

    DTOSalida obtenerProductosAlternativos(Long oidPeriodo, String codigoVenta) throws MareException;

    DTOSalida obtenerVariantes(DTOBelcorp dto) throws MareException;

    DTOSValidarCodigoVenta validarCodVent(DTOEValidarCodigoVenta DTOE) throws MareException;

    DTOSValidarCodigoVenta validarCodigoVenta(DTOEValidarCodigoVenta DTOE) throws MareException;

    String insertarProductoEnMatriz(DTOProductoMatriz dto) throws MareException;

    DTOSalida buscarCodigoVentaPeriodo2(DTOBuscarCodigoVentaPeriodo dtoe) throws MareException;

    DTOSalida buscarCodigoVentaPeriodo3(DTOBuscarCodigoVentaPeriodo dtoe) throws MareException;

    DTOSalida obtenerTipoOfertaCopiar(DTOBelcorp dtoe) throws MareException;
}
