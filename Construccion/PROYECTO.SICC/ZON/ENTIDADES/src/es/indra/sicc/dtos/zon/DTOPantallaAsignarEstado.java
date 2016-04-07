package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPantallaAsignarEstado extends DTOAuditableSICC  {
	private RecordSet Zonas;
	private RecordSet EstadosZona;

	public DTOPantallaAsignarEstado() {
	}

	public RecordSet getZonas() {
		return Zonas;
	}

	public void setZonas(RecordSet newZonas) {
		Zonas = newZonas;
	}

	public RecordSet getEstadosZona() {
		return EstadosZona;
	}

	public void setEstadosZona(RecordSet newEstadosZona) {
		EstadosZona = newEstadosZona;
	}
}