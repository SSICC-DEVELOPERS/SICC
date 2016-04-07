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
 *
 */
package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * 
 * @author Mariano Rodriguez
 * @fecha 20/07/2005
 */
public class DTORanking extends DTOSiccPaginacion  {
  
    private Long oidConcurso;
    private Long version;
    private Integer valorCalculado;
    private Long baseCalculo;
  
    public void setOidConcurso(Long oidConcurso) {
      this.oidConcurso = oidConcurso;
    }
  
    public Long getOidConcurso() {
      return oidConcurso;
    }
  
    public void setVersion(Long version) {
      this.version = version;
    }
  
    public Long getVersion() {  
      return version;
    }
  
    public void setValorCalculado(Integer valorCalculado) {
      this.valorCalculado = valorCalculado;
    }
  
    public Integer getValorCalculado() {
      return valorCalculado;
    }
  
    public void setBaseCalculo(Long baseCalculo) {
      this.baseCalculo = baseCalculo;
    }
  
    public Long getBaseCalculo() {
      return baseCalculo;
    }
  
}