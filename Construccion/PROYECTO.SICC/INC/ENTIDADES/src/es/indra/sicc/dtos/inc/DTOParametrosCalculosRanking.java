/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * 
 * Autor: Diego Morello
 * 
 */

package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.logicanegocio.inc.UnidadAdministrativa;
import es.indra.sicc.logicanegocio.inc.Periodo;


public class DTOParametrosCalculosRanking extends DTOBelcorp {
    
    private Long oidConcurso;
    private Long oidGerente;
    private Periodo periodoCierre;
    private UnidadAdministrativa unidadAdministrativaGerente;

    public DTOParametrosCalculosRanking() {
        
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidGerente() {
        return oidGerente;
    }

    public void setOidGerente(Long oidGerente) {
        this.oidGerente = oidGerente;
    }

    public Periodo getPeriodoCierre() {
        return periodoCierre;
    }

    public void setPeriodoCierre(Periodo periodoCierre) {
        this.periodoCierre = periodoCierre;
    }

    public UnidadAdministrativa getUnidadAdministrativaGerente() {
        return unidadAdministrativaGerente;
    }

    public void setUnidadAdministrativaGerente(UnidadAdministrativa unidadAdministrativaGerente) {
        this.unidadAdministrativaGerente = unidadAdministrativaGerente;
    }

}