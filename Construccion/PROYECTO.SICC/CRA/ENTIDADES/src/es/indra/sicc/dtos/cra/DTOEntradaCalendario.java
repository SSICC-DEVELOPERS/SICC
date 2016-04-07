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
 * Fecha:             11/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 * @version           1.0
 * @autor             Diego Javier Grigna
 */

public class DTOEntradaCalendario extends DTOAuditableSICC {

	private Long pais;
	private Integer anno;
	private Vector festivos;
    private Long marca;
    private Long canal;
    private Integer codGrupoZona;
    private Long oidGrupoZona;

	public DTOEntradaCalendario() {
		super();
	}


	public DTOEntradaCalendario(Long pais,
			Integer anno,
			Vector festivos,
			Long marca,
			Long canal,
			Integer grupoZona) {
		super();
		this.pais = pais;
		this.anno = anno;
		this.festivos = festivos;
		this.marca = marca;
		this.canal = canal;
		this.codGrupoZona = grupoZona;
	}

	public Long getPais(){
		return this.pais;
	}

	public void setPais( Long pais){
		this.pais = pais;
	}

	public Integer getAnno(){
		return this.anno;
	}

	public void setAnno( Integer anno){
		this.anno = anno;
	}

	public Vector getFestivos(){
		return this.festivos;
	}

	public void setFestivos( Vector festivos){
		this.festivos = festivos;
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

	public Integer getCodGrupoZona(){
        return codGrupoZona;
	}

	public void setCodGrupoZona( Integer newGrupoZona){
        codGrupoZona = newGrupoZona;
	}
	public Long getOidGrupoZona(){
        return oidGrupoZona;
	}

	public void setOidGrupoZona( Long oidGrupoZona){
        oidGrupoZona = oidGrupoZona;
	}
}

