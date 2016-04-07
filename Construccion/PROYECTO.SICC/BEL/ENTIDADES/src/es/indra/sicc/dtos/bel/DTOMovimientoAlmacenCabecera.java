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
import java.util.Date;
public class DTOMovimientoAlmacenCabecera extends DTOBelcorp  {
	private String numeroMovimiento;           
	private String numeroDocumento;            
	private Long oidTipoMovimientoAlmacen;     
	private Date fecha;                        
	private Long oidAlmacenSalida;             
	private Long oidAlmacenEntrada;            
	private Long oidMarca;                     
	private Long oidCanal;                     
	private Long oidAcceso;                    
	private Long oidSubacceso;                 
	private Long oidPeriodo;                   
	private String observaciones;              
	private Boolean indicadorNoGenerarCabecera;
	private Long oid; //BELC300006139 

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date newFecha) {
		this.fecha = newFecha;
	}

	public Boolean getIndicadorNoGenerarCabecera() {
		return this.indicadorNoGenerarCabecera;
	}

	public void setIndicadorNoGenerarCabecera(Boolean newIndicadorNoGenerarCabecera) {
		this.indicadorNoGenerarCabecera = newIndicadorNoGenerarCabecera;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String newNumeroDocumento) {
		this.numeroDocumento = newNumeroDocumento;
	}

	public String getNumeroMovimiento() {
		return this.numeroMovimiento;
	}

	public void setNumeroMovimiento(String newNumeroMovimiento) {
		this.numeroMovimiento = newNumeroMovimiento;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public Long getOidAcceso() {
		return this.oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		this.oidAcceso = newOidAcceso;
	}

	public Long getOidAlmacenEntrada() {
		return this.oidAlmacenEntrada;
	}

	public void setOidAlmacenEntrada(Long newOidAlmacenEntrada) {
		this.oidAlmacenEntrada = newOidAlmacenEntrada;
	}

	public Long getOidAlmacenSalida() {
		return this.oidAlmacenSalida;
	}

	public void setOidAlmacenSalida(Long newOidAlmacenSalida) {
		this.oidAlmacenSalida = newOidAlmacenSalida;
	}

	public Long getOidCanal() {
		return this.oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		this.oidCanal = newOidCanal;
	}

	public Long getOidMarca() {
		return this.oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		this.oidMarca = newOidMarca;
	}

	public Long getOidPeriodo() {
		return this.oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		this.oidPeriodo = newOidPeriodo;
	}

	public Long getOidSubacceso() {
		return this.oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		this.oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoMovimientoAlmacen() {
		return this.oidTipoMovimientoAlmacen;
	}

	public void setOidTipoMovimientoAlmacen(Long newOidTipoMovimientoAlmacen) {
		this.oidTipoMovimientoAlmacen = newOidTipoMovimientoAlmacen;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

}