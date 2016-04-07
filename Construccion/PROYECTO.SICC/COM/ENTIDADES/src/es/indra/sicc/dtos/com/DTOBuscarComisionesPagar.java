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
package es.indra.sicc.dtos.com;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarComisionesPagar extends DTOSiccPaginacion
{
	private String codComision;
	private String descripcion;
  private String fechaCalculo;
  private String formatoFecha;

	public DTOBuscarComisionesPagar() 
	{
	}

	public String getCodComision()
	{
		return codComision;
	}

	public void setCodComision(String codComision)
	{
		this.codComision = codComision;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getFechaCalculo()
	{
		return fechaCalculo;
	}

	public void setFechaCalculo(String fechaCalculo)
	{
		this.fechaCalculo = fechaCalculo;
	}

  public String getFormatoFecha() {
    return formatoFecha;
  }

  public void setFormatoFecha(String formatoFecha) {
    this.formatoFecha = formatoFecha;
  }
}