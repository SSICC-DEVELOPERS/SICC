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

/**
 * @author
 * @date 
 * pperanzola - 04/11/2005 - [1] se modifica según incidencia BELC300021576
 */
public class DTOEAlcanceClasificacionDTO extends DTOAuditableSICC {

    private Long oidDescuento;
    private Long oidClasificacion;
    private Long oidTipoClasificacion;
    private Double porcentajeAdicional;
    private String descClasificacion;
    private String descTipoClasificacion;
   
    public DTOEAlcanceClasificacionDTO() {
    }
    
    public Long getOidDescuento(){
      return this.oidDescuento;
    }
    
    public void setOidDescuento(Long oidDescuento) {
      this.oidDescuento = oidDescuento;
    }
    
    public Double getPorcentajeAdicional() {
      return this.porcentajeAdicional;
    }
    
    public void setPorcentajeAdicional  (Double porcentajeAdicional) {
      this.porcentajeAdicional = porcentajeAdicional;
    }
    
    public Long getOidClasificacion() {
      return this.oidClasificacion;
    }
    
    public void setOidClasificacion(Long oidClasificacion) {
      this.oidClasificacion = oidClasificacion;
    }
    
    public Long getOidTipoClasificacion(){
      return this.oidTipoClasificacion;
    }
    
    public void setOidTipoClasificacion(Long oidTipoClasificacion){
      this.oidTipoClasificacion = oidTipoClasificacion;
    }
    ///*[1]
    public String getDescClasificacion(){
        return descClasificacion;
    }
    
    public void setDescClasificacion(String descClasificacion) {
        this.descClasificacion = descClasificacion;
    }
    
    public String getDescTipoClasificacion() {
        return descTipoClasificacion;
    }
    
    public void setDescTipoClasificacion(String descTipoClasificacion){
        this.descTipoClasificacion = descTipoClasificacion;
    }
    //*/[1]
}