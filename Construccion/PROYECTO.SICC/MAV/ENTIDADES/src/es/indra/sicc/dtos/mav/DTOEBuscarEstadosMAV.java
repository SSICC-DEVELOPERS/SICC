package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarEstadosMAV extends DTOSiccPaginacion  {
	private Long oidEstadoMAV;
	private String descripcion;

	public DTOEBuscarEstadosMAV() {
	}

	public Long getOidEstadoMAV() {
		return oidEstadoMAV;
	}

	public void setOidEstadoMAV(Long newOidEstadoMAV) {
		oidEstadoMAV = newOidEstadoMAV;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}
}