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
public class DTONivelesRanking extends DTOSiccPaginacion {

    private Long oidConcurso;
    private Long oidNivelPremiacion;
    private Long oidTipoPremio;
    private Long oidPremio;
    private Integer numeroAspirantes;
    private Integer numeroPremio;
    private Integer cantidadInicialPuntos;
    private Integer cantidadFinalPuntos;
  
    public void setOidConcurso(Long oidConcurso) {
      this.oidConcurso = oidConcurso;
    }
  
    public Long getOidConcurso() {
      return oidConcurso;
    }
  
    public void setOidNivelPremiacion(Long oidNivelPremiacion) {
      this.oidNivelPremiacion = oidNivelPremiacion;
    }
  
    public Long getOidNivelPremiacion() {
      return oidNivelPremiacion;
    }
  
    public void setOidTipoPremio(Long oidTipoPremio) {
      this.oidTipoPremio = oidTipoPremio;
    }
  
    public Long getOidTipoPremio() {
      return oidTipoPremio;
    }
  
    public void setOidPremio(Long oidPremio) {
      this.oidPremio = oidPremio;
    }
  
    public Long getOidPremio() {
      return oidPremio;
    }
  
    public void setNumeroAspirantes(Integer numeroAspirantes) {
      this.numeroAspirantes = numeroAspirantes;
    }
  
    public Integer getNumeroAspirantes() {
      return numeroAspirantes;
    }
  
    public void setNumeroPremio(Integer numeroPremio) {
      this.numeroPremio = numeroPremio;
    }
  
    public Integer getNumeroPremio() {
      return numeroPremio;
    }
  
    public void setCantidadInicialPuntos(Integer cantidadInicialPuntos) {
      this.cantidadInicialPuntos = cantidadInicialPuntos;
    }
  
    public Integer getCantidadInicialPuntos() {
      return cantidadInicialPuntos;
    }
  
    public void setCantidadFinalPuntos(Integer cantidadFinalPuntos) {
      this.cantidadFinalPuntos = cantidadFinalPuntos;
    }
  
    public Integer getCantidadFinalPuntos() {
      return cantidadFinalPuntos;
    }
    
}