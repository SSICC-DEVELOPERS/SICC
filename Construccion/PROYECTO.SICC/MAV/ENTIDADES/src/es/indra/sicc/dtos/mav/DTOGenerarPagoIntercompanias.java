package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Timestamp;

public class DTOGenerarPagoIntercompanias extends DTOAuditableSICC {
	private Long marca;
	private Long canal;
	private Long actividad;
	private Timestamp fechaDesde;
	private Timestamp fechaHasta;

	public DTOGenerarPagoIntercompanias() {
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

	public Long getActividad() {
		return actividad;
	}

	public void setActividad(Long newActividad) {
		actividad = newActividad;
	}

	public Timestamp getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Timestamp newFechaDesde) {
		fechaDesde = newFechaDesde;
	}

	public Timestamp getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Timestamp newFechaHasta) {
		fechaHasta = newFechaHasta;
	}
}