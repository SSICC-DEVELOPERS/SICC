/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.bel.DTOAnadirProductosRA;
import es.indra.sicc.dtos.bel.DTOEBuscarHDDetalleFlag;
import es.indra.sicc.dtos.bel.DTOEBuscarHojaDemandaDetalle;
import es.indra.sicc.dtos.bel.DTOEObtenerRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOERecuperarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimientoDetalle;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.dtos.bel.DTORegistroInterface;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;

public interface MONRegistroAbastecimiento extends EJBObject 
{
   DTORegistroAbastecimiento rellenarRegistroAbastecimiento(DTOERellenarRegistroAbastecimiento dto) throws RemoteException, MareException;
   DTOSalida rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dto) throws RemoteException, MareException;
   DTOSalida recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dto) throws RemoteException, MareException;
   DTORegistroAbastecimiento obtenerRegistroAbastecimiento(DTOOID dto) throws RemoteException, MareException;
   DTOSalida obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dto) throws RemoteException, MareException;
   DTORegistroAbastecimientoDetalle anadirProductosRA(DTOAnadirProductosRA dto) throws RemoteException, MareException;
   DTOSalida obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dto) throws RemoteException, MareException;
   void actualizarHojaDemanda(DTORegistroAbastecimiento dto) throws RemoteException, MareException;
   void guardarRegistroAbastecimiento(DTORegistroAbastecimiento dto) throws RemoteException, MareException;
   DTOSalida buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dto) throws RemoteException, MareException;
   DTOProducto buscarProductoHDDetalle(DTOString dto) throws RemoteException, MareException;
   void guardarHDDetalle(DTORegistroAbastecimientoDetalle dto) throws RemoteException, MareException;
   void guardarIngresoFisicoHD(DTORegistroAbastecimiento dto) throws RemoteException, MareException;
   void generarEntradaSAP(DTORegistroInterface dto) throws MareException, RemoteException;
  DTOSalida buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dto) throws MareException, RemoteException;

    void alertaCalculoSalidaSuperiorAlPrevisto(Long pais, Long subacceso) throws MareException, RemoteException;
}