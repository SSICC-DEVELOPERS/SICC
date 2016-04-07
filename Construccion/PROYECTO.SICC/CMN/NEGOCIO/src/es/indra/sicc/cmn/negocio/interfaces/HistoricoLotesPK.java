package es.indra.sicc.cmn.negocio.interfaces;

import java.io.Serializable;

public class HistoricoLotesPK implements Serializable {

	public String numeroLote;
	public String codigoInterfaz;
	public Long pais;

	public HistoricoLotesPK() {
	}

	public HistoricoLotesPK(Long pais, String codigoInterfaz, String numeroLote) {

		this.pais = pais;
		this.codigoInterfaz = codigoInterfaz;
		this.numeroLote = numeroLote;
	}

	public boolean equals(Object other) {
		if (other instanceof HistoricoLotesPK) {
			final HistoricoLotesPK otherHistoricoLotesPK = (HistoricoLotesPK)other;

			// The following assignment statement is auto-maintained and may be overwritten.
			boolean areEqual = (otherHistoricoLotesPK.pais.equals(pais) && 
								otherHistoricoLotesPK.codigoInterfaz.equals(codigoInterfaz) && 
								otherHistoricoLotesPK.numeroLote.equals(numeroLote) );

			return areEqual;
		}

		return false;
	}

	public int hashCode() {
		// Add custom hashCode() impl here
		return super.hashCode();
	}
}