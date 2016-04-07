package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOProcesoDetalleMAV extends DTOAuditableSICC  {
	private Long numeroClientes;
	private Long numeroUnidadesEnviadas;

	public DTOProcesoDetalleMAV() {
	}

	public Long getNumeroClientes() {
		return numeroClientes;
	}

	public void setNumeroClientes(Long newNumeroClientes) {
		numeroClientes = newNumeroClientes;
	}

	public Long getNumeroUnidadesEnviadas() {
		return numeroUnidadesEnviadas;
	}

	public void setNumeroUnidadesEnviadas(Long newNumeroUnidadesEnviadas) {
		numeroUnidadesEnviadas = newNumeroUnidadesEnviadas;
	}
}