/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.cal;
import es.indra.sicc.util.DTOBelcorp;
public class DTOReclamo extends DTOBelcorp

{
  public Long oidContacto;   
  public Long oidCabecera;    
  public String codUsuario;     
  public String descripcionActividad;     
  public Long oidTipoGestionCliente;   
  public String observaciones;
  
  public DTOReclamo()
  {
  }

  public String getCodUsuario()
  {
    return codUsuario;
  }

  public void setCodUsuario(String codUsuario)
  {
    this.codUsuario = codUsuario;
  }

  public String getDescripcionActividad()
  {
    return descripcionActividad;
  }

  public void setDescripcionActividad(String descripcionActividad)
  {
    this.descripcionActividad = descripcionActividad;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Long getOidCabecera()
  {
    return oidCabecera;
  }

  public void setOidCabecera(Long oidCabecera)
  {
    this.oidCabecera = oidCabecera;
  }

  public Long getOidContacto()
  {
    return oidContacto;
  }

  public void setOidContacto(Long oidContacto)
  {
    this.oidContacto = oidContacto;
  }

  public Long getOidTipoGestionCliente()
  {
    return oidTipoGestionCliente;
  }

  public void setOidTipoGestionCliente(Long oidTipoGestionCliente)
  {
    this.oidTipoGestionCliente = oidTipoGestionCliente;
  }
}