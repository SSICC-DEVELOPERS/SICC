/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.pre;

import es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.pre.DTOECabeceraMF;
import es.indra.sicc.dtos.pre.DTOEConsultarMF;
import es.indra.sicc.dtos.pre.DTOECopiarMF;
import es.indra.sicc.dtos.pre.DTOProductoMatriz;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOEValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.pre.DTOProductoReemplazo;
import es.indra.sicc.dtos.pre.DTOObtenerProductoRecuperacion;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import java.util.Hashtable;

public interface MONMantenimientoMF extends EJBObject  {

    DTOSalida buscarMFPeriodoActualYFuturo(DTOSiccPaginacion dto) throws RemoteException, MareException;

    DTOSalida buscarMFPeriodoAnterior(DTOSiccPaginacion dto) throws RemoteException, MareException;

    DTOOID guardarCabeceraMF(DTOECabeceraMF dto) throws RemoteException, MareException;

    DTOSalida consultarMF(DTOEConsultarMF dto) throws RemoteException, MareException;

    void eliminarMatrizYOfertas(DTOOID dto) throws RemoteException, MareException;

    void crearMF(DTOCabecCatal dto) throws RemoteException, MareException;

    void eliminarMF(DTOOID dto) throws RemoteException, MareException;

    void copiarMF(DTOECopiarMF dto) throws RemoteException, MareException;

    DTOSalida consultarCabeceraMF(DTOOID dto) throws RemoteException, MareException;

    void modificarCabeceraMF(DTOECabeceraMF dto) throws RemoteException, MareException;

    Boolean buscarCodigoVenta(String codigoVenta, Long pais) throws RemoteException, MareException;

    DTOProductoMatriz buscaProductoEnMatriz(DTOProductoMatriz DTOE) throws RemoteException, MareException;

    Hashtable insertarProductoEnMatrizAgregados(DTOProductoMatriz dto) throws RemoteException, MareException;

    DTOSValidarCodigoVenta validarCodigoVenta(DTOEValidarCodigoVenta DTOE) throws RemoteException, MareException;

    DTOSValidarCodigoVenta validarCodVent(DTOEValidarCodigoVenta DTOE) throws RemoteException, MareException;

    Integer contarCodigoVenta(Long pais, Long marca, Long canal, Long acceso, Long subacceso, String codigoVenta, Long codigoCatalogo) throws RemoteException, MareException;

    DTOSalida buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto) throws RemoteException, MareException;

    Long obtenerFormaPagoMF(Long oidPeriodo, String codigoVenta) throws RemoteException, MareException;

    DTOSalida obtenerProductosAlternativos(Long oidPeriodo, String codigoVenta) throws RemoteException, MareException;

    DTOProductoReemplazo obtenerProductoReemplazo(DTOProductoReemplazo dtoe) throws RemoteException, MareException;  

  DTOSalida obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe) throws RemoteException, MareException;

  void actualizarMatrizFacturada(Long oidPeriodo, Boolean estado) throws RemoteException, MareException;

  DTOSalida obtenerCodigosVenta(DTOInfoProducto dtoe) throws RemoteException, MareException;

  DTOSalida buscarProductosRegistro(DTOBuscarProductosRegistro dtoe) throws RemoteException, MareException;

  Long buscarProductoCV(String codigoVenta,Long cabecera) throws MareException, RemoteException;

    DTOSalida obtenerVariantes(DTOBelcorp dto) throws RemoteException, MareException;

    String insertarProductoEnMatriz(DTOProductoMatriz dto) throws MareException, RemoteException;

    DTOSalida buscarCodigoVentaPeriodo2(DTOBuscarCodigoVentaPeriodo dtoe) throws MareException, RemoteException;

    DTOSalida buscarCodigoVentaPeriodo3(DTOBuscarCodigoVentaPeriodo dtoe) throws MareException, RemoteException;


    DTOSalida obtenerTipoOfertaCopiar(DTOBelcorp dtoe) throws MareException, 
                                                              RemoteException;
}
