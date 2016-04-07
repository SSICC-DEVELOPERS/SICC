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
 * Autor: Diego Morello
 */
 
package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOAsignarPremios extends DTOBelcorp  {
    private Long[] oidGanadores;
    private Long[] oidNivelesPremios;
    private Long oidConcurso;
    private Long oidPGenPrem;

    public Long[] getOidGanadores() {
        return oidGanadores;
    }

    public void setOidGanadores(Long[] oidGanadores) {
        this.oidGanadores = oidGanadores;
    }

    public Long[] getOidNivelesPremios() {
        return oidNivelesPremios;
    }

    public void setOidNivelesPremios(Long[] oidNivelesPremios) {
        this.oidNivelesPremios = oidNivelesPremios;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidPGenPrem() {
        return oidPGenPrem;
    }

    public void setOidPGenPrem(Long oidPGenPrem) {
        this.oidPGenPrem = oidPGenPrem;
    }
    
}