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
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/11/2003
 * Observaciones:     
 *                    
 * @version           1.0
 * @autor             Emilio Noziglia
 */

public class DTOZonasGruposZonas extends DTOAuditableSICC {

	private Vector codGrupoZona;
	private Vector nombreGrupoZona;
    private Vector tipoFacturacion;
    private Vector fechaInicio;
    private Vector fechaPrevista;
    private Vector fechaMedia;
    private Vector fechaFin;
    private Long pais;
    private Long marca;
    private Long canal;
    private Long periodo;
    private Vector zonasGrupos;

	public DTOZonasGruposZonas() {
		super();
	}


	public DTOZonasGruposZonas(Vector codGrupoZona,
			Vector nombreGrupoZona) {
		super();
		this.codGrupoZona = codGrupoZona;
		this.nombreGrupoZona = nombreGrupoZona;
	}

	public Vector getCodGrupoZona(){
		return this.codGrupoZona;
	}

	public void setCodGrupoZona( Vector codGrupoZona){
		this.codGrupoZona = codGrupoZona;
	}

	public Vector getNombreGrupoZona(){
		return this.nombreGrupoZona;
	}

	public void setNombreGrupoZona( Vector nombreGrupoZona){
		this.nombreGrupoZona = nombreGrupoZona;
	}

    public Vector getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(Vector tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public Vector getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Vector fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Vector getFechaPrevista() {
        return fechaPrevista;
    }

    public void setFechaPrevista(Vector fechaPrevista) {
        this.fechaPrevista = fechaPrevista;
    }

    public Vector getFechaMedia() {
        return fechaMedia;
    }

    public void setFechaMedia(Vector fechaMedia) {
        this.fechaMedia = fechaMedia;
    }

    public Vector getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Vector fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long marca) {
        this.marca = marca;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long canal) {
        this.canal = canal;
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long periodo) {
        this.periodo = periodo;
    }

    public Vector getZonasGrupos() {
        return zonasGrupos;
    }

    public void setZonasGrupos(Vector zonasGrupos) {
        this.zonasGrupos = zonasGrupos;
    }
}

