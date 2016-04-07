package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
public class DTOCriteriosCodigoConf extends DTOSiccPaginacion  {
	private Long marca;
	private Long canal;
	private Long sgv;
	private Long region;
	private Long zona;
	private String codConf;
	private Long nivelRiesgo;
	private Long grupoSolicitud;
	private Integer tipoValidacion1;
	private Integer tipoValidacion2;
	private Integer tipoValidacion3;
	private Integer tipoValidacion4;

	public DTOCriteriosCodigoConf() {
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getSgv() {
		return sgv;
	}

	public void setSgv(Long newSgv) {
		sgv = newSgv;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long newRegion) {
		region = newRegion;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long newZona) {
		zona = newZona;
	}

	public String getCodConf() {
		return codConf;
	}

	public void setCodConf(String newCodConf) {
		codConf = newCodConf;
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

	public Integer getTipoValidacion1() {
		return tipoValidacion1;
	}

	public void setTipoValidacion1(Integer newTipoValidacion1) {
		tipoValidacion1 = newTipoValidacion1;
	}

	public Integer getTipoValidacion2() {
		return tipoValidacion2;
	}

	public void setTipoValidacion2(Integer newTipoValidacion2) {
		tipoValidacion2 = newTipoValidacion2;
	}

	public Integer getTipoValidacion3() {
		return tipoValidacion3;
	}

	public void setTipoValidacion3(Integer newTipoValidacion3) {
		tipoValidacion3 = newTipoValidacion3;
	}

	public Integer getTipoValidacion4() {
		return tipoValidacion4;
	}

	public void setTipoValidacion4(Integer newTipoValidacion4) {
		tipoValidacion4 = newTipoValidacion4;
	}
}