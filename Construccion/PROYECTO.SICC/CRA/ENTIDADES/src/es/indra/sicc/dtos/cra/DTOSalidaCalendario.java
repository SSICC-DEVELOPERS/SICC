/*
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

package es.indra.sicc.dtos.cra;

import es.indra.sicc.util.DTOBelcorp;

import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 * @version           1.0
 * @autor             Diego Javier Grigna
 */

public class DTOSalidaCalendario extends DTOBelcorp {

	private Integer anno;
	private Vector fecha;
	private Vector indicadorFestivo;

	public DTOSalidaCalendario() {
		super();
	}


	public DTOSalidaCalendario(Integer anno,
			Vector fecha,
			Vector indicadorFestivo) {
		super();
		this.anno = anno;
		this.fecha = fecha;
		this.indicadorFestivo = indicadorFestivo;
	}

	public Integer getAnno(){
		return this.anno;
	}

	public void setAnno( Integer anno){
		this.anno = anno;
	}

	public Vector getFecha(){
		return this.fecha;
	}

	public void setFecha( Vector fecha){
		this.fecha = fecha;
	}

	public Vector getIndicadorFestivo(){
		return this.indicadorFestivo;
	}

	public void setIndicadorFestivo( Vector indicadorFestivo){
		this.indicadorFestivo = indicadorFestivo;
	}

}
