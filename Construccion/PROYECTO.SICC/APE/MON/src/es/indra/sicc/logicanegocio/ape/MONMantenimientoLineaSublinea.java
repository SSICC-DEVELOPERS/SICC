/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ape.DTOBuscarLineasArmado;
import es.indra.sicc.dtos.ape.DTOBuscarSublineaArmado;
import es.indra.sicc.dtos.ape.DTOInsertarLineaArmado;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOTipoCajaProducto;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTOSublineasLineaOrdenacion;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONMantenimientoLineaSublinea extends EJBObject {
    void insertarTipoCajaProducto(DTOTipoCajaProducto dtoe) throws MareException, RemoteException;

    DTOSalida buscarTipoCajaProducto(DTOTipoCajaProducto dtoe) throws MareException, RemoteException;

    void eliminarTipoCajaProducto(DTOOIDs dtoe) throws MareException, RemoteException;

    DTOSalida obtenerLineasArmadoCD(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida obtenerSublineasArmadoCD(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida obtenerLineasMapaCD(DTOOID dtoe) throws RemoteException, MareException;

    DTOSalida consultarSistemaPicado(DTOSiccPaginacion dtoE) throws RemoteException, MareException;

    DTOSalida obtenerSublineasLinea(DTOOID dtoe) throws RemoteException, MareException;

    DTOOID obtenerProximoCodigoLinea(DTOBelcorp dtoE) throws RemoteException, MareException;

    DTOSalida obtenerProgramasCubicaje(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida buscarTipoCajaSublinea(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida buscarSublineasArmado(DTOBuscarSublineaArmado dtoe) throws RemoteException, MareException;

    DTOOID obtenerProximoCodigoSublinea() throws RemoteException, MareException;

    void eliminarSublineas(DTOOIDs dtoe) throws MareException, RemoteException;

    void eliminarTiposCajaSublinea(DTOOIDs dtoe) throws MareException, RemoteException;

    void modificarSublineaArmado(DTOSublineaArmado dtoSublineaArmado) throws RemoteException, MareException;

    void insertarTiposCajaSublinea(DTOSublineaArmado tiposCajaSublineas) throws RemoteException, MareException;

    void insertarSublineaArmado(DTOSublineaArmado dtoSublineaArmado) throws RemoteException, MareException;

    DTOSalida obtenerSistemasEtiquetado(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOOID insertarLineaArmado(DTOInsertarLineaArmado dtoE) throws MareException, RemoteException;

    DTOSalida recuperarTiposSolicitudLinea(DTOOID dtoE) throws MareException, RemoteException;

    DTOSalida obtenerLineasArmadoCDAFP(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida obtenerLineasArmadoCDNoAFP(DTOOID dtoe) throws MareException, RemoteException;

    void modificarLineaArmado(DTOInsertarLineaArmado dtoE) throws MareException, RemoteException;

    DTOSalida obtenerLineasMapaZona(DTOOID dtoe) throws RemoteException, MareException;

    DTOSalida obtenerUsuariosAlarmaLinea(DTOOID dtoE) throws MareException, RemoteException;

    DTOSalida obtenerDescripcionesLineas(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida buscarLineasArmado(DTOBuscarLineasArmado dtoE) throws RemoteException, MareException;

    void eliminarLineasArmado(DTOOIDs dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposSolicitudLinea(DTOOID dtoE) throws RemoteException, MareException;

    DTOSalida recuperarSublineasLinea(DTOOID dtoe) throws MareException, RemoteException;

  DTOSalida consultaCodigosImpresora(DTOBelcorp dtoe) throws RemoteException, MareException;

  DTOSalida recuperarSublineasLineaBalanceo(DTOSublineasLineaOrdenacion dtoe) throws RemoteException, MareException;

  DTOSalida recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe) throws RemoteException, MareException;

}