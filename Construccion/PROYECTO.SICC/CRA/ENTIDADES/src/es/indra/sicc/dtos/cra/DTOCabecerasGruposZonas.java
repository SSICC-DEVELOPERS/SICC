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

import java.util.Collection;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             10/11/2003
 * Observaciones:     
 * @version           
 * @autor             Emilio Noziglia
 */

public class DTOCabecerasGruposZonas extends DTOAuditableSICC {

private java.lang.Long pais;
private java.lang.Long marca;
private java.lang.Long canal;
private Integer codigoGrupo;
private String nombreGrupo;
private Boolean status;
private Long tipoFacturacion;
private Integer nroDiasIntervalo;
private Integer acceso;
private Collection zonas;
private Long oidGrupo;
  private Vector attriTraducible;


	public DTOCabecerasGruposZonas() {
		super();
	}


	public DTOCabecerasGruposZonas(java.lang.Long pais, java.lang.Long marca, java.lang.Long canal, Integer codigoGrupo, String nombreGrupo, Boolean status, Long tipoFacturacion, Integer nroDiasIntervalo, Integer acceso) {
		super();
		this.pais = pais;
    this.marca = marca;
    this.canal = canal;
    this.codigoGrupo = codigoGrupo;
    this.nombreGrupo = nombreGrupo;
    this.status = status;
    this.tipoFacturacion = tipoFacturacion;
    this.nroDiasIntervalo = nroDiasIntervalo;
    this.acceso = acceso;
	}

	public java.lang.Long getPais(){
		return this.pais;
	}

	public void setPais(java.lang.Long pais){
		this.pais = pais;
	}
	public java.lang.Long getMarca(){
		return this.marca;
	}

	public void setMarca(java.lang.Long marca){
		this.marca = marca;
	}
  	public java.lang.Long getCanal(){
		return this.canal;
	}

	public void setCanal(java.lang.Long canal){
		this.canal = canal;
	}
  	public Integer getCodigoGrupo(){
		return this.codigoGrupo;
	}

	public void setCodigoGrupo(Integer codigoGrupo){
		this.codigoGrupo = codigoGrupo;
	}
  	public String getNombreGrupo(){
		return this.nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo){
		this.nombreGrupo = nombreGrupo;
	}
  	public Boolean getStatus(){
		return this.status;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}
  	public Long getTipoFacturacion(){
		return this.tipoFacturacion;
	}

	public void setTipoFacturacion(Long tipoFacturacion){
		this.tipoFacturacion = tipoFacturacion;
	}
  	public Integer getNroDiasIntervalo(){
		return this.nroDiasIntervalo;
	}

	public void setNroDiasIntervalo(Integer nroDiasIntervalo){
		this.nroDiasIntervalo = nroDiasIntervalo;
	}
  	public Integer getAcceso(){
		return this.acceso;
	}

	public void setAcceso(Integer acceso){
		this.acceso = acceso;
	}
    	public Collection getZonas(){
		return this.zonas;
	}

	public void setZonas(Collection zonas){
		this.zonas = zonas;
	}
  public Long getOidGrupo(){
		return this.oidGrupo;
	}

	public void setOidGrupo(Long oidGrupo){
		this.oidGrupo = oidGrupo;
	}

  public Vector getAttriTraducible() {
    return attriTraducible;
  }

  public void setAttriTraducible(Vector newAttriTraducible) {
    attriTraducible = newAttriTraducible;
  }
}