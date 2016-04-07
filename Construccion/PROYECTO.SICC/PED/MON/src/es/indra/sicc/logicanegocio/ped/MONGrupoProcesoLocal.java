package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.ped.DTOListaProcesos;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONGrupoProcesoLocal extends EJBLocalObject 
{
  MareDTO procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dto, DTOListaProcesos listaProcesos) throws MareException;

  void actualizarProcesoSolicitud(Long oidSolicitud, Long oidGrupoProceso, Long oidProceso, Long estatus) throws MareException;

    MareDTO ejecutar(DTOEjecucionProcesos dtoin) throws MareException;

    DTOSalidaBatch ejecutarBatch(DTOBatch dtoin) throws MareException;

    DTOSalidaBatch reSegmentar(DTOBatch dtoin) throws MareException;

    void reversar(DTOEjecucionProcesos dtoin) throws MareException;

    DTOSalidaBatch reversarBatch(DTOBatch dtoin) throws MareException;

    DTOSalidaBatch ejecutarCacheEntidades(DTOBatch dtoin) throws MareException;
}
