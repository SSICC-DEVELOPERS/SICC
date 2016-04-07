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
import java.sql.Timestamp;

public class DTOGMACabecera  extends DTOBelcorp{
	private Long oidMarca;                
	private Long oidTipoMovimientoAlmacen;
	private Long oidSubacceso;            
	private String acceso;                
	private String canal;                 
	private Long oidAlmacenOrigen;        
	private Long oidAlmacenDestino;       
	private String observaciones;         
	private String numeroDocumento;       
	private Timestamp fecha;

	public String getAcceso() {
		return this.acceso;
	}

	public void setAcceso(String newAcceso) {
		this.acceso = newAcceso;
	}

	public String getCanal() {
		return this.canal;
	}

	public void setCanal(String newCanal) {
		this.canal = newCanal;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String newNumeroDocumento) {
		this.numeroDocumento = newNumeroDocumento;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		this.observaciones = newObservaciones;
	}

	public Long getOidAlmacenDestino() {
		return this.oidAlmacenDestino;
	}

	public void setOidAlmacenDestino(Long newOidAlmacenDestino) {
		this.oidAlmacenDestino = newOidAlmacenDestino;
	}

	public Long getOidAlmacenOrigen() {
		return this.oidAlmacenOrigen;
	}

	public void setOidAlmacenOrigen(Long newOidAlmacenOrigen) {
		this.oidAlmacenOrigen = newOidAlmacenOrigen;
	}

	public Long getOidMarca() {
		return this.oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		this.oidMarca = newOidMarca;
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

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp newFecha) {
		this.fecha = newFecha;
	}

}