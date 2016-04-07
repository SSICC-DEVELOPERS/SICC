/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.bel;

import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOComprobarInicioCobro extends DTOAuditableSICC
{
  private String IP;
  private Long oidCaja;
  private String caja;
  private BigDecimal totalPagarLocal;
  private BigDecimal totalPagarDocumento;
  private Long oidCabeceraSolicitud;
  private Long oidSubacceso;
  private Long oidTipoMovimientoCobrar;
  private BigDecimal montoMaximoDiferencia;
  private Long oidCuentaCorriente;
  private Long oidEmpresa;
  private Long oidTipoTransaccion;
  private Boolean cobrarBelcenter;
  private Long numeroConsolidado;
  /**
   * Atributo divisa agregado por Guido Pons
   * Fecha 03/05/2005
   * Incidencia DBLG400000833 
  */
  private String divisa;
  

  public DTOComprobarInicioCobro()
  {
  }

  public String getDivisa()
  {
    return this.divisa;
  }
  
  public void setDivisa(String divisa)
  {
    this.divisa = divisa;
  }
  
  public String getIP()
  {
    return IP;
  }

  public void setIP(String IP)
  {
    this.IP = IP;
  }

  public Long getOidCaja()
  {
    return oidCaja;
  }

  public void setOidCaja(Long oidCaja)
  {
    this.oidCaja = oidCaja;
  }

  public String getCaja()
  {
    return caja;
  }

  public void setCaja(String caja)
  {
    this.caja = caja;
  }

  public BigDecimal getTotalPagarLocal()
  {
    return totalPagarLocal;
  }

  public void setTotalPagarLocal(BigDecimal totalPagarLocal)
  {
    this.totalPagarLocal = totalPagarLocal;
  }

  public BigDecimal getTotalPagarDocumento()
  {
    return totalPagarDocumento;
  }

  public void setTotalPagarDocumento(BigDecimal totalPagarDocumento)
  {
    this.totalPagarDocumento = totalPagarDocumento;
  }

  public Long getOidCabeceraSolicitud()
  {
    return oidCabeceraSolicitud;
  }

  public void setOidCabeceraSolicitud(Long oidCabeceraSolicitud)
  {
    this.oidCabeceraSolicitud = oidCabeceraSolicitud;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Long getOidTipoMovimientoCobrar()
  {
    return oidTipoMovimientoCobrar;
  }

  public void setOidTipoMovimientoCobrar(Long oidTipoMovimientoCobrar)
  {
    this.oidTipoMovimientoCobrar = oidTipoMovimientoCobrar;
  }

  public BigDecimal getMontoMaximoDiferencia()
  {
    return montoMaximoDiferencia;
  }

  public void setMontoMaximoDiferencia(BigDecimal montoMaximoDiferencia)
  {
    this.montoMaximoDiferencia = montoMaximoDiferencia;
  }

  public Long getOidCuentaCorriente()
  {
    return oidCuentaCorriente;
  }

  public void setOidCuentaCorriente(Long oidCuentaCorriente)
  {
    this.oidCuentaCorriente = oidCuentaCorriente;
  }

  public Long getOidEmpresa()
  {
    return oidEmpresa;
  }

  public void setOidEmpresa(Long oidEmpresa)
  {
    this.oidEmpresa = oidEmpresa;
  }

  public Long getOidTipoTransaccion()
  {
    return oidTipoTransaccion;
  }

  public void setOidTipoTransaccion(Long oidTipoTransaccion)
  {
    this.oidTipoTransaccion = oidTipoTransaccion;
  }

  public Boolean getCobrarBelcenter()
  {
    return cobrarBelcenter;
  }

  public void setCobrarBelcenter(Boolean cobrarBelcenter)
  {
    this.cobrarBelcenter = cobrarBelcenter;
  }

  public Long getNumeroConsolidado() {
    return numeroConsolidado;
  }

  public void setNumeroConsolidado(Long numeroConsolidado) {
    this.numeroConsolidado = numeroConsolidado;
  }
}