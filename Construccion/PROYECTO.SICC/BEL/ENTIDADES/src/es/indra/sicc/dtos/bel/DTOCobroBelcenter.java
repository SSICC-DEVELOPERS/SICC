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

import java.util.ArrayList;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCobroBelcenter extends DTOAuditableSICC
{
  private DTOMovimientoCaja movimientoCaja;
  private ArrayList movimientoCajaDetalle;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidSubacceso;
  private BigDecimal totalImporte;
  private Boolean enviarMensaje;
  private Boolean generarMovimiento;
  private Long oidEmpresa;
  private Long oidCuentaCorriente;
  private Long oidTipoTransaccion;
  private Long numeroLote;
  private Boolean continuaFacturacion;

  public DTOCobroBelcenter()
  {
  }

  public DTOMovimientoCaja getMovimientoCaja()
  {
    return movimientoCaja;
  }

  public void setMovimientoCaja(DTOMovimientoCaja movimientoCaja)
  {
    this.movimientoCaja = movimientoCaja;
  }

  public ArrayList getMovimientoCajaDetalle()
  {
    return movimientoCajaDetalle;
  }

  public void setMovimientoCajaDetalle(ArrayList movimientoCajaDetalle)
  {
    this.movimientoCajaDetalle = movimientoCajaDetalle;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public BigDecimal getTotalImporte()
  {
    return totalImporte;
  }

  public void setTotalImporte(BigDecimal totalImporte)
  {
    this.totalImporte = totalImporte;
  }

  public Boolean getEnviarMensaje()
  {
    return enviarMensaje;
  }

  public void setEnviarMensaje(Boolean enviarMensaje)
  {
    this.enviarMensaje = enviarMensaje;
  }

  public Boolean getGenerarMovimiento()
  {
    return generarMovimiento;
  }

  public void setGenerarMovimiento(Boolean generarMovimiento)
  {
    this.generarMovimiento = generarMovimiento;
  }

  public Long getOidEmpresa()
  {
    return oidEmpresa;
  }

  public void setOidEmpresa(Long oidEmpresa)
  {
    this.oidEmpresa = oidEmpresa;
  }

  public Long getOidCuentaCorriente()
  {
    return oidCuentaCorriente;
  }

  public void setOidCuentaCorriente(Long oidCuentaCorriente)
  {
    this.oidCuentaCorriente = oidCuentaCorriente;
  }

  public Long getOidTipoTransaccion()
  {
    return oidTipoTransaccion;
  }

  public void setOidTipoTransaccion(Long oidTipoTransaccion)
  {
    this.oidTipoTransaccion = oidTipoTransaccion;
  }

  public Long getNumeroLote()
  {
    return numeroLote;
  }

  public void setNumeroLote(Long numeroLote)
  {
    this.numeroLote = numeroLote;
  }

  public Boolean getContinuaFacturacion()
  {
    return continuaFacturacion;
  }

  public void setContinuaFacturacion(Boolean continuaFacturacion)
  {
    this.continuaFacturacion = continuaFacturacion;
  }
  
}