/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.inc;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * Sistema:        Sicc Belcorp
 * Modulo:        INC
 * Fecha:                01/06/2005
 * @version        1.0
 * @autor                enozigli
 */
public interface MONPremiacionMultinivelHome
        extends EJBHome {
    MONPremiacionMultinivel create() throws RemoteException, CreateException;
}
