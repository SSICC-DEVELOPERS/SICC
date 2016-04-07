package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.ArrayList;
public class DTOAsignaciones  extends DTOSiccPaginacion{
	private ArrayList asignaciones;

	public DTOAsignaciones() {
	}

	public ArrayList getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(ArrayList newAsignaciones) {
		asignaciones = newAsignaciones;
	}
}