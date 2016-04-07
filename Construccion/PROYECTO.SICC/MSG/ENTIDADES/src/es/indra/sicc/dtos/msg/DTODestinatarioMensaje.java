package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODestinatarioMensaje extends DTOAuditableSICC {

	private Long oidTipoDestinatario;
    private Long oidMensaje;

	public DTODestinatarioMensaje() {
	}

	public void setOidTipoDestinatario(Long newOidTipoDestinatario) {
        oidTipoDestinatario = newOidTipoDestinatario;
    }

    public Long getOidTipoDestinatario() {
        return oidTipoDestinatario;
    }

    public Long getOidMensaje()
    {
        return oidMensaje;
    }

    public void setOidMensaje(Long oidMensaje)
    {
        this.oidMensaje = oidMensaje;
    }
	
}