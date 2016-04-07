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
public class DTOGMA  extends DTOBelcorp{

 DTOGMACabecera cabecera;
 ArrayList detalle;

	public DTOGMACabecera getCabecera() {
		return this.cabecera;
	}

	public void setCabecera(DTOGMACabecera newCabecera) {
		this.cabecera = newCabecera;
	}

	public ArrayList getDetalle() {
		return this.detalle;
	}

	public void setDetalle(ArrayList newDetalle) {
		this.detalle = newDetalle;
	}

}