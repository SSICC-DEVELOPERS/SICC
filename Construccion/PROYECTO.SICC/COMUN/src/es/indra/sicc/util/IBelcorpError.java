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
package es.indra.sicc.util;

import java.io.Serializable;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:
 * Fecha:             30/05/2003
 * Observaciones:
 * Descripcion:
 * @version           1.0
 * @autor             Agustin Palacios
 */
public interface IBelcorpError {
   DTOError obtenerError(Throwable exception);

   DTOError obtenerError(Throwable exception, String language, String country);
}
