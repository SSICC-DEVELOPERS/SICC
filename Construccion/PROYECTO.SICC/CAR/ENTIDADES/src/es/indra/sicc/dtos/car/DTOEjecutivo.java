package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
public class DTOEjecutivo  extends DTOSiccPaginacion{
	private Long oidEjecutivo;
	private Long IDPrincipal;
	private Long jerarquia;
	private RecordSet asignaciones;

	public DTOEjecutivo() {
	}

	public Long getOidEjecutivo() {
		return oidEjecutivo;
	}

	public void setOidEjecutivo(Long newOidEjecutivo) {
		oidEjecutivo = newOidEjecutivo;
	}

	public Long getIDPrincipal() {
		return IDPrincipal;
	}

	public void setIDPrincipal(Long newIDPrincipal) {
		IDPrincipal = newIDPrincipal;
	}

	public Long getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(Long newJerarquia) {
		jerarquia = newJerarquia;
	}

	public RecordSet getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(RecordSet newAsignaciones) {
		asignaciones = newAsignaciones;
	}
}