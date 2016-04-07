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

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            ZON - Seguridad
 * Componente:        Interface IServiceEstructuraVial
 *
 * @version           1.0
 */ 
 
package es.indra.sicc.logicanegocio.zon;

import es.indra.sicc.dtos.zon.DTOELocalizacionDirecciones;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.mare.common.exception.MareException;

public interface IServiceEstructuraVial  {

	public DTOUBIGEOS localizarDireccion(DTOELocalizacionDirecciones datosdir) throws MareException;
	
}