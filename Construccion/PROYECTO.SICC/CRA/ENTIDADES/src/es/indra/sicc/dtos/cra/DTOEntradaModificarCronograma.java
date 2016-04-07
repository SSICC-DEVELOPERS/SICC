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
 * */

public class DTOEntradaModificarCronograma extends DTOAuditableSICC{

	private Long zona;
	private Integer tipoDias;
	private Long subgerenciaVentas;
	private Long seccion;
	private Boolean repetitiva;
	private Long region;
	private Long pais;
    private Long marca;
    private Date horaEjecucion;
	private Long grupoZonas;
	private Boolean flaffija;
	private Date fechafin;
	private Date fechaInicio;
    private Long codigoperiodo;
	private Long codigoActividadReferenciada;
    private Long canal;
	private Integer NroDiasRepite;
	private Long codigoActividad;
    private Integer diasEjecucion;
    private String tipoFacturacion;
    private Integer fechaMedia;
    private Long acceso;
    private Long actividadFromActividad;
    private Long marcaFromActividad;
    private Long paisFromActividad;
    private Long canalFromActividad;
    private Long oidCronograma;
    private Long oidActividad;

	public DTOEntradaModificarCronograma() {
		super();
	}


	public DTOEntradaModificarCronograma(
      Long zona,
			Integer tipoDias,
			Long subgerenciaVentas,
			Long seccion,
			Boolean repetitiva,
			Long region,
			Long pais,
			Long marca,
			Date horaEjecucion,
			Long grupoZonas,
			Boolean flaffija,
			Date fechafin,
			Date fechaInicio,
			Long codigoperiodo,
			Long codigoActividadReferenciada,
			Long canal,
			Integer NroDiasRepite,
			Long codigoActividad,
            Long   oidActividad) {
		super();
		this.zona = zona;
		this.tipoDias = tipoDias;
		this.subgerenciaVentas = subgerenciaVentas;
		this.seccion = seccion;
		this.repetitiva = repetitiva;
		this.region = region;
		this.pais = pais;
		this.marca = marca;
		this.horaEjecucion = horaEjecucion;
		this.grupoZonas = grupoZonas;
		this.flaffija = flaffija;
		this.fechafin = fechafin;
		this.fechaInicio = fechaInicio;
		this.codigoperiodo = codigoperiodo;
		this.codigoActividadReferenciada = codigoActividadReferenciada;
		this.canal = canal;
		this.NroDiasRepite = NroDiasRepite;
		this.codigoActividad = codigoActividad;
        this.oidActividad = oidActividad;
	}

	public Long getZona(){
		return this.zona;
	}

	public void setZona( Long zona){
		this.zona = zona;
	}

	public Integer getTipoDias(){
		return this.tipoDias;
	}

	public void setTipoDias( Integer tipoDias){
		this.tipoDias = tipoDias;
	}

	public Long getSubgerenciaVentas(){
		return this.subgerenciaVentas;
	}

	public void setSubgerenciaVentas( Long subgerenciaVentas){
		this.subgerenciaVentas = subgerenciaVentas;
	}

	public Long getSeccion(){
		return this.seccion;
	}

	public void setSeccion( Long seccion){
		this.seccion = seccion;
	}

	public Boolean getRepetitiva(){
		return this.repetitiva;
	}

	public void setRepetitiva( Boolean repetitiva){
		this.repetitiva = repetitiva;
	}

	public Long getRegion(){
		return this.region;
	}

	public void setRegion( Long region){
		this.region = region;
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

	public Date getHoraEjecucion(){
        return horaEjecucion;
	}

	public void setHoraEjecucion( Date newHoraEjecucion){
        horaEjecucion = newHoraEjecucion;
	}

	public Long getGrupoZonas(){
		return this.grupoZonas;
	}

	public void setGrupoZonas( Long grupoZonas){
		this.grupoZonas = grupoZonas;
	}

	public Boolean getFlaffija(){
		return this.flaffija;
	}

	public void setFlaffija( Boolean flaffija){
		this.flaffija = flaffija;
	}

	public Date getFechafin(){
		return this.fechafin;
	}

	public void setFechafin( Date fechafin){
		this.fechafin = fechafin;
	}

	public Date getFechaInicio(){
		return this.fechaInicio;
	}

	public void setFechaInicio( Date fechaInicio){
		this.fechaInicio = fechaInicio;
	}

	public Long getCodigoperiodo(){
        return codigoperiodo;
	}

	public void setCodigoperiodo( Long newCodigoperiodo){
        codigoperiodo = newCodigoperiodo;
	}

	public Long getCodigoActividadReferenciada(){
		return this.codigoActividadReferenciada;
	}

	public void setCodigoActividadReferenciada( Long codigoActividadReferenciada){
		this.codigoActividadReferenciada = codigoActividadReferenciada;
	}

	public Long getCanal(){
        return canal;
	}

	public void setCanal( Long newCanal){
        canal = newCanal;
	}

	public Integer getNroDiasRepite(){
		return this.NroDiasRepite;
	}

	public void setNroDiasRepite( Integer NroDiasRepite){
		this.NroDiasRepite = NroDiasRepite;
	}

	public Long getCodigoActividad(){
		return this.codigoActividad;
	}

	public void setCodigoActividad( Long codigoActividad){
		this.codigoActividad = codigoActividad;
	}

	public Long getOidActividad(){
		return this.oidActividad;
	}

	public void setOidActividad( Long oidActividad){
		this.oidActividad = oidActividad;
	}

    public Integer getDiasEjecucion() {
        return diasEjecucion;
    }

    public void setDiasEjecucion(Integer newDiasEjecucion) {
        diasEjecucion = newDiasEjecucion;
    }

    public String getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(String newTipoFacturacion) {
        tipoFacturacion = newTipoFacturacion;
    }

    public Integer getFechaMedia() {
        return fechaMedia;
    }

    public void setFechaMedia(Integer newFechaMedia) {
        fechaMedia = newFechaMedia;
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long newAcceso) {
        acceso = newAcceso;
    }

    public Long getActividadFromActividad() {
        return actividadFromActividad;
    }

    public void setActividadFromActividad(Long newActividadFromActividad) {
        actividadFromActividad = newActividadFromActividad;
    }

    public Long getMarcaFromActividad() {
        return marcaFromActividad;
    }

    public void setMarcaFromActividad(Long newMarcaFromActividad) {
        marcaFromActividad = newMarcaFromActividad;
    }

    public Long getPaisFromActividad() {
        return paisFromActividad;
    }

    public void setPaisFromActividad(Long newPaisFromActividad) {
        paisFromActividad = newPaisFromActividad;
    }

    public Long getCanalFromActividad() {
        return canalFromActividad;
    }

    public void setCanalFromActividad(Long newCanalFromActividad) {
        canalFromActividad = newCanalFromActividad;
    }

    public Long getOidCronograma() {
        return oidCronograma;
    }

    public void setOidCronograma(Long newOidCronograma) {
        oidCronograma = newOidCronograma;
    }

}
