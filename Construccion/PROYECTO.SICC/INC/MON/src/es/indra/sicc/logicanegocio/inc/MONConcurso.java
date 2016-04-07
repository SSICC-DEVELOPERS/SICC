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
 *
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTOBuscarCtaCtePtos;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;
import es.indra.sicc.dtos.inc.DTOBuscarPlantillas;
import es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOCursosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTODespachoPremios;
import es.indra.sicc.dtos.inc.DTOListaAmbitosGeograficos;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOMovimientoCtaCte;
import es.indra.sicc.dtos.inc.DTOMultinivel;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTONuevaVersion;
import es.indra.sicc.dtos.inc.DTOObtencionPuntos;
import es.indra.sicc.dtos.inc.DTOParametrosCalificacion;
import es.indra.sicc.dtos.inc.DTOParametrosConsultoras;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosGerentes;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.dtos.inc.DTOPremioArticulo;
import es.indra.sicc.dtos.inc.DTOPremioDescuento;
import es.indra.sicc.dtos.inc.DTOPremioMonetario;
import es.indra.sicc.dtos.inc.DTOPremioPuntos;
import es.indra.sicc.dtos.inc.DTOProducto;
import es.indra.sicc.dtos.inc.DTOProductosExigidosPremiacion;

//import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.inc.DTOProgramaNuevas;
import es.indra.sicc.dtos.inc.DTORequisitosPremiacion;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.dtos.inc.DTOVariablesVenta;
import es.indra.sicc.dtos.inc.DTOVariablesVentaProyectada;
import es.indra.sicc.dtos.inc.DTOVersion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.EJBObject;

