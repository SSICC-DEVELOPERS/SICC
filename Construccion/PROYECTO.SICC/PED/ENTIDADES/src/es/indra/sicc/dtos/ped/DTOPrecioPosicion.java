package es.indra.sicc.dtos.ped;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPrecioPosicion extends DTOAuditableSICC {

	private Long oidPosicion;
	private BigDecimal precioContable;
	private BigDecimal precioUnitario;
	private BigDecimal precioPosicion;
	private Boolean indVentaExclusivo;
	private Long oidOferta;
    private BigDecimal precioCatalogo;
	
	public DTOPrecioPosicion() {
	}

	public Boolean getIndVentaExclusivo() {
		return indVentaExclusivo;
	}

	public void setIndVentaExclusivo(Boolean newIndVentaExclusivo) {
		indVentaExclusivo = newIndVentaExclusivo;
	}

	public Long getOidOferta() {
		return oidOferta;
	}

	public void setOidOferta(Long newOidOferta) {
		oidOferta = newOidOferta;
	}

	public Long getOidPosicion() {
		return oidPosicion;
	}

	public void setOidPosicion(Long newOidPosicion) {
		oidPosicion = newOidPosicion;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal newPrecioUnitario) {
		precioUnitario = newPrecioUnitario;
	}

	public BigDecimal getPrecioContable() {
		return precioContable;
	}

	public void setPrecioContable(BigDecimal newPrecioContable) {
		precioContable = newPrecioContable;
	}

	public BigDecimal getPrecioPosicion() {
		return precioPosicion;
	}

	public void setPrecioPosicion(BigDecimal newPrecioPosicion) {
		precioPosicion = newPrecioPosicion;
	}

    public BigDecimal getPrecioCatalogo() {
        return precioCatalogo;
    }

	public void setPrecioCatalogo(BigDecimal newPrecioCatalogo) {
		precioCatalogo = newPrecioCatalogo;
	}
}