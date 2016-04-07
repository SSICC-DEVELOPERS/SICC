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
package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOGestionarProdNORecuperados extends DTOBelcorp  {
  private ArrayList numBoletasRecojo;
  private ArrayList acciones;
  private ArrayList numAtencion;
  private Boolean primerRecojo;
  private Boolean siExitoso;
  private ArrayList oidCabeRecla;

  public DTOGestionarProdNORecuperados() {
  }

  public ArrayList getNumBoletasRecojo() {
    return numBoletasRecojo;
  }

  public void setNumBoletasRecojo(ArrayList numBoletasRecojo) {
    this.numBoletasRecojo = numBoletasRecojo;
  }

  public ArrayList getAcciones() {
    return acciones;
  }

  public void setAcciones(ArrayList acciones) {
    this.acciones = acciones;
  }

  public ArrayList getNumAtencion() {
    return numAtencion;
  }

  public void setNumAtencion(ArrayList numAtencion) {
    this.numAtencion = numAtencion;
  }

  public Boolean getPrimerRecojo() {
    return primerRecojo;
  }

  public void setPrimerRecojo(Boolean primerRecojo) {
    this.primerRecojo = primerRecojo;
  }

  public Boolean getSiExitoso() {
    return siExitoso;
  }

  public void setSiExitoso(Boolean siExitoso) {
    this.siExitoso = siExitoso;
  }
  
    public ArrayList getOidCabeRecla() {
      return oidCabeRecla;
    }

    public void setOidCabeRecla(ArrayList oidCabeRecla) {
      this.oidCabeRecla = oidCabeRecla;
    }
}