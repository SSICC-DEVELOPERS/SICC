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
package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOCabecerasGruposZonas;
import es.indra.sicc.dtos.cra.DTOEntradaEliminarGrupoZonas;
import es.indra.sicc.dtos.cra.DTOGrupoZonas;
import es.indra.sicc.dtos.cra.DTOGruposZonas;
import es.indra.sicc.dtos.cra.DTOZonasGruposZonas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import java.util.Collection;
import java.util.Vector;

import javax.ejb.EJBObject;

public interface MONMantenimientoGruposZonas extends EJBObject  {
  void crear(DTOGrupoZonas dto) throws  RemoteException, MareException, RemoteException;

  DTOSalida consulta(DTOGrupoZonas dto) throws  RemoteException, MareException, RemoteException;

  void elimina(DTOGrupoZonas dto) throws  RemoteException, MareException, RemoteException;

  void modifica(DTOGrupoZonas dto) throws  RemoteException, MareException, RemoteException;

  DTOGrupoZonas obtenZonasPorGruposZonas(DTOGrupoZonas dto) throws  RemoteException, MareException, RemoteException;

  void compruebaZonasNoAsignadas(Long oidPais) throws  RemoteException, MareException, RemoteException;

  void asignacion(DTOCabecerasGruposZonas dtoCabecerasGruposZonas) throws MareException, RemoteException;

  DTOSalida consulta(Long marca, Long pais, Long canal, Long idioma) throws RemoteException, MareException;

  Collection consultaGruposZonasDetalles(Long marca, Long pais, Long canal, Long idioma) throws RemoteException, MareException;

  Collection crear(Collection dtoCabecerasGruposZonas) throws MareException, RemoteException;

  void elimina(DTOEntradaEliminarGrupoZonas dtoEntradaEliminarGrupoZonas) throws MareException, RemoteException;

  DTOSalida modifica(Long marca, Long pais, Long canal, Integer codigoGrupo, Vector nombresGrupo, Long tipoFactura) throws RemoteException, MareException;

  void mueveZonas(Collection allGroups) throws MareException, RemoteException;

  Collection obtenZonasPorGruposZonas(Collection dtoGruposZonasCollection) throws MareException, RemoteException;

  DTOSalida obtenerZonasDeGrupo(DTOGruposZonas dtoGrupoZona) throws MareException, RemoteException;

  Collection obtenerZonasNoAsignadas(Long pais, Long marca, Long canal) throws RemoteException, MareException;

  DTOZonasGruposZonas obtenerZonasPorGruposZonas(DTOZonasGruposZonas gruposZonas) throws MareException, RemoteException;

  DTOSalida obtenerZonasNoAsignadasPorRegion(Long pais, Long marca, Long canal, Long OidRegion) throws MareException, RemoteException;


  DTOSalida obtenerZonasNoAsignadasPorRegion(DTOGrupoZonas dto) throws MareException, RemoteException;

  DTOSalida obtieneGruposZona(DTOGrupoZonas dto) throws RemoteException, MareException;

  DTOSalida obtieneTiposFacturacion(DTOBelcorp dto) throws MareException, RemoteException;

	Long obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona) throws MareException, RemoteException;
  
    DTOSalida obtenerTipoFacturacion(DTOOID dto) throws MareException, RemoteException;
  
  
}