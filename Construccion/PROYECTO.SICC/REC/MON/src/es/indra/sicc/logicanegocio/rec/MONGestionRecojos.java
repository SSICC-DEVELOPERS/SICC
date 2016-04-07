package es.indra.sicc.logicanegocio.rec;

import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContable;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.rec.DTOFiltroProductoNoRecogible;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.rec.DTOGestionProductosNoRecogibles;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.rec.DTOGestionarBoletaRecojoPendiente;
import es.indra.sicc.dtos.rec.DTOGestionarProdNORecuperados;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.rec.DTOBuscarBolRecProcesadas;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.rec.DTOFiltroBoletasRecojo;
import es.indra.sicc.dtos.rec.DTOGestBoletasRecPend;
import es.indra.sicc.dtos.rec.DTOBoletas;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.rec.DTOConsolidarBoletasRecojo;
import es.indra.sicc.dtos.rec.DTOGenerarBoletasRecojoCierreZona;

public interface MONGestionRecojos extends EJBObject  {
    DTOSalida obtenerProductosRecojo(DTOFiltroProductoNoRecogible dtoE) throws MareException, 
                                                                               RemoteException;

    DTOSalida obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible dtoE) throws MareException, 
                                                                                     RemoteException;

    void guardarProductosNoRecogibles(DTOGestionProductosNoRecogibles dtoE) throws MareException, 
                                                                                   RemoteException;

    DTOSalida obtenerEstadoRecojo(DTOBelcorp dtoE) throws RemoteException, MareException;

    void gestionarProdNORecuperados(DTOGestionarProdNORecuperados dtoe) throws MareException, 
                                                                               RemoteException;

    DTOSalida buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe) throws MareException, 
                                                                                   RemoteException;

    DTOSalida obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE) throws MareException, 
                                                                                   RemoteException;

    void eliminarBolRecojoProcesadas(DTOOIDs dtoe) throws MareException, 
                                                          RemoteException;

    void eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe) throws MareException, 
                                                                    RemoteException;

    DTOSalida obtenerEstadosRecojo(DTOBoolean dtoE) throws MareException, 
                                                           RemoteException;

    DTOSalida obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo dtoE) throws MareException, 
                                                                               RemoteException;

    void procesarNoExitosoAnular(DTOGestBoletasRecPend dtoE) throws MareException, 
                                                                    RemoteException;

    DTOBoletas validarBoletasRecojo(DTOBoletas dtoE) throws MareException, 
                                                            RemoteException;

    DTOBoletas procesarBoletasRecojoTemporal(DTOBoletas dtoE) throws MareException, 
                                                                     RemoteException;

    DTOSalidaBatch procesarBoletasRecojoTemporalBatch(DTOBatch dtoE) throws MareException, 
                                                                            RemoteException;

    DTOSalidaBatch procesarSegmentoBoletasRecojoTemporal(DTOBatch dtoE) throws MareException, 
                                                                               RemoteException;

    void movimentoAlmacen(DTOGestionarProdNORecuperados dtoe) throws MareException, 
                                                                     RemoteException;

    void generaSolicitudes(DTOGestionarProdNORecuperados dtoe) throws MareException, 
                                                                      RemoteException;

    void generarBoletasRecojoCierreZonaBatch(DTOGenerarBoletasRecojoCierreZona dtoe) throws MareException, 
                                                                                            RemoteException;

    DTOSalidaBatch generarBoletasRecojoCierreZona(DTOBatch dtoin) throws MareException, 
                                                                         RemoteException;

    DTOConsolidarBoletasRecojo consolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe) throws MareException, 
                                                                                               RemoteException;

    DTOFACDocumentoContable consolidarBoletasRecojoDesdeFAC(DTOConsolidarBoletasRecojo dtoCons, 
                                                            DTOFACDocumentoContable dtoFac) throws MareException, 
                                                                                                   RemoteException;
}
