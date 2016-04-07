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
package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.mare.common.exception.MareException;

/**
 * Sistema:         Belcorp
 * Modulo:          CRA - Cronograma de Actividades
 * Componente:      IDAOCRA
 * Fecha:           22/1/2004
 * Observaciones:   
 *
 * @version         1.0
 * @author          
 */

public interface IDAOCRA  {

    public RecordSet obtienePeriodoPorTipo (Long oidPais, Long oidMarca, Long oidCanal, Long oidTipoPeriodo) throws MareException;
    public DTOSalida obtienePeriodo (DTOPeriodo dto) throws MareException;
    public DTOPeriodo obtienePeriodoPorCodigo (String codigo, String tipo) throws MareException;
    public Long obtienePeriodoSiguiente(Long oidPeriodo) throws MareException;
  	public Long obtienePeriodoAnterior(Long lngOidPeriodo) throws MareException;
    public Long obtieneOrigenCronogramaGrupoZonas (Long oidMatriz) throws MareException;
    public Long obtieneOrigenCronograma (Long oidCrono) throws MareException;
	public DTOSalida obtieneFechasCronograma (Long oidPais, Long oidCanal, Long oidZona, Long oidPeriodo, Long oidMarca, Long oidActividad) throws MareException;

}