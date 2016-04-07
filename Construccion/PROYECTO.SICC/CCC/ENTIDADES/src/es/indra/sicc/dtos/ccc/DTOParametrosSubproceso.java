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

import es.indra.sicc.util.DTOBelcorp;

public class DTOParametrosSubproceso extends DTOBelcorp  {

	private Long subproceso;
	private Long marcaSituacion;
	private Long cuenta;
	private Long tipoAbono;
	private Long tipoAbonoSubproceso;
    // dmorello, 28/06/2006
    private boolean indActualizaCuota;

	public DTOParametrosSubproceso() {
	}

	public Long getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Long newCuenta) {
		this.cuenta = newCuenta;
	}

	public Long getMarcaSituacion() {
		return this.marcaSituacion;
	}

	public void setMarcaSituacion(Long newMarcaSituacion) {
		this.marcaSituacion = newMarcaSituacion;
	}

	public Long getSubproceso() {
		return this.subproceso;
	}

	public void setSubproceso(Long newSubproceso) {
		this.subproceso = newSubproceso;
	}

	public Long getTipoAbono() {
		return this.tipoAbono;
	}

	public void setTipoAbono(Long newTipoAbono) {
		this.tipoAbono = newTipoAbono;
	}

	public Long getTipoAbonoSubproceso() {
		return this.tipoAbonoSubproceso;
	}

	public void setTipoAbonoSubproceso(Long newTipoAbonoSubproceso) {
		this.tipoAbonoSubproceso = newTipoAbonoSubproceso;
	}

    public boolean getIndActualizaCuota()
    {
        return indActualizaCuota;
    }

    public void setIndActualizaCuota(boolean indActualizaCuota)
    {
        this.indActualizaCuota = indActualizaCuota;
    }
}