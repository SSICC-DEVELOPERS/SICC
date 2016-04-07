/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import java.util.ArrayList;
public class DTOAgrupacionStockCabecera extends DTOBelcorp  {
	private Long oidAgrupacionStockCabecera;
	private String codigoASC;
	private String descripcion;
	private ArrayList attTraducible;
	private Boolean indicadorDefecto;	

	public ArrayList getAttTraducible() {
		return attTraducible;
	}

	public void setAttTraducible(ArrayList newAttTraducible) {
		this.attTraducible = newAttTraducible;
	}

	public String getCodigoASC() {
		return this.codigoASC;
	}

	public void setCodigoASC(String newCodigoASC) {
		this.codigoASC = newCodigoASC;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		this.descripcion = newDescripcion;
	}

	public Boolean getIndicadorDefecto() {
		return this.indicadorDefecto;
	}

	public void setIndicadorDefecto(Boolean newIndicadorDefecto) {
		this.indicadorDefecto = newIndicadorDefecto;
	}

	public Long getOidAgrupacionStockCabecera() {
		return this.oidAgrupacionStockCabecera;
	}

	public void setOidAgrupacionStockCabecera(Long newOidAgrupacionStockCabecera) {
		this.oidAgrupacionStockCabecera = newOidAgrupacionStockCabecera;
	}
}