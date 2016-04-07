package es.indra.sicc.dtos.ped;


import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEstatusSolicitud extends DTOAuditableSICC {

  private Long estatus;
	private Long oidProceso;
	private MareDTO resultado;
	
	public DTOEstatusSolicitud() {
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long newEstatus) {
		estatus = newEstatus;
	}

	public Long getOidProceso() {
		return oidProceso;
	}

	public void setOidProceso(Long newOidProceso) {
		oidProceso = newOidProceso;
	}

	public MareDTO getResultado() {
		return resultado;
	}

	public void setResultado(MareDTO newResultado) {
		resultado = newResultado;
	}
}