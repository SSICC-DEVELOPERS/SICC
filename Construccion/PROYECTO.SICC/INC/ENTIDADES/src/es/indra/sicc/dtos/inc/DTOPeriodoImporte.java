package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

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
 * @autor Javier Quiroga - CDOS - jquiroga@indra.com.ar
 * @date 26/05/2005
 */
public class DTOPeriodoImporte extends DTOBelcorp 
{
  public Long oidPeriodo;
  public Long cantidad;
  public BigDecimal importe;

  public DTOPeriodoImporte()
  {
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getCantidad()
  {
    return cantidad;
  }

  public void setCantidad(Long cantidad)
  {
    this.cantidad = cantidad;
  }

  public BigDecimal getImporte()
  {
    return importe;
  }

  public void setImporte(BigDecimal importe)
  {
    this.importe = importe;
  }
  
}