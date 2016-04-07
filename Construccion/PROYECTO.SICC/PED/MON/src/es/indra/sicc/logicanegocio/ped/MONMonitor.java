package es.indra.sicc.logicanegocio.ped;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTOCargaInicialMonitor;
import es.indra.sicc.dtos.ped.DTOBuscarDatosMonitor;
import es.indra.sicc.dtos.ped.DTODatosMonitor;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesGrupo;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesCriterio;
import es.indra.sicc.dtos.ped.DTOPlantilla;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOGrupoSolicitudes;
import es.indra.sicc.dtos.ped.DTOListaSolicitudes;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.ped.DTOListaTipificaciones;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOAlarmas;
import es.indra.sicc.dtos.ped.DTOAlarmaPedidos;

public interface MONMonitor extends EJBObject  {
  DTOCargaInicialMonitor cargaInicialMonitor(DTOBelcorp dto) throws MareException, RemoteException;

  DTODatosMonitor obtenerDatos(DTOBuscarDatosMonitor criterios) throws MareException, RemoteException;

  void guardar(DTOPlantilla dto) throws MareException, RemoteException;

  void agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto) throws MareException, RemoteException;

  void agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto) throws MareException, RemoteException;

  DTOSalida cargarGrupoReversion(DTOEGrupoReversion dto) throws MareException, RemoteException;

  DTOSalida contarSolicitudesGrupo(DTOEGrupoReversion dto) throws MareException, RemoteException;

  void eliminarSolicitudesGrupo(DTOOIDs dto) throws MareException, RemoteException;

  DTOListaSolicitudes obtenerSolicitudes(DTOInfoMonitor dto) throws RemoteException, MareException;

  void revertirProcesos(DTOEGrupoReversion dtoe) throws MareException, RemoteException;

  void procesarSolicitudes(DTOInfoMonitor dtoin) throws RemoteException, MareException;

  void guardarTipificaciones(DTOListaTipificaciones dotin) throws MareException, RemoteException;

	DTOAlarmas cuentaAlarmas(DTOAlarmaPedidos dtoe) throws RemoteException, MareException;

	DTOSalida cargaAlarmaPedidos(DTOAlarmaPedidos dtoe) throws MareException, RemoteException;

  DTODatosMonitor obtenerDatosMejorado(DTOBuscarDatosMonitor criterios) throws MareException, RemoteException;

    DTOListaSolicitudes obtenerSolicitudesReversion(DTOInfoMonitor dto) throws MareException, RemoteException;

    void revertirSolicitudesServicio(DTOInfoMonitor dtoE) throws MareException, RemoteException;

    String procesarSolicitudesIntegracionSSICC(DTOInfoMonitor dtoin) throws MareException, 
                                                                            RemoteException;
}
