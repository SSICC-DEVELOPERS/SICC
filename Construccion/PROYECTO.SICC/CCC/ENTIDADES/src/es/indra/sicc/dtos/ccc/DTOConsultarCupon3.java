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

package es.indra.sicc.dtos.ccc;

import java.util.Date;

public class DTOConsultarCupon3 extends DTOBuscarCupon3 {

	private Long oidPeriodo;
	private Date fechaDigitacion;
    private Date fechaMovBanc;

	public DTOConsultarCupon3() {
		super();
	}

	public Date getFechaDigitacion() {
		return this.fechaDigitacion;
	}

	public void setFechaDigitacion(Date newFechaDigitacion) {
		this.fechaDigitacion = newFechaDigitacion;
	}

	public Long getOidPeriodo() {
		return this.oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		this.oidPeriodo = newOidPeriodo;
	}


    public void setFechaMovBanc(Date fechaMovBanc)
    {
        this.fechaMovBanc = fechaMovBanc;
    }


    public Date getFechaMovBanc()
    {
        return fechaMovBanc;
    }
}