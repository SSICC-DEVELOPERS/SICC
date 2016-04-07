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


public class DTOUsuariosBloqueo extends DTOBelcorp {
    private Long oid;
    private Long idUser;
    private Long oidTipoBloqueo;
    private Long oidAccionPermitida; // Es el OID de la Entidad MAE Valores Usuario Bloqueo

    public DTOUsuariosBloqueo() {
        
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setOidTipoBloqueo(Long oidTipoBloqueo) {
        this.oidTipoBloqueo = oidTipoBloqueo;
    }

    public Long getOidTipoBloqueo() {
        return oidTipoBloqueo;
    }

    public void setOidAccionPermitida(Long oidAccionPermitida) {
        this.oidAccionPermitida = oidAccionPermitida;
    }

    public Long getOidAccionPermitida() {
        return oidAccionPermitida;
    }

}
