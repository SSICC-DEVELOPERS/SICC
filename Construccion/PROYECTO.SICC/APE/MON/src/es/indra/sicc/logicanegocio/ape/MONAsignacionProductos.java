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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;
import es.indra.sicc.dtos.ape.DTOCalcularHit;
import es.indra.sicc.dtos.ape.DTODesasignarProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOMantenerEstimadosProducto;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import java.util.ArrayList;
import java.util.Collection;

public interface MONAsignacionProductos extends EJBObject {
  void guardarEstimadosProducto (DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto) throws MareException, RemoteException;
  DTOSalida obtenerProcedencia (DTOBelcorp dtoe) throws MareException, RemoteException;
  DTOSalida consultarEstimadosProducto (DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto) throws MareException, RemoteException;
  void eliminarEstimadosProducto (DTOOIDs dtoe) throws MareException, RemoteException;
  DTOSalida obtenerVersionesAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException, RemoteException;
  DTOMantenerAsignacionProductosAnaqueles validarAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException, RemoteException;
  DTOOID validarNuevaVersionAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) throws RemoteException, MareException;
  DTOSalida consultarAsignacionProductosAnaqueles(DTODesasignarProductosAnaqueles dtoe) throws RemoteException, MareException;
  DTOSalida consultarVersionesAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException, RemoteException;
  void eliminarAsignacionProductosAnaqueles(DTOOIDs dtoe) throws MareException, RemoteException;
  void guardarAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException, RemoteException;
  DTOSalida calcularHit(DTOCalcularHit dtoE) throws MareException, RemoteException;
  DTOMantenerEstimadosProducto generarEstimadosProducto(DTOMantenerEstimadosProducto dtoe) throws RemoteException, MareException;
  void eliminarEstimadosVentaMAV(DTOMantenerEstimadosProducto dtoe) throws MareException, RemoteException;
  void generarEstimadosVentaMAV(DTOMantenerEstimadosProducto dtoe) throws MareException, RemoteException;
  void sobreEscribirGeneracionEstimadosProducto(DTOMantenerEstimadosProducto dtoe) throws MareException, RemoteException;
  void insertarAsignacionProductoDetalles(ArrayList detalles) throws RemoteException, MareException;
  void copiarAsignacionProductosAnaqueles(DTOAsignacionProductoAnaquelCabecera dtoe) throws MareException, RemoteException;
  void activarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE) throws MareException, RemoteException;
  Collection obtenerVersionesAsignacionActiva(DTOMantenerAsignacionProductosAnaqueles dtoE) throws MareException, RemoteException;

  void desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE) throws RemoteException, MareException;

    DTOSalida desProduInter(DTOMantenerEstimadosProducto dtoe) throws MareException, 
                                                                      RemoteException;
}
