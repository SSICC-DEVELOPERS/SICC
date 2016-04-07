package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
public class DTOCriteriosEjecutivo  extends DTOSiccPaginacion{
	private Long oidMarca;
	private Long oidCanal;
	private Long oidsgv;
	private Long oidRegion;
	private Long oidZona;
	private Long oidNivelRiesgo;
	private Long iDPrincipal;
	private Long oidJerarquia;

	public DTOCriteriosEjecutivo() {
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidsgv() {
		return oidsgv;
	}

	public void setOidsgv(Long newOidsgv) {
		oidsgv = newOidsgv;
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

	public Long getOidJerarquia() {
		return oidJerarquia;
	}

	public void setOidJerarquia(Long newOidJerarquia) {
		oidJerarquia = newOidJerarquia;
	}

    public Long getIDPrincipal() {
        return iDPrincipal;
    }

    public void setIDPrincipal(Long newIDPrincipal) {
        iDPrincipal = newIDPrincipal;
    }
}