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
 
package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTODescuentoCliente extends DTOAuditableSICC {

    private Long oidAlcanceCliente; 
    private String codigoCliente; 
    private String nombre; 
    private String apellidos; 
    private Double importeDescuento;
    private Float porcentajeDescuento;
  private Long oidCliente;

    public DTODescuentoCliente()
    {
    }
    
    
   public Long getOidAlcanceCliente()
   {
      return this.oidAlcanceCliente;
   }

   public void setOidAlcanceCliente(Long oidAlcanceCliente)
   {
      this.oidAlcanceCliente = oidAlcanceCliente;
   }         
   
   
   public String getCodigoCliente()
   {
      return this.codigoCliente;
   }

   public void setCodigoCliente(String codigoCliente)
   {
      this.codigoCliente = codigoCliente;
   }         
   
    
   public String getNombre()
   {
      return this.nombre;
   }

   public void setNombre(String nombre)
   {
      this.nombre = nombre;
   }       
    
    
   public String getApellidos()
   {
      return this.apellidos;
   }

   public void setApellidos(String apellidos)
   {
      this.apellidos = apellidos;
   }       
        
    
   public Double getImporteDescuento()
   {
      return this.importeDescuento;
   }

   public void setImporteDescuento(Double importeDescuento)
   {
      this.importeDescuento = importeDescuento;
   }       
    
    
   public Float getPorcentajeDescuento()
   {
      return this.porcentajeDescuento;
   }

   public void setPorcentajeDescuento(Float porcentajeDescuento)
   {
      this.porcentajeDescuento = porcentajeDescuento;
   }       

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }
   
}