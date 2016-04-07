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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCargaCursos extends DTOBelcorp {

  private RecordSet cursos;
  private RecordSet marcas;
  private RecordSet canales;
  private RecordSet regalos;
  private RecordSet tiposCliente;
  private RecordSet frecuenciasCursos;
  private RecordSet parametros;
  private RecordSet statusClientes;
  private RecordSet momentoEntrega; //new

//sobra este parametro
//  private RecordSet clasificaciones; 

  private DTOPlantillaCurso plantilla;
  private DTOCurso curso;
  private DTODependientesCarga dependientes; //new


  public DTOCargaCursos() {
    super();
  }

  public RecordSet getCursos() {
    return this.cursos;
  }

  public void setCursos(RecordSet newCursos) {
    this.cursos = newCursos;
  }

  public RecordSet getMarcas() {
    return this.marcas;
  }

  public void setMarcas(RecordSet newMarcas) {
    this.marcas = newMarcas;
  }

  public RecordSet getCanales() {
    return this.canales;
  }

  public void setCanales(RecordSet newCanales) {
    this.canales = newCanales;
  }

  public RecordSet getRegalos() {
    return this.regalos;
  }

  public void setRegalos(RecordSet newRegalos) {
    this.regalos = newRegalos;
  }

  public RecordSet getTiposCliente() {
    return this.tiposCliente;
  }

  public void setTiposCliente(RecordSet newTiposCliente) {
    this.tiposCliente = newTiposCliente;
  }

  public RecordSet getFrecuenciasCursos() {
    return this.frecuenciasCursos;
  }

  public void setFrecuenciasCursos(RecordSet newFrecuenciasCursos) {
    this.frecuenciasCursos = newFrecuenciasCursos;
  }

  public RecordSet getParametros() {
    return this.parametros;
  }

  public void setParametros(RecordSet newParametros) {
    this.parametros = newParametros;
  }

  public RecordSet getStatusClientes() {
    return this.statusClientes;
  }

  public void setStatusClientes(RecordSet newStatusClientes) {
    this.statusClientes = newStatusClientes;
  }

  public RecordSet getMomentoEntrega() {
	return this.momentoEntrega;
  }

  public void setMomentoEntrega(RecordSet newMomentoEntrega) {
	this.momentoEntrega = newMomentoEntrega;
  }

  

/*
  public RecordSet getClasificaciones() {
    return this.clasificaciones;
  }

  public void setClasificaciones(RecordSet newClasificaciones) {
    this.clasificaciones = newClasificaciones;
  }
*/

  public DTOPlantillaCurso getPlantilla() {
    return this.plantilla;
  }

  public void setPlantilla(DTOPlantillaCurso newPlantilla) {
    this.plantilla = newPlantilla;
  }

  public DTOCurso getCurso() {
    return this.curso;
  }

  public void setCurso(DTOCurso newCurso) {
    this.curso = newCurso;
  }

  public DTODependientesCarga getDependientes() {
	  return this.dependientes;
  }

  public void setDependientes(DTODependientesCarga newDependientes) {
	  this.dependientes = newDependientes;
  }
}