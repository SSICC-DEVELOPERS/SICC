package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEliminarCodigoConf extends DTOAuditableSICC  {
  private Long[] asignaciones;
	private Long[] codigos;

  public DTOEliminarCodigoConf() {
  }

  public Long[] getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(Long[] newAsignaciones) {
		asignaciones = newAsignaciones;
	}

	public Long[] getCodigos() {
		return codigos;
	}

	public void setCodigos(Long[] newCodigos) {
		codigos = newCodigos;
	}
}