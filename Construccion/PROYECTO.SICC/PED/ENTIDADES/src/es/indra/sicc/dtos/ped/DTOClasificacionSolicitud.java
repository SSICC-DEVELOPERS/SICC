package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
public class DTOClasificacionSolicitud extends DTOAuditableSICC {
	private Long oidTipoClasificacion;
	private Long oidZona;
	
	public DTOClasificacionSolicitud() {
	}

	public Long getOidTipoClasificacion() {
		return oidTipoClasificacion;
	}

	public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
		oidTipoClasificacion = newOidTipoClasificacion;
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}
}