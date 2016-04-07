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
 * Modulo:        MEN
 * Componente:    MONFuncionesMenu - Interfaz Home
 * Fecha:         01/04/2003
 *
 * @version       1.0
 * @author        Pablo Daniel Iorio
 */

public interface MONFuncionesMenuHome extends EJBHome  {
    MONFuncionesMenu create() throws RemoteException, CreateException;
}