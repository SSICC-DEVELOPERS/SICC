package es.indra.sicc.dtos.mav;
import es.indra.sicc.util.DTOOID;

public class DTOLineaCombo extends DTOOID {
	private String descripcion;

	public DTOLineaCombo() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}
}