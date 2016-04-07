package es.indra.sicc.dtos.ped;


import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
public class DTODatosMonitor extends DTOAuditableSICC {
	private RecordSet procesos;
	private Long totalGP1;
	private Long totalGP2;
	private Long totalGP3;
	private Long totalGP4;
	private Long totalGP5;
	
	public DTODatosMonitor() {
	}

	public RecordSet getProcesos() {
		return procesos;
	}

	public void setProcesos(RecordSet newProcesos) {
		procesos = newProcesos;
	}

	public Long getTotalGP1() {
		return totalGP1;
	}

	public void setTotalGP1(Long newTotalGP1) {
		totalGP1 = newTotalGP1;
	}

	public Long getTotalGP2() {
		return totalGP2;
	}

	public void setTotalGP2(Long newTotalGP2) {
		totalGP2 = newTotalGP2;
	}

	public Long getTotalGP3() {
		return totalGP3;
	}

	public void setTotalGP3(Long newTotalGP3) {
		totalGP3 = newTotalGP3;
	}

	public Long getTotalGP4() {
		return totalGP4;
	}

	public void setTotalGP4(Long newTotalGP4) {
		totalGP4 = newTotalGP4;
	}

	public Long getTotalGP5() {
		return totalGP5;
	}

	public void setTotalGP5(Long newTotalGP5) {
		totalGP5 = newTotalGP5;
	}
}