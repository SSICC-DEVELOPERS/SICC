package es.indra.sicc.logicanegocio.fac;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;

import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONCierreFacturacionLocal extends EJBLocalObject  {
    DTOSalidaBatch ejecutaProcesoCierre(DTOBatch dtoe) throws MareException;

  DTOSalidaBatch cerrarZonaSegmento(DTOBatch dto) throws MareException;

    void actualizarProgramaCierre(DTOFACCierreFacturacion dtoe, Long oidRegion, 
                                  int totalProcesos) throws MareException;
}
