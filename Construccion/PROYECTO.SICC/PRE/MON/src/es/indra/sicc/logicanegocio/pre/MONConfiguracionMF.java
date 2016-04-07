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
import es.indra.sicc.dtos.pre.DTODatosEstrategia;
import es.indra.sicc.dtos.pre.DTOEConfiguracionMF;
import es.indra.sicc.dtos.pre.DTOELeerConfiguracionMF;
import es.indra.sicc.dtos.pre.DTOSConfiguracionMF;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONConfiguracionMF extends EJBObject  {
  DTOSConfiguracionMF leerConfiguracion(DTOELeerConfiguracionMF dto) throws MareException, RemoteException;

  void guardarConfiguracion(DTOEConfiguracionMF dto) throws RemoteException, MareException;

  void guardarEstrategia(DTODatosEstrategia dto) throws MareException, RemoteException;

  void modificarEstrategia(DTODatosEstrategia dtoe) throws MareException, RemoteException;

  void eliminarEstrategia(DTOOIDs dtoe) throws MareException, RemoteException;

  DTODatosEstrategia obtenerDetalleEstrategia(DTOOID dtoe) throws MareException, RemoteException;

  DTOOID obtenerArgumentoVentaEstrategia(DTOOID dtoe) throws MareException, RemoteException;

  DTOOID obtenerMarcaMF(DTOOID dtoe) throws MareException, RemoteException;

  DTOSalida buscarEstrategias(DTODatosEstrategia dtoe) throws MareException, RemoteException;
}