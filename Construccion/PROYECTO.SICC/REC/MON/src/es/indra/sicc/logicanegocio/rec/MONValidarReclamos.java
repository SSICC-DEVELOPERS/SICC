/**
 * Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOBelcorp;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.rec.DTOValidarReclamo;

public interface MONValidarReclamos extends EJBObject  {
    void procesoValidacionReclamos(DTOBelcorp dtoBelcorp) throws MareException, RemoteException;

  void calcularImporteReclamoAnulacion(DTOValidarReclamo dto) throws MareException, RemoteException;
}