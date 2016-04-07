package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Timestamp;

public class DTOAgrupacionEnvios extends DTOAuditableSICC  {
	private Long oidTipoCliente;
	private String codigoCliente;
	private Long oidTipoDespacho;
	private Timestamp fechaEntrega;

	public DTOAgrupacionEnvios() {
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public Long getOidTipoDespacho() {
		return oidTipoDespacho;
	}

	public void setOidTipoDespacho(Long newOidTipoDespacho) {
		oidTipoDespacho = newOidTipoDespacho;
	}

	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Timestamp newFechaEntrega) {
		fechaEntrega = newFechaEntrega;
	}
}