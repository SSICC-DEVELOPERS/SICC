package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORegistro extends DTOAuditableSICC  {
	private String pais;
	private String codigoCliente;

	public DTORegistro() {
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String newPais) {
		pais = newPais;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}
}