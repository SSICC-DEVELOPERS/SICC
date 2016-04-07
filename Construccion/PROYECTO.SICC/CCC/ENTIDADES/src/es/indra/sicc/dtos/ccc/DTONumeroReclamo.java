package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTONumeroReclamo  extends DTOBelcorp{
	Integer numeroIdentificacion;

	public DTONumeroReclamo() {
	}

	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer newNumeroIdentificacion) {
		numeroIdentificacion = newNumeroIdentificacion;
	}
}