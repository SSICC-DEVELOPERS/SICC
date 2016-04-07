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
 * Autor : Igor Dedough
 */
 
package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOElegirPremiosRec extends  DTOSiccPaginacion {
    private Long oidClienteRecomendante;
    private Long oidClienteRecomendada;
    private Long oidConcurso;
    private Long oidPeriodoVinculo;
    private Integer numeroPremio;
    private Long oidNivelPremiacion;
    private Integer version;
    private String numeroConcurso;
        
    public DTOElegirPremiosRec() {  }

    public void setOidClienteRecomendante(Long oidClienteRecomendante) {
        this.oidClienteRecomendante = oidClienteRecomendante;
    }

    public Long getOidClienteRecomendante() {
        return oidClienteRecomendante;
    }

    public void setOidClienteRecomendada(Long oidClienteRecomendada) {
        this.oidClienteRecomendada = oidClienteRecomendada;
    }

    public Long getOidClienteRecomendada() {
        return oidClienteRecomendada;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidPeriodoVinculo(Long oidPeriodoVinculo) {
        this.oidPeriodoVinculo = oidPeriodoVinculo;
    }

    public Long getOidPeriodoVinculo() {
        return oidPeriodoVinculo;
    }

    public void setNumeroPremio(Integer numeroPremio) {
        this.numeroPremio = numeroPremio;
    }

    public Integer getNumeroPremio() {
        return numeroPremio;
    }

    public void setOidNivelPremiacion(Long oidNivelPremiacion) {
        this.oidNivelPremiacion = oidNivelPremiacion;
    }

    public Long getOidNivelPremiacion() {
        return oidNivelPremiacion;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }
    
}