package es.indra.sicc.cmn.negocio.correo;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCorreoElectronico extends DTOAuditableSICC {
	private String direccion;
	private String mensaje;
	private String asunto;

	public DTOCorreoElectronico() {
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String newDireccion) {
		direccion = newDireccion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String newMensaje) {
		mensaje = newMensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String newAsunto) {
		asunto = newAsunto;
	}
}