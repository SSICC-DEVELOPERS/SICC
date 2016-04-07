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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOBuscarUsuariosBloqueo extends DTOSiccPaginacion {
    private Long oid;
    private Long idUser;             // Corresponde a USERS.IDUSER
    private String codigoUsuario;    // Corresponde a PRINCIPALS.NAME (para el USERS.IDUSER)
    private Long oidTipoBloqueo;
    private Long oidAccionPermitida; // Es MAE_VALOR_USUAR_BLOQU.OID_VALO_USUA_BLOQ

    public DTOBuscarUsuariosBloqueo() {
        
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

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
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
