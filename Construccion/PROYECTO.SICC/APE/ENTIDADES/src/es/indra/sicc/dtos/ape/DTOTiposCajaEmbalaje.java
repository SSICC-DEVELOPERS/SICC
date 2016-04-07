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

import es.indra.sicc.util.DTOOIDs;

public class DTOTiposCajaEmbalaje extends DTOTipoCajaEmbalaje {
    private Long centroDistribucion;
    private DTOOIDs lineasArmadoInsertadas;
    private DTOOIDs lineasArmadoEliminadas ;
    private Long lineaArmadoConsultada;
    public DTOTiposCajaEmbalaje() {
        
    }

  public void setCentroDistribucion(Long centroDistribucion) {
    this.centroDistribucion = centroDistribucion;
  }


  public Long getCentroDistribucion() {
    return centroDistribucion;
  }


  public void setLineasArmadoInsertadas(DTOOIDs lineasArmadoInsertadas) {
    this.lineasArmadoInsertadas = lineasArmadoInsertadas;
  }


  public DTOOIDs getLineasArmadoInsertadas() {
    return lineasArmadoInsertadas;
  }


  public void setLineasArmadoEliminadas(DTOOIDs lineasArmadoEliminadas) {
    this.lineasArmadoEliminadas = lineasArmadoEliminadas;
  }


  public DTOOIDs getLineasArmadoEliminadas() {
    return lineasArmadoEliminadas;
  }


  public void setLineaArmadoConsultada(Long lineaArmadoConsultada) {
    this.lineaArmadoConsultada = lineaArmadoConsultada;
  }


  public Long getLineaArmadoConsultada() {
    return lineaArmadoConsultada;
  }
    
    
}