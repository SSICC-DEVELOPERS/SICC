
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
 */

 
package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;

public class DTOAnadirProductosRA extends DTOBelcorp { 

  public DTOAnadirProductosRA(){
  
    super();
  }
  
  private String codigoProducto;
  private Long subacceso;
  private Long almacen; // añadido por incidencia BELC300012171
  private Long marca;

  public String getCodigoProducto(){
    
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto){
    
    this.codigoProducto = codigoProducto;
  }

  public Long getSubacceso(){
    
    return subacceso;
  }

  public void setSubacceso(Long subacceso){
    
    this.subacceso = subacceso;
  }

  public Long getAlmacen()
  {
    return almacen;
  }

  public void setAlmacen(Long almacen)
  {
    this.almacen = almacen;
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long marca) {
    this.marca = marca;
  }
}