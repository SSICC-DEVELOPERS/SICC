package es.indra.sicc.dtos.car;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBusquedaSolBloqueadas extends DTOSiccPaginacion  {
	private Long oidMarca;
	private Long oidCanal;
	private Long oidSubgerencia;
	private Long oidRegion;
	private Long oidZona;
	private Long oidNivelJerarquico;
	private Long oidNivelRiesgo;
	private Integer validacion1;
	private Long validacion2;
	private Long validacion3;
	private Long validacion4;
	private Long oidGrupoSolicitud;
	private Long estatusBloqueado;
	private Long estatusLiberado;
	private Long estatusReasignado;
	private Long estatusRechazado;
	private String ejecutivo;
	private Long oidPeriodo;
	private Double montoOrdenDesde;
	private Double montoOrdenHasta;
	private Double montoDeudaDesde;
	private Double montoDeudaHasta;

	public DTOBusquedaSolBloqueadas() {
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

	public Long getOidSubgerencia() {
		return oidSubgerencia;
	}

	public void setOidSubgerencia(Long newOidSubgerencia) {
		oidSubgerencia = newOidSubgerencia;
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

	public Long getOidNivelJerarquico() {
		return oidNivelJerarquico;
	}

	public void setOidNivelJerarquico(Long newOidNivelJerarquico) {
		oidNivelJerarquico = newOidNivelJerarquico;
	}

	public Long getOidNivelRiesgo() {
		return oidNivelRiesgo;
	}

	public void setOidNivelRiesgo(Long newOidNivelRiesgo) {
		oidNivelRiesgo = newOidNivelRiesgo;
	}

	public Integer getValidacion1() {
		return validacion1;
	}

	public void setValidacion1(Integer newValidacion1) {
		validacion1 = newValidacion1;
	}

	public Long getValidacion2() {
		return validacion2;
	}

	public void setValidacion2(Long newValidacion2) {
		validacion2 = newValidacion2;
	}

	public Long getValidacion3() {
		return validacion3;
	}

	public void setValidacion3(Long newValidacion3) {
		validacion3 = newValidacion3;
	}

	public Long getValidacion4() {
		return validacion4;
	}

	public void setValidacion4(Long newValidacion4) {
		validacion4 = newValidacion4;
	}

	public Long getOidGrupoSolicitud() {
		return oidGrupoSolicitud;
	}

	public void setOidGrupoSolicitud(Long newOidGrupoSolicitud) {
		oidGrupoSolicitud = newOidGrupoSolicitud;
	}

	public Long getEstatusBloqueado() {
		return estatusBloqueado;
	}

	public void setEstatusBloqueado(Long newEstatusBloqueado) {
		estatusBloqueado = newEstatusBloqueado;
	}

	public Long getEstatusLiberado() {
		return estatusLiberado;
	}

	public void setEstatusLiberado(Long newEstatusLiberado) {
		estatusLiberado = newEstatusLiberado;
	}

	public Long getEstatusReasignado() {
		return estatusReasignado;
	}

	public void setEstatusReasignado(Long newEstatusReasignado) {
		estatusReasignado = newEstatusReasignado;
	}

	public Long getEstatusRechazado() {
		return estatusRechazado;
	}

	public void setEstatusRechazado(Long newEstatusRechazado) {
		estatusRechazado = newEstatusRechazado;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String newEjecutivo) {
		ejecutivo = newEjecutivo;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Double getMontoOrdenDesde() {
		return montoOrdenDesde;
	}

	public void setMontoOrdenDesde(Double newMontoOrdenDesde) {
		montoOrdenDesde = newMontoOrdenDesde;
	}

	public Double getMontoOrdenHasta() {
		return montoOrdenHasta;
	}

	public void setMontoOrdenHasta(Double newMontoOrdenHasta) {
		montoOrdenHasta = newMontoOrdenHasta;
	}

	public Double getMontoDeudaDesde() {
		return montoDeudaDesde;
	}

	public void setMontoDeudaDesde(Double newMontoDeudaDesde) {
		montoDeudaDesde = newMontoDeudaDesde;
	}

	public Double getMontoDeudaHasta() {
		return montoDeudaHasta;
	}

	public void setMontoDeudaHasta(Double newMontoDeudaHasta) {
		montoDeudaHasta = newMontoDeudaHasta;
	}
}