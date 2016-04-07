package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOInformeGeneracion extends DTOAuditableSICC {
	private Long oidSolicitud;
	private Long numeroTotalUnidades;
	private BigDecimal numeroTotalMonto;
	private Long accesoSolicitud;
	private Long subaccesoSolicitud;
	private Long tipoSolicitud;
	private Long numeroCodigosVenta;

	public DTOInformeGeneracion() {
	}

	public Long getOidSolicitud() {
		return oidSolicitud;
	}

	public void setOidSolicitud(Long newOidSolicitud) {
		oidSolicitud = newOidSolicitud;
	}

	public Long getNumeroTotalUnidades() {
		return numeroTotalUnidades;
	}

	public void setNumeroTotalUnidades(Long newNumeroTotalUnidades) {
		numeroTotalUnidades = newNumeroTotalUnidades;
	}

	public BigDecimal getNumeroTotalMonto() {
		return numeroTotalMonto;
	}

	public void setNumeroTotalMonto(BigDecimal newNumeroTotalMonto) {
		numeroTotalMonto = newNumeroTotalMonto;
	}

	public Long getAccesoSolicitud() {
		return accesoSolicitud;
	}

	public void setAccesoSolicitud(Long newAccesoSolicitud) {
		accesoSolicitud = newAccesoSolicitud;
	}

	public Long getSubaccesoSolicitud() {
		return subaccesoSolicitud;
	}

	public void setSubaccesoSolicitud(Long newSubaccesoSolicitud) {
		subaccesoSolicitud = newSubaccesoSolicitud;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getNumeroCodigosVenta() {
		return numeroCodigosVenta;
	}

	public void setNumeroCodigosVenta(Long newNumeroCodigosVenta) {
		numeroCodigosVenta = newNumeroCodigosVenta;
	}
}