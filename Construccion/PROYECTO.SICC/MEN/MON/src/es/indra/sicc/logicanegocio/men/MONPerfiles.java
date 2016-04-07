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

package es.indra.sicc.logicanegocio.men;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.men.DTOCargaPerfil;
import es.indra.sicc.dtos.men.DTOEntradaAgregarRoles;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusqueda;
import es.indra.sicc.dtos.men.DTOEntradaEliminarPerfil;
import es.indra.sicc.dtos.men.DTOEntradaInsertarPerfiles;
import es.indra.sicc.dtos.men.DTOEntradaModificarPerfiles;
import es.indra.sicc.dtos.men.DTOPerfil;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.dtos.men.DTOStrings;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import java.util.Collection;
import java.util.HashSet;

/**
 * Sistema:       Belcorp
 * Modulo:        MEN - Menú
 * Componente:    MONPerfiles - Interfaz remota
 * Fecha:         11/04/2003
 * Dcoumentacion Este componente se construyó de acuerdo al siguiente documento
 *                - SICC-DMCO-MEN-001-200 (publicado el 06/03/2003) [REF 1]
 * Observaciones Este componente tiene como objetivo proveer la interfaz remota
 *                del MONPerfiles
 * 
 * @version       1.0
 * @author        Pablo Daniel Iorio
 */
public interface MONPerfiles extends EJBObject 
{
	RecordSet recuperaTodos() throws RemoteException, MareException;

/**
   * El método elimina el perfil especificado en el parametro de entrada
   *
   * @param DTOEntradaBorrarPerfiles dtoe
   * @return void
   * @throws MareException, RemoteException
  */   
  void removePerfiles(DTOEntradaEliminarPerfil dtoe) throws RemoteException, MareException;

/**
   * El método modifica los atributos de un perfil
   *
   * @param DTOEntradaModificarPerfiles dtoe
   * @return void
   * @throws MareException, RemoteException
  */  
  void modificarPerfiles(DTOEntradaModificarPerfiles dtoe) 
    throws RemoteException, MareException;
/**
   * El método realiza una busqueda en la entidad Perfil y retorna los perfiles 
   * que coincidan con los especificados en el parametro de entrada
   *
   * @param DTOEntradaCriteriosDeBusqueda dtoe
   * @return DTOSalida
   * @throws MareException, RemoteException
  */ 
  DTOSalida buscarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe) throws RemoteException, MareException;

  void createPerfiles(DTOEntradaInsertarPerfiles dtoe) throws MareException, RemoteException;

/**
   * El método realiza una busqueda en la entidad Perfil y retorna el perfil 
   * que coincida con el especificado en el parametro de entrada
   *
   * @param DTOEntradaCriteriosDeBusqueda dtoe
   * @return DTOSalida
   * @throws MareException, RemoteException
  */ 
  DTOSalida consultarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe) 
    throws RemoteException, MareException;

	void crear(DTOPerfil dto) throws RemoteException, MareException;

	DTOCargaPerfil cargaInicial(DTOString dto) throws RemoteException, MareException;

	RecordSet obtenerFuncionesPerfil(DTOString dto) throws RemoteException, MareException;

	void eliminar(DTOStrings dto) throws RemoteException, MareException;

	void modificar(DTOPerfil dto) throws RemoteException, MareException;

	DTOSalida buscar(DTOString dto) throws RemoteException, MareException;

	Collection obtenerPropiedadesInicio(Long oidFuncion) throws RemoteException, MareException;

    void setRoles(DTOEntradaAgregarRoles dto, HashSet roles) throws MareException, RemoteException;

    DTOSalida recuperaPerfiles() throws MareException, RemoteException;
}

