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
 *
 */
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import java.util.ArrayList;

public class DTOCuadrarCondicion  extends DTOAuditableSICC{
  private ArrayList posicionesOferta;
  private ArrayList unidadesOferta;
  private ArrayList indicadorCuadreGrupos;
  private ArrayList factorCuadreGrupos;
  private int numeroGrupos;
  private int numeroGruposCondicionantes;
  private int numeroGruposCondicionados;
  private String condicionCondicionantes;
  private String condicionCondicionados;
  private int cuadre;
  private Boolean despachoAutomatico;
  private Boolean cuadreFinalizado;
  private DTOCabeceraSolicitud cabeceraSolicitud;

    public DTOCuadrarCondicion() {
    }

  public ArrayList getPosicionesOferta() {
    return posicionesOferta;
  }

  public void setPosicionesOferta(ArrayList newPosicionesOferta) {
    posicionesOferta = newPosicionesOferta;
  }

  public ArrayList getUnidadesOferta() {
    return unidadesOferta;
  }

  public void setUnidadesOferta(ArrayList newUnidadesOferta) {
    unidadesOferta = newUnidadesOferta;
  }

  public ArrayList getIndicadorCuadreGrupos() {
    return indicadorCuadreGrupos;
  }

  public void setIndicadorCuadreGrupos(ArrayList newIndicadorCuadreGrupos) {
    indicadorCuadreGrupos = newIndicadorCuadreGrupos;
  }

  public ArrayList getFactorCuadreGrupos() {
    return factorCuadreGrupos;
  }

  public void setFactorCuadreGrupos(ArrayList newFactorCuadreGrupos) {
    factorCuadreGrupos = newFactorCuadreGrupos;
  }

  public int getNumeroGrupos() {
    return numeroGrupos;
  }

  public void setNumeroGrupos(int newNumeroGrupos) {
    numeroGrupos = newNumeroGrupos;
  }

  public int getNumeroGruposCondicionantes() {
    return numeroGruposCondicionantes;
  }

  public void setNumeroGruposCondicionantes(int newNumeroGruposCondicionantes) {
    numeroGruposCondicionantes = newNumeroGruposCondicionantes;
  }

  public int getNumeroGruposCondicionados() {
    return numeroGruposCondicionados;
  }

  public void setNumeroGruposCondicionados(int newNumeroGruposCondicionados) {
    numeroGruposCondicionados = newNumeroGruposCondicionados;
  }

  public String getCondicionCondicionantes() {
    return condicionCondicionantes;
  }

  public void setCondicionCondicionantes(String newCondicionCondicionantes) {
    condicionCondicionantes = newCondicionCondicionantes;
  }

  public String getCondicionCondicionados() {
    return condicionCondicionados;
  }

  public void setCondicionCondicionados(String newCondicionCondicionados) {
    condicionCondicionados = newCondicionCondicionados;
  }

  public int getCuadre() {
    return cuadre;
  }

  public void setCuadre(int newCuadre) {
    cuadre = newCuadre;
  }

  public Boolean getDespachoAutomatico() {
    return despachoAutomatico;
  }

  public void setDespachoAutomatico(Boolean newDespachoAutomatico) {
    despachoAutomatico = newDespachoAutomatico;
  }

  public Boolean getCuadreFinalizado() {
    return cuadreFinalizado;
  }

  public void setCuadreFinalizado(Boolean newCuadreFinalizado) {
    cuadreFinalizado = newCuadreFinalizado;
  }

  public DTOCabeceraSolicitud getCabeceraSolicitud() {
    return cabeceraSolicitud;
  }

  public void setCabeceraSolicitud(DTOCabeceraSolicitud newCabeceraSolicitud) {
    cabeceraSolicitud = newCabeceraSolicitud;
  }

    
}