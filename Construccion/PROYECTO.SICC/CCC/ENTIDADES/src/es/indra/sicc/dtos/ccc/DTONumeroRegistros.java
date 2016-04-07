package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTONumeroRegistros extends DTOAuditableSICC {

	private Long numeroRegistros;
	
	public DTONumeroRegistros() {
	}

	public Long getNumeroRegistros() {
        return numeroRegistros;
    }

    public void setNumeroRegistros(Long newNumeroRegistros) {
        numeroRegistros = newNumeroRegistros;
    }
	
}