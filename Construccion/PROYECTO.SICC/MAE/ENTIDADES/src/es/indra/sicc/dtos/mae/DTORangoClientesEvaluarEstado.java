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

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           09/09/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Fernando Coronel
 */

public class DTORangoClientesEvaluarEstado  extends DTOAuditableSICC {
  private RecordSet consultoras;
  private Long      periodo;
  private Boolean   indReevaluacion;

  public RecordSet getConsultoras() {
    return consultoras;
  }

  public void setConsultoras(RecordSet newConsultoras) {
    consultoras = newConsultoras;
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo) {
    periodo = newPeriodo;
  }

  public void setIndReevaluacion(Boolean indReevaluacion) {
    this.indReevaluacion = indReevaluacion;
  }

  public Boolean getIndReevaluacion() {
    return indReevaluacion;
  }
  
}