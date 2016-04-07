/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTODatosPagarComision
 * Fecha:             20/12/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTODatosPagarComision
 * @version           1.0
 * @autor             Viviana Bongiovanni
 */
package es.indra.sicc.dtos.com;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODatosPagarComision extends DTOSiccPaginacion {
  private Long oidComision;
  private String fechaCalculo;
  private String formatoFecha;

  public DTODatosPagarComision() {
  }

  public Long getOidComision() {
    return oidComision;
  }

  public void setOidComision(Long oidComision) {
    this.oidComision = oidComision;
  }

  public String getFechaCalculo() {
    return fechaCalculo;
  }

  public void setFechaCalculo(String fechaCalculo) {
    this.fechaCalculo = fechaCalculo;
  }

  public String getFormatoFecha() {
    return formatoFecha;
  }

  public void setFormatoFecha(String formatoFecha) {
    this.formatoFecha = formatoFecha;
  }
}