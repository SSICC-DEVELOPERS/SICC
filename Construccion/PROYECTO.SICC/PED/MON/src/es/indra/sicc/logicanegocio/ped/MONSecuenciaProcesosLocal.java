package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSecuenciaProcesos;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONSecuenciaProcesosLocal extends EJBLocalObject  {
  DTOSalida consulta(DTOSecuenciaProcesos dto) throws MareException;

  MareDTO ejecutar(DTOArranqueGP dtoin) throws MareException;

  DTOSalidaBatch ejecutarBatch(DTOBatch dtoin) throws MareException;

    DTOSalidaBatch reversarSolicitudesServicioBatch(DTOBatch dtoin) throws MareException;
}