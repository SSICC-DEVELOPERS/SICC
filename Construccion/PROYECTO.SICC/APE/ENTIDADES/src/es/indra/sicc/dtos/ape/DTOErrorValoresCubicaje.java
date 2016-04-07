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
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOErrorValoresCubicaje  extends DTOBelcorp  {
  private String descripcionLinea;
  private String informacionRegistroProblemas;
  private String error;

  public DTOErrorValoresCubicaje() {
  }

  public String getDescripcionLinea() {
    return descripcionLinea;
  }

  public void setDescripcionLinea(String descripcionLinea) {
    this.descripcionLinea = descripcionLinea;
  }

  public String getInformacionRegistroProblemas() {
    return informacionRegistroProblemas;
  }

  public void setInformacionRegistroProblemas(String informacionRegistroProblemas) {
    this.informacionRegistroProblemas = informacionRegistroProblemas;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
  
  
}