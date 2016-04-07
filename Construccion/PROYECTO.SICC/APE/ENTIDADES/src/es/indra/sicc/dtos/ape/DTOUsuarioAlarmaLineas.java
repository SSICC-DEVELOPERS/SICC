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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOUsuarioAlarmaLineas extends DTOBelcorp {
    private Long oid;
    private String email;
    private DTOLineaArmado lineaArmado;
    
    
    public DTOUsuarioAlarmaLineas() {
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLineaArmado(DTOLineaArmado lineaArmado) {
        this.lineaArmado = lineaArmado;
    }

    public DTOLineaArmado getLineaArmado() {
        return lineaArmado;
    }
    
}