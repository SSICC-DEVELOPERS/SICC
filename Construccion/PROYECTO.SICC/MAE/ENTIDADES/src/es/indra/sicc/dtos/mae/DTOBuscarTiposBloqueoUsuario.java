/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 */

package es.indra.sicc.dtos.mae;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarTiposBloqueoUsuario extends DTOBelcorp 
{
  private String usuario;
  private Long oidTipoBloqueo;

  public String getUsuario()
  {
    return usuario;
  }

  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
  }

  public Long getOidTipoBloqueo()
  {
    return oidTipoBloqueo;
  }

  public void setOidTipoBloqueo(Long oidTipoBloqueo)
  {
    this.oidTipoBloqueo = oidTipoBloqueo;
  }





}