/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:           Belcorp
 * Modulo:            MEN 
 * Componente:        DTO's
 * @version           1.0
 */
 
public class DTOSFormato extends DTOAuditableSICC {
	private String seperadorMiles;
	private String separadorDecimal;
	private String formatoFecha;
	private String numeroDeDecimales;
	private String descripcion;
	private String numeroDeDecimalesAlternativa;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

	public DTOSFormato() {
		super();
	}

	public String getSeperadorMiles() {
		return seperadorMiles;
	}

	public void setSeperadorMiles(String newSeperadorMiles) {
		seperadorMiles = newSeperadorMiles;
	}

	public String getSeparadorDecimal() {
		return separadorDecimal;
	}

	public void setSeparadorDecimal(String newSeparadorDecimal) {
		separadorDecimal = newSeparadorDecimal;
	}

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public void setFormatoFecha(String newFormatoFecha) {
		formatoFecha = newFormatoFecha;
	}

	public String getNumeroDeDecimales() {
		return numeroDeDecimales;
	}

	public void setNumeroDeDecimales(String newNumeroDeDecimales) {
		numeroDeDecimales = newNumeroDeDecimales;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}

	public String getNumeroDeDecimalesAlternativa() {
		return numeroDeDecimalesAlternativa;
	}

	public void setNumeroDeDecimalesAlternativa(String newNumeroDeDecimalesAlternativa) {
		numeroDeDecimalesAlternativa = newNumeroDeDecimalesAlternativa;
	}
}