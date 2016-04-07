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
 
package es.indra.sicc.dtos.rec;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODetalleReclamosREC extends DTOSiccPaginacion 
{
    private Long oidReclamo;
    //Incidencia BELC300021669
    private String usuario;

    public DTODetalleReclamosREC()
    {
    }

    public Long getOidReclamo()
    {
        return oidReclamo;
    }

    public void setOidReclamo(Long oidReclamo)
    {
        this.oidReclamo = oidReclamo;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getUsuario() {
        return usuario;
    }
}