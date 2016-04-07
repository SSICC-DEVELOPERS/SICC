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
import java.util.Date;

public class DTOINTDocumento extends DTOBelcorp
{
	private Long oidCabecera;
	private String codigoEmpresa;
	private String numeroPedido;
	private String codigoCliente;
	private Date fechaPedido;
	private String indicadorPedidoAChequear;
	private Integer totalItemsPedido;
	private Integer totalUnidadesPedido;
	private String indicadorPedidoExpress;
	private Date fechaCita;
	private String horaCita;
	private String claseSolicitud;
	private String tipoSolicitud;
	private String codigoItem;
	private String unidadesPorAtender;
	private String indicadorDentroFueraCaja;

	public DTOINTDocumento()
	{
	}

	public Long getOidCabecera()
	{
		return oidCabecera;
	}

	public void setOidCabecera(Long oidCabecera)
	{
		this.oidCabecera = oidCabecera;
	}

	public String getCodigoEmpresa()
	{
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa)
	{
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getNumeroPedido()
	{
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido)
	{
		this.numeroPedido = numeroPedido;
	}

	public String getCodigoCliente()
	{
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente)
	{
		this.codigoCliente = codigoCliente;
	}

	public Date getFechaPedido()
	{
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido)
	{
		this.fechaPedido = fechaPedido;
	}

	public String getIndicadorPedidoAChequear()
	{
		return indicadorPedidoAChequear;
	}

	public void setIndicadorPedidoAChequear(String indicadorPedidoAChequear)
	{
		this.indicadorPedidoAChequear = indicadorPedidoAChequear;
	}

	public Integer getTotalItemsPedido()
	{
		return totalItemsPedido;
	}

	public void setTotalItemsPedido(Integer totalItemsPedido)
	{
		this.totalItemsPedido = totalItemsPedido;
	}

	public Integer getTotalUnidadesPedido()
	{
		return totalUnidadesPedido;
	}

	public void setTotalUnidadesPedido(Integer totalUnidadesPedido)
	{
		this.totalUnidadesPedido = totalUnidadesPedido;
	}

	public String getIndicadorPedidoExpress()
	{
		return indicadorPedidoExpress;
	}

	public void setIndicadorPedidoExpress(String indicadorPedidoExpress)
	{
		this.indicadorPedidoExpress = indicadorPedidoExpress;
	}

	public Date getFechaCita()
	{
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita)
	{
		this.fechaCita = fechaCita;
	}

	public String getHoraCita()
	{
		return horaCita;
	}

	public void setHoraCita(String horaCita)
	{
		this.horaCita = horaCita;
	}

	public String getClaseSolicitud()
	{
		return claseSolicitud;
	}

	public void setClaseSolicitud(String claseSolicitud)
	{
		this.claseSolicitud = claseSolicitud;
	}

	public String getTipoSolicitud()
	{
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud)
	{
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getCodigoItem()
	{
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem)
	{
		this.codigoItem = codigoItem;
	}

	public String getUnidadesPorAtender()
	{
		return unidadesPorAtender;
	}

	public void setUnidadesPorAtender(String unidadesPorAtender)
	{
		this.unidadesPorAtender = unidadesPorAtender;
	}

	public String getIndicadorDentroFueraCaja()
	{
		return indicadorDentroFueraCaja;
	}

	public void setIndicadorDentroFueraCaja(String indicadorDentroFueraCaja)
	{
		this.indicadorDentroFueraCaja = indicadorDentroFueraCaja;
	}
}