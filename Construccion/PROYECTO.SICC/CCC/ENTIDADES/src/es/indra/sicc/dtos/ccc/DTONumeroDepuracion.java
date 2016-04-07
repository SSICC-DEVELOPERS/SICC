package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTONumeroDepuracion extends DTOBelcorp {
	private Integer numeroDepuracion;

	public DTONumeroDepuracion() {
	}

	public Integer getNumeroDepuracion() {
		return numeroDepuracion;
	}

	public void setNumeroDepuracion(Integer newNumeroDepuracion) {
		numeroDepuracion = newNumeroDepuracion;
	}
}