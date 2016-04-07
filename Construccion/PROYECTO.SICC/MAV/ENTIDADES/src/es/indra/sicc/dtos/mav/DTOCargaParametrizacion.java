package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCargaParametrizacion extends DTOAuditableSICC  {
	private RecordSet parametrizacionMAV;
	private RecordSet parametrizacionGZona;
	private RecordSet parametrizacionGRegion;

	public DTOCargaParametrizacion() {
	}

	public RecordSet getParametrizacionMAV() {
		return parametrizacionMAV;
	}

	public void setParametrizacionMAV(RecordSet newParametrizacionMAV) {
		parametrizacionMAV = newParametrizacionMAV;
	}

	public RecordSet getParametrizacionGZona() {
		return parametrizacionGZona;
	}

	public void setParametrizacionGZona(RecordSet newParametrizacionGZona) {
		parametrizacionGZona = newParametrizacionGZona;
	}

	public RecordSet getParametrizacionGRegion() {
		return parametrizacionGRegion;
	}

	public void setParametrizacionGRegion(RecordSet newParametrizacionGRegion) {
		parametrizacionGRegion = newParametrizacionGRegion;
	}
}