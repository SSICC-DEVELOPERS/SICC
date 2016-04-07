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
 * Autor : Viviana Bongiovanni
 */
package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarClientesConcurso  extends DTOSiccPaginacion {
  private Long oidConcurso;
  private String numeroConcurso;
  private Integer versionConcurso;
  //Agregado por Cristian Valenzuela - 20/2/2006
  //Incidencia 22634
  private Long oidCliente;
  private String codCliente;  
  //FIN - Agregado por Cristian Valenzuela - 20/2/2006

  public DTOBuscarClientesConcurso() {
  }
  
  public Long getOidCliente() {
    return this.oidCliente;
  }
  
  public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;
  }
  
  public String getCodCliente() {
    return this.codCliente;
  }
  
  public void setCodCliente(String newCodCliente) {
    this.codCliente = newCodCliente;
  }

  public Long getOidConcurso() {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso) {
    this.oidConcurso = oidConcurso;
  }

  public String getNumeroConcurso() {
    return numeroConcurso;
  }

  public void setNumeroConcurso(String numeroConcurso) {
    this.numeroConcurso = numeroConcurso;
  }

  public Integer getVersionConcurso() {
    return versionConcurso;
  }

  public void setVersionConcurso(Integer versionConcurso) {
    this.versionConcurso = versionConcurso;
  }
}