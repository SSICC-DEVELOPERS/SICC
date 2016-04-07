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

import javax.ejb.EJBHome;
import javax.ejb.CreateException;

import java.rmi.RemoteException;

/**
 * Sistema:       Belcorp
 * Modulo:        MEN - Menú
 * Componente:    MONUsuarios - Interfaz Home
 * Fecha:         09/04/2003
 * Dcoumentacion: Este componente se construyó de acuerdo al siguiente documento
 *                - SICC-DMCO-MEN-001-200 (publicado el 06/03/2003) [REF 1]
 * Observaciones: Este componente tiene como objetivo proveer la interfaz home
 *                del MONUsuarios
 * 
 * @version       1.0
 * @author        Pablo Daniel Iorio
 */

public interface MONUsuariosHome extends EJBHome 
{

/**
   * El método crea una nueva instancia de MONUsuarios
   *
   * @return MONUsuarios
   * @throws RemoteException, CreateException
  */
  MONUsuarios create() throws RemoteException, CreateException;
}
