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
public class DTOReportePedidos  extends DTOBelcorp{
	ArrayList lineasDetalle;

	public ArrayList getLineasDetalle() {
		return this.lineasDetalle;
	}

	public void setLineasDetalle(ArrayList newLineasDetalle) {
		this.lineasDetalle = newLineasDetalle;
	}
}