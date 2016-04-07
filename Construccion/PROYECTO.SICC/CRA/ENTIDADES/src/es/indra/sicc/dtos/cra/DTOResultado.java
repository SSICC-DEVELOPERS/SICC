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

import java.util.Date;
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


public class DTOResultado extends DTOAuditableSICC {

	private Date fechaInicio;
	private Date fechaFin;
    //Definido por Gabriel Guardincerri
    private Collection zonasGrupos = new ArrayList();

    //Definido por Gabriel Guardincerri
    private Long pais;
    //Definido por Gabriel Guardincerri
    private Long marca;
    //Definido por Gabriel Guardincerri
    private Long canal;
    
	public DTOResultado() {
		super();
	}


	public DTOResultado(Date fechaInicio,
			Date fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio(){
		return this.fechaInicio;
	}

	public void setFechaInicio( Date fechaInicio){
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin(){
		return this.fechaFin;
	}

	public void setFechaFin( Date fechaFin){
		this.fechaFin = fechaFin;
	}

    public Collection getZonasGrupos() {
        //Definido por Gabriel Guardincerri
        return zonasGrupos;
    }

    public Collection getDTOZonasGrupos() {
        //Definido por Gabriel Guardincerri
        return zonasGrupos;
    }

    public void setDTOZonasGrupos(Collection DTOZonasGrupos) {
        //Definido por Gabriel Guardincerri
        zonasGrupos = DTOZonasGrupos;
    }
    public void addDTOZonasGrupo(DTOZonasGrupo act) {
        //Definido por Gabriel Guardincerri
        zonasGrupos.add(act);
    }

    public boolean removeDTOCZonasGrupo(DTOZonasGrupo act) {
        //Definido por Gabriel Guardincerri
        return zonasGrupos.remove(act);
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
}
