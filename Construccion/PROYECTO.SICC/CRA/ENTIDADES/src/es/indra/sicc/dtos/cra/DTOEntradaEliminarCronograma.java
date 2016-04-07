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

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     Importado desde Version 2 y modificado segun requerimientos
 *                    generales de la Version 3
 * @version           1.0
 * @autor             Gaston Acevedo
 */

public class DTOEntradaEliminarCronograma extends DTOAuditableSICC {

	private Long pais;
    private Long marca;
	private Long grupoZonas;
	private Long region;
	private Long seccion;
    private Long codigoPeriodo;
    private Long canal;
	private Long subgerenciaVentas;
	private Long zona;
    private Date fechaInicio;
    private Long codigoActividad;
    private Long oidCronograma;

	public DTOEntradaEliminarCronograma() {
		super();
	}


	public DTOEntradaEliminarCronograma(Long pais,
			Long marca,
			Long grupoZonas,
			Long region,
			Long seccion,
			Long codigoperiodo,
			Long canal,
			Long subgerenciaVentas,
			Long zona) {
		super();
		this.pais = pais;
		this.marca = marca;
		this.grupoZonas = grupoZonas;
		this.region = region;
		this.seccion = seccion;
		this.codigoPeriodo = codigoperiodo;
		this.canal = canal;
		this.subgerenciaVentas = subgerenciaVentas;
		this.zona = zona;
	}

	public Long getPais(){
		return this.pais;
	}

	public void setPais( Long pais){
		this.pais = pais;
	}

	public Long getMarca(){
        return marca;
	}

	public void setMarca( Long newMarca){
        marca = newMarca;
	}

	public Long getGrupoZonas(){
		return this.grupoZonas;
	}

	public void setGrupoZonas( Long grupoZonas){
		this.grupoZonas = grupoZonas;
	}

	public Long getRegion(){
		return this.region;
	}

	public void setRegion( Long region){
		this.region = region;
	}

	public Long getSeccion(){
		return this.seccion;
	}

	public void setSeccion( Long seccion){
		this.seccion = seccion;
	}

	public Long getCodigoPeriodo(){
        return codigoPeriodo;
	}

	public void setCodigoPeriodo( Long codigoperiodo){
		this.codigoPeriodo = codigoperiodo;
	}

	public Long getCanal(){
        return canal;
	}

	public void setCanal( Long newCanal){
        canal = newCanal;
	}

	public Long getSubgerenciaVentas(){
		return this.subgerenciaVentas;
	}

	public void setSubgerenciaVentas( Long subgerenciaVentas){
		this.subgerenciaVentas = subgerenciaVentas;
	}

	public Long getZona(){
		return this.zona;
	}

	public void setZona( Long zona){
		this.zona = zona;
	}

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date newFechaInicio) {
        fechaInicio = newFechaInicio;
    }

    public Long getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Long newCodigoActividad) {
        codigoActividad = newCodigoActividad;
    }

    public Long getOidCronograma() {
        return oidCronograma;
    }

    public void setOidCronograma(Long newOidCronograma) {
        oidCronograma = newOidCronograma;
    }

}
