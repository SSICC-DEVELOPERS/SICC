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
 
package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEstados extends DTOAuditableSICC {
    private String codEstadoActual;
    private Long oidNuevoEstado;
    //Brecha BLO-01 jrivas 16/11/2007
    private String codNuevoEstado;
    
    
    public void setCodEstadoActual(String codEstadoActual) {
        this.codEstadoActual = codEstadoActual;
    }
    
    public String getCodEstadoActual() {
        return codEstadoActual;
    }
    
    public void setOidNuevoEstado(Long oidNuevoEstado) {
        this.oidNuevoEstado = oidNuevoEstado;
    }
    
    public Long getOidNuevoEstado() {
        return oidNuevoEstado;
    }

    public String getCodNuevoEstado()
    {
        return codNuevoEstado;
    }

    public void setCodNuevoEstado(String codNuevoEstado)
    {
        this.codNuevoEstado = codNuevoEstado;
    }
}