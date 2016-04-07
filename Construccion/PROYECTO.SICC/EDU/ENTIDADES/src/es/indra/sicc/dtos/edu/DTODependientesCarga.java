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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

public class DTODependientesCarga extends DTOBelcorp{

	public RecordSet tiposCurso;                                
	public RecordSet subgerencias;                              
	public RecordSet regiones;                                  
	public RecordSet zonas;                                     
	public RecordSet secciones;                                 
	public RecordSet territorios;                               
	public RecordSet periodos;                                  
	public RecordSet subtiposCliente;                           
	public RecordSet tiposClasificacion;                        
	public RecordSet clasificaciones;                           
	public RecordSet accesos;                                   
	public RecordSet capacitadores;   

	public RecordSet getAccesos() {
		return accesos;
	}

	public void setAccesos(RecordSet newAccesos) {
		accesos = newAccesos;
	}

	public RecordSet getCapacitadores() {
		return capacitadores;
	}

	public void setCapacitadores(RecordSet newCapacitadores) {
		capacitadores = newCapacitadores;
	}

	public RecordSet getClasificaciones() {
		return clasificaciones;
	}

	public void setClasificaciones(RecordSet newClasificaciones) {
		clasificaciones = newClasificaciones;
	}

	public RecordSet getPeriodos() {
		return periodos;
	}

	public void setPeriodos(RecordSet newPeriodos) {
		periodos = newPeriodos;
	}

	public RecordSet getRegiones() {
		return regiones;
	}

	public void setRegiones(RecordSet newRegiones) {
		regiones = newRegiones;
	}

	public RecordSet getSecciones() {
		return secciones;
	}

	public void setSecciones(RecordSet newSecciones) {
		secciones = newSecciones;
	}

	public RecordSet getSubgerencias() {
		return subgerencias;
	}

	public void setSubgerencias(RecordSet newSubgerencias) {
		subgerencias = newSubgerencias;
	}

	public RecordSet getSubtiposCliente() {
		return subtiposCliente;
	}

	public void setSubtiposCliente(RecordSet newSubtiposCliente) {
		subtiposCliente = newSubtiposCliente;
	}

	public RecordSet getTerritorios() {
		return territorios;
	}

	public void setTerritorios(RecordSet newTerritorios) {
		territorios = newTerritorios;
	}

	public RecordSet getTiposClasificacion() {
		return tiposClasificacion;
	}

	public void setTiposClasificacion(RecordSet newTiposClasificacion) {
		tiposClasificacion = newTiposClasificacion;
	}

	public RecordSet getTiposCurso() {
		return tiposCurso;
	}

	public void setTiposCurso(RecordSet newTiposCurso) {
		tiposCurso = newTiposCurso;
	}

	public RecordSet getZonas() {
		return zonas;
	}

	public void setZonas(RecordSet newZonas) {
		zonas = newZonas;
	}
}