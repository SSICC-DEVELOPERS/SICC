package es.indra.sicc.logicanegocio.ped.applet;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOCambiosVentas;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.dtos.bel.DTOPosicionCambioVenta;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro;
import es.indra.sicc.dtos.ped.applet.DTOCargaPantallaBusqueda;
import es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.ped.applet.DTODatosCliente;
import es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.ped.applet.DTOPresentarFlete;
import es.indra.sicc.dtos.ped.applet.DTORevertirPosicionRegistro;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores;
//import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public interface MONRegistroOnline extends EJBObject  {

  DTODatosCliente  buscarDatosCliente(DTODatosCliente DTOE) throws MareException, RemoteException;

  DTOInfoProducto validarCodigoVenta(DTOInfoProducto DTOInfoProducto) throws MareException, RemoteException;

  DTOInfoProducto validarCodigoProducto(DTOInfoProducto DTOInfoProducto) throws MareException, RemoteException;

  DTOInfoProducto obtenerInfoGestionStock(DTOInfoProducto DTOInfoProducto) throws MareException, RemoteException;

  DTOCabeceraSolicitud grabarSolicitud(DTOCabeceraSolicitud DTOCabeceraSolicitud) throws MareException, RemoteException;

  DTOSalida buscarProductosAlternativos(DTOInfoProducto DTOE) throws MareException, RemoteException;

  DTOCargaRegistroOnline obtenerCargaInicial(DTOCargaRegistroOnline dtoOut) throws MareException, RemoteException;

  DTOSalida obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto) throws RemoteException, MareException;

  DTOCargaPantallaBusqueda obtenerCargaBusquedaProductos(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalida buscarProductosRegistro(DTOBuscarProductosRegistro dtoe) throws MareException, RemoteException;

  DTOSalida obtenerFlete(DTOPresentarFlete dtoe) throws MareException, RemoteException;

  DTOGenerarPosicionRegistro reservarAlmacen(DTOGenerarPosicionRegistro dtoe) throws MareException, RemoteException;

  DTOMovimientoAlmacen crearDTOMovimientoAlmacen(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Boolean noGenerarCabecera, Long cantidadReservar, String numeroMovimiento) throws RemoteException, MareException;

  DTOMovimientoAlmacenDetalle  crearDTOMovimientoAlmacenDetalle(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Long cantidadReservar, String numeroMovimiento) throws RemoteException, MareException;

  DTOCabeceraSolicitud generarPosicion(DTOGenerarPosicionRegistro dtoe) throws MareException, RemoteException;

  Long obtenerTipoOferta(DTOCabeceraSolicitud cabeceraSolicitud, String cv) throws MareException, RemoteException;

  DTOCabeceraSolicitud revertirAlmacen(DTORevertirPosicionRegistro dtoe) throws MareException, RemoteException;

  DTOSalida obtenerImportesCobro(DTOOID dtoOid) throws MareException, RemoteException;

  DTOObtenerSolicitudCobro obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE) throws MareException, RemoteException;

  DTOSalida obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE) throws MareException, RemoteException;

  void actualizarAplicacionManual(DTOOID dtoOId) throws MareException, RemoteException;

  DTOSalida buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE) throws MareException, RemoteException;

  BigDecimal calcularMontoDevuelve(DTOApplet dtoa) throws RemoteException, MareException;

  DTOOID obtenerNumeroUnidadesVendidas(DTOApplet dtoa) throws MareException, RemoteException;

  DTOSalida obtenerPosicionesCambioVenta(DTOApplet dtoa) throws MareException, RemoteException;

  void actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE) throws MareException, RemoteException;

  DTOSalida simularCambiosVentas(DTOApplet dtoa) throws MareException, RemoteException;

  Integer obtenerTamanioPagina(String user) throws RemoteException;

  DTOCabeceraSolicitud simularCuadreOfertas(DTOCabeceraSolicitud DTOE) throws RemoteException, MareException;
 


}