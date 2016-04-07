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

import java.util.Vector;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;
import java.util.Collection;
import java.util.ArrayList;

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

public class DTOGuardaCronograma extends DTOAuditableSICC {

	private Long pais;
    private Long marca;
    private Long canal;
    private Long numperiodo;
    private Date InicioPeriodo;
    private Date finPeriodo;
	private Long actividad;
	private Boolean moverReferenciadas;
    private Vector gruposZonas;
    private Long subgerenciaVentas;
    private Long region;
    private Long seccion;
    private Long zona;
    //Definido por Gabriel Guardincerri
    private ArrayList zonasGrupos = new ArrayList();

	public DTOGuardaCronograma() {
		super();
	}

	public DTOGuardaCronograma(Long pais,
			Long marca,
			Long canal,
			Long numperiodo,
			Date InicioPeriodo,
			Date finPeriodo,
			Long actividad,
			Boolean moverReferenciadas,
            Vector gruposZonas) {
		super();
		this.pais = pais;
		this.marca = marca;
		this.canal = canal;
		this.numperiodo = numperiodo;
		this.InicioPeriodo = InicioPeriodo;
		this.finPeriodo = finPeriodo;
		this.actividad = actividad;
		this.moverReferenciadas = moverReferenciadas;
        this.gruposZonas = gruposZonas;
	}

    public void setZonasGrupos(ArrayList zonasGrupos){
        this.zonasGrupos = zonasGrupos;
    }

    public ArrayList getZonasGrupos(){
        return this.zonasGrupos;
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

	public Long getCanal(){
        return canal;
	}

	public void setCanal( Long newCanal){
        canal = newCanal;
	}

	public Long getNumperiodo(){
        return numperiodo;
	}
  
	public void setNumperiodo( Long newNumperiodo){
        numperiodo = newNumperiodo;
	}

    public Vector getGruposZonas(){
        return this.gruposZonas;
    }

    public void setGruposZonas(Vector gruposZonas){
        this.gruposZonas = gruposZonas;
    }

	public Date getInicioPeriodo(){
        return InicioPeriodo;
	}

	public void setInicioPeriodo( Date InicioPeriodo){
		this.InicioPeriodo = InicioPeriodo;
	}

	public Date getFinPeriodo(){
        return finPeriodo;
	}

	public void setFinPeriodo( Date finPeriodo){
		this.finPeriodo = finPeriodo;
	}

	public Long getActividad(){
		return this.actividad;
	}

	public void setActividad( Long actividad){
		this.actividad = actividad;
	}

	public Boolean getMoverReferenciadas(){
		return this.moverReferenciadas;
	}

	public void setMoverReferenciadas( Boolean moverReferenciadas){
		this.moverReferenciadas = moverReferenciadas;
	}

    public Long getSubgerenciaVentas() {
        return subgerenciaVentas;
    }

    public void setSubgerenciaVentas(Long newSubgerenciaVentas) {
        subgerenciaVentas = newSubgerenciaVentas;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long newRegion) {
        region = newRegion;
    }

    public Long getSeccion() {
        return seccion;
    }

    public void setSeccion(Long newSeccion) {
        seccion = newSeccion;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long newZona) {
        zona = newZona;
    }

    public Collection getDTOZonasGrupos() {
        //Definido por Gabriel Guardincerri
        return zonasGrupos;
    }

    public void addDTOZonasGrupo(DTOZonasGrupo act) {
        //Definido por Gabriel Guardincerri
        zonasGrupos.add(act);
    }

    public boolean removeDTOCZonasGrupo(DTOZonasGrupo act) {
        //Definido por Gabriel Guardincerri
        return zonasGrupos.remove(act);
    }
}
