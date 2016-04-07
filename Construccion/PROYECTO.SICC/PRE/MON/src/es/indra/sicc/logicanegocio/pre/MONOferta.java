/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.pre.DTOComprobarOrden;
import es.indra.sicc.dtos.pre.DTOEBuscarOfertas;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.dtos.pre.DTOEOrdenOfertas;
import es.indra.sicc.dtos.pre.DTOModificarOferta;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOTextoOferta;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.DTOString;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.entidades.pre.OfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.dtos.pre.DTOValidacionRecuperacion;
import es.indra.sicc.dtos.pre.DTOValidacionesOferta;


public interface MONOferta extends EJBObject {
    DTOSalida buscarProductosEstimados(DTOEBuscarProductos dto) throws RemoteException, MareException;
    DTOSalida buscarProductosMaestro(DTOEBuscarProductos dto) throws RemoteException, MareException;
    void guardarOferta(DTOOferta dto) throws RemoteException, MareException;
    void validarAcceso(DTOOferta dto) throws RemoteException, MareException;
    void registrarOfertasIndividuales(DTOCabecCatal dto) throws RemoteException, MareException;
    void asignarCodigosVenta(DTOCabecCatal dto) throws RemoteException, MareException;
    RecordSet buscarOfertasSinCodigoVenta(DTOCabecCatal dto) throws RemoteException, MareException;
    Boolean comprobarNumeroOrden(DTOTextoOferta dto) throws RemoteException, MareException;
    void guardarTextoOferta(DTOTextoOferta dto) throws RemoteException, MareException;
    void eliminarTextoOferta(DTOOID dto) throws RemoteException, MareException;
    DTOComprobarOrden comprobarOrdenOfertas(DTOOID dto) throws RemoteException, MareException;
    void secuenciarOfertas(DTOOID dto) throws RemoteException, MareException;
    DTOSalida consultarOrdenOfertas(DTOEOrdenOfertas dto) throws RemoteException, MareException;
    RecordSet obtenerProductosOfertaSinCV(Long oidOferta) throws RemoteException, MareException;
    DTOSalida buscarProductosEstrategiaIndividual(DTOCabecCatal dto) throws RemoteException, MareException;
    void modificarOferta(DTOOferta dto) throws RemoteException, MareException;
    Integer eliminarOferta(DTOOID dtoOid) throws RemoteException, MareException;
    DTOSalida buscarOfertas(DTOEBuscarOfertas dto) throws RemoteException, MareException;
    DTOOferta obtenerOferta(DTOOID dto) throws RemoteException, MareException;
    DTOModificarOferta obtenerOfertaModificacion(DTOOID dtoOId) throws RemoteException, MareException;

  DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductos(DTOOID dto) throws RemoteException, MareException;

  DTOSCargarCriteriosDefinirOferta cargarCriteriosDefinirOferta(DTOECargarCriteriosDefinirOferta dtoe) throws RemoteException, MareException;

  DetalleOfertaLocal guardarDetalleOferta(DTODetalleOferta dto) throws RemoteException, MareException;

  OfertaLocal guardarCabeceraOferta(DTOOferta dto) throws RemoteException, MareException;

  DTOSalida cargarPaisMarcaCanalPeriodo(DTOOID dto) throws RemoteException, MareException;

  Integer obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia) throws RemoteException, MareException;

  DTOSalida obtenerProductos(DTOOID dto) throws RemoteException, MareException;

  DTOTextoOferta obtenerTextoOferta(DTOTextoOferta dtoe) throws RemoteException, MareException;

  DTOSalida obtenerProductosOferta(Long oidOferta) throws RemoteException, MareException;

  DTOSalida obtenerFactorCuadreGrupos(DTOOID dtoe) throws RemoteException, MareException;

  DTOSalida obtenerOfertasPromocion(DTOOID dtoe) throws RemoteException, MareException;

  DTOSalida obtenerProductosAsociados(DTOOID dtoe) throws RemoteException, MareException;

  DTOSalida obtenerIndicadorCuadreGrupos(DTOOID dtoe) throws RemoteException, MareException;



  Integer obtenerNumeroOferta(Long oidOferta) throws RemoteException, MareException;

    RecordSet obtenerProductosGrupo(Long oidOferta, Long numeroGrupo) throws RemoteException, MareException;

    RecordSet obtenerGrupoCondicionadoMenorRanking(Long oidOferta) throws RemoteException, MareException;

    RecordSet obtenerGrupoCondicionadoMayorRanking(Long oidOferta) throws RemoteException, MareException;

  String obtenerUltimoCodigoVenta(Long oidCabecera) throws RemoteException, MareException;

  void asignarAdicional(String CUV, DetalleOfertaLocal detalleOferta, OfertaLocal oferta) throws RemoteException, MareException;

  boolean existeOtroProductoAsignado(String CUV, Long oidCabecera) throws RemoteException, MareException;

  DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductosMinimo(DTOOID dto) throws RemoteException, MareException;

  DTOOID obtenerProgramaFidelizacion(DTOOID dtoE) throws RemoteException, MareException;

  DTOSalida buscarProductosEstimadosPerf(DTOEBuscarProductos dto) throws RemoteException, MareException;

  DTOSalida consultarOrdenOfertaFiltros(DTOEOrdenOfertas dto) throws MareException, RemoteException;

    DTOString validarRestriccionesOferta(DTOValidacionesOferta dto) throws MareException, 
                                                                           RemoteException;

    DTOString validarProductoRecuperacion(DTOValidacionRecuperacion dto) throws MareException, 
                                                                                RemoteException;
}
