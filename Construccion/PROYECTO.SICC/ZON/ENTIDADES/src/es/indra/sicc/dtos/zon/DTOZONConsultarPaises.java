package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOZONConsultarPaises extends DTOAuditableSICC  {
	private Vector paises;
	private Long idioma;

	public DTOZONConsultarPaises() {
	}

	public Vector getPaises() {
		return paises;
	}

	public void setPaises(Vector newPaises) {
		paises = newPaises;
	}

	public Long getIdioma() {
		return idioma;
	}

	public void setIdioma(Long newIdioma) {
		idioma = newIdioma;
	}



}