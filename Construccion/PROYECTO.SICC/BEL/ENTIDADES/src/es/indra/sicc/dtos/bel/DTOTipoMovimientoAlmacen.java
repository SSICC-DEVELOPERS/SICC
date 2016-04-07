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

public class DTOTipoMovimientoAlmacen extends DTOBelcorp  {
	private Long oid;
	private String codigoMovimiento;
	private String descripcion;
	private ArrayList attTraducible;
	private Boolean movimientoEntreAlmacenes;
	private Boolean mantieneMovimientos;
	private String codigoMovimientoSAP;
	private Boolean indicadorSAP;
	private Character operacion1;
	private Character operacion2;
	private Long oidEstadoMercancia1;
	private String descripcionEstado1;
	private Long oidEstadoMercancia2;
	private String descripconEstado2;

	public ArrayList getAttTraducible() {
		return this.attTraducible;
	}

	public void setAttTraducible(ArrayList newAttTraducible) {
		this.attTraducible = newAttTraducible;
	}

	public String getCodigoMovimiento() {
		return this.codigoMovimiento;
	}

	public void setCodigoMovimiento(String newCodigoMovimiento) {
		this.codigoMovimiento = newCodigoMovimiento;
	}

	public String getCodigoMovimientoSAP() {
		return this.codigoMovimientoSAP;
	}

	public void setCodigoMovimientoSAP(String newCodigoMovimientoSAP) {
		this.codigoMovimientoSAP = newCodigoMovimientoSAP;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		this.descripcion = newDescripcion;
	}

	public String getDescripcionEstado1() {
		return this.descripcionEstado1;
	}

	public void setDescripcionEstado1(String newDescripcionEstado1) {
		this.descripcionEstado1 = newDescripcionEstado1;
	}

	public String getDescripconEstado2() {
		return this.descripconEstado2;
	}

	public void setDescripconEstado2(String newDescripconEstado2) {
		this.descripconEstado2 = newDescripconEstado2;
	}

	public Boolean getIndicadorSAP() {
		return this.indicadorSAP;
	}

	public void setIndicadorSAP(Boolean newIndicadorSAP) {
		this.indicadorSAP = newIndicadorSAP;
	}

	public Boolean getMantieneMovimientos() {
		return this.mantieneMovimientos;
	}

	public void setMantieneMovimientos(Boolean newMantieneMovimientos) {
		mantieneMovimientos = newMantieneMovimientos;
	}

	public Boolean getMovimientoEntreAlmacenes() {
		return this.movimientoEntreAlmacenes;
	}

	public void setMovimientoEntreAlmacenes(Boolean newMovimientoEntreAlmacenes) {
		this.movimientoEntreAlmacenes = newMovimientoEntreAlmacenes;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setOid(Long newOid) {
		this.oid = newOid;
	}

	public Long getOidEstadoMercancia1() {
		return this.oidEstadoMercancia1;
	}

	public void setOidEstadoMercancia1(Long newOidEstadoMercancia1) {
		this.oidEstadoMercancia1 = newOidEstadoMercancia1;
	}

	public Long getOidEstadoMercancia2() {
		return this.oidEstadoMercancia2;
	}

	public void setOidEstadoMercancia2(Long newOidEstadoMercancia2) {
		this.oidEstadoMercancia2 = newOidEstadoMercancia2;
	}

	public Character getOperacion1() {
		return this.operacion1;
	}

	public void setOperacion1(Character newOperacion1) {
		this.operacion1 = newOperacion1;
	}

	public Character getOperacion2() {
		return this.operacion2;
	}

	public void setOperacion2(Character newOperacion2) {
		this.operacion2 = newOperacion2;
	}
	
}