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

package es.indra.sicc.logicanegocio.edu;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;

public interface IEDU {
  	public DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws MareException; //incidencia 12320, incidencia 12556
}