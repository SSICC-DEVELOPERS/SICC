package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUsuarioJerarquia extends DTOAuditableSICC  {
	private Long oidJerarquia;
	private String usuario;
    private Long oidEjecutivo;

	public DTOUsuarioJerarquia() {
	}

	public Long getOidJerarquia() {
		return oidJerarquia;
	}

	public void setOidJerarquia(Long newOidJerarquia) {
		oidJerarquia = newOidJerarquia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String newUsuario) {
		usuario = newUsuario;
	}

    public Long getOidEjecutivo() {
        return oidEjecutivo;
    }

    public void setOidEjecutivo(Long newOidEjecutivo) {
        oidEjecutivo = newOidEjecutivo;
    }
}