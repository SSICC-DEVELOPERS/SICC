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
 *
 */

package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

public interface ICNCronograma  {

  public DTOBoolean existeCronograma(DTOCronograma dto) throws MareException;

  public DTOCronograma generaCronograma(DTOCronograma dto) throws MareException;

  public void actualizaCronograma(DTOCronograma dto) throws MareException;

  public DTOCronograma obtieneTipoFacturacion (DTOCronograma dto) throws MareException;

  public DTOCronograma obtieneCronograma(DTOCronograma dto) throws MareException;

  public void eliminaCronograma(DTOCronograma dto) throws MareException;

}