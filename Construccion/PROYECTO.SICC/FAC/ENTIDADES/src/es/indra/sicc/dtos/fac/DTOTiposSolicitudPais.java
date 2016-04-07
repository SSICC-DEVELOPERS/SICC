/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTiposSolicitudPais extends DTOBelcorp {
	private Long  tipoSolicitudPais; //incidencia: BELC300008638
									 //cambiado en el dise�o SICC-DMCO-FAC-201-364-N005-2 
	private Long  acceso; 
	private Long  subacceso; 
    private String codAcceso; //a�adido por incidencia 17331

	public DTOTiposSolicitudPais() {
		super();
	}

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getTipoSolicitudPais() {
		return tipoSolicitudPais;
	}

	public void setTipoSolicitudPais(Long newTipoSolicitudPais) {
		tipoSolicitudPais = newTipoSolicitudPais;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

    public String getCodAcceso()
    {
        return codAcceso;
    }

    public void setCodAcceso(String codAcceso)
    {
        this.codAcceso = codAcceso;
    }
	
}
