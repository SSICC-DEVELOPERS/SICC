package es.indra.sicc.dtos.mav;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSCargaPaginaInsertarActividades  extends DTOAuditableSICC{
	private RecordSet tipoSolicitudDestino;
	private RecordSet tipoPosicionEnvio;
	private RecordSet subtipoCliente;

	public DTOSCargaPaginaInsertarActividades() {
	}

	public RecordSet getTipoSolicitudDestino() {
		return tipoSolicitudDestino;
	}

	public void setTipoSolicitudDestino(RecordSet newTipoSolicitudDestino) {
		tipoSolicitudDestino = newTipoSolicitudDestino;
	}

	public RecordSet getSubtipoCliente() {
		return subtipoCliente;
	}

	public void setSubtipoCliente(RecordSet newSubtipoCliente) {
		subtipoCliente = newSubtipoCliente;
	}

	public RecordSet getTipoPosicionEnvio() {
		return tipoPosicionEnvio;
	}

	public void setTipoPosicionEnvio(RecordSet newTipoPosicionEnvio) {
		tipoPosicionEnvio = newTipoPosicionEnvio;
	}
}