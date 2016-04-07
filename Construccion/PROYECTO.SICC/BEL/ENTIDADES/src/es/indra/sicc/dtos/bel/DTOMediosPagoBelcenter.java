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
import java.util.ArrayList;
import es.indra.sicc.util.DTOBelcorp;
public class DTOMediosPagoBelcenter  extends DTOBelcorp{

	private Long oidSubacceso;   
	private Long oidCanal; 
	private Long oidAcceso;     
	private String descripcionSubacceso;
	private String descripcionAcceso;
	private String descripcionCanal;
	private ArrayList mediosPago;

	public String getDescripcionSubacceso() {
		return this.descripcionSubacceso;
	}

	public void setDescripcionSubacceso(String newDescripcionSubacceso) {
		this.descripcionSubacceso = newDescripcionSubacceso;
	}

	public String getDescripcionAcceso() {
		return this.descripcionAcceso;
	}

	public void setDescripcionAcceso(String newDescripcionAcceso) {
		this.descripcionAcceso = newDescripcionAcceso;
	}

	public String getDescripcionCanal() {
		return this.descripcionCanal;
	}

	public void setDescripcionCanal(String newDescripcionCanal) {
		this.descripcionCanal = newDescripcionCanal;
	}

	public ArrayList getMediosPago() {
		return this.mediosPago;
	}

	public void setMediosPago(ArrayList newMediosPago) {
		this.mediosPago = newMediosPago;
	}

	public Long getOidSubacceso() {
		return this.oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		this.oidSubacceso = newOidSubacceso;
	}

	public Long getOidAcceso() {
		return this.oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		this.oidAcceso = newOidAcceso;
	}
	
	public Long getOidCanal() {
		return this.oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		this.oidCanal = newOidCanal;
	}		

}