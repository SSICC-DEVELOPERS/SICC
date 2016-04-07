package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

import java.util.ArrayList;

public class DTORespuestaCancelacion extends DTOBelcorp {

// Añandido por incidencia 10002

private ArrayList movCCSaldados;
private BigDecimal importeASaldar;

	public DTORespuestaCancelacion() {
	}

	public BigDecimal getImporteASaldar() {
		return importeASaldar;
	}

	public void setImporteASaldar(BigDecimal newImporteASaldar) {
		importeASaldar = newImporteASaldar;
	}

	public ArrayList getMovCCSaldados() {
		return movCCSaldados;
	}

	public void setMovCCSaldados(ArrayList newMovCCSaldados) {
		movCCSaldados = newMovCCSaldados;
	}
}