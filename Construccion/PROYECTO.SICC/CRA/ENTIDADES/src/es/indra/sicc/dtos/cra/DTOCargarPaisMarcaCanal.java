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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
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

public class DTOCargarPaisMarcaCanal extends DTOAuditableSICC {

	private RecordSet paises;
	private RecordSet marcas;
	private RecordSet canales;

	public DTOCargarPaisMarcaCanal() {
		super();
	}

	public DTOCargarPaisMarcaCanal(RecordSet paises,
    RecordSet marcas,
		RecordSet canales) {
		super();
		this.paises = paises;
		this.marcas = marcas;
		this.canales = canales;
	}

	public RecordSet getPaises(){
		return this.paises;
	}

	public void setPaises( RecordSet paises){
		this.paises = paises;
	}

	public RecordSet getMarcas(){
		return this.marcas;
	}

	public void setMarcas( RecordSet marcas){
		this.marcas = marcas;
	}

	public RecordSet getCanales(){
		return this.canales;
	}

	public void setCanales( RecordSet canales){
		this.canales = canales;
	}

}
