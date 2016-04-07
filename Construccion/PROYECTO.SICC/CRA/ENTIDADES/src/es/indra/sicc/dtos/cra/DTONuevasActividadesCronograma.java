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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:      Cronograma de Actividades
 * Componente:    DTO's
 * Fecha:             15/11/2004
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor               Luis Ramos
 */

public class DTONuevasActividadesCronograma extends DTOAuditableSICC  {

  private Long oidMarca;
  private Long oidCanal;
  private RecordSet actividadesCronograma;

    public DTONuevasActividadesCronograma() {
    }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca) {
    oidMarca = newOidMarca;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal) {
    oidCanal = newOidCanal;
  }

  public RecordSet getActividadesCronograma() {
    return actividadesCronograma;
  }

  public void setActividadesCronograma(RecordSet newActividadesCronograma) {
    actividadesCronograma = newActividadesCronograma;
  }

    
  
}