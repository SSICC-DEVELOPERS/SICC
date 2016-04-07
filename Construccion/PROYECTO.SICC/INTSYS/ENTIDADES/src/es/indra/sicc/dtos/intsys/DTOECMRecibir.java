/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOECMRecibir extends DTOBelcorp
{
	private String numLote;
	private String descripcion;
	private String observaciones;

	public DTOECMRecibir()
	{
	}

	public String getNumLote()
	{
		return numLote;
	}

	public void setNumLote(String numLote)
	{
		this.numLote = numLote;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getObservaciones()
	{
		return observaciones;
	}

	public void setObservaciones(String observaciones)
	{
		this.observaciones = observaciones;
	}
}