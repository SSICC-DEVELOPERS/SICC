package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSProductoValidado extends DTOAuditableSICC  {
	private String codigoVenta;
	private Double precioCatalogo;

	public DTOSProductoValidado() {
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(String newCodigoVenta) {
		codigoVenta = newCodigoVenta;
	}

	public Double getPrecioCatalogo() {
		return precioCatalogo;
	}

	public void setPrecioCatalogo(Double newPrecioCatalogo) {
		precioCatalogo = newPrecioCatalogo;
	}
}