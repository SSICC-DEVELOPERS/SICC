package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
public class DTOAsignacionesEjecutivo extends DTOSiccPaginacion {
	private Long oidAsignacion;
	private Long oidEjecutivo;
	private Long oidSgv;
	private Long oidRegion;
	private Long oidZona;
	private Long oidNivelRiesgo;

	public DTOAsignacionesEjecutivo() {
	}

	public Long getOidAsignacion() {
		return oidAsignacion;
	}

	public void setOidAsignacion(Long newOidAsignacion) {
		oidAsignacion = newOidAsignacion;
	}

	public Long getOidEjecutivo() {
		return oidEjecutivo;
	}

	public void setOidEjecutivo(Long newOidEjecutivo) {
		oidEjecutivo = newOidEjecutivo;
	}

	public Long getOidSgv() {
		return oidSgv;
	}

	public void setOidSgv(Long newOidSgv) {
		oidSgv = newOidSgv;
	}

	public Long getOidRegion() {
		return oidRegion;
	}

	public void setOidRegion(Long newOidRegion) {
		oidRegion = newOidRegion;
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}

	public Long getOidNivelRiesgo() {
		return oidNivelRiesgo;
	}

	public void setOidNivelRiesgo(Long newOidNivelRiesgo) {
		oidNivelRiesgo = newOidNivelRiesgo;
	}
}