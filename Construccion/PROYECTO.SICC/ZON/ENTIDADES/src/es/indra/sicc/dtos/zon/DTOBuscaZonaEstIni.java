package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscaZonaEstIni extends DTOSiccPaginacion  {
	private Long oidMarca;
	private Long oidCanal;
	private Long oidRegion;
	private Long oidZona;

	public DTOBuscaZonaEstIni() {
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
}