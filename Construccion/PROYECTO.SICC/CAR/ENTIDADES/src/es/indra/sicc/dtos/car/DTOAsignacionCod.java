package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;
public class DTOAsignacionCod extends DTOSiccPaginacion {
	private Long oidCodConf;
	private Long oidAsignacion;
	private Long nivelRiesgo;
	private Long grupoSolicitud;
	private Long oidSgv;
	private Long oidRegion;
	private Long oidZona;
	private BigDecimal LCIni;
	private Long NRIni;

	public DTOAsignacionCod() {
	}

	public Long getOidCodConf() {
		return oidCodConf;
	}

	public void setOidCodConf(Long newOidCodConf) {
		oidCodConf = newOidCodConf;
	}

	public Long getOidAsignacion() {
		return oidAsignacion;
	}

	public void setOidAsignacion(Long newOidAsignacion) {
		oidAsignacion = newOidAsignacion;
	}

	public Long getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(Long newNivelRiesgo) {
		nivelRiesgo = newNivelRiesgo;
	}

	public Long getGrupoSolicitud() {
		return grupoSolicitud;
	}

	public void setGrupoSolicitud(Long newGrupoSolicitud) {
		grupoSolicitud = newGrupoSolicitud;
	}

	public Long getOidSgv() {
		return oidSgv;
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

	public BigDecimal getLCIni() {
		return LCIni;
	}

	public void setLCIni(BigDecimal newLCIni) {
		LCIni = newLCIni;
	}

	public Long getNRIni() {
		return NRIni;
	}

	public void setNRIni(Long newNRIni) {
		NRIni = newNRIni;
	}

    public void setOidSgv(Long newOidSgv) {
		oidSgv = newOidSgv;
	}
}