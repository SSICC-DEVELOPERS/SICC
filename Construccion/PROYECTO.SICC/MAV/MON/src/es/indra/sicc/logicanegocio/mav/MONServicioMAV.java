package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONServicioMAV extends EJBObject {
    DTOSalida obtenerTiposDespacho() throws RemoteException, MareException;

    DTOSalida obtenerEstadosMAV(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtenerTiposCondicionPago() throws RemoteException, MareException;

    DTOSalida obtenerCriteriosAsignacion() throws RemoteException, MareException;

    DTOSalida obtenerFormaCobro(DTOOID dtoOid) throws RemoteException, MareException;

    DTOSalida obtieneMensajesTipoDespacho(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtieneActividadesMAV(DTOActividadMAV dto) throws RemoteException, MareException;

    DTOSalida obtieneSubcriteriosPorCriterio(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerEnvioConSolicitud() throws RemoteException, MareException;

    DTOSalida obtieneTiposEstadoProceso(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtieneEstadosEnvio(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtenerEstadosMAVActividad(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerTiposOfertaActividad(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerCiclosVidaActividad(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerTiposDespachoActividad(DTOOID dto) throws RemoteException, MareException;

  DTOSalida obtieneTiposClienteActividad(DTOOID dto) throws RemoteException, MareException;

  DTOSalida obtieneFormasPagoActividad(DTOOID dtoOid) throws RemoteException, MareException;

  DTOSalida obtenerTiposDespachoIniFinPeriodo() throws MareException, RemoteException;
}