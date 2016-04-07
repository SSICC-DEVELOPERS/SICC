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

public class DTOCopiaOrdenAnaqueles  extends DTOBelcorp  {
  private DTOOrdenAnaquelesCabecera ordenAnaquelOrigen;
  private DTOOrdenAnaquelesCabecera ordenAnaquelDestino;

  public DTOCopiaOrdenAnaqueles() {
  }

  public DTOOrdenAnaquelesCabecera getOrdenAnaquelOrigen() {
    return ordenAnaquelOrigen;
  }

  public void setOrdenAnaquelOrigen(DTOOrdenAnaquelesCabecera ordenAnaquelOrigen) {
    this.ordenAnaquelOrigen = ordenAnaquelOrigen;
  }

  public DTOOrdenAnaquelesCabecera getOrdenAnaquelDestino() {
    return ordenAnaquelDestino;
  }

  public void setOrdenAnaquelDestino(DTOOrdenAnaquelesCabecera ordenAnaquelDestino) {
    this.ordenAnaquelDestino = ordenAnaquelDestino;
  }
}