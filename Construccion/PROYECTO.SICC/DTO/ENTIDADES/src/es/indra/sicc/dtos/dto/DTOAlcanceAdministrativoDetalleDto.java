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


public class DTOAlcanceAdministrativoDetalleDto extends DTOAuditableSICC {
    
    private Long oidAlcance;
    private Long oidSubgerencia;
    private String subgerencia;
    private Long oidRegion;
    private String region;
    private Long oidZona;
    private String zona;
    private Float porcentajeAdicional;
    
    public DTOAlcanceAdministrativoDetalleDto()
    {
    }
    
    
   public Long getOidAlcance()
   {
      return this.oidAlcance;
   }

   public void setOidAlcance(Long oidAlcance)
   {
      this.oidAlcance = oidAlcance;
   }          
    
    
   public Long getOidSubgerencia()
   {
      return this.oidSubgerencia;
   }

   public void setOidSubgerencia(Long oidSubgerencia)
   {
      this.oidSubgerencia = oidSubgerencia;
   }       
    
    
   public String getSubgerencia()
   {
      return this.subgerencia;
   }

   public void setSubgerencia(String subgerencia)
   {
      this.subgerencia = subgerencia;
   }      
    
    
   public Long getOidRegion()
   {
      return this.oidRegion;
   }

   public void setOidRegion(Long oidRegion)
   {
      this.oidRegion = oidRegion;
   }       
    
    
   public String getRegion()
   {
      return this.region;
   }

   public void setRegion(String region)
   {
      this.region = region;
   }         
    
    
   public Long getOidZona()
   {
      return this.oidZona;
   }

   public void setOidZona(Long oidZona)
   {
      this.oidZona = oidZona;
   }        
    
    
   public String getZona()
   {
      return this.zona;
   }

   public void setZona(String zona)
   {
      this.zona = zona;
   }        
    
    
   public Float getPorcentajeAdicional()
   {
      return this.porcentajeAdicional;
   }

   public void setPorcentajeAdicional(Float porcentajeAdicional)
   {
      this.porcentajeAdicional = porcentajeAdicional;
   }         
    
    
}