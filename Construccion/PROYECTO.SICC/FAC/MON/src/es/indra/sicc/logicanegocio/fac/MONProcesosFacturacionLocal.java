package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACListaConsolidados;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import java.util.Hashtable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACVisualizarDoc;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import java.util.HashMap;

public interface MONProcesosFacturacionLocal extends EJBLocalObject 
{   
    ArrayList actualizarPosiciones(DTOFACConsolidado dtoConsolidado) throws MareException;

    DTOFACConsolidado ejecutarProcesosFacturacion(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos) throws MareException;

    DTOSalidaBatch ejecutarProcesosFacturacion(DTOFACListaConsolidados segmentoConsolidados, Boolean online) throws MareException;

    DTOSalidaBatch ejecutarProcesosFacturacionBatch(DTOBatch dtoin) throws MareException;

    Hashtable obtenerValoresTipoSolicitud() throws MareException;

    ArrayList procesar(DTOFACListaConsolidados dtoListaConsolidados) throws MareException;

    DTODocumento visualizarDocumentoFacturacion(DTOFACVisualizarDoc dtoEntrada);

    void continuarFacturacion(Long oidSolicitud, Boolean estado) throws MareException;

    void actualizacionTablasNuevo(DTOFACConsolidado consolidado) throws MareException;

    void revertirActualizarTablas(DTOFACConsolidado consolidado) throws MareException;

  DTOFACPosicionSolicitud actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion, ArrayList listaSolicitudes, HashMap hashImpuestosUbigeo, HashMap hashIndicadoresImpuestos, HashMap hashImpuestosNegocio) throws MareException;

    DTOSalidaBatch reSegmentar(DTOBatch dtoin) throws MareException;


    String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException;

    HashMap obtenerPosicionesCabeceras(ArrayList listaOIDs, 
                                       Long oidIdioma) throws MareException;
}