public interface MONConcurso
        extends EJBObject {
    DTOSalida obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe)
            throws MareException, RemoteException;

    void actualizarEstadoVersion(DTOVersion dtoe) throws MareException, RemoteException;

    DTOSalida cargarNroPlantilla(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida cargarNroConcurso(DTOBuscarNumConcurso DTOE)
            throws MareException, RemoteException;

    DTOSalida buscarCtaCtePtos(DTOBuscarCtaCtePtos DTOE)
            throws MareException, RemoteException;

    DTOSalida buscarListaPlantillas(DTOBuscarPlantillas DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerListaParticipantes(DTOOID DTOE) throws MareException, RemoteException;

    DTOConcurso obtenerDatosConcurso(DTOOID DTOE) throws MareException, RemoteException;

    DTOParametrosGeneralesConcurso obtenerParametrosGeneralesConcurso(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerTiposExigencia(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposRequisito(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOBoolean obtenerVersionesSuperiores(DTOVersion dtoe)
            throws MareException, RemoteException;

    void actualizarNuevaVersion(DTONuevaVersion dtoe) throws MareException, RemoteException;

    void borrarConcurso(DTOVersion dtoe) throws MareException, RemoteException;

    DTONuevaVersion crearConcursoNuevaVersion(DTOVersion dtoe)
            throws MareException, RemoteException;

    void insertarVersion(DTOVersion dtoe) throws MareException, RemoteException;

    DTOProgramaNuevas obtenerProgramaNuevas(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOListaAmbitosGeograficos obtenerListaAmbitosGeograficos(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOObtencionPuntos obtenerObtencionPuntos(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOListaMontoVentaRecomendadas obtenerMontoVentaRecomendadas(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerListaClasificacionParticipantes(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOClasificacionParticipantes obtenerListasClasificacion(DTOClasificacionParticipantes DTOE)
            throws MareException, RemoteException;

    DTOParametrosConsultoras obtenerParametrosConsultoras(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerMaximoNumeroPremio(DTOOID DTOE) throws MareException, RemoteException;

    DTOParametrosGeneralesPremiacion obtenerParametrosPremiacion(DTOOID DTOE)
            throws MareException, RemoteException;

    DTORequisitosPremiacion obtenerRequisitosPremiacion(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOCursosExigidosPremiacion obtenerCursosExigidosPremiacion(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOProductosExigidosPremiacion obtenerProductosExigidosPremiacion(DTOOID DTOE)
            throws MareException, RemoteException;

    DTODespachoPremios obtenerDespachoPremios(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOProducto obtenerProductosValidos(DTOOID DTOE) throws MareException, RemoteException;

    DTOProducto obtenerProductosExcluidos(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOProducto obtenerProductosBonificados(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOProducto obtenerProductosExigidos(DTOOID DTOE) throws MareException, RemoteException;

    DTOProducto obtenerProductosACalificar(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOProducto obtenerProductosExcluidosCalificacion(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerTiposProducto(DTOTipoProducto DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerMarcas(DTOOID DTOE) throws MareException, RemoteException;

    DTOSalida obtenerAccesos(DTOOID DTOE) throws MareException, RemoteException;

    DTOSalida obtenerTiposVentaIncremental(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerTiposDeterminacionMetas(DTOOID DTOE)
            throws RemoteException, MareException;

    DTOSalida obtenerFormaCalculoMetas(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerTiposIncremento(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida obtenerFormaCalculo(DTOBelcorp DTOE) throws MareException, RemoteException;

    DTOSalida obtenerCalculoPremio(DTOBelcorp DTOE) throws RemoteException, MareException;

    DTOSalida obtenerTipoPremio(DTOBelcorp dtoe) throws RemoteException, MareException;

    DTOSalida obtenerTipoEleccion(DTOBelcorp dtoe) throws RemoteException, MareException;

    DTOSalida obtenerTipoPremiacion(DTOBoolean dtoe) throws MareException, 
                                                            RemoteException;

    DTOSalida obtenerTipoPremiosPuntos(DTOBelcorp dtoe)
            throws RemoteException, MareException;

    DTOSalida obtenerTipoPremioMonetario(DTOBelcorp dtoe)
            throws RemoteException, MareException;

    DTOSalida obtenerFormaPago(DTOBelcorp dtoe) throws RemoteException, MareException;

    DTOSalida obtenerTipoCumplimiento(DTOBelcorp dtoe)
            throws RemoteException, MareException;

    DTOSalida obtenerTipoDescuento(DTOBelcorp dtoe) throws RemoteException, MareException;

    void guardarDatosConcurso(DTOConcurso DTOE) throws MareException, RemoteException;

    Long guardarParametrosGeneralesConcurso(DTOParametrosGeneralesConcurso DTOE)
            throws RemoteException, MareException;

    void guardarAmbitosGeograficos(DTOListaAmbitosGeograficos DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    DTOSalida obtenerAgrupacion(DTOBelcorp dtoe) throws RemoteException, MareException;

    void guardarVersion(DTOParametrosGeneralesConcurso DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarObtencionPuntos(DTOObtencionPuntos DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarEstatusVenta(DTOConcurso DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarMontoVentaRecomendadas(DTOListaMontoVentaRecomendadas DTOE, Long oid)
            throws MareException, RemoteException;

    void guardarClasificacionParticipantes(DTOClasificacionParticipantes DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarParametrosConsultoras(DTOParametrosConsultoras DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarParametrosPremiacion(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    DTOSalida obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE)
            throws MareException, RemoteException;

    DTOMultinivel obtenerMultinivel(DTOOID dtoe) throws RemoteException, MareException;

    DTOParametrosCalificacion obtenerParametrosCalificacion(DTOOID DTOE)
            throws RemoteException, MareException;

    DTOVariablesVenta obtenerVariablesVenta(DTOOID dtoe)
            throws RemoteException, MareException;

    DTOVariablesVentaProyectada obtenerVariablesVentaProyectada(DTOOID dtoe)
            throws RemoteException, MareException;

    void guardarCursosExigidosPremiacion(DTOCursosExigidosPremiacion DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosExigidosPremiacion(DTOProductosExigidosPremiacion DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarDespachoPremios(DTODespachoPremios DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarParametrosCalificacion(DTOParametrosCalificacion DTOE, Long oidConcurso, Long oidTipoCalificacion)
            throws RemoteException, MareException;

    void guardarIncrementosPorRango(Long oidConcurso, ArrayList lista)
            throws MareException, RemoteException;

    DTOListaEstatusVenta obtenerListaEstatusVentaConsultora(DTOOID DTOE)
            throws MareException, RemoteException;

    void guardarClasificacionParticipantesCalificacion(DTOCalificacionParticipantes DTOE, Long oidConcurso, Long oidDirigidoA)
            throws MareException, RemoteException;

    void guardarNivelesPremiacion(DTONivelesPremiacion DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void borrarPremios(Long oidParamNivelPremiacion) throws MareException, RemoteException;

    void guardarPremioPuntos(DTOPremioPuntos DTOE, Long oidNivel)
            throws MareException, RemoteException;

    void guardarPremioMonetario(DTOPremioMonetario DTOE, Long oidNivel)
            throws MareException, RemoteException;

    void guardarPremioArticulo(DTOPremioArticulo DTOE, Long oidNivel)
            throws MareException, RemoteException;

    void guardarPremioDescuento(DTOPremioDescuento DTOE, Long oidNivel)
            throws MareException, RemoteException;

    void guardarProgramaNuevas(DTOProgramaNuevas DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarParametrosGerentes(DTOParametrosGerentes DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarVariablesVenta(DTOVariablesVenta DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarMultinivel(DTOMultinivel DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarVariablesVentaProyectada(DTOVariablesVentaProyectada DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductos(DTOConcurso DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void actualizarEstadoPlantilla(DTOPlantilla DTOE) throws MareException, RemoteException;

    void guardarProductosValidos(DTOProducto DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosExcluidos(DTOProducto DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosBonificados(DTOProducto DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosExigidos(DTOProducto DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosExcluidosCalificacion(DTOProducto DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    void guardarProductosACalificar(DTOProducto DTOE, Long oidConcurso)
            throws MareException, RemoteException;

    DTOSalida buscarConcursos(DTOBuscarConcursos DTOE)
            throws MareException, RemoteException;

    ArrayList obtenerIncrementosPorRango(Long oidConcurso)
            throws MareException, RemoteException;

    DTONivelesPremiacion obtenerNivelesPremiacion(DTOOID DTOE)
            throws MareException, RemoteException;

    DTOSalida obtenerVersionesConcurso(DTOOIDPaginado dtoOid)
            throws RemoteException, MareException;

    DTOParametrosGerentes obtenerParametrosGerentes(DTOOID dtoe)
            throws MareException, RemoteException;

    DTOSalida obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn)
            throws MareException, RemoteException;

    DTOSalida obtenerNivelesConcursoREP(DTOBelcorp dtoIn)
            throws MareException, RemoteException;

    DTOSalida cargarNroConcursoVersion(DTOBuscarNumConcurso DTOE)
            throws RemoteException, MareException;

    void guardarProductos(DTOConcurso DTOE) throws MareException, RemoteException;

    DTOConcurso obtenerConcursoParaCambios(DTOOID dtoe)
            throws MareException, RemoteException;

    void guardarPremiosNuevaVersion(DTOConcurso dtoConcurso)
            throws MareException, RemoteException;

    void guardarRequisitosPremiacion(DTORequisitosPremiacion DTOE, DTOCursosExigidosPremiacion lstCursosExigidos, Long oidConcurso)
            throws MareException, RemoteException;

  void guardarProductosNuevaVersion(DTOConcurso dtoConcurso) throws MareException, RemoteException;
  
  void guardarEstatusVentaConsultoras(DTOConcurso DTOE, Long oidConcurso) throws RemoteException, MareException;

  void borrarVersionConcurso(DTOOID DTOE) throws MareException, RemoteException;

  DTOSalida obtenerBaseIncumplimiento(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerConcursosMonetarios(DTOBusquedaClienteCalificado dto) throws MareException, RemoteException;

  DTOSalida obtenerMontoVentaRep(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida obtenerTiposPrograma(DTOBelcorp DTOE) throws MareException, RemoteException;
  
  DTOSalida obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE) throws MareException, RemoteException;
  
  DTOSalida obtenerTipoMovimiento(DTOBelcorp DTOE) throws MareException, RemoteException;
  
  void guardarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento) throws MareException, RemoteException;

    DTOSalida obtenerClasificacionConcurso(DTOBelcorp dtoe) throws MareException, 
                                                                   RemoteException;

    void guardarNiveleSorteoPremiacion(DTOParametrosGeneralesPremiacion dtoeParametrosGeneralesPremiacion, 
                                       Long oidConcurso) throws MareException, 
                                                                RemoteException;

    DTOSalida validarDeuda(DTOBelcorp dtoe) throws MareException, 
                                                   RemoteException;

    DTOSalida obtenerTipoOfertaConcurso(DTOBelcorp dtoe) throws MareException, 
                                                                RemoteException;
}
