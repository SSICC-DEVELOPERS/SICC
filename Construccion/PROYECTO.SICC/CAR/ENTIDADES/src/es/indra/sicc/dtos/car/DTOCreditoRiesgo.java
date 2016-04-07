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
package es.indra.sicc.dtos.car;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOCreditoRiesgo extends DTOSiccPaginacion  {
    private Long nivelRiesgo;
    private BigDecimal montoLineaCredito;
  private Long oidCliente;
  private Long oidPeriodo;
  private BigDecimal pedidoPromedio;

    public DTOCreditoRiesgo() {
    }

    public Long getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(Long newNivelRiesgo) {
        nivelRiesgo = newNivelRiesgo;
    }

    public BigDecimal getMontoLineaCredito() {
        return montoLineaCredito;
    }

    public void setMontoLineaCredito(BigDecimal newMontoLineaCredito) {
        montoLineaCredito = newMontoLineaCredito;
    }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }

  public BigDecimal getPedidoPromedio() {
    return pedidoPromedio;
  }

  public void setPedidoPromedio(BigDecimal pedidoPromedio) {
    this.pedidoPromedio = pedidoPromedio;
  }
  
  
}
