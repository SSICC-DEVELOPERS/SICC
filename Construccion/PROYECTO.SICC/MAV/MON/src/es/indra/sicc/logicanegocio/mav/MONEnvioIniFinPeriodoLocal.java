package es.indra.sicc.logicanegocio.mav;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOEnvioMAV;
import es.indra.mare.common.exception.MareException;
import java.sql.Date;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.mav.DTOEnvioIniFinPeriodo;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONEnvioIniFinPeriodoLocal extends EJBLocalObject 
{
    void insertarEnvioMAV(DTOEnvioMAV DTOE) throws MareException;

    Date obtenerFechaEntrega(Long periodo, Long zona) throws MareException;

    void procesarEnvioIniFinPeriodo(MareDTO dtoin) throws MareException;

    void procesarEnvioIniFinPeriodoCierre(DTOFACProcesoCierre dtoProcesoCierre) throws MareException;

    void procesarEnvioIniFinPeriodoCierre(MareDTO dto) throws MareException;

  DTOSalidaBatch procesarEnvioIniFinPeriodoBatch(DTOBatch dtoin) throws MareException;

  void procesarEnvioIniFinPeriodoMenu(DTOEnvioIniFinPeriodo dtoe) throws MareException;
}