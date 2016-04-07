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

import es.indra.sicc.dtos.ccc.DTOBuscarSaldosMorosos;
import java.util.Date;

public class DTOAplicarIncobrables extends DTOBuscarSaldosMorosos {

	private Long movimientos[];
	private Date fechaImputacion;
	private Long tipoCargoAbono;
	private String referenciaExterna;
  /*
   * Autor: Cortaberria
   * Fecha: 15/06/2005
   * Se agrega numero de lote debido a incidencia BELC300019032
   * */
  private Integer numeroLote;

  public Integer getNumeroLote() {
    return this.numeroLote;
  }
  
  public void setNumeroLote(Integer numeroLote) {
    this.numeroLote = numeroLote;
  }

	public Long[] getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(Long[] newMovimientos) {
		this.movimientos = newMovimientos;
	}

	public Date getFechaImputacion() {
		return fechaImputacion;
	}

	public void setFechaImputacion(Date newFechaImputacion) {
		fechaImputacion = newFechaImputacion;
	}

	public Long getTipoCargoAbono() {
		return tipoCargoAbono;
	}

	public void setTipoCargoAbono(Long newTipoCargoAbono) {
		tipoCargoAbono = newTipoCargoAbono;
	}

	public String getReferenciaExterna() {
		return referenciaExterna;
	}

	public void setReferenciaExterna(String newReferenciaExterna) {
		referenciaExterna = newReferenciaExterna;
	}
}