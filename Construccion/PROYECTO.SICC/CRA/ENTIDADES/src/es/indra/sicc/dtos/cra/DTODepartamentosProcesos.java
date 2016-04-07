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
package es.indra.sicc.dtos.cra;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;
import java.sql.Date;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
/**
 * Sistema:       Belcorp
 * Modulo:        CRA - Actividades
 * Componente:    DTODepartamentosProcesos 
 * Fecha:         26/11/2003
 * Observaciones: 
 * 
 * @version       2.0
 * @author        NRMinett
 */

public class DTODepartamentosProcesos extends DTOAuditableSICC {

  private RecordSet procesosDisponibles;
  private RecordSet procesosAsignados;
  private RecordSet departamentos;
  private RecordSet tiposDireccion;

  public DTODepartamentosProcesos() {
  }

  public RecordSet getProcesosDisponibles() {
    return procesosDisponibles;
  }

  public void setProcesosDisponibles(RecordSet newProcesosDisponibles) {
    procesosDisponibles = newProcesosDisponibles;
  }

  public RecordSet getProcesosAsignados() {
    return procesosAsignados;
  }

  public void setProcesosAsignados(RecordSet newProcesosAsignados) {
    procesosAsignados = newProcesosAsignados;
  }

  public RecordSet getDepartamentos() {
    return departamentos;
  }

  public void setDepartamentos(RecordSet newDepartamentos) {
    departamentos = newDepartamentos;
  }

  public RecordSet getTiposDireccion() {
    return tiposDireccion;
  }

  public void setTiposDireccion(RecordSet newTiposDireccion) {
    tiposDireccion = newTiposDireccion;
  }
}