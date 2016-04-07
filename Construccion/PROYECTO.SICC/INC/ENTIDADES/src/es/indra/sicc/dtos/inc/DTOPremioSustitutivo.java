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
 * Autor : Damasia Maneiro
 */
package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

import java.util.ArrayList;

public class DTOPremioSustitutivo extends DTOBelcorp 
{

  private Long tipoCambio;     
  private String observacionesCambio;
  private Long oidConcurso;     
  private Long oidSolicitud;     
  private Long oidCliente;     
  private Long numeroPremioFaltante;
  private String codigoMensaje;     
  private Long oidRegion;     
  private Long oidZona;     
  private ArrayList productosSustitutivos;
  

  public DTOPremioSustitutivo()
  {
  }

  public String getCodigoMensaje()
  {
    return codigoMensaje;
  }

  public void setCodigoMensaje(String codigoMensaje)
  {
    this.codigoMensaje = codigoMensaje;
  }



  public Long getNumeroPremioFaltante()
  {
    return numeroPremioFaltante;
  }

  public void setNumeroPremioFaltante(Long numeroPremioFaltante)
  {
    this.numeroPremioFaltante = numeroPremioFaltante;
  }

  public String getObservacionesCambio()
  {
    return observacionesCambio;
  }

  public void setObservacionesCambio(String observacionesCambio)
  {
    this.observacionesCambio = observacionesCambio;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidSolicitud()
  {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long oidSolicitud)
  {
    this.oidSolicitud = oidSolicitud;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }



  public Long getTipoCambio()
  {
    return tipoCambio;
  }

  public void setTipoCambio(Long tipoCambio)
  {
    this.tipoCambio = tipoCambio;
  }

  public ArrayList getProductosSustitutivos()
  {
    return productosSustitutivos;
  }

  public void setProductosSustitutivos(ArrayList productosSustitutivos)
  {
    this.productosSustitutivos = productosSustitutivos;
  }

}