/**
 * Copyright 2002 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.bel;
import java.util.ArrayList;
import es.indra.sicc.util.DTOBelcorp;
public class DTOEDetalleFormaPago  extends DTOBelcorp{
	private Long   oidFormaPagoCabecera;
	private ArrayList listaRegistrosDetalle;

	public ArrayList getListaRegistrosDetalle() {
		return this.listaRegistrosDetalle;
	}

	public void setListaRegistrosDetalle(ArrayList newListaRegistrosDetalle) {
		this.listaRegistrosDetalle = newListaRegistrosDetalle;
	}

	public Long getOidFormaPagoCabecera() {
		return this.oidFormaPagoCabecera;
	}

	public void setOidFormaPagoCabecera(Long newOidFormaPagoCabecera) {
		this.oidFormaPagoCabecera = newOidFormaPagoCabecera;
	}
}