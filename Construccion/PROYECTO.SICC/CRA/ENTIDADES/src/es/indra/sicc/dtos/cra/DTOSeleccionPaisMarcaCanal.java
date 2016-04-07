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
package es.indra.sicc.dtos.cra;

public class DTOSeleccionPaisMarcaCanal  extends  es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC{
  private Long pais;
  private Long marca;
  private Long canal;
  private Long idioma;

  public DTOSeleccionPaisMarcaCanal() {
  }

  public Long getPais() {
    return pais;
  }

  public void setPais(Long newPais) {
    pais = newPais;
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long newMarca) {
    marca = newMarca;
  }

  public Long getCanal() {
    return canal;
  }

  public void setCanal(Long newCanal) {
    canal = newCanal;
  }
  public void setIdioma(Long newIdioma){
    idioma = newIdioma;
  }
  public Long getIdioma(){
    return idioma;
  }
}