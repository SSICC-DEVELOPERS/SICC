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

public class DTOEValidarCodigoVenta extends DTOAuditableSICC  {
    private Long periodo;
	private Long acceso;
    private Long subacceso;
    private String codigoVenta;
    private Long modulo;
    private Long oidDocumentoReferencia;

  public DTOEValidarCodigoVenta() {
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo) {
    periodo = newPeriodo;
  }

  public Long getAcceso() {
		return acceso;
  }

  public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
  }

  public Long getSubacceso() {
    return subacceso;
  }

  public void setSubacceso(Long newSubacceso) {
    subacceso = newSubacceso;
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String newCodigoVenta) {
    codigoVenta = newCodigoVenta;
  }
 
    public Long getModulo(){
        return modulo;
    }
    
    public void setModulo(Long newModulo){
        modulo = newModulo;
    }
    
    public Long getOidDocumentoReferencia(){
        return oidDocumentoReferencia;
    }
    
    public void setOidDocumentoReferencia(Long newOidDocumentoReferencia){
        oidDocumentoReferencia = newOidDocumentoReferencia;
    }
}