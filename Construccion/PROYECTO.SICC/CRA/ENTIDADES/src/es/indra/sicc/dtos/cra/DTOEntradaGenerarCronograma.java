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

public class DTOEntradaGenerarCronograma extends DTOBelcorp {

	private Long pais;
  private Long marca;
  private Long canal;
	private String numPeriodo;
	private Integer anno;

	public DTOEntradaGenerarCronograma() {
		super();
	}


	public DTOEntradaGenerarCronograma(Long pais,
			Long marca,
			Long canal,
			String numPeriodo,
			Integer anno) {
		super();
		this.pais = pais;
		this.marca = marca;
		this.canal = canal;
		this.numPeriodo = numPeriodo;
		this.anno = anno;
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

	public String getNumPeriodo(){
		return this.numPeriodo;
	}

	public void setNumPeriodo( String numPeriodo){
		this.numPeriodo = numPeriodo;
	}

	public Integer getAnno(){
		return this.anno;
	}

	public void setAnno( Integer anno){
		this.anno = anno;
	}

}
