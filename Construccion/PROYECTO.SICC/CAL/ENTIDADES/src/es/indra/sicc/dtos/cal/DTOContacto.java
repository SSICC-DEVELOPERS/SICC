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

public class DTOContacto extends DTOBelcorp{
  public DTOContacto() {
    super();
  }
  
  private Long oidContacto;    
  private Long oidEstado;   
  private Long oidAtributo; 

  public Long getOidAtributo()
  {
    return oidAtributo;
  }

  public void setOidAtributo(Long oidAtributo)
  {
    this.oidAtributo = oidAtributo;
  }

  public Long getOidContacto()
  {
    return oidContacto;
  }

  public void setOidContacto(Long oidContacto)
  {
    this.oidContacto = oidContacto;
  }

  public Long getOidEstado()
  {
    return oidEstado;
  }

  public void setOidEstado(Long oidEstado)
  {
    this.oidEstado = oidEstado;
  }

  
}