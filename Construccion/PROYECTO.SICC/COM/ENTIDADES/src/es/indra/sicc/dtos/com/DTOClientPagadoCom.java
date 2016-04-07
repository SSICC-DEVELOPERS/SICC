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

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOClientPagadoCom extends DTOBelcorp
{
	private Long oidCliente;
	private String codPlanilla;
	private BigDecimal impCalculado;

	public DTOClientPagadoCom()
	{
	}

	public Long getOidCliente()
	{
		return oidCliente;
	}

	public void setOidCliente(Long oidCliente)
	{
		this.oidCliente = oidCliente;
	}

	public String getCodPlanilla()
	{
		return codPlanilla;
	}

	public void setCodPlanilla(String codPlanilla)
	{
		this.codPlanilla = codPlanilla;
	}

	public BigDecimal getImpCalculado()
	{
		return impCalculado;
	}

	public void setImpCalculado(BigDecimal impCalculado)
	{
		this.impCalculado = impCalculado;
	}
}