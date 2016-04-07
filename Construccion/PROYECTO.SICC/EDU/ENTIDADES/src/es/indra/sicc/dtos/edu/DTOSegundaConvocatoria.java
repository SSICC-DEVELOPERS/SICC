/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.edu;

import es.indra.sicc.util.DTOBelcorp;

public class DTOSegundaConvocatoria  extends DTOBelcorp{

	private Integer codCurso;
	private Long oidAsigna;  
    private Long oidMarca;
    private Long oidCanal;
	
	public Integer getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(Integer newCodCurso) {
		codCurso = newCodCurso;
	}

	public Long getOidAsigna() {
		return oidAsigna;
	}

	public void setOidAsigna(Long newOidAsigna) {
		oidAsigna = newOidAsigna;
	}

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }
}