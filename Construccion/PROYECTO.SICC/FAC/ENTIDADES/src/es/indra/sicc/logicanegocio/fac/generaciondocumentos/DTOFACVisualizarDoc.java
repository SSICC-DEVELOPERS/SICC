package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.DTOBelcorp;


public class DTOFACVisualizarDoc extends DTOBelcorp

 {
	private Long oidDocumento;

	public DTOFACVisualizarDoc() {
	}

	public Long getOidDocumento() {
		return oidDocumento;
	}

	public void setOidDocumento(Long newOidDocumento) {
		oidDocumento = newOidDocumento;
	}

}