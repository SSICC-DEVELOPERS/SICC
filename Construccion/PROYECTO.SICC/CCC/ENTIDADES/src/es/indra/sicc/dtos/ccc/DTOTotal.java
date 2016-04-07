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

package es.indra.sicc.dtos.ccc;

import java.math.BigDecimal;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTotal extends DTOBelcorp {

	private BigDecimal total;
    private String totalString;
	
	public DTOTotal() {
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal newTotal) {
		total = newTotal;
	}

    public String getTotalString()
    {
        return totalString;
    }

    public void setTotalString(String totalstring)
    {
        this.totalString = totalstring;
    }
}