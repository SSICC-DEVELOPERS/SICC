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
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTOEFicheroGP;
import es.indra.sicc.dtos.pre.DTOSFicheroGP;


public interface MONGP extends EJBObject  {
   DTOSFicheroGP generarGP(DTOEFicheroGP dto) throws MareException, RemoteException;

   DTOSFicheroGP generarCabeceraGP(DTOEFicheroGP dto) throws MareException, RemoteException;
}