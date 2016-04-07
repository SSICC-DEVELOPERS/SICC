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
*/
package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;

public class DTOZona extends DTOAuditableSICC  {
    public Long oidZona;
    public Date fechaCambioEstado;
    public Long oidEstadoZona;
    public Boolean indRezonificacion;
    
    public DTOZona() {
    }

    public Date getFechaCambioEstado() {
        return fechaCambioEstado;
    }

    public void setFechaCambioEstado(Date fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    public Boolean getIndRezonificacion() {
        return indRezonificacion;
    }

    public void setIndRezonificacion(Boolean indRezonificacion) {
        this.indRezonificacion = indRezonificacion;
    }

    public Long getOidEstadoZona() {
        return oidEstadoZona;
    }

    public void setOidEstadoZona(Long oidEstadoZona) {
        this.oidEstadoZona = oidEstadoZona;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }
    
}