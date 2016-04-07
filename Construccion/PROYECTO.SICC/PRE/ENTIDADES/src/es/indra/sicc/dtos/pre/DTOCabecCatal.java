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
 
package es.indra.sicc.dtos.pre;

import es.indra.sicc.util.DTOBelcorp;
/*
 * enozigli - 06/09/2005: se crea la clase
 * */
public class DTOCabecCatal extends DTOBelcorp  {
  private Long oidCabecera;
  private Long oidCatalogo;

  public DTOCabecCatal() {
  }

  public Long getOidCabecera() {
    return oidCabecera;
  }

  public void setOidCabecera(Long oidCabecera) {
    this.oidCabecera = oidCabecera;
  }

  public Long getOidCatalogo() {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long oidCatalogo) {
    this.oidCatalogo = oidCatalogo;
  }
}