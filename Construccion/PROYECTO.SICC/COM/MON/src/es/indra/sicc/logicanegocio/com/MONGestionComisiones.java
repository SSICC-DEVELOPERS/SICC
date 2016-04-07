package es.indra.sicc.logicanegocio.com;

import es.indra.sicc.dtos.com.DTOComisionesProductos;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.com.DTOEstados;
import es.indra.sicc.dtos.com.DTOBuscarInsertarComisiones;
import es.indra.sicc.dtos.com.DTOBuscarModificar;
import es.indra.sicc.dtos.com.DTOEstadoComision;
import es.indra.sicc.dtos.com.DTOBuscarMarcarModificar;
import es.indra.sicc.dtos.com.DTOPermitirModificar;
import es.indra.sicc.dtos.com.DTOCodigoComision;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.cra.DTOPeriodo;

public interface MONGestionComisiones extends EJBObject {
  DTOSalida obtenerCanalesPlantillas(DTOBelcorp dto) throws MareException, RemoteException;
  DTOSalida obtenerDescripcionesPlantillas(DTOBelcorp dto) throws MareException, RemoteException;
  DTOSalida buscarInsertarComisiones(DTOBuscarInsertarComisiones dto) throws MareException, RemoteException;
  DTOSalida obtenerMarcasPlantilla(DTOOID dto) throws MareException, RemoteException;
  DTOSalida obtenerAccesosPlantilla(DTOOID dto) throws MareException, RemoteException;
  DTOSalida obtenerCodigosComisiones(DTOBelcorp dto) throws MareException, RemoteException;
  DTOSalida obtenerMarcasComisiones(DTOBelcorp dto) throws MareException, RemoteException;
  DTOSalida obtenerCanalesComisiones(DTOBelcorp dto) throws MareException, RemoteException;
  DTOSalida obtenerAccesosComisiones(DTOBelcorp dto) throws MareException, RemoteException;
  DTOSalida obtenerVersionesComision(DTOCodigoComision dto) throws MareException, RemoteException;
  DTOSalida buscarMarcarModificar(DTOBuscarMarcarModificar dto) throws MareException, RemoteException;
  void marcarModificar(DTOComisiones dto) throws MareException, RemoteException;
  DTOSalida buscarAceptarModificacion(DTOEstadoComision dto) throws MareException, RemoteException;
  void permitirModificar(DTOPermitirModificar dto) throws MareException, RemoteException;
  DTOSalida cargaConfirmarModificar(DTOOID dto) throws MareException, RemoteException;
  void aceptarModificacion(DTOOID dto) throws MareException, RemoteException;
  void rechazarModificacion(DTOOID dto) throws MareException, RemoteException;
  DTOSalida buscarModificar(DTOBuscarModificar dto) throws MareException, RemoteException;
  void copiarComision(DTOComisiones dto) throws MareException, RemoteException;
  DTOSalida obtenerEstadosComisiones(DTOEstados dto) throws MareException , RemoteException;
  void eliminarComision(DTOOID dto) throws MareException, RemoteException;
  DTOSalida obtenerTiposInsercionProducto(DTOBelcorp dto) throws MareException, RemoteException;
  DTOOID obtenerMarca(DTOComisiones dto) throws RemoteException, MareException;
  DTOComisionesProductos completarProducto(DTOComisionesProductos dto) throws MareException, RemoteException;

  String generaCodigoComision() throws MareException, RemoteException;
  DTOSalida obtenerTiposPlantilla() throws MareException, RemoteException;

  DTOSalida obtenerPeriodosMayores(DTOPeriodo dto) throws MareException, RemoteException;

  DTOSalida obtenerPeriodoAnioAnterior(DTOOID dto) throws MareException, RemoteException;
  
  
  
}