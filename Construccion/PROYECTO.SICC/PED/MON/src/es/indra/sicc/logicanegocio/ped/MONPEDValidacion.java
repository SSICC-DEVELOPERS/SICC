package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudReversion;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;

import java.rmi.RemoteException;

import java.util.Hashtable;

import javax.ejb.EJBObject;


public interface MONPEDValidacion extends EJBObject {
    DTOEstatusSolicitud validarPreciosMatriz(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarPreciosMaestroProducto(
        DTOSolicitudValidacion dto) throws RemoteException, MareException;

    public DTOEstatusSolicitud revertirPrecios(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirDescuentos(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarDescuento(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarControlStock(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirControlStock(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarControlLiquidacion(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarAsignacionStock(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirAsignacionStock(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud generarMensajesFaltantesAnunciados(
        DTOSolicitudValidacion dto) throws RemoteException, MareException;

    DTOEstatusSolicitud revertirControlLiquidacion(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirFlete(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarFlete(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud recuperarDatosAnulaciones(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirLimiteVenta(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirMontoMinimo(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarMontoMinimo(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarLimiteVenta(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud recuperacionObligatoria(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud recuperacionVoluntaria(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirRecuperacionObligatoria(
        DTOSolicitudValidacion dto) throws RemoteException, MareException;

    DTOEstatusSolicitud revertirRecuperacionVoluntaria(
        DTOSolicitudValidacion dto) throws RemoteException, MareException;

    DTOEstatusSolicitud validarAgregados(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud revertirAgregados(DTOSolicitudValidacion dto)
        throws RemoteException, MareException;

    DTOEstatusSolicitud validarLineaCredito(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud reversionLineaCredito(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

    DTOEstatusSolicitud calcularTotales(DTOSolicitudValidacion dtoin)
        throws RemoteException, MareException;

	DTOEstatusSolicitud recuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws RemoteException, MareException;

	DTOEstatusSolicitud reversionRecuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws RemoteException, MareException;

	DTOEstatusSolicitud reversionRecuperacionObligatoriaMismoPeriodoVenta(DTOSolicitudValidacion dto, String codigoVenta) throws RemoteException, MareException;

	DTOEstatusSolicitud revertirRecuperacionVoluntariaVenta(DTOSolicitudValidacion dto, String codigoVenta) throws RemoteException, MareException;

	DTOEstatusSolicitud revertirRecuperacionObligatoriaVenta(DTOSolicitudValidacion dto, String codigoVenta) throws RemoteException, MareException;

  DTOEstatusSolicitud reversionMensajesFaltantesAnunciados(DTOSolicitudValidacion dto) throws RemoteException, MareException;

  DTOEstatusSolicitud revertirAgregadosCV(DTOSolicitudReversion dto) throws RemoteException, MareException;

    void generarPedidosServicioRecuperaciones(DTOFACProcesoCierre dtoProcesoCierre) throws RemoteException, MareException;

    DTOEstatusSolicitud revertirCalcularTotales(DTOSolicitudValidacion dto) throws RemoteException, MareException;
    void desbloquearMM(Long oidPais, Long oidMarca) throws MareException, RemoteException;

    DTOEstatusSolicitud actualizarPeriodoPrimerContacto(DTOSolicitudValidacion dto) throws MareException, RemoteException;
;

  //DTOEstatusSolicitud recuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws MareException, RemoteException;

    DTOEstatusSolicitud validarDescuento2(DTOSolicitudValidacion dto) throws MareException, 
                                                                             RemoteException;

    DTOEstatusSolicitud validarCuadreOfertas2(DTOSolicitudValidacion dto) throws MareException, 
                                                                                 RemoteException;

    DTOEstatusSolicitud recuperacionObligatoria2(DTOSolicitudValidacion dto) throws MareException, 
                                                                                    RemoteException;

    DTOEstatusSolicitud calcularMontoMaximo2(DTOSolicitudValidacion dto) throws MareException, 
                                                                                RemoteException;

    DTOEstatusSolicitud calcularMontoMinimo2(DTOSolicitudValidacion dto) throws MareException, 
                                                                                RemoteException;

    DTOEstatusSolicitud insertarOfertasEspeciales(DTOSolicitudValidacion dto) throws MareException, 
                                                                                     RemoteException;

    DTOEstatusSolicitud validarAgregados2(DTOSolicitudValidacion dto) throws MareException, 
                                                                             RemoteException;

    DTOEstatusSolicitud calcularMontoMinimoIncentivos(DTOSolicitudValidacion dto) throws MareException, 
                                                                                         RemoteException;

    DTOEstatusSolicitud insertarOfertasEspeciales2(DTOSolicitudValidacion dto) throws MareException, 
                                                                                      RemoteException;

    DTOEstatusSolicitud validarCuadreOfertas3(DTOSolicitudValidacion dto) throws MareException, 
                                                                                 RemoteException;

    DTOEstatusSolicitud validarCuadreOfertas4(DTOSolicitudValidacion dto) throws MareException, 
                                                                                 RemoteException;

    DTOEstatusSolicitud eliminarProductosFaltantesProlIndividual(DTOSolicitudValidacion dto) throws MareException, 
                                                                                                    RemoteException;

    DTOEstatusSolicitud eliminarProductosFaltantesProlCompuesta(DTOSolicitudValidacion dto) throws MareException, 
            RemoteException;

    DTOEstatusSolicitud evaluarExigenciasVentas(DTOSolicitudValidacion dto) throws MareException, 
            RemoteException;
}
