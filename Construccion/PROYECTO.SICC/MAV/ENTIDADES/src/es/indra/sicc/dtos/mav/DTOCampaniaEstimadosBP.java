package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCampaniaEstimadosBP extends DTOAuditableSICC {
	private Long pais;
	private Long marca;
	private Long canal;
	private Long periodo;
	private Long actividad;
	private Long tipoCliente;

	public DTOCampaniaEstimadosBP() {
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
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

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public Long getActividad() {
		return actividad;
	}

	public void setActividad(Long newActividad) {
		actividad = newActividad;
	}

	public Long getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente) {
		tipoCliente = newTipoCliente;
	}
}