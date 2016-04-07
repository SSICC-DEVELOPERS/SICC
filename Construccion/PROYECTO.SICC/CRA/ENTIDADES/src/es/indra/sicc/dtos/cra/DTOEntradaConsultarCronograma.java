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

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             11/06/2003
 * Observaciones:     Importado de Version 2 y modificado segun requerimientos
 *                    generales de Version 3
 * @version           1.0
 * @autor             Gaston Acevedo
 */

public class DTOEntradaConsultarCronograma extends DTOAuditableSICC{

	private Long pais;
    private Long marca;
    private Long grupoZonas;
	private Long region;
	private Long seccion;
    private Long codigoperiodo;
    private Long canal;
	private Long subgerenciaVentas;
	private Long zona;
  private Boolean indFija;

	public DTOEntradaConsultarCronograma() {
		super();
	}


	public DTOEntradaConsultarCronograma(Long pais,
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
		this.codigoperiodo = codigoperiodo;
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
        return grupoZonas;
	}

	public void setGrupoZonas( Long newGrupoZonas){
        grupoZonas = newGrupoZonas;
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

	public Long getCodigoperiodo(){
        return codigoperiodo;
	}

	public void setCodigoperiodo( Long newCodigoperiodo){
        codigoperiodo = newCodigoperiodo;
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

	public void setZona(Long zona){
		this.zona = zona;
	}

  public Boolean getIndFija()
  {
    return indFija;
  }

  public void setIndFija(Boolean newIndFija)
  {
    indFija = newIndFija;
  }
}
