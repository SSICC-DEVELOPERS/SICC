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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.zon;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOEjecutarReterritorializacion   extends DTOBelcorp {
  private ArrayList registros;
  private DTOEjecutarReterritorializacionCab cabecera;
  private String pathFichero;
  private String tipoOp;

  public DTOEjecutarReterritorializacion() {
      super();
  }

  public ArrayList getRegistros() {
    return registros;
  }

  public void setRegistros(ArrayList registros) {
    this.registros = registros;
  }

  public DTOEjecutarReterritorializacionCab getCabecera() {
    return cabecera;
  }

  public void setCabecera(DTOEjecutarReterritorializacionCab cabecera) {
    this.cabecera = cabecera;
  }

  public String getPathFichero() {
    return pathFichero;
  }

  public void setPathFichero(String pathFichero) {
    this.pathFichero = pathFichero;
  }

  public String getTipoOp() {
    return tipoOp;
  }

  public void setTipoOp(String tipoOp) {
    this.tipoOp = tipoOp;
  }
}