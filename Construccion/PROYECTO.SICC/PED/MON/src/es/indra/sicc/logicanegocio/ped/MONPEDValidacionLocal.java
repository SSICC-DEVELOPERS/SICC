package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.ped.DTOSolicitudReversion;

public interface MONPEDValidacionLocal extends EJBLocalObject 
{
    DTOEstatusSolicitud calcularTotales(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud generarMensajesFaltantesAnunciados(DTOSolicitudValidacion dto) throws MareException;

    void generarPedidosServicioRecuperaciones(DTOFACProcesoCierre dtoProcesoCierre) throws MareException;

    DTOEstatusSolicitud recuperacionObligatoria(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud recuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud recuperacionVoluntaria(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud recuperarDatosAnulaciones(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud reversionLineaCredito(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud reversionMensajesFaltantesAnunciados(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud reversionRecuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud reversionRecuperacionObligatoriaMismoPeriodoVenta(DTOSolicitudValidacion dto, String codigoVenta) throws MareException;

    DTOEstatusSolicitud revertirAgregados(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirAgregadosCV(DTOSolicitudReversion dto) throws MareException;

    DTOEstatusSolicitud revertirAsignacionStock(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirControlLiquidacion(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirControlStock(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirDescuentos(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirFlete(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud revertirLimiteVenta(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud revertirMontoMinimo(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud revertirPrecios(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirRecuperacionObligatoria(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirRecuperacionObligatoriaVenta(DTOSolicitudValidacion dto, String codigoVenta) throws MareException;

    DTOEstatusSolicitud revertirRecuperacionVoluntaria(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirRecuperacionVoluntariaVenta(DTOSolicitudValidacion dto, String codigoVenta) throws MareException;

    DTOEstatusSolicitud validarAgregados(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarAsignacionStock(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarControlLiquidacion(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarControlStock(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarDescuento(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarFlete(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud validarLimiteVenta(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud validarLineaCredito(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud validarMontoMinimo(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud validarPreciosMaestroProducto(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarPreciosMatriz(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud revertirCalcularTotales(DTOSolicitudValidacion dto) throws MareException;

    void desbloquearMM(Long oidPais, Long oidMarca) throws MareException;

    void bloquearCliente(DTOSolicitudValidacion dtoin) throws MareException;

    DTOEstatusSolicitud actualizarPeriodoPrimerContacto(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarDescuento2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarCuadreOfertas2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud recuperacionObligatoria2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud calcularMontoMaximo2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud calcularMontoMinimo2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud insertarOfertasEspeciales(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarAgregados2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud calcularMontoMinimoIncentivos(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud insertarOfertasEspeciales2(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarCuadreOfertas3(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarCuadreOfertas4(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud eliminarProductosFaltantesProlIndividual(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud eliminarProductosFaltantesProlCompuesta(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud evaluarExigenciasVentas(DTOSolicitudValidacion dto) throws MareException;
}
