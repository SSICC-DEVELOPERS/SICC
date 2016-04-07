package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTONumerosLineaVistaLotes extends DTOAuditableSICC  {
	public DTONumerosLineaVistaLotes() {
	}

	private Long numeroLinea;

	public Long getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Long newNumeroLinea) {
        numeroLinea = newNumeroLinea;
    }
	
}