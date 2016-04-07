package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTORegistrosMAV extends DTOAuditableSICC  {
	private ArrayList agrupacionesEnvios;
	private ArrayList enviosProducto;
	private ArrayList detalleAgrupacion;

	public DTORegistrosMAV() {
	}

	public ArrayList getAgrupacionesEnvios() {
		return agrupacionesEnvios;
	}

	public void setAgrupacionesEnvios(ArrayList newAgrupacionesEnvios) {
		agrupacionesEnvios = newAgrupacionesEnvios;
	}

	public ArrayList getEnviosProducto() {
		return enviosProducto;
	}

	public void setEnviosProducto(ArrayList newEnviosProducto) {
		enviosProducto = newEnviosProducto;
	}

	public ArrayList getDetalleAgrupacion() {
		return detalleAgrupacion;
	}

	public void setDetalleAgrupacion(ArrayList newDetalleAgrupacion) {
		detalleAgrupacion = newDetalleAgrupacion;
	}
}