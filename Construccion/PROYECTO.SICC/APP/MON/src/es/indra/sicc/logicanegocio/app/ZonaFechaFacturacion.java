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

package es.indra.sicc.logicanegocio.app;

import java.util.Date;

/*
 * Clase creada por incidencia DBLG700000178
 * Autor: dmorello
 * Fecha: 17/11/2006
 */
public class ZonaFechaFacturacion 
{
  private Long oidZona;
  private Date fechaFacturacion;

  public ZonaFechaFacturacion() {
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Date getFechaFacturacion()
  {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Date fechaFacturacion)
  {
    this.fechaFacturacion = fechaFacturacion;
  }
  
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    } else if (o == this) {
      return true;
    } else {
      ZonaFechaFacturacion zff = (ZonaFechaFacturacion)o;
      return this.oidZona.equals(zff.oidZona) && this.fechaFacturacion.equals(zff.fechaFacturacion);
    }
  }
  
  public int hashCode() {
    String s = this.oidZona.toString() + this.fechaFacturacion.toString();
    return s.hashCode();
  }
  
  
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[oidZona=").append(this.oidZona);
    sb.append(";fechaFacturacion=").append(this.fechaFacturacion).append(']');
    return sb.toString();
  }


}