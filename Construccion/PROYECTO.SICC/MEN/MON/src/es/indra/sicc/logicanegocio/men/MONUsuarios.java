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
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.sicc.dtos.men.DTOEntradaBorrarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPais;
import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaInsertarUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaMENSeguridad;
import es.indra.sicc.dtos.men.DTOSalidaDepartamentosPerfiles;
import es.indra.sicc.dtos.men.DTOSalidaMantenimientoUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPassword;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import java.util.HashMap;

import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.men.DTOIdentUsuario;
import es.indra.sicc.util.DTOString;

/**
 * Sistema:       Belcorp
 * Modulo:        MEN - Menú
 * Componente:    MONUsuarios - Interfaz remota
 * Fecha:         09/04/2003
 * Dcoumentacion: Este componente se construyó de acuerdo al siguiente documento
 *                - SICC-DMCO-MEN-001-200 (publicado el 06/03/2003) [REF 1]
 * Observaciones: Este componente tiene como objetivo proveer la interfaz remota
 *                del MONUsuarios
 * 
 * @version       1.0
 * @author        Pablo Daniel Iorio
 */

public interface MONUsuarios extends EJBObject 
{

/**
   * El método crea una entidad Usuario
   *
   * @param DTOEntradaInsertarUsuarios dtoe
   * @return void
   * @throws MareException, RemoteException
  */
  void createUsuario(DTOEntradaInsertarUsuarios dtoe) 
    throws MareException, RemoteException;

/**
   * El método modifica los atributos de un Usuario
   *
   * @param DTOEntradaModificarUsuarios dtoe
   * @return void
   * @throws MareException, RemoteException
  */
  void modificarUsuario(DTOEntradaInsertarUsuarios dtoe) 
    throws RemoteException, MareException;

/**
   * El método elimina el usuario especificado en el parametro de entrada
   *
   * @param DTOEntradaBorrarUsuario dtoe
   * @return void
   * @throws MareException, RemoteException
  */    
  void removeUsuario(DTOEntradaBorrarUsuario dtoe) 
    throws RemoteException, MareException;

/**
   * El método realiza una busqueda en la entidad Usuario y retorna los 
   * usuarios que coincidan con los especificados en el parametro de entrada
   *
   * @param DTOEntradaCriteriosDeBusquedaUsuarios dtoe
   * @return DTOSalida
   * @throws MareException, RemoteException
  */    
    
  DTOSalida buscarUsuario(DTOEntradaCriteriosDeBusquedaUsuarios dtoe) 
    throws RemoteException, MareException;

/**
   * El método realiza una consulta en la entidad Usuario y retorna las 
   * propiedades del usuario que coincida con lo especificado en el parametro 
   * de entrada
   *
   * @param DTOConsultarUsuario dtoe
   * @return DTOSalida
   * @throws MareException, RemoteException
  */
  DTOSalida consultarUsuario(DTOEntradaConsultarUsuario dtoe) 
    throws RemoteException, MareException;

    DTOSalidaMantenimientoUsuarios prepararMantenimiento(DTOEntradaMENSeguridad dtoe) throws MareException, RemoteException;

    String modificaPaisDefecto(DTOEntradaCambiarPais dtoe) throws RemoteException, MareException;

    String obtenerPaginaInicio(DTOEntradaMENSeguridad dtoe) throws MareException, RemoteException;

    DTOSalida obtenerUsuarios(DTOBelcorp dtoin) throws RemoteException, MareException;

	DTOSalida obtenerCodUsuarios(DTOBelcorp dto) throws RemoteException, MareException;

  DTOIdentUsuario obtenerUsuario(DTOIdentUsuario dtoe) throws RemoteException, MareException;

    DTOSalida recargarFuncionesMenu(DTOString dto) throws MareException, RemoteException;

    DTOSalida recargaAccesosScr(DTOString dtoe) throws RemoteException, MareException;

    DTOSalida recargaSubAccesosScr(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida recargaSubGerenciasScr(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida recargaSociedadesScr(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida recargaRegionesScr(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida recargaZonasScr(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida recargaSeccionesScr(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida recargaTerritoriosPorSeccionesScr(DTOString dtoe) throws RemoteException, MareException;

    DTOSalida recuperaUsuariosSustitucion(DTOString dtoe) throws MareException, RemoteException;

    DTOSalida consultarUsuario2(DTOEntradaConsultarUsuario dtoe) throws MareException, RemoteException;

    /**

     *
     * @param IMareDTO dtoe
     * @return DTOSalidaMantenimientoUsuarios
     * @throws MareException, RemoteException
     */
    HashMap getMergedProperties(DTOEntradaConsultarUsuario dtoe) throws MareException, 
                                                                        RemoteException;

    HashMap getProperties(UserIDImpl usr) throws MareException, 
                                                 RemoteException;

    void cambiarPassword(DTOEntradaCambiarPassword dtoe) throws MareException, RemoteException;

    DTOSalida getProperties2(UserIDImpl usr) throws MareException, RemoteException;

    DTOSalidaDepartamentosPerfiles preparaMantenimientoBusqueda(Long idioma) throws MareException, RemoteException;
}
