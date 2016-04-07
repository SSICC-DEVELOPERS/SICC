/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;

public class DTOERellenarRegistroAbastecimiento extends DTOBelcorp {
  
  public DTOERellenarRegistroAbastecimiento(){
    
    super();
  }
  
  private Long subacceso;   
  private Long marca;   
  private Long agrupacionStock;

  public Long getAgrupacionStock(){
    
    return agrupacionStock;
  }

  public void setAgrupacionStock(Long agrupacionStock){
    
    this.agrupacionStock = agrupacionStock;
  }

  public Long getMarca(){
    
    return marca;
  }

  public void setMarca(Long marca)
  {
    this.marca = marca;
  }

  public Long getSubacceso(){
    
    return subacceso;
  }

  public void setSubacceso(Long subacceso){
    
    this.subacceso = subacceso;
  }
  
}