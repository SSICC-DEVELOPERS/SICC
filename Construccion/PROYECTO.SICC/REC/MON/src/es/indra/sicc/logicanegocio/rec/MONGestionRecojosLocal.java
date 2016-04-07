package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.rec.DTOBoletas;
import es.indra.sicc.dtos.rec.DTOBuscarBolRecProcesadas;
import es.indra.sicc.dtos.rec.DTOConsolidarBoletasRecojo;
import es.indra.sicc.dtos.rec.DTOFiltroBoletasRecojo;
import es.indra.sicc.dtos.rec.DTOFiltroProductoNoRecogible;
import es.indra.sicc.dtos.rec.DTOGestBoletasRecPend;
import es.indra.sicc.dtos.rec.DTOGestionProductosNoRecogibles;
import es.indra.sicc.dtos.rec.DTOGestionarBoletaRecojoPendiente;
import es.indra.sicc.dtos.rec.DTOGestionarProdNORecuperados;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContable;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.rec.DTOGenerarBoletasRecojoCierreZona;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import javax.ejb.EJBLocalObject;

public interface MONGestionRecojosLocal extends EJBLocalObject {
    void generarBoletasRecojoCierreZonaBatch(DTOGenerarBoletasRecojoCierreZona dtoe) throws MareException;

    void generaSolicitudes(DTOGestionarProdNORecuperados dtoe) throws MareException;

    DTOSalida buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe) throws MareException;

    void eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe) throws MareException;

    void eliminarBolRecojoProcesadas(DTOOIDs dtoe) throws MareException;

    void gestionarProdNORecuperados(DTOGestionarProdNORecuperados dtoe) throws MareException;

    void guardarProductosNoRecogibles(DTOGestionProductosNoRecogibles dtoE) throws MareException;

    void movimentoAlmacen(DTOGestionarProdNORecuperados dtoe) throws MareException;

    DTOSalida obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE) throws MareException;

    DTOSalida obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo dtoE) throws MareException;

    DTOSalida obtenerEstadoRecojo(DTOBelcorp dtoE) throws MareException;

    DTOSalida obtenerEstadosRecojo(DTOBoolean dtoE) throws MareException;

    DTOSalida obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible dtoE) throws MareException;

    DTOSalida obtenerProductosRecojo(DTOFiltroProductoNoRecogible dtoE) throws MareException;

    DTOBoletas procesarBoletasRecojoTemporal(DTOBoletas dtoE) throws MareException;

    DTOSalidaBatch procesarBoletasRecojoTemporalBatch(DTOBatch dtoE) throws MareException;

    void procesarNoExitosoAnular(DTOGestBoletasRecPend dtoE) throws MareException;

    DTOSalidaBatch procesarSegmentoBoletasRecojoTemporal(DTOBatch dtoE) throws MareException;

    DTOBoletas validarBoletasRecojo(DTOBoletas dtoE) throws MareException;

    DTOSalidaBatch generarBoletasRecojoCierreZona(DTOBatch dtoin) throws MareException;

    DTOConsolidarBoletasRecojo consolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe) throws MareException;

    DTOFACDocumentoContable consolidarBoletasRecojoDesdeFAC(DTOConsolidarBoletasRecojo dtoCons, 
                                                            DTOFACDocumentoContable dtoFac) throws MareException;
}
