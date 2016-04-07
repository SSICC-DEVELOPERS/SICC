/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.bel;

import es.indra.sicc.util.DTOBelcorp;

public class DTOStock extends DTOBelcorp {
	private Long oidStock;
	private Long oidEstadoMercancia;
	private Long oidProducto;
	private Long oidAlmacen;
	private Long saldo;
  Boolean indicadorUpdate;

	public Long getOidAlmacen() {
		return oidAlmacen;
	}

	public void setOidAlmacen(Long newOidAlmacen) {
		oidAlmacen = newOidAlmacen;
	}

	public Long getOidEstadoMercancia() {
		return oidEstadoMercancia;
	}

	public void setOidEstadoMercancia(Long newOidEstadoMercancia) {
		oidEstadoMercancia = newOidEstadoMercancia;
	}

	public Long getOidProducto() {
		return oidProducto;
	}

	public void setOidProducto(Long newOidProducto) {
		oidProducto = newOidProducto;
	}

	public Long getOidStock() {
		return oidStock;
	}

	public void setOidStock(Long newOidStock) {
		oidStock = newOidStock;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long newSaldo) {
		saldo = newSaldo;
	}

  public Boolean getIndicadorUpdate() {
    return indicadorUpdate;
  }

  public void setIndicadorUpdate(Boolean indicadorUpdate) {
    this.indicadorUpdate = indicadorUpdate;
  }
}