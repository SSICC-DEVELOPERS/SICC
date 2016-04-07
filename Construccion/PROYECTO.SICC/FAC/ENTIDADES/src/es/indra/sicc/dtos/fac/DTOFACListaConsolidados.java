/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.fac;

import es.indra.sicc.dtos.fac.DTOGenerarConsolidado;
import es.indra.sicc.util.DTOBelcorp;

import java.util.ArrayList;

public class DTOFACListaConsolidados extends DTOBelcorp {

	private ArrayList listaConsolidados;
	private DTOGenerarConsolidado dtoGenerarConsolidado;//a�adido por incidencia 8643

	public DTOFACListaConsolidados() {
				super();
	}

	public ArrayList getListaConsolidados() {
		return listaConsolidados;
	}

	public void setListaConsolidados(ArrayList newListaConsolidados) {
		listaConsolidados = newListaConsolidados;
	}

	public DTOGenerarConsolidado getDtoGenerarConsolidado() {
		return dtoGenerarConsolidado;
	}

	public void setDtoGenerarConsolidado(DTOGenerarConsolidado newDtoGenerarConsolidado) {
		dtoGenerarConsolidado = newDtoGenerarConsolidado;
	}
}