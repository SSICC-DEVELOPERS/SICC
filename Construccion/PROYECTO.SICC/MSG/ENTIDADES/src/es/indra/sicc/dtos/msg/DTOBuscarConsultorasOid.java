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

package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOBuscarConsultorasOid extends DTOSiccPaginacion {
    private Long oidCliente;
	private String codMensaje;

    public DTOBuscarConsultorasOid() {
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public String getCodMensaje() {
		return codMensaje;
    }

	public void setCodMensaje(String newCodMensaje) {
		codMensaje = newCodMensaje;
	}
}
