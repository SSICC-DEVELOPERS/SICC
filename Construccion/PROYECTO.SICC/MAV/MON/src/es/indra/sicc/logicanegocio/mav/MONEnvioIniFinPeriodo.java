package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.mav.DTOEnvioMAV;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import java.rmi.RemoteException;

import java.sql.Date;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.mav.DTOEnvioIniFinPeriodo;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

public interface MONEnvioIniFinPeriodo extends EJBObject {
    void procesarEnvioIniFinPeriodo(MareDTO dtoin) throws RemoteException, MareException;

    void insertarEnvioMAV(DTOEnvioMAV DTOE) throws RemoteException, MareException;

    Date obtenerFechaEntrega(Long periodo, Long zona) throws RemoteException, MareException;

    void procesarEnvioIniFinPeriodoCierre(DTOFACProcesoCierre dtoProcesoCierre) throws RemoteException, MareException;

  void procesarEnvioIniFinPeriodoCierre(MareDTO dto) throws RemoteException, MareException;

  DTOSalidaBatch procesarEnvioIniFinPeriodoBatch(DTOBatch dtoin) throws RemoteException, MareException;

  void procesarEnvioIniFinPeriodoMenu(DTOEnvioIniFinPeriodo dtoe) throws MareException, RemoteException;
}