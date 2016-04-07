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
 */
package es.indra.sicc.dtos.mae;

import es.indra.sicc.util.DTOBelcorp;


public class DTOAccionesProcesosBloqueo extends DTOBelcorp {
    private Long oid;
    private Long oidTipoBloqueo;
    private Long oidProcesoBloqueo;
    private Long oidAccionBloqueo;

    public DTOAccionesProcesosBloqueo() {
        
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOidTipoBloqueo(Long oidTipoBloqueo) {
        this.oidTipoBloqueo = oidTipoBloqueo;
    }

    public Long getOidTipoBloqueo() {
        return oidTipoBloqueo;
    }

    public void setOidProcesoBloqueo(Long oidProcesoBloqueo) {
        this.oidProcesoBloqueo = oidProcesoBloqueo;
    }

    public Long getOidProcesoBloqueo() {
        return oidProcesoBloqueo;
    }

    public void setOidAccionBloqueo(Long oidAccionBloqueo) {
        this.oidAccionBloqueo = oidAccionBloqueo;
    }

    public Long getOidAccionBloqueo() {
        return oidAccionBloqueo;
    }

}