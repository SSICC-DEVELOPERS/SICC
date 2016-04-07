package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.dtos.intsys.DTOEnviarPedidosSAP;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTEstimado;

import es.indra.sicc.dtos.intsys.DTOINTPantallaSAPBPS;
import es.indra.sicc.util.DTOOID;

import java.util.ArrayList;

import javax.ejb.EJBLocalObject;

public interface MONSAPBPSLocal extends EJBLocalObject {
    void realizarCreate(DTOINTEstimado dtoE, ArrayList array, 
                        InterfazInfo interfaz, 
                        MONGestorInterfaces gi) throws MareException;

    ArrayList calcularFuenteVentaReal(Long periodo) throws MareException;

    DTOSalidaBatch enviarDemandaAnormal(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch enviarFuenteVentaReal(DTOBatch dtoBatch) throws MareException;

    void enviarInterfacesDemandaAnormal(DTOINTPantallaSAPBPS dtoe) throws MareException;

    void enviarInterfacesFuenteVentaReal(DTOINTPantallaSAPBPS dtoe) throws MareException;

    DTOSalidaBatch enviarMaestroRegiones(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch enviarMaestroTerritorios(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch enviarMaestroZonas(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch enviarPedidosDiaMarca(DTOBatch dtoBatch) throws MareException;

    void enviarPedidosDiaMarcaBatch(DTOEnviarPedidosSAP dtoe) throws MareException;

    void enviarPedidosTotalesDia(Integer anioComercial, ArrayList datosPedSAP, 
                                 DTOEnviarPedidosSAP dtoe) throws MareException;

    DTOSalidaBatch enviarVentaDiaProducto(DTOBatch dtoBatch) throws MareException;

    void enviarVentaDiaProductoBatch(DTOEnviarPedidosSAP dtoe) throws MareException;

    DTOSalidaBatch enviarVentasTotalesCampania(DTOBatch dtoBatch) throws MareException;

    void realizarCreate2(DTOINTEstimado dtoE, ArrayList array, 
                         InterfazInfo interfaz, 
                         MONGestorInterfaces gi) throws MareException;

    void recepcionarArgumentosVenta(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarArgumentosVentaBatch(DTOBatch dtoBatch) throws MareException;

    void recepcionarCicloVida(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarCicloVidaBatch(DTOBatch dtoBatch) throws MareException;

    void recepcionarCondicionPromocion(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarCondicionPromocionBatch(DTOBatch dtoBatch) throws MareException;

    void recepcionarDescripcionTiposOfertaPorIdioma(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarDescripcionTiposOfertaPorIdiomaBatch(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch recepcionarEstimadosMAV(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch recepcionarEstimadosMAVAutomaticoBatch(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch recepcionarEstimadosMAVManualBatch(DTOINT dtoInt) throws MareException;

    DTOSalidaBatch recepcionarEstimadosVentas(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch recepcionarEstimadosVentasAutomaticoBatch(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch recepcionarEstimadosVentasManualBatch(DTOINT dtoInt) throws MareException;

    DTOSalidaBatch recepcionarEstimadosVentasProyectadas(DTOBatch dtoBatch) throws MareException;

    DTOSalidaBatch recepcionarEstimadosVentasProyectadasBatch(DTOINT dtoINT) throws MareException;

    void recepcionarFuenteVentasPrevista(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarFuenteVentasPrevistaBatch(DTOBatch dtoBatch) throws MareException;

    void recepcionarMedioCatalogo(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarMedioCatalogoBatch(DTOBatch dtoBatch) throws MareException;

    void recepcionarTiposOferta(DTOOID pais) throws MareException;

    DTOSalidaBatch recepcionarTiposOfertaBatch(DTOBatch dtoBatch) throws MareException;
}
