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
 * Fecha:             11/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 * @version           1.0
 * @autor             Diego Javier Grigna
 */

public class DTOEntradaConsultarGruposZonas extends DTOAuditableSICC {

  private Long pais;
  private Long marca;
  private Long canal;
	private Integer codigoGrupo;
	private String nombreGrupo;
  private String tipoFacturacion;
	private String gupoZonas;
	private String region;
	private String zonas;

	public DTOEntradaConsultarGruposZonas() {
		super();
	}

	public DTOEntradaConsultarGruposZonas(Long pais,
    Long marca,
    Long canal,
    Integer codigoGrupo,
    String nombreGrupo,
    String tipoFacturacion,
    String gupoZonas,
    String region,
    String zonas) {
		super();
		this.pais = pais;
		this.marca = marca;
		this.canal = canal;
		this.codigoGrupo = codigoGrupo;
		this.nombreGrupo = nombreGrupo;
		this.tipoFacturacion = tipoFacturacion;
		this.gupoZonas = gupoZonas;
		this.region = region;
		this.zonas = zonas;
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

	public Integer getCodigoGrupo(){
		return this.codigoGrupo;
	}

	public void setCodigoGrupo( Integer codigoGrupo){
		this.codigoGrupo = codigoGrupo;
	}

	public String getNombreGrupo(){
		return this.nombreGrupo;
	}

	public void setNombreGrupo( String nombreGrupo){
		this.nombreGrupo = nombreGrupo;
	}

	public String getTipoFacturacion(){
        return tipoFacturacion;
	}

	public void setTipoFacturacion( String newTipoFacturacion){
        tipoFacturacion = newTipoFacturacion;
	}

	public String getGupoZonas(){
		return this.gupoZonas;
	}

	public void setGupoZonas( String gupoZonas){
		this.gupoZonas = gupoZonas;
	}

	public String getRegion(){
		return this.region;
	}

	public void setRegion( String region){
		this.region = region;
	}

	public String getZonas(){
		return this.zonas;
	}

	public void setZonas( String zonas){
		this.zonas = zonas;
	}

}
