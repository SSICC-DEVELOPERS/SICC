package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEstadoZona extends DTOAuditableSICC  {
	private Long oidZona;
	private Long EstadoZona;

	public DTOEstadoZona() {
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}

	public Long getEstadoZona() {
		return EstadoZona;
	}

	public void setEstadoZona(Long newEstadoZona) {
		EstadoZona = newEstadoZona;
	}
}