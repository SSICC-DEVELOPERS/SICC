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

import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.EJBObject;

public interface MONSAPBPS extends EJBObject {
    ArrayList calcularFuenteVentaReal(Long periodo) throws MareException, 
                                                           RemoteException;

    DTOSalidaBatch enviarDemandaAnormal(DTOBatch dtoBatch) throws MareException, 
                                                                  RemoteException;

    DTOSalidaBatch enviarFuenteVentaReal(DTOBatch dtoBatch) throws MareException, 
                                                                   RemoteException;

    void enviarInterfacesDemandaAnormal(DTOINTPantallaSAPBPS dtoe) throws MareException, 
                                                                          RemoteException;

    void enviarInterfacesFuenteVentaReal(DTOINTPantallaSAPBPS dtoe) throws MareException, 
                                                                           RemoteException;

    DTOSalidaBatch enviarMaestroRegiones(DTOBatch dtoBatch) throws MareException, 
                                                                   RemoteException;

    DTOSalidaBatch enviarMaestroTerritorios(DTOBatch dtoBatch) throws MareException, 
                                                                      RemoteException;

    DTOSalidaBatch enviarMaestroZonas(DTOBatch dtoBatch) throws MareException, 
                                                                RemoteException;

    DTOSalidaBatch enviarPedidosDiaMarca(DTOBatch dtoBatch) throws MareException, 
                                                                   RemoteException;

    void enviarPedidosDiaMarcaBatch(DTOEnviarPedidosSAP dtoe) throws MareException, 
                                                                     RemoteException;

    void enviarPedidosTotalesDia(Integer anioComercial, ArrayList datosPedSAP, 
                                 DTOEnviarPedidosSAP dtoe) throws MareException, 
                                                                  RemoteException;

    DTOSalidaBatch enviarVentaDiaProducto(DTOBatch dtoBatch) throws MareException, 
                                                                    RemoteException;

    void enviarVentaDiaProductoBatch(DTOEnviarPedidosSAP dtoe) throws MareException, 
                                                                      RemoteException;

    DTOSalidaBatch enviarVentasTotalesCampania(DTOBatch dtoBatch) throws MareException, 
                                                                         RemoteException;

    void realizarCreate(DTOINTEstimado dtoE, ArrayList array, 
                        InterfazInfo interfaz, 
                        MONGestorInterfaces gi) throws MareException, 
                                                       RemoteException;

    void realizarCreate2(DTOINTEstimado dtoE, ArrayList array, 
                         InterfazInfo interfaz, 
                         MONGestorInterfaces gi) throws MareException, 
                                                        RemoteException;

    void recepcionarArgumentosVenta(DTOOID pais) throws MareException, 
                                                        RemoteException;

    DTOSalidaBatch recepcionarArgumentosVentaBatch(DTOBatch dtoBatch) throws MareException, 
                                                                             RemoteException;

    void recepcionarCicloVida(DTOOID pais) throws MareException, 
                                                  RemoteException;

    DTOSalidaBatch recepcionarCicloVidaBatch(DTOBatch dtoBatch) throws MareException, 
                                                                       RemoteException;

    void recepcionarCondicionPromocion(DTOOID pais) throws MareException, 
                                                           RemoteException;

    DTOSalidaBatch recepcionarCondicionPromocionBatch(DTOBatch dtoBatch) throws MareException, 
                                                                                RemoteException;

    void recepcionarDescripcionTiposOfertaPorIdioma(DTOOID pais) throws MareException, 
                                                                        RemoteException;

    DTOSalidaBatch recepcionarDescripcionTiposOfertaPorIdiomaBatch(DTOBatch dtoBatch) throws MareException, 
                                                                                             RemoteException;

    DTOSalidaBatch recepcionarEstimadosMAV(DTOBatch dtoBatch) throws MareException, 
                                                                     RemoteException;

    DTOSalidaBatch recepcionarEstimadosMAVAutomaticoBatch(DTOBatch dtoBatch) throws MareException, 
                                                                                    RemoteException;

    DTOSalidaBatch recepcionarEstimadosMAVManualBatch(DTOINT dtoInt) throws MareException, 
                                                                            RemoteException;

    DTOSalidaBatch recepcionarEstimadosVentas(DTOBatch dtoBatch) throws MareException, 
                                                                        RemoteException;

    DTOSalidaBatch recepcionarEstimadosVentasAutomaticoBatch(DTOBatch dtoBatch) throws MareException, 
                                                                                       RemoteException;

    DTOSalidaBatch recepcionarEstimadosVentasManualBatch(DTOINT dtoInt) throws MareException, 
                                                                               RemoteException;

    DTOSalidaBatch recepcionarEstimadosVentasProyectadas(DTOBatch dtoBatch) throws MareException, 
                                                                                   RemoteException;

    DTOSalidaBatch recepcionarEstimadosVentasProyectadasBatch(DTOINT dtoINT) throws MareException, 
                                                                                    RemoteException;

    void recepcionarFuenteVentasPrevista(DTOOID pais) throws MareException, 
                                                             RemoteException;

    DTOSalidaBatch recepcionarFuenteVentasPrevistaBatch(DTOBatch dtoBatch) throws MareException, 
                                                                                  RemoteException;

    void recepcionarMedioCatalogo(DTOOID pais) throws MareException, 
                                                      RemoteException;

    DTOSalidaBatch recepcionarMedioCatalogoBatch(DTOBatch dtoBatch) throws MareException, 
                                                                           RemoteException;

    void recepcionarTiposOferta(DTOOID pais) throws MareException, 
                                                    RemoteException;

    DTOSalidaBatch recepcionarTiposOfertaBatch(DTOBatch dtoBatch) throws MareException, 
                                                                         RemoteException;
}
