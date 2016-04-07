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
 */
 
package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarSublineaArmado extends DTOSiccPaginacion 
{
    private Long oidCentroDistribucion;
    private Long codigoSublinea;
    private String descripcionSublinea;
    private Long oidLineaArmado;
    private Long oidSistemaPicado;
    private char letraParaAnaquel;
    private Long impresoraVirtual;
  
    public DTOBuscarSublineaArmado() {}
    
    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }
    public Long getOidCentroDistribucion() {
        return this.oidCentroDistribucion;
    }
    
    public void setCodigoSublinea( Long codigoSublinea){
        this.codigoSublinea = codigoSublinea;
    }
    public Long getCodigoSublinea(){
        return this.codigoSublinea;
    }     
  
    public void setDescripcionSublinea(String descripcionSublinea) {
        this.descripcionSublinea = descripcionSublinea;
    }
      
    public String getDescripcionSublinea(){
        return this.descripcionSublinea;
    }
    
    public void setOidLineaArmado(Long oidLineaArmado){
        this.oidLineaArmado = oidLineaArmado;
    }
     
    public Long getOidLineaArmado(){
        return this.oidLineaArmado;
    }
  
    public void setOidSistemaPicado(Long oidSistemaPicado){
        this.oidSistemaPicado = oidSistemaPicado;
    }
    public Long getOidSistemaPicado(){
        return this.oidSistemaPicado;
    } 
  
    public void setLetraParaAnaquel(char letraParaAnaquel) {
        this.letraParaAnaquel = letraParaAnaquel;
    }
  
    public char getLetraParaAnaquel(){
        return this.letraParaAnaquel;
    }

    public void setImpresoraVirtual(Long impresoraVirtual) {
        this.impresoraVirtual = impresoraVirtual;
    }

    public Long getImpresoraVirtual() {
        return impresoraVirtual;
    }
}